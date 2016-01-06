package unlimited_works.mongodb.dao.lift

import net.liftweb.mongodb.record.{MongoMetaRecord, MongoRecord}
import net.liftweb.mongodb.record.field.ObjectIdPk

class Resume extends MongoRecord[Resume] with ObjectIdPk[Resume] {
  override def meta = Resume
}

object Resume extends Resume with MongoMetaRecord[Resume] {
  override val collectionName = "resumes"
}