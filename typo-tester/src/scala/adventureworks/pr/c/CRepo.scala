/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pr
package c

import java.sql.Connection

trait CRepo {
  def selectAll(implicit c: Connection): List[CRow]
  def selectByFieldValues(fieldValues: List[CFieldOrIdValue[_]])(implicit c: Connection): List[CRow]
}