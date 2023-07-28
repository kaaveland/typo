/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_config

import doobie.free.connection.ConnectionIO
import doobie.syntax.string.toSqlInterpolator
import fs2.Stream

object PgConfigViewRepoImpl extends PgConfigViewRepo {
  override def selectAll: Stream[ConnectionIO, PgConfigViewRow] = {
    sql"""select "name", setting from pg_catalog.pg_config""".query(PgConfigViewRow.read).stream
  }
}