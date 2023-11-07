/**
 * File automatically generated by `typo` for its own test suite.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN
 */
package testdb
package hardcoded
package myschema
package person

import scala.annotation.nowarn
import typo.dsl.DeleteBuilder
import typo.dsl.DeleteBuilder.DeleteBuilderMock
import typo.dsl.DeleteParams
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderMock
import typo.dsl.SelectParams
import typo.dsl.UpdateBuilder
import typo.dsl.UpdateBuilder.UpdateBuilderMock
import typo.dsl.UpdateParams
import zio.Chunk
import zio.ZIO
import zio.jdbc.UpdateResult
import zio.jdbc.ZConnection
import zio.stream.ZStream

class PersonRepoMock(toRow: Function1[PersonRowUnsaved, PersonRow],
                     map: scala.collection.mutable.Map[PersonId, PersonRow] = scala.collection.mutable.Map.empty) extends PersonRepo {
  override def delete(id: PersonId): ZIO[ZConnection, Throwable, Boolean] = {
    ZIO.succeed(map.remove(id).isDefined)
  }
  override def delete: DeleteBuilder[PersonFields, PersonRow] = {
    DeleteBuilderMock(DeleteParams.empty, PersonFields, map)
  }
  override def insert(unsaved: PersonRow): ZIO[ZConnection, Throwable, PersonRow] = {
    ZIO.succeed {
      val _ =
        if (map.contains(unsaved.id))
          sys.error(s"id ${unsaved.id} already exists")
        else
          map.put(unsaved.id, unsaved)
    
      unsaved
    }
  }
  override def insert(unsaved: PersonRowUnsaved): ZIO[ZConnection, Throwable, PersonRow] = {
    insert(toRow(unsaved))
  }
  override def select: SelectBuilder[PersonFields, PersonRow] = {
    SelectBuilderMock(PersonFields, ZIO.succeed(Chunk.fromIterable(map.values)), SelectParams.empty)
  }
  override def selectAll: ZStream[ZConnection, Throwable, PersonRow] = {
    ZStream.fromIterable(map.values)
  }
  override def selectById(id: PersonId): ZIO[ZConnection, Throwable, Option[PersonRow]] = {
    ZIO.succeed(map.get(id))
  }
  override def selectByIds(ids: Array[PersonId]): ZStream[ZConnection, Throwable, PersonRow] = {
    ZStream.fromIterable(ids.flatMap(map.get))
  }
  override def selectByFieldValues(fieldValues: List[PersonFieldOrIdValue[?]]): ZStream[ZConnection, Throwable, PersonRow] = {
    ZStream.fromIterable {
      fieldValues.foldLeft(map.values) {
        case (acc, PersonFieldValue.id(value)) => acc.filter(_.id == value)
        case (acc, PersonFieldValue.favouriteFootballClubId(value)) => acc.filter(_.favouriteFootballClubId == value)
        case (acc, PersonFieldValue.name(value)) => acc.filter(_.name == value)
        case (acc, PersonFieldValue.nickName(value)) => acc.filter(_.nickName == value)
        case (acc, PersonFieldValue.blogUrl(value)) => acc.filter(_.blogUrl == value)
        case (acc, PersonFieldValue.email(value)) => acc.filter(_.email == value)
        case (acc, PersonFieldValue.phone(value)) => acc.filter(_.phone == value)
        case (acc, PersonFieldValue.likesPizza(value)) => acc.filter(_.likesPizza == value)
        case (acc, PersonFieldValue.maritalStatusId(value)) => acc.filter(_.maritalStatusId == value)
        case (acc, PersonFieldValue.workEmail(value)) => acc.filter(_.workEmail == value)
        case (acc, PersonFieldValue.sector(value)) => acc.filter(_.sector == value)
        case (acc, PersonFieldValue.favoriteNumber(value)) => acc.filter(_.favoriteNumber == value)
      }
    }
  }
  override def update(row: PersonRow): ZIO[ZConnection, Throwable, Boolean] = {
    ZIO.succeed {
      map.get(row.id) match {
        case Some(`row`) => false
        case Some(_) =>
          map.put(row.id, row): @nowarn
          true
        case None => false
      }
    }
  }
  override def update: UpdateBuilder[PersonFields, PersonRow] = {
    UpdateBuilderMock(UpdateParams.empty, PersonFields, map)
  }
  override def updateFieldValues(id: PersonId, fieldValues: List[PersonFieldValue[?]]): ZIO[ZConnection, Throwable, Boolean] = {
    ZIO.succeed {
      map.get(id) match {
        case Some(oldRow) =>
          val updatedRow = fieldValues.foldLeft(oldRow) {
            case (acc, PersonFieldValue.favouriteFootballClubId(value)) => acc.copy(favouriteFootballClubId = value)
            case (acc, PersonFieldValue.name(value)) => acc.copy(name = value)
            case (acc, PersonFieldValue.nickName(value)) => acc.copy(nickName = value)
            case (acc, PersonFieldValue.blogUrl(value)) => acc.copy(blogUrl = value)
            case (acc, PersonFieldValue.email(value)) => acc.copy(email = value)
            case (acc, PersonFieldValue.phone(value)) => acc.copy(phone = value)
            case (acc, PersonFieldValue.likesPizza(value)) => acc.copy(likesPizza = value)
            case (acc, PersonFieldValue.maritalStatusId(value)) => acc.copy(maritalStatusId = value)
            case (acc, PersonFieldValue.workEmail(value)) => acc.copy(workEmail = value)
            case (acc, PersonFieldValue.sector(value)) => acc.copy(sector = value)
            case (acc, PersonFieldValue.favoriteNumber(value)) => acc.copy(favoriteNumber = value)
          }
          if (updatedRow != oldRow) {
            map.put(id, updatedRow): @nowarn
            true
          } else {
            false
          }
        case None => false
      }
    }
  }
  override def upsert(unsaved: PersonRow): ZIO[ZConnection, Throwable, UpdateResult[PersonRow]] = {
    ZIO.succeed {
      map.put(unsaved.id, unsaved): @nowarn
      UpdateResult(1, Chunk.single(unsaved))
    }
  }
}
