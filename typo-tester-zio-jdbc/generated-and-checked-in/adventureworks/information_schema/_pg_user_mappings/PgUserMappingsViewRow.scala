/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package `_pg_user_mappings`

import adventureworks.pg_catalog.pg_user_mapping.PgUserMappingId
import java.sql.ResultSet
import zio.jdbc.JdbcDecoder
import zio.json.JsonDecoder
import zio.json.JsonEncoder
import zio.json.ast.Json
import zio.json.internal.Write

case class PgUserMappingsViewRow(
  /** Points to [[pg_catalog.pg_user_mapping.PgUserMappingRow.oid]] */
  oid: PgUserMappingId,
  /** Points to [[pg_catalog.pg_user_mapping.PgUserMappingRow.umoptions]] */
  umoptions: Option[Array[String]],
  /** Points to [[pg_catalog.pg_user_mapping.PgUserMappingRow.umuser]] */
  umuser: /* oid */ Long,
  authorizationIdentifier: /* nullability unknown */ Option[String],
  /** Points to [[`_pg_foreign_servers`.PgForeignServersViewRow.foreignServerCatalog]] */
  foreignServerCatalog: Option[/* nullability unknown */ String],
  /** Points to [[`_pg_foreign_servers`.PgForeignServersViewRow.foreignServerName]] */
  foreignServerName: Option[/* nullability unknown */ String],
  /** Points to [[`_pg_foreign_servers`.PgForeignServersViewRow.authorizationIdentifier]] */
  srvowner: Option[/* nullability unknown */ String]
)

object PgUserMappingsViewRow {
  implicit lazy val jdbcDecoder: JdbcDecoder[PgUserMappingsViewRow] = new JdbcDecoder[PgUserMappingsViewRow] {
    override def unsafeDecode(columIndex: Int, rs: ResultSet): (Int, PgUserMappingsViewRow) =
      columIndex + 6 ->
        PgUserMappingsViewRow(
          oid = PgUserMappingId.jdbcDecoder.unsafeDecode(columIndex + 0, rs)._2,
          umoptions = JdbcDecoder.optionDecoder(adventureworks.StringArrayDecoder).unsafeDecode(columIndex + 1, rs)._2,
          umuser = JdbcDecoder.longDecoder.unsafeDecode(columIndex + 2, rs)._2,
          authorizationIdentifier = JdbcDecoder.optionDecoder(JdbcDecoder.stringDecoder).unsafeDecode(columIndex + 3, rs)._2,
          foreignServerCatalog = JdbcDecoder.optionDecoder(JdbcDecoder.stringDecoder).unsafeDecode(columIndex + 4, rs)._2,
          foreignServerName = JdbcDecoder.optionDecoder(JdbcDecoder.stringDecoder).unsafeDecode(columIndex + 5, rs)._2,
          srvowner = JdbcDecoder.optionDecoder(JdbcDecoder.stringDecoder).unsafeDecode(columIndex + 6, rs)._2
        )
  }
  implicit lazy val jsonDecoder: JsonDecoder[PgUserMappingsViewRow] = JsonDecoder[Json.Obj].mapOrFail { jsonObj =>
    val oid = jsonObj.get("oid").toRight("Missing field 'oid'").flatMap(_.as(PgUserMappingId.jsonDecoder))
    val umoptions = jsonObj.get("umoptions").fold[Either[String, Option[Array[String]]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.array[String](JsonDecoder.string, implicitly))))
    val umuser = jsonObj.get("umuser").toRight("Missing field 'umuser'").flatMap(_.as(JsonDecoder.long))
    val authorizationIdentifier = jsonObj.get("authorization_identifier").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.string)))
    val foreignServerCatalog = jsonObj.get("foreign_server_catalog").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.string)))
    val foreignServerName = jsonObj.get("foreign_server_name").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.string)))
    val srvowner = jsonObj.get("srvowner").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.string)))
    if (oid.isRight && umoptions.isRight && umuser.isRight && authorizationIdentifier.isRight && foreignServerCatalog.isRight && foreignServerName.isRight && srvowner.isRight)
      Right(PgUserMappingsViewRow(oid = oid.toOption.get, umoptions = umoptions.toOption.get, umuser = umuser.toOption.get, authorizationIdentifier = authorizationIdentifier.toOption.get, foreignServerCatalog = foreignServerCatalog.toOption.get, foreignServerName = foreignServerName.toOption.get, srvowner = srvowner.toOption.get))
    else Left(List[Either[String, Any]](oid, umoptions, umuser, authorizationIdentifier, foreignServerCatalog, foreignServerName, srvowner).flatMap(_.left.toOption).mkString(", "))
  }
  implicit lazy val jsonEncoder: JsonEncoder[PgUserMappingsViewRow] = new JsonEncoder[PgUserMappingsViewRow] {
    override def unsafeEncode(a: PgUserMappingsViewRow, indent: Option[Int], out: Write): Unit = {
      out.write("{")
      out.write(""""oid":""")
      PgUserMappingId.jsonEncoder.unsafeEncode(a.oid, indent, out)
      out.write(",")
      out.write(""""umoptions":""")
      JsonEncoder.option(JsonEncoder.array[String](JsonEncoder.string, implicitly)).unsafeEncode(a.umoptions, indent, out)
      out.write(",")
      out.write(""""umuser":""")
      JsonEncoder.long.unsafeEncode(a.umuser, indent, out)
      out.write(",")
      out.write(""""authorization_identifier":""")
      JsonEncoder.option(JsonEncoder.string).unsafeEncode(a.authorizationIdentifier, indent, out)
      out.write(",")
      out.write(""""foreign_server_catalog":""")
      JsonEncoder.option(JsonEncoder.string).unsafeEncode(a.foreignServerCatalog, indent, out)
      out.write(",")
      out.write(""""foreign_server_name":""")
      JsonEncoder.option(JsonEncoder.string).unsafeEncode(a.foreignServerName, indent, out)
      out.write(",")
      out.write(""""srvowner":""")
      JsonEncoder.option(JsonEncoder.string).unsafeEncode(a.srvowner, indent, out)
      out.write("}")
    }
  }
}
