import Dependencies._
import sbt.{Compile, Resolver, Setting, URL}
import sbt.Keys._

object CommonSettings {

  val value: Seq[Setting[_]] = Seq(
    name := "auction",
    version := "0.0.1",
    scalaVersion := "2.13.2",
    resolvers ++= Seq(
        Resolver.mavenCentral,
        Resolver.mavenLocal,
        Resolver.bintrayRepo("sbt-assembly", "maven"),
        Resolver.bintrayRepo("sbt-native-packager", "maven")
      ),
    mainClass in Compile := Some("example.Hello"),
    scalacOptions := Seq("-unchecked", "-feature", "-deprecation", "-encoding", "utf8"),
    libraryDependencies ++= Dependencies.mainDeps ++ Dependencies.testDeps
  )
}
