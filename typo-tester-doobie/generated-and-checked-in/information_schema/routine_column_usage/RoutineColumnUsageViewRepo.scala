/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package routine_column_usage

import doobie.free.connection.ConnectionIO
import fs2.Stream

trait RoutineColumnUsageViewRepo {
  def selectAll: Stream[ConnectionIO, RoutineColumnUsageViewRow]
}