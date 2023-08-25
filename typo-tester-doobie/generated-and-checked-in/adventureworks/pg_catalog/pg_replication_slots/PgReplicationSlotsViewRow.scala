/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_replication_slots

import adventureworks.customtypes.TypoXid
import doobie.enumerated.Nullability
import doobie.util.Read
import doobie.util.meta.Meta
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet

case class PgReplicationSlotsViewRow(
  slotName: String,
  plugin: String,
  slotType: String,
  datoid: /* oid */ Long,
  database: Option[String],
  temporary: Boolean,
  active: Boolean,
  activePid: Int,
  xmin: TypoXid,
  catalogXmin: TypoXid,
  restartLsn: /* pg_lsn */ Long,
  confirmedFlushLsn: /* pg_lsn */ Long,
  walStatus: String,
  safeWalSize: Long,
  twoPhase: Boolean
)

object PgReplicationSlotsViewRow {
  implicit lazy val decoder: Decoder[PgReplicationSlotsViewRow] = Decoder.forProduct15[PgReplicationSlotsViewRow, String, String, String, /* oid */ Long, Option[String], Boolean, Boolean, Int, TypoXid, TypoXid, /* pg_lsn */ Long, /* pg_lsn */ Long, String, Long, Boolean]("slot_name", "plugin", "slot_type", "datoid", "database", "temporary", "active", "active_pid", "xmin", "catalog_xmin", "restart_lsn", "confirmed_flush_lsn", "wal_status", "safe_wal_size", "two_phase")(PgReplicationSlotsViewRow.apply)(Decoder.decodeString, Decoder.decodeString, Decoder.decodeString, Decoder.decodeLong, Decoder.decodeOption(Decoder.decodeString), Decoder.decodeBoolean, Decoder.decodeBoolean, Decoder.decodeInt, TypoXid.decoder, TypoXid.decoder, Decoder.decodeLong, Decoder.decodeLong, Decoder.decodeString, Decoder.decodeLong, Decoder.decodeBoolean)
  implicit lazy val encoder: Encoder[PgReplicationSlotsViewRow] = Encoder.forProduct15[PgReplicationSlotsViewRow, String, String, String, /* oid */ Long, Option[String], Boolean, Boolean, Int, TypoXid, TypoXid, /* pg_lsn */ Long, /* pg_lsn */ Long, String, Long, Boolean]("slot_name", "plugin", "slot_type", "datoid", "database", "temporary", "active", "active_pid", "xmin", "catalog_xmin", "restart_lsn", "confirmed_flush_lsn", "wal_status", "safe_wal_size", "two_phase")(x => (x.slotName, x.plugin, x.slotType, x.datoid, x.database, x.temporary, x.active, x.activePid, x.xmin, x.catalogXmin, x.restartLsn, x.confirmedFlushLsn, x.walStatus, x.safeWalSize, x.twoPhase))(Encoder.encodeString, Encoder.encodeString, Encoder.encodeString, Encoder.encodeLong, Encoder.encodeOption(Encoder.encodeString), Encoder.encodeBoolean, Encoder.encodeBoolean, Encoder.encodeInt, TypoXid.encoder, TypoXid.encoder, Encoder.encodeLong, Encoder.encodeLong, Encoder.encodeString, Encoder.encodeLong, Encoder.encodeBoolean)
  implicit lazy val read: Read[PgReplicationSlotsViewRow] = new Read[PgReplicationSlotsViewRow](
    gets = List(
      (Meta.StringMeta.get, Nullability.NoNulls),
      (Meta.StringMeta.get, Nullability.NoNulls),
      (Meta.StringMeta.get, Nullability.NoNulls),
      (Meta.LongMeta.get, Nullability.NoNulls),
      (Meta.StringMeta.get, Nullability.Nullable),
      (Meta.BooleanMeta.get, Nullability.NoNulls),
      (Meta.BooleanMeta.get, Nullability.NoNulls),
      (Meta.IntMeta.get, Nullability.NoNulls),
      (TypoXid.get, Nullability.NoNulls),
      (TypoXid.get, Nullability.NoNulls),
      (Meta.LongMeta.get, Nullability.NoNulls),
      (Meta.LongMeta.get, Nullability.NoNulls),
      (Meta.StringMeta.get, Nullability.NoNulls),
      (Meta.LongMeta.get, Nullability.NoNulls),
      (Meta.BooleanMeta.get, Nullability.NoNulls)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => PgReplicationSlotsViewRow(
      slotName = Meta.StringMeta.get.unsafeGetNonNullable(rs, i + 0),
      plugin = Meta.StringMeta.get.unsafeGetNonNullable(rs, i + 1),
      slotType = Meta.StringMeta.get.unsafeGetNonNullable(rs, i + 2),
      datoid = Meta.LongMeta.get.unsafeGetNonNullable(rs, i + 3),
      database = Meta.StringMeta.get.unsafeGetNullable(rs, i + 4),
      temporary = Meta.BooleanMeta.get.unsafeGetNonNullable(rs, i + 5),
      active = Meta.BooleanMeta.get.unsafeGetNonNullable(rs, i + 6),
      activePid = Meta.IntMeta.get.unsafeGetNonNullable(rs, i + 7),
      xmin = TypoXid.get.unsafeGetNonNullable(rs, i + 8),
      catalogXmin = TypoXid.get.unsafeGetNonNullable(rs, i + 9),
      restartLsn = Meta.LongMeta.get.unsafeGetNonNullable(rs, i + 10),
      confirmedFlushLsn = Meta.LongMeta.get.unsafeGetNonNullable(rs, i + 11),
      walStatus = Meta.StringMeta.get.unsafeGetNonNullable(rs, i + 12),
      safeWalSize = Meta.LongMeta.get.unsafeGetNonNullable(rs, i + 13),
      twoPhase = Meta.BooleanMeta.get.unsafeGetNonNullable(rs, i + 14)
    )
  )
}
