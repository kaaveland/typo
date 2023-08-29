/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_matviews

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

case class PgMatviewsViewRow(
  /** Points to [[pg_namespace.PgNamespaceRow.nspname]] */
  schemaname: Option[String],
  /** Points to [[pg_class.PgClassRow.relname]] */
  matviewname: String,
  matviewowner: /* nullability unknown */ Option[String],
  /** Points to [[pg_tablespace.PgTablespaceRow.spcname]] */
  tablespace: Option[String],
  /** Points to [[pg_class.PgClassRow.relhasindex]] */
  hasindexes: Boolean,
  /** Points to [[pg_class.PgClassRow.relispopulated]] */
  ispopulated: Boolean,
  definition: /* nullability unknown */ Option[String]
)

object PgMatviewsViewRow {
  implicit lazy val reads: Reads[PgMatviewsViewRow] = Reads[PgMatviewsViewRow](json => JsResult.fromTry(
      Try(
        PgMatviewsViewRow(
          schemaname = json.\("schemaname").toOption.map(_.as(Reads.StringReads)),
          matviewname = json.\("matviewname").as(Reads.StringReads),
          matviewowner = json.\("matviewowner").toOption.map(_.as(Reads.StringReads)),
          tablespace = json.\("tablespace").toOption.map(_.as(Reads.StringReads)),
          hasindexes = json.\("hasindexes").as(Reads.BooleanReads),
          ispopulated = json.\("ispopulated").as(Reads.BooleanReads),
          definition = json.\("definition").toOption.map(_.as(Reads.StringReads))
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[PgMatviewsViewRow] = RowParser[PgMatviewsViewRow] { row =>
    Success(
      PgMatviewsViewRow(
        schemaname = row(idx + 0)(Column.columnToOption(Column.columnToString)),
        matviewname = row(idx + 1)(Column.columnToString),
        matviewowner = row(idx + 2)(Column.columnToOption(Column.columnToString)),
        tablespace = row(idx + 3)(Column.columnToOption(Column.columnToString)),
        hasindexes = row(idx + 4)(Column.columnToBoolean),
        ispopulated = row(idx + 5)(Column.columnToBoolean),
        definition = row(idx + 6)(Column.columnToOption(Column.columnToString))
      )
    )
  }
  implicit lazy val writes: OWrites[PgMatviewsViewRow] = OWrites[PgMatviewsViewRow](o =>
    new JsObject(ListMap[String, JsValue](
      "schemaname" -> Writes.OptionWrites(Writes.StringWrites).writes(o.schemaname),
      "matviewname" -> Writes.StringWrites.writes(o.matviewname),
      "matviewowner" -> Writes.OptionWrites(Writes.StringWrites).writes(o.matviewowner),
      "tablespace" -> Writes.OptionWrites(Writes.StringWrites).writes(o.tablespace),
      "hasindexes" -> Writes.BooleanWrites.writes(o.hasindexes),
      "ispopulated" -> Writes.BooleanWrites.writes(o.ispopulated),
      "definition" -> Writes.OptionWrites(Writes.StringWrites).writes(o.definition)
    ))
  )
}
