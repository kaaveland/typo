/**
 * File has been automatically generated by `typo` for internal use.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 *
 * (If you're developing `typo` and want to change it: run `bleep generate-sources`)
 */
package typo
package generated
package information_schema
package columns

import typo.generated.information_schema.CardinalNumberDomain
import typo.generated.information_schema.CharacterDataDomain
import typo.generated.information_schema.SqlIdentifierDomain
import typo.generated.information_schema.YesOrNoDomain

sealed abstract class ColumnsFieldOrIdValue[T](val name: String, val value: T)
sealed abstract class ColumnsFieldValue[T](name: String, value: T) extends ColumnsFieldOrIdValue(name, value)

object ColumnsFieldValue {
  case class tableCatalog(override val value: Option[SqlIdentifierDomain]) extends ColumnsFieldValue("table_catalog", value)
  case class tableSchema(override val value: Option[SqlIdentifierDomain]) extends ColumnsFieldValue("table_schema", value)
  case class tableName(override val value: Option[SqlIdentifierDomain]) extends ColumnsFieldValue("table_name", value)
  case class columnName(override val value: Option[SqlIdentifierDomain]) extends ColumnsFieldValue("column_name", value)
  case class ordinalPosition(override val value: Option[CardinalNumberDomain]) extends ColumnsFieldValue("ordinal_position", value)
  case class columnDefault(override val value: Option[CharacterDataDomain]) extends ColumnsFieldValue("column_default", value)
  case class isNullable(override val value: Option[YesOrNoDomain]) extends ColumnsFieldValue("is_nullable", value)
  case class dataType(override val value: Option[CharacterDataDomain]) extends ColumnsFieldValue("data_type", value)
  case class characterMaximumLength(override val value: Option[CardinalNumberDomain]) extends ColumnsFieldValue("character_maximum_length", value)
  case class characterOctetLength(override val value: Option[CardinalNumberDomain]) extends ColumnsFieldValue("character_octet_length", value)
  case class numericPrecision(override val value: Option[CardinalNumberDomain]) extends ColumnsFieldValue("numeric_precision", value)
  case class numericPrecisionRadix(override val value: Option[CardinalNumberDomain]) extends ColumnsFieldValue("numeric_precision_radix", value)
  case class numericScale(override val value: Option[CardinalNumberDomain]) extends ColumnsFieldValue("numeric_scale", value)
  case class datetimePrecision(override val value: Option[CardinalNumberDomain]) extends ColumnsFieldValue("datetime_precision", value)
  case class intervalType(override val value: Option[CharacterDataDomain]) extends ColumnsFieldValue("interval_type", value)
  case class intervalPrecision(override val value: Option[CardinalNumberDomain]) extends ColumnsFieldValue("interval_precision", value)
  case class characterSetCatalog(override val value: Option[SqlIdentifierDomain]) extends ColumnsFieldValue("character_set_catalog", value)
  case class characterSetSchema(override val value: Option[SqlIdentifierDomain]) extends ColumnsFieldValue("character_set_schema", value)
  case class characterSetName(override val value: Option[SqlIdentifierDomain]) extends ColumnsFieldValue("character_set_name", value)
  case class collationCatalog(override val value: Option[SqlIdentifierDomain]) extends ColumnsFieldValue("collation_catalog", value)
  case class collationSchema(override val value: Option[SqlIdentifierDomain]) extends ColumnsFieldValue("collation_schema", value)
  case class collationName(override val value: Option[SqlIdentifierDomain]) extends ColumnsFieldValue("collation_name", value)
  case class domainCatalog(override val value: Option[SqlIdentifierDomain]) extends ColumnsFieldValue("domain_catalog", value)
  case class domainSchema(override val value: Option[SqlIdentifierDomain]) extends ColumnsFieldValue("domain_schema", value)
  case class domainName(override val value: Option[SqlIdentifierDomain]) extends ColumnsFieldValue("domain_name", value)
  case class udtCatalog(override val value: Option[SqlIdentifierDomain]) extends ColumnsFieldValue("udt_catalog", value)
  case class udtSchema(override val value: Option[SqlIdentifierDomain]) extends ColumnsFieldValue("udt_schema", value)
  case class udtName(override val value: Option[SqlIdentifierDomain]) extends ColumnsFieldValue("udt_name", value)
  case class scopeCatalog(override val value: Option[SqlIdentifierDomain]) extends ColumnsFieldValue("scope_catalog", value)
  case class scopeSchema(override val value: Option[SqlIdentifierDomain]) extends ColumnsFieldValue("scope_schema", value)
  case class scopeName(override val value: Option[SqlIdentifierDomain]) extends ColumnsFieldValue("scope_name", value)
  case class maximumCardinality(override val value: Option[CardinalNumberDomain]) extends ColumnsFieldValue("maximum_cardinality", value)
  case class dtdIdentifier(override val value: Option[SqlIdentifierDomain]) extends ColumnsFieldValue("dtd_identifier", value)
  case class isSelfReferencing(override val value: Option[YesOrNoDomain]) extends ColumnsFieldValue("is_self_referencing", value)
  case class isIdentity(override val value: Option[YesOrNoDomain]) extends ColumnsFieldValue("is_identity", value)
  case class identityGeneration(override val value: Option[CharacterDataDomain]) extends ColumnsFieldValue("identity_generation", value)
  case class identityStart(override val value: Option[CharacterDataDomain]) extends ColumnsFieldValue("identity_start", value)
  case class identityIncrement(override val value: Option[CharacterDataDomain]) extends ColumnsFieldValue("identity_increment", value)
  case class identityMaximum(override val value: Option[CharacterDataDomain]) extends ColumnsFieldValue("identity_maximum", value)
  case class identityMinimum(override val value: Option[CharacterDataDomain]) extends ColumnsFieldValue("identity_minimum", value)
  case class identityCycle(override val value: Option[YesOrNoDomain]) extends ColumnsFieldValue("identity_cycle", value)
  case class isGenerated(override val value: Option[CharacterDataDomain]) extends ColumnsFieldValue("is_generated", value)
  case class generationExpression(override val value: Option[CharacterDataDomain]) extends ColumnsFieldValue("generation_expression", value)
  case class isUpdatable(override val value: Option[YesOrNoDomain]) extends ColumnsFieldValue("is_updatable", value)
}
