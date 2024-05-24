/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package productproductphoto

import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.production.product.ProductFields
import adventureworks.production.product.ProductId
import adventureworks.production.product.ProductRow
import adventureworks.production.productphoto.ProductphotoFields
import adventureworks.production.productphoto.ProductphotoId
import adventureworks.production.productphoto.ProductphotoRow
import adventureworks.public.Flag
import typo.dsl.ForeignKey
import typo.dsl.Path
import typo.dsl.SqlExpr.Field
import typo.dsl.SqlExpr.FieldLikeNoHkt
import typo.dsl.SqlExpr.IdField
import typo.dsl.Structure.Relation

trait ProductproductphotoFields {
  def productid: IdField[ProductId, ProductproductphotoRow]
  def productphotoid: IdField[ProductphotoId, ProductproductphotoRow]
  def primary: Field[Flag, ProductproductphotoRow]
  def modifieddate: Field[TypoLocalDateTime, ProductproductphotoRow]
  def fkProduct: ForeignKey[ProductFields, ProductRow] =
    ForeignKey[ProductFields, ProductRow]("production.FK_ProductProductPhoto_Product_ProductID", Nil)
      .withColumnPair(productid, _.productid)
  def fkProductphoto: ForeignKey[ProductphotoFields, ProductphotoRow] =
    ForeignKey[ProductphotoFields, ProductphotoRow]("production.FK_ProductProductPhoto_ProductPhoto_ProductPhotoID", Nil)
      .withColumnPair(productphotoid, _.productphotoid)
}

object ProductproductphotoFields {
  lazy val structure: Relation[ProductproductphotoFields, ProductproductphotoRow] =
    new Impl(Nil)
    
  private final class Impl(val _path: List[Path])
    extends Relation[ProductproductphotoFields, ProductproductphotoRow] {
  
    override lazy val fields: ProductproductphotoFields = new ProductproductphotoFields {
      override def productid = IdField[ProductId, ProductproductphotoRow](_path, "productid", None, Some("int4"), x => x.productid, (row, value) => row.copy(productid = value))
      override def productphotoid = IdField[ProductphotoId, ProductproductphotoRow](_path, "productphotoid", None, Some("int4"), x => x.productphotoid, (row, value) => row.copy(productphotoid = value))
      override def primary = Field[Flag, ProductproductphotoRow](_path, "primary", None, Some("bool"), x => x.primary, (row, value) => row.copy(primary = value))
      override def modifieddate = Field[TypoLocalDateTime, ProductproductphotoRow](_path, "modifieddate", Some("text"), Some("timestamp"), x => x.modifieddate, (row, value) => row.copy(modifieddate = value))
    }
  
    override lazy val columns: List[FieldLikeNoHkt[?, ProductproductphotoRow]] =
      List[FieldLikeNoHkt[?, ProductproductphotoRow]](fields.productid, fields.productphotoid, fields.primary, fields.modifieddate)
  
    override def copy(path: List[Path]): Impl =
      new Impl(path)
  }
  
}
