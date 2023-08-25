/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pe
package cr

import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.person.countryregion.CountryregionId
import adventureworks.public.Name
import doobie.enumerated.Nullability
import doobie.util.Read
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet

case class CrViewRow(
  /** Points to [[person.countryregion.CountryregionRow.countryregioncode]] */
  countryregioncode: CountryregionId,
  /** Points to [[person.countryregion.CountryregionRow.name]] */
  name: Name,
  /** Points to [[person.countryregion.CountryregionRow.modifieddate]] */
  modifieddate: TypoLocalDateTime
)

object CrViewRow {
  implicit lazy val decoder: Decoder[CrViewRow] = Decoder.forProduct3[CrViewRow, CountryregionId, Name, TypoLocalDateTime]("countryregioncode", "name", "modifieddate")(CrViewRow.apply)(CountryregionId.decoder, Name.decoder, TypoLocalDateTime.decoder)
  implicit lazy val encoder: Encoder[CrViewRow] = Encoder.forProduct3[CrViewRow, CountryregionId, Name, TypoLocalDateTime]("countryregioncode", "name", "modifieddate")(x => (x.countryregioncode, x.name, x.modifieddate))(CountryregionId.encoder, Name.encoder, TypoLocalDateTime.encoder)
  implicit lazy val read: Read[CrViewRow] = new Read[CrViewRow](
    gets = List(
      (CountryregionId.get, Nullability.NoNulls),
      (Name.get, Nullability.NoNulls),
      (TypoLocalDateTime.get, Nullability.NoNulls)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => CrViewRow(
      countryregioncode = CountryregionId.get.unsafeGetNonNullable(rs, i + 0),
      name = Name.get.unsafeGetNonNullable(rs, i + 1),
      modifieddate = TypoLocalDateTime.get.unsafeGetNonNullable(rs, i + 2)
    )
  )
}
