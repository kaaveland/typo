/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package public
package flaff

import adventureworks.public.ShortText
import doobie.free.connection.ConnectionIO
import doobie.postgres.syntax.FragmentOps
import doobie.syntax.SqlInterpolator.SingleFragment.fromWrite
import doobie.syntax.string.toSqlInterpolator
import doobie.util.Write
import doobie.util.meta.Meta
import fs2.Stream
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql
import typo.dsl.UpdateBuilder

class FlaffRepoImpl extends FlaffRepo {
  override def delete: DeleteBuilder[FlaffFields, FlaffRow] = {
    DeleteBuilder("public.flaff", FlaffFields.structure)
  }
  override def deleteById(compositeId: FlaffId): ConnectionIO[Boolean] = {
    sql"""delete from public.flaff where "code" = ${fromWrite(compositeId.code)(Write.fromPut(ShortText.put))} AND "another_code" = ${fromWrite(compositeId.anotherCode)(Write.fromPut(Meta.StringMeta.put))} AND "some_number" = ${fromWrite(compositeId.someNumber)(Write.fromPut(Meta.IntMeta.put))} AND "specifier" = ${fromWrite(compositeId.specifier)(Write.fromPut(ShortText.put))}""".update.run.map(_ > 0)
  }
  override def deleteByIds(compositeIds: Array[FlaffId]): ConnectionIO[Int] = {
    val code = compositeIds.map(_.code)
    val anotherCode = compositeIds.map(_.anotherCode)
    val someNumber = compositeIds.map(_.someNumber)
    val specifier = compositeIds.map(_.specifier)
    sql"""delete
          from public.flaff
          where ("code", "another_code", "some_number", "specifier")
          in (select unnest(${code}), unnest(${anotherCode}), unnest(${someNumber}), unnest(${specifier}))
       """.update.run
    
  }
  override def insert(unsaved: FlaffRow): ConnectionIO[FlaffRow] = {
    sql"""insert into public.flaff("code", "another_code", "some_number", "specifier", "parentspecifier")
          values (${fromWrite(unsaved.code)(Write.fromPut(ShortText.put))}::text, ${fromWrite(unsaved.anotherCode)(Write.fromPut(Meta.StringMeta.put))}, ${fromWrite(unsaved.someNumber)(Write.fromPut(Meta.IntMeta.put))}::int4, ${fromWrite(unsaved.specifier)(Write.fromPut(ShortText.put))}::text, ${fromWrite(unsaved.parentspecifier)(Write.fromPutOption(ShortText.put))}::text)
          returning "code", "another_code", "some_number", "specifier", "parentspecifier"
       """.query(using FlaffRow.read).unique
  }
  override def insertStreaming(unsaved: Stream[ConnectionIO, FlaffRow], batchSize: Int = 10000): ConnectionIO[Long] = {
    new FragmentOps(sql"""COPY public.flaff("code", "another_code", "some_number", "specifier", "parentspecifier") FROM STDIN""").copyIn(unsaved, batchSize)(using FlaffRow.text)
  }
  override def select: SelectBuilder[FlaffFields, FlaffRow] = {
    SelectBuilderSql("public.flaff", FlaffFields.structure, FlaffRow.read)
  }
  override def selectAll: Stream[ConnectionIO, FlaffRow] = {
    sql"""select "code", "another_code", "some_number", "specifier", "parentspecifier" from public.flaff""".query(using FlaffRow.read).stream
  }
  override def selectById(compositeId: FlaffId): ConnectionIO[Option[FlaffRow]] = {
    sql"""select "code", "another_code", "some_number", "specifier", "parentspecifier" from public.flaff where "code" = ${fromWrite(compositeId.code)(Write.fromPut(ShortText.put))} AND "another_code" = ${fromWrite(compositeId.anotherCode)(Write.fromPut(Meta.StringMeta.put))} AND "some_number" = ${fromWrite(compositeId.someNumber)(Write.fromPut(Meta.IntMeta.put))} AND "specifier" = ${fromWrite(compositeId.specifier)(Write.fromPut(ShortText.put))}""".query(using FlaffRow.read).option
  }
  override def selectByIds(compositeIds: Array[FlaffId]): Stream[ConnectionIO, FlaffRow] = {
    val code = compositeIds.map(_.code)
    val anotherCode = compositeIds.map(_.anotherCode)
    val someNumber = compositeIds.map(_.someNumber)
    val specifier = compositeIds.map(_.specifier)
    sql"""select "code", "another_code", "some_number", "specifier", "parentspecifier"
          from public.flaff
          where ("code", "another_code", "some_number", "specifier") 
          in (select unnest(${code}), unnest(${anotherCode}), unnest(${someNumber}), unnest(${specifier}))
       """.query(using FlaffRow.read).stream
    
  }
  override def selectByIdsTracked(compositeIds: Array[FlaffId]): ConnectionIO[Map[FlaffId, FlaffRow]] = {
    selectByIds(compositeIds).compile.toList.map { rows =>
      val byId = rows.view.map(x => (x.compositeId, x)).toMap
      compositeIds.view.flatMap(id => byId.get(id).map(x => (id, x))).toMap
    }
  }
  override def update: UpdateBuilder[FlaffFields, FlaffRow] = {
    UpdateBuilder("public.flaff", FlaffFields.structure, FlaffRow.read)
  }
  override def update(row: FlaffRow): ConnectionIO[Boolean] = {
    val compositeId = row.compositeId
    sql"""update public.flaff
          set "parentspecifier" = ${fromWrite(row.parentspecifier)(Write.fromPutOption(ShortText.put))}::text
          where "code" = ${fromWrite(compositeId.code)(Write.fromPut(ShortText.put))} AND "another_code" = ${fromWrite(compositeId.anotherCode)(Write.fromPut(Meta.StringMeta.put))} AND "some_number" = ${fromWrite(compositeId.someNumber)(Write.fromPut(Meta.IntMeta.put))} AND "specifier" = ${fromWrite(compositeId.specifier)(Write.fromPut(ShortText.put))}"""
      .update
      .run
      .map(_ > 0)
  }
  override def upsert(unsaved: FlaffRow): ConnectionIO[FlaffRow] = {
    sql"""insert into public.flaff("code", "another_code", "some_number", "specifier", "parentspecifier")
          values (
            ${fromWrite(unsaved.code)(Write.fromPut(ShortText.put))}::text,
            ${fromWrite(unsaved.anotherCode)(Write.fromPut(Meta.StringMeta.put))},
            ${fromWrite(unsaved.someNumber)(Write.fromPut(Meta.IntMeta.put))}::int4,
            ${fromWrite(unsaved.specifier)(Write.fromPut(ShortText.put))}::text,
            ${fromWrite(unsaved.parentspecifier)(Write.fromPutOption(ShortText.put))}::text
          )
          on conflict ("code", "another_code", "some_number", "specifier")
          do update set
            "parentspecifier" = EXCLUDED."parentspecifier"
          returning "code", "another_code", "some_number", "specifier", "parentspecifier"
       """.query(using FlaffRow.read).unique
  }
}
