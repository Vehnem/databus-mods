package org.dbpedia.databus.mods.model

import scala.collection.JavaConverters.mapAsJavaMapConverter

object Vocab {

  val prefixMap : java.util.Map[String,String] =
    Map(
      "prov" -> PROV.__base__
    ).asJava

  object PROV {
    val __base__ : String = "http://www.w3.org/ns/prov#"

    val generated : String = __base__ + "generated"

    val used : String = __base__ + "used"
  }

}
