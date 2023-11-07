/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package countryregioncurrency

import adventureworks.customtypes.Defaulted
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.person.countryregion.CountryregionId
import adventureworks.sales.currency.CurrencyId
import zio.json.JsonDecoder
import zio.json.JsonEncoder
import zio.json.ast.Json
import zio.json.internal.Write

/** This class corresponds to a row in table `sales.countryregioncurrency` which has not been persisted yet */
case class CountryregioncurrencyRowUnsaved(
  /** ISO code for countries and regions. Foreign key to CountryRegion.CountryRegionCode.
      Points to [[person.countryregion.CountryregionRow.countryregioncode]] */
  countryregioncode: CountryregionId,
  /** ISO standard currency code. Foreign key to Currency.CurrencyCode.
      Points to [[currency.CurrencyRow.currencycode]] */
  currencycode: CurrencyId,
  /** Default: now() */
  modifieddate: Defaulted[TypoLocalDateTime] = Defaulted.UseDefault
) {
  def toRow(modifieddateDefault: => TypoLocalDateTime): CountryregioncurrencyRow =
    CountryregioncurrencyRow(
      countryregioncode = countryregioncode,
      currencycode = currencycode,
      modifieddate = modifieddate match {
                       case Defaulted.UseDefault => modifieddateDefault
                       case Defaulted.Provided(value) => value
                     }
    )
}
object CountryregioncurrencyRowUnsaved {
  implicit lazy val jsonDecoder: JsonDecoder[CountryregioncurrencyRowUnsaved] = JsonDecoder[Json.Obj].mapOrFail { jsonObj =>
    val countryregioncode = jsonObj.get("countryregioncode").toRight("Missing field 'countryregioncode'").flatMap(_.as(CountryregionId.jsonDecoder))
    val currencycode = jsonObj.get("currencycode").toRight("Missing field 'currencycode'").flatMap(_.as(CurrencyId.jsonDecoder))
    val modifieddate = jsonObj.get("modifieddate").toRight("Missing field 'modifieddate'").flatMap(_.as(Defaulted.jsonDecoder(TypoLocalDateTime.jsonDecoder)))
    if (countryregioncode.isRight && currencycode.isRight && modifieddate.isRight)
      Right(CountryregioncurrencyRowUnsaved(countryregioncode = countryregioncode.toOption.get, currencycode = currencycode.toOption.get, modifieddate = modifieddate.toOption.get))
    else Left(List[Either[String, Any]](countryregioncode, currencycode, modifieddate).flatMap(_.left.toOption).mkString(", "))
  }
  implicit lazy val jsonEncoder: JsonEncoder[CountryregioncurrencyRowUnsaved] = new JsonEncoder[CountryregioncurrencyRowUnsaved] {
    override def unsafeEncode(a: CountryregioncurrencyRowUnsaved, indent: Option[Int], out: Write): Unit = {
      out.write("{")
      out.write(""""countryregioncode":""")
      CountryregionId.jsonEncoder.unsafeEncode(a.countryregioncode, indent, out)
      out.write(",")
      out.write(""""currencycode":""")
      CurrencyId.jsonEncoder.unsafeEncode(a.currencycode, indent, out)
      out.write(",")
      out.write(""""modifieddate":""")
      Defaulted.jsonEncoder(TypoLocalDateTime.jsonEncoder).unsafeEncode(a.modifieddate, indent, out)
      out.write("}")
    }
  }
}
