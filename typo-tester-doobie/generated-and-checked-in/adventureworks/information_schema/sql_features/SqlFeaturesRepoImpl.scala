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
import doobie.free.connection.ConnectionIO
import doobie.syntax.SqlInterpolator.SingleFragment.fromWrite
import doobie.syntax.string.toSqlInterpolator
import doobie.util.Write
import fs2.Stream
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql
import typo.dsl.UpdateBuilder

object SqlFeaturesRepoImpl extends SqlFeaturesRepo {
  override def delete: DeleteBuilder[SqlFeaturesFields, SqlFeaturesRow] = {
    DeleteBuilder("information_schema.sql_features", SqlFeaturesFields)
  }
  override def insert(unsaved: SqlFeaturesRow): ConnectionIO[SqlFeaturesRow] = {
    sql"""insert into information_schema.sql_features(feature_id, feature_name, sub_feature_id, sub_feature_name, is_supported, is_verified_by, "comments")
          values (${fromWrite(unsaved.featureId)(Write.fromPutOption(CharacterData.put))}::varchar, ${fromWrite(unsaved.featureName)(Write.fromPutOption(CharacterData.put))}::varchar, ${fromWrite(unsaved.subFeatureId)(Write.fromPutOption(CharacterData.put))}::varchar, ${fromWrite(unsaved.subFeatureName)(Write.fromPutOption(CharacterData.put))}::varchar, ${fromWrite(unsaved.isSupported)(Write.fromPutOption(YesOrNo.put))}::varchar, ${fromWrite(unsaved.isVerifiedBy)(Write.fromPutOption(CharacterData.put))}::varchar, ${fromWrite(unsaved.comments)(Write.fromPutOption(CharacterData.put))}::varchar)
          returning feature_id, feature_name, sub_feature_id, sub_feature_name, is_supported, is_verified_by, "comments"
       """.query(SqlFeaturesRow.read).unique
  }
  override def select: SelectBuilder[SqlFeaturesFields, SqlFeaturesRow] = {
    SelectBuilderSql("information_schema.sql_features", SqlFeaturesFields, SqlFeaturesRow.read)
  }
  override def selectAll: Stream[ConnectionIO, SqlFeaturesRow] = {
    sql"""select feature_id, feature_name, sub_feature_id, sub_feature_name, is_supported, is_verified_by, "comments" from information_schema.sql_features""".query(SqlFeaturesRow.read).stream
  }
  override def update: UpdateBuilder[SqlFeaturesFields, SqlFeaturesRow] = {
    UpdateBuilder("information_schema.sql_features", SqlFeaturesFields, SqlFeaturesRow.read)
  }
}
