/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sa
package sci

import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.production.product.ProductId
import adventureworks.sales.shoppingcartitem.ShoppingcartitemId
import typo.dsl.SqlExpr.Field
import typo.dsl.SqlExpr.FieldLikeNoHkt
import typo.dsl.Structure.Relation

trait SciViewFields[Row] {
  val id: Field[ShoppingcartitemId, Row]
  val shoppingcartitemid: Field[ShoppingcartitemId, Row]
  val shoppingcartid: Field[/* max 50 chars */ String, Row]
  val quantity: Field[Int, Row]
  val productid: Field[ProductId, Row]
  val datecreated: Field[TypoLocalDateTime, Row]
  val modifieddate: Field[TypoLocalDateTime, Row]
}

object SciViewFields {
  val structure: Relation[SciViewFields, SciViewRow, SciViewRow] = 
    new Impl(None, identity, (_, x) => x)
    
  private final class Impl[Row](val prefix: Option[String], val extract: Row => SciViewRow, val merge: (Row, SciViewRow) => Row)
    extends Relation[SciViewFields, SciViewRow, Row] { 
  
    override val fields: SciViewFields[Row] = new SciViewFields[Row] {
      override val id = new Field[ShoppingcartitemId, Row](prefix, "id", None, None)(x => extract(x).id, (row, value) => merge(row, extract(row).copy(id = value)))
      override val shoppingcartitemid = new Field[ShoppingcartitemId, Row](prefix, "shoppingcartitemid", None, None)(x => extract(x).shoppingcartitemid, (row, value) => merge(row, extract(row).copy(shoppingcartitemid = value)))
      override val shoppingcartid = new Field[/* max 50 chars */ String, Row](prefix, "shoppingcartid", None, None)(x => extract(x).shoppingcartid, (row, value) => merge(row, extract(row).copy(shoppingcartid = value)))
      override val quantity = new Field[Int, Row](prefix, "quantity", None, None)(x => extract(x).quantity, (row, value) => merge(row, extract(row).copy(quantity = value)))
      override val productid = new Field[ProductId, Row](prefix, "productid", None, None)(x => extract(x).productid, (row, value) => merge(row, extract(row).copy(productid = value)))
      override val datecreated = new Field[TypoLocalDateTime, Row](prefix, "datecreated", Some("text"), None)(x => extract(x).datecreated, (row, value) => merge(row, extract(row).copy(datecreated = value)))
      override val modifieddate = new Field[TypoLocalDateTime, Row](prefix, "modifieddate", Some("text"), None)(x => extract(x).modifieddate, (row, value) => merge(row, extract(row).copy(modifieddate = value)))
    }
  
    override val columns: List[FieldLikeNoHkt[?, Row]] =
      List[FieldLikeNoHkt[?, Row]](fields.id, fields.shoppingcartitemid, fields.shoppingcartid, fields.quantity, fields.productid, fields.datecreated, fields.modifieddate)
  
    override def copy[NewRow](prefix: Option[String], extract: NewRow => SciViewRow, merge: (NewRow, SciViewRow) => NewRow): Impl[NewRow] =
      new Impl(prefix, extract, merge)
  }
  
}
