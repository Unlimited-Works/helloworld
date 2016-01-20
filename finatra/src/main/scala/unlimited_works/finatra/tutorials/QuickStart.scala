package unlimited_works.finatra.tutorials

/**
 * http://twitter.github.io/finagle/guide/Quickstart.html#setting-up-sbt
 */

//We’ll need to import a few things into our namespace.
import com.twitter.finagle.{Http, Service, http}
import com.twitter.util.{Await, Future}

class QuickStart {
  class Server {
//    given a request, we must promise a response some time in the future.
    val service = new Service[http.Request, http.Response] {
      def apply(req: http.Request): Future[http.Response] =
        Future.value(
          http.Response(req.version, http.Status.Ok)
        )
    }
    val server = Http.serve(":8080", service)
    Await.ready(server)
  }

  class Client {
//    client is a Service to which we can dispatch an http.Request and in return receive a Future[http.Response]
    val client: Service[http.Request, http.Response] = Http.newService("www.scala-lang.org:80")
    val request = http.Request(http.Method.Get, "/")
    request.host = "www.scala-lang.org"
    val response: Future[http.Response] = client(request)
    response.onSuccess { resp: http.Response =>
      println("GET success: " + resp)
    }
    Await.ready(response)
  }
}

// Notice the symmetry above: servers provide a Service, while a client uses it.
