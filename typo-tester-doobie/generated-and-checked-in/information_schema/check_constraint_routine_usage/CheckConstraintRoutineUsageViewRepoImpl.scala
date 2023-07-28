/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package check_constraint_routine_usage

import doobie.free.connection.ConnectionIO
import doobie.syntax.string.toSqlInterpolator
import fs2.Stream

object CheckConstraintRoutineUsageViewRepoImpl extends CheckConstraintRoutineUsageViewRepo {
  override def selectAll: Stream[ConnectionIO, CheckConstraintRoutineUsageViewRow] = {
    sql"""select "constraint_catalog", "constraint_schema", "constraint_name", specific_catalog, specific_schema, "specific_name" from information_schema.check_constraint_routine_usage""".query(CheckConstraintRoutineUsageViewRow.read).stream
  }
}