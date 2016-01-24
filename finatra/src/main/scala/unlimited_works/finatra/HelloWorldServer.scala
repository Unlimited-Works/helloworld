package unlimited_works.finatra

import com.google.inject.Inject
import com.twitter.finagle.http.{Request, Response}
import com.twitter.finatra.annotations.Flag
import com.twitter.finatra.http.HttpServer
import com.twitter.finatra.http.filters.CommonFilters
import com.twitter.finatra.http.routing.HttpRouter
import com.twitter.finatra.logging.filter.{LoggingMDCFilter, TraceIdMDCFilter}
import com.twitter.finatra.logging.modules.Slf4jBridgeModule
import unlimited_works.finatra.controller.{Resources, Login}
import unlimited_works.finatra.module.AssetsPathConfigModule

object HelloWorldServerMain extends HelloWorldServer

class HelloWorldServer extends HttpServer {
//  flag("doc.root", "unlimited_works.finatra.public", "assets class path")

  //outer dependency as various modules, such as database, memcache, akka system
  //every module with it's configuration could represent by Flag.
  override val modules = Seq(
    Slf4jBridgeModule,
    AssetsPathConfigModule
  )

  override def postWarmup() {
    super.postWarmup()


  }
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
