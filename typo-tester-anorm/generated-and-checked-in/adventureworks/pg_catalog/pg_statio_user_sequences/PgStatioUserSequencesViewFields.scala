/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_statio_user_sequences

import adventureworks.pg_catalog.pg_class.PgClassId
import typo.dsl.SqlExpr.OptField

trait PgStatioUserSequencesViewFields[Row] {
  val relid: OptField[PgClassId, Row]
  val schemaname: OptField[String, Row]
  val relname: OptField[String, Row]
  val blksRead: OptField[/* nullability unknown */ Long, Row]
  val blksHit: OptField[/* nullability unknown */ Long, Row]
}
object PgStatioUserSequencesViewFields extends PgStatioUserSequencesViewStructure[PgStatioUserSequencesViewRow](None, identity, (_, x) => x)

