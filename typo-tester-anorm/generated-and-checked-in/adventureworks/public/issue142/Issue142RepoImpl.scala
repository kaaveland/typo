/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package public
package issue142

import anorm.BatchSql
import anorm.NamedParameter
import anorm.ParameterValue
import anorm.SqlStringInterpolation
import java.sql.Connection
import scala.annotation.nowarn
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql
import typo.dsl.UpdateBuilder

class Issue142RepoImpl extends Issue142Repo {
  override def delete: DeleteBuilder[Issue142Fields, Issue142Row] = {
    DeleteBuilder(""""public"."issue142"""", Issue142Fields.structure)
  }
  override def deleteById(tabellkode: Issue142Id)(implicit c: Connection): Boolean = {
    SQL"""delete from "public"."issue142" where "tabellkode" = ${ParameterValue(tabellkode, null, Issue142Id.toStatement)}""".executeUpdate() > 0
  }
  override def deleteByIds(tabellkodes: Array[Issue142Id])(implicit c: Connection): Int = {
    SQL"""delete
          from "public"."issue142"
          where "tabellkode" = ANY(${tabellkodes})
       """.executeUpdate()
    
  }
  override def insert(unsaved: Issue142Row)(implicit c: Connection): Issue142Row = {
    SQL"""insert into "public"."issue142"("tabellkode")
          values (${ParameterValue(unsaved.tabellkode, null, Issue142Id.toStatement)})
          returning "tabellkode"
       """
      .executeInsert(Issue142Row.rowParser(1).single)
    
  }
  override def insertStreaming(unsaved: Iterator[Issue142Row], batchSize: Int = 10000)(implicit c: Connection): Long = {
    streamingInsert(s"""COPY "public"."issue142"("tabellkode") FROM STDIN""", batchSize, unsaved)(Issue142Row.text, c)
  }
  override def select: SelectBuilder[Issue142Fields, Issue142Row] = {
    SelectBuilderSql(""""public"."issue142"""", Issue142Fields.structure, Issue142Row.rowParser)
  }
  override def selectAll(implicit c: Connection): List[Issue142Row] = {
    SQL"""select "tabellkode"
          from "public"."issue142"
       """.as(Issue142Row.rowParser(1).*)
  }
  override def selectById(tabellkode: Issue142Id)(implicit c: Connection): Option[Issue142Row] = {
    SQL"""select "tabellkode"
          from "public"."issue142"
          where "tabellkode" = ${ParameterValue(tabellkode, null, Issue142Id.toStatement)}
       """.as(Issue142Row.rowParser(1).singleOpt)
  }
  override def selectByIds(tabellkodes: Array[Issue142Id])(implicit c: Connection): List[Issue142Row] = {
    SQL"""select "tabellkode"
          from "public"."issue142"
          where "tabellkode" = ANY(${tabellkodes})
       """.as(Issue142Row.rowParser(1).*)
    
  }
  override def selectByIdsTracked(tabellkodes: Array[Issue142Id])(implicit c: Connection): Map[Issue142Id, Issue142Row] = {
    val byId = selectByIds(tabellkodes).view.map(x => (x.tabellkode, x)).toMap
    tabellkodes.view.flatMap(id => byId.get(id).map(x => (id, x))).toMap
  }
  override def update: UpdateBuilder[Issue142Fields, Issue142Row] = {
    UpdateBuilder(""""public"."issue142"""", Issue142Fields.structure, Issue142Row.rowParser)
  }
  override def upsert(unsaved: Issue142Row)(implicit c: Connection): Issue142Row = {
    SQL"""insert into "public"."issue142"("tabellkode")
          values (
            ${ParameterValue(unsaved.tabellkode, null, Issue142Id.toStatement)}
          )
          on conflict ("tabellkode")
          do nothing
          returning "tabellkode"
       """
      .executeInsert(Issue142Row.rowParser(1).single)
    
  }
  override def upsertBatch(unsaved: Iterable[Issue142Row])(implicit c: Connection): List[Issue142Row] = {
    def toNamedParameter(row: Issue142Row): List[NamedParameter] = List(
      NamedParameter("tabellkode", ParameterValue(row.tabellkode, null, Issue142Id.toStatement))
    )
    unsaved.toList match {
      case Nil => Nil
      case head :: rest =>
        new anorm.adventureworks.ExecuteReturningSyntax.Ops(
          BatchSql(
            s"""insert into "public"."issue142"("tabellkode")
                values ({tabellkode})
                on conflict ("tabellkode")
                do nothing
                returning "tabellkode"
             """,
            toNamedParameter(head),
            rest.map(toNamedParameter)*
          )
        ).executeReturning(Issue142Row.rowParser(1).*)
    }
  }
  /* NOTE: this functionality is not safe if you use auto-commit mode! it runs 3 SQL statements */
  override def upsertStreaming(unsaved: Iterator[Issue142Row], batchSize: Int = 10000)(implicit c: Connection): Int = {
    SQL"""create temporary table issue142_TEMP (like "public"."issue142") on commit drop""".execute(): @nowarn
    streamingInsert(s"""copy issue142_TEMP("tabellkode") from stdin""", batchSize, unsaved)(Issue142Row.text, c): @nowarn
    SQL"""insert into "public"."issue142"("tabellkode")
          select * from issue142_TEMP
          on conflict ("tabellkode")
          do nothing
          ;
          drop table issue142_TEMP;""".executeUpdate()
  }
}
