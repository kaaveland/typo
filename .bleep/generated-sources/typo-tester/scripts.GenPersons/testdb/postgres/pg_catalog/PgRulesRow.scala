package testdb
package postgres
package pg_catalog

import anorm.RowParser
import anorm.Success
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try

case class PgRulesRow(
  /** Points to [[PgNamespaceRow.nspname]] */
  schemaname: String,
  /** Points to [[PgClassRow.relname]] */
  tablename: String,
  /** Points to [[PgRewriteRow.rulename]] */
  rulename: String,
  definition: /* unknown nullability */ Option[String]
)

object PgRulesRow {
  implicit val rowParser: RowParser[PgRulesRow] = { row =>
    Success(
      PgRulesRow(
        schemaname = row[String]("schemaname"),
        tablename = row[String]("tablename"),
        rulename = row[String]("rulename"),
        definition = row[/* unknown nullability */ Option[String]]("definition")
      )
    )
  }

  implicit val oFormat: OFormat[PgRulesRow] = new OFormat[PgRulesRow]{
    override def writes(o: PgRulesRow): JsObject =
      Json.obj(
        "schemaname" -> o.schemaname,
      "tablename" -> o.tablename,
      "rulename" -> o.rulename,
      "definition" -> o.definition
      )

    override def reads(json: JsValue): JsResult[PgRulesRow] = {
      JsResult.fromTry(
        Try(
          PgRulesRow(
            schemaname = json.\("schemaname").as[String],
            tablename = json.\("tablename").as[String],
            rulename = json.\("rulename").as[String],
            definition = json.\("definition").toOption.map(_.as[String])
          )
        )
      )
    }
  }
}