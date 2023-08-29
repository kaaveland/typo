/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_stat_sys_tables

import adventureworks.customtypes.TypoOffsetDateTime
import adventureworks.pg_catalog.pg_class.PgClassId
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
  relid: Option[PgClassId],
  /** Points to [[pg_stat_all_tables.PgStatAllTablesViewRow.schemaname]] */
  schemaname: Option[String],
  /** Points to [[pg_stat_all_tables.PgStatAllTablesViewRow.relname]] */
  relname: Option[String],
  /** Points to [[pg_stat_all_tables.PgStatAllTablesViewRow.seqScan]] */
  seqScan: Option[/* nullability unknown */ Long],
  /** Points to [[pg_stat_all_tables.PgStatAllTablesViewRow.seqTupRead]] */
  seqTupRead: Option[/* nullability unknown */ Long],
  /** Points to [[pg_stat_all_tables.PgStatAllTablesViewRow.idxScan]] */
  idxScan: Option[/* nullability unknown */ Long],
  /** Points to [[pg_stat_all_tables.PgStatAllTablesViewRow.idxTupFetch]] */
  idxTupFetch: Option[/* nullability unknown */ Long],
  /** Points to [[pg_stat_all_tables.PgStatAllTablesViewRow.nTupIns]] */
  nTupIns: Option[/* nullability unknown */ Long],
  /** Points to [[pg_stat_all_tables.PgStatAllTablesViewRow.nTupUpd]] */
  nTupUpd: Option[/* nullability unknown */ Long],
  /** Points to [[pg_stat_all_tables.PgStatAllTablesViewRow.nTupDel]] */
  nTupDel: Option[/* nullability unknown */ Long],
  /** Points to [[pg_stat_all_tables.PgStatAllTablesViewRow.nTupHotUpd]] */
  nTupHotUpd: Option[/* nullability unknown */ Long],
  /** Points to [[pg_stat_all_tables.PgStatAllTablesViewRow.nLiveTup]] */
  nLiveTup: Option[/* nullability unknown */ Long],
  /** Points to [[pg_stat_all_tables.PgStatAllTablesViewRow.nDeadTup]] */
  nDeadTup: Option[/* nullability unknown */ Long],
  /** Points to [[pg_stat_all_tables.PgStatAllTablesViewRow.nModSinceAnalyze]] */
  nModSinceAnalyze: Option[/* nullability unknown */ Long],
  /** Points to [[pg_stat_all_tables.PgStatAllTablesViewRow.nInsSinceVacuum]] */
  nInsSinceVacuum: Option[/* nullability unknown */ Long],
  /** Points to [[pg_stat_all_tables.PgStatAllTablesViewRow.lastVacuum]] */
  lastVacuum: Option[/* nullability unknown */ TypoOffsetDateTime],
  /** Points to [[pg_stat_all_tables.PgStatAllTablesViewRow.lastAutovacuum]] */
  lastAutovacuum: Option[/* nullability unknown */ TypoOffsetDateTime],
  /** Points to [[pg_stat_all_tables.PgStatAllTablesViewRow.lastAnalyze]] */
  lastAnalyze: Option[/* nullability unknown */ TypoOffsetDateTime],
  /** Points to [[pg_stat_all_tables.PgStatAllTablesViewRow.lastAutoanalyze]] */
  lastAutoanalyze: Option[/* nullability unknown */ TypoOffsetDateTime],
  /** Points to [[pg_stat_all_tables.PgStatAllTablesViewRow.vacuumCount]] */
  vacuumCount: Option[/* nullability unknown */ Long],
  /** Points to [[pg_stat_all_tables.PgStatAllTablesViewRow.autovacuumCount]] */
  autovacuumCount: Option[/* nullability unknown */ Long],
  /** Points to [[pg_stat_all_tables.PgStatAllTablesViewRow.analyzeCount]] */
  analyzeCount: Option[/* nullability unknown */ Long],
  /** Points to [[pg_stat_all_tables.PgStatAllTablesViewRow.autoanalyzeCount]] */
  autoanalyzeCount: Option[/* nullability unknown */ Long]
)

