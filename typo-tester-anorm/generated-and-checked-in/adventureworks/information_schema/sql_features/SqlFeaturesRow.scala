/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package sql_features

import adventureworks.information_schema.CharacterData
import adventureworks.information_schema.YesOrNo
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

case class SqlFeaturesRow(
  featureId: Option[CharacterData],
  featureName: Option[CharacterData],
  subFeatureId: Option[CharacterData],
  subFeatureName: Option[CharacterData],
  isSupported: Option[YesOrNo],
  isVerifiedBy: Option[CharacterData],
  comments: Option[CharacterData]
)

object SqlFeaturesRow {
  implicit lazy val reads: Reads[SqlFeaturesRow] = Reads[SqlFeaturesRow](json => JsResult.fromTry(
      Try(
        SqlFeaturesRow(
          featureId = json.\("feature_id").toOption.map(_.as(CharacterData.reads)),
          featureName = json.\("feature_name").toOption.map(_.as(CharacterData.reads)),
          subFeatureId = json.\("sub_feature_id").toOption.map(_.as(CharacterData.reads)),
          subFeatureName = json.\("sub_feature_name").toOption.map(_.as(CharacterData.reads)),
          isSupported = json.\("is_supported").toOption.map(_.as(YesOrNo.reads)),
          isVerifiedBy = json.\("is_verified_by").toOption.map(_.as(CharacterData.reads)),
          comments = json.\("comments").toOption.map(_.as(CharacterData.reads))
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[SqlFeaturesRow] = RowParser[SqlFeaturesRow] { row =>
    Success(
      SqlFeaturesRow(
        featureId = row(idx + 0)(Column.columnToOption(CharacterData.column)),
        featureName = row(idx + 1)(Column.columnToOption(CharacterData.column)),
        subFeatureId = row(idx + 2)(Column.columnToOption(CharacterData.column)),
        subFeatureName = row(idx + 3)(Column.columnToOption(CharacterData.column)),
        isSupported = row(idx + 4)(Column.columnToOption(YesOrNo.column)),
        isVerifiedBy = row(idx + 5)(Column.columnToOption(CharacterData.column)),
        comments = row(idx + 6)(Column.columnToOption(CharacterData.column))
      )
    )
  }
  implicit lazy val writes: OWrites[SqlFeaturesRow] = OWrites[SqlFeaturesRow](o =>
    new JsObject(ListMap[String, JsValue](
      "feature_id" -> Writes.OptionWrites(CharacterData.writes).writes(o.featureId),
      "feature_name" -> Writes.OptionWrites(CharacterData.writes).writes(o.featureName),
      "sub_feature_id" -> Writes.OptionWrites(CharacterData.writes).writes(o.subFeatureId),
      "sub_feature_name" -> Writes.OptionWrites(CharacterData.writes).writes(o.subFeatureName),
      "is_supported" -> Writes.OptionWrites(YesOrNo.writes).writes(o.isSupported),
      "is_verified_by" -> Writes.OptionWrites(CharacterData.writes).writes(o.isVerifiedBy),
      "comments" -> Writes.OptionWrites(CharacterData.writes).writes(o.comments)
    ))
  )
}