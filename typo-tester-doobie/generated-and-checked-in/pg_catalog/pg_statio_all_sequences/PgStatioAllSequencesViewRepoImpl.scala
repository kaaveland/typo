/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_statio_all_sequences

import doobie.free.connection.ConnectionIO
import doobie.syntax.string.toSqlInterpolator
import fs2.Stream

object PgStatioAllSequencesViewRepoImpl extends PgStatioAllSequencesViewRepo {
  override def selectAll: Stream[ConnectionIO, PgStatioAllSequencesViewRow] = {
    sql"select relid, schemaname, relname, blks_read, blks_hit from pg_catalog.pg_statio_all_sequences".query(PgStatioAllSequencesViewRow.read).stream
  }
}