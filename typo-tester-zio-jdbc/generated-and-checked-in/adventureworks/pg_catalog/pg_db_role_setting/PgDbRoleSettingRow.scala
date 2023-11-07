/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_db_role_setting

import java.sql.ResultSet
import zio.jdbc.JdbcDecoder
import zio.json.JsonDecoder
import zio.json.JsonEncoder
import zio.json.ast.Json
import zio.json.internal.Write

case class PgDbRoleSettingRow(
  setdatabase: /* oid */ Long,
  setrole: /* oid */ Long,
  setconfig: Option[Array[String]]
){
   val compositeId: PgDbRoleSettingId = PgDbRoleSettingId(setdatabase, setrole)
 }

object PgDbRoleSettingRow {
  implicit lazy val jdbcDecoder: JdbcDecoder[PgDbRoleSettingRow] = new JdbcDecoder[PgDbRoleSettingRow] {
    override def unsafeDecode(columIndex: Int, rs: ResultSet): (Int, PgDbRoleSettingRow) =
      columIndex + 2 ->
        PgDbRoleSettingRow(
          setdatabase = JdbcDecoder.longDecoder.unsafeDecode(columIndex + 0, rs)._2,
          setrole = JdbcDecoder.longDecoder.unsafeDecode(columIndex + 1, rs)._2,
          setconfig = JdbcDecoder.optionDecoder(adventureworks.StringArrayDecoder).unsafeDecode(columIndex + 2, rs)._2
        )
  }
  implicit lazy val jsonDecoder: JsonDecoder[PgDbRoleSettingRow] = JsonDecoder[Json.Obj].mapOrFail { jsonObj =>
    val setdatabase = jsonObj.get("setdatabase").toRight("Missing field 'setdatabase'").flatMap(_.as(JsonDecoder.long))
    val setrole = jsonObj.get("setrole").toRight("Missing field 'setrole'").flatMap(_.as(JsonDecoder.long))
    val setconfig = jsonObj.get("setconfig").fold[Either[String, Option[Array[String]]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.array[String](JsonDecoder.string, implicitly))))
    if (setdatabase.isRight && setrole.isRight && setconfig.isRight)
      Right(PgDbRoleSettingRow(setdatabase = setdatabase.toOption.get, setrole = setrole.toOption.get, setconfig = setconfig.toOption.get))
    else Left(List[Either[String, Any]](setdatabase, setrole, setconfig).flatMap(_.left.toOption).mkString(", "))
  }
  implicit lazy val jsonEncoder: JsonEncoder[PgDbRoleSettingRow] = new JsonEncoder[PgDbRoleSettingRow] {
    override def unsafeEncode(a: PgDbRoleSettingRow, indent: Option[Int], out: Write): Unit = {
      out.write("{")
      out.write(""""setdatabase":""")
      JsonEncoder.long.unsafeEncode(a.setdatabase, indent, out)
      out.write(",")
      out.write(""""setrole":""")
      JsonEncoder.long.unsafeEncode(a.setrole, indent, out)
      out.write(",")
      out.write(""""setconfig":""")
      JsonEncoder.option(JsonEncoder.array[String](JsonEncoder.string, implicitly)).unsafeEncode(a.setconfig, indent, out)
      out.write("}")
    }
  }
}
