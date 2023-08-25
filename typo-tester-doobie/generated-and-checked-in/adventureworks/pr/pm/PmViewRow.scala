/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pr
package pm

import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoXml
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
  id: Int,
  /** Points to [[production.productmodel.ProductmodelRow.productmodelid]] */
  productmodelid: ProductmodelId,
  /** Points to [[production.productmodel.ProductmodelRow.name]] */
  name: Name,
  /** Points to [[production.productmodel.ProductmodelRow.catalogdescription]] */
  catalogdescription: TypoXml,
  /** Points to [[production.productmodel.ProductmodelRow.instructions]] */
  instructions: TypoXml,
  /** Points to [[production.productmodel.ProductmodelRow.rowguid]] */
  rowguid: UUID,
  /** Points to [[production.productmodel.ProductmodelRow.modifieddate]] */
  modifieddate: TypoLocalDateTime
)

object PmViewRow {
  implicit lazy val decoder: Decoder[PmViewRow] = Decoder.forProduct7[PmViewRow, Int, ProductmodelId, Name, TypoXml, TypoXml, UUID, TypoLocalDateTime]("id", "productmodelid", "name", "catalogdescription", "instructions", "rowguid", "modifieddate")(PmViewRow.apply)(Decoder.decodeInt, ProductmodelId.decoder, Name.decoder, TypoXml.decoder, TypoXml.decoder, Decoder.decodeUUID, TypoLocalDateTime.decoder)
  implicit lazy val encoder: Encoder[PmViewRow] = Encoder.forProduct7[PmViewRow, Int, ProductmodelId, Name, TypoXml, TypoXml, UUID, TypoLocalDateTime]("id", "productmodelid", "name", "catalogdescription", "instructions", "rowguid", "modifieddate")(x => (x.id, x.productmodelid, x.name, x.catalogdescription, x.instructions, x.rowguid, x.modifieddate))(Encoder.encodeInt, ProductmodelId.encoder, Name.encoder, TypoXml.encoder, TypoXml.encoder, Encoder.encodeUUID, TypoLocalDateTime.encoder)
  implicit lazy val read: Read[PmViewRow] = new Read[PmViewRow](
    gets = List(
      (Meta.IntMeta.get, Nullability.NoNulls),
      (ProductmodelId.get, Nullability.NoNulls),
      (Name.get, Nullability.NoNulls),
      (TypoXml.get, Nullability.NoNulls),
      (TypoXml.get, Nullability.NoNulls),
      (adventureworks.UUIDMeta.get, Nullability.NoNulls),
      (TypoLocalDateTime.get, Nullability.NoNulls)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => PmViewRow(
      id = Meta.IntMeta.get.unsafeGetNonNullable(rs, i + 0),
      productmodelid = ProductmodelId.get.unsafeGetNonNullable(rs, i + 1),
      name = Name.get.unsafeGetNonNullable(rs, i + 2),
      catalogdescription = TypoXml.get.unsafeGetNonNullable(rs, i + 3),
      instructions = TypoXml.get.unsafeGetNonNullable(rs, i + 4),
      rowguid = adventureworks.UUIDMeta.get.unsafeGetNonNullable(rs, i + 5),
      modifieddate = TypoLocalDateTime.get.unsafeGetNonNullable(rs, i + 6)
    )
  )
}
