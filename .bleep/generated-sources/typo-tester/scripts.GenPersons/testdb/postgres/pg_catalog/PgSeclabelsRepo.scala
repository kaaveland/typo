package testdb
package postgres
package pg_catalog

import java.sql.Connection

trait PgSeclabelsRepo {
  def selectAll(implicit c: Connection): List[PgSeclabelsRow]
  def selectByFieldValues(fieldValues: List[PgSeclabelsFieldValue[_]])(implicit c: Connection): List[PgSeclabelsRow]
}