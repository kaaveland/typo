/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package countryregioncurrency

import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.person.countryregion.CountryregionId
import adventureworks.sales.currency.CurrencyId
import java.sql.ResultSet
import zio.jdbc.JdbcDecoder
import zio.json.JsonDecoder
import zio.json.JsonEncoder
import zio.json.ast.Json
import zio.json.internal.Write

case class CountryregioncurrencyRow(
  /** ISO code for countries and regions. Foreign key to CountryRegion.CountryRegionCode.
      Points to [[person.countryregion.CountryregionRow.countryregioncode]] */
  countryregioncode: CountryregionId,
  /** ISO standard currency code. Foreign key to Currency.CurrencyCode.
      Points to [[currency.CurrencyRow.currencycode]] */
  currencycode: CurrencyId,
  modifieddate: TypoLocalDateTime
){
   val compositeId: CountryregioncurrencyId = CountryregioncurrencyId(countryregioncode, currencycode)
 }

object CountryregioncurrencyRow {
  implicit lazy val jdbcDecoder: JdbcDecoder[CountryregioncurrencyRow] = new JdbcDecoder[CountryregioncurrencyRow] {
    override def unsafeDecode(columIndex: Int, rs: ResultSet): (Int, CountryregioncurrencyRow) =
      columIndex + 2 ->
        CountryregioncurrencyRow(
          countryregioncode = CountryregionId.jdbcDecoder.unsafeDecode(columIndex + 0, rs)._2,
          currencycode = CurrencyId.jdbcDecoder.unsafeDecode(columIndex + 1, rs)._2,
          modifieddate = TypoLocalDateTime.jdbcDecoder.unsafeDecode(columIndex + 2, rs)._2
        )
  }
  implicit lazy val jsonDecoder: JsonDecoder[CountryregioncurrencyRow] = JsonDecoder[Json.Obj].mapOrFail { jsonObj =>
    val countryregioncode = jsonObj.get("countryregioncode").toRight("Missing field 'countryregioncode'").flatMap(_.as(CountryregionId.jsonDecoder))
    val currencycode = jsonObj.get("currencycode").toRight("Missing field 'currencycode'").flatMap(_.as(CurrencyId.jsonDecoder))
    val modifieddate = jsonObj.get("modifieddate").toRight("Missing field 'modifieddate'").flatMap(_.as(TypoLocalDateTime.jsonDecoder))
    if (countryregioncode.isRight && currencycode.isRight && modifieddate.isRight)
      Right(CountryregioncurrencyRow(countryregioncode = countryregioncode.toOption.get, currencycode = currencycode.toOption.get, modifieddate = modifieddate.toOption.get))
    else Left(List[Either[String, Any]](countryregioncode, currencycode, modifieddate).flatMap(_.left.toOption).mkString(", "))
  }
  implicit lazy val jsonEncoder: JsonEncoder[CountryregioncurrencyRow] = new JsonEncoder[CountryregioncurrencyRow] {
    override def unsafeEncode(a: CountryregioncurrencyRow, indent: Option[Int], out: Write): Unit = {
      out.write("{")
      out.write(""""countryregioncode":""")
      CountryregionId.jsonEncoder.unsafeEncode(a.countryregioncode, indent, out)
      out.write(",")
      out.write(""""currencycode":""")
      CurrencyId.jsonEncoder.unsafeEncode(a.currencycode, indent, out)
      out.write(",")
      out.write(""""modifieddate":""")
      TypoLocalDateTime.jsonEncoder.unsafeEncode(a.modifieddate, indent, out)
      out.write("}")
    }
  }
}
