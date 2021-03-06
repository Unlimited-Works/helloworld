package org.unlimited_works.mongodb.dao

object ScalaMain {

  val linker = new lift.Main
  def linkToMongo = {
    linker.linkToMongo
  }

  def op: Unit = linker.op

  def main(args: Array[String]): Unit = {
    linkToMongo
    op
  }
}

trait TMain {
  def linkToMongo: Unit
  def op: Unit
}
