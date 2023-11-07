/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package person
package emailaddress

import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoUUID
import adventureworks.person.businessentity.BusinessentityId
import java.sql.ResultSet
import zio.jdbc.JdbcDecoder
import zio.json.JsonDecoder
import zio.json.JsonEncoder
import zio.json.ast.Json
import zio.json.internal.Write

case class EmailaddressRow(
  /** Primary key. Person associated with this email address.  Foreign key to Person.BusinessEntityID
      Points to [[person.PersonRow.businessentityid]] */
  businessentityid: BusinessentityId,
  /** Primary key. ID of this email address. */
  emailaddressid: Int,
  /** E-mail address for the person. */
  emailaddress: Option[/* max 50 chars */ String],
  rowguid: TypoUUID,
  modifieddate: TypoLocalDateTime
){
   val compositeId: EmailaddressId = EmailaddressId(businessentityid, emailaddressid)
 }

object EmailaddressRow {
  implicit lazy val jdbcDecoder: JdbcDecoder[EmailaddressRow] = new JdbcDecoder[EmailaddressRow] {
    override def unsafeDecode(columIndex: Int, rs: ResultSet): (Int, EmailaddressRow) =
      columIndex + 4 ->
        EmailaddressRow(
          businessentityid = BusinessentityId.jdbcDecoder.unsafeDecode(columIndex + 0, rs)._2,
          emailaddressid = JdbcDecoder.intDecoder.unsafeDecode(columIndex + 1, rs)._2,
          emailaddress = JdbcDecoder.optionDecoder(JdbcDecoder.stringDecoder).unsafeDecode(columIndex + 2, rs)._2,
          rowguid = TypoUUID.jdbcDecoder.unsafeDecode(columIndex + 3, rs)._2,
          modifieddate = TypoLocalDateTime.jdbcDecoder.unsafeDecode(columIndex + 4, rs)._2
        )
  }
  implicit lazy val jsonDecoder: JsonDecoder[EmailaddressRow] = JsonDecoder[Json.Obj].mapOrFail { jsonObj =>
    val businessentityid = jsonObj.get("businessentityid").toRight("Missing field 'businessentityid'").flatMap(_.as(BusinessentityId.jsonDecoder))
    val emailaddressid = jsonObj.get("emailaddressid").toRight("Missing field 'emailaddressid'").flatMap(_.as(JsonDecoder.int))
    val emailaddress = jsonObj.get("emailaddress").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.string)))
    val rowguid = jsonObj.get("rowguid").toRight("Missing field 'rowguid'").flatMap(_.as(TypoUUID.jsonDecoder))
    val modifieddate = jsonObj.get("modifieddate").toRight("Missing field 'modifieddate'").flatMap(_.as(TypoLocalDateTime.jsonDecoder))
    if (businessentityid.isRight && emailaddressid.isRight && emailaddress.isRight && rowguid.isRight && modifieddate.isRight)
      Right(EmailaddressRow(businessentityid = businessentityid.toOption.get, emailaddressid = emailaddressid.toOption.get, emailaddress = emailaddress.toOption.get, rowguid = rowguid.toOption.get, modifieddate = modifieddate.toOption.get))
    else Left(List[Either[String, Any]](businessentityid, emailaddressid, emailaddress, rowguid, modifieddate).flatMap(_.left.toOption).mkString(", "))
  }
  implicit lazy val jsonEncoder: JsonEncoder[EmailaddressRow] = new JsonEncoder[EmailaddressRow] {
    override def unsafeEncode(a: EmailaddressRow, indent: Option[Int], out: Write): Unit = {
      out.write("{")
      out.write(""""businessentityid":""")
      BusinessentityId.jsonEncoder.unsafeEncode(a.businessentityid, indent, out)
      out.write(",")
      out.write(""""emailaddressid":""")
      JsonEncoder.int.unsafeEncode(a.emailaddressid, indent, out)
      out.write(",")
      out.write(""""emailaddress":""")
      JsonEncoder.option(JsonEncoder.string).unsafeEncode(a.emailaddress, indent, out)
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
