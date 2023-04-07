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
package referential_constraints

import typo.generated.information_schema.CharacterDataDomain
import typo.generated.information_schema.SqlIdentifierDomain

sealed abstract class ReferentialConstraintsFieldOrIdValue[T](val name: String, val value: T)
sealed abstract class ReferentialConstraintsFieldValue[T](name: String, value: T) extends ReferentialConstraintsFieldOrIdValue(name, value)

object ReferentialConstraintsFieldValue {
  case class constraintCatalog(override val value: Option[SqlIdentifierDomain]) extends ReferentialConstraintsFieldValue("constraint_catalog", value)
  case class constraintSchema(override val value: Option[SqlIdentifierDomain]) extends ReferentialConstraintsFieldValue("constraint_schema", value)
  case class constraintName(override val value: Option[SqlIdentifierDomain]) extends ReferentialConstraintsFieldValue("constraint_name", value)
  case class uniqueConstraintCatalog(override val value: Option[SqlIdentifierDomain]) extends ReferentialConstraintsFieldValue("unique_constraint_catalog", value)
  case class uniqueConstraintSchema(override val value: Option[SqlIdentifierDomain]) extends ReferentialConstraintsFieldValue("unique_constraint_schema", value)
  case class uniqueConstraintName(override val value: Option[SqlIdentifierDomain]) extends ReferentialConstraintsFieldValue("unique_constraint_name", value)
  case class matchOption(override val value: Option[CharacterDataDomain]) extends ReferentialConstraintsFieldValue("match_option", value)
  case class updateRule(override val value: Option[CharacterDataDomain]) extends ReferentialConstraintsFieldValue("update_rule", value)
  case class deleteRule(override val value: Option[CharacterDataDomain]) extends ReferentialConstraintsFieldValue("delete_rule", value)
}
