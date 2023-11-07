/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_prepared_xacts

import adventureworks.customtypes.TypoInstant
import adventureworks.customtypes.TypoXid
import typo.dsl.SqlExpr.FieldLikeNoHkt
import typo.dsl.SqlExpr.OptField
import typo.dsl.Structure.Relation

class PgPreparedXactsViewStructure[Row](val prefix: Option[String], val extract: Row => PgPreparedXactsViewRow, val merge: (Row, PgPreparedXactsViewRow) => Row)
  extends Relation[PgPreparedXactsViewFields, PgPreparedXactsViewRow, Row]
    with PgPreparedXactsViewFields[Row] { outer =>

  override val transaction = new OptField[TypoXid, Row](prefix, "transaction", None, None)(x => extract(x).transaction, (row, value) => merge(row, extract(row).copy(transaction = value)))
  override val gid = new OptField[String, Row](prefix, "gid", None, None)(x => extract(x).gid, (row, value) => merge(row, extract(row).copy(gid = value)))
  override val prepared = new OptField[TypoInstant, Row](prefix, "prepared", Some("text"), None)(x => extract(x).prepared, (row, value) => merge(row, extract(row).copy(prepared = value)))
  override val owner = new OptField[String, Row](prefix, "owner", None, None)(x => extract(x).owner, (row, value) => merge(row, extract(row).copy(owner = value)))
  override val database = new OptField[String, Row](prefix, "database", None, None)(x => extract(x).database, (row, value) => merge(row, extract(row).copy(database = value)))

  override val columns: List[FieldLikeNoHkt[?, Row]] =
    List[FieldLikeNoHkt[?, Row]](transaction, gid, prepared, owner, database)

  override def copy[NewRow](prefix: Option[String], extract: NewRow => PgPreparedXactsViewRow, merge: (NewRow, PgPreparedXactsViewRow) => NewRow): PgPreparedXactsViewStructure[NewRow] =
    new PgPreparedXactsViewStructure(prefix, extract, merge)
}
