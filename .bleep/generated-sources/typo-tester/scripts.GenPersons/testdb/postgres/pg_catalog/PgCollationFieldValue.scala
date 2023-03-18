package testdb
package postgres
package pg_catalog



sealed abstract class PgCollationFieldValue[T](val name: String, val value: T)

object PgCollationFieldValue {
  case class oid(override val value: Long) extends PgCollationFieldValue("oid", value)
  case class collname(override val value: String) extends PgCollationFieldValue("collname", value)
  case class collnamespace(override val value: Long) extends PgCollationFieldValue("collnamespace", value)
  case class collowner(override val value: Long) extends PgCollationFieldValue("collowner", value)
  case class collprovider(override val value: String) extends PgCollationFieldValue("collprovider", value)
  case class collisdeterministic(override val value: Boolean) extends PgCollationFieldValue("collisdeterministic", value)
  case class collencoding(override val value: Int) extends PgCollationFieldValue("collencoding", value)
  case class collcollate(override val value: String) extends PgCollationFieldValue("collcollate", value)
  case class collctype(override val value: String) extends PgCollationFieldValue("collctype", value)
  case class collversion(override val value: Option[String]) extends PgCollationFieldValue("collversion", value)
}
