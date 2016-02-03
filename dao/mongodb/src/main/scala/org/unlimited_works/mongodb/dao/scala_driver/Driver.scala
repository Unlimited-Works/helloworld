package org.unlimited_works.mongodb.dao.scala_driver

import org.mongodb.scala.{MongoClient, MongoDatabase, MongoCollection, Document}
import scala.collection.mutable

/**
  * basic of module
  */
trait Collection {
  protected val dbName, coll: String
  type module
  val database: MongoDatabase = Driver.getDB(dbName)
  val collection: MongoCollection[Document] = database.getCollection(coll)

}

/**
  * MongoLink resources
  */
object Driver {
  private var dbs = mutable.Map.empty[String, MongoDatabase]

  def getDB(dbName: String) = dbs(dbName)

  def addDB(dbName: String) = this.synchronized {
    val mongoClient: MongoClient = MongoClient()
    val database: MongoDatabase = mongoClient.getDatabase(dbName)
    dbs += Tuple2(dbName, database)
  }

  def removeDB(name: String) = this.synchronized {
    dbs -= name
  }
}