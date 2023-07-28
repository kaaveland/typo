/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package key_column_usage

import adventureworks.information_schema.CardinalNumber
import adventureworks.information_schema.SqlIdentifier
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

case class KeyColumnUsageViewRow(
  constraintCatalog: Option[SqlIdentifier],
  constraintSchema: Option[SqlIdentifier],
  constraintName: Option[SqlIdentifier],
  tableCatalog: Option[SqlIdentifier],
  tableSchema: Option[SqlIdentifier],
  tableName: Option[SqlIdentifier],
  columnName: Option[SqlIdentifier],
  ordinalPosition: Option[CardinalNumber],
  positionInUniqueConstraint: Option[CardinalNumber]
)

object KeyColumnUsageViewRow {
  implicit val reads: Reads[KeyColumnUsageViewRow] = Reads[KeyColumnUsageViewRow](json => JsResult.fromTry(
      Try(
        KeyColumnUsageViewRow(
          constraintCatalog = json.\("constraint_catalog").toOption.map(_.as(SqlIdentifier.reads)),
          constraintSchema = json.\("constraint_schema").toOption.map(_.as(SqlIdentifier.reads)),
          constraintName = json.\("constraint_name").toOption.map(_.as(SqlIdentifier.reads)),
          tableCatalog = json.\("table_catalog").toOption.map(_.as(SqlIdentifier.reads)),
          tableSchema = json.\("table_schema").toOption.map(_.as(SqlIdentifier.reads)),
          tableName = json.\("table_name").toOption.map(_.as(SqlIdentifier.reads)),
          columnName = json.\("column_name").toOption.map(_.as(SqlIdentifier.reads)),
          ordinalPosition = json.\("ordinal_position").toOption.map(_.as(CardinalNumber.reads)),
          positionInUniqueConstraint = json.\("position_in_unique_constraint").toOption.map(_.as(CardinalNumber.reads))
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[KeyColumnUsageViewRow] = RowParser[KeyColumnUsageViewRow] { row =>
    Success(
      KeyColumnUsageViewRow(
        constraintCatalog = row(idx + 0)(Column.columnToOption(SqlIdentifier.column)),
        constraintSchema = row(idx + 1)(Column.columnToOption(SqlIdentifier.column)),
        constraintName = row(idx + 2)(Column.columnToOption(SqlIdentifier.column)),
        tableCatalog = row(idx + 3)(Column.columnToOption(SqlIdentifier.column)),
        tableSchema = row(idx + 4)(Column.columnToOption(SqlIdentifier.column)),
        tableName = row(idx + 5)(Column.columnToOption(SqlIdentifier.column)),
        columnName = row(idx + 6)(Column.columnToOption(SqlIdentifier.column)),
        ordinalPosition = row(idx + 7)(Column.columnToOption(CardinalNumber.column)),
        positionInUniqueConstraint = row(idx + 8)(Column.columnToOption(CardinalNumber.column))
      )
    )
  }
  implicit val writes: OWrites[KeyColumnUsageViewRow] = OWrites[KeyColumnUsageViewRow](o =>
    new JsObject(ListMap[String, JsValue](
      "constraint_catalog" -> Writes.OptionWrites(SqlIdentifier.writes).writes(o.constraintCatalog),
      "constraint_schema" -> Writes.OptionWrites(SqlIdentifier.writes).writes(o.constraintSchema),
      "constraint_name" -> Writes.OptionWrites(SqlIdentifier.writes).writes(o.constraintName),
      "table_catalog" -> Writes.OptionWrites(SqlIdentifier.writes).writes(o.tableCatalog),
      "table_schema" -> Writes.OptionWrites(SqlIdentifier.writes).writes(o.tableSchema),
      "table_name" -> Writes.OptionWrites(SqlIdentifier.writes).writes(o.tableName),
      "column_name" -> Writes.OptionWrites(SqlIdentifier.writes).writes(o.columnName),
      "ordinal_position" -> Writes.OptionWrites(CardinalNumber.writes).writes(o.ordinalPosition),
      "position_in_unique_constraint" -> Writes.OptionWrites(CardinalNumber.writes).writes(o.positionInUniqueConstraint)
    ))
  )
}