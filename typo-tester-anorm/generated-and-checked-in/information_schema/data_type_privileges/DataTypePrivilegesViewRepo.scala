/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package data_type_privileges

import java.sql.Connection

trait DataTypePrivilegesViewRepo {
  def selectAll(implicit c: Connection): List[DataTypePrivilegesViewRow]
}