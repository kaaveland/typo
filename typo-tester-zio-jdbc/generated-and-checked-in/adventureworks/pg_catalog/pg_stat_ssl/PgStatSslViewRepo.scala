/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_stat_ssl

import typo.dsl.SelectBuilder
import zio.jdbc.ZConnection
import zio.stream.ZStream

trait PgStatSslViewRepo {
  def select: SelectBuilder[PgStatSslViewFields, PgStatSslViewRow]
  def selectAll: ZStream[ZConnection, Throwable, PgStatSslViewRow]
}
