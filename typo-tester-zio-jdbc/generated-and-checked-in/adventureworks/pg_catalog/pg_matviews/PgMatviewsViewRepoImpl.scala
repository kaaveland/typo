/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_matviews

import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql
import zio.jdbc.ZConnection
import zio.jdbc.sqlInterpolator
import zio.stream.ZStream

object PgMatviewsViewRepoImpl extends PgMatviewsViewRepo {
  override def select: SelectBuilder[PgMatviewsViewFields, PgMatviewsViewRow] = {
    SelectBuilderSql("pg_catalog.pg_matviews", PgMatviewsViewFields, PgMatviewsViewRow.jdbcDecoder)
  }
  override def selectAll: ZStream[ZConnection, Throwable, PgMatviewsViewRow] = {
    sql"""select "schemaname", "matviewname", "matviewowner", "tablespace", "hasindexes", "ispopulated", "definition" from pg_catalog.pg_matviews""".query(PgMatviewsViewRow.jdbcDecoder).selectStream
  }
}
