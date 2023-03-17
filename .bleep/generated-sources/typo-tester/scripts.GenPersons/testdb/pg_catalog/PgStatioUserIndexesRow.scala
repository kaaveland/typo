package testdb.pg_catalog

import anorm.RowParser
import anorm.Success
import play.api.libs.json.Json
import play.api.libs.json.OFormat

case class PgStatioUserIndexesRow(
  relid: Option[Long],
  indexrelid: Option[Long],
  schemaname: Option[String],
  relname: Option[String],
  indexrelname: Option[String],
  idxBlksRead: Option[Long],
  idxBlksHit: Option[Long]
)

object PgStatioUserIndexesRow {
  implicit val rowParser: RowParser[PgStatioUserIndexesRow] = { row =>
    Success(
      PgStatioUserIndexesRow(
        relid = row[Option[Long]]("relid"),
        indexrelid = row[Option[Long]]("indexrelid"),
        schemaname = row[Option[String]]("schemaname"),
        relname = row[Option[String]]("relname"),
        indexrelname = row[Option[String]]("indexrelname"),
        idxBlksRead = row[Option[Long]]("idx_blks_read"),
        idxBlksHit = row[Option[Long]]("idx_blks_hit")
      )
    )
  }

  implicit val oFormat: OFormat[PgStatioUserIndexesRow] = Json.format
}