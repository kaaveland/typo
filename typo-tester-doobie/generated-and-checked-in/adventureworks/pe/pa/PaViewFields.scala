/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pe
package pa

import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.person.businessentity.BusinessentityId
import java.util.UUID
import typo.dsl.SqlExpr.Field

trait PaViewFields[Row] {
  val id: Field[Int, Row]
  val businessentityid: Field[BusinessentityId, Row]
  val passwordhash: Field[/* max 128 chars */ String, Row]
  val passwordsalt: Field[/* max 10 chars */ String, Row]
  val rowguid: Field[UUID, Row]
  val modifieddate: Field[TypoLocalDateTime, Row]
}
object PaViewFields extends PaViewStructure[PaViewRow](None, identity, (_, x) => x)

