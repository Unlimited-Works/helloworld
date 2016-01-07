
import sbt.Keys._

lazy val projectVersion = "1.0-SNAPSHOT"

lazy val buildSettings = Seq(
  version := projectVersion,
  scalaVersion := "2.11.7"
)

lazy val baseSetting = Seq(

)

lazy val compilerOptions = scalacOptions ++= Seq(
  "-encoding", "UTF-8"
)

lazy val helloworldModules = Seq(
  web,
  akka,
  daoMongodb,
  daoUtil
)

lazy val versions = new {
  val akkaActor = "2.4.1"
  val mongoScalaDriver = "1.1.0"

  //web finatra
  val finatra = "2.1.2"
  val guice = "4.0"
  val logback = "1.0.13"

  val liftMongoRecorder = "3.0-M7"
}

lazy val web = (project in file("web")).
  settings(buildSettings: _*).
  settings(
    resolvers ++= Seq(Resolver.sonatypeRepo("releases"),
      "Twitter Maven" at "https://maven.twttr.com"
    )
  ).
  settings(
    name := "web",
    moduleName := name.value,
    libraryDependencies ++= Seq(
      "com.twitter.finatra" %% "finatra-http" % versions.finatra,
      "com.twitter.finatra" %% "finatra-httpclient" % versions.finatra,
      "com.twitter.finatra" %% "finatra-slf4j" % versions.finatra,
      "com.twitter.inject" %% "inject-core" % versions.finatra,
      "ch.qos.logback" % "logback-classic" % versions.logback,

      "com.twitter.finatra" %% "finatra-http" % versions.finatra % "test",
      "com.twitter.finatra" %% "finatra-jackson" % versions.finatra % "test",
      "com.twitter.inject" %% "inject-server" % versions.finatra % "test",
      "com.twitter.inject" %% "inject-app" % versions.finatra % "test",
      "com.twitter.inject" %% "inject-core" % versions.finatra % "test",
      "com.twitter.inject" %% "inject-modules" % versions.finatra % "test",
      "com.google.inject.extensions" % "guice-testlib" % versions.guice % "test",

      "com.twitter.finatra" %% "finatra-http" % versions.finatra % "test" classifier "tests",
      "com.twitter.finatra" %% "finatra-jackson" % versions.finatra % "test" classifier "tests",
      "com.twitter.inject" %% "inject-app" % versions.finatra % "test" classifier "tests",
      "com.twitter.inject" %% "inject-core" % versions.finatra % "test" classifier "tests",
      "com.twitter.inject" %% "inject-modules" % versions.finatra % "test" classifier "tests",
      "com.twitter.inject" %% "inject-server" % versions.finatra % "test" classifier "tests",

      "org.mockito" % "mockito-core" % "1.9.5" % "test",
      "org.scalatest" %% "scalatest" % "2.2.3" % "test",
      "org.specs2" %% "specs2" % "2.3.12" % "test")
  )

lazy val akka = (project in file("akka")).
  settings(buildSettings: _*).
  settings(
    name := "akka",
    organization := "org.unlimitedcode.akka",
    libraryDependencies ++= Seq(
      "com.typesafe.akka" %% "akka-actor" % versions.akkaActor
    )
  ).
  settings(resolvers += "Akka Snapshot Repository" at "http://repo.akka.io/snapshots/")//not snap now

lazy val daoMongodb = (project in file("dao/mongodb")).
  settings(buildSettings: _*).
  settings(
    name := "dao-mongodb",
    moduleName := name.value,
    libraryDependencies ++= Seq(
      "org.mongodb.scala" %% "mongo-scala-driver" % versions.mongoScalaDriver,
      "net.liftweb" %% "lift-mongodb-record" % versions.liftMongoRecorder
    )
  )

lazy val daoUtil = (project in file("dao/util")).
  settings(buildSettings: _*).
  settings(
    name := "dao-util",
    moduleName := name.value
  )

//not decide needs of util, need the top dependence for other modules?
// If need, other modules can't independence, a good way is put the util to a private responsitory
lazy val util = (project in file("util")).
  settings(buildSettings: _*).
  settings(
    name := "util",
    moduleName := name.value
  )
