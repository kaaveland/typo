/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pr
package ppp

import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.production.product.ProductId
import adventureworks.production.productphoto.ProductphotoId
import adventureworks.public.Flag
import typo.dsl.SqlExpr.Field
import typo.dsl.SqlExpr.FieldLikeNoHkt
import typo.dsl.Structure.Relation

class PppViewStructure[Row](val prefix: Option[String], val extract: Row => PppViewRow, val merge: (Row, PppViewRow) => Row)
  extends Relation[PppViewFields, PppViewRow, Row]
    with PppViewFields[Row] { outer =>

  override val productid = new Field[ProductId, Row](prefix, "productid", None, Some("int4"))(x => extract(x).productid, (row, value) => merge(row, extract(row).copy(productid = value)))
  override val productphotoid = new Field[ProductphotoId, Row](prefix, "productphotoid", None, Some("int4"))(x => extract(x).productphotoid, (row, value) => merge(row, extract(row).copy(productphotoid = value)))
  override val primary = new Field[Flag, Row](prefix, "primary", None, Some(""""public"."Flag""""))(x => extract(x).primary, (row, value) => merge(row, extract(row).copy(primary = value)))
  override val modifieddate = new Field[TypoLocalDateTime, Row](prefix, "modifieddate", Some("text"), Some("timestamp"))(x => extract(x).modifieddate, (row, value) => merge(row, extract(row).copy(modifieddate = value)))

  override val columns: List[FieldLikeNoHkt[?, Row]] =
    List[FieldLikeNoHkt[?, Row]](productid, productphotoid, primary, modifieddate)

  override def copy[NewRow](prefix: Option[String], extract: NewRow => PppViewRow, merge: (NewRow, PppViewRow) => NewRow): PppViewStructure[NewRow] =
    new PppViewStructure(prefix, extract, merge)
}
