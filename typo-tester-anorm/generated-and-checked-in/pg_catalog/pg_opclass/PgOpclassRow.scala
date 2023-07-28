/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_opclass

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

case class PgOpclassRow(
  oid: PgOpclassId,
  opcmethod: /* oid */ Long,
  opcname: String,
  opcnamespace: /* oid */ Long,
  opcowner: /* oid */ Long,
  opcfamily: /* oid */ Long,
  opcintype: /* oid */ Long,
  opcdefault: Boolean,
  opckeytype: /* oid */ Long
)

object PgOpclassRow {
  implicit val reads: Reads[PgOpclassRow] = Reads[PgOpclassRow](json => JsResult.fromTry(
      Try(
        PgOpclassRow(
          oid = json.\("oid").as(PgOpclassId.reads),
          opcmethod = json.\("opcmethod").as(Reads.LongReads),
          opcname = json.\("opcname").as(Reads.StringReads),
          opcnamespace = json.\("opcnamespace").as(Reads.LongReads),
          opcowner = json.\("opcowner").as(Reads.LongReads),
          opcfamily = json.\("opcfamily").as(Reads.LongReads),
          opcintype = json.\("opcintype").as(Reads.LongReads),
          opcdefault = json.\("opcdefault").as(Reads.BooleanReads),
          opckeytype = json.\("opckeytype").as(Reads.LongReads)
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[PgOpclassRow] = RowParser[PgOpclassRow] { row =>
    Success(
      PgOpclassRow(
        oid = row(idx + 0)(PgOpclassId.column),
        opcmethod = row(idx + 1)(Column.columnToLong),
        opcname = row(idx + 2)(Column.columnToString),
        opcnamespace = row(idx + 3)(Column.columnToLong),
        opcowner = row(idx + 4)(Column.columnToLong),
        opcfamily = row(idx + 5)(Column.columnToLong),
        opcintype = row(idx + 6)(Column.columnToLong),
        opcdefault = row(idx + 7)(Column.columnToBoolean),
        opckeytype = row(idx + 8)(Column.columnToLong)
      )
    )
  }
  implicit val writes: OWrites[PgOpclassRow] = OWrites[PgOpclassRow](o =>
    new JsObject(ListMap[String, JsValue](
      "oid" -> PgOpclassId.writes.writes(o.oid),
      "opcmethod" -> Writes.LongWrites.writes(o.opcmethod),
      "opcname" -> Writes.StringWrites.writes(o.opcname),
      "opcnamespace" -> Writes.LongWrites.writes(o.opcnamespace),
      "opcowner" -> Writes.LongWrites.writes(o.opcowner),
      "opcfamily" -> Writes.LongWrites.writes(o.opcfamily),
      "opcintype" -> Writes.LongWrites.writes(o.opcintype),
      "opcdefault" -> Writes.BooleanWrites.writes(o.opcdefault),
      "opckeytype" -> Writes.LongWrites.writes(o.opckeytype)
    ))
  )
}