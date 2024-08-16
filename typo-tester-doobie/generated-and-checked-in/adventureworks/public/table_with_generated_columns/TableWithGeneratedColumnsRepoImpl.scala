/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package public
package table_with_generated_columns

import cats.instances.list.catsStdInstancesForList
import doobie.free.connection.ConnectionIO
import doobie.postgres.syntax.FragmentOps
import doobie.syntax.SqlInterpolator.SingleFragment.fromWrite
import doobie.syntax.string.toSqlInterpolator
import doobie.util.Write
import doobie.util.fragment.Fragment
import doobie.util.update.Update
import fs2.Stream
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql
import typo.dsl.UpdateBuilder

class TableWithGeneratedColumnsRepoImpl extends TableWithGeneratedColumnsRepo {
  override def delete: DeleteBuilder[TableWithGeneratedColumnsFields, TableWithGeneratedColumnsRow] = {
    DeleteBuilder(""""public"."table-with-generated-columns"""", TableWithGeneratedColumnsFields.structure)
  }
  override def deleteById(name: TableWithGeneratedColumnsId): ConnectionIO[Boolean] = {
    sql"""delete from "public"."table-with-generated-columns" where "name" = ${fromWrite(name)(Write.fromPut(TableWithGeneratedColumnsId.put))}""".update.run.map(_ > 0)
  }
  override def deleteByIds(names: Array[TableWithGeneratedColumnsId]): ConnectionIO[Int] = {
    sql"""delete from "public"."table-with-generated-columns" where "name" = ANY(${names})""".update.run
  }
  override def insert(unsaved: TableWithGeneratedColumnsRow): ConnectionIO[TableWithGeneratedColumnsRow] = {
    sql"""insert into "public"."table-with-generated-columns"("name")
          values (${fromWrite(unsaved.name)(Write.fromPut(TableWithGeneratedColumnsId.put))})
          returning "name", "name-type-always"
       """.query(using TableWithGeneratedColumnsRow.read).unique
  }
  override def insert(unsaved: TableWithGeneratedColumnsRowUnsaved): ConnectionIO[TableWithGeneratedColumnsRow] = {
    val fs = List(
      Some((Fragment.const0(s""""name""""), fr"${fromWrite(unsaved.name)(Write.fromPut(TableWithGeneratedColumnsId.put))}"))
    ).flatten
    
    val q = if (fs.isEmpty) {
      sql"""insert into "public"."table-with-generated-columns" default values
            returning "name", "name-type-always"
         """
    } else {
      val CommaSeparate = Fragment.FragmentMonoid.intercalate(fr", ")
      sql"""insert into "public"."table-with-generated-columns"(${CommaSeparate.combineAllOption(fs.map { case (n, _) => n }).get})
            values (${CommaSeparate.combineAllOption(fs.map { case (_, f) => f }).get})
            returning "name", "name-type-always"
         """
    }
    q.query(using TableWithGeneratedColumnsRow.read).unique
    
  }
  override def insertStreaming(unsaved: Stream[ConnectionIO, TableWithGeneratedColumnsRow], batchSize: Int = 10000): ConnectionIO[Long] = {
    new FragmentOps(sql"""COPY "public"."table-with-generated-columns"("name") FROM STDIN""").copyIn(unsaved, batchSize)(using TableWithGeneratedColumnsRow.text)
  }
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  override def insertUnsavedStreaming(unsaved: Stream[ConnectionIO, TableWithGeneratedColumnsRowUnsaved], batchSize: Int = 10000): ConnectionIO[Long] = {
    new FragmentOps(sql"""COPY "public"."table-with-generated-columns"("name") FROM STDIN (DEFAULT '__DEFAULT_VALUE__')""").copyIn(unsaved, batchSize)(using TableWithGeneratedColumnsRowUnsaved.text)
  }
  override def select: SelectBuilder[TableWithGeneratedColumnsFields, TableWithGeneratedColumnsRow] = {
    SelectBuilderSql(""""public"."table-with-generated-columns"""", TableWithGeneratedColumnsFields.structure, TableWithGeneratedColumnsRow.read)
  }
  override def selectAll: Stream[ConnectionIO, TableWithGeneratedColumnsRow] = {
    sql"""select "name", "name-type-always" from "public"."table-with-generated-columns"""".query(using TableWithGeneratedColumnsRow.read).stream
  }
  override def selectById(name: TableWithGeneratedColumnsId): ConnectionIO[Option[TableWithGeneratedColumnsRow]] = {
    sql"""select "name", "name-type-always" from "public"."table-with-generated-columns" where "name" = ${fromWrite(name)(Write.fromPut(TableWithGeneratedColumnsId.put))}""".query(using TableWithGeneratedColumnsRow.read).option
  }
  override def selectByIds(names: Array[TableWithGeneratedColumnsId]): Stream[ConnectionIO, TableWithGeneratedColumnsRow] = {
    sql"""select "name", "name-type-always" from "public"."table-with-generated-columns" where "name" = ANY(${names})""".query(using TableWithGeneratedColumnsRow.read).stream
  }
  override def selectByIdsTracked(names: Array[TableWithGeneratedColumnsId]): ConnectionIO[Map[TableWithGeneratedColumnsId, TableWithGeneratedColumnsRow]] = {
    selectByIds(names).compile.toList.map { rows =>
      val byId = rows.view.map(x => (x.name, x)).toMap
      names.view.flatMap(id => byId.get(id).map(x => (id, x))).toMap
    }
  }
  override def update: UpdateBuilder[TableWithGeneratedColumnsFields, TableWithGeneratedColumnsRow] = {
    UpdateBuilder(""""public"."table-with-generated-columns"""", TableWithGeneratedColumnsFields.structure, TableWithGeneratedColumnsRow.read)
  }
  override def upsert(unsaved: TableWithGeneratedColumnsRow): ConnectionIO[TableWithGeneratedColumnsRow] = {
    sql"""insert into "public"."table-with-generated-columns"("name")
          values (
            ${fromWrite(unsaved.name)(Write.fromPut(TableWithGeneratedColumnsId.put))}
          )
          on conflict ("name")
          do nothing
          returning "name", "name-type-always"
       """.query(using TableWithGeneratedColumnsRow.read).unique
  }
  override def upsertBatch(unsaved: List[TableWithGeneratedColumnsRow]): Stream[ConnectionIO, TableWithGeneratedColumnsRow] = {
    Update[TableWithGeneratedColumnsRow](
      s"""insert into "public"."table-with-generated-columns"("name")
          values (?)
          on conflict ("name")
          do nothing
          returning "name", "name-type-always""""
    )(using TableWithGeneratedColumnsRow.write)
    .updateManyWithGeneratedKeys[TableWithGeneratedColumnsRow]("name", "name-type-always")(unsaved)(using catsStdInstancesForList, TableWithGeneratedColumnsRow.read)
  }
  /* NOTE: this functionality is not safe if you use auto-commit mode! it runs 3 SQL statements */
  override def upsertStreaming(unsaved: Stream[ConnectionIO, TableWithGeneratedColumnsRow], batchSize: Int = 10000): ConnectionIO[Int] = {
    for {
      _ <- sql"""create temporary table table-with-generated-columns_TEMP (like "public"."table-with-generated-columns") on commit drop""".update.run
      _ <- new FragmentOps(sql"""copy table-with-generated-columns_TEMP("name") from stdin""").copyIn(unsaved, batchSize)(using TableWithGeneratedColumnsRow.text)
      res <- sql"""insert into "public"."table-with-generated-columns"("name")
                   select * from table-with-generated-columns_TEMP
                   on conflict ("name")
                   do nothing
                   ;
                   drop table table-with-generated-columns_TEMP;""".update.run
    } yield res
  }
}
