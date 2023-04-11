/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package hr
package e

import adventureworks.person.businessentity.BusinessentityId
import adventureworks.public.Flag
import java.time.LocalDate
import java.time.LocalDateTime
import java.util.UUID
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try

case class ERow(
  /** debug: {"table_catalog":"Adventureworks","table_schema":"hr","table_name":"e","column_name":"id","ordinal_position":1,"is_nullable":"YES","data_type":"integer","numeric_precision":32,"numeric_precision_radix":2,"numeric_scale":0,"udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"int4","dtd_identifier":"1","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
  id: Option[Int],
  /** Points to [[humanresources.employee.EmployeeRow.businessentityid]]
      debug: {"table_catalog":"Adventureworks","table_schema":"hr","table_name":"e","column_name":"businessentityid","ordinal_position":2,"is_nullable":"YES","data_type":"integer","numeric_precision":32,"numeric_precision_radix":2,"numeric_scale":0,"udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"int4","dtd_identifier":"2","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
  businessentityid: Option[BusinessentityId],
  /** Points to [[humanresources.employee.EmployeeRow.nationalidnumber]]
      debug: {"table_catalog":"Adventureworks","table_schema":"hr","table_name":"e","column_name":"nationalidnumber","ordinal_position":3,"is_nullable":"YES","data_type":"character varying","character_maximum_length":15,"character_octet_length":60,"udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"varchar","dtd_identifier":"3","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
  nationalidnumber: Option[String],
  /** Points to [[humanresources.employee.EmployeeRow.loginid]]
      debug: {"table_catalog":"Adventureworks","table_schema":"hr","table_name":"e","column_name":"loginid","ordinal_position":4,"is_nullable":"YES","data_type":"character varying","character_maximum_length":256,"character_octet_length":1024,"udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"varchar","dtd_identifier":"4","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
  loginid: Option[String],
  /** Points to [[humanresources.employee.EmployeeRow.jobtitle]]
      debug: {"table_catalog":"Adventureworks","table_schema":"hr","table_name":"e","column_name":"jobtitle","ordinal_position":5,"is_nullable":"YES","data_type":"character varying","character_maximum_length":50,"character_octet_length":200,"udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"varchar","dtd_identifier":"5","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
  jobtitle: Option[String],
  /** Points to [[humanresources.employee.EmployeeRow.birthdate]]
      debug: {"table_catalog":"Adventureworks","table_schema":"hr","table_name":"e","column_name":"birthdate","ordinal_position":6,"is_nullable":"YES","data_type":"date","datetime_precision":0,"udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"date","dtd_identifier":"6","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
  birthdate: Option[LocalDate],
  /** Points to [[humanresources.employee.EmployeeRow.maritalstatus]]
      debug: {"table_catalog":"Adventureworks","table_schema":"hr","table_name":"e","column_name":"maritalstatus","ordinal_position":7,"is_nullable":"YES","data_type":"character","character_maximum_length":1,"character_octet_length":4,"udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"bpchar","dtd_identifier":"7","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
  maritalstatus: Option[/* bpchar */ String],
  /** Points to [[humanresources.employee.EmployeeRow.gender]]
      debug: {"table_catalog":"Adventureworks","table_schema":"hr","table_name":"e","column_name":"gender","ordinal_position":8,"is_nullable":"YES","data_type":"character","character_maximum_length":1,"character_octet_length":4,"udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"bpchar","dtd_identifier":"8","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
  gender: Option[/* bpchar */ String],
  /** Points to [[humanresources.employee.EmployeeRow.hiredate]]
      debug: {"table_catalog":"Adventureworks","table_schema":"hr","table_name":"e","column_name":"hiredate","ordinal_position":9,"is_nullable":"YES","data_type":"date","datetime_precision":0,"udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"date","dtd_identifier":"9","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
  hiredate: Option[LocalDate],
  /** Points to [[humanresources.employee.EmployeeRow.salariedflag]]
      debug: {"table_catalog":"Adventureworks","table_schema":"hr","table_name":"e","column_name":"salariedflag","ordinal_position":10,"is_nullable":"NO","data_type":"boolean","domain_catalog":"Adventureworks","domain_schema":"public","domain_name":"Flag","udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"bool","dtd_identifier":"10","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
  salariedflag: Flag,
  /** Points to [[humanresources.employee.EmployeeRow.vacationhours]]
      debug: {"table_catalog":"Adventureworks","table_schema":"hr","table_name":"e","column_name":"vacationhours","ordinal_position":11,"is_nullable":"YES","data_type":"smallint","numeric_precision":16,"numeric_precision_radix":2,"numeric_scale":0,"udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"int2","dtd_identifier":"11","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
  vacationhours: Option[Int],
  /** Points to [[humanresources.employee.EmployeeRow.sickleavehours]]
      debug: {"table_catalog":"Adventureworks","table_schema":"hr","table_name":"e","column_name":"sickleavehours","ordinal_position":12,"is_nullable":"YES","data_type":"smallint","numeric_precision":16,"numeric_precision_radix":2,"numeric_scale":0,"udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"int2","dtd_identifier":"12","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
  sickleavehours: Option[Int],
  /** Points to [[humanresources.employee.EmployeeRow.currentflag]]
      debug: {"table_catalog":"Adventureworks","table_schema":"hr","table_name":"e","column_name":"currentflag","ordinal_position":13,"is_nullable":"NO","data_type":"boolean","domain_catalog":"Adventureworks","domain_schema":"public","domain_name":"Flag","udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"bool","dtd_identifier":"13","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
  currentflag: Flag,
  /** Points to [[humanresources.employee.EmployeeRow.rowguid]]
      debug: {"table_catalog":"Adventureworks","table_schema":"hr","table_name":"e","column_name":"rowguid","ordinal_position":14,"is_nullable":"YES","data_type":"uuid","udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"uuid","dtd_identifier":"14","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
  rowguid: Option[UUID],
  /** Points to [[humanresources.employee.EmployeeRow.modifieddate]]
      debug: {"table_catalog":"Adventureworks","table_schema":"hr","table_name":"e","column_name":"modifieddate","ordinal_position":15,"is_nullable":"YES","data_type":"timestamp without time zone","datetime_precision":6,"udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"timestamp","dtd_identifier":"15","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
  modifieddate: Option[LocalDateTime],
  /** Points to [[humanresources.employee.EmployeeRow.organizationnode]]
      debug: {"table_catalog":"Adventureworks","table_schema":"hr","table_name":"e","column_name":"organizationnode","ordinal_position":16,"is_nullable":"YES","data_type":"character varying","character_octet_length":1073741824,"udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"varchar","dtd_identifier":"16","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
  organizationnode: Option[String]
)

object ERow {
  implicit val oFormat: OFormat[ERow] = new OFormat[ERow]{
    override def writes(o: ERow): JsObject =
      Json.obj(
        "id" -> o.id,
        "businessentityid" -> o.businessentityid,
        "nationalidnumber" -> o.nationalidnumber,
        "loginid" -> o.loginid,
        "jobtitle" -> o.jobtitle,
        "birthdate" -> o.birthdate,
        "maritalstatus" -> o.maritalstatus,
        "gender" -> o.gender,
        "hiredate" -> o.hiredate,
        "salariedflag" -> o.salariedflag,
        "vacationhours" -> o.vacationhours,
        "sickleavehours" -> o.sickleavehours,
        "currentflag" -> o.currentflag,
        "rowguid" -> o.rowguid,
        "modifieddate" -> o.modifieddate,
        "organizationnode" -> o.organizationnode
      )
  
    override def reads(json: JsValue): JsResult[ERow] = {
      JsResult.fromTry(
        Try(
          ERow(
            id = json.\("id").toOption.map(_.as[Int]),
            businessentityid = json.\("businessentityid").toOption.map(_.as[BusinessentityId]),
            nationalidnumber = json.\("nationalidnumber").toOption.map(_.as[String]),
            loginid = json.\("loginid").toOption.map(_.as[String]),
            jobtitle = json.\("jobtitle").toOption.map(_.as[String]),
            birthdate = json.\("birthdate").toOption.map(_.as[LocalDate]),
            maritalstatus = json.\("maritalstatus").toOption.map(_.as[/* bpchar */ String]),
            gender = json.\("gender").toOption.map(_.as[/* bpchar */ String]),
            hiredate = json.\("hiredate").toOption.map(_.as[LocalDate]),
            salariedflag = json.\("salariedflag").as[Flag],
            vacationhours = json.\("vacationhours").toOption.map(_.as[Int]),
            sickleavehours = json.\("sickleavehours").toOption.map(_.as[Int]),
            currentflag = json.\("currentflag").as[Flag],
            rowguid = json.\("rowguid").toOption.map(_.as[UUID]),
            modifieddate = json.\("modifieddate").toOption.map(_.as[LocalDateTime]),
            organizationnode = json.\("organizationnode").toOption.map(_.as[String])
          )
        )
      )
    }
  }
}