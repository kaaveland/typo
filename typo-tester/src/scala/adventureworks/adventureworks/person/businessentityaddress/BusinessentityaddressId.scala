/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package person
package businessentityaddress

import adventureworks.person.address.AddressId
import adventureworks.person.addresstype.AddresstypeId
import adventureworks.person.businessentity.BusinessentityId
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try

/** Type for the composite primary key of table `person.businessentityaddress` */
case class BusinessentityaddressId(businessentityid: BusinessentityId, addressid: AddressId, addresstypeid: AddresstypeId)
object BusinessentityaddressId {
  implicit def ordering: Ordering[BusinessentityaddressId] = Ordering.by(x => (x.businessentityid, x.addressid, x.addresstypeid))
  implicit val oFormat: OFormat[BusinessentityaddressId] = new OFormat[BusinessentityaddressId]{
    override def writes(o: BusinessentityaddressId): JsObject =
      Json.obj(
        "businessentityid" -> o.businessentityid,
        "addressid" -> o.addressid,
        "addresstypeid" -> o.addresstypeid
      )
  
    override def reads(json: JsValue): JsResult[BusinessentityaddressId] = {
      JsResult.fromTry(
        Try(
          BusinessentityaddressId(
            businessentityid = json.\("businessentityid").as[BusinessentityId],
            addressid = json.\("addressid").as[AddressId],
            addresstypeid = json.\("addresstypeid").as[AddresstypeId]
          )
        )
      )
    }
  }
}