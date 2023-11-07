/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package creditcard

import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoShort
import adventureworks.userdefined.CustomCreditcardId
import typo.dsl.SqlExpr.Field
import typo.dsl.SqlExpr.FieldLikeNoHkt
import typo.dsl.SqlExpr.IdField
import typo.dsl.Structure.Relation

class CreditcardStructure[Row](val prefix: Option[String], val extract: Row => CreditcardRow, val merge: (Row, CreditcardRow) => Row)
  extends Relation[CreditcardFields, CreditcardRow, Row]
    with CreditcardFields[Row] { outer =>

  override val creditcardid = new IdField[/* user-picked */ CustomCreditcardId, Row](prefix, "creditcardid", None, Some("int4"))(x => extract(x).creditcardid, (row, value) => merge(row, extract(row).copy(creditcardid = value)))
  override val cardtype = new Field[/* max 50 chars */ String, Row](prefix, "cardtype", None, None)(x => extract(x).cardtype, (row, value) => merge(row, extract(row).copy(cardtype = value)))
  override val cardnumber = new Field[/* max 25 chars */ String, Row](prefix, "cardnumber", None, None)(x => extract(x).cardnumber, (row, value) => merge(row, extract(row).copy(cardnumber = value)))
  override val expmonth = new Field[TypoShort, Row](prefix, "expmonth", None, Some("int2"))(x => extract(x).expmonth, (row, value) => merge(row, extract(row).copy(expmonth = value)))
  override val expyear = new Field[TypoShort, Row](prefix, "expyear", None, Some("int2"))(x => extract(x).expyear, (row, value) => merge(row, extract(row).copy(expyear = value)))
  override val modifieddate = new Field[TypoLocalDateTime, Row](prefix, "modifieddate", Some("text"), Some("timestamp"))(x => extract(x).modifieddate, (row, value) => merge(row, extract(row).copy(modifieddate = value)))

  override val columns: List[FieldLikeNoHkt[?, Row]] =
    List[FieldLikeNoHkt[?, Row]](creditcardid, cardtype, cardnumber, expmonth, expyear, modifieddate)

  override def copy[NewRow](prefix: Option[String], extract: NewRow => CreditcardRow, merge: (NewRow, CreditcardRow) => NewRow): CreditcardStructure[NewRow] =
    new CreditcardStructure(prefix, extract, merge)
}
