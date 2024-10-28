/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package public
package table_with_generated_columns

import anorm.BatchSql
import anorm.NamedParameter
import anorm.ParameterValue
import anorm.RowParser
import anorm.SQL
import anorm.SimpleSql
import anorm.SqlStringInterpolation
import java.sql.Connection
import scala.annotation.nowarn
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql
import typo.dsl.UpdateBuilder

class TableWithGeneratedColumnsRepoImpl extends TableWithGeneratedColumnsRepo {
  override def delete: DeleteBuilder[TableWithGeneratedColumnsFields, TableWithGeneratedColumnsRow] = {
    DeleteBuilder(""""public"."table-with-generated-columns"""", TableWithGeneratedColumnsFields.structure)
  }
  override def deleteById(name: TableWithGeneratedColumnsId)(implicit c: Connection): Boolean = {
    SQL"""delete from "public"."table-with-generated-columns" where "name" = ${ParameterValue(name, null, TableWithGeneratedColumnsId.toStatement)}""".executeUpdate() > 0
  }
  override def deleteByIds(names: Array[TableWithGeneratedColumnsId])(implicit c: Connection): Int = {
    SQL"""delete
          from "public"."table-with-generated-columns"
          where "name" = ANY(${names})
       """.executeUpdate()
    
  }
  override def insert(unsaved: TableWithGeneratedColumnsRow)(implicit c: Connection): TableWithGeneratedColumnsRow = {
    SQL"""insert into "public"."table-with-generated-columns"("name")
          values (${ParameterValue(unsaved.name, null, TableWithGeneratedColumnsId.toStatement)})
          returning "name", "name-type-always"
       """
      .executeInsert(TableWithGeneratedColumnsRow.rowParser(1).single)
    
  }
  override def insert(unsaved: TableWithGeneratedColumnsRowUnsaved)(implicit c: Connection): TableWithGeneratedColumnsRow = {
    val namedParameters = List(
      Some((NamedParameter("name", ParameterValue(unsaved.name, null, TableWithGeneratedColumnsId.toStatement)), ""))
    ).flatten
    val quote = '"'.toString
    if (namedParameters.isEmpty) {
      SQL"""insert into "public"."table-with-generated-columns" default values
            returning "name", "name-type-always"
         """
        .executeInsert(TableWithGeneratedColumnsRow.rowParser(1).single)
    } else {
      val q = s"""insert into "public"."table-with-generated-columns"(${namedParameters.map{case (x, _) => quote + x.name + quote}.mkString(", ")})
                  values (${namedParameters.map{ case (np, cast) => s"{${np.name}}$cast"}.mkString(", ")})
                  returning "name", "name-type-always"
               """
      SimpleSql(SQL(q), namedParameters.map { case (np, _) => np.tupled }.toMap, RowParser.successful)
        .executeInsert(TableWithGeneratedColumnsRow.rowParser(1).single)
    }
    
  }
  override def insertStreaming(unsaved: Iterator[TableWithGeneratedColumnsRow], batchSize: Int = 10000)(implicit c: Connection): Long = {
    streamingInsert(s"""COPY "public"."table-with-generated-columns"("name") FROM STDIN""", batchSize, unsaved)(TableWithGeneratedColumnsRow.text, c)
  }
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  override def insertUnsavedStreaming(unsaved: Iterator[TableWithGeneratedColumnsRowUnsaved], batchSize: Int = 10000)(implicit c: Connection): Long = {
    streamingInsert(s"""COPY "public"."table-with-generated-columns"("name") FROM STDIN (DEFAULT '__DEFAULT_VALUE__')""", batchSize, unsaved)(TableWithGeneratedColumnsRowUnsaved.text, c)
  }
  override def select: SelectBuilder[TableWithGeneratedColumnsFields, TableWithGeneratedColumnsRow] = {
    SelectBuilderSql(""""public"."table-with-generated-columns"""", TableWithGeneratedColumnsFields.structure, TableWithGeneratedColumnsRow.rowParser)
  }
  override def selectAll(implicit c: Connection): List[TableWithGeneratedColumnsRow] = {
    SQL"""select "name", "name-type-always"
          from "public"."table-with-generated-columns"
       """.as(TableWithGeneratedColumnsRow.rowParser(1).*)
  }
  override def selectById(name: TableWithGeneratedColumnsId)(implicit c: Connection): Option[TableWithGeneratedColumnsRow] = {
    SQL"""select "name", "name-type-always"
          from "public"."table-with-generated-columns"
          where "name" = ${ParameterValue(name, null, TableWithGeneratedColumnsId.toStatement)}
       """.as(TableWithGeneratedColumnsRow.rowParser(1).singleOpt)
  }
  override def selectByIds(names: Array[TableWithGeneratedColumnsId])(implicit c: Connection): List[TableWithGeneratedColumnsRow] = {
    SQL"""select "name", "name-type-always"
          from "public"."table-with-generated-columns"
          where "name" = ANY(${names})
       """.as(TableWithGeneratedColumnsRow.rowParser(1).*)
    
  }
  override def selectByIdsTracked(names: Array[TableWithGeneratedColumnsId])(implicit c: Connection): Map[TableWithGeneratedColumnsId, TableWithGeneratedColumnsRow] = {
    val byId = selectByIds(names).view.map(x => (x.name, x)).toMap
    names.view.flatMap(id => byId.get(id).map(x => (id, x))).toMap
  }
  override def update: UpdateBuilder[TableWithGeneratedColumnsFields, TableWithGeneratedColumnsRow] = {
    UpdateBuilder(""""public"."table-with-generated-columns"""", TableWithGeneratedColumnsFields.structure, TableWithGeneratedColumnsRow.rowParser)
  }
  override def upsert(unsaved: TableWithGeneratedColumnsRow)(implicit c: Connection): TableWithGeneratedColumnsRow = {
    SQL"""insert into "public"."table-with-generated-columns"("name")
          values (
            ${ParameterValue(unsaved.name, null, TableWithGeneratedColumnsId.toStatement)}
          )
          on conflict ("name")
          do update set "name" = EXCLUDED."name"
          returning "name", "name-type-always"
       """
      .executeInsert(TableWithGeneratedColumnsRow.rowParser(1).single)
    
  }
  override def upsertBatch(unsaved: Iterable[TableWithGeneratedColumnsRow])(implicit c: Connection): List[TableWithGeneratedColumnsRow] = {
    def toNamedParameter(row: TableWithGeneratedColumnsRow): List[NamedParameter] = List(
      NamedParameter("name", ParameterValue(row.name, null, TableWithGeneratedColumnsId.toStatement))
    )
    unsaved.toList match {
      case Nil => Nil
      case head :: rest =>
        new anorm.adventureworks.ExecuteReturningSyntax.Ops(
          BatchSql(
            s"""insert into "public"."table-with-generated-columns"("name")
                values ({name})
                on conflict ("name")
                do nothing
                returning "name", "name-type-always"
             """,
            toNamedParameter(head),
            rest.map(toNamedParameter)*
          )
        ).executeReturning(TableWithGeneratedColumnsRow.rowParser(1).*)
    }
  }
  /* NOTE: this functionality is not safe if you use auto-commit mode! it runs 3 SQL statements */
  override def upsertStreaming(unsaved: Iterator[TableWithGeneratedColumnsRow], batchSize: Int = 10000)(implicit c: Connection): Int = {
    SQL"""create temporary table table-with-generated-columns_TEMP (like "public"."table-with-generated-columns") on commit drop""".execute(): @nowarn
    streamingInsert(s"""copy table-with-generated-columns_TEMP("name") from stdin""", batchSize, unsaved)(TableWithGeneratedColumnsRow.text, c): @nowarn
    SQL"""insert into "public"."table-with-generated-columns"("name")
          select * from table-with-generated-columns_TEMP
          on conflict ("name")
          do nothing
          ;
          drop table table-with-generated-columns_TEMP;""".executeUpdate()
  }
}
