package testdb
package postgres
package pg_catalog



sealed abstract class PgPolicyFieldValue[T](val name: String, val value: T)

object PgPolicyFieldValue {
  case class oid(override val value: Long) extends PgPolicyFieldValue("oid", value)
  case class polname(override val value: String) extends PgPolicyFieldValue("polname", value)
  case class polrelid(override val value: Long) extends PgPolicyFieldValue("polrelid", value)
  case class polcmd(override val value: String) extends PgPolicyFieldValue("polcmd", value)
  case class polpermissive(override val value: Boolean) extends PgPolicyFieldValue("polpermissive", value)
  case class polroles(override val value: Array[Long]) extends PgPolicyFieldValue("polroles", value)
  case class polqual(override val value: Option[String]) extends PgPolicyFieldValue("polqual", value)
  case class polwithcheck(override val value: Option[String]) extends PgPolicyFieldValue("polwithcheck", value)
}
