package com.example

import akka.actor.Actor
import spray.routing._

class ServiceActor extends Actor with Service {
  def actorRefFactory = context
  def receive = runRoute(route)
}

trait Service extends HttpService {

  val route =
    path("") {
      get {
        complete("Hi")
      }
    }

}