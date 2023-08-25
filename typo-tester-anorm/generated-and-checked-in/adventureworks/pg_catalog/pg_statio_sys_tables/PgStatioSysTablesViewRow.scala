/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_statio_sys_tables

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

case class PgStatioSysTablesViewRow(
  /** Points to [[pg_statio_all_tables.PgStatioAllTablesViewRow.relid]] */
  relid: /* oid */ Long,
  /** Points to [[pg_statio_all_tables.PgStatioAllTablesViewRow.schemaname]] */
  schemaname: String,
  /** Points to [[pg_statio_all_tables.PgStatioAllTablesViewRow.relname]] */
  relname: String,
  /** Points to [[pg_statio_all_tables.PgStatioAllTablesViewRow.heapBlksRead]] */
  heapBlksRead: Long,
  /** Points to [[pg_statio_all_tables.PgStatioAllTablesViewRow.heapBlksHit]] */
  heapBlksHit: Long,
  /** Points to [[pg_statio_all_tables.PgStatioAllTablesViewRow.idxBlksRead]] */
  idxBlksRead: Long,
  /** Points to [[pg_statio_all_tables.PgStatioAllTablesViewRow.idxBlksHit]] */
  idxBlksHit: Long,
  /** Points to [[pg_statio_all_tables.PgStatioAllTablesViewRow.toastBlksRead]] */
  toastBlksRead: Long,
  /** Points to [[pg_statio_all_tables.PgStatioAllTablesViewRow.toastBlksHit]] */
  toastBlksHit: Long,
  /** Points to [[pg_statio_all_tables.PgStatioAllTablesViewRow.tidxBlksRead]] */
  tidxBlksRead: Long,
  /** Points to [[pg_statio_all_tables.PgStatioAllTablesViewRow.tidxBlksHit]] */
  tidxBlksHit: Long
)

object PgStatioSysTablesViewRow {
  implicit lazy val reads: Reads[PgStatioSysTablesViewRow] = Reads[PgStatioSysTablesViewRow](json => JsResult.fromTry(
      Try(
        PgStatioSysTablesViewRow(
          relid = json.\("relid").as(Reads.LongReads),
          schemaname = json.\("schemaname").as(Reads.StringReads),
          relname = json.\("relname").as(Reads.StringReads),
          heapBlksRead = json.\("heap_blks_read").as(Reads.LongReads),
          heapBlksHit = json.\("heap_blks_hit").as(Reads.LongReads),
          idxBlksRead = json.\("idx_blks_read").as(Reads.LongReads),
          idxBlksHit = json.\("idx_blks_hit").as(Reads.LongReads),
          toastBlksRead = json.\("toast_blks_read").as(Reads.LongReads),
          toastBlksHit = json.\("toast_blks_hit").as(Reads.LongReads),
          tidxBlksRead = json.\("tidx_blks_read").as(Reads.LongReads),
          tidxBlksHit = json.\("tidx_blks_hit").as(Reads.LongReads)
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[PgStatioSysTablesViewRow] = RowParser[PgStatioSysTablesViewRow] { row =>
    Success(
      PgStatioSysTablesViewRow(
        relid = row(idx + 0)(Column.columnToLong),
        schemaname = row(idx + 1)(Column.columnToString),
        relname = row(idx + 2)(Column.columnToString),
        heapBlksRead = row(idx + 3)(Column.columnToLong),
        heapBlksHit = row(idx + 4)(Column.columnToLong),
        idxBlksRead = row(idx + 5)(Column.columnToLong),
        idxBlksHit = row(idx + 6)(Column.columnToLong),
        toastBlksRead = row(idx + 7)(Column.columnToLong),
        toastBlksHit = row(idx + 8)(Column.columnToLong),
        tidxBlksRead = row(idx + 9)(Column.columnToLong),
        tidxBlksHit = row(idx + 10)(Column.columnToLong)
      )
    )
  }
  implicit lazy val writes: OWrites[PgStatioSysTablesViewRow] = OWrites[PgStatioSysTablesViewRow](o =>
    new JsObject(ListMap[String, JsValue](
      "relid" -> Writes.LongWrites.writes(o.relid),
      "schemaname" -> Writes.StringWrites.writes(o.schemaname),
      "relname" -> Writes.StringWrites.writes(o.relname),
      "heap_blks_read" -> Writes.LongWrites.writes(o.heapBlksRead),
      "heap_blks_hit" -> Writes.LongWrites.writes(o.heapBlksHit),
      "idx_blks_read" -> Writes.LongWrites.writes(o.idxBlksRead),
      "idx_blks_hit" -> Writes.LongWrites.writes(o.idxBlksHit),
      "toast_blks_read" -> Writes.LongWrites.writes(o.toastBlksRead),
      "toast_blks_hit" -> Writes.LongWrites.writes(o.toastBlksHit),
      "tidx_blks_read" -> Writes.LongWrites.writes(o.tidxBlksRead),
      "tidx_blks_hit" -> Writes.LongWrites.writes(o.tidxBlksHit)
    ))
  )
}
