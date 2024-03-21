/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package vpersondemographics

import adventureworks.customtypes.TypoLocalDate
import adventureworks.customtypes.TypoMoney
import adventureworks.person.businessentity.BusinessentityId
import java.sql.ResultSet
import zio.jdbc.JdbcDecoder
import zio.json.JsonDecoder
import zio.json.JsonEncoder
import zio.json.ast.Json
import zio.json.internal.Write

case class VpersondemographicsViewRow(
  /** Points to [[person.person.PersonRow.businessentityid]] */
  businessentityid: BusinessentityId,
  totalpurchaseytd: /* nullability unknown */ Option[TypoMoney],
  datefirstpurchase: /* nullability unknown */ Option[TypoLocalDate],
  birthdate: /* nullability unknown */ Option[TypoLocalDate],
  maritalstatus: /* nullability unknown */ Option[/* max 1 chars */ String],
  yearlyincome: /* nullability unknown */ Option[/* max 30 chars */ String],
  gender: /* nullability unknown */ Option[/* max 1 chars */ String],
  totalchildren: /* nullability unknown */ Option[Int],
  numberchildrenathome: /* nullability unknown */ Option[Int],
  education: /* nullability unknown */ Option[/* max 30 chars */ String],
  occupation: /* nullability unknown */ Option[/* max 30 chars */ String],
  homeownerflag: /* nullability unknown */ Option[Boolean],
  numbercarsowned: /* nullability unknown */ Option[Int]
)

