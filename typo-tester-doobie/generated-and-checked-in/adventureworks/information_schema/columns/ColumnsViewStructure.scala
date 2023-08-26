/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package columns

import adventureworks.information_schema.CardinalNumber
import adventureworks.information_schema.CharacterData
import adventureworks.information_schema.SqlIdentifier
import adventureworks.information_schema.YesOrNo
import typo.dsl.SqlExpr.Field
import typo.dsl.SqlExpr.FieldLikeNoHkt
import typo.dsl.Structure.Relation

class ColumnsViewStructure[Row](val prefix: Option[String], val extract: Row => ColumnsViewRow, val merge: (Row, ColumnsViewRow) => Row)
  extends Relation[ColumnsViewFields, ColumnsViewRow, Row]
    with ColumnsViewFields[Row] { outer =>

  override val tableCatalog = new Field[SqlIdentifier, Row](prefix, "table_catalog", None, Some("name"))(x => extract(x).tableCatalog, (row, value) => merge(row, extract(row).copy(tableCatalog = value)))
  override val tableSchema = new Field[SqlIdentifier, Row](prefix, "table_schema", None, Some("name"))(x => extract(x).tableSchema, (row, value) => merge(row, extract(row).copy(tableSchema = value)))
  override val tableName = new Field[SqlIdentifier, Row](prefix, "table_name", None, Some("name"))(x => extract(x).tableName, (row, value) => merge(row, extract(row).copy(tableName = value)))
  override val columnName = new Field[SqlIdentifier, Row](prefix, "column_name", None, Some("name"))(x => extract(x).columnName, (row, value) => merge(row, extract(row).copy(columnName = value)))
  override val ordinalPosition = new Field[CardinalNumber, Row](prefix, "ordinal_position", None, Some("int4"))(x => extract(x).ordinalPosition, (row, value) => merge(row, extract(row).copy(ordinalPosition = value)))
  override val columnDefault = new Field[CharacterData, Row](prefix, "column_default", None, Some("varchar"))(x => extract(x).columnDefault, (row, value) => merge(row, extract(row).copy(columnDefault = value)))
  override val isNullable = new Field[YesOrNo, Row](prefix, "is_nullable", None, Some("varchar"))(x => extract(x).isNullable, (row, value) => merge(row, extract(row).copy(isNullable = value)))
  override val dataType = new Field[CharacterData, Row](prefix, "data_type", None, Some("varchar"))(x => extract(x).dataType, (row, value) => merge(row, extract(row).copy(dataType = value)))
  override val characterMaximumLength = new Field[CardinalNumber, Row](prefix, "character_maximum_length", None, Some("int4"))(x => extract(x).characterMaximumLength, (row, value) => merge(row, extract(row).copy(characterMaximumLength = value)))
  override val characterOctetLength = new Field[CardinalNumber, Row](prefix, "character_octet_length", None, Some("int4"))(x => extract(x).characterOctetLength, (row, value) => merge(row, extract(row).copy(characterOctetLength = value)))
  override val numericPrecision = new Field[CardinalNumber, Row](prefix, "numeric_precision", None, Some("int4"))(x => extract(x).numericPrecision, (row, value) => merge(row, extract(row).copy(numericPrecision = value)))
  override val numericPrecisionRadix = new Field[CardinalNumber, Row](prefix, "numeric_precision_radix", None, Some("int4"))(x => extract(x).numericPrecisionRadix, (row, value) => merge(row, extract(row).copy(numericPrecisionRadix = value)))
  override val numericScale = new Field[CardinalNumber, Row](prefix, "numeric_scale", None, Some("int4"))(x => extract(x).numericScale, (row, value) => merge(row, extract(row).copy(numericScale = value)))
  override val datetimePrecision = new Field[CardinalNumber, Row](prefix, "datetime_precision", None, Some("int4"))(x => extract(x).datetimePrecision, (row, value) => merge(row, extract(row).copy(datetimePrecision = value)))
  override val intervalType = new Field[CharacterData, Row](prefix, "interval_type", None, Some("varchar"))(x => extract(x).intervalType, (row, value) => merge(row, extract(row).copy(intervalType = value)))
  override val intervalPrecision = new Field[CardinalNumber, Row](prefix, "interval_precision", None, Some("int4"))(x => extract(x).intervalPrecision, (row, value) => merge(row, extract(row).copy(intervalPrecision = value)))
  override val characterSetCatalog = new Field[SqlIdentifier, Row](prefix, "character_set_catalog", None, Some("name"))(x => extract(x).characterSetCatalog, (row, value) => merge(row, extract(row).copy(characterSetCatalog = value)))
  override val characterSetSchema = new Field[SqlIdentifier, Row](prefix, "character_set_schema", None, Some("name"))(x => extract(x).characterSetSchema, (row, value) => merge(row, extract(row).copy(characterSetSchema = value)))
  override val characterSetName = new Field[SqlIdentifier, Row](prefix, "character_set_name", None, Some("name"))(x => extract(x).characterSetName, (row, value) => merge(row, extract(row).copy(characterSetName = value)))
  override val collationCatalog = new Field[SqlIdentifier, Row](prefix, "collation_catalog", None, Some("name"))(x => extract(x).collationCatalog, (row, value) => merge(row, extract(row).copy(collationCatalog = value)))
  override val collationSchema = new Field[SqlIdentifier, Row](prefix, "collation_schema", None, Some("name"))(x => extract(x).collationSchema, (row, value) => merge(row, extract(row).copy(collationSchema = value)))
  override val collationName = new Field[SqlIdentifier, Row](prefix, "collation_name", None, Some("name"))(x => extract(x).collationName, (row, value) => merge(row, extract(row).copy(collationName = value)))
  override val domainCatalog = new Field[SqlIdentifier, Row](prefix, "domain_catalog", None, Some("name"))(x => extract(x).domainCatalog, (row, value) => merge(row, extract(row).copy(domainCatalog = value)))
  override val domainSchema = new Field[SqlIdentifier, Row](prefix, "domain_schema", None, Some("name"))(x => extract(x).domainSchema, (row, value) => merge(row, extract(row).copy(domainSchema = value)))
  override val domainName = new Field[SqlIdentifier, Row](prefix, "domain_name", None, Some("name"))(x => extract(x).domainName, (row, value) => merge(row, extract(row).copy(domainName = value)))
  override val udtCatalog = new Field[SqlIdentifier, Row](prefix, "udt_catalog", None, Some("name"))(x => extract(x).udtCatalog, (row, value) => merge(row, extract(row).copy(udtCatalog = value)))
  override val udtSchema = new Field[SqlIdentifier, Row](prefix, "udt_schema", None, Some("name"))(x => extract(x).udtSchema, (row, value) => merge(row, extract(row).copy(udtSchema = value)))
  override val udtName = new Field[SqlIdentifier, Row](prefix, "udt_name", None, Some("name"))(x => extract(x).udtName, (row, value) => merge(row, extract(row).copy(udtName = value)))
  override val scopeCatalog = new Field[SqlIdentifier, Row](prefix, "scope_catalog", None, Some("name"))(x => extract(x).scopeCatalog, (row, value) => merge(row, extract(row).copy(scopeCatalog = value)))
  override val scopeSchema = new Field[SqlIdentifier, Row](prefix, "scope_schema", None, Some("name"))(x => extract(x).scopeSchema, (row, value) => merge(row, extract(row).copy(scopeSchema = value)))
  override val scopeName = new Field[SqlIdentifier, Row](prefix, "scope_name", None, Some("name"))(x => extract(x).scopeName, (row, value) => merge(row, extract(row).copy(scopeName = value)))
  override val maximumCardinality = new Field[CardinalNumber, Row](prefix, "maximum_cardinality", None, Some("int4"))(x => extract(x).maximumCardinality, (row, value) => merge(row, extract(row).copy(maximumCardinality = value)))
  override val dtdIdentifier = new Field[SqlIdentifier, Row](prefix, "dtd_identifier", None, Some("name"))(x => extract(x).dtdIdentifier, (row, value) => merge(row, extract(row).copy(dtdIdentifier = value)))
  override val isSelfReferencing = new Field[YesOrNo, Row](prefix, "is_self_referencing", None, Some("varchar"))(x => extract(x).isSelfReferencing, (row, value) => merge(row, extract(row).copy(isSelfReferencing = value)))
  override val isIdentity = new Field[YesOrNo, Row](prefix, "is_identity", None, Some("varchar"))(x => extract(x).isIdentity, (row, value) => merge(row, extract(row).copy(isIdentity = value)))
  override val identityGeneration = new Field[CharacterData, Row](prefix, "identity_generation", None, Some("varchar"))(x => extract(x).identityGeneration, (row, value) => merge(row, extract(row).copy(identityGeneration = value)))
  override val identityStart = new Field[CharacterData, Row](prefix, "identity_start", None, Some("varchar"))(x => extract(x).identityStart, (row, value) => merge(row, extract(row).copy(identityStart = value)))
  override val identityIncrement = new Field[CharacterData, Row](prefix, "identity_increment", None, Some("varchar"))(x => extract(x).identityIncrement, (row, value) => merge(row, extract(row).copy(identityIncrement = value)))
  override val identityMaximum = new Field[CharacterData, Row](prefix, "identity_maximum", None, Some("varchar"))(x => extract(x).identityMaximum, (row, value) => merge(row, extract(row).copy(identityMaximum = value)))
  override val identityMinimum = new Field[CharacterData, Row](prefix, "identity_minimum", None, Some("varchar"))(x => extract(x).identityMinimum, (row, value) => merge(row, extract(row).copy(identityMinimum = value)))
  override val identityCycle = new Field[YesOrNo, Row](prefix, "identity_cycle", None, Some("varchar"))(x => extract(x).identityCycle, (row, value) => merge(row, extract(row).copy(identityCycle = value)))
  override val isGenerated = new Field[CharacterData, Row](prefix, "is_generated", None, Some("varchar"))(x => extract(x).isGenerated, (row, value) => merge(row, extract(row).copy(isGenerated = value)))
  override val generationExpression = new Field[CharacterData, Row](prefix, "generation_expression", None, Some("varchar"))(x => extract(x).generationExpression, (row, value) => merge(row, extract(row).copy(generationExpression = value)))
  override val isUpdatable = new Field[YesOrNo, Row](prefix, "is_updatable", None, Some("varchar"))(x => extract(x).isUpdatable, (row, value) => merge(row, extract(row).copy(isUpdatable = value)))

  override val columns: List[FieldLikeNoHkt[?, Row]] =
    List[FieldLikeNoHkt[?, Row]](tableCatalog, tableSchema, tableName, columnName, ordinalPosition, columnDefault, isNullable, dataType, characterMaximumLength, characterOctetLength, numericPrecision, numericPrecisionRadix, numericScale, datetimePrecision, intervalType, intervalPrecision, characterSetCatalog, characterSetSchema, characterSetName, collationCatalog, collationSchema, collationName, domainCatalog, domainSchema, domainName, udtCatalog, udtSchema, udtName, scopeCatalog, scopeSchema, scopeName, maximumCardinality, dtdIdentifier, isSelfReferencing, isIdentity, identityGeneration, identityStart, identityIncrement, identityMaximum, identityMinimum, identityCycle, isGenerated, generationExpression, isUpdatable)

  override def copy[NewRow](prefix: Option[String], extract: NewRow => ColumnsViewRow, merge: (NewRow, ColumnsViewRow) => NewRow): ColumnsViewStructure[NewRow] =
    new ColumnsViewStructure(prefix, extract, merge)
}
