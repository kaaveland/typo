/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_available_extensions

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

case class PgAvailableExtensionsViewRow(
  name: String,
  defaultVersion: String,
  installedVersion: Option[String],
  comment: String
)

object PgAvailableExtensionsViewRow {
  implicit lazy val reads: Reads[PgAvailableExtensionsViewRow] = Reads[PgAvailableExtensionsViewRow](json => JsResult.fromTry(
      Try(
        PgAvailableExtensionsViewRow(
          name = json.\("name").as(Reads.StringReads),
          defaultVersion = json.\("default_version").as(Reads.StringReads),
          installedVersion = json.\("installed_version").toOption.map(_.as(Reads.StringReads)),
          comment = json.\("comment").as(Reads.StringReads)
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[PgAvailableExtensionsViewRow] = RowParser[PgAvailableExtensionsViewRow] { row =>
    Success(
      PgAvailableExtensionsViewRow(
        name = row(idx + 0)(Column.columnToString),
        defaultVersion = row(idx + 1)(Column.columnToString),
        installedVersion = row(idx + 2)(Column.columnToOption(Column.columnToString)),
        comment = row(idx + 3)(Column.columnToString)
      )
    )
  }
  implicit lazy val writes: OWrites[PgAvailableExtensionsViewRow] = OWrites[PgAvailableExtensionsViewRow](o =>
    new JsObject(ListMap[String, JsValue](
      "name" -> Writes.StringWrites.writes(o.name),
      "default_version" -> Writes.StringWrites.writes(o.defaultVersion),
      "installed_version" -> Writes.OptionWrites(Writes.StringWrites).writes(o.installedVersion),
      "comment" -> Writes.StringWrites.writes(o.comment)
    ))
  )
}
