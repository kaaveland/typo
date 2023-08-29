/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package vsalespersonsalesbyfiscalyearsdata

import adventureworks.person.businessentity.BusinessentityId
import adventureworks.public.Name
import typo.dsl.SqlExpr.Field
import typo.dsl.SqlExpr.OptField

trait VsalespersonsalesbyfiscalyearsdataViewFields[Row] {
  val salespersonid: OptField[BusinessentityId, Row]
  val fullname: OptField[String, Row]
  val jobtitle: Field[/* max 50 chars */ String, Row]
  val salesterritory: Field[Name, Row]
  val salestotal: OptField[BigDecimal, Row]
  val fiscalyear: OptField[BigDecimal, Row]
}
object VsalespersonsalesbyfiscalyearsdataViewFields extends VsalespersonsalesbyfiscalyearsdataViewStructure[VsalespersonsalesbyfiscalyearsdataViewRow](None, identity, (_, x) => x)

