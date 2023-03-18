package testdb
package postgres
package pg_catalog



sealed abstract class PgLargeobjectFieldValue[T](val name: String, val value: T)

object PgLargeobjectFieldValue {
  case class loid(override val value: Long) extends PgLargeobjectFieldValue("loid", value)
  case class pageno(override val value: Int) extends PgLargeobjectFieldValue("pageno", value)
  case class data(override val value: String) extends PgLargeobjectFieldValue("data", value)
}
