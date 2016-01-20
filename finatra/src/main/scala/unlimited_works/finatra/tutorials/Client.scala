package unlimited_works.finatra.tutorials

import com.twitter.finagle.{Http, Service, http}
import com.twitter.util.{Await, Future}
/**
 *
 */
class Client {
  val client: Service[http.Request, http.Response] = Http.newService("www.baidu.com:80")
  val request = http.Request(http.Method.Get, "/")
  request.host = "www.baidu.com"
  val response: Future[http.Response] = client(request)
  response.onSuccess { resp: http.Response =>
    println("GET success: " + resp)
  }
  val x = Await.result(response)
  x
}