object VpersondemographicsViewRow {
  implicit lazy val jdbcDecoder: JdbcDecoder[VpersondemographicsViewRow] = new JdbcDecoder[VpersondemographicsViewRow] {
    override def unsafeDecode(columIndex: Int, rs: ResultSet): (Int, VpersondemographicsViewRow) =
      columIndex + 12 ->
        VpersondemographicsViewRow(
          businessentityid = BusinessentityId.jdbcDecoder.unsafeDecode(columIndex + 0, rs)._2,
          totalpurchaseytd = JdbcDecoder.optionDecoder(TypoMoney.jdbcDecoder).unsafeDecode(columIndex + 1, rs)._2,
          datefirstpurchase = JdbcDecoder.optionDecoder(TypoLocalDate.jdbcDecoder).unsafeDecode(columIndex + 2, rs)._2,
          birthdate = JdbcDecoder.optionDecoder(TypoLocalDate.jdbcDecoder).unsafeDecode(columIndex + 3, rs)._2,
          maritalstatus = JdbcDecoder.optionDecoder(JdbcDecoder.stringDecoder).unsafeDecode(columIndex + 4, rs)._2,
          yearlyincome = JdbcDecoder.optionDecoder(JdbcDecoder.stringDecoder).unsafeDecode(columIndex + 5, rs)._2,
          gender = JdbcDecoder.optionDecoder(JdbcDecoder.stringDecoder).unsafeDecode(columIndex + 6, rs)._2,
          totalchildren = JdbcDecoder.optionDecoder(JdbcDecoder.intDecoder).unsafeDecode(columIndex + 7, rs)._2,
          numberchildrenathome = JdbcDecoder.optionDecoder(JdbcDecoder.intDecoder).unsafeDecode(columIndex + 8, rs)._2,
          education = JdbcDecoder.optionDecoder(JdbcDecoder.stringDecoder).unsafeDecode(columIndex + 9, rs)._2,
          occupation = JdbcDecoder.optionDecoder(JdbcDecoder.stringDecoder).unsafeDecode(columIndex + 10, rs)._2,
          homeownerflag = JdbcDecoder.optionDecoder(JdbcDecoder.booleanDecoder).unsafeDecode(columIndex + 11, rs)._2,
          numbercarsowned = JdbcDecoder.optionDecoder(JdbcDecoder.intDecoder).unsafeDecode(columIndex + 12, rs)._2
        )
  }
  implicit lazy val jsonDecoder: JsonDecoder[VpersondemographicsViewRow] = JsonDecoder[Json.Obj].mapOrFail { jsonObj =>
    val businessentityid = jsonObj.get("businessentityid").toRight("Missing field 'businessentityid'").flatMap(_.as(BusinessentityId.jsonDecoder))
    val totalpurchaseytd = jsonObj.get("totalpurchaseytd").fold[Either[String, Option[TypoMoney]]](Right(None))(_.as(JsonDecoder.option(using TypoMoney.jsonDecoder)))
    val datefirstpurchase = jsonObj.get("datefirstpurchase").fold[Either[String, Option[TypoLocalDate]]](Right(None))(_.as(JsonDecoder.option(using TypoLocalDate.jsonDecoder)))
    val birthdate = jsonObj.get("birthdate").fold[Either[String, Option[TypoLocalDate]]](Right(None))(_.as(JsonDecoder.option(using TypoLocalDate.jsonDecoder)))
    val maritalstatus = jsonObj.get("maritalstatus").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(using JsonDecoder.string)))
    val yearlyincome = jsonObj.get("yearlyincome").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(using JsonDecoder.string)))
    val gender = jsonObj.get("gender").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(using JsonDecoder.string)))
    val totalchildren = jsonObj.get("totalchildren").fold[Either[String, Option[Int]]](Right(None))(_.as(JsonDecoder.option(using JsonDecoder.int)))
    val numberchildrenathome = jsonObj.get("numberchildrenathome").fold[Either[String, Option[Int]]](Right(None))(_.as(JsonDecoder.option(using JsonDecoder.int)))
    val education = jsonObj.get("education").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(using JsonDecoder.string)))
    val occupation = jsonObj.get("occupation").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(using JsonDecoder.string)))
    val homeownerflag = jsonObj.get("homeownerflag").fold[Either[String, Option[Boolean]]](Right(None))(_.as(JsonDecoder.option(using JsonDecoder.boolean)))
    val numbercarsowned = jsonObj.get("numbercarsowned").fold[Either[String, Option[Int]]](Right(None))(_.as(JsonDecoder.option(using JsonDecoder.int)))
    if (businessentityid.isRight && totalpurchaseytd.isRight && datefirstpurchase.isRight && birthdate.isRight && maritalstatus.isRight && yearlyincome.isRight && gender.isRight && totalchildren.isRight && numberchildrenathome.isRight && education.isRight && occupation.isRight && homeownerflag.isRight && numbercarsowned.isRight)
      Right(VpersondemographicsViewRow(businessentityid = businessentityid.toOption.get, totalpurchaseytd = totalpurchaseytd.toOption.get, datefirstpurchase = datefirstpurchase.toOption.get, birthdate = birthdate.toOption.get, maritalstatus = maritalstatus.toOption.get, yearlyincome = yearlyincome.toOption.get, gender = gender.toOption.get, totalchildren = totalchildren.toOption.get, numberchildrenathome = numberchildrenathome.toOption.get, education = education.toOption.get, occupation = occupation.toOption.get, homeownerflag = homeownerflag.toOption.get, numbercarsowned = numbercarsowned.toOption.get))
    else Left(List[Either[String, Any]](businessentityid, totalpurchaseytd, datefirstpurchase, birthdate, maritalstatus, yearlyincome, gender, totalchildren, numberchildrenathome, education, occupation, homeownerflag, numbercarsowned).flatMap(_.left.toOption).mkString(", "))
  }
  implicit lazy val jsonEncoder: JsonEncoder[VpersondemographicsViewRow] = new JsonEncoder[VpersondemographicsViewRow] {
    override def unsafeEncode(a: VpersondemographicsViewRow, indent: Option[Int], out: Write): Unit = {
      out.write("{")
      out.write(""""businessentityid":""")
      BusinessentityId.jsonEncoder.unsafeEncode(a.businessentityid, indent, out)
      out.write(",")
      out.write(""""totalpurchaseytd":""")
      JsonEncoder.option(using TypoMoney.jsonEncoder).unsafeEncode(a.totalpurchaseytd, indent, out)
      out.write(",")
      out.write(""""datefirstpurchase":""")
      JsonEncoder.option(using TypoLocalDate.jsonEncoder).unsafeEncode(a.datefirstpurchase, indent, out)
      out.write(",")
      out.write(""""birthdate":""")
      JsonEncoder.option(using TypoLocalDate.jsonEncoder).unsafeEncode(a.birthdate, indent, out)
      out.write(",")
      out.write(""""maritalstatus":""")
      JsonEncoder.option(using JsonEncoder.string).unsafeEncode(a.maritalstatus, indent, out)
      out.write(",")
      out.write(""""yearlyincome":""")
      JsonEncoder.option(using JsonEncoder.string).unsafeEncode(a.yearlyincome, indent, out)
      out.write(",")
      out.write(""""gender":""")
      JsonEncoder.option(using JsonEncoder.string).unsafeEncode(a.gender, indent, out)
      out.write(",")
      out.write(""""totalchildren":""")
      JsonEncoder.option(using JsonEncoder.int).unsafeEncode(a.totalchildren, indent, out)
      out.write(",")
      out.write(""""numberchildrenathome":""")
      JsonEncoder.option(using JsonEncoder.int).unsafeEncode(a.numberchildrenathome, indent, out)
      out.write(",")
      out.write(""""education":""")
      JsonEncoder.option(using JsonEncoder.string).unsafeEncode(a.education, indent, out)
      out.write(",")
      out.write(""""occupation":""")
      JsonEncoder.option(using JsonEncoder.string).unsafeEncode(a.occupation, indent, out)
      out.write(",")
      out.write(""""homeownerflag":""")
      JsonEncoder.option(using JsonEncoder.boolean).unsafeEncode(a.homeownerflag, indent, out)
      out.write(",")
      out.write(""""numbercarsowned":""")
      JsonEncoder.option(using JsonEncoder.int).unsafeEncode(a.numbercarsowned, indent, out)
      out.write("}")
    }
  }
}
