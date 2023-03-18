package testdb
package postgres
package pg_catalog



sealed abstract class PgEnumFieldValue[T](val name: String, val value: T)

object PgEnumFieldValue {
  case class oid(override val value: Long) extends PgEnumFieldValue("oid", value)
  case class enumtypid(override val value: Long) extends PgEnumFieldValue("enumtypid", value)
  case class enumsortorder(override val value: Float) extends PgEnumFieldValue("enumsortorder", value)
  case class enumlabel(override val value: String) extends PgEnumFieldValue("enumlabel", value)
}
