/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package scrapreason

import adventureworks.public.NameDomain
import anorm.RowParser
import anorm.Success
import java.time.LocalDateTime
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try

case class ScrapreasonRow(
  scrapreasonid: ScrapreasonId /* {"table_catalog":"Adventureworks","table_schema":"production","table_name":"scrapreason","column_name":"scrapreasonid","ordinal_position":1,"column_default":"nextval('production.scrapreason_scrapreasonid_seq'::regclass)","is_nullable":"NO","data_type":"integer","numeric_precision":32,"numeric_precision_radix":2,"numeric_scale":0,"udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"int4","dtd_identifier":"1","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */,
  name: NameDomain /* {"table_catalog":"Adventureworks","table_schema":"production","table_name":"scrapreason","column_name":"name","ordinal_position":2,"is_nullable":"NO","data_type":"character varying","character_maximum_length":50,"character_octet_length":200,"domain_catalog":"Adventureworks","domain_schema":"public","domain_name":"Name","udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"varchar","dtd_identifier":"2","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */,
  modifieddate: LocalDateTime /* {"table_catalog":"Adventureworks","table_schema":"production","table_name":"scrapreason","column_name":"modifieddate","ordinal_position":3,"column_default":"now()","is_nullable":"NO","data_type":"timestamp without time zone","datetime_precision":6,"udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"timestamp","dtd_identifier":"3","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
)

object ScrapreasonRow {
  def rowParser(prefix: String): RowParser[ScrapreasonRow] = { row =>
    Success(
      ScrapreasonRow(
        scrapreasonid = row[ScrapreasonId](prefix + "scrapreasonid"),
        name = row[NameDomain](prefix + "name"),
        modifieddate = row[LocalDateTime](prefix + "modifieddate")
      )
    )
  }

  implicit val oFormat: OFormat[ScrapreasonRow] = new OFormat[ScrapreasonRow]{
    override def writes(o: ScrapreasonRow): JsObject =
      Json.obj(
        "scrapreasonid" -> o.scrapreasonid,
        "name" -> o.name,
        "modifieddate" -> o.modifieddate
      )
  
    override def reads(json: JsValue): JsResult[ScrapreasonRow] = {
      JsResult.fromTry(
        Try(
          ScrapreasonRow(
            scrapreasonid = json.\("scrapreasonid").as[ScrapreasonId],
            name = json.\("name").as[NameDomain],
            modifieddate = json.\("modifieddate").as[LocalDateTime]
          )
        )
      )
    }
  }
}
