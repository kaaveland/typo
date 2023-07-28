/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package salestaxrate

import adventureworks.Defaulted
import doobie.free.connection.ConnectionIO
import doobie.syntax.string.toSqlInterpolator
import doobie.util.fragment.Fragment
import fs2.Stream
import java.time.LocalDateTime
import java.util.UUID

object SalestaxrateRepoImpl extends SalestaxrateRepo {
  override def delete(salestaxrateid: SalestaxrateId): ConnectionIO[Boolean] = {
    sql"delete from sales.salestaxrate where salestaxrateid = $salestaxrateid".update.run.map(_ > 0)
  }
  override def insert(unsaved: SalestaxrateRow): ConnectionIO[SalestaxrateRow] = {
    sql"""insert into sales.salestaxrate(salestaxrateid, stateprovinceid, taxtype, taxrate, "name", rowguid, modifieddate)
          values (${unsaved.salestaxrateid}::int4, ${unsaved.stateprovinceid}::int4, ${unsaved.taxtype}::int2, ${unsaved.taxrate}::numeric, ${unsaved.name}::"public"."Name", ${unsaved.rowguid}::uuid, ${unsaved.modifieddate}::timestamp)
          returning salestaxrateid, stateprovinceid, taxtype, taxrate, "name", rowguid, modifieddate
       """.query[SalestaxrateRow].unique
  }
  override def insert(unsaved: SalestaxrateRowUnsaved): ConnectionIO[SalestaxrateRow] = {
    val fs = List(
      Some((Fragment.const(s"stateprovinceid"), fr"${unsaved.stateprovinceid}::int4")),
      Some((Fragment.const(s"taxtype"), fr"${unsaved.taxtype}::int2")),
      Some((Fragment.const(s""""name""""), fr"""${unsaved.name}::"public"."Name"""")),
      unsaved.salestaxrateid match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s"salestaxrateid"), fr"${value: SalestaxrateId}::int4"))
      },
      unsaved.taxrate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s"taxrate"), fr"${value: BigDecimal}::numeric"))
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
      sql"""insert into sales.salestaxrate default values
            returning salestaxrateid, stateprovinceid, taxtype, taxrate, "name", rowguid, modifieddate
         """
    } else {
      import cats.syntax.foldable.toFoldableOps
      sql"""insert into sales.salestaxrate(${fs.map { case (n, _) => n }.intercalate(fr", ")})
            values (${fs.map { case (_, f) => f }.intercalate(fr", ")})
            returning salestaxrateid, stateprovinceid, taxtype, taxrate, "name", rowguid, modifieddate
         """
    }
    q.query[SalestaxrateRow].unique
  
  }
  override def selectAll: Stream[ConnectionIO, SalestaxrateRow] = {
    sql"""select salestaxrateid, stateprovinceid, taxtype, taxrate, "name", rowguid, modifieddate from sales.salestaxrate""".query[SalestaxrateRow].stream
  }
  override def selectById(salestaxrateid: SalestaxrateId): ConnectionIO[Option[SalestaxrateRow]] = {
    sql"""select salestaxrateid, stateprovinceid, taxtype, taxrate, "name", rowguid, modifieddate from sales.salestaxrate where salestaxrateid = $salestaxrateid""".query[SalestaxrateRow].option
  }
  override def selectByIds(salestaxrateids: Array[SalestaxrateId]): Stream[ConnectionIO, SalestaxrateRow] = {
    sql"""select salestaxrateid, stateprovinceid, taxtype, taxrate, "name", rowguid, modifieddate from sales.salestaxrate where salestaxrateid = ANY($salestaxrateids)""".query[SalestaxrateRow].stream
  }
  override def update(row: SalestaxrateRow): ConnectionIO[Boolean] = {
    val salestaxrateid = row.salestaxrateid
    sql"""update sales.salestaxrate
          set stateprovinceid = ${row.stateprovinceid}::int4,
              taxtype = ${row.taxtype}::int2,
              taxrate = ${row.taxrate}::numeric,
              "name" = ${row.name}::"public"."Name",
              rowguid = ${row.rowguid}::uuid,
              modifieddate = ${row.modifieddate}::timestamp
          where salestaxrateid = $salestaxrateid
       """
      .update
      .run
      .map(_ > 0)
  }
  override def upsert(unsaved: SalestaxrateRow): ConnectionIO[SalestaxrateRow] = {
    sql"""insert into sales.salestaxrate(salestaxrateid, stateprovinceid, taxtype, taxrate, "name", rowguid, modifieddate)
          values (
            ${unsaved.salestaxrateid}::int4,
            ${unsaved.stateprovinceid}::int4,
            ${unsaved.taxtype}::int2,
            ${unsaved.taxrate}::numeric,
            ${unsaved.name}::"public"."Name",
            ${unsaved.rowguid}::uuid,
            ${unsaved.modifieddate}::timestamp
          )
          on conflict (salestaxrateid)
          do update set
            stateprovinceid = EXCLUDED.stateprovinceid,
            taxtype = EXCLUDED.taxtype,
            taxrate = EXCLUDED.taxrate,
            "name" = EXCLUDED."name",
            rowguid = EXCLUDED.rowguid,
            modifieddate = EXCLUDED.modifieddate
          returning salestaxrateid, stateprovinceid, taxtype, taxrate, "name", rowguid, modifieddate
       """.query[SalestaxrateRow].unique
  }
}
