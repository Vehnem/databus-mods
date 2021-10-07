package org.dbpedia.databus.mods.worker.springboot.config

import java.util

import org.dbpedia.databus.mods.worker.springboot.controller.{PollingBasedWorkerApi, WorkerApi}
import org.slf4j.LoggerFactory
import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.{Bean, Configuration}
import org.springframework.web.servlet.handler.{BeanNameUrlHandlerMapping, SimpleUrlHandlerMapping}

@Configuration
class ModWorkerApiAutoConfig {

  private val log = LoggerFactory.getLogger(classOf[ModWorkerApiAutoConfig])

  @Bean
  def workerApi(): WorkerApi = {
    new PollingBasedWorkerApi()
  }

}
