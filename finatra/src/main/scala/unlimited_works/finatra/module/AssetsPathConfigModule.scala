package unlimited_works.finatra.module

import com.google.inject.Provides
import com.twitter.finatra.http.routing.FileResolver
import com.twitter.inject.TwitterModule

/**
  * two choice of define assets path, recommend use keyDoc on publish.
  */
object AssetsPathConfigModule extends TwitterModule {
  val keyFileDoc = flag("local.doc.root", "./finatra/src/main/scala/unlimited_works/finatra/public", "The key to use.")
  val keyDoc = flag("doc.root", "/unlimited_works/finatra/public/", "class path")

//  @Singleton //compile error with the annotation
  @Provides
  def providesThirdPartyFoo: FileResolver = {
    new FileResolver("", keyDoc())
//    new FileResolver(keyFileDoc(),"")
  }
}