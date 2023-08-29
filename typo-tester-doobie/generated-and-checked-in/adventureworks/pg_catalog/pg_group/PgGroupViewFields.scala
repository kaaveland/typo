/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_group

import adventureworks.pg_catalog.pg_authid.PgAuthidId
import typo.dsl.SqlExpr.Field
import typo.dsl.SqlExpr.OptField

trait PgGroupViewFields[Row] {
  val groname: Field[String, Row]
  val grosysid: Field[PgAuthidId, Row]
  val grolist: OptField[Array[/* oid */ Long], Row]
}
object PgGroupViewFields extends PgGroupViewStructure[PgGroupViewRow](None, identity, (_, x) => x)

