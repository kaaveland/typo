/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_tables

import typo.dsl.SelectBuilder
import zio.jdbc.ZConnection
import zio.stream.ZStream

trait PgTablesViewRepo {
  def select: SelectBuilder[PgTablesViewFields, PgTablesViewRow]
  def selectAll: ZStream[ZConnection, Throwable, PgTablesViewRow]
}
