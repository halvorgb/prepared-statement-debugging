lazy val versions = new {
  val logback = "1.0.13"
  val postgresql = "9.4-1201-jdbc41"
  val slick = "3.2.0-M2"
  val doobie = "0.4.1"
}

name := "prepared"

scalaVersion := "2.11.8"

resolvers ++= Seq(
  Resolver.sonatypeRepo("releases")
)

// not included: Slick-PG
libraryDependencies := Seq(
  "org.postgresql" % "postgresql" % versions.postgresql,
  "com.typesafe.slick" %% "slick" % versions.slick,
  "com.typesafe.slick" % "slick-hikaricp_2.11" % versions.slick,


  "org.tpolecat" %% "doobie-core-cats" % versions.doobie,
  "org.tpolecat" %% "doobie-postgres-cats" % versions.doobie
)
