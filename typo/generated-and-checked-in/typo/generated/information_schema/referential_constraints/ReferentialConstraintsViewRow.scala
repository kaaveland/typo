/**
 * File has been automatically generated by `typo` for internal use.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 *
 * (If you're developing `typo` and want to change it: run `bleep generate-sources`)
 */
package typo
package generated
package information_schema
package referential_constraints

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

case class ReferentialConstraintsViewRow(
  /** debug: {"columnClassName":"java.lang.String","columnDisplaySize":2147483647,"parsedColumnName":{"name":"constraint_catalog"},"columnName":"constraint_catalog","columnType":"VarChar","columnTypeName":"name","format":0,"isAutoIncrement":false,"isCaseSensitive":true,"isCurrency":false,"isDefinitelyWritable":false,"isNullable":"NullableUnknown","isReadOnly":false,"isSearchable":true,"isSigned":false,"isWritable":true,"precision":2147483647,"scale":0} */
  constraintCatalog: /* nullability unknown */ Option[String],
  /** debug: {"columnClassName":"java.lang.String","columnDisplaySize":2147483647,"parsedColumnName":{"name":"constraint_schema"},"columnName":"constraint_schema","columnType":"VarChar","columnTypeName":"name","format":0,"isAutoIncrement":false,"isCaseSensitive":true,"isCurrency":false,"isDefinitelyWritable":false,"isNullable":"NullableUnknown","isReadOnly":false,"isSearchable":true,"isSigned":false,"isWritable":true,"precision":2147483647,"scale":0} */
  constraintSchema: /* nullability unknown */ Option[String],
  /** debug: {"columnClassName":"java.lang.String","columnDisplaySize":2147483647,"parsedColumnName":{"name":"constraint_name"},"columnName":"constraint_name","columnType":"VarChar","columnTypeName":"name","format":0,"isAutoIncrement":false,"isCaseSensitive":true,"isCurrency":false,"isDefinitelyWritable":false,"isNullable":"NullableUnknown","isReadOnly":false,"isSearchable":true,"isSigned":false,"isWritable":true,"precision":2147483647,"scale":0} */
  constraintName: /* nullability unknown */ Option[String],
  /** debug: {"columnClassName":"java.lang.String","columnDisplaySize":2147483647,"parsedColumnName":{"name":"unique_constraint_catalog"},"columnName":"unique_constraint_catalog","columnType":"VarChar","columnTypeName":"name","format":0,"isAutoIncrement":false,"isCaseSensitive":true,"isCurrency":false,"isDefinitelyWritable":false,"isNullable":"NullableUnknown","isReadOnly":false,"isSearchable":true,"isSigned":false,"isWritable":true,"precision":2147483647,"scale":0} */
  uniqueConstraintCatalog: /* nullability unknown */ Option[String],
  /** debug: {"columnClassName":"java.lang.String","columnDisplaySize":2147483647,"parsedColumnName":{"name":"unique_constraint_schema"},"columnName":"unique_constraint_schema","columnType":"VarChar","columnTypeName":"name","format":0,"isAutoIncrement":false,"isCaseSensitive":true,"isCurrency":false,"isDefinitelyWritable":false,"isNullable":"NullableUnknown","isReadOnly":false,"isSearchable":true,"isSigned":false,"isWritable":true,"precision":2147483647,"scale":0} */
  uniqueConstraintSchema: /* nullability unknown */ Option[String],
  /** debug: {"columnClassName":"java.lang.String","columnDisplaySize":2147483647,"parsedColumnName":{"name":"unique_constraint_name"},"columnName":"unique_constraint_name","columnType":"VarChar","columnTypeName":"name","format":0,"isAutoIncrement":false,"isCaseSensitive":true,"isCurrency":false,"isDefinitelyWritable":false,"isNullable":"NullableUnknown","isReadOnly":false,"isSearchable":true,"isSigned":false,"isWritable":true,"precision":2147483647,"scale":0} */
  uniqueConstraintName: /* nullability unknown */ Option[String],
  /** debug: {"columnClassName":"java.lang.String","columnDisplaySize":2147483647,"parsedColumnName":{"name":"match_option"},"columnName":"match_option","columnType":"VarChar","columnTypeName":"varchar","format":0,"isAutoIncrement":false,"isCaseSensitive":true,"isCurrency":false,"isDefinitelyWritable":false,"isNullable":"NullableUnknown","isReadOnly":false,"isSearchable":true,"isSigned":false,"isWritable":true,"precision":2147483647,"scale":0} */
  matchOption: /* nullability unknown */ Option[String],
  /** debug: {"columnClassName":"java.lang.String","columnDisplaySize":2147483647,"parsedColumnName":{"name":"update_rule"},"columnName":"update_rule","columnType":"VarChar","columnTypeName":"varchar","format":0,"isAutoIncrement":false,"isCaseSensitive":true,"isCurrency":false,"isDefinitelyWritable":false,"isNullable":"NullableUnknown","isReadOnly":false,"isSearchable":true,"isSigned":false,"isWritable":true,"precision":2147483647,"scale":0} */
  updateRule: /* nullability unknown */ Option[String],
  /** debug: {"columnClassName":"java.lang.String","columnDisplaySize":2147483647,"parsedColumnName":{"name":"delete_rule"},"columnName":"delete_rule","columnType":"VarChar","columnTypeName":"varchar","format":0,"isAutoIncrement":false,"isCaseSensitive":true,"isCurrency":false,"isDefinitelyWritable":false,"isNullable":"NullableUnknown","isReadOnly":false,"isSearchable":true,"isSigned":false,"isWritable":true,"precision":2147483647,"scale":0} */
  deleteRule: /* nullability unknown */ Option[String]
)

