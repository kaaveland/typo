/**
 * File has been automatically generated by `typo` for internal use.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 *
 * (If you're developing `typo` and want to change it: run `bleep generate-sources)
 */
package typo
package generated
package pg_catalog

import java.sql.Connection

trait PgEnumRepo {
  def selectAll(implicit c: Connection): List[PgEnumRow]
  def selectById(oid: PgEnumId)(implicit c: Connection): Option[PgEnumRow]
  def selectByIds(oids: List[PgEnumId])(implicit c: Connection): List[PgEnumRow]
  def selectByFieldValues(fieldValues: List[PgEnumFieldValue[_]])(implicit c: Connection): List[PgEnumRow]
  def updateFieldValues(oid: PgEnumId, fieldValues: List[PgEnumFieldValue[_]])(implicit c: Connection): Int
  def insert(oid: PgEnumId, unsaved: PgEnumRowUnsaved)(implicit c: Connection): Unit
  def delete(oid: PgEnumId)(implicit c: Connection): Boolean
  def selectByUnique(enumtypid: Long, enumlabel: String)(implicit c: Connection): Option[PgEnumRow]
  def selectByUnique(enumtypid: Long, enumsortorder: Float)(implicit c: Connection): Option[PgEnumRow]
}