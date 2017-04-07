package com.nirdosh.akka.avionics

import akka.actor.{Actor, ActorRef}

object ControlSurfaces {

  case class StickBack(amounnt: Float)

  case class StickForward(amount: Float)

}

class ControlSurfaces(altimeter: ActorRef) extends Actor {

  import Altimeter._
  import ControlSurfaces._

  override def receive = {
    case StickBack(amounnt) =>
      altimeter ! RateChange(amounnt)
    case StickForward(amount) =>
      altimeter ! RateChange(-1 * amount)

  }
}
