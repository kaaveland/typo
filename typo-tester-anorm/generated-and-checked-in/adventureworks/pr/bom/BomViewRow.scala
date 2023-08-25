/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pr
package bom

import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.production.billofmaterials.BillofmaterialsId
import adventureworks.production.product.ProductId
import adventureworks.production.unitmeasure.UnitmeasureId
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

case class BomViewRow(
  id: Int,
  /** Points to [[production.billofmaterials.BillofmaterialsRow.billofmaterialsid]] */
  billofmaterialsid: BillofmaterialsId,
  /** Points to [[production.billofmaterials.BillofmaterialsRow.productassemblyid]] */
  productassemblyid: ProductId,
  /** Points to [[production.billofmaterials.BillofmaterialsRow.componentid]] */
  componentid: ProductId,
  /** Points to [[production.billofmaterials.BillofmaterialsRow.startdate]] */
  startdate: TypoLocalDateTime,
  /** Points to [[production.billofmaterials.BillofmaterialsRow.enddate]] */
  enddate: TypoLocalDateTime,
  /** Points to [[production.billofmaterials.BillofmaterialsRow.unitmeasurecode]] */
  unitmeasurecode: UnitmeasureId,
  /** Points to [[production.billofmaterials.BillofmaterialsRow.bomlevel]] */
  bomlevel: Int,
  /** Points to [[production.billofmaterials.BillofmaterialsRow.perassemblyqty]] */
  perassemblyqty: BigDecimal,
  /** Points to [[production.billofmaterials.BillofmaterialsRow.modifieddate]] */
  modifieddate: TypoLocalDateTime
)

object BomViewRow {
  implicit lazy val reads: Reads[BomViewRow] = Reads[BomViewRow](json => JsResult.fromTry(
      Try(
        BomViewRow(
          id = json.\("id").as(Reads.IntReads),
          billofmaterialsid = json.\("billofmaterialsid").as(BillofmaterialsId.reads),
          productassemblyid = json.\("productassemblyid").as(ProductId.reads),
          componentid = json.\("componentid").as(ProductId.reads),
          startdate = json.\("startdate").as(TypoLocalDateTime.reads),
          enddate = json.\("enddate").as(TypoLocalDateTime.reads),
          unitmeasurecode = json.\("unitmeasurecode").as(UnitmeasureId.reads),
          bomlevel = json.\("bomlevel").as(Reads.IntReads),
          perassemblyqty = json.\("perassemblyqty").as(Reads.bigDecReads),
          modifieddate = json.\("modifieddate").as(TypoLocalDateTime.reads)
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[BomViewRow] = RowParser[BomViewRow] { row =>
    Success(
      BomViewRow(
        id = row(idx + 0)(Column.columnToInt),
        billofmaterialsid = row(idx + 1)(BillofmaterialsId.column),
        productassemblyid = row(idx + 2)(ProductId.column),
        componentid = row(idx + 3)(ProductId.column),
        startdate = row(idx + 4)(TypoLocalDateTime.column),
        enddate = row(idx + 5)(TypoLocalDateTime.column),
        unitmeasurecode = row(idx + 6)(UnitmeasureId.column),
        bomlevel = row(idx + 7)(Column.columnToInt),
        perassemblyqty = row(idx + 8)(Column.columnToScalaBigDecimal),
        modifieddate = row(idx + 9)(TypoLocalDateTime.column)
      )
    )
  }
  implicit lazy val writes: OWrites[BomViewRow] = OWrites[BomViewRow](o =>
    new JsObject(ListMap[String, JsValue](
      "id" -> Writes.IntWrites.writes(o.id),
      "billofmaterialsid" -> BillofmaterialsId.writes.writes(o.billofmaterialsid),
      "productassemblyid" -> ProductId.writes.writes(o.productassemblyid),
      "componentid" -> ProductId.writes.writes(o.componentid),
      "startdate" -> TypoLocalDateTime.writes.writes(o.startdate),
      "enddate" -> TypoLocalDateTime.writes.writes(o.enddate),
      "unitmeasurecode" -> UnitmeasureId.writes.writes(o.unitmeasurecode),
      "bomlevel" -> Writes.IntWrites.writes(o.bomlevel),
      "perassemblyqty" -> Writes.BigDecimalWrites.writes(o.perassemblyqty),
      "modifieddate" -> TypoLocalDateTime.writes.writes(o.modifieddate)
    ))
  )
}
