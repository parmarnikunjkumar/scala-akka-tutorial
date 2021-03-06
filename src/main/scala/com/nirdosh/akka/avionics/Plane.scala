package com.nirdosh.akka.avionics

import akka.actor.{Actor, ActorLogging, Props}

object Plane {

  case object GiveMeControl

}

class Plane extends Actor with ActorLogging {

  import Altimeter._
  import Plane._

  val altimeter = context.actorOf(Props[Altimeter], "Altimeter")
  val controls = context.actorOf(Props(new ControlSurfaces(altimeter)), "ControlSurfaces")

  override def receive: Receive = {
    case GiveMeControl =>
      log info ("Plane giving control.")
      sender ! controls
    case AltitudeUpdate(altitude) =>
      log info (s"Altitude is now : $altitude")
  }

  import EventSource._

  override def preStart(): Unit = {
    altimeter ! RegisterListener(self)
  }
}
