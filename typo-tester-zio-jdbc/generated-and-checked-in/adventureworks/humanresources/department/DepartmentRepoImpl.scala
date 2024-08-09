/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package humanresources
package department

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
import zio.jdbc.UpdateResult
import zio.jdbc.ZConnection
import zio.jdbc.sqlInterpolator
import zio.stream.ZStream

class DepartmentRepoImpl extends DepartmentRepo {
  override def delete: DeleteBuilder[DepartmentFields, DepartmentRow] = {
    DeleteBuilder(""""humanresources"."department"""", DepartmentFields.structure)
  }
  override def deleteById(departmentid: DepartmentId): ZIO[ZConnection, Throwable, Boolean] = {
    sql"""delete from "humanresources"."department" where "departmentid" = ${Segment.paramSegment(departmentid)(DepartmentId.setter)}""".delete.map(_ > 0)
  }
  override def deleteByIds(departmentids: Array[DepartmentId]): ZIO[ZConnection, Throwable, Long] = {
    sql"""delete from "humanresources"."department" where "departmentid" = ANY(${departmentids})""".delete
  }
  override def insert(unsaved: DepartmentRow): ZIO[ZConnection, Throwable, DepartmentRow] = {
    sql"""insert into "humanresources"."department"("departmentid", "name", "groupname", "modifieddate")
          values (${Segment.paramSegment(unsaved.departmentid)(DepartmentId.setter)}::int4, ${Segment.paramSegment(unsaved.name)(Name.setter)}::varchar, ${Segment.paramSegment(unsaved.groupname)(Name.setter)}::varchar, ${Segment.paramSegment(unsaved.modifieddate)(TypoLocalDateTime.setter)}::timestamp)
          returning "departmentid", "name", "groupname", "modifieddate"::text
       """.insertReturning(using DepartmentRow.jdbcDecoder).map(_.updatedKeys.head)
  }
  override def insert(unsaved: DepartmentRowUnsaved): ZIO[ZConnection, Throwable, DepartmentRow] = {
    val fs = List(
      Some((sql""""name"""", sql"${Segment.paramSegment(unsaved.name)(Name.setter)}::varchar")),
      Some((sql""""groupname"""", sql"${Segment.paramSegment(unsaved.groupname)(Name.setter)}::varchar")),
      unsaved.departmentid match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((sql""""departmentid"""", sql"${Segment.paramSegment(value: DepartmentId)(DepartmentId.setter)}::int4"))
      },
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((sql""""modifieddate"""", sql"${Segment.paramSegment(value: TypoLocalDateTime)(TypoLocalDateTime.setter)}::timestamp"))
      }
    ).flatten
    
    val q = if (fs.isEmpty) {
      sql"""insert into "humanresources"."department" default values
            returning "departmentid", "name", "groupname", "modifieddate"::text
         """
    } else {
      val names  = fs.map { case (n, _) => n }.mkFragment(SqlFragment(", "))
      val values = fs.map { case (_, f) => f }.mkFragment(SqlFragment(", "))
      sql"""insert into "humanresources"."department"($names) values ($values) returning "departmentid", "name", "groupname", "modifieddate"::text"""
    }
    q.insertReturning(using DepartmentRow.jdbcDecoder).map(_.updatedKeys.head)
    
  }
  override def insertStreaming(unsaved: ZStream[ZConnection, Throwable, DepartmentRow], batchSize: Int = 10000): ZIO[ZConnection, Throwable, Long] = {
    streamingInsert(s"""COPY "humanresources"."department"("departmentid", "name", "groupname", "modifieddate") FROM STDIN""", batchSize, unsaved)(DepartmentRow.text)
  }
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  override def insertUnsavedStreaming(unsaved: ZStream[ZConnection, Throwable, DepartmentRowUnsaved], batchSize: Int = 10000): ZIO[ZConnection, Throwable, Long] = {
    streamingInsert(s"""COPY "humanresources"."department"("name", "groupname", "departmentid", "modifieddate") FROM STDIN (DEFAULT '__DEFAULT_VALUE__')""", batchSize, unsaved)(DepartmentRowUnsaved.text)
  }
  override def select: SelectBuilder[DepartmentFields, DepartmentRow] = {
    SelectBuilderSql(""""humanresources"."department"""", DepartmentFields.structure, DepartmentRow.jdbcDecoder)
  }
  override def selectAll: ZStream[ZConnection, Throwable, DepartmentRow] = {
    sql"""select "departmentid", "name", "groupname", "modifieddate"::text from "humanresources"."department"""".query(using DepartmentRow.jdbcDecoder).selectStream()
  }
  override def selectById(departmentid: DepartmentId): ZIO[ZConnection, Throwable, Option[DepartmentRow]] = {
    sql"""select "departmentid", "name", "groupname", "modifieddate"::text from "humanresources"."department" where "departmentid" = ${Segment.paramSegment(departmentid)(DepartmentId.setter)}""".query(using DepartmentRow.jdbcDecoder).selectOne
  }
  override def selectByIds(departmentids: Array[DepartmentId]): ZStream[ZConnection, Throwable, DepartmentRow] = {
    sql"""select "departmentid", "name", "groupname", "modifieddate"::text from "humanresources"."department" where "departmentid" = ANY(${Segment.paramSegment(departmentids)(DepartmentId.arraySetter)})""".query(using DepartmentRow.jdbcDecoder).selectStream()
  }
  override def selectByIdsTracked(departmentids: Array[DepartmentId]): ZIO[ZConnection, Throwable, Map[DepartmentId, DepartmentRow]] = {
    selectByIds(departmentids).runCollect.map { rows =>
      val byId = rows.view.map(x => (x.departmentid, x)).toMap
      departmentids.view.flatMap(id => byId.get(id).map(x => (id, x))).toMap
    }
  }
  override def update: UpdateBuilder[DepartmentFields, DepartmentRow] = {
    UpdateBuilder(""""humanresources"."department"""", DepartmentFields.structure, DepartmentRow.jdbcDecoder)
  }
  override def update(row: DepartmentRow): ZIO[ZConnection, Throwable, Boolean] = {
    val departmentid = row.departmentid
    sql"""update "humanresources"."department"
          set "name" = ${Segment.paramSegment(row.name)(Name.setter)}::varchar,
              "groupname" = ${Segment.paramSegment(row.groupname)(Name.setter)}::varchar,
              "modifieddate" = ${Segment.paramSegment(row.modifieddate)(TypoLocalDateTime.setter)}::timestamp
          where "departmentid" = ${Segment.paramSegment(departmentid)(DepartmentId.setter)}""".update.map(_ > 0)
  }
  override def upsert(unsaved: DepartmentRow): ZIO[ZConnection, Throwable, UpdateResult[DepartmentRow]] = {
    sql"""insert into "humanresources"."department"("departmentid", "name", "groupname", "modifieddate")
          values (
            ${Segment.paramSegment(unsaved.departmentid)(DepartmentId.setter)}::int4,
            ${Segment.paramSegment(unsaved.name)(Name.setter)}::varchar,
            ${Segment.paramSegment(unsaved.groupname)(Name.setter)}::varchar,
            ${Segment.paramSegment(unsaved.modifieddate)(TypoLocalDateTime.setter)}::timestamp
          )
          on conflict ("departmentid")
          do update set
            "name" = EXCLUDED."name",
            "groupname" = EXCLUDED."groupname",
            "modifieddate" = EXCLUDED."modifieddate"
          returning "departmentid", "name", "groupname", "modifieddate"::text""".insertReturning(using DepartmentRow.jdbcDecoder)
  }
  /* NOTE: this functionality is not safe if you use auto-commit mode! it runs 3 SQL statements */
  override def upsertStreaming(unsaved: ZStream[ZConnection, Throwable, DepartmentRow], batchSize: Int = 10000): ZIO[ZConnection, Throwable, Long] = {
    val created = sql"""create temporary table department_TEMP (like "humanresources"."department") on commit drop""".execute
    val copied = streamingInsert(s"""copy department_TEMP("departmentid", "name", "groupname", "modifieddate") from stdin""", batchSize, unsaved)(DepartmentRow.text)
    val merged = sql"""insert into "humanresources"."department"("departmentid", "name", "groupname", "modifieddate")
                       select * from department_TEMP
                       on conflict ("departmentid")
                       do update set
                         "name" = EXCLUDED."name",
                         "groupname" = EXCLUDED."groupname",
                         "modifieddate" = EXCLUDED."modifieddate"
                       ;
                       drop table department_TEMP;""".update
    created *> copied *> merged
  }
}
