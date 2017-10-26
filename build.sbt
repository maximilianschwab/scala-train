organization := "de.heikoseeberger"
name := "scala-train"
version := "2.0.0"

scalaVersion := "2.11.7"
scalacOptions := List(
    "-unchecked",
    "-deprecation",
    "-target:jvm-1.8"
)

import scalariform.formatter.preferences._
SbtScalariform.autoImport.preferences := SbtScalariform.autoImport.preferences.value
.setPreference(AlignSingleLineCaseStatements, true)
.setPreference(AlignSingleLineCaseStatements.MaxArrowIndent, 100)
.setPreference(DoubleIndentClassDeclaration, true)

//Bei Start der REPL Packet importieren
initialCommands := "import de.heikoseeberger.scalatrain._"

libraryDependencies ++= List(
    //ScalaTest Bibliothek hinzufügen für Unit Tests
    "org.scalatest" %% "scalatest" % "2.2.5" % "test",
    "org.scalacheck" %% "scalacheck" % "1.12.4" % "test",
    //Log4j Bibliotheken hinzufügen
    "org.apache.logging.log4j" % "log4j-api" % "2.3",
    "org.apache.logging.log4j" % "log4j-core" % "2.3"


)