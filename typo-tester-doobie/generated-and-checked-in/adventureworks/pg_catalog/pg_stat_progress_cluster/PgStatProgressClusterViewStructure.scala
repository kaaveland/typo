/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_stat_progress_cluster

import typo.dsl.SqlExpr.FieldLikeNoHkt
import typo.dsl.SqlExpr.OptField
import typo.dsl.Structure.Relation

class PgStatProgressClusterViewStructure[Row](val prefix: Option[String], val extract: Row => PgStatProgressClusterViewRow, val merge: (Row, PgStatProgressClusterViewRow) => Row)
  extends Relation[PgStatProgressClusterViewFields, PgStatProgressClusterViewRow, Row]
    with PgStatProgressClusterViewFields[Row] { outer =>

  override val pid = new OptField[Int, Row](prefix, "pid", None, Some("int4"))(x => extract(x).pid, (row, value) => merge(row, extract(row).copy(pid = value)))
  override val datid = new OptField[/* oid */ Long, Row](prefix, "datid", None, Some("oid"))(x => extract(x).datid, (row, value) => merge(row, extract(row).copy(datid = value)))
  override val datname = new OptField[String, Row](prefix, "datname", None, Some("name"))(x => extract(x).datname, (row, value) => merge(row, extract(row).copy(datname = value)))
  override val relid = new OptField[/* oid */ Long, Row](prefix, "relid", None, Some("oid"))(x => extract(x).relid, (row, value) => merge(row, extract(row).copy(relid = value)))
  override val command = new OptField[String, Row](prefix, "command", None, None)(x => extract(x).command, (row, value) => merge(row, extract(row).copy(command = value)))
  override val phase = new OptField[String, Row](prefix, "phase", None, None)(x => extract(x).phase, (row, value) => merge(row, extract(row).copy(phase = value)))
  override val clusterIndexRelid = new OptField[/* oid */ Long, Row](prefix, "cluster_index_relid", None, Some("oid"))(x => extract(x).clusterIndexRelid, (row, value) => merge(row, extract(row).copy(clusterIndexRelid = value)))
  override val heapTuplesScanned = new OptField[Long, Row](prefix, "heap_tuples_scanned", None, Some("int8"))(x => extract(x).heapTuplesScanned, (row, value) => merge(row, extract(row).copy(heapTuplesScanned = value)))
  override val heapTuplesWritten = new OptField[Long, Row](prefix, "heap_tuples_written", None, Some("int8"))(x => extract(x).heapTuplesWritten, (row, value) => merge(row, extract(row).copy(heapTuplesWritten = value)))
  override val heapBlksTotal = new OptField[Long, Row](prefix, "heap_blks_total", None, Some("int8"))(x => extract(x).heapBlksTotal, (row, value) => merge(row, extract(row).copy(heapBlksTotal = value)))
  override val heapBlksScanned = new OptField[Long, Row](prefix, "heap_blks_scanned", None, Some("int8"))(x => extract(x).heapBlksScanned, (row, value) => merge(row, extract(row).copy(heapBlksScanned = value)))
  override val indexRebuildCount = new OptField[Long, Row](prefix, "index_rebuild_count", None, Some("int8"))(x => extract(x).indexRebuildCount, (row, value) => merge(row, extract(row).copy(indexRebuildCount = value)))

  override val columns: List[FieldLikeNoHkt[?, Row]] =
    List[FieldLikeNoHkt[?, Row]](pid, datid, datname, relid, command, phase, clusterIndexRelid, heapTuplesScanned, heapTuplesWritten, heapBlksTotal, heapBlksScanned, indexRebuildCount)

  override def copy[NewRow](prefix: Option[String], extract: NewRow => PgStatProgressClusterViewRow, merge: (NewRow, PgStatProgressClusterViewRow) => NewRow): PgStatProgressClusterViewStructure[NewRow] =
    new PgStatProgressClusterViewStructure(prefix, extract, merge)
}