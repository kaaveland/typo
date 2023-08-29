/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pe
package ct

import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.person.contacttype.ContacttypeId
import adventureworks.public.Name
import typo.dsl.SqlExpr.Field

trait CtViewFields[Row] {
  val id: Field[ContacttypeId, Row]
  val contacttypeid: Field[ContacttypeId, Row]
  val name: Field[Name, Row]
  val modifieddate: Field[TypoLocalDateTime, Row]
}
object CtViewFields extends CtViewStructure[CtViewRow](None, identity, (_, x) => x)

