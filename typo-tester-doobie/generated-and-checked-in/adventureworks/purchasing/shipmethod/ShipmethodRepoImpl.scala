/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package purchasing
package shipmethod

import adventureworks.customtypes.Defaulted
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.public.Name
import doobie.free.connection.ConnectionIO
import doobie.syntax.SqlInterpolator.SingleFragment.fromWrite
import doobie.syntax.string.toSqlInterpolator
import doobie.util.Write
import doobie.util.fragment.Fragment
import doobie.util.meta.Meta
import fs2.Stream
import java.util.UUID
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql
import typo.dsl.UpdateBuilder

object ShipmethodRepoImpl extends ShipmethodRepo {
  override def delete(shipmethodid: ShipmethodId): ConnectionIO[Boolean] = {
    sql"delete from purchasing.shipmethod where shipmethodid = ${fromWrite(shipmethodid)(Write.fromPut(ShipmethodId.put))}".update.run.map(_ > 0)
  }
  override def delete: DeleteBuilder[ShipmethodFields, ShipmethodRow] = {
    DeleteBuilder("purchasing.shipmethod", ShipmethodFields)
  }
  override def insert(unsaved: ShipmethodRow): ConnectionIO[ShipmethodRow] = {
    sql"""insert into purchasing.shipmethod(shipmethodid, "name", shipbase, shiprate, rowguid, modifieddate)
          values (${fromWrite(unsaved.shipmethodid)(Write.fromPut(ShipmethodId.put))}::int4, ${fromWrite(unsaved.name)(Write.fromPut(Name.put))}::varchar, ${fromWrite(unsaved.shipbase)(Write.fromPut(Meta.ScalaBigDecimalMeta.put))}::numeric, ${fromWrite(unsaved.shiprate)(Write.fromPut(Meta.ScalaBigDecimalMeta.put))}::numeric, ${fromWrite(unsaved.rowguid)(Write.fromPut(adventureworks.UUIDMeta.put))}::uuid, ${fromWrite(unsaved.modifieddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp)
          returning shipmethodid, "name", shipbase, shiprate, rowguid, modifieddate::text
       """.query(ShipmethodRow.read).unique
  }
  override def insert(unsaved: ShipmethodRowUnsaved): ConnectionIO[ShipmethodRow] = {
    val fs = List(
      Some((Fragment.const(s""""name""""), fr"${fromWrite(unsaved.name)(Write.fromPut(Name.put))}::varchar")),
      unsaved.shipmethodid match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s"shipmethodid"), fr"${fromWrite(value: ShipmethodId)(Write.fromPut(ShipmethodId.put))}::int4"))
      },
      unsaved.shipbase match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s"shipbase"), fr"${fromWrite(value: BigDecimal)(Write.fromPut(Meta.ScalaBigDecimalMeta.put))}::numeric"))
      },
      unsaved.shiprate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s"shiprate"), fr"${fromWrite(value: BigDecimal)(Write.fromPut(Meta.ScalaBigDecimalMeta.put))}::numeric"))
      },
      unsaved.rowguid match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s"rowguid"), fr"${fromWrite(value: UUID)(Write.fromPut(adventureworks.UUIDMeta.put))}::uuid"))
      },
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s"modifieddate"), fr"${fromWrite(value: TypoLocalDateTime)(Write.fromPut(TypoLocalDateTime.put))}::timestamp"))
      }
    ).flatten
    
    val q = if (fs.isEmpty) {
      sql"""insert into purchasing.shipmethod default values
            returning shipmethodid, "name", shipbase, shiprate, rowguid, modifieddate::text
         """
    } else {
      import cats.syntax.foldable.toFoldableOps
      sql"""insert into purchasing.shipmethod(${fs.map { case (n, _) => n }.intercalate(fr", ")})
            values (${fs.map { case (_, f) => f }.intercalate(fr", ")})
            returning shipmethodid, "name", shipbase, shiprate, rowguid, modifieddate::text
         """
    }
    q.query(ShipmethodRow.read).unique
    
  }
  override def select: SelectBuilder[ShipmethodFields, ShipmethodRow] = {
    SelectBuilderSql("purchasing.shipmethod", ShipmethodFields, ShipmethodRow.read)
  }
  override def selectAll: Stream[ConnectionIO, ShipmethodRow] = {
    sql"""select shipmethodid, "name", shipbase, shiprate, rowguid, modifieddate::text from purchasing.shipmethod""".query(ShipmethodRow.read).stream
  }
  override def selectById(shipmethodid: ShipmethodId): ConnectionIO[Option[ShipmethodRow]] = {
    sql"""select shipmethodid, "name", shipbase, shiprate, rowguid, modifieddate::text from purchasing.shipmethod where shipmethodid = ${fromWrite(shipmethodid)(Write.fromPut(ShipmethodId.put))}""".query(ShipmethodRow.read).option
  }
  override def selectByIds(shipmethodids: Array[ShipmethodId]): Stream[ConnectionIO, ShipmethodRow] = {
    sql"""select shipmethodid, "name", shipbase, shiprate, rowguid, modifieddate::text from purchasing.shipmethod where shipmethodid = ANY(${shipmethodids})""".query(ShipmethodRow.read).stream
  }
  override def update(row: ShipmethodRow): ConnectionIO[Boolean] = {
    val shipmethodid = row.shipmethodid
    sql"""update purchasing.shipmethod
          set "name" = ${fromWrite(row.name)(Write.fromPut(Name.put))}::varchar,
              shipbase = ${fromWrite(row.shipbase)(Write.fromPut(Meta.ScalaBigDecimalMeta.put))}::numeric,
              shiprate = ${fromWrite(row.shiprate)(Write.fromPut(Meta.ScalaBigDecimalMeta.put))}::numeric,
              rowguid = ${fromWrite(row.rowguid)(Write.fromPut(adventureworks.UUIDMeta.put))}::uuid,
              modifieddate = ${fromWrite(row.modifieddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp
          where shipmethodid = ${fromWrite(shipmethodid)(Write.fromPut(ShipmethodId.put))}"""
      .update
      .run
      .map(_ > 0)
  }
  override def update: UpdateBuilder[ShipmethodFields, ShipmethodRow] = {
    UpdateBuilder("purchasing.shipmethod", ShipmethodFields, ShipmethodRow.read)
  }
  override def upsert(unsaved: ShipmethodRow): ConnectionIO[ShipmethodRow] = {
    sql"""insert into purchasing.shipmethod(shipmethodid, "name", shipbase, shiprate, rowguid, modifieddate)
          values (
            ${fromWrite(unsaved.shipmethodid)(Write.fromPut(ShipmethodId.put))}::int4,
            ${fromWrite(unsaved.name)(Write.fromPut(Name.put))}::varchar,
            ${fromWrite(unsaved.shipbase)(Write.fromPut(Meta.ScalaBigDecimalMeta.put))}::numeric,
            ${fromWrite(unsaved.shiprate)(Write.fromPut(Meta.ScalaBigDecimalMeta.put))}::numeric,
            ${fromWrite(unsaved.rowguid)(Write.fromPut(adventureworks.UUIDMeta.put))}::uuid,
            ${fromWrite(unsaved.modifieddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp
          )
          on conflict (shipmethodid)
          do update set
            "name" = EXCLUDED."name",
            shipbase = EXCLUDED.shipbase,
            shiprate = EXCLUDED.shiprate,
            rowguid = EXCLUDED.rowguid,
            modifieddate = EXCLUDED.modifieddate
          returning shipmethodid, "name", shipbase, shiprate, rowguid, modifieddate::text
       """.query(ShipmethodRow.read).unique
  }
}
