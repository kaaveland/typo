/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_locks

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

case class PgLocksViewRow(
  locktype: /* nullability unknown */ Option[String],
  database: /* nullability unknown */ Option[/* oid */ Long],
  relation: /* nullability unknown */ Option[/* oid */ Long],
  page: /* nullability unknown */ Option[Int],
  tuple: /* nullability unknown */ Option[Int],
  virtualxid: /* nullability unknown */ Option[String],
  transactionid: /* nullability unknown */ Option[TypoXid],
  classid: /* nullability unknown */ Option[/* oid */ Long],
  objid: /* nullability unknown */ Option[/* oid */ Long],
  objsubid: /* nullability unknown */ Option[Int],
  virtualtransaction: /* nullability unknown */ Option[String],
  pid: /* nullability unknown */ Option[Int],
  mode: /* nullability unknown */ Option[String],
  granted: /* nullability unknown */ Option[Boolean],
  fastpath: /* nullability unknown */ Option[Boolean],
  waitstart: /* nullability unknown */ Option[TypoOffsetDateTime]
)

object PgLocksViewRow {
  implicit lazy val reads: Reads[PgLocksViewRow] = Reads[PgLocksViewRow](json => JsResult.fromTry(
      Try(
        PgLocksViewRow(
          locktype = json.\("locktype").toOption.map(_.as(Reads.StringReads)),
          database = json.\("database").toOption.map(_.as(Reads.LongReads)),
          relation = json.\("relation").toOption.map(_.as(Reads.LongReads)),
          page = json.\("page").toOption.map(_.as(Reads.IntReads)),
          tuple = json.\("tuple").toOption.map(_.as(Reads.IntReads)),
          virtualxid = json.\("virtualxid").toOption.map(_.as(Reads.StringReads)),
          transactionid = json.\("transactionid").toOption.map(_.as(TypoXid.reads)),
          classid = json.\("classid").toOption.map(_.as(Reads.LongReads)),
          objid = json.\("objid").toOption.map(_.as(Reads.LongReads)),
          objsubid = json.\("objsubid").toOption.map(_.as(Reads.IntReads)),
          virtualtransaction = json.\("virtualtransaction").toOption.map(_.as(Reads.StringReads)),
          pid = json.\("pid").toOption.map(_.as(Reads.IntReads)),
          mode = json.\("mode").toOption.map(_.as(Reads.StringReads)),
          granted = json.\("granted").toOption.map(_.as(Reads.BooleanReads)),
          fastpath = json.\("fastpath").toOption.map(_.as(Reads.BooleanReads)),
          waitstart = json.\("waitstart").toOption.map(_.as(TypoOffsetDateTime.reads))
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[PgLocksViewRow] = RowParser[PgLocksViewRow] { row =>
    Success(
      PgLocksViewRow(
        locktype = row(idx + 0)(Column.columnToOption(Column.columnToString)),
        database = row(idx + 1)(Column.columnToOption(Column.columnToLong)),
        relation = row(idx + 2)(Column.columnToOption(Column.columnToLong)),
        page = row(idx + 3)(Column.columnToOption(Column.columnToInt)),
        tuple = row(idx + 4)(Column.columnToOption(Column.columnToInt)),
        virtualxid = row(idx + 5)(Column.columnToOption(Column.columnToString)),
        transactionid = row(idx + 6)(Column.columnToOption(TypoXid.column)),
        classid = row(idx + 7)(Column.columnToOption(Column.columnToLong)),
        objid = row(idx + 8)(Column.columnToOption(Column.columnToLong)),
        objsubid = row(idx + 9)(Column.columnToOption(Column.columnToInt)),
        virtualtransaction = row(idx + 10)(Column.columnToOption(Column.columnToString)),
        pid = row(idx + 11)(Column.columnToOption(Column.columnToInt)),
        mode = row(idx + 12)(Column.columnToOption(Column.columnToString)),
        granted = row(idx + 13)(Column.columnToOption(Column.columnToBoolean)),
        fastpath = row(idx + 14)(Column.columnToOption(Column.columnToBoolean)),
        waitstart = row(idx + 15)(Column.columnToOption(TypoOffsetDateTime.column))
      )
    )
  }
  implicit lazy val writes: OWrites[PgLocksViewRow] = OWrites[PgLocksViewRow](o =>
    new JsObject(ListMap[String, JsValue](
      "locktype" -> Writes.OptionWrites(Writes.StringWrites).writes(o.locktype),
      "database" -> Writes.OptionWrites(Writes.LongWrites).writes(o.database),
      "relation" -> Writes.OptionWrites(Writes.LongWrites).writes(o.relation),
      "page" -> Writes.OptionWrites(Writes.IntWrites).writes(o.page),
      "tuple" -> Writes.OptionWrites(Writes.IntWrites).writes(o.tuple),
      "virtualxid" -> Writes.OptionWrites(Writes.StringWrites).writes(o.virtualxid),
      "transactionid" -> Writes.OptionWrites(TypoXid.writes).writes(o.transactionid),
      "classid" -> Writes.OptionWrites(Writes.LongWrites).writes(o.classid),
      "objid" -> Writes.OptionWrites(Writes.LongWrites).writes(o.objid),
      "objsubid" -> Writes.OptionWrites(Writes.IntWrites).writes(o.objsubid),
      "virtualtransaction" -> Writes.OptionWrites(Writes.StringWrites).writes(o.virtualtransaction),
      "pid" -> Writes.OptionWrites(Writes.IntWrites).writes(o.pid),
      "mode" -> Writes.OptionWrites(Writes.StringWrites).writes(o.mode),
      "granted" -> Writes.OptionWrites(Writes.BooleanWrites).writes(o.granted),
      "fastpath" -> Writes.OptionWrites(Writes.BooleanWrites).writes(o.fastpath),
      "waitstart" -> Writes.OptionWrites(TypoOffsetDateTime.writes).writes(o.waitstart)
    ))
  )
}
