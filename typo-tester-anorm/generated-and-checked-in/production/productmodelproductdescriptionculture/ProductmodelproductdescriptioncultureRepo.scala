/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package productmodelproductdescriptionculture

import java.sql.Connection

trait ProductmodelproductdescriptioncultureRepo {
  def delete(compositeId: ProductmodelproductdescriptioncultureId)(implicit c: Connection): Boolean
  def insert(unsaved: ProductmodelproductdescriptioncultureRow)(implicit c: Connection): ProductmodelproductdescriptioncultureRow
  def insert(unsaved: ProductmodelproductdescriptioncultureRowUnsaved)(implicit c: Connection): ProductmodelproductdescriptioncultureRow
  def selectAll(implicit c: Connection): List[ProductmodelproductdescriptioncultureRow]
  def selectById(compositeId: ProductmodelproductdescriptioncultureId)(implicit c: Connection): Option[ProductmodelproductdescriptioncultureRow]
  def update(row: ProductmodelproductdescriptioncultureRow)(implicit c: Connection): Boolean
  def upsert(unsaved: ProductmodelproductdescriptioncultureRow)(implicit c: Connection): ProductmodelproductdescriptioncultureRow
}
