package unlimited_works.mongodb.dao.lift

import net.liftweb.mongodb.record._
import net.liftweb.mongodb.record.field.ObjectIdPk
import net.liftweb.record.field.StringField

class Account extends MongoRecord[Account] with ObjectIdPk[Account]{
  override def meta = Account

  object user extends StringField(this, 30)
  object pwd extends StringField(this, 30)
}

object Account extends Account with MongoMetaRecord[Account] {
  override val collectionName = "acont_"

}