object ReferentialConstraintsViewRow {
  implicit lazy val reads: Reads[ReferentialConstraintsViewRow] = Reads[ReferentialConstraintsViewRow](json => JsResult.fromTry(
      Try(
        ReferentialConstraintsViewRow(
          constraintCatalog = json.\("constraint_catalog").toOption.map(_.as(Reads.StringReads)),
          constraintSchema = json.\("constraint_schema").toOption.map(_.as(Reads.StringReads)),
          constraintName = json.\("constraint_name").toOption.map(_.as(Reads.StringReads)),
          uniqueConstraintCatalog = json.\("unique_constraint_catalog").toOption.map(_.as(Reads.StringReads)),
          uniqueConstraintSchema = json.\("unique_constraint_schema").toOption.map(_.as(Reads.StringReads)),
          uniqueConstraintName = json.\("unique_constraint_name").toOption.map(_.as(Reads.StringReads)),
          matchOption = json.\("match_option").toOption.map(_.as(Reads.StringReads)),
          updateRule = json.\("update_rule").toOption.map(_.as(Reads.StringReads)),
          deleteRule = json.\("delete_rule").toOption.map(_.as(Reads.StringReads))
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[ReferentialConstraintsViewRow] = RowParser[ReferentialConstraintsViewRow] { row =>
    Success(
      ReferentialConstraintsViewRow(
        constraintCatalog = row(idx + 0)(Column.columnToOption(Column.columnToString)),
        constraintSchema = row(idx + 1)(Column.columnToOption(Column.columnToString)),
        constraintName = row(idx + 2)(Column.columnToOption(Column.columnToString)),
        uniqueConstraintCatalog = row(idx + 3)(Column.columnToOption(Column.columnToString)),
        uniqueConstraintSchema = row(idx + 4)(Column.columnToOption(Column.columnToString)),
        uniqueConstraintName = row(idx + 5)(Column.columnToOption(Column.columnToString)),
        matchOption = row(idx + 6)(Column.columnToOption(Column.columnToString)),
        updateRule = row(idx + 7)(Column.columnToOption(Column.columnToString)),
        deleteRule = row(idx + 8)(Column.columnToOption(Column.columnToString))
      )
    )
  }
  implicit lazy val writes: OWrites[ReferentialConstraintsViewRow] = OWrites[ReferentialConstraintsViewRow](o =>
    new JsObject(ListMap[String, JsValue](
      "constraint_catalog" -> Writes.OptionWrites(Writes.StringWrites).writes(o.constraintCatalog),
      "constraint_schema" -> Writes.OptionWrites(Writes.StringWrites).writes(o.constraintSchema),
      "constraint_name" -> Writes.OptionWrites(Writes.StringWrites).writes(o.constraintName),
      "unique_constraint_catalog" -> Writes.OptionWrites(Writes.StringWrites).writes(o.uniqueConstraintCatalog),
      "unique_constraint_schema" -> Writes.OptionWrites(Writes.StringWrites).writes(o.uniqueConstraintSchema),
      "unique_constraint_name" -> Writes.OptionWrites(Writes.StringWrites).writes(o.uniqueConstraintName),
      "match_option" -> Writes.OptionWrites(Writes.StringWrites).writes(o.matchOption),
      "update_rule" -> Writes.OptionWrites(Writes.StringWrites).writes(o.updateRule),
      "delete_rule" -> Writes.OptionWrites(Writes.StringWrites).writes(o.deleteRule)
    ))
  )
}
