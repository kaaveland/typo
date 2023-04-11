/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package shoppingcartitem

import adventureworks.production.product.ProductId
import java.time.LocalDateTime
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try

case class ShoppingcartitemRow(
  /** Primary key for ShoppingCartItem records.
      debug: {"table_catalog":"Adventureworks","table_schema":"sales","table_name":"shoppingcartitem","column_name":"shoppingcartitemid","ordinal_position":1,"column_default":"nextval('sales.shoppingcartitem_shoppingcartitemid_seq'::regclass)","is_nullable":"NO","data_type":"integer","numeric_precision":32,"numeric_precision_radix":2,"numeric_scale":0,"udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"int4","dtd_identifier":"1","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
  shoppingcartitemid: ShoppingcartitemId,
  /** Shopping cart identification number.
      debug: {"table_catalog":"Adventureworks","table_schema":"sales","table_name":"shoppingcartitem","column_name":"shoppingcartid","ordinal_position":2,"is_nullable":"NO","data_type":"character varying","character_maximum_length":50,"character_octet_length":200,"udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"varchar","dtd_identifier":"2","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
  shoppingcartid: String,
  /** Product quantity ordered.
      debug: {"table_catalog":"Adventureworks","table_schema":"sales","table_name":"shoppingcartitem","column_name":"quantity","ordinal_position":3,"column_default":"1","is_nullable":"NO","data_type":"integer","numeric_precision":32,"numeric_precision_radix":2,"numeric_scale":0,"udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"int4","dtd_identifier":"3","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
  quantity: Int,
  /** Product ordered. Foreign key to Product.ProductID.
      Points to [[production.product.ProductRow.productid]]
      debug: {"table_catalog":"Adventureworks","table_schema":"sales","table_name":"shoppingcartitem","column_name":"productid","ordinal_position":4,"is_nullable":"NO","data_type":"integer","numeric_precision":32,"numeric_precision_radix":2,"numeric_scale":0,"udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"int4","dtd_identifier":"4","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
  productid: ProductId,
  /** Date the time the record was created.
      debug: {"table_catalog":"Adventureworks","table_schema":"sales","table_name":"shoppingcartitem","column_name":"datecreated","ordinal_position":5,"column_default":"now()","is_nullable":"NO","data_type":"timestamp without time zone","datetime_precision":6,"udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"timestamp","dtd_identifier":"5","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
  datecreated: LocalDateTime,
  /** debug: {"table_catalog":"Adventureworks","table_schema":"sales","table_name":"shoppingcartitem","column_name":"modifieddate","ordinal_position":6,"column_default":"now()","is_nullable":"NO","data_type":"timestamp without time zone","datetime_precision":6,"udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"timestamp","dtd_identifier":"6","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
  modifieddate: LocalDateTime
)

object ShoppingcartitemRow {
  implicit val oFormat: OFormat[ShoppingcartitemRow] = new OFormat[ShoppingcartitemRow]{
    override def writes(o: ShoppingcartitemRow): JsObject =
      Json.obj(
        "shoppingcartitemid" -> o.shoppingcartitemid,
        "shoppingcartid" -> o.shoppingcartid,
        "quantity" -> o.quantity,
        "productid" -> o.productid,
        "datecreated" -> o.datecreated,
        "modifieddate" -> o.modifieddate
      )
  
    override def reads(json: JsValue): JsResult[ShoppingcartitemRow] = {
      JsResult.fromTry(
        Try(
          ShoppingcartitemRow(
            shoppingcartitemid = json.\("shoppingcartitemid").as[ShoppingcartitemId],
            shoppingcartid = json.\("shoppingcartid").as[String],
            quantity = json.\("quantity").as[Int],
            productid = json.\("productid").as[ProductId],
            datecreated = json.\("datecreated").as[LocalDateTime],
            modifieddate = json.\("modifieddate").as[LocalDateTime]
          )
        )
      )
    }
  }
}