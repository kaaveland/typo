/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_stats

import java.sql.Connection
import typo.dsl.SelectBuilder

trait PgStatsViewRepo {
  def select: SelectBuilder[PgStatsViewFields, PgStatsViewRow]
  def selectAll(implicit c: Connection): List[PgStatsViewRow]
}