/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package productdescription

import adventureworks.Text
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoUUID
import java.sql.ResultSet
import zio.jdbc.JdbcDecoder
import zio.json.JsonDecoder
import zio.json.JsonEncoder
import zio.json.ast.Json
import zio.json.internal.Write

case class ProductdescriptionRow(
  /** Primary key for ProductDescription records.
      Default: nextval('production.productdescription_productdescriptionid_seq'::regclass) */
  productdescriptionid: ProductdescriptionId,
  /** Description of the product. */
  description: /* max 400 chars */ String,
  /** Default: uuid_generate_v1() */
  rowguid: TypoUUID,
  /** Default: now() */
  modifieddate: TypoLocalDateTime
)

object ProductdescriptionRow {
  implicit lazy val jdbcDecoder: JdbcDecoder[ProductdescriptionRow] = new JdbcDecoder[ProductdescriptionRow] {
    override def unsafeDecode(columIndex: Int, rs: ResultSet): (Int, ProductdescriptionRow) =
      columIndex + 3 ->
        ProductdescriptionRow(
          productdescriptionid = ProductdescriptionId.jdbcDecoder.unsafeDecode(columIndex + 0, rs)._2,
          description = JdbcDecoder.stringDecoder.unsafeDecode(columIndex + 1, rs)._2,
          rowguid = TypoUUID.jdbcDecoder.unsafeDecode(columIndex + 2, rs)._2,
          modifieddate = TypoLocalDateTime.jdbcDecoder.unsafeDecode(columIndex + 3, rs)._2
        )
  }
  implicit lazy val jsonDecoder: JsonDecoder[ProductdescriptionRow] = JsonDecoder[Json.Obj].mapOrFail { jsonObj =>
    val productdescriptionid = jsonObj.get("productdescriptionid").toRight("Missing field 'productdescriptionid'").flatMap(_.as(ProductdescriptionId.jsonDecoder))
    val description = jsonObj.get("description").toRight("Missing field 'description'").flatMap(_.as(JsonDecoder.string))
    val rowguid = jsonObj.get("rowguid").toRight("Missing field 'rowguid'").flatMap(_.as(TypoUUID.jsonDecoder))
    val modifieddate = jsonObj.get("modifieddate").toRight("Missing field 'modifieddate'").flatMap(_.as(TypoLocalDateTime.jsonDecoder))
    if (productdescriptionid.isRight && description.isRight && rowguid.isRight && modifieddate.isRight)
      Right(ProductdescriptionRow(productdescriptionid = productdescriptionid.toOption.get, description = description.toOption.get, rowguid = rowguid.toOption.get, modifieddate = modifieddate.toOption.get))
    else Left(List[Either[String, Any]](productdescriptionid, description, rowguid, modifieddate).flatMap(_.left.toOption).mkString(", "))
  }
  implicit lazy val jsonEncoder: JsonEncoder[ProductdescriptionRow] = new JsonEncoder[ProductdescriptionRow] {
    override def unsafeEncode(a: ProductdescriptionRow, indent: Option[Int], out: Write): Unit = {
      out.write("{")
      out.write(""""productdescriptionid":""")
      ProductdescriptionId.jsonEncoder.unsafeEncode(a.productdescriptionid, indent, out)
      out.write(",")
      out.write(""""description":""")
      JsonEncoder.string.unsafeEncode(a.description, indent, out)
      out.write(",")
      out.write(""""rowguid":""")
      TypoUUID.jsonEncoder.unsafeEncode(a.rowguid, indent, out)
      out.write(",")
      out.write(""""modifieddate":""")
      TypoLocalDateTime.jsonEncoder.unsafeEncode(a.modifieddate, indent, out)
      out.write("}")
    }
  }
  implicit lazy val text: Text[ProductdescriptionRow] = Text.instance[ProductdescriptionRow]{ (row, sb) =>
    ProductdescriptionId.text.unsafeEncode(row.productdescriptionid, sb)
    sb.append(Text.DELIMETER)
    Text.stringInstance.unsafeEncode(row.description, sb)
    sb.append(Text.DELIMETER)
    TypoUUID.text.unsafeEncode(row.rowguid, sb)
    sb.append(Text.DELIMETER)
    TypoLocalDateTime.text.unsafeEncode(row.modifieddate, sb)
  }
}
