/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_seclabels

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

case class PgSeclabelsViewRow(
  objoid: /* nullability unknown */ Option[/* oid */ Long],
  classoid: /* nullability unknown */ Option[/* oid */ Long],
  objsubid: /* nullability unknown */ Option[Int],
  objtype: /* nullability unknown */ Option[String],
  objnamespace: /* nullability unknown */ Option[/* oid */ Long],
  objname: /* nullability unknown */ Option[String],
  provider: /* nullability unknown */ Option[String],
  label: /* nullability unknown */ Option[String]
)

object PgSeclabelsViewRow {
  implicit lazy val reads: Reads[PgSeclabelsViewRow] = Reads[PgSeclabelsViewRow](json => JsResult.fromTry(
      Try(
        PgSeclabelsViewRow(
          objoid = json.\("objoid").toOption.map(_.as(Reads.LongReads)),
          classoid = json.\("classoid").toOption.map(_.as(Reads.LongReads)),
          objsubid = json.\("objsubid").toOption.map(_.as(Reads.IntReads)),
          objtype = json.\("objtype").toOption.map(_.as(Reads.StringReads)),
          objnamespace = json.\("objnamespace").toOption.map(_.as(Reads.LongReads)),
          objname = json.\("objname").toOption.map(_.as(Reads.StringReads)),
          provider = json.\("provider").toOption.map(_.as(Reads.StringReads)),
          label = json.\("label").toOption.map(_.as(Reads.StringReads))
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[PgSeclabelsViewRow] = RowParser[PgSeclabelsViewRow] { row =>
    Success(
      PgSeclabelsViewRow(
        objoid = row(idx + 0)(Column.columnToOption(Column.columnToLong)),
        classoid = row(idx + 1)(Column.columnToOption(Column.columnToLong)),
        objsubid = row(idx + 2)(Column.columnToOption(Column.columnToInt)),
        objtype = row(idx + 3)(Column.columnToOption(Column.columnToString)),
        objnamespace = row(idx + 4)(Column.columnToOption(Column.columnToLong)),
        objname = row(idx + 5)(Column.columnToOption(Column.columnToString)),
        provider = row(idx + 6)(Column.columnToOption(Column.columnToString)),
        label = row(idx + 7)(Column.columnToOption(Column.columnToString))
      )
    )
  }
  implicit lazy val writes: OWrites[PgSeclabelsViewRow] = OWrites[PgSeclabelsViewRow](o =>
    new JsObject(ListMap[String, JsValue](
      "objoid" -> Writes.OptionWrites(Writes.LongWrites).writes(o.objoid),
      "classoid" -> Writes.OptionWrites(Writes.LongWrites).writes(o.classoid),
      "objsubid" -> Writes.OptionWrites(Writes.IntWrites).writes(o.objsubid),
      "objtype" -> Writes.OptionWrites(Writes.StringWrites).writes(o.objtype),
      "objnamespace" -> Writes.OptionWrites(Writes.LongWrites).writes(o.objnamespace),
      "objname" -> Writes.OptionWrites(Writes.StringWrites).writes(o.objname),
      "provider" -> Writes.OptionWrites(Writes.StringWrites).writes(o.provider),
      "label" -> Writes.OptionWrites(Writes.StringWrites).writes(o.label)
    ))
  )
}
