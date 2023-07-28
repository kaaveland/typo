/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package foreign_data_wrapper_options

import adventureworks.information_schema.CharacterData
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

case class ForeignDataWrapperOptionsViewRow(
  /** Points to [[`_pg_foreign_data_wrappers`.PgForeignDataWrappersViewRow.foreignDataWrapperCatalog]] */
  foreignDataWrapperCatalog: Option[SqlIdentifier],
  /** Points to [[`_pg_foreign_data_wrappers`.PgForeignDataWrappersViewRow.foreignDataWrapperName]] */
  foreignDataWrapperName: Option[SqlIdentifier],
  optionName: Option[SqlIdentifier],
  optionValue: Option[CharacterData]
)

object ForeignDataWrapperOptionsViewRow {
  implicit val reads: Reads[ForeignDataWrapperOptionsViewRow] = Reads[ForeignDataWrapperOptionsViewRow](json => JsResult.fromTry(
      Try(
        ForeignDataWrapperOptionsViewRow(
          foreignDataWrapperCatalog = json.\("foreign_data_wrapper_catalog").toOption.map(_.as(SqlIdentifier.reads)),
          foreignDataWrapperName = json.\("foreign_data_wrapper_name").toOption.map(_.as(SqlIdentifier.reads)),
          optionName = json.\("option_name").toOption.map(_.as(SqlIdentifier.reads)),
          optionValue = json.\("option_value").toOption.map(_.as(CharacterData.reads))
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[ForeignDataWrapperOptionsViewRow] = RowParser[ForeignDataWrapperOptionsViewRow] { row =>
    Success(
      ForeignDataWrapperOptionsViewRow(
        foreignDataWrapperCatalog = row(idx + 0)(Column.columnToOption(SqlIdentifier.column)),
        foreignDataWrapperName = row(idx + 1)(Column.columnToOption(SqlIdentifier.column)),
        optionName = row(idx + 2)(Column.columnToOption(SqlIdentifier.column)),
        optionValue = row(idx + 3)(Column.columnToOption(CharacterData.column))
      )
    )
  }
  implicit val writes: OWrites[ForeignDataWrapperOptionsViewRow] = OWrites[ForeignDataWrapperOptionsViewRow](o =>
    new JsObject(ListMap[String, JsValue](
      "foreign_data_wrapper_catalog" -> Writes.OptionWrites(SqlIdentifier.writes).writes(o.foreignDataWrapperCatalog),
      "foreign_data_wrapper_name" -> Writes.OptionWrites(SqlIdentifier.writes).writes(o.foreignDataWrapperName),
      "option_name" -> Writes.OptionWrites(SqlIdentifier.writes).writes(o.optionName),
      "option_value" -> Writes.OptionWrites(CharacterData.writes).writes(o.optionValue)
    ))
  )
}