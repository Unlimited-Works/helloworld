package org.unlimitedcode.mongodb.dao.lift

import com.mongodb.{Mongo, ServerAddress, MongoClient, MongoClientOptions}
import net.liftweb.mongodb.MongoDB
import net.liftweb.util.{Props, DefaultConnectionIdentifier}

class Connection {
  def init: Unit = {
    val srvr = new ServerAddress(
      Props.get("mongo.host", "127.0.0.1"),
      Props.getInt("mongo.port", 27017)
    )
    MongoDB.defineDb(DefaultConnectionIdentifier, new MongoClient(Config.host, Config.port), Config.db)
  }
}

//better save into XML
object Config {
  val host = "127.0.0.1"
  val port = 27017
  val db = "fstdb"
}
