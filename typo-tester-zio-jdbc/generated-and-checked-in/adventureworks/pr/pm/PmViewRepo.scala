/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pr
package pm

import typo.dsl.SelectBuilder
import zio.jdbc.ZConnection
import zio.stream.ZStream

trait PmViewRepo {
  def select: SelectBuilder[PmViewFields, PmViewRow]
  def selectAll: ZStream[ZConnection, Throwable, PmViewRow]
}
