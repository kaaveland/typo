/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package salesorderheadersalesreason

import java.sql.Connection

trait SalesorderheadersalesreasonRepo {
  def delete(compositeId: SalesorderheadersalesreasonId)(implicit c: Connection): Boolean
  def insert(unsaved: SalesorderheadersalesreasonRow)(implicit c: Connection): SalesorderheadersalesreasonRow
  def insert(unsaved: SalesorderheadersalesreasonRowUnsaved)(implicit c: Connection): SalesorderheadersalesreasonRow
  def selectAll(implicit c: Connection): List[SalesorderheadersalesreasonRow]
  def selectById(compositeId: SalesorderheadersalesreasonId)(implicit c: Connection): Option[SalesorderheadersalesreasonRow]
  def update(row: SalesorderheadersalesreasonRow)(implicit c: Connection): Boolean
  def upsert(unsaved: SalesorderheadersalesreasonRow)(implicit c: Connection): SalesorderheadersalesreasonRow
}
