//package org.dbpedia.databus.mods.worker.impl.dummy
//
//import org.junit.jupiter.api.Test
//import org.scalatest.featurespec.AnyFeatureSpec
//import org.springframework.beans.factory.annotation.Autowired
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
//import org.springframework.boot.test.context.SpringBootTest
//import org.springframework.test.context.ContextConfiguration
//import org.springframework.test.context.web.{AnnotationConfigWebContextLoader, WebAppConfiguration}
//import org.springframework.test.web.servlet.{MockMvc, MvcResult, ResultHandler}
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers
//import org.junit.jupiter.run
//
//@ContextConfiguration(
//  locations = Array("org.dbpedia.databus.mods.worker.impl.dummy"),
//  loader = classOf[AnnotationConfigWebContextLoader]
//)
//
//class DummyWorkerTest extends AnyFeatureSpec {
//
//  @Autowired
//  var mockMvc: MockMvc = _
//
//  feature("lol") {
//    scenario("sen") {
//          mockMvc.perform(MockMvcRequestBuilders.get("/"))
//            .andDo(new ResultHandler {
//              override def handle(mvcResult: MvcResult): Unit = println(mvcResult)
//            }).andExpect(MockMvcResultMatchers.status().isOk)
//    }
//  }
//}
////@RunWith
////@SpringBootTest
////@AutoConfigureMockMvc
////class DummyWorkerTest {
////
////  @Autowired
////  var mockMvc: MockMvc = _
////
////  @Test
////  def reachable() = {
////    mockMvc.perform(MockMvcRequestBuilders.get("/"))
////      .andDo(new ResultHandler {
////        override def handle(mvcResult: MvcResult): Unit = println(mvcResult)
////      }).andExpect(MockMvcResultMatchers.status().isOk)
////  }
////}
