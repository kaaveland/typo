/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_group

import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql
import zio.jdbc.ZConnection
import zio.jdbc.sqlInterpolator
import zio.stream.ZStream

object PgGroupViewRepoImpl extends PgGroupViewRepo {
  override def select: SelectBuilder[PgGroupViewFields, PgGroupViewRow] = {
    SelectBuilderSql("pg_catalog.pg_group", PgGroupViewFields, PgGroupViewRow.jdbcDecoder)
  }
  override def selectAll: ZStream[ZConnection, Throwable, PgGroupViewRow] = {
    sql"""select "groname", "grosysid", "grolist" from pg_catalog.pg_group""".query(PgGroupViewRow.jdbcDecoder).selectStream
  }
}
