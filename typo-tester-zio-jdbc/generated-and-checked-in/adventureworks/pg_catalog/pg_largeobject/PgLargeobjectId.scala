/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_largeobject

import zio.json.JsonDecoder
import zio.json.JsonEncoder
import zio.json.ast.Json
import zio.json.internal.Write

/** Type for the composite primary key of table `pg_catalog.pg_largeobject` */
case class PgLargeobjectId(loid: /* oid */ Long, pageno: Int)
object PgLargeobjectId {
  implicit lazy val jsonDecoder: JsonDecoder[PgLargeobjectId] = JsonDecoder[Json.Obj].mapOrFail { jsonObj =>
    val loid = jsonObj.get("loid").toRight("Missing field 'loid'").flatMap(_.as(JsonDecoder.long))
    val pageno = jsonObj.get("pageno").toRight("Missing field 'pageno'").flatMap(_.as(JsonDecoder.int))
    if (loid.isRight && pageno.isRight)
      Right(PgLargeobjectId(loid = loid.toOption.get, pageno = pageno.toOption.get))
    else Left(List[Either[String, Any]](loid, pageno).flatMap(_.left.toOption).mkString(", "))
  }
  implicit lazy val jsonEncoder: JsonEncoder[PgLargeobjectId] = new JsonEncoder[PgLargeobjectId] {
    override def unsafeEncode(a: PgLargeobjectId, indent: Option[Int], out: Write): Unit = {
      out.write("{")
      out.write(""""loid":""")
      JsonEncoder.long.unsafeEncode(a.loid, indent, out)
      out.write(",")
      out.write(""""pageno":""")
      JsonEncoder.int.unsafeEncode(a.pageno, indent, out)
      out.write("}")
    }
  }
  implicit lazy val ordering: Ordering[PgLargeobjectId] = Ordering.by(x => (x.loid, x.pageno))
}
