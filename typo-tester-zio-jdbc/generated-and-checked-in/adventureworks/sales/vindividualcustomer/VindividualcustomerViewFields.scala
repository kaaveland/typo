/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package vindividualcustomer

import adventureworks.customtypes.TypoXml
import adventureworks.person.businessentity.BusinessentityId
import adventureworks.public.Name
import adventureworks.public.Phone
import adventureworks.userdefined.FirstName
import typo.dsl.SqlExpr.Field
import typo.dsl.SqlExpr.OptField

trait VindividualcustomerViewFields[Row] {
  val businessentityid: Field[BusinessentityId, Row]
  val title: OptField[/* max 8 chars */ String, Row]
  val firstname: Field[/* user-picked */ FirstName, Row]
  val middlename: OptField[Name, Row]
  val lastname: Field[Name, Row]
  val suffix: OptField[/* max 10 chars */ String, Row]
  val phonenumber: OptField[Phone, Row]
  val phonenumbertype: OptField[Name, Row]
  val emailaddress: OptField[/* max 50 chars */ String, Row]
  val emailpromotion: Field[Int, Row]
  val addresstype: Field[Name, Row]
  val addressline1: Field[/* max 60 chars */ String, Row]
  val addressline2: OptField[/* max 60 chars */ String, Row]
  val city: Field[/* max 30 chars */ String, Row]
  val stateprovincename: Field[Name, Row]
  val postalcode: Field[/* max 15 chars */ String, Row]
  val countryregionname: Field[Name, Row]
  val demographics: OptField[TypoXml, Row]
}
object VindividualcustomerViewFields extends VindividualcustomerViewStructure[VindividualcustomerViewRow](None, identity, (_, x) => x)

