/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package scrapreason

import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.public.Name
import typo.dsl.SqlExpr.Field
import typo.dsl.SqlExpr.IdField

trait ScrapreasonFields[Row] {
  val scrapreasonid: IdField[ScrapreasonId, Row]
  val name: Field[Name, Row]
  val modifieddate: Field[TypoLocalDateTime, Row]
}
object ScrapreasonFields extends ScrapreasonStructure[ScrapreasonRow](None, identity, (_, x) => x)

