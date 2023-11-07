/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_shdescription

import zio.json.JsonDecoder
import zio.json.JsonEncoder
import zio.json.ast.Json
import zio.json.internal.Write

/** Type for the composite primary key of table `pg_catalog.pg_shdescription` */
case class PgShdescriptionId(objoid: /* oid */ Long, classoid: /* oid */ Long)
object PgShdescriptionId {
  implicit lazy val jsonDecoder: JsonDecoder[PgShdescriptionId] = JsonDecoder[Json.Obj].mapOrFail { jsonObj =>
    val objoid = jsonObj.get("objoid").toRight("Missing field 'objoid'").flatMap(_.as(JsonDecoder.long))
    val classoid = jsonObj.get("classoid").toRight("Missing field 'classoid'").flatMap(_.as(JsonDecoder.long))
    if (objoid.isRight && classoid.isRight)
      Right(PgShdescriptionId(objoid = objoid.toOption.get, classoid = classoid.toOption.get))
    else Left(List[Either[String, Any]](objoid, classoid).flatMap(_.left.toOption).mkString(", "))
  }
  implicit lazy val jsonEncoder: JsonEncoder[PgShdescriptionId] = new JsonEncoder[PgShdescriptionId] {
    override def unsafeEncode(a: PgShdescriptionId, indent: Option[Int], out: Write): Unit = {
      out.write("{")
      out.write(""""objoid":""")
      JsonEncoder.long.unsafeEncode(a.objoid, indent, out)
      out.write(",")
      out.write(""""classoid":""")
      JsonEncoder.long.unsafeEncode(a.classoid, indent, out)
      out.write("}")
    }
  }
  implicit lazy val ordering: Ordering[PgShdescriptionId] = Ordering.by(x => (x.objoid, x.classoid))
}
