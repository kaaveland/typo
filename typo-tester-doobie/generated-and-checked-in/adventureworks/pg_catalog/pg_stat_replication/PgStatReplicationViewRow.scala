/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_stat_replication

import adventureworks.customtypes.TypoInet
import adventureworks.customtypes.TypoInterval
import adventureworks.customtypes.TypoOffsetDateTime
import adventureworks.customtypes.TypoXid
import doobie.enumerated.Nullability
import doobie.util.Read
import doobie.util.meta.Meta
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet

case class PgStatReplicationViewRow(
  pid: Int,
  usesysid: /* oid */ Long,
  usename: Option[String],
  applicationName: String,
  clientAddr: TypoInet,
  clientHostname: String,
  clientPort: Int,
  backendStart: TypoOffsetDateTime,
  backendXmin: TypoXid,
  state: String,
  sentLsn: /* pg_lsn */ Long,
  writeLsn: /* pg_lsn */ Long,
  flushLsn: /* pg_lsn */ Long,
  replayLsn: /* pg_lsn */ Long,
  writeLag: TypoInterval,
  flushLag: TypoInterval,
  replayLag: TypoInterval,
  syncPriority: Int,
  syncState: String,
  replyTime: TypoOffsetDateTime
)

object PgStatReplicationViewRow {
  implicit lazy val decoder: Decoder[PgStatReplicationViewRow] = Decoder.forProduct20[PgStatReplicationViewRow, Int, /* oid */ Long, Option[String], String, TypoInet, String, Int, TypoOffsetDateTime, TypoXid, String, /* pg_lsn */ Long, /* pg_lsn */ Long, /* pg_lsn */ Long, /* pg_lsn */ Long, TypoInterval, TypoInterval, TypoInterval, Int, String, TypoOffsetDateTime]("pid", "usesysid", "usename", "application_name", "client_addr", "client_hostname", "client_port", "backend_start", "backend_xmin", "state", "sent_lsn", "write_lsn", "flush_lsn", "replay_lsn", "write_lag", "flush_lag", "replay_lag", "sync_priority", "sync_state", "reply_time")(PgStatReplicationViewRow.apply)(Decoder.decodeInt, Decoder.decodeLong, Decoder.decodeOption(Decoder.decodeString), Decoder.decodeString, TypoInet.decoder, Decoder.decodeString, Decoder.decodeInt, TypoOffsetDateTime.decoder, TypoXid.decoder, Decoder.decodeString, Decoder.decodeLong, Decoder.decodeLong, Decoder.decodeLong, Decoder.decodeLong, TypoInterval.decoder, TypoInterval.decoder, TypoInterval.decoder, Decoder.decodeInt, Decoder.decodeString, TypoOffsetDateTime.decoder)
  implicit lazy val encoder: Encoder[PgStatReplicationViewRow] = Encoder.forProduct20[PgStatReplicationViewRow, Int, /* oid */ Long, Option[String], String, TypoInet, String, Int, TypoOffsetDateTime, TypoXid, String, /* pg_lsn */ Long, /* pg_lsn */ Long, /* pg_lsn */ Long, /* pg_lsn */ Long, TypoInterval, TypoInterval, TypoInterval, Int, String, TypoOffsetDateTime]("pid", "usesysid", "usename", "application_name", "client_addr", "client_hostname", "client_port", "backend_start", "backend_xmin", "state", "sent_lsn", "write_lsn", "flush_lsn", "replay_lsn", "write_lag", "flush_lag", "replay_lag", "sync_priority", "sync_state", "reply_time")(x => (x.pid, x.usesysid, x.usename, x.applicationName, x.clientAddr, x.clientHostname, x.clientPort, x.backendStart, x.backendXmin, x.state, x.sentLsn, x.writeLsn, x.flushLsn, x.replayLsn, x.writeLag, x.flushLag, x.replayLag, x.syncPriority, x.syncState, x.replyTime))(Encoder.encodeInt, Encoder.encodeLong, Encoder.encodeOption(Encoder.encodeString), Encoder.encodeString, TypoInet.encoder, Encoder.encodeString, Encoder.encodeInt, TypoOffsetDateTime.encoder, TypoXid.encoder, Encoder.encodeString, Encoder.encodeLong, Encoder.encodeLong, Encoder.encodeLong, Encoder.encodeLong, TypoInterval.encoder, TypoInterval.encoder, TypoInterval.encoder, Encoder.encodeInt, Encoder.encodeString, TypoOffsetDateTime.encoder)
  implicit lazy val read: Read[PgStatReplicationViewRow] = new Read[PgStatReplicationViewRow](
    gets = List(
      (Meta.IntMeta.get, Nullability.NoNulls),
      (Meta.LongMeta.get, Nullability.NoNulls),
      (Meta.StringMeta.get, Nullability.Nullable),
      (Meta.StringMeta.get, Nullability.NoNulls),
      (TypoInet.get, Nullability.NoNulls),
      (Meta.StringMeta.get, Nullability.NoNulls),
      (Meta.IntMeta.get, Nullability.NoNulls),
      (TypoOffsetDateTime.get, Nullability.NoNulls),
      (TypoXid.get, Nullability.NoNulls),
      (Meta.StringMeta.get, Nullability.NoNulls),
      (Meta.LongMeta.get, Nullability.NoNulls),
      (Meta.LongMeta.get, Nullability.NoNulls),
      (Meta.LongMeta.get, Nullability.NoNulls),
      (Meta.LongMeta.get, Nullability.NoNulls),
      (TypoInterval.get, Nullability.NoNulls),
      (TypoInterval.get, Nullability.NoNulls),
      (TypoInterval.get, Nullability.NoNulls),
      (Meta.IntMeta.get, Nullability.NoNulls),
      (Meta.StringMeta.get, Nullability.NoNulls),
      (TypoOffsetDateTime.get, Nullability.NoNulls)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => PgStatReplicationViewRow(
      pid = Meta.IntMeta.get.unsafeGetNonNullable(rs, i + 0),
      usesysid = Meta.LongMeta.get.unsafeGetNonNullable(rs, i + 1),
      usename = Meta.StringMeta.get.unsafeGetNullable(rs, i + 2),
      applicationName = Meta.StringMeta.get.unsafeGetNonNullable(rs, i + 3),
      clientAddr = TypoInet.get.unsafeGetNonNullable(rs, i + 4),
      clientHostname = Meta.StringMeta.get.unsafeGetNonNullable(rs, i + 5),
      clientPort = Meta.IntMeta.get.unsafeGetNonNullable(rs, i + 6),
      backendStart = TypoOffsetDateTime.get.unsafeGetNonNullable(rs, i + 7),
      backendXmin = TypoXid.get.unsafeGetNonNullable(rs, i + 8),
      state = Meta.StringMeta.get.unsafeGetNonNullable(rs, i + 9),
      sentLsn = Meta.LongMeta.get.unsafeGetNonNullable(rs, i + 10),
      writeLsn = Meta.LongMeta.get.unsafeGetNonNullable(rs, i + 11),
      flushLsn = Meta.LongMeta.get.unsafeGetNonNullable(rs, i + 12),
      replayLsn = Meta.LongMeta.get.unsafeGetNonNullable(rs, i + 13),
      writeLag = TypoInterval.get.unsafeGetNonNullable(rs, i + 14),
      flushLag = TypoInterval.get.unsafeGetNonNullable(rs, i + 15),
      replayLag = TypoInterval.get.unsafeGetNonNullable(rs, i + 16),
      syncPriority = Meta.IntMeta.get.unsafeGetNonNullable(rs, i + 17),
      syncState = Meta.StringMeta.get.unsafeGetNonNullable(rs, i + 18),
      replyTime = TypoOffsetDateTime.get.unsafeGetNonNullable(rs, i + 19)
    )
  )
}
