/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_user_mappings

import typo.dsl.SqlExpr.Field

trait PgUserMappingsViewFields[Row] {
  val umid: Field[/* oid */ Long, Row]
  val srvid: Field[/* oid */ Long, Row]
  val srvname: Field[String, Row]
  val umuser: Field[/* oid */ Long, Row]
  val usename: Field[String, Row]
  val umoptions: Field[Array[String], Row]
}
object PgUserMappingsViewFields extends PgUserMappingsViewStructure[PgUserMappingsViewRow](None, identity, (_, x) => x)

