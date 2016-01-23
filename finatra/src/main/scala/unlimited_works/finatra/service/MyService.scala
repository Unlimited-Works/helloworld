package unlimited_works.finatra.service

import com.google.inject.Inject
import unlimited_works.finatra.module.ThirdPartyFoo

/**
  *
  */
class MyService @Inject() (thirdPartyFoo: ThirdPartyFoo) {
  def getFooName = thirdPartyFoo.key
}