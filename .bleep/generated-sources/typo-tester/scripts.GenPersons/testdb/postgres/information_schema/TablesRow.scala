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

case class TablesRow(
  tableCatalog: /* unknown nullability */ Option[String],
  tableSchema: /* unknown nullability */ Option[String],
  tableName: /* unknown nullability */ Option[String],
  tableType: /* unknown nullability */ Option[String],
  selfReferencingColumnName: /* unknown nullability */ Option[String],
  referenceGeneration: /* unknown nullability */ Option[String],
  userDefinedTypeCatalog: /* unknown nullability */ Option[String],
  userDefinedTypeSchema: /* unknown nullability */ Option[String],
  userDefinedTypeName: /* unknown nullability */ Option[String],
  isInsertableInto: /* unknown nullability */ Option[String],
  isTyped: /* unknown nullability */ Option[String],
  commitAction: /* unknown nullability */ Option[String]
)

object TablesRow {
  implicit val rowParser: RowParser[TablesRow] = { row =>
    Success(
      TablesRow(
        tableCatalog = row[/* unknown nullability */ Option[String]]("table_catalog"),
        tableSchema = row[/* unknown nullability */ Option[String]]("table_schema"),
        tableName = row[/* unknown nullability */ Option[String]]("table_name"),
        tableType = row[/* unknown nullability */ Option[String]]("table_type"),
        selfReferencingColumnName = row[/* unknown nullability */ Option[String]]("self_referencing_column_name"),
        referenceGeneration = row[/* unknown nullability */ Option[String]]("reference_generation"),
        userDefinedTypeCatalog = row[/* unknown nullability */ Option[String]]("user_defined_type_catalog"),
        userDefinedTypeSchema = row[/* unknown nullability */ Option[String]]("user_defined_type_schema"),
        userDefinedTypeName = row[/* unknown nullability */ Option[String]]("user_defined_type_name"),
        isInsertableInto = row[/* unknown nullability */ Option[String]]("is_insertable_into"),
        isTyped = row[/* unknown nullability */ Option[String]]("is_typed"),
        commitAction = row[/* unknown nullability */ Option[String]]("commit_action")
      )
    )
  }

  implicit val oFormat: OFormat[TablesRow] = new OFormat[TablesRow]{
    override def writes(o: TablesRow): JsObject =
      Json.obj(
        "table_catalog" -> o.tableCatalog,
      "table_schema" -> o.tableSchema,
      "table_name" -> o.tableName,
      "table_type" -> o.tableType,
      "self_referencing_column_name" -> o.selfReferencingColumnName,
      "reference_generation" -> o.referenceGeneration,
      "user_defined_type_catalog" -> o.userDefinedTypeCatalog,
      "user_defined_type_schema" -> o.userDefinedTypeSchema,
      "user_defined_type_name" -> o.userDefinedTypeName,
      "is_insertable_into" -> o.isInsertableInto,
      "is_typed" -> o.isTyped,
      "commit_action" -> o.commitAction
      )

    override def reads(json: JsValue): JsResult[TablesRow] = {
      JsResult.fromTry(
        Try(
          TablesRow(
            tableCatalog = json.\("table_catalog").toOption.map(_.as[String]),
            tableSchema = json.\("table_schema").toOption.map(_.as[String]),
            tableName = json.\("table_name").toOption.map(_.as[String]),
            tableType = json.\("table_type").toOption.map(_.as[String]),
            selfReferencingColumnName = json.\("self_referencing_column_name").toOption.map(_.as[String]),
            referenceGeneration = json.\("reference_generation").toOption.map(_.as[String]),
            userDefinedTypeCatalog = json.\("user_defined_type_catalog").toOption.map(_.as[String]),
            userDefinedTypeSchema = json.\("user_defined_type_schema").toOption.map(_.as[String]),
            userDefinedTypeName = json.\("user_defined_type_name").toOption.map(_.as[String]),
            isInsertableInto = json.\("is_insertable_into").toOption.map(_.as[String]),
            isTyped = json.\("is_typed").toOption.map(_.as[String]),
            commitAction = json.\("commit_action").toOption.map(_.as[String])
          )
        )
      )
    }
  }
}