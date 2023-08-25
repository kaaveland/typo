/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sa
package tr

import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.person.stateprovince.StateprovinceId
import adventureworks.public.Name
import adventureworks.sales.salestaxrate.SalestaxrateId
import java.util.UUID
import typo.dsl.SqlExpr.Field

trait TrViewFields[Row] {
  val id: Field[Int, Row]
  val salestaxrateid: Field[SalestaxrateId, Row]
  val stateprovinceid: Field[StateprovinceId, Row]
  val taxtype: Field[Int, Row]
  val taxrate: Field[BigDecimal, Row]
  val name: Field[Name, Row]
  val rowguid: Field[UUID, Row]
  val modifieddate: Field[TypoLocalDateTime, Row]
}
object TrViewFields extends TrViewStructure[TrViewRow](None, identity, (_, x) => x)

