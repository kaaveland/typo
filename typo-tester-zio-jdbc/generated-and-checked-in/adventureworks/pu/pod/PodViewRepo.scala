/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pu
package pod

import typo.dsl.SelectBuilder
import zio.jdbc.ZConnection
import zio.stream.ZStream

trait PodViewRepo {
  def select: SelectBuilder[PodViewFields, PodViewRow]
  def selectAll: ZStream[ZConnection, Throwable, PodViewRow]
}
