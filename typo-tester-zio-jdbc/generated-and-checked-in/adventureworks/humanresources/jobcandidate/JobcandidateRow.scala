/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package humanresources
package jobcandidate

import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoXml
import adventureworks.person.businessentity.BusinessentityId
import java.sql.ResultSet
import zio.jdbc.JdbcDecoder
import zio.json.JsonDecoder
import zio.json.JsonEncoder
import zio.json.ast.Json
import zio.json.internal.Write

case class JobcandidateRow(
  /** Primary key for JobCandidate records. */
  jobcandidateid: JobcandidateId,
  /** Employee identification number if applicant was hired. Foreign key to Employee.BusinessEntityID.
      Points to [[employee.EmployeeRow.businessentityid]] */
  businessentityid: Option[BusinessentityId],
  /** RÃ©sumÃ© in XML format. */
  resume: Option[TypoXml],
  modifieddate: TypoLocalDateTime
)

object JobcandidateRow {
  implicit lazy val jdbcDecoder: JdbcDecoder[JobcandidateRow] = new JdbcDecoder[JobcandidateRow] {
    override def unsafeDecode(columIndex: Int, rs: ResultSet): (Int, JobcandidateRow) =
      columIndex + 3 ->
        JobcandidateRow(
          jobcandidateid = JobcandidateId.jdbcDecoder.unsafeDecode(columIndex + 0, rs)._2,
          businessentityid = JdbcDecoder.optionDecoder(BusinessentityId.jdbcDecoder).unsafeDecode(columIndex + 1, rs)._2,
          resume = JdbcDecoder.optionDecoder(TypoXml.jdbcDecoder).unsafeDecode(columIndex + 2, rs)._2,
          modifieddate = TypoLocalDateTime.jdbcDecoder.unsafeDecode(columIndex + 3, rs)._2
        )
  }
  implicit lazy val jsonDecoder: JsonDecoder[JobcandidateRow] = JsonDecoder[Json.Obj].mapOrFail { jsonObj =>
    val jobcandidateid = jsonObj.get("jobcandidateid").toRight("Missing field 'jobcandidateid'").flatMap(_.as(JobcandidateId.jsonDecoder))
    val businessentityid = jsonObj.get("businessentityid").fold[Either[String, Option[BusinessentityId]]](Right(None))(_.as(JsonDecoder.option(BusinessentityId.jsonDecoder)))
    val resume = jsonObj.get("resume").fold[Either[String, Option[TypoXml]]](Right(None))(_.as(JsonDecoder.option(TypoXml.jsonDecoder)))
    val modifieddate = jsonObj.get("modifieddate").toRight("Missing field 'modifieddate'").flatMap(_.as(TypoLocalDateTime.jsonDecoder))
    if (jobcandidateid.isRight && businessentityid.isRight && resume.isRight && modifieddate.isRight)
      Right(JobcandidateRow(jobcandidateid = jobcandidateid.toOption.get, businessentityid = businessentityid.toOption.get, resume = resume.toOption.get, modifieddate = modifieddate.toOption.get))
    else Left(List[Either[String, Any]](jobcandidateid, businessentityid, resume, modifieddate).flatMap(_.left.toOption).mkString(", "))
  }
  implicit lazy val jsonEncoder: JsonEncoder[JobcandidateRow] = new JsonEncoder[JobcandidateRow] {
    override def unsafeEncode(a: JobcandidateRow, indent: Option[Int], out: Write): Unit = {
      out.write("{")
      out.write(""""jobcandidateid":""")
      JobcandidateId.jsonEncoder.unsafeEncode(a.jobcandidateid, indent, out)
      out.write(",")
      out.write(""""businessentityid":""")
      JsonEncoder.option(BusinessentityId.jsonEncoder).unsafeEncode(a.businessentityid, indent, out)
      out.write(",")
      out.write(""""resume":""")
      JsonEncoder.option(TypoXml.jsonEncoder).unsafeEncode(a.resume, indent, out)
      out.write(",")
      out.write(""""modifieddate":""")
      TypoLocalDateTime.jsonEncoder.unsafeEncode(a.modifieddate, indent, out)
      out.write("}")
    }
  }
}
