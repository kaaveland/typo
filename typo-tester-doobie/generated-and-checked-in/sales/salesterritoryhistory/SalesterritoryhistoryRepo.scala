/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package salesterritoryhistory

import doobie.free.connection.ConnectionIO
import fs2.Stream

trait SalesterritoryhistoryRepo {
  def delete(compositeId: SalesterritoryhistoryId): ConnectionIO[Boolean]
  def insert(unsaved: SalesterritoryhistoryRow): ConnectionIO[SalesterritoryhistoryRow]
  def insert(unsaved: SalesterritoryhistoryRowUnsaved): ConnectionIO[SalesterritoryhistoryRow]
  def selectAll: Stream[ConnectionIO, SalesterritoryhistoryRow]
  def selectByFieldValues(fieldValues: List[SalesterritoryhistoryFieldOrIdValue[_]]): Stream[ConnectionIO, SalesterritoryhistoryRow]
  def selectById(compositeId: SalesterritoryhistoryId): ConnectionIO[Option[SalesterritoryhistoryRow]]
  def update(row: SalesterritoryhistoryRow): ConnectionIO[Boolean]
  def updateFieldValues(compositeId: SalesterritoryhistoryId, fieldValues: List[SalesterritoryhistoryFieldValue[_]]): ConnectionIO[Boolean]
  def upsert(unsaved: SalesterritoryhistoryRow): ConnectionIO[SalesterritoryhistoryRow]
}