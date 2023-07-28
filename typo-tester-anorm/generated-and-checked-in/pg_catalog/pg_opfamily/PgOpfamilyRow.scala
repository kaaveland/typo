/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_opfamily

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

case class PgOpfamilyRow(
  oid: PgOpfamilyId,
  opfmethod: /* oid */ Long,
  opfname: String,
  opfnamespace: /* oid */ Long,
  opfowner: /* oid */ Long
)

object PgOpfamilyRow {
  implicit val reads: Reads[PgOpfamilyRow] = Reads[PgOpfamilyRow](json => JsResult.fromTry(
      Try(
        PgOpfamilyRow(
          oid = json.\("oid").as(PgOpfamilyId.reads),
          opfmethod = json.\("opfmethod").as(Reads.LongReads),
          opfname = json.\("opfname").as(Reads.StringReads),
          opfnamespace = json.\("opfnamespace").as(Reads.LongReads),
          opfowner = json.\("opfowner").as(Reads.LongReads)
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[PgOpfamilyRow] = RowParser[PgOpfamilyRow] { row =>
    Success(
      PgOpfamilyRow(
        oid = row(idx + 0)(PgOpfamilyId.column),
        opfmethod = row(idx + 1)(Column.columnToLong),
        opfname = row(idx + 2)(Column.columnToString),
        opfnamespace = row(idx + 3)(Column.columnToLong),
        opfowner = row(idx + 4)(Column.columnToLong)
      )
    )
  }
  implicit val writes: OWrites[PgOpfamilyRow] = OWrites[PgOpfamilyRow](o =>
    new JsObject(ListMap[String, JsValue](
      "oid" -> PgOpfamilyId.writes.writes(o.oid),
      "opfmethod" -> Writes.LongWrites.writes(o.opfmethod),
      "opfname" -> Writes.StringWrites.writes(o.opfname),
      "opfnamespace" -> Writes.LongWrites.writes(o.opfnamespace),
      "opfowner" -> Writes.LongWrites.writes(o.opfowner)
    ))
  )
}