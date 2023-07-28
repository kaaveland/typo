/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_seclabel

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

case class PgSeclabelRow(
  objoid: /* oid */ Long,
  classoid: /* oid */ Long,
  objsubid: Int,
  provider: String,
  label: String
){
   val compositeId: PgSeclabelId = PgSeclabelId(objoid, classoid, objsubid, provider)
 }

object PgSeclabelRow {
  implicit val reads: Reads[PgSeclabelRow] = Reads[PgSeclabelRow](json => JsResult.fromTry(
      Try(
        PgSeclabelRow(
          objoid = json.\("objoid").as(Reads.LongReads),
          classoid = json.\("classoid").as(Reads.LongReads),
          objsubid = json.\("objsubid").as(Reads.IntReads),
          provider = json.\("provider").as(Reads.StringReads),
          label = json.\("label").as(Reads.StringReads)
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[PgSeclabelRow] = RowParser[PgSeclabelRow] { row =>
    Success(
      PgSeclabelRow(
        objoid = row(idx + 0)(Column.columnToLong),
        classoid = row(idx + 1)(Column.columnToLong),
        objsubid = row(idx + 2)(Column.columnToInt),
        provider = row(idx + 3)(Column.columnToString),
        label = row(idx + 4)(Column.columnToString)
      )
    )
  }
  implicit val writes: OWrites[PgSeclabelRow] = OWrites[PgSeclabelRow](o =>
    new JsObject(ListMap[String, JsValue](
      "objoid" -> Writes.LongWrites.writes(o.objoid),
      "classoid" -> Writes.LongWrites.writes(o.classoid),
      "objsubid" -> Writes.IntWrites.writes(o.objsubid),
      "provider" -> Writes.StringWrites.writes(o.provider),
      "label" -> Writes.StringWrites.writes(o.label)
    ))
  )
}