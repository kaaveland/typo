/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package triggers

import typo.dsl.SelectBuilder
import zio.jdbc.ZConnection
import zio.stream.ZStream

trait TriggersViewRepo {
  def select: SelectBuilder[TriggersViewFields, TriggersViewRow]
  def selectAll: ZStream[ZConnection, Throwable, TriggersViewRow]
}
