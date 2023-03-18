package testdb
package postgres
package pg_catalog

import anorm.RowParser
import anorm.Success
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try

case class PgDatabaseRow(
  oid: Long,
  datname: String,
  datdba: Long,
  encoding: Int,
  datcollate: String,
  datctype: String,
  datistemplate: Boolean,
  datallowconn: Boolean,
  datconnlimit: Int,
  datlastsysoid: Long,
  datfrozenxid: String,
  datminmxid: String,
  dattablespace: Long,
  datacl: Option[Array[String]]
)

object PgDatabaseRow {
  implicit val rowParser: RowParser[PgDatabaseRow] = { row =>
    Success(
      PgDatabaseRow(
        oid = row[Long]("oid"),
        datname = row[String]("datname"),
        datdba = row[Long]("datdba"),
        encoding = row[Int]("encoding"),
        datcollate = row[String]("datcollate"),
        datctype = row[String]("datctype"),
        datistemplate = row[Boolean]("datistemplate"),
        datallowconn = row[Boolean]("datallowconn"),
        datconnlimit = row[Int]("datconnlimit"),
        datlastsysoid = row[Long]("datlastsysoid"),
        datfrozenxid = row[String]("datfrozenxid"),
        datminmxid = row[String]("datminmxid"),
        dattablespace = row[Long]("dattablespace"),
        datacl = row[Option[Array[String]]]("datacl")
      )
    )
  }

  implicit val oFormat: OFormat[PgDatabaseRow] = new OFormat[PgDatabaseRow]{
    override def writes(o: PgDatabaseRow): JsObject =
      Json.obj(
        "oid" -> o.oid,
      "datname" -> o.datname,
      "datdba" -> o.datdba,
      "encoding" -> o.encoding,
      "datcollate" -> o.datcollate,
      "datctype" -> o.datctype,
      "datistemplate" -> o.datistemplate,
      "datallowconn" -> o.datallowconn,
      "datconnlimit" -> o.datconnlimit,
      "datlastsysoid" -> o.datlastsysoid,
      "datfrozenxid" -> o.datfrozenxid,
      "datminmxid" -> o.datminmxid,
      "dattablespace" -> o.dattablespace,
      "datacl" -> o.datacl
      )

    override def reads(json: JsValue): JsResult[PgDatabaseRow] = {
      JsResult.fromTry(
        Try(
          PgDatabaseRow(
            oid = json.\("oid").as[Long],
            datname = json.\("datname").as[String],
            datdba = json.\("datdba").as[Long],
            encoding = json.\("encoding").as[Int],
            datcollate = json.\("datcollate").as[String],
            datctype = json.\("datctype").as[String],
            datistemplate = json.\("datistemplate").as[Boolean],
            datallowconn = json.\("datallowconn").as[Boolean],
            datconnlimit = json.\("datconnlimit").as[Int],
            datlastsysoid = json.\("datlastsysoid").as[Long],
            datfrozenxid = json.\("datfrozenxid").as[String],
            datminmxid = json.\("datminmxid").as[String],
            dattablespace = json.\("dattablespace").as[Long],
            datacl = json.\("datacl").toOption.map(_.as[Array[String]])
          )
        )
      )
    }
  }
}