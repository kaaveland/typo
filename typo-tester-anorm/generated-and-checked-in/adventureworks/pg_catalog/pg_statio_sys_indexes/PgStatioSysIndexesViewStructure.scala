/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_statio_sys_indexes

import typo.dsl.SqlExpr.Field
import typo.dsl.SqlExpr.FieldLikeNoHkt
import typo.dsl.Structure.Relation

class PgStatioSysIndexesViewStructure[Row](val prefix: Option[String], val extract: Row => PgStatioSysIndexesViewRow, val merge: (Row, PgStatioSysIndexesViewRow) => Row)
  extends Relation[PgStatioSysIndexesViewFields, PgStatioSysIndexesViewRow, Row]
    with PgStatioSysIndexesViewFields[Row] { outer =>

  override val relid = new Field[/* oid */ Long, Row](prefix, "relid", None, Some("oid"))(x => extract(x).relid, (row, value) => merge(row, extract(row).copy(relid = value)))
  override val indexrelid = new Field[/* oid */ Long, Row](prefix, "indexrelid", None, Some("oid"))(x => extract(x).indexrelid, (row, value) => merge(row, extract(row).copy(indexrelid = value)))
  override val schemaname = new Field[String, Row](prefix, "schemaname", None, Some("name"))(x => extract(x).schemaname, (row, value) => merge(row, extract(row).copy(schemaname = value)))
  override val relname = new Field[String, Row](prefix, "relname", None, Some("name"))(x => extract(x).relname, (row, value) => merge(row, extract(row).copy(relname = value)))
  override val indexrelname = new Field[String, Row](prefix, "indexrelname", None, Some("name"))(x => extract(x).indexrelname, (row, value) => merge(row, extract(row).copy(indexrelname = value)))
  override val idxBlksRead = new Field[Long, Row](prefix, "idx_blks_read", None, Some("int8"))(x => extract(x).idxBlksRead, (row, value) => merge(row, extract(row).copy(idxBlksRead = value)))
  override val idxBlksHit = new Field[Long, Row](prefix, "idx_blks_hit", None, Some("int8"))(x => extract(x).idxBlksHit, (row, value) => merge(row, extract(row).copy(idxBlksHit = value)))

  override val columns: List[FieldLikeNoHkt[?, Row]] =
    List[FieldLikeNoHkt[?, Row]](relid, indexrelid, schemaname, relname, indexrelname, idxBlksRead, idxBlksHit)

  override def copy[NewRow](prefix: Option[String], extract: NewRow => PgStatioSysIndexesViewRow, merge: (NewRow, PgStatioSysIndexesViewRow) => NewRow): PgStatioSysIndexesViewStructure[NewRow] =
    new PgStatioSysIndexesViewStructure(prefix, extract, merge)
}
