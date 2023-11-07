/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_stat_xact_sys_tables

import adventureworks.pg_catalog.pg_class.PgClassId
import java.sql.ResultSet
import zio.jdbc.JdbcDecoder
import zio.json.JsonDecoder
import zio.json.JsonEncoder
import zio.json.ast.Json
import zio.json.internal.Write

case class PgStatXactSysTablesViewRow(
  /** Points to [[pg_stat_xact_all_tables.PgStatXactAllTablesViewRow.relid]] */
  relid: Option[PgClassId],
  /** Points to [[pg_stat_xact_all_tables.PgStatXactAllTablesViewRow.schemaname]] */
  schemaname: Option[String],
  /** Points to [[pg_stat_xact_all_tables.PgStatXactAllTablesViewRow.relname]] */
  relname: Option[String],
  /** Points to [[pg_stat_xact_all_tables.PgStatXactAllTablesViewRow.seqScan]] */
  seqScan: Option[/* nullability unknown */ Long],
  /** Points to [[pg_stat_xact_all_tables.PgStatXactAllTablesViewRow.seqTupRead]] */
  seqTupRead: Option[/* nullability unknown */ Long],
  /** Points to [[pg_stat_xact_all_tables.PgStatXactAllTablesViewRow.idxScan]] */
  idxScan: Option[/* nullability unknown */ Long],
  /** Points to [[pg_stat_xact_all_tables.PgStatXactAllTablesViewRow.idxTupFetch]] */
  idxTupFetch: Option[/* nullability unknown */ Long],
  /** Points to [[pg_stat_xact_all_tables.PgStatXactAllTablesViewRow.nTupIns]] */
  nTupIns: Option[/* nullability unknown */ Long],
  /** Points to [[pg_stat_xact_all_tables.PgStatXactAllTablesViewRow.nTupUpd]] */
  nTupUpd: Option[/* nullability unknown */ Long],
  /** Points to [[pg_stat_xact_all_tables.PgStatXactAllTablesViewRow.nTupDel]] */
  nTupDel: Option[/* nullability unknown */ Long],
  /** Points to [[pg_stat_xact_all_tables.PgStatXactAllTablesViewRow.nTupHotUpd]] */
  nTupHotUpd: Option[/* nullability unknown */ Long]
)

