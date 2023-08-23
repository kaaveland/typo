/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package personcreditcard

import adventureworks.customtype.CustomCreditcardId
import adventureworks.person.businessentity.BusinessentityId
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.OWrites
import play.api.libs.json.Reads
import scala.collection.immutable.ListMap
import scala.util.Try

/** Type for the composite primary key of table `sales.personcreditcard` */
case class PersoncreditcardId(businessentityid: BusinessentityId, creditcardid: /* user-picked */ CustomCreditcardId)
object PersoncreditcardId {
  implicit lazy val ordering: Ordering[PersoncreditcardId] = Ordering.by(x => (x.businessentityid, x.creditcardid))
  implicit lazy val reads: Reads[PersoncreditcardId] = Reads[PersoncreditcardId](json => JsResult.fromTry(
      Try(
        PersoncreditcardId(
          businessentityid = json.\("businessentityid").as(BusinessentityId.reads),
          creditcardid = json.\("creditcardid").as(CustomCreditcardId.reads)
        )
      )
    ),
  )
  implicit lazy val writes: OWrites[PersoncreditcardId] = OWrites[PersoncreditcardId](o =>
    new JsObject(ListMap[String, JsValue](
      "businessentityid" -> BusinessentityId.writes.writes(o.businessentityid),
      "creditcardid" -> CustomCreditcardId.writes.writes(o.creditcardid)
    ))
  )
}
