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

case class PlphRow(
  /** debug: {"table_catalog":"Adventureworks","table_schema":"pr","table_name":"plph","column_name":"id","ordinal_position":1,"is_nullable":"YES","data_type":"integer","numeric_precision":32,"numeric_precision_radix":2,"numeric_scale":0,"udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"int4","dtd_identifier":"1","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
  id: Option[Int],
  /** Points to [[production.productlistpricehistory.ProductlistpricehistoryRow.productid]]
      debug: {"table_catalog":"Adventureworks","table_schema":"pr","table_name":"plph","column_name":"productid","ordinal_position":2,"is_nullable":"YES","data_type":"integer","numeric_precision":32,"numeric_precision_radix":2,"numeric_scale":0,"udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"int4","dtd_identifier":"2","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
  productid: Option[ProductId],
  /** Points to [[production.productlistpricehistory.ProductlistpricehistoryRow.startdate]]
      debug: {"table_catalog":"Adventureworks","table_schema":"pr","table_name":"plph","column_name":"startdate","ordinal_position":3,"is_nullable":"YES","data_type":"timestamp without time zone","datetime_precision":6,"udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"timestamp","dtd_identifier":"3","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
  startdate: Option[LocalDateTime],
  /** Points to [[production.productlistpricehistory.ProductlistpricehistoryRow.enddate]]
      debug: {"table_catalog":"Adventureworks","table_schema":"pr","table_name":"plph","column_name":"enddate","ordinal_position":4,"is_nullable":"YES","data_type":"timestamp without time zone","datetime_precision":6,"udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"timestamp","dtd_identifier":"4","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
  enddate: Option[LocalDateTime],
  /** Points to [[production.productlistpricehistory.ProductlistpricehistoryRow.listprice]]
      debug: {"table_catalog":"Adventureworks","table_schema":"pr","table_name":"plph","column_name":"listprice","ordinal_position":5,"is_nullable":"YES","data_type":"numeric","numeric_precision_radix":10,"udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"numeric","dtd_identifier":"5","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
  listprice: Option[BigDecimal],
  /** Points to [[production.productlistpricehistory.ProductlistpricehistoryRow.modifieddate]]
      debug: {"table_catalog":"Adventureworks","table_schema":"pr","table_name":"plph","column_name":"modifieddate","ordinal_position":6,"is_nullable":"YES","data_type":"timestamp without time zone","datetime_precision":6,"udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"timestamp","dtd_identifier":"6","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
  modifieddate: Option[LocalDateTime]
)

object PlphRow {
  implicit val oFormat: OFormat[PlphRow] = new OFormat[PlphRow]{
    override def writes(o: PlphRow): JsObject =
      Json.obj(
        "id" -> o.id,
        "productid" -> o.productid,
        "startdate" -> o.startdate,
        "enddate" -> o.enddate,
        "listprice" -> o.listprice,
        "modifieddate" -> o.modifieddate
      )
  
    override def reads(json: JsValue): JsResult[PlphRow] = {
      JsResult.fromTry(
        Try(
          PlphRow(
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