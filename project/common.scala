import sbt.Keys._

object Common {
  lazy val projectVersion = "1.0-SNAPSHOT"

  lazy val buildSettings = Seq(
    version := projectVersion,
    scalaVersion := "2.11.7"
  )
}