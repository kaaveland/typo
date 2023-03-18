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
import testdb.postgres.pg_catalog.PgAttributeRow
import testdb.postgres.pg_catalog.PgClassRow
import testdb.postgres.pg_catalog.PgNamespaceRow

case class PgForeignTableColumnsRow(
  /** Points to [[PgNamespaceRow.nspname]] */
  nspname: String,
  /** Points to [[PgClassRow.relname]] */
  relname: String,
  /** Points to [[PgAttributeRow.attname]] */
  attname: String,
  /** Points to [[PgAttributeRow.attfdwoptions]] */
  attfdwoptions: Option[Array[String]]
)

object PgForeignTableColumnsRow {
  implicit val rowParser: RowParser[PgForeignTableColumnsRow] = { row =>
    Success(
      PgForeignTableColumnsRow(
        nspname = row[String]("nspname"),
        relname = row[String]("relname"),
        attname = row[String]("attname"),
        attfdwoptions = row[Option[Array[String]]]("attfdwoptions")
      )
    )
  }

  implicit val oFormat: OFormat[PgForeignTableColumnsRow] = new OFormat[PgForeignTableColumnsRow]{
    override def writes(o: PgForeignTableColumnsRow): JsObject =
      Json.obj(
        "nspname" -> o.nspname,
      "relname" -> o.relname,
      "attname" -> o.attname,
      "attfdwoptions" -> o.attfdwoptions
      )

    override def reads(json: JsValue): JsResult[PgForeignTableColumnsRow] = {
      JsResult.fromTry(
        Try(
          PgForeignTableColumnsRow(
            nspname = json.\("nspname").as[String],
            relname = json.\("relname").as[String],
            attname = json.\("attname").as[String],
            attfdwoptions = json.\("attfdwoptions").toOption.map(_.as[Array[String]])
          )
        )
      )
    }
  }
}