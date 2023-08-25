/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package transforms

import adventureworks.information_schema.CharacterData
import adventureworks.information_schema.SqlIdentifier
import typo.dsl.SqlExpr.Field
import typo.dsl.SqlExpr.FieldLikeNoHkt
import typo.dsl.Structure.Relation

class TransformsViewStructure[Row](val prefix: Option[String], val extract: Row => TransformsViewRow, val merge: (Row, TransformsViewRow) => Row)
  extends Relation[TransformsViewFields, TransformsViewRow, Row]
    with TransformsViewFields[Row] { outer =>

  override val udtCatalog = new Field[SqlIdentifier, Row](prefix, "udt_catalog", None, Some("information_schema.sql_identifier"))(x => extract(x).udtCatalog, (row, value) => merge(row, extract(row).copy(udtCatalog = value)))
  override val udtSchema = new Field[SqlIdentifier, Row](prefix, "udt_schema", None, Some("information_schema.sql_identifier"))(x => extract(x).udtSchema, (row, value) => merge(row, extract(row).copy(udtSchema = value)))
  override val udtName = new Field[SqlIdentifier, Row](prefix, "udt_name", None, Some("information_schema.sql_identifier"))(x => extract(x).udtName, (row, value) => merge(row, extract(row).copy(udtName = value)))
  override val specificCatalog = new Field[SqlIdentifier, Row](prefix, "specific_catalog", None, Some("information_schema.sql_identifier"))(x => extract(x).specificCatalog, (row, value) => merge(row, extract(row).copy(specificCatalog = value)))
  override val specificSchema = new Field[SqlIdentifier, Row](prefix, "specific_schema", None, Some("information_schema.sql_identifier"))(x => extract(x).specificSchema, (row, value) => merge(row, extract(row).copy(specificSchema = value)))
  override val specificName = new Field[SqlIdentifier, Row](prefix, "specific_name", None, Some("information_schema.sql_identifier"))(x => extract(x).specificName, (row, value) => merge(row, extract(row).copy(specificName = value)))
  override val groupName = new Field[SqlIdentifier, Row](prefix, "group_name", None, Some("information_schema.sql_identifier"))(x => extract(x).groupName, (row, value) => merge(row, extract(row).copy(groupName = value)))
  override val transformType = new Field[CharacterData, Row](prefix, "transform_type", None, Some("information_schema.character_data"))(x => extract(x).transformType, (row, value) => merge(row, extract(row).copy(transformType = value)))

  override val columns: List[FieldLikeNoHkt[?, Row]] =
    List[FieldLikeNoHkt[?, Row]](udtCatalog, udtSchema, udtName, specificCatalog, specificSchema, specificName, groupName, transformType)

  override def copy[NewRow](prefix: Option[String], extract: NewRow => TransformsViewRow, merge: (NewRow, TransformsViewRow) => NewRow): TransformsViewStructure[NewRow] =
    new TransformsViewStructure(prefix, extract, merge)
}
