/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package specialoffer

import adventureworks.Text
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoUUID
import java.sql.ResultSet
import zio.jdbc.JdbcDecoder
import zio.json.JsonDecoder
import zio.json.JsonEncoder
import zio.json.ast.Json
import zio.json.internal.Write

/** Table: sales.specialoffer
    Sale discounts lookup table.
    Primary key: specialofferid */
case class SpecialofferRow(
  /** Primary key for SpecialOffer records.
      Default: nextval('sales.specialoffer_specialofferid_seq'::regclass) */
  specialofferid: SpecialofferId,
  /** Discount description. */
  description: /* max 255 chars */ String,
  /** Discount precentage.
      Default: 0.00
      Constraint CK_SpecialOffer_DiscountPct affecting columns discountpct: ((discountpct >= 0.00)) */
  discountpct: BigDecimal,
  /** Discount type category. */
  `type`: /* max 50 chars */ String,
  /** Group the discount applies to such as Reseller or Customer. */
  category: /* max 50 chars */ String,
  /** Discount start date.
      Constraint CK_SpecialOffer_EndDate affecting columns enddate, startdate: ((enddate >= startdate)) */
  startdate: TypoLocalDateTime,
  /** Discount end date.
      Constraint CK_SpecialOffer_EndDate affecting columns enddate, startdate: ((enddate >= startdate)) */
  enddate: TypoLocalDateTime,
  /** Minimum discount percent allowed.
      Default: 0
      Constraint CK_SpecialOffer_MinQty affecting columns minqty: ((minqty >= 0)) */
  minqty: Int,
  /** Maximum discount percent allowed.
      Constraint CK_SpecialOffer_MaxQty affecting columns maxqty: ((maxqty >= 0)) */
  maxqty: Option[Int],
  /** Default: uuid_generate_v1() */
  rowguid: TypoUUID,
  /** Default: now() */
  modifieddate: TypoLocalDateTime
)

