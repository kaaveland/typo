/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package schemata

import typo.dsl.SqlExpr.FieldLikeNoHkt
import typo.dsl.SqlExpr.OptField
import typo.dsl.Structure.Relation

class SchemataViewStructure[Row](val prefix: Option[String], val extract: Row => SchemataViewRow, val merge: (Row, SchemataViewRow) => Row)
  extends Relation[SchemataViewFields, SchemataViewRow, Row]
    with SchemataViewFields[Row] { outer =>

  override val catalogName = new OptField[String, Row](prefix, "catalog_name", None, None)(x => extract(x).catalogName, (row, value) => merge(row, extract(row).copy(catalogName = value)))
  override val schemaName = new OptField[String, Row](prefix, "schema_name", None, None)(x => extract(x).schemaName, (row, value) => merge(row, extract(row).copy(schemaName = value)))
  override val schemaOwner = new OptField[String, Row](prefix, "schema_owner", None, None)(x => extract(x).schemaOwner, (row, value) => merge(row, extract(row).copy(schemaOwner = value)))
  override val defaultCharacterSetCatalog = new OptField[String, Row](prefix, "default_character_set_catalog", None, None)(x => extract(x).defaultCharacterSetCatalog, (row, value) => merge(row, extract(row).copy(defaultCharacterSetCatalog = value)))
  override val defaultCharacterSetSchema = new OptField[String, Row](prefix, "default_character_set_schema", None, None)(x => extract(x).defaultCharacterSetSchema, (row, value) => merge(row, extract(row).copy(defaultCharacterSetSchema = value)))
  override val defaultCharacterSetName = new OptField[String, Row](prefix, "default_character_set_name", None, None)(x => extract(x).defaultCharacterSetName, (row, value) => merge(row, extract(row).copy(defaultCharacterSetName = value)))
  override val sqlPath = new OptField[String, Row](prefix, "sql_path", None, None)(x => extract(x).sqlPath, (row, value) => merge(row, extract(row).copy(sqlPath = value)))

  override val columns: List[FieldLikeNoHkt[?, Row]] =
    List[FieldLikeNoHkt[?, Row]](catalogName, schemaName, schemaOwner, defaultCharacterSetCatalog, defaultCharacterSetSchema, defaultCharacterSetName, sqlPath)

  override def copy[NewRow](prefix: Option[String], extract: NewRow => SchemataViewRow, merge: (NewRow, SchemataViewRow) => NewRow): SchemataViewStructure[NewRow] =
    new SchemataViewStructure(prefix, extract, merge)
}
