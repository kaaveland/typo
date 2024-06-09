/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package productinventory

import adventureworks.production.location.LocationId
import adventureworks.production.product.ProductId
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.OWrites
import play.api.libs.json.Reads
import scala.collection.immutable.ListMap
import scala.util.Try

/** Type for the composite primary key of table `production.productinventory` */
case class ProductinventoryId(
  productid: ProductId,
  locationid: LocationId
)
object ProductinventoryId {
  implicit lazy val ordering: Ordering[ProductinventoryId] = Ordering.by(x => (x.productid, x.locationid))
  implicit lazy val reads: Reads[ProductinventoryId] = Reads[ProductinventoryId](json => JsResult.fromTry(
      Try(
        ProductinventoryId(
          productid = json.\("productid").as(ProductId.reads),
          locationid = json.\("locationid").as(LocationId.reads)
        )
      )
    ),
  )
  implicit lazy val writes: OWrites[ProductinventoryId] = OWrites[ProductinventoryId](o =>
    new JsObject(ListMap[String, JsValue](
      "productid" -> ProductId.writes.writes(o.productid),
      "locationid" -> LocationId.writes.writes(o.locationid)
    ))
  )
}
