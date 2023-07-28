/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package transforms

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

case class TransformsViewRow(
  udtCatalog: Option[SqlIdentifier],
  udtSchema: Option[SqlIdentifier],
  udtName: Option[SqlIdentifier],
  specificCatalog: Option[SqlIdentifier],
  specificSchema: Option[SqlIdentifier],
  specificName: Option[SqlIdentifier],
  groupName: Option[SqlIdentifier],
  transformType: Option[CharacterData]
)

object TransformsViewRow {
  implicit val reads: Reads[TransformsViewRow] = Reads[TransformsViewRow](json => JsResult.fromTry(
      Try(
        TransformsViewRow(
          udtCatalog = json.\("udt_catalog").toOption.map(_.as(SqlIdentifier.reads)),
          udtSchema = json.\("udt_schema").toOption.map(_.as(SqlIdentifier.reads)),
          udtName = json.\("udt_name").toOption.map(_.as(SqlIdentifier.reads)),
          specificCatalog = json.\("specific_catalog").toOption.map(_.as(SqlIdentifier.reads)),
          specificSchema = json.\("specific_schema").toOption.map(_.as(SqlIdentifier.reads)),
          specificName = json.\("specific_name").toOption.map(_.as(SqlIdentifier.reads)),
          groupName = json.\("group_name").toOption.map(_.as(SqlIdentifier.reads)),
          transformType = json.\("transform_type").toOption.map(_.as(CharacterData.reads))
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[TransformsViewRow] = RowParser[TransformsViewRow] { row =>
    Success(
      TransformsViewRow(
        udtCatalog = row(idx + 0)(Column.columnToOption(SqlIdentifier.column)),
        udtSchema = row(idx + 1)(Column.columnToOption(SqlIdentifier.column)),
        udtName = row(idx + 2)(Column.columnToOption(SqlIdentifier.column)),
        specificCatalog = row(idx + 3)(Column.columnToOption(SqlIdentifier.column)),
        specificSchema = row(idx + 4)(Column.columnToOption(SqlIdentifier.column)),
        specificName = row(idx + 5)(Column.columnToOption(SqlIdentifier.column)),
        groupName = row(idx + 6)(Column.columnToOption(SqlIdentifier.column)),
        transformType = row(idx + 7)(Column.columnToOption(CharacterData.column))
      )
    )
  }
  implicit val writes: OWrites[TransformsViewRow] = OWrites[TransformsViewRow](o =>
    new JsObject(ListMap[String, JsValue](
      "udt_catalog" -> Writes.OptionWrites(SqlIdentifier.writes).writes(o.udtCatalog),
      "udt_schema" -> Writes.OptionWrites(SqlIdentifier.writes).writes(o.udtSchema),
      "udt_name" -> Writes.OptionWrites(SqlIdentifier.writes).writes(o.udtName),
      "specific_catalog" -> Writes.OptionWrites(SqlIdentifier.writes).writes(o.specificCatalog),
      "specific_schema" -> Writes.OptionWrites(SqlIdentifier.writes).writes(o.specificSchema),
      "specific_name" -> Writes.OptionWrites(SqlIdentifier.writes).writes(o.specificName),
      "group_name" -> Writes.OptionWrites(SqlIdentifier.writes).writes(o.groupName),
      "transform_type" -> Writes.OptionWrites(CharacterData.writes).writes(o.transformType)
    ))
  )
}