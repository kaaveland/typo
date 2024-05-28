/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package purchasing
package productvendor

import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.person.businessentity.BusinessentityId
import adventureworks.production.product.ProductFields
import adventureworks.production.product.ProductId
import adventureworks.production.product.ProductRow
import adventureworks.production.unitmeasure.UnitmeasureFields
import adventureworks.production.unitmeasure.UnitmeasureId
import adventureworks.production.unitmeasure.UnitmeasureRow
import adventureworks.purchasing.vendor.VendorFields
import adventureworks.purchasing.vendor.VendorRow
import typo.dsl.ForeignKey
import typo.dsl.Path
import typo.dsl.Required
import typo.dsl.SqlExpr
import typo.dsl.SqlExpr.CompositeIn
import typo.dsl.SqlExpr.CompositeIn.TuplePart
import typo.dsl.SqlExpr.Field
import typo.dsl.SqlExpr.FieldLikeNoHkt
import typo.dsl.SqlExpr.IdField
import typo.dsl.SqlExpr.OptField
import typo.dsl.Structure.Relation

trait ProductvendorFields {
  def productid: IdField[ProductId, ProductvendorRow]
  def businessentityid: IdField[BusinessentityId, ProductvendorRow]
  def averageleadtime: Field[Int, ProductvendorRow]
  def standardprice: Field[BigDecimal, ProductvendorRow]
  def lastreceiptcost: OptField[BigDecimal, ProductvendorRow]
  def lastreceiptdate: OptField[TypoLocalDateTime, ProductvendorRow]
  def minorderqty: Field[Int, ProductvendorRow]
  def maxorderqty: Field[Int, ProductvendorRow]
  def onorderqty: OptField[Int, ProductvendorRow]
  def unitmeasurecode: Field[UnitmeasureId, ProductvendorRow]
  def modifieddate: Field[TypoLocalDateTime, ProductvendorRow]
  def fkProductionProduct: ForeignKey[ProductFields, ProductRow] =
    ForeignKey[ProductFields, ProductRow]("purchasing.FK_ProductVendor_Product_ProductID", Nil)
      .withColumnPair(productid, _.productid)
  def fkProductionUnitmeasure: ForeignKey[UnitmeasureFields, UnitmeasureRow] =
    ForeignKey[UnitmeasureFields, UnitmeasureRow]("purchasing.FK_ProductVendor_UnitMeasure_UnitMeasureCode", Nil)
      .withColumnPair(unitmeasurecode, _.unitmeasurecode)
  def fkVendor: ForeignKey[VendorFields, VendorRow] =
    ForeignKey[VendorFields, VendorRow]("purchasing.FK_ProductVendor_Vendor_BusinessEntityID", Nil)
      .withColumnPair(businessentityid, _.businessentityid)
  def compositeIdIs(compositeId: ProductvendorId): SqlExpr[Boolean, Required] =
    productid.isEqual(compositeId.productid).and(businessentityid.isEqual(compositeId.businessentityid))
  def compositeIdIn(compositeIds: Array[ProductvendorId]): SqlExpr[Boolean, Required] =
    new CompositeIn(compositeIds)(TuplePart(productid)(_.productid), TuplePart(businessentityid)(_.businessentityid))
  
}

object ProductvendorFields {
  lazy val structure: Relation[ProductvendorFields, ProductvendorRow] =
    new Impl(Nil)
    
  private final class Impl(val _path: List[Path])
    extends Relation[ProductvendorFields, ProductvendorRow] {
  
    override lazy val fields: ProductvendorFields = new ProductvendorFields {
      override def productid = IdField[ProductId, ProductvendorRow](_path, "productid", None, Some("int4"), x => x.productid, (row, value) => row.copy(productid = value))
      override def businessentityid = IdField[BusinessentityId, ProductvendorRow](_path, "businessentityid", None, Some("int4"), x => x.businessentityid, (row, value) => row.copy(businessentityid = value))
      override def averageleadtime = Field[Int, ProductvendorRow](_path, "averageleadtime", None, Some("int4"), x => x.averageleadtime, (row, value) => row.copy(averageleadtime = value))
      override def standardprice = Field[BigDecimal, ProductvendorRow](_path, "standardprice", None, Some("numeric"), x => x.standardprice, (row, value) => row.copy(standardprice = value))
      override def lastreceiptcost = OptField[BigDecimal, ProductvendorRow](_path, "lastreceiptcost", None, Some("numeric"), x => x.lastreceiptcost, (row, value) => row.copy(lastreceiptcost = value))
      override def lastreceiptdate = OptField[TypoLocalDateTime, ProductvendorRow](_path, "lastreceiptdate", Some("text"), Some("timestamp"), x => x.lastreceiptdate, (row, value) => row.copy(lastreceiptdate = value))
      override def minorderqty = Field[Int, ProductvendorRow](_path, "minorderqty", None, Some("int4"), x => x.minorderqty, (row, value) => row.copy(minorderqty = value))
      override def maxorderqty = Field[Int, ProductvendorRow](_path, "maxorderqty", None, Some("int4"), x => x.maxorderqty, (row, value) => row.copy(maxorderqty = value))
      override def onorderqty = OptField[Int, ProductvendorRow](_path, "onorderqty", None, Some("int4"), x => x.onorderqty, (row, value) => row.copy(onorderqty = value))
      override def unitmeasurecode = Field[UnitmeasureId, ProductvendorRow](_path, "unitmeasurecode", None, Some("bpchar"), x => x.unitmeasurecode, (row, value) => row.copy(unitmeasurecode = value))
      override def modifieddate = Field[TypoLocalDateTime, ProductvendorRow](_path, "modifieddate", Some("text"), Some("timestamp"), x => x.modifieddate, (row, value) => row.copy(modifieddate = value))
    }
  
    override lazy val columns: List[FieldLikeNoHkt[?, ProductvendorRow]] =
      List[FieldLikeNoHkt[?, ProductvendorRow]](fields.productid, fields.businessentityid, fields.averageleadtime, fields.standardprice, fields.lastreceiptcost, fields.lastreceiptdate, fields.minorderqty, fields.maxorderqty, fields.onorderqty, fields.unitmeasurecode, fields.modifieddate)
  
    override def copy(path: List[Path]): Impl =
      new Impl(path)
  }
  
}
