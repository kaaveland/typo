/**
 * File has been automatically generated by `typo` for internal use.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 *
 * (If you're developing `typo` and want to change it: run `bleep generate-sources`)
 */
package typo
package generated
package custom
package table_comments

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

case class TableCommentsSqlRow(
  /** Points to [[pg_catalog.pg_namespace.PgNamespaceRow.nspname]]
      debug: {"baseColumnName":"nspname","baseRelationName":"pg_catalog.pg_namespace","columnClassName":"java.lang.String","columnDisplaySize":2147483647,"parsedColumnName":{"name":"schema","originalName":"schema"},"columnName":"schema","columnType":"VarChar","columnTypeName":"name","format":0,"isAutoIncrement":false,"isCaseSensitive":true,"isCurrency":false,"isDefinitelyWritable":false,"isNullable":"NoNulls","isReadOnly":false,"isSearchable":true,"isSigned":false,"isWritable":true,"precision":2147483647,"scale":0,"tableName":"pg_namespace"} */
  schema: String,
  /** Points to [[pg_catalog.pg_class.PgClassRow.relname]]
      debug: {"baseColumnName":"relname","baseRelationName":"pg_catalog.pg_class","columnClassName":"java.lang.String","columnDisplaySize":2147483647,"parsedColumnName":{"name":"name","originalName":"name"},"columnName":"name","columnType":"VarChar","columnTypeName":"name","format":0,"isAutoIncrement":false,"isCaseSensitive":true,"isCurrency":false,"isDefinitelyWritable":false,"isNullable":"NoNulls","isReadOnly":false,"isSearchable":true,"isSigned":false,"isWritable":true,"precision":2147483647,"scale":0,"tableName":"pg_class"} */
  name: String,
  /** debug: {"columnClassName":"java.lang.String","columnDisplaySize":2147483647,"parsedColumnName":{"name":"description","originalName":"description"},"columnName":"description","columnType":"VarChar","columnTypeName":"text","format":0,"isAutoIncrement":false,"isCaseSensitive":true,"isCurrency":false,"isDefinitelyWritable":false,"isNullable":"NullableUnknown","isReadOnly":false,"isSearchable":true,"isSigned":false,"isWritable":true,"precision":2147483647,"scale":0} */
  description: /* nullability unknown */ Option[String]
)

object TableCommentsSqlRow {
  implicit lazy val reads: Reads[TableCommentsSqlRow] = Reads[TableCommentsSqlRow](json => JsResult.fromTry(
      Try(
        TableCommentsSqlRow(
          schema = json.\("schema").as(Reads.StringReads),
          name = json.\("name").as(Reads.StringReads),
          description = json.\("description").toOption.map(_.as(Reads.StringReads))
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[TableCommentsSqlRow] = RowParser[TableCommentsSqlRow] { row =>
    Success(
      TableCommentsSqlRow(
        schema = row(idx + 0)(Column.columnToString),
        name = row(idx + 1)(Column.columnToString),
        description = row(idx + 2)(Column.columnToOption(Column.columnToString))
      )
    )
  }
  implicit lazy val writes: OWrites[TableCommentsSqlRow] = OWrites[TableCommentsSqlRow](o =>
    new JsObject(ListMap[String, JsValue](
      "schema" -> Writes.StringWrites.writes(o.schema),
      "name" -> Writes.StringWrites.writes(o.name),
      "description" -> Writes.OptionWrites(Writes.StringWrites).writes(o.description)
    ))
  )
}
