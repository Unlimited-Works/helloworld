package unlimited_works.finatra.controller

import com.twitter.finagle.http.Request
import com.twitter.finatra.http.Controller

/**
  * Getting all resources from the route.
  * path of assets defined at AssetsPathConfigModule.scala
  */
class Resources extends Controller {
  get("/assets/:*") { request: Request =>
    val x = response.ok.file(request.params("*"))
//    println(s"asset - ${request.params("*")} - $x")
    x
  }
}

