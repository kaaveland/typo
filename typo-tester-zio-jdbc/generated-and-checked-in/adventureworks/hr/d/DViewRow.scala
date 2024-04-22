/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package hr
package d

import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.humanresources.department.DepartmentId
import adventureworks.public.Name
import java.sql.ResultSet
import zio.jdbc.JdbcDecoder
import zio.json.JsonDecoder
import zio.json.JsonEncoder
import zio.json.ast.Json
import zio.json.internal.Write

/** View: hr.d */
case class DViewRow(
  /** Points to [[humanresources.department.DepartmentRow.departmentid]] */
  id: DepartmentId,
  /** Points to [[humanresources.department.DepartmentRow.departmentid]] */
  departmentid: DepartmentId,
  /** Points to [[humanresources.department.DepartmentRow.name]] */
  name: Name,
  /** Points to [[humanresources.department.DepartmentRow.groupname]] */
  groupname: Name,
  /** Points to [[humanresources.department.DepartmentRow.modifieddate]] */
  modifieddate: TypoLocalDateTime
)

object DViewRow {
  implicit lazy val jdbcDecoder: JdbcDecoder[DViewRow] = new JdbcDecoder[DViewRow] {
    override def unsafeDecode(columIndex: Int, rs: ResultSet): (Int, DViewRow) =
      columIndex + 4 ->
        DViewRow(
          id = DepartmentId.jdbcDecoder.unsafeDecode(columIndex + 0, rs)._2,
          departmentid = DepartmentId.jdbcDecoder.unsafeDecode(columIndex + 1, rs)._2,
          name = Name.jdbcDecoder.unsafeDecode(columIndex + 2, rs)._2,
          groupname = Name.jdbcDecoder.unsafeDecode(columIndex + 3, rs)._2,
          modifieddate = TypoLocalDateTime.jdbcDecoder.unsafeDecode(columIndex + 4, rs)._2
        )
  }
  implicit lazy val jsonDecoder: JsonDecoder[DViewRow] = JsonDecoder[Json.Obj].mapOrFail { jsonObj =>
    val id = jsonObj.get("id").toRight("Missing field 'id'").flatMap(_.as(DepartmentId.jsonDecoder))
    val departmentid = jsonObj.get("departmentid").toRight("Missing field 'departmentid'").flatMap(_.as(DepartmentId.jsonDecoder))
    val name = jsonObj.get("name").toRight("Missing field 'name'").flatMap(_.as(Name.jsonDecoder))
    val groupname = jsonObj.get("groupname").toRight("Missing field 'groupname'").flatMap(_.as(Name.jsonDecoder))
    val modifieddate = jsonObj.get("modifieddate").toRight("Missing field 'modifieddate'").flatMap(_.as(TypoLocalDateTime.jsonDecoder))
    if (id.isRight && departmentid.isRight && name.isRight && groupname.isRight && modifieddate.isRight)
      Right(DViewRow(id = id.toOption.get, departmentid = departmentid.toOption.get, name = name.toOption.get, groupname = groupname.toOption.get, modifieddate = modifieddate.toOption.get))
    else Left(List[Either[String, Any]](id, departmentid, name, groupname, modifieddate).flatMap(_.left.toOption).mkString(", "))
  }
  implicit lazy val jsonEncoder: JsonEncoder[DViewRow] = new JsonEncoder[DViewRow] {
    override def unsafeEncode(a: DViewRow, indent: Option[Int], out: Write): Unit = {
      out.write("{")
      out.write(""""id":""")
      DepartmentId.jsonEncoder.unsafeEncode(a.id, indent, out)
      out.write(",")
      out.write(""""departmentid":""")
      DepartmentId.jsonEncoder.unsafeEncode(a.departmentid, indent, out)
      out.write(",")
      out.write(""""name":""")
      Name.jsonEncoder.unsafeEncode(a.name, indent, out)
      out.write(",")
      out.write(""""groupname":""")
      Name.jsonEncoder.unsafeEncode(a.groupname, indent, out)
      out.write(",")
      out.write(""""modifieddate":""")
      TypoLocalDateTime.jsonEncoder.unsafeEncode(a.modifieddate, indent, out)
      out.write("}")
    }
  }
}
