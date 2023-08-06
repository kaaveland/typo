/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package countryregioncurrency

import adventureworks.person.countryregion.CountryregionId
import adventureworks.sales.currency.CurrencyId
import io.circe.Decoder
import io.circe.Encoder

/** Type for the composite primary key of table `sales.countryregioncurrency` */
case class CountryregioncurrencyId(countryregioncode: CountryregionId, currencycode: CurrencyId)
object CountryregioncurrencyId {
  implicit lazy val decoder: Decoder[CountryregioncurrencyId] = Decoder.forProduct2[CountryregioncurrencyId, CountryregionId, CurrencyId]("countryregioncode", "currencycode")(CountryregioncurrencyId.apply)(CountryregionId.decoder, CurrencyId.decoder)
  implicit lazy val encoder: Encoder[CountryregioncurrencyId] = Encoder.forProduct2[CountryregioncurrencyId, CountryregionId, CurrencyId]("countryregioncode", "currencycode")(x => (x.countryregioncode, x.currencycode))(CountryregionId.encoder, CurrencyId.encoder)
  implicit lazy val ordering: Ordering[CountryregioncurrencyId] = Ordering.by(x => (x.countryregioncode, x.currencycode))
}
