/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_statio_user_indexes

import adventureworks.pg_catalog.pg_class.PgClassId
import typo.dsl.SqlExpr.FieldLikeNoHkt
import typo.dsl.SqlExpr.OptField
import typo.dsl.Structure.Relation

class PgStatioUserIndexesViewStructure[Row](val prefix: Option[String], val extract: Row => PgStatioUserIndexesViewRow, val merge: (Row, PgStatioUserIndexesViewRow) => Row)
  extends Relation[PgStatioUserIndexesViewFields, PgStatioUserIndexesViewRow, Row]
    with PgStatioUserIndexesViewFields[Row] { outer =>

  override val relid = new OptField[PgClassId, Row](prefix, "relid", None, None)(x => extract(x).relid, (row, value) => merge(row, extract(row).copy(relid = value)))
  override val indexrelid = new OptField[PgClassId, Row](prefix, "indexrelid", None, None)(x => extract(x).indexrelid, (row, value) => merge(row, extract(row).copy(indexrelid = value)))
  override val schemaname = new OptField[String, Row](prefix, "schemaname", None, None)(x => extract(x).schemaname, (row, value) => merge(row, extract(row).copy(schemaname = value)))
  override val relname = new OptField[String, Row](prefix, "relname", None, None)(x => extract(x).relname, (row, value) => merge(row, extract(row).copy(relname = value)))
  override val indexrelname = new OptField[String, Row](prefix, "indexrelname", None, None)(x => extract(x).indexrelname, (row, value) => merge(row, extract(row).copy(indexrelname = value)))
  override val idxBlksRead = new OptField[/* nullability unknown */ Long, Row](prefix, "idx_blks_read", None, None)(x => extract(x).idxBlksRead, (row, value) => merge(row, extract(row).copy(idxBlksRead = value)))
  override val idxBlksHit = new OptField[/* nullability unknown */ Long, Row](prefix, "idx_blks_hit", None, None)(x => extract(x).idxBlksHit, (row, value) => merge(row, extract(row).copy(idxBlksHit = value)))

  override val columns: List[FieldLikeNoHkt[?, Row]] =
    List[FieldLikeNoHkt[?, Row]](relid, indexrelid, schemaname, relname, indexrelname, idxBlksRead, idxBlksHit)

  override def copy[NewRow](prefix: Option[String], extract: NewRow => PgStatioUserIndexesViewRow, merge: (NewRow, PgStatioUserIndexesViewRow) => NewRow): PgStatioUserIndexesViewStructure[NewRow] =
    new PgStatioUserIndexesViewStructure(prefix, extract, merge)
}
