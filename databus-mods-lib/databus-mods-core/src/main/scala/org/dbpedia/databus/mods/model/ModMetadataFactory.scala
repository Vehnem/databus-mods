package org.dbpedia.databus.mods.model

object ModMetadataFactory {

//  def createModActivityMetadata(): ModActivityMetadata = {
//    new ModActivityMetadata()
//  }

  def createModResult(modResultType: ModResultType): ModResult = {
    modResultType match {
      case ModResultType.Summary => new Summary
      case ModResultType.Enrichment => new Enrichment
      case ModResultType.Statistics => new Statistics
    }
  }
}
