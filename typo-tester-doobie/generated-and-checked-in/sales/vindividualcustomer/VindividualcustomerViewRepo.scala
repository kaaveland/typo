/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package vindividualcustomer

import doobie.free.connection.ConnectionIO
import fs2.Stream

trait VindividualcustomerViewRepo {
  def selectAll: Stream[ConnectionIO, VindividualcustomerViewRow]
  def selectByFieldValues(fieldValues: List[VindividualcustomerViewFieldOrIdValue[_]]): Stream[ConnectionIO, VindividualcustomerViewRow]
}