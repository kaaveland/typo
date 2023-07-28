/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_db_role_setting

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

case class PgDbRoleSettingRow(
  setdatabase: /* oid */ Long,
  setrole: /* oid */ Long,
  setconfig: Option[Array[String]]
){
   val compositeId: PgDbRoleSettingId = PgDbRoleSettingId(setdatabase, setrole)
 }

object PgDbRoleSettingRow {
  implicit val reads: Reads[PgDbRoleSettingRow] = Reads[PgDbRoleSettingRow](json => JsResult.fromTry(
      Try(
        PgDbRoleSettingRow(
          setdatabase = json.\("setdatabase").as(Reads.LongReads),
          setrole = json.\("setrole").as(Reads.LongReads),
          setconfig = json.\("setconfig").toOption.map(_.as(Reads.ArrayReads[String](Reads.StringReads, implicitly)))
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[PgDbRoleSettingRow] = RowParser[PgDbRoleSettingRow] { row =>
    Success(
      PgDbRoleSettingRow(
        setdatabase = row(idx + 0)(Column.columnToLong),
        setrole = row(idx + 1)(Column.columnToLong),
        setconfig = row(idx + 2)(Column.columnToOption(Column.columnToArray[String](Column.columnToString, implicitly)))
      )
    )
  }
  implicit val writes: OWrites[PgDbRoleSettingRow] = OWrites[PgDbRoleSettingRow](o =>
    new JsObject(ListMap[String, JsValue](
      "setdatabase" -> Writes.LongWrites.writes(o.setdatabase),
      "setrole" -> Writes.LongWrites.writes(o.setrole),
      "setconfig" -> Writes.OptionWrites(Writes.arrayWrites[String](implicitly, Writes.StringWrites)).writes(o.setconfig)
    ))
  )
}