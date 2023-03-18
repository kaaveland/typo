package testdb
package postgres
package pg_catalog



sealed abstract class PgSequenceFieldValue[T](val name: String, val value: T)

object PgSequenceFieldValue {
  case class seqrelid(override val value: Long) extends PgSequenceFieldValue("seqrelid", value)
  case class seqtypid(override val value: Long) extends PgSequenceFieldValue("seqtypid", value)
  case class seqstart(override val value: Long) extends PgSequenceFieldValue("seqstart", value)
  case class seqincrement(override val value: Long) extends PgSequenceFieldValue("seqincrement", value)
  case class seqmax(override val value: Long) extends PgSequenceFieldValue("seqmax", value)
  case class seqmin(override val value: Long) extends PgSequenceFieldValue("seqmin", value)
  case class seqcache(override val value: Long) extends PgSequenceFieldValue("seqcache", value)
  case class seqcycle(override val value: Boolean) extends PgSequenceFieldValue("seqcycle", value)
}
