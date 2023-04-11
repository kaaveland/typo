/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package humanresources
package employeedepartmenthistory

import adventureworks.humanresources.department.DepartmentId
import adventureworks.humanresources.shift.ShiftId
import adventureworks.person.businessentity.BusinessentityId
import java.time.LocalDate
import java.time.LocalDateTime
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try

case class EmployeedepartmenthistoryRow(
  /** Employee identification number. Foreign key to Employee.BusinessEntityID.
      Points to [[employee.EmployeeRow.businessentityid]]
      debug: {"table_catalog":"Adventureworks","table_schema":"humanresources","table_name":"employeedepartmenthistory","column_name":"businessentityid","ordinal_position":1,"is_nullable":"NO","data_type":"integer","numeric_precision":32,"numeric_precision_radix":2,"numeric_scale":0,"udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"int4","dtd_identifier":"1","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
  businessentityid: BusinessentityId,
  /** Department in which the employee worked including currently. Foreign key to Department.DepartmentID.
      Points to [[department.DepartmentRow.departmentid]]
      debug: {"table_catalog":"Adventureworks","table_schema":"humanresources","table_name":"employeedepartmenthistory","column_name":"departmentid","ordinal_position":2,"is_nullable":"NO","data_type":"smallint","numeric_precision":16,"numeric_precision_radix":2,"numeric_scale":0,"udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"int2","dtd_identifier":"2","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
  departmentid: DepartmentId,
  /** Identifies which 8-hour shift the employee works. Foreign key to Shift.Shift.ID.
      Points to [[shift.ShiftRow.shiftid]]
      debug: {"table_catalog":"Adventureworks","table_schema":"humanresources","table_name":"employeedepartmenthistory","column_name":"shiftid","ordinal_position":3,"is_nullable":"NO","data_type":"smallint","numeric_precision":16,"numeric_precision_radix":2,"numeric_scale":0,"udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"int2","dtd_identifier":"3","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
  shiftid: ShiftId,
  /** Date the employee started work in the department.
      debug: {"table_catalog":"Adventureworks","table_schema":"humanresources","table_name":"employeedepartmenthistory","column_name":"startdate","ordinal_position":4,"is_nullable":"NO","data_type":"date","datetime_precision":0,"udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"date","dtd_identifier":"4","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
  startdate: LocalDate,
  /** Date the employee left the department. NULL = Current department.
      debug: {"table_catalog":"Adventureworks","table_schema":"humanresources","table_name":"employeedepartmenthistory","column_name":"enddate","ordinal_position":5,"is_nullable":"YES","data_type":"date","datetime_precision":0,"udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"date","dtd_identifier":"5","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
  enddate: Option[LocalDate],
  /** debug: {"table_catalog":"Adventureworks","table_schema":"humanresources","table_name":"employeedepartmenthistory","column_name":"modifieddate","ordinal_position":6,"column_default":"now()","is_nullable":"NO","data_type":"timestamp without time zone","datetime_precision":6,"udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"timestamp","dtd_identifier":"6","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
  modifieddate: LocalDateTime
){
   val compositeId: EmployeedepartmenthistoryId = EmployeedepartmenthistoryId(businessentityid, startdate, departmentid, shiftid)
 }

object EmployeedepartmenthistoryRow {
  implicit val oFormat: OFormat[EmployeedepartmenthistoryRow] = new OFormat[EmployeedepartmenthistoryRow]{
    override def writes(o: EmployeedepartmenthistoryRow): JsObject =
      Json.obj(
        "businessentityid" -> o.businessentityid,
        "departmentid" -> o.departmentid,
        "shiftid" -> o.shiftid,
        "startdate" -> o.startdate,
        "enddate" -> o.enddate,
        "modifieddate" -> o.modifieddate
      )
  
    override def reads(json: JsValue): JsResult[EmployeedepartmenthistoryRow] = {
      JsResult.fromTry(
        Try(
          EmployeedepartmenthistoryRow(
            businessentityid = json.\("businessentityid").as[BusinessentityId],
            departmentid = json.\("departmentid").as[DepartmentId],
            shiftid = json.\("shiftid").as[ShiftId],
            startdate = json.\("startdate").as[LocalDate],
            enddate = json.\("enddate").toOption.map(_.as[LocalDate]),
            modifieddate = json.\("modifieddate").as[LocalDateTime]
          )
        )
      )
    }
  }
}