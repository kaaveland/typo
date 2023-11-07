/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package person
package addresstype

import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoUUID
import adventureworks.public.Name
import java.sql.ResultSet
import zio.jdbc.JdbcDecoder
import zio.json.JsonDecoder
import zio.json.JsonEncoder
import zio.json.ast.Json
import zio.json.internal.Write

case class AddresstypeRow(
  /** Primary key for AddressType records. */
  addresstypeid: AddresstypeId,
  /** Address type description. For example, Billing, Home, or Shipping. */
  name: Name,
  rowguid: TypoUUID,
  modifieddate: TypoLocalDateTime
)

object AddresstypeRow {
  implicit lazy val jdbcDecoder: JdbcDecoder[AddresstypeRow] = new JdbcDecoder[AddresstypeRow] {
    override def unsafeDecode(columIndex: Int, rs: ResultSet): (Int, AddresstypeRow) =
      columIndex + 3 ->
        AddresstypeRow(
          addresstypeid = AddresstypeId.jdbcDecoder.unsafeDecode(columIndex + 0, rs)._2,
          name = Name.jdbcDecoder.unsafeDecode(columIndex + 1, rs)._2,
          rowguid = TypoUUID.jdbcDecoder.unsafeDecode(columIndex + 2, rs)._2,
          modifieddate = TypoLocalDateTime.jdbcDecoder.unsafeDecode(columIndex + 3, rs)._2
        )
  }
  implicit lazy val jsonDecoder: JsonDecoder[AddresstypeRow] = JsonDecoder[Json.Obj].mapOrFail { jsonObj =>
    val addresstypeid = jsonObj.get("addresstypeid").toRight("Missing field 'addresstypeid'").flatMap(_.as(AddresstypeId.jsonDecoder))
    val name = jsonObj.get("name").toRight("Missing field 'name'").flatMap(_.as(Name.jsonDecoder))
    val rowguid = jsonObj.get("rowguid").toRight("Missing field 'rowguid'").flatMap(_.as(TypoUUID.jsonDecoder))
    val modifieddate = jsonObj.get("modifieddate").toRight("Missing field 'modifieddate'").flatMap(_.as(TypoLocalDateTime.jsonDecoder))
    if (addresstypeid.isRight && name.isRight && rowguid.isRight && modifieddate.isRight)
      Right(AddresstypeRow(addresstypeid = addresstypeid.toOption.get, name = name.toOption.get, rowguid = rowguid.toOption.get, modifieddate = modifieddate.toOption.get))
    else Left(List[Either[String, Any]](addresstypeid, name, rowguid, modifieddate).flatMap(_.left.toOption).mkString(", "))
  }
  implicit lazy val jsonEncoder: JsonEncoder[AddresstypeRow] = new JsonEncoder[AddresstypeRow] {
    override def unsafeEncode(a: AddresstypeRow, indent: Option[Int], out: Write): Unit = {
      out.write("{")
      out.write(""""addresstypeid":""")
      AddresstypeId.jsonEncoder.unsafeEncode(a.addresstypeid, indent, out)
      out.write(",")
      out.write(""""name":""")
      Name.jsonEncoder.unsafeEncode(a.name, indent, out)
      out.write(",")
      out.write(""""rowguid":""")
      TypoUUID.jsonEncoder.unsafeEncode(a.rowguid, indent, out)
      out.write(",")
      out.write(""""modifieddate":""")
      TypoLocalDateTime.jsonEncoder.unsafeEncode(a.modifieddate, indent, out)
      out.write("}")
    }
  }
}
