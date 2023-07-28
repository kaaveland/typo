/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package foreign_table_options

import doobie.free.connection.ConnectionIO
import doobie.syntax.string.toSqlInterpolator
import fs2.Stream

object ForeignTableOptionsViewRepoImpl extends ForeignTableOptionsViewRepo {
  override def selectAll: Stream[ConnectionIO, ForeignTableOptionsViewRow] = {
    sql"select foreign_table_catalog, foreign_table_schema, foreign_table_name, option_name, option_value from information_schema.foreign_table_options".query(ForeignTableOptionsViewRow.read).stream
  }
}