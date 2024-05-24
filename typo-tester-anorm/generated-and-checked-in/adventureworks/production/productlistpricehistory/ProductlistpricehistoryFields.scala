/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package productlistpricehistory

import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.production.product.ProductId
import typo.dsl.Path
import typo.dsl.SqlExpr.Field
import typo.dsl.SqlExpr.FieldLikeNoHkt
import typo.dsl.SqlExpr.IdField
import typo.dsl.SqlExpr.OptField
import typo.dsl.Structure.Relation

trait ProductlistpricehistoryFields {
  def productid: IdField[ProductId, ProductlistpricehistoryRow]
  def startdate: IdField[TypoLocalDateTime, ProductlistpricehistoryRow]
  def enddate: OptField[TypoLocalDateTime, ProductlistpricehistoryRow]
  def listprice: Field[BigDecimal, ProductlistpricehistoryRow]
  def modifieddate: Field[TypoLocalDateTime, ProductlistpricehistoryRow]
}

object ProductlistpricehistoryFields {
  lazy val structure: Relation[ProductlistpricehistoryFields, ProductlistpricehistoryRow] =
    new Impl(Nil)
    
  private final class Impl(val _path: List[Path])
    extends Relation[ProductlistpricehistoryFields, ProductlistpricehistoryRow] {
  
    override lazy val fields: ProductlistpricehistoryFields = new ProductlistpricehistoryFields {
      override def productid = IdField[ProductId, ProductlistpricehistoryRow](_path, "productid", None, Some("int4"), x => x.productid, (row, value) => row.copy(productid = value))
      override def startdate = IdField[TypoLocalDateTime, ProductlistpricehistoryRow](_path, "startdate", Some("text"), Some("timestamp"), x => x.startdate, (row, value) => row.copy(startdate = value))
      override def enddate = OptField[TypoLocalDateTime, ProductlistpricehistoryRow](_path, "enddate", Some("text"), Some("timestamp"), x => x.enddate, (row, value) => row.copy(enddate = value))
      override def listprice = Field[BigDecimal, ProductlistpricehistoryRow](_path, "listprice", None, Some("numeric"), x => x.listprice, (row, value) => row.copy(listprice = value))
      override def modifieddate = Field[TypoLocalDateTime, ProductlistpricehistoryRow](_path, "modifieddate", Some("text"), Some("timestamp"), x => x.modifieddate, (row, value) => row.copy(modifieddate = value))
    }
  
    override lazy val columns: List[FieldLikeNoHkt[?, ProductlistpricehistoryRow]] =
      List[FieldLikeNoHkt[?, ProductlistpricehistoryRow]](fields.productid, fields.startdate, fields.enddate, fields.listprice, fields.modifieddate)
  
    override def copy(path: List[Path]): Impl =
      new Impl(path)
  }
  
}
