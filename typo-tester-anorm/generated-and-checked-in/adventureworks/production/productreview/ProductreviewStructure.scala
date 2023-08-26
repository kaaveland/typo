/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package productreview

import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.production.product.ProductId
import adventureworks.public.Name
import typo.dsl.SqlExpr.Field
import typo.dsl.SqlExpr.FieldLikeNoHkt
import typo.dsl.SqlExpr.IdField
import typo.dsl.SqlExpr.OptField
import typo.dsl.Structure.Relation

class ProductreviewStructure[Row](val prefix: Option[String], val extract: Row => ProductreviewRow, val merge: (Row, ProductreviewRow) => Row)
  extends Relation[ProductreviewFields, ProductreviewRow, Row]
    with ProductreviewFields[Row] { outer =>

  override val productreviewid = new IdField[ProductreviewId, Row](prefix, "productreviewid", None, Some("int4"))(x => extract(x).productreviewid, (row, value) => merge(row, extract(row).copy(productreviewid = value)))
  override val productid = new Field[ProductId, Row](prefix, "productid", None, Some("int4"))(x => extract(x).productid, (row, value) => merge(row, extract(row).copy(productid = value)))
  override val reviewername = new Field[Name, Row](prefix, "reviewername", None, Some("varchar"))(x => extract(x).reviewername, (row, value) => merge(row, extract(row).copy(reviewername = value)))
  override val reviewdate = new Field[TypoLocalDateTime, Row](prefix, "reviewdate", Some("text"), Some("timestamp"))(x => extract(x).reviewdate, (row, value) => merge(row, extract(row).copy(reviewdate = value)))
  override val emailaddress = new Field[/* max 50 chars */ String, Row](prefix, "emailaddress", None, None)(x => extract(x).emailaddress, (row, value) => merge(row, extract(row).copy(emailaddress = value)))
  override val rating = new Field[Int, Row](prefix, "rating", None, Some("int4"))(x => extract(x).rating, (row, value) => merge(row, extract(row).copy(rating = value)))
  override val comments = new OptField[/* max 3850 chars */ String, Row](prefix, "comments", None, None)(x => extract(x).comments, (row, value) => merge(row, extract(row).copy(comments = value)))
  override val modifieddate = new Field[TypoLocalDateTime, Row](prefix, "modifieddate", Some("text"), Some("timestamp"))(x => extract(x).modifieddate, (row, value) => merge(row, extract(row).copy(modifieddate = value)))

  override val columns: List[FieldLikeNoHkt[?, Row]] =
    List[FieldLikeNoHkt[?, Row]](productreviewid, productid, reviewername, reviewdate, emailaddress, rating, comments, modifieddate)

  override def copy[NewRow](prefix: Option[String], extract: NewRow => ProductreviewRow, merge: (NewRow, ProductreviewRow) => NewRow): ProductreviewStructure[NewRow] =
    new ProductreviewStructure(prefix, extract, merge)
}
