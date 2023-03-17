package testdb.pg_catalog

import anorm.NamedParameter
import anorm.ParameterValue
import anorm.SqlStringInterpolation
import java.sql.Connection

trait PgStatReplicationRepoImpl extends PgStatReplicationRepo {
  override def selectAll(implicit c: Connection): List[PgStatReplicationRow] = {
    SQL"""select pid, usesysid, usename, application_name, client_addr, client_hostname, client_port, backend_start, backend_xmin, state, sent_lsn, write_lsn, flush_lsn, replay_lsn, write_lag, flush_lag, replay_lag, sync_priority, sync_state, reply_time from pg_catalog.pg_stat_replication""".as(PgStatReplicationRow.rowParser.*)
  }
  override def selectByFieldValues(fieldValues: List[PgStatReplicationFieldValue[_]])(implicit c: Connection): List[PgStatReplicationRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case PgStatReplicationFieldValue.pid(value) => NamedParameter("pid", ParameterValue.from(value))
          case PgStatReplicationFieldValue.usesysid(value) => NamedParameter("usesysid", ParameterValue.from(value))
          case PgStatReplicationFieldValue.usename(value) => NamedParameter("usename", ParameterValue.from(value))
          case PgStatReplicationFieldValue.applicationName(value) => NamedParameter("application_name", ParameterValue.from(value))
          case PgStatReplicationFieldValue.clientAddr(value) => NamedParameter("client_addr", ParameterValue.from(value))
          case PgStatReplicationFieldValue.clientHostname(value) => NamedParameter("client_hostname", ParameterValue.from(value))
          case PgStatReplicationFieldValue.clientPort(value) => NamedParameter("client_port", ParameterValue.from(value))
          case PgStatReplicationFieldValue.backendStart(value) => NamedParameter("backend_start", ParameterValue.from(value))
          case PgStatReplicationFieldValue.backendXmin(value) => NamedParameter("backend_xmin", ParameterValue.from(value))
          case PgStatReplicationFieldValue.state(value) => NamedParameter("state", ParameterValue.from(value))
          case PgStatReplicationFieldValue.sentLsn(value) => NamedParameter("sent_lsn", ParameterValue.from(value))
          case PgStatReplicationFieldValue.writeLsn(value) => NamedParameter("write_lsn", ParameterValue.from(value))
          case PgStatReplicationFieldValue.flushLsn(value) => NamedParameter("flush_lsn", ParameterValue.from(value))
          case PgStatReplicationFieldValue.replayLsn(value) => NamedParameter("replay_lsn", ParameterValue.from(value))
          case PgStatReplicationFieldValue.writeLag(value) => NamedParameter("write_lag", ParameterValue.from(value))
          case PgStatReplicationFieldValue.flushLag(value) => NamedParameter("flush_lag", ParameterValue.from(value))
          case PgStatReplicationFieldValue.replayLag(value) => NamedParameter("replay_lag", ParameterValue.from(value))
          case PgStatReplicationFieldValue.syncPriority(value) => NamedParameter("sync_priority", ParameterValue.from(value))
          case PgStatReplicationFieldValue.syncState(value) => NamedParameter("sync_state", ParameterValue.from(value))
          case PgStatReplicationFieldValue.replyTime(value) => NamedParameter("reply_time", ParameterValue.from(value))
        }
        SQL"""select * from pg_catalog.pg_stat_replication where ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(" AND ")}"""
          .on(namedParams: _*)
          .as(PgStatReplicationRow.rowParser.*)
    }

  }
}