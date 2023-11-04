/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package creditcard

import adventureworks.customtypes.Defaulted
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoShort
import adventureworks.userdefined.CustomCreditcardId
import zio.json.JsonDecoder
import zio.json.JsonEncoder
import zio.json.ast.Json
import zio.json.internal.Write

/** This class corresponds to a row in table `sales.creditcard` which has not been persisted yet */
case class CreditcardRowUnsaved(
  /** Credit card name. */
  cardtype: /* max 50 chars */ String,
  /** Credit card number. */
  cardnumber: /* max 25 chars */ String,
  /** Credit card expiration month. */
  expmonth: TypoShort,
  /** Credit card expiration year. */
  expyear: TypoShort,
  /** Default: nextval('sales.creditcard_creditcardid_seq'::regclass)
      Primary key for CreditCard records. */
  creditcardid: Defaulted[/* user-picked */ CustomCreditcardId] = Defaulted.UseDefault,
  /** Default: now() */
  modifieddate: Defaulted[TypoLocalDateTime] = Defaulted.UseDefault
) {
  def toRow(creditcardidDefault: => /* user-picked */ CustomCreditcardId, modifieddateDefault: => TypoLocalDateTime): CreditcardRow =
    CreditcardRow(
      cardtype = cardtype,
      cardnumber = cardnumber,
      expmonth = expmonth,
      expyear = expyear,
      creditcardid = creditcardid match {
                       case Defaulted.UseDefault => creditcardidDefault
                       case Defaulted.Provided(value) => value
                     },
      modifieddate = modifieddate match {
                       case Defaulted.UseDefault => modifieddateDefault
                       case Defaulted.Provided(value) => value
                     }
    )
}
object CreditcardRowUnsaved {
  implicit lazy val jsonDecoder: JsonDecoder[CreditcardRowUnsaved] = JsonDecoder[Json.Obj].mapOrFail { jsonObj =>
    val cardtype = jsonObj.get("cardtype").toRight("Missing field 'cardtype'").flatMap(_.as(JsonDecoder.string))
    val cardnumber = jsonObj.get("cardnumber").toRight("Missing field 'cardnumber'").flatMap(_.as(JsonDecoder.string))
    val expmonth = jsonObj.get("expmonth").toRight("Missing field 'expmonth'").flatMap(_.as(TypoShort.jsonDecoder))
    val expyear = jsonObj.get("expyear").toRight("Missing field 'expyear'").flatMap(_.as(TypoShort.jsonDecoder))
    val creditcardid = jsonObj.get("creditcardid").toRight("Missing field 'creditcardid'").flatMap(_.as(Defaulted.jsonDecoder(CustomCreditcardId.jsonDecoder)))
    val modifieddate = jsonObj.get("modifieddate").toRight("Missing field 'modifieddate'").flatMap(_.as(Defaulted.jsonDecoder(TypoLocalDateTime.jsonDecoder)))
    if (cardtype.isRight && cardnumber.isRight && expmonth.isRight && expyear.isRight && creditcardid.isRight && modifieddate.isRight)
      Right(CreditcardRowUnsaved(cardtype = cardtype.toOption.get, cardnumber = cardnumber.toOption.get, expmonth = expmonth.toOption.get, expyear = expyear.toOption.get, creditcardid = creditcardid.toOption.get, modifieddate = modifieddate.toOption.get))
    else Left(List[Either[String, Any]](cardtype, cardnumber, expmonth, expyear, creditcardid, modifieddate).flatMap(_.left.toOption).mkString(", "))
  }
  implicit lazy val jsonEncoder: JsonEncoder[CreditcardRowUnsaved] = new JsonEncoder[CreditcardRowUnsaved] {
    override def unsafeEncode(a: CreditcardRowUnsaved, indent: Option[Int], out: Write): Unit = {
      out.write("{")
      out.write(""""cardtype":""")
      JsonEncoder.string.unsafeEncode(a.cardtype, indent, out)
      out.write(",")
      out.write(""""cardnumber":""")
      JsonEncoder.string.unsafeEncode(a.cardnumber, indent, out)
      out.write(",")
      out.write(""""expmonth":""")
      TypoShort.jsonEncoder.unsafeEncode(a.expmonth, indent, out)
      out.write(",")
      out.write(""""expyear":""")
      TypoShort.jsonEncoder.unsafeEncode(a.expyear, indent, out)
      out.write(",")
      out.write(""""creditcardid":""")
      Defaulted.jsonEncoder(CustomCreditcardId.jsonEncoder).unsafeEncode(a.creditcardid, indent, out)
      out.write(",")
      out.write(""""modifieddate":""")
      Defaulted.jsonEncoder(TypoLocalDateTime.jsonEncoder).unsafeEncode(a.modifieddate, indent, out)
      out.write("}")
    }
  }
}