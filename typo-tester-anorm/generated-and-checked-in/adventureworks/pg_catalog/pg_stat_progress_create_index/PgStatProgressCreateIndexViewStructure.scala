/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_stat_progress_create_index

import typo.dsl.SqlExpr.FieldLikeNoHkt
import typo.dsl.SqlExpr.OptField
import typo.dsl.Structure.Relation

class PgStatProgressCreateIndexViewStructure[Row](val prefix: Option[String], val extract: Row => PgStatProgressCreateIndexViewRow, val merge: (Row, PgStatProgressCreateIndexViewRow) => Row)
  extends Relation[PgStatProgressCreateIndexViewFields, PgStatProgressCreateIndexViewRow, Row]
    with PgStatProgressCreateIndexViewFields[Row] { outer =>

  override val pid = new OptField[Int, Row](prefix, "pid", None, None)(x => extract(x).pid, (row, value) => merge(row, extract(row).copy(pid = value)))
  override val datid = new OptField[/* oid */ Long, Row](prefix, "datid", None, None)(x => extract(x).datid, (row, value) => merge(row, extract(row).copy(datid = value)))
  override val datname = new OptField[String, Row](prefix, "datname", None, None)(x => extract(x).datname, (row, value) => merge(row, extract(row).copy(datname = value)))
  override val relid = new OptField[/* oid */ Long, Row](prefix, "relid", None, None)(x => extract(x).relid, (row, value) => merge(row, extract(row).copy(relid = value)))
  override val indexRelid = new OptField[/* oid */ Long, Row](prefix, "index_relid", None, None)(x => extract(x).indexRelid, (row, value) => merge(row, extract(row).copy(indexRelid = value)))
  override val command = new OptField[String, Row](prefix, "command", None, None)(x => extract(x).command, (row, value) => merge(row, extract(row).copy(command = value)))
  override val phase = new OptField[String, Row](prefix, "phase", None, None)(x => extract(x).phase, (row, value) => merge(row, extract(row).copy(phase = value)))
  override val lockersTotal = new OptField[Long, Row](prefix, "lockers_total", None, None)(x => extract(x).lockersTotal, (row, value) => merge(row, extract(row).copy(lockersTotal = value)))
  override val lockersDone = new OptField[Long, Row](prefix, "lockers_done", None, None)(x => extract(x).lockersDone, (row, value) => merge(row, extract(row).copy(lockersDone = value)))
  override val currentLockerPid = new OptField[Long, Row](prefix, "current_locker_pid", None, None)(x => extract(x).currentLockerPid, (row, value) => merge(row, extract(row).copy(currentLockerPid = value)))
  override val blocksTotal = new OptField[Long, Row](prefix, "blocks_total", None, None)(x => extract(x).blocksTotal, (row, value) => merge(row, extract(row).copy(blocksTotal = value)))
  override val blocksDone = new OptField[Long, Row](prefix, "blocks_done", None, None)(x => extract(x).blocksDone, (row, value) => merge(row, extract(row).copy(blocksDone = value)))
  override val tuplesTotal = new OptField[Long, Row](prefix, "tuples_total", None, None)(x => extract(x).tuplesTotal, (row, value) => merge(row, extract(row).copy(tuplesTotal = value)))
  override val tuplesDone = new OptField[Long, Row](prefix, "tuples_done", None, None)(x => extract(x).tuplesDone, (row, value) => merge(row, extract(row).copy(tuplesDone = value)))
  override val partitionsTotal = new OptField[Long, Row](prefix, "partitions_total", None, None)(x => extract(x).partitionsTotal, (row, value) => merge(row, extract(row).copy(partitionsTotal = value)))
  override val partitionsDone = new OptField[Long, Row](prefix, "partitions_done", None, None)(x => extract(x).partitionsDone, (row, value) => merge(row, extract(row).copy(partitionsDone = value)))

  override val columns: List[FieldLikeNoHkt[?, Row]] =
    List[FieldLikeNoHkt[?, Row]](pid, datid, datname, relid, indexRelid, command, phase, lockersTotal, lockersDone, currentLockerPid, blocksTotal, blocksDone, tuplesTotal, tuplesDone, partitionsTotal, partitionsDone)

  override def copy[NewRow](prefix: Option[String], extract: NewRow => PgStatProgressCreateIndexViewRow, merge: (NewRow, PgStatProgressCreateIndexViewRow) => NewRow): PgStatProgressCreateIndexViewStructure[NewRow] =
    new PgStatProgressCreateIndexViewStructure(prefix, extract, merge)
}
