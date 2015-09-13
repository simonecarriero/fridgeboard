package com.example

import akka.actor.Actor
import spray.http.MediaTypes.`application/json`
import spray.routing._

class ServiceActor extends Actor with Service {
  def actorRefFactory = context
  def receive = runRoute(route)
}

trait Service extends HttpService {

  val route =
    path("items" / IntNumber) { id =>
      get {
        respondWithMediaType(`application/json`) {
          complete {
            "{\"id\": " + id + "}"
          }
        }
      }
    }

}