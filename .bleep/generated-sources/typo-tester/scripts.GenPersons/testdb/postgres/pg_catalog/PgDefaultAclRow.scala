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

case class PgDefaultAclRow(
  oid: Long,
  defaclrole: Long,
  defaclnamespace: Long,
  defaclobjtype: String,
  defaclacl: Array[String]
)

object PgDefaultAclRow {
  implicit val rowParser: RowParser[PgDefaultAclRow] = { row =>
    Success(
      PgDefaultAclRow(
        oid = row[Long]("oid"),
        defaclrole = row[Long]("defaclrole"),
        defaclnamespace = row[Long]("defaclnamespace"),
        defaclobjtype = row[String]("defaclobjtype"),
        defaclacl = row[Array[String]]("defaclacl")
      )
    )
  }

  implicit val oFormat: OFormat[PgDefaultAclRow] = new OFormat[PgDefaultAclRow]{
    override def writes(o: PgDefaultAclRow): JsObject =
      Json.obj(
        "oid" -> o.oid,
      "defaclrole" -> o.defaclrole,
      "defaclnamespace" -> o.defaclnamespace,
      "defaclobjtype" -> o.defaclobjtype,
      "defaclacl" -> o.defaclacl
      )

    override def reads(json: JsValue): JsResult[PgDefaultAclRow] = {
      JsResult.fromTry(
        Try(
          PgDefaultAclRow(
            oid = json.\("oid").as[Long],
            defaclrole = json.\("defaclrole").as[Long],
            defaclnamespace = json.\("defaclnamespace").as[Long],
            defaclobjtype = json.\("defaclobjtype").as[String],
            defaclacl = json.\("defaclacl").as[Array[String]]
          )
        )
      )
    }
  }
}
