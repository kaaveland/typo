/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pr
package p

import java.sql.Connection

trait PViewRepo {
  def selectAll(implicit c: Connection): List[PViewRow]
}
