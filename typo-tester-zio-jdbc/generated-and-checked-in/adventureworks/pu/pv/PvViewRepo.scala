/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pu
package pv

import typo.dsl.SelectBuilder
import zio.jdbc.ZConnection
import zio.stream.ZStream

trait PvViewRepo {
  def select: SelectBuilder[PvViewFields, PvViewRow]
  def selectAll: ZStream[ZConnection, Throwable, PvViewRow]
}
