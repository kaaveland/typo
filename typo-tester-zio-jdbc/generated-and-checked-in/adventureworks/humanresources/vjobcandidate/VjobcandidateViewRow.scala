/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package humanresources
package vjobcandidate

import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.humanresources.jobcandidate.JobcandidateId
import adventureworks.person.businessentity.BusinessentityId
import java.sql.ResultSet
import zio.jdbc.JdbcDecoder
import zio.json.JsonDecoder
import zio.json.JsonEncoder
import zio.json.ast.Json
import zio.json.internal.Write

case class VjobcandidateViewRow(
  /** Points to [[jobcandidate.JobcandidateRow.jobcandidateid]] */
  jobcandidateid: JobcandidateId,
  /** Points to [[jobcandidate.JobcandidateRow.businessentityid]] */
  businessentityid: Option[BusinessentityId],
  `Name.Prefix`: /* nullability unknown */ Option[/* max 30 chars */ String],
  `Name.First`: /* nullability unknown */ Option[/* max 30 chars */ String],
  `Name.Middle`: /* nullability unknown */ Option[/* max 30 chars */ String],
  `Name.Last`: /* nullability unknown */ Option[/* max 30 chars */ String],
  `Name.Suffix`: /* nullability unknown */ Option[/* max 30 chars */ String],
  Skills: /* nullability unknown */ Option[String],
  `Addr.Type`: /* nullability unknown */ Option[/* max 30 chars */ String],
  `Addr.Loc.CountryRegion`: /* nullability unknown */ Option[/* max 100 chars */ String],
  `Addr.Loc.State`: /* nullability unknown */ Option[/* max 100 chars */ String],
  `Addr.Loc.City`: /* nullability unknown */ Option[/* max 100 chars */ String],
  `Addr.PostalCode`: /* nullability unknown */ Option[/* max 20 chars */ String],
  EMail: /* nullability unknown */ Option[String],
  WebSite: /* nullability unknown */ Option[String],
  /** Points to [[jobcandidate.JobcandidateRow.modifieddate]] */
  modifieddate: TypoLocalDateTime
)

