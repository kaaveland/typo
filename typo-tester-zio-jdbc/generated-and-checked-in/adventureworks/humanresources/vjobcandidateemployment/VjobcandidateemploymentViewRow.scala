/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package humanresources
package vjobcandidateemployment

import adventureworks.customtypes.TypoLocalDate
import adventureworks.humanresources.jobcandidate.JobcandidateId
import java.sql.ResultSet
import zio.jdbc.JdbcDecoder
import zio.json.JsonDecoder
import zio.json.JsonEncoder
import zio.json.ast.Json
import zio.json.internal.Write

case class VjobcandidateemploymentViewRow(
  /** Points to [[jobcandidate.JobcandidateRow.jobcandidateid]] */
  jobcandidateid: JobcandidateId,
  `Emp.StartDate`: /* nullability unknown */ Option[TypoLocalDate],
  `Emp.EndDate`: /* nullability unknown */ Option[TypoLocalDate],
  `Emp.OrgName`: /* nullability unknown */ Option[/* max 100 chars */ String],
  `Emp.JobTitle`: /* nullability unknown */ Option[/* max 100 chars */ String],
  `Emp.Responsibility`: /* nullability unknown */ Option[String],
  `Emp.FunctionCategory`: /* nullability unknown */ Option[String],
  `Emp.IndustryCategory`: /* nullability unknown */ Option[String],
  `Emp.Loc.CountryRegion`: /* nullability unknown */ Option[String],
  `Emp.Loc.State`: /* nullability unknown */ Option[String],
  `Emp.Loc.City`: /* nullability unknown */ Option[String]
)

