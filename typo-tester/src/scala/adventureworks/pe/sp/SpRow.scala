/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pe
package sp

import adventureworks.person.countryregion.CountryregionId
import adventureworks.person.stateprovince.StateprovinceId
import adventureworks.public.Flag
import adventureworks.public.Name
import adventureworks.sales.salesterritory.SalesterritoryId
import java.time.LocalDateTime
import java.util.UUID
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try

case class SpRow(
  /** debug: {"table_catalog":"Adventureworks","table_schema":"pe","table_name":"sp","column_name":"id","ordinal_position":1,"is_nullable":"YES","data_type":"integer","numeric_precision":32,"numeric_precision_radix":2,"numeric_scale":0,"udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"int4","dtd_identifier":"1","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
  id: Option[Int],
  /** Points to [[person.stateprovince.StateprovinceRow.stateprovinceid]]
      debug: {"table_catalog":"Adventureworks","table_schema":"pe","table_name":"sp","column_name":"stateprovinceid","ordinal_position":2,"is_nullable":"YES","data_type":"integer","numeric_precision":32,"numeric_precision_radix":2,"numeric_scale":0,"udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"int4","dtd_identifier":"2","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
  stateprovinceid: Option[StateprovinceId],
  /** Points to [[person.stateprovince.StateprovinceRow.stateprovincecode]]
      debug: {"table_catalog":"Adventureworks","table_schema":"pe","table_name":"sp","column_name":"stateprovincecode","ordinal_position":3,"is_nullable":"YES","data_type":"character","character_maximum_length":3,"character_octet_length":12,"udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"bpchar","dtd_identifier":"3","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
  stateprovincecode: Option[/* bpchar */ String],
  /** Points to [[person.stateprovince.StateprovinceRow.countryregioncode]]
      debug: {"table_catalog":"Adventureworks","table_schema":"pe","table_name":"sp","column_name":"countryregioncode","ordinal_position":4,"is_nullable":"YES","data_type":"character varying","character_maximum_length":3,"character_octet_length":12,"udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"varchar","dtd_identifier":"4","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
  countryregioncode: Option[CountryregionId],
  /** Points to [[person.stateprovince.StateprovinceRow.isonlystateprovinceflag]]
      debug: {"table_catalog":"Adventureworks","table_schema":"pe","table_name":"sp","column_name":"isonlystateprovinceflag","ordinal_position":5,"is_nullable":"NO","data_type":"boolean","domain_catalog":"Adventureworks","domain_schema":"public","domain_name":"Flag","udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"bool","dtd_identifier":"5","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
  isonlystateprovinceflag: Flag,
  /** Points to [[person.stateprovince.StateprovinceRow.name]]
      debug: {"table_catalog":"Adventureworks","table_schema":"pe","table_name":"sp","column_name":"name","ordinal_position":6,"is_nullable":"YES","data_type":"character varying","character_maximum_length":50,"character_octet_length":200,"domain_catalog":"Adventureworks","domain_schema":"public","domain_name":"Name","udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"varchar","dtd_identifier":"6","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
  name: Option[Name],
  /** Points to [[person.stateprovince.StateprovinceRow.territoryid]]
      debug: {"table_catalog":"Adventureworks","table_schema":"pe","table_name":"sp","column_name":"territoryid","ordinal_position":7,"is_nullable":"YES","data_type":"integer","numeric_precision":32,"numeric_precision_radix":2,"numeric_scale":0,"udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"int4","dtd_identifier":"7","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
  territoryid: Option[SalesterritoryId],
  /** Points to [[person.stateprovince.StateprovinceRow.rowguid]]
      debug: {"table_catalog":"Adventureworks","table_schema":"pe","table_name":"sp","column_name":"rowguid","ordinal_position":8,"is_nullable":"YES","data_type":"uuid","udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"uuid","dtd_identifier":"8","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
  rowguid: Option[UUID],
  /** Points to [[person.stateprovince.StateprovinceRow.modifieddate]]
      debug: {"table_catalog":"Adventureworks","table_schema":"pe","table_name":"sp","column_name":"modifieddate","ordinal_position":9,"is_nullable":"YES","data_type":"timestamp without time zone","datetime_precision":6,"udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"timestamp","dtd_identifier":"9","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
  modifieddate: Option[LocalDateTime]
)

object SpRow {
  implicit val oFormat: OFormat[SpRow] = new OFormat[SpRow]{
    override def writes(o: SpRow): JsObject =
      Json.obj(
        "id" -> o.id,
        "stateprovinceid" -> o.stateprovinceid,
        "stateprovincecode" -> o.stateprovincecode,
        "countryregioncode" -> o.countryregioncode,
        "isonlystateprovinceflag" -> o.isonlystateprovinceflag,
        "name" -> o.name,
        "territoryid" -> o.territoryid,
        "rowguid" -> o.rowguid,
        "modifieddate" -> o.modifieddate
      )
  
    override def reads(json: JsValue): JsResult[SpRow] = {
      JsResult.fromTry(
        Try(
          SpRow(
            id = json.\("id").toOption.map(_.as[Int]),
            stateprovinceid = json.\("stateprovinceid").toOption.map(_.as[StateprovinceId]),
            stateprovincecode = json.\("stateprovincecode").toOption.map(_.as[/* bpchar */ String]),
            countryregioncode = json.\("countryregioncode").toOption.map(_.as[CountryregionId]),
            isonlystateprovinceflag = json.\("isonlystateprovinceflag").as[Flag],
            name = json.\("name").toOption.map(_.as[Name]),
            territoryid = json.\("territoryid").toOption.map(_.as[SalesterritoryId]),
            rowguid = json.\("rowguid").toOption.map(_.as[UUID]),
            modifieddate = json.\("modifieddate").toOption.map(_.as[LocalDateTime])
          )
        )
      )
    }
  }
}