/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package salesperson

import adventureworks.Defaulted
import adventureworks.TypoLocalDateTime
import adventureworks.person.businessentity.BusinessentityId
import adventureworks.sales.salesterritory.SalesterritoryId
import io.circe.Decoder
import io.circe.Encoder
import java.util.UUID

/** This class corresponds to a row in table `sales.salesperson` which has not been persisted yet */
case class SalespersonRowUnsaved(
  /** Primary key for SalesPerson records. Foreign key to Employee.BusinessEntityID
      Points to [[humanresources.employee.EmployeeRow.businessentityid]] */
  businessentityid: BusinessentityId,
  /** Territory currently assigned to. Foreign key to SalesTerritory.SalesTerritoryID.
      Points to [[salesterritory.SalesterritoryRow.territoryid]] */
  territoryid: Option[SalesterritoryId],
  /** Projected yearly sales. */
  salesquota: Option[BigDecimal],
  /** Default: 0.00
      Bonus due if quota is met. */
  bonus: Defaulted[BigDecimal] = Defaulted.UseDefault,
  /** Default: 0.00
      Commision percent received per sale. */
  commissionpct: Defaulted[BigDecimal] = Defaulted.UseDefault,
  /** Default: 0.00
      Sales total year to date. */
  salesytd: Defaulted[BigDecimal] = Defaulted.UseDefault,
  /** Default: 0.00
      Sales total of previous year. */
  saleslastyear: Defaulted[BigDecimal] = Defaulted.UseDefault,
  /** Default: uuid_generate_v1() */
  rowguid: Defaulted[UUID] = Defaulted.UseDefault,
  /** Default: now() */
  modifieddate: Defaulted[TypoLocalDateTime] = Defaulted.UseDefault
) {
  def toRow(bonusDefault: => BigDecimal, commissionpctDefault: => BigDecimal, salesytdDefault: => BigDecimal, saleslastyearDefault: => BigDecimal, rowguidDefault: => UUID, modifieddateDefault: => TypoLocalDateTime): SalespersonRow =
    SalespersonRow(
      businessentityid = businessentityid,
      territoryid = territoryid,
      salesquota = salesquota,
      bonus = bonus match {
                case Defaulted.UseDefault => bonusDefault
                case Defaulted.Provided(value) => value
              },
      commissionpct = commissionpct match {
                        case Defaulted.UseDefault => commissionpctDefault
                        case Defaulted.Provided(value) => value
                      },
      salesytd = salesytd match {
                   case Defaulted.UseDefault => salesytdDefault
                   case Defaulted.Provided(value) => value
                 },
      saleslastyear = saleslastyear match {
                        case Defaulted.UseDefault => saleslastyearDefault
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
object SalespersonRowUnsaved {
  implicit lazy val decoder: Decoder[SalespersonRowUnsaved] = Decoder.forProduct9[SalespersonRowUnsaved, BusinessentityId, Option[SalesterritoryId], Option[BigDecimal], Defaulted[BigDecimal], Defaulted[BigDecimal], Defaulted[BigDecimal], Defaulted[BigDecimal], Defaulted[UUID], Defaulted[TypoLocalDateTime]]("businessentityid", "territoryid", "salesquota", "bonus", "commissionpct", "salesytd", "saleslastyear", "rowguid", "modifieddate")(SalespersonRowUnsaved.apply)(BusinessentityId.decoder, Decoder.decodeOption(SalesterritoryId.decoder), Decoder.decodeOption(Decoder.decodeBigDecimal), Defaulted.decoder(Decoder.decodeBigDecimal), Defaulted.decoder(Decoder.decodeBigDecimal), Defaulted.decoder(Decoder.decodeBigDecimal), Defaulted.decoder(Decoder.decodeBigDecimal), Defaulted.decoder(Decoder.decodeUUID), Defaulted.decoder(TypoLocalDateTime.decoder))
  implicit lazy val encoder: Encoder[SalespersonRowUnsaved] = Encoder.forProduct9[SalespersonRowUnsaved, BusinessentityId, Option[SalesterritoryId], Option[BigDecimal], Defaulted[BigDecimal], Defaulted[BigDecimal], Defaulted[BigDecimal], Defaulted[BigDecimal], Defaulted[UUID], Defaulted[TypoLocalDateTime]]("businessentityid", "territoryid", "salesquota", "bonus", "commissionpct", "salesytd", "saleslastyear", "rowguid", "modifieddate")(x => (x.businessentityid, x.territoryid, x.salesquota, x.bonus, x.commissionpct, x.salesytd, x.saleslastyear, x.rowguid, x.modifieddate))(BusinessentityId.encoder, Encoder.encodeOption(SalesterritoryId.encoder), Encoder.encodeOption(Encoder.encodeBigDecimal), Defaulted.encoder(Encoder.encodeBigDecimal), Defaulted.encoder(Encoder.encodeBigDecimal), Defaulted.encoder(Encoder.encodeBigDecimal), Defaulted.encoder(Encoder.encodeBigDecimal), Defaulted.encoder(Encoder.encodeUUID), Defaulted.encoder(TypoLocalDateTime.encoder))
}
