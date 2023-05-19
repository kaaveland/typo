/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pr
package pmpdc

import adventureworks.production.culture.CultureId
import adventureworks.production.productdescription.ProductdescriptionId
import adventureworks.production.productmodel.ProductmodelId
import io.circe.Decoder
import io.circe.Encoder
import io.circe.HCursor
import io.circe.Json
import java.time.LocalDateTime

case class PmpdcViewRow(
  /** Points to [[production.productmodelproductdescriptionculture.ProductmodelproductdescriptioncultureRow.productmodelid]] */
  productmodelid: Option[ProductmodelId],
  /** Points to [[production.productmodelproductdescriptionculture.ProductmodelproductdescriptioncultureRow.productdescriptionid]] */
  productdescriptionid: Option[ProductdescriptionId],
  /** Points to [[production.productmodelproductdescriptionculture.ProductmodelproductdescriptioncultureRow.cultureid]] */
  cultureid: Option[CultureId],
  /** Points to [[production.productmodelproductdescriptionculture.ProductmodelproductdescriptioncultureRow.modifieddate]] */
  modifieddate: Option[LocalDateTime]
)

object PmpdcViewRow {
  implicit val decoder: Decoder[PmpdcViewRow] =
    (c: HCursor) =>
      for {
        productmodelid <- c.downField("productmodelid").as[Option[ProductmodelId]]
        productdescriptionid <- c.downField("productdescriptionid").as[Option[ProductdescriptionId]]
        cultureid <- c.downField("cultureid").as[Option[CultureId]]
        modifieddate <- c.downField("modifieddate").as[Option[LocalDateTime]]
      } yield PmpdcViewRow(productmodelid, productdescriptionid, cultureid, modifieddate)
  implicit val encoder: Encoder[PmpdcViewRow] = {
    import io.circe.syntax._
    row =>
      Json.obj(
        "productmodelid" := row.productmodelid,
        "productdescriptionid" := row.productdescriptionid,
        "cultureid" := row.cultureid,
        "modifieddate" := row.modifieddate
      )}
}
