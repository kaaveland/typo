/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pr
package um

import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.production.unitmeasure.UnitmeasureId
import adventureworks.public.Name
import typo.dsl.SqlExpr.Field

trait UmViewFields[Row] {
  val id: Field[/* bpchar, max 3 chars */ String, Row]
  val unitmeasurecode: Field[UnitmeasureId, Row]
  val name: Field[Name, Row]
  val modifieddate: Field[TypoLocalDateTime, Row]
}
object UmViewFields extends UmViewStructure[UmViewRow](None, identity, (_, x) => x)

