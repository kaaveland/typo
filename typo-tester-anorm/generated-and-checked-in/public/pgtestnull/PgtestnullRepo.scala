/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package public
package pgtestnull

import java.sql.Connection

trait PgtestnullRepo {
  def insert(unsaved: PgtestnullRow)(implicit c: Connection): PgtestnullRow
  def selectAll(implicit c: Connection): List[PgtestnullRow]
}
