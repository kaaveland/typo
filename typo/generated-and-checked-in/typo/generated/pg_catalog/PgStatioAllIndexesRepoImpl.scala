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

object PgStatioAllIndexesRepoImpl extends PgStatioAllIndexesRepo {
  override def selectAll(implicit c: Connection): List[PgStatioAllIndexesRow] = {
    SQL"""select relid, indexrelid, schemaname, relname, indexrelname, idx_blks_read, idx_blks_hit from pg_catalog.pg_statio_all_indexes""".as(PgStatioAllIndexesRow.rowParser("").*)
  }
  override def selectByFieldValues(fieldValues: List[PgStatioAllIndexesFieldValue[_]])(implicit c: Connection): List[PgStatioAllIndexesRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case PgStatioAllIndexesFieldValue.relid(value) => NamedParameter("relid", ParameterValue.from(value))
          case PgStatioAllIndexesFieldValue.indexrelid(value) => NamedParameter("indexrelid", ParameterValue.from(value))
          case PgStatioAllIndexesFieldValue.schemaname(value) => NamedParameter("schemaname", ParameterValue.from(value))
          case PgStatioAllIndexesFieldValue.relname(value) => NamedParameter("relname", ParameterValue.from(value))
          case PgStatioAllIndexesFieldValue.indexrelname(value) => NamedParameter("indexrelname", ParameterValue.from(value))
          case PgStatioAllIndexesFieldValue.idxBlksRead(value) => NamedParameter("idx_blks_read", ParameterValue.from(value))
          case PgStatioAllIndexesFieldValue.idxBlksHit(value) => NamedParameter("idx_blks_hit", ParameterValue.from(value))
        }
        val q = s"""select * from pg_catalog.pg_statio_all_indexes where ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(" AND ")}"""
        // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
        import anorm._
        SQL(q)
          .on(namedParams: _*)
          .as(PgStatioAllIndexesRow.rowParser("").*)
    }

  }
}
