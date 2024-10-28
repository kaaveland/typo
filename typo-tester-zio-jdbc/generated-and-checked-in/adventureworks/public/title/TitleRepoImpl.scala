/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package public
package title

import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql
import typo.dsl.UpdateBuilder
import zio.ZIO
import zio.jdbc.SqlFragment.Segment
import zio.jdbc.UpdateResult
import zio.jdbc.ZConnection
import zio.jdbc.sqlInterpolator
import zio.stream.ZStream

class TitleRepoImpl extends TitleRepo {
  override def delete: DeleteBuilder[TitleFields, TitleRow] = {
    DeleteBuilder(""""public"."title"""", TitleFields.structure)
  }
  override def deleteById(code: TitleId): ZIO[ZConnection, Throwable, Boolean] = {
    sql"""delete from "public"."title" where "code" = ${Segment.paramSegment(code)(TitleId.setter)}""".delete.map(_ > 0)
  }
  override def deleteByIds(codes: Array[TitleId]): ZIO[ZConnection, Throwable, Long] = {
    sql"""delete from "public"."title" where "code" = ANY(${codes})""".delete
  }
  override def insert(unsaved: TitleRow): ZIO[ZConnection, Throwable, TitleRow] = {
    sql"""insert into "public"."title"("code")
          values (${Segment.paramSegment(unsaved.code)(TitleId.setter)})
          returning "code"
       """.insertReturning(using TitleRow.jdbcDecoder).map(_.updatedKeys.head)
  }
  override def insertStreaming(unsaved: ZStream[ZConnection, Throwable, TitleRow], batchSize: Int = 10000): ZIO[ZConnection, Throwable, Long] = {
    streamingInsert(s"""COPY "public"."title"("code") FROM STDIN""", batchSize, unsaved)(TitleRow.text)
  }
  override def select: SelectBuilder[TitleFields, TitleRow] = {
    SelectBuilderSql(""""public"."title"""", TitleFields.structure, TitleRow.jdbcDecoder)
  }
  override def selectAll: ZStream[ZConnection, Throwable, TitleRow] = {
    sql"""select "code" from "public"."title"""".query(using TitleRow.jdbcDecoder).selectStream()
  }
  override def selectById(code: TitleId): ZIO[ZConnection, Throwable, Option[TitleRow]] = {
    sql"""select "code" from "public"."title" where "code" = ${Segment.paramSegment(code)(TitleId.setter)}""".query(using TitleRow.jdbcDecoder).selectOne
  }
  override def selectByIds(codes: Array[TitleId]): ZStream[ZConnection, Throwable, TitleRow] = {
    sql"""select "code" from "public"."title" where "code" = ANY(${Segment.paramSegment(codes)(TitleId.arraySetter)})""".query(using TitleRow.jdbcDecoder).selectStream()
  }
  override def selectByIdsTracked(codes: Array[TitleId]): ZIO[ZConnection, Throwable, Map[TitleId, TitleRow]] = {
    selectByIds(codes).runCollect.map { rows =>
      val byId = rows.view.map(x => (x.code, x)).toMap
      codes.view.flatMap(id => byId.get(id).map(x => (id, x))).toMap
    }
  }
  override def update: UpdateBuilder[TitleFields, TitleRow] = {
    UpdateBuilder(""""public"."title"""", TitleFields.structure, TitleRow.jdbcDecoder)
  }
  override def upsert(unsaved: TitleRow): ZIO[ZConnection, Throwable, UpdateResult[TitleRow]] = {
    sql"""insert into "public"."title"("code")
          values (
            ${Segment.paramSegment(unsaved.code)(TitleId.setter)}
          )
          on conflict ("code")
          do update set "code" = EXCLUDED."code"
          returning "code"""".insertReturning(using TitleRow.jdbcDecoder)
  }
  /* NOTE: this functionality is not safe if you use auto-commit mode! it runs 3 SQL statements */
  override def upsertStreaming(unsaved: ZStream[ZConnection, Throwable, TitleRow], batchSize: Int = 10000): ZIO[ZConnection, Throwable, Long] = {
    val created = sql"""create temporary table title_TEMP (like "public"."title") on commit drop""".execute
    val copied = streamingInsert(s"""copy title_TEMP("code") from stdin""", batchSize, unsaved)(TitleRow.text)
    val merged = sql"""insert into "public"."title"("code")
                       select * from title_TEMP
                       on conflict ("code")
                       do nothing
                       ;
                       drop table title_TEMP;""".update
    created *> copied *> merged
  }
}
