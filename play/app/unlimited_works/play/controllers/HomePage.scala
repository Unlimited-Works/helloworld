package unlimited_works.play.controllers

import play.api.mvc._
import unlimited_works.play.views

object HomePage extends Controller {

  def index = Action {
    Ok(views.html.signin( ))
  }
}