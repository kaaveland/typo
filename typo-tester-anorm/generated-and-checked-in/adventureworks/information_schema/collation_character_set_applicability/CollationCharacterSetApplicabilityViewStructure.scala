/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package collation_character_set_applicability

import adventureworks.information_schema.SqlIdentifier
import typo.dsl.SqlExpr.Field
import typo.dsl.SqlExpr.FieldLikeNoHkt
import typo.dsl.Structure.Relation

class CollationCharacterSetApplicabilityViewStructure[Row](val prefix: Option[String], val extract: Row => CollationCharacterSetApplicabilityViewRow, val merge: (Row, CollationCharacterSetApplicabilityViewRow) => Row)
  extends Relation[CollationCharacterSetApplicabilityViewFields, CollationCharacterSetApplicabilityViewRow, Row]
    with CollationCharacterSetApplicabilityViewFields[Row] { outer =>

  override val collationCatalog = new Field[SqlIdentifier, Row](prefix, "collation_catalog", None, Some("information_schema.sql_identifier"))(x => extract(x).collationCatalog, (row, value) => merge(row, extract(row).copy(collationCatalog = value)))
  override val collationSchema = new Field[SqlIdentifier, Row](prefix, "collation_schema", None, Some("information_schema.sql_identifier"))(x => extract(x).collationSchema, (row, value) => merge(row, extract(row).copy(collationSchema = value)))
  override val collationName = new Field[SqlIdentifier, Row](prefix, "collation_name", None, Some("information_schema.sql_identifier"))(x => extract(x).collationName, (row, value) => merge(row, extract(row).copy(collationName = value)))
  override val characterSetCatalog = new Field[SqlIdentifier, Row](prefix, "character_set_catalog", None, Some("information_schema.sql_identifier"))(x => extract(x).characterSetCatalog, (row, value) => merge(row, extract(row).copy(characterSetCatalog = value)))
  override val characterSetSchema = new Field[SqlIdentifier, Row](prefix, "character_set_schema", None, Some("information_schema.sql_identifier"))(x => extract(x).characterSetSchema, (row, value) => merge(row, extract(row).copy(characterSetSchema = value)))
  override val characterSetName = new Field[SqlIdentifier, Row](prefix, "character_set_name", None, Some("information_schema.sql_identifier"))(x => extract(x).characterSetName, (row, value) => merge(row, extract(row).copy(characterSetName = value)))

  override val columns: List[FieldLikeNoHkt[?, Row]] =
    List[FieldLikeNoHkt[?, Row]](collationCatalog, collationSchema, collationName, characterSetCatalog, characterSetSchema, characterSetName)

  override def copy[NewRow](prefix: Option[String], extract: NewRow => CollationCharacterSetApplicabilityViewRow, merge: (NewRow, CollationCharacterSetApplicabilityViewRow) => NewRow): CollationCharacterSetApplicabilityViewStructure[NewRow] =
    new CollationCharacterSetApplicabilityViewStructure(prefix, extract, merge)
}
