/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_stats_ext_exprs

import typo.dsl.SelectBuilder
import zio.jdbc.ZConnection
import zio.stream.ZStream

trait PgStatsExtExprsViewRepo {
  def select: SelectBuilder[PgStatsExtExprsViewFields, PgStatsExtExprsViewRow]
  def selectAll: ZStream[ZConnection, Throwable, PgStatsExtExprsViewRow]
}
