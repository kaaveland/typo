/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package salesterritory

import adventureworks.TypoLocalDateTime
import adventureworks.person.countryregion.CountryregionId
import adventureworks.public.Name
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

case class SalesterritoryRow(
  /** Primary key for SalesTerritory records. */
  territoryid: SalesterritoryId,
  /** Sales territory description */
  name: Name,
  /** ISO standard country or region code. Foreign key to CountryRegion.CountryRegionCode.
      Points to [[person.countryregion.CountryregionRow.countryregioncode]] */
  countryregioncode: CountryregionId,
  /** Geographic area to which the sales territory belong. */
  group: /* max 50 chars */ String,
  /** Sales in the territory year to date. */
  salesytd: BigDecimal,
  /** Sales in the territory the previous year. */
  saleslastyear: BigDecimal,
  /** Business costs in the territory year to date. */
  costytd: BigDecimal,
  /** Business costs in the territory the previous year. */
  costlastyear: BigDecimal,
  rowguid: UUID,
  modifieddate: TypoLocalDateTime
)

object SalesterritoryRow {
  implicit lazy val reads: Reads[SalesterritoryRow] = Reads[SalesterritoryRow](json => JsResult.fromTry(
      Try(
        SalesterritoryRow(
          territoryid = json.\("territoryid").as(SalesterritoryId.reads),
          name = json.\("name").as(Name.reads),
          countryregioncode = json.\("countryregioncode").as(CountryregionId.reads),
          group = json.\("group").as(Reads.StringReads),
          salesytd = json.\("salesytd").as(Reads.bigDecReads),
          saleslastyear = json.\("saleslastyear").as(Reads.bigDecReads),
          costytd = json.\("costytd").as(Reads.bigDecReads),
          costlastyear = json.\("costlastyear").as(Reads.bigDecReads),
          rowguid = json.\("rowguid").as(Reads.uuidReads),
          modifieddate = json.\("modifieddate").as(TypoLocalDateTime.reads)
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[SalesterritoryRow] = RowParser[SalesterritoryRow] { row =>
    Success(
      SalesterritoryRow(
        territoryid = row(idx + 0)(SalesterritoryId.column),
        name = row(idx + 1)(Name.column),
        countryregioncode = row(idx + 2)(CountryregionId.column),
        group = row(idx + 3)(Column.columnToString),
        salesytd = row(idx + 4)(Column.columnToScalaBigDecimal),
        saleslastyear = row(idx + 5)(Column.columnToScalaBigDecimal),
        costytd = row(idx + 6)(Column.columnToScalaBigDecimal),
        costlastyear = row(idx + 7)(Column.columnToScalaBigDecimal),
        rowguid = row(idx + 8)(Column.columnToUUID),
        modifieddate = row(idx + 9)(TypoLocalDateTime.column)
      )
    )
  }
  implicit lazy val writes: OWrites[SalesterritoryRow] = OWrites[SalesterritoryRow](o =>
    new JsObject(ListMap[String, JsValue](
      "territoryid" -> SalesterritoryId.writes.writes(o.territoryid),
      "name" -> Name.writes.writes(o.name),
      "countryregioncode" -> CountryregionId.writes.writes(o.countryregioncode),
      "group" -> Writes.StringWrites.writes(o.group),
      "salesytd" -> Writes.BigDecimalWrites.writes(o.salesytd),
      "saleslastyear" -> Writes.BigDecimalWrites.writes(o.saleslastyear),
      "costytd" -> Writes.BigDecimalWrites.writes(o.costytd),
      "costlastyear" -> Writes.BigDecimalWrites.writes(o.costlastyear),
      "rowguid" -> Writes.UuidWrites.writes(o.rowguid),
      "modifieddate" -> TypoLocalDateTime.writes.writes(o.modifieddate)
    ))
  )
}