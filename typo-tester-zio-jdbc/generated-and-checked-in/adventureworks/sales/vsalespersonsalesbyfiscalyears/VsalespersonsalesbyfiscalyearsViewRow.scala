/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package vsalespersonsalesbyfiscalyears

import java.sql.ResultSet
import zio.jdbc.JdbcDecoder
import zio.json.JsonDecoder
import zio.json.JsonEncoder
import zio.json.ast.Json
import zio.json.internal.Write

/** View: sales.vsalespersonsalesbyfiscalyears */
case class VsalespersonsalesbyfiscalyearsViewRow(
  SalesPersonID: /* nullability unknown */ Option[Int],
  FullName: /* nullability unknown */ Option[String],
  JobTitle: /* nullability unknown */ Option[String],
  SalesTerritory: /* nullability unknown */ Option[String],
  `2012`: /* nullability unknown */ Option[BigDecimal],
  `2013`: /* nullability unknown */ Option[BigDecimal],
  `2014`: /* nullability unknown */ Option[BigDecimal]
)

object VsalespersonsalesbyfiscalyearsViewRow {
  implicit lazy val jdbcDecoder: JdbcDecoder[VsalespersonsalesbyfiscalyearsViewRow] = new JdbcDecoder[VsalespersonsalesbyfiscalyearsViewRow] {
    override def unsafeDecode(columIndex: Int, rs: ResultSet): (Int, VsalespersonsalesbyfiscalyearsViewRow) =
      columIndex + 6 ->
        VsalespersonsalesbyfiscalyearsViewRow(
          SalesPersonID = JdbcDecoder.optionDecoder(JdbcDecoder.intDecoder).unsafeDecode(columIndex + 0, rs)._2,
          FullName = JdbcDecoder.optionDecoder(JdbcDecoder.stringDecoder).unsafeDecode(columIndex + 1, rs)._2,
          JobTitle = JdbcDecoder.optionDecoder(JdbcDecoder.stringDecoder).unsafeDecode(columIndex + 2, rs)._2,
          SalesTerritory = JdbcDecoder.optionDecoder(JdbcDecoder.stringDecoder).unsafeDecode(columIndex + 3, rs)._2,
          `2012` = JdbcDecoder.optionDecoder(JdbcDecoder.bigDecimalDecoderScala).unsafeDecode(columIndex + 4, rs)._2,
          `2013` = JdbcDecoder.optionDecoder(JdbcDecoder.bigDecimalDecoderScala).unsafeDecode(columIndex + 5, rs)._2,
          `2014` = JdbcDecoder.optionDecoder(JdbcDecoder.bigDecimalDecoderScala).unsafeDecode(columIndex + 6, rs)._2
        )
  }
  implicit lazy val jsonDecoder: JsonDecoder[VsalespersonsalesbyfiscalyearsViewRow] = JsonDecoder[Json.Obj].mapOrFail { jsonObj =>
    val SalesPersonID = jsonObj.get("SalesPersonID").fold[Either[String, Option[Int]]](Right(None))(_.as(JsonDecoder.option(using JsonDecoder.int)))
    val FullName = jsonObj.get("FullName").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(using JsonDecoder.string)))
    val JobTitle = jsonObj.get("JobTitle").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(using JsonDecoder.string)))
    val SalesTerritory = jsonObj.get("SalesTerritory").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(using JsonDecoder.string)))
    val `2012` = jsonObj.get("2012").fold[Either[String, Option[BigDecimal]]](Right(None))(_.as(JsonDecoder.option(using JsonDecoder.scalaBigDecimal)))
    val `2013` = jsonObj.get("2013").fold[Either[String, Option[BigDecimal]]](Right(None))(_.as(JsonDecoder.option(using JsonDecoder.scalaBigDecimal)))
    val `2014` = jsonObj.get("2014").fold[Either[String, Option[BigDecimal]]](Right(None))(_.as(JsonDecoder.option(using JsonDecoder.scalaBigDecimal)))
    if (SalesPersonID.isRight && FullName.isRight && JobTitle.isRight && SalesTerritory.isRight && `2012`.isRight && `2013`.isRight && `2014`.isRight)
      Right(VsalespersonsalesbyfiscalyearsViewRow(SalesPersonID = SalesPersonID.toOption.get, FullName = FullName.toOption.get, JobTitle = JobTitle.toOption.get, SalesTerritory = SalesTerritory.toOption.get, `2012` = `2012`.toOption.get, `2013` = `2013`.toOption.get, `2014` = `2014`.toOption.get))
    else Left(List[Either[String, Any]](SalesPersonID, FullName, JobTitle, SalesTerritory, `2012`, `2013`, `2014`).flatMap(_.left.toOption).mkString(", "))
  }
  implicit lazy val jsonEncoder: JsonEncoder[VsalespersonsalesbyfiscalyearsViewRow] = new JsonEncoder[VsalespersonsalesbyfiscalyearsViewRow] {
    override def unsafeEncode(a: VsalespersonsalesbyfiscalyearsViewRow, indent: Option[Int], out: Write): Unit = {
      out.write("{")
      out.write(""""SalesPersonID":""")
      JsonEncoder.option(using JsonEncoder.int).unsafeEncode(a.SalesPersonID, indent, out)
      out.write(",")
      out.write(""""FullName":""")
      JsonEncoder.option(using JsonEncoder.string).unsafeEncode(a.FullName, indent, out)
      out.write(",")
      out.write(""""JobTitle":""")
      JsonEncoder.option(using JsonEncoder.string).unsafeEncode(a.JobTitle, indent, out)
      out.write(",")
      out.write(""""SalesTerritory":""")
      JsonEncoder.option(using JsonEncoder.string).unsafeEncode(a.SalesTerritory, indent, out)
      out.write(",")
      out.write(""""2012":""")
      JsonEncoder.option(using JsonEncoder.scalaBigDecimal).unsafeEncode(a.`2012`, indent, out)
      out.write(",")
      out.write(""""2013":""")
      JsonEncoder.option(using JsonEncoder.scalaBigDecimal).unsafeEncode(a.`2013`, indent, out)
      out.write(",")
      out.write(""""2014":""")
      JsonEncoder.option(using JsonEncoder.scalaBigDecimal).unsafeEncode(a.`2014`, indent, out)
      out.write("}")
    }
  }
}
