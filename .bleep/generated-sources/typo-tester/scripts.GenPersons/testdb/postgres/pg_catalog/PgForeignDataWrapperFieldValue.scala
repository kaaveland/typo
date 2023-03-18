package testdb
package postgres
package pg_catalog



sealed abstract class PgForeignDataWrapperFieldValue[T](val name: String, val value: T)

object PgForeignDataWrapperFieldValue {
  case class oid(override val value: Long) extends PgForeignDataWrapperFieldValue("oid", value)
  case class fdwname(override val value: String) extends PgForeignDataWrapperFieldValue("fdwname", value)
  case class fdwowner(override val value: Long) extends PgForeignDataWrapperFieldValue("fdwowner", value)
  case class fdwhandler(override val value: Long) extends PgForeignDataWrapperFieldValue("fdwhandler", value)
  case class fdwvalidator(override val value: Long) extends PgForeignDataWrapperFieldValue("fdwvalidator", value)
  case class fdwacl(override val value: Option[Array[String]]) extends PgForeignDataWrapperFieldValue("fdwacl", value)
  case class fdwoptions(override val value: Option[Array[String]]) extends PgForeignDataWrapperFieldValue("fdwoptions", value)
}