/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package humanresources
package employeedepartmenthistory

import adventureworks.customtypes.Defaulted
import adventureworks.customtypes.TypoLocalDate
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.humanresources.department.DepartmentId
import adventureworks.humanresources.shift.ShiftId
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

class EmployeedepartmenthistoryRepoImpl extends EmployeedepartmenthistoryRepo {
  override def delete: DeleteBuilder[EmployeedepartmenthistoryFields, EmployeedepartmenthistoryRow] = {
    DeleteBuilder("humanresources.employeedepartmenthistory", EmployeedepartmenthistoryFields.structure)
  }
  override def deleteById(compositeId: EmployeedepartmenthistoryId): ZIO[ZConnection, Throwable, Boolean] = {
    sql"""delete from humanresources.employeedepartmenthistory where "businessentityid" = ${Segment.paramSegment(compositeId.businessentityid)(BusinessentityId.setter)} AND "startdate" = ${Segment.paramSegment(compositeId.startdate)(TypoLocalDate.setter)} AND "departmentid" = ${Segment.paramSegment(compositeId.departmentid)(DepartmentId.setter)} AND "shiftid" = ${Segment.paramSegment(compositeId.shiftid)(ShiftId.setter)}""".delete.map(_ > 0)
  }
  override def deleteByIds(compositeIds: Array[EmployeedepartmenthistoryId]): ZIO[ZConnection, Throwable, Long] = {
    val businessentityid = compositeIds.map(_.businessentityid)
    val startdate = compositeIds.map(_.startdate)
    val departmentid = compositeIds.map(_.departmentid)
    val shiftid = compositeIds.map(_.shiftid)
    sql"""delete
          from humanresources.employeedepartmenthistory
          where ("businessentityid", "startdate", "departmentid", "shiftid")
          in (select unnest(${businessentityid}), unnest(${startdate}), unnest(${departmentid}), unnest(${shiftid}))
       """.delete
    
  }
  override def insert(unsaved: EmployeedepartmenthistoryRow): ZIO[ZConnection, Throwable, EmployeedepartmenthistoryRow] = {
    sql"""insert into humanresources.employeedepartmenthistory("businessentityid", "departmentid", "shiftid", "startdate", "enddate", "modifieddate")
          values (${Segment.paramSegment(unsaved.businessentityid)(BusinessentityId.setter)}::int4, ${Segment.paramSegment(unsaved.departmentid)(DepartmentId.setter)}::int2, ${Segment.paramSegment(unsaved.shiftid)(ShiftId.setter)}::int2, ${Segment.paramSegment(unsaved.startdate)(TypoLocalDate.setter)}::date, ${Segment.paramSegment(unsaved.enddate)(Setter.optionParamSetter(TypoLocalDate.setter))}::date, ${Segment.paramSegment(unsaved.modifieddate)(TypoLocalDateTime.setter)}::timestamp)
          returning "businessentityid", "departmentid", "shiftid", "startdate"::text, "enddate"::text, "modifieddate"::text
       """.insertReturning(using EmployeedepartmenthistoryRow.jdbcDecoder).map(_.updatedKeys.head)
  }
  override def insert(unsaved: EmployeedepartmenthistoryRowUnsaved): ZIO[ZConnection, Throwable, EmployeedepartmenthistoryRow] = {
    val fs = List(
      Some((sql""""businessentityid"""", sql"${Segment.paramSegment(unsaved.businessentityid)(BusinessentityId.setter)}::int4")),
      Some((sql""""departmentid"""", sql"${Segment.paramSegment(unsaved.departmentid)(DepartmentId.setter)}::int2")),
      Some((sql""""shiftid"""", sql"${Segment.paramSegment(unsaved.shiftid)(ShiftId.setter)}::int2")),
      Some((sql""""startdate"""", sql"${Segment.paramSegment(unsaved.startdate)(TypoLocalDate.setter)}::date")),
      Some((sql""""enddate"""", sql"${Segment.paramSegment(unsaved.enddate)(Setter.optionParamSetter(TypoLocalDate.setter))}::date")),
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((sql""""modifieddate"""", sql"${Segment.paramSegment(value: TypoLocalDateTime)(TypoLocalDateTime.setter)}::timestamp"))
      }
    ).flatten
    
    val q = if (fs.isEmpty) {
      sql"""insert into humanresources.employeedepartmenthistory default values
            returning "businessentityid", "departmentid", "shiftid", "startdate"::text, "enddate"::text, "modifieddate"::text
         """
    } else {
      val names  = fs.map { case (n, _) => n }.mkFragment(SqlFragment(", "))
      val values = fs.map { case (_, f) => f }.mkFragment(SqlFragment(", "))
      sql"""insert into humanresources.employeedepartmenthistory($names) values ($values) returning "businessentityid", "departmentid", "shiftid", "startdate"::text, "enddate"::text, "modifieddate"::text"""
    }
    q.insertReturning(using EmployeedepartmenthistoryRow.jdbcDecoder).map(_.updatedKeys.head)
    
  }
  override def insertStreaming(unsaved: ZStream[ZConnection, Throwable, EmployeedepartmenthistoryRow], batchSize: Int): ZIO[ZConnection, Throwable, Long] = {
    streamingInsert(s"""COPY humanresources.employeedepartmenthistory("businessentityid", "departmentid", "shiftid", "startdate", "enddate", "modifieddate") FROM STDIN""", batchSize, unsaved)(EmployeedepartmenthistoryRow.text)
  }
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  override def insertUnsavedStreaming(unsaved: ZStream[ZConnection, Throwable, EmployeedepartmenthistoryRowUnsaved], batchSize: Int): ZIO[ZConnection, Throwable, Long] = {
    streamingInsert(s"""COPY humanresources.employeedepartmenthistory("businessentityid", "departmentid", "shiftid", "startdate", "enddate", "modifieddate") FROM STDIN (DEFAULT '__DEFAULT_VALUE__')""", batchSize, unsaved)(EmployeedepartmenthistoryRowUnsaved.text)
  }
  override def select: SelectBuilder[EmployeedepartmenthistoryFields, EmployeedepartmenthistoryRow] = {
    SelectBuilderSql("humanresources.employeedepartmenthistory", EmployeedepartmenthistoryFields.structure, EmployeedepartmenthistoryRow.jdbcDecoder)
  }
  override def selectAll: ZStream[ZConnection, Throwable, EmployeedepartmenthistoryRow] = {
    sql"""select "businessentityid", "departmentid", "shiftid", "startdate"::text, "enddate"::text, "modifieddate"::text from humanresources.employeedepartmenthistory""".query(using EmployeedepartmenthistoryRow.jdbcDecoder).selectStream()
  }
  override def selectById(compositeId: EmployeedepartmenthistoryId): ZIO[ZConnection, Throwable, Option[EmployeedepartmenthistoryRow]] = {
    sql"""select "businessentityid", "departmentid", "shiftid", "startdate"::text, "enddate"::text, "modifieddate"::text from humanresources.employeedepartmenthistory where "businessentityid" = ${Segment.paramSegment(compositeId.businessentityid)(BusinessentityId.setter)} AND "startdate" = ${Segment.paramSegment(compositeId.startdate)(TypoLocalDate.setter)} AND "departmentid" = ${Segment.paramSegment(compositeId.departmentid)(DepartmentId.setter)} AND "shiftid" = ${Segment.paramSegment(compositeId.shiftid)(ShiftId.setter)}""".query(using EmployeedepartmenthistoryRow.jdbcDecoder).selectOne
  }
  override def selectByIds(compositeIds: Array[EmployeedepartmenthistoryId]): ZStream[ZConnection, Throwable, EmployeedepartmenthistoryRow] = {
    val businessentityid = compositeIds.map(_.businessentityid)
    val startdate = compositeIds.map(_.startdate)
    val departmentid = compositeIds.map(_.departmentid)
    val shiftid = compositeIds.map(_.shiftid)
    sql"""select "businessentityid", "departmentid", "shiftid", "startdate"::text, "enddate"::text, "modifieddate"::text
          from humanresources.employeedepartmenthistory
          where ("businessentityid", "startdate", "departmentid", "shiftid")
          in (select unnest(${businessentityid}), unnest(${startdate}), unnest(${departmentid}), unnest(${shiftid}))
       """.query(using EmployeedepartmenthistoryRow.jdbcDecoder).selectStream()
    
  }
  override def selectByIdsTracked(compositeIds: Array[EmployeedepartmenthistoryId]): ZIO[ZConnection, Throwable, Map[EmployeedepartmenthistoryId, Option[EmployeedepartmenthistoryRow]]] = {
    selectByIds(compositeIds).runCollect.map { rows =>
      val byId = rows.view.map(x => (x.compositeId, x)).toMap
      compositeIds.view.map(id => (id, byId.get(id))).toMap
    }
  }
  override def update: UpdateBuilder[EmployeedepartmenthistoryFields, EmployeedepartmenthistoryRow] = {
    UpdateBuilder("humanresources.employeedepartmenthistory", EmployeedepartmenthistoryFields.structure, EmployeedepartmenthistoryRow.jdbcDecoder)
  }
  override def update(row: EmployeedepartmenthistoryRow): ZIO[ZConnection, Throwable, Boolean] = {
    val compositeId = row.compositeId
    sql"""update humanresources.employeedepartmenthistory
          set "enddate" = ${Segment.paramSegment(row.enddate)(Setter.optionParamSetter(TypoLocalDate.setter))}::date,
              "modifieddate" = ${Segment.paramSegment(row.modifieddate)(TypoLocalDateTime.setter)}::timestamp
          where "businessentityid" = ${Segment.paramSegment(compositeId.businessentityid)(BusinessentityId.setter)} AND "startdate" = ${Segment.paramSegment(compositeId.startdate)(TypoLocalDate.setter)} AND "departmentid" = ${Segment.paramSegment(compositeId.departmentid)(DepartmentId.setter)} AND "shiftid" = ${Segment.paramSegment(compositeId.shiftid)(ShiftId.setter)}""".update.map(_ > 0)
  }
  override def upsert(unsaved: EmployeedepartmenthistoryRow): ZIO[ZConnection, Throwable, UpdateResult[EmployeedepartmenthistoryRow]] = {
    sql"""insert into humanresources.employeedepartmenthistory("businessentityid", "departmentid", "shiftid", "startdate", "enddate", "modifieddate")
          values (
            ${Segment.paramSegment(unsaved.businessentityid)(BusinessentityId.setter)}::int4,
            ${Segment.paramSegment(unsaved.departmentid)(DepartmentId.setter)}::int2,
            ${Segment.paramSegment(unsaved.shiftid)(ShiftId.setter)}::int2,
            ${Segment.paramSegment(unsaved.startdate)(TypoLocalDate.setter)}::date,
            ${Segment.paramSegment(unsaved.enddate)(Setter.optionParamSetter(TypoLocalDate.setter))}::date,
            ${Segment.paramSegment(unsaved.modifieddate)(TypoLocalDateTime.setter)}::timestamp
          )
          on conflict ("businessentityid", "startdate", "departmentid", "shiftid")
          do update set
            "enddate" = EXCLUDED."enddate",
            "modifieddate" = EXCLUDED."modifieddate"
          returning "businessentityid", "departmentid", "shiftid", "startdate"::text, "enddate"::text, "modifieddate"::text""".insertReturning(using EmployeedepartmenthistoryRow.jdbcDecoder)
  }
}
