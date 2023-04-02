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

object PgReplicationOriginStatusRepoImpl extends PgReplicationOriginStatusRepo {
  override def selectAll(implicit c: Connection): List[PgReplicationOriginStatusRow] = {
    SQL"""select local_id, external_id, remote_lsn, local_lsn from pg_catalog.pg_replication_origin_status""".as(PgReplicationOriginStatusRow.rowParser("").*)
  }
  override def selectByFieldValues(fieldValues: List[PgReplicationOriginStatusFieldValue[_]])(implicit c: Connection): List[PgReplicationOriginStatusRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case PgReplicationOriginStatusFieldValue.localId(value) => NamedParameter("local_id", ParameterValue.from(value))
          case PgReplicationOriginStatusFieldValue.externalId(value) => NamedParameter("external_id", ParameterValue.from(value))
          case PgReplicationOriginStatusFieldValue.remoteLsn(value) => NamedParameter("remote_lsn", ParameterValue.from(value))
          case PgReplicationOriginStatusFieldValue.localLsn(value) => NamedParameter("local_lsn", ParameterValue.from(value))
        }
        val q = s"""select * from pg_catalog.pg_replication_origin_status where ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(" AND ")}"""
        // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
        import anorm._
        SQL(q)
          .on(namedParams: _*)
          .as(PgReplicationOriginStatusRow.rowParser("").*)
    }

  }
}
