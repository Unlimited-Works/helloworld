package unlimited_works.finatra.module

import com.google.inject.Provides
import com.twitter.inject.TwitterModule

/**
  *
  */
object MyModule1 extends TwitterModule {
  val key = flag("key", "defaultkey", "The key to use.")

//  @Singleton
  @Provides
  def providesThirdPartyFoo: ThirdPartyFoo = {
    new ThirdPartyFoo(key())
  }
}

case class ThirdPartyFoo(key: String)