package testdb.information_schema

import anorm.RowParser
import anorm.Success
import play.api.libs.json.Json
import play.api.libs.json.OFormat

case class ViewColumnUsageRow(
  viewCatalog: /* unknown nullability */ Option[String],
  viewSchema: /* unknown nullability */ Option[String],
  viewName: /* unknown nullability */ Option[String],
  tableCatalog: /* unknown nullability */ Option[String],
  tableSchema: /* unknown nullability */ Option[String],
  tableName: /* unknown nullability */ Option[String],
  columnName: /* unknown nullability */ Option[String]
)

object ViewColumnUsageRow {
  implicit val rowParser: RowParser[ViewColumnUsageRow] = { row =>
    Success(
      ViewColumnUsageRow(
        viewCatalog = row[/* unknown nullability */ Option[String]]("view_catalog"),
        viewSchema = row[/* unknown nullability */ Option[String]]("view_schema"),
        viewName = row[/* unknown nullability */ Option[String]]("view_name"),
        tableCatalog = row[/* unknown nullability */ Option[String]]("table_catalog"),
        tableSchema = row[/* unknown nullability */ Option[String]]("table_schema"),
        tableName = row[/* unknown nullability */ Option[String]]("table_name"),
        columnName = row[/* unknown nullability */ Option[String]]("column_name")
      )
    )
  }

  implicit val oFormat: OFormat[ViewColumnUsageRow] = Json.format
}