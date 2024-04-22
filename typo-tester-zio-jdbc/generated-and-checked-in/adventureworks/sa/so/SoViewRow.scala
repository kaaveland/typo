/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sa
package so

import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoUUID
import adventureworks.sales.specialoffer.SpecialofferId
import java.sql.ResultSet
import zio.jdbc.JdbcDecoder
import zio.json.JsonDecoder
import zio.json.JsonEncoder
import zio.json.ast.Json
import zio.json.internal.Write

/** View: sa.so */
case class SoViewRow(
  /** Points to [[sales.specialoffer.SpecialofferRow.specialofferid]] */
  id: SpecialofferId,
  /** Points to [[sales.specialoffer.SpecialofferRow.specialofferid]] */
  specialofferid: SpecialofferId,
  /** Points to [[sales.specialoffer.SpecialofferRow.description]] */
  description: /* max 255 chars */ String,
  /** Points to [[sales.specialoffer.SpecialofferRow.discountpct]] */
  discountpct: BigDecimal,
  /** Points to [[sales.specialoffer.SpecialofferRow.type]] */
  `type`: /* max 50 chars */ String,
  /** Points to [[sales.specialoffer.SpecialofferRow.category]] */
  category: /* max 50 chars */ String,
  /** Points to [[sales.specialoffer.SpecialofferRow.startdate]] */
  startdate: TypoLocalDateTime,
  /** Points to [[sales.specialoffer.SpecialofferRow.enddate]] */
  enddate: TypoLocalDateTime,
  /** Points to [[sales.specialoffer.SpecialofferRow.minqty]] */
  minqty: Int,
  /** Points to [[sales.specialoffer.SpecialofferRow.maxqty]] */
  maxqty: Option[Int],
  /** Points to [[sales.specialoffer.SpecialofferRow.rowguid]] */
  rowguid: TypoUUID,
  /** Points to [[sales.specialoffer.SpecialofferRow.modifieddate]] */
  modifieddate: TypoLocalDateTime
)

object SoViewRow {
  implicit lazy val jdbcDecoder: JdbcDecoder[SoViewRow] = new JdbcDecoder[SoViewRow] {
    override def unsafeDecode(columIndex: Int, rs: ResultSet): (Int, SoViewRow) =
      columIndex + 11 ->
        SoViewRow(
          id = SpecialofferId.jdbcDecoder.unsafeDecode(columIndex + 0, rs)._2,
          specialofferid = SpecialofferId.jdbcDecoder.unsafeDecode(columIndex + 1, rs)._2,
          description = JdbcDecoder.stringDecoder.unsafeDecode(columIndex + 2, rs)._2,
          discountpct = JdbcDecoder.bigDecimalDecoderScala.unsafeDecode(columIndex + 3, rs)._2,
          `type` = JdbcDecoder.stringDecoder.unsafeDecode(columIndex + 4, rs)._2,
          category = JdbcDecoder.stringDecoder.unsafeDecode(columIndex + 5, rs)._2,
          startdate = TypoLocalDateTime.jdbcDecoder.unsafeDecode(columIndex + 6, rs)._2,
          enddate = TypoLocalDateTime.jdbcDecoder.unsafeDecode(columIndex + 7, rs)._2,
          minqty = JdbcDecoder.intDecoder.unsafeDecode(columIndex + 8, rs)._2,
          maxqty = JdbcDecoder.optionDecoder(JdbcDecoder.intDecoder).unsafeDecode(columIndex + 9, rs)._2,
          rowguid = TypoUUID.jdbcDecoder.unsafeDecode(columIndex + 10, rs)._2,
          modifieddate = TypoLocalDateTime.jdbcDecoder.unsafeDecode(columIndex + 11, rs)._2
        )
  }
  implicit lazy val jsonDecoder: JsonDecoder[SoViewRow] = JsonDecoder[Json.Obj].mapOrFail { jsonObj =>
    val id = jsonObj.get("id").toRight("Missing field 'id'").flatMap(_.as(SpecialofferId.jsonDecoder))
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
    if (id.isRight && specialofferid.isRight && description.isRight && discountpct.isRight && `type`.isRight && category.isRight && startdate.isRight && enddate.isRight && minqty.isRight && maxqty.isRight && rowguid.isRight && modifieddate.isRight)
      Right(SoViewRow(id = id.toOption.get, specialofferid = specialofferid.toOption.get, description = description.toOption.get, discountpct = discountpct.toOption.get, `type` = `type`.toOption.get, category = category.toOption.get, startdate = startdate.toOption.get, enddate = enddate.toOption.get, minqty = minqty.toOption.get, maxqty = maxqty.toOption.get, rowguid = rowguid.toOption.get, modifieddate = modifieddate.toOption.get))
    else Left(List[Either[String, Any]](id, specialofferid, description, discountpct, `type`, category, startdate, enddate, minqty, maxqty, rowguid, modifieddate).flatMap(_.left.toOption).mkString(", "))
  }
  implicit lazy val jsonEncoder: JsonEncoder[SoViewRow] = new JsonEncoder[SoViewRow] {
    override def unsafeEncode(a: SoViewRow, indent: Option[Int], out: Write): Unit = {
      out.write("{")
      out.write(""""id":""")
      SpecialofferId.jsonEncoder.unsafeEncode(a.id, indent, out)
      out.write(",")
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
}
