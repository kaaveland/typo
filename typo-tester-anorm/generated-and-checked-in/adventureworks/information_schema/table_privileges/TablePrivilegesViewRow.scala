/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package table_privileges

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

case class TablePrivilegesViewRow(
  grantor: SqlIdentifier,
  grantee: SqlIdentifier,
  tableCatalog: SqlIdentifier,
  tableSchema: SqlIdentifier,
  tableName: SqlIdentifier,
  privilegeType: CharacterData,
  isGrantable: YesOrNo,
  withHierarchy: YesOrNo
)

object TablePrivilegesViewRow {
  implicit lazy val reads: Reads[TablePrivilegesViewRow] = Reads[TablePrivilegesViewRow](json => JsResult.fromTry(
      Try(
        TablePrivilegesViewRow(
          grantor = json.\("grantor").as(SqlIdentifier.reads),
          grantee = json.\("grantee").as(SqlIdentifier.reads),
          tableCatalog = json.\("table_catalog").as(SqlIdentifier.reads),
          tableSchema = json.\("table_schema").as(SqlIdentifier.reads),
          tableName = json.\("table_name").as(SqlIdentifier.reads),
          privilegeType = json.\("privilege_type").as(CharacterData.reads),
          isGrantable = json.\("is_grantable").as(YesOrNo.reads),
          withHierarchy = json.\("with_hierarchy").as(YesOrNo.reads)
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[TablePrivilegesViewRow] = RowParser[TablePrivilegesViewRow] { row =>
    Success(
      TablePrivilegesViewRow(
        grantor = row(idx + 0)(SqlIdentifier.column),
        grantee = row(idx + 1)(SqlIdentifier.column),
        tableCatalog = row(idx + 2)(SqlIdentifier.column),
        tableSchema = row(idx + 3)(SqlIdentifier.column),
        tableName = row(idx + 4)(SqlIdentifier.column),
        privilegeType = row(idx + 5)(CharacterData.column),
        isGrantable = row(idx + 6)(YesOrNo.column),
        withHierarchy = row(idx + 7)(YesOrNo.column)
      )
    )
  }
  implicit lazy val writes: OWrites[TablePrivilegesViewRow] = OWrites[TablePrivilegesViewRow](o =>
    new JsObject(ListMap[String, JsValue](
      "grantor" -> SqlIdentifier.writes.writes(o.grantor),
      "grantee" -> SqlIdentifier.writes.writes(o.grantee),
      "table_catalog" -> SqlIdentifier.writes.writes(o.tableCatalog),
      "table_schema" -> SqlIdentifier.writes.writes(o.tableSchema),
      "table_name" -> SqlIdentifier.writes.writes(o.tableName),
      "privilege_type" -> CharacterData.writes.writes(o.privilegeType),
      "is_grantable" -> YesOrNo.writes.writes(o.isGrantable),
      "with_hierarchy" -> YesOrNo.writes.writes(o.withHierarchy)
    ))
  )
}
