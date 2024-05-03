/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package productdocument

import adventureworks.customtypes.Defaulted
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.production.document.DocumentId
import adventureworks.production.product.ProductId
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

class ProductdocumentRepoImpl extends ProductdocumentRepo {
  override def delete: DeleteBuilder[ProductdocumentFields, ProductdocumentRow] = {
    DeleteBuilder("production.productdocument", ProductdocumentFields.structure)
  }
  override def deleteById(compositeId: ProductdocumentId): ZIO[ZConnection, Throwable, Boolean] = {
    sql"""delete from production.productdocument where "productid" = ${Segment.paramSegment(compositeId.productid)(ProductId.setter)} AND "documentnode" = ${Segment.paramSegment(compositeId.documentnode)(DocumentId.setter)}""".delete.map(_ > 0)
  }
  override def deleteByIds(compositeIds: Array[ProductdocumentId]): ZIO[ZConnection, Throwable, Long] = {
    val productid = compositeIds.map(_.productid)
    val documentnode = compositeIds.map(_.documentnode)
    sql"""delete
          from production.productdocument
          where ("productid", "documentnode")
          in (select unnest(${productid}), unnest(${documentnode}))
       """.delete
    
  }
  override def insert(unsaved: ProductdocumentRow): ZIO[ZConnection, Throwable, ProductdocumentRow] = {
    sql"""insert into production.productdocument("productid", "modifieddate", "documentnode")
          values (${Segment.paramSegment(unsaved.productid)(ProductId.setter)}::int4, ${Segment.paramSegment(unsaved.modifieddate)(TypoLocalDateTime.setter)}::timestamp, ${Segment.paramSegment(unsaved.documentnode)(DocumentId.setter)})
          returning "productid", "modifieddate"::text, "documentnode"
       """.insertReturning(using ProductdocumentRow.jdbcDecoder).map(_.updatedKeys.head)
  }
  override def insert(unsaved: ProductdocumentRowUnsaved): ZIO[ZConnection, Throwable, ProductdocumentRow] = {
    val fs = List(
      Some((sql""""productid"""", sql"${Segment.paramSegment(unsaved.productid)(ProductId.setter)}::int4")),
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((sql""""modifieddate"""", sql"${Segment.paramSegment(value: TypoLocalDateTime)(TypoLocalDateTime.setter)}::timestamp"))
      },
      unsaved.documentnode match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((sql""""documentnode"""", sql"${Segment.paramSegment(value: DocumentId)(DocumentId.setter)}"))
      }
    ).flatten
    
    val q = if (fs.isEmpty) {
      sql"""insert into production.productdocument default values
            returning "productid", "modifieddate"::text, "documentnode"
         """
    } else {
      val names  = fs.map { case (n, _) => n }.mkFragment(SqlFragment(", "))
      val values = fs.map { case (_, f) => f }.mkFragment(SqlFragment(", "))
      sql"""insert into production.productdocument($names) values ($values) returning "productid", "modifieddate"::text, "documentnode""""
    }
    q.insertReturning(using ProductdocumentRow.jdbcDecoder).map(_.updatedKeys.head)
    
  }
  override def insertStreaming(unsaved: ZStream[ZConnection, Throwable, ProductdocumentRow], batchSize: Int = 10000): ZIO[ZConnection, Throwable, Long] = {
    streamingInsert(s"""COPY production.productdocument("productid", "modifieddate", "documentnode") FROM STDIN""", batchSize, unsaved)(ProductdocumentRow.text)
  }
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  override def insertUnsavedStreaming(unsaved: ZStream[ZConnection, Throwable, ProductdocumentRowUnsaved], batchSize: Int = 10000): ZIO[ZConnection, Throwable, Long] = {
    streamingInsert(s"""COPY production.productdocument("productid", "modifieddate", "documentnode") FROM STDIN (DEFAULT '__DEFAULT_VALUE__')""", batchSize, unsaved)(ProductdocumentRowUnsaved.text)
  }
  override def select: SelectBuilder[ProductdocumentFields, ProductdocumentRow] = {
    SelectBuilderSql("production.productdocument", ProductdocumentFields.structure, ProductdocumentRow.jdbcDecoder)
  }
  override def selectAll: ZStream[ZConnection, Throwable, ProductdocumentRow] = {
    sql"""select "productid", "modifieddate"::text, "documentnode" from production.productdocument""".query(using ProductdocumentRow.jdbcDecoder).selectStream()
  }
  override def selectById(compositeId: ProductdocumentId): ZIO[ZConnection, Throwable, Option[ProductdocumentRow]] = {
    sql"""select "productid", "modifieddate"::text, "documentnode" from production.productdocument where "productid" = ${Segment.paramSegment(compositeId.productid)(ProductId.setter)} AND "documentnode" = ${Segment.paramSegment(compositeId.documentnode)(DocumentId.setter)}""".query(using ProductdocumentRow.jdbcDecoder).selectOne
  }
  override def selectByIds(compositeIds: Array[ProductdocumentId]): ZStream[ZConnection, Throwable, ProductdocumentRow] = {
    val productid = compositeIds.map(_.productid)
    val documentnode = compositeIds.map(_.documentnode)
    sql"""select "productid", "modifieddate"::text, "documentnode"
          from production.productdocument
          where ("productid", "documentnode")
          in (select unnest(${productid}), unnest(${documentnode}))
       """.query(using ProductdocumentRow.jdbcDecoder).selectStream()
    
  }
  override def selectByIdsTracked(compositeIds: Array[ProductdocumentId]): ZIO[ZConnection, Throwable, Map[ProductdocumentId, ProductdocumentRow]] = {
    selectByIds(compositeIds).runCollect.map { rows =>
      val byId = rows.view.map(x => (x.compositeId, x)).toMap
      compositeIds.view.flatMap(id => byId.get(id).map(x => (id, x))).toMap
    }
  }
  override def update: UpdateBuilder[ProductdocumentFields, ProductdocumentRow] = {
    UpdateBuilder("production.productdocument", ProductdocumentFields.structure, ProductdocumentRow.jdbcDecoder)
  }
  override def update(row: ProductdocumentRow): ZIO[ZConnection, Throwable, Boolean] = {
    val compositeId = row.compositeId
    sql"""update production.productdocument
          set "modifieddate" = ${Segment.paramSegment(row.modifieddate)(TypoLocalDateTime.setter)}::timestamp
          where "productid" = ${Segment.paramSegment(compositeId.productid)(ProductId.setter)} AND "documentnode" = ${Segment.paramSegment(compositeId.documentnode)(DocumentId.setter)}""".update.map(_ > 0)
  }
  override def upsert(unsaved: ProductdocumentRow): ZIO[ZConnection, Throwable, UpdateResult[ProductdocumentRow]] = {
    sql"""insert into production.productdocument("productid", "modifieddate", "documentnode")
          values (
            ${Segment.paramSegment(unsaved.productid)(ProductId.setter)}::int4,
            ${Segment.paramSegment(unsaved.modifieddate)(TypoLocalDateTime.setter)}::timestamp,
            ${Segment.paramSegment(unsaved.documentnode)(DocumentId.setter)}
          )
          on conflict ("productid", "documentnode")
          do update set
            "modifieddate" = EXCLUDED."modifieddate"
          returning "productid", "modifieddate"::text, "documentnode"""".insertReturning(using ProductdocumentRow.jdbcDecoder)
  }
}
