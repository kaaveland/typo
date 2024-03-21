/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package hr
package jc

import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoXml
import adventureworks.humanresources.jobcandidate.JobcandidateId
import adventureworks.person.businessentity.BusinessentityId
import java.sql.ResultSet
import zio.jdbc.JdbcDecoder
import zio.json.JsonDecoder
import zio.json.JsonEncoder
import zio.json.ast.Json
import zio.json.internal.Write

case class JcViewRow(
  /** Points to [[humanresources.jobcandidate.JobcandidateRow.jobcandidateid]] */
  id: JobcandidateId,
  /** Points to [[humanresources.jobcandidate.JobcandidateRow.jobcandidateid]] */
  jobcandidateid: JobcandidateId,
  /** Points to [[humanresources.jobcandidate.JobcandidateRow.businessentityid]] */
  businessentityid: Option[BusinessentityId],
  /** Points to [[humanresources.jobcandidate.JobcandidateRow.resume]] */
  resume: Option[TypoXml],
  /** Points to [[humanresources.jobcandidate.JobcandidateRow.modifieddate]] */
  modifieddate: TypoLocalDateTime
)

object JcViewRow {
  implicit lazy val jdbcDecoder: JdbcDecoder[JcViewRow] = new JdbcDecoder[JcViewRow] {
    override def unsafeDecode(columIndex: Int, rs: ResultSet): (Int, JcViewRow) =
      columIndex + 4 ->
        JcViewRow(
          id = JobcandidateId.jdbcDecoder.unsafeDecode(columIndex + 0, rs)._2,
          jobcandidateid = JobcandidateId.jdbcDecoder.unsafeDecode(columIndex + 1, rs)._2,
          businessentityid = JdbcDecoder.optionDecoder(BusinessentityId.jdbcDecoder).unsafeDecode(columIndex + 2, rs)._2,
          resume = JdbcDecoder.optionDecoder(TypoXml.jdbcDecoder).unsafeDecode(columIndex + 3, rs)._2,
          modifieddate = TypoLocalDateTime.jdbcDecoder.unsafeDecode(columIndex + 4, rs)._2
        )
  }
  implicit lazy val jsonDecoder: JsonDecoder[JcViewRow] = JsonDecoder[Json.Obj].mapOrFail { jsonObj =>
    val id = jsonObj.get("id").toRight("Missing field 'id'").flatMap(_.as(JobcandidateId.jsonDecoder))
    val jobcandidateid = jsonObj.get("jobcandidateid").toRight("Missing field 'jobcandidateid'").flatMap(_.as(JobcandidateId.jsonDecoder))
    val businessentityid = jsonObj.get("businessentityid").fold[Either[String, Option[BusinessentityId]]](Right(None))(_.as(JsonDecoder.option(using BusinessentityId.jsonDecoder)))
    val resume = jsonObj.get("resume").fold[Either[String, Option[TypoXml]]](Right(None))(_.as(JsonDecoder.option(using TypoXml.jsonDecoder)))
    val modifieddate = jsonObj.get("modifieddate").toRight("Missing field 'modifieddate'").flatMap(_.as(TypoLocalDateTime.jsonDecoder))
    if (id.isRight && jobcandidateid.isRight && businessentityid.isRight && resume.isRight && modifieddate.isRight)
      Right(JcViewRow(id = id.toOption.get, jobcandidateid = jobcandidateid.toOption.get, businessentityid = businessentityid.toOption.get, resume = resume.toOption.get, modifieddate = modifieddate.toOption.get))
    else Left(List[Either[String, Any]](id, jobcandidateid, businessentityid, resume, modifieddate).flatMap(_.left.toOption).mkString(", "))
  }
  implicit lazy val jsonEncoder: JsonEncoder[JcViewRow] = new JsonEncoder[JcViewRow] {
    override def unsafeEncode(a: JcViewRow, indent: Option[Int], out: Write): Unit = {
      out.write("{")
      out.write(""""id":""")
      JobcandidateId.jsonEncoder.unsafeEncode(a.id, indent, out)
      out.write(",")
      out.write(""""jobcandidateid":""")
      JobcandidateId.jsonEncoder.unsafeEncode(a.jobcandidateid, indent, out)
      out.write(",")
      out.write(""""businessentityid":""")
      JsonEncoder.option(using BusinessentityId.jsonEncoder).unsafeEncode(a.businessentityid, indent, out)
      out.write(",")
      out.write(""""resume":""")
      JsonEncoder.option(using TypoXml.jsonEncoder).unsafeEncode(a.resume, indent, out)
      out.write(",")
      out.write(""""modifieddate":""")
      TypoLocalDateTime.jsonEncoder.unsafeEncode(a.modifieddate, indent, out)
      out.write("}")
    }
  }
}
