/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package location

import adventureworks.Defaulted
import doobie.free.connection.ConnectionIO
import doobie.syntax.string.toSqlInterpolator
import doobie.util.fragment.Fragment
import fs2.Stream
import java.time.LocalDateTime

object LocationRepoImpl extends LocationRepo {
  override def delete(locationid: LocationId): ConnectionIO[Boolean] = {
    sql"""delete from production."location" where locationid = $locationid""".update.run.map(_ > 0)
  }
  override def insert(unsaved: LocationRow): ConnectionIO[LocationRow] = {
    sql"""insert into production."location"(locationid, "name", costrate, availability, modifieddate)
          values (${unsaved.locationid}::int4, ${unsaved.name}::"public"."Name", ${unsaved.costrate}::numeric, ${unsaved.availability}::numeric, ${unsaved.modifieddate}::timestamp)
          returning locationid, "name", costrate, availability, modifieddate
       """.query[LocationRow].unique
  }
  override def insert(unsaved: LocationRowUnsaved): ConnectionIO[LocationRow] = {
    val fs = List(
      Some((Fragment.const(s""""name""""), fr"""${unsaved.name}::"public"."Name"""")),
      unsaved.locationid match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s"locationid"), fr"${value: LocationId}::int4"))
      },
      unsaved.costrate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s"costrate"), fr"${value: BigDecimal}::numeric"))
      },
      unsaved.availability match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s"availability"), fr"${value: BigDecimal}::numeric"))
      },
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s"modifieddate"), fr"${value: LocalDateTime}::timestamp"))
      }
    ).flatten
    
    val q = if (fs.isEmpty) {
      sql"""insert into production."location" default values
            returning locationid, "name", costrate, availability, modifieddate
         """
    } else {
      import cats.syntax.foldable.toFoldableOps
      sql"""insert into production."location"(${fs.map { case (n, _) => n }.intercalate(fr", ")})
            values (${fs.map { case (_, f) => f }.intercalate(fr", ")})
            returning locationid, "name", costrate, availability, modifieddate
         """
    }
    q.query[LocationRow].unique
  
  }
  override def selectAll: Stream[ConnectionIO, LocationRow] = {
    sql"""select locationid, "name", costrate, availability, modifieddate from production."location"""".query[LocationRow].stream
  }
  override def selectById(locationid: LocationId): ConnectionIO[Option[LocationRow]] = {
    sql"""select locationid, "name", costrate, availability, modifieddate from production."location" where locationid = $locationid""".query[LocationRow].option
  }
  override def selectByIds(locationids: Array[LocationId]): Stream[ConnectionIO, LocationRow] = {
    sql"""select locationid, "name", costrate, availability, modifieddate from production."location" where locationid = ANY($locationids)""".query[LocationRow].stream
  }
  override def update(row: LocationRow): ConnectionIO[Boolean] = {
    val locationid = row.locationid
    sql"""update production."location"
          set "name" = ${row.name}::"public"."Name",
              costrate = ${row.costrate}::numeric,
              availability = ${row.availability}::numeric,
              modifieddate = ${row.modifieddate}::timestamp
          where locationid = $locationid
       """
      .update
      .run
      .map(_ > 0)
  }
  override def upsert(unsaved: LocationRow): ConnectionIO[LocationRow] = {
    sql"""insert into production."location"(locationid, "name", costrate, availability, modifieddate)
          values (
            ${unsaved.locationid}::int4,
            ${unsaved.name}::"public"."Name",
            ${unsaved.costrate}::numeric,
            ${unsaved.availability}::numeric,
            ${unsaved.modifieddate}::timestamp
          )
          on conflict (locationid)
          do update set
            "name" = EXCLUDED."name",
            costrate = EXCLUDED.costrate,
            availability = EXCLUDED.availability,
            modifieddate = EXCLUDED.modifieddate
          returning locationid, "name", costrate, availability, modifieddate
       """.query[LocationRow].unique
  }
}
