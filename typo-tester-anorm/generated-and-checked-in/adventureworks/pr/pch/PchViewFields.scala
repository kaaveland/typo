/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pr
package pch

import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.production.product.ProductId
import typo.dsl.SqlExpr.Field
import typo.dsl.SqlExpr.FieldLikeNoHkt
import typo.dsl.SqlExpr.OptField
import typo.dsl.Structure.Relation

trait PchViewFields[Row] {
  val id: Field[ProductId, Row]
  val productid: Field[ProductId, Row]
  val startdate: Field[TypoLocalDateTime, Row]
  val enddate: OptField[TypoLocalDateTime, Row]
  val standardcost: Field[BigDecimal, Row]
  val modifieddate: Field[TypoLocalDateTime, Row]
}

object PchViewFields {
  val structure: Relation[PchViewFields, PchViewRow, PchViewRow] = 
    new Impl(None, identity, (_, x) => x)
    
  private final class Impl[Row](val prefix: Option[String], val extract: Row => PchViewRow, val merge: (Row, PchViewRow) => Row)
    extends Relation[PchViewFields, PchViewRow, Row] { 
  
    override val fields: PchViewFields[Row] = new PchViewFields[Row] {
      override val id = new Field[ProductId, Row](prefix, "id", None, None)(x => extract(x).id, (row, value) => merge(row, extract(row).copy(id = value)))
      override val productid = new Field[ProductId, Row](prefix, "productid", None, None)(x => extract(x).productid, (row, value) => merge(row, extract(row).copy(productid = value)))
      override val startdate = new Field[TypoLocalDateTime, Row](prefix, "startdate", Some("text"), None)(x => extract(x).startdate, (row, value) => merge(row, extract(row).copy(startdate = value)))
      override val enddate = new OptField[TypoLocalDateTime, Row](prefix, "enddate", Some("text"), None)(x => extract(x).enddate, (row, value) => merge(row, extract(row).copy(enddate = value)))
      override val standardcost = new Field[BigDecimal, Row](prefix, "standardcost", None, None)(x => extract(x).standardcost, (row, value) => merge(row, extract(row).copy(standardcost = value)))
      override val modifieddate = new Field[TypoLocalDateTime, Row](prefix, "modifieddate", Some("text"), None)(x => extract(x).modifieddate, (row, value) => merge(row, extract(row).copy(modifieddate = value)))
    }
  
    override val columns: List[FieldLikeNoHkt[?, Row]] =
      List[FieldLikeNoHkt[?, Row]](fields.id, fields.productid, fields.startdate, fields.enddate, fields.standardcost, fields.modifieddate)
  
    override def copy[NewRow](prefix: Option[String], extract: NewRow => PchViewRow, merge: (NewRow, PchViewRow) => NewRow): Impl[NewRow] =
      new Impl(prefix, extract, merge)
  }
  
}
