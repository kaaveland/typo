package testdb
package postgres
package pg_catalog



sealed abstract class PgShdescriptionFieldValue[T](val name: String, val value: T)

object PgShdescriptionFieldValue {
  case class objoid(override val value: Long) extends PgShdescriptionFieldValue("objoid", value)
  case class classoid(override val value: Long) extends PgShdescriptionFieldValue("classoid", value)
  case class description(override val value: String) extends PgShdescriptionFieldValue("description", value)
}
