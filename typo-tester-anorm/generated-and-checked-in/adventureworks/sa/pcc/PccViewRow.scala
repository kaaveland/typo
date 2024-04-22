/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sa
package pcc

import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.person.businessentity.BusinessentityId
import adventureworks.userdefined.CustomCreditcardId
import anorm.RowParser
import anorm.Success
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.OWrites
import play.api.libs.json.Reads
import scala.collection.immutable.ListMap
import scala.util.Try

/** View: sa.pcc */
case class PccViewRow(
  /** Points to [[sales.personcreditcard.PersoncreditcardRow.businessentityid]] */
  id: BusinessentityId,
  /** Points to [[sales.personcreditcard.PersoncreditcardRow.businessentityid]] */
  businessentityid: BusinessentityId,
  /** Points to [[sales.personcreditcard.PersoncreditcardRow.creditcardid]] */
  creditcardid: /* user-picked */ CustomCreditcardId,
  /** Points to [[sales.personcreditcard.PersoncreditcardRow.modifieddate]] */
  modifieddate: TypoLocalDateTime
)

object PccViewRow {
  implicit lazy val reads: Reads[PccViewRow] = Reads[PccViewRow](json => JsResult.fromTry(
      Try(
        PccViewRow(
          id = json.\("id").as(BusinessentityId.reads),
          businessentityid = json.\("businessentityid").as(BusinessentityId.reads),
          creditcardid = json.\("creditcardid").as(CustomCreditcardId.reads),
          modifieddate = json.\("modifieddate").as(TypoLocalDateTime.reads)
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[PccViewRow] = RowParser[PccViewRow] { row =>
    Success(
      PccViewRow(
        id = row(idx + 0)(BusinessentityId.column),
        businessentityid = row(idx + 1)(BusinessentityId.column),
        creditcardid = row(idx + 2)(/* user-picked */ CustomCreditcardId.column),
        modifieddate = row(idx + 3)(TypoLocalDateTime.column)
      )
    )
  }
  implicit lazy val writes: OWrites[PccViewRow] = OWrites[PccViewRow](o =>
    new JsObject(ListMap[String, JsValue](
      "id" -> BusinessentityId.writes.writes(o.id),
      "businessentityid" -> BusinessentityId.writes.writes(o.businessentityid),
      "creditcardid" -> CustomCreditcardId.writes.writes(o.creditcardid),
      "modifieddate" -> TypoLocalDateTime.writes.writes(o.modifieddate)
    ))
  )
}
