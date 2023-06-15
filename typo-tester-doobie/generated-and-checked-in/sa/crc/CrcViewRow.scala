/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sa
package crc

import adventureworks.person.countryregion.CountryregionId
import adventureworks.sales.currency.CurrencyId
import io.circe.Decoder
import io.circe.Encoder
import io.circe.HCursor
import io.circe.Json
import java.time.LocalDateTime

case class CrcViewRow(
  /** Points to [[sales.countryregioncurrency.CountryregioncurrencyRow.countryregioncode]] */
  countryregioncode: Option[CountryregionId],
  /** Points to [[sales.countryregioncurrency.CountryregioncurrencyRow.currencycode]] */
  currencycode: Option[CurrencyId],
  /** Points to [[sales.countryregioncurrency.CountryregioncurrencyRow.modifieddate]] */
  modifieddate: Option[LocalDateTime]
)

object CrcViewRow {
  implicit val decoder: Decoder[CrcViewRow] =
    (c: HCursor) =>
      for {
        countryregioncode <- c.downField("countryregioncode").as[Option[CountryregionId]]
        currencycode <- c.downField("currencycode").as[Option[CurrencyId]]
        modifieddate <- c.downField("modifieddate").as[Option[LocalDateTime]]
      } yield CrcViewRow(countryregioncode, currencycode, modifieddate)
  implicit val encoder: Encoder[CrcViewRow] = {
    import io.circe.syntax._
    row =>
      Json.obj(
        "countryregioncode" := row.countryregioncode,
        "currencycode" := row.currencycode,
        "modifieddate" := row.modifieddate
      )}
}