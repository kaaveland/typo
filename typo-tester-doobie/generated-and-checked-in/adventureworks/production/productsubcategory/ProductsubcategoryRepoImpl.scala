/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package productsubcategory

import adventureworks.customtypes.Defaulted
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoUUID
import adventureworks.production.productcategory.ProductcategoryId
import adventureworks.public.Name
import doobie.free.connection.ConnectionIO
import doobie.postgres.syntax.FragmentOps
import doobie.syntax.SqlInterpolator.SingleFragment.fromWrite
import doobie.syntax.string.toSqlInterpolator
import doobie.util.Write
import doobie.util.fragment.Fragment
import fs2.Stream
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql
import typo.dsl.UpdateBuilder

class ProductsubcategoryRepoImpl extends ProductsubcategoryRepo {
  override def delete(productsubcategoryid: ProductsubcategoryId): ConnectionIO[Boolean] = {
    sql"""delete from production.productsubcategory where "productsubcategoryid" = ${fromWrite(productsubcategoryid)(Write.fromPut(ProductsubcategoryId.put))}""".update.run.map(_ > 0)
  }
  override def delete: DeleteBuilder[ProductsubcategoryFields, ProductsubcategoryRow] = {
    DeleteBuilder("production.productsubcategory", ProductsubcategoryFields.structure)
  }
  override def insert(unsaved: ProductsubcategoryRow): ConnectionIO[ProductsubcategoryRow] = {
    sql"""insert into production.productsubcategory("productsubcategoryid", "productcategoryid", "name", "rowguid", "modifieddate")
          values (${fromWrite(unsaved.productsubcategoryid)(Write.fromPut(ProductsubcategoryId.put))}::int4, ${fromWrite(unsaved.productcategoryid)(Write.fromPut(ProductcategoryId.put))}::int4, ${fromWrite(unsaved.name)(Write.fromPut(Name.put))}::varchar, ${fromWrite(unsaved.rowguid)(Write.fromPut(TypoUUID.put))}::uuid, ${fromWrite(unsaved.modifieddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp)
          returning "productsubcategoryid", "productcategoryid", "name", "rowguid", "modifieddate"::text
       """.query(using ProductsubcategoryRow.read).unique
  }
  override def insertStreaming(unsaved: Stream[ConnectionIO, ProductsubcategoryRow], batchSize: Int): ConnectionIO[Long] = {
    new FragmentOps(sql"""COPY production.productsubcategory("productsubcategoryid", "productcategoryid", "name", "rowguid", "modifieddate") FROM STDIN""").copyIn(unsaved, batchSize)(using ProductsubcategoryRow.text)
  }
  override def insert(unsaved: ProductsubcategoryRowUnsaved): ConnectionIO[ProductsubcategoryRow] = {
    val fs = List(
      Some((Fragment.const(s""""productcategoryid""""), fr"${fromWrite(unsaved.productcategoryid)(Write.fromPut(ProductcategoryId.put))}::int4")),
      Some((Fragment.const(s""""name""""), fr"${fromWrite(unsaved.name)(Write.fromPut(Name.put))}::varchar")),
      unsaved.productsubcategoryid match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s""""productsubcategoryid""""), fr"${fromWrite(value: ProductsubcategoryId)(Write.fromPut(ProductsubcategoryId.put))}::int4"))
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
      sql"""insert into production.productsubcategory default values
            returning "productsubcategoryid", "productcategoryid", "name", "rowguid", "modifieddate"::text
         """
    } else {
      val CommaSeparate = Fragment.FragmentMonoid.intercalate(fr", ")
      sql"""insert into production.productsubcategory(${CommaSeparate.combineAllOption(fs.map { case (n, _) => n }).get})
            values (${CommaSeparate.combineAllOption(fs.map { case (_, f) => f }).get})
            returning "productsubcategoryid", "productcategoryid", "name", "rowguid", "modifieddate"::text
         """
    }
    q.query(using ProductsubcategoryRow.read).unique
    
  }
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  override def insertUnsavedStreaming(unsaved: Stream[ConnectionIO, ProductsubcategoryRowUnsaved], batchSize: Int): ConnectionIO[Long] = {
    new FragmentOps(sql"""COPY production.productsubcategory("productcategoryid", "name", "productsubcategoryid", "rowguid", "modifieddate") FROM STDIN (DEFAULT '__DEFAULT_VALUE__')""").copyIn(unsaved, batchSize)(using ProductsubcategoryRowUnsaved.text)
  }
  override def select: SelectBuilder[ProductsubcategoryFields, ProductsubcategoryRow] = {
    SelectBuilderSql("production.productsubcategory", ProductsubcategoryFields.structure, ProductsubcategoryRow.read)
  }
  override def selectAll: Stream[ConnectionIO, ProductsubcategoryRow] = {
    sql"""select "productsubcategoryid", "productcategoryid", "name", "rowguid", "modifieddate"::text from production.productsubcategory""".query(using ProductsubcategoryRow.read).stream
  }
  override def selectById(productsubcategoryid: ProductsubcategoryId): ConnectionIO[Option[ProductsubcategoryRow]] = {
    sql"""select "productsubcategoryid", "productcategoryid", "name", "rowguid", "modifieddate"::text from production.productsubcategory where "productsubcategoryid" = ${fromWrite(productsubcategoryid)(Write.fromPut(ProductsubcategoryId.put))}""".query(using ProductsubcategoryRow.read).option
  }
  override def selectByIds(productsubcategoryids: Array[ProductsubcategoryId]): Stream[ConnectionIO, ProductsubcategoryRow] = {
    sql"""select "productsubcategoryid", "productcategoryid", "name", "rowguid", "modifieddate"::text from production.productsubcategory where "productsubcategoryid" = ANY(${productsubcategoryids})""".query(using ProductsubcategoryRow.read).stream
  }
  override def update(row: ProductsubcategoryRow): ConnectionIO[Boolean] = {
    val productsubcategoryid = row.productsubcategoryid
    sql"""update production.productsubcategory
          set "productcategoryid" = ${fromWrite(row.productcategoryid)(Write.fromPut(ProductcategoryId.put))}::int4,
              "name" = ${fromWrite(row.name)(Write.fromPut(Name.put))}::varchar,
              "rowguid" = ${fromWrite(row.rowguid)(Write.fromPut(TypoUUID.put))}::uuid,
              "modifieddate" = ${fromWrite(row.modifieddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp
          where "productsubcategoryid" = ${fromWrite(productsubcategoryid)(Write.fromPut(ProductsubcategoryId.put))}"""
      .update
      .run
      .map(_ > 0)
  }
  override def update: UpdateBuilder[ProductsubcategoryFields, ProductsubcategoryRow] = {
    UpdateBuilder("production.productsubcategory", ProductsubcategoryFields.structure, ProductsubcategoryRow.read)
  }
  override def upsert(unsaved: ProductsubcategoryRow): ConnectionIO[ProductsubcategoryRow] = {
    sql"""insert into production.productsubcategory("productsubcategoryid", "productcategoryid", "name", "rowguid", "modifieddate")
          values (
            ${fromWrite(unsaved.productsubcategoryid)(Write.fromPut(ProductsubcategoryId.put))}::int4,
            ${fromWrite(unsaved.productcategoryid)(Write.fromPut(ProductcategoryId.put))}::int4,
            ${fromWrite(unsaved.name)(Write.fromPut(Name.put))}::varchar,
            ${fromWrite(unsaved.rowguid)(Write.fromPut(TypoUUID.put))}::uuid,
            ${fromWrite(unsaved.modifieddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp
          )
          on conflict ("productsubcategoryid")
          do update set
            "productcategoryid" = EXCLUDED."productcategoryid",
            "name" = EXCLUDED."name",
            "rowguid" = EXCLUDED."rowguid",
            "modifieddate" = EXCLUDED."modifieddate"
          returning "productsubcategoryid", "productcategoryid", "name", "rowguid", "modifieddate"::text
       """.query(using ProductsubcategoryRow.read).unique
  }
}
