/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pr
package th

import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.production.product.ProductId
import adventureworks.production.transactionhistory.TransactionhistoryId
import typo.dsl.SqlExpr.Field
import typo.dsl.SqlExpr.FieldLikeNoHkt
import typo.dsl.Structure.Relation

class ThViewStructure[Row](val prefix: Option[String], val extract: Row => ThViewRow, val merge: (Row, ThViewRow) => Row)
  extends Relation[ThViewFields, ThViewRow, Row]
    with ThViewFields[Row] { outer =>

  override val id = new Field[Int, Row](prefix, "id", None, Some("int4"))(x => extract(x).id, (row, value) => merge(row, extract(row).copy(id = value)))
  override val transactionid = new Field[TransactionhistoryId, Row](prefix, "transactionid", None, Some("int4"))(x => extract(x).transactionid, (row, value) => merge(row, extract(row).copy(transactionid = value)))
  override val productid = new Field[ProductId, Row](prefix, "productid", None, Some("int4"))(x => extract(x).productid, (row, value) => merge(row, extract(row).copy(productid = value)))
  override val referenceorderid = new Field[Int, Row](prefix, "referenceorderid", None, Some("int4"))(x => extract(x).referenceorderid, (row, value) => merge(row, extract(row).copy(referenceorderid = value)))
  override val referenceorderlineid = new Field[Int, Row](prefix, "referenceorderlineid", None, Some("int4"))(x => extract(x).referenceorderlineid, (row, value) => merge(row, extract(row).copy(referenceorderlineid = value)))
  override val transactiondate = new Field[TypoLocalDateTime, Row](prefix, "transactiondate", Some("text"), Some("timestamp"))(x => extract(x).transactiondate, (row, value) => merge(row, extract(row).copy(transactiondate = value)))
  override val transactiontype = new Field[/* bpchar, max 1 chars */ String, Row](prefix, "transactiontype", None, Some("bpchar"))(x => extract(x).transactiontype, (row, value) => merge(row, extract(row).copy(transactiontype = value)))
  override val quantity = new Field[Int, Row](prefix, "quantity", None, Some("int4"))(x => extract(x).quantity, (row, value) => merge(row, extract(row).copy(quantity = value)))
  override val actualcost = new Field[BigDecimal, Row](prefix, "actualcost", None, Some("numeric"))(x => extract(x).actualcost, (row, value) => merge(row, extract(row).copy(actualcost = value)))
  override val modifieddate = new Field[TypoLocalDateTime, Row](prefix, "modifieddate", Some("text"), Some("timestamp"))(x => extract(x).modifieddate, (row, value) => merge(row, extract(row).copy(modifieddate = value)))

  override val columns: List[FieldLikeNoHkt[?, Row]] =
    List[FieldLikeNoHkt[?, Row]](id, transactionid, productid, referenceorderid, referenceorderlineid, transactiondate, transactiontype, quantity, actualcost, modifieddate)

  override def copy[NewRow](prefix: Option[String], extract: NewRow => ThViewRow, merge: (NewRow, ThViewRow) => NewRow): ThViewStructure[NewRow] =
    new ThViewStructure(prefix, extract, merge)
}
