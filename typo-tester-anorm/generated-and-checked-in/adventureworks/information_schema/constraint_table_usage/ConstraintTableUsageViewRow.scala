/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package constraint_table_usage

import adventureworks.information_schema.SqlIdentifier
import anorm.RowParser
import anorm.Success
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.OWrites
import play.api.libs.json.Reads
import scala.collection.immutable.ListMap
import scala.util.Try

case class ConstraintTableUsageViewRow(
  tableCatalog: SqlIdentifier,
  tableSchema: SqlIdentifier,
  tableName: SqlIdentifier,
  constraintCatalog: SqlIdentifier,
  constraintSchema: SqlIdentifier,
  constraintName: SqlIdentifier
)

object ConstraintTableUsageViewRow {
  implicit lazy val reads: Reads[ConstraintTableUsageViewRow] = Reads[ConstraintTableUsageViewRow](json => JsResult.fromTry(
      Try(
        ConstraintTableUsageViewRow(
          tableCatalog = json.\("table_catalog").as(SqlIdentifier.reads),
          tableSchema = json.\("table_schema").as(SqlIdentifier.reads),
          tableName = json.\("table_name").as(SqlIdentifier.reads),
          constraintCatalog = json.\("constraint_catalog").as(SqlIdentifier.reads),
          constraintSchema = json.\("constraint_schema").as(SqlIdentifier.reads),
          constraintName = json.\("constraint_name").as(SqlIdentifier.reads)
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[ConstraintTableUsageViewRow] = RowParser[ConstraintTableUsageViewRow] { row =>
    Success(
      ConstraintTableUsageViewRow(
        tableCatalog = row(idx + 0)(SqlIdentifier.column),
        tableSchema = row(idx + 1)(SqlIdentifier.column),
        tableName = row(idx + 2)(SqlIdentifier.column),
        constraintCatalog = row(idx + 3)(SqlIdentifier.column),
        constraintSchema = row(idx + 4)(SqlIdentifier.column),
        constraintName = row(idx + 5)(SqlIdentifier.column)
      )
    )
  }
  implicit lazy val writes: OWrites[ConstraintTableUsageViewRow] = OWrites[ConstraintTableUsageViewRow](o =>
    new JsObject(ListMap[String, JsValue](
      "table_catalog" -> SqlIdentifier.writes.writes(o.tableCatalog),
      "table_schema" -> SqlIdentifier.writes.writes(o.tableSchema),
      "table_name" -> SqlIdentifier.writes.writes(o.tableName),
      "constraint_catalog" -> SqlIdentifier.writes.writes(o.constraintCatalog),
      "constraint_schema" -> SqlIdentifier.writes.writes(o.constraintSchema),
      "constraint_name" -> SqlIdentifier.writes.writes(o.constraintName)
    ))
  )
}
