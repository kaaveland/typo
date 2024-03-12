/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pr
package pr

import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.production.product.ProductId
import adventureworks.production.productreview.ProductreviewId
import adventureworks.public.Name
import typo.dsl.SqlExpr.Field
import typo.dsl.SqlExpr.FieldLikeNoHkt
import typo.dsl.SqlExpr.OptField
import typo.dsl.Structure.Relation

trait PrViewFields[Row] {
  val id: Field[ProductreviewId, Row]
  val productreviewid: Field[ProductreviewId, Row]
  val productid: Field[ProductId, Row]
  val reviewername: Field[Name, Row]
  val reviewdate: Field[TypoLocalDateTime, Row]
  val emailaddress: Field[/* max 50 chars */ String, Row]
  val rating: Field[Int, Row]
  val comments: OptField[/* max 3850 chars */ String, Row]
  val modifieddate: Field[TypoLocalDateTime, Row]
}

object PrViewFields {
  val structure: Relation[PrViewFields, PrViewRow, PrViewRow] = 
    new Impl(None, identity, (_, x) => x)
    
  private final class Impl[Row](val prefix: Option[String], val extract: Row => PrViewRow, val merge: (Row, PrViewRow) => Row)
    extends Relation[PrViewFields, PrViewRow, Row] { 
  
    override val fields: PrViewFields[Row] = new PrViewFields[Row] {
      override val id = new Field[ProductreviewId, Row](prefix, "id", None, None)(x => extract(x).id, (row, value) => merge(row, extract(row).copy(id = value)))
      override val productreviewid = new Field[ProductreviewId, Row](prefix, "productreviewid", None, None)(x => extract(x).productreviewid, (row, value) => merge(row, extract(row).copy(productreviewid = value)))
      override val productid = new Field[ProductId, Row](prefix, "productid", None, None)(x => extract(x).productid, (row, value) => merge(row, extract(row).copy(productid = value)))
      override val reviewername = new Field[Name, Row](prefix, "reviewername", None, None)(x => extract(x).reviewername, (row, value) => merge(row, extract(row).copy(reviewername = value)))
      override val reviewdate = new Field[TypoLocalDateTime, Row](prefix, "reviewdate", Some("text"), None)(x => extract(x).reviewdate, (row, value) => merge(row, extract(row).copy(reviewdate = value)))
      override val emailaddress = new Field[/* max 50 chars */ String, Row](prefix, "emailaddress", None, None)(x => extract(x).emailaddress, (row, value) => merge(row, extract(row).copy(emailaddress = value)))
      override val rating = new Field[Int, Row](prefix, "rating", None, None)(x => extract(x).rating, (row, value) => merge(row, extract(row).copy(rating = value)))
      override val comments = new OptField[/* max 3850 chars */ String, Row](prefix, "comments", None, None)(x => extract(x).comments, (row, value) => merge(row, extract(row).copy(comments = value)))
      override val modifieddate = new Field[TypoLocalDateTime, Row](prefix, "modifieddate", Some("text"), None)(x => extract(x).modifieddate, (row, value) => merge(row, extract(row).copy(modifieddate = value)))
    }
  
    override val columns: List[FieldLikeNoHkt[?, Row]] =
      List[FieldLikeNoHkt[?, Row]](fields.id, fields.productreviewid, fields.productid, fields.reviewername, fields.reviewdate, fields.emailaddress, fields.rating, fields.comments, fields.modifieddate)
  
    override def copy[NewRow](prefix: Option[String], extract: NewRow => PrViewRow, merge: (NewRow, PrViewRow) => NewRow): Impl[NewRow] =
      new Impl(prefix, extract, merge)
  }
  
}
