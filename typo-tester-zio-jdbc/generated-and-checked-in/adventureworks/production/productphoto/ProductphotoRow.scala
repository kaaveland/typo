/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package productphoto

import adventureworks.Text
import adventureworks.customtypes.TypoBytea
import adventureworks.customtypes.TypoLocalDateTime
import java.sql.ResultSet
import zio.jdbc.JdbcDecoder
import zio.json.JsonDecoder
import zio.json.JsonEncoder
import zio.json.ast.Json
import zio.json.internal.Write

/** Table: production.productphoto
    Product images.
    Primary key: productphotoid */
case class ProductphotoRow(
  /** Primary key for ProductPhoto records.
      Default: nextval('production.productphoto_productphotoid_seq'::regclass) */
  productphotoid: ProductphotoId,
  /** Small image of the product. */
  thumbnailphoto: Option[TypoBytea],
  /** Small image file name. */
  thumbnailphotofilename: Option[/* max 50 chars */ String],
  /** Large image of the product. */
  largephoto: Option[TypoBytea],
  /** Large image file name. */
  largephotofilename: Option[/* max 50 chars */ String],
  /** Default: now() */
  modifieddate: TypoLocalDateTime
)

object ProductphotoRow {
  implicit lazy val jdbcDecoder: JdbcDecoder[ProductphotoRow] = new JdbcDecoder[ProductphotoRow] {
    override def unsafeDecode(columIndex: Int, rs: ResultSet): (Int, ProductphotoRow) =
      columIndex + 5 ->
        ProductphotoRow(
          productphotoid = ProductphotoId.jdbcDecoder.unsafeDecode(columIndex + 0, rs)._2,
          thumbnailphoto = JdbcDecoder.optionDecoder(TypoBytea.jdbcDecoder).unsafeDecode(columIndex + 1, rs)._2,
          thumbnailphotofilename = JdbcDecoder.optionDecoder(JdbcDecoder.stringDecoder).unsafeDecode(columIndex + 2, rs)._2,
          largephoto = JdbcDecoder.optionDecoder(TypoBytea.jdbcDecoder).unsafeDecode(columIndex + 3, rs)._2,
          largephotofilename = JdbcDecoder.optionDecoder(JdbcDecoder.stringDecoder).unsafeDecode(columIndex + 4, rs)._2,
          modifieddate = TypoLocalDateTime.jdbcDecoder.unsafeDecode(columIndex + 5, rs)._2
        )
  }
  implicit lazy val jsonDecoder: JsonDecoder[ProductphotoRow] = JsonDecoder[Json.Obj].mapOrFail { jsonObj =>
    val productphotoid = jsonObj.get("productphotoid").toRight("Missing field 'productphotoid'").flatMap(_.as(ProductphotoId.jsonDecoder))
    val thumbnailphoto = jsonObj.get("thumbnailphoto").fold[Either[String, Option[TypoBytea]]](Right(None))(_.as(JsonDecoder.option(using TypoBytea.jsonDecoder)))
    val thumbnailphotofilename = jsonObj.get("thumbnailphotofilename").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(using JsonDecoder.string)))
    val largephoto = jsonObj.get("largephoto").fold[Either[String, Option[TypoBytea]]](Right(None))(_.as(JsonDecoder.option(using TypoBytea.jsonDecoder)))
    val largephotofilename = jsonObj.get("largephotofilename").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(using JsonDecoder.string)))
    val modifieddate = jsonObj.get("modifieddate").toRight("Missing field 'modifieddate'").flatMap(_.as(TypoLocalDateTime.jsonDecoder))
    if (productphotoid.isRight && thumbnailphoto.isRight && thumbnailphotofilename.isRight && largephoto.isRight && largephotofilename.isRight && modifieddate.isRight)
      Right(ProductphotoRow(productphotoid = productphotoid.toOption.get, thumbnailphoto = thumbnailphoto.toOption.get, thumbnailphotofilename = thumbnailphotofilename.toOption.get, largephoto = largephoto.toOption.get, largephotofilename = largephotofilename.toOption.get, modifieddate = modifieddate.toOption.get))
    else Left(List[Either[String, Any]](productphotoid, thumbnailphoto, thumbnailphotofilename, largephoto, largephotofilename, modifieddate).flatMap(_.left.toOption).mkString(", "))
  }
  implicit lazy val jsonEncoder: JsonEncoder[ProductphotoRow] = new JsonEncoder[ProductphotoRow] {
    override def unsafeEncode(a: ProductphotoRow, indent: Option[Int], out: Write): Unit = {
      out.write("{")
      out.write(""""productphotoid":""")
      ProductphotoId.jsonEncoder.unsafeEncode(a.productphotoid, indent, out)
      out.write(",")
      out.write(""""thumbnailphoto":""")
      JsonEncoder.option(using TypoBytea.jsonEncoder).unsafeEncode(a.thumbnailphoto, indent, out)
      out.write(",")
      out.write(""""thumbnailphotofilename":""")
      JsonEncoder.option(using JsonEncoder.string).unsafeEncode(a.thumbnailphotofilename, indent, out)
      out.write(",")
      out.write(""""largephoto":""")
      JsonEncoder.option(using TypoBytea.jsonEncoder).unsafeEncode(a.largephoto, indent, out)
      out.write(",")
      out.write(""""largephotofilename":""")
      JsonEncoder.option(using JsonEncoder.string).unsafeEncode(a.largephotofilename, indent, out)
      out.write(",")
      out.write(""""modifieddate":""")
      TypoLocalDateTime.jsonEncoder.unsafeEncode(a.modifieddate, indent, out)
      out.write("}")
    }
  }
  implicit lazy val text: Text[ProductphotoRow] = Text.instance[ProductphotoRow]{ (row, sb) =>
    ProductphotoId.text.unsafeEncode(row.productphotoid, sb)
    sb.append(Text.DELIMETER)
    Text.option(TypoBytea.text).unsafeEncode(row.thumbnailphoto, sb)
    sb.append(Text.DELIMETER)
    Text.option(Text.stringInstance).unsafeEncode(row.thumbnailphotofilename, sb)
    sb.append(Text.DELIMETER)
    Text.option(TypoBytea.text).unsafeEncode(row.largephoto, sb)
    sb.append(Text.DELIMETER)
    Text.option(Text.stringInstance).unsafeEncode(row.largephotofilename, sb)
    sb.append(Text.DELIMETER)
    TypoLocalDateTime.text.unsafeEncode(row.modifieddate, sb)
  }
}
