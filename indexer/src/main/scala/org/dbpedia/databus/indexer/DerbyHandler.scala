/*-
 * #%L
 * Indexing the Databus
 * %%
 * Copyright (C) 2018 - 2020 Sebastian Hellmann (on behalf of the DBpedia Association)
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 * #L%
 */
package org.dbpedia.databus.indexer

import java.sql.{DriverManager, ResultSet, SQLException}

import org.apache.derby.shared.common.error.DerbySQLIntegrityConstraintViolationException

object DerbyFactory {

  def init(filename: String): DerbyHandler = {
    val dbh = new DerbyHandler(s"""jdbc:derby:${filename}""")
    dbh.init()
    dbh
  }
}

class DerbyHandler(val databaseURL: String) {


  def shutdown = {
    try {
      DriverManager.getConnection(databaseURL + ";shutdown=true")
    } catch {
      case e: SQLException =>
        if (e.getErrorCode == 45000) {
          println("derby shutdown")
        } else {
          println(e.getErrorCode)
          e.printStackTrace()
        }
    }
  }


  def init(): Boolean = {

    Class.forName("org.apache.derby.jdbc.EmbeddedDriver")
    val conn = DriverManager.getConnection(databaseURL + ";create=true")
    val statement = conn.createStatement
    try {
      val sql: String =
        """CREATE TABLE item (
          |shasum varchar(128) primary key,
          |status varchar(20),
          |downloadURL varchar(2000),
          |dataset varchar(2000),
          |version varchar(2000),
          |file varchar(2000),
          |distribution varchar(2000)
          |)""".stripMargin
      statement.execute(sql)
    } catch {
      case e: SQLException => println("IGNORE: " + e.getMessage)
    }
    val ret = statement.execute("CREATE INDEX status on item (status)")
    conn.close()
    ret

  }

  /**
   *
   * @return true if created, false if exists
   */
  def addIfNotExists(shaSum: String,
                     downloadURL: String,
                     dataset: String,
                     version: String,
                     file:String,
                     distribution: String): Boolean = {
    val conn = DriverManager.getConnection(databaseURL + ";create=true")
    val statement = conn.createStatement
    val sql =
      s"""
         |INSERT INTO item VALUES
         |('${shaSum}','open','${downloadURL}','${dataset}','${version}','${file}','${distribution}')
         |""".stripMargin
    try {
      statement.execute(sql)
      true
    } catch {
      case e: DerbySQLIntegrityConstraintViolationException =>
        //case e: DerbySQLIntegrityConstraintViolationException => println("IGNORE: " + e.getMessage) //TODO do nothing

        if (e.getErrorCode != 30000) {
          e.printStackTrace()
        }
        false
    } finally {
      conn.close()
    }

  }

  def setStatusProcessed(shasum: String) = {
    val conn = DriverManager.getConnection(databaseURL + ";create=true")
    val statement = conn.createStatement
    val sql =
      s"""
         |UPDATE item SET status = 'processed'
         |WHERE shasum = '${shasum}'
         |""".stripMargin
    try {
      statement.executeUpdate(sql)
    } catch {
      case e: Exception => e.printStackTrace()
    }
    conn.close()
  }


  /**
   * retrieves all with status open
   *
   * @return ResultSet for iterating into threads
   */
  def getNewResultSet: ItemSet = {

    val conn = DriverManager.getConnection(databaseURL + ";create=true")
    val statement = conn.createStatement
    val query = "SELECT * FROM item WHERE status = 'open'"
    val rs: ResultSet = statement.executeQuery(query)
    new ItemSet(rs)
  }

}
