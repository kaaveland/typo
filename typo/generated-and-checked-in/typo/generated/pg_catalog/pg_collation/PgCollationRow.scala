/**
 * File has been automatically generated by `typo` for internal use.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 *
 * (If you're developing `typo` and want to change it: run `bleep generate-sources`)
 */
package typo
package generated
package pg_catalog
package pg_collation

import anorm.RowParser
import anorm.Success
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try

case class PgCollationRow(
  oid: PgCollationId /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_collation","column_name":"oid","ordinal_position":1,"is_nullable":"NO","data_type":"oid","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"oid","dtd_identifier":"1","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */,
  collname: String /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_collation","column_name":"collname","ordinal_position":2,"is_nullable":"NO","data_type":"name","collation_catalog":"postgres","collation_schema":"pg_catalog","collation_name":"C","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"name","dtd_identifier":"2","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */,
  collnamespace: /* oid */ Long /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_collation","column_name":"collnamespace","ordinal_position":3,"is_nullable":"NO","data_type":"oid","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"oid","dtd_identifier":"3","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */,
  collowner: /* oid */ Long /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_collation","column_name":"collowner","ordinal_position":4,"is_nullable":"NO","data_type":"oid","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"oid","dtd_identifier":"4","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */,
  collprovider: String /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_collation","column_name":"collprovider","ordinal_position":5,"is_nullable":"NO","data_type":"\"char\"","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"char","dtd_identifier":"5","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */,
  collisdeterministic: Boolean /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_collation","column_name":"collisdeterministic","ordinal_position":6,"is_nullable":"NO","data_type":"boolean","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"bool","dtd_identifier":"6","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */,
  collencoding: Int /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_collation","column_name":"collencoding","ordinal_position":7,"is_nullable":"NO","data_type":"integer","numeric_precision":32,"numeric_precision_radix":2,"numeric_scale":0,"udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"int4","dtd_identifier":"7","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */,
  collcollate: String /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_collation","column_name":"collcollate","ordinal_position":8,"is_nullable":"NO","data_type":"name","collation_catalog":"postgres","collation_schema":"pg_catalog","collation_name":"C","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"name","dtd_identifier":"8","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */,
  collctype: String /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_collation","column_name":"collctype","ordinal_position":9,"is_nullable":"NO","data_type":"name","collation_catalog":"postgres","collation_schema":"pg_catalog","collation_name":"C","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"name","dtd_identifier":"9","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */,
  collversion: Option[String] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_collation","column_name":"collversion","ordinal_position":10,"is_nullable":"YES","data_type":"text","character_octet_length":1073741824,"collation_catalog":"postgres","collation_schema":"pg_catalog","collation_name":"C","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"text","dtd_identifier":"10","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
)

object PgCollationRow {
  def rowParser(prefix: String): RowParser[PgCollationRow] = { row =>
    Success(
      PgCollationRow(
        oid = row[PgCollationId](prefix + "oid"),
        collname = row[String](prefix + "collname"),
        collnamespace = row[/* oid */ Long](prefix + "collnamespace"),
        collowner = row[/* oid */ Long](prefix + "collowner"),
        collprovider = row[String](prefix + "collprovider"),
        collisdeterministic = row[Boolean](prefix + "collisdeterministic"),
        collencoding = row[Int](prefix + "collencoding"),
        collcollate = row[String](prefix + "collcollate"),
        collctype = row[String](prefix + "collctype"),
        collversion = row[Option[String]](prefix + "collversion")
      )
    )
  }

  implicit val oFormat: OFormat[PgCollationRow] = new OFormat[PgCollationRow]{
    override def writes(o: PgCollationRow): JsObject =
      Json.obj(
        "oid" -> o.oid,
        "collname" -> o.collname,
        "collnamespace" -> o.collnamespace,
        "collowner" -> o.collowner,
        "collprovider" -> o.collprovider,
        "collisdeterministic" -> o.collisdeterministic,
        "collencoding" -> o.collencoding,
        "collcollate" -> o.collcollate,
        "collctype" -> o.collctype,
        "collversion" -> o.collversion
      )
  
    override def reads(json: JsValue): JsResult[PgCollationRow] = {
      JsResult.fromTry(
        Try(
          PgCollationRow(
            oid = json.\("oid").as[PgCollationId],
            collname = json.\("collname").as[String],
            collnamespace = json.\("collnamespace").as[/* oid */ Long],
            collowner = json.\("collowner").as[/* oid */ Long],
            collprovider = json.\("collprovider").as[String],
            collisdeterministic = json.\("collisdeterministic").as[Boolean],
            collencoding = json.\("collencoding").as[Int],
            collcollate = json.\("collcollate").as[String],
            collctype = json.\("collctype").as[String],
            collversion = json.\("collversion").toOption.map(_.as[String])
          )
        )
      )
    }
  }
}
