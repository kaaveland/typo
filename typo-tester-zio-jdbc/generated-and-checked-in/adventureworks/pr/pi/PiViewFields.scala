/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pr
package pi

import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoShort
import adventureworks.customtypes.TypoUUID
import adventureworks.production.location.LocationId
import adventureworks.production.product.ProductId
import typo.dsl.Path
import typo.dsl.SqlExpr.Field
import typo.dsl.SqlExpr.FieldLikeNoHkt
import typo.dsl.Structure.Relation

trait PiViewFields {
  def id: Field[ProductId, PiViewRow]
  def productid: Field[ProductId, PiViewRow]
  def locationid: Field[LocationId, PiViewRow]
  def shelf: Field[/* max 10 chars */ String, PiViewRow]
  def bin: Field[TypoShort, PiViewRow]
  def quantity: Field[TypoShort, PiViewRow]
  def rowguid: Field[TypoUUID, PiViewRow]
  def modifieddate: Field[TypoLocalDateTime, PiViewRow]
}

object PiViewFields {
  lazy val structure: Relation[PiViewFields, PiViewRow] =
    new Impl(Nil)
    
  private final class Impl(val _path: List[Path])
    extends Relation[PiViewFields, PiViewRow] {
  
    override lazy val fields: PiViewFields = new PiViewFields {
      override def id = Field[ProductId, PiViewRow](_path, "id", None, None, x => x.id, (row, value) => row.copy(id = value))
      override def productid = Field[ProductId, PiViewRow](_path, "productid", None, None, x => x.productid, (row, value) => row.copy(productid = value))
      override def locationid = Field[LocationId, PiViewRow](_path, "locationid", None, None, x => x.locationid, (row, value) => row.copy(locationid = value))
      override def shelf = Field[/* max 10 chars */ String, PiViewRow](_path, "shelf", None, None, x => x.shelf, (row, value) => row.copy(shelf = value))
      override def bin = Field[TypoShort, PiViewRow](_path, "bin", None, None, x => x.bin, (row, value) => row.copy(bin = value))
      override def quantity = Field[TypoShort, PiViewRow](_path, "quantity", None, None, x => x.quantity, (row, value) => row.copy(quantity = value))
      override def rowguid = Field[TypoUUID, PiViewRow](_path, "rowguid", None, None, x => x.rowguid, (row, value) => row.copy(rowguid = value))
      override def modifieddate = Field[TypoLocalDateTime, PiViewRow](_path, "modifieddate", Some("text"), None, x => x.modifieddate, (row, value) => row.copy(modifieddate = value))
    }
  
    override lazy val columns: List[FieldLikeNoHkt[?, PiViewRow]] =
      List[FieldLikeNoHkt[?, PiViewRow]](fields.id, fields.productid, fields.locationid, fields.shelf, fields.bin, fields.quantity, fields.rowguid, fields.modifieddate)
  
    override def copy(path: List[Path]): Impl =
      new Impl(path)
  }
  
}
