/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_stat_subscription

import adventureworks.customtypes.TypoOffsetDateTime
import doobie.enumerated.Nullability
import doobie.util.Read
import doobie.util.meta.Meta
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet

case class PgStatSubscriptionViewRow(
  subid: /* oid */ Long,
  subname: String,
  pid: Option[Int],
  relid: Option[/* oid */ Long],
  receivedLsn: Option[/* pg_lsn */ Long],
  lastMsgSendTime: Option[TypoOffsetDateTime],
  lastMsgReceiptTime: Option[TypoOffsetDateTime],
  latestEndLsn: Option[/* pg_lsn */ Long],
  latestEndTime: Option[TypoOffsetDateTime]
)

object PgStatSubscriptionViewRow {
  implicit lazy val decoder: Decoder[PgStatSubscriptionViewRow] = Decoder.forProduct9[PgStatSubscriptionViewRow, /* oid */ Long, String, Option[Int], Option[/* oid */ Long], Option[/* pg_lsn */ Long], Option[TypoOffsetDateTime], Option[TypoOffsetDateTime], Option[/* pg_lsn */ Long], Option[TypoOffsetDateTime]]("subid", "subname", "pid", "relid", "received_lsn", "last_msg_send_time", "last_msg_receipt_time", "latest_end_lsn", "latest_end_time")(PgStatSubscriptionViewRow.apply)(Decoder.decodeLong, Decoder.decodeString, Decoder.decodeOption(Decoder.decodeInt), Decoder.decodeOption(Decoder.decodeLong), Decoder.decodeOption(Decoder.decodeLong), Decoder.decodeOption(TypoOffsetDateTime.decoder), Decoder.decodeOption(TypoOffsetDateTime.decoder), Decoder.decodeOption(Decoder.decodeLong), Decoder.decodeOption(TypoOffsetDateTime.decoder))
  implicit lazy val encoder: Encoder[PgStatSubscriptionViewRow] = Encoder.forProduct9[PgStatSubscriptionViewRow, /* oid */ Long, String, Option[Int], Option[/* oid */ Long], Option[/* pg_lsn */ Long], Option[TypoOffsetDateTime], Option[TypoOffsetDateTime], Option[/* pg_lsn */ Long], Option[TypoOffsetDateTime]]("subid", "subname", "pid", "relid", "received_lsn", "last_msg_send_time", "last_msg_receipt_time", "latest_end_lsn", "latest_end_time")(x => (x.subid, x.subname, x.pid, x.relid, x.receivedLsn, x.lastMsgSendTime, x.lastMsgReceiptTime, x.latestEndLsn, x.latestEndTime))(Encoder.encodeLong, Encoder.encodeString, Encoder.encodeOption(Encoder.encodeInt), Encoder.encodeOption(Encoder.encodeLong), Encoder.encodeOption(Encoder.encodeLong), Encoder.encodeOption(TypoOffsetDateTime.encoder), Encoder.encodeOption(TypoOffsetDateTime.encoder), Encoder.encodeOption(Encoder.encodeLong), Encoder.encodeOption(TypoOffsetDateTime.encoder))
  implicit lazy val read: Read[PgStatSubscriptionViewRow] = new Read[PgStatSubscriptionViewRow](
    gets = List(
      (Meta.LongMeta.get, Nullability.NoNulls),
      (Meta.StringMeta.get, Nullability.NoNulls),
      (Meta.IntMeta.get, Nullability.Nullable),
      (Meta.LongMeta.get, Nullability.Nullable),
      (Meta.LongMeta.get, Nullability.Nullable),
      (TypoOffsetDateTime.get, Nullability.Nullable),
      (TypoOffsetDateTime.get, Nullability.Nullable),
      (Meta.LongMeta.get, Nullability.Nullable),
      (TypoOffsetDateTime.get, Nullability.Nullable)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => PgStatSubscriptionViewRow(
      subid = Meta.LongMeta.get.unsafeGetNonNullable(rs, i + 0),
      subname = Meta.StringMeta.get.unsafeGetNonNullable(rs, i + 1),
      pid = Meta.IntMeta.get.unsafeGetNullable(rs, i + 2),
      relid = Meta.LongMeta.get.unsafeGetNullable(rs, i + 3),
      receivedLsn = Meta.LongMeta.get.unsafeGetNullable(rs, i + 4),
      lastMsgSendTime = TypoOffsetDateTime.get.unsafeGetNullable(rs, i + 5),
      lastMsgReceiptTime = TypoOffsetDateTime.get.unsafeGetNullable(rs, i + 6),
      latestEndLsn = Meta.LongMeta.get.unsafeGetNullable(rs, i + 7),
      latestEndTime = TypoOffsetDateTime.get.unsafeGetNullable(rs, i + 8)
    )
  )
}
