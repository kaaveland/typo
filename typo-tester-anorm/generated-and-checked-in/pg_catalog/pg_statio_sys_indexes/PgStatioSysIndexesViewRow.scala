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
  relid: Option[/* oid */ Long],
  /** Points to [[pg_statio_all_indexes.PgStatioAllIndexesViewRow.indexrelid]] */
  indexrelid: Option[/* oid */ Long],
  /** Points to [[pg_statio_all_indexes.PgStatioAllIndexesViewRow.schemaname]] */
  schemaname: Option[String],
  /** Points to [[pg_statio_all_indexes.PgStatioAllIndexesViewRow.relname]] */
  relname: Option[String],
  /** Points to [[pg_statio_all_indexes.PgStatioAllIndexesViewRow.indexrelname]] */
  indexrelname: Option[String],
  /** Points to [[pg_statio_all_indexes.PgStatioAllIndexesViewRow.idxBlksRead]] */
  idxBlksRead: Option[Long],
  /** Points to [[pg_statio_all_indexes.PgStatioAllIndexesViewRow.idxBlksHit]] */
  idxBlksHit: Option[Long]
)

object PgStatioSysIndexesViewRow {
  implicit val reads: Reads[PgStatioSysIndexesViewRow] = Reads[PgStatioSysIndexesViewRow](json => JsResult.fromTry(
      Try(
        PgStatioSysIndexesViewRow(
          relid = json.\("relid").toOption.map(_.as(Reads.LongReads)),
          indexrelid = json.\("indexrelid").toOption.map(_.as(Reads.LongReads)),
          schemaname = json.\("schemaname").toOption.map(_.as(Reads.StringReads)),
          relname = json.\("relname").toOption.map(_.as(Reads.StringReads)),
          indexrelname = json.\("indexrelname").toOption.map(_.as(Reads.StringReads)),
          idxBlksRead = json.\("idx_blks_read").toOption.map(_.as(Reads.LongReads)),
          idxBlksHit = json.\("idx_blks_hit").toOption.map(_.as(Reads.LongReads))
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[PgStatioSysIndexesViewRow] = RowParser[PgStatioSysIndexesViewRow] { row =>
    Success(
      PgStatioSysIndexesViewRow(
        relid = row(idx + 0)(Column.columnToOption(Column.columnToLong)),
        indexrelid = row(idx + 1)(Column.columnToOption(Column.columnToLong)),
        schemaname = row(idx + 2)(Column.columnToOption(Column.columnToString)),
        relname = row(idx + 3)(Column.columnToOption(Column.columnToString)),
        indexrelname = row(idx + 4)(Column.columnToOption(Column.columnToString)),
        idxBlksRead = row(idx + 5)(Column.columnToOption(Column.columnToLong)),
        idxBlksHit = row(idx + 6)(Column.columnToOption(Column.columnToLong))
      )
    )
  }
  implicit val writes: OWrites[PgStatioSysIndexesViewRow] = OWrites[PgStatioSysIndexesViewRow](o =>
    new JsObject(ListMap[String, JsValue](
      "relid" -> Writes.OptionWrites(Writes.LongWrites).writes(o.relid),
      "indexrelid" -> Writes.OptionWrites(Writes.LongWrites).writes(o.indexrelid),
      "schemaname" -> Writes.OptionWrites(Writes.StringWrites).writes(o.schemaname),
      "relname" -> Writes.OptionWrites(Writes.StringWrites).writes(o.relname),
      "indexrelname" -> Writes.OptionWrites(Writes.StringWrites).writes(o.indexrelname),
      "idx_blks_read" -> Writes.OptionWrites(Writes.LongWrites).writes(o.idxBlksRead),
      "idx_blks_hit" -> Writes.OptionWrites(Writes.LongWrites).writes(o.idxBlksHit)
    ))
  )
}