/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_stat_gssapi

import typo.dsl.SqlExpr.Field

trait PgStatGssapiViewFields[Row] {
  val pid: Field[Int, Row]
  val gssAuthenticated: Field[Boolean, Row]
  val principal: Field[String, Row]
  val encrypted: Field[Boolean, Row]
}
object PgStatGssapiViewFields extends PgStatGssapiViewStructure[PgStatGssapiViewRow](None, identity, (_, x) => x)

