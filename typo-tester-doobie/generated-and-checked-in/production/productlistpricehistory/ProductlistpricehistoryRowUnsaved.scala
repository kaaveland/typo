/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package productlistpricehistory

import adventureworks.Defaulted
import adventureworks.production.product.ProductId
import io.circe.Decoder
import io.circe.Encoder
import io.circe.HCursor
import io.circe.Json
import java.time.LocalDateTime

/** This class corresponds to a row in table `production.productlistpricehistory` which has not been persisted yet */
case class ProductlistpricehistoryRowUnsaved(
  /** Product identification number. Foreign key to Product.ProductID
      Points to [[product.ProductRow.productid]] */
  productid: ProductId,
  /** List price start date. */
  startdate: LocalDateTime,
  /** List price end date */
  enddate: Option[LocalDateTime],
  /** Product list price. */
  listprice: BigDecimal,
  /** Default: now() */
  modifieddate: Defaulted[LocalDateTime] = Defaulted.UseDefault
) {
  def toRow(modifieddateDefault: => LocalDateTime): ProductlistpricehistoryRow =
    ProductlistpricehistoryRow(
      productid = productid,
      startdate = startdate,
      enddate = enddate,
      listprice = listprice,
      modifieddate = modifieddate match {
                       case Defaulted.UseDefault => modifieddateDefault
                       case Defaulted.Provided(value) => value
                     }
    )
}
object ProductlistpricehistoryRowUnsaved {
  implicit val decoder: Decoder[ProductlistpricehistoryRowUnsaved] =
    (c: HCursor) =>
      for {
        productid <- c.downField("productid").as[ProductId]
        startdate <- c.downField("startdate").as[LocalDateTime]
        enddate <- c.downField("enddate").as[Option[LocalDateTime]]
        listprice <- c.downField("listprice").as[BigDecimal]
        modifieddate <- c.downField("modifieddate").as[Defaulted[LocalDateTime]]
      } yield ProductlistpricehistoryRowUnsaved(productid, startdate, enddate, listprice, modifieddate)
  implicit val encoder: Encoder[ProductlistpricehistoryRowUnsaved] = {
    import io.circe.syntax._
    row =>
      Json.obj(
        "productid" := row.productid,
        "startdate" := row.startdate,
        "enddate" := row.enddate,
        "listprice" := row.listprice,
        "modifieddate" := row.modifieddate
      )}
}
