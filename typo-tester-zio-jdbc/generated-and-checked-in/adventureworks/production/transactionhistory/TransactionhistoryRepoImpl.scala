/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package transactionhistory

import adventureworks.customtypes.Defaulted
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.production.product.ProductId
import adventureworks.streamingInsert
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

class TransactionhistoryRepoImpl extends TransactionhistoryRepo {
  override def delete(transactionid: TransactionhistoryId): ZIO[ZConnection, Throwable, Boolean] = {
    sql"""delete from production.transactionhistory where "transactionid" = ${Segment.paramSegment(transactionid)(TransactionhistoryId.setter)}""".delete.map(_ > 0)
  }
  override def delete: DeleteBuilder[TransactionhistoryFields, TransactionhistoryRow] = {
    DeleteBuilder("production.transactionhistory", TransactionhistoryFields.structure)
  }
  override def insert(unsaved: TransactionhistoryRow): ZIO[ZConnection, Throwable, TransactionhistoryRow] = {
    sql"""insert into production.transactionhistory("transactionid", "productid", "referenceorderid", "referenceorderlineid", "transactiondate", "transactiontype", "quantity", "actualcost", "modifieddate")
          values (${Segment.paramSegment(unsaved.transactionid)(TransactionhistoryId.setter)}::int4, ${Segment.paramSegment(unsaved.productid)(ProductId.setter)}::int4, ${Segment.paramSegment(unsaved.referenceorderid)(Setter.intSetter)}::int4, ${Segment.paramSegment(unsaved.referenceorderlineid)(Setter.intSetter)}::int4, ${Segment.paramSegment(unsaved.transactiondate)(TypoLocalDateTime.setter)}::timestamp, ${Segment.paramSegment(unsaved.transactiontype)(Setter.stringSetter)}::bpchar, ${Segment.paramSegment(unsaved.quantity)(Setter.intSetter)}::int4, ${Segment.paramSegment(unsaved.actualcost)(Setter.bigDecimalScalaSetter)}::numeric, ${Segment.paramSegment(unsaved.modifieddate)(TypoLocalDateTime.setter)}::timestamp)
          returning "transactionid", "productid", "referenceorderid", "referenceorderlineid", "transactiondate"::text, "transactiontype", "quantity", "actualcost", "modifieddate"::text
       """.insertReturning(using TransactionhistoryRow.jdbcDecoder).map(_.updatedKeys.head)
  }
  override def insertStreaming(unsaved: ZStream[ZConnection, Throwable, TransactionhistoryRow], batchSize: Int): ZIO[ZConnection, Throwable, Long] = {
    streamingInsert(s"""COPY production.transactionhistory("transactionid", "productid", "referenceorderid", "referenceorderlineid", "transactiondate", "transactiontype", "quantity", "actualcost", "modifieddate") FROM STDIN""", batchSize, unsaved)(TransactionhistoryRow.text)
  }
  override def insert(unsaved: TransactionhistoryRowUnsaved): ZIO[ZConnection, Throwable, TransactionhistoryRow] = {
    val fs = List(
      Some((sql""""productid"""", sql"${Segment.paramSegment(unsaved.productid)(ProductId.setter)}::int4")),
      Some((sql""""referenceorderid"""", sql"${Segment.paramSegment(unsaved.referenceorderid)(Setter.intSetter)}::int4")),
      Some((sql""""transactiontype"""", sql"${Segment.paramSegment(unsaved.transactiontype)(Setter.stringSetter)}::bpchar")),
      Some((sql""""quantity"""", sql"${Segment.paramSegment(unsaved.quantity)(Setter.intSetter)}::int4")),
      Some((sql""""actualcost"""", sql"${Segment.paramSegment(unsaved.actualcost)(Setter.bigDecimalScalaSetter)}::numeric")),
      unsaved.transactionid match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((sql""""transactionid"""", sql"${Segment.paramSegment(value: TransactionhistoryId)(TransactionhistoryId.setter)}::int4"))
      },
      unsaved.referenceorderlineid match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((sql""""referenceorderlineid"""", sql"${Segment.paramSegment(value: Int)(Setter.intSetter)}::int4"))
      },
      unsaved.transactiondate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((sql""""transactiondate"""", sql"${Segment.paramSegment(value: TypoLocalDateTime)(TypoLocalDateTime.setter)}::timestamp"))
      },
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((sql""""modifieddate"""", sql"${Segment.paramSegment(value: TypoLocalDateTime)(TypoLocalDateTime.setter)}::timestamp"))
      }
    ).flatten
    
    val q = if (fs.isEmpty) {
      sql"""insert into production.transactionhistory default values
            returning "transactionid", "productid", "referenceorderid", "referenceorderlineid", "transactiondate"::text, "transactiontype", "quantity", "actualcost", "modifieddate"::text
         """
    } else {
      val names  = fs.map { case (n, _) => n }.mkFragment(SqlFragment(", "))
      val values = fs.map { case (_, f) => f }.mkFragment(SqlFragment(", "))
      sql"""insert into production.transactionhistory($names) values ($values) returning "transactionid", "productid", "referenceorderid", "referenceorderlineid", "transactiondate"::text, "transactiontype", "quantity", "actualcost", "modifieddate"::text"""
    }
    q.insertReturning(using TransactionhistoryRow.jdbcDecoder).map(_.updatedKeys.head)
    
  }
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  override def insertUnsavedStreaming(unsaved: ZStream[ZConnection, Throwable, TransactionhistoryRowUnsaved], batchSize: Int): ZIO[ZConnection, Throwable, Long] = {
    streamingInsert(s"""COPY production.transactionhistory("productid", "referenceorderid", "transactiontype", "quantity", "actualcost", "transactionid", "referenceorderlineid", "transactiondate", "modifieddate") FROM STDIN (DEFAULT '__DEFAULT_VALUE__')""", batchSize, unsaved)(TransactionhistoryRowUnsaved.text)
  }
  override def select: SelectBuilder[TransactionhistoryFields, TransactionhistoryRow] = {
    SelectBuilderSql("production.transactionhistory", TransactionhistoryFields.structure, TransactionhistoryRow.jdbcDecoder)
  }
  override def selectAll: ZStream[ZConnection, Throwable, TransactionhistoryRow] = {
    sql"""select "transactionid", "productid", "referenceorderid", "referenceorderlineid", "transactiondate"::text, "transactiontype", "quantity", "actualcost", "modifieddate"::text from production.transactionhistory""".query(using TransactionhistoryRow.jdbcDecoder).selectStream()
  }
  override def selectById(transactionid: TransactionhistoryId): ZIO[ZConnection, Throwable, Option[TransactionhistoryRow]] = {
    sql"""select "transactionid", "productid", "referenceorderid", "referenceorderlineid", "transactiondate"::text, "transactiontype", "quantity", "actualcost", "modifieddate"::text from production.transactionhistory where "transactionid" = ${Segment.paramSegment(transactionid)(TransactionhistoryId.setter)}""".query(using TransactionhistoryRow.jdbcDecoder).selectOne
  }
  override def selectByIds(transactionids: Array[TransactionhistoryId]): ZStream[ZConnection, Throwable, TransactionhistoryRow] = {
    sql"""select "transactionid", "productid", "referenceorderid", "referenceorderlineid", "transactiondate"::text, "transactiontype", "quantity", "actualcost", "modifieddate"::text from production.transactionhistory where "transactionid" = ANY(${Segment.paramSegment(transactionids)(TransactionhistoryId.arraySetter)})""".query(using TransactionhistoryRow.jdbcDecoder).selectStream()
  }
  override def update(row: TransactionhistoryRow): ZIO[ZConnection, Throwable, Boolean] = {
    val transactionid = row.transactionid
    sql"""update production.transactionhistory
          set "productid" = ${Segment.paramSegment(row.productid)(ProductId.setter)}::int4,
              "referenceorderid" = ${Segment.paramSegment(row.referenceorderid)(Setter.intSetter)}::int4,
              "referenceorderlineid" = ${Segment.paramSegment(row.referenceorderlineid)(Setter.intSetter)}::int4,
              "transactiondate" = ${Segment.paramSegment(row.transactiondate)(TypoLocalDateTime.setter)}::timestamp,
              "transactiontype" = ${Segment.paramSegment(row.transactiontype)(Setter.stringSetter)}::bpchar,
              "quantity" = ${Segment.paramSegment(row.quantity)(Setter.intSetter)}::int4,
              "actualcost" = ${Segment.paramSegment(row.actualcost)(Setter.bigDecimalScalaSetter)}::numeric,
              "modifieddate" = ${Segment.paramSegment(row.modifieddate)(TypoLocalDateTime.setter)}::timestamp
          where "transactionid" = ${Segment.paramSegment(transactionid)(TransactionhistoryId.setter)}""".update.map(_ > 0)
  }
  override def update: UpdateBuilder[TransactionhistoryFields, TransactionhistoryRow] = {
    UpdateBuilder("production.transactionhistory", TransactionhistoryFields.structure, TransactionhistoryRow.jdbcDecoder)
  }
  override def upsert(unsaved: TransactionhistoryRow): ZIO[ZConnection, Throwable, UpdateResult[TransactionhistoryRow]] = {
    sql"""insert into production.transactionhistory("transactionid", "productid", "referenceorderid", "referenceorderlineid", "transactiondate", "transactiontype", "quantity", "actualcost", "modifieddate")
          values (
            ${Segment.paramSegment(unsaved.transactionid)(TransactionhistoryId.setter)}::int4,
            ${Segment.paramSegment(unsaved.productid)(ProductId.setter)}::int4,
            ${Segment.paramSegment(unsaved.referenceorderid)(Setter.intSetter)}::int4,
            ${Segment.paramSegment(unsaved.referenceorderlineid)(Setter.intSetter)}::int4,
            ${Segment.paramSegment(unsaved.transactiondate)(TypoLocalDateTime.setter)}::timestamp,
            ${Segment.paramSegment(unsaved.transactiontype)(Setter.stringSetter)}::bpchar,
            ${Segment.paramSegment(unsaved.quantity)(Setter.intSetter)}::int4,
            ${Segment.paramSegment(unsaved.actualcost)(Setter.bigDecimalScalaSetter)}::numeric,
            ${Segment.paramSegment(unsaved.modifieddate)(TypoLocalDateTime.setter)}::timestamp
          )
          on conflict ("transactionid")
          do update set
            "productid" = EXCLUDED."productid",
            "referenceorderid" = EXCLUDED."referenceorderid",
            "referenceorderlineid" = EXCLUDED."referenceorderlineid",
            "transactiondate" = EXCLUDED."transactiondate",
            "transactiontype" = EXCLUDED."transactiontype",
            "quantity" = EXCLUDED."quantity",
            "actualcost" = EXCLUDED."actualcost",
            "modifieddate" = EXCLUDED."modifieddate"
          returning "transactionid", "productid", "referenceorderid", "referenceorderlineid", "transactiondate"::text, "transactiontype", "quantity", "actualcost", "modifieddate"::text""".insertReturning(using TransactionhistoryRow.jdbcDecoder)
  }
}
