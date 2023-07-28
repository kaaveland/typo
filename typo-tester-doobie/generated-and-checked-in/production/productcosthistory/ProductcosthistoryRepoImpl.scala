/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package productcosthistory

import adventureworks.Defaulted
import doobie.free.connection.ConnectionIO
import doobie.syntax.string.toSqlInterpolator
import doobie.util.fragment.Fragment
import fs2.Stream
import java.time.LocalDateTime

object ProductcosthistoryRepoImpl extends ProductcosthistoryRepo {
  override def delete(compositeId: ProductcosthistoryId): ConnectionIO[Boolean] = {
    sql"delete from production.productcosthistory where productid = ${compositeId.productid} AND startdate = ${compositeId.startdate}".update.run.map(_ > 0)
  }
  override def insert(unsaved: ProductcosthistoryRow): ConnectionIO[ProductcosthistoryRow] = {
    sql"""insert into production.productcosthistory(productid, startdate, enddate, standardcost, modifieddate)
          values (${unsaved.productid}::int4, ${unsaved.startdate}::timestamp, ${unsaved.enddate}::timestamp, ${unsaved.standardcost}::numeric, ${unsaved.modifieddate}::timestamp)
          returning productid, startdate, enddate, standardcost, modifieddate
       """.query[ProductcosthistoryRow].unique
  }
  override def insert(unsaved: ProductcosthistoryRowUnsaved): ConnectionIO[ProductcosthistoryRow] = {
    val fs = List(
      Some((Fragment.const(s"productid"), fr"${unsaved.productid}::int4")),
      Some((Fragment.const(s"startdate"), fr"${unsaved.startdate}::timestamp")),
      Some((Fragment.const(s"enddate"), fr"${unsaved.enddate}::timestamp")),
      Some((Fragment.const(s"standardcost"), fr"${unsaved.standardcost}::numeric")),
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s"modifieddate"), fr"${value: LocalDateTime}::timestamp"))
      }
    ).flatten
    
    val q = if (fs.isEmpty) {
      sql"""insert into production.productcosthistory default values
            returning productid, startdate, enddate, standardcost, modifieddate
         """
    } else {
      import cats.syntax.foldable.toFoldableOps
      sql"""insert into production.productcosthistory(${fs.map { case (n, _) => n }.intercalate(fr", ")})
            values (${fs.map { case (_, f) => f }.intercalate(fr", ")})
            returning productid, startdate, enddate, standardcost, modifieddate
         """
    }
    q.query[ProductcosthistoryRow].unique
  
  }
  override def selectAll: Stream[ConnectionIO, ProductcosthistoryRow] = {
    sql"select productid, startdate, enddate, standardcost, modifieddate from production.productcosthistory".query[ProductcosthistoryRow].stream
  }
  override def selectById(compositeId: ProductcosthistoryId): ConnectionIO[Option[ProductcosthistoryRow]] = {
    sql"select productid, startdate, enddate, standardcost, modifieddate from production.productcosthistory where productid = ${compositeId.productid} AND startdate = ${compositeId.startdate}".query[ProductcosthistoryRow].option
  }
  override def update(row: ProductcosthistoryRow): ConnectionIO[Boolean] = {
    val compositeId = row.compositeId
    sql"""update production.productcosthistory
          set enddate = ${row.enddate}::timestamp,
              standardcost = ${row.standardcost}::numeric,
              modifieddate = ${row.modifieddate}::timestamp
          where productid = ${compositeId.productid} AND startdate = ${compositeId.startdate}
       """
      .update
      .run
      .map(_ > 0)
  }
  override def upsert(unsaved: ProductcosthistoryRow): ConnectionIO[ProductcosthistoryRow] = {
    sql"""insert into production.productcosthistory(productid, startdate, enddate, standardcost, modifieddate)
          values (
            ${unsaved.productid}::int4,
            ${unsaved.startdate}::timestamp,
            ${unsaved.enddate}::timestamp,
            ${unsaved.standardcost}::numeric,
            ${unsaved.modifieddate}::timestamp
          )
          on conflict (productid, startdate)
          do update set
            enddate = EXCLUDED.enddate,
            standardcost = EXCLUDED.standardcost,
            modifieddate = EXCLUDED.modifieddate
          returning productid, startdate, enddate, standardcost, modifieddate
       """.query[ProductcosthistoryRow].unique
  }
}
