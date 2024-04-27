/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package productinventory

import adventureworks.customtypes.Defaulted
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoShort
import adventureworks.customtypes.TypoUUID
import adventureworks.production.location.LocationId
import adventureworks.production.product.ProductId
import doobie.free.connection.ConnectionIO
import doobie.postgres.syntax.FragmentOps
import doobie.syntax.SqlInterpolator.SingleFragment.fromWrite
import doobie.syntax.string.toSqlInterpolator
import doobie.util.Write
import doobie.util.fragment.Fragment
import doobie.util.meta.Meta
import fs2.Stream
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql
import typo.dsl.UpdateBuilder

class ProductinventoryRepoImpl extends ProductinventoryRepo {
  override def delete: DeleteBuilder[ProductinventoryFields, ProductinventoryRow] = {
    DeleteBuilder("production.productinventory", ProductinventoryFields.structure)
  }
  override def deleteById(compositeId: ProductinventoryId): ConnectionIO[Boolean] = {
    sql"""delete from production.productinventory where "productid" = ${fromWrite(compositeId.productid)(Write.fromPut(ProductId.put))} AND "locationid" = ${fromWrite(compositeId.locationid)(Write.fromPut(LocationId.put))}""".update.run.map(_ > 0)
  }
  override def deleteByIds(compositeIds: Array[ProductinventoryId]): ConnectionIO[Int] = {
    val productid = compositeIds.map(_.productid)
    val locationid = compositeIds.map(_.locationid)
    sql"""delete
          from production.productinventory
          where ("productid", "locationid")
          in (select unnest(${productid}), unnest(${locationid}))
       """.update.run
    
  }
  override def insert(unsaved: ProductinventoryRow): ConnectionIO[ProductinventoryRow] = {
    sql"""insert into production.productinventory("productid", "locationid", "shelf", "bin", "quantity", "rowguid", "modifieddate")
          values (${fromWrite(unsaved.productid)(Write.fromPut(ProductId.put))}::int4, ${fromWrite(unsaved.locationid)(Write.fromPut(LocationId.put))}::int2, ${fromWrite(unsaved.shelf)(Write.fromPut(Meta.StringMeta.put))}, ${fromWrite(unsaved.bin)(Write.fromPut(TypoShort.put))}::int2, ${fromWrite(unsaved.quantity)(Write.fromPut(TypoShort.put))}::int2, ${fromWrite(unsaved.rowguid)(Write.fromPut(TypoUUID.put))}::uuid, ${fromWrite(unsaved.modifieddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp)
          returning "productid", "locationid", "shelf", "bin", "quantity", "rowguid", "modifieddate"::text
       """.query(using ProductinventoryRow.read).unique
  }
  override def insert(unsaved: ProductinventoryRowUnsaved): ConnectionIO[ProductinventoryRow] = {
    val fs = List(
      Some((Fragment.const(s""""productid""""), fr"${fromWrite(unsaved.productid)(Write.fromPut(ProductId.put))}::int4")),
      Some((Fragment.const(s""""locationid""""), fr"${fromWrite(unsaved.locationid)(Write.fromPut(LocationId.put))}::int2")),
      Some((Fragment.const(s""""shelf""""), fr"${fromWrite(unsaved.shelf)(Write.fromPut(Meta.StringMeta.put))}")),
      Some((Fragment.const(s""""bin""""), fr"${fromWrite(unsaved.bin)(Write.fromPut(TypoShort.put))}::int2")),
      unsaved.quantity match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s""""quantity""""), fr"${fromWrite(value: TypoShort)(Write.fromPut(TypoShort.put))}::int2"))
      },
      unsaved.rowguid match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s""""rowguid""""), fr"${fromWrite(value: TypoUUID)(Write.fromPut(TypoUUID.put))}::uuid"))
      },
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s""""modifieddate""""), fr"${fromWrite(value: TypoLocalDateTime)(Write.fromPut(TypoLocalDateTime.put))}::timestamp"))
      }
    ).flatten
    
    val q = if (fs.isEmpty) {
      sql"""insert into production.productinventory default values
            returning "productid", "locationid", "shelf", "bin", "quantity", "rowguid", "modifieddate"::text
         """
    } else {
      val CommaSeparate = Fragment.FragmentMonoid.intercalate(fr", ")
      sql"""insert into production.productinventory(${CommaSeparate.combineAllOption(fs.map { case (n, _) => n }).get})
            values (${CommaSeparate.combineAllOption(fs.map { case (_, f) => f }).get})
            returning "productid", "locationid", "shelf", "bin", "quantity", "rowguid", "modifieddate"::text
         """
    }
    q.query(using ProductinventoryRow.read).unique
    
  }
  override def insertStreaming(unsaved: Stream[ConnectionIO, ProductinventoryRow], batchSize: Int): ConnectionIO[Long] = {
    new FragmentOps(sql"""COPY production.productinventory("productid", "locationid", "shelf", "bin", "quantity", "rowguid", "modifieddate") FROM STDIN""").copyIn(unsaved, batchSize)(using ProductinventoryRow.text)
  }
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  override def insertUnsavedStreaming(unsaved: Stream[ConnectionIO, ProductinventoryRowUnsaved], batchSize: Int): ConnectionIO[Long] = {
    new FragmentOps(sql"""COPY production.productinventory("productid", "locationid", "shelf", "bin", "quantity", "rowguid", "modifieddate") FROM STDIN (DEFAULT '__DEFAULT_VALUE__')""").copyIn(unsaved, batchSize)(using ProductinventoryRowUnsaved.text)
  }
  override def select: SelectBuilder[ProductinventoryFields, ProductinventoryRow] = {
    SelectBuilderSql("production.productinventory", ProductinventoryFields.structure, ProductinventoryRow.read)
  }
  override def selectAll: Stream[ConnectionIO, ProductinventoryRow] = {
    sql"""select "productid", "locationid", "shelf", "bin", "quantity", "rowguid", "modifieddate"::text from production.productinventory""".query(using ProductinventoryRow.read).stream
  }
  override def selectById(compositeId: ProductinventoryId): ConnectionIO[Option[ProductinventoryRow]] = {
    sql"""select "productid", "locationid", "shelf", "bin", "quantity", "rowguid", "modifieddate"::text from production.productinventory where "productid" = ${fromWrite(compositeId.productid)(Write.fromPut(ProductId.put))} AND "locationid" = ${fromWrite(compositeId.locationid)(Write.fromPut(LocationId.put))}""".query(using ProductinventoryRow.read).option
  }
  override def selectByIds(compositeIds: Array[ProductinventoryId]): Stream[ConnectionIO, ProductinventoryRow] = {
    val productid = compositeIds.map(_.productid)
    val locationid = compositeIds.map(_.locationid)
    sql"""select "productid", "locationid", "shelf", "bin", "quantity", "rowguid", "modifieddate"::text
          from production.productinventory
          where ("productid", "locationid") 
          in (select unnest(${productid}), unnest(${locationid}))
       """.query(using ProductinventoryRow.read).stream
    
  }
  override def selectByIdsTracked(compositeIds: Array[ProductinventoryId]): ConnectionIO[Map[ProductinventoryId, Option[ProductinventoryRow]]] = {
    selectByIds(compositeIds).compile.toList.map { rows =>
      val byId = rows.view.map(x => (x.compositeId, x)).toMap
      compositeIds.view.map(id => (id, byId.get(id))).toMap
    }
  }
  override def update: UpdateBuilder[ProductinventoryFields, ProductinventoryRow] = {
    UpdateBuilder("production.productinventory", ProductinventoryFields.structure, ProductinventoryRow.read)
  }
  override def update(row: ProductinventoryRow): ConnectionIO[Boolean] = {
    val compositeId = row.compositeId
    sql"""update production.productinventory
          set "shelf" = ${fromWrite(row.shelf)(Write.fromPut(Meta.StringMeta.put))},
              "bin" = ${fromWrite(row.bin)(Write.fromPut(TypoShort.put))}::int2,
              "quantity" = ${fromWrite(row.quantity)(Write.fromPut(TypoShort.put))}::int2,
              "rowguid" = ${fromWrite(row.rowguid)(Write.fromPut(TypoUUID.put))}::uuid,
              "modifieddate" = ${fromWrite(row.modifieddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp
          where "productid" = ${fromWrite(compositeId.productid)(Write.fromPut(ProductId.put))} AND "locationid" = ${fromWrite(compositeId.locationid)(Write.fromPut(LocationId.put))}"""
      .update
      .run
      .map(_ > 0)
  }
  override def upsert(unsaved: ProductinventoryRow): ConnectionIO[ProductinventoryRow] = {
    sql"""insert into production.productinventory("productid", "locationid", "shelf", "bin", "quantity", "rowguid", "modifieddate")
          values (
            ${fromWrite(unsaved.productid)(Write.fromPut(ProductId.put))}::int4,
            ${fromWrite(unsaved.locationid)(Write.fromPut(LocationId.put))}::int2,
            ${fromWrite(unsaved.shelf)(Write.fromPut(Meta.StringMeta.put))},
            ${fromWrite(unsaved.bin)(Write.fromPut(TypoShort.put))}::int2,
            ${fromWrite(unsaved.quantity)(Write.fromPut(TypoShort.put))}::int2,
            ${fromWrite(unsaved.rowguid)(Write.fromPut(TypoUUID.put))}::uuid,
            ${fromWrite(unsaved.modifieddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp
          )
          on conflict ("productid", "locationid")
          do update set
            "shelf" = EXCLUDED."shelf",
            "bin" = EXCLUDED."bin",
            "quantity" = EXCLUDED."quantity",
            "rowguid" = EXCLUDED."rowguid",
            "modifieddate" = EXCLUDED."modifieddate"
          returning "productid", "locationid", "shelf", "bin", "quantity", "rowguid", "modifieddate"::text
       """.query(using ProductinventoryRow.read).unique
  }
}
