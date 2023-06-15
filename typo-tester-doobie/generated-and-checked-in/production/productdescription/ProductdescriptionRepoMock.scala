/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package productdescription

import doobie.free.connection.ConnectionIO
import doobie.free.connection.delay
import fs2.Stream

class ProductdescriptionRepoMock(toRow: Function1[ProductdescriptionRowUnsaved, ProductdescriptionRow],
                                 map: scala.collection.mutable.Map[ProductdescriptionId, ProductdescriptionRow] = scala.collection.mutable.Map.empty) extends ProductdescriptionRepo {
  override def delete(productdescriptionid: ProductdescriptionId): ConnectionIO[Boolean] = {
    delay(map.remove(productdescriptionid).isDefined)
  }
  override def insert(unsaved: ProductdescriptionRow): ConnectionIO[ProductdescriptionRow] = {
    delay {
      if (map.contains(unsaved.productdescriptionid))
        sys.error(s"id ${unsaved.productdescriptionid} already exists")
      else
        map.put(unsaved.productdescriptionid, unsaved)
      unsaved
    }
  }
  override def insert(unsaved: ProductdescriptionRowUnsaved): ConnectionIO[ProductdescriptionRow] = {
    insert(toRow(unsaved))
  }
  override def selectAll: Stream[ConnectionIO, ProductdescriptionRow] = {
    Stream.emits(map.values.toList)
  }
  override def selectByFieldValues(fieldValues: List[ProductdescriptionFieldOrIdValue[_]]): Stream[ConnectionIO, ProductdescriptionRow] = {
    Stream.emits {
      fieldValues.foldLeft(map.values) {
        case (acc, ProductdescriptionFieldValue.productdescriptionid(value)) => acc.filter(_.productdescriptionid == value)
        case (acc, ProductdescriptionFieldValue.description(value)) => acc.filter(_.description == value)
        case (acc, ProductdescriptionFieldValue.rowguid(value)) => acc.filter(_.rowguid == value)
        case (acc, ProductdescriptionFieldValue.modifieddate(value)) => acc.filter(_.modifieddate == value)
      }.toList
    }
  }
  override def selectById(productdescriptionid: ProductdescriptionId): ConnectionIO[Option[ProductdescriptionRow]] = {
    delay(map.get(productdescriptionid))
  }
  override def selectByIds(productdescriptionids: Array[ProductdescriptionId]): Stream[ConnectionIO, ProductdescriptionRow] = {
    Stream.emits(productdescriptionids.flatMap(map.get).toList)
  }
  override def update(row: ProductdescriptionRow): ConnectionIO[Boolean] = {
    delay {
      map.get(row.productdescriptionid) match {
        case Some(`row`) => false
        case Some(_) =>
          map.put(row.productdescriptionid, row)
          true
        case None => false
      }
    }
  }
  override def updateFieldValues(productdescriptionid: ProductdescriptionId, fieldValues: List[ProductdescriptionFieldValue[_]]): ConnectionIO[Boolean] = {
    delay {
      map.get(productdescriptionid) match {
        case Some(oldRow) =>
          val updatedRow = fieldValues.foldLeft(oldRow) {
            case (acc, ProductdescriptionFieldValue.description(value)) => acc.copy(description = value)
            case (acc, ProductdescriptionFieldValue.rowguid(value)) => acc.copy(rowguid = value)
            case (acc, ProductdescriptionFieldValue.modifieddate(value)) => acc.copy(modifieddate = value)
          }
          if (updatedRow != oldRow) {
            map.put(productdescriptionid, updatedRow)
            true
          } else {
            false
          }
        case None => false
      }
    }
  }
  override def upsert(unsaved: ProductdescriptionRow): ConnectionIO[ProductdescriptionRow] = {
    delay {
      map.put(unsaved.productdescriptionid, unsaved)
      unsaved
    }
  }
}