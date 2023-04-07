/**
 * File has been automatically generated by `typo` for internal use.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 *
 * (If you're developing `typo` and want to change it: run `bleep generate-sources`)
 */
package typo
package generated
package pg_catalog
package pg_type

import org.postgresql.util.PGobject

sealed abstract class PgTypeFieldOrIdValue[T](val name: String, val value: T)
sealed abstract class PgTypeFieldValue[T](name: String, value: T) extends PgTypeFieldOrIdValue(name, value)

object PgTypeFieldValue {
  case class oid(override val value: PgTypeId) extends PgTypeFieldOrIdValue("oid", value)
  case class typname(override val value: String) extends PgTypeFieldValue("typname", value)
  case class typnamespace(override val value: /* oid */ Long) extends PgTypeFieldValue("typnamespace", value)
  case class typowner(override val value: /* oid */ Long) extends PgTypeFieldValue("typowner", value)
  case class typlen(override val value: Int) extends PgTypeFieldValue("typlen", value)
  case class typbyval(override val value: Boolean) extends PgTypeFieldValue("typbyval", value)
  case class typtype(override val value: String) extends PgTypeFieldValue("typtype", value)
  case class typcategory(override val value: String) extends PgTypeFieldValue("typcategory", value)
  case class typispreferred(override val value: Boolean) extends PgTypeFieldValue("typispreferred", value)
  case class typisdefined(override val value: Boolean) extends PgTypeFieldValue("typisdefined", value)
  case class typdelim(override val value: String) extends PgTypeFieldValue("typdelim", value)
  case class typrelid(override val value: /* oid */ Long) extends PgTypeFieldValue("typrelid", value)
  case class typsubscript(override val value: /* regproc */ PGobject) extends PgTypeFieldValue("typsubscript", value)
  case class typelem(override val value: /* oid */ Long) extends PgTypeFieldValue("typelem", value)
  case class typarray(override val value: /* oid */ Long) extends PgTypeFieldValue("typarray", value)
  case class typinput(override val value: /* regproc */ PGobject) extends PgTypeFieldValue("typinput", value)
  case class typoutput(override val value: /* regproc */ PGobject) extends PgTypeFieldValue("typoutput", value)
  case class typreceive(override val value: /* regproc */ PGobject) extends PgTypeFieldValue("typreceive", value)
  case class typsend(override val value: /* regproc */ PGobject) extends PgTypeFieldValue("typsend", value)
  case class typmodin(override val value: /* regproc */ PGobject) extends PgTypeFieldValue("typmodin", value)
  case class typmodout(override val value: /* regproc */ PGobject) extends PgTypeFieldValue("typmodout", value)
  case class typanalyze(override val value: /* regproc */ PGobject) extends PgTypeFieldValue("typanalyze", value)
  case class typalign(override val value: String) extends PgTypeFieldValue("typalign", value)
  case class typstorage(override val value: String) extends PgTypeFieldValue("typstorage", value)
  case class typnotnull(override val value: Boolean) extends PgTypeFieldValue("typnotnull", value)
  case class typbasetype(override val value: /* oid */ Long) extends PgTypeFieldValue("typbasetype", value)
  case class typtypmod(override val value: Int) extends PgTypeFieldValue("typtypmod", value)
  case class typndims(override val value: Int) extends PgTypeFieldValue("typndims", value)
  case class typcollation(override val value: /* oid */ Long) extends PgTypeFieldValue("typcollation", value)
  case class typdefaultbin(override val value: Option[/* pg_node_tree */ PGobject]) extends PgTypeFieldValue("typdefaultbin", value)
  case class typdefault(override val value: Option[String]) extends PgTypeFieldValue("typdefault", value)
  case class typacl(override val value: Option[Array[/* aclitem */ PGobject]]) extends PgTypeFieldValue("typacl", value)
}
