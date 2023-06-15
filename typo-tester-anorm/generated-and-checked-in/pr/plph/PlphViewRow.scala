/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pr
package plph

import adventureworks.production.product.ProductId
import java.time.LocalDateTime
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try

case class PlphViewRow(
  id: Option[Int],
  /** Points to [[production.productlistpricehistory.ProductlistpricehistoryRow.productid]] */
  productid: Option[ProductId],
  /** Points to [[production.productlistpricehistory.ProductlistpricehistoryRow.startdate]] */
  startdate: Option[LocalDateTime],
  /** Points to [[production.productlistpricehistory.ProductlistpricehistoryRow.enddate]] */
  enddate: Option[LocalDateTime],
  /** Points to [[production.productlistpricehistory.ProductlistpricehistoryRow.listprice]] */
  listprice: Option[BigDecimal],
  /** Points to [[production.productlistpricehistory.ProductlistpricehistoryRow.modifieddate]] */
  modifieddate: Option[LocalDateTime]
)

object PlphViewRow {
  implicit val oFormat: OFormat[PlphViewRow] = new OFormat[PlphViewRow]{
    override def writes(o: PlphViewRow): JsObject =
      Json.obj(
        "id" -> o.id,
        "productid" -> o.productid,
        "startdate" -> o.startdate,
        "enddate" -> o.enddate,
        "listprice" -> o.listprice,
        "modifieddate" -> o.modifieddate
      )
  
    override def reads(json: JsValue): JsResult[PlphViewRow] = {
      JsResult.fromTry(
        Try(
          PlphViewRow(
            id = json.\("id").toOption.map(_.as[Int]),
            productid = json.\("productid").toOption.map(_.as[ProductId]),
            startdate = json.\("startdate").toOption.map(_.as[LocalDateTime]),
            enddate = json.\("enddate").toOption.map(_.as[LocalDateTime]),
            listprice = json.\("listprice").toOption.map(_.as[BigDecimal]),
            modifieddate = json.\("modifieddate").toOption.map(_.as[LocalDateTime])
          )
        )
      )
    }
  }
}