object PgStatSysTablesViewRow {
  implicit lazy val decoder: Decoder[PgStatSysTablesViewRow] = Decoder.instanceTry[PgStatSysTablesViewRow]((c: HCursor) =>
    Try {
      def orThrow[R](either: Either[DecodingFailure, R]): R = either match {
        case Left(err) => throw err
        case Right(r)  => r
      }
      PgStatSysTablesViewRow(
        relid = orThrow(c.get("relid")(Decoder.decodeOption(PgClassId.decoder))),
        schemaname = orThrow(c.get("schemaname")(Decoder.decodeOption(Decoder.decodeString))),
        relname = orThrow(c.get("relname")(Decoder.decodeOption(Decoder.decodeString))),
        seqScan = orThrow(c.get("seq_scan")(Decoder.decodeOption(Decoder.decodeLong))),
        seqTupRead = orThrow(c.get("seq_tup_read")(Decoder.decodeOption(Decoder.decodeLong))),
        idxScan = orThrow(c.get("idx_scan")(Decoder.decodeOption(Decoder.decodeLong))),
        idxTupFetch = orThrow(c.get("idx_tup_fetch")(Decoder.decodeOption(Decoder.decodeLong))),
        nTupIns = orThrow(c.get("n_tup_ins")(Decoder.decodeOption(Decoder.decodeLong))),
        nTupUpd = orThrow(c.get("n_tup_upd")(Decoder.decodeOption(Decoder.decodeLong))),
        nTupDel = orThrow(c.get("n_tup_del")(Decoder.decodeOption(Decoder.decodeLong))),
        nTupHotUpd = orThrow(c.get("n_tup_hot_upd")(Decoder.decodeOption(Decoder.decodeLong))),
        nLiveTup = orThrow(c.get("n_live_tup")(Decoder.decodeOption(Decoder.decodeLong))),
        nDeadTup = orThrow(c.get("n_dead_tup")(Decoder.decodeOption(Decoder.decodeLong))),
        nModSinceAnalyze = orThrow(c.get("n_mod_since_analyze")(Decoder.decodeOption(Decoder.decodeLong))),
        nInsSinceVacuum = orThrow(c.get("n_ins_since_vacuum")(Decoder.decodeOption(Decoder.decodeLong))),
        lastVacuum = orThrow(c.get("last_vacuum")(Decoder.decodeOption(TypoOffsetDateTime.decoder))),
        lastAutovacuum = orThrow(c.get("last_autovacuum")(Decoder.decodeOption(TypoOffsetDateTime.decoder))),
        lastAnalyze = orThrow(c.get("last_analyze")(Decoder.decodeOption(TypoOffsetDateTime.decoder))),
        lastAutoanalyze = orThrow(c.get("last_autoanalyze")(Decoder.decodeOption(TypoOffsetDateTime.decoder))),
        vacuumCount = orThrow(c.get("vacuum_count")(Decoder.decodeOption(Decoder.decodeLong))),
        autovacuumCount = orThrow(c.get("autovacuum_count")(Decoder.decodeOption(Decoder.decodeLong))),
        analyzeCount = orThrow(c.get("analyze_count")(Decoder.decodeOption(Decoder.decodeLong))),
        autoanalyzeCount = orThrow(c.get("autoanalyze_count")(Decoder.decodeOption(Decoder.decodeLong)))
      )
    }
  )
  implicit lazy val encoder: Encoder[PgStatSysTablesViewRow] = Encoder[PgStatSysTablesViewRow](row =>
    Json.obj(
      "relid" -> Encoder.encodeOption(PgClassId.encoder).apply(row.relid),
      "schemaname" -> Encoder.encodeOption(Encoder.encodeString).apply(row.schemaname),
      "relname" -> Encoder.encodeOption(Encoder.encodeString).apply(row.relname),
      "seq_scan" -> Encoder.encodeOption(Encoder.encodeLong).apply(row.seqScan),
      "seq_tup_read" -> Encoder.encodeOption(Encoder.encodeLong).apply(row.seqTupRead),
      "idx_scan" -> Encoder.encodeOption(Encoder.encodeLong).apply(row.idxScan),
      "idx_tup_fetch" -> Encoder.encodeOption(Encoder.encodeLong).apply(row.idxTupFetch),
      "n_tup_ins" -> Encoder.encodeOption(Encoder.encodeLong).apply(row.nTupIns),
      "n_tup_upd" -> Encoder.encodeOption(Encoder.encodeLong).apply(row.nTupUpd),
      "n_tup_del" -> Encoder.encodeOption(Encoder.encodeLong).apply(row.nTupDel),
      "n_tup_hot_upd" -> Encoder.encodeOption(Encoder.encodeLong).apply(row.nTupHotUpd),
      "n_live_tup" -> Encoder.encodeOption(Encoder.encodeLong).apply(row.nLiveTup),
      "n_dead_tup" -> Encoder.encodeOption(Encoder.encodeLong).apply(row.nDeadTup),
      "n_mod_since_analyze" -> Encoder.encodeOption(Encoder.encodeLong).apply(row.nModSinceAnalyze),
      "n_ins_since_vacuum" -> Encoder.encodeOption(Encoder.encodeLong).apply(row.nInsSinceVacuum),
      "last_vacuum" -> Encoder.encodeOption(TypoOffsetDateTime.encoder).apply(row.lastVacuum),
      "last_autovacuum" -> Encoder.encodeOption(TypoOffsetDateTime.encoder).apply(row.lastAutovacuum),
      "last_analyze" -> Encoder.encodeOption(TypoOffsetDateTime.encoder).apply(row.lastAnalyze),
      "last_autoanalyze" -> Encoder.encodeOption(TypoOffsetDateTime.encoder).apply(row.lastAutoanalyze),
      "vacuum_count" -> Encoder.encodeOption(Encoder.encodeLong).apply(row.vacuumCount),
      "autovacuum_count" -> Encoder.encodeOption(Encoder.encodeLong).apply(row.autovacuumCount),
      "analyze_count" -> Encoder.encodeOption(Encoder.encodeLong).apply(row.analyzeCount),
      "autoanalyze_count" -> Encoder.encodeOption(Encoder.encodeLong).apply(row.autoanalyzeCount)
    )
  )
  implicit lazy val read: Read[PgStatSysTablesViewRow] = new Read[PgStatSysTablesViewRow](
    gets = List(
      (PgClassId.get, Nullability.Nullable),
      (Meta.StringMeta.get, Nullability.Nullable),
      (Meta.StringMeta.get, Nullability.Nullable),
      (Meta.LongMeta.get, Nullability.Nullable),
      (Meta.LongMeta.get, Nullability.Nullable),
      (Meta.LongMeta.get, Nullability.Nullable),
      (Meta.LongMeta.get, Nullability.Nullable),
      (Meta.LongMeta.get, Nullability.Nullable),
      (Meta.LongMeta.get, Nullability.Nullable),
      (Meta.LongMeta.get, Nullability.Nullable),
      (Meta.LongMeta.get, Nullability.Nullable),
      (Meta.LongMeta.get, Nullability.Nullable),
      (Meta.LongMeta.get, Nullability.Nullable),
      (Meta.LongMeta.get, Nullability.Nullable),
      (Meta.LongMeta.get, Nullability.Nullable),
      (/* nullability unknown */ TypoOffsetDateTime.get, Nullability.Nullable),
      (/* nullability unknown */ TypoOffsetDateTime.get, Nullability.Nullable),
      (/* nullability unknown */ TypoOffsetDateTime.get, Nullability.Nullable),
      (/* nullability unknown */ TypoOffsetDateTime.get, Nullability.Nullable),
      (Meta.LongMeta.get, Nullability.Nullable),
      (Meta.LongMeta.get, Nullability.Nullable),
      (Meta.LongMeta.get, Nullability.Nullable),
      (Meta.LongMeta.get, Nullability.Nullable)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => PgStatSysTablesViewRow(
      relid = PgClassId.get.unsafeGetNullable(rs, i + 0),
      schemaname = Meta.StringMeta.get.unsafeGetNullable(rs, i + 1),
      relname = Meta.StringMeta.get.unsafeGetNullable(rs, i + 2),
      seqScan = Meta.LongMeta.get.unsafeGetNullable(rs, i + 3),
      seqTupRead = Meta.LongMeta.get.unsafeGetNullable(rs, i + 4),
      idxScan = Meta.LongMeta.get.unsafeGetNullable(rs, i + 5),
      idxTupFetch = Meta.LongMeta.get.unsafeGetNullable(rs, i + 6),
      nTupIns = Meta.LongMeta.get.unsafeGetNullable(rs, i + 7),
      nTupUpd = Meta.LongMeta.get.unsafeGetNullable(rs, i + 8),
      nTupDel = Meta.LongMeta.get.unsafeGetNullable(rs, i + 9),
      nTupHotUpd = Meta.LongMeta.get.unsafeGetNullable(rs, i + 10),
      nLiveTup = Meta.LongMeta.get.unsafeGetNullable(rs, i + 11),
      nDeadTup = Meta.LongMeta.get.unsafeGetNullable(rs, i + 12),
      nModSinceAnalyze = Meta.LongMeta.get.unsafeGetNullable(rs, i + 13),
      nInsSinceVacuum = Meta.LongMeta.get.unsafeGetNullable(rs, i + 14),
      lastVacuum = /* nullability unknown */ TypoOffsetDateTime.get.unsafeGetNullable(rs, i + 15),
      lastAutovacuum = /* nullability unknown */ TypoOffsetDateTime.get.unsafeGetNullable(rs, i + 16),
      lastAnalyze = /* nullability unknown */ TypoOffsetDateTime.get.unsafeGetNullable(rs, i + 17),
      lastAutoanalyze = /* nullability unknown */ TypoOffsetDateTime.get.unsafeGetNullable(rs, i + 18),
      vacuumCount = Meta.LongMeta.get.unsafeGetNullable(rs, i + 19),
      autovacuumCount = Meta.LongMeta.get.unsafeGetNullable(rs, i + 20),
      analyzeCount = Meta.LongMeta.get.unsafeGetNullable(rs, i + 21),
      autoanalyzeCount = Meta.LongMeta.get.unsafeGetNullable(rs, i + 22)
    )
  )
}
