/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package billofmaterials

import adventureworks.Text
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoShort
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

/** Table: production.billofmaterials
    Items required to make bicycles and bicycle subassemblies. It identifies the heirarchical relationship between a parent product and its components.
    Primary key: billofmaterialsid */
case class BillofmaterialsRow(
  /** Primary key for BillOfMaterials records.
      Default: nextval('production.billofmaterials_billofmaterialsid_seq'::regclass) */
  billofmaterialsid: Int,
  /** Parent product identification number. Foreign key to Product.ProductID.
      Points to [[product.ProductRow.productid]]
      Constraint CK_BillOfMaterials_BOMLevel affecting columns bomlevel, perassemblyqty, productassemblyid: ((((productassemblyid IS NULL) AND (bomlevel = 0) AND (perassemblyqty = 1.00)) OR ((productassemblyid IS NOT NULL) AND (bomlevel >= 1))))
      Constraint CK_BillOfMaterials_ProductAssemblyID affecting columns componentid, productassemblyid: ((productassemblyid <> componentid)) */
  productassemblyid: Option[ProductId],
  /** Component identification number. Foreign key to Product.ProductID.
      Points to [[product.ProductRow.productid]]
      Constraint CK_BillOfMaterials_ProductAssemblyID affecting columns componentid, productassemblyid: ((productassemblyid <> componentid)) */
  componentid: ProductId,
  /** Date the component started being used in the assembly item.
      Default: now()
      Constraint CK_BillOfMaterials_EndDate affecting columns enddate, startdate: (((enddate > startdate) OR (enddate IS NULL))) */
  startdate: TypoLocalDateTime,
  /** Date the component stopped being used in the assembly item.
      Constraint CK_BillOfMaterials_EndDate affecting columns enddate, startdate: (((enddate > startdate) OR (enddate IS NULL))) */
  enddate: Option[TypoLocalDateTime],
  /** Standard code identifying the unit of measure for the quantity.
      Points to [[unitmeasure.UnitmeasureRow.unitmeasurecode]] */
  unitmeasurecode: UnitmeasureId,
  /** Indicates the depth the component is from its parent (AssemblyID).
      Constraint CK_BillOfMaterials_BOMLevel affecting columns bomlevel, perassemblyqty, productassemblyid: ((((productassemblyid IS NULL) AND (bomlevel = 0) AND (perassemblyqty = 1.00)) OR ((productassemblyid IS NOT NULL) AND (bomlevel >= 1)))) */
  bomlevel: TypoShort,
  /** Quantity of the component needed to create the assembly.
      Default: 1.00
      Constraint CK_BillOfMaterials_BOMLevel affecting columns bomlevel, perassemblyqty, productassemblyid: ((((productassemblyid IS NULL) AND (bomlevel = 0) AND (perassemblyqty = 1.00)) OR ((productassemblyid IS NOT NULL) AND (bomlevel >= 1))))
      Constraint CK_BillOfMaterials_PerAssemblyQty affecting columns perassemblyqty: ((perassemblyqty >= 1.00)) */
  perassemblyqty: BigDecimal,
  /** Default: now() */
  modifieddate: TypoLocalDateTime
)

object BillofmaterialsRow {
  implicit lazy val reads: Reads[BillofmaterialsRow] = Reads[BillofmaterialsRow](json => JsResult.fromTry(
      Try(
        BillofmaterialsRow(
          billofmaterialsid = json.\("billofmaterialsid").as(Reads.IntReads),
          productassemblyid = json.\("productassemblyid").toOption.map(_.as(ProductId.reads)),
          componentid = json.\("componentid").as(ProductId.reads),
          startdate = json.\("startdate").as(TypoLocalDateTime.reads),
          enddate = json.\("enddate").toOption.map(_.as(TypoLocalDateTime.reads)),
          unitmeasurecode = json.\("unitmeasurecode").as(UnitmeasureId.reads),
          bomlevel = json.\("bomlevel").as(TypoShort.reads),
          perassemblyqty = json.\("perassemblyqty").as(Reads.bigDecReads),
          modifieddate = json.\("modifieddate").as(TypoLocalDateTime.reads)
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[BillofmaterialsRow] = RowParser[BillofmaterialsRow] { row =>
    Success(
      BillofmaterialsRow(
        billofmaterialsid = row(idx + 0)(Column.columnToInt),
        productassemblyid = row(idx + 1)(Column.columnToOption(ProductId.column)),
        componentid = row(idx + 2)(ProductId.column),
        startdate = row(idx + 3)(TypoLocalDateTime.column),
        enddate = row(idx + 4)(Column.columnToOption(TypoLocalDateTime.column)),
        unitmeasurecode = row(idx + 5)(UnitmeasureId.column),
        bomlevel = row(idx + 6)(TypoShort.column),
        perassemblyqty = row(idx + 7)(Column.columnToScalaBigDecimal),
        modifieddate = row(idx + 8)(TypoLocalDateTime.column)
      )
    )
  }
  implicit lazy val text: Text[BillofmaterialsRow] = Text.instance[BillofmaterialsRow]{ (row, sb) =>
    Text.intInstance.unsafeEncode(row.billofmaterialsid, sb)
    sb.append(Text.DELIMETER)
    Text.option(ProductId.text).unsafeEncode(row.productassemblyid, sb)
    sb.append(Text.DELIMETER)
    ProductId.text.unsafeEncode(row.componentid, sb)
    sb.append(Text.DELIMETER)
    TypoLocalDateTime.text.unsafeEncode(row.startdate, sb)
    sb.append(Text.DELIMETER)
    Text.option(TypoLocalDateTime.text).unsafeEncode(row.enddate, sb)
    sb.append(Text.DELIMETER)
    UnitmeasureId.text.unsafeEncode(row.unitmeasurecode, sb)
    sb.append(Text.DELIMETER)
    TypoShort.text.unsafeEncode(row.bomlevel, sb)
    sb.append(Text.DELIMETER)
    Text.bigDecimalInstance.unsafeEncode(row.perassemblyqty, sb)
    sb.append(Text.DELIMETER)
    TypoLocalDateTime.text.unsafeEncode(row.modifieddate, sb)
  }
  implicit lazy val writes: OWrites[BillofmaterialsRow] = OWrites[BillofmaterialsRow](o =>
    new JsObject(ListMap[String, JsValue](
      "billofmaterialsid" -> Writes.IntWrites.writes(o.billofmaterialsid),
      "productassemblyid" -> Writes.OptionWrites(ProductId.writes).writes(o.productassemblyid),
      "componentid" -> ProductId.writes.writes(o.componentid),
      "startdate" -> TypoLocalDateTime.writes.writes(o.startdate),
      "enddate" -> Writes.OptionWrites(TypoLocalDateTime.writes).writes(o.enddate),
      "unitmeasurecode" -> UnitmeasureId.writes.writes(o.unitmeasurecode),
      "bomlevel" -> TypoShort.writes.writes(o.bomlevel),
      "perassemblyqty" -> Writes.BigDecimalWrites.writes(o.perassemblyqty),
      "modifieddate" -> TypoLocalDateTime.writes.writes(o.modifieddate)
    ))
  )
}
