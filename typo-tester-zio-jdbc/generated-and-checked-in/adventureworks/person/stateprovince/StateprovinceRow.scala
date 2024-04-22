/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package person
package stateprovince

import adventureworks.Text
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoUUID
import adventureworks.person.countryregion.CountryregionId
import adventureworks.public.Flag
import adventureworks.public.Name
import adventureworks.sales.salesterritory.SalesterritoryId
import java.sql.ResultSet
import zio.jdbc.JdbcDecoder
import zio.json.JsonDecoder
import zio.json.JsonEncoder
import zio.json.ast.Json
import zio.json.internal.Write

/** Table: person.stateprovince
    State and province lookup table.
    Primary key: stateprovinceid */
case class StateprovinceRow(
  /** Primary key for StateProvince records.
      Default: nextval('person.stateprovince_stateprovinceid_seq'::regclass) */
  stateprovinceid: StateprovinceId,
  /** ISO standard state or province code. */
  stateprovincecode: /* bpchar, max 3 chars */ String,
  /** ISO standard country or region code. Foreign key to CountryRegion.CountryRegionCode.
      Points to [[countryregion.CountryregionRow.countryregioncode]] */
  countryregioncode: CountryregionId,
  /** 0 = StateProvinceCode exists. 1 = StateProvinceCode unavailable, using CountryRegionCode.
      Default: true */
  isonlystateprovinceflag: Flag,
  /** State or province description. */
  name: Name,
  /** ID of the territory in which the state or province is located. Foreign key to SalesTerritory.SalesTerritoryID.
      Points to [[sales.salesterritory.SalesterritoryRow.territoryid]] */
  territoryid: SalesterritoryId,
  /** Default: uuid_generate_v1() */
  rowguid: TypoUUID,
  /** Default: now() */
  modifieddate: TypoLocalDateTime
)

