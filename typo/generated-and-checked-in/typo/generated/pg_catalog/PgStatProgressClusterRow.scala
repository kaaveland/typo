/**
 * File has been automatically generated by `typo` for internal use.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 *
 * (If you're developing `typo` and want to change it: run `bleep generate-sources)
 */
package typo
package generated
package pg_catalog

import anorm.RowParser
import anorm.Success

case class PgStatProgressClusterRow(
  pid: /* unknown nullability */ Option[Int],
  datid: /* unknown nullability */ Option[Long],
  /** Points to [[PgDatabaseRow.datname]] */
  datname: String,
  relid: /* unknown nullability */ Option[Long],
  command: /* unknown nullability */ Option[String],
  phase: /* unknown nullability */ Option[String],
  clusterIndexRelid: /* unknown nullability */ Option[Long],
  heapTuplesScanned: /* unknown nullability */ Option[Long],
  heapTuplesWritten: /* unknown nullability */ Option[Long],
  heapBlksTotal: /* unknown nullability */ Option[Long],
  heapBlksScanned: /* unknown nullability */ Option[Long],
  indexRebuildCount: /* unknown nullability */ Option[Long]
)

object PgStatProgressClusterRow {
  implicit val rowParser: RowParser[PgStatProgressClusterRow] = { row =>
    Success(
      PgStatProgressClusterRow(
        pid = row[/* unknown nullability */ Option[Int]]("pid"),
        datid = row[/* unknown nullability */ Option[Long]]("datid"),
        datname = row[String]("datname"),
        relid = row[/* unknown nullability */ Option[Long]]("relid"),
        command = row[/* unknown nullability */ Option[String]]("command"),
        phase = row[/* unknown nullability */ Option[String]]("phase"),
        clusterIndexRelid = row[/* unknown nullability */ Option[Long]]("cluster_index_relid"),
        heapTuplesScanned = row[/* unknown nullability */ Option[Long]]("heap_tuples_scanned"),
        heapTuplesWritten = row[/* unknown nullability */ Option[Long]]("heap_tuples_written"),
        heapBlksTotal = row[/* unknown nullability */ Option[Long]]("heap_blks_total"),
        heapBlksScanned = row[/* unknown nullability */ Option[Long]]("heap_blks_scanned"),
        indexRebuildCount = row[/* unknown nullability */ Option[Long]]("index_rebuild_count")
      )
    )
  }

  
}