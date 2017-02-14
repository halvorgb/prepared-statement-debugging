import slick.driver.PostgresDriver.api._
import scala.concurrent.Await
import scala.concurrent.duration._
import scala.concurrent.ExecutionContext.Implicits.global

class Slick {
  case class Triple(a: Int, b: Int, c: Int)

  class Triples(tag: Tag) extends Table[Triple](tag, "slick") {
    def a = column[Int]("a")
    def b = column[Int]("b")
    def c = column[Int]("c")

    def * = (a,b,c) <> (Triple.tupled, Triple.unapply)
  }

  val triples = TableQuery[Triples]


  val db = Database.forConfig("database")

  def insertMany: Option[Int] = {
    val q = for {
      n <- triples ++= 1.to(10).toList.map(n => Triple(n, n, n))
    } yield n

    val futureResult = db.run(q)

    Await.result(futureResult, 2.seconds)
  }

}
