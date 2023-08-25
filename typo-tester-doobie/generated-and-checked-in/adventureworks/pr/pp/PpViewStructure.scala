/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pr
package pp

import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.production.productphoto.ProductphotoId
import typo.dsl.SqlExpr.Field
import typo.dsl.SqlExpr.FieldLikeNoHkt
import typo.dsl.Structure.Relation

class PpViewStructure[Row](val prefix: Option[String], val extract: Row => PpViewRow, val merge: (Row, PpViewRow) => Row)
  extends Relation[PpViewFields, PpViewRow, Row]
    with PpViewFields[Row] { outer =>

  override val id = new Field[Int, Row](prefix, "id", None, Some("int4"))(x => extract(x).id, (row, value) => merge(row, extract(row).copy(id = value)))
  override val productphotoid = new Field[ProductphotoId, Row](prefix, "productphotoid", None, Some("int4"))(x => extract(x).productphotoid, (row, value) => merge(row, extract(row).copy(productphotoid = value)))
  override val thumbnailphoto = new Field[Byte, Row](prefix, "thumbnailphoto", None, Some("bytea"))(x => extract(x).thumbnailphoto, (row, value) => merge(row, extract(row).copy(thumbnailphoto = value)))
  override val thumbnailphotofilename = new Field[/* max 50 chars */ String, Row](prefix, "thumbnailphotofilename", None, None)(x => extract(x).thumbnailphotofilename, (row, value) => merge(row, extract(row).copy(thumbnailphotofilename = value)))
  override val largephoto = new Field[Byte, Row](prefix, "largephoto", None, Some("bytea"))(x => extract(x).largephoto, (row, value) => merge(row, extract(row).copy(largephoto = value)))
  override val largephotofilename = new Field[/* max 50 chars */ String, Row](prefix, "largephotofilename", None, None)(x => extract(x).largephotofilename, (row, value) => merge(row, extract(row).copy(largephotofilename = value)))
  override val modifieddate = new Field[TypoLocalDateTime, Row](prefix, "modifieddate", Some("text"), Some("timestamp"))(x => extract(x).modifieddate, (row, value) => merge(row, extract(row).copy(modifieddate = value)))

  override val columns: List[FieldLikeNoHkt[?, Row]] =
    List[FieldLikeNoHkt[?, Row]](id, productphotoid, thumbnailphoto, thumbnailphotofilename, largephoto, largephotofilename, modifieddate)

  override def copy[NewRow](prefix: Option[String], extract: NewRow => PpViewRow, merge: (NewRow, PpViewRow) => NewRow): PpViewStructure[NewRow] =
    new PpViewStructure(prefix, extract, merge)
}
