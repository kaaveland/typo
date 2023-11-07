/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package tables

import typo.dsl.SelectBuilder
import zio.jdbc.ZConnection
import zio.stream.ZStream

trait TablesViewRepo {
  def select: SelectBuilder[TablesViewFields, TablesViewRow]
  def selectAll: ZStream[ZConnection, Throwable, TablesViewRow]
}
