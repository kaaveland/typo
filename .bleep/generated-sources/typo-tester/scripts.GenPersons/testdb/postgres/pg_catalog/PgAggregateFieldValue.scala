package testdb
package postgres
package pg_catalog



sealed abstract class PgAggregateFieldValue[T](val name: String, val value: T)

object PgAggregateFieldValue {
  case class aggfnoid(override val value: String) extends PgAggregateFieldValue("aggfnoid", value)
  case class aggkind(override val value: String) extends PgAggregateFieldValue("aggkind", value)
  case class aggnumdirectargs(override val value: Short) extends PgAggregateFieldValue("aggnumdirectargs", value)
  case class aggtransfn(override val value: String) extends PgAggregateFieldValue("aggtransfn", value)
  case class aggfinalfn(override val value: String) extends PgAggregateFieldValue("aggfinalfn", value)
  case class aggcombinefn(override val value: String) extends PgAggregateFieldValue("aggcombinefn", value)
  case class aggserialfn(override val value: String) extends PgAggregateFieldValue("aggserialfn", value)
  case class aggdeserialfn(override val value: String) extends PgAggregateFieldValue("aggdeserialfn", value)
  case class aggmtransfn(override val value: String) extends PgAggregateFieldValue("aggmtransfn", value)
  case class aggminvtransfn(override val value: String) extends PgAggregateFieldValue("aggminvtransfn", value)
  case class aggmfinalfn(override val value: String) extends PgAggregateFieldValue("aggmfinalfn", value)
  case class aggfinalextra(override val value: Boolean) extends PgAggregateFieldValue("aggfinalextra", value)
  case class aggmfinalextra(override val value: Boolean) extends PgAggregateFieldValue("aggmfinalextra", value)
  case class aggfinalmodify(override val value: String) extends PgAggregateFieldValue("aggfinalmodify", value)
  case class aggmfinalmodify(override val value: String) extends PgAggregateFieldValue("aggmfinalmodify", value)
  case class aggsortop(override val value: Long) extends PgAggregateFieldValue("aggsortop", value)
  case class aggtranstype(override val value: Long) extends PgAggregateFieldValue("aggtranstype", value)
  case class aggtransspace(override val value: Int) extends PgAggregateFieldValue("aggtransspace", value)
  case class aggmtranstype(override val value: Long) extends PgAggregateFieldValue("aggmtranstype", value)
  case class aggmtransspace(override val value: Int) extends PgAggregateFieldValue("aggmtransspace", value)
  case class agginitval(override val value: Option[String]) extends PgAggregateFieldValue("agginitval", value)
  case class aggminitval(override val value: Option[String]) extends PgAggregateFieldValue("aggminitval", value)
}