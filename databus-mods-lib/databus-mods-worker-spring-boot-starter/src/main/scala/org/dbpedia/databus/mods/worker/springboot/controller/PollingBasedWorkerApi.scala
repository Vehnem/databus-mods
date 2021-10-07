package org.dbpedia.databus.mods.worker.springboot.controller

import java.nio.charset.StandardCharsets

import javax.servlet.http.{HttpServletRequest, HttpServletResponse}
import org.apache.commons.io.IOUtils

class PollingBasedWorkerApi extends WorkerApi {
  override def handleRequest(request: HttpServletRequest, response: HttpServletResponse): Unit = {
    val os = response.getOutputStream
    IOUtils.write("PollingBasedWorkerApi",os,StandardCharsets.UTF_8)
    os.close()
  }
}
