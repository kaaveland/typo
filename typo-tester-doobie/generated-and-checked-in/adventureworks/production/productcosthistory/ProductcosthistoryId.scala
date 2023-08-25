/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package productcosthistory

import adventureworks.TypoLocalDateTime
import adventureworks.production.product.ProductId
import io.circe.Decoder
import io.circe.Encoder

/** Type for the composite primary key of table `production.productcosthistory` */
case class ProductcosthistoryId(productid: ProductId, startdate: TypoLocalDateTime)
object ProductcosthistoryId {
  implicit lazy val decoder: Decoder[ProductcosthistoryId] = Decoder.forProduct2[ProductcosthistoryId, ProductId, TypoLocalDateTime]("productid", "startdate")(ProductcosthistoryId.apply)(ProductId.decoder, TypoLocalDateTime.decoder)
  implicit lazy val encoder: Encoder[ProductcosthistoryId] = Encoder.forProduct2[ProductcosthistoryId, ProductId, TypoLocalDateTime]("productid", "startdate")(x => (x.productid, x.startdate))(ProductId.encoder, TypoLocalDateTime.encoder)
  implicit def ordering(implicit O0: Ordering[TypoLocalDateTime]): Ordering[ProductcosthistoryId] = Ordering.by(x => (x.productid, x.startdate))
}