/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pe
package a

import doobie.free.connection.ConnectionIO
import fs2.Stream

trait AViewRepo {
  def selectAll: Stream[ConnectionIO, AViewRow]
  def selectByFieldValues(fieldValues: List[AViewFieldOrIdValue[_]]): Stream[ConnectionIO, AViewRow]
}