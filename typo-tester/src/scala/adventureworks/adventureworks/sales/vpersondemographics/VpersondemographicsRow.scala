/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package vpersondemographics

import adventureworks.person.businessentity.BusinessentityId
import java.time.LocalDate
import org.postgresql.util.PGmoney
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try

case class VpersondemographicsRow(
  /** Points to [[person.person.PersonRow.businessentityid]]
      debug: {"table_catalog":"Adventureworks","table_schema":"sales","table_name":"vpersondemographics","column_name":"businessentityid","ordinal_position":1,"is_nullable":"YES","data_type":"integer","numeric_precision":32,"numeric_precision_radix":2,"numeric_scale":0,"udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"int4","dtd_identifier":"1","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
  businessentityid: Option[BusinessentityId],
  /** debug: {"table_catalog":"Adventureworks","table_schema":"sales","table_name":"vpersondemographics","column_name":"totalpurchaseytd","ordinal_position":2,"is_nullable":"YES","data_type":"money","udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"money","dtd_identifier":"2","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */
  totalpurchaseytd: Option[PGmoney],
  /** debug: {"table_catalog":"Adventureworks","table_schema":"sales","table_name":"vpersondemographics","column_name":"datefirstpurchase","ordinal_position":3,"is_nullable":"YES","data_type":"date","datetime_precision":0,"udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"date","dtd_identifier":"3","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */
  datefirstpurchase: Option[LocalDate],
  /** debug: {"table_catalog":"Adventureworks","table_schema":"sales","table_name":"vpersondemographics","column_name":"birthdate","ordinal_position":4,"is_nullable":"YES","data_type":"date","datetime_precision":0,"udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"date","dtd_identifier":"4","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */
  birthdate: Option[LocalDate],
  /** debug: {"table_catalog":"Adventureworks","table_schema":"sales","table_name":"vpersondemographics","column_name":"maritalstatus","ordinal_position":5,"is_nullable":"YES","data_type":"character varying","character_maximum_length":1,"character_octet_length":4,"udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"varchar","dtd_identifier":"5","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */
  maritalstatus: Option[String],
  /** debug: {"table_catalog":"Adventureworks","table_schema":"sales","table_name":"vpersondemographics","column_name":"yearlyincome","ordinal_position":6,"is_nullable":"YES","data_type":"character varying","character_maximum_length":30,"character_octet_length":120,"udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"varchar","dtd_identifier":"6","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */
  yearlyincome: Option[String],
  /** debug: {"table_catalog":"Adventureworks","table_schema":"sales","table_name":"vpersondemographics","column_name":"gender","ordinal_position":7,"is_nullable":"YES","data_type":"character varying","character_maximum_length":1,"character_octet_length":4,"udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"varchar","dtd_identifier":"7","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */
  gender: Option[String],
  /** debug: {"table_catalog":"Adventureworks","table_schema":"sales","table_name":"vpersondemographics","column_name":"totalchildren","ordinal_position":8,"is_nullable":"YES","data_type":"integer","numeric_precision":32,"numeric_precision_radix":2,"numeric_scale":0,"udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"int4","dtd_identifier":"8","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */
  totalchildren: Option[Int],
  /** debug: {"table_catalog":"Adventureworks","table_schema":"sales","table_name":"vpersondemographics","column_name":"numberchildrenathome","ordinal_position":9,"is_nullable":"YES","data_type":"integer","numeric_precision":32,"numeric_precision_radix":2,"numeric_scale":0,"udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"int4","dtd_identifier":"9","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */
  numberchildrenathome: Option[Int],
  /** debug: {"table_catalog":"Adventureworks","table_schema":"sales","table_name":"vpersondemographics","column_name":"education","ordinal_position":10,"is_nullable":"YES","data_type":"character varying","character_maximum_length":30,"character_octet_length":120,"udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"varchar","dtd_identifier":"10","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */
  education: Option[String],
  /** debug: {"table_catalog":"Adventureworks","table_schema":"sales","table_name":"vpersondemographics","column_name":"occupation","ordinal_position":11,"is_nullable":"YES","data_type":"character varying","character_maximum_length":30,"character_octet_length":120,"udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"varchar","dtd_identifier":"11","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */
  occupation: Option[String],
  /** debug: {"table_catalog":"Adventureworks","table_schema":"sales","table_name":"vpersondemographics","column_name":"homeownerflag","ordinal_position":12,"is_nullable":"YES","data_type":"boolean","udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"bool","dtd_identifier":"12","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */
  homeownerflag: Option[Boolean],
  /** debug: {"table_catalog":"Adventureworks","table_schema":"sales","table_name":"vpersondemographics","column_name":"numbercarsowned","ordinal_position":13,"is_nullable":"YES","data_type":"integer","numeric_precision":32,"numeric_precision_radix":2,"numeric_scale":0,"udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"int4","dtd_identifier":"13","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */
  numbercarsowned: Option[Int]
)

object VpersondemographicsRow {
  implicit val oFormat: OFormat[VpersondemographicsRow] = new OFormat[VpersondemographicsRow]{
    override def writes(o: VpersondemographicsRow): JsObject =
      Json.obj(
        "businessentityid" -> o.businessentityid,
        "totalpurchaseytd" -> o.totalpurchaseytd,
        "datefirstpurchase" -> o.datefirstpurchase,
        "birthdate" -> o.birthdate,
        "maritalstatus" -> o.maritalstatus,
        "yearlyincome" -> o.yearlyincome,
        "gender" -> o.gender,
        "totalchildren" -> o.totalchildren,
        "numberchildrenathome" -> o.numberchildrenathome,
        "education" -> o.education,
        "occupation" -> o.occupation,
        "homeownerflag" -> o.homeownerflag,
        "numbercarsowned" -> o.numbercarsowned
      )
  
    override def reads(json: JsValue): JsResult[VpersondemographicsRow] = {
      JsResult.fromTry(
        Try(
          VpersondemographicsRow(
            businessentityid = json.\("businessentityid").toOption.map(_.as[BusinessentityId]),
            totalpurchaseytd = json.\("totalpurchaseytd").toOption.map(_.as[PGmoney]),
            datefirstpurchase = json.\("datefirstpurchase").toOption.map(_.as[LocalDate]),
            birthdate = json.\("birthdate").toOption.map(_.as[LocalDate]),
            maritalstatus = json.\("maritalstatus").toOption.map(_.as[String]),
            yearlyincome = json.\("yearlyincome").toOption.map(_.as[String]),
            gender = json.\("gender").toOption.map(_.as[String]),
            totalchildren = json.\("totalchildren").toOption.map(_.as[Int]),
            numberchildrenathome = json.\("numberchildrenathome").toOption.map(_.as[Int]),
            education = json.\("education").toOption.map(_.as[String]),
            occupation = json.\("occupation").toOption.map(_.as[String]),
            homeownerflag = json.\("homeownerflag").toOption.map(_.as[Boolean]),
            numbercarsowned = json.\("numbercarsowned").toOption.map(_.as[Int])
          )
        )
      )
    }
  }
}