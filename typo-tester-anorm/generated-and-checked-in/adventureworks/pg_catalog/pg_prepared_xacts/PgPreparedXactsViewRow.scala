/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_prepared_xacts

import adventureworks.customtypes.TypoOffsetDateTime
import adventureworks.customtypes.TypoXid
import anorm.Column
import anorm.RowParser
import anorm.Success
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.OWrites
import play.api.libs.json.Reads
import play.api.libs.json.Writes
import scala.collection.immutable.ListMap
import scala.util.Try

case class PgPreparedXactsViewRow(
  transaction: /* nullability unknown */ Option[TypoXid],
  gid: /* nullability unknown */ Option[String],
  prepared: /* nullability unknown */ Option[TypoOffsetDateTime],
  /** Points to [[pg_authid.PgAuthidRow.rolname]] */
  owner: Option[String],
  /** Points to [[pg_database.PgDatabaseRow.datname]] */
  database: Option[String]
)

object PgPreparedXactsViewRow {
  implicit lazy val reads: Reads[PgPreparedXactsViewRow] = Reads[PgPreparedXactsViewRow](json => JsResult.fromTry(
      Try(
        PgPreparedXactsViewRow(
          transaction = json.\("transaction").toOption.map(_.as(TypoXid.reads)),
          gid = json.\("gid").toOption.map(_.as(Reads.StringReads)),
          prepared = json.\("prepared").toOption.map(_.as(TypoOffsetDateTime.reads)),
          owner = json.\("owner").toOption.map(_.as(Reads.StringReads)),
          database = json.\("database").toOption.map(_.as(Reads.StringReads))
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[PgPreparedXactsViewRow] = RowParser[PgPreparedXactsViewRow] { row =>
    Success(
      PgPreparedXactsViewRow(
        transaction = row(idx + 0)(Column.columnToOption(TypoXid.column)),
        gid = row(idx + 1)(Column.columnToOption(Column.columnToString)),
        prepared = row(idx + 2)(Column.columnToOption(TypoOffsetDateTime.column)),
        owner = row(idx + 3)(Column.columnToOption(Column.columnToString)),
        database = row(idx + 4)(Column.columnToOption(Column.columnToString))
      )
    )
  }
  implicit lazy val writes: OWrites[PgPreparedXactsViewRow] = OWrites[PgPreparedXactsViewRow](o =>
    new JsObject(ListMap[String, JsValue](
      "transaction" -> Writes.OptionWrites(TypoXid.writes).writes(o.transaction),
      "gid" -> Writes.OptionWrites(Writes.StringWrites).writes(o.gid),
      "prepared" -> Writes.OptionWrites(TypoOffsetDateTime.writes).writes(o.prepared),
      "owner" -> Writes.OptionWrites(Writes.StringWrites).writes(o.owner),
      "database" -> Writes.OptionWrites(Writes.StringWrites).writes(o.database)
    ))
  )
}
