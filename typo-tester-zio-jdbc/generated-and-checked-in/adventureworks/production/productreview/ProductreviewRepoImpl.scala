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
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql
import typo.dsl.UpdateBuilder
import zio.ZIO
import zio.jdbc.SqlFragment
import zio.jdbc.SqlFragment.Segment
import zio.jdbc.SqlFragment.Setter
import zio.jdbc.UpdateResult
import zio.jdbc.ZConnection
import zio.jdbc.sqlInterpolator
import zio.stream.ZStream

class ProductreviewRepoImpl extends ProductreviewRepo {
  override def delete: DeleteBuilder[ProductreviewFields, ProductreviewRow] = {
    DeleteBuilder(""""production"."productreview"""", ProductreviewFields.structure)
  }
  override def deleteById(productreviewid: ProductreviewId): ZIO[ZConnection, Throwable, Boolean] = {
    sql"""delete from "production"."productreview" where "productreviewid" = ${Segment.paramSegment(productreviewid)(ProductreviewId.setter)}""".delete.map(_ > 0)
  }
  override def deleteByIds(productreviewids: Array[ProductreviewId]): ZIO[ZConnection, Throwable, Long] = {
    sql"""delete from "production"."productreview" where "productreviewid" = ANY(${productreviewids})""".delete
  }
  override def insert(unsaved: ProductreviewRow): ZIO[ZConnection, Throwable, ProductreviewRow] = {
    sql"""insert into "production"."productreview"("productreviewid", "productid", "reviewername", "reviewdate", "emailaddress", "rating", "comments", "modifieddate")
          values (${Segment.paramSegment(unsaved.productreviewid)(ProductreviewId.setter)}::int4, ${Segment.paramSegment(unsaved.productid)(ProductId.setter)}::int4, ${Segment.paramSegment(unsaved.reviewername)(Name.setter)}::varchar, ${Segment.paramSegment(unsaved.reviewdate)(TypoLocalDateTime.setter)}::timestamp, ${Segment.paramSegment(unsaved.emailaddress)(Setter.stringSetter)}, ${Segment.paramSegment(unsaved.rating)(Setter.intSetter)}::int4, ${Segment.paramSegment(unsaved.comments)(Setter.optionParamSetter(Setter.stringSetter))}, ${Segment.paramSegment(unsaved.modifieddate)(TypoLocalDateTime.setter)}::timestamp)
          returning "productreviewid", "productid", "reviewername", "reviewdate"::text, "emailaddress", "rating", "comments", "modifieddate"::text
       """.insertReturning(using ProductreviewRow.jdbcDecoder).map(_.updatedKeys.head)
  }
  override def insert(unsaved: ProductreviewRowUnsaved): ZIO[ZConnection, Throwable, ProductreviewRow] = {
    val fs = List(
      Some((sql""""productid"""", sql"${Segment.paramSegment(unsaved.productid)(ProductId.setter)}::int4")),
      Some((sql""""reviewername"""", sql"${Segment.paramSegment(unsaved.reviewername)(Name.setter)}::varchar")),
      Some((sql""""emailaddress"""", sql"${Segment.paramSegment(unsaved.emailaddress)(Setter.stringSetter)}")),
      Some((sql""""rating"""", sql"${Segment.paramSegment(unsaved.rating)(Setter.intSetter)}::int4")),
      Some((sql""""comments"""", sql"${Segment.paramSegment(unsaved.comments)(Setter.optionParamSetter(Setter.stringSetter))}")),
      unsaved.productreviewid match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((sql""""productreviewid"""", sql"${Segment.paramSegment(value: ProductreviewId)(ProductreviewId.setter)}::int4"))
      },
      unsaved.reviewdate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((sql""""reviewdate"""", sql"${Segment.paramSegment(value: TypoLocalDateTime)(TypoLocalDateTime.setter)}::timestamp"))
      },
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((sql""""modifieddate"""", sql"${Segment.paramSegment(value: TypoLocalDateTime)(TypoLocalDateTime.setter)}::timestamp"))
      }
    ).flatten
    
    val q = if (fs.isEmpty) {
      sql"""insert into "production"."productreview" default values
            returning "productreviewid", "productid", "reviewername", "reviewdate"::text, "emailaddress", "rating", "comments", "modifieddate"::text
         """
    } else {
      val names  = fs.map { case (n, _) => n }.mkFragment(SqlFragment(", "))
      val values = fs.map { case (_, f) => f }.mkFragment(SqlFragment(", "))
      sql"""insert into "production"."productreview"($names) values ($values) returning "productreviewid", "productid", "reviewername", "reviewdate"::text, "emailaddress", "rating", "comments", "modifieddate"::text"""
    }
    q.insertReturning(using ProductreviewRow.jdbcDecoder).map(_.updatedKeys.head)
    
  }
  override def insertStreaming(unsaved: ZStream[ZConnection, Throwable, ProductreviewRow], batchSize: Int = 10000): ZIO[ZConnection, Throwable, Long] = {
    streamingInsert(s"""COPY "production"."productreview"("productreviewid", "productid", "reviewername", "reviewdate", "emailaddress", "rating", "comments", "modifieddate") FROM STDIN""", batchSize, unsaved)(ProductreviewRow.text)
  }
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  override def insertUnsavedStreaming(unsaved: ZStream[ZConnection, Throwable, ProductreviewRowUnsaved], batchSize: Int = 10000): ZIO[ZConnection, Throwable, Long] = {
    streamingInsert(s"""COPY "production"."productreview"("productid", "reviewername", "emailaddress", "rating", "comments", "productreviewid", "reviewdate", "modifieddate") FROM STDIN (DEFAULT '__DEFAULT_VALUE__')""", batchSize, unsaved)(ProductreviewRowUnsaved.text)
  }
  override def select: SelectBuilder[ProductreviewFields, ProductreviewRow] = {
    SelectBuilderSql(""""production"."productreview"""", ProductreviewFields.structure, ProductreviewRow.jdbcDecoder)
  }
  override def selectAll: ZStream[ZConnection, Throwable, ProductreviewRow] = {
    sql"""select "productreviewid", "productid", "reviewername", "reviewdate"::text, "emailaddress", "rating", "comments", "modifieddate"::text from "production"."productreview"""".query(using ProductreviewRow.jdbcDecoder).selectStream()
  }
  override def selectById(productreviewid: ProductreviewId): ZIO[ZConnection, Throwable, Option[ProductreviewRow]] = {
    sql"""select "productreviewid", "productid", "reviewername", "reviewdate"::text, "emailaddress", "rating", "comments", "modifieddate"::text from "production"."productreview" where "productreviewid" = ${Segment.paramSegment(productreviewid)(ProductreviewId.setter)}""".query(using ProductreviewRow.jdbcDecoder).selectOne
  }
  override def selectByIds(productreviewids: Array[ProductreviewId]): ZStream[ZConnection, Throwable, ProductreviewRow] = {
    sql"""select "productreviewid", "productid", "reviewername", "reviewdate"::text, "emailaddress", "rating", "comments", "modifieddate"::text from "production"."productreview" where "productreviewid" = ANY(${Segment.paramSegment(productreviewids)(ProductreviewId.arraySetter)})""".query(using ProductreviewRow.jdbcDecoder).selectStream()
  }
  override def selectByIdsTracked(productreviewids: Array[ProductreviewId]): ZIO[ZConnection, Throwable, Map[ProductreviewId, ProductreviewRow]] = {
    selectByIds(productreviewids).runCollect.map { rows =>
      val byId = rows.view.map(x => (x.productreviewid, x)).toMap
      productreviewids.view.flatMap(id => byId.get(id).map(x => (id, x))).toMap
    }
  }
  override def update: UpdateBuilder[ProductreviewFields, ProductreviewRow] = {
    UpdateBuilder(""""production"."productreview"""", ProductreviewFields.structure, ProductreviewRow.jdbcDecoder)
  }
  override def update(row: ProductreviewRow): ZIO[ZConnection, Throwable, Boolean] = {
    val productreviewid = row.productreviewid
    sql"""update "production"."productreview"
          set "productid" = ${Segment.paramSegment(row.productid)(ProductId.setter)}::int4,
              "reviewername" = ${Segment.paramSegment(row.reviewername)(Name.setter)}::varchar,
              "reviewdate" = ${Segment.paramSegment(row.reviewdate)(TypoLocalDateTime.setter)}::timestamp,
              "emailaddress" = ${Segment.paramSegment(row.emailaddress)(Setter.stringSetter)},
              "rating" = ${Segment.paramSegment(row.rating)(Setter.intSetter)}::int4,
              "comments" = ${Segment.paramSegment(row.comments)(Setter.optionParamSetter(Setter.stringSetter))},
              "modifieddate" = ${Segment.paramSegment(row.modifieddate)(TypoLocalDateTime.setter)}::timestamp
          where "productreviewid" = ${Segment.paramSegment(productreviewid)(ProductreviewId.setter)}""".update.map(_ > 0)
  }
  override def upsert(unsaved: ProductreviewRow): ZIO[ZConnection, Throwable, UpdateResult[ProductreviewRow]] = {
    sql"""insert into "production"."productreview"("productreviewid", "productid", "reviewername", "reviewdate", "emailaddress", "rating", "comments", "modifieddate")
          values (
            ${Segment.paramSegment(unsaved.productreviewid)(ProductreviewId.setter)}::int4,
            ${Segment.paramSegment(unsaved.productid)(ProductId.setter)}::int4,
            ${Segment.paramSegment(unsaved.reviewername)(Name.setter)}::varchar,
            ${Segment.paramSegment(unsaved.reviewdate)(TypoLocalDateTime.setter)}::timestamp,
            ${Segment.paramSegment(unsaved.emailaddress)(Setter.stringSetter)},
            ${Segment.paramSegment(unsaved.rating)(Setter.intSetter)}::int4,
            ${Segment.paramSegment(unsaved.comments)(Setter.optionParamSetter(Setter.stringSetter))},
            ${Segment.paramSegment(unsaved.modifieddate)(TypoLocalDateTime.setter)}::timestamp
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
          returning "productreviewid", "productid", "reviewername", "reviewdate"::text, "emailaddress", "rating", "comments", "modifieddate"::text""".insertReturning(using ProductreviewRow.jdbcDecoder)
  }
  /* NOTE: this functionality is not safe if you use auto-commit mode! it runs 3 SQL statements */
  override def upsertStreaming(unsaved: ZStream[ZConnection, Throwable, ProductreviewRow], batchSize: Int = 10000): ZIO[ZConnection, Throwable, Long] = {
    val created = sql"""create temporary table productreview_TEMP (like "production"."productreview") on commit drop""".execute
    val copied = streamingInsert(s"""copy productreview_TEMP("productreviewid", "productid", "reviewername", "reviewdate", "emailaddress", "rating", "comments", "modifieddate") from stdin""", batchSize, unsaved)(ProductreviewRow.text)
    val merged = sql"""insert into "production"."productreview"("productreviewid", "productid", "reviewername", "reviewdate", "emailaddress", "rating", "comments", "modifieddate")
                       select * from productreview_TEMP
                       on conflict ("productreviewid")
                       do update set
                         "productid" = EXCLUDED."productid",
                         "reviewername" = EXCLUDED."reviewername",
                         "reviewdate" = EXCLUDED."reviewdate",
                         "emailaddress" = EXCLUDED."emailaddress",
                         "rating" = EXCLUDED."rating",
                         "comments" = EXCLUDED."comments",
                         "modifieddate" = EXCLUDED."modifieddate"
                       ;
                       drop table productreview_TEMP;""".update
    created *> copied *> merged
  }
}
