package com.example

import org.specs2.mutable.Specification
import spray.testkit.Specs2RouteTest

class ServiceSpec extends Specification with Specs2RouteTest with Service {
  def actorRefFactory = system
  
  "Service" should {

    "say Hi" in {
      Get() ~> route ~> check {
        responseAs[String] contains "Hi"
      }
    }

  }
}
