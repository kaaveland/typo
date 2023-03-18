package testdb
package postgres
package information_schema



sealed abstract class TransformsFieldValue[T](val name: String, val value: T)

object TransformsFieldValue {
  case class udtCatalog(override val value: /* unknown nullability */ Option[String]) extends TransformsFieldValue("udt_catalog", value)
  case class udtSchema(override val value: /* unknown nullability */ Option[String]) extends TransformsFieldValue("udt_schema", value)
  case class udtName(override val value: /* unknown nullability */ Option[String]) extends TransformsFieldValue("udt_name", value)
  case class specificCatalog(override val value: /* unknown nullability */ Option[String]) extends TransformsFieldValue("specific_catalog", value)
  case class specificSchema(override val value: /* unknown nullability */ Option[String]) extends TransformsFieldValue("specific_schema", value)
  case class specificName(override val value: /* unknown nullability */ Option[String]) extends TransformsFieldValue("specific_name", value)
  case class groupName(override val value: /* unknown nullability */ Option[String]) extends TransformsFieldValue("group_name", value)
  case class transformType(override val value: /* unknown nullability */ Option[String]) extends TransformsFieldValue("transform_type", value)
}