object PgStatXactSysTablesViewRow {
  implicit lazy val jdbcDecoder: JdbcDecoder[PgStatXactSysTablesViewRow] = new JdbcDecoder[PgStatXactSysTablesViewRow] {
    override def unsafeDecode(columIndex: Int, rs: ResultSet): (Int, PgStatXactSysTablesViewRow) =
      columIndex + 10 ->
        PgStatXactSysTablesViewRow(
          relid = JdbcDecoder.optionDecoder(PgClassId.jdbcDecoder).unsafeDecode(columIndex + 0, rs)._2,
          schemaname = JdbcDecoder.optionDecoder(JdbcDecoder.stringDecoder).unsafeDecode(columIndex + 1, rs)._2,
          relname = JdbcDecoder.optionDecoder(JdbcDecoder.stringDecoder).unsafeDecode(columIndex + 2, rs)._2,
          seqScan = JdbcDecoder.optionDecoder(JdbcDecoder.longDecoder).unsafeDecode(columIndex + 3, rs)._2,
          seqTupRead = JdbcDecoder.optionDecoder(JdbcDecoder.longDecoder).unsafeDecode(columIndex + 4, rs)._2,
          idxScan = JdbcDecoder.optionDecoder(JdbcDecoder.longDecoder).unsafeDecode(columIndex + 5, rs)._2,
          idxTupFetch = JdbcDecoder.optionDecoder(JdbcDecoder.longDecoder).unsafeDecode(columIndex + 6, rs)._2,
          nTupIns = JdbcDecoder.optionDecoder(JdbcDecoder.longDecoder).unsafeDecode(columIndex + 7, rs)._2,
          nTupUpd = JdbcDecoder.optionDecoder(JdbcDecoder.longDecoder).unsafeDecode(columIndex + 8, rs)._2,
          nTupDel = JdbcDecoder.optionDecoder(JdbcDecoder.longDecoder).unsafeDecode(columIndex + 9, rs)._2,
          nTupHotUpd = JdbcDecoder.optionDecoder(JdbcDecoder.longDecoder).unsafeDecode(columIndex + 10, rs)._2
        )
  }
  implicit lazy val jsonDecoder: JsonDecoder[PgStatXactSysTablesViewRow] = JsonDecoder[Json.Obj].mapOrFail { jsonObj =>
    val relid = jsonObj.get("relid").fold[Either[String, Option[PgClassId]]](Right(None))(_.as(JsonDecoder.option(PgClassId.jsonDecoder)))
    val schemaname = jsonObj.get("schemaname").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.string)))
    val relname = jsonObj.get("relname").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.string)))
    val seqScan = jsonObj.get("seq_scan").fold[Either[String, Option[Long]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.long)))
    val seqTupRead = jsonObj.get("seq_tup_read").fold[Either[String, Option[Long]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.long)))
    val idxScan = jsonObj.get("idx_scan").fold[Either[String, Option[Long]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.long)))
    val idxTupFetch = jsonObj.get("idx_tup_fetch").fold[Either[String, Option[Long]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.long)))
    val nTupIns = jsonObj.get("n_tup_ins").fold[Either[String, Option[Long]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.long)))
    val nTupUpd = jsonObj.get("n_tup_upd").fold[Either[String, Option[Long]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.long)))
    val nTupDel = jsonObj.get("n_tup_del").fold[Either[String, Option[Long]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.long)))
    val nTupHotUpd = jsonObj.get("n_tup_hot_upd").fold[Either[String, Option[Long]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.long)))
    if (relid.isRight && schemaname.isRight && relname.isRight && seqScan.isRight && seqTupRead.isRight && idxScan.isRight && idxTupFetch.isRight && nTupIns.isRight && nTupUpd.isRight && nTupDel.isRight && nTupHotUpd.isRight)
      Right(PgStatXactSysTablesViewRow(relid = relid.toOption.get, schemaname = schemaname.toOption.get, relname = relname.toOption.get, seqScan = seqScan.toOption.get, seqTupRead = seqTupRead.toOption.get, idxScan = idxScan.toOption.get, idxTupFetch = idxTupFetch.toOption.get, nTupIns = nTupIns.toOption.get, nTupUpd = nTupUpd.toOption.get, nTupDel = nTupDel.toOption.get, nTupHotUpd = nTupHotUpd.toOption.get))
    else Left(List[Either[String, Any]](relid, schemaname, relname, seqScan, seqTupRead, idxScan, idxTupFetch, nTupIns, nTupUpd, nTupDel, nTupHotUpd).flatMap(_.left.toOption).mkString(", "))
  }
  implicit lazy val jsonEncoder: JsonEncoder[PgStatXactSysTablesViewRow] = new JsonEncoder[PgStatXactSysTablesViewRow] {
    override def unsafeEncode(a: PgStatXactSysTablesViewRow, indent: Option[Int], out: Write): Unit = {
      out.write("{")
      out.write(""""relid":""")
      JsonEncoder.option(PgClassId.jsonEncoder).unsafeEncode(a.relid, indent, out)
      out.write(",")
      out.write(""""schemaname":""")
      JsonEncoder.option(JsonEncoder.string).unsafeEncode(a.schemaname, indent, out)
      out.write(",")
      out.write(""""relname":""")
      JsonEncoder.option(JsonEncoder.string).unsafeEncode(a.relname, indent, out)
      out.write(",")
      out.write(""""seq_scan":""")
      JsonEncoder.option(JsonEncoder.long).unsafeEncode(a.seqScan, indent, out)
      out.write(",")
      out.write(""""seq_tup_read":""")
      JsonEncoder.option(JsonEncoder.long).unsafeEncode(a.seqTupRead, indent, out)
      out.write(",")
      out.write(""""idx_scan":""")
      JsonEncoder.option(JsonEncoder.long).unsafeEncode(a.idxScan, indent, out)
      out.write(",")
      out.write(""""idx_tup_fetch":""")
      JsonEncoder.option(JsonEncoder.long).unsafeEncode(a.idxTupFetch, indent, out)
      out.write(",")
      out.write(""""n_tup_ins":""")
      JsonEncoder.option(JsonEncoder.long).unsafeEncode(a.nTupIns, indent, out)
      out.write(",")
      out.write(""""n_tup_upd":""")
      JsonEncoder.option(JsonEncoder.long).unsafeEncode(a.nTupUpd, indent, out)
      out.write(",")
      out.write(""""n_tup_del":""")
      JsonEncoder.option(JsonEncoder.long).unsafeEncode(a.nTupDel, indent, out)
      out.write(",")
      out.write(""""n_tup_hot_upd":""")
      JsonEncoder.option(JsonEncoder.long).unsafeEncode(a.nTupHotUpd, indent, out)
      out.write("}")
    }
  }
}
