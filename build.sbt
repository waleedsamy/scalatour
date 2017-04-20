lazy val root = (project in file("."))
  .settings(
    name         := "scalatour",
    organization := "io.github.waleedsamy",
    scalaVersion := "2.12.1",
    version      := "0.1.0-SNAPSHOT",
    scalacOptions ++= Seq(
      "-feature",
      "-language:postfixOps"
    )
)
