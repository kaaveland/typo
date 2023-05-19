/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package specialofferproduct

import adventureworks.Defaulted
import adventureworks.production.product.ProductId
import adventureworks.sales.specialoffer.SpecialofferId
import io.circe.Decoder
import io.circe.Encoder
import io.circe.HCursor
import io.circe.Json
import java.time.LocalDateTime
import java.util.UUID

/** This class corresponds to a row in table `sales.specialofferproduct` which has not been persisted yet */
case class SpecialofferproductRowUnsaved(
  /** Primary key for SpecialOfferProduct records.
      Points to [[specialoffer.SpecialofferRow.specialofferid]] */
  specialofferid: SpecialofferId,
  /** Product identification number. Foreign key to Product.ProductID.
      Points to [[production.product.ProductRow.productid]] */
  productid: ProductId,
  /** Default: uuid_generate_v1() */
  rowguid: Defaulted[UUID] = Defaulted.UseDefault,
  /** Default: now() */
  modifieddate: Defaulted[LocalDateTime] = Defaulted.UseDefault
) {
  def toRow(rowguidDefault: => UUID, modifieddateDefault: => LocalDateTime): SpecialofferproductRow =
    SpecialofferproductRow(
      specialofferid = specialofferid,
      productid = productid,
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
object SpecialofferproductRowUnsaved {
  implicit val decoder: Decoder[SpecialofferproductRowUnsaved] =
    (c: HCursor) =>
      for {
        specialofferid <- c.downField("specialofferid").as[SpecialofferId]
        productid <- c.downField("productid").as[ProductId]
        rowguid <- c.downField("rowguid").as[Defaulted[UUID]]
        modifieddate <- c.downField("modifieddate").as[Defaulted[LocalDateTime]]
      } yield SpecialofferproductRowUnsaved(specialofferid, productid, rowguid, modifieddate)
  implicit val encoder: Encoder[SpecialofferproductRowUnsaved] = {
    import io.circe.syntax._
    row =>
      Json.obj(
        "specialofferid" := row.specialofferid,
        "productid" := row.productid,
        "rowguid" := row.rowguid,
        "modifieddate" := row.modifieddate
      )}
}
