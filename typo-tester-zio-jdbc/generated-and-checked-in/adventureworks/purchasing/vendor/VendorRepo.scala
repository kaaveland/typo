/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package purchasing
package vendor

import adventureworks.person.businessentity.BusinessentityId
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.UpdateBuilder
import zio.ZIO
import zio.jdbc.UpdateResult
import zio.jdbc.ZConnection
import zio.stream.ZStream

trait VendorRepo {
  def delete(businessentityid: BusinessentityId): ZIO[ZConnection, Throwable, Boolean]
  def delete: DeleteBuilder[VendorFields, VendorRow]
  def insert(unsaved: VendorRow): ZIO[ZConnection, Throwable, VendorRow]
  def insert(unsaved: VendorRowUnsaved): ZIO[ZConnection, Throwable, VendorRow]
  def select: SelectBuilder[VendorFields, VendorRow]
  def selectAll: ZStream[ZConnection, Throwable, VendorRow]
  def selectById(businessentityid: BusinessentityId): ZIO[ZConnection, Throwable, Option[VendorRow]]
  def selectByIds(businessentityids: Array[BusinessentityId]): ZStream[ZConnection, Throwable, VendorRow]
  def update(row: VendorRow): ZIO[ZConnection, Throwable, Boolean]
  def update: UpdateBuilder[VendorFields, VendorRow]
  def upsert(unsaved: VendorRow): ZIO[ZConnection, Throwable, UpdateResult[VendorRow]]
}
