package lorancechen.grosery

import net.liftweb.json
import net.liftweb.json.JsonAST._

import scala.io.{Codec, Source}

/**
 *
// */
//object addFiledInJson {
//  def theTask = {
//    val path = "/Users/lorancechen/git/unlimited-works/helloworld/util/src/main/resources/111.json"
//    val sourceCHS = Source.fromInputStream(getClass.getResourceAsStream("/location/111.json"))(Codec.UTF8)
//    val sourceStatistic = Source.fromInputStream(getClass.getResourceAsStream("/location/statistic.json"))(Codec.UTF8)
//    val prasedCHS = json.JsonParser.parse(sourceCHS.bufferedReader(), true)
//    val prasedStatistic = json.JsonParser.parse(sourceStatistic.bufferedReader(), true)
//    case class IdAndCount(_id: String, count: Int)
//    case class Statistic(statistic: List[IdAndCount])
//    val stas = prasedStatistic.extract[Statistic]
//    prasedCHS.asInstanceOf[JObject].obj.map{country =>
//      val id = country.name
////      if(stas.statistic.exists(_._id == id))//true
////        country.value.(JField("hasUniversity", JBool(true)))
//    }
//  }
//}

