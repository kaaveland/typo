/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_tables

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

case class PgTablesViewRow(
  /** Points to [[pg_namespace.PgNamespaceRow.nspname]] */
  schemaname: Option[String],
  /** Points to [[pg_class.PgClassRow.relname]] */
  tablename: String,
  tableowner: /* nullability unknown */ Option[String],
  /** Points to [[pg_tablespace.PgTablespaceRow.spcname]] */
  tablespace: Option[String],
  /** Points to [[pg_class.PgClassRow.relhasindex]] */
  hasindexes: Boolean,
  /** Points to [[pg_class.PgClassRow.relhasrules]] */
  hasrules: Boolean,
  /** Points to [[pg_class.PgClassRow.relhastriggers]] */
  hastriggers: Boolean,
  /** Points to [[pg_class.PgClassRow.relrowsecurity]] */
  rowsecurity: Boolean
)

object PgTablesViewRow {
  implicit lazy val reads: Reads[PgTablesViewRow] = Reads[PgTablesViewRow](json => JsResult.fromTry(
      Try(
        PgTablesViewRow(
          schemaname = json.\("schemaname").toOption.map(_.as(Reads.StringReads)),
          tablename = json.\("tablename").as(Reads.StringReads),
          tableowner = json.\("tableowner").toOption.map(_.as(Reads.StringReads)),
          tablespace = json.\("tablespace").toOption.map(_.as(Reads.StringReads)),
          hasindexes = json.\("hasindexes").as(Reads.BooleanReads),
          hasrules = json.\("hasrules").as(Reads.BooleanReads),
          hastriggers = json.\("hastriggers").as(Reads.BooleanReads),
          rowsecurity = json.\("rowsecurity").as(Reads.BooleanReads)
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[PgTablesViewRow] = RowParser[PgTablesViewRow] { row =>
    Success(
      PgTablesViewRow(
        schemaname = row(idx + 0)(Column.columnToOption(Column.columnToString)),
        tablename = row(idx + 1)(Column.columnToString),
        tableowner = row(idx + 2)(Column.columnToOption(Column.columnToString)),
        tablespace = row(idx + 3)(Column.columnToOption(Column.columnToString)),
        hasindexes = row(idx + 4)(Column.columnToBoolean),
        hasrules = row(idx + 5)(Column.columnToBoolean),
        hastriggers = row(idx + 6)(Column.columnToBoolean),
        rowsecurity = row(idx + 7)(Column.columnToBoolean)
      )
    )
  }
  implicit lazy val writes: OWrites[PgTablesViewRow] = OWrites[PgTablesViewRow](o =>
    new JsObject(ListMap[String, JsValue](
      "schemaname" -> Writes.OptionWrites(Writes.StringWrites).writes(o.schemaname),
      "tablename" -> Writes.StringWrites.writes(o.tablename),
      "tableowner" -> Writes.OptionWrites(Writes.StringWrites).writes(o.tableowner),
      "tablespace" -> Writes.OptionWrites(Writes.StringWrites).writes(o.tablespace),
      "hasindexes" -> Writes.BooleanWrites.writes(o.hasindexes),
      "hasrules" -> Writes.BooleanWrites.writes(o.hasrules),
      "hastriggers" -> Writes.BooleanWrites.writes(o.hastriggers),
      "rowsecurity" -> Writes.BooleanWrites.writes(o.rowsecurity)
    ))
  )
}
