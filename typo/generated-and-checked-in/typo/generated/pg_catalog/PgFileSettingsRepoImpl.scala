/**
 * File has been automatically generated by `typo` for internal use.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 *
 * (If you're developing `typo` and want to change it: run `bleep generate-sources`)
 */
package typo
package generated
package pg_catalog

import anorm.NamedParameter
import anorm.ParameterValue
import anorm.SqlStringInterpolation
import java.sql.Connection

object PgFileSettingsRepoImpl extends PgFileSettingsRepo {
  override def selectAll(implicit c: Connection): List[PgFileSettingsRow] = {
    SQL"""select sourcefile, sourceline, seqno, name, setting, applied, error from pg_catalog.pg_file_settings""".as(PgFileSettingsRow.rowParser("").*)
  }
  override def selectByFieldValues(fieldValues: List[PgFileSettingsFieldValue[_]])(implicit c: Connection): List[PgFileSettingsRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case PgFileSettingsFieldValue.sourcefile(value) => NamedParameter("sourcefile", ParameterValue.from(value))
          case PgFileSettingsFieldValue.sourceline(value) => NamedParameter("sourceline", ParameterValue.from(value))
          case PgFileSettingsFieldValue.seqno(value) => NamedParameter("seqno", ParameterValue.from(value))
          case PgFileSettingsFieldValue.name(value) => NamedParameter("name", ParameterValue.from(value))
          case PgFileSettingsFieldValue.setting(value) => NamedParameter("setting", ParameterValue.from(value))
          case PgFileSettingsFieldValue.applied(value) => NamedParameter("applied", ParameterValue.from(value))
          case PgFileSettingsFieldValue.error(value) => NamedParameter("error", ParameterValue.from(value))
        }
        val q = s"""select * from pg_catalog.pg_file_settings where ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(" AND ")}"""
        // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
        import anorm._
        SQL(q)
          .on(namedParams: _*)
          .as(PgFileSettingsRow.rowParser("").*)
    }

  }
}
