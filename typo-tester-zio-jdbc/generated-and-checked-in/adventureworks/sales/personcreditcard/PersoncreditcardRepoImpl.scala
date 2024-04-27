/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package personcreditcard

import adventureworks.customtypes.Defaulted
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.person.businessentity.BusinessentityId
import adventureworks.streamingInsert
import adventureworks.userdefined.CustomCreditcardId
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql
import typo.dsl.UpdateBuilder
import zio.ZIO
import zio.jdbc.JdbcEncoder
import zio.jdbc.SqlFragment
import zio.jdbc.SqlFragment.Segment
import zio.jdbc.UpdateResult
import zio.jdbc.ZConnection
import zio.jdbc.sqlInterpolator
import zio.stream.ZStream

class PersoncreditcardRepoImpl extends PersoncreditcardRepo {
  override def delete: DeleteBuilder[PersoncreditcardFields, PersoncreditcardRow] = {
    DeleteBuilder("sales.personcreditcard", PersoncreditcardFields.structure)
  }
  override def deleteById(compositeId: PersoncreditcardId): ZIO[ZConnection, Throwable, Boolean] = {
    sql"""delete from sales.personcreditcard where "businessentityid" = ${Segment.paramSegment(compositeId.businessentityid)(BusinessentityId.setter)} AND "creditcardid" = ${Segment.paramSegment(compositeId.creditcardid)(/* user-picked */ CustomCreditcardId.setter)}""".delete.map(_ > 0)
  }
  override def deleteByIds(compositeIds: Array[PersoncreditcardId])(implicit encoder0: JdbcEncoder[Array[/* user-picked */ CustomCreditcardId]]): ZIO[ZConnection, Throwable, Long] = {
    val businessentityid = compositeIds.map(_.businessentityid)
    val creditcardid = compositeIds.map(_.creditcardid)
    sql"""delete
          from sales.personcreditcard
          where ("businessentityid", "creditcardid")
          in (select unnest(${businessentityid}), unnest(${creditcardid}))
       """.delete
    
  }
  override def insert(unsaved: PersoncreditcardRow): ZIO[ZConnection, Throwable, PersoncreditcardRow] = {
    sql"""insert into sales.personcreditcard("businessentityid", "creditcardid", "modifieddate")
          values (${Segment.paramSegment(unsaved.businessentityid)(BusinessentityId.setter)}::int4, ${Segment.paramSegment(unsaved.creditcardid)(/* user-picked */ CustomCreditcardId.setter)}::int4, ${Segment.paramSegment(unsaved.modifieddate)(TypoLocalDateTime.setter)}::timestamp)
          returning "businessentityid", "creditcardid", "modifieddate"::text
       """.insertReturning(using PersoncreditcardRow.jdbcDecoder).map(_.updatedKeys.head)
  }
  override def insert(unsaved: PersoncreditcardRowUnsaved): ZIO[ZConnection, Throwable, PersoncreditcardRow] = {
    val fs = List(
      Some((sql""""businessentityid"""", sql"${Segment.paramSegment(unsaved.businessentityid)(BusinessentityId.setter)}::int4")),
      Some((sql""""creditcardid"""", sql"${Segment.paramSegment(unsaved.creditcardid)(/* user-picked */ CustomCreditcardId.setter)}::int4")),
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((sql""""modifieddate"""", sql"${Segment.paramSegment(value: TypoLocalDateTime)(TypoLocalDateTime.setter)}::timestamp"))
      }
    ).flatten
    
    val q = if (fs.isEmpty) {
      sql"""insert into sales.personcreditcard default values
            returning "businessentityid", "creditcardid", "modifieddate"::text
         """
    } else {
      val names  = fs.map { case (n, _) => n }.mkFragment(SqlFragment(", "))
      val values = fs.map { case (_, f) => f }.mkFragment(SqlFragment(", "))
      sql"""insert into sales.personcreditcard($names) values ($values) returning "businessentityid", "creditcardid", "modifieddate"::text"""
    }
    q.insertReturning(using PersoncreditcardRow.jdbcDecoder).map(_.updatedKeys.head)
    
  }
  override def insertStreaming(unsaved: ZStream[ZConnection, Throwable, PersoncreditcardRow], batchSize: Int): ZIO[ZConnection, Throwable, Long] = {
    streamingInsert(s"""COPY sales.personcreditcard("businessentityid", "creditcardid", "modifieddate") FROM STDIN""", batchSize, unsaved)(PersoncreditcardRow.text)
  }
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  override def insertUnsavedStreaming(unsaved: ZStream[ZConnection, Throwable, PersoncreditcardRowUnsaved], batchSize: Int): ZIO[ZConnection, Throwable, Long] = {
    streamingInsert(s"""COPY sales.personcreditcard("businessentityid", "creditcardid", "modifieddate") FROM STDIN (DEFAULT '__DEFAULT_VALUE__')""", batchSize, unsaved)(PersoncreditcardRowUnsaved.text)
  }
  override def select: SelectBuilder[PersoncreditcardFields, PersoncreditcardRow] = {
    SelectBuilderSql("sales.personcreditcard", PersoncreditcardFields.structure, PersoncreditcardRow.jdbcDecoder)
  }
  override def selectAll: ZStream[ZConnection, Throwable, PersoncreditcardRow] = {
    sql"""select "businessentityid", "creditcardid", "modifieddate"::text from sales.personcreditcard""".query(using PersoncreditcardRow.jdbcDecoder).selectStream()
  }
  override def selectById(compositeId: PersoncreditcardId): ZIO[ZConnection, Throwable, Option[PersoncreditcardRow]] = {
    sql"""select "businessentityid", "creditcardid", "modifieddate"::text from sales.personcreditcard where "businessentityid" = ${Segment.paramSegment(compositeId.businessentityid)(BusinessentityId.setter)} AND "creditcardid" = ${Segment.paramSegment(compositeId.creditcardid)(/* user-picked */ CustomCreditcardId.setter)}""".query(using PersoncreditcardRow.jdbcDecoder).selectOne
  }
  override def selectByIds(compositeIds: Array[PersoncreditcardId])(implicit encoder0: JdbcEncoder[Array[/* user-picked */ CustomCreditcardId]]): ZStream[ZConnection, Throwable, PersoncreditcardRow] = {
    val businessentityid = compositeIds.map(_.businessentityid)
    val creditcardid = compositeIds.map(_.creditcardid)
    sql"""select "businessentityid", "creditcardid", "modifieddate"::text
          from sales.personcreditcard
          where ("businessentityid", "creditcardid")
          in (select unnest(${businessentityid}), unnest(${creditcardid}))
       """.query(using PersoncreditcardRow.jdbcDecoder).selectStream()
    
  }
  override def selectByIdsTracked(compositeIds: Array[PersoncreditcardId])(implicit encoder0: JdbcEncoder[Array[/* user-picked */ CustomCreditcardId]]): ZIO[ZConnection, Throwable, Map[PersoncreditcardId, Option[PersoncreditcardRow]]] = {
    selectByIds(compositeIds).runCollect.map { rows =>
      val byId = rows.view.map(x => (x.compositeId, x)).toMap
      compositeIds.view.map(id => (id, byId.get(id))).toMap
    }
  }
  override def update: UpdateBuilder[PersoncreditcardFields, PersoncreditcardRow] = {
    UpdateBuilder("sales.personcreditcard", PersoncreditcardFields.structure, PersoncreditcardRow.jdbcDecoder)
  }
  override def update(row: PersoncreditcardRow): ZIO[ZConnection, Throwable, Boolean] = {
    val compositeId = row.compositeId
    sql"""update sales.personcreditcard
          set "modifieddate" = ${Segment.paramSegment(row.modifieddate)(TypoLocalDateTime.setter)}::timestamp
          where "businessentityid" = ${Segment.paramSegment(compositeId.businessentityid)(BusinessentityId.setter)} AND "creditcardid" = ${Segment.paramSegment(compositeId.creditcardid)(/* user-picked */ CustomCreditcardId.setter)}""".update.map(_ > 0)
  }
  override def upsert(unsaved: PersoncreditcardRow): ZIO[ZConnection, Throwable, UpdateResult[PersoncreditcardRow]] = {
    sql"""insert into sales.personcreditcard("businessentityid", "creditcardid", "modifieddate")
          values (
            ${Segment.paramSegment(unsaved.businessentityid)(BusinessentityId.setter)}::int4,
            ${Segment.paramSegment(unsaved.creditcardid)(/* user-picked */ CustomCreditcardId.setter)}::int4,
            ${Segment.paramSegment(unsaved.modifieddate)(TypoLocalDateTime.setter)}::timestamp
          )
          on conflict ("businessentityid", "creditcardid")
          do update set
            "modifieddate" = EXCLUDED."modifieddate"
          returning "businessentityid", "creditcardid", "modifieddate"::text""".insertReturning(using PersoncreditcardRow.jdbcDecoder)
  }
}
