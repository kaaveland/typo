package testdb
package postgres
package pg_catalog



sealed abstract class PgPublicationFieldValue[T](val name: String, val value: T)

object PgPublicationFieldValue {
  case class oid(override val value: Long) extends PgPublicationFieldValue("oid", value)
  case class pubname(override val value: String) extends PgPublicationFieldValue("pubname", value)
  case class pubowner(override val value: Long) extends PgPublicationFieldValue("pubowner", value)
  case class puballtables(override val value: Boolean) extends PgPublicationFieldValue("puballtables", value)
  case class pubinsert(override val value: Boolean) extends PgPublicationFieldValue("pubinsert", value)
  case class pubupdate(override val value: Boolean) extends PgPublicationFieldValue("pubupdate", value)
  case class pubdelete(override val value: Boolean) extends PgPublicationFieldValue("pubdelete", value)
  case class pubtruncate(override val value: Boolean) extends PgPublicationFieldValue("pubtruncate", value)
  case class pubviaroot(override val value: Boolean) extends PgPublicationFieldValue("pubviaroot", value)
}