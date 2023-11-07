/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package productcategory

import adventureworks.customtypes.Defaulted
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoUUID
import adventureworks.public.Name
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

object ProductcategoryRepoImpl extends ProductcategoryRepo {
  override def delete(productcategoryid: ProductcategoryId): ZIO[ZConnection, Throwable, Boolean] = {
    sql"""delete from production.productcategory where "productcategoryid" = ${Segment.paramSegment(productcategoryid)(ProductcategoryId.setter)}""".delete.map(_ > 0)
  }
  override def delete: DeleteBuilder[ProductcategoryFields, ProductcategoryRow] = {
    DeleteBuilder("production.productcategory", ProductcategoryFields)
  }
  override def insert(unsaved: ProductcategoryRow): ZIO[ZConnection, Throwable, ProductcategoryRow] = {
    sql"""insert into production.productcategory("productcategoryid", "name", "rowguid", "modifieddate")
          values (${Segment.paramSegment(unsaved.productcategoryid)(ProductcategoryId.setter)}::int4, ${Segment.paramSegment(unsaved.name)(Name.setter)}::varchar, ${Segment.paramSegment(unsaved.rowguid)(TypoUUID.setter)}::uuid, ${Segment.paramSegment(unsaved.modifieddate)(TypoLocalDateTime.setter)}::timestamp)
          returning "productcategoryid", "name", "rowguid", "modifieddate"::text
       """.insertReturning(ProductcategoryRow.jdbcDecoder).map(_.updatedKeys.head)
  }
  override def insert(unsaved: ProductcategoryRowUnsaved): ZIO[ZConnection, Throwable, ProductcategoryRow] = {
    val fs = List(
      Some((sql""""name"""", sql"${Segment.paramSegment(unsaved.name)(Name.setter)}::varchar")),
      unsaved.productcategoryid match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((sql""""productcategoryid"""", sql"${Segment.paramSegment(value: ProductcategoryId)(ProductcategoryId.setter)}::int4"))
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
      sql"""insert into production.productcategory default values
            returning "productcategoryid", "name", "rowguid", "modifieddate"::text
         """
    } else {
      val names  = fs.map { case (n, _) => n }.mkFragment(SqlFragment(", "))
      val values = fs.map { case (_, f) => f }.mkFragment(SqlFragment(", "))
      sql"""insert into production.productcategory($names) values ($values) returning "productcategoryid", "name", "rowguid", "modifieddate"::text"""
    }
    q.insertReturning(ProductcategoryRow.jdbcDecoder).map(_.updatedKeys.head)
    
  }
  override def select: SelectBuilder[ProductcategoryFields, ProductcategoryRow] = {
    SelectBuilderSql("production.productcategory", ProductcategoryFields, ProductcategoryRow.jdbcDecoder)
  }
  override def selectAll: ZStream[ZConnection, Throwable, ProductcategoryRow] = {
    sql"""select "productcategoryid", "name", "rowguid", "modifieddate"::text from production.productcategory""".query(ProductcategoryRow.jdbcDecoder).selectStream
  }
  override def selectById(productcategoryid: ProductcategoryId): ZIO[ZConnection, Throwable, Option[ProductcategoryRow]] = {
    sql"""select "productcategoryid", "name", "rowguid", "modifieddate"::text from production.productcategory where "productcategoryid" = ${Segment.paramSegment(productcategoryid)(ProductcategoryId.setter)}""".query(ProductcategoryRow.jdbcDecoder).selectOne
  }
  override def selectByIds(productcategoryids: Array[ProductcategoryId]): ZStream[ZConnection, Throwable, ProductcategoryRow] = {
    sql"""select "productcategoryid", "name", "rowguid", "modifieddate"::text from production.productcategory where "productcategoryid" = ANY(${Segment.paramSegment(productcategoryids)(ProductcategoryId.arraySetter)})""".query(ProductcategoryRow.jdbcDecoder).selectStream
  }
  override def update(row: ProductcategoryRow): ZIO[ZConnection, Throwable, Boolean] = {
    val productcategoryid = row.productcategoryid
    sql"""update production.productcategory
          set "name" = ${Segment.paramSegment(row.name)(Name.setter)}::varchar,
              "rowguid" = ${Segment.paramSegment(row.rowguid)(TypoUUID.setter)}::uuid,
              "modifieddate" = ${Segment.paramSegment(row.modifieddate)(TypoLocalDateTime.setter)}::timestamp
          where "productcategoryid" = ${Segment.paramSegment(productcategoryid)(ProductcategoryId.setter)}""".update.map(_ > 0)
  }
  override def update: UpdateBuilder[ProductcategoryFields, ProductcategoryRow] = {
    UpdateBuilder("production.productcategory", ProductcategoryFields, ProductcategoryRow.jdbcDecoder)
  }
  override def upsert(unsaved: ProductcategoryRow): ZIO[ZConnection, Throwable, UpdateResult[ProductcategoryRow]] = {
    sql"""insert into production.productcategory("productcategoryid", "name", "rowguid", "modifieddate")
          values (
            ${Segment.paramSegment(unsaved.productcategoryid)(ProductcategoryId.setter)}::int4,
            ${Segment.paramSegment(unsaved.name)(Name.setter)}::varchar,
            ${Segment.paramSegment(unsaved.rowguid)(TypoUUID.setter)}::uuid,
            ${Segment.paramSegment(unsaved.modifieddate)(TypoLocalDateTime.setter)}::timestamp
          )
          on conflict ("productcategoryid")
          do update set
            "name" = EXCLUDED."name",
            "rowguid" = EXCLUDED."rowguid",
            "modifieddate" = EXCLUDED."modifieddate"
          returning "productcategoryid", "name", "rowguid", "modifieddate"::text""".insertReturning(ProductcategoryRow.jdbcDecoder)
  }
}
