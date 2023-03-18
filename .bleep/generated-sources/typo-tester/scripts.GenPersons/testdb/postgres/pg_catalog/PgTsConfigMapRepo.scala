package testdb
package postgres
package pg_catalog

import java.sql.Connection

trait PgTsConfigMapRepo {
  def selectAll(implicit c: Connection): List[PgTsConfigMapRow]
  def selectByFieldValues(fieldValues: List[PgTsConfigMapFieldValue[_]])(implicit c: Connection): List[PgTsConfigMapRow]
}
