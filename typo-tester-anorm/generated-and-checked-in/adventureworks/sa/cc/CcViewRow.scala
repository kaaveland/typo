/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sa
package cc

import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.userdefined.CustomCreditcardId
import anorm.Column
import anorm.RowParser
import anorm.Success
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.OWrites
import play.api.libs.json.Reads
import play.api.libs.json.Writes
import scala.collection.immutable.ListMap
import scala.util.Try

case class CcViewRow(
  /** Points to [[sales.creditcard.CreditcardRow.creditcardid]] */
  id: /* user-picked */ CustomCreditcardId,
  /** Points to [[sales.creditcard.CreditcardRow.creditcardid]] */
  creditcardid: /* user-picked */ CustomCreditcardId,
  /** Points to [[sales.creditcard.CreditcardRow.cardtype]] */
  cardtype: /* max 50 chars */ String,
  /** Points to [[sales.creditcard.CreditcardRow.cardnumber]] */
  cardnumber: /* max 25 chars */ String,
  /** Points to [[sales.creditcard.CreditcardRow.expmonth]] */
  expmonth: Int,
  /** Points to [[sales.creditcard.CreditcardRow.expyear]] */
  expyear: Int,
  /** Points to [[sales.creditcard.CreditcardRow.modifieddate]] */
  modifieddate: TypoLocalDateTime
)

object CcViewRow {
  implicit lazy val reads: Reads[CcViewRow] = Reads[CcViewRow](json => JsResult.fromTry(
      Try(
        CcViewRow(
          id = json.\("id").as(CustomCreditcardId.reads),
          creditcardid = json.\("creditcardid").as(CustomCreditcardId.reads),
          cardtype = json.\("cardtype").as(Reads.StringReads),
          cardnumber = json.\("cardnumber").as(Reads.StringReads),
          expmonth = json.\("expmonth").as(Reads.IntReads),
          expyear = json.\("expyear").as(Reads.IntReads),
          modifieddate = json.\("modifieddate").as(TypoLocalDateTime.reads)
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[CcViewRow] = RowParser[CcViewRow] { row =>
    Success(
      CcViewRow(
        id = row(idx + 0)(/* user-picked */ CustomCreditcardId.column),
        creditcardid = row(idx + 1)(/* user-picked */ CustomCreditcardId.column),
        cardtype = row(idx + 2)(Column.columnToString),
        cardnumber = row(idx + 3)(Column.columnToString),
        expmonth = row(idx + 4)(Column.columnToInt),
        expyear = row(idx + 5)(Column.columnToInt),
        modifieddate = row(idx + 6)(TypoLocalDateTime.column)
      )
    )
  }
  implicit lazy val writes: OWrites[CcViewRow] = OWrites[CcViewRow](o =>
    new JsObject(ListMap[String, JsValue](
      "id" -> CustomCreditcardId.writes.writes(o.id),
      "creditcardid" -> CustomCreditcardId.writes.writes(o.creditcardid),
      "cardtype" -> Writes.StringWrites.writes(o.cardtype),
      "cardnumber" -> Writes.StringWrites.writes(o.cardnumber),
      "expmonth" -> Writes.IntWrites.writes(o.expmonth),
      "expyear" -> Writes.IntWrites.writes(o.expyear),
      "modifieddate" -> TypoLocalDateTime.writes.writes(o.modifieddate)
    ))
  )
}
