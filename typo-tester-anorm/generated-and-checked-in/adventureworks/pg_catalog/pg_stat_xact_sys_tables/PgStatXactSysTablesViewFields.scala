/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_stat_xact_sys_tables

import typo.dsl.SqlExpr.Field

trait PgStatXactSysTablesViewFields[Row] {
  val relid: Field[/* oid */ Long, Row]
  val schemaname: Field[String, Row]
  val relname: Field[String, Row]
  val seqScan: Field[Long, Row]
  val seqTupRead: Field[Long, Row]
  val idxScan: Field[Long, Row]
  val idxTupFetch: Field[Long, Row]
  val nTupIns: Field[Long, Row]
  val nTupUpd: Field[Long, Row]
  val nTupDel: Field[Long, Row]
  val nTupHotUpd: Field[Long, Row]
}
object PgStatXactSysTablesViewFields extends PgStatXactSysTablesViewStructure[PgStatXactSysTablesViewRow](None, identity, (_, x) => x)

