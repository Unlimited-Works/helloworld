package unlimited_works.play.controllers

import play.api.mvc._
import unlimited_works.play.views

/**
  *
  */
object Blog extends Controller {

  //authenticate confirmation from cookie named uuid
  def index = Action { request =>
    request.cookies.get("uuid").map { uuid =>
      Ok(views.html.blog.index(""))
    }.getOrElse {
      Redirect("/signin")
    }
  }

//  def content(blogId: String) = Action { request =>
//    //is logined
//    //TODO the logic as a annotion
//
//  }
}

/**
  * structure
 */
case class Content( title: String, //标题
                    appendix: String, //附录
                    `abstract`: String, //摘要
                    keywords: List[String],//关键词
                    introduction: String,//引言
                    body: String,//正文
                    conclusion: String,//结束语
                    acknowledgement: List[String],//致谢
                    references: List[String])//参考书目