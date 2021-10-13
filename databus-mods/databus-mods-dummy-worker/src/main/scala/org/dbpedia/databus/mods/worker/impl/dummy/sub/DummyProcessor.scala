package org.dbpedia.databus.mods.worker.impl.dummy.sub

import org.apache.jena.rdf.model.{ModelFactory, ResourceFactory}
import org.apache.jena.vocabulary.{DCAT, RDFS}
import org.dbpedia.databus.dataid.SingleFile
import org.dbpedia.databus.mods.model.ModActivityMetadata
import org.dbpedia.databus.mods.worker.springboot.service.ActivityProcessor
import org.springframework.stereotype.Component

@Component
class DummyProcessor extends ActivityProcessor {

  println("DummyProcessor")

  override def process(modActivityMetadata: ModActivityMetadata): Unit = {
    val dbusSF = modActivityMetadata.dbusSF

    val model = ModelFactory.createDefaultModel()
    model.add(
      ResourceFactory.createResource(dbusSF.uri),
      RDFS.seeAlso,
      ResourceFactory.createResource(dbusSF.downloadURL)
    )
    model.add(
      ResourceFactory.createResource(dbusSF.uri),
      DCAT.accessURL,
      ResourceFactory.createResource(dbusSF.downloadURL)
    )
    modActivityMetadata.addMetadata(model)
  }
}
