package com.nirdosh.akka.investigation


object ImplicitParameters {

  implicit val multiplier = 2
  def multiply(implicit by:Int) = 2 * by
  def main(args: Array[String]): Unit = {
    multiply
  }
}
