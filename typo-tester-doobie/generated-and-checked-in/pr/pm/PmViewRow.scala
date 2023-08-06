/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pr
package pm

import adventureworks.TypoLocalDateTime
import adventureworks.TypoXml
import adventureworks.production.productmodel.ProductmodelId
import adventureworks.public.Name
import doobie.enumerated.Nullability
import doobie.util.Read
import doobie.util.meta.Meta
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet
import java.util.UUID

case class PmViewRow(
  id: Option[Int],
  /** Points to [[production.productmodel.ProductmodelRow.productmodelid]] */
  productmodelid: Option[ProductmodelId],
  /** Points to [[production.productmodel.ProductmodelRow.name]] */
  name: Option[Name],
  /** Points to [[production.productmodel.ProductmodelRow.catalogdescription]] */
  catalogdescription: Option[TypoXml],
  /** Points to [[production.productmodel.ProductmodelRow.instructions]] */
  instructions: Option[TypoXml],
  /** Points to [[production.productmodel.ProductmodelRow.rowguid]] */
  rowguid: Option[UUID],
  /** Points to [[production.productmodel.ProductmodelRow.modifieddate]] */
  modifieddate: Option[TypoLocalDateTime]
)

object PmViewRow {
  implicit lazy val decoder: Decoder[PmViewRow] = Decoder.forProduct7[PmViewRow, Option[Int], Option[ProductmodelId], Option[Name], Option[TypoXml], Option[TypoXml], Option[UUID], Option[TypoLocalDateTime]]("id", "productmodelid", "name", "catalogdescription", "instructions", "rowguid", "modifieddate")(PmViewRow.apply)(Decoder.decodeOption(Decoder.decodeInt), Decoder.decodeOption(ProductmodelId.decoder), Decoder.decodeOption(Name.decoder), Decoder.decodeOption(TypoXml.decoder), Decoder.decodeOption(TypoXml.decoder), Decoder.decodeOption(Decoder.decodeUUID), Decoder.decodeOption(TypoLocalDateTime.decoder))
  implicit lazy val encoder: Encoder[PmViewRow] = Encoder.forProduct7[PmViewRow, Option[Int], Option[ProductmodelId], Option[Name], Option[TypoXml], Option[TypoXml], Option[UUID], Option[TypoLocalDateTime]]("id", "productmodelid", "name", "catalogdescription", "instructions", "rowguid", "modifieddate")(x => (x.id, x.productmodelid, x.name, x.catalogdescription, x.instructions, x.rowguid, x.modifieddate))(Encoder.encodeOption(Encoder.encodeInt), Encoder.encodeOption(ProductmodelId.encoder), Encoder.encodeOption(Name.encoder), Encoder.encodeOption(TypoXml.encoder), Encoder.encodeOption(TypoXml.encoder), Encoder.encodeOption(Encoder.encodeUUID), Encoder.encodeOption(TypoLocalDateTime.encoder))
  implicit lazy val read: Read[PmViewRow] = new Read[PmViewRow](
    gets = List(
      (Meta.IntMeta.get, Nullability.Nullable),
      (ProductmodelId.get, Nullability.Nullable),
      (Name.get, Nullability.Nullable),
      (TypoXml.get, Nullability.Nullable),
      (TypoXml.get, Nullability.Nullable),
      (adventureworks.UUIDMeta.get, Nullability.Nullable),
      (TypoLocalDateTime.get, Nullability.Nullable)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => PmViewRow(
      id = Meta.IntMeta.get.unsafeGetNullable(rs, i + 0),
      productmodelid = ProductmodelId.get.unsafeGetNullable(rs, i + 1),
      name = Name.get.unsafeGetNullable(rs, i + 2),
      catalogdescription = TypoXml.get.unsafeGetNullable(rs, i + 3),
      instructions = TypoXml.get.unsafeGetNullable(rs, i + 4),
      rowguid = adventureworks.UUIDMeta.get.unsafeGetNullable(rs, i + 5),
      modifieddate = TypoLocalDateTime.get.unsafeGetNullable(rs, i + 6)
    )
  )
}
