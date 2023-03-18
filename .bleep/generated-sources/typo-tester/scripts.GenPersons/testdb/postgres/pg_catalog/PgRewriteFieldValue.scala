package testdb
package postgres
package pg_catalog



sealed abstract class PgRewriteFieldValue[T](val name: String, val value: T)

object PgRewriteFieldValue {
  case class oid(override val value: Long) extends PgRewriteFieldValue("oid", value)
  case class rulename(override val value: String) extends PgRewriteFieldValue("rulename", value)
  case class evClass(override val value: Long) extends PgRewriteFieldValue("ev_class", value)
  case class evType(override val value: String) extends PgRewriteFieldValue("ev_type", value)
  case class evEnabled(override val value: String) extends PgRewriteFieldValue("ev_enabled", value)
  case class isInstead(override val value: Boolean) extends PgRewriteFieldValue("is_instead", value)
  case class evQual(override val value: String) extends PgRewriteFieldValue("ev_qual", value)
  case class evAction(override val value: String) extends PgRewriteFieldValue("ev_action", value)
}