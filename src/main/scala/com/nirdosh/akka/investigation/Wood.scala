package com.nirdosh.akka.investigation

import akka.actor.{Actor, ActorSystem, Props}

class Wood extends Actor{

  override def receive = {
    case _ =>
      throw new Exception("Wood can't hear you!")
  }
}

object Wood {
  val system = ActorSystem("WoodActorSystem")
  val actor = system.actorOf(Props[Wood],"wood")
  def main(args: Array[String]): Unit = {
    actor ! "hi"
  }
}
