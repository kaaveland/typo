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
import adventureworks.streamingInsert
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql
import typo.dsl.UpdateBuilder
import zio.ZIO
import zio.jdbc.SqlFragment
import zio.jdbc.SqlFragment.Segment
import zio.jdbc.UpdateResult
import zio.jdbc.ZConnection
import zio.jdbc.sqlInterpolator
import zio.stream.ZStream

class ProductsubcategoryRepoImpl extends ProductsubcategoryRepo {
  override def delete(productsubcategoryid: ProductsubcategoryId): ZIO[ZConnection, Throwable, Boolean] = {
    sql"""delete from production.productsubcategory where "productsubcategoryid" = ${Segment.paramSegment(productsubcategoryid)(ProductsubcategoryId.setter)}""".delete.map(_ > 0)
  }
  override def delete: DeleteBuilder[ProductsubcategoryFields, ProductsubcategoryRow] = {
    DeleteBuilder("production.productsubcategory", ProductsubcategoryFields.structure)
  }
  override def insert(unsaved: ProductsubcategoryRow): ZIO[ZConnection, Throwable, ProductsubcategoryRow] = {
    sql"""insert into production.productsubcategory("productsubcategoryid", "productcategoryid", "name", "rowguid", "modifieddate")
          values (${Segment.paramSegment(unsaved.productsubcategoryid)(ProductsubcategoryId.setter)}::int4, ${Segment.paramSegment(unsaved.productcategoryid)(ProductcategoryId.setter)}::int4, ${Segment.paramSegment(unsaved.name)(Name.setter)}::varchar, ${Segment.paramSegment(unsaved.rowguid)(TypoUUID.setter)}::uuid, ${Segment.paramSegment(unsaved.modifieddate)(TypoLocalDateTime.setter)}::timestamp)
          returning "productsubcategoryid", "productcategoryid", "name", "rowguid", "modifieddate"::text
       """.insertReturning(ProductsubcategoryRow.jdbcDecoder).map(_.updatedKeys.head)
  }
  override def insertStreaming(unsaved: ZStream[ZConnection, Throwable, ProductsubcategoryRow], batchSize: Int): ZIO[ZConnection, Throwable, Long] = {
    streamingInsert(s"""COPY production.productsubcategory("productsubcategoryid", "productcategoryid", "name", "rowguid", "modifieddate") FROM STDIN""", batchSize, unsaved)(ProductsubcategoryRow.text)
  }
  override def insert(unsaved: ProductsubcategoryRowUnsaved): ZIO[ZConnection, Throwable, ProductsubcategoryRow] = {
    val fs = List(
      Some((sql""""productcategoryid"""", sql"${Segment.paramSegment(unsaved.productcategoryid)(ProductcategoryId.setter)}::int4")),
      Some((sql""""name"""", sql"${Segment.paramSegment(unsaved.name)(Name.setter)}::varchar")),
      unsaved.productsubcategoryid match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((sql""""productsubcategoryid"""", sql"${Segment.paramSegment(value: ProductsubcategoryId)(ProductsubcategoryId.setter)}::int4"))
      },
      unsaved.rowguid match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((sql""""rowguid"""", sql"${Segment.paramSegment(value: TypoUUID)(TypoUUID.setter)}::uuid"))
      },
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((sql""""modifieddate"""", sql"${Segment.paramSegment(value: TypoLocalDateTime)(TypoLocalDateTime.setter)}::timestamp"))
      }
    ).flatten
    
    val q = if (fs.isEmpty) {
      sql"""insert into production.productsubcategory default values
            returning "productsubcategoryid", "productcategoryid", "name", "rowguid", "modifieddate"::text
         """
    } else {
      val names  = fs.map { case (n, _) => n }.mkFragment(SqlFragment(", "))
      val values = fs.map { case (_, f) => f }.mkFragment(SqlFragment(", "))
      sql"""insert into production.productsubcategory($names) values ($values) returning "productsubcategoryid", "productcategoryid", "name", "rowguid", "modifieddate"::text"""
    }
    q.insertReturning(ProductsubcategoryRow.jdbcDecoder).map(_.updatedKeys.head)
    
  }
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  override def insertUnsavedStreaming(unsaved: ZStream[ZConnection, Throwable, ProductsubcategoryRowUnsaved], batchSize: Int): ZIO[ZConnection, Throwable, Long] = {
    streamingInsert(s"""COPY production.productsubcategory("productcategoryid", "name", "productsubcategoryid", "rowguid", "modifieddate") FROM STDIN (DEFAULT '__DEFAULT_VALUE__')""", batchSize, unsaved)(ProductsubcategoryRowUnsaved.text)
  }
  override def select: SelectBuilder[ProductsubcategoryFields, ProductsubcategoryRow] = {
    SelectBuilderSql("production.productsubcategory", ProductsubcategoryFields.structure, ProductsubcategoryRow.jdbcDecoder)
  }
  override def selectAll: ZStream[ZConnection, Throwable, ProductsubcategoryRow] = {
    sql"""select "productsubcategoryid", "productcategoryid", "name", "rowguid", "modifieddate"::text from production.productsubcategory""".query(ProductsubcategoryRow.jdbcDecoder).selectStream
  }
  override def selectById(productsubcategoryid: ProductsubcategoryId): ZIO[ZConnection, Throwable, Option[ProductsubcategoryRow]] = {
    sql"""select "productsubcategoryid", "productcategoryid", "name", "rowguid", "modifieddate"::text from production.productsubcategory where "productsubcategoryid" = ${Segment.paramSegment(productsubcategoryid)(ProductsubcategoryId.setter)}""".query(ProductsubcategoryRow.jdbcDecoder).selectOne
  }
  override def selectByIds(productsubcategoryids: Array[ProductsubcategoryId]): ZStream[ZConnection, Throwable, ProductsubcategoryRow] = {
    sql"""select "productsubcategoryid", "productcategoryid", "name", "rowguid", "modifieddate"::text from production.productsubcategory where "productsubcategoryid" = ANY(${Segment.paramSegment(productsubcategoryids)(ProductsubcategoryId.arraySetter)})""".query(ProductsubcategoryRow.jdbcDecoder).selectStream
  }
  override def update(row: ProductsubcategoryRow): ZIO[ZConnection, Throwable, Boolean] = {
    val productsubcategoryid = row.productsubcategoryid
    sql"""update production.productsubcategory
          set "productcategoryid" = ${Segment.paramSegment(row.productcategoryid)(ProductcategoryId.setter)}::int4,
              "name" = ${Segment.paramSegment(row.name)(Name.setter)}::varchar,
              "rowguid" = ${Segment.paramSegment(row.rowguid)(TypoUUID.setter)}::uuid,
              "modifieddate" = ${Segment.paramSegment(row.modifieddate)(TypoLocalDateTime.setter)}::timestamp
          where "productsubcategoryid" = ${Segment.paramSegment(productsubcategoryid)(ProductsubcategoryId.setter)}""".update.map(_ > 0)
  }
  override def update: UpdateBuilder[ProductsubcategoryFields, ProductsubcategoryRow] = {
    UpdateBuilder("production.productsubcategory", ProductsubcategoryFields.structure, ProductsubcategoryRow.jdbcDecoder)
  }
  override def upsert(unsaved: ProductsubcategoryRow): ZIO[ZConnection, Throwable, UpdateResult[ProductsubcategoryRow]] = {
    sql"""insert into production.productsubcategory("productsubcategoryid", "productcategoryid", "name", "rowguid", "modifieddate")
          values (
            ${Segment.paramSegment(unsaved.productsubcategoryid)(ProductsubcategoryId.setter)}::int4,
            ${Segment.paramSegment(unsaved.productcategoryid)(ProductcategoryId.setter)}::int4,
            ${Segment.paramSegment(unsaved.name)(Name.setter)}::varchar,
            ${Segment.paramSegment(unsaved.rowguid)(TypoUUID.setter)}::uuid,
            ${Segment.paramSegment(unsaved.modifieddate)(TypoLocalDateTime.setter)}::timestamp
          )
          on conflict ("productsubcategoryid")
          do update set
            "productcategoryid" = EXCLUDED."productcategoryid",
            "name" = EXCLUDED."name",
            "rowguid" = EXCLUDED."rowguid",
            "modifieddate" = EXCLUDED."modifieddate"
          returning "productsubcategoryid", "productcategoryid", "name", "rowguid", "modifieddate"::text""".insertReturning(ProductsubcategoryRow.jdbcDecoder)
  }
}
