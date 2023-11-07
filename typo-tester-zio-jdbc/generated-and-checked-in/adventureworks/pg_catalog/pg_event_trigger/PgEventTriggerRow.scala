/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_event_trigger

import java.sql.ResultSet
import zio.jdbc.JdbcDecoder
import zio.json.JsonDecoder
import zio.json.JsonEncoder
import zio.json.ast.Json
import zio.json.internal.Write

case class PgEventTriggerRow(
  oid: PgEventTriggerId,
  evtname: String,
  evtevent: String,
  evtowner: /* oid */ Long,
  evtfoid: /* oid */ Long,
  evtenabled: String,
  evttags: Option[Array[String]]
)

object PgEventTriggerRow {
  implicit lazy val jdbcDecoder: JdbcDecoder[PgEventTriggerRow] = new JdbcDecoder[PgEventTriggerRow] {
    override def unsafeDecode(columIndex: Int, rs: ResultSet): (Int, PgEventTriggerRow) =
      columIndex + 6 ->
        PgEventTriggerRow(
          oid = PgEventTriggerId.jdbcDecoder.unsafeDecode(columIndex + 0, rs)._2,
          evtname = JdbcDecoder.stringDecoder.unsafeDecode(columIndex + 1, rs)._2,
          evtevent = JdbcDecoder.stringDecoder.unsafeDecode(columIndex + 2, rs)._2,
          evtowner = JdbcDecoder.longDecoder.unsafeDecode(columIndex + 3, rs)._2,
          evtfoid = JdbcDecoder.longDecoder.unsafeDecode(columIndex + 4, rs)._2,
          evtenabled = JdbcDecoder.stringDecoder.unsafeDecode(columIndex + 5, rs)._2,
          evttags = JdbcDecoder.optionDecoder(adventureworks.StringArrayDecoder).unsafeDecode(columIndex + 6, rs)._2
        )
  }
  implicit lazy val jsonDecoder: JsonDecoder[PgEventTriggerRow] = JsonDecoder[Json.Obj].mapOrFail { jsonObj =>
    val oid = jsonObj.get("oid").toRight("Missing field 'oid'").flatMap(_.as(PgEventTriggerId.jsonDecoder))
    val evtname = jsonObj.get("evtname").toRight("Missing field 'evtname'").flatMap(_.as(JsonDecoder.string))
    val evtevent = jsonObj.get("evtevent").toRight("Missing field 'evtevent'").flatMap(_.as(JsonDecoder.string))
    val evtowner = jsonObj.get("evtowner").toRight("Missing field 'evtowner'").flatMap(_.as(JsonDecoder.long))
    val evtfoid = jsonObj.get("evtfoid").toRight("Missing field 'evtfoid'").flatMap(_.as(JsonDecoder.long))
    val evtenabled = jsonObj.get("evtenabled").toRight("Missing field 'evtenabled'").flatMap(_.as(JsonDecoder.string))
    val evttags = jsonObj.get("evttags").fold[Either[String, Option[Array[String]]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.array[String](JsonDecoder.string, implicitly))))
    if (oid.isRight && evtname.isRight && evtevent.isRight && evtowner.isRight && evtfoid.isRight && evtenabled.isRight && evttags.isRight)
      Right(PgEventTriggerRow(oid = oid.toOption.get, evtname = evtname.toOption.get, evtevent = evtevent.toOption.get, evtowner = evtowner.toOption.get, evtfoid = evtfoid.toOption.get, evtenabled = evtenabled.toOption.get, evttags = evttags.toOption.get))
    else Left(List[Either[String, Any]](oid, evtname, evtevent, evtowner, evtfoid, evtenabled, evttags).flatMap(_.left.toOption).mkString(", "))
  }
  implicit lazy val jsonEncoder: JsonEncoder[PgEventTriggerRow] = new JsonEncoder[PgEventTriggerRow] {
    override def unsafeEncode(a: PgEventTriggerRow, indent: Option[Int], out: Write): Unit = {
      out.write("{")
      out.write(""""oid":""")
      PgEventTriggerId.jsonEncoder.unsafeEncode(a.oid, indent, out)
      out.write(",")
      out.write(""""evtname":""")
      JsonEncoder.string.unsafeEncode(a.evtname, indent, out)
      out.write(",")
      out.write(""""evtevent":""")
      JsonEncoder.string.unsafeEncode(a.evtevent, indent, out)
      out.write(",")
      out.write(""""evtowner":""")
      JsonEncoder.long.unsafeEncode(a.evtowner, indent, out)
      out.write(",")
      out.write(""""evtfoid":""")
      JsonEncoder.long.unsafeEncode(a.evtfoid, indent, out)
      out.write(",")
      out.write(""""evtenabled":""")
      JsonEncoder.string.unsafeEncode(a.evtenabled, indent, out)
      out.write(",")
      out.write(""""evttags":""")
      JsonEncoder.option(JsonEncoder.array[String](JsonEncoder.string, implicitly)).unsafeEncode(a.evttags, indent, out)
      out.write("}")
    }
  }
}
