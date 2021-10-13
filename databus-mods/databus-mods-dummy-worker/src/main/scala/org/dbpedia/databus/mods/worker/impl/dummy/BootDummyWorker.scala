package org.dbpedia.databus.mods.worker.impl.dummy

import org.dbpedia.databus.mods.worker.springboot.EnableModWorkerApi
import org.dbpedia.databus.mods.worker.springboot.service.ActivityProcessor
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.{Bean, Primary}

@SpringBootApplication
@EnableModWorkerApi
class BootDummyWorker {


//  @Bean
//  def dummyProcessor(): ActivityProcessor = {
//    new DummyProcessor
//  }
}

object BootDummyWorker extends App {

  SpringApplication.run(classOf[BootDummyWorker], args: _*)
}
