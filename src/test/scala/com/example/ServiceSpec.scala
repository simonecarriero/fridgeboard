package com.example

import org.specs2.mutable.Specification
import spray.http.MediaTypes.`application/json`
import spray.testkit.Specs2RouteTest

class ServiceSpec extends Specification with Specs2RouteTest with Service {
  def actorRefFactory = system

  "Service" should {

    "return an item" in {
      Get("/items/1") ~> route ~> check {
        mediaType === `application/json`
        responseAs[String] mustEqual """{"id": 1}"""
      }
    }

  }
}
