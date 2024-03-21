/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package productreview

import adventureworks.customtypes.Defaulted
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.production.product.ProductId
import adventureworks.public.Name
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

class ProductreviewRepoImpl extends ProductreviewRepo {
  override def delete(productreviewid: ProductreviewId): ConnectionIO[Boolean] = {
    sql"""delete from production.productreview where "productreviewid" = ${fromWrite(productreviewid)(Write.fromPut(ProductreviewId.put))}""".update.run.map(_ > 0)
  }
  override def delete: DeleteBuilder[ProductreviewFields, ProductreviewRow] = {
    DeleteBuilder("production.productreview", ProductreviewFields.structure)
  }
  override def insert(unsaved: ProductreviewRow): ConnectionIO[ProductreviewRow] = {
    sql"""insert into production.productreview("productreviewid", "productid", "reviewername", "reviewdate", "emailaddress", "rating", "comments", "modifieddate")
          values (${fromWrite(unsaved.productreviewid)(Write.fromPut(ProductreviewId.put))}::int4, ${fromWrite(unsaved.productid)(Write.fromPut(ProductId.put))}::int4, ${fromWrite(unsaved.reviewername)(Write.fromPut(Name.put))}::varchar, ${fromWrite(unsaved.reviewdate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp, ${fromWrite(unsaved.emailaddress)(Write.fromPut(Meta.StringMeta.put))}, ${fromWrite(unsaved.rating)(Write.fromPut(Meta.IntMeta.put))}::int4, ${fromWrite(unsaved.comments)(Write.fromPutOption(Meta.StringMeta.put))}, ${fromWrite(unsaved.modifieddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp)
          returning "productreviewid", "productid", "reviewername", "reviewdate"::text, "emailaddress", "rating", "comments", "modifieddate"::text
       """.query(using ProductreviewRow.read).unique
  }
  override def insertStreaming(unsaved: Stream[ConnectionIO, ProductreviewRow], batchSize: Int): ConnectionIO[Long] = {
    new FragmentOps(sql"""COPY production.productreview("productreviewid", "productid", "reviewername", "reviewdate", "emailaddress", "rating", "comments", "modifieddate") FROM STDIN""").copyIn(unsaved, batchSize)(using ProductreviewRow.text)
  }
  override def insert(unsaved: ProductreviewRowUnsaved): ConnectionIO[ProductreviewRow] = {
    val fs = List(
      Some((Fragment.const(s""""productid""""), fr"${fromWrite(unsaved.productid)(Write.fromPut(ProductId.put))}::int4")),
      Some((Fragment.const(s""""reviewername""""), fr"${fromWrite(unsaved.reviewername)(Write.fromPut(Name.put))}::varchar")),
      Some((Fragment.const(s""""emailaddress""""), fr"${fromWrite(unsaved.emailaddress)(Write.fromPut(Meta.StringMeta.put))}")),
      Some((Fragment.const(s""""rating""""), fr"${fromWrite(unsaved.rating)(Write.fromPut(Meta.IntMeta.put))}::int4")),
      Some((Fragment.const(s""""comments""""), fr"${fromWrite(unsaved.comments)(Write.fromPutOption(Meta.StringMeta.put))}")),
      unsaved.productreviewid match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s""""productreviewid""""), fr"${fromWrite(value: ProductreviewId)(Write.fromPut(ProductreviewId.put))}::int4"))
      },
      unsaved.reviewdate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s""""reviewdate""""), fr"${fromWrite(value: TypoLocalDateTime)(Write.fromPut(TypoLocalDateTime.put))}::timestamp"))
      },
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s""""modifieddate""""), fr"${fromWrite(value: TypoLocalDateTime)(Write.fromPut(TypoLocalDateTime.put))}::timestamp"))
      }
    ).flatten
    
    val q = if (fs.isEmpty) {
      sql"""insert into production.productreview default values
            returning "productreviewid", "productid", "reviewername", "reviewdate"::text, "emailaddress", "rating", "comments", "modifieddate"::text
         """
    } else {
      val CommaSeparate = Fragment.FragmentMonoid.intercalate(fr", ")
      sql"""insert into production.productreview(${CommaSeparate.combineAllOption(fs.map { case (n, _) => n }).get})
            values (${CommaSeparate.combineAllOption(fs.map { case (_, f) => f }).get})
            returning "productreviewid", "productid", "reviewername", "reviewdate"::text, "emailaddress", "rating", "comments", "modifieddate"::text
         """
    }
    q.query(using ProductreviewRow.read).unique
    
  }
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  override def insertUnsavedStreaming(unsaved: Stream[ConnectionIO, ProductreviewRowUnsaved], batchSize: Int): ConnectionIO[Long] = {
    new FragmentOps(sql"""COPY production.productreview("productid", "reviewername", "emailaddress", "rating", "comments", "productreviewid", "reviewdate", "modifieddate") FROM STDIN (DEFAULT '__DEFAULT_VALUE__')""").copyIn(unsaved, batchSize)(using ProductreviewRowUnsaved.text)
  }
  override def select: SelectBuilder[ProductreviewFields, ProductreviewRow] = {
    SelectBuilderSql("production.productreview", ProductreviewFields.structure, ProductreviewRow.read)
  }
  override def selectAll: Stream[ConnectionIO, ProductreviewRow] = {
    sql"""select "productreviewid", "productid", "reviewername", "reviewdate"::text, "emailaddress", "rating", "comments", "modifieddate"::text from production.productreview""".query(using ProductreviewRow.read).stream
  }
  override def selectById(productreviewid: ProductreviewId): ConnectionIO[Option[ProductreviewRow]] = {
    sql"""select "productreviewid", "productid", "reviewername", "reviewdate"::text, "emailaddress", "rating", "comments", "modifieddate"::text from production.productreview where "productreviewid" = ${fromWrite(productreviewid)(Write.fromPut(ProductreviewId.put))}""".query(using ProductreviewRow.read).option
  }
  override def selectByIds(productreviewids: Array[ProductreviewId]): Stream[ConnectionIO, ProductreviewRow] = {
    sql"""select "productreviewid", "productid", "reviewername", "reviewdate"::text, "emailaddress", "rating", "comments", "modifieddate"::text from production.productreview where "productreviewid" = ANY(${productreviewids})""".query(using ProductreviewRow.read).stream
  }
  override def update(row: ProductreviewRow): ConnectionIO[Boolean] = {
    val productreviewid = row.productreviewid
    sql"""update production.productreview
          set "productid" = ${fromWrite(row.productid)(Write.fromPut(ProductId.put))}::int4,
              "reviewername" = ${fromWrite(row.reviewername)(Write.fromPut(Name.put))}::varchar,
              "reviewdate" = ${fromWrite(row.reviewdate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp,
              "emailaddress" = ${fromWrite(row.emailaddress)(Write.fromPut(Meta.StringMeta.put))},
              "rating" = ${fromWrite(row.rating)(Write.fromPut(Meta.IntMeta.put))}::int4,
              "comments" = ${fromWrite(row.comments)(Write.fromPutOption(Meta.StringMeta.put))},
              "modifieddate" = ${fromWrite(row.modifieddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp
          where "productreviewid" = ${fromWrite(productreviewid)(Write.fromPut(ProductreviewId.put))}"""
      .update
      .run
      .map(_ > 0)
  }
  override def update: UpdateBuilder[ProductreviewFields, ProductreviewRow] = {
    UpdateBuilder("production.productreview", ProductreviewFields.structure, ProductreviewRow.read)
  }
  override def upsert(unsaved: ProductreviewRow): ConnectionIO[ProductreviewRow] = {
    sql"""insert into production.productreview("productreviewid", "productid", "reviewername", "reviewdate", "emailaddress", "rating", "comments", "modifieddate")
          values (
            ${fromWrite(unsaved.productreviewid)(Write.fromPut(ProductreviewId.put))}::int4,
            ${fromWrite(unsaved.productid)(Write.fromPut(ProductId.put))}::int4,
            ${fromWrite(unsaved.reviewername)(Write.fromPut(Name.put))}::varchar,
            ${fromWrite(unsaved.reviewdate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp,
            ${fromWrite(unsaved.emailaddress)(Write.fromPut(Meta.StringMeta.put))},
            ${fromWrite(unsaved.rating)(Write.fromPut(Meta.IntMeta.put))}::int4,
            ${fromWrite(unsaved.comments)(Write.fromPutOption(Meta.StringMeta.put))},
            ${fromWrite(unsaved.modifieddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp
          )
          on conflict ("productreviewid")
          do update set
            "productid" = EXCLUDED."productid",
            "reviewername" = EXCLUDED."reviewername",
            "reviewdate" = EXCLUDED."reviewdate",
            "emailaddress" = EXCLUDED."emailaddress",
            "rating" = EXCLUDED."rating",
            "comments" = EXCLUDED."comments",
            "modifieddate" = EXCLUDED."modifieddate"
          returning "productreviewid", "productid", "reviewername", "reviewdate"::text, "emailaddress", "rating", "comments", "modifieddate"::text
       """.query(using ProductreviewRow.read).unique
  }
}
