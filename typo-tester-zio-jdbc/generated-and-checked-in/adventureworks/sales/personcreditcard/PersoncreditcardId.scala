/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package personcreditcard

import adventureworks.person.businessentity.BusinessentityId
import adventureworks.userdefined.CustomCreditcardId
import zio.json.JsonDecoder
import zio.json.JsonEncoder
import zio.json.ast.Json
import zio.json.internal.Write

/** Type for the composite primary key of table `sales.personcreditcard` */
case class PersoncreditcardId(
  businessentityid: BusinessentityId,
  creditcardid: /* user-picked */ CustomCreditcardId
)
object PersoncreditcardId {
  implicit lazy val jsonDecoder: JsonDecoder[PersoncreditcardId] = JsonDecoder[Json.Obj].mapOrFail { jsonObj =>
    val businessentityid = jsonObj.get("businessentityid").toRight("Missing field 'businessentityid'").flatMap(_.as(BusinessentityId.jsonDecoder))
    val creditcardid = jsonObj.get("creditcardid").toRight("Missing field 'creditcardid'").flatMap(_.as(CustomCreditcardId.jsonDecoder))
    if (businessentityid.isRight && creditcardid.isRight)
      Right(PersoncreditcardId(businessentityid = businessentityid.toOption.get, creditcardid = creditcardid.toOption.get))
    else Left(List[Either[String, Any]](businessentityid, creditcardid).flatMap(_.left.toOption).mkString(", "))
  }
  implicit lazy val jsonEncoder: JsonEncoder[PersoncreditcardId] = new JsonEncoder[PersoncreditcardId] {
    override def unsafeEncode(a: PersoncreditcardId, indent: Option[Int], out: Write): Unit = {
      out.write("{")
      out.write(""""businessentityid":""")
      BusinessentityId.jsonEncoder.unsafeEncode(a.businessentityid, indent, out)
      out.write(",")
      out.write(""""creditcardid":""")
      CustomCreditcardId.jsonEncoder.unsafeEncode(a.creditcardid, indent, out)
      out.write("}")
    }
  }
  implicit lazy val ordering: Ordering[PersoncreditcardId] = Ordering.by(x => (x.businessentityid, x.creditcardid))
}
