/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package information_schema_catalog_name

import typo.dsl.SqlExpr.FieldLikeNoHkt
import typo.dsl.SqlExpr.OptField
import typo.dsl.Structure.Relation

class InformationSchemaCatalogNameViewStructure[Row](val prefix: Option[String], val extract: Row => InformationSchemaCatalogNameViewRow, val merge: (Row, InformationSchemaCatalogNameViewRow) => Row)
  extends Relation[InformationSchemaCatalogNameViewFields, InformationSchemaCatalogNameViewRow, Row]
    with InformationSchemaCatalogNameViewFields[Row] { outer =>

  override val catalogName = new OptField[String, Row](prefix, "catalog_name", None, None)(x => extract(x).catalogName, (row, value) => merge(row, extract(row).copy(catalogName = value)))

  override val columns: List[FieldLikeNoHkt[?, Row]] =
    List[FieldLikeNoHkt[?, Row]](catalogName)

  override def copy[NewRow](prefix: Option[String], extract: NewRow => InformationSchemaCatalogNameViewRow, merge: (NewRow, InformationSchemaCatalogNameViewRow) => NewRow): InformationSchemaCatalogNameViewStructure[NewRow] =
    new InformationSchemaCatalogNameViewStructure(prefix, extract, merge)
}
