package org.dbpedia.databus.mods.model

import java.time.Instant
import java.util.Calendar

import scala.beans.BeanProperty

class ModActivityMetadata {

  var state: Int = 0

  @BeanProperty
  var startTime: Calendar

  @BeanProperty
  var endTime: Calendar


}
