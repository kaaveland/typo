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

case class ForeignDataWrapperOptionsRow(
  /** Points to [[PgForeignDataWrappersRow.foreignDataWrapperCatalog]] */
  foreignDataWrapperCatalog: Option[String],
  /** Points to [[PgForeignDataWrappersRow.foreignDataWrapperName]] */
  foreignDataWrapperName: Option[String],
  optionName: /* unknown nullability */ Option[String],
  optionValue: /* unknown nullability */ Option[String]
)

object ForeignDataWrapperOptionsRow {
  implicit val rowParser: RowParser[ForeignDataWrapperOptionsRow] = { row =>
    Success(
      ForeignDataWrapperOptionsRow(
        foreignDataWrapperCatalog = row[Option[String]]("foreign_data_wrapper_catalog"),
        foreignDataWrapperName = row[Option[String]]("foreign_data_wrapper_name"),
        optionName = row[/* unknown nullability */ Option[String]]("option_name"),
        optionValue = row[/* unknown nullability */ Option[String]]("option_value")
      )
    )
  }

  implicit val oFormat: OFormat[ForeignDataWrapperOptionsRow] = new OFormat[ForeignDataWrapperOptionsRow]{
    override def writes(o: ForeignDataWrapperOptionsRow): JsObject =
      Json.obj(
        "foreign_data_wrapper_catalog" -> o.foreignDataWrapperCatalog,
      "foreign_data_wrapper_name" -> o.foreignDataWrapperName,
      "option_name" -> o.optionName,
      "option_value" -> o.optionValue
      )

    override def reads(json: JsValue): JsResult[ForeignDataWrapperOptionsRow] = {
      JsResult.fromTry(
        Try(
          ForeignDataWrapperOptionsRow(
            foreignDataWrapperCatalog = json.\("foreign_data_wrapper_catalog").toOption.map(_.as[String]),
            foreignDataWrapperName = json.\("foreign_data_wrapper_name").toOption.map(_.as[String]),
            optionName = json.\("option_name").toOption.map(_.as[String]),
            optionValue = json.\("option_value").toOption.map(_.as[String])
          )
        )
      )
    }
  }
}