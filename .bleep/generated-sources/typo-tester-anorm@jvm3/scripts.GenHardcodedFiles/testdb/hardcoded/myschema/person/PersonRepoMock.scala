/**
 * File automatically generated by `typo` for its own test suite.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN
 */
package testdb
package hardcoded
package myschema
package person

import java.sql.Connection
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

class PersonRepoMock(toRow: Function1[PersonRowUnsaved, PersonRow],
                     map: scala.collection.mutable.Map[PersonId, PersonRow] = scala.collection.mutable.Map.empty) extends PersonRepo {
  override def delete: DeleteBuilder[PersonFields, PersonRow] = {
    DeleteBuilderMock(DeleteParams.empty, PersonFields.structure.fields, map)
  }
  override def deleteById(id: PersonId)(implicit c: Connection): Boolean = {
    map.remove(id).isDefined
  }
  override def deleteByIds(ids: Array[PersonId])(implicit c: Connection): Int = {
    ids.map(id => map.remove(id)).count(_.isDefined)
  }
  override def insert(unsaved: PersonRow)(implicit c: Connection): PersonRow = {
    val _ = if (map.contains(unsaved.id))
      sys.error(s"id ${unsaved.id} already exists")
    else
      map.put(unsaved.id, unsaved)
    
    unsaved
  }
  override def insert(unsaved: PersonRowUnsaved)(implicit c: Connection): PersonRow = {
    insert(toRow(unsaved))
  }
  override def insertStreaming(unsaved: Iterator[PersonRow], batchSize: Int = 10000)(implicit c: Connection): Long = {
    unsaved.foreach { row =>
      map += (row.id -> row)
    }
    unsaved.size.toLong
  }
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  override def insertUnsavedStreaming(unsaved: Iterator[PersonRowUnsaved], batchSize: Int = 10000)(implicit c: Connection): Long = {
    unsaved.foreach { unsavedRow =>
      val row = toRow(unsavedRow)
      map += (row.id -> row)
    }
    unsaved.size.toLong
  }
  override def select: SelectBuilder[PersonFields, PersonRow] = {
    SelectBuilderMock(PersonFields.structure, () => map.values.toList, SelectParams.empty)
  }
  override def selectAll(implicit c: Connection): List[PersonRow] = {
    map.values.toList
  }
  override def selectByFieldValues(fieldValues: List[PersonFieldOrIdValue[?]])(implicit c: Connection): List[PersonRow] = {
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
    }.toList
  }
  override def selectById(id: PersonId)(implicit c: Connection): Option[PersonRow] = {
    map.get(id)
  }
  override def selectByIds(ids: Array[PersonId])(implicit c: Connection): List[PersonRow] = {
    ids.flatMap(map.get).toList
  }
  override def selectByIdsTracked(ids: Array[PersonId])(implicit c: Connection): Map[PersonId, PersonRow] = {
    val byId = selectByIds(ids).view.map(x => (x.id, x)).toMap
    ids.view.flatMap(id => byId.get(id).map(x => (id, x))).toMap
  }
  override def update: UpdateBuilder[PersonFields, PersonRow] = {
    UpdateBuilderMock(UpdateParams.empty, PersonFields.structure.fields, map)
  }
  override def update(row: PersonRow)(implicit c: Connection): Boolean = {
    map.get(row.id) match {
      case Some(`row`) => false
      case Some(_) =>
        map.put(row.id, row): @nowarn
        true
      case None => false
    }
  }
  override def updateFieldValues(id: PersonId, fieldValues: List[PersonFieldValue[?]])(implicit c: Connection): Boolean = {
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
  override def upsert(unsaved: PersonRow)(implicit c: Connection): PersonRow = {
    map.put(unsaved.id, unsaved): @nowarn
    unsaved
  }
}
