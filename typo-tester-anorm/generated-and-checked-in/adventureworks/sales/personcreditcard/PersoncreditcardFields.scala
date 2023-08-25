/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package personcreditcard

import adventureworks.TypoLocalDateTime
import adventureworks.customtype.CustomCreditcardId
import adventureworks.person.businessentity.BusinessentityId
import typo.dsl.SqlExpr.Field
import typo.dsl.SqlExpr.IdField

trait PersoncreditcardFields[Row] {
  val businessentityid: IdField[BusinessentityId, Row]
  val creditcardid: IdField[/* user-picked */ CustomCreditcardId, Row]
  val modifieddate: Field[TypoLocalDateTime, Row]
}
object PersoncreditcardFields extends PersoncreditcardStructure[PersoncreditcardRow](None, identity, (_, x) => x)
