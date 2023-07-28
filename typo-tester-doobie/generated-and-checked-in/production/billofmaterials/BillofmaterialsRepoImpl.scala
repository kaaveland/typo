/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package billofmaterials

import adventureworks.Defaulted
import doobie.free.connection.ConnectionIO
import doobie.syntax.string.toSqlInterpolator
import doobie.util.fragment.Fragment
import fs2.Stream
import java.time.LocalDateTime

object BillofmaterialsRepoImpl extends BillofmaterialsRepo {
  override def delete(billofmaterialsid: BillofmaterialsId): ConnectionIO[Boolean] = {
    sql"delete from production.billofmaterials where billofmaterialsid = $billofmaterialsid".update.run.map(_ > 0)
  }
  override def insert(unsaved: BillofmaterialsRow): ConnectionIO[BillofmaterialsRow] = {
    sql"""insert into production.billofmaterials(billofmaterialsid, productassemblyid, componentid, startdate, enddate, unitmeasurecode, bomlevel, perassemblyqty, modifieddate)
          values (${unsaved.billofmaterialsid}::int4, ${unsaved.productassemblyid}::int4, ${unsaved.componentid}::int4, ${unsaved.startdate}::timestamp, ${unsaved.enddate}::timestamp, ${unsaved.unitmeasurecode}::bpchar, ${unsaved.bomlevel}::int2, ${unsaved.perassemblyqty}::numeric, ${unsaved.modifieddate}::timestamp)
          returning billofmaterialsid, productassemblyid, componentid, startdate, enddate, unitmeasurecode, bomlevel, perassemblyqty, modifieddate
       """.query[BillofmaterialsRow].unique
  }
  override def insert(unsaved: BillofmaterialsRowUnsaved): ConnectionIO[BillofmaterialsRow] = {
    val fs = List(
      Some((Fragment.const(s"productassemblyid"), fr"${unsaved.productassemblyid}::int4")),
      Some((Fragment.const(s"componentid"), fr"${unsaved.componentid}::int4")),
      Some((Fragment.const(s"enddate"), fr"${unsaved.enddate}::timestamp")),
      Some((Fragment.const(s"unitmeasurecode"), fr"${unsaved.unitmeasurecode}::bpchar")),
      Some((Fragment.const(s"bomlevel"), fr"${unsaved.bomlevel}::int2")),
      unsaved.billofmaterialsid match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s"billofmaterialsid"), fr"${value: BillofmaterialsId}::int4"))
      },
      unsaved.startdate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s"startdate"), fr"${value: LocalDateTime}::timestamp"))
      },
      unsaved.perassemblyqty match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s"perassemblyqty"), fr"${value: BigDecimal}::numeric"))
      },
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s"modifieddate"), fr"${value: LocalDateTime}::timestamp"))
      }
    ).flatten
    
    val q = if (fs.isEmpty) {
      sql"""insert into production.billofmaterials default values
            returning billofmaterialsid, productassemblyid, componentid, startdate, enddate, unitmeasurecode, bomlevel, perassemblyqty, modifieddate
         """
    } else {
      import cats.syntax.foldable.toFoldableOps
      sql"""insert into production.billofmaterials(${fs.map { case (n, _) => n }.intercalate(fr", ")})
            values (${fs.map { case (_, f) => f }.intercalate(fr", ")})
            returning billofmaterialsid, productassemblyid, componentid, startdate, enddate, unitmeasurecode, bomlevel, perassemblyqty, modifieddate
         """
    }
    q.query[BillofmaterialsRow].unique
  
  }
  override def selectAll: Stream[ConnectionIO, BillofmaterialsRow] = {
    sql"select billofmaterialsid, productassemblyid, componentid, startdate, enddate, unitmeasurecode, bomlevel, perassemblyqty, modifieddate from production.billofmaterials".query[BillofmaterialsRow].stream
  }
  override def selectById(billofmaterialsid: BillofmaterialsId): ConnectionIO[Option[BillofmaterialsRow]] = {
    sql"select billofmaterialsid, productassemblyid, componentid, startdate, enddate, unitmeasurecode, bomlevel, perassemblyqty, modifieddate from production.billofmaterials where billofmaterialsid = $billofmaterialsid".query[BillofmaterialsRow].option
  }
  override def selectByIds(billofmaterialsids: Array[BillofmaterialsId]): Stream[ConnectionIO, BillofmaterialsRow] = {
    sql"select billofmaterialsid, productassemblyid, componentid, startdate, enddate, unitmeasurecode, bomlevel, perassemblyqty, modifieddate from production.billofmaterials where billofmaterialsid = ANY($billofmaterialsids)".query[BillofmaterialsRow].stream
  }
  override def update(row: BillofmaterialsRow): ConnectionIO[Boolean] = {
    val billofmaterialsid = row.billofmaterialsid
    sql"""update production.billofmaterials
          set productassemblyid = ${row.productassemblyid}::int4,
              componentid = ${row.componentid}::int4,
              startdate = ${row.startdate}::timestamp,
              enddate = ${row.enddate}::timestamp,
              unitmeasurecode = ${row.unitmeasurecode}::bpchar,
              bomlevel = ${row.bomlevel}::int2,
              perassemblyqty = ${row.perassemblyqty}::numeric,
              modifieddate = ${row.modifieddate}::timestamp
          where billofmaterialsid = $billofmaterialsid
       """
      .update
      .run
      .map(_ > 0)
  }
  override def upsert(unsaved: BillofmaterialsRow): ConnectionIO[BillofmaterialsRow] = {
    sql"""insert into production.billofmaterials(billofmaterialsid, productassemblyid, componentid, startdate, enddate, unitmeasurecode, bomlevel, perassemblyqty, modifieddate)
          values (
            ${unsaved.billofmaterialsid}::int4,
            ${unsaved.productassemblyid}::int4,
            ${unsaved.componentid}::int4,
            ${unsaved.startdate}::timestamp,
            ${unsaved.enddate}::timestamp,
            ${unsaved.unitmeasurecode}::bpchar,
            ${unsaved.bomlevel}::int2,
            ${unsaved.perassemblyqty}::numeric,
            ${unsaved.modifieddate}::timestamp
          )
          on conflict (billofmaterialsid)
          do update set
            productassemblyid = EXCLUDED.productassemblyid,
            componentid = EXCLUDED.componentid,
            startdate = EXCLUDED.startdate,
            enddate = EXCLUDED.enddate,
            unitmeasurecode = EXCLUDED.unitmeasurecode,
            bomlevel = EXCLUDED.bomlevel,
            perassemblyqty = EXCLUDED.perassemblyqty,
            modifieddate = EXCLUDED.modifieddate
          returning billofmaterialsid, productassemblyid, componentid, startdate, enddate, unitmeasurecode, bomlevel, perassemblyqty, modifieddate
       """.query[BillofmaterialsRow].unique
  }
}
