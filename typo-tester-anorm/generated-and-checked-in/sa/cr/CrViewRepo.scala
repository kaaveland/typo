/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sa
package cr

import java.sql.Connection

trait CrViewRepo {
  def selectAll(implicit c: Connection): List[CrViewRow]
}
