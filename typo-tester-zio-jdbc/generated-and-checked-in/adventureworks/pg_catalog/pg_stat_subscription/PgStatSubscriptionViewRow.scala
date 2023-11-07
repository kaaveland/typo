/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_stat_subscription

import adventureworks.customtypes.TypoInstant
import adventureworks.pg_catalog.pg_subscription.PgSubscriptionId
import java.sql.ResultSet
import zio.jdbc.JdbcDecoder
import zio.json.JsonDecoder
import zio.json.JsonEncoder
import zio.json.ast.Json
import zio.json.internal.Write

case class PgStatSubscriptionViewRow(
  /** Points to [[pg_subscription.PgSubscriptionRow.oid]] */
  subid: PgSubscriptionId,
  /** Points to [[pg_subscription.PgSubscriptionRow.subname]] */
  subname: String,
  pid: Option[Int],
  relid: Option[/* oid */ Long],
  receivedLsn: Option[/* pg_lsn */ Long],
  lastMsgSendTime: Option[TypoInstant],
  lastMsgReceiptTime: Option[TypoInstant],
  latestEndLsn: Option[/* pg_lsn */ Long],
  latestEndTime: Option[TypoInstant]
)

object PgStatSubscriptionViewRow {
  implicit lazy val jdbcDecoder: JdbcDecoder[PgStatSubscriptionViewRow] = new JdbcDecoder[PgStatSubscriptionViewRow] {
    override def unsafeDecode(columIndex: Int, rs: ResultSet): (Int, PgStatSubscriptionViewRow) =
      columIndex + 8 ->
        PgStatSubscriptionViewRow(
          subid = PgSubscriptionId.jdbcDecoder.unsafeDecode(columIndex + 0, rs)._2,
          subname = JdbcDecoder.stringDecoder.unsafeDecode(columIndex + 1, rs)._2,
          pid = JdbcDecoder.optionDecoder(JdbcDecoder.intDecoder).unsafeDecode(columIndex + 2, rs)._2,
          relid = JdbcDecoder.optionDecoder(JdbcDecoder.longDecoder).unsafeDecode(columIndex + 3, rs)._2,
          receivedLsn = JdbcDecoder.optionDecoder(JdbcDecoder.longDecoder).unsafeDecode(columIndex + 4, rs)._2,
          lastMsgSendTime = JdbcDecoder.optionDecoder(TypoInstant.jdbcDecoder).unsafeDecode(columIndex + 5, rs)._2,
          lastMsgReceiptTime = JdbcDecoder.optionDecoder(TypoInstant.jdbcDecoder).unsafeDecode(columIndex + 6, rs)._2,
          latestEndLsn = JdbcDecoder.optionDecoder(JdbcDecoder.longDecoder).unsafeDecode(columIndex + 7, rs)._2,
          latestEndTime = JdbcDecoder.optionDecoder(TypoInstant.jdbcDecoder).unsafeDecode(columIndex + 8, rs)._2
        )
  }
  implicit lazy val jsonDecoder: JsonDecoder[PgStatSubscriptionViewRow] = JsonDecoder[Json.Obj].mapOrFail { jsonObj =>
    val subid = jsonObj.get("subid").toRight("Missing field 'subid'").flatMap(_.as(PgSubscriptionId.jsonDecoder))
    val subname = jsonObj.get("subname").toRight("Missing field 'subname'").flatMap(_.as(JsonDecoder.string))
    val pid = jsonObj.get("pid").fold[Either[String, Option[Int]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.int)))
    val relid = jsonObj.get("relid").fold[Either[String, Option[Long]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.long)))
    val receivedLsn = jsonObj.get("received_lsn").fold[Either[String, Option[Long]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.long)))
    val lastMsgSendTime = jsonObj.get("last_msg_send_time").fold[Either[String, Option[TypoInstant]]](Right(None))(_.as(JsonDecoder.option(TypoInstant.jsonDecoder)))
    val lastMsgReceiptTime = jsonObj.get("last_msg_receipt_time").fold[Either[String, Option[TypoInstant]]](Right(None))(_.as(JsonDecoder.option(TypoInstant.jsonDecoder)))
    val latestEndLsn = jsonObj.get("latest_end_lsn").fold[Either[String, Option[Long]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.long)))
    val latestEndTime = jsonObj.get("latest_end_time").fold[Either[String, Option[TypoInstant]]](Right(None))(_.as(JsonDecoder.option(TypoInstant.jsonDecoder)))
    if (subid.isRight && subname.isRight && pid.isRight && relid.isRight && receivedLsn.isRight && lastMsgSendTime.isRight && lastMsgReceiptTime.isRight && latestEndLsn.isRight && latestEndTime.isRight)
      Right(PgStatSubscriptionViewRow(subid = subid.toOption.get, subname = subname.toOption.get, pid = pid.toOption.get, relid = relid.toOption.get, receivedLsn = receivedLsn.toOption.get, lastMsgSendTime = lastMsgSendTime.toOption.get, lastMsgReceiptTime = lastMsgReceiptTime.toOption.get, latestEndLsn = latestEndLsn.toOption.get, latestEndTime = latestEndTime.toOption.get))
    else Left(List[Either[String, Any]](subid, subname, pid, relid, receivedLsn, lastMsgSendTime, lastMsgReceiptTime, latestEndLsn, latestEndTime).flatMap(_.left.toOption).mkString(", "))
  }
  implicit lazy val jsonEncoder: JsonEncoder[PgStatSubscriptionViewRow] = new JsonEncoder[PgStatSubscriptionViewRow] {
    override def unsafeEncode(a: PgStatSubscriptionViewRow, indent: Option[Int], out: Write): Unit = {
      out.write("{")
      out.write(""""subid":""")
      PgSubscriptionId.jsonEncoder.unsafeEncode(a.subid, indent, out)
      out.write(",")
      out.write(""""subname":""")
      JsonEncoder.string.unsafeEncode(a.subname, indent, out)
      out.write(",")
      out.write(""""pid":""")
      JsonEncoder.option(JsonEncoder.int).unsafeEncode(a.pid, indent, out)
      out.write(",")
      out.write(""""relid":""")
      JsonEncoder.option(JsonEncoder.long).unsafeEncode(a.relid, indent, out)
      out.write(",")
      out.write(""""received_lsn":""")
      JsonEncoder.option(JsonEncoder.long).unsafeEncode(a.receivedLsn, indent, out)
      out.write(",")
      out.write(""""last_msg_send_time":""")
      JsonEncoder.option(TypoInstant.jsonEncoder).unsafeEncode(a.lastMsgSendTime, indent, out)
      out.write(",")
      out.write(""""last_msg_receipt_time":""")
      JsonEncoder.option(TypoInstant.jsonEncoder).unsafeEncode(a.lastMsgReceiptTime, indent, out)
      out.write(",")
      out.write(""""latest_end_lsn":""")
      JsonEncoder.option(JsonEncoder.long).unsafeEncode(a.latestEndLsn, indent, out)
      out.write(",")
      out.write(""""latest_end_time":""")
      JsonEncoder.option(TypoInstant.jsonEncoder).unsafeEncode(a.latestEndTime, indent, out)
      out.write("}")
    }
  }
}
