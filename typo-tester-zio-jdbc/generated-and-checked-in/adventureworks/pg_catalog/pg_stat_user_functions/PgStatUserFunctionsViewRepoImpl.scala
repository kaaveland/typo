/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_stat_user_functions

import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql
import zio.jdbc.ZConnection
import zio.jdbc.sqlInterpolator
import zio.stream.ZStream

object PgStatUserFunctionsViewRepoImpl extends PgStatUserFunctionsViewRepo {
  override def select: SelectBuilder[PgStatUserFunctionsViewFields, PgStatUserFunctionsViewRow] = {
    SelectBuilderSql("pg_catalog.pg_stat_user_functions", PgStatUserFunctionsViewFields, PgStatUserFunctionsViewRow.jdbcDecoder)
  }
  override def selectAll: ZStream[ZConnection, Throwable, PgStatUserFunctionsViewRow] = {
    sql"""select "funcid", "schemaname", "funcname", "calls", "total_time", "self_time" from pg_catalog.pg_stat_user_functions""".query(PgStatUserFunctionsViewRow.jdbcDecoder).selectStream
  }
}
