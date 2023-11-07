/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package person
package personphone

import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.person.businessentity.BusinessentityId
import adventureworks.person.phonenumbertype.PhonenumbertypeId
import adventureworks.public.Phone
import typo.dsl.SqlExpr.Field
import typo.dsl.SqlExpr.IdField

trait PersonphoneFields[Row] {
  val businessentityid: IdField[BusinessentityId, Row]
  val phonenumber: IdField[Phone, Row]
  val phonenumbertypeid: IdField[PhonenumbertypeId, Row]
  val modifieddate: Field[TypoLocalDateTime, Row]
}
object PersonphoneFields extends PersonphoneStructure[PersonphoneRow](None, identity, (_, x) => x)

