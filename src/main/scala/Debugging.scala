import com.typesafe.config.ConfigFactory

object Debugging extends App {

  val conf = ConfigFactory.load()
  val url: String = conf.getString("database.url")
  val user: String = conf.getString("database.user")

  val slick = new Slick
  val doobie = new Doobie(url, user)


  val d0 = doobie.insertMany
  println(s"doobie: Inserted $d0 rows")

  val s0 = slick.insertMany
  println(s"slick: Inserted $s0 rows")

  val d1 = doobie.insertMany
  println(s"doobie: Inserted $d1 rows")

  val s1 = slick.insertMany
  println(s"slick: Inserted $s1 rows")

}
