/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pu
package poh

import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.person.businessentity.BusinessentityId
import adventureworks.purchasing.purchaseorderheader.PurchaseorderheaderId
import adventureworks.purchasing.shipmethod.ShipmethodId
import typo.dsl.SqlExpr.Field
import typo.dsl.SqlExpr.FieldLikeNoHkt
import typo.dsl.SqlExpr.OptField
import typo.dsl.Structure.Relation

class PohViewStructure[Row](val prefix: Option[String], val extract: Row => PohViewRow, val merge: (Row, PohViewRow) => Row)
  extends Relation[PohViewFields, PohViewRow, Row]
    with PohViewFields[Row] { outer =>

  override val id = new Field[PurchaseorderheaderId, Row](prefix, "id", None, None)(x => extract(x).id, (row, value) => merge(row, extract(row).copy(id = value)))
  override val purchaseorderid = new Field[PurchaseorderheaderId, Row](prefix, "purchaseorderid", None, None)(x => extract(x).purchaseorderid, (row, value) => merge(row, extract(row).copy(purchaseorderid = value)))
  override val revisionnumber = new Field[Int, Row](prefix, "revisionnumber", None, None)(x => extract(x).revisionnumber, (row, value) => merge(row, extract(row).copy(revisionnumber = value)))
  override val status = new Field[Int, Row](prefix, "status", None, None)(x => extract(x).status, (row, value) => merge(row, extract(row).copy(status = value)))
  override val employeeid = new Field[BusinessentityId, Row](prefix, "employeeid", None, None)(x => extract(x).employeeid, (row, value) => merge(row, extract(row).copy(employeeid = value)))
  override val vendorid = new Field[BusinessentityId, Row](prefix, "vendorid", None, None)(x => extract(x).vendorid, (row, value) => merge(row, extract(row).copy(vendorid = value)))
  override val shipmethodid = new Field[ShipmethodId, Row](prefix, "shipmethodid", None, None)(x => extract(x).shipmethodid, (row, value) => merge(row, extract(row).copy(shipmethodid = value)))
  override val orderdate = new Field[TypoLocalDateTime, Row](prefix, "orderdate", Some("text"), None)(x => extract(x).orderdate, (row, value) => merge(row, extract(row).copy(orderdate = value)))
  override val shipdate = new OptField[TypoLocalDateTime, Row](prefix, "shipdate", Some("text"), None)(x => extract(x).shipdate, (row, value) => merge(row, extract(row).copy(shipdate = value)))
  override val subtotal = new Field[BigDecimal, Row](prefix, "subtotal", None, None)(x => extract(x).subtotal, (row, value) => merge(row, extract(row).copy(subtotal = value)))
  override val taxamt = new Field[BigDecimal, Row](prefix, "taxamt", None, None)(x => extract(x).taxamt, (row, value) => merge(row, extract(row).copy(taxamt = value)))
  override val freight = new Field[BigDecimal, Row](prefix, "freight", None, None)(x => extract(x).freight, (row, value) => merge(row, extract(row).copy(freight = value)))
  override val modifieddate = new Field[TypoLocalDateTime, Row](prefix, "modifieddate", Some("text"), None)(x => extract(x).modifieddate, (row, value) => merge(row, extract(row).copy(modifieddate = value)))

  override val columns: List[FieldLikeNoHkt[?, Row]] =
    List[FieldLikeNoHkt[?, Row]](id, purchaseorderid, revisionnumber, status, employeeid, vendorid, shipmethodid, orderdate, shipdate, subtotal, taxamt, freight, modifieddate)

  override def copy[NewRow](prefix: Option[String], extract: NewRow => PohViewRow, merge: (NewRow, PohViewRow) => NewRow): PohViewStructure[NewRow] =
    new PohViewStructure(prefix, extract, merge)
}
