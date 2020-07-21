name := "shiftleft-scala-example"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala,SonarRunnerPlugin)

scalaVersion := "2.11.6"

resolvers += "Scalaz Bintray Repo" at "https://dl.bintray.com/scalaz/releases"

libraryDependencies ++= Seq(
  "com.typesafe.play" %% "play-slick" % "1.1.0",
  "com.typesafe.play" %% "play-slick-evolutions" % "1.1.0",
  "com.h2database" % "h2" % "1.4.177",
  "org.spire-math" %% "spire" % "0.11.0",
  "commons-io" % "commons-io" % "2.5",
  specs2 % Test
)     

// Play provides two styles of routers, one expects its actions to be injected, the
// other, legacy style, accesses its actions statically.
routesGenerator := InjectedRoutesGenerator


sonarProperties ++= Map(
  "sonar.jdbc.username" -> "sonar",
  "sonar.jdbc.password" -> "changeme",
  "sonar.jdbc.url" -> "jdbc:postgresql://127.0.0.1:5432/sonarqube",
  "sonar.host.url" -> "http://localhost:9000"
)
