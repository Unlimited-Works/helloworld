//package unlimited_works.finatra
//
//import com.twitter.conversions.time._
//import com.twitter.finagle.http.{Status, HttpMuxer, Request, Response}
//import com.twitter.finagle.Service
//import com.twitter.finatra.http.HttpServer
//import com.twitter.io.Charsets
//import com.twitter.logging.Formatter
//import com.twitter.server.TwitterServer
//import com.twitter.util.{Await, Future, Time}
//import java.net.InetSocketAddress
//
//object AdvancedServer {//extends TwitterServer {
//
//  val what = flag("what", "hello", "String to return")
//  val addr = flag("bind", new InetSocketAddress(0), "Bind address")
//  val durations = flag("alarms", (1.second, 5.second), "2 alarm durations")
//  val counter = statsReceiver.counter("requests_counter")
//  override def defaultFormatter = new Formatter(
//    timezone = Some("UTC"),
//    prefix = "<yyyy-MM-dd HH:mm:ss.SSS> [%.3s] %s: "
//  )
//
//  val service = new Service[Request, Response] {
//    def apply(request: Request) = {
//      log.debug("Received a request at " + Time.now)
//      counter.incr()
//      val response = Response(request.version, Status.Ok)
//      response.contentString = what() + "\n"
//      Future.value(response)
//    }
//  }
//
//  def main() {
//    // We can create a new http server but in that case we profit from the
//    // one already started for /admin/*
//    // The `TwitterServer` trait exposes an `adminHttpServer` that serve all routes
//    // registered in the HttpMuxer object, we just have to add our own.
//    HttpMuxer.addHandler("/echo", service)
//    HttpMuxer.addHandler("/echo/", service)
//    // And wait on the server
//    Await.ready(adminHttpServer)
//  }
//}