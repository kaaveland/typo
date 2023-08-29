/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_stat_all_indexes

import adventureworks.pg_catalog.pg_class.PgClassId
import typo.dsl.SqlExpr.Field
import typo.dsl.SqlExpr.OptField

trait PgStatAllIndexesViewFields[Row] {
  val relid: Field[PgClassId, Row]
  val indexrelid: Field[PgClassId, Row]
  val schemaname: OptField[String, Row]
  val relname: Field[String, Row]
  val indexrelname: Field[String, Row]
  val idxScan: OptField[Long, Row]
  val idxTupRead: OptField[Long, Row]
  val idxTupFetch: OptField[Long, Row]
}
object PgStatAllIndexesViewFields extends PgStatAllIndexesViewStructure[PgStatAllIndexesViewRow](None, identity, (_, x) => x)

