package org.dbpedia.databus.mods.worker.springboot.controller

import javax.servlet.http.{HttpServletRequest, HttpServletResponse}
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.{RequestMapping, RequestMethod, RestController}
import org.springframework.web.servlet.mvc.AbstractController

@Controller
abstract class WorkerApi {

  /**
   * todo multiple APIs for one application
   */

  private val log = LoggerFactory.getLogger(classOf[WorkerApi])

  @RequestMapping(method = Array(RequestMethod.GET, RequestMethod.POST))
  def activity(request: HttpServletRequest, response: HttpServletResponse): Unit = {
    handleRequest(request, response)
  }

  def handleRequest(request: HttpServletRequest, response: HttpServletResponse): Unit
}
