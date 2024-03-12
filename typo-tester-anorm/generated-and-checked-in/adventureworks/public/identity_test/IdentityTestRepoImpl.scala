/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package public
package identity_test

import adventureworks.customtypes.Defaulted
import adventureworks.streamingInsert
import anorm.NamedParameter
import anorm.ParameterValue
import anorm.RowParser
import anorm.SQL
import anorm.SimpleSql
import anorm.SqlStringInterpolation
import anorm.ToStatement
import java.sql.Connection
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql
import typo.dsl.UpdateBuilder

class IdentityTestRepoImpl extends IdentityTestRepo {
  override def delete(name: IdentityTestId)(implicit c: Connection): Boolean = {
    SQL"""delete from public.identity-test where "name" = ${ParameterValue(name, null, IdentityTestId.toStatement)}""".executeUpdate() > 0
  }
  override def delete: DeleteBuilder[IdentityTestFields, IdentityTestRow] = {
    DeleteBuilder("public.identity-test", IdentityTestFields.structure)
  }
  override def insert(unsaved: IdentityTestRow)(implicit c: Connection): IdentityTestRow = {
    SQL"""insert into public.identity-test("always_generated", "default_generated", "name")
          values (${ParameterValue(unsaved.alwaysGenerated, null, ToStatement.intToStatement)}::int4, ${ParameterValue(unsaved.defaultGenerated, null, ToStatement.intToStatement)}::int4, ${ParameterValue(unsaved.name, null, IdentityTestId.toStatement)})
          returning "always_generated", "default_generated", "name"
       """
      .executeInsert(IdentityTestRow.rowParser(1).single)
    
  }
  override def insertStreaming(unsaved: Iterator[IdentityTestRow], batchSize: Int)(implicit c: Connection): Long = {
    streamingInsert(s"""COPY public.identity-test("always_generated", "default_generated", "name") FROM STDIN""", batchSize, unsaved)(IdentityTestRow.text, c)
  }
  override def insert(unsaved: IdentityTestRowUnsaved)(implicit c: Connection): IdentityTestRow = {
    val namedParameters = List(
      Some((NamedParameter("name", ParameterValue(unsaved.name, null, IdentityTestId.toStatement)), "")),
      unsaved.defaultGenerated match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("default_generated", ParameterValue(value, null, ToStatement.intToStatement)), "::int4"))
      }
    ).flatten
    val quote = '"'.toString
    if (namedParameters.isEmpty) {
      SQL"""insert into public.identity-test default values
            returning "always_generated", "default_generated", "name"
         """
        .executeInsert(IdentityTestRow.rowParser(1).single)
    } else {
      val q = s"""insert into public.identity-test(${namedParameters.map{case (x, _) => quote + x.name + quote}.mkString(", ")})
                  values (${namedParameters.map{ case (np, cast) => s"{${np.name}}$cast"}.mkString(", ")})
                  returning "always_generated", "default_generated", "name"
               """
      SimpleSql(SQL(q), namedParameters.map { case (np, _) => np.tupled }.toMap, RowParser.successful)
        .executeInsert(IdentityTestRow.rowParser(1).single)
    }
    
  }
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  override def insertUnsavedStreaming(unsaved: Iterator[IdentityTestRowUnsaved], batchSize: Int)(implicit c: Connection): Long = {
    streamingInsert(s"""COPY public.identity-test("name", "default_generated") FROM STDIN (DEFAULT '__DEFAULT_VALUE__')""", batchSize, unsaved)(IdentityTestRowUnsaved.text, c)
  }
  override def select: SelectBuilder[IdentityTestFields, IdentityTestRow] = {
    SelectBuilderSql("public.identity-test", IdentityTestFields.structure, IdentityTestRow.rowParser)
  }
  override def selectAll(implicit c: Connection): List[IdentityTestRow] = {
    SQL"""select "always_generated", "default_generated", "name"
          from public.identity-test
       """.as(IdentityTestRow.rowParser(1).*)
  }
  override def selectById(name: IdentityTestId)(implicit c: Connection): Option[IdentityTestRow] = {
    SQL"""select "always_generated", "default_generated", "name"
          from public.identity-test
          where "name" = ${ParameterValue(name, null, IdentityTestId.toStatement)}
       """.as(IdentityTestRow.rowParser(1).singleOpt)
  }
  override def selectByIds(names: Array[IdentityTestId])(implicit c: Connection): List[IdentityTestRow] = {
    SQL"""select "always_generated", "default_generated", "name"
          from public.identity-test
          where "name" = ANY(${names})
       """.as(IdentityTestRow.rowParser(1).*)
    
  }
  override def update(row: IdentityTestRow)(implicit c: Connection): Boolean = {
    val name = row.name
    SQL"""update public.identity-test
          set "always_generated" = ${ParameterValue(row.alwaysGenerated, null, ToStatement.intToStatement)}::int4,
              "default_generated" = ${ParameterValue(row.defaultGenerated, null, ToStatement.intToStatement)}::int4
          where "name" = ${ParameterValue(name, null, IdentityTestId.toStatement)}
       """.executeUpdate() > 0
  }
  override def update: UpdateBuilder[IdentityTestFields, IdentityTestRow] = {
    UpdateBuilder("public.identity-test", IdentityTestFields.structure, IdentityTestRow.rowParser)
  }
  override def upsert(unsaved: IdentityTestRow)(implicit c: Connection): IdentityTestRow = {
    SQL"""insert into public.identity-test("always_generated", "default_generated", "name")
          values (
            ${ParameterValue(unsaved.alwaysGenerated, null, ToStatement.intToStatement)}::int4,
            ${ParameterValue(unsaved.defaultGenerated, null, ToStatement.intToStatement)}::int4,
            ${ParameterValue(unsaved.name, null, IdentityTestId.toStatement)}
          )
          on conflict ("name")
          do update set
            "always_generated" = EXCLUDED."always_generated",
            "default_generated" = EXCLUDED."default_generated"
          returning "always_generated", "default_generated", "name"
       """
      .executeInsert(IdentityTestRow.rowParser(1).single)
    
  }
}
