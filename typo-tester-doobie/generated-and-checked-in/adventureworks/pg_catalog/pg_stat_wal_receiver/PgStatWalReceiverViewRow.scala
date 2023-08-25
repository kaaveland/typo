/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_stat_wal_receiver

import adventureworks.customtypes.TypoOffsetDateTime
import doobie.enumerated.Nullability
import doobie.util.Read
import doobie.util.meta.Meta
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet

case class PgStatWalReceiverViewRow(
  pid: Int,
  status: String,
  receiveStartLsn: /* pg_lsn */ Long,
  receiveStartTli: Int,
  writtenLsn: /* pg_lsn */ Long,
  flushedLsn: /* pg_lsn */ Long,
  receivedTli: Int,
  lastMsgSendTime: TypoOffsetDateTime,
  lastMsgReceiptTime: TypoOffsetDateTime,
  latestEndLsn: /* pg_lsn */ Long,
  latestEndTime: TypoOffsetDateTime,
  slotName: String,
  senderHost: String,
  senderPort: Int,
  conninfo: String
)

object PgStatWalReceiverViewRow {
  implicit lazy val decoder: Decoder[PgStatWalReceiverViewRow] = Decoder.forProduct15[PgStatWalReceiverViewRow, Int, String, /* pg_lsn */ Long, Int, /* pg_lsn */ Long, /* pg_lsn */ Long, Int, TypoOffsetDateTime, TypoOffsetDateTime, /* pg_lsn */ Long, TypoOffsetDateTime, String, String, Int, String]("pid", "status", "receive_start_lsn", "receive_start_tli", "written_lsn", "flushed_lsn", "received_tli", "last_msg_send_time", "last_msg_receipt_time", "latest_end_lsn", "latest_end_time", "slot_name", "sender_host", "sender_port", "conninfo")(PgStatWalReceiverViewRow.apply)(Decoder.decodeInt, Decoder.decodeString, Decoder.decodeLong, Decoder.decodeInt, Decoder.decodeLong, Decoder.decodeLong, Decoder.decodeInt, TypoOffsetDateTime.decoder, TypoOffsetDateTime.decoder, Decoder.decodeLong, TypoOffsetDateTime.decoder, Decoder.decodeString, Decoder.decodeString, Decoder.decodeInt, Decoder.decodeString)
  implicit lazy val encoder: Encoder[PgStatWalReceiverViewRow] = Encoder.forProduct15[PgStatWalReceiverViewRow, Int, String, /* pg_lsn */ Long, Int, /* pg_lsn */ Long, /* pg_lsn */ Long, Int, TypoOffsetDateTime, TypoOffsetDateTime, /* pg_lsn */ Long, TypoOffsetDateTime, String, String, Int, String]("pid", "status", "receive_start_lsn", "receive_start_tli", "written_lsn", "flushed_lsn", "received_tli", "last_msg_send_time", "last_msg_receipt_time", "latest_end_lsn", "latest_end_time", "slot_name", "sender_host", "sender_port", "conninfo")(x => (x.pid, x.status, x.receiveStartLsn, x.receiveStartTli, x.writtenLsn, x.flushedLsn, x.receivedTli, x.lastMsgSendTime, x.lastMsgReceiptTime, x.latestEndLsn, x.latestEndTime, x.slotName, x.senderHost, x.senderPort, x.conninfo))(Encoder.encodeInt, Encoder.encodeString, Encoder.encodeLong, Encoder.encodeInt, Encoder.encodeLong, Encoder.encodeLong, Encoder.encodeInt, TypoOffsetDateTime.encoder, TypoOffsetDateTime.encoder, Encoder.encodeLong, TypoOffsetDateTime.encoder, Encoder.encodeString, Encoder.encodeString, Encoder.encodeInt, Encoder.encodeString)
  implicit lazy val read: Read[PgStatWalReceiverViewRow] = new Read[PgStatWalReceiverViewRow](
    gets = List(
      (Meta.IntMeta.get, Nullability.NoNulls),
      (Meta.StringMeta.get, Nullability.NoNulls),
      (Meta.LongMeta.get, Nullability.NoNulls),
      (Meta.IntMeta.get, Nullability.NoNulls),
      (Meta.LongMeta.get, Nullability.NoNulls),
      (Meta.LongMeta.get, Nullability.NoNulls),
      (Meta.IntMeta.get, Nullability.NoNulls),
      (TypoOffsetDateTime.get, Nullability.NoNulls),
      (TypoOffsetDateTime.get, Nullability.NoNulls),
      (Meta.LongMeta.get, Nullability.NoNulls),
      (TypoOffsetDateTime.get, Nullability.NoNulls),
      (Meta.StringMeta.get, Nullability.NoNulls),
      (Meta.StringMeta.get, Nullability.NoNulls),
      (Meta.IntMeta.get, Nullability.NoNulls),
      (Meta.StringMeta.get, Nullability.NoNulls)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => PgStatWalReceiverViewRow(
      pid = Meta.IntMeta.get.unsafeGetNonNullable(rs, i + 0),
      status = Meta.StringMeta.get.unsafeGetNonNullable(rs, i + 1),
      receiveStartLsn = Meta.LongMeta.get.unsafeGetNonNullable(rs, i + 2),
      receiveStartTli = Meta.IntMeta.get.unsafeGetNonNullable(rs, i + 3),
      writtenLsn = Meta.LongMeta.get.unsafeGetNonNullable(rs, i + 4),
      flushedLsn = Meta.LongMeta.get.unsafeGetNonNullable(rs, i + 5),
      receivedTli = Meta.IntMeta.get.unsafeGetNonNullable(rs, i + 6),
      lastMsgSendTime = TypoOffsetDateTime.get.unsafeGetNonNullable(rs, i + 7),
      lastMsgReceiptTime = TypoOffsetDateTime.get.unsafeGetNonNullable(rs, i + 8),
      latestEndLsn = Meta.LongMeta.get.unsafeGetNonNullable(rs, i + 9),
      latestEndTime = TypoOffsetDateTime.get.unsafeGetNonNullable(rs, i + 10),
      slotName = Meta.StringMeta.get.unsafeGetNonNullable(rs, i + 11),
      senderHost = Meta.StringMeta.get.unsafeGetNonNullable(rs, i + 12),
      senderPort = Meta.IntMeta.get.unsafeGetNonNullable(rs, i + 13),
      conninfo = Meta.StringMeta.get.unsafeGetNonNullable(rs, i + 14)
    )
  )
}
