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
import anorm.Column
import anorm.RowParser
import anorm.Success
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.OWrites
import play.api.libs.json.Reads
import play.api.libs.json.Writes
import scala.collection.immutable.ListMap
import scala.util.Try

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
  implicit lazy val reads: Reads[ProductphotoRow] = Reads[ProductphotoRow](json => JsResult.fromTry(
      Try(
        ProductphotoRow(
          productphotoid = json.\("productphotoid").as(ProductphotoId.reads),
          thumbnailphoto = json.\("thumbnailphoto").toOption.map(_.as(TypoBytea.reads)),
          thumbnailphotofilename = json.\("thumbnailphotofilename").toOption.map(_.as(Reads.StringReads)),
          largephoto = json.\("largephoto").toOption.map(_.as(TypoBytea.reads)),
          largephotofilename = json.\("largephotofilename").toOption.map(_.as(Reads.StringReads)),
          modifieddate = json.\("modifieddate").as(TypoLocalDateTime.reads)
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[ProductphotoRow] = RowParser[ProductphotoRow] { row =>
    Success(
      ProductphotoRow(
        productphotoid = row(idx + 0)(ProductphotoId.column),
        thumbnailphoto = row(idx + 1)(Column.columnToOption(TypoBytea.column)),
        thumbnailphotofilename = row(idx + 2)(Column.columnToOption(Column.columnToString)),
        largephoto = row(idx + 3)(Column.columnToOption(TypoBytea.column)),
        largephotofilename = row(idx + 4)(Column.columnToOption(Column.columnToString)),
        modifieddate = row(idx + 5)(TypoLocalDateTime.column)
      )
    )
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
  implicit lazy val writes: OWrites[ProductphotoRow] = OWrites[ProductphotoRow](o =>
    new JsObject(ListMap[String, JsValue](
      "productphotoid" -> ProductphotoId.writes.writes(o.productphotoid),
      "thumbnailphoto" -> Writes.OptionWrites(TypoBytea.writes).writes(o.thumbnailphoto),
      "thumbnailphotofilename" -> Writes.OptionWrites(Writes.StringWrites).writes(o.thumbnailphotofilename),
      "largephoto" -> Writes.OptionWrites(TypoBytea.writes).writes(o.largephoto),
      "largephotofilename" -> Writes.OptionWrites(Writes.StringWrites).writes(o.largephotofilename),
      "modifieddate" -> TypoLocalDateTime.writes.writes(o.modifieddate)
    ))
  )
}
