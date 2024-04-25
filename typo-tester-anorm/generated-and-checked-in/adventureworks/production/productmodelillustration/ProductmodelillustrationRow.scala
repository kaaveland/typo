/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package productmodelillustration

import adventureworks.Text
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.production.illustration.IllustrationId
import adventureworks.production.productmodel.ProductmodelId
import anorm.RowParser
import anorm.Success
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.OWrites
import play.api.libs.json.Reads
import scala.collection.immutable.ListMap
import scala.util.Try

/** Table: production.productmodelillustration
    Cross-reference table mapping product models and illustrations.
    Composite primary key: productmodelid, illustrationid */
case class ProductmodelillustrationRow(
  /** Primary key. Foreign key to ProductModel.ProductModelID.
      Points to [[productmodel.ProductmodelRow.productmodelid]] */
  productmodelid: ProductmodelId,
  /** Primary key. Foreign key to Illustration.IllustrationID.
      Points to [[illustration.IllustrationRow.illustrationid]] */
  illustrationid: IllustrationId,
  /** Default: now() */
  modifieddate: TypoLocalDateTime
){
   val compositeId: ProductmodelillustrationId = ProductmodelillustrationId(productmodelid, illustrationid)
 }

object ProductmodelillustrationRow {
  def apply(compositeId: ProductmodelillustrationId, modifieddate: TypoLocalDateTime) =
    new ProductmodelillustrationRow(compositeId.productmodelid, compositeId.illustrationid, modifieddate)
  implicit lazy val reads: Reads[ProductmodelillustrationRow] = Reads[ProductmodelillustrationRow](json => JsResult.fromTry(
      Try(
        ProductmodelillustrationRow(
          productmodelid = json.\("productmodelid").as(ProductmodelId.reads),
          illustrationid = json.\("illustrationid").as(IllustrationId.reads),
          modifieddate = json.\("modifieddate").as(TypoLocalDateTime.reads)
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[ProductmodelillustrationRow] = RowParser[ProductmodelillustrationRow] { row =>
    Success(
      ProductmodelillustrationRow(
        productmodelid = row(idx + 0)(ProductmodelId.column),
        illustrationid = row(idx + 1)(IllustrationId.column),
        modifieddate = row(idx + 2)(TypoLocalDateTime.column)
      )
    )
  }
  implicit lazy val text: Text[ProductmodelillustrationRow] = Text.instance[ProductmodelillustrationRow]{ (row, sb) =>
    ProductmodelId.text.unsafeEncode(row.productmodelid, sb)
    sb.append(Text.DELIMETER)
    IllustrationId.text.unsafeEncode(row.illustrationid, sb)
    sb.append(Text.DELIMETER)
    TypoLocalDateTime.text.unsafeEncode(row.modifieddate, sb)
  }
  implicit lazy val writes: OWrites[ProductmodelillustrationRow] = OWrites[ProductmodelillustrationRow](o =>
    new JsObject(ListMap[String, JsValue](
      "productmodelid" -> ProductmodelId.writes.writes(o.productmodelid),
      "illustrationid" -> IllustrationId.writes.writes(o.illustrationid),
      "modifieddate" -> TypoLocalDateTime.writes.writes(o.modifieddate)
    ))
  )
}
