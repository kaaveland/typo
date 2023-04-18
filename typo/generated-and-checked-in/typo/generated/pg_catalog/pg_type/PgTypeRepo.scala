/**
 * File has been automatically generated by `typo` for internal use.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 *
 * (If you're developing `typo` and want to change it: run `bleep generate-sources`)
 */
package typo
package generated
package pg_catalog
package pg_type

import java.sql.Connection

trait PgTypeRepo {
  def delete(oid: PgTypeId)(implicit c: Connection): Boolean
  def insert(oid: PgTypeId, unsaved: PgTypeRowUnsaved)(implicit c: Connection): Boolean
  def selectAll(implicit c: Connection): List[PgTypeRow]
  def selectByFieldValues(fieldValues: List[PgTypeFieldOrIdValue[_]])(implicit c: Connection): List[PgTypeRow]
  def selectById(oid: PgTypeId)(implicit c: Connection): Option[PgTypeRow]
  def selectByIds(oids: Array[PgTypeId])(implicit c: Connection): List[PgTypeRow]
  def selectByUnique(typname: String, typnamespace: /* oid */ Long)(implicit c: Connection): Option[PgTypeRow]
  def update(row: PgTypeRow)(implicit c: Connection): Boolean
  def updateFieldValues(oid: PgTypeId, fieldValues: List[PgTypeFieldValue[_]])(implicit c: Connection): Boolean
}
