import Dependencies._

name := "auction"
version := "0.0.1"
scalaVersion := "2.13.2"

assemblyJarName in assembly := "auction.jar"
test in assembly := {}
mainClass in assembly := Some("example.Hello")

assemblyMergeStrategy in assembly := {
  case x if x.contains("io.netty.versions.properties") => MergeStrategy.discard
  case x =>
    val oldStrategy = (assemblyMergeStrategy in assembly).value
    oldStrategy(x)
}

testOptions in Test ++= Seq(
  Tests.Argument(TestFrameworks.ScalaTest, "-o"),
  Tests.Argument(TestFrameworks.ScalaTest, "-h", "target/test-reports")
)

resolvers ++= Seq(
  Resolver.mavenCentral,
  Resolver.mavenLocal,
  Resolver.bintrayRepo("sbt-assembly", "maven")
)

scalacOptions ++= Settings.config

libraryDependencies ++= Dependencies.testDeps

scalafmtOnCompile := true

addCommandAlias("build-jar", ";test;assembly")