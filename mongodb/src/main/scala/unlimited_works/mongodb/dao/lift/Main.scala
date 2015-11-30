package unlimited_works.mongodb.dao.lift

import com.mongodb.ServerAddress
import net.liftweb.util.DefaultConnectionIdentifier
import net.liftweb.mongodb.MongoDB
import unlimited_works.mongodb.dao

class Main extends dao.TMain{
  override def linkToMongo = {
    val mongoClient = new com.mongodb.MongoClient(new ServerAddress("127.0.0.1", 27017))

    MongoDB.defineDb(
      DefaultConnectionIdentifier,
      mongoClient,
      "fstdb"
    )
  }

  override def op = {
    def printLine(str: String) = println(str + "==========")
    Account.findAll map println
    Account.find(Account.user.name, "fn1") map println
    Account.find(Account.id.name, "56585edbd838ae248bec46ef") map println
  }
}
