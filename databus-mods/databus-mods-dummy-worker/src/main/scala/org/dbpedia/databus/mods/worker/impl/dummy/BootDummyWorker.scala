package org.dbpedia.databus.mods.worker.impl.dummy

import org.dbpedia.databus.mods.worker.springboot.EnableModWorkerApi
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
@EnableModWorkerApi
class BootDummyWorker {

}

object BootDummyWorker extends App {

  SpringApplication.run(classOf[BootDummyWorker])
}
