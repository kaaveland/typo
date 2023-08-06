/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package countryregioncurrency

import adventureworks.Defaulted
import adventureworks.TypoLocalDateTime
import adventureworks.person.countryregion.CountryregionId
import adventureworks.sales.currency.CurrencyId
import io.circe.Decoder
import io.circe.Encoder

/** This class corresponds to a row in table `sales.countryregioncurrency` which has not been persisted yet */
case class CountryregioncurrencyRowUnsaved(
  /** ISO code for countries and regions. Foreign key to CountryRegion.CountryRegionCode.
      Points to [[person.countryregion.CountryregionRow.countryregioncode]] */
  countryregioncode: CountryregionId,
  /** ISO standard currency code. Foreign key to Currency.CurrencyCode.
      Points to [[currency.CurrencyRow.currencycode]] */
  currencycode: CurrencyId,
  /** Default: now() */
  modifieddate: Defaulted[TypoLocalDateTime] = Defaulted.UseDefault
) {
  def toRow(modifieddateDefault: => TypoLocalDateTime): CountryregioncurrencyRow =
    CountryregioncurrencyRow(
      countryregioncode = countryregioncode,
      currencycode = currencycode,
      modifieddate = modifieddate match {
                       case Defaulted.UseDefault => modifieddateDefault
                       case Defaulted.Provided(value) => value
                     }
    )
}
object CountryregioncurrencyRowUnsaved {
  implicit lazy val decoder: Decoder[CountryregioncurrencyRowUnsaved] = Decoder.forProduct3[CountryregioncurrencyRowUnsaved, CountryregionId, CurrencyId, Defaulted[TypoLocalDateTime]]("countryregioncode", "currencycode", "modifieddate")(CountryregioncurrencyRowUnsaved.apply)(CountryregionId.decoder, CurrencyId.decoder, Defaulted.decoder(TypoLocalDateTime.decoder))
  implicit lazy val encoder: Encoder[CountryregioncurrencyRowUnsaved] = Encoder.forProduct3[CountryregioncurrencyRowUnsaved, CountryregionId, CurrencyId, Defaulted[TypoLocalDateTime]]("countryregioncode", "currencycode", "modifieddate")(x => (x.countryregioncode, x.currencycode, x.modifieddate))(CountryregionId.encoder, CurrencyId.encoder, Defaulted.encoder(TypoLocalDateTime.encoder))
}
