/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_shseclabel

import java.sql.Connection

trait PgShseclabelRepo {
  def delete(compositeId: PgShseclabelId)(implicit c: Connection): Boolean
  def insert(unsaved: PgShseclabelRow)(implicit c: Connection): PgShseclabelRow
  def selectAll(implicit c: Connection): List[PgShseclabelRow]
  def selectById(compositeId: PgShseclabelId)(implicit c: Connection): Option[PgShseclabelRow]
  def update(row: PgShseclabelRow)(implicit c: Connection): Boolean
  def upsert(unsaved: PgShseclabelRow)(implicit c: Connection): PgShseclabelRow
}