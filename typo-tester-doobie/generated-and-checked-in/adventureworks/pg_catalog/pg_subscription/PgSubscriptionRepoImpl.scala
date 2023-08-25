/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_subscription

import doobie.free.connection.ConnectionIO
import doobie.syntax.SqlInterpolator.SingleFragment.fromWrite
import doobie.syntax.string.toSqlInterpolator
import doobie.util.Write
import doobie.util.meta.Meta
import fs2.Stream
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql
import typo.dsl.UpdateBuilder

object PgSubscriptionRepoImpl extends PgSubscriptionRepo {
  override def delete(oid: PgSubscriptionId): ConnectionIO[Boolean] = {
    sql"delete from pg_catalog.pg_subscription where oid = ${fromWrite(oid)(Write.fromPut(PgSubscriptionId.put))}".update.run.map(_ > 0)
  }
  override def delete: DeleteBuilder[PgSubscriptionFields, PgSubscriptionRow] = {
    DeleteBuilder("pg_catalog.pg_subscription", PgSubscriptionFields)
  }
  override def insert(unsaved: PgSubscriptionRow): ConnectionIO[PgSubscriptionRow] = {
    sql"""insert into pg_catalog.pg_subscription(oid, subdbid, subname, subowner, subenabled, subbinary, substream, subconninfo, subslotname, subsynccommit, subpublications)
          values (${fromWrite(unsaved.oid)(Write.fromPut(PgSubscriptionId.put))}::oid, ${fromWrite(unsaved.subdbid)(Write.fromPut(Meta.LongMeta.put))}::oid, ${fromWrite(unsaved.subname)(Write.fromPut(Meta.StringMeta.put))}::name, ${fromWrite(unsaved.subowner)(Write.fromPut(Meta.LongMeta.put))}::oid, ${fromWrite(unsaved.subenabled)(Write.fromPut(Meta.BooleanMeta.put))}, ${fromWrite(unsaved.subbinary)(Write.fromPut(Meta.BooleanMeta.put))}, ${fromWrite(unsaved.substream)(Write.fromPut(Meta.BooleanMeta.put))}, ${fromWrite(unsaved.subconninfo)(Write.fromPut(Meta.StringMeta.put))}, ${fromWrite(unsaved.subslotname)(Write.fromPutOption(Meta.StringMeta.put))}::name, ${fromWrite(unsaved.subsynccommit)(Write.fromPut(Meta.StringMeta.put))}, ${fromWrite(unsaved.subpublications)(Write.fromPut(adventureworks.StringArrayMeta.put))}::_text)
          returning oid, subdbid, subname, subowner, subenabled, subbinary, substream, subconninfo, subslotname, subsynccommit, subpublications
       """.query(PgSubscriptionRow.read).unique
  }
  override def select: SelectBuilder[PgSubscriptionFields, PgSubscriptionRow] = {
    SelectBuilderSql("pg_catalog.pg_subscription", PgSubscriptionFields, PgSubscriptionRow.read)
  }
  override def selectAll: Stream[ConnectionIO, PgSubscriptionRow] = {
    sql"select oid, subdbid, subname, subowner, subenabled, subbinary, substream, subconninfo, subslotname, subsynccommit, subpublications from pg_catalog.pg_subscription".query(PgSubscriptionRow.read).stream
  }
  override def selectById(oid: PgSubscriptionId): ConnectionIO[Option[PgSubscriptionRow]] = {
    sql"select oid, subdbid, subname, subowner, subenabled, subbinary, substream, subconninfo, subslotname, subsynccommit, subpublications from pg_catalog.pg_subscription where oid = ${fromWrite(oid)(Write.fromPut(PgSubscriptionId.put))}".query(PgSubscriptionRow.read).option
  }
  override def selectByIds(oids: Array[PgSubscriptionId]): Stream[ConnectionIO, PgSubscriptionRow] = {
    sql"select oid, subdbid, subname, subowner, subenabled, subbinary, substream, subconninfo, subslotname, subsynccommit, subpublications from pg_catalog.pg_subscription where oid = ANY(${oids})".query(PgSubscriptionRow.read).stream
  }
  override def selectByUnique(subdbid: /* oid */ Long, subname: String): ConnectionIO[Option[PgSubscriptionRow]] = {
    sql"""select subdbid, subname
          from pg_catalog.pg_subscription
          where subdbid = ${fromWrite(subdbid)(Write.fromPut(Meta.LongMeta.put))} AND subname = ${fromWrite(subname)(Write.fromPut(Meta.StringMeta.put))}
       """.query(PgSubscriptionRow.read).option
  }
  override def update(row: PgSubscriptionRow): ConnectionIO[Boolean] = {
    val oid = row.oid
    sql"""update pg_catalog.pg_subscription
          set subdbid = ${fromWrite(row.subdbid)(Write.fromPut(Meta.LongMeta.put))}::oid,
              subname = ${fromWrite(row.subname)(Write.fromPut(Meta.StringMeta.put))}::name,
              subowner = ${fromWrite(row.subowner)(Write.fromPut(Meta.LongMeta.put))}::oid,
              subenabled = ${fromWrite(row.subenabled)(Write.fromPut(Meta.BooleanMeta.put))},
              subbinary = ${fromWrite(row.subbinary)(Write.fromPut(Meta.BooleanMeta.put))},
              substream = ${fromWrite(row.substream)(Write.fromPut(Meta.BooleanMeta.put))},
              subconninfo = ${fromWrite(row.subconninfo)(Write.fromPut(Meta.StringMeta.put))},
              subslotname = ${fromWrite(row.subslotname)(Write.fromPutOption(Meta.StringMeta.put))}::name,
              subsynccommit = ${fromWrite(row.subsynccommit)(Write.fromPut(Meta.StringMeta.put))},
              subpublications = ${fromWrite(row.subpublications)(Write.fromPut(adventureworks.StringArrayMeta.put))}::_text
          where oid = ${fromWrite(oid)(Write.fromPut(PgSubscriptionId.put))}"""
      .update
      .run
      .map(_ > 0)
  }
  override def update: UpdateBuilder[PgSubscriptionFields, PgSubscriptionRow] = {
    UpdateBuilder("pg_catalog.pg_subscription", PgSubscriptionFields, PgSubscriptionRow.read)
  }
  override def upsert(unsaved: PgSubscriptionRow): ConnectionIO[PgSubscriptionRow] = {
    sql"""insert into pg_catalog.pg_subscription(oid, subdbid, subname, subowner, subenabled, subbinary, substream, subconninfo, subslotname, subsynccommit, subpublications)
          values (
            ${fromWrite(unsaved.oid)(Write.fromPut(PgSubscriptionId.put))}::oid,
            ${fromWrite(unsaved.subdbid)(Write.fromPut(Meta.LongMeta.put))}::oid,
            ${fromWrite(unsaved.subname)(Write.fromPut(Meta.StringMeta.put))}::name,
            ${fromWrite(unsaved.subowner)(Write.fromPut(Meta.LongMeta.put))}::oid,
            ${fromWrite(unsaved.subenabled)(Write.fromPut(Meta.BooleanMeta.put))},
            ${fromWrite(unsaved.subbinary)(Write.fromPut(Meta.BooleanMeta.put))},
            ${fromWrite(unsaved.substream)(Write.fromPut(Meta.BooleanMeta.put))},
            ${fromWrite(unsaved.subconninfo)(Write.fromPut(Meta.StringMeta.put))},
            ${fromWrite(unsaved.subslotname)(Write.fromPutOption(Meta.StringMeta.put))}::name,
            ${fromWrite(unsaved.subsynccommit)(Write.fromPut(Meta.StringMeta.put))},
            ${fromWrite(unsaved.subpublications)(Write.fromPut(adventureworks.StringArrayMeta.put))}::_text
          )
          on conflict (oid)
          do update set
            subdbid = EXCLUDED.subdbid,
            subname = EXCLUDED.subname,
            subowner = EXCLUDED.subowner,
            subenabled = EXCLUDED.subenabled,
            subbinary = EXCLUDED.subbinary,
            substream = EXCLUDED.substream,
            subconninfo = EXCLUDED.subconninfo,
            subslotname = EXCLUDED.subslotname,
            subsynccommit = EXCLUDED.subsynccommit,
            subpublications = EXCLUDED.subpublications
          returning oid, subdbid, subname, subowner, subenabled, subbinary, substream, subconninfo, subslotname, subsynccommit, subpublications
       """.query(PgSubscriptionRow.read).unique
  }
}