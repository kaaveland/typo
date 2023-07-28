/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_description

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

case class PgDescriptionRow(
  objoid: /* oid */ Long,
  classoid: /* oid */ Long,
  objsubid: Int,
  description: String
){
   val compositeId: PgDescriptionId = PgDescriptionId(objoid, classoid, objsubid)
 }

object PgDescriptionRow {
  implicit val reads: Reads[PgDescriptionRow] = Reads[PgDescriptionRow](json => JsResult.fromTry(
      Try(
        PgDescriptionRow(
          objoid = json.\("objoid").as(Reads.LongReads),
          classoid = json.\("classoid").as(Reads.LongReads),
          objsubid = json.\("objsubid").as(Reads.IntReads),
          description = json.\("description").as(Reads.StringReads)
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[PgDescriptionRow] = RowParser[PgDescriptionRow] { row =>
    Success(
      PgDescriptionRow(
        objoid = row(idx + 0)(Column.columnToLong),
        classoid = row(idx + 1)(Column.columnToLong),
        objsubid = row(idx + 2)(Column.columnToInt),
        description = row(idx + 3)(Column.columnToString)
      )
    )
  }
  implicit val writes: OWrites[PgDescriptionRow] = OWrites[PgDescriptionRow](o =>
    new JsObject(ListMap[String, JsValue](
      "objoid" -> Writes.LongWrites.writes(o.objoid),
      "classoid" -> Writes.LongWrites.writes(o.classoid),
      "objsubid" -> Writes.IntWrites.writes(o.objsubid),
      "description" -> Writes.StringWrites.writes(o.description)
    ))
  )
}