/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pr
package plph

import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.production.product.ProductId
import typo.dsl.SqlExpr.Field
import typo.dsl.SqlExpr.FieldLikeNoHkt
import typo.dsl.Structure.Relation

class PlphViewStructure[Row](val prefix: Option[String], val extract: Row => PlphViewRow, val merge: (Row, PlphViewRow) => Row)
  extends Relation[PlphViewFields, PlphViewRow, Row]
    with PlphViewFields[Row] { outer =>

  override val id = new Field[Int, Row](prefix, "id", None, Some("int4"))(x => extract(x).id, (row, value) => merge(row, extract(row).copy(id = value)))
  override val productid = new Field[ProductId, Row](prefix, "productid", None, Some("int4"))(x => extract(x).productid, (row, value) => merge(row, extract(row).copy(productid = value)))
  override val startdate = new Field[TypoLocalDateTime, Row](prefix, "startdate", Some("text"), Some("timestamp"))(x => extract(x).startdate, (row, value) => merge(row, extract(row).copy(startdate = value)))
  override val enddate = new Field[TypoLocalDateTime, Row](prefix, "enddate", Some("text"), Some("timestamp"))(x => extract(x).enddate, (row, value) => merge(row, extract(row).copy(enddate = value)))
  override val listprice = new Field[BigDecimal, Row](prefix, "listprice", None, Some("numeric"))(x => extract(x).listprice, (row, value) => merge(row, extract(row).copy(listprice = value)))
  override val modifieddate = new Field[TypoLocalDateTime, Row](prefix, "modifieddate", Some("text"), Some("timestamp"))(x => extract(x).modifieddate, (row, value) => merge(row, extract(row).copy(modifieddate = value)))

  override val columns: List[FieldLikeNoHkt[?, Row]] =
    List[FieldLikeNoHkt[?, Row]](id, productid, startdate, enddate, listprice, modifieddate)

  override def copy[NewRow](prefix: Option[String], extract: NewRow => PlphViewRow, merge: (NewRow, PlphViewRow) => NewRow): PlphViewStructure[NewRow] =
    new PlphViewStructure(prefix, extract, merge)
}
