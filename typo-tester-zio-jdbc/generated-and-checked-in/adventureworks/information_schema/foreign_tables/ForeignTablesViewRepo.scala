/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package foreign_tables

import typo.dsl.SelectBuilder
import zio.jdbc.ZConnection
import zio.stream.ZStream

trait ForeignTablesViewRepo {
  def select: SelectBuilder[ForeignTablesViewFields, ForeignTablesViewRow]
  def selectAll: ZStream[ZConnection, Throwable, ForeignTablesViewRow]
}
