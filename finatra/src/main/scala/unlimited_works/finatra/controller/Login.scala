package unlimited_works.finatra.controller

import com.twitter.finagle.http.Request
import com.twitter.finatra.http.Controller
import com.twitter.finatra.request.QueryParam
import com.twitter.finatra.validation.Max
import org.joda.time.DateTime
import unlimited_works.finatra.HiRequest

import scala.io.Source

/**
  *
  */
class Login extends Controller {

  get("/signin") { request: Request =>
    val content = Source.fromURL(getClass.getResource("/forwardend/login/signin.html")).mkString
    response.created.html(content).toFuture
  }

  //  post("/signin") { request: FormPostRequest =>
  //    response.created.
  //      location("123").
  //      html(
  //        TestUserView(request.age, request.name))
  //  }
}

case class UsersRequest(
                         @Max(100) @QueryParam max: Int,
                         @QueryParam startDate: Option[DateTime],
                         @QueryParam verbose: Boolean = false)