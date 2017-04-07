package com.nirdosh.akka.investigation

import akka.actor.{Actor, ActorSystem, Props}

case class DoSomething(withThis:String)
class MyConcurrentObject extends Actor{
  override def receive = {
    case DoSomething(withThis) =>
      println(s"doing something with $withThis")
  }
}

object DoSomething {
  def doSomething(withThis: String): Unit ={
    println("sleeping")
    Thread.sleep(5000)
    println(s"tesing this $withThis")
  }

  def main(args: Array[String]): Unit = {
    DoSomething.doSomething("test")
    println("after that")

    val system = ActorSystem("test")
    system.actorOf(Props[MyConcurrentObject],"test") ! DoSomething("test do something")
    println("concurrent after that")
  }

}