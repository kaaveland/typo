package testdb
package postgres
package pg_catalog

import anorm.NamedParameter
import anorm.ParameterValue
import anorm.SqlStringInterpolation
import java.sql.Connection

trait PgStatXactSysTablesRepoImpl extends PgStatXactSysTablesRepo {
  override def selectAll(implicit c: Connection): List[PgStatXactSysTablesRow] = {
    SQL"""select relid, schemaname, relname, seq_scan, seq_tup_read, idx_scan, idx_tup_fetch, n_tup_ins, n_tup_upd, n_tup_del, n_tup_hot_upd from pg_catalog.pg_stat_xact_sys_tables""".as(PgStatXactSysTablesRow.rowParser.*)
  }
  override def selectByFieldValues(fieldValues: List[PgStatXactSysTablesFieldValue[_]])(implicit c: Connection): List[PgStatXactSysTablesRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case PgStatXactSysTablesFieldValue.relid(value) => NamedParameter("relid", ParameterValue.from(value))
          case PgStatXactSysTablesFieldValue.schemaname(value) => NamedParameter("schemaname", ParameterValue.from(value))
          case PgStatXactSysTablesFieldValue.relname(value) => NamedParameter("relname", ParameterValue.from(value))
          case PgStatXactSysTablesFieldValue.seqScan(value) => NamedParameter("seq_scan", ParameterValue.from(value))
          case PgStatXactSysTablesFieldValue.seqTupRead(value) => NamedParameter("seq_tup_read", ParameterValue.from(value))
          case PgStatXactSysTablesFieldValue.idxScan(value) => NamedParameter("idx_scan", ParameterValue.from(value))
          case PgStatXactSysTablesFieldValue.idxTupFetch(value) => NamedParameter("idx_tup_fetch", ParameterValue.from(value))
          case PgStatXactSysTablesFieldValue.nTupIns(value) => NamedParameter("n_tup_ins", ParameterValue.from(value))
          case PgStatXactSysTablesFieldValue.nTupUpd(value) => NamedParameter("n_tup_upd", ParameterValue.from(value))
          case PgStatXactSysTablesFieldValue.nTupDel(value) => NamedParameter("n_tup_del", ParameterValue.from(value))
          case PgStatXactSysTablesFieldValue.nTupHotUpd(value) => NamedParameter("n_tup_hot_upd", ParameterValue.from(value))
        }
        SQL"""select * from pg_catalog.pg_stat_xact_sys_tables where ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(" AND ")}"""
          .on(namedParams: _*)
          .as(PgStatXactSysTablesRow.rowParser.*)
    }

  }
}