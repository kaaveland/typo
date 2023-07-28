/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package productinventory

import adventureworks.Defaulted
import doobie.free.connection.ConnectionIO
import doobie.syntax.string.toSqlInterpolator
import doobie.util.fragment.Fragment
import fs2.Stream
import java.time.LocalDateTime
import java.util.UUID

object ProductinventoryRepoImpl extends ProductinventoryRepo {
  override def delete(compositeId: ProductinventoryId): ConnectionIO[Boolean] = {
    sql"delete from production.productinventory where productid = ${compositeId.productid} AND locationid = ${compositeId.locationid}".update.run.map(_ > 0)
  }
  override def insert(unsaved: ProductinventoryRow): ConnectionIO[ProductinventoryRow] = {
    sql"""insert into production.productinventory(productid, locationid, shelf, bin, quantity, rowguid, modifieddate)
          values (${unsaved.productid}::int4, ${unsaved.locationid}::int2, ${unsaved.shelf}, ${unsaved.bin}::int2, ${unsaved.quantity}::int2, ${unsaved.rowguid}::uuid, ${unsaved.modifieddate}::timestamp)
          returning productid, locationid, shelf, bin, quantity, rowguid, modifieddate
       """.query[ProductinventoryRow].unique
  }
  override def insert(unsaved: ProductinventoryRowUnsaved): ConnectionIO[ProductinventoryRow] = {
    val fs = List(
      Some((Fragment.const(s"productid"), fr"${unsaved.productid}::int4")),
      Some((Fragment.const(s"locationid"), fr"${unsaved.locationid}::int2")),
      Some((Fragment.const(s"shelf"), fr"${unsaved.shelf}")),
      Some((Fragment.const(s"bin"), fr"${unsaved.bin}::int2")),
      unsaved.quantity match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s"quantity"), fr"${value: Int}::int2"))
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
      sql"""insert into production.productinventory default values
            returning productid, locationid, shelf, bin, quantity, rowguid, modifieddate
         """
    } else {
      import cats.syntax.foldable.toFoldableOps
      sql"""insert into production.productinventory(${fs.map { case (n, _) => n }.intercalate(fr", ")})
            values (${fs.map { case (_, f) => f }.intercalate(fr", ")})
            returning productid, locationid, shelf, bin, quantity, rowguid, modifieddate
         """
    }
    q.query[ProductinventoryRow].unique
  
  }
  override def selectAll: Stream[ConnectionIO, ProductinventoryRow] = {
    sql"select productid, locationid, shelf, bin, quantity, rowguid, modifieddate from production.productinventory".query[ProductinventoryRow].stream
  }
  override def selectById(compositeId: ProductinventoryId): ConnectionIO[Option[ProductinventoryRow]] = {
    sql"select productid, locationid, shelf, bin, quantity, rowguid, modifieddate from production.productinventory where productid = ${compositeId.productid} AND locationid = ${compositeId.locationid}".query[ProductinventoryRow].option
  }
  override def update(row: ProductinventoryRow): ConnectionIO[Boolean] = {
    val compositeId = row.compositeId
    sql"""update production.productinventory
          set shelf = ${row.shelf},
              bin = ${row.bin}::int2,
              quantity = ${row.quantity}::int2,
              rowguid = ${row.rowguid}::uuid,
              modifieddate = ${row.modifieddate}::timestamp
          where productid = ${compositeId.productid} AND locationid = ${compositeId.locationid}
       """
      .update
      .run
      .map(_ > 0)
  }
  override def upsert(unsaved: ProductinventoryRow): ConnectionIO[ProductinventoryRow] = {
    sql"""insert into production.productinventory(productid, locationid, shelf, bin, quantity, rowguid, modifieddate)
          values (
            ${unsaved.productid}::int4,
            ${unsaved.locationid}::int2,
            ${unsaved.shelf},
            ${unsaved.bin}::int2,
            ${unsaved.quantity}::int2,
            ${unsaved.rowguid}::uuid,
            ${unsaved.modifieddate}::timestamp
          )
          on conflict (productid, locationid)
          do update set
            shelf = EXCLUDED.shelf,
            bin = EXCLUDED.bin,
            quantity = EXCLUDED.quantity,
            rowguid = EXCLUDED.rowguid,
            modifieddate = EXCLUDED.modifieddate
          returning productid, locationid, shelf, bin, quantity, rowguid, modifieddate
       """.query[ProductinventoryRow].unique
  }
}
