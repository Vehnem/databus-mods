package org.dbpedia.databus.dataid

case class SingleFile
(
  publisher: String,
  group: String,
  artifact: String,
  version: String,
  file: String,
  var downloadURL: String,
  var issued: String,
  var sha256sum: String
) {
  lazy val path = s"$publisher/$group/$artifact/$version/$file"
  lazy val uri = s"https://databus.dbpedia.org/$path"
}

object SingleFile {

  def apply(
             publisher: String,
             group: String,
             artifact: String,
             version: String,
             file: String): SingleFile = {
    new SingleFile(publisher, group, artifact, version, file, null, null, null)
  }
}