object VjobcandidateemploymentViewRow {
  implicit lazy val jdbcDecoder: JdbcDecoder[VjobcandidateemploymentViewRow] = new JdbcDecoder[VjobcandidateemploymentViewRow] {
    override def unsafeDecode(columIndex: Int, rs: ResultSet): (Int, VjobcandidateemploymentViewRow) =
      columIndex + 10 ->
        VjobcandidateemploymentViewRow(
          jobcandidateid = JobcandidateId.jdbcDecoder.unsafeDecode(columIndex + 0, rs)._2,
          `Emp.StartDate` = JdbcDecoder.optionDecoder(TypoLocalDate.jdbcDecoder).unsafeDecode(columIndex + 1, rs)._2,
          `Emp.EndDate` = JdbcDecoder.optionDecoder(TypoLocalDate.jdbcDecoder).unsafeDecode(columIndex + 2, rs)._2,
          `Emp.OrgName` = JdbcDecoder.optionDecoder(JdbcDecoder.stringDecoder).unsafeDecode(columIndex + 3, rs)._2,
          `Emp.JobTitle` = JdbcDecoder.optionDecoder(JdbcDecoder.stringDecoder).unsafeDecode(columIndex + 4, rs)._2,
          `Emp.Responsibility` = JdbcDecoder.optionDecoder(JdbcDecoder.stringDecoder).unsafeDecode(columIndex + 5, rs)._2,
          `Emp.FunctionCategory` = JdbcDecoder.optionDecoder(JdbcDecoder.stringDecoder).unsafeDecode(columIndex + 6, rs)._2,
          `Emp.IndustryCategory` = JdbcDecoder.optionDecoder(JdbcDecoder.stringDecoder).unsafeDecode(columIndex + 7, rs)._2,
          `Emp.Loc.CountryRegion` = JdbcDecoder.optionDecoder(JdbcDecoder.stringDecoder).unsafeDecode(columIndex + 8, rs)._2,
          `Emp.Loc.State` = JdbcDecoder.optionDecoder(JdbcDecoder.stringDecoder).unsafeDecode(columIndex + 9, rs)._2,
          `Emp.Loc.City` = JdbcDecoder.optionDecoder(JdbcDecoder.stringDecoder).unsafeDecode(columIndex + 10, rs)._2
        )
  }
  implicit lazy val jsonDecoder: JsonDecoder[VjobcandidateemploymentViewRow] = JsonDecoder[Json.Obj].mapOrFail { jsonObj =>
    val jobcandidateid = jsonObj.get("jobcandidateid").toRight("Missing field 'jobcandidateid'").flatMap(_.as(JobcandidateId.jsonDecoder))
    val `Emp.StartDate` = jsonObj.get("Emp.StartDate").fold[Either[String, Option[TypoLocalDate]]](Right(None))(_.as(JsonDecoder.option(TypoLocalDate.jsonDecoder)))
    val `Emp.EndDate` = jsonObj.get("Emp.EndDate").fold[Either[String, Option[TypoLocalDate]]](Right(None))(_.as(JsonDecoder.option(TypoLocalDate.jsonDecoder)))
    val `Emp.OrgName` = jsonObj.get("Emp.OrgName").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.string)))
    val `Emp.JobTitle` = jsonObj.get("Emp.JobTitle").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.string)))
    val `Emp.Responsibility` = jsonObj.get("Emp.Responsibility").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.string)))
    val `Emp.FunctionCategory` = jsonObj.get("Emp.FunctionCategory").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.string)))
    val `Emp.IndustryCategory` = jsonObj.get("Emp.IndustryCategory").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.string)))
    val `Emp.Loc.CountryRegion` = jsonObj.get("Emp.Loc.CountryRegion").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.string)))
    val `Emp.Loc.State` = jsonObj.get("Emp.Loc.State").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.string)))
    val `Emp.Loc.City` = jsonObj.get("Emp.Loc.City").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.string)))
    if (jobcandidateid.isRight && `Emp.StartDate`.isRight && `Emp.EndDate`.isRight && `Emp.OrgName`.isRight && `Emp.JobTitle`.isRight && `Emp.Responsibility`.isRight && `Emp.FunctionCategory`.isRight && `Emp.IndustryCategory`.isRight && `Emp.Loc.CountryRegion`.isRight && `Emp.Loc.State`.isRight && `Emp.Loc.City`.isRight)
      Right(VjobcandidateemploymentViewRow(jobcandidateid = jobcandidateid.toOption.get, `Emp.StartDate` = `Emp.StartDate`.toOption.get, `Emp.EndDate` = `Emp.EndDate`.toOption.get, `Emp.OrgName` = `Emp.OrgName`.toOption.get, `Emp.JobTitle` = `Emp.JobTitle`.toOption.get, `Emp.Responsibility` = `Emp.Responsibility`.toOption.get, `Emp.FunctionCategory` = `Emp.FunctionCategory`.toOption.get, `Emp.IndustryCategory` = `Emp.IndustryCategory`.toOption.get, `Emp.Loc.CountryRegion` = `Emp.Loc.CountryRegion`.toOption.get, `Emp.Loc.State` = `Emp.Loc.State`.toOption.get, `Emp.Loc.City` = `Emp.Loc.City`.toOption.get))
    else Left(List[Either[String, Any]](jobcandidateid, `Emp.StartDate`, `Emp.EndDate`, `Emp.OrgName`, `Emp.JobTitle`, `Emp.Responsibility`, `Emp.FunctionCategory`, `Emp.IndustryCategory`, `Emp.Loc.CountryRegion`, `Emp.Loc.State`, `Emp.Loc.City`).flatMap(_.left.toOption).mkString(", "))
  }
  implicit lazy val jsonEncoder: JsonEncoder[VjobcandidateemploymentViewRow] = new JsonEncoder[VjobcandidateemploymentViewRow] {
    override def unsafeEncode(a: VjobcandidateemploymentViewRow, indent: Option[Int], out: Write): Unit = {
      out.write("{")
      out.write(""""jobcandidateid":""")
      JobcandidateId.jsonEncoder.unsafeEncode(a.jobcandidateid, indent, out)
      out.write(",")
      out.write(""""Emp.StartDate":""")
      JsonEncoder.option(TypoLocalDate.jsonEncoder).unsafeEncode(a.`Emp.StartDate`, indent, out)
      out.write(",")
      out.write(""""Emp.EndDate":""")
      JsonEncoder.option(TypoLocalDate.jsonEncoder).unsafeEncode(a.`Emp.EndDate`, indent, out)
      out.write(",")
      out.write(""""Emp.OrgName":""")
      JsonEncoder.option(JsonEncoder.string).unsafeEncode(a.`Emp.OrgName`, indent, out)
      out.write(",")
      out.write(""""Emp.JobTitle":""")
      JsonEncoder.option(JsonEncoder.string).unsafeEncode(a.`Emp.JobTitle`, indent, out)
      out.write(",")
      out.write(""""Emp.Responsibility":""")
      JsonEncoder.option(JsonEncoder.string).unsafeEncode(a.`Emp.Responsibility`, indent, out)
      out.write(",")
      out.write(""""Emp.FunctionCategory":""")
      JsonEncoder.option(JsonEncoder.string).unsafeEncode(a.`Emp.FunctionCategory`, indent, out)
      out.write(",")
      out.write(""""Emp.IndustryCategory":""")
      JsonEncoder.option(JsonEncoder.string).unsafeEncode(a.`Emp.IndustryCategory`, indent, out)
      out.write(",")
      out.write(""""Emp.Loc.CountryRegion":""")
      JsonEncoder.option(JsonEncoder.string).unsafeEncode(a.`Emp.Loc.CountryRegion`, indent, out)
      out.write(",")
      out.write(""""Emp.Loc.State":""")
      JsonEncoder.option(JsonEncoder.string).unsafeEncode(a.`Emp.Loc.State`, indent, out)
      out.write(",")
      out.write(""""Emp.Loc.City":""")
      JsonEncoder.option(JsonEncoder.string).unsafeEncode(a.`Emp.Loc.City`, indent, out)
      out.write("}")
    }
  }
}