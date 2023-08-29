/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package table_privileges

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

case class TablePrivilegesViewRow(
  grantor: /* nullability unknown */ Option[String],
  grantee: /* nullability unknown */ Option[String],
  tableCatalog: /* nullability unknown */ Option[String],
  tableSchema: /* nullability unknown */ Option[String],
  tableName: /* nullability unknown */ Option[String],
  privilegeType: /* nullability unknown */ Option[String],
  isGrantable: /* nullability unknown */ Option[/* max 3 chars */ String],
  withHierarchy: /* nullability unknown */ Option[/* max 3 chars */ String]
)

object TablePrivilegesViewRow {
  implicit lazy val reads: Reads[TablePrivilegesViewRow] = Reads[TablePrivilegesViewRow](json => JsResult.fromTry(
      Try(
        TablePrivilegesViewRow(
          grantor = json.\("grantor").toOption.map(_.as(Reads.StringReads)),
          grantee = json.\("grantee").toOption.map(_.as(Reads.StringReads)),
          tableCatalog = json.\("table_catalog").toOption.map(_.as(Reads.StringReads)),
          tableSchema = json.\("table_schema").toOption.map(_.as(Reads.StringReads)),
          tableName = json.\("table_name").toOption.map(_.as(Reads.StringReads)),
          privilegeType = json.\("privilege_type").toOption.map(_.as(Reads.StringReads)),
          isGrantable = json.\("is_grantable").toOption.map(_.as(Reads.StringReads)),
          withHierarchy = json.\("with_hierarchy").toOption.map(_.as(Reads.StringReads))
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[TablePrivilegesViewRow] = RowParser[TablePrivilegesViewRow] { row =>
    Success(
      TablePrivilegesViewRow(
        grantor = row(idx + 0)(Column.columnToOption(Column.columnToString)),
        grantee = row(idx + 1)(Column.columnToOption(Column.columnToString)),
        tableCatalog = row(idx + 2)(Column.columnToOption(Column.columnToString)),
        tableSchema = row(idx + 3)(Column.columnToOption(Column.columnToString)),
        tableName = row(idx + 4)(Column.columnToOption(Column.columnToString)),
        privilegeType = row(idx + 5)(Column.columnToOption(Column.columnToString)),
        isGrantable = row(idx + 6)(Column.columnToOption(Column.columnToString)),
        withHierarchy = row(idx + 7)(Column.columnToOption(Column.columnToString))
      )
    )
  }
  implicit lazy val writes: OWrites[TablePrivilegesViewRow] = OWrites[TablePrivilegesViewRow](o =>
    new JsObject(ListMap[String, JsValue](
      "grantor" -> Writes.OptionWrites(Writes.StringWrites).writes(o.grantor),
      "grantee" -> Writes.OptionWrites(Writes.StringWrites).writes(o.grantee),
      "table_catalog" -> Writes.OptionWrites(Writes.StringWrites).writes(o.tableCatalog),
      "table_schema" -> Writes.OptionWrites(Writes.StringWrites).writes(o.tableSchema),
      "table_name" -> Writes.OptionWrites(Writes.StringWrites).writes(o.tableName),
      "privilege_type" -> Writes.OptionWrites(Writes.StringWrites).writes(o.privilegeType),
      "is_grantable" -> Writes.OptionWrites(Writes.StringWrites).writes(o.isGrantable),
      "with_hierarchy" -> Writes.OptionWrites(Writes.StringWrites).writes(o.withHierarchy)
    ))
  )
}
