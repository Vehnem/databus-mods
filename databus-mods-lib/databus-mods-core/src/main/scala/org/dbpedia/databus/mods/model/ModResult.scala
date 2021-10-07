package org.dbpedia.databus.mods.model

sealed trait ModResult {
  // TODO
}


case class Summary() extends ModResult
case class Statistics() extends ModResult
case class Enrichment() extends ModResult