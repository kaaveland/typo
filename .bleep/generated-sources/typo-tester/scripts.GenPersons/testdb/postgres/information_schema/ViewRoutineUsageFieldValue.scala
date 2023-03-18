package testdb
package postgres
package information_schema



sealed abstract class ViewRoutineUsageFieldValue[T](val name: String, val value: T)

object ViewRoutineUsageFieldValue {
  case class tableCatalog(override val value: /* unknown nullability */ Option[String]) extends ViewRoutineUsageFieldValue("table_catalog", value)
  case class tableSchema(override val value: /* unknown nullability */ Option[String]) extends ViewRoutineUsageFieldValue("table_schema", value)
  case class tableName(override val value: /* unknown nullability */ Option[String]) extends ViewRoutineUsageFieldValue("table_name", value)
  case class specificCatalog(override val value: /* unknown nullability */ Option[String]) extends ViewRoutineUsageFieldValue("specific_catalog", value)
  case class specificSchema(override val value: /* unknown nullability */ Option[String]) extends ViewRoutineUsageFieldValue("specific_schema", value)
  case class specificName(override val value: /* unknown nullability */ Option[String]) extends ViewRoutineUsageFieldValue("specific_name", value)
}