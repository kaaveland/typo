/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package productinventory

import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoShort
import adventureworks.customtypes.TypoUUID
import adventureworks.production.location.LocationFields
import adventureworks.production.location.LocationId
import adventureworks.production.location.LocationRow
import adventureworks.production.product.ProductFields
import adventureworks.production.product.ProductId
import adventureworks.production.product.ProductRow
import typo.dsl.ForeignKey
import typo.dsl.Path
import typo.dsl.SqlExpr.Field
import typo.dsl.SqlExpr.FieldLikeNoHkt
import typo.dsl.SqlExpr.IdField
import typo.dsl.Structure.Relation

trait ProductinventoryFields {
  def productid: IdField[ProductId, ProductinventoryRow]
  def locationid: IdField[LocationId, ProductinventoryRow]
  def shelf: Field[/* max 10 chars */ String, ProductinventoryRow]
  def bin: Field[TypoShort, ProductinventoryRow]
  def quantity: Field[TypoShort, ProductinventoryRow]
  def rowguid: Field[TypoUUID, ProductinventoryRow]
  def modifieddate: Field[TypoLocalDateTime, ProductinventoryRow]
  def fkLocation: ForeignKey[LocationFields, LocationRow] =
    ForeignKey[LocationFields, LocationRow]("production.FK_ProductInventory_Location_LocationID", Nil)
      .withColumnPair(locationid, _.locationid)
  def fkProduct: ForeignKey[ProductFields, ProductRow] =
    ForeignKey[ProductFields, ProductRow]("production.FK_ProductInventory_Product_ProductID", Nil)
      .withColumnPair(productid, _.productid)
}

object ProductinventoryFields {
  lazy val structure: Relation[ProductinventoryFields, ProductinventoryRow] =
    new Impl(Nil)
    
  private final class Impl(val _path: List[Path])
    extends Relation[ProductinventoryFields, ProductinventoryRow] {
  
    override lazy val fields: ProductinventoryFields = new ProductinventoryFields {
      override def productid = IdField[ProductId, ProductinventoryRow](_path, "productid", None, Some("int4"), x => x.productid, (row, value) => row.copy(productid = value))
      override def locationid = IdField[LocationId, ProductinventoryRow](_path, "locationid", None, Some("int2"), x => x.locationid, (row, value) => row.copy(locationid = value))
      override def shelf = Field[/* max 10 chars */ String, ProductinventoryRow](_path, "shelf", None, None, x => x.shelf, (row, value) => row.copy(shelf = value))
      override def bin = Field[TypoShort, ProductinventoryRow](_path, "bin", None, Some("int2"), x => x.bin, (row, value) => row.copy(bin = value))
      override def quantity = Field[TypoShort, ProductinventoryRow](_path, "quantity", None, Some("int2"), x => x.quantity, (row, value) => row.copy(quantity = value))
      override def rowguid = Field[TypoUUID, ProductinventoryRow](_path, "rowguid", None, Some("uuid"), x => x.rowguid, (row, value) => row.copy(rowguid = value))
      override def modifieddate = Field[TypoLocalDateTime, ProductinventoryRow](_path, "modifieddate", Some("text"), Some("timestamp"), x => x.modifieddate, (row, value) => row.copy(modifieddate = value))
    }
  
    override lazy val columns: List[FieldLikeNoHkt[?, ProductinventoryRow]] =
      List[FieldLikeNoHkt[?, ProductinventoryRow]](fields.productid, fields.locationid, fields.shelf, fields.bin, fields.quantity, fields.rowguid, fields.modifieddate)
  
    override def copy(path: List[Path]): Impl =
      new Impl(path)
  }
  
}
