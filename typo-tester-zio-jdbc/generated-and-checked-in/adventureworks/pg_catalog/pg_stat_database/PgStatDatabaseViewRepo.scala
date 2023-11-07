/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_stat_database

import typo.dsl.SelectBuilder
import zio.jdbc.ZConnection
import zio.stream.ZStream

trait PgStatDatabaseViewRepo {
  def select: SelectBuilder[PgStatDatabaseViewFields, PgStatDatabaseViewRow]
  def selectAll: ZStream[ZConnection, Throwable, PgStatDatabaseViewRow]
}
