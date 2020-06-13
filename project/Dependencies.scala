import sbt._

object Dependencies {

  private val versions: Map[String, String] = Map (

      "scala-test" -> "3.1.1",

      "flexmark" -> "0.35.10"

  )

  //tests
  private val scalaTest: Seq[ModuleID] = Seq(
    "org.scalatest" %% "scalatest" % versions("scala-test"),
    "org.scalactic" %% "scalactic" % versions("scala-test")
  ).map(_ % Test)

  private val flexmark: Seq[ModuleID] = Seq(
    "com.vladsch.flexmark" % "flexmark-all" % versions("flexmark")
  ).map(_ % Test)

  val testDeps: Seq[ModuleID] = scalaTest.union(flexmark) 
}
