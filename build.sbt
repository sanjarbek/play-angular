import play.Project._

name := "iClinic"

version := "1.0"

libraryDependencies ++= Seq (
  "org.webjars" %% "webjars-play" % "2.2.1",
  "org.webjars" % "bootstrap" % "3.2.0",
  "org.webjars" % "jquery" % "1.9.1",
  "org.webjars" % "angularjs" % "1.2.21",
  "org.webjars" % "ng-grid" % "2.0.11-2",
  "org.webjars" % "angular-ui-calendar" % "0.8.1",
  "org.webjars" % "angular-loading-bar" % "0.5.0",
  "org.webjars" % "angular-ui-router" % "0.2.10-1",
  "org.apache.poi" % "poi" % "3.8",
  "org.apache.poi" % "poi-ooxml" % "3.8"
)

playScalaSettings