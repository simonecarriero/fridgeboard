package com.example

import akka.actor.{ActorSystem, Props}
import akka.io.IO
import spray.can.Http
import akka.pattern.ask
import akka.util.Timeout
import scala.concurrent.duration._

object Boot extends App {

  implicit val system = ActorSystem("fridgeboard")
  val service = system.actorOf(Props[ServiceActor], "service")
  implicit val timeout = Timeout(5.seconds)
  val port = sys.env.get("PORT").getOrElse("8080").toInt
  IO(Http) ? Http.Bind(service, "0.0.0.0", port = port)
}
