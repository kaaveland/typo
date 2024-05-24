/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package productmodelproductdescriptionculture

import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.production.culture.CultureFields
import adventureworks.production.culture.CultureId
import adventureworks.production.culture.CultureRow
import adventureworks.production.productdescription.ProductdescriptionFields
import adventureworks.production.productdescription.ProductdescriptionId
import adventureworks.production.productdescription.ProductdescriptionRow
import adventureworks.production.productmodel.ProductmodelFields
import adventureworks.production.productmodel.ProductmodelId
import adventureworks.production.productmodel.ProductmodelRow
import typo.dsl.ForeignKey
import typo.dsl.Path
import typo.dsl.SqlExpr.Field
import typo.dsl.SqlExpr.FieldLikeNoHkt
import typo.dsl.SqlExpr.IdField
import typo.dsl.Structure.Relation

trait ProductmodelproductdescriptioncultureFields {
  def productmodelid: IdField[ProductmodelId, ProductmodelproductdescriptioncultureRow]
  def productdescriptionid: IdField[ProductdescriptionId, ProductmodelproductdescriptioncultureRow]
  def cultureid: IdField[CultureId, ProductmodelproductdescriptioncultureRow]
  def modifieddate: Field[TypoLocalDateTime, ProductmodelproductdescriptioncultureRow]
  def fkProductdescription: ForeignKey[ProductdescriptionFields, ProductdescriptionRow] =
    ForeignKey[ProductdescriptionFields, ProductdescriptionRow]("production.FK_ProductModelProductDescriptionCulture_ProductDescription_Pro", Nil)
      .withColumnPair(productdescriptionid, _.productdescriptionid)
  def fkCulture: ForeignKey[CultureFields, CultureRow] =
    ForeignKey[CultureFields, CultureRow]("production.FK_ProductModelProductDescriptionCulture_Culture_CultureID", Nil)
      .withColumnPair(cultureid, _.cultureid)
  def fkProductmodel: ForeignKey[ProductmodelFields, ProductmodelRow] =
    ForeignKey[ProductmodelFields, ProductmodelRow]("production.FK_ProductModelProductDescriptionCulture_ProductModel_ProductMo", Nil)
      .withColumnPair(productmodelid, _.productmodelid)
}

object ProductmodelproductdescriptioncultureFields {
  lazy val structure: Relation[ProductmodelproductdescriptioncultureFields, ProductmodelproductdescriptioncultureRow] =
    new Impl(Nil)
    
  private final class Impl(val _path: List[Path])
    extends Relation[ProductmodelproductdescriptioncultureFields, ProductmodelproductdescriptioncultureRow] {
  
    override lazy val fields: ProductmodelproductdescriptioncultureFields = new ProductmodelproductdescriptioncultureFields {
      override def productmodelid = IdField[ProductmodelId, ProductmodelproductdescriptioncultureRow](_path, "productmodelid", None, Some("int4"), x => x.productmodelid, (row, value) => row.copy(productmodelid = value))
      override def productdescriptionid = IdField[ProductdescriptionId, ProductmodelproductdescriptioncultureRow](_path, "productdescriptionid", None, Some("int4"), x => x.productdescriptionid, (row, value) => row.copy(productdescriptionid = value))
      override def cultureid = IdField[CultureId, ProductmodelproductdescriptioncultureRow](_path, "cultureid", None, Some("bpchar"), x => x.cultureid, (row, value) => row.copy(cultureid = value))
      override def modifieddate = Field[TypoLocalDateTime, ProductmodelproductdescriptioncultureRow](_path, "modifieddate", Some("text"), Some("timestamp"), x => x.modifieddate, (row, value) => row.copy(modifieddate = value))
    }
  
    override lazy val columns: List[FieldLikeNoHkt[?, ProductmodelproductdescriptioncultureRow]] =
      List[FieldLikeNoHkt[?, ProductmodelproductdescriptioncultureRow]](fields.productmodelid, fields.productdescriptionid, fields.cultureid, fields.modifieddate)
  
    override def copy(path: List[Path]): Impl =
      new Impl(path)
  }
  
}
