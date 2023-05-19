/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pr
package ppp

import adventureworks.production.product.ProductId
import adventureworks.production.productphoto.ProductphotoId
import adventureworks.public.Flag
import io.circe.Decoder
import io.circe.Encoder
import io.circe.HCursor
import io.circe.Json
import java.time.LocalDateTime

case class PppViewRow(
  /** Points to [[production.productproductphoto.ProductproductphotoRow.productid]] */
  productid: Option[ProductId],
  /** Points to [[production.productproductphoto.ProductproductphotoRow.productphotoid]] */
  productphotoid: Option[ProductphotoId],
  /** Points to [[production.productproductphoto.ProductproductphotoRow.primary]] */
  primary: Flag,
  /** Points to [[production.productproductphoto.ProductproductphotoRow.modifieddate]] */
  modifieddate: Option[LocalDateTime]
)

object PppViewRow {
  implicit val decoder: Decoder[PppViewRow] =
    (c: HCursor) =>
      for {
        productid <- c.downField("productid").as[Option[ProductId]]
        productphotoid <- c.downField("productphotoid").as[Option[ProductphotoId]]
        primary <- c.downField("primary").as[Flag]
        modifieddate <- c.downField("modifieddate").as[Option[LocalDateTime]]
      } yield PppViewRow(productid, productphotoid, primary, modifieddate)
  implicit val encoder: Encoder[PppViewRow] = {
    import io.circe.syntax._
    row =>
      Json.obj(
        "productid" := row.productid,
        "productphotoid" := row.productphotoid,
        "primary" := row.primary,
        "modifieddate" := row.modifieddate
      )}
}
