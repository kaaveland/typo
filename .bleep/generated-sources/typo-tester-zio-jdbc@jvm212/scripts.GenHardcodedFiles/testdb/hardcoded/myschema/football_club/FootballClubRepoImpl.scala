/**
 * File automatically generated by `typo` for its own test suite.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN
 */
package testdb
package hardcoded
package myschema
package football_club

import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql
import typo.dsl.UpdateBuilder
import zio.NonEmptyChunk
import zio.ZIO
import zio.jdbc.SqlFragment
import zio.jdbc.SqlFragment.Segment
import zio.jdbc.SqlFragment.Setter
import zio.jdbc.UpdateResult
import zio.jdbc.ZConnection
import zio.jdbc.sqlInterpolator
import zio.stream.ZStream

object FootballClubRepoImpl extends FootballClubRepo {
  override def delete(id: FootballClubId): ZIO[ZConnection, Throwable, Boolean] = {
    sql"""delete from myschema.football_club where "id" = ${Segment.paramSegment(id)(Setter[FootballClubId])}""".delete.map(_ > 0)
  }
  override def delete: DeleteBuilder[FootballClubFields, FootballClubRow] = {
    DeleteBuilder("myschema.football_club", FootballClubFields)
  }
  override def insert(unsaved: FootballClubRow): ZIO[ZConnection, Throwable, FootballClubRow] = {
    sql"""insert into myschema.football_club("id", "name")
          values (${Segment.paramSegment(unsaved.id)(Setter[FootballClubId])}::int8, ${Segment.paramSegment(unsaved.name)(Setter.stringSetter)})
          returning "id", "name"
       """.insertReturning(FootballClubRow.jdbcDecoder).map(_.updatedKeys.head)
  }
  override def select: SelectBuilder[FootballClubFields, FootballClubRow] = {
    SelectBuilderSql("myschema.football_club", FootballClubFields, FootballClubRow.jdbcDecoder)
  }
  override def selectAll: ZStream[ZConnection, Throwable, FootballClubRow] = {
    sql"""select "id", "name" from myschema.football_club""".query(FootballClubRow.jdbcDecoder).selectStream
  }
  override def selectById(id: FootballClubId): ZIO[ZConnection, Throwable, Option[FootballClubRow]] = {
    sql"""select "id", "name" from myschema.football_club where "id" = ${Segment.paramSegment(id)(Setter[FootballClubId])}""".query(FootballClubRow.jdbcDecoder).selectOne
  }
  override def selectByIds(ids: Array[FootballClubId]): ZStream[ZConnection, Throwable, FootballClubRow] = {
    sql"""select "id", "name" from myschema.football_club where "id" = ANY(${Segment.paramSegment(ids)(FootballClubId.arraySetter)})""".query(FootballClubRow.jdbcDecoder).selectStream
  }
  override def selectByFieldValues(fieldValues: List[FootballClubFieldOrIdValue[?]]): ZStream[ZConnection, Throwable, FootballClubRow] = {
    fieldValues match {
      case Nil      => selectAll
      case nonEmpty =>
        val wheres = SqlFragment.empty.and(
          nonEmpty.map {
            case FootballClubFieldValue.id(value) => sql""""id" = ${Segment.paramSegment(value)(Setter[FootballClubId])}"""
            case FootballClubFieldValue.name(value) => sql""""name" = ${Segment.paramSegment(value)(Setter.stringSetter)}"""
          }
        )
        sql"""select "id", "name" from myschema.football_club where $wheres""".query(FootballClubRow.jdbcDecoder).selectStream
    }
  }
  override def update(row: FootballClubRow): ZIO[ZConnection, Throwable, Boolean] = {
    val id = row.id
    sql"""update myschema.football_club
          set "name" = ${Segment.paramSegment(row.name)(Setter.stringSetter)}
          where "id" = ${Segment.paramSegment(id)(Setter[FootballClubId])}""".update.map(_ > 0)
  }
  override def update: UpdateBuilder[FootballClubFields, FootballClubRow] = {
    UpdateBuilder("myschema.football_club", FootballClubFields, FootballClubRow.jdbcDecoder)
  }
  override def updateFieldValues(id: FootballClubId, fieldValues: List[FootballClubFieldValue[?]]): ZIO[ZConnection, Throwable, Boolean] = {
    NonEmptyChunk.fromIterableOption(fieldValues) match {
      case None           => ZIO.succeed(false)
      case Some(nonEmpty) =>
        val updates = nonEmpty.map { case FootballClubFieldValue.name(value) => sql""""name" = ${Segment.paramSegment(value)(Setter.stringSetter)}""" }.mkFragment(SqlFragment(", "))
        sql"""update myschema.football_club
              set $updates
              where "id" = ${Segment.paramSegment(id)(Setter[FootballClubId])}
           """.update.map(_ > 0)
    }
  }
  override def upsert(unsaved: FootballClubRow): ZIO[ZConnection, Throwable, UpdateResult[FootballClubRow]] = {
    sql"""insert into myschema.football_club("id", "name")
          values (
            ${Segment.paramSegment(unsaved.id)(Setter[FootballClubId])}::int8,
            ${Segment.paramSegment(unsaved.name)(Setter.stringSetter)}
          )
          on conflict ("id")
          do update set
            "name" = EXCLUDED."name"
          returning "id", "name"""".insertReturning(FootballClubRow.jdbcDecoder)
  }
}
