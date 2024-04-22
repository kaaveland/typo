/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sa
package sr

import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.public.Name
import adventureworks.sales.salesreason.SalesreasonId
import doobie.enumerated.Nullability
import doobie.util.Read
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet

/** View: sa.sr */
case class SrViewRow(
  /** Points to [[sales.salesreason.SalesreasonRow.salesreasonid]] */
  id: SalesreasonId,
  /** Points to [[sales.salesreason.SalesreasonRow.salesreasonid]] */
  salesreasonid: SalesreasonId,
  /** Points to [[sales.salesreason.SalesreasonRow.name]] */
  name: Name,
  /** Points to [[sales.salesreason.SalesreasonRow.reasontype]] */
  reasontype: Name,
  /** Points to [[sales.salesreason.SalesreasonRow.modifieddate]] */
  modifieddate: TypoLocalDateTime
)

object SrViewRow {
  implicit lazy val decoder: Decoder[SrViewRow] = Decoder.forProduct5[SrViewRow, SalesreasonId, SalesreasonId, Name, Name, TypoLocalDateTime]("id", "salesreasonid", "name", "reasontype", "modifieddate")(SrViewRow.apply)(SalesreasonId.decoder, SalesreasonId.decoder, Name.decoder, Name.decoder, TypoLocalDateTime.decoder)
  implicit lazy val encoder: Encoder[SrViewRow] = Encoder.forProduct5[SrViewRow, SalesreasonId, SalesreasonId, Name, Name, TypoLocalDateTime]("id", "salesreasonid", "name", "reasontype", "modifieddate")(x => (x.id, x.salesreasonid, x.name, x.reasontype, x.modifieddate))(SalesreasonId.encoder, SalesreasonId.encoder, Name.encoder, Name.encoder, TypoLocalDateTime.encoder)
  implicit lazy val read: Read[SrViewRow] = new Read[SrViewRow](
    gets = List(
      (SalesreasonId.get, Nullability.NoNulls),
      (SalesreasonId.get, Nullability.NoNulls),
      (Name.get, Nullability.NoNulls),
      (Name.get, Nullability.NoNulls),
      (TypoLocalDateTime.get, Nullability.NoNulls)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => SrViewRow(
      id = SalesreasonId.get.unsafeGetNonNullable(rs, i + 0),
      salesreasonid = SalesreasonId.get.unsafeGetNonNullable(rs, i + 1),
      name = Name.get.unsafeGetNonNullable(rs, i + 2),
      reasontype = Name.get.unsafeGetNonNullable(rs, i + 3),
      modifieddate = TypoLocalDateTime.get.unsafeGetNonNullable(rs, i + 4)
    )
  )
}
