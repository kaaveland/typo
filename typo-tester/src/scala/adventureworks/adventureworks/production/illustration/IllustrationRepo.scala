/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package illustration

import java.sql.Connection

trait IllustrationRepo {
  def delete(illustrationid: IllustrationId)(implicit c: Connection): Boolean
  def insert(unsaved: IllustrationRowUnsaved)(implicit c: Connection): IllustrationId
  def selectAll(implicit c: Connection): List[IllustrationRow]
  def selectByFieldValues(fieldValues: List[IllustrationFieldOrIdValue[_]])(implicit c: Connection): List[IllustrationRow]
  def selectById(illustrationid: IllustrationId)(implicit c: Connection): Option[IllustrationRow]
  def selectByIds(illustrationids: Array[IllustrationId])(implicit c: Connection): List[IllustrationRow]
  def update(row: IllustrationRow)(implicit c: Connection): Boolean
  def updateFieldValues(illustrationid: IllustrationId, fieldValues: List[IllustrationFieldValue[_]])(implicit c: Connection): Boolean
}
