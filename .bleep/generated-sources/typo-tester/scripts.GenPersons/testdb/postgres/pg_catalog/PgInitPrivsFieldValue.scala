package testdb
package postgres
package pg_catalog



sealed abstract class PgInitPrivsFieldValue[T](val name: String, val value: T)

object PgInitPrivsFieldValue {
  case class objoid(override val value: Long) extends PgInitPrivsFieldValue("objoid", value)
  case class classoid(override val value: Long) extends PgInitPrivsFieldValue("classoid", value)
  case class objsubid(override val value: Int) extends PgInitPrivsFieldValue("objsubid", value)
  case class privtype(override val value: String) extends PgInitPrivsFieldValue("privtype", value)
  case class initprivs(override val value: Array[String]) extends PgInitPrivsFieldValue("initprivs", value)
}
