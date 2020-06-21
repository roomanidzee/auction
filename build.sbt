import Dependencies._

lazy val root = project
  .in(file("."))
  .enablePlugins(JavaServerAppPackaging)
  .settings(
    CommonSettings.value,
    testOptions in Test ++= Seq(
        Tests.Argument(TestFrameworks.ScalaTest, "-o"),
        Tests.Argument(TestFrameworks.ScalaTest, "-h", "target/test-reports")
      ),
    scalafmtOnCompile := true,
    maintainer := "Andrey Romanov <steampart@gmail.com>",
    packageSummary in Linux := "Example of auction app",
    packageDescription := "Example of auction app",
    mappings in Universal ++= Seq(
        (resourceDirectory in Compile).value / "log4j.xml" -> "conf/log4j.xml",
        (packageBin in Compile).value                      -> (packageBin in Compile).value.getName
      )
  )

addCommandAlias("build-dist", ";fmt;test;universal:packageBin;")
addCommandAlias("fmt", ";scalafmt;test:scalafmt;scalafmtSbt;")
