/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_statio_sys_indexes

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

case class PgStatioSysIndexesViewRow(
  /** Points to [[pg_statio_all_indexes.PgStatioAllIndexesViewRow.relid]] */
  relid: /* oid */ Long,
  /** Points to [[pg_statio_all_indexes.PgStatioAllIndexesViewRow.indexrelid]] */
  indexrelid: /* oid */ Long,
  /** Points to [[pg_statio_all_indexes.PgStatioAllIndexesViewRow.schemaname]] */
  schemaname: String,
  /** Points to [[pg_statio_all_indexes.PgStatioAllIndexesViewRow.relname]] */
  relname: String,
  /** Points to [[pg_statio_all_indexes.PgStatioAllIndexesViewRow.indexrelname]] */
  indexrelname: String,
  /** Points to [[pg_statio_all_indexes.PgStatioAllIndexesViewRow.idxBlksRead]] */
  idxBlksRead: Long,
  /** Points to [[pg_statio_all_indexes.PgStatioAllIndexesViewRow.idxBlksHit]] */
  idxBlksHit: Long
)

object PgStatioSysIndexesViewRow {
  implicit lazy val reads: Reads[PgStatioSysIndexesViewRow] = Reads[PgStatioSysIndexesViewRow](json => JsResult.fromTry(
      Try(
        PgStatioSysIndexesViewRow(
          relid = json.\("relid").as(Reads.LongReads),
          indexrelid = json.\("indexrelid").as(Reads.LongReads),
          schemaname = json.\("schemaname").as(Reads.StringReads),
          relname = json.\("relname").as(Reads.StringReads),
          indexrelname = json.\("indexrelname").as(Reads.StringReads),
          idxBlksRead = json.\("idx_blks_read").as(Reads.LongReads),
          idxBlksHit = json.\("idx_blks_hit").as(Reads.LongReads)
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[PgStatioSysIndexesViewRow] = RowParser[PgStatioSysIndexesViewRow] { row =>
    Success(
      PgStatioSysIndexesViewRow(
        relid = row(idx + 0)(Column.columnToLong),
        indexrelid = row(idx + 1)(Column.columnToLong),
        schemaname = row(idx + 2)(Column.columnToString),
        relname = row(idx + 3)(Column.columnToString),
        indexrelname = row(idx + 4)(Column.columnToString),
        idxBlksRead = row(idx + 5)(Column.columnToLong),
        idxBlksHit = row(idx + 6)(Column.columnToLong)
      )
    )
  }
  implicit lazy val writes: OWrites[PgStatioSysIndexesViewRow] = OWrites[PgStatioSysIndexesViewRow](o =>
    new JsObject(ListMap[String, JsValue](
      "relid" -> Writes.LongWrites.writes(o.relid),
      "indexrelid" -> Writes.LongWrites.writes(o.indexrelid),
      "schemaname" -> Writes.StringWrites.writes(o.schemaname),
      "relname" -> Writes.StringWrites.writes(o.relname),
      "indexrelname" -> Writes.StringWrites.writes(o.indexrelname),
      "idx_blks_read" -> Writes.LongWrites.writes(o.idxBlksRead),
      "idx_blks_hit" -> Writes.LongWrites.writes(o.idxBlksHit)
    ))
  )
}
