package org.dbpedia.databus.mods.worker.impl.dummy

import java.io.ByteArrayInputStream
import java.nio.charset.StandardCharsets
import java.util.{Timer, TimerTask}

import org.apache.http.client.utils.URIBuilder
import org.apache.jena.rdf.model.ModelFactory
import org.apache.jena.riot.{Lang, RDFDataMgr}
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.web.server.LocalServerPort
import org.springframework.http.ResponseEntity

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class DummyWorkerTest {

  @Autowired
  var restTemplate: TestRestTemplate = _

  @LocalServerPort
  var port = 0

  lazy val host = s"http://localhost:$port"

  @Test
  def testWorkerApi(): Unit = {
    val dbusPath = "vehnem/paper-supplements/demo-graph/20210301/demo-graph.nt"
    val source = "file:///tmp/test.nt"

    val ub = new URIBuilder(s"$host/$dbusPath/activity")
    ub.addParameter("source", source)

    val postResponse = restTemplate.postForEntity(ub.build(), null, classOf[String])
    assert(202 == postResponse.getStatusCode.value())

    var continue = true
    new Timer(true).schedule(new TimerTask {
      override def run(): Unit = {
        continue = false
      }
    }, 10 * 1000)

    var getResponse: ResponseEntity[String] = null
    while (continue) {
      getResponse = restTemplate.getForEntity(postResponse.getHeaders.getLocation, classOf[String])
      assert(200 == getResponse.getStatusCode.value() || 202 == getResponse.getStatusCode.value())
      if (200 == getResponse.getStatusCode.value()) continue = false
    }

    val model = ModelFactory.createDefaultModel()
    RDFDataMgr.read(model, new ByteArrayInputStream(getResponse.getBody.getBytes(StandardCharsets.UTF_8)), Lang.TURTLE)
    RDFDataMgr.write(System.out, model, Lang.TURTLE)
  }
}

