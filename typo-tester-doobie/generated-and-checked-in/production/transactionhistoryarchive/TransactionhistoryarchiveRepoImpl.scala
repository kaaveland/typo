/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package transactionhistoryarchive

import adventureworks.Defaulted
import doobie.free.connection.ConnectionIO
import doobie.syntax.string.toSqlInterpolator
import doobie.util.fragment.Fragment
import fs2.Stream
import java.time.LocalDateTime

object TransactionhistoryarchiveRepoImpl extends TransactionhistoryarchiveRepo {
  override def delete(transactionid: TransactionhistoryarchiveId): ConnectionIO[Boolean] = {
    sql"delete from production.transactionhistoryarchive where transactionid = $transactionid".update.run.map(_ > 0)
  }
  override def insert(unsaved: TransactionhistoryarchiveRow): ConnectionIO[TransactionhistoryarchiveRow] = {
    sql"""insert into production.transactionhistoryarchive(transactionid, productid, referenceorderid, referenceorderlineid, transactiondate, transactiontype, quantity, actualcost, modifieddate)
          values (${unsaved.transactionid}::int4, ${unsaved.productid}::int4, ${unsaved.referenceorderid}::int4, ${unsaved.referenceorderlineid}::int4, ${unsaved.transactiondate}::timestamp, ${unsaved.transactiontype}::bpchar, ${unsaved.quantity}::int4, ${unsaved.actualcost}::numeric, ${unsaved.modifieddate}::timestamp)
          returning transactionid, productid, referenceorderid, referenceorderlineid, transactiondate, transactiontype, quantity, actualcost, modifieddate
       """.query[TransactionhistoryarchiveRow].unique
  }
  override def insert(unsaved: TransactionhistoryarchiveRowUnsaved): ConnectionIO[TransactionhistoryarchiveRow] = {
    val fs = List(
      Some((Fragment.const(s"transactionid"), fr"${unsaved.transactionid}::int4")),
      Some((Fragment.const(s"productid"), fr"${unsaved.productid}::int4")),
      Some((Fragment.const(s"referenceorderid"), fr"${unsaved.referenceorderid}::int4")),
      Some((Fragment.const(s"transactiontype"), fr"${unsaved.transactiontype}::bpchar")),
      Some((Fragment.const(s"quantity"), fr"${unsaved.quantity}::int4")),
      Some((Fragment.const(s"actualcost"), fr"${unsaved.actualcost}::numeric")),
      unsaved.referenceorderlineid match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s"referenceorderlineid"), fr"${value: Int}::int4"))
      },
      unsaved.transactiondate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s"transactiondate"), fr"${value: LocalDateTime}::timestamp"))
      },
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s"modifieddate"), fr"${value: LocalDateTime}::timestamp"))
      }
    ).flatten
    
    val q = if (fs.isEmpty) {
      sql"""insert into production.transactionhistoryarchive default values
            returning transactionid, productid, referenceorderid, referenceorderlineid, transactiondate, transactiontype, quantity, actualcost, modifieddate
         """
    } else {
      import cats.syntax.foldable.toFoldableOps
      sql"""insert into production.transactionhistoryarchive(${fs.map { case (n, _) => n }.intercalate(fr", ")})
            values (${fs.map { case (_, f) => f }.intercalate(fr", ")})
            returning transactionid, productid, referenceorderid, referenceorderlineid, transactiondate, transactiontype, quantity, actualcost, modifieddate
         """
    }
    q.query[TransactionhistoryarchiveRow].unique
  
  }
  override def selectAll: Stream[ConnectionIO, TransactionhistoryarchiveRow] = {
    sql"select transactionid, productid, referenceorderid, referenceorderlineid, transactiondate, transactiontype, quantity, actualcost, modifieddate from production.transactionhistoryarchive".query[TransactionhistoryarchiveRow].stream
  }
  override def selectById(transactionid: TransactionhistoryarchiveId): ConnectionIO[Option[TransactionhistoryarchiveRow]] = {
    sql"select transactionid, productid, referenceorderid, referenceorderlineid, transactiondate, transactiontype, quantity, actualcost, modifieddate from production.transactionhistoryarchive where transactionid = $transactionid".query[TransactionhistoryarchiveRow].option
  }
  override def selectByIds(transactionids: Array[TransactionhistoryarchiveId]): Stream[ConnectionIO, TransactionhistoryarchiveRow] = {
    sql"select transactionid, productid, referenceorderid, referenceorderlineid, transactiondate, transactiontype, quantity, actualcost, modifieddate from production.transactionhistoryarchive where transactionid = ANY($transactionids)".query[TransactionhistoryarchiveRow].stream
  }
  override def update(row: TransactionhistoryarchiveRow): ConnectionIO[Boolean] = {
    val transactionid = row.transactionid
    sql"""update production.transactionhistoryarchive
          set productid = ${row.productid}::int4,
              referenceorderid = ${row.referenceorderid}::int4,
              referenceorderlineid = ${row.referenceorderlineid}::int4,
              transactiondate = ${row.transactiondate}::timestamp,
              transactiontype = ${row.transactiontype}::bpchar,
              quantity = ${row.quantity}::int4,
              actualcost = ${row.actualcost}::numeric,
              modifieddate = ${row.modifieddate}::timestamp
          where transactionid = $transactionid
       """
      .update
      .run
      .map(_ > 0)
  }
  override def upsert(unsaved: TransactionhistoryarchiveRow): ConnectionIO[TransactionhistoryarchiveRow] = {
    sql"""insert into production.transactionhistoryarchive(transactionid, productid, referenceorderid, referenceorderlineid, transactiondate, transactiontype, quantity, actualcost, modifieddate)
          values (
            ${unsaved.transactionid}::int4,
            ${unsaved.productid}::int4,
            ${unsaved.referenceorderid}::int4,
            ${unsaved.referenceorderlineid}::int4,
            ${unsaved.transactiondate}::timestamp,
            ${unsaved.transactiontype}::bpchar,
            ${unsaved.quantity}::int4,
            ${unsaved.actualcost}::numeric,
            ${unsaved.modifieddate}::timestamp
          )
          on conflict (transactionid)
          do update set
            productid = EXCLUDED.productid,
            referenceorderid = EXCLUDED.referenceorderid,
            referenceorderlineid = EXCLUDED.referenceorderlineid,
            transactiondate = EXCLUDED.transactiondate,
            transactiontype = EXCLUDED.transactiontype,
            quantity = EXCLUDED.quantity,
            actualcost = EXCLUDED.actualcost,
            modifieddate = EXCLUDED.modifieddate
          returning transactionid, productid, referenceorderid, referenceorderlineid, transactiondate, transactiontype, quantity, actualcost, modifieddate
       """.query[TransactionhistoryarchiveRow].unique
  }
}
