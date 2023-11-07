/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package productcategory

import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoUUID
import adventureworks.public.Name
import typo.dsl.SqlExpr.Field
import typo.dsl.SqlExpr.FieldLikeNoHkt
import typo.dsl.SqlExpr.IdField
import typo.dsl.Structure.Relation

class ProductcategoryStructure[Row](val prefix: Option[String], val extract: Row => ProductcategoryRow, val merge: (Row, ProductcategoryRow) => Row)
  extends Relation[ProductcategoryFields, ProductcategoryRow, Row]
    with ProductcategoryFields[Row] { outer =>

  override val productcategoryid = new IdField[ProductcategoryId, Row](prefix, "productcategoryid", None, Some("int4"))(x => extract(x).productcategoryid, (row, value) => merge(row, extract(row).copy(productcategoryid = value)))
  override val name = new Field[Name, Row](prefix, "name", None, Some("varchar"))(x => extract(x).name, (row, value) => merge(row, extract(row).copy(name = value)))
  override val rowguid = new Field[TypoUUID, Row](prefix, "rowguid", None, Some("uuid"))(x => extract(x).rowguid, (row, value) => merge(row, extract(row).copy(rowguid = value)))
  override val modifieddate = new Field[TypoLocalDateTime, Row](prefix, "modifieddate", Some("text"), Some("timestamp"))(x => extract(x).modifieddate, (row, value) => merge(row, extract(row).copy(modifieddate = value)))

  override val columns: List[FieldLikeNoHkt[?, Row]] =
    List[FieldLikeNoHkt[?, Row]](productcategoryid, name, rowguid, modifieddate)

  override def copy[NewRow](prefix: Option[String], extract: NewRow => ProductcategoryRow, merge: (NewRow, ProductcategoryRow) => NewRow): ProductcategoryStructure[NewRow] =
    new ProductcategoryStructure(prefix, extract, merge)
}
