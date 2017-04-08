package com.nirdosh.test

import akka.actor.Actor
import akka.actor.Actor.Receive

class TestClass extends Actor {
  override def receive: Receive = {
    case _ =>
  }
}

object TestClass {
  def main(args: Array[String]): Unit = {
    val actor = new TestClass
  }
}
