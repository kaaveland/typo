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

object LocationRepoImpl extends LocationRepo {
  override def delete(locationid: LocationId): ZIO[ZConnection, Throwable, Boolean] = {
    sql"""delete from production.location where "locationid" = ${Segment.paramSegment(locationid)(LocationId.setter)}""".delete.map(_ > 0)
  }
  override def delete: DeleteBuilder[LocationFields, LocationRow] = {
    DeleteBuilder("production.location", LocationFields)
  }
  override def insert(unsaved: LocationRow): ZIO[ZConnection, Throwable, LocationRow] = {
    sql"""insert into production.location("locationid", "name", "costrate", "availability", "modifieddate")
          values (${Segment.paramSegment(unsaved.locationid)(LocationId.setter)}::int4, ${Segment.paramSegment(unsaved.name)(Name.setter)}::varchar, ${Segment.paramSegment(unsaved.costrate)(Setter.bigDecimalScalaSetter)}::numeric, ${Segment.paramSegment(unsaved.availability)(Setter.bigDecimalScalaSetter)}::numeric, ${Segment.paramSegment(unsaved.modifieddate)(TypoLocalDateTime.setter)}::timestamp)
          returning "locationid", "name", "costrate", "availability", "modifieddate"::text
       """.insertReturning(LocationRow.jdbcDecoder).map(_.updatedKeys.head)
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
    q.insertReturning(LocationRow.jdbcDecoder).map(_.updatedKeys.head)
    
  }
  override def select: SelectBuilder[LocationFields, LocationRow] = {
    SelectBuilderSql("production.location", LocationFields, LocationRow.jdbcDecoder)
  }
  override def selectAll: ZStream[ZConnection, Throwable, LocationRow] = {
    sql"""select "locationid", "name", "costrate", "availability", "modifieddate"::text from production.location""".query(LocationRow.jdbcDecoder).selectStream
  }
  override def selectById(locationid: LocationId): ZIO[ZConnection, Throwable, Option[LocationRow]] = {
    sql"""select "locationid", "name", "costrate", "availability", "modifieddate"::text from production.location where "locationid" = ${Segment.paramSegment(locationid)(LocationId.setter)}""".query(LocationRow.jdbcDecoder).selectOne
  }
  override def selectByIds(locationids: Array[LocationId]): ZStream[ZConnection, Throwable, LocationRow] = {
    sql"""select "locationid", "name", "costrate", "availability", "modifieddate"::text from production.location where "locationid" = ANY(${Segment.paramSegment(locationids)(LocationId.arraySetter)})""".query(LocationRow.jdbcDecoder).selectStream
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
  override def update: UpdateBuilder[LocationFields, LocationRow] = {
    UpdateBuilder("production.location", LocationFields, LocationRow.jdbcDecoder)
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
          returning "locationid", "name", "costrate", "availability", "modifieddate"::text""".insertReturning(LocationRow.jdbcDecoder)
  }
}