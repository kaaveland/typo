/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package humanresources
package jobcandidate

import adventureworks.customtypes.Defaulted
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoXml
import adventureworks.person.businessentity.BusinessentityId
import adventureworks.streamingInsert
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql
import typo.dsl.UpdateBuilder
import zio.ZIO
import zio.jdbc.SqlFragment
import zio.jdbc.SqlFragment.Segment
import zio.jdbc.SqlFragment.Setter
import zio.jdbc.UpdateResult
import zio.jdbc.ZConnection
import zio.jdbc.sqlInterpolator
import zio.stream.ZStream

class JobcandidateRepoImpl extends JobcandidateRepo {
  override def delete(jobcandidateid: JobcandidateId): ZIO[ZConnection, Throwable, Boolean] = {
    sql"""delete from humanresources.jobcandidate where "jobcandidateid" = ${Segment.paramSegment(jobcandidateid)(JobcandidateId.setter)}""".delete.map(_ > 0)
  }
  override def delete: DeleteBuilder[JobcandidateFields, JobcandidateRow] = {
    DeleteBuilder("humanresources.jobcandidate", JobcandidateFields.structure)
  }
  override def insert(unsaved: JobcandidateRow): ZIO[ZConnection, Throwable, JobcandidateRow] = {
    sql"""insert into humanresources.jobcandidate("jobcandidateid", "businessentityid", "resume", "modifieddate")
          values (${Segment.paramSegment(unsaved.jobcandidateid)(JobcandidateId.setter)}::int4, ${Segment.paramSegment(unsaved.businessentityid)(Setter.optionParamSetter(BusinessentityId.setter))}::int4, ${Segment.paramSegment(unsaved.resume)(Setter.optionParamSetter(TypoXml.setter))}::xml, ${Segment.paramSegment(unsaved.modifieddate)(TypoLocalDateTime.setter)}::timestamp)
          returning "jobcandidateid", "businessentityid", "resume", "modifieddate"::text
       """.insertReturning(JobcandidateRow.jdbcDecoder).map(_.updatedKeys.head)
  }
  override def insertStreaming(unsaved: ZStream[ZConnection, Throwable, JobcandidateRow], batchSize: Int): ZIO[ZConnection, Throwable, Long] = {
    streamingInsert(s"""COPY humanresources.jobcandidate("jobcandidateid", "businessentityid", "resume", "modifieddate") FROM STDIN""", batchSize, unsaved)(JobcandidateRow.text)
  }
  override def insert(unsaved: JobcandidateRowUnsaved): ZIO[ZConnection, Throwable, JobcandidateRow] = {
    val fs = List(
      Some((sql""""businessentityid"""", sql"${Segment.paramSegment(unsaved.businessentityid)(Setter.optionParamSetter(BusinessentityId.setter))}::int4")),
      Some((sql""""resume"""", sql"${Segment.paramSegment(unsaved.resume)(Setter.optionParamSetter(TypoXml.setter))}::xml")),
      unsaved.jobcandidateid match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((sql""""jobcandidateid"""", sql"${Segment.paramSegment(value: JobcandidateId)(JobcandidateId.setter)}::int4"))
      },
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((sql""""modifieddate"""", sql"${Segment.paramSegment(value: TypoLocalDateTime)(TypoLocalDateTime.setter)}::timestamp"))
      }
    ).flatten
    
    val q = if (fs.isEmpty) {
      sql"""insert into humanresources.jobcandidate default values
            returning "jobcandidateid", "businessentityid", "resume", "modifieddate"::text
         """
    } else {
      val names  = fs.map { case (n, _) => n }.mkFragment(SqlFragment(", "))
      val values = fs.map { case (_, f) => f }.mkFragment(SqlFragment(", "))
      sql"""insert into humanresources.jobcandidate($names) values ($values) returning "jobcandidateid", "businessentityid", "resume", "modifieddate"::text"""
    }
    q.insertReturning(JobcandidateRow.jdbcDecoder).map(_.updatedKeys.head)
    
  }
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  override def insertUnsavedStreaming(unsaved: ZStream[ZConnection, Throwable, JobcandidateRowUnsaved], batchSize: Int): ZIO[ZConnection, Throwable, Long] = {
    streamingInsert(s"""COPY humanresources.jobcandidate("businessentityid", "resume", "jobcandidateid", "modifieddate") FROM STDIN (DEFAULT '__DEFAULT_VALUE__')""", batchSize, unsaved)(JobcandidateRowUnsaved.text)
  }
  override def select: SelectBuilder[JobcandidateFields, JobcandidateRow] = {
    SelectBuilderSql("humanresources.jobcandidate", JobcandidateFields.structure, JobcandidateRow.jdbcDecoder)
  }
  override def selectAll: ZStream[ZConnection, Throwable, JobcandidateRow] = {
    sql"""select "jobcandidateid", "businessentityid", "resume", "modifieddate"::text from humanresources.jobcandidate""".query(JobcandidateRow.jdbcDecoder).selectStream
  }
  override def selectById(jobcandidateid: JobcandidateId): ZIO[ZConnection, Throwable, Option[JobcandidateRow]] = {
    sql"""select "jobcandidateid", "businessentityid", "resume", "modifieddate"::text from humanresources.jobcandidate where "jobcandidateid" = ${Segment.paramSegment(jobcandidateid)(JobcandidateId.setter)}""".query(JobcandidateRow.jdbcDecoder).selectOne
  }
  override def selectByIds(jobcandidateids: Array[JobcandidateId]): ZStream[ZConnection, Throwable, JobcandidateRow] = {
    sql"""select "jobcandidateid", "businessentityid", "resume", "modifieddate"::text from humanresources.jobcandidate where "jobcandidateid" = ANY(${Segment.paramSegment(jobcandidateids)(JobcandidateId.arraySetter)})""".query(JobcandidateRow.jdbcDecoder).selectStream
  }
  override def update(row: JobcandidateRow): ZIO[ZConnection, Throwable, Boolean] = {
    val jobcandidateid = row.jobcandidateid
    sql"""update humanresources.jobcandidate
          set "businessentityid" = ${Segment.paramSegment(row.businessentityid)(Setter.optionParamSetter(BusinessentityId.setter))}::int4,
              "resume" = ${Segment.paramSegment(row.resume)(Setter.optionParamSetter(TypoXml.setter))}::xml,
              "modifieddate" = ${Segment.paramSegment(row.modifieddate)(TypoLocalDateTime.setter)}::timestamp
          where "jobcandidateid" = ${Segment.paramSegment(jobcandidateid)(JobcandidateId.setter)}""".update.map(_ > 0)
  }
  override def update: UpdateBuilder[JobcandidateFields, JobcandidateRow] = {
    UpdateBuilder("humanresources.jobcandidate", JobcandidateFields.structure, JobcandidateRow.jdbcDecoder)
  }
  override def upsert(unsaved: JobcandidateRow): ZIO[ZConnection, Throwable, UpdateResult[JobcandidateRow]] = {
    sql"""insert into humanresources.jobcandidate("jobcandidateid", "businessentityid", "resume", "modifieddate")
          values (
            ${Segment.paramSegment(unsaved.jobcandidateid)(JobcandidateId.setter)}::int4,
            ${Segment.paramSegment(unsaved.businessentityid)(Setter.optionParamSetter(BusinessentityId.setter))}::int4,
            ${Segment.paramSegment(unsaved.resume)(Setter.optionParamSetter(TypoXml.setter))}::xml,
            ${Segment.paramSegment(unsaved.modifieddate)(TypoLocalDateTime.setter)}::timestamp
          )
          on conflict ("jobcandidateid")
          do update set
            "businessentityid" = EXCLUDED."businessentityid",
            "resume" = EXCLUDED."resume",
            "modifieddate" = EXCLUDED."modifieddate"
          returning "jobcandidateid", "businessentityid", "resume", "modifieddate"::text""".insertReturning(JobcandidateRow.jdbcDecoder)
  }
}
