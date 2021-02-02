package org.dbpedia.databus_mods.void

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.{EnableAutoConfiguration, SpringBootApplication}
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages = Array("org.dbpedia.databus_mods.lib.worker.base", "org.dbpedia.databus_mods.void"))
class Worker {

}

object Worker extends App {
  SpringApplication.run(classOf[Worker], args: _*)
}
