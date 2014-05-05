import sbt._
import Keys._

object ApplicationBuild extends Build {

  val playVersion = "2.2.3"

  val main = Project("iteratees-extras", new File(".")).settings(
    libraryDependencies ++= Seq(
      "com.typesafe.play" %% "play" % playVersion % "provided",
      "org.specs2" %% "specs2" % "1.12.3" %  "test"
    ),
    publishTo <<= (version) { version: String =>
      val nexus = "https://private-repo.typesafe.com/typesafe/"
      if (version.trim.endsWith("SNAPSHOT")) Some("snapshots" at nexus + "maven-snapshots/")
      else                                   Some("releases"  at nexus + "maven-releases/")
    },
    organization := "com.typesafe.play.extras",
    version := "1.2.1-SNAPSHOT",
    scalaVersion := "2.10.2"
  )

}
