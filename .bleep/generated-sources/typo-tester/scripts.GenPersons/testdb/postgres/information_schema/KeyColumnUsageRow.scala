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

case class KeyColumnUsageRow(
  constraintCatalog: /* unknown nullability */ Option[String],
  constraintSchema: /* unknown nullability */ Option[String],
  constraintName: /* unknown nullability */ Option[String],
  tableCatalog: /* unknown nullability */ Option[String],
  tableSchema: /* unknown nullability */ Option[String],
  tableName: /* unknown nullability */ Option[String],
  columnName: /* unknown nullability */ Option[String],
  ordinalPosition: /* unknown nullability */ Option[Int],
  positionInUniqueConstraint: /* unknown nullability */ Option[Int]
)

object KeyColumnUsageRow {
  implicit val rowParser: RowParser[KeyColumnUsageRow] = { row =>
    Success(
      KeyColumnUsageRow(
        constraintCatalog = row[/* unknown nullability */ Option[String]]("constraint_catalog"),
        constraintSchema = row[/* unknown nullability */ Option[String]]("constraint_schema"),
        constraintName = row[/* unknown nullability */ Option[String]]("constraint_name"),
        tableCatalog = row[/* unknown nullability */ Option[String]]("table_catalog"),
        tableSchema = row[/* unknown nullability */ Option[String]]("table_schema"),
        tableName = row[/* unknown nullability */ Option[String]]("table_name"),
        columnName = row[/* unknown nullability */ Option[String]]("column_name"),
        ordinalPosition = row[/* unknown nullability */ Option[Int]]("ordinal_position"),
        positionInUniqueConstraint = row[/* unknown nullability */ Option[Int]]("position_in_unique_constraint")
      )
    )
  }

  implicit val oFormat: OFormat[KeyColumnUsageRow] = new OFormat[KeyColumnUsageRow]{
    override def writes(o: KeyColumnUsageRow): JsObject =
      Json.obj(
        "constraint_catalog" -> o.constraintCatalog,
      "constraint_schema" -> o.constraintSchema,
      "constraint_name" -> o.constraintName,
      "table_catalog" -> o.tableCatalog,
      "table_schema" -> o.tableSchema,
      "table_name" -> o.tableName,
      "column_name" -> o.columnName,
      "ordinal_position" -> o.ordinalPosition,
      "position_in_unique_constraint" -> o.positionInUniqueConstraint
      )

    override def reads(json: JsValue): JsResult[KeyColumnUsageRow] = {
      JsResult.fromTry(
        Try(
          KeyColumnUsageRow(
            constraintCatalog = json.\("constraint_catalog").toOption.map(_.as[String]),
            constraintSchema = json.\("constraint_schema").toOption.map(_.as[String]),
            constraintName = json.\("constraint_name").toOption.map(_.as[String]),
            tableCatalog = json.\("table_catalog").toOption.map(_.as[String]),
            tableSchema = json.\("table_schema").toOption.map(_.as[String]),
            tableName = json.\("table_name").toOption.map(_.as[String]),
            columnName = json.\("column_name").toOption.map(_.as[String]),
            ordinalPosition = json.\("ordinal_position").toOption.map(_.as[Int]),
            positionInUniqueConstraint = json.\("position_in_unique_constraint").toOption.map(_.as[Int])
          )
        )
      )
    }
  }
}