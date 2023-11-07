/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pe
package p

import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoUUID
import adventureworks.customtypes.TypoXml
import adventureworks.person.businessentity.BusinessentityId
import adventureworks.public.Name
import adventureworks.public.NameStyle
import adventureworks.userdefined.FirstName
import java.sql.ResultSet
import zio.jdbc.JdbcDecoder
import zio.json.JsonDecoder
import zio.json.JsonEncoder
import zio.json.ast.Json
import zio.json.internal.Write

case class PViewRow(
  /** Points to [[person.person.PersonRow.businessentityid]] */
  id: BusinessentityId,
  /** Points to [[person.person.PersonRow.businessentityid]] */
  businessentityid: BusinessentityId,
  /** Points to [[person.person.PersonRow.persontype]] */
  persontype: /* bpchar, max 2 chars */ String,
  /** Points to [[person.person.PersonRow.namestyle]] */
  namestyle: NameStyle,
  /** Points to [[person.person.PersonRow.title]] */
  title: Option[/* max 8 chars */ String],
  /** Points to [[person.person.PersonRow.firstname]] */
  firstname: /* user-picked */ FirstName,
  /** Points to [[person.person.PersonRow.middlename]] */
  middlename: Option[Name],
  /** Points to [[person.person.PersonRow.lastname]] */
  lastname: Name,
  /** Points to [[person.person.PersonRow.suffix]] */
  suffix: Option[/* max 10 chars */ String],
  /** Points to [[person.person.PersonRow.emailpromotion]] */
  emailpromotion: Int,
  /** Points to [[person.person.PersonRow.additionalcontactinfo]] */
  additionalcontactinfo: Option[TypoXml],
  /** Points to [[person.person.PersonRow.demographics]] */
  demographics: Option[TypoXml],
  /** Points to [[person.person.PersonRow.rowguid]] */
  rowguid: TypoUUID,
  /** Points to [[person.person.PersonRow.modifieddate]] */
  modifieddate: TypoLocalDateTime
)

