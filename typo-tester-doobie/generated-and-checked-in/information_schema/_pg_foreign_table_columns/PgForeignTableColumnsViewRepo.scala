/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package `_pg_foreign_table_columns`

import doobie.free.connection.ConnectionIO
import fs2.Stream

trait PgForeignTableColumnsViewRepo {
  def selectAll: Stream[ConnectionIO, PgForeignTableColumnsViewRow]
}