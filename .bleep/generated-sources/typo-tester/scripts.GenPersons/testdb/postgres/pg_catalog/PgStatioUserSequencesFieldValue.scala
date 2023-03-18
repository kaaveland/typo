package testdb
package postgres
package pg_catalog



sealed abstract class PgStatioUserSequencesFieldValue[T](val name: String, val value: T)

object PgStatioUserSequencesFieldValue {
  case class relid(override val value: Option[Long]) extends PgStatioUserSequencesFieldValue("relid", value)
  case class schemaname(override val value: Option[String]) extends PgStatioUserSequencesFieldValue("schemaname", value)
  case class relname(override val value: Option[String]) extends PgStatioUserSequencesFieldValue("relname", value)
  case class blksRead(override val value: Option[Long]) extends PgStatioUserSequencesFieldValue("blks_read", value)
  case class blksHit(override val value: Option[Long]) extends PgStatioUserSequencesFieldValue("blks_hit", value)
}