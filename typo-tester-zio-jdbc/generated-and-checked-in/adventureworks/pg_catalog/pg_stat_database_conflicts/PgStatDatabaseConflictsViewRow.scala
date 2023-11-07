/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_stat_database_conflicts

import adventureworks.pg_catalog.pg_database.PgDatabaseId
import java.sql.ResultSet
import zio.jdbc.JdbcDecoder
import zio.json.JsonDecoder
import zio.json.JsonEncoder
import zio.json.ast.Json
import zio.json.internal.Write

case class PgStatDatabaseConflictsViewRow(
  /** Points to [[pg_database.PgDatabaseRow.oid]] */
  datid: PgDatabaseId,
  /** Points to [[pg_database.PgDatabaseRow.datname]] */
  datname: String,
  conflTablespace: /* nullability unknown */ Option[Long],
  conflLock: /* nullability unknown */ Option[Long],
  conflSnapshot: /* nullability unknown */ Option[Long],
  conflBufferpin: /* nullability unknown */ Option[Long],
  conflDeadlock: /* nullability unknown */ Option[Long]
)

object PgStatDatabaseConflictsViewRow {
  implicit lazy val jdbcDecoder: JdbcDecoder[PgStatDatabaseConflictsViewRow] = new JdbcDecoder[PgStatDatabaseConflictsViewRow] {
    override def unsafeDecode(columIndex: Int, rs: ResultSet): (Int, PgStatDatabaseConflictsViewRow) =
      columIndex + 6 ->
        PgStatDatabaseConflictsViewRow(
          datid = PgDatabaseId.jdbcDecoder.unsafeDecode(columIndex + 0, rs)._2,
          datname = JdbcDecoder.stringDecoder.unsafeDecode(columIndex + 1, rs)._2,
          conflTablespace = JdbcDecoder.optionDecoder(JdbcDecoder.longDecoder).unsafeDecode(columIndex + 2, rs)._2,
          conflLock = JdbcDecoder.optionDecoder(JdbcDecoder.longDecoder).unsafeDecode(columIndex + 3, rs)._2,
          conflSnapshot = JdbcDecoder.optionDecoder(JdbcDecoder.longDecoder).unsafeDecode(columIndex + 4, rs)._2,
          conflBufferpin = JdbcDecoder.optionDecoder(JdbcDecoder.longDecoder).unsafeDecode(columIndex + 5, rs)._2,
          conflDeadlock = JdbcDecoder.optionDecoder(JdbcDecoder.longDecoder).unsafeDecode(columIndex + 6, rs)._2
        )
  }
  implicit lazy val jsonDecoder: JsonDecoder[PgStatDatabaseConflictsViewRow] = JsonDecoder[Json.Obj].mapOrFail { jsonObj =>
    val datid = jsonObj.get("datid").toRight("Missing field 'datid'").flatMap(_.as(PgDatabaseId.jsonDecoder))
    val datname = jsonObj.get("datname").toRight("Missing field 'datname'").flatMap(_.as(JsonDecoder.string))
    val conflTablespace = jsonObj.get("confl_tablespace").fold[Either[String, Option[Long]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.long)))
    val conflLock = jsonObj.get("confl_lock").fold[Either[String, Option[Long]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.long)))
    val conflSnapshot = jsonObj.get("confl_snapshot").fold[Either[String, Option[Long]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.long)))
    val conflBufferpin = jsonObj.get("confl_bufferpin").fold[Either[String, Option[Long]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.long)))
    val conflDeadlock = jsonObj.get("confl_deadlock").fold[Either[String, Option[Long]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.long)))
    if (datid.isRight && datname.isRight && conflTablespace.isRight && conflLock.isRight && conflSnapshot.isRight && conflBufferpin.isRight && conflDeadlock.isRight)
      Right(PgStatDatabaseConflictsViewRow(datid = datid.toOption.get, datname = datname.toOption.get, conflTablespace = conflTablespace.toOption.get, conflLock = conflLock.toOption.get, conflSnapshot = conflSnapshot.toOption.get, conflBufferpin = conflBufferpin.toOption.get, conflDeadlock = conflDeadlock.toOption.get))
    else Left(List[Either[String, Any]](datid, datname, conflTablespace, conflLock, conflSnapshot, conflBufferpin, conflDeadlock).flatMap(_.left.toOption).mkString(", "))
  }
  implicit lazy val jsonEncoder: JsonEncoder[PgStatDatabaseConflictsViewRow] = new JsonEncoder[PgStatDatabaseConflictsViewRow] {
    override def unsafeEncode(a: PgStatDatabaseConflictsViewRow, indent: Option[Int], out: Write): Unit = {
      out.write("{")
      out.write(""""datid":""")
      PgDatabaseId.jsonEncoder.unsafeEncode(a.datid, indent, out)
      out.write(",")
      out.write(""""datname":""")
      JsonEncoder.string.unsafeEncode(a.datname, indent, out)
      out.write(",")
      out.write(""""confl_tablespace":""")
      JsonEncoder.option(JsonEncoder.long).unsafeEncode(a.conflTablespace, indent, out)
      out.write(",")
      out.write(""""confl_lock":""")
      JsonEncoder.option(JsonEncoder.long).unsafeEncode(a.conflLock, indent, out)
      out.write(",")
      out.write(""""confl_snapshot":""")
      JsonEncoder.option(JsonEncoder.long).unsafeEncode(a.conflSnapshot, indent, out)
      out.write(",")
      out.write(""""confl_bufferpin":""")
      JsonEncoder.option(JsonEncoder.long).unsafeEncode(a.conflBufferpin, indent, out)
      out.write(",")
      out.write(""""confl_deadlock":""")
      JsonEncoder.option(JsonEncoder.long).unsafeEncode(a.conflDeadlock, indent, out)
      out.write("}")
    }
  }
}
