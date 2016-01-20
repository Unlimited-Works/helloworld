//resolvers ++= Seq(
//  Classpaths.sbtPluginSnapshots,
//  Classpaths.sbtPluginReleases,
//  Resolver.sonatypeRepo("snapshots"),
//  "Twitter Maven" at "https://maven.twttr.com"
//)
//
//addSbtPlugin("com.eed3si9n" % "sbt-unidoc" % "0.3.2")
//addSbtPlugin("com.eed3si9n" % "sbt-assembly" % "0.13.0")
//addSbtPlugin("pl.project13.scala" % "sbt-jmh" % "0.1.8")
//addSbtPlugin("com.twitter" %% "scrooge-sbt-plugin" % "4.1.0")
//addSbtPlugin("org.scoverage" % "sbt-scoverage" % "1.2.0")

//PLAY=======================
// The Play plugin
addSbtPlugin("com.typesafe.play" % "sbt-plugin" % "2.4.6")

// web plugins
addSbtPlugin("com.typesafe.sbt" % "sbt-coffeescript" % "1.0.0")

addSbtPlugin("com.typesafe.sbt" % "sbt-less" % "1.0.6")

addSbtPlugin("com.typesafe.sbt" % "sbt-jshint" % "1.0.3")

addSbtPlugin("com.typesafe.sbt" % "sbt-rjs" % "1.0.7")

addSbtPlugin("com.typesafe.sbt" % "sbt-digest" % "1.1.0")

addSbtPlugin("com.typesafe.sbt" % "sbt-mocha" % "1.1.0")
