/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pr
package bom

import typo.dsl.SelectBuilder
import zio.jdbc.ZConnection
import zio.stream.ZStream

trait BomViewRepo {
  def select: SelectBuilder[BomViewFields, BomViewRow]
  def selectAll: ZStream[ZConnection, Throwable, BomViewRow]
}