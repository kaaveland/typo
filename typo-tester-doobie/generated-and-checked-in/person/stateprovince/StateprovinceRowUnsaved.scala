/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package person
package stateprovince

import adventureworks.Defaulted
import adventureworks.TypoLocalDateTime
import adventureworks.person.countryregion.CountryregionId
import adventureworks.public.Flag
import adventureworks.public.Name
import adventureworks.sales.salesterritory.SalesterritoryId
import io.circe.Decoder
import io.circe.Encoder
import java.util.UUID

/** This class corresponds to a row in table `person.stateprovince` which has not been persisted yet */
case class StateprovinceRowUnsaved(
  /** ISO standard state or province code. */
  stateprovincecode: /* bpchar */ String,
  /** ISO standard country or region code. Foreign key to CountryRegion.CountryRegionCode.
      Points to [[countryregion.CountryregionRow.countryregioncode]] */
  countryregioncode: CountryregionId,
  /** State or province description. */
  name: Name,
  /** ID of the territory in which the state or province is located. Foreign key to SalesTerritory.SalesTerritoryID.
      Points to [[sales.salesterritory.SalesterritoryRow.territoryid]] */
  territoryid: SalesterritoryId,
  /** Default: nextval('person.stateprovince_stateprovinceid_seq'::regclass)
      Primary key for StateProvince records. */
  stateprovinceid: Defaulted[StateprovinceId] = Defaulted.UseDefault,
  /** Default: true
      0 = StateProvinceCode exists. 1 = StateProvinceCode unavailable, using CountryRegionCode. */
  isonlystateprovinceflag: Defaulted[Flag] = Defaulted.UseDefault,
  /** Default: uuid_generate_v1() */
  rowguid: Defaulted[UUID] = Defaulted.UseDefault,
  /** Default: now() */
  modifieddate: Defaulted[TypoLocalDateTime] = Defaulted.UseDefault
) {
  def toRow(stateprovinceidDefault: => StateprovinceId, isonlystateprovinceflagDefault: => Flag, rowguidDefault: => UUID, modifieddateDefault: => TypoLocalDateTime): StateprovinceRow =
    StateprovinceRow(
      stateprovincecode = stateprovincecode,
      countryregioncode = countryregioncode,
      name = name,
      territoryid = territoryid,
      stateprovinceid = stateprovinceid match {
                          case Defaulted.UseDefault => stateprovinceidDefault
                          case Defaulted.Provided(value) => value
                        },
      isonlystateprovinceflag = isonlystateprovinceflag match {
                                  case Defaulted.UseDefault => isonlystateprovinceflagDefault
                                  case Defaulted.Provided(value) => value
                                },
      rowguid = rowguid match {
                  case Defaulted.UseDefault => rowguidDefault
                  case Defaulted.Provided(value) => value
                },
      modifieddate = modifieddate match {
                       case Defaulted.UseDefault => modifieddateDefault
                       case Defaulted.Provided(value) => value
                     }
    )
}
object StateprovinceRowUnsaved {
  implicit lazy val decoder: Decoder[StateprovinceRowUnsaved] = Decoder.forProduct8[StateprovinceRowUnsaved, /* bpchar */ String, CountryregionId, Name, SalesterritoryId, Defaulted[StateprovinceId], Defaulted[Flag], Defaulted[UUID], Defaulted[TypoLocalDateTime]]("stateprovincecode", "countryregioncode", "name", "territoryid", "stateprovinceid", "isonlystateprovinceflag", "rowguid", "modifieddate")(StateprovinceRowUnsaved.apply)(Decoder.decodeString, CountryregionId.decoder, Name.decoder, SalesterritoryId.decoder, Defaulted.decoder(StateprovinceId.decoder), Defaulted.decoder(Flag.decoder), Defaulted.decoder(Decoder.decodeUUID), Defaulted.decoder(TypoLocalDateTime.decoder))
  implicit lazy val encoder: Encoder[StateprovinceRowUnsaved] = Encoder.forProduct8[StateprovinceRowUnsaved, /* bpchar */ String, CountryregionId, Name, SalesterritoryId, Defaulted[StateprovinceId], Defaulted[Flag], Defaulted[UUID], Defaulted[TypoLocalDateTime]]("stateprovincecode", "countryregioncode", "name", "territoryid", "stateprovinceid", "isonlystateprovinceflag", "rowguid", "modifieddate")(x => (x.stateprovincecode, x.countryregioncode, x.name, x.territoryid, x.stateprovinceid, x.isonlystateprovinceflag, x.rowguid, x.modifieddate))(Encoder.encodeString, CountryregionId.encoder, Name.encoder, SalesterritoryId.encoder, Defaulted.encoder(StateprovinceId.encoder), Defaulted.encoder(Flag.encoder), Defaulted.encoder(Encoder.encodeUUID), Defaulted.encoder(TypoLocalDateTime.encoder))
}
