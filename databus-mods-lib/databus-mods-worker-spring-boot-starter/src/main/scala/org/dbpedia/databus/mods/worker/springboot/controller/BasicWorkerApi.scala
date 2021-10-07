package org.dbpedia.databus.mods.worker.springboot.controller

import java.nio.charset.StandardCharsets

import javax.servlet.http.{HttpServletRequest, HttpServletResponse}
import org.apache.commons.io.IOUtils
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.servlet.ModelAndView

class BasicWorkerApi extends WorkerApi {

  @GetMapping
  override def handleRequest(request: HttpServletRequest, response: HttpServletResponse): Unit = {

    val os = response.getOutputStream
    IOUtils.write("BasicWorkerApi",os,StandardCharsets.UTF_8)
    os.close()
  }

}
