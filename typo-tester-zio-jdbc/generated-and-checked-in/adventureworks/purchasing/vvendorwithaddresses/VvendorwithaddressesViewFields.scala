/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package purchasing
package vvendorwithaddresses

import adventureworks.person.businessentity.BusinessentityId
import adventureworks.public.Name
import typo.dsl.SqlExpr.Field
import typo.dsl.SqlExpr.OptField

trait VvendorwithaddressesViewFields[Row] {
  val businessentityid: Field[BusinessentityId, Row]
  val name: Field[Name, Row]
  val addresstype: Field[Name, Row]
  val addressline1: Field[/* max 60 chars */ String, Row]
  val addressline2: OptField[/* max 60 chars */ String, Row]
  val city: Field[/* max 30 chars */ String, Row]
  val stateprovincename: Field[Name, Row]
  val postalcode: Field[/* max 15 chars */ String, Row]
  val countryregionname: Field[Name, Row]
}
object VvendorwithaddressesViewFields extends VvendorwithaddressesViewStructure[VvendorwithaddressesViewRow](None, identity, (_, x) => x)