object PViewRow {
  implicit lazy val jdbcDecoder: JdbcDecoder[PViewRow] = new JdbcDecoder[PViewRow] {
    override def unsafeDecode(columIndex: Int, rs: ResultSet): (Int, PViewRow) =
      columIndex + 13 ->
        PViewRow(
          id = BusinessentityId.jdbcDecoder.unsafeDecode(columIndex + 0, rs)._2,
          businessentityid = BusinessentityId.jdbcDecoder.unsafeDecode(columIndex + 1, rs)._2,
          persontype = JdbcDecoder.stringDecoder.unsafeDecode(columIndex + 2, rs)._2,
          namestyle = NameStyle.jdbcDecoder.unsafeDecode(columIndex + 3, rs)._2,
          title = JdbcDecoder.optionDecoder(JdbcDecoder.stringDecoder).unsafeDecode(columIndex + 4, rs)._2,
          firstname = FirstName.jdbcDecoder.unsafeDecode(columIndex + 5, rs)._2,
          middlename = JdbcDecoder.optionDecoder(Name.jdbcDecoder).unsafeDecode(columIndex + 6, rs)._2,
          lastname = Name.jdbcDecoder.unsafeDecode(columIndex + 7, rs)._2,
          suffix = JdbcDecoder.optionDecoder(JdbcDecoder.stringDecoder).unsafeDecode(columIndex + 8, rs)._2,
          emailpromotion = JdbcDecoder.intDecoder.unsafeDecode(columIndex + 9, rs)._2,
          additionalcontactinfo = JdbcDecoder.optionDecoder(TypoXml.jdbcDecoder).unsafeDecode(columIndex + 10, rs)._2,
          demographics = JdbcDecoder.optionDecoder(TypoXml.jdbcDecoder).unsafeDecode(columIndex + 11, rs)._2,
          rowguid = TypoUUID.jdbcDecoder.unsafeDecode(columIndex + 12, rs)._2,
          modifieddate = TypoLocalDateTime.jdbcDecoder.unsafeDecode(columIndex + 13, rs)._2
        )
  }
  implicit lazy val jsonDecoder: JsonDecoder[PViewRow] = JsonDecoder[Json.Obj].mapOrFail { jsonObj =>
    val id = jsonObj.get("id").toRight("Missing field 'id'").flatMap(_.as(BusinessentityId.jsonDecoder))
    val businessentityid = jsonObj.get("businessentityid").toRight("Missing field 'businessentityid'").flatMap(_.as(BusinessentityId.jsonDecoder))
    val persontype = jsonObj.get("persontype").toRight("Missing field 'persontype'").flatMap(_.as(JsonDecoder.string))
    val namestyle = jsonObj.get("namestyle").toRight("Missing field 'namestyle'").flatMap(_.as(NameStyle.jsonDecoder))
    val title = jsonObj.get("title").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.string)))
    val firstname = jsonObj.get("firstname").toRight("Missing field 'firstname'").flatMap(_.as(FirstName.jsonDecoder))
    val middlename = jsonObj.get("middlename").fold[Either[String, Option[Name]]](Right(None))(_.as(JsonDecoder.option(Name.jsonDecoder)))
    val lastname = jsonObj.get("lastname").toRight("Missing field 'lastname'").flatMap(_.as(Name.jsonDecoder))
    val suffix = jsonObj.get("suffix").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.string)))
    val emailpromotion = jsonObj.get("emailpromotion").toRight("Missing field 'emailpromotion'").flatMap(_.as(JsonDecoder.int))
    val additionalcontactinfo = jsonObj.get("additionalcontactinfo").fold[Either[String, Option[TypoXml]]](Right(None))(_.as(JsonDecoder.option(TypoXml.jsonDecoder)))
    val demographics = jsonObj.get("demographics").fold[Either[String, Option[TypoXml]]](Right(None))(_.as(JsonDecoder.option(TypoXml.jsonDecoder)))
    val rowguid = jsonObj.get("rowguid").toRight("Missing field 'rowguid'").flatMap(_.as(TypoUUID.jsonDecoder))
    val modifieddate = jsonObj.get("modifieddate").toRight("Missing field 'modifieddate'").flatMap(_.as(TypoLocalDateTime.jsonDecoder))
    if (id.isRight && businessentityid.isRight && persontype.isRight && namestyle.isRight && title.isRight && firstname.isRight && middlename.isRight && lastname.isRight && suffix.isRight && emailpromotion.isRight && additionalcontactinfo.isRight && demographics.isRight && rowguid.isRight && modifieddate.isRight)
      Right(PViewRow(id = id.toOption.get, businessentityid = businessentityid.toOption.get, persontype = persontype.toOption.get, namestyle = namestyle.toOption.get, title = title.toOption.get, firstname = firstname.toOption.get, middlename = middlename.toOption.get, lastname = lastname.toOption.get, suffix = suffix.toOption.get, emailpromotion = emailpromotion.toOption.get, additionalcontactinfo = additionalcontactinfo.toOption.get, demographics = demographics.toOption.get, rowguid = rowguid.toOption.get, modifieddate = modifieddate.toOption.get))
    else Left(List[Either[String, Any]](id, businessentityid, persontype, namestyle, title, firstname, middlename, lastname, suffix, emailpromotion, additionalcontactinfo, demographics, rowguid, modifieddate).flatMap(_.left.toOption).mkString(", "))
  }
  implicit lazy val jsonEncoder: JsonEncoder[PViewRow] = new JsonEncoder[PViewRow] {
    override def unsafeEncode(a: PViewRow, indent: Option[Int], out: Write): Unit = {
      out.write("{")
      out.write(""""id":""")
      BusinessentityId.jsonEncoder.unsafeEncode(a.id, indent, out)
      out.write(",")
      out.write(""""businessentityid":""")
      BusinessentityId.jsonEncoder.unsafeEncode(a.businessentityid, indent, out)
      out.write(",")
      out.write(""""persontype":""")
      JsonEncoder.string.unsafeEncode(a.persontype, indent, out)
      out.write(",")
      out.write(""""namestyle":""")
      NameStyle.jsonEncoder.unsafeEncode(a.namestyle, indent, out)
      out.write(",")
      out.write(""""title":""")
      JsonEncoder.option(JsonEncoder.string).unsafeEncode(a.title, indent, out)
      out.write(",")
      out.write(""""firstname":""")
      FirstName.jsonEncoder.unsafeEncode(a.firstname, indent, out)
      out.write(",")
      out.write(""""middlename":""")
      JsonEncoder.option(Name.jsonEncoder).unsafeEncode(a.middlename, indent, out)
      out.write(",")
      out.write(""""lastname":""")
      Name.jsonEncoder.unsafeEncode(a.lastname, indent, out)
      out.write(",")
      out.write(""""suffix":""")
      JsonEncoder.option(JsonEncoder.string).unsafeEncode(a.suffix, indent, out)
      out.write(",")
      out.write(""""emailpromotion":""")
      JsonEncoder.int.unsafeEncode(a.emailpromotion, indent, out)
      out.write(",")
      out.write(""""additionalcontactinfo":""")
      JsonEncoder.option(TypoXml.jsonEncoder).unsafeEncode(a.additionalcontactinfo, indent, out)
      out.write(",")
      out.write(""""demographics":""")
      JsonEncoder.option(TypoXml.jsonEncoder).unsafeEncode(a.demographics, indent, out)
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