object SpecialofferRow {
  implicit lazy val jdbcDecoder: JdbcDecoder[SpecialofferRow] = new JdbcDecoder[SpecialofferRow] {
    override def unsafeDecode(columIndex: Int, rs: ResultSet): (Int, SpecialofferRow) =
      columIndex + 10 ->
        SpecialofferRow(
          specialofferid = SpecialofferId.jdbcDecoder.unsafeDecode(columIndex + 0, rs)._2,
          description = JdbcDecoder.stringDecoder.unsafeDecode(columIndex + 1, rs)._2,
          discountpct = JdbcDecoder.bigDecimalDecoderScala.unsafeDecode(columIndex + 2, rs)._2,
          `type` = JdbcDecoder.stringDecoder.unsafeDecode(columIndex + 3, rs)._2,
          category = JdbcDecoder.stringDecoder.unsafeDecode(columIndex + 4, rs)._2,
          startdate = TypoLocalDateTime.jdbcDecoder.unsafeDecode(columIndex + 5, rs)._2,
          enddate = TypoLocalDateTime.jdbcDecoder.unsafeDecode(columIndex + 6, rs)._2,
          minqty = JdbcDecoder.intDecoder.unsafeDecode(columIndex + 7, rs)._2,
          maxqty = JdbcDecoder.optionDecoder(JdbcDecoder.intDecoder).unsafeDecode(columIndex + 8, rs)._2,
          rowguid = TypoUUID.jdbcDecoder.unsafeDecode(columIndex + 9, rs)._2,
          modifieddate = TypoLocalDateTime.jdbcDecoder.unsafeDecode(columIndex + 10, rs)._2
        )
  }
  implicit lazy val jsonDecoder: JsonDecoder[SpecialofferRow] = JsonDecoder[Json.Obj].mapOrFail { jsonObj =>
    val specialofferid = jsonObj.get("specialofferid").toRight("Missing field 'specialofferid'").flatMap(_.as(SpecialofferId.jsonDecoder))
    val description = jsonObj.get("description").toRight("Missing field 'description'").flatMap(_.as(JsonDecoder.string))
    val discountpct = jsonObj.get("discountpct").toRight("Missing field 'discountpct'").flatMap(_.as(JsonDecoder.scalaBigDecimal))
    val `type` = jsonObj.get("type").toRight("Missing field 'type'").flatMap(_.as(JsonDecoder.string))
    val category = jsonObj.get("category").toRight("Missing field 'category'").flatMap(_.as(JsonDecoder.string))
    val startdate = jsonObj.get("startdate").toRight("Missing field 'startdate'").flatMap(_.as(TypoLocalDateTime.jsonDecoder))
    val enddate = jsonObj.get("enddate").toRight("Missing field 'enddate'").flatMap(_.as(TypoLocalDateTime.jsonDecoder))
    val minqty = jsonObj.get("minqty").toRight("Missing field 'minqty'").flatMap(_.as(JsonDecoder.int))
    val maxqty = jsonObj.get("maxqty").fold[Either[String, Option[Int]]](Right(None))(_.as(JsonDecoder.option(using JsonDecoder.int)))
    val rowguid = jsonObj.get("rowguid").toRight("Missing field 'rowguid'").flatMap(_.as(TypoUUID.jsonDecoder))
    val modifieddate = jsonObj.get("modifieddate").toRight("Missing field 'modifieddate'").flatMap(_.as(TypoLocalDateTime.jsonDecoder))
    if (specialofferid.isRight && description.isRight && discountpct.isRight && `type`.isRight && category.isRight && startdate.isRight && enddate.isRight && minqty.isRight && maxqty.isRight && rowguid.isRight && modifieddate.isRight)
      Right(SpecialofferRow(specialofferid = specialofferid.toOption.get, description = description.toOption.get, discountpct = discountpct.toOption.get, `type` = `type`.toOption.get, category = category.toOption.get, startdate = startdate.toOption.get, enddate = enddate.toOption.get, minqty = minqty.toOption.get, maxqty = maxqty.toOption.get, rowguid = rowguid.toOption.get, modifieddate = modifieddate.toOption.get))
    else Left(List[Either[String, Any]](specialofferid, description, discountpct, `type`, category, startdate, enddate, minqty, maxqty, rowguid, modifieddate).flatMap(_.left.toOption).mkString(", "))
  }
  implicit lazy val jsonEncoder: JsonEncoder[SpecialofferRow] = new JsonEncoder[SpecialofferRow] {
    override def unsafeEncode(a: SpecialofferRow, indent: Option[Int], out: Write): Unit = {
      out.write("{")
      out.write(""""specialofferid":""")
      SpecialofferId.jsonEncoder.unsafeEncode(a.specialofferid, indent, out)
      out.write(",")
      out.write(""""description":""")
      JsonEncoder.string.unsafeEncode(a.description, indent, out)
      out.write(",")
      out.write(""""discountpct":""")
      JsonEncoder.scalaBigDecimal.unsafeEncode(a.discountpct, indent, out)
      out.write(",")
      out.write(""""type":""")
      JsonEncoder.string.unsafeEncode(a.`type`, indent, out)
      out.write(",")
      out.write(""""category":""")
      JsonEncoder.string.unsafeEncode(a.category, indent, out)
      out.write(",")
      out.write(""""startdate":""")
      TypoLocalDateTime.jsonEncoder.unsafeEncode(a.startdate, indent, out)
      out.write(",")
      out.write(""""enddate":""")
      TypoLocalDateTime.jsonEncoder.unsafeEncode(a.enddate, indent, out)
      out.write(",")
      out.write(""""minqty":""")
      JsonEncoder.int.unsafeEncode(a.minqty, indent, out)
      out.write(",")
      out.write(""""maxqty":""")
      JsonEncoder.option(using JsonEncoder.int).unsafeEncode(a.maxqty, indent, out)
      out.write(",")
      out.write(""""rowguid":""")
      TypoUUID.jsonEncoder.unsafeEncode(a.rowguid, indent, out)
      out.write(",")
      out.write(""""modifieddate":""")
      TypoLocalDateTime.jsonEncoder.unsafeEncode(a.modifieddate, indent, out)
      out.write("}")
    }
  }
  implicit lazy val text: Text[SpecialofferRow] = Text.instance[SpecialofferRow]{ (row, sb) =>
    SpecialofferId.text.unsafeEncode(row.specialofferid, sb)
    sb.append(Text.DELIMETER)
    Text.stringInstance.unsafeEncode(row.description, sb)
    sb.append(Text.DELIMETER)
    Text.bigDecimalInstance.unsafeEncode(row.discountpct, sb)
    sb.append(Text.DELIMETER)
    Text.stringInstance.unsafeEncode(row.`type`, sb)
    sb.append(Text.DELIMETER)
    Text.stringInstance.unsafeEncode(row.category, sb)
    sb.append(Text.DELIMETER)
    TypoLocalDateTime.text.unsafeEncode(row.startdate, sb)
    sb.append(Text.DELIMETER)
    TypoLocalDateTime.text.unsafeEncode(row.enddate, sb)
    sb.append(Text.DELIMETER)
    Text.intInstance.unsafeEncode(row.minqty, sb)
    sb.append(Text.DELIMETER)
    Text.option(Text.intInstance).unsafeEncode(row.maxqty, sb)
    sb.append(Text.DELIMETER)
    TypoUUID.text.unsafeEncode(row.rowguid, sb)
    sb.append(Text.DELIMETER)
    TypoLocalDateTime.text.unsafeEncode(row.modifieddate, sb)
  }
}
