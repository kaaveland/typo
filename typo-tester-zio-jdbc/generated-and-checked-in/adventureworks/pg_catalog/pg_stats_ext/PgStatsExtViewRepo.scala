/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_stats_ext

import typo.dsl.SelectBuilder
import zio.jdbc.ZConnection
import zio.stream.ZStream

trait PgStatsExtViewRepo {
  def select: SelectBuilder[PgStatsExtViewFields, PgStatsExtViewRow]
  def selectAll: ZStream[ZConnection, Throwable, PgStatsExtViewRow]
}
