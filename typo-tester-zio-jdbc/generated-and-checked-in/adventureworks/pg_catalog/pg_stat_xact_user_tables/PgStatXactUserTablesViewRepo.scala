/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_stat_xact_user_tables

import typo.dsl.SelectBuilder
import zio.jdbc.ZConnection
import zio.stream.ZStream

trait PgStatXactUserTablesViewRepo {
  def select: SelectBuilder[PgStatXactUserTablesViewFields, PgStatXactUserTablesViewRow]
  def selectAll: ZStream[ZConnection, Throwable, PgStatXactUserTablesViewRow]
}
