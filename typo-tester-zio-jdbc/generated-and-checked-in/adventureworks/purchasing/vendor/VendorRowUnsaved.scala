/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package purchasing
package vendor

import adventureworks.Text
import adventureworks.customtypes.Defaulted
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoShort
import adventureworks.person.businessentity.BusinessentityId
import adventureworks.public.AccountNumber
import adventureworks.public.Flag
import adventureworks.public.Name
import zio.json.JsonDecoder
import zio.json.JsonEncoder
import zio.json.ast.Json
import zio.json.internal.Write

/** This class corresponds to a row in table `purchasing.vendor` which has not been persisted yet */
case class VendorRowUnsaved(
  /** Primary key for Vendor records.  Foreign key to BusinessEntity.BusinessEntityID
      Points to [[person.businessentity.BusinessentityRow.businessentityid]] */
  businessentityid: BusinessentityId,
  /** Vendor account (identification) number. */
  accountnumber: AccountNumber,
  /** Company name. */
  name: Name,
  /** 1 = Superior, 2 = Excellent, 3 = Above average, 4 = Average, 5 = Below average
      Constraint CK_Vendor_CreditRating affecting columns c, r, e, d, i, t, r, a, t, i, n, g:  (((creditrating >= 1) AND (creditrating <= 5))) */
  creditrating: TypoShort,
  /** Vendor URL. */
  purchasingwebserviceurl: Option[/* max 1024 chars */ String],
  /** Default: true
      0 = Do not use if another vendor is available. 1 = Preferred over other vendors supplying the same product. */
  preferredvendorstatus: Defaulted[Flag] = Defaulted.UseDefault,
  /** Default: true
      0 = Vendor no longer used. 1 = Vendor is actively used. */
  activeflag: Defaulted[Flag] = Defaulted.UseDefault,
  /** Default: now() */
  modifieddate: Defaulted[TypoLocalDateTime] = Defaulted.UseDefault
) {
  def toRow(preferredvendorstatusDefault: => Flag, activeflagDefault: => Flag, modifieddateDefault: => TypoLocalDateTime): VendorRow =
    VendorRow(
      businessentityid = businessentityid,
      accountnumber = accountnumber,
      name = name,
      creditrating = creditrating,
      purchasingwebserviceurl = purchasingwebserviceurl,
      preferredvendorstatus = preferredvendorstatus match {
                                case Defaulted.UseDefault => preferredvendorstatusDefault
                                case Defaulted.Provided(value) => value
                              },
      activeflag = activeflag match {
                     case Defaulted.UseDefault => activeflagDefault
                     case Defaulted.Provided(value) => value
                   },
      modifieddate = modifieddate match {
                       case Defaulted.UseDefault => modifieddateDefault
                       case Defaulted.Provided(value) => value
                     }
    )
}
object VendorRowUnsaved {
  implicit lazy val jsonDecoder: JsonDecoder[VendorRowUnsaved] = JsonDecoder[Json.Obj].mapOrFail { jsonObj =>
    val businessentityid = jsonObj.get("businessentityid").toRight("Missing field 'businessentityid'").flatMap(_.as(BusinessentityId.jsonDecoder))
    val accountnumber = jsonObj.get("accountnumber").toRight("Missing field 'accountnumber'").flatMap(_.as(AccountNumber.jsonDecoder))
    val name = jsonObj.get("name").toRight("Missing field 'name'").flatMap(_.as(Name.jsonDecoder))
    val creditrating = jsonObj.get("creditrating").toRight("Missing field 'creditrating'").flatMap(_.as(TypoShort.jsonDecoder))
    val purchasingwebserviceurl = jsonObj.get("purchasingwebserviceurl").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(using JsonDecoder.string)))
    val preferredvendorstatus = jsonObj.get("preferredvendorstatus").toRight("Missing field 'preferredvendorstatus'").flatMap(_.as(Defaulted.jsonDecoder(Flag.jsonDecoder)))
    val activeflag = jsonObj.get("activeflag").toRight("Missing field 'activeflag'").flatMap(_.as(Defaulted.jsonDecoder(Flag.jsonDecoder)))
    val modifieddate = jsonObj.get("modifieddate").toRight("Missing field 'modifieddate'").flatMap(_.as(Defaulted.jsonDecoder(TypoLocalDateTime.jsonDecoder)))
    if (businessentityid.isRight && accountnumber.isRight && name.isRight && creditrating.isRight && purchasingwebserviceurl.isRight && preferredvendorstatus.isRight && activeflag.isRight && modifieddate.isRight)
      Right(VendorRowUnsaved(businessentityid = businessentityid.toOption.get, accountnumber = accountnumber.toOption.get, name = name.toOption.get, creditrating = creditrating.toOption.get, purchasingwebserviceurl = purchasingwebserviceurl.toOption.get, preferredvendorstatus = preferredvendorstatus.toOption.get, activeflag = activeflag.toOption.get, modifieddate = modifieddate.toOption.get))
    else Left(List[Either[String, Any]](businessentityid, accountnumber, name, creditrating, purchasingwebserviceurl, preferredvendorstatus, activeflag, modifieddate).flatMap(_.left.toOption).mkString(", "))
  }
  implicit lazy val jsonEncoder: JsonEncoder[VendorRowUnsaved] = new JsonEncoder[VendorRowUnsaved] {
    override def unsafeEncode(a: VendorRowUnsaved, indent: Option[Int], out: Write): Unit = {
      out.write("{")
      out.write(""""businessentityid":""")
      BusinessentityId.jsonEncoder.unsafeEncode(a.businessentityid, indent, out)
      out.write(",")
      out.write(""""accountnumber":""")
      AccountNumber.jsonEncoder.unsafeEncode(a.accountnumber, indent, out)
      out.write(",")
      out.write(""""name":""")
      Name.jsonEncoder.unsafeEncode(a.name, indent, out)
      out.write(",")
      out.write(""""creditrating":""")
      TypoShort.jsonEncoder.unsafeEncode(a.creditrating, indent, out)
      out.write(",")
      out.write(""""purchasingwebserviceurl":""")
      JsonEncoder.option(using JsonEncoder.string).unsafeEncode(a.purchasingwebserviceurl, indent, out)
      out.write(",")
      out.write(""""preferredvendorstatus":""")
      Defaulted.jsonEncoder(Flag.jsonEncoder).unsafeEncode(a.preferredvendorstatus, indent, out)
      out.write(",")
      out.write(""""activeflag":""")
      Defaulted.jsonEncoder(Flag.jsonEncoder).unsafeEncode(a.activeflag, indent, out)
      out.write(",")
      out.write(""""modifieddate":""")
      Defaulted.jsonEncoder(TypoLocalDateTime.jsonEncoder).unsafeEncode(a.modifieddate, indent, out)
      out.write("}")
    }
  }
  implicit lazy val text: Text[VendorRowUnsaved] = Text.instance[VendorRowUnsaved]{ (row, sb) =>
    BusinessentityId.text.unsafeEncode(row.businessentityid, sb)
    sb.append(Text.DELIMETER)
    AccountNumber.text.unsafeEncode(row.accountnumber, sb)
    sb.append(Text.DELIMETER)
    Name.text.unsafeEncode(row.name, sb)
    sb.append(Text.DELIMETER)
    TypoShort.text.unsafeEncode(row.creditrating, sb)
    sb.append(Text.DELIMETER)
    Text.option(Text.stringInstance).unsafeEncode(row.purchasingwebserviceurl, sb)
    sb.append(Text.DELIMETER)
    Defaulted.text(Flag.text).unsafeEncode(row.preferredvendorstatus, sb)
    sb.append(Text.DELIMETER)
    Defaulted.text(Flag.text).unsafeEncode(row.activeflag, sb)
    sb.append(Text.DELIMETER)
    Defaulted.text(TypoLocalDateTime.text).unsafeEncode(row.modifieddate, sb)
  }
}
