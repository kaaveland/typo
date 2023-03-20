/**
 * File has been automatically generated by `typo` for internal use.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 *
 * (If you're developing `typo` and want to change it: run `bleep generate-sources)
 */
package typo
package generated
package information_schema

import anorm.RowParser
import anorm.Success

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

  
}