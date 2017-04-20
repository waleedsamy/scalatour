lazy val root = (project in file("."))
  .settings(
    name         := "scalatour",
    organization := "io.github.waleedsamy",
    scalaVersion := "2.12.1",
    version      := "0.1.0-SNAPSHOT",
    scalacOptions ++= Seq(
      "-feature",
      "-language:postfixOps"
    ),
    libraryDependencies ++=Seq(
      "org.scalaz" %% "scalaz-core" % "7.2.11"
    ),
    mainClass in (Compile, run) := Some("io.github.waleedsamy.scalatour.SelfReferences"),
    mainClass in (Compile, packageBin) := Some("io.github.waleedsamy.scalatour.SelfReferences")
)
