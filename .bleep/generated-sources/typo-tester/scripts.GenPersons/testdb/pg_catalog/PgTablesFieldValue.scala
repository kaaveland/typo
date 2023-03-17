package testdb.pg_catalog



sealed abstract class PgTablesFieldValue[T](val name: String, val value: T)

object PgTablesFieldValue {
  case class schemaname(override val value: String) extends PgTablesFieldValue("schemaname", value)
  case class tablename(override val value: String) extends PgTablesFieldValue("tablename", value)
  case class tableowner(override val value: /* unknown nullability */ Option[String]) extends PgTablesFieldValue("tableowner", value)
  case class tablespace(override val value: String) extends PgTablesFieldValue("tablespace", value)
  case class hasindexes(override val value: Boolean) extends PgTablesFieldValue("hasindexes", value)
  case class hasrules(override val value: Boolean) extends PgTablesFieldValue("hasrules", value)
  case class hastriggers(override val value: Boolean) extends PgTablesFieldValue("hastriggers", value)
  case class rowsecurity(override val value: Boolean) extends PgTablesFieldValue("rowsecurity", value)
}