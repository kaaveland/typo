/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_sequence

import anorm.SqlStringInterpolation
import java.sql.Connection

object PgSequenceRepoImpl extends PgSequenceRepo {
  override def delete(seqrelid: PgSequenceId)(implicit c: Connection): Boolean = {
    SQL"delete from pg_catalog.pg_sequence where seqrelid = $seqrelid".executeUpdate() > 0
  }
  override def insert(unsaved: PgSequenceRow)(implicit c: Connection): PgSequenceRow = {
    SQL"""insert into pg_catalog.pg_sequence(seqrelid, seqtypid, seqstart, seqincrement, seqmax, seqmin, seqcache, seqcycle)
          values (${unsaved.seqrelid}::oid, ${unsaved.seqtypid}::oid, ${unsaved.seqstart}::int8, ${unsaved.seqincrement}::int8, ${unsaved.seqmax}::int8, ${unsaved.seqmin}::int8, ${unsaved.seqcache}::int8, ${unsaved.seqcycle})
          returning seqrelid, seqtypid, seqstart, seqincrement, seqmax, seqmin, seqcache, seqcycle
       """
      .executeInsert(PgSequenceRow.rowParser(1).single)
    
  }
  override def selectAll(implicit c: Connection): List[PgSequenceRow] = {
    SQL"""select seqrelid, seqtypid, seqstart, seqincrement, seqmax, seqmin, seqcache, seqcycle
          from pg_catalog.pg_sequence
       """.as(PgSequenceRow.rowParser(1).*)
  }
  override def selectById(seqrelid: PgSequenceId)(implicit c: Connection): Option[PgSequenceRow] = {
    SQL"""select seqrelid, seqtypid, seqstart, seqincrement, seqmax, seqmin, seqcache, seqcycle
          from pg_catalog.pg_sequence
          where seqrelid = $seqrelid
       """.as(PgSequenceRow.rowParser(1).singleOpt)
  }
  override def selectByIds(seqrelids: Array[PgSequenceId])(implicit c: Connection): List[PgSequenceRow] = {
    SQL"""select seqrelid, seqtypid, seqstart, seqincrement, seqmax, seqmin, seqcache, seqcycle
          from pg_catalog.pg_sequence
          where seqrelid = ANY($seqrelids)
       """.as(PgSequenceRow.rowParser(1).*)
    
  }
  override def update(row: PgSequenceRow)(implicit c: Connection): Boolean = {
    val seqrelid = row.seqrelid
    SQL"""update pg_catalog.pg_sequence
          set seqtypid = ${row.seqtypid}::oid,
              seqstart = ${row.seqstart}::int8,
              seqincrement = ${row.seqincrement}::int8,
              seqmax = ${row.seqmax}::int8,
              seqmin = ${row.seqmin}::int8,
              seqcache = ${row.seqcache}::int8,
              seqcycle = ${row.seqcycle}
          where seqrelid = $seqrelid
       """.executeUpdate() > 0
  }
  override def upsert(unsaved: PgSequenceRow)(implicit c: Connection): PgSequenceRow = {
    SQL"""insert into pg_catalog.pg_sequence(seqrelid, seqtypid, seqstart, seqincrement, seqmax, seqmin, seqcache, seqcycle)
          values (
            ${unsaved.seqrelid}::oid,
            ${unsaved.seqtypid}::oid,
            ${unsaved.seqstart}::int8,
            ${unsaved.seqincrement}::int8,
            ${unsaved.seqmax}::int8,
            ${unsaved.seqmin}::int8,
            ${unsaved.seqcache}::int8,
            ${unsaved.seqcycle}
          )
          on conflict (seqrelid)
          do update set
            seqtypid = EXCLUDED.seqtypid,
            seqstart = EXCLUDED.seqstart,
            seqincrement = EXCLUDED.seqincrement,
            seqmax = EXCLUDED.seqmax,
            seqmin = EXCLUDED.seqmin,
            seqcache = EXCLUDED.seqcache,
            seqcycle = EXCLUDED.seqcycle
          returning seqrelid, seqtypid, seqstart, seqincrement, seqmax, seqmin, seqcache, seqcycle
       """
      .executeInsert(PgSequenceRow.rowParser(1).single)
    
  }
}