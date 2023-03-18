package testdb
package postgres
package pg_catalog



sealed abstract class PgConversionFieldValue[T](val name: String, val value: T)

object PgConversionFieldValue {
  case class oid(override val value: Long) extends PgConversionFieldValue("oid", value)
  case class conname(override val value: String) extends PgConversionFieldValue("conname", value)
  case class connamespace(override val value: Long) extends PgConversionFieldValue("connamespace", value)
  case class conowner(override val value: Long) extends PgConversionFieldValue("conowner", value)
  case class conforencoding(override val value: Int) extends PgConversionFieldValue("conforencoding", value)
  case class contoencoding(override val value: Int) extends PgConversionFieldValue("contoencoding", value)
  case class conproc(override val value: String) extends PgConversionFieldValue("conproc", value)
  case class condefault(override val value: Boolean) extends PgConversionFieldValue("condefault", value)
}
