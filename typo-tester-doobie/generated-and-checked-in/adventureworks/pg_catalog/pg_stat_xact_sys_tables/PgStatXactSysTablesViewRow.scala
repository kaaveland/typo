/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_stat_xact_sys_tables

import doobie.enumerated.Nullability
import doobie.util.Read
import doobie.util.meta.Meta
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet

case class PgStatXactSysTablesViewRow(
  /** Points to [[pg_stat_xact_all_tables.PgStatXactAllTablesViewRow.relid]] */
  relid: /* oid */ Long,
  /** Points to [[pg_stat_xact_all_tables.PgStatXactAllTablesViewRow.schemaname]] */
  schemaname: String,
  /** Points to [[pg_stat_xact_all_tables.PgStatXactAllTablesViewRow.relname]] */
  relname: String,
  /** Points to [[pg_stat_xact_all_tables.PgStatXactAllTablesViewRow.seqScan]] */
  seqScan: Long,
  /** Points to [[pg_stat_xact_all_tables.PgStatXactAllTablesViewRow.seqTupRead]] */
  seqTupRead: Long,
  /** Points to [[pg_stat_xact_all_tables.PgStatXactAllTablesViewRow.idxScan]] */
  idxScan: Long,
  /** Points to [[pg_stat_xact_all_tables.PgStatXactAllTablesViewRow.idxTupFetch]] */
  idxTupFetch: Long,
  /** Points to [[pg_stat_xact_all_tables.PgStatXactAllTablesViewRow.nTupIns]] */
  nTupIns: Long,
  /** Points to [[pg_stat_xact_all_tables.PgStatXactAllTablesViewRow.nTupUpd]] */
  nTupUpd: Long,
  /** Points to [[pg_stat_xact_all_tables.PgStatXactAllTablesViewRow.nTupDel]] */
  nTupDel: Long,
  /** Points to [[pg_stat_xact_all_tables.PgStatXactAllTablesViewRow.nTupHotUpd]] */
  nTupHotUpd: Long
)

object PgStatXactSysTablesViewRow {
  implicit lazy val decoder: Decoder[PgStatXactSysTablesViewRow] = Decoder.forProduct11[PgStatXactSysTablesViewRow, /* oid */ Long, String, String, Long, Long, Long, Long, Long, Long, Long, Long]("relid", "schemaname", "relname", "seq_scan", "seq_tup_read", "idx_scan", "idx_tup_fetch", "n_tup_ins", "n_tup_upd", "n_tup_del", "n_tup_hot_upd")(PgStatXactSysTablesViewRow.apply)(Decoder.decodeLong, Decoder.decodeString, Decoder.decodeString, Decoder.decodeLong, Decoder.decodeLong, Decoder.decodeLong, Decoder.decodeLong, Decoder.decodeLong, Decoder.decodeLong, Decoder.decodeLong, Decoder.decodeLong)
  implicit lazy val encoder: Encoder[PgStatXactSysTablesViewRow] = Encoder.forProduct11[PgStatXactSysTablesViewRow, /* oid */ Long, String, String, Long, Long, Long, Long, Long, Long, Long, Long]("relid", "schemaname", "relname", "seq_scan", "seq_tup_read", "idx_scan", "idx_tup_fetch", "n_tup_ins", "n_tup_upd", "n_tup_del", "n_tup_hot_upd")(x => (x.relid, x.schemaname, x.relname, x.seqScan, x.seqTupRead, x.idxScan, x.idxTupFetch, x.nTupIns, x.nTupUpd, x.nTupDel, x.nTupHotUpd))(Encoder.encodeLong, Encoder.encodeString, Encoder.encodeString, Encoder.encodeLong, Encoder.encodeLong, Encoder.encodeLong, Encoder.encodeLong, Encoder.encodeLong, Encoder.encodeLong, Encoder.encodeLong, Encoder.encodeLong)
  implicit lazy val read: Read[PgStatXactSysTablesViewRow] = new Read[PgStatXactSysTablesViewRow](
    gets = List(
      (Meta.LongMeta.get, Nullability.NoNulls),
      (Meta.StringMeta.get, Nullability.NoNulls),
      (Meta.StringMeta.get, Nullability.NoNulls),
      (Meta.LongMeta.get, Nullability.NoNulls),
      (Meta.LongMeta.get, Nullability.NoNulls),
      (Meta.LongMeta.get, Nullability.NoNulls),
      (Meta.LongMeta.get, Nullability.NoNulls),
      (Meta.LongMeta.get, Nullability.NoNulls),
      (Meta.LongMeta.get, Nullability.NoNulls),
      (Meta.LongMeta.get, Nullability.NoNulls),
      (Meta.LongMeta.get, Nullability.NoNulls)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => PgStatXactSysTablesViewRow(
      relid = Meta.LongMeta.get.unsafeGetNonNullable(rs, i + 0),
      schemaname = Meta.StringMeta.get.unsafeGetNonNullable(rs, i + 1),
      relname = Meta.StringMeta.get.unsafeGetNonNullable(rs, i + 2),
      seqScan = Meta.LongMeta.get.unsafeGetNonNullable(rs, i + 3),
      seqTupRead = Meta.LongMeta.get.unsafeGetNonNullable(rs, i + 4),
      idxScan = Meta.LongMeta.get.unsafeGetNonNullable(rs, i + 5),
      idxTupFetch = Meta.LongMeta.get.unsafeGetNonNullable(rs, i + 6),
      nTupIns = Meta.LongMeta.get.unsafeGetNonNullable(rs, i + 7),
      nTupUpd = Meta.LongMeta.get.unsafeGetNonNullable(rs, i + 8),
      nTupDel = Meta.LongMeta.get.unsafeGetNonNullable(rs, i + 9),
      nTupHotUpd = Meta.LongMeta.get.unsafeGetNonNullable(rs, i + 10)
    )
  )
}
