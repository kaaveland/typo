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
import doobie.enumerated.Nullability
import doobie.util.Read
import doobie.util.meta.Meta
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet

case class JcViewRow(
  id: Int,
  /** Points to [[humanresources.jobcandidate.JobcandidateRow.jobcandidateid]] */
  jobcandidateid: JobcandidateId,
  /** Points to [[humanresources.jobcandidate.JobcandidateRow.businessentityid]] */
  businessentityid: BusinessentityId,
  /** Points to [[humanresources.jobcandidate.JobcandidateRow.resume]] */
  resume: TypoXml,
  /** Points to [[humanresources.jobcandidate.JobcandidateRow.modifieddate]] */
  modifieddate: TypoLocalDateTime
)

object JcViewRow {
  implicit lazy val decoder: Decoder[JcViewRow] = Decoder.forProduct5[JcViewRow, Int, JobcandidateId, BusinessentityId, TypoXml, TypoLocalDateTime]("id", "jobcandidateid", "businessentityid", "resume", "modifieddate")(JcViewRow.apply)(Decoder.decodeInt, JobcandidateId.decoder, BusinessentityId.decoder, TypoXml.decoder, TypoLocalDateTime.decoder)
  implicit lazy val encoder: Encoder[JcViewRow] = Encoder.forProduct5[JcViewRow, Int, JobcandidateId, BusinessentityId, TypoXml, TypoLocalDateTime]("id", "jobcandidateid", "businessentityid", "resume", "modifieddate")(x => (x.id, x.jobcandidateid, x.businessentityid, x.resume, x.modifieddate))(Encoder.encodeInt, JobcandidateId.encoder, BusinessentityId.encoder, TypoXml.encoder, TypoLocalDateTime.encoder)
  implicit lazy val read: Read[JcViewRow] = new Read[JcViewRow](
    gets = List(
      (Meta.IntMeta.get, Nullability.NoNulls),
      (JobcandidateId.get, Nullability.NoNulls),
      (BusinessentityId.get, Nullability.NoNulls),
      (TypoXml.get, Nullability.NoNulls),
      (TypoLocalDateTime.get, Nullability.NoNulls)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => JcViewRow(
      id = Meta.IntMeta.get.unsafeGetNonNullable(rs, i + 0),
      jobcandidateid = JobcandidateId.get.unsafeGetNonNullable(rs, i + 1),
      businessentityid = BusinessentityId.get.unsafeGetNonNullable(rs, i + 2),
      resume = TypoXml.get.unsafeGetNonNullable(rs, i + 3),
      modifieddate = TypoLocalDateTime.get.unsafeGetNonNullable(rs, i + 4)
    )
  )
}
