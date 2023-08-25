/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_stat_user_indexes

import anorm.Column
import anorm.RowParser
import anorm.Success
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.OWrites
import play.api.libs.json.Reads
import play.api.libs.json.Writes
import scala.collection.immutable.ListMap
import scala.util.Try

case class PgStatUserIndexesViewRow(
  /** Points to [[pg_stat_all_indexes.PgStatAllIndexesViewRow.relid]] */
  relid: /* oid */ Long,
  /** Points to [[pg_stat_all_indexes.PgStatAllIndexesViewRow.indexrelid]] */
  indexrelid: /* oid */ Long,
  /** Points to [[pg_stat_all_indexes.PgStatAllIndexesViewRow.schemaname]] */
  schemaname: String,
  /** Points to [[pg_stat_all_indexes.PgStatAllIndexesViewRow.relname]] */
  relname: String,
  /** Points to [[pg_stat_all_indexes.PgStatAllIndexesViewRow.indexrelname]] */
  indexrelname: String,
  /** Points to [[pg_stat_all_indexes.PgStatAllIndexesViewRow.idxScan]] */
  idxScan: Long,
  /** Points to [[pg_stat_all_indexes.PgStatAllIndexesViewRow.idxTupRead]] */
  idxTupRead: Long,
  /** Points to [[pg_stat_all_indexes.PgStatAllIndexesViewRow.idxTupFetch]] */
  idxTupFetch: Long
)

object PgStatUserIndexesViewRow {
  implicit lazy val reads: Reads[PgStatUserIndexesViewRow] = Reads[PgStatUserIndexesViewRow](json => JsResult.fromTry(
      Try(
        PgStatUserIndexesViewRow(
          relid = json.\("relid").as(Reads.LongReads),
          indexrelid = json.\("indexrelid").as(Reads.LongReads),
          schemaname = json.\("schemaname").as(Reads.StringReads),
          relname = json.\("relname").as(Reads.StringReads),
          indexrelname = json.\("indexrelname").as(Reads.StringReads),
          idxScan = json.\("idx_scan").as(Reads.LongReads),
          idxTupRead = json.\("idx_tup_read").as(Reads.LongReads),
          idxTupFetch = json.\("idx_tup_fetch").as(Reads.LongReads)
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[PgStatUserIndexesViewRow] = RowParser[PgStatUserIndexesViewRow] { row =>
    Success(
      PgStatUserIndexesViewRow(
        relid = row(idx + 0)(Column.columnToLong),
        indexrelid = row(idx + 1)(Column.columnToLong),
        schemaname = row(idx + 2)(Column.columnToString),
        relname = row(idx + 3)(Column.columnToString),
        indexrelname = row(idx + 4)(Column.columnToString),
        idxScan = row(idx + 5)(Column.columnToLong),
        idxTupRead = row(idx + 6)(Column.columnToLong),
        idxTupFetch = row(idx + 7)(Column.columnToLong)
      )
    )
  }
  implicit lazy val writes: OWrites[PgStatUserIndexesViewRow] = OWrites[PgStatUserIndexesViewRow](o =>
    new JsObject(ListMap[String, JsValue](
      "relid" -> Writes.LongWrites.writes(o.relid),
      "indexrelid" -> Writes.LongWrites.writes(o.indexrelid),
      "schemaname" -> Writes.StringWrites.writes(o.schemaname),
      "relname" -> Writes.StringWrites.writes(o.relname),
      "indexrelname" -> Writes.StringWrites.writes(o.indexrelname),
      "idx_scan" -> Writes.LongWrites.writes(o.idxScan),
      "idx_tup_read" -> Writes.LongWrites.writes(o.idxTupRead),
      "idx_tup_fetch" -> Writes.LongWrites.writes(o.idxTupFetch)
    ))
  )
}
