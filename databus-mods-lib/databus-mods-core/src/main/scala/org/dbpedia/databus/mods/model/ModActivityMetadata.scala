package org.dbpedia.databus.mods.model

import java.util.Calendar

import org.apache.jena.rdf.model.{Model, ModelFactory, ResourceFactory}
import org.dbpedia.databus.dataid.SingleFile

import scala.beans.BeanProperty
import scala.collection.mutable.ArrayBuffer

class ModActivityMetadata(val dbusSF: SingleFile) {

  var state: Int = 0

  @BeanProperty
  var startTime: Calendar = _

  @BeanProperty
  var endTime: Calendar = _

  var generated: Array[String] = _

  var innerMetadata: String = _

  def getModel: Model = {
    val model = ModelFactory.createDefaultModel()
    model.setNsPrefixes(Vocab.prefixMap)
    model.add(
      ResourceFactory.createResource("activity"),
      ResourceFactory.createProperty(Vocab.PROV.used),
      ResourceFactory.createResource(dbusSF.uri)
    )

    additionals.foreach(add => model.add(add))
    /* return */ model
  }

  private val additionals = new ArrayBuffer[Model]()

  def addMetadata(model: Model): Unit = {
    additionals.append(model)
  }
}
