/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package productmodel

import adventureworks.Text
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoUUID
import adventureworks.customtypes.TypoXml
import adventureworks.public.Name
import java.sql.ResultSet
import zio.jdbc.JdbcDecoder
import zio.json.JsonDecoder
import zio.json.JsonEncoder
import zio.json.ast.Json
import zio.json.internal.Write

case class ProductmodelRow(
  /** Primary key for ProductModel records.
      Default: nextval('production.productmodel_productmodelid_seq'::regclass) */
  productmodelid: ProductmodelId,
  /** Product model description. */
  name: Name,
  /** Detailed product catalog information in xml format. */
  catalogdescription: Option[TypoXml],
  /** Manufacturing instructions in xml format. */
  instructions: Option[TypoXml],
  /** Default: uuid_generate_v1() */
  rowguid: TypoUUID,
  /** Default: now() */
  modifieddate: TypoLocalDateTime
)

object ProductmodelRow {
  implicit lazy val jdbcDecoder: JdbcDecoder[ProductmodelRow] = new JdbcDecoder[ProductmodelRow] {
    override def unsafeDecode(columIndex: Int, rs: ResultSet): (Int, ProductmodelRow) =
      columIndex + 5 ->
        ProductmodelRow(
          productmodelid = ProductmodelId.jdbcDecoder.unsafeDecode(columIndex + 0, rs)._2,
          name = Name.jdbcDecoder.unsafeDecode(columIndex + 1, rs)._2,
          catalogdescription = JdbcDecoder.optionDecoder(TypoXml.jdbcDecoder).unsafeDecode(columIndex + 2, rs)._2,
          instructions = JdbcDecoder.optionDecoder(TypoXml.jdbcDecoder).unsafeDecode(columIndex + 3, rs)._2,
          rowguid = TypoUUID.jdbcDecoder.unsafeDecode(columIndex + 4, rs)._2,
          modifieddate = TypoLocalDateTime.jdbcDecoder.unsafeDecode(columIndex + 5, rs)._2
        )
  }
  implicit lazy val jsonDecoder: JsonDecoder[ProductmodelRow] = JsonDecoder[Json.Obj].mapOrFail { jsonObj =>
    val productmodelid = jsonObj.get("productmodelid").toRight("Missing field 'productmodelid'").flatMap(_.as(ProductmodelId.jsonDecoder))
    val name = jsonObj.get("name").toRight("Missing field 'name'").flatMap(_.as(Name.jsonDecoder))
    val catalogdescription = jsonObj.get("catalogdescription").fold[Either[String, Option[TypoXml]]](Right(None))(_.as(JsonDecoder.option(TypoXml.jsonDecoder)))
    val instructions = jsonObj.get("instructions").fold[Either[String, Option[TypoXml]]](Right(None))(_.as(JsonDecoder.option(TypoXml.jsonDecoder)))
    val rowguid = jsonObj.get("rowguid").toRight("Missing field 'rowguid'").flatMap(_.as(TypoUUID.jsonDecoder))
    val modifieddate = jsonObj.get("modifieddate").toRight("Missing field 'modifieddate'").flatMap(_.as(TypoLocalDateTime.jsonDecoder))
    if (productmodelid.isRight && name.isRight && catalogdescription.isRight && instructions.isRight && rowguid.isRight && modifieddate.isRight)
      Right(ProductmodelRow(productmodelid = productmodelid.toOption.get, name = name.toOption.get, catalogdescription = catalogdescription.toOption.get, instructions = instructions.toOption.get, rowguid = rowguid.toOption.get, modifieddate = modifieddate.toOption.get))
    else Left(List[Either[String, Any]](productmodelid, name, catalogdescription, instructions, rowguid, modifieddate).flatMap(_.left.toOption).mkString(", "))
  }
  implicit lazy val jsonEncoder: JsonEncoder[ProductmodelRow] = new JsonEncoder[ProductmodelRow] {
    override def unsafeEncode(a: ProductmodelRow, indent: Option[Int], out: Write): Unit = {
      out.write("{")
      out.write(""""productmodelid":""")
      ProductmodelId.jsonEncoder.unsafeEncode(a.productmodelid, indent, out)
      out.write(",")
      out.write(""""name":""")
      Name.jsonEncoder.unsafeEncode(a.name, indent, out)
      out.write(",")
      out.write(""""catalogdescription":""")
      JsonEncoder.option(TypoXml.jsonEncoder).unsafeEncode(a.catalogdescription, indent, out)
      out.write(",")
      out.write(""""instructions":""")
      JsonEncoder.option(TypoXml.jsonEncoder).unsafeEncode(a.instructions, indent, out)
      out.write(",")
      out.write(""""rowguid":""")
      TypoUUID.jsonEncoder.unsafeEncode(a.rowguid, indent, out)
      out.write(",")
      out.write(""""modifieddate":""")
      TypoLocalDateTime.jsonEncoder.unsafeEncode(a.modifieddate, indent, out)
      out.write("}")
    }
  }
  implicit lazy val text: Text[ProductmodelRow] = Text.instance[ProductmodelRow]{ (row, sb) =>
    ProductmodelId.text.unsafeEncode(row.productmodelid, sb)
    sb.append(Text.DELIMETER)
    Name.text.unsafeEncode(row.name, sb)
    sb.append(Text.DELIMETER)
    Text.option(TypoXml.text).unsafeEncode(row.catalogdescription, sb)
    sb.append(Text.DELIMETER)
    Text.option(TypoXml.text).unsafeEncode(row.instructions, sb)
    sb.append(Text.DELIMETER)
    TypoUUID.text.unsafeEncode(row.rowguid, sb)
    sb.append(Text.DELIMETER)
    TypoLocalDateTime.text.unsafeEncode(row.modifieddate, sb)
  }
}
