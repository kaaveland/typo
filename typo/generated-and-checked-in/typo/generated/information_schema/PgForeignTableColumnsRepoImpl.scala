/**
 * File has been automatically generated by `typo` for internal use.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 *
 * (If you're developing `typo` and want to change it: run `bleep generate-sources`)
 */
package typo
package generated
package information_schema

import anorm.NamedParameter
import anorm.ParameterValue
import anorm.SqlStringInterpolation
import java.sql.Connection

object PgForeignTableColumnsRepoImpl extends PgForeignTableColumnsRepo {
  override def selectAll(implicit c: Connection): List[PgForeignTableColumnsRow] = {
    SQL"""select nspname, relname, attname, attfdwoptions from information_schema._pg_foreign_table_columns""".as(PgForeignTableColumnsRow.rowParser("").*)
  }
  override def selectByFieldValues(fieldValues: List[PgForeignTableColumnsFieldValue[_]])(implicit c: Connection): List[PgForeignTableColumnsRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case PgForeignTableColumnsFieldValue.nspname(value) => NamedParameter("nspname", ParameterValue.from(value))
          case PgForeignTableColumnsFieldValue.relname(value) => NamedParameter("relname", ParameterValue.from(value))
          case PgForeignTableColumnsFieldValue.attname(value) => NamedParameter("attname", ParameterValue.from(value))
          case PgForeignTableColumnsFieldValue.attfdwoptions(value) => NamedParameter("attfdwoptions", ParameterValue.from(value))
        }
        val q = s"""select * from information_schema._pg_foreign_table_columns where ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(" AND ")}"""
        // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
        import anorm._
        SQL(q)
          .on(namedParams: _*)
          .as(PgForeignTableColumnsRow.rowParser("").*)
    }

  }
}