object VjobcandidateViewRow {
  implicit lazy val jdbcDecoder: JdbcDecoder[VjobcandidateViewRow] = new JdbcDecoder[VjobcandidateViewRow] {
    override def unsafeDecode(columIndex: Int, rs: ResultSet): (Int, VjobcandidateViewRow) =
      columIndex + 15 ->
        VjobcandidateViewRow(
          jobcandidateid = JobcandidateId.jdbcDecoder.unsafeDecode(columIndex + 0, rs)._2,
          businessentityid = JdbcDecoder.optionDecoder(BusinessentityId.jdbcDecoder).unsafeDecode(columIndex + 1, rs)._2,
          `Name.Prefix` = JdbcDecoder.optionDecoder(JdbcDecoder.stringDecoder).unsafeDecode(columIndex + 2, rs)._2,
          `Name.First` = JdbcDecoder.optionDecoder(JdbcDecoder.stringDecoder).unsafeDecode(columIndex + 3, rs)._2,
          `Name.Middle` = JdbcDecoder.optionDecoder(JdbcDecoder.stringDecoder).unsafeDecode(columIndex + 4, rs)._2,
          `Name.Last` = JdbcDecoder.optionDecoder(JdbcDecoder.stringDecoder).unsafeDecode(columIndex + 5, rs)._2,
          `Name.Suffix` = JdbcDecoder.optionDecoder(JdbcDecoder.stringDecoder).unsafeDecode(columIndex + 6, rs)._2,
          Skills = JdbcDecoder.optionDecoder(JdbcDecoder.stringDecoder).unsafeDecode(columIndex + 7, rs)._2,
          `Addr.Type` = JdbcDecoder.optionDecoder(JdbcDecoder.stringDecoder).unsafeDecode(columIndex + 8, rs)._2,
          `Addr.Loc.CountryRegion` = JdbcDecoder.optionDecoder(JdbcDecoder.stringDecoder).unsafeDecode(columIndex + 9, rs)._2,
          `Addr.Loc.State` = JdbcDecoder.optionDecoder(JdbcDecoder.stringDecoder).unsafeDecode(columIndex + 10, rs)._2,
          `Addr.Loc.City` = JdbcDecoder.optionDecoder(JdbcDecoder.stringDecoder).unsafeDecode(columIndex + 11, rs)._2,
          `Addr.PostalCode` = JdbcDecoder.optionDecoder(JdbcDecoder.stringDecoder).unsafeDecode(columIndex + 12, rs)._2,
          EMail = JdbcDecoder.optionDecoder(JdbcDecoder.stringDecoder).unsafeDecode(columIndex + 13, rs)._2,
          WebSite = JdbcDecoder.optionDecoder(JdbcDecoder.stringDecoder).unsafeDecode(columIndex + 14, rs)._2,
          modifieddate = TypoLocalDateTime.jdbcDecoder.unsafeDecode(columIndex + 15, rs)._2
        )
  }
  implicit lazy val jsonDecoder: JsonDecoder[VjobcandidateViewRow] = JsonDecoder[Json.Obj].mapOrFail { jsonObj =>
    val jobcandidateid = jsonObj.get("jobcandidateid").toRight("Missing field 'jobcandidateid'").flatMap(_.as(JobcandidateId.jsonDecoder))
    val businessentityid = jsonObj.get("businessentityid").fold[Either[String, Option[BusinessentityId]]](Right(None))(_.as(JsonDecoder.option(BusinessentityId.jsonDecoder)))
    val `Name.Prefix` = jsonObj.get("Name.Prefix").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.string)))
    val `Name.First` = jsonObj.get("Name.First").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.string)))
    val `Name.Middle` = jsonObj.get("Name.Middle").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.string)))
    val `Name.Last` = jsonObj.get("Name.Last").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.string)))
    val `Name.Suffix` = jsonObj.get("Name.Suffix").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.string)))
    val Skills = jsonObj.get("Skills").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.string)))
    val `Addr.Type` = jsonObj.get("Addr.Type").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.string)))
    val `Addr.Loc.CountryRegion` = jsonObj.get("Addr.Loc.CountryRegion").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.string)))
    val `Addr.Loc.State` = jsonObj.get("Addr.Loc.State").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.string)))
    val `Addr.Loc.City` = jsonObj.get("Addr.Loc.City").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.string)))
    val `Addr.PostalCode` = jsonObj.get("Addr.PostalCode").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.string)))
    val EMail = jsonObj.get("EMail").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.string)))
    val WebSite = jsonObj.get("WebSite").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.string)))
    val modifieddate = jsonObj.get("modifieddate").toRight("Missing field 'modifieddate'").flatMap(_.as(TypoLocalDateTime.jsonDecoder))
    if (jobcandidateid.isRight && businessentityid.isRight && `Name.Prefix`.isRight && `Name.First`.isRight && `Name.Middle`.isRight && `Name.Last`.isRight && `Name.Suffix`.isRight && Skills.isRight && `Addr.Type`.isRight && `Addr.Loc.CountryRegion`.isRight && `Addr.Loc.State`.isRight && `Addr.Loc.City`.isRight && `Addr.PostalCode`.isRight && EMail.isRight && WebSite.isRight && modifieddate.isRight)
      Right(VjobcandidateViewRow(jobcandidateid = jobcandidateid.toOption.get, businessentityid = businessentityid.toOption.get, `Name.Prefix` = `Name.Prefix`.toOption.get, `Name.First` = `Name.First`.toOption.get, `Name.Middle` = `Name.Middle`.toOption.get, `Name.Last` = `Name.Last`.toOption.get, `Name.Suffix` = `Name.Suffix`.toOption.get, Skills = Skills.toOption.get, `Addr.Type` = `Addr.Type`.toOption.get, `Addr.Loc.CountryRegion` = `Addr.Loc.CountryRegion`.toOption.get, `Addr.Loc.State` = `Addr.Loc.State`.toOption.get, `Addr.Loc.City` = `Addr.Loc.City`.toOption.get, `Addr.PostalCode` = `Addr.PostalCode`.toOption.get, EMail = EMail.toOption.get, WebSite = WebSite.toOption.get, modifieddate = modifieddate.toOption.get))
    else Left(List[Either[String, Any]](jobcandidateid, businessentityid, `Name.Prefix`, `Name.First`, `Name.Middle`, `Name.Last`, `Name.Suffix`, Skills, `Addr.Type`, `Addr.Loc.CountryRegion`, `Addr.Loc.State`, `Addr.Loc.City`, `Addr.PostalCode`, EMail, WebSite, modifieddate).flatMap(_.left.toOption).mkString(", "))
  }
  implicit lazy val jsonEncoder: JsonEncoder[VjobcandidateViewRow] = new JsonEncoder[VjobcandidateViewRow] {
    override def unsafeEncode(a: VjobcandidateViewRow, indent: Option[Int], out: Write): Unit = {
      out.write("{")
      out.write(""""jobcandidateid":""")
      JobcandidateId.jsonEncoder.unsafeEncode(a.jobcandidateid, indent, out)
      out.write(",")
      out.write(""""businessentityid":""")
      JsonEncoder.option(BusinessentityId.jsonEncoder).unsafeEncode(a.businessentityid, indent, out)
      out.write(",")
      out.write(""""Name.Prefix":""")
      JsonEncoder.option(JsonEncoder.string).unsafeEncode(a.`Name.Prefix`, indent, out)
      out.write(",")
      out.write(""""Name.First":""")
      JsonEncoder.option(JsonEncoder.string).unsafeEncode(a.`Name.First`, indent, out)
      out.write(",")
      out.write(""""Name.Middle":""")
      JsonEncoder.option(JsonEncoder.string).unsafeEncode(a.`Name.Middle`, indent, out)
      out.write(",")
      out.write(""""Name.Last":""")
      JsonEncoder.option(JsonEncoder.string).unsafeEncode(a.`Name.Last`, indent, out)
      out.write(",")
      out.write(""""Name.Suffix":""")
      JsonEncoder.option(JsonEncoder.string).unsafeEncode(a.`Name.Suffix`, indent, out)
      out.write(",")
      out.write(""""Skills":""")
      JsonEncoder.option(JsonEncoder.string).unsafeEncode(a.Skills, indent, out)
      out.write(",")
      out.write(""""Addr.Type":""")
      JsonEncoder.option(JsonEncoder.string).unsafeEncode(a.`Addr.Type`, indent, out)
      out.write(",")
      out.write(""""Addr.Loc.CountryRegion":""")
      JsonEncoder.option(JsonEncoder.string).unsafeEncode(a.`Addr.Loc.CountryRegion`, indent, out)
      out.write(",")
      out.write(""""Addr.Loc.State":""")
      JsonEncoder.option(JsonEncoder.string).unsafeEncode(a.`Addr.Loc.State`, indent, out)
      out.write(",")
      out.write(""""Addr.Loc.City":""")
      JsonEncoder.option(JsonEncoder.string).unsafeEncode(a.`Addr.Loc.City`, indent, out)
      out.write(",")
      out.write(""""Addr.PostalCode":""")
      JsonEncoder.option(JsonEncoder.string).unsafeEncode(a.`Addr.PostalCode`, indent, out)
      out.write(",")
      out.write(""""EMail":""")
      JsonEncoder.option(JsonEncoder.string).unsafeEncode(a.EMail, indent, out)
      out.write(",")
      out.write(""""WebSite":""")
      JsonEncoder.option(JsonEncoder.string).unsafeEncode(a.WebSite, indent, out)
      out.write(",")
      out.write(""""modifieddate":""")
      TypoLocalDateTime.jsonEncoder.unsafeEncode(a.modifieddate, indent, out)
      out.write("}")
    }
  }
}
