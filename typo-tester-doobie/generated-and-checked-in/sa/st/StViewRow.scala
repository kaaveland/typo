/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sa
package st

import adventureworks.person.countryregion.CountryregionId
import adventureworks.public.Name
import adventureworks.sales.salesterritory.SalesterritoryId
import io.circe.Decoder
import io.circe.Encoder
import io.circe.HCursor
import io.circe.Json
import java.time.LocalDateTime
import java.util.UUID

case class StViewRow(
  id: Option[Int],
  /** Points to [[sales.salesterritory.SalesterritoryRow.territoryid]] */
  territoryid: Option[SalesterritoryId],
  /** Points to [[sales.salesterritory.SalesterritoryRow.name]] */
  name: Option[Name],
  /** Points to [[sales.salesterritory.SalesterritoryRow.countryregioncode]] */
  countryregioncode: Option[CountryregionId],
  /** Points to [[sales.salesterritory.SalesterritoryRow.group]] */
  group: Option[String],
  /** Points to [[sales.salesterritory.SalesterritoryRow.salesytd]] */
  salesytd: Option[BigDecimal],
  /** Points to [[sales.salesterritory.SalesterritoryRow.saleslastyear]] */
  saleslastyear: Option[BigDecimal],
  /** Points to [[sales.salesterritory.SalesterritoryRow.costytd]] */
  costytd: Option[BigDecimal],
  /** Points to [[sales.salesterritory.SalesterritoryRow.costlastyear]] */
  costlastyear: Option[BigDecimal],
  /** Points to [[sales.salesterritory.SalesterritoryRow.rowguid]] */
  rowguid: Option[UUID],
  /** Points to [[sales.salesterritory.SalesterritoryRow.modifieddate]] */
  modifieddate: Option[LocalDateTime]
)

object StViewRow {
  implicit val decoder: Decoder[StViewRow] =
    (c: HCursor) =>
      for {
        id <- c.downField("id").as[Option[Int]]
        territoryid <- c.downField("territoryid").as[Option[SalesterritoryId]]
        name <- c.downField("name").as[Option[Name]]
        countryregioncode <- c.downField("countryregioncode").as[Option[CountryregionId]]
        group <- c.downField("group").as[Option[String]]
        salesytd <- c.downField("salesytd").as[Option[BigDecimal]]
        saleslastyear <- c.downField("saleslastyear").as[Option[BigDecimal]]
        costytd <- c.downField("costytd").as[Option[BigDecimal]]
        costlastyear <- c.downField("costlastyear").as[Option[BigDecimal]]
        rowguid <- c.downField("rowguid").as[Option[UUID]]
        modifieddate <- c.downField("modifieddate").as[Option[LocalDateTime]]
      } yield StViewRow(id, territoryid, name, countryregioncode, group, salesytd, saleslastyear, costytd, costlastyear, rowguid, modifieddate)
  implicit val encoder: Encoder[StViewRow] = {
    import io.circe.syntax._
    row =>
      Json.obj(
        "id" := row.id,
        "territoryid" := row.territoryid,
        "name" := row.name,
        "countryregioncode" := row.countryregioncode,
        "group" := row.group,
        "salesytd" := row.salesytd,
        "saleslastyear" := row.saleslastyear,
        "costytd" := row.costytd,
        "costlastyear" := row.costlastyear,
        "rowguid" := row.rowguid,
        "modifieddate" := row.modifieddate
      )}
}
