/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pr
package p

import adventureworks.production.product.ProductId
import adventureworks.production.productmodel.ProductmodelId
import adventureworks.production.productsubcategory.ProductsubcategoryId
import adventureworks.production.unitmeasure.UnitmeasureId
import adventureworks.public.Flag
import adventureworks.public.Name
import java.time.LocalDateTime
import java.util.UUID
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try

case class PRow(
  /** debug: {"table_catalog":"Adventureworks","table_schema":"pr","table_name":"p","column_name":"id","ordinal_position":1,"is_nullable":"YES","data_type":"integer","numeric_precision":32,"numeric_precision_radix":2,"numeric_scale":0,"udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"int4","dtd_identifier":"1","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
  id: Option[Int],
  /** Points to [[production.product.ProductRow.productid]]
      debug: {"table_catalog":"Adventureworks","table_schema":"pr","table_name":"p","column_name":"productid","ordinal_position":2,"is_nullable":"YES","data_type":"integer","numeric_precision":32,"numeric_precision_radix":2,"numeric_scale":0,"udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"int4","dtd_identifier":"2","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
  productid: Option[ProductId],
  /** Points to [[production.product.ProductRow.name]]
      debug: {"table_catalog":"Adventureworks","table_schema":"pr","table_name":"p","column_name":"name","ordinal_position":3,"is_nullable":"YES","data_type":"character varying","character_maximum_length":50,"character_octet_length":200,"domain_catalog":"Adventureworks","domain_schema":"public","domain_name":"Name","udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"varchar","dtd_identifier":"3","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
  name: Option[Name],
  /** Points to [[production.product.ProductRow.productnumber]]
      debug: {"table_catalog":"Adventureworks","table_schema":"pr","table_name":"p","column_name":"productnumber","ordinal_position":4,"is_nullable":"YES","data_type":"character varying","character_maximum_length":25,"character_octet_length":100,"udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"varchar","dtd_identifier":"4","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
  productnumber: Option[String],
  /** Points to [[production.product.ProductRow.makeflag]]
      debug: {"table_catalog":"Adventureworks","table_schema":"pr","table_name":"p","column_name":"makeflag","ordinal_position":5,"is_nullable":"NO","data_type":"boolean","domain_catalog":"Adventureworks","domain_schema":"public","domain_name":"Flag","udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"bool","dtd_identifier":"5","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
  makeflag: Flag,
  /** Points to [[production.product.ProductRow.finishedgoodsflag]]
      debug: {"table_catalog":"Adventureworks","table_schema":"pr","table_name":"p","column_name":"finishedgoodsflag","ordinal_position":6,"is_nullable":"NO","data_type":"boolean","domain_catalog":"Adventureworks","domain_schema":"public","domain_name":"Flag","udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"bool","dtd_identifier":"6","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
  finishedgoodsflag: Flag,
  /** Points to [[production.product.ProductRow.color]]
      debug: {"table_catalog":"Adventureworks","table_schema":"pr","table_name":"p","column_name":"color","ordinal_position":7,"is_nullable":"YES","data_type":"character varying","character_maximum_length":15,"character_octet_length":60,"udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"varchar","dtd_identifier":"7","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
  color: Option[String],
  /** Points to [[production.product.ProductRow.safetystocklevel]]
      debug: {"table_catalog":"Adventureworks","table_schema":"pr","table_name":"p","column_name":"safetystocklevel","ordinal_position":8,"is_nullable":"YES","data_type":"smallint","numeric_precision":16,"numeric_precision_radix":2,"numeric_scale":0,"udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"int2","dtd_identifier":"8","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
  safetystocklevel: Option[Int],
  /** Points to [[production.product.ProductRow.reorderpoint]]
      debug: {"table_catalog":"Adventureworks","table_schema":"pr","table_name":"p","column_name":"reorderpoint","ordinal_position":9,"is_nullable":"YES","data_type":"smallint","numeric_precision":16,"numeric_precision_radix":2,"numeric_scale":0,"udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"int2","dtd_identifier":"9","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
  reorderpoint: Option[Int],
  /** Points to [[production.product.ProductRow.standardcost]]
      debug: {"table_catalog":"Adventureworks","table_schema":"pr","table_name":"p","column_name":"standardcost","ordinal_position":10,"is_nullable":"YES","data_type":"numeric","numeric_precision_radix":10,"udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"numeric","dtd_identifier":"10","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
  standardcost: Option[BigDecimal],
  /** Points to [[production.product.ProductRow.listprice]]
      debug: {"table_catalog":"Adventureworks","table_schema":"pr","table_name":"p","column_name":"listprice","ordinal_position":11,"is_nullable":"YES","data_type":"numeric","numeric_precision_radix":10,"udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"numeric","dtd_identifier":"11","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
  listprice: Option[BigDecimal],
  /** Points to [[production.product.ProductRow.size]]
      debug: {"table_catalog":"Adventureworks","table_schema":"pr","table_name":"p","column_name":"size","ordinal_position":12,"is_nullable":"YES","data_type":"character varying","character_maximum_length":5,"character_octet_length":20,"udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"varchar","dtd_identifier":"12","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
  size: Option[String],
  /** Points to [[production.product.ProductRow.sizeunitmeasurecode]]
      debug: {"table_catalog":"Adventureworks","table_schema":"pr","table_name":"p","column_name":"sizeunitmeasurecode","ordinal_position":13,"is_nullable":"YES","data_type":"character","character_maximum_length":3,"character_octet_length":12,"udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"bpchar","dtd_identifier":"13","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
  sizeunitmeasurecode: Option[UnitmeasureId],
  /** Points to [[production.product.ProductRow.weightunitmeasurecode]]
      debug: {"table_catalog":"Adventureworks","table_schema":"pr","table_name":"p","column_name":"weightunitmeasurecode","ordinal_position":14,"is_nullable":"YES","data_type":"character","character_maximum_length":3,"character_octet_length":12,"udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"bpchar","dtd_identifier":"14","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
  weightunitmeasurecode: Option[UnitmeasureId],
  /** Points to [[production.product.ProductRow.weight]]
      debug: {"table_catalog":"Adventureworks","table_schema":"pr","table_name":"p","column_name":"weight","ordinal_position":15,"is_nullable":"YES","data_type":"numeric","numeric_precision":8,"numeric_precision_radix":10,"numeric_scale":2,"udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"numeric","dtd_identifier":"15","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
  weight: Option[BigDecimal],
  /** Points to [[production.product.ProductRow.daystomanufacture]]
      debug: {"table_catalog":"Adventureworks","table_schema":"pr","table_name":"p","column_name":"daystomanufacture","ordinal_position":16,"is_nullable":"YES","data_type":"integer","numeric_precision":32,"numeric_precision_radix":2,"numeric_scale":0,"udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"int4","dtd_identifier":"16","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
  daystomanufacture: Option[Int],
  /** Points to [[production.product.ProductRow.productline]]
      debug: {"table_catalog":"Adventureworks","table_schema":"pr","table_name":"p","column_name":"productline","ordinal_position":17,"is_nullable":"YES","data_type":"character","character_maximum_length":2,"character_octet_length":8,"udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"bpchar","dtd_identifier":"17","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
  productline: Option[/* bpchar */ String],
  /** Points to [[production.product.ProductRow.class]]
      debug: {"table_catalog":"Adventureworks","table_schema":"pr","table_name":"p","column_name":"class","ordinal_position":18,"is_nullable":"YES","data_type":"character","character_maximum_length":2,"character_octet_length":8,"udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"bpchar","dtd_identifier":"18","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
  `class`: Option[/* bpchar */ String],
  /** Points to [[production.product.ProductRow.style]]
      debug: {"table_catalog":"Adventureworks","table_schema":"pr","table_name":"p","column_name":"style","ordinal_position":19,"is_nullable":"YES","data_type":"character","character_maximum_length":2,"character_octet_length":8,"udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"bpchar","dtd_identifier":"19","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
  style: Option[/* bpchar */ String],
  /** Points to [[production.product.ProductRow.productsubcategoryid]]
      debug: {"table_catalog":"Adventureworks","table_schema":"pr","table_name":"p","column_name":"productsubcategoryid","ordinal_position":20,"is_nullable":"YES","data_type":"integer","numeric_precision":32,"numeric_precision_radix":2,"numeric_scale":0,"udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"int4","dtd_identifier":"20","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
  productsubcategoryid: Option[ProductsubcategoryId],
  /** Points to [[production.product.ProductRow.productmodelid]]
      debug: {"table_catalog":"Adventureworks","table_schema":"pr","table_name":"p","column_name":"productmodelid","ordinal_position":21,"is_nullable":"YES","data_type":"integer","numeric_precision":32,"numeric_precision_radix":2,"numeric_scale":0,"udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"int4","dtd_identifier":"21","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
  productmodelid: Option[ProductmodelId],
  /** Points to [[production.product.ProductRow.sellstartdate]]
      debug: {"table_catalog":"Adventureworks","table_schema":"pr","table_name":"p","column_name":"sellstartdate","ordinal_position":22,"is_nullable":"YES","data_type":"timestamp without time zone","datetime_precision":6,"udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"timestamp","dtd_identifier":"22","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
  sellstartdate: Option[LocalDateTime],
  /** Points to [[production.product.ProductRow.sellenddate]]
      debug: {"table_catalog":"Adventureworks","table_schema":"pr","table_name":"p","column_name":"sellenddate","ordinal_position":23,"is_nullable":"YES","data_type":"timestamp without time zone","datetime_precision":6,"udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"timestamp","dtd_identifier":"23","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
  sellenddate: Option[LocalDateTime],
  /** Points to [[production.product.ProductRow.discontinueddate]]
      debug: {"table_catalog":"Adventureworks","table_schema":"pr","table_name":"p","column_name":"discontinueddate","ordinal_position":24,"is_nullable":"YES","data_type":"timestamp without time zone","datetime_precision":6,"udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"timestamp","dtd_identifier":"24","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
  discontinueddate: Option[LocalDateTime],
  /** Points to [[production.product.ProductRow.rowguid]]
      debug: {"table_catalog":"Adventureworks","table_schema":"pr","table_name":"p","column_name":"rowguid","ordinal_position":25,"is_nullable":"YES","data_type":"uuid","udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"uuid","dtd_identifier":"25","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
  rowguid: Option[UUID],
  /** Points to [[production.product.ProductRow.modifieddate]]
      debug: {"table_catalog":"Adventureworks","table_schema":"pr","table_name":"p","column_name":"modifieddate","ordinal_position":26,"is_nullable":"YES","data_type":"timestamp without time zone","datetime_precision":6,"udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"timestamp","dtd_identifier":"26","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
  modifieddate: Option[LocalDateTime]
)

object PRow {
  implicit val oFormat: OFormat[PRow] = new OFormat[PRow]{
    override def writes(o: PRow): JsObject =
      Json.obj(
        "id" -> o.id,
        "productid" -> o.productid,
        "name" -> o.name,
        "productnumber" -> o.productnumber,
        "makeflag" -> o.makeflag,
        "finishedgoodsflag" -> o.finishedgoodsflag,
        "color" -> o.color,
        "safetystocklevel" -> o.safetystocklevel,
        "reorderpoint" -> o.reorderpoint,
        "standardcost" -> o.standardcost,
        "listprice" -> o.listprice,
        "size" -> o.size,
        "sizeunitmeasurecode" -> o.sizeunitmeasurecode,
        "weightunitmeasurecode" -> o.weightunitmeasurecode,
        "weight" -> o.weight,
        "daystomanufacture" -> o.daystomanufacture,
        "productline" -> o.productline,
        "class" -> o.`class`,
        "style" -> o.style,
        "productsubcategoryid" -> o.productsubcategoryid,
        "productmodelid" -> o.productmodelid,
        "sellstartdate" -> o.sellstartdate,
        "sellenddate" -> o.sellenddate,
        "discontinueddate" -> o.discontinueddate,
        "rowguid" -> o.rowguid,
        "modifieddate" -> o.modifieddate
      )
  
    override def reads(json: JsValue): JsResult[PRow] = {
      JsResult.fromTry(
        Try(
          PRow(
            id = json.\("id").toOption.map(_.as[Int]),
            productid = json.\("productid").toOption.map(_.as[ProductId]),
            name = json.\("name").toOption.map(_.as[Name]),
            productnumber = json.\("productnumber").toOption.map(_.as[String]),
            makeflag = json.\("makeflag").as[Flag],
            finishedgoodsflag = json.\("finishedgoodsflag").as[Flag],
            color = json.\("color").toOption.map(_.as[String]),
            safetystocklevel = json.\("safetystocklevel").toOption.map(_.as[Int]),
            reorderpoint = json.\("reorderpoint").toOption.map(_.as[Int]),
            standardcost = json.\("standardcost").toOption.map(_.as[BigDecimal]),
            listprice = json.\("listprice").toOption.map(_.as[BigDecimal]),
            size = json.\("size").toOption.map(_.as[String]),
            sizeunitmeasurecode = json.\("sizeunitmeasurecode").toOption.map(_.as[UnitmeasureId]),
            weightunitmeasurecode = json.\("weightunitmeasurecode").toOption.map(_.as[UnitmeasureId]),
            weight = json.\("weight").toOption.map(_.as[BigDecimal]),
            daystomanufacture = json.\("daystomanufacture").toOption.map(_.as[Int]),
            productline = json.\("productline").toOption.map(_.as[/* bpchar */ String]),
            `class` = json.\("class").toOption.map(_.as[/* bpchar */ String]),
            style = json.\("style").toOption.map(_.as[/* bpchar */ String]),
            productsubcategoryid = json.\("productsubcategoryid").toOption.map(_.as[ProductsubcategoryId]),
            productmodelid = json.\("productmodelid").toOption.map(_.as[ProductmodelId]),
            sellstartdate = json.\("sellstartdate").toOption.map(_.as[LocalDateTime]),
            sellenddate = json.\("sellenddate").toOption.map(_.as[LocalDateTime]),
            discontinueddate = json.\("discontinueddate").toOption.map(_.as[LocalDateTime]),
            rowguid = json.\("rowguid").toOption.map(_.as[UUID]),
            modifieddate = json.\("modifieddate").toOption.map(_.as[LocalDateTime])
          )
        )
      )
    }
  }
}