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
import typo.dsl.SqlExpr.OptField

trait SqlFeaturesFields[Row] {
  val featureId: OptField[CharacterData, Row]
  val featureName: OptField[CharacterData, Row]
  val subFeatureId: OptField[CharacterData, Row]
  val subFeatureName: OptField[CharacterData, Row]
  val isSupported: OptField[YesOrNo, Row]
  val isVerifiedBy: OptField[CharacterData, Row]
  val comments: OptField[CharacterData, Row]
}
object SqlFeaturesFields extends SqlFeaturesStructure[SqlFeaturesRow](None, identity, (_, x) => x)

