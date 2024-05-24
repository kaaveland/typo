/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pr
package tha

import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.production.transactionhistoryarchive.TransactionhistoryarchiveId
import typo.dsl.Path
import typo.dsl.SqlExpr.Field
import typo.dsl.SqlExpr.FieldLikeNoHkt
import typo.dsl.Structure.Relation

trait ThaViewFields {
  def id: Field[TransactionhistoryarchiveId, ThaViewRow]
  def transactionid: Field[TransactionhistoryarchiveId, ThaViewRow]
  def productid: Field[Int, ThaViewRow]
  def referenceorderid: Field[Int, ThaViewRow]
  def referenceorderlineid: Field[Int, ThaViewRow]
  def transactiondate: Field[TypoLocalDateTime, ThaViewRow]
  def transactiontype: Field[/* bpchar, max 1 chars */ String, ThaViewRow]
  def quantity: Field[Int, ThaViewRow]
  def actualcost: Field[BigDecimal, ThaViewRow]
  def modifieddate: Field[TypoLocalDateTime, ThaViewRow]
}

object ThaViewFields {
  lazy val structure: Relation[ThaViewFields, ThaViewRow] =
    new Impl(Nil)
    
  private final class Impl(val _path: List[Path])
    extends Relation[ThaViewFields, ThaViewRow] {
  
    override lazy val fields: ThaViewFields = new ThaViewFields {
      override def id = Field[TransactionhistoryarchiveId, ThaViewRow](_path, "id", None, None, x => x.id, (row, value) => row.copy(id = value))
      override def transactionid = Field[TransactionhistoryarchiveId, ThaViewRow](_path, "transactionid", None, None, x => x.transactionid, (row, value) => row.copy(transactionid = value))
      override def productid = Field[Int, ThaViewRow](_path, "productid", None, None, x => x.productid, (row, value) => row.copy(productid = value))
      override def referenceorderid = Field[Int, ThaViewRow](_path, "referenceorderid", None, None, x => x.referenceorderid, (row, value) => row.copy(referenceorderid = value))
      override def referenceorderlineid = Field[Int, ThaViewRow](_path, "referenceorderlineid", None, None, x => x.referenceorderlineid, (row, value) => row.copy(referenceorderlineid = value))
      override def transactiondate = Field[TypoLocalDateTime, ThaViewRow](_path, "transactiondate", Some("text"), None, x => x.transactiondate, (row, value) => row.copy(transactiondate = value))
      override def transactiontype = Field[/* bpchar, max 1 chars */ String, ThaViewRow](_path, "transactiontype", None, None, x => x.transactiontype, (row, value) => row.copy(transactiontype = value))
      override def quantity = Field[Int, ThaViewRow](_path, "quantity", None, None, x => x.quantity, (row, value) => row.copy(quantity = value))
      override def actualcost = Field[BigDecimal, ThaViewRow](_path, "actualcost", None, None, x => x.actualcost, (row, value) => row.copy(actualcost = value))
      override def modifieddate = Field[TypoLocalDateTime, ThaViewRow](_path, "modifieddate", Some("text"), None, x => x.modifieddate, (row, value) => row.copy(modifieddate = value))
    }
  
    override lazy val columns: List[FieldLikeNoHkt[?, ThaViewRow]] =
      List[FieldLikeNoHkt[?, ThaViewRow]](fields.id, fields.transactionid, fields.productid, fields.referenceorderid, fields.referenceorderlineid, fields.transactiondate, fields.transactiontype, fields.quantity, fields.actualcost, fields.modifieddate)
  
    override def copy(path: List[Path]): Impl =
      new Impl(path)
  }
  
}
