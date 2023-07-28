/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package collation_character_set_applicability

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

case class CollationCharacterSetApplicabilityViewRow(
  collationCatalog: Option[SqlIdentifier],
  collationSchema: Option[SqlIdentifier],
  collationName: Option[SqlIdentifier],
  characterSetCatalog: Option[SqlIdentifier],
  characterSetSchema: Option[SqlIdentifier],
  characterSetName: Option[SqlIdentifier]
)

object CollationCharacterSetApplicabilityViewRow {
  implicit val reads: Reads[CollationCharacterSetApplicabilityViewRow] = Reads[CollationCharacterSetApplicabilityViewRow](json => JsResult.fromTry(
      Try(
        CollationCharacterSetApplicabilityViewRow(
          collationCatalog = json.\("collation_catalog").toOption.map(_.as(SqlIdentifier.reads)),
          collationSchema = json.\("collation_schema").toOption.map(_.as(SqlIdentifier.reads)),
          collationName = json.\("collation_name").toOption.map(_.as(SqlIdentifier.reads)),
          characterSetCatalog = json.\("character_set_catalog").toOption.map(_.as(SqlIdentifier.reads)),
          characterSetSchema = json.\("character_set_schema").toOption.map(_.as(SqlIdentifier.reads)),
          characterSetName = json.\("character_set_name").toOption.map(_.as(SqlIdentifier.reads))
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[CollationCharacterSetApplicabilityViewRow] = RowParser[CollationCharacterSetApplicabilityViewRow] { row =>
    Success(
      CollationCharacterSetApplicabilityViewRow(
        collationCatalog = row(idx + 0)(Column.columnToOption(SqlIdentifier.column)),
        collationSchema = row(idx + 1)(Column.columnToOption(SqlIdentifier.column)),
        collationName = row(idx + 2)(Column.columnToOption(SqlIdentifier.column)),
        characterSetCatalog = row(idx + 3)(Column.columnToOption(SqlIdentifier.column)),
        characterSetSchema = row(idx + 4)(Column.columnToOption(SqlIdentifier.column)),
        characterSetName = row(idx + 5)(Column.columnToOption(SqlIdentifier.column))
      )
    )
  }
  implicit val writes: OWrites[CollationCharacterSetApplicabilityViewRow] = OWrites[CollationCharacterSetApplicabilityViewRow](o =>
    new JsObject(ListMap[String, JsValue](
      "collation_catalog" -> Writes.OptionWrites(SqlIdentifier.writes).writes(o.collationCatalog),
      "collation_schema" -> Writes.OptionWrites(SqlIdentifier.writes).writes(o.collationSchema),
      "collation_name" -> Writes.OptionWrites(SqlIdentifier.writes).writes(o.collationName),
      "character_set_catalog" -> Writes.OptionWrites(SqlIdentifier.writes).writes(o.characterSetCatalog),
      "character_set_schema" -> Writes.OptionWrites(SqlIdentifier.writes).writes(o.characterSetSchema),
      "character_set_name" -> Writes.OptionWrites(SqlIdentifier.writes).writes(o.characterSetName)
    ))
  )
}