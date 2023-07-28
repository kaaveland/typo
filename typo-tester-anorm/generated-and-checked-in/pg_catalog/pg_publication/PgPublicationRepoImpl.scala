/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_publication

import anorm.SqlStringInterpolation
import java.sql.Connection

object PgPublicationRepoImpl extends PgPublicationRepo {
  override def delete(oid: PgPublicationId)(implicit c: Connection): Boolean = {
    SQL"delete from pg_catalog.pg_publication where oid = $oid".executeUpdate() > 0
  }
  override def insert(unsaved: PgPublicationRow)(implicit c: Connection): PgPublicationRow = {
    SQL"""insert into pg_catalog.pg_publication(oid, pubname, pubowner, puballtables, pubinsert, pubupdate, pubdelete, pubtruncate, pubviaroot)
          values (${unsaved.oid}::oid, ${unsaved.pubname}::name, ${unsaved.pubowner}::oid, ${unsaved.puballtables}, ${unsaved.pubinsert}, ${unsaved.pubupdate}, ${unsaved.pubdelete}, ${unsaved.pubtruncate}, ${unsaved.pubviaroot})
          returning oid, pubname, pubowner, puballtables, pubinsert, pubupdate, pubdelete, pubtruncate, pubviaroot
       """
      .executeInsert(PgPublicationRow.rowParser(1).single)
    
  }
  override def selectAll(implicit c: Connection): List[PgPublicationRow] = {
    SQL"""select oid, pubname, pubowner, puballtables, pubinsert, pubupdate, pubdelete, pubtruncate, pubviaroot
          from pg_catalog.pg_publication
       """.as(PgPublicationRow.rowParser(1).*)
  }
  override def selectById(oid: PgPublicationId)(implicit c: Connection): Option[PgPublicationRow] = {
    SQL"""select oid, pubname, pubowner, puballtables, pubinsert, pubupdate, pubdelete, pubtruncate, pubviaroot
          from pg_catalog.pg_publication
          where oid = $oid
       """.as(PgPublicationRow.rowParser(1).singleOpt)
  }
  override def selectByIds(oids: Array[PgPublicationId])(implicit c: Connection): List[PgPublicationRow] = {
    SQL"""select oid, pubname, pubowner, puballtables, pubinsert, pubupdate, pubdelete, pubtruncate, pubviaroot
          from pg_catalog.pg_publication
          where oid = ANY($oids)
       """.as(PgPublicationRow.rowParser(1).*)
    
  }
  override def update(row: PgPublicationRow)(implicit c: Connection): Boolean = {
    val oid = row.oid
    SQL"""update pg_catalog.pg_publication
          set pubname = ${row.pubname}::name,
              pubowner = ${row.pubowner}::oid,
              puballtables = ${row.puballtables},
              pubinsert = ${row.pubinsert},
              pubupdate = ${row.pubupdate},
              pubdelete = ${row.pubdelete},
              pubtruncate = ${row.pubtruncate},
              pubviaroot = ${row.pubviaroot}
          where oid = $oid
       """.executeUpdate() > 0
  }
  override def upsert(unsaved: PgPublicationRow)(implicit c: Connection): PgPublicationRow = {
    SQL"""insert into pg_catalog.pg_publication(oid, pubname, pubowner, puballtables, pubinsert, pubupdate, pubdelete, pubtruncate, pubviaroot)
          values (
            ${unsaved.oid}::oid,
            ${unsaved.pubname}::name,
            ${unsaved.pubowner}::oid,
            ${unsaved.puballtables},
            ${unsaved.pubinsert},
            ${unsaved.pubupdate},
            ${unsaved.pubdelete},
            ${unsaved.pubtruncate},
            ${unsaved.pubviaroot}
          )
          on conflict (oid)
          do update set
            pubname = EXCLUDED.pubname,
            pubowner = EXCLUDED.pubowner,
            puballtables = EXCLUDED.puballtables,
            pubinsert = EXCLUDED.pubinsert,
            pubupdate = EXCLUDED.pubupdate,
            pubdelete = EXCLUDED.pubdelete,
            pubtruncate = EXCLUDED.pubtruncate,
            pubviaroot = EXCLUDED.pubviaroot
          returning oid, pubname, pubowner, puballtables, pubinsert, pubupdate, pubdelete, pubtruncate, pubviaroot
       """
      .executeInsert(PgPublicationRow.rowParser(1).single)
    
  }
}