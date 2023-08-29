/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pe
package sp

import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.person.countryregion.CountryregionId
import adventureworks.person.stateprovince.StateprovinceId
import adventureworks.public.Flag
import adventureworks.public.Name
import adventureworks.sales.salesterritory.SalesterritoryId
import anorm.Column
import anorm.RowParser
import anorm.Success
import java.util.UUID
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.OWrites
import play.api.libs.json.Reads
import play.api.libs.json.Writes
import scala.collection.immutable.ListMap
import scala.util.Try

case class SpViewRow(
  /** Points to [[person.stateprovince.StateprovinceRow.stateprovinceid]] */
  id: StateprovinceId,
  /** Points to [[person.stateprovince.StateprovinceRow.stateprovinceid]] */
  stateprovinceid: StateprovinceId,
  /** Points to [[person.stateprovince.StateprovinceRow.stateprovincecode]] */
  stateprovincecode: /* bpchar, max 3 chars */ String,
  /** Points to [[person.stateprovince.StateprovinceRow.countryregioncode]] */
  countryregioncode: CountryregionId,
  /** Points to [[person.stateprovince.StateprovinceRow.isonlystateprovinceflag]] */
  isonlystateprovinceflag: Flag,
  /** Points to [[person.stateprovince.StateprovinceRow.name]] */
  name: Name,
  /** Points to [[person.stateprovince.StateprovinceRow.territoryid]] */
  territoryid: SalesterritoryId,
  /** Points to [[person.stateprovince.StateprovinceRow.rowguid]] */
  rowguid: UUID,
  /** Points to [[person.stateprovince.StateprovinceRow.modifieddate]] */
  modifieddate: TypoLocalDateTime
)

object SpViewRow {
  implicit lazy val reads: Reads[SpViewRow] = Reads[SpViewRow](json => JsResult.fromTry(
      Try(
        SpViewRow(
          id = json.\("id").as(StateprovinceId.reads),
          stateprovinceid = json.\("stateprovinceid").as(StateprovinceId.reads),
          stateprovincecode = json.\("stateprovincecode").as(Reads.StringReads),
          countryregioncode = json.\("countryregioncode").as(CountryregionId.reads),
          isonlystateprovinceflag = json.\("isonlystateprovinceflag").as(Flag.reads),
          name = json.\("name").as(Name.reads),
          territoryid = json.\("territoryid").as(SalesterritoryId.reads),
          rowguid = json.\("rowguid").as(Reads.uuidReads),
          modifieddate = json.\("modifieddate").as(TypoLocalDateTime.reads)
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[SpViewRow] = RowParser[SpViewRow] { row =>
    Success(
      SpViewRow(
        id = row(idx + 0)(StateprovinceId.column),
        stateprovinceid = row(idx + 1)(StateprovinceId.column),
        stateprovincecode = row(idx + 2)(Column.columnToString),
        countryregioncode = row(idx + 3)(CountryregionId.column),
        isonlystateprovinceflag = row(idx + 4)(Flag.column),
        name = row(idx + 5)(Name.column),
        territoryid = row(idx + 6)(SalesterritoryId.column),
        rowguid = row(idx + 7)(Column.columnToUUID),
        modifieddate = row(idx + 8)(TypoLocalDateTime.column)
      )
    )
  }
  implicit lazy val writes: OWrites[SpViewRow] = OWrites[SpViewRow](o =>
    new JsObject(ListMap[String, JsValue](
      "id" -> StateprovinceId.writes.writes(o.id),
      "stateprovinceid" -> StateprovinceId.writes.writes(o.stateprovinceid),
      "stateprovincecode" -> Writes.StringWrites.writes(o.stateprovincecode),
      "countryregioncode" -> CountryregionId.writes.writes(o.countryregioncode),
      "isonlystateprovinceflag" -> Flag.writes.writes(o.isonlystateprovinceflag),
      "name" -> Name.writes.writes(o.name),
      "territoryid" -> SalesterritoryId.writes.writes(o.territoryid),
      "rowguid" -> Writes.UuidWrites.writes(o.rowguid),
      "modifieddate" -> TypoLocalDateTime.writes.writes(o.modifieddate)
    ))
  )
}
