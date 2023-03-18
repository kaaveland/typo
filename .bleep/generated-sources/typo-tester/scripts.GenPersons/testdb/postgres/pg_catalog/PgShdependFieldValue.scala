package testdb
package postgres
package pg_catalog



sealed abstract class PgShdependFieldValue[T](val name: String, val value: T)

object PgShdependFieldValue {
  case class dbid(override val value: Long) extends PgShdependFieldValue("dbid", value)
  case class classid(override val value: Long) extends PgShdependFieldValue("classid", value)
  case class objid(override val value: Long) extends PgShdependFieldValue("objid", value)
  case class objsubid(override val value: Int) extends PgShdependFieldValue("objsubid", value)
  case class refclassid(override val value: Long) extends PgShdependFieldValue("refclassid", value)
  case class refobjid(override val value: Long) extends PgShdependFieldValue("refobjid", value)
  case class deptype(override val value: String) extends PgShdependFieldValue("deptype", value)
}