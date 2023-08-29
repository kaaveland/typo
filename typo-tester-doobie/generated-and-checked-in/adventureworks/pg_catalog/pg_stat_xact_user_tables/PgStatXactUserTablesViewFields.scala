/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_stat_xact_user_tables

import adventureworks.pg_catalog.pg_class.PgClassId
import typo.dsl.SqlExpr.OptField

trait PgStatXactUserTablesViewFields[Row] {
  val relid: OptField[PgClassId, Row]
  val schemaname: OptField[String, Row]
  val relname: OptField[String, Row]
  val seqScan: OptField[/* nullability unknown */ Long, Row]
  val seqTupRead: OptField[/* nullability unknown */ Long, Row]
  val idxScan: OptField[/* nullability unknown */ Long, Row]
  val idxTupFetch: OptField[/* nullability unknown */ Long, Row]
  val nTupIns: OptField[/* nullability unknown */ Long, Row]
  val nTupUpd: OptField[/* nullability unknown */ Long, Row]
  val nTupDel: OptField[/* nullability unknown */ Long, Row]
  val nTupHotUpd: OptField[/* nullability unknown */ Long, Row]
}
object PgStatXactUserTablesViewFields extends PgStatXactUserTablesViewStructure[PgStatXactUserTablesViewRow](None, identity, (_, x) => x)

