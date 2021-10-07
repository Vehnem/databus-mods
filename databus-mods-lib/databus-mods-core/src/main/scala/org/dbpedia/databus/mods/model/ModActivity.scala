package org.dbpedia.databus.mods.model

import java.util.concurrent.Callable

class ModActivity extends Callable[ModActivityMetadata] {

  override def call(): ModActivityMetadata = {

    val mam = ModMetadataFactory.createModActivityMetadata()


  }
}
