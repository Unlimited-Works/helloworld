package unlimited_works.finatra

import com.twitter.finagle.http.{Request, Response}
import com.twitter.finatra.http.HttpServer
import com.twitter.finatra.http.filters.CommonFilters
import com.twitter.finatra.http.routing.HttpRouter
import com.twitter.finatra.logging.filter.{LoggingMDCFilter, TraceIdMDCFilter}
import com.twitter.finatra.logging.modules.Slf4jBridgeModule
import unlimited_works.finatra.controller.Login
import unlimited_works.finatra.module.MyModule1
import unlimited_works.finatra.public.Resources

object HelloWorldServerMain extends HelloWorldServer

class HelloWorldServer extends HttpServer {
//  I was try convert assets path to resources/public, but those doesn't any effect.
//  System.setProperty("com.twitter.finatra.config.assetPath", "src/main/resources/public")
//  System.setProperty("local.doc.root", "src/main/resources/public")

  override val modules = Seq(
    Slf4jBridgeModule,
    MyModule1
  )

  override def defaultFinatraHttpPort = ":9999"

  // limited (1024, 49152) as self-define port
  override def configureHttp(router: HttpRouter) {
    router
      .filter[LoggingMDCFilter[Request, Response]]
      .filter[TraceIdMDCFilter[Request, Response]]
      .filter[CommonFilters]
      .add[HelloWorldController]
      .add[Login]
      .add[Resources]
  }
}
