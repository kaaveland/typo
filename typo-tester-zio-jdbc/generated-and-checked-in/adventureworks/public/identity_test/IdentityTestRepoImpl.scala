/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package public
package identity_test

import adventureworks.customtypes.Defaulted
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

class IdentityTestRepoImpl extends IdentityTestRepo {
  override def delete: DeleteBuilder[IdentityTestFields, IdentityTestRow] = {
    DeleteBuilder(""""public"."identity-test"""", IdentityTestFields.structure)
  }
  override def deleteById(name: IdentityTestId): ZIO[ZConnection, Throwable, Boolean] = {
    sql"""delete from "public"."identity-test" where "name" = ${Segment.paramSegment(name)(IdentityTestId.setter)}""".delete.map(_ > 0)
  }
  override def deleteByIds(names: Array[IdentityTestId]): ZIO[ZConnection, Throwable, Long] = {
    sql"""delete from "public"."identity-test" where "name" = ANY(${names})""".delete
  }
  override def insert(unsaved: IdentityTestRow): ZIO[ZConnection, Throwable, IdentityTestRow] = {
    sql"""insert into "public"."identity-test"("always_generated", "default_generated", "name")
          values (${Segment.paramSegment(unsaved.alwaysGenerated)(Setter.intSetter)}::int4, ${Segment.paramSegment(unsaved.defaultGenerated)(Setter.intSetter)}::int4, ${Segment.paramSegment(unsaved.name)(IdentityTestId.setter)})
          returning "always_generated", "default_generated", "name"
       """.insertReturning(using IdentityTestRow.jdbcDecoder).map(_.updatedKeys.head)
  }
  override def insert(unsaved: IdentityTestRowUnsaved): ZIO[ZConnection, Throwable, IdentityTestRow] = {
    val fs = List(
      Some((sql""""name"""", sql"${Segment.paramSegment(unsaved.name)(IdentityTestId.setter)}")),
      unsaved.defaultGenerated match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((sql""""default_generated"""", sql"${Segment.paramSegment(value: Int)(Setter.intSetter)}::int4"))
      }
    ).flatten
    
    val q = if (fs.isEmpty) {
      sql"""insert into "public"."identity-test" default values
            returning "always_generated", "default_generated", "name"
         """
    } else {
      val names  = fs.map { case (n, _) => n }.mkFragment(SqlFragment(", "))
      val values = fs.map { case (_, f) => f }.mkFragment(SqlFragment(", "))
      sql"""insert into "public"."identity-test"($names) values ($values) returning "always_generated", "default_generated", "name""""
    }
    q.insertReturning(using IdentityTestRow.jdbcDecoder).map(_.updatedKeys.head)
    
  }
  override def insertStreaming(unsaved: ZStream[ZConnection, Throwable, IdentityTestRow], batchSize: Int = 10000): ZIO[ZConnection, Throwable, Long] = {
    streamingInsert(s"""COPY "public"."identity-test"("always_generated", "default_generated", "name") FROM STDIN""", batchSize, unsaved)(IdentityTestRow.text)
  }
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  override def insertUnsavedStreaming(unsaved: ZStream[ZConnection, Throwable, IdentityTestRowUnsaved], batchSize: Int = 10000): ZIO[ZConnection, Throwable, Long] = {
    streamingInsert(s"""COPY "public"."identity-test"("name", "default_generated") FROM STDIN (DEFAULT '__DEFAULT_VALUE__')""", batchSize, unsaved)(IdentityTestRowUnsaved.text)
  }
  override def select: SelectBuilder[IdentityTestFields, IdentityTestRow] = {
    SelectBuilderSql(""""public"."identity-test"""", IdentityTestFields.structure, IdentityTestRow.jdbcDecoder)
  }
  override def selectAll: ZStream[ZConnection, Throwable, IdentityTestRow] = {
    sql"""select "always_generated", "default_generated", "name" from "public"."identity-test"""".query(using IdentityTestRow.jdbcDecoder).selectStream()
  }
  override def selectById(name: IdentityTestId): ZIO[ZConnection, Throwable, Option[IdentityTestRow]] = {
    sql"""select "always_generated", "default_generated", "name" from "public"."identity-test" where "name" = ${Segment.paramSegment(name)(IdentityTestId.setter)}""".query(using IdentityTestRow.jdbcDecoder).selectOne
  }
  override def selectByIds(names: Array[IdentityTestId]): ZStream[ZConnection, Throwable, IdentityTestRow] = {
    sql"""select "always_generated", "default_generated", "name" from "public"."identity-test" where "name" = ANY(${Segment.paramSegment(names)(IdentityTestId.arraySetter)})""".query(using IdentityTestRow.jdbcDecoder).selectStream()
  }
  override def selectByIdsTracked(names: Array[IdentityTestId]): ZIO[ZConnection, Throwable, Map[IdentityTestId, IdentityTestRow]] = {
    selectByIds(names).runCollect.map { rows =>
      val byId = rows.view.map(x => (x.name, x)).toMap
      names.view.flatMap(id => byId.get(id).map(x => (id, x))).toMap
    }
  }
  override def update: UpdateBuilder[IdentityTestFields, IdentityTestRow] = {
    UpdateBuilder(""""public"."identity-test"""", IdentityTestFields.structure, IdentityTestRow.jdbcDecoder)
  }
  override def update(row: IdentityTestRow): ZIO[ZConnection, Throwable, Boolean] = {
    val name = row.name
    sql"""update "public"."identity-test"
          set "always_generated" = ${Segment.paramSegment(row.alwaysGenerated)(Setter.intSetter)}::int4,
              "default_generated" = ${Segment.paramSegment(row.defaultGenerated)(Setter.intSetter)}::int4
          where "name" = ${Segment.paramSegment(name)(IdentityTestId.setter)}""".update.map(_ > 0)
  }
  override def upsert(unsaved: IdentityTestRow): ZIO[ZConnection, Throwable, UpdateResult[IdentityTestRow]] = {
    sql"""insert into "public"."identity-test"("always_generated", "default_generated", "name")
          values (
            ${Segment.paramSegment(unsaved.alwaysGenerated)(Setter.intSetter)}::int4,
            ${Segment.paramSegment(unsaved.defaultGenerated)(Setter.intSetter)}::int4,
            ${Segment.paramSegment(unsaved.name)(IdentityTestId.setter)}
          )
          on conflict ("name")
          do update set
            "always_generated" = EXCLUDED."always_generated",
            "default_generated" = EXCLUDED."default_generated"
          returning "always_generated", "default_generated", "name"""".insertReturning(using IdentityTestRow.jdbcDecoder)
  }
  /* NOTE: this functionality is not safe if you use auto-commit mode! it runs 3 SQL statements */
  override def upsertStreaming(unsaved: ZStream[ZConnection, Throwable, IdentityTestRow], batchSize: Int = 10000): ZIO[ZConnection, Throwable, Long] = {
    val created = sql"""create temporary table identity-test_TEMP (like "public"."identity-test") on commit drop""".execute
    val copied = streamingInsert(s"""copy identity-test_TEMP("always_generated", "default_generated", "name") from stdin""", batchSize, unsaved)(IdentityTestRow.text)
    val merged = sql"""insert into "public"."identity-test"("always_generated", "default_generated", "name")
                       select * from identity-test_TEMP
                       on conflict ("name")
                       do update set
                         "always_generated" = EXCLUDED."always_generated",
                         "default_generated" = EXCLUDED."default_generated"
                       ;
                       drop table identity-test_TEMP;""".update
    created *> copied *> merged
  }
}
