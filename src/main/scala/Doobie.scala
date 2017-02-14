import doobie.imports._
import fs2.Task
import cats.implicits._

class Doobie(url: String, user: String) {

  val xa: Transactor[Task] = DriverManagerTransactor[Task](
    driver = "org.postgresql.Driver",
    url = url,
    user = user,
    pass = ""
  )

  def insertMany: Int = {
    val q = Update[(Int, Int, Int)]("INSERT INTO doobie (x, y, z) VALUES (?, ?, ?)").updateMany(1.to(10).toList.map(n => (n, n, n)))

    q.transact(xa).unsafeRun
  }


}
