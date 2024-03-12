/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package unitmeasure

import adventureworks.customtypes.Defaulted
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.public.Name
import adventureworks.streamingInsert
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql
import typo.dsl.UpdateBuilder
import zio.ZIO
import zio.jdbc.SqlFragment
import zio.jdbc.SqlFragment.Segment
import zio.jdbc.UpdateResult
import zio.jdbc.ZConnection
import zio.jdbc.sqlInterpolator
import zio.stream.ZStream

class UnitmeasureRepoImpl extends UnitmeasureRepo {
  override def delete(unitmeasurecode: UnitmeasureId): ZIO[ZConnection, Throwable, Boolean] = {
    sql"""delete from production.unitmeasure where "unitmeasurecode" = ${Segment.paramSegment(unitmeasurecode)(UnitmeasureId.setter)}""".delete.map(_ > 0)
  }
  override def delete: DeleteBuilder[UnitmeasureFields, UnitmeasureRow] = {
    DeleteBuilder("production.unitmeasure", UnitmeasureFields.structure)
  }
  override def insert(unsaved: UnitmeasureRow): ZIO[ZConnection, Throwable, UnitmeasureRow] = {
    sql"""insert into production.unitmeasure("unitmeasurecode", "name", "modifieddate")
          values (${Segment.paramSegment(unsaved.unitmeasurecode)(UnitmeasureId.setter)}::bpchar, ${Segment.paramSegment(unsaved.name)(Name.setter)}::varchar, ${Segment.paramSegment(unsaved.modifieddate)(TypoLocalDateTime.setter)}::timestamp)
          returning "unitmeasurecode", "name", "modifieddate"::text
       """.insertReturning(UnitmeasureRow.jdbcDecoder).map(_.updatedKeys.head)
  }
  override def insertStreaming(unsaved: ZStream[ZConnection, Throwable, UnitmeasureRow], batchSize: Int): ZIO[ZConnection, Throwable, Long] = {
    streamingInsert(s"""COPY production.unitmeasure("unitmeasurecode", "name", "modifieddate") FROM STDIN""", batchSize, unsaved)(UnitmeasureRow.text)
  }
  override def insert(unsaved: UnitmeasureRowUnsaved): ZIO[ZConnection, Throwable, UnitmeasureRow] = {
    val fs = List(
      Some((sql""""unitmeasurecode"""", sql"${Segment.paramSegment(unsaved.unitmeasurecode)(UnitmeasureId.setter)}::bpchar")),
      Some((sql""""name"""", sql"${Segment.paramSegment(unsaved.name)(Name.setter)}::varchar")),
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((sql""""modifieddate"""", sql"${Segment.paramSegment(value: TypoLocalDateTime)(TypoLocalDateTime.setter)}::timestamp"))
      }
    ).flatten
    
    val q = if (fs.isEmpty) {
      sql"""insert into production.unitmeasure default values
            returning "unitmeasurecode", "name", "modifieddate"::text
         """
    } else {
      val names  = fs.map { case (n, _) => n }.mkFragment(SqlFragment(", "))
      val values = fs.map { case (_, f) => f }.mkFragment(SqlFragment(", "))
      sql"""insert into production.unitmeasure($names) values ($values) returning "unitmeasurecode", "name", "modifieddate"::text"""
    }
    q.insertReturning(UnitmeasureRow.jdbcDecoder).map(_.updatedKeys.head)
    
  }
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  override def insertUnsavedStreaming(unsaved: ZStream[ZConnection, Throwable, UnitmeasureRowUnsaved], batchSize: Int): ZIO[ZConnection, Throwable, Long] = {
    streamingInsert(s"""COPY production.unitmeasure("unitmeasurecode", "name", "modifieddate") FROM STDIN (DEFAULT '__DEFAULT_VALUE__')""", batchSize, unsaved)(UnitmeasureRowUnsaved.text)
  }
  override def select: SelectBuilder[UnitmeasureFields, UnitmeasureRow] = {
    SelectBuilderSql("production.unitmeasure", UnitmeasureFields.structure, UnitmeasureRow.jdbcDecoder)
  }
  override def selectAll: ZStream[ZConnection, Throwable, UnitmeasureRow] = {
    sql"""select "unitmeasurecode", "name", "modifieddate"::text from production.unitmeasure""".query(UnitmeasureRow.jdbcDecoder).selectStream
  }
  override def selectById(unitmeasurecode: UnitmeasureId): ZIO[ZConnection, Throwable, Option[UnitmeasureRow]] = {
    sql"""select "unitmeasurecode", "name", "modifieddate"::text from production.unitmeasure where "unitmeasurecode" = ${Segment.paramSegment(unitmeasurecode)(UnitmeasureId.setter)}""".query(UnitmeasureRow.jdbcDecoder).selectOne
  }
  override def selectByIds(unitmeasurecodes: Array[UnitmeasureId]): ZStream[ZConnection, Throwable, UnitmeasureRow] = {
    sql"""select "unitmeasurecode", "name", "modifieddate"::text from production.unitmeasure where "unitmeasurecode" = ANY(${Segment.paramSegment(unitmeasurecodes)(UnitmeasureId.arraySetter)})""".query(UnitmeasureRow.jdbcDecoder).selectStream
  }
  override def update(row: UnitmeasureRow): ZIO[ZConnection, Throwable, Boolean] = {
    val unitmeasurecode = row.unitmeasurecode
    sql"""update production.unitmeasure
          set "name" = ${Segment.paramSegment(row.name)(Name.setter)}::varchar,
              "modifieddate" = ${Segment.paramSegment(row.modifieddate)(TypoLocalDateTime.setter)}::timestamp
          where "unitmeasurecode" = ${Segment.paramSegment(unitmeasurecode)(UnitmeasureId.setter)}""".update.map(_ > 0)
  }
  override def update: UpdateBuilder[UnitmeasureFields, UnitmeasureRow] = {
    UpdateBuilder("production.unitmeasure", UnitmeasureFields.structure, UnitmeasureRow.jdbcDecoder)
  }
  override def upsert(unsaved: UnitmeasureRow): ZIO[ZConnection, Throwable, UpdateResult[UnitmeasureRow]] = {
    sql"""insert into production.unitmeasure("unitmeasurecode", "name", "modifieddate")
          values (
            ${Segment.paramSegment(unsaved.unitmeasurecode)(UnitmeasureId.setter)}::bpchar,
            ${Segment.paramSegment(unsaved.name)(Name.setter)}::varchar,
            ${Segment.paramSegment(unsaved.modifieddate)(TypoLocalDateTime.setter)}::timestamp
          )
          on conflict ("unitmeasurecode")
          do update set
            "name" = EXCLUDED."name",
            "modifieddate" = EXCLUDED."modifieddate"
          returning "unitmeasurecode", "name", "modifieddate"::text""".insertReturning(UnitmeasureRow.jdbcDecoder)
  }
}
