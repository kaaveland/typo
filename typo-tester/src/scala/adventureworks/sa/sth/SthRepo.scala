/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sa
package sth

import java.sql.Connection

trait SthRepo {
  def selectAll(implicit c: Connection): List[SthRow]
  def selectByFieldValues(fieldValues: List[SthFieldOrIdValue[_]])(implicit c: Connection): List[SthRow]
}