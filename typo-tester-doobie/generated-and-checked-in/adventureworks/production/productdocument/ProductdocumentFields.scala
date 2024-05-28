/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package productdocument

import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.production.document.DocumentFields
import adventureworks.production.document.DocumentId
import adventureworks.production.document.DocumentRow
import adventureworks.production.product.ProductFields
import adventureworks.production.product.ProductId
import adventureworks.production.product.ProductRow
import typo.dsl.ForeignKey
import typo.dsl.Path
import typo.dsl.Required
import typo.dsl.SqlExpr
import typo.dsl.SqlExpr.CompositeIn
import typo.dsl.SqlExpr.CompositeIn.TuplePart
import typo.dsl.SqlExpr.Field
import typo.dsl.SqlExpr.FieldLikeNoHkt
import typo.dsl.SqlExpr.IdField
import typo.dsl.Structure.Relation

trait ProductdocumentFields {
  def productid: IdField[ProductId, ProductdocumentRow]
  def modifieddate: Field[TypoLocalDateTime, ProductdocumentRow]
  def documentnode: IdField[DocumentId, ProductdocumentRow]
  def fkProduct: ForeignKey[ProductFields, ProductRow] =
    ForeignKey[ProductFields, ProductRow]("production.FK_ProductDocument_Product_ProductID", Nil)
      .withColumnPair(productid, _.productid)
  def fkDocument: ForeignKey[DocumentFields, DocumentRow] =
    ForeignKey[DocumentFields, DocumentRow]("production.FK_ProductDocument_Document_DocumentNode", Nil)
      .withColumnPair(documentnode, _.documentnode)
  def compositeIdIs(compositeId: ProductdocumentId): SqlExpr[Boolean, Required] =
    productid.isEqual(compositeId.productid).and(documentnode.isEqual(compositeId.documentnode))
  def compositeIdIn(compositeIds: Array[ProductdocumentId]): SqlExpr[Boolean, Required] =
    new CompositeIn(compositeIds)(TuplePart(productid)(_.productid), TuplePart(documentnode)(_.documentnode))
  
}

object ProductdocumentFields {
  lazy val structure: Relation[ProductdocumentFields, ProductdocumentRow] =
    new Impl(Nil)
    
  private final class Impl(val _path: List[Path])
    extends Relation[ProductdocumentFields, ProductdocumentRow] {
  
    override lazy val fields: ProductdocumentFields = new ProductdocumentFields {
      override def productid = IdField[ProductId, ProductdocumentRow](_path, "productid", None, Some("int4"), x => x.productid, (row, value) => row.copy(productid = value))
      override def modifieddate = Field[TypoLocalDateTime, ProductdocumentRow](_path, "modifieddate", Some("text"), Some("timestamp"), x => x.modifieddate, (row, value) => row.copy(modifieddate = value))
      override def documentnode = IdField[DocumentId, ProductdocumentRow](_path, "documentnode", None, None, x => x.documentnode, (row, value) => row.copy(documentnode = value))
    }
  
    override lazy val columns: List[FieldLikeNoHkt[?, ProductdocumentRow]] =
      List[FieldLikeNoHkt[?, ProductdocumentRow]](fields.productid, fields.modifieddate, fields.documentnode)
  
    override def copy(path: List[Path]): Impl =
      new Impl(path)
  }
  
}
