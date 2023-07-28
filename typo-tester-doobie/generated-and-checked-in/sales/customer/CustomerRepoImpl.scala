/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package customer

import adventureworks.Defaulted
import doobie.free.connection.ConnectionIO
import doobie.syntax.string.toSqlInterpolator
import doobie.util.fragment.Fragment
import fs2.Stream
import java.time.LocalDateTime
import java.util.UUID

object CustomerRepoImpl extends CustomerRepo {
  override def delete(customerid: CustomerId): ConnectionIO[Boolean] = {
    sql"delete from sales.customer where customerid = $customerid".update.run.map(_ > 0)
  }
  override def insert(unsaved: CustomerRow): ConnectionIO[CustomerRow] = {
    sql"""insert into sales.customer(customerid, personid, storeid, territoryid, rowguid, modifieddate)
          values (${unsaved.customerid}::int4, ${unsaved.personid}::int4, ${unsaved.storeid}::int4, ${unsaved.territoryid}::int4, ${unsaved.rowguid}::uuid, ${unsaved.modifieddate}::timestamp)
          returning customerid, personid, storeid, territoryid, rowguid, modifieddate
       """.query[CustomerRow].unique
  }
  override def insert(unsaved: CustomerRowUnsaved): ConnectionIO[CustomerRow] = {
    val fs = List(
      Some((Fragment.const(s"personid"), fr"${unsaved.personid}::int4")),
      Some((Fragment.const(s"storeid"), fr"${unsaved.storeid}::int4")),
      Some((Fragment.const(s"territoryid"), fr"${unsaved.territoryid}::int4")),
      unsaved.customerid match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s"customerid"), fr"${value: CustomerId}::int4"))
      },
      unsaved.rowguid match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s"rowguid"), fr"${value: UUID}::uuid"))
      },
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s"modifieddate"), fr"${value: LocalDateTime}::timestamp"))
      }
    ).flatten
    
    val q = if (fs.isEmpty) {
      sql"""insert into sales.customer default values
            returning customerid, personid, storeid, territoryid, rowguid, modifieddate
         """
    } else {
      import cats.syntax.foldable.toFoldableOps
      sql"""insert into sales.customer(${fs.map { case (n, _) => n }.intercalate(fr", ")})
            values (${fs.map { case (_, f) => f }.intercalate(fr", ")})
            returning customerid, personid, storeid, territoryid, rowguid, modifieddate
         """
    }
    q.query[CustomerRow].unique
  
  }
  override def selectAll: Stream[ConnectionIO, CustomerRow] = {
    sql"select customerid, personid, storeid, territoryid, rowguid, modifieddate from sales.customer".query[CustomerRow].stream
  }
  override def selectById(customerid: CustomerId): ConnectionIO[Option[CustomerRow]] = {
    sql"select customerid, personid, storeid, territoryid, rowguid, modifieddate from sales.customer where customerid = $customerid".query[CustomerRow].option
  }
  override def selectByIds(customerids: Array[CustomerId]): Stream[ConnectionIO, CustomerRow] = {
    sql"select customerid, personid, storeid, territoryid, rowguid, modifieddate from sales.customer where customerid = ANY($customerids)".query[CustomerRow].stream
  }
  override def update(row: CustomerRow): ConnectionIO[Boolean] = {
    val customerid = row.customerid
    sql"""update sales.customer
          set personid = ${row.personid}::int4,
              storeid = ${row.storeid}::int4,
              territoryid = ${row.territoryid}::int4,
              rowguid = ${row.rowguid}::uuid,
              modifieddate = ${row.modifieddate}::timestamp
          where customerid = $customerid
       """
      .update
      .run
      .map(_ > 0)
  }
  override def upsert(unsaved: CustomerRow): ConnectionIO[CustomerRow] = {
    sql"""insert into sales.customer(customerid, personid, storeid, territoryid, rowguid, modifieddate)
          values (
            ${unsaved.customerid}::int4,
            ${unsaved.personid}::int4,
            ${unsaved.storeid}::int4,
            ${unsaved.territoryid}::int4,
            ${unsaved.rowguid}::uuid,
            ${unsaved.modifieddate}::timestamp
          )
          on conflict (customerid)
          do update set
            personid = EXCLUDED.personid,
            storeid = EXCLUDED.storeid,
            territoryid = EXCLUDED.territoryid,
            rowguid = EXCLUDED.rowguid,
            modifieddate = EXCLUDED.modifieddate
          returning customerid, personid, storeid, territoryid, rowguid, modifieddate
       """.query[CustomerRow].unique
  }
}
