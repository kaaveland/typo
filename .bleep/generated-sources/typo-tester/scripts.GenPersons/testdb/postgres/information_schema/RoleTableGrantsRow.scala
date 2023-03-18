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

case class RoleTableGrantsRow(
  /** Points to [[TablePrivilegesRow.grantor]] */
  grantor: Option[String],
  /** Points to [[TablePrivilegesRow.grantee]] */
  grantee: Option[String],
  /** Points to [[TablePrivilegesRow.tableCatalog]] */
  tableCatalog: Option[String],
  /** Points to [[TablePrivilegesRow.tableSchema]] */
  tableSchema: Option[String],
  /** Points to [[TablePrivilegesRow.tableName]] */
  tableName: Option[String],
  /** Points to [[TablePrivilegesRow.privilegeType]] */
  privilegeType: Option[String],
  /** Points to [[TablePrivilegesRow.isGrantable]] */
  isGrantable: Option[String],
  /** Points to [[TablePrivilegesRow.withHierarchy]] */
  withHierarchy: Option[String]
)

object RoleTableGrantsRow {
  implicit val rowParser: RowParser[RoleTableGrantsRow] = { row =>
    Success(
      RoleTableGrantsRow(
        grantor = row[Option[String]]("grantor"),
        grantee = row[Option[String]]("grantee"),
        tableCatalog = row[Option[String]]("table_catalog"),
        tableSchema = row[Option[String]]("table_schema"),
        tableName = row[Option[String]]("table_name"),
        privilegeType = row[Option[String]]("privilege_type"),
        isGrantable = row[Option[String]]("is_grantable"),
        withHierarchy = row[Option[String]]("with_hierarchy")
      )
    )
  }

  implicit val oFormat: OFormat[RoleTableGrantsRow] = new OFormat[RoleTableGrantsRow]{
    override def writes(o: RoleTableGrantsRow): JsObject =
      Json.obj(
        "grantor" -> o.grantor,
      "grantee" -> o.grantee,
      "table_catalog" -> o.tableCatalog,
      "table_schema" -> o.tableSchema,
      "table_name" -> o.tableName,
      "privilege_type" -> o.privilegeType,
      "is_grantable" -> o.isGrantable,
      "with_hierarchy" -> o.withHierarchy
      )

    override def reads(json: JsValue): JsResult[RoleTableGrantsRow] = {
      JsResult.fromTry(
        Try(
          RoleTableGrantsRow(
            grantor = json.\("grantor").toOption.map(_.as[String]),
            grantee = json.\("grantee").toOption.map(_.as[String]),
            tableCatalog = json.\("table_catalog").toOption.map(_.as[String]),
            tableSchema = json.\("table_schema").toOption.map(_.as[String]),
            tableName = json.\("table_name").toOption.map(_.as[String]),
            privilegeType = json.\("privilege_type").toOption.map(_.as[String]),
            isGrantable = json.\("is_grantable").toOption.map(_.as[String]),
            withHierarchy = json.\("with_hierarchy").toOption.map(_.as[String])
          )
        )
      )
    }
  }
}