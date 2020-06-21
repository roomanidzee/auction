import sbt._

object Dependencies {

  private val versions: Map[String, String] =
    Map("log4j" -> "2.13.3", "scala-test" -> "3.1.1", "flexmark" -> "0.35.10")

  //logging
  private val logging: Seq[ModuleID] = Seq(
    "org.apache.logging.log4j" % "log4j-core" % versions("log4j"),
    "org.apache.logging.log4j" % "log4j-api" % versions("log4j")
  )

  //tests
  private val scalaTest: Seq[ModuleID] = Seq(
    "org.scalatest" %% "scalatest" % versions("scala-test"),
    "org.scalactic" %% "scalactic" % versions("scala-test")
  ).map(_ % Test)

  private val flexmark: Seq[ModuleID] =
    Seq("com.vladsch.flexmark" % "flexmark-all" % versions("flexmark")).map(_ % Test)

  val mainDeps: Seq[ModuleID] = logging

  val testDeps: Seq[ModuleID] = scalaTest.union(flexmark)
}
