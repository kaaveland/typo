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

case class SqlPartsRow(
  featureId: Option[String],
  featureName: Option[String],
  isSupported: Option[String],
  isVerifiedBy: Option[String],
  comments: Option[String]
)

object SqlPartsRow {
  implicit val rowParser: RowParser[SqlPartsRow] = { row =>
    Success(
      SqlPartsRow(
        featureId = row[Option[String]]("feature_id"),
        featureName = row[Option[String]]("feature_name"),
        isSupported = row[Option[String]]("is_supported"),
        isVerifiedBy = row[Option[String]]("is_verified_by"),
        comments = row[Option[String]]("comments")
      )
    )
  }

  implicit val oFormat: OFormat[SqlPartsRow] = new OFormat[SqlPartsRow]{
    override def writes(o: SqlPartsRow): JsObject =
      Json.obj(
        "feature_id" -> o.featureId,
      "feature_name" -> o.featureName,
      "is_supported" -> o.isSupported,
      "is_verified_by" -> o.isVerifiedBy,
      "comments" -> o.comments
      )

    override def reads(json: JsValue): JsResult[SqlPartsRow] = {
      JsResult.fromTry(
        Try(
          SqlPartsRow(
            featureId = json.\("feature_id").toOption.map(_.as[String]),
            featureName = json.\("feature_name").toOption.map(_.as[String]),
            isSupported = json.\("is_supported").toOption.map(_.as[String]),
            isVerifiedBy = json.\("is_verified_by").toOption.map(_.as[String]),
            comments = json.\("comments").toOption.map(_.as[String])
          )
        )
      )
    }
  }
}
