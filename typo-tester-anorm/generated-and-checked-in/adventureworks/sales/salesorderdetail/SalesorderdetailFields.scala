/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package salesorderdetail

import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoShort
import adventureworks.customtypes.TypoUUID
import adventureworks.production.product.ProductId
import adventureworks.sales.salesorderheader.SalesorderheaderId
import adventureworks.sales.specialoffer.SpecialofferId
import typo.dsl.Path
import typo.dsl.SqlExpr.Field
import typo.dsl.SqlExpr.FieldLikeNoHkt
import typo.dsl.SqlExpr.IdField
import typo.dsl.SqlExpr.OptField
import typo.dsl.Structure.Relation

trait SalesorderdetailFields {
  def salesorderid: IdField[SalesorderheaderId, SalesorderdetailRow]
  def salesorderdetailid: IdField[Int, SalesorderdetailRow]
  def carriertrackingnumber: OptField[/* max 25 chars */ String, SalesorderdetailRow]
  def orderqty: Field[TypoShort, SalesorderdetailRow]
  def productid: Field[ProductId, SalesorderdetailRow]
  def specialofferid: Field[SpecialofferId, SalesorderdetailRow]
  def unitprice: Field[BigDecimal, SalesorderdetailRow]
  def unitpricediscount: Field[BigDecimal, SalesorderdetailRow]
  def rowguid: Field[TypoUUID, SalesorderdetailRow]
  def modifieddate: Field[TypoLocalDateTime, SalesorderdetailRow]
}

object SalesorderdetailFields {
  lazy val structure: Relation[SalesorderdetailFields, SalesorderdetailRow] =
    new Impl(Nil)
    
  private final class Impl(val _path: List[Path])
    extends Relation[SalesorderdetailFields, SalesorderdetailRow] {
  
    override lazy val fields: SalesorderdetailFields = new SalesorderdetailFields {
      override def salesorderid = IdField[SalesorderheaderId, SalesorderdetailRow](_path, "salesorderid", None, Some("int4"), x => x.salesorderid, (row, value) => row.copy(salesorderid = value))
      override def salesorderdetailid = IdField[Int, SalesorderdetailRow](_path, "salesorderdetailid", None, Some("int4"), x => x.salesorderdetailid, (row, value) => row.copy(salesorderdetailid = value))
      override def carriertrackingnumber = OptField[/* max 25 chars */ String, SalesorderdetailRow](_path, "carriertrackingnumber", None, None, x => x.carriertrackingnumber, (row, value) => row.copy(carriertrackingnumber = value))
      override def orderqty = Field[TypoShort, SalesorderdetailRow](_path, "orderqty", None, Some("int2"), x => x.orderqty, (row, value) => row.copy(orderqty = value))
      override def productid = Field[ProductId, SalesorderdetailRow](_path, "productid", None, Some("int4"), x => x.productid, (row, value) => row.copy(productid = value))
      override def specialofferid = Field[SpecialofferId, SalesorderdetailRow](_path, "specialofferid", None, Some("int4"), x => x.specialofferid, (row, value) => row.copy(specialofferid = value))
      override def unitprice = Field[BigDecimal, SalesorderdetailRow](_path, "unitprice", None, Some("numeric"), x => x.unitprice, (row, value) => row.copy(unitprice = value))
      override def unitpricediscount = Field[BigDecimal, SalesorderdetailRow](_path, "unitpricediscount", None, Some("numeric"), x => x.unitpricediscount, (row, value) => row.copy(unitpricediscount = value))
      override def rowguid = Field[TypoUUID, SalesorderdetailRow](_path, "rowguid", None, Some("uuid"), x => x.rowguid, (row, value) => row.copy(rowguid = value))
      override def modifieddate = Field[TypoLocalDateTime, SalesorderdetailRow](_path, "modifieddate", Some("text"), Some("timestamp"), x => x.modifieddate, (row, value) => row.copy(modifieddate = value))
    }
  
    override lazy val columns: List[FieldLikeNoHkt[?, SalesorderdetailRow]] =
      List[FieldLikeNoHkt[?, SalesorderdetailRow]](fields.salesorderid, fields.salesorderdetailid, fields.carriertrackingnumber, fields.orderqty, fields.productid, fields.specialofferid, fields.unitprice, fields.unitpricediscount, fields.rowguid, fields.modifieddate)
  
    override def copy(path: List[Path]): Impl =
      new Impl(path)
  }
  
}
