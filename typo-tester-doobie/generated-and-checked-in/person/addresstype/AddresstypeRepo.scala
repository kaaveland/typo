/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package person
package addresstype

import doobie.free.connection.ConnectionIO
import fs2.Stream

trait AddresstypeRepo {
  def delete(addresstypeid: AddresstypeId): ConnectionIO[Boolean]
  def insert(unsaved: AddresstypeRow): ConnectionIO[AddresstypeRow]
  def insert(unsaved: AddresstypeRowUnsaved): ConnectionIO[AddresstypeRow]
  def selectAll: Stream[ConnectionIO, AddresstypeRow]
  def selectById(addresstypeid: AddresstypeId): ConnectionIO[Option[AddresstypeRow]]
  def selectByIds(addresstypeids: Array[AddresstypeId]): Stream[ConnectionIO, AddresstypeRow]
  def update(row: AddresstypeRow): ConnectionIO[Boolean]
  def upsert(unsaved: AddresstypeRow): ConnectionIO[AddresstypeRow]
}
