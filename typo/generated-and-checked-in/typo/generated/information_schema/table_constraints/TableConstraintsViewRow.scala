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
package table_constraints

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

case class TableConstraintsViewRow(
  /** debug: {"columnClassName":"java.lang.String","columnDisplaySize":2147483647,"parsedColumnName":{"name":"constraint_catalog"},"columnName":"constraint_catalog","columnType":"VarChar","columnTypeName":"name","format":0,"isAutoIncrement":false,"isCaseSensitive":true,"isCurrency":false,"isDefinitelyWritable":false,"isNullable":"NullableUnknown","isReadOnly":false,"isSearchable":true,"isSigned":false,"isWritable":true,"precision":2147483647,"scale":0} */
  constraintCatalog: /* nullability unknown */ Option[String],
  /** debug: {"columnClassName":"java.lang.String","columnDisplaySize":2147483647,"parsedColumnName":{"name":"constraint_schema"},"columnName":"constraint_schema","columnType":"VarChar","columnTypeName":"name","format":0,"isAutoIncrement":false,"isCaseSensitive":true,"isCurrency":false,"isDefinitelyWritable":false,"isNullable":"NullableUnknown","isReadOnly":false,"isSearchable":true,"isSigned":false,"isWritable":true,"precision":2147483647,"scale":0} */
  constraintSchema: /* nullability unknown */ Option[String],
  /** debug: {"columnClassName":"java.lang.String","columnDisplaySize":2147483647,"parsedColumnName":{"name":"constraint_name"},"columnName":"constraint_name","columnType":"VarChar","columnTypeName":"name","format":0,"isAutoIncrement":false,"isCaseSensitive":true,"isCurrency":false,"isDefinitelyWritable":false,"isNullable":"NullableUnknown","isReadOnly":false,"isSearchable":true,"isSigned":false,"isWritable":true,"precision":2147483647,"scale":0} */
  constraintName: /* nullability unknown */ Option[String],
  /** debug: {"columnClassName":"java.lang.String","columnDisplaySize":2147483647,"parsedColumnName":{"name":"table_catalog"},"columnName":"table_catalog","columnType":"VarChar","columnTypeName":"name","format":0,"isAutoIncrement":false,"isCaseSensitive":true,"isCurrency":false,"isDefinitelyWritable":false,"isNullable":"NullableUnknown","isReadOnly":false,"isSearchable":true,"isSigned":false,"isWritable":true,"precision":2147483647,"scale":0} */
  tableCatalog: /* nullability unknown */ Option[String],
  /** debug: {"columnClassName":"java.lang.String","columnDisplaySize":2147483647,"parsedColumnName":{"name":"table_schema"},"columnName":"table_schema","columnType":"VarChar","columnTypeName":"name","format":0,"isAutoIncrement":false,"isCaseSensitive":true,"isCurrency":false,"isDefinitelyWritable":false,"isNullable":"NullableUnknown","isReadOnly":false,"isSearchable":true,"isSigned":false,"isWritable":true,"precision":2147483647,"scale":0} */
  tableSchema: /* nullability unknown */ Option[String],
  /** debug: {"columnClassName":"java.lang.String","columnDisplaySize":2147483647,"parsedColumnName":{"name":"table_name"},"columnName":"table_name","columnType":"VarChar","columnTypeName":"name","format":0,"isAutoIncrement":false,"isCaseSensitive":true,"isCurrency":false,"isDefinitelyWritable":false,"isNullable":"NullableUnknown","isReadOnly":false,"isSearchable":true,"isSigned":false,"isWritable":true,"precision":2147483647,"scale":0} */
  tableName: /* nullability unknown */ Option[String],
  /** debug: {"columnClassName":"java.lang.String","columnDisplaySize":2147483647,"parsedColumnName":{"name":"constraint_type"},"columnName":"constraint_type","columnType":"VarChar","columnTypeName":"varchar","format":0,"isAutoIncrement":false,"isCaseSensitive":true,"isCurrency":false,"isDefinitelyWritable":false,"isNullable":"NullableUnknown","isReadOnly":false,"isSearchable":true,"isSigned":false,"isWritable":true,"precision":2147483647,"scale":0} */
  constraintType: /* nullability unknown */ Option[String],
  /** debug: {"columnClassName":"java.lang.String","columnDisplaySize":3,"parsedColumnName":{"name":"is_deferrable"},"columnName":"is_deferrable","columnType":"VarChar","columnTypeName":"varchar","format":0,"isAutoIncrement":false,"isCaseSensitive":true,"isCurrency":false,"isDefinitelyWritable":false,"isNullable":"NullableUnknown","isReadOnly":false,"isSearchable":true,"isSigned":false,"isWritable":true,"precision":3,"scale":0} */
  isDeferrable: /* nullability unknown */ Option[/* max 3 chars */ String],
  /** debug: {"columnClassName":"java.lang.String","columnDisplaySize":3,"parsedColumnName":{"name":"initially_deferred"},"columnName":"initially_deferred","columnType":"VarChar","columnTypeName":"varchar","format":0,"isAutoIncrement":false,"isCaseSensitive":true,"isCurrency":false,"isDefinitelyWritable":false,"isNullable":"NullableUnknown","isReadOnly":false,"isSearchable":true,"isSigned":false,"isWritable":true,"precision":3,"scale":0} */
  initiallyDeferred: /* nullability unknown */ Option[/* max 3 chars */ String],
  /** debug: {"columnClassName":"java.lang.String","columnDisplaySize":3,"parsedColumnName":{"name":"enforced"},"columnName":"enforced","columnType":"VarChar","columnTypeName":"varchar","format":0,"isAutoIncrement":false,"isCaseSensitive":true,"isCurrency":false,"isDefinitelyWritable":false,"isNullable":"NullableUnknown","isReadOnly":false,"isSearchable":true,"isSigned":false,"isWritable":true,"precision":3,"scale":0} */
  enforced: /* nullability unknown */ Option[/* max 3 chars */ String]
)

object TableConstraintsViewRow {
  implicit lazy val reads: Reads[TableConstraintsViewRow] = Reads[TableConstraintsViewRow](json => JsResult.fromTry(
      Try(
        TableConstraintsViewRow(
          constraintCatalog = json.\("constraint_catalog").toOption.map(_.as(Reads.StringReads)),
          constraintSchema = json.\("constraint_schema").toOption.map(_.as(Reads.StringReads)),
          constraintName = json.\("constraint_name").toOption.map(_.as(Reads.StringReads)),
          tableCatalog = json.\("table_catalog").toOption.map(_.as(Reads.StringReads)),
          tableSchema = json.\("table_schema").toOption.map(_.as(Reads.StringReads)),
          tableName = json.\("table_name").toOption.map(_.as(Reads.StringReads)),
          constraintType = json.\("constraint_type").toOption.map(_.as(Reads.StringReads)),
          isDeferrable = json.\("is_deferrable").toOption.map(_.as(Reads.StringReads)),
          initiallyDeferred = json.\("initially_deferred").toOption.map(_.as(Reads.StringReads)),
          enforced = json.\("enforced").toOption.map(_.as(Reads.StringReads))
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[TableConstraintsViewRow] = RowParser[TableConstraintsViewRow] { row =>
    Success(
      TableConstraintsViewRow(
        constraintCatalog = row(idx + 0)(Column.columnToOption(Column.columnToString)),
        constraintSchema = row(idx + 1)(Column.columnToOption(Column.columnToString)),
        constraintName = row(idx + 2)(Column.columnToOption(Column.columnToString)),
        tableCatalog = row(idx + 3)(Column.columnToOption(Column.columnToString)),
        tableSchema = row(idx + 4)(Column.columnToOption(Column.columnToString)),
        tableName = row(idx + 5)(Column.columnToOption(Column.columnToString)),
        constraintType = row(idx + 6)(Column.columnToOption(Column.columnToString)),
        isDeferrable = row(idx + 7)(Column.columnToOption(Column.columnToString)),
        initiallyDeferred = row(idx + 8)(Column.columnToOption(Column.columnToString)),
        enforced = row(idx + 9)(Column.columnToOption(Column.columnToString))
      )
    )
  }
  implicit lazy val writes: OWrites[TableConstraintsViewRow] = OWrites[TableConstraintsViewRow](o =>
    new JsObject(ListMap[String, JsValue](
      "constraint_catalog" -> Writes.OptionWrites(Writes.StringWrites).writes(o.constraintCatalog),
      "constraint_schema" -> Writes.OptionWrites(Writes.StringWrites).writes(o.constraintSchema),
      "constraint_name" -> Writes.OptionWrites(Writes.StringWrites).writes(o.constraintName),
      "table_catalog" -> Writes.OptionWrites(Writes.StringWrites).writes(o.tableCatalog),
      "table_schema" -> Writes.OptionWrites(Writes.StringWrites).writes(o.tableSchema),
      "table_name" -> Writes.OptionWrites(Writes.StringWrites).writes(o.tableName),
      "constraint_type" -> Writes.OptionWrites(Writes.StringWrites).writes(o.constraintType),
      "is_deferrable" -> Writes.OptionWrites(Writes.StringWrites).writes(o.isDeferrable),
      "initially_deferred" -> Writes.OptionWrites(Writes.StringWrites).writes(o.initiallyDeferred),
      "enforced" -> Writes.OptionWrites(Writes.StringWrites).writes(o.enforced)
    ))
  )
}
