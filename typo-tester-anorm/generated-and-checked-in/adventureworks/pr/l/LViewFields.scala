/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pr
package l

import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.production.location.LocationId
import adventureworks.public.Name
import typo.dsl.SqlExpr.Field

trait LViewFields[Row] {
  val id: Field[LocationId, Row]
  val locationid: Field[LocationId, Row]
  val name: Field[Name, Row]
  val costrate: Field[BigDecimal, Row]
  val availability: Field[BigDecimal, Row]
  val modifieddate: Field[TypoLocalDateTime, Row]
}
object LViewFields extends LViewStructure[LViewRow](None, identity, (_, x) => x)

