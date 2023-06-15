/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package productproductphoto

import adventureworks.production.product.ProductId
import adventureworks.production.productphoto.ProductphotoId
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try

/** Type for the composite primary key of table `production.productproductphoto` */
case class ProductproductphotoId(productid: ProductId, productphotoid: ProductphotoId)
object ProductproductphotoId {
  implicit def ordering: Ordering[ProductproductphotoId] = Ordering.by(x => (x.productid, x.productphotoid))
  implicit val oFormat: OFormat[ProductproductphotoId] = new OFormat[ProductproductphotoId]{
    override def writes(o: ProductproductphotoId): JsObject =
      Json.obj(
        "productid" -> o.productid,
        "productphotoid" -> o.productphotoid
      )
  
    override def reads(json: JsValue): JsResult[ProductproductphotoId] = {
      JsResult.fromTry(
        Try(
          ProductproductphotoId(
            productid = json.\("productid").as[ProductId],
            productphotoid = json.\("productphotoid").as[ProductphotoId]
          )
        )
      )
    }
  }
}