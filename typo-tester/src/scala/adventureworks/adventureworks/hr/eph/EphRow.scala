/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package hr
package eph

import adventureworks.person.businessentity.BusinessentityId
import java.time.LocalDateTime
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try

case class EphRow(
  /** debug: {"table_catalog":"Adventureworks","table_schema":"hr","table_name":"eph","column_name":"id","ordinal_position":1,"is_nullable":"YES","data_type":"integer","numeric_precision":32,"numeric_precision_radix":2,"numeric_scale":0,"udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"int4","dtd_identifier":"1","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
  id: Option[Int],
  /** Points to [[humanresources.employeepayhistory.EmployeepayhistoryRow.businessentityid]]
      debug: {"table_catalog":"Adventureworks","table_schema":"hr","table_name":"eph","column_name":"businessentityid","ordinal_position":2,"is_nullable":"YES","data_type":"integer","numeric_precision":32,"numeric_precision_radix":2,"numeric_scale":0,"udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"int4","dtd_identifier":"2","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
  businessentityid: Option[BusinessentityId],
  /** Points to [[humanresources.employeepayhistory.EmployeepayhistoryRow.ratechangedate]]
      debug: {"table_catalog":"Adventureworks","table_schema":"hr","table_name":"eph","column_name":"ratechangedate","ordinal_position":3,"is_nullable":"YES","data_type":"timestamp without time zone","datetime_precision":6,"udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"timestamp","dtd_identifier":"3","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
  ratechangedate: Option[LocalDateTime],
  /** Points to [[humanresources.employeepayhistory.EmployeepayhistoryRow.rate]]
      debug: {"table_catalog":"Adventureworks","table_schema":"hr","table_name":"eph","column_name":"rate","ordinal_position":4,"is_nullable":"YES","data_type":"numeric","numeric_precision_radix":10,"udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"numeric","dtd_identifier":"4","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
  rate: Option[BigDecimal],
  /** Points to [[humanresources.employeepayhistory.EmployeepayhistoryRow.payfrequency]]
      debug: {"table_catalog":"Adventureworks","table_schema":"hr","table_name":"eph","column_name":"payfrequency","ordinal_position":5,"is_nullable":"YES","data_type":"smallint","numeric_precision":16,"numeric_precision_radix":2,"numeric_scale":0,"udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"int2","dtd_identifier":"5","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
  payfrequency: Option[Int],
  /** Points to [[humanresources.employeepayhistory.EmployeepayhistoryRow.modifieddate]]
      debug: {"table_catalog":"Adventureworks","table_schema":"hr","table_name":"eph","column_name":"modifieddate","ordinal_position":6,"is_nullable":"YES","data_type":"timestamp without time zone","datetime_precision":6,"udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"timestamp","dtd_identifier":"6","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
  modifieddate: Option[LocalDateTime]
)

object EphRow {
  implicit val oFormat: OFormat[EphRow] = new OFormat[EphRow]{
    override def writes(o: EphRow): JsObject =
      Json.obj(
        "id" -> o.id,
        "businessentityid" -> o.businessentityid,
        "ratechangedate" -> o.ratechangedate,
        "rate" -> o.rate,
        "payfrequency" -> o.payfrequency,
        "modifieddate" -> o.modifieddate
      )
  
    override def reads(json: JsValue): JsResult[EphRow] = {
      JsResult.fromTry(
        Try(
          EphRow(
            id = json.\("id").toOption.map(_.as[Int]),
            businessentityid = json.\("businessentityid").toOption.map(_.as[BusinessentityId]),
            ratechangedate = json.\("ratechangedate").toOption.map(_.as[LocalDateTime]),
            rate = json.\("rate").toOption.map(_.as[BigDecimal]),
            payfrequency = json.\("payfrequency").toOption.map(_.as[Int]),
            modifieddate = json.\("modifieddate").toOption.map(_.as[LocalDateTime])
          )
        )
      )
    }
  }
}