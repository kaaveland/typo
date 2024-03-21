/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package purchasing
package vendor

import adventureworks.Text
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoShort
import adventureworks.person.businessentity.BusinessentityId
import adventureworks.public.AccountNumber
import adventureworks.public.Flag
import adventureworks.public.Name
import java.sql.ResultSet
import zio.jdbc.JdbcDecoder
import zio.json.JsonDecoder
import zio.json.JsonEncoder
import zio.json.ast.Json
import zio.json.internal.Write

case class VendorRow(
  /** Primary key for Vendor records.  Foreign key to BusinessEntity.BusinessEntityID
      Points to [[person.businessentity.BusinessentityRow.businessentityid]] */
  businessentityid: BusinessentityId,
  /** Vendor account (identification) number. */
  accountnumber: AccountNumber,
  /** Company name. */
  name: Name,
  /** 1 = Superior, 2 = Excellent, 3 = Above average, 4 = Average, 5 = Below average
      Constraint CK_Vendor_CreditRating affecting columns creditrating: (((creditrating >= 1) AND (creditrating <= 5))) */
  creditrating: TypoShort,
  /** 0 = Do not use if another vendor is available. 1 = Preferred over other vendors supplying the same product.
      Default: true */
  preferredvendorstatus: Flag,
  /** 0 = Vendor no longer used. 1 = Vendor is actively used.
      Default: true */
  activeflag: Flag,
  /** Vendor URL. */
  purchasingwebserviceurl: Option[/* max 1024 chars */ String],
  /** Default: now() */
  modifieddate: TypoLocalDateTime
)

object VendorRow {
  implicit lazy val jdbcDecoder: JdbcDecoder[VendorRow] = new JdbcDecoder[VendorRow] {
    override def unsafeDecode(columIndex: Int, rs: ResultSet): (Int, VendorRow) =
      columIndex + 7 ->
        VendorRow(
          businessentityid = BusinessentityId.jdbcDecoder.unsafeDecode(columIndex + 0, rs)._2,
          accountnumber = AccountNumber.jdbcDecoder.unsafeDecode(columIndex + 1, rs)._2,
          name = Name.jdbcDecoder.unsafeDecode(columIndex + 2, rs)._2,
          creditrating = TypoShort.jdbcDecoder.unsafeDecode(columIndex + 3, rs)._2,
          preferredvendorstatus = Flag.jdbcDecoder.unsafeDecode(columIndex + 4, rs)._2,
          activeflag = Flag.jdbcDecoder.unsafeDecode(columIndex + 5, rs)._2,
          purchasingwebserviceurl = JdbcDecoder.optionDecoder(JdbcDecoder.stringDecoder).unsafeDecode(columIndex + 6, rs)._2,
          modifieddate = TypoLocalDateTime.jdbcDecoder.unsafeDecode(columIndex + 7, rs)._2
        )
  }
  implicit lazy val jsonDecoder: JsonDecoder[VendorRow] = JsonDecoder[Json.Obj].mapOrFail { jsonObj =>
    val businessentityid = jsonObj.get("businessentityid").toRight("Missing field 'businessentityid'").flatMap(_.as(BusinessentityId.jsonDecoder))
    val accountnumber = jsonObj.get("accountnumber").toRight("Missing field 'accountnumber'").flatMap(_.as(AccountNumber.jsonDecoder))
    val name = jsonObj.get("name").toRight("Missing field 'name'").flatMap(_.as(Name.jsonDecoder))
    val creditrating = jsonObj.get("creditrating").toRight("Missing field 'creditrating'").flatMap(_.as(TypoShort.jsonDecoder))
    val preferredvendorstatus = jsonObj.get("preferredvendorstatus").toRight("Missing field 'preferredvendorstatus'").flatMap(_.as(Flag.jsonDecoder))
    val activeflag = jsonObj.get("activeflag").toRight("Missing field 'activeflag'").flatMap(_.as(Flag.jsonDecoder))
    val purchasingwebserviceurl = jsonObj.get("purchasingwebserviceurl").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(using JsonDecoder.string)))
    val modifieddate = jsonObj.get("modifieddate").toRight("Missing field 'modifieddate'").flatMap(_.as(TypoLocalDateTime.jsonDecoder))
    if (businessentityid.isRight && accountnumber.isRight && name.isRight && creditrating.isRight && preferredvendorstatus.isRight && activeflag.isRight && purchasingwebserviceurl.isRight && modifieddate.isRight)
      Right(VendorRow(businessentityid = businessentityid.toOption.get, accountnumber = accountnumber.toOption.get, name = name.toOption.get, creditrating = creditrating.toOption.get, preferredvendorstatus = preferredvendorstatus.toOption.get, activeflag = activeflag.toOption.get, purchasingwebserviceurl = purchasingwebserviceurl.toOption.get, modifieddate = modifieddate.toOption.get))
    else Left(List[Either[String, Any]](businessentityid, accountnumber, name, creditrating, preferredvendorstatus, activeflag, purchasingwebserviceurl, modifieddate).flatMap(_.left.toOption).mkString(", "))
  }
  implicit lazy val jsonEncoder: JsonEncoder[VendorRow] = new JsonEncoder[VendorRow] {
    override def unsafeEncode(a: VendorRow, indent: Option[Int], out: Write): Unit = {
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
      out.write(""""preferredvendorstatus":""")
      Flag.jsonEncoder.unsafeEncode(a.preferredvendorstatus, indent, out)
      out.write(",")
      out.write(""""activeflag":""")
      Flag.jsonEncoder.unsafeEncode(a.activeflag, indent, out)
      out.write(",")
      out.write(""""purchasingwebserviceurl":""")
      JsonEncoder.option(using JsonEncoder.string).unsafeEncode(a.purchasingwebserviceurl, indent, out)
      out.write(",")
      out.write(""""modifieddate":""")
      TypoLocalDateTime.jsonEncoder.unsafeEncode(a.modifieddate, indent, out)
      out.write("}")
    }
  }
  implicit lazy val text: Text[VendorRow] = Text.instance[VendorRow]{ (row, sb) =>
    BusinessentityId.text.unsafeEncode(row.businessentityid, sb)
    sb.append(Text.DELIMETER)
    AccountNumber.text.unsafeEncode(row.accountnumber, sb)
    sb.append(Text.DELIMETER)
    Name.text.unsafeEncode(row.name, sb)
    sb.append(Text.DELIMETER)
    TypoShort.text.unsafeEncode(row.creditrating, sb)
    sb.append(Text.DELIMETER)
    Flag.text.unsafeEncode(row.preferredvendorstatus, sb)
    sb.append(Text.DELIMETER)
    Flag.text.unsafeEncode(row.activeflag, sb)
    sb.append(Text.DELIMETER)
    Text.option(Text.stringInstance).unsafeEncode(row.purchasingwebserviceurl, sb)
    sb.append(Text.DELIMETER)
    TypoLocalDateTime.text.unsafeEncode(row.modifieddate, sb)
  }
}
