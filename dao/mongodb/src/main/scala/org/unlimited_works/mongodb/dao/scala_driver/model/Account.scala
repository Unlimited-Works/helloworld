package org.unlimited_works.mongodb.dao.scala_driver.model

import org.mongodb.scala.bson.collection.immutable.Document
import org.unlimited_works.mongodb.dao.scala_driver.Collection
import org.bson.types.ObjectId


trait AccountAuthentication {
  private def _id: ObjectId = null
  val uuid: String = ""
  val password: String = ""
}

trait AccountBasicInfo {
  val name: String = ""

  trait Sex
  object Boy extends Sex
  object Girl extends Sex
  val sex: Sex = Boy

  val favorite: List[String] = Nil
}

class Account extends
  AccountAuthentication with
  AccountBasicInfo

object Account extends Collection {
  val dbName = "helloworld"
  val coll = "account"
  type module = Account

  def getById(uuid: String) = {
    database.runCommand(Document("uuid" -> uuid))
  }

  /**
    * todo add a macro to compile Module class to TResult
    * @param account
    */
  def insert(account: Account) = {
//    collection.insertOne()
  }
}