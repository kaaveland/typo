/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package specialoffer

import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.UpdateBuilder
import zio.ZIO
import zio.jdbc.UpdateResult
import zio.jdbc.ZConnection
import zio.stream.ZStream

trait SpecialofferRepo {
  def delete(specialofferid: SpecialofferId): ZIO[ZConnection, Throwable, Boolean]
  def delete: DeleteBuilder[SpecialofferFields, SpecialofferRow]
  def insert(unsaved: SpecialofferRow): ZIO[ZConnection, Throwable, SpecialofferRow]
  def insert(unsaved: SpecialofferRowUnsaved): ZIO[ZConnection, Throwable, SpecialofferRow]
  def select: SelectBuilder[SpecialofferFields, SpecialofferRow]
  def selectAll: ZStream[ZConnection, Throwable, SpecialofferRow]
  def selectById(specialofferid: SpecialofferId): ZIO[ZConnection, Throwable, Option[SpecialofferRow]]
  def selectByIds(specialofferids: Array[SpecialofferId]): ZStream[ZConnection, Throwable, SpecialofferRow]
  def update(row: SpecialofferRow): ZIO[ZConnection, Throwable, Boolean]
  def update: UpdateBuilder[SpecialofferFields, SpecialofferRow]
  def upsert(unsaved: SpecialofferRow): ZIO[ZConnection, Throwable, UpdateResult[SpecialofferRow]]
}