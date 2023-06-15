/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sa
package sop

import adventureworks.production.product.ProductId
import adventureworks.sales.specialoffer.SpecialofferId
import io.circe.Decoder
import io.circe.Encoder
import io.circe.HCursor
import io.circe.Json
import java.time.LocalDateTime
import java.util.UUID

case class SopViewRow(
  id: Option[Int],
  /** Points to [[sales.specialofferproduct.SpecialofferproductRow.specialofferid]] */
  specialofferid: Option[SpecialofferId],
  /** Points to [[sales.specialofferproduct.SpecialofferproductRow.productid]] */
  productid: Option[ProductId],
  /** Points to [[sales.specialofferproduct.SpecialofferproductRow.rowguid]] */
  rowguid: Option[UUID],
  /** Points to [[sales.specialofferproduct.SpecialofferproductRow.modifieddate]] */
  modifieddate: Option[LocalDateTime]
)

object SopViewRow {
  implicit val decoder: Decoder[SopViewRow] =
    (c: HCursor) =>
      for {
        id <- c.downField("id").as[Option[Int]]
        specialofferid <- c.downField("specialofferid").as[Option[SpecialofferId]]
        productid <- c.downField("productid").as[Option[ProductId]]
        rowguid <- c.downField("rowguid").as[Option[UUID]]
        modifieddate <- c.downField("modifieddate").as[Option[LocalDateTime]]
      } yield SopViewRow(id, specialofferid, productid, rowguid, modifieddate)
  implicit val encoder: Encoder[SopViewRow] = {
    import io.circe.syntax._
    row =>
      Json.obj(
        "id" := row.id,
        "specialofferid" := row.specialofferid,
        "productid" := row.productid,
        "rowguid" := row.rowguid,
        "modifieddate" := row.modifieddate
      )}
}