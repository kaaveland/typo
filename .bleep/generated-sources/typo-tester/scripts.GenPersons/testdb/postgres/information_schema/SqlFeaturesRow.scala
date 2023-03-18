package testdb
package postgres
package information_schema

import anorm.RowParser
import anorm.Success
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try

case class SqlFeaturesRow(
  featureId: Option[String],
  featureName: Option[String],
  subFeatureId: Option[String],
  subFeatureName: Option[String],
  isSupported: Option[String],
  isVerifiedBy: Option[String],
  comments: Option[String]
)

object SqlFeaturesRow {
  implicit val rowParser: RowParser[SqlFeaturesRow] = { row =>
    Success(
      SqlFeaturesRow(
        featureId = row[Option[String]]("feature_id"),
        featureName = row[Option[String]]("feature_name"),
        subFeatureId = row[Option[String]]("sub_feature_id"),
        subFeatureName = row[Option[String]]("sub_feature_name"),
        isSupported = row[Option[String]]("is_supported"),
        isVerifiedBy = row[Option[String]]("is_verified_by"),
        comments = row[Option[String]]("comments")
      )
    )
  }

  implicit val oFormat: OFormat[SqlFeaturesRow] = new OFormat[SqlFeaturesRow]{
    override def writes(o: SqlFeaturesRow): JsObject =
      Json.obj(
        "feature_id" -> o.featureId,
      "feature_name" -> o.featureName,
      "sub_feature_id" -> o.subFeatureId,
      "sub_feature_name" -> o.subFeatureName,
      "is_supported" -> o.isSupported,
      "is_verified_by" -> o.isVerifiedBy,
      "comments" -> o.comments
      )

    override def reads(json: JsValue): JsResult[SqlFeaturesRow] = {
      JsResult.fromTry(
        Try(
          SqlFeaturesRow(
            featureId = json.\("feature_id").toOption.map(_.as[String]),
            featureName = json.\("feature_name").toOption.map(_.as[String]),
            subFeatureId = json.\("sub_feature_id").toOption.map(_.as[String]),
            subFeatureName = json.\("sub_feature_name").toOption.map(_.as[String]),
            isSupported = json.\("is_supported").toOption.map(_.as[String]),
            isVerifiedBy = json.\("is_verified_by").toOption.map(_.as[String]),
            comments = json.\("comments").toOption.map(_.as[String])
          )
        )
      )
    }
  }
}