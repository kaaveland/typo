/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package salesperson

import adventureworks.person.businessentity.BusinessentityId
import adventureworks.sales.salesterritory.SalesterritoryId
import java.time.LocalDateTime
import java.util.UUID
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try

case class SalespersonRow(
  /** Primary key for SalesPerson records. Foreign key to Employee.BusinessEntityID
      Points to [[humanresources.employee.EmployeeRow.businessentityid]]
      debug: {"table_catalog":"Adventureworks","table_schema":"sales","table_name":"salesperson","column_name":"businessentityid","ordinal_position":1,"is_nullable":"NO","data_type":"integer","numeric_precision":32,"numeric_precision_radix":2,"numeric_scale":0,"udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"int4","dtd_identifier":"1","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
  businessentityid: BusinessentityId,
  /** Territory currently assigned to. Foreign key to SalesTerritory.SalesTerritoryID.
      Points to [[salesterritory.SalesterritoryRow.territoryid]]
      debug: {"table_catalog":"Adventureworks","table_schema":"sales","table_name":"salesperson","column_name":"territoryid","ordinal_position":2,"is_nullable":"YES","data_type":"integer","numeric_precision":32,"numeric_precision_radix":2,"numeric_scale":0,"udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"int4","dtd_identifier":"2","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
  territoryid: Option[SalesterritoryId],
  /** Projected yearly sales.
      debug: {"table_catalog":"Adventureworks","table_schema":"sales","table_name":"salesperson","column_name":"salesquota","ordinal_position":3,"is_nullable":"YES","data_type":"numeric","numeric_precision_radix":10,"udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"numeric","dtd_identifier":"3","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
  salesquota: Option[BigDecimal],
  /** Bonus due if quota is met.
      debug: {"table_catalog":"Adventureworks","table_schema":"sales","table_name":"salesperson","column_name":"bonus","ordinal_position":4,"column_default":"0.00","is_nullable":"NO","data_type":"numeric","numeric_precision_radix":10,"udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"numeric","dtd_identifier":"4","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
  bonus: BigDecimal,
  /** Commision percent received per sale.
      debug: {"table_catalog":"Adventureworks","table_schema":"sales","table_name":"salesperson","column_name":"commissionpct","ordinal_position":5,"column_default":"0.00","is_nullable":"NO","data_type":"numeric","numeric_precision_radix":10,"udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"numeric","dtd_identifier":"5","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
  commissionpct: BigDecimal,
  /** Sales total year to date.
      debug: {"table_catalog":"Adventureworks","table_schema":"sales","table_name":"salesperson","column_name":"salesytd","ordinal_position":6,"column_default":"0.00","is_nullable":"NO","data_type":"numeric","numeric_precision_radix":10,"udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"numeric","dtd_identifier":"6","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
  salesytd: BigDecimal,
  /** Sales total of previous year.
      debug: {"table_catalog":"Adventureworks","table_schema":"sales","table_name":"salesperson","column_name":"saleslastyear","ordinal_position":7,"column_default":"0.00","is_nullable":"NO","data_type":"numeric","numeric_precision_radix":10,"udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"numeric","dtd_identifier":"7","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
  saleslastyear: BigDecimal,
  /** debug: {"table_catalog":"Adventureworks","table_schema":"sales","table_name":"salesperson","column_name":"rowguid","ordinal_position":8,"column_default":"uuid_generate_v1()","is_nullable":"NO","data_type":"uuid","udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"uuid","dtd_identifier":"8","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
  rowguid: UUID,
  /** debug: {"table_catalog":"Adventureworks","table_schema":"sales","table_name":"salesperson","column_name":"modifieddate","ordinal_position":9,"column_default":"now()","is_nullable":"NO","data_type":"timestamp without time zone","datetime_precision":6,"udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"timestamp","dtd_identifier":"9","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
  modifieddate: LocalDateTime
)

object SalespersonRow {
  implicit val oFormat: OFormat[SalespersonRow] = new OFormat[SalespersonRow]{
    override def writes(o: SalespersonRow): JsObject =
      Json.obj(
        "businessentityid" -> o.businessentityid,
        "territoryid" -> o.territoryid,
        "salesquota" -> o.salesquota,
        "bonus" -> o.bonus,
        "commissionpct" -> o.commissionpct,
        "salesytd" -> o.salesytd,
        "saleslastyear" -> o.saleslastyear,
        "rowguid" -> o.rowguid,
        "modifieddate" -> o.modifieddate
      )
  
    override def reads(json: JsValue): JsResult[SalespersonRow] = {
      JsResult.fromTry(
        Try(
          SalespersonRow(
            businessentityid = json.\("businessentityid").as[BusinessentityId],
            territoryid = json.\("territoryid").toOption.map(_.as[SalesterritoryId]),
            salesquota = json.\("salesquota").toOption.map(_.as[BigDecimal]),
            bonus = json.\("bonus").as[BigDecimal],
            commissionpct = json.\("commissionpct").as[BigDecimal],
            salesytd = json.\("salesytd").as[BigDecimal],
            saleslastyear = json.\("saleslastyear").as[BigDecimal],
            rowguid = json.\("rowguid").as[UUID],
            modifieddate = json.\("modifieddate").as[LocalDateTime]
          )
        )
      )
    }
  }
}