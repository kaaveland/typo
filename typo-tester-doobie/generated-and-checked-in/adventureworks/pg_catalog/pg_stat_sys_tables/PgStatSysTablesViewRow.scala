/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_stat_sys_tables

import adventureworks.customtypes.TypoOffsetDateTime
import doobie.enumerated.Nullability
import doobie.util.Read
import doobie.util.meta.Meta
import io.circe.Decoder
import io.circe.DecodingFailure
import io.circe.Encoder
import io.circe.HCursor
import io.circe.Json
import java.sql.ResultSet
import scala.util.Try

case class PgStatSysTablesViewRow(
  /** Points to [[pg_stat_all_tables.PgStatAllTablesViewRow.relid]] */
  relid: /* oid */ Long,
  /** Points to [[pg_stat_all_tables.PgStatAllTablesViewRow.schemaname]] */
  schemaname: String,
  /** Points to [[pg_stat_all_tables.PgStatAllTablesViewRow.relname]] */
  relname: String,
  /** Points to [[pg_stat_all_tables.PgStatAllTablesViewRow.seqScan]] */
  seqScan: Long,
  /** Points to [[pg_stat_all_tables.PgStatAllTablesViewRow.seqTupRead]] */
  seqTupRead: Long,
  /** Points to [[pg_stat_all_tables.PgStatAllTablesViewRow.idxScan]] */
  idxScan: Long,
  /** Points to [[pg_stat_all_tables.PgStatAllTablesViewRow.idxTupFetch]] */
  idxTupFetch: Long,
  /** Points to [[pg_stat_all_tables.PgStatAllTablesViewRow.nTupIns]] */
  nTupIns: Long,
  /** Points to [[pg_stat_all_tables.PgStatAllTablesViewRow.nTupUpd]] */
  nTupUpd: Long,
  /** Points to [[pg_stat_all_tables.PgStatAllTablesViewRow.nTupDel]] */
  nTupDel: Long,
  /** Points to [[pg_stat_all_tables.PgStatAllTablesViewRow.nTupHotUpd]] */
  nTupHotUpd: Long,
  /** Points to [[pg_stat_all_tables.PgStatAllTablesViewRow.nLiveTup]] */
  nLiveTup: Long,
  /** Points to [[pg_stat_all_tables.PgStatAllTablesViewRow.nDeadTup]] */
  nDeadTup: Long,
  /** Points to [[pg_stat_all_tables.PgStatAllTablesViewRow.nModSinceAnalyze]] */
  nModSinceAnalyze: Long,
  /** Points to [[pg_stat_all_tables.PgStatAllTablesViewRow.nInsSinceVacuum]] */
  nInsSinceVacuum: Long,
  /** Points to [[pg_stat_all_tables.PgStatAllTablesViewRow.lastVacuum]] */
  lastVacuum: TypoOffsetDateTime,
  /** Points to [[pg_stat_all_tables.PgStatAllTablesViewRow.lastAutovacuum]] */
  lastAutovacuum: TypoOffsetDateTime,
  /** Points to [[pg_stat_all_tables.PgStatAllTablesViewRow.lastAnalyze]] */
  lastAnalyze: TypoOffsetDateTime,
  /** Points to [[pg_stat_all_tables.PgStatAllTablesViewRow.lastAutoanalyze]] */
  lastAutoanalyze: TypoOffsetDateTime,
  /** Points to [[pg_stat_all_tables.PgStatAllTablesViewRow.vacuumCount]] */
  vacuumCount: Long,
  /** Points to [[pg_stat_all_tables.PgStatAllTablesViewRow.autovacuumCount]] */
  autovacuumCount: Long,
  /** Points to [[pg_stat_all_tables.PgStatAllTablesViewRow.analyzeCount]] */
  analyzeCount: Long,
  /** Points to [[pg_stat_all_tables.PgStatAllTablesViewRow.autoanalyzeCount]] */
  autoanalyzeCount: Long
)

