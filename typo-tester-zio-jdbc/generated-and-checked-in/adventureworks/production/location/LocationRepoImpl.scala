/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package location

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
import zio.jdbc.SqlFragment.Setter
import zio.jdbc.UpdateResult
import zio.jdbc.ZConnection
import zio.jdbc.sqlInterpolator
import zio.stream.ZStream

class LocationRepoImpl extends LocationRepo {
  override def delete: DeleteBuilder[LocationFields, LocationRow] = {
    DeleteBuilder("production.location", LocationFields.structure)
  }
  override def deleteById(locationid: LocationId): ZIO[ZConnection, Throwable, Boolean] = {
    sql"""delete from production.location where "locationid" = ${Segment.paramSegment(locationid)(LocationId.setter)}""".delete.map(_ > 0)
  }
  override def deleteByIds(locationids: Array[LocationId]): ZIO[ZConnection, Throwable, Long] = {
    sql"""delete from production.location where "locationid" = ANY(${locationids})""".delete
  }
  override def insert(unsaved: LocationRow): ZIO[ZConnection, Throwable, LocationRow] = {
    sql"""insert into production.location("locationid", "name", "costrate", "availability", "modifieddate")
          values (${Segment.paramSegment(unsaved.locationid)(LocationId.setter)}::int4, ${Segment.paramSegment(unsaved.name)(Name.setter)}::varchar, ${Segment.paramSegment(unsaved.costrate)(Setter.bigDecimalScalaSetter)}::numeric, ${Segment.paramSegment(unsaved.availability)(Setter.bigDecimalScalaSetter)}::numeric, ${Segment.paramSegment(unsaved.modifieddate)(TypoLocalDateTime.setter)}::timestamp)
          returning "locationid", "name", "costrate", "availability", "modifieddate"::text
       """.insertReturning(using LocationRow.jdbcDecoder).map(_.updatedKeys.head)
  }
  override def insert(unsaved: LocationRowUnsaved): ZIO[ZConnection, Throwable, LocationRow] = {
    val fs = List(
      Some((sql""""name"""", sql"${Segment.paramSegment(unsaved.name)(Name.setter)}::varchar")),
      unsaved.locationid match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((sql""""locationid"""", sql"${Segment.paramSegment(value: LocationId)(LocationId.setter)}::int4"))
      },
      unsaved.costrate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((sql""""costrate"""", sql"${Segment.paramSegment(value: BigDecimal)(Setter.bigDecimalScalaSetter)}::numeric"))
      },
      unsaved.availability match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((sql""""availability"""", sql"${Segment.paramSegment(value: BigDecimal)(Setter.bigDecimalScalaSetter)}::numeric"))
      },
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((sql""""modifieddate"""", sql"${Segment.paramSegment(value: TypoLocalDateTime)(TypoLocalDateTime.setter)}::timestamp"))
      }
    ).flatten
    
    val q = if (fs.isEmpty) {
      sql"""insert into production.location default values
            returning "locationid", "name", "costrate", "availability", "modifieddate"::text
         """
    } else {
      val names  = fs.map { case (n, _) => n }.mkFragment(SqlFragment(", "))
      val values = fs.map { case (_, f) => f }.mkFragment(SqlFragment(", "))
      sql"""insert into production.location($names) values ($values) returning "locationid", "name", "costrate", "availability", "modifieddate"::text"""
    }
    q.insertReturning(using LocationRow.jdbcDecoder).map(_.updatedKeys.head)
    
  }
  override def insertStreaming(unsaved: ZStream[ZConnection, Throwable, LocationRow], batchSize: Int = 10000): ZIO[ZConnection, Throwable, Long] = {
    streamingInsert(s"""COPY production.location("locationid", "name", "costrate", "availability", "modifieddate") FROM STDIN""", batchSize, unsaved)(LocationRow.text)
  }
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  override def insertUnsavedStreaming(unsaved: ZStream[ZConnection, Throwable, LocationRowUnsaved], batchSize: Int = 10000): ZIO[ZConnection, Throwable, Long] = {
    streamingInsert(s"""COPY production.location("name", "locationid", "costrate", "availability", "modifieddate") FROM STDIN (DEFAULT '__DEFAULT_VALUE__')""", batchSize, unsaved)(LocationRowUnsaved.text)
  }
  override def select: SelectBuilder[LocationFields, LocationRow] = {
    SelectBuilderSql("production.location", LocationFields.structure, LocationRow.jdbcDecoder)
  }
  override def selectAll: ZStream[ZConnection, Throwable, LocationRow] = {
    sql"""select "locationid", "name", "costrate", "availability", "modifieddate"::text from production.location""".query(using LocationRow.jdbcDecoder).selectStream()
  }
  override def selectById(locationid: LocationId): ZIO[ZConnection, Throwable, Option[LocationRow]] = {
    sql"""select "locationid", "name", "costrate", "availability", "modifieddate"::text from production.location where "locationid" = ${Segment.paramSegment(locationid)(LocationId.setter)}""".query(using LocationRow.jdbcDecoder).selectOne
  }
  override def selectByIds(locationids: Array[LocationId]): ZStream[ZConnection, Throwable, LocationRow] = {
    sql"""select "locationid", "name", "costrate", "availability", "modifieddate"::text from production.location where "locationid" = ANY(${Segment.paramSegment(locationids)(LocationId.arraySetter)})""".query(using LocationRow.jdbcDecoder).selectStream()
  }
  override def selectByIdsTracked(locationids: Array[LocationId]): ZIO[ZConnection, Throwable, Map[LocationId, LocationRow]] = {
    selectByIds(locationids).runCollect.map { rows =>
      val byId = rows.view.map(x => (x.locationid, x)).toMap
      locationids.view.flatMap(id => byId.get(id).map(x => (id, x))).toMap
    }
  }
  override def update: UpdateBuilder[LocationFields, LocationRow] = {
    UpdateBuilder("production.location", LocationFields.structure, LocationRow.jdbcDecoder)
  }
  override def update(row: LocationRow): ZIO[ZConnection, Throwable, Boolean] = {
    val locationid = row.locationid
    sql"""update production.location
          set "name" = ${Segment.paramSegment(row.name)(Name.setter)}::varchar,
              "costrate" = ${Segment.paramSegment(row.costrate)(Setter.bigDecimalScalaSetter)}::numeric,
              "availability" = ${Segment.paramSegment(row.availability)(Setter.bigDecimalScalaSetter)}::numeric,
              "modifieddate" = ${Segment.paramSegment(row.modifieddate)(TypoLocalDateTime.setter)}::timestamp
          where "locationid" = ${Segment.paramSegment(locationid)(LocationId.setter)}""".update.map(_ > 0)
  }
  override def upsert(unsaved: LocationRow): ZIO[ZConnection, Throwable, UpdateResult[LocationRow]] = {
    sql"""insert into production.location("locationid", "name", "costrate", "availability", "modifieddate")
          values (
            ${Segment.paramSegment(unsaved.locationid)(LocationId.setter)}::int4,
            ${Segment.paramSegment(unsaved.name)(Name.setter)}::varchar,
            ${Segment.paramSegment(unsaved.costrate)(Setter.bigDecimalScalaSetter)}::numeric,
            ${Segment.paramSegment(unsaved.availability)(Setter.bigDecimalScalaSetter)}::numeric,
            ${Segment.paramSegment(unsaved.modifieddate)(TypoLocalDateTime.setter)}::timestamp
          )
          on conflict ("locationid")
          do update set
            "name" = EXCLUDED."name",
            "costrate" = EXCLUDED."costrate",
            "availability" = EXCLUDED."availability",
            "modifieddate" = EXCLUDED."modifieddate"
          returning "locationid", "name", "costrate", "availability", "modifieddate"::text""".insertReturning(using LocationRow.jdbcDecoder)
  }
}
