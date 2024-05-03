/**
 * File automatically generated by `typo` for its own test suite.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN
 */
package testdb
package hardcoded
package myschema
package person

import testdb.hardcoded.customtypes.Defaulted
import testdb.hardcoded.myschema.Number
import testdb.hardcoded.myschema.Sector
import testdb.hardcoded.myschema.football_club.FootballClubId
import testdb.hardcoded.myschema.marital_status.MaritalStatusId
import testdb.hardcoded.streamingInsert
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

class PersonRepoImpl extends PersonRepo {
  override def delete: DeleteBuilder[PersonFields, PersonRow] = {
    DeleteBuilder("myschema.person", PersonFields.structure)
  }
  override def deleteById(id: PersonId): ZIO[ZConnection, Throwable, Boolean] = {
    sql"""delete from myschema.person where "id" = ${Segment.paramSegment(id)(PersonId.setter)}""".delete.map(_ > 0)
  }
  override def deleteByIds(ids: Array[PersonId]): ZIO[ZConnection, Throwable, Long] = {
    sql"""delete from myschema.person where "id" = ANY(${ids})""".delete
  }
  override def insert(unsaved: PersonRow): ZIO[ZConnection, Throwable, PersonRow] = {
    sql"""insert into myschema.person("id", "favourite_football_club_id", "name", "nick_name", "blog_url", "email", "phone", "likes_pizza", "marital_status_id", "work_email", "sector", "favorite_number")
          values (${Segment.paramSegment(unsaved.id)(PersonId.setter)}::int8, ${Segment.paramSegment(unsaved.favouriteFootballClubId)(FootballClubId.setter)}, ${Segment.paramSegment(unsaved.name)(Setter.stringSetter)}, ${Segment.paramSegment(unsaved.nickName)(Setter.optionParamSetter(Setter.stringSetter))}, ${Segment.paramSegment(unsaved.blogUrl)(Setter.optionParamSetter(Setter.stringSetter))}, ${Segment.paramSegment(unsaved.email)(Setter.stringSetter)}, ${Segment.paramSegment(unsaved.phone)(Setter.stringSetter)}, ${Segment.paramSegment(unsaved.likesPizza)(Setter.booleanSetter)}, ${Segment.paramSegment(unsaved.maritalStatusId)(MaritalStatusId.setter)}, ${Segment.paramSegment(unsaved.workEmail)(Setter.optionParamSetter(Setter.stringSetter))}, ${Segment.paramSegment(unsaved.sector)(Sector.setter)}::myschema.sector, ${Segment.paramSegment(unsaved.favoriteNumber)(Number.setter)}::myschema.number)
          returning "id", "favourite_football_club_id", "name", "nick_name", "blog_url", "email", "phone", "likes_pizza", "marital_status_id", "work_email", "sector", "favorite_number"
       """.insertReturning(using PersonRow.jdbcDecoder).map(_.updatedKeys.head)
  }
  override def insert(unsaved: PersonRowUnsaved): ZIO[ZConnection, Throwable, PersonRow] = {
    val fs = List(
      Some((sql""""favourite_football_club_id"""", sql"${Segment.paramSegment(unsaved.favouriteFootballClubId)(FootballClubId.setter)}")),
      Some((sql""""name"""", sql"${Segment.paramSegment(unsaved.name)(Setter.stringSetter)}")),
      Some((sql""""nick_name"""", sql"${Segment.paramSegment(unsaved.nickName)(Setter.optionParamSetter(Setter.stringSetter))}")),
      Some((sql""""blog_url"""", sql"${Segment.paramSegment(unsaved.blogUrl)(Setter.optionParamSetter(Setter.stringSetter))}")),
      Some((sql""""email"""", sql"${Segment.paramSegment(unsaved.email)(Setter.stringSetter)}")),
      Some((sql""""phone"""", sql"${Segment.paramSegment(unsaved.phone)(Setter.stringSetter)}")),
      Some((sql""""likes_pizza"""", sql"${Segment.paramSegment(unsaved.likesPizza)(Setter.booleanSetter)}")),
      Some((sql""""work_email"""", sql"${Segment.paramSegment(unsaved.workEmail)(Setter.optionParamSetter(Setter.stringSetter))}")),
      unsaved.id match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((sql""""id"""", sql"${Segment.paramSegment(value: PersonId)(PersonId.setter)}::int8"))
      },
      unsaved.maritalStatusId match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((sql""""marital_status_id"""", sql"${Segment.paramSegment(value: MaritalStatusId)(MaritalStatusId.setter)}"))
      },
      unsaved.sector match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((sql""""sector"""", sql"${Segment.paramSegment(value: Sector)(Sector.setter)}::myschema.sector"))
      },
      unsaved.favoriteNumber match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((sql""""favorite_number"""", sql"${Segment.paramSegment(value: Number)(Number.setter)}::myschema.number"))
      }
    ).flatten
    
    val q = if (fs.isEmpty) {
      sql"""insert into myschema.person default values
            returning "id", "favourite_football_club_id", "name", "nick_name", "blog_url", "email", "phone", "likes_pizza", "marital_status_id", "work_email", "sector", "favorite_number"
         """
    } else {
      val names  = fs.map { case (n, _) => n }.mkFragment(SqlFragment(", "))
      val values = fs.map { case (_, f) => f }.mkFragment(SqlFragment(", "))
      sql"""insert into myschema.person($names) values ($values) returning "id", "favourite_football_club_id", "name", "nick_name", "blog_url", "email", "phone", "likes_pizza", "marital_status_id", "work_email", "sector", "favorite_number""""
    }
    q.insertReturning(using PersonRow.jdbcDecoder).map(_.updatedKeys.head)
    
  }
  override def insertStreaming(unsaved: ZStream[ZConnection, Throwable, PersonRow], batchSize: Int = 10000): ZIO[ZConnection, Throwable, Long] = {
    streamingInsert(s"""COPY myschema.person("id", "favourite_football_club_id", "name", "nick_name", "blog_url", "email", "phone", "likes_pizza", "marital_status_id", "work_email", "sector", "favorite_number") FROM STDIN""", batchSize, unsaved)(PersonRow.text)
  }
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  override def insertUnsavedStreaming(unsaved: ZStream[ZConnection, Throwable, PersonRowUnsaved], batchSize: Int = 10000): ZIO[ZConnection, Throwable, Long] = {
    streamingInsert(s"""COPY myschema.person("favourite_football_club_id", "name", "nick_name", "blog_url", "email", "phone", "likes_pizza", "work_email", "id", "marital_status_id", "sector", "favorite_number") FROM STDIN (DEFAULT '__DEFAULT_VALUE__')""", batchSize, unsaved)(PersonRowUnsaved.text)
  }
  override def select: SelectBuilder[PersonFields, PersonRow] = {
    SelectBuilderSql("myschema.person", PersonFields.structure, PersonRow.jdbcDecoder)
  }
  override def selectAll: ZStream[ZConnection, Throwable, PersonRow] = {
    sql"""select "id", "favourite_football_club_id", "name", "nick_name", "blog_url", "email", "phone", "likes_pizza", "marital_status_id", "work_email", "sector", "favorite_number" from myschema.person""".query(using PersonRow.jdbcDecoder).selectStream()
  }
  override def selectByFieldValues(fieldValues: List[PersonFieldOrIdValue[?]]): ZStream[ZConnection, Throwable, PersonRow] = {
    fieldValues match {
      case Nil      => selectAll
      case nonEmpty =>
        val wheres = SqlFragment.empty.and(
          nonEmpty.map {
            case PersonFieldValue.id(value) => sql""""id" = ${Segment.paramSegment(value)(PersonId.setter)}"""
            case PersonFieldValue.favouriteFootballClubId(value) => sql""""favourite_football_club_id" = ${Segment.paramSegment(value)(FootballClubId.setter)}"""
            case PersonFieldValue.name(value) => sql""""name" = ${Segment.paramSegment(value)(Setter.stringSetter)}"""
            case PersonFieldValue.nickName(value) => sql""""nick_name" = ${Segment.paramSegment(value)(Setter.optionParamSetter(Setter.stringSetter))}"""
            case PersonFieldValue.blogUrl(value) => sql""""blog_url" = ${Segment.paramSegment(value)(Setter.optionParamSetter(Setter.stringSetter))}"""
            case PersonFieldValue.email(value) => sql""""email" = ${Segment.paramSegment(value)(Setter.stringSetter)}"""
            case PersonFieldValue.phone(value) => sql""""phone" = ${Segment.paramSegment(value)(Setter.stringSetter)}"""
            case PersonFieldValue.likesPizza(value) => sql""""likes_pizza" = ${Segment.paramSegment(value)(Setter.booleanSetter)}"""
            case PersonFieldValue.maritalStatusId(value) => sql""""marital_status_id" = ${Segment.paramSegment(value)(MaritalStatusId.setter)}"""
            case PersonFieldValue.workEmail(value) => sql""""work_email" = ${Segment.paramSegment(value)(Setter.optionParamSetter(Setter.stringSetter))}"""
            case PersonFieldValue.sector(value) => sql""""sector" = ${Segment.paramSegment(value)(Sector.setter)}"""
            case PersonFieldValue.favoriteNumber(value) => sql""""favorite_number" = ${Segment.paramSegment(value)(Number.setter)}"""
          }
        )
        sql"""select "id", "favourite_football_club_id", "name", "nick_name", "blog_url", "email", "phone", "likes_pizza", "marital_status_id", "work_email", "sector", "favorite_number" from myschema.person where $wheres""".query(using PersonRow.jdbcDecoder).selectStream()
    }
  }
  override def selectById(id: PersonId): ZIO[ZConnection, Throwable, Option[PersonRow]] = {
    sql"""select "id", "favourite_football_club_id", "name", "nick_name", "blog_url", "email", "phone", "likes_pizza", "marital_status_id", "work_email", "sector", "favorite_number" from myschema.person where "id" = ${Segment.paramSegment(id)(PersonId.setter)}""".query(using PersonRow.jdbcDecoder).selectOne
  }
  override def selectByIds(ids: Array[PersonId]): ZStream[ZConnection, Throwable, PersonRow] = {
    sql"""select "id", "favourite_football_club_id", "name", "nick_name", "blog_url", "email", "phone", "likes_pizza", "marital_status_id", "work_email", "sector", "favorite_number" from myschema.person where "id" = ANY(${Segment.paramSegment(ids)(PersonId.arraySetter)})""".query(using PersonRow.jdbcDecoder).selectStream()
  }
  override def selectByIdsTracked(ids: Array[PersonId]): ZIO[ZConnection, Throwable, Map[PersonId, PersonRow]] = {
    selectByIds(ids).runCollect.map { rows =>
      val byId = rows.view.map(x => (x.id, x)).toMap
      ids.view.flatMap(id => byId.get(id).map(x => (id, x))).toMap
    }
  }
  override def update: UpdateBuilder[PersonFields, PersonRow] = {
    UpdateBuilder("myschema.person", PersonFields.structure, PersonRow.jdbcDecoder)
  }
  override def update(row: PersonRow): ZIO[ZConnection, Throwable, Boolean] = {
    val id = row.id
    sql"""update myschema.person
          set "favourite_football_club_id" = ${Segment.paramSegment(row.favouriteFootballClubId)(FootballClubId.setter)},
              "name" = ${Segment.paramSegment(row.name)(Setter.stringSetter)},
              "nick_name" = ${Segment.paramSegment(row.nickName)(Setter.optionParamSetter(Setter.stringSetter))},
              "blog_url" = ${Segment.paramSegment(row.blogUrl)(Setter.optionParamSetter(Setter.stringSetter))},
              "email" = ${Segment.paramSegment(row.email)(Setter.stringSetter)},
              "phone" = ${Segment.paramSegment(row.phone)(Setter.stringSetter)},
              "likes_pizza" = ${Segment.paramSegment(row.likesPizza)(Setter.booleanSetter)},
              "marital_status_id" = ${Segment.paramSegment(row.maritalStatusId)(MaritalStatusId.setter)},
              "work_email" = ${Segment.paramSegment(row.workEmail)(Setter.optionParamSetter(Setter.stringSetter))},
              "sector" = ${Segment.paramSegment(row.sector)(Sector.setter)}::myschema.sector,
              "favorite_number" = ${Segment.paramSegment(row.favoriteNumber)(Number.setter)}::myschema.number
          where "id" = ${Segment.paramSegment(id)(PersonId.setter)}""".update.map(_ > 0)
  }
  override def updateFieldValues(id: PersonId, fieldValues: List[PersonFieldValue[?]]): ZIO[ZConnection, Throwable, Boolean] = {
    NonEmptyChunk.fromIterableOption(fieldValues) match {
      case None           => ZIO.succeed(false)
      case Some(nonEmpty) =>
        val updates = nonEmpty.map { case PersonFieldValue.favouriteFootballClubId(value) => sql""""favourite_football_club_id" = ${Segment.paramSegment(value)(FootballClubId.setter)}"""
                                     case PersonFieldValue.name(value) => sql""""name" = ${Segment.paramSegment(value)(Setter.stringSetter)}"""
                                     case PersonFieldValue.nickName(value) => sql""""nick_name" = ${Segment.paramSegment(value)(Setter.optionParamSetter(Setter.stringSetter))}"""
                                     case PersonFieldValue.blogUrl(value) => sql""""blog_url" = ${Segment.paramSegment(value)(Setter.optionParamSetter(Setter.stringSetter))}"""
                                     case PersonFieldValue.email(value) => sql""""email" = ${Segment.paramSegment(value)(Setter.stringSetter)}"""
                                     case PersonFieldValue.phone(value) => sql""""phone" = ${Segment.paramSegment(value)(Setter.stringSetter)}"""
                                     case PersonFieldValue.likesPizza(value) => sql""""likes_pizza" = ${Segment.paramSegment(value)(Setter.booleanSetter)}"""
                                     case PersonFieldValue.maritalStatusId(value) => sql""""marital_status_id" = ${Segment.paramSegment(value)(MaritalStatusId.setter)}"""
                                     case PersonFieldValue.workEmail(value) => sql""""work_email" = ${Segment.paramSegment(value)(Setter.optionParamSetter(Setter.stringSetter))}"""
                                     case PersonFieldValue.sector(value) => sql""""sector" = ${Segment.paramSegment(value)(Sector.setter)}::myschema.sector"""
                                     case PersonFieldValue.favoriteNumber(value) => sql""""favorite_number" = ${Segment.paramSegment(value)(Number.setter)}::myschema.number""" }.mkFragment(SqlFragment(", "))
        sql"""update myschema.person
              set $updates
              where "id" = ${Segment.paramSegment(id)(PersonId.setter)}
           """.update.map(_ > 0)
    }
  }
  override def upsert(unsaved: PersonRow): ZIO[ZConnection, Throwable, UpdateResult[PersonRow]] = {
    sql"""insert into myschema.person("id", "favourite_football_club_id", "name", "nick_name", "blog_url", "email", "phone", "likes_pizza", "marital_status_id", "work_email", "sector", "favorite_number")
          values (
            ${Segment.paramSegment(unsaved.id)(PersonId.setter)}::int8,
            ${Segment.paramSegment(unsaved.favouriteFootballClubId)(FootballClubId.setter)},
            ${Segment.paramSegment(unsaved.name)(Setter.stringSetter)},
            ${Segment.paramSegment(unsaved.nickName)(Setter.optionParamSetter(Setter.stringSetter))},
            ${Segment.paramSegment(unsaved.blogUrl)(Setter.optionParamSetter(Setter.stringSetter))},
            ${Segment.paramSegment(unsaved.email)(Setter.stringSetter)},
            ${Segment.paramSegment(unsaved.phone)(Setter.stringSetter)},
            ${Segment.paramSegment(unsaved.likesPizza)(Setter.booleanSetter)},
            ${Segment.paramSegment(unsaved.maritalStatusId)(MaritalStatusId.setter)},
            ${Segment.paramSegment(unsaved.workEmail)(Setter.optionParamSetter(Setter.stringSetter))},
            ${Segment.paramSegment(unsaved.sector)(Sector.setter)}::myschema.sector,
            ${Segment.paramSegment(unsaved.favoriteNumber)(Number.setter)}::myschema.number
          )
          on conflict ("id")
          do update set
            "favourite_football_club_id" = EXCLUDED."favourite_football_club_id",
            "name" = EXCLUDED."name",
            "nick_name" = EXCLUDED."nick_name",
            "blog_url" = EXCLUDED."blog_url",
            "email" = EXCLUDED."email",
            "phone" = EXCLUDED."phone",
            "likes_pizza" = EXCLUDED."likes_pizza",
            "marital_status_id" = EXCLUDED."marital_status_id",
            "work_email" = EXCLUDED."work_email",
            "sector" = EXCLUDED."sector",
            "favorite_number" = EXCLUDED."favorite_number"
          returning "id", "favourite_football_club_id", "name", "nick_name", "blog_url", "email", "phone", "likes_pizza", "marital_status_id", "work_email", "sector", "favorite_number"""".insertReturning(using PersonRow.jdbcDecoder)
  }
}
