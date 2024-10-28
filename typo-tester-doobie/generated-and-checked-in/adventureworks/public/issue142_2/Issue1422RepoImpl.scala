/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package public
package issue142_2

import adventureworks.public.issue142.Issue142Id
import cats.instances.list.catsStdInstancesForList
import doobie.free.connection.ConnectionIO
import doobie.postgres.syntax.FragmentOps
import doobie.syntax.SqlInterpolator.SingleFragment.fromWrite
import doobie.syntax.string.toSqlInterpolator
import doobie.util.Write
import doobie.util.update.Update
import fs2.Stream
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql
import typo.dsl.UpdateBuilder

class Issue1422RepoImpl extends Issue1422Repo {
  override def delete: DeleteBuilder[Issue1422Fields, Issue1422Row] = {
    DeleteBuilder(""""public"."issue142_2"""", Issue1422Fields.structure)
  }
  override def deleteById(tabellkode: Issue142Id): ConnectionIO[Boolean] = {
    sql"""delete from "public"."issue142_2" where "tabellkode" = ${fromWrite(tabellkode)(Write.fromPut(Issue142Id.put))}""".update.run.map(_ > 0)
  }
  override def deleteByIds(tabellkodes: Array[Issue142Id]): ConnectionIO[Int] = {
    sql"""delete from "public"."issue142_2" where "tabellkode" = ANY(${tabellkodes})""".update.run
  }
  override def insert(unsaved: Issue1422Row): ConnectionIO[Issue1422Row] = {
    sql"""insert into "public"."issue142_2"("tabellkode")
          values (${fromWrite(unsaved.tabellkode)(Write.fromPut(Issue142Id.put))})
          returning "tabellkode"
       """.query(using Issue1422Row.read).unique
  }
  override def insertStreaming(unsaved: Stream[ConnectionIO, Issue1422Row], batchSize: Int = 10000): ConnectionIO[Long] = {
    new FragmentOps(sql"""COPY "public"."issue142_2"("tabellkode") FROM STDIN""").copyIn(unsaved, batchSize)(using Issue1422Row.text)
  }
  override def select: SelectBuilder[Issue1422Fields, Issue1422Row] = {
    SelectBuilderSql(""""public"."issue142_2"""", Issue1422Fields.structure, Issue1422Row.read)
  }
  override def selectAll: Stream[ConnectionIO, Issue1422Row] = {
    sql"""select "tabellkode" from "public"."issue142_2"""".query(using Issue1422Row.read).stream
  }
  override def selectById(tabellkode: Issue142Id): ConnectionIO[Option[Issue1422Row]] = {
    sql"""select "tabellkode" from "public"."issue142_2" where "tabellkode" = ${fromWrite(tabellkode)(Write.fromPut(Issue142Id.put))}""".query(using Issue1422Row.read).option
  }
  override def selectByIds(tabellkodes: Array[Issue142Id]): Stream[ConnectionIO, Issue1422Row] = {
    sql"""select "tabellkode" from "public"."issue142_2" where "tabellkode" = ANY(${tabellkodes})""".query(using Issue1422Row.read).stream
  }
  override def selectByIdsTracked(tabellkodes: Array[Issue142Id]): ConnectionIO[Map[Issue142Id, Issue1422Row]] = {
    selectByIds(tabellkodes).compile.toList.map { rows =>
      val byId = rows.view.map(x => (x.tabellkode, x)).toMap
      tabellkodes.view.flatMap(id => byId.get(id).map(x => (id, x))).toMap
    }
  }
  override def update: UpdateBuilder[Issue1422Fields, Issue1422Row] = {
    UpdateBuilder(""""public"."issue142_2"""", Issue1422Fields.structure, Issue1422Row.read)
  }
  override def upsert(unsaved: Issue1422Row): ConnectionIO[Issue1422Row] = {
    sql"""insert into "public"."issue142_2"("tabellkode")
          values (
            ${fromWrite(unsaved.tabellkode)(Write.fromPut(Issue142Id.put))}
          )
          on conflict ("tabellkode")
          do update set "tabellkode" = EXCLUDED."tabellkode"
          returning "tabellkode"
       """.query(using Issue1422Row.read).unique
  }
  override def upsertBatch(unsaved: List[Issue1422Row]): Stream[ConnectionIO, Issue1422Row] = {
    Update[Issue1422Row](
      s"""insert into "public"."issue142_2"("tabellkode")
          values (?)
          on conflict ("tabellkode")
          do nothing
          returning "tabellkode""""
    )(using Issue1422Row.write)
    .updateManyWithGeneratedKeys[Issue1422Row]("tabellkode")(unsaved)(using catsStdInstancesForList, Issue1422Row.read)
  }
  /* NOTE: this functionality is not safe if you use auto-commit mode! it runs 3 SQL statements */
  override def upsertStreaming(unsaved: Stream[ConnectionIO, Issue1422Row], batchSize: Int = 10000): ConnectionIO[Int] = {
    for {
      _ <- sql"""create temporary table issue142_2_TEMP (like "public"."issue142_2") on commit drop""".update.run
      _ <- new FragmentOps(sql"""copy issue142_2_TEMP("tabellkode") from stdin""").copyIn(unsaved, batchSize)(using Issue1422Row.text)
      res <- sql"""insert into "public"."issue142_2"("tabellkode")
                   select * from issue142_2_TEMP
                   on conflict ("tabellkode")
                   do nothing
                   ;
                   drop table issue142_2_TEMP;""".update.run
    } yield res
  }
}
