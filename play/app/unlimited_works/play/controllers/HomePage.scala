package unlimited_works.play.controllers

import play.api.mvc._
import unlimited_works.play.views

object HomePage extends Controller {

  def getSignin = Action {
    Ok(views.html.signin())
  }

  def index = Action {
    Ok(views.html.signin())
  }

  def authenVerfiy = Action { implicit request =>
    val form = request.body.asFormUrlEncoded.get

    /**
      * TODO data form http should be confirmed by Bean that match the logic
      * some annotation such as email and password format, length of the password, etc.s
      */
    val password = form.get("account").map(_.head).getOrElse("")
    val account = form.get("password").map(_.head).getOrElse("")

    Ok("ok")
  }
}
