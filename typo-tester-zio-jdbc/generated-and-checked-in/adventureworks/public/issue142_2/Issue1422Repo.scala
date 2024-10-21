/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package public
package issue142_2

import adventureworks.public.issue142.Issue142Id
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.UpdateBuilder
import zio.ZIO
import zio.jdbc.UpdateResult
import zio.jdbc.ZConnection
import zio.stream.ZStream

trait Issue1422Repo {
  def delete: DeleteBuilder[Issue1422Fields, Issue1422Row]
  def deleteById(tabellkode: Issue142Id): ZIO[ZConnection, Throwable, Boolean]
  def deleteByIds(tabellkodes: Array[Issue142Id]): ZIO[ZConnection, Throwable, Long]
  def insert(unsaved: Issue1422Row): ZIO[ZConnection, Throwable, Issue1422Row]
  def insertStreaming(unsaved: ZStream[ZConnection, Throwable, Issue1422Row], batchSize: Int = 10000): ZIO[ZConnection, Throwable, Long]
  def select: SelectBuilder[Issue1422Fields, Issue1422Row]
  def selectAll: ZStream[ZConnection, Throwable, Issue1422Row]
  def selectById(tabellkode: Issue142Id): ZIO[ZConnection, Throwable, Option[Issue1422Row]]
  def selectByIds(tabellkodes: Array[Issue142Id]): ZStream[ZConnection, Throwable, Issue1422Row]
  def selectByIdsTracked(tabellkodes: Array[Issue142Id]): ZIO[ZConnection, Throwable, Map[Issue142Id, Issue1422Row]]
  def update: UpdateBuilder[Issue1422Fields, Issue1422Row]
  def upsert(unsaved: Issue1422Row): ZIO[ZConnection, Throwable, UpdateResult[Issue1422Row]]
  // Not implementable for zio-jdbc: upsertBatch
  /* NOTE: this functionality is not safe if you use auto-commit mode! it runs 3 SQL statements */
  def upsertStreaming(unsaved: ZStream[ZConnection, Throwable, Issue1422Row], batchSize: Int = 10000): ZIO[ZConnection, Throwable, Long]
}
