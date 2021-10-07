package org.dbpedia.databus.mods.worker.springboot.service

import java.util.concurrent.{ThreadPoolExecutor, TimeUnit}

import org.springframework.stereotype.Service

@Service
class ActivityService() {

  private val executor = new ThreadPoolExecutor(1,1,0L,TimeUnit.MILLISECONDS)

  def submit(activityRequest: ActivityRequest): Unit = {

  }
}