object StateprovinceRow {
  implicit lazy val jdbcDecoder: JdbcDecoder[StateprovinceRow] = new JdbcDecoder[StateprovinceRow] {
    override def unsafeDecode(columIndex: Int, rs: ResultSet): (Int, StateprovinceRow) =
      columIndex + 7 ->
        StateprovinceRow(
          stateprovinceid = StateprovinceId.jdbcDecoder.unsafeDecode(columIndex + 0, rs)._2,
          stateprovincecode = JdbcDecoder.stringDecoder.unsafeDecode(columIndex + 1, rs)._2,
          countryregioncode = CountryregionId.jdbcDecoder.unsafeDecode(columIndex + 2, rs)._2,
          isonlystateprovinceflag = Flag.jdbcDecoder.unsafeDecode(columIndex + 3, rs)._2,
          name = Name.jdbcDecoder.unsafeDecode(columIndex + 4, rs)._2,
          territoryid = SalesterritoryId.jdbcDecoder.unsafeDecode(columIndex + 5, rs)._2,
          rowguid = TypoUUID.jdbcDecoder.unsafeDecode(columIndex + 6, rs)._2,
          modifieddate = TypoLocalDateTime.jdbcDecoder.unsafeDecode(columIndex + 7, rs)._2
        )
  }
  implicit lazy val jsonDecoder: JsonDecoder[StateprovinceRow] = JsonDecoder[Json.Obj].mapOrFail { jsonObj =>
    val stateprovinceid = jsonObj.get("stateprovinceid").toRight("Missing field 'stateprovinceid'").flatMap(_.as(StateprovinceId.jsonDecoder))
    val stateprovincecode = jsonObj.get("stateprovincecode").toRight("Missing field 'stateprovincecode'").flatMap(_.as(JsonDecoder.string))
    val countryregioncode = jsonObj.get("countryregioncode").toRight("Missing field 'countryregioncode'").flatMap(_.as(CountryregionId.jsonDecoder))
    val isonlystateprovinceflag = jsonObj.get("isonlystateprovinceflag").toRight("Missing field 'isonlystateprovinceflag'").flatMap(_.as(Flag.jsonDecoder))
    val name = jsonObj.get("name").toRight("Missing field 'name'").flatMap(_.as(Name.jsonDecoder))
    val territoryid = jsonObj.get("territoryid").toRight("Missing field 'territoryid'").flatMap(_.as(SalesterritoryId.jsonDecoder))
    val rowguid = jsonObj.get("rowguid").toRight("Missing field 'rowguid'").flatMap(_.as(TypoUUID.jsonDecoder))
    val modifieddate = jsonObj.get("modifieddate").toRight("Missing field 'modifieddate'").flatMap(_.as(TypoLocalDateTime.jsonDecoder))
    if (stateprovinceid.isRight && stateprovincecode.isRight && countryregioncode.isRight && isonlystateprovinceflag.isRight && name.isRight && territoryid.isRight && rowguid.isRight && modifieddate.isRight)
      Right(StateprovinceRow(stateprovinceid = stateprovinceid.toOption.get, stateprovincecode = stateprovincecode.toOption.get, countryregioncode = countryregioncode.toOption.get, isonlystateprovinceflag = isonlystateprovinceflag.toOption.get, name = name.toOption.get, territoryid = territoryid.toOption.get, rowguid = rowguid.toOption.get, modifieddate = modifieddate.toOption.get))
    else Left(List[Either[String, Any]](stateprovinceid, stateprovincecode, countryregioncode, isonlystateprovinceflag, name, territoryid, rowguid, modifieddate).flatMap(_.left.toOption).mkString(", "))
  }
  implicit lazy val jsonEncoder: JsonEncoder[StateprovinceRow] = new JsonEncoder[StateprovinceRow] {
    override def unsafeEncode(a: StateprovinceRow, indent: Option[Int], out: Write): Unit = {
      out.write("{")
      out.write(""""stateprovinceid":""")
      StateprovinceId.jsonEncoder.unsafeEncode(a.stateprovinceid, indent, out)
      out.write(",")
      out.write(""""stateprovincecode":""")
      JsonEncoder.string.unsafeEncode(a.stateprovincecode, indent, out)
      out.write(",")
      out.write(""""countryregioncode":""")
      CountryregionId.jsonEncoder.unsafeEncode(a.countryregioncode, indent, out)
      out.write(",")
      out.write(""""isonlystateprovinceflag":""")
      Flag.jsonEncoder.unsafeEncode(a.isonlystateprovinceflag, indent, out)
      out.write(",")
      out.write(""""name":""")
      Name.jsonEncoder.unsafeEncode(a.name, indent, out)
      out.write(",")
      out.write(""""territoryid":""")
      SalesterritoryId.jsonEncoder.unsafeEncode(a.territoryid, indent, out)
      out.write(",")
      out.write(""""rowguid":""")
      TypoUUID.jsonEncoder.unsafeEncode(a.rowguid, indent, out)
      out.write(",")
      out.write(""""modifieddate":""")
      TypoLocalDateTime.jsonEncoder.unsafeEncode(a.modifieddate, indent, out)
      out.write("}")
    }
  }
  implicit lazy val text: Text[StateprovinceRow] = Text.instance[StateprovinceRow]{ (row, sb) =>
    StateprovinceId.text.unsafeEncode(row.stateprovinceid, sb)
    sb.append(Text.DELIMETER)
    Text.stringInstance.unsafeEncode(row.stateprovincecode, sb)
    sb.append(Text.DELIMETER)
    CountryregionId.text.unsafeEncode(row.countryregioncode, sb)
    sb.append(Text.DELIMETER)
    Flag.text.unsafeEncode(row.isonlystateprovinceflag, sb)
    sb.append(Text.DELIMETER)
    Name.text.unsafeEncode(row.name, sb)
    sb.append(Text.DELIMETER)
    SalesterritoryId.text.unsafeEncode(row.territoryid, sb)
    sb.append(Text.DELIMETER)
    TypoUUID.text.unsafeEncode(row.rowguid, sb)
    sb.append(Text.DELIMETER)
    TypoLocalDateTime.text.unsafeEncode(row.modifieddate, sb)
  }
}
