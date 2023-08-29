/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_shadow

import adventureworks.customtypes.TypoOffsetDateTime
import adventureworks.pg_catalog.pg_authid.PgAuthidId
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

case class PgShadowViewRow(
  /** Points to [[pg_authid.PgAuthidRow.rolname]] */
  usename: String,
  /** Points to [[pg_authid.PgAuthidRow.oid]] */
  usesysid: PgAuthidId,
  /** Points to [[pg_authid.PgAuthidRow.rolcreatedb]] */
  usecreatedb: Boolean,
  /** Points to [[pg_authid.PgAuthidRow.rolsuper]] */
  usesuper: Boolean,
  /** Points to [[pg_authid.PgAuthidRow.rolreplication]] */
  userepl: Boolean,
  /** Points to [[pg_authid.PgAuthidRow.rolbypassrls]] */
  usebypassrls: Boolean,
  /** Points to [[pg_authid.PgAuthidRow.rolpassword]] */
  passwd: Option[String],
  /** Points to [[pg_authid.PgAuthidRow.rolvaliduntil]] */
  valuntil: Option[TypoOffsetDateTime],
  /** Points to [[pg_db_role_setting.PgDbRoleSettingRow.setconfig]] */
  useconfig: Option[Array[String]]
)

object PgShadowViewRow {
  implicit lazy val reads: Reads[PgShadowViewRow] = Reads[PgShadowViewRow](json => JsResult.fromTry(
      Try(
        PgShadowViewRow(
          usename = json.\("usename").as(Reads.StringReads),
          usesysid = json.\("usesysid").as(PgAuthidId.reads),
          usecreatedb = json.\("usecreatedb").as(Reads.BooleanReads),
          usesuper = json.\("usesuper").as(Reads.BooleanReads),
          userepl = json.\("userepl").as(Reads.BooleanReads),
          usebypassrls = json.\("usebypassrls").as(Reads.BooleanReads),
          passwd = json.\("passwd").toOption.map(_.as(Reads.StringReads)),
          valuntil = json.\("valuntil").toOption.map(_.as(TypoOffsetDateTime.reads)),
          useconfig = json.\("useconfig").toOption.map(_.as(Reads.ArrayReads[String](Reads.StringReads, implicitly)))
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[PgShadowViewRow] = RowParser[PgShadowViewRow] { row =>
    Success(
      PgShadowViewRow(
        usename = row(idx + 0)(Column.columnToString),
        usesysid = row(idx + 1)(PgAuthidId.column),
        usecreatedb = row(idx + 2)(Column.columnToBoolean),
        usesuper = row(idx + 3)(Column.columnToBoolean),
        userepl = row(idx + 4)(Column.columnToBoolean),
        usebypassrls = row(idx + 5)(Column.columnToBoolean),
        passwd = row(idx + 6)(Column.columnToOption(Column.columnToString)),
        valuntil = row(idx + 7)(Column.columnToOption(TypoOffsetDateTime.column)),
        useconfig = row(idx + 8)(Column.columnToOption(Column.columnToArray[String](Column.columnToString, implicitly)))
      )
    )
  }
  implicit lazy val writes: OWrites[PgShadowViewRow] = OWrites[PgShadowViewRow](o =>
    new JsObject(ListMap[String, JsValue](
      "usename" -> Writes.StringWrites.writes(o.usename),
      "usesysid" -> PgAuthidId.writes.writes(o.usesysid),
      "usecreatedb" -> Writes.BooleanWrites.writes(o.usecreatedb),
      "usesuper" -> Writes.BooleanWrites.writes(o.usesuper),
      "userepl" -> Writes.BooleanWrites.writes(o.userepl),
      "usebypassrls" -> Writes.BooleanWrites.writes(o.usebypassrls),
      "passwd" -> Writes.OptionWrites(Writes.StringWrites).writes(o.passwd),
      "valuntil" -> Writes.OptionWrites(TypoOffsetDateTime.writes).writes(o.valuntil),
      "useconfig" -> Writes.OptionWrites(Writes.arrayWrites[String](implicitly, Writes.StringWrites)).writes(o.useconfig)
    ))
  )
}
