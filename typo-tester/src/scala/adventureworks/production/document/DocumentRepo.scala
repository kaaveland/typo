/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package document

import java.sql.Connection
import java.util.UUID

trait DocumentRepo {
  def delete(documentnode: DocumentId)(implicit c: Connection): Boolean
  def insert(unsaved: DocumentRowUnsaved)(implicit c: Connection): DocumentRow
  def selectAll(implicit c: Connection): List[DocumentRow]
  def selectByFieldValues(fieldValues: List[DocumentFieldOrIdValue[_]])(implicit c: Connection): List[DocumentRow]
  def selectById(documentnode: DocumentId)(implicit c: Connection): Option[DocumentRow]
  def selectByIds(documentnodes: Array[DocumentId])(implicit c: Connection): List[DocumentRow]
  def selectByUnique(rowguid: UUID)(implicit c: Connection): Option[DocumentRow]
  def update(row: DocumentRow)(implicit c: Connection): Boolean
  def updateFieldValues(documentnode: DocumentId, fieldValues: List[DocumentFieldValue[_]])(implicit c: Connection): Boolean
}