object PgStatSysTablesViewRow {
  implicit lazy val decoder: Decoder[PgStatSysTablesViewRow] = Decoder.instanceTry[PgStatSysTablesViewRow]((c: HCursor) =>
    Try {
      def orThrow[R](either: Either[DecodingFailure, R]): R = either match {
        case Left(err) => throw err
        case Right(r)  => r
      }
      PgStatSysTablesViewRow(
        relid = orThrow(c.get("relid")(Decoder.decodeLong)),
        schemaname = orThrow(c.get("schemaname")(Decoder.decodeString)),
        relname = orThrow(c.get("relname")(Decoder.decodeString)),
        seqScan = orThrow(c.get("seq_scan")(Decoder.decodeLong)),
        seqTupRead = orThrow(c.get("seq_tup_read")(Decoder.decodeLong)),
        idxScan = orThrow(c.get("idx_scan")(Decoder.decodeLong)),
        idxTupFetch = orThrow(c.get("idx_tup_fetch")(Decoder.decodeLong)),
        nTupIns = orThrow(c.get("n_tup_ins")(Decoder.decodeLong)),
        nTupUpd = orThrow(c.get("n_tup_upd")(Decoder.decodeLong)),
        nTupDel = orThrow(c.get("n_tup_del")(Decoder.decodeLong)),
        nTupHotUpd = orThrow(c.get("n_tup_hot_upd")(Decoder.decodeLong)),
        nLiveTup = orThrow(c.get("n_live_tup")(Decoder.decodeLong)),
        nDeadTup = orThrow(c.get("n_dead_tup")(Decoder.decodeLong)),
        nModSinceAnalyze = orThrow(c.get("n_mod_since_analyze")(Decoder.decodeLong)),
        nInsSinceVacuum = orThrow(c.get("n_ins_since_vacuum")(Decoder.decodeLong)),
        lastVacuum = orThrow(c.get("last_vacuum")(TypoOffsetDateTime.decoder)),
        lastAutovacuum = orThrow(c.get("last_autovacuum")(TypoOffsetDateTime.decoder)),
        lastAnalyze = orThrow(c.get("last_analyze")(TypoOffsetDateTime.decoder)),
        lastAutoanalyze = orThrow(c.get("last_autoanalyze")(TypoOffsetDateTime.decoder)),
        vacuumCount = orThrow(c.get("vacuum_count")(Decoder.decodeLong)),
        autovacuumCount = orThrow(c.get("autovacuum_count")(Decoder.decodeLong)),
        analyzeCount = orThrow(c.get("analyze_count")(Decoder.decodeLong)),
        autoanalyzeCount = orThrow(c.get("autoanalyze_count")(Decoder.decodeLong))
      )
    }
  )
  implicit lazy val encoder: Encoder[PgStatSysTablesViewRow] = Encoder[PgStatSysTablesViewRow](row =>
    Json.obj(
      "relid" -> Encoder.encodeLong.apply(row.relid),
      "schemaname" -> Encoder.encodeString.apply(row.schemaname),
      "relname" -> Encoder.encodeString.apply(row.relname),
      "seq_scan" -> Encoder.encodeLong.apply(row.seqScan),
      "seq_tup_read" -> Encoder.encodeLong.apply(row.seqTupRead),
      "idx_scan" -> Encoder.encodeLong.apply(row.idxScan),
      "idx_tup_fetch" -> Encoder.encodeLong.apply(row.idxTupFetch),
      "n_tup_ins" -> Encoder.encodeLong.apply(row.nTupIns),
      "n_tup_upd" -> Encoder.encodeLong.apply(row.nTupUpd),
      "n_tup_del" -> Encoder.encodeLong.apply(row.nTupDel),
      "n_tup_hot_upd" -> Encoder.encodeLong.apply(row.nTupHotUpd),
      "n_live_tup" -> Encoder.encodeLong.apply(row.nLiveTup),
      "n_dead_tup" -> Encoder.encodeLong.apply(row.nDeadTup),
      "n_mod_since_analyze" -> Encoder.encodeLong.apply(row.nModSinceAnalyze),
      "n_ins_since_vacuum" -> Encoder.encodeLong.apply(row.nInsSinceVacuum),
      "last_vacuum" -> TypoOffsetDateTime.encoder.apply(row.lastVacuum),
      "last_autovacuum" -> TypoOffsetDateTime.encoder.apply(row.lastAutovacuum),
      "last_analyze" -> TypoOffsetDateTime.encoder.apply(row.lastAnalyze),
      "last_autoanalyze" -> TypoOffsetDateTime.encoder.apply(row.lastAutoanalyze),
      "vacuum_count" -> Encoder.encodeLong.apply(row.vacuumCount),
      "autovacuum_count" -> Encoder.encodeLong.apply(row.autovacuumCount),
      "analyze_count" -> Encoder.encodeLong.apply(row.analyzeCount),
      "autoanalyze_count" -> Encoder.encodeLong.apply(row.autoanalyzeCount)
    )
  )
  implicit lazy val read: Read[PgStatSysTablesViewRow] = new Read[PgStatSysTablesViewRow](
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
      (Meta.LongMeta.get, Nullability.NoNulls),
      (Meta.LongMeta.get, Nullability.NoNulls),
      (Meta.LongMeta.get, Nullability.NoNulls),
      (Meta.LongMeta.get, Nullability.NoNulls),
      (Meta.LongMeta.get, Nullability.NoNulls),
      (TypoOffsetDateTime.get, Nullability.NoNulls),
      (TypoOffsetDateTime.get, Nullability.NoNulls),
      (TypoOffsetDateTime.get, Nullability.NoNulls),
      (TypoOffsetDateTime.get, Nullability.NoNulls),
      (Meta.LongMeta.get, Nullability.NoNulls),
      (Meta.LongMeta.get, Nullability.NoNulls),
      (Meta.LongMeta.get, Nullability.NoNulls),
      (Meta.LongMeta.get, Nullability.NoNulls)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => PgStatSysTablesViewRow(
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
      nTupHotUpd = Meta.LongMeta.get.unsafeGetNonNullable(rs, i + 10),
      nLiveTup = Meta.LongMeta.get.unsafeGetNonNullable(rs, i + 11),
      nDeadTup = Meta.LongMeta.get.unsafeGetNonNullable(rs, i + 12),
      nModSinceAnalyze = Meta.LongMeta.get.unsafeGetNonNullable(rs, i + 13),
      nInsSinceVacuum = Meta.LongMeta.get.unsafeGetNonNullable(rs, i + 14),
      lastVacuum = TypoOffsetDateTime.get.unsafeGetNonNullable(rs, i + 15),
      lastAutovacuum = TypoOffsetDateTime.get.unsafeGetNonNullable(rs, i + 16),
      lastAnalyze = TypoOffsetDateTime.get.unsafeGetNonNullable(rs, i + 17),
      lastAutoanalyze = TypoOffsetDateTime.get.unsafeGetNonNullable(rs, i + 18),
      vacuumCount = Meta.LongMeta.get.unsafeGetNonNullable(rs, i + 19),
      autovacuumCount = Meta.LongMeta.get.unsafeGetNonNullable(rs, i + 20),
      analyzeCount = Meta.LongMeta.get.unsafeGetNonNullable(rs, i + 21),
      autoanalyzeCount = Meta.LongMeta.get.unsafeGetNonNullable(rs, i + 22)
    )
  )
}
