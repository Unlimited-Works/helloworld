package unlimited_works

/**
  *
  */
package object terminal {
  def printTip(tip: String, text: Any) = {
    println(s"$tip - $text")
  }
}
