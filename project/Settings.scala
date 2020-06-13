import sbt.{ Compile, Resolver, Setting, URL }
import sbt.Keys._

object Settings {

    val config: Seq[String] = Seq(
        "-unchecked",
        "-feature",
        "-deprecation",
        "-encoding",
        "utf8",
    )
}