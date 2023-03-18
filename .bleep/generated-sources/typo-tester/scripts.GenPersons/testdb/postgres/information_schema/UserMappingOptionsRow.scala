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

case class UserMappingOptionsRow(
  /** Points to [[PgUserMappingsRow.authorizationIdentifier]] */
  authorizationIdentifier: Option[String],
  /** Points to [[PgUserMappingsRow.foreignServerCatalog]] */
  foreignServerCatalog: Option[String],
  /** Points to [[PgUserMappingsRow.foreignServerName]] */
  foreignServerName: Option[String],
  optionName: /* unknown nullability */ Option[String],
  optionValue: /* unknown nullability */ Option[String]
)

object UserMappingOptionsRow {
  implicit val rowParser: RowParser[UserMappingOptionsRow] = { row =>
    Success(
      UserMappingOptionsRow(
        authorizationIdentifier = row[Option[String]]("authorization_identifier"),
        foreignServerCatalog = row[Option[String]]("foreign_server_catalog"),
        foreignServerName = row[Option[String]]("foreign_server_name"),
        optionName = row[/* unknown nullability */ Option[String]]("option_name"),
        optionValue = row[/* unknown nullability */ Option[String]]("option_value")
      )
    )
  }

  implicit val oFormat: OFormat[UserMappingOptionsRow] = new OFormat[UserMappingOptionsRow]{
    override def writes(o: UserMappingOptionsRow): JsObject =
      Json.obj(
        "authorization_identifier" -> o.authorizationIdentifier,
      "foreign_server_catalog" -> o.foreignServerCatalog,
      "foreign_server_name" -> o.foreignServerName,
      "option_name" -> o.optionName,
      "option_value" -> o.optionValue
      )

    override def reads(json: JsValue): JsResult[UserMappingOptionsRow] = {
      JsResult.fromTry(
        Try(
          UserMappingOptionsRow(
            authorizationIdentifier = json.\("authorization_identifier").toOption.map(_.as[String]),
            foreignServerCatalog = json.\("foreign_server_catalog").toOption.map(_.as[String]),
            foreignServerName = json.\("foreign_server_name").toOption.map(_.as[String]),
            optionName = json.\("option_name").toOption.map(_.as[String]),
            optionValue = json.\("option_value").toOption.map(_.as[String])
          )
        )
      )
    }
  }
}