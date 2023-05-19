/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package productcosthistory

import adventureworks.Defaulted
import adventureworks.production.product.ProductId
import io.circe.Decoder
import io.circe.Encoder
import io.circe.HCursor
import io.circe.Json
import java.time.LocalDateTime

/** This class corresponds to a row in table `production.productcosthistory` which has not been persisted yet */
case class ProductcosthistoryRowUnsaved(
  /** Product identification number. Foreign key to Product.ProductID
      Points to [[product.ProductRow.productid]] */
  productid: ProductId,
  /** Product cost start date. */
  startdate: LocalDateTime,
  /** Product cost end date. */
  enddate: Option[LocalDateTime],
  /** Standard cost of the product. */
  standardcost: BigDecimal,
  /** Default: now() */
  modifieddate: Defaulted[LocalDateTime] = Defaulted.UseDefault
) {
  def toRow(modifieddateDefault: => LocalDateTime): ProductcosthistoryRow =
    ProductcosthistoryRow(
      productid = productid,
      startdate = startdate,
      enddate = enddate,
      standardcost = standardcost,
      modifieddate = modifieddate match {
                       case Defaulted.UseDefault => modifieddateDefault
                       case Defaulted.Provided(value) => value
                     }
    )
}
object ProductcosthistoryRowUnsaved {
  implicit val decoder: Decoder[ProductcosthistoryRowUnsaved] =
    (c: HCursor) =>
      for {
        productid <- c.downField("productid").as[ProductId]
        startdate <- c.downField("startdate").as[LocalDateTime]
        enddate <- c.downField("enddate").as[Option[LocalDateTime]]
        standardcost <- c.downField("standardcost").as[BigDecimal]
        modifieddate <- c.downField("modifieddate").as[Defaulted[LocalDateTime]]
      } yield ProductcosthistoryRowUnsaved(productid, startdate, enddate, standardcost, modifieddate)
  implicit val encoder: Encoder[ProductcosthistoryRowUnsaved] = {
    import io.circe.syntax._
    row =>
      Json.obj(
        "productid" := row.productid,
        "startdate" := row.startdate,
        "enddate" := row.enddate,
        "standardcost" := row.standardcost,
        "modifieddate" := row.modifieddate
      )}
}
