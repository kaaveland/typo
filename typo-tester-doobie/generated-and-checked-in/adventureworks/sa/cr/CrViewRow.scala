/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sa
package cr

import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.sales.currency.CurrencyId
import adventureworks.sales.currencyrate.CurrencyrateId
import doobie.enumerated.Nullability
import doobie.util.Read
import doobie.util.meta.Meta
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet

case class CrViewRow(
  /** Points to [[sales.currencyrate.CurrencyrateRow.currencyrateid]] */
  currencyrateid: CurrencyrateId,
  /** Points to [[sales.currencyrate.CurrencyrateRow.currencyratedate]] */
  currencyratedate: TypoLocalDateTime,
  /** Points to [[sales.currencyrate.CurrencyrateRow.fromcurrencycode]] */
  fromcurrencycode: CurrencyId,
  /** Points to [[sales.currencyrate.CurrencyrateRow.tocurrencycode]] */
  tocurrencycode: CurrencyId,
  /** Points to [[sales.currencyrate.CurrencyrateRow.averagerate]] */
  averagerate: BigDecimal,
  /** Points to [[sales.currencyrate.CurrencyrateRow.endofdayrate]] */
  endofdayrate: BigDecimal,
  /** Points to [[sales.currencyrate.CurrencyrateRow.modifieddate]] */
  modifieddate: TypoLocalDateTime
)

object CrViewRow {
  implicit lazy val decoder: Decoder[CrViewRow] = Decoder.forProduct7[CrViewRow, CurrencyrateId, TypoLocalDateTime, CurrencyId, CurrencyId, BigDecimal, BigDecimal, TypoLocalDateTime]("currencyrateid", "currencyratedate", "fromcurrencycode", "tocurrencycode", "averagerate", "endofdayrate", "modifieddate")(CrViewRow.apply)(CurrencyrateId.decoder, TypoLocalDateTime.decoder, CurrencyId.decoder, CurrencyId.decoder, Decoder.decodeBigDecimal, Decoder.decodeBigDecimal, TypoLocalDateTime.decoder)
  implicit lazy val encoder: Encoder[CrViewRow] = Encoder.forProduct7[CrViewRow, CurrencyrateId, TypoLocalDateTime, CurrencyId, CurrencyId, BigDecimal, BigDecimal, TypoLocalDateTime]("currencyrateid", "currencyratedate", "fromcurrencycode", "tocurrencycode", "averagerate", "endofdayrate", "modifieddate")(x => (x.currencyrateid, x.currencyratedate, x.fromcurrencycode, x.tocurrencycode, x.averagerate, x.endofdayrate, x.modifieddate))(CurrencyrateId.encoder, TypoLocalDateTime.encoder, CurrencyId.encoder, CurrencyId.encoder, Encoder.encodeBigDecimal, Encoder.encodeBigDecimal, TypoLocalDateTime.encoder)
  implicit lazy val read: Read[CrViewRow] = new Read[CrViewRow](
    gets = List(
      (CurrencyrateId.get, Nullability.NoNulls),
      (TypoLocalDateTime.get, Nullability.NoNulls),
      (CurrencyId.get, Nullability.NoNulls),
      (CurrencyId.get, Nullability.NoNulls),
      (Meta.ScalaBigDecimalMeta.get, Nullability.NoNulls),
      (Meta.ScalaBigDecimalMeta.get, Nullability.NoNulls),
      (TypoLocalDateTime.get, Nullability.NoNulls)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => CrViewRow(
      currencyrateid = CurrencyrateId.get.unsafeGetNonNullable(rs, i + 0),
      currencyratedate = TypoLocalDateTime.get.unsafeGetNonNullable(rs, i + 1),
      fromcurrencycode = CurrencyId.get.unsafeGetNonNullable(rs, i + 2),
      tocurrencycode = CurrencyId.get.unsafeGetNonNullable(rs, i + 3),
      averagerate = Meta.ScalaBigDecimalMeta.get.unsafeGetNonNullable(rs, i + 4),
      endofdayrate = Meta.ScalaBigDecimalMeta.get.unsafeGetNonNullable(rs, i + 5),
      modifieddate = TypoLocalDateTime.get.unsafeGetNonNullable(rs, i + 6)
    )
  )
}
