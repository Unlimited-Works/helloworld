package unlimited_works.finatra.public

import com.twitter.finagle.http.Request
import com.twitter.finatra.http.Controller

/**
  *
  */
class Resources extends Controller {
  get("/assets/:*") { request: Request =>
//    println("assets path - " + request.params("*"))
    val rst = response.ok.file("/public/" + request.params("*"))
//    println(rst.toString)
    rst
  }

//  get("/test") { reqest: Request =>
//    val rst = response.ok.file("/public/test.txt")
//    println(rst.toString)
//    rst
//  }
}