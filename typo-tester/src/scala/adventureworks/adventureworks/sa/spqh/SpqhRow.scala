/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sa
package spqh

import adventureworks.person.businessentity.BusinessentityId
import java.time.LocalDateTime
import java.util.UUID
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try

case class SpqhRow(
  /** debug: {"table_catalog":"Adventureworks","table_schema":"sa","table_name":"spqh","column_name":"id","ordinal_position":1,"is_nullable":"YES","data_type":"integer","numeric_precision":32,"numeric_precision_radix":2,"numeric_scale":0,"udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"int4","dtd_identifier":"1","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
  id: Option[Int],
  /** Points to [[sales.salespersonquotahistory.SalespersonquotahistoryRow.businessentityid]]
      debug: {"table_catalog":"Adventureworks","table_schema":"sa","table_name":"spqh","column_name":"businessentityid","ordinal_position":2,"is_nullable":"YES","data_type":"integer","numeric_precision":32,"numeric_precision_radix":2,"numeric_scale":0,"udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"int4","dtd_identifier":"2","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
  businessentityid: Option[BusinessentityId],
  /** Points to [[sales.salespersonquotahistory.SalespersonquotahistoryRow.quotadate]]
      debug: {"table_catalog":"Adventureworks","table_schema":"sa","table_name":"spqh","column_name":"quotadate","ordinal_position":3,"is_nullable":"YES","data_type":"timestamp without time zone","datetime_precision":6,"udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"timestamp","dtd_identifier":"3","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
  quotadate: Option[LocalDateTime],
  /** Points to [[sales.salespersonquotahistory.SalespersonquotahistoryRow.salesquota]]
      debug: {"table_catalog":"Adventureworks","table_schema":"sa","table_name":"spqh","column_name":"salesquota","ordinal_position":4,"is_nullable":"YES","data_type":"numeric","numeric_precision_radix":10,"udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"numeric","dtd_identifier":"4","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
  salesquota: Option[BigDecimal],
  /** Points to [[sales.salespersonquotahistory.SalespersonquotahistoryRow.rowguid]]
      debug: {"table_catalog":"Adventureworks","table_schema":"sa","table_name":"spqh","column_name":"rowguid","ordinal_position":5,"is_nullable":"YES","data_type":"uuid","udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"uuid","dtd_identifier":"5","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
  rowguid: Option[UUID],
  /** Points to [[sales.salespersonquotahistory.SalespersonquotahistoryRow.modifieddate]]
      debug: {"table_catalog":"Adventureworks","table_schema":"sa","table_name":"spqh","column_name":"modifieddate","ordinal_position":6,"is_nullable":"YES","data_type":"timestamp without time zone","datetime_precision":6,"udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"timestamp","dtd_identifier":"6","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
  modifieddate: Option[LocalDateTime]
)

object SpqhRow {
  implicit val oFormat: OFormat[SpqhRow] = new OFormat[SpqhRow]{
    override def writes(o: SpqhRow): JsObject =
      Json.obj(
        "id" -> o.id,
        "businessentityid" -> o.businessentityid,
        "quotadate" -> o.quotadate,
        "salesquota" -> o.salesquota,
        "rowguid" -> o.rowguid,
        "modifieddate" -> o.modifieddate
      )
  
    override def reads(json: JsValue): JsResult[SpqhRow] = {
      JsResult.fromTry(
        Try(
          SpqhRow(
            id = json.\("id").toOption.map(_.as[Int]),
            businessentityid = json.\("businessentityid").toOption.map(_.as[BusinessentityId]),
            quotadate = json.\("quotadate").toOption.map(_.as[LocalDateTime]),
            salesquota = json.\("salesquota").toOption.map(_.as[BigDecimal]),
            rowguid = json.\("rowguid").toOption.map(_.as[UUID]),
            modifieddate = json.\("modifieddate").toOption.map(_.as[LocalDateTime])
          )
        )
      )
    }
  }
}