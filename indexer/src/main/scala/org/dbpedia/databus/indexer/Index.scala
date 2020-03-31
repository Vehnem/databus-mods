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

import java.io.FileOutputStream

import scala.collection.parallel.mutable.ParHashSet
import java.net.URL

/**
 *
 */
object Index {


  def main(args: Array[String]): Unit = {
    println(DerbyHandler.databaseURL)
    updateIndex("dbpedia/mappings/%")
  }

  /**
   * takes a pattern in the form of "dbpedia/mappings/%" as used in LIKE
   *
   * @param pattern
   */
  def updateIndex(pattern: String) {


    val sparql =
      s"""
         |PREFIX dataid: <http://dataid.dbpedia.org/ns/core#>
         |PREFIX dct:    <http://purl.org/dc/terms/>
         |PREFIX dcat:   <http://www.w3.org/ns/dcat#>
         |PREFIX db:     <https://databus.dbpedia.org/>
         |PREFIX rdf:    <http://www.w3.org/1999/02/22-rdf-syntax-ns#>
         |PREFIX rdfs:   <http://www.w3.org/2000/01/rdf-schema#>
         |
         |SELECT ?dataset ?version ?distribution ?downloadURL ?shaSum WHERE
         |{
         |  ?dataset dataid:version ?version .
         |  FILTER (?version LIKE <https://databus.dbpedia.org/${pattern}> ).
         |  ?dataset dcat:distribution ?distribution .
         |  ?distribution  dcat:downloadURL ?downloadURL .
         |  ?distribution  dataid:sha256sum ?shaSum .
         |}
         |""".stripMargin

    //TODO SPARQL all with limit and offset

    DerbyHandler.addIfNotExists("sshatest", "http://example.org", "http://example.org", "http://example.org", "http://example.org")





  }

}
