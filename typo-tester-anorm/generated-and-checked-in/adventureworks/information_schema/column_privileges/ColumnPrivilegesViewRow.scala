/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package column_privileges

import adventureworks.information_schema.CharacterData
import adventureworks.information_schema.SqlIdentifier
import adventureworks.information_schema.YesOrNo
import anorm.RowParser
import anorm.Success
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.OWrites
import play.api.libs.json.Reads
import scala.collection.immutable.ListMap
import scala.util.Try

case class ColumnPrivilegesViewRow(
  grantor: SqlIdentifier,
  grantee: SqlIdentifier,
  tableCatalog: SqlIdentifier,
  tableSchema: SqlIdentifier,
  tableName: SqlIdentifier,
  columnName: SqlIdentifier,
  privilegeType: CharacterData,
  isGrantable: YesOrNo
)

object ColumnPrivilegesViewRow {
  implicit lazy val reads: Reads[ColumnPrivilegesViewRow] = Reads[ColumnPrivilegesViewRow](json => JsResult.fromTry(
      Try(
        ColumnPrivilegesViewRow(
          grantor = json.\("grantor").as(SqlIdentifier.reads),
          grantee = json.\("grantee").as(SqlIdentifier.reads),
          tableCatalog = json.\("table_catalog").as(SqlIdentifier.reads),
          tableSchema = json.\("table_schema").as(SqlIdentifier.reads),
          tableName = json.\("table_name").as(SqlIdentifier.reads),
          columnName = json.\("column_name").as(SqlIdentifier.reads),
          privilegeType = json.\("privilege_type").as(CharacterData.reads),
          isGrantable = json.\("is_grantable").as(YesOrNo.reads)
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[ColumnPrivilegesViewRow] = RowParser[ColumnPrivilegesViewRow] { row =>
    Success(
      ColumnPrivilegesViewRow(
        grantor = row(idx + 0)(SqlIdentifier.column),
        grantee = row(idx + 1)(SqlIdentifier.column),
        tableCatalog = row(idx + 2)(SqlIdentifier.column),
        tableSchema = row(idx + 3)(SqlIdentifier.column),
        tableName = row(idx + 4)(SqlIdentifier.column),
        columnName = row(idx + 5)(SqlIdentifier.column),
        privilegeType = row(idx + 6)(CharacterData.column),
        isGrantable = row(idx + 7)(YesOrNo.column)
      )
    )
  }
  implicit lazy val writes: OWrites[ColumnPrivilegesViewRow] = OWrites[ColumnPrivilegesViewRow](o =>
    new JsObject(ListMap[String, JsValue](
      "grantor" -> SqlIdentifier.writes.writes(o.grantor),
      "grantee" -> SqlIdentifier.writes.writes(o.grantee),
      "table_catalog" -> SqlIdentifier.writes.writes(o.tableCatalog),
      "table_schema" -> SqlIdentifier.writes.writes(o.tableSchema),
      "table_name" -> SqlIdentifier.writes.writes(o.tableName),
      "column_name" -> SqlIdentifier.writes.writes(o.columnName),
      "privilege_type" -> CharacterData.writes.writes(o.privilegeType),
      "is_grantable" -> YesOrNo.writes.writes(o.isGrantable)
    ))
  )
}
