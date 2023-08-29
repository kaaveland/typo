/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pr
package pdoc

import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.production.document.DocumentId
import adventureworks.production.product.ProductId
import anorm.RowParser
import anorm.Success
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.OWrites
import play.api.libs.json.Reads
import scala.collection.immutable.ListMap
import scala.util.Try

case class PdocViewRow(
  /** Points to [[production.productdocument.ProductdocumentRow.productid]] */
  id: ProductId,
  /** Points to [[production.productdocument.ProductdocumentRow.productid]] */
  productid: ProductId,
  /** Points to [[production.productdocument.ProductdocumentRow.modifieddate]] */
  modifieddate: TypoLocalDateTime,
  /** Points to [[production.productdocument.ProductdocumentRow.documentnode]] */
  documentnode: DocumentId
)

object PdocViewRow {
  implicit lazy val reads: Reads[PdocViewRow] = Reads[PdocViewRow](json => JsResult.fromTry(
      Try(
        PdocViewRow(
          id = json.\("id").as(ProductId.reads),
          productid = json.\("productid").as(ProductId.reads),
          modifieddate = json.\("modifieddate").as(TypoLocalDateTime.reads),
          documentnode = json.\("documentnode").as(DocumentId.reads)
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[PdocViewRow] = RowParser[PdocViewRow] { row =>
    Success(
      PdocViewRow(
        id = row(idx + 0)(ProductId.column),
        productid = row(idx + 1)(ProductId.column),
        modifieddate = row(idx + 2)(TypoLocalDateTime.column),
        documentnode = row(idx + 3)(DocumentId.column)
      )
    )
  }
  implicit lazy val writes: OWrites[PdocViewRow] = OWrites[PdocViewRow](o =>
    new JsObject(ListMap[String, JsValue](
      "id" -> ProductId.writes.writes(o.id),
      "productid" -> ProductId.writes.writes(o.productid),
      "modifieddate" -> TypoLocalDateTime.writes.writes(o.modifieddate),
      "documentnode" -> DocumentId.writes.writes(o.documentnode)
    ))
  )
}
