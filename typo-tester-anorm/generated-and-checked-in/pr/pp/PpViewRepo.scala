/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pr
package pp

import java.sql.Connection

trait PpViewRepo {
  def selectAll(implicit c: Connection): List[PpViewRow]
}
