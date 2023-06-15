/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package personcreditcard

import adventureworks.Defaulted
import adventureworks.person.businessentity.BusinessentityId
import adventureworks.sales.creditcard.CreditcardId
import java.time.LocalDateTime
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try

/** This class corresponds to a row in table `sales.personcreditcard` which has not been persisted yet */
case class PersoncreditcardRowUnsaved(
  /** Business entity identification number. Foreign key to Person.BusinessEntityID.
      Points to [[person.person.PersonRow.businessentityid]] */
  businessentityid: BusinessentityId,
  /** Credit card identification number. Foreign key to CreditCard.CreditCardID.
      Points to [[creditcard.CreditcardRow.creditcardid]] */
  creditcardid: CreditcardId,
  /** Default: now() */
  modifieddate: Defaulted[LocalDateTime] = Defaulted.UseDefault
) {
  def toRow(modifieddateDefault: => LocalDateTime): PersoncreditcardRow =
    PersoncreditcardRow(
      businessentityid = businessentityid,
      creditcardid = creditcardid,
      modifieddate = modifieddate match {
                       case Defaulted.UseDefault => modifieddateDefault
                       case Defaulted.Provided(value) => value
                     }
    )
}
object PersoncreditcardRowUnsaved {
  implicit val oFormat: OFormat[PersoncreditcardRowUnsaved] = new OFormat[PersoncreditcardRowUnsaved]{
    override def writes(o: PersoncreditcardRowUnsaved): JsObject =
      Json.obj(
        "businessentityid" -> o.businessentityid,
        "creditcardid" -> o.creditcardid,
        "modifieddate" -> o.modifieddate
      )
  
    override def reads(json: JsValue): JsResult[PersoncreditcardRowUnsaved] = {
      JsResult.fromTry(
        Try(
          PersoncreditcardRowUnsaved(
            businessentityid = json.\("businessentityid").as[BusinessentityId],
            creditcardid = json.\("creditcardid").as[CreditcardId],
            modifieddate = json.\("modifieddate").as[Defaulted[LocalDateTime]]
          )
        )
      )
    }
  }
}