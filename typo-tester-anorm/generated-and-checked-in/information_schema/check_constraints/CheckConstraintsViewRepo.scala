/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package check_constraints

import java.sql.Connection

trait CheckConstraintsViewRepo {
  def selectAll(implicit c: Connection): List[CheckConstraintsViewRow]
}