/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_user

import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql
import zio.jdbc.ZConnection
import zio.jdbc.sqlInterpolator
import zio.stream.ZStream

object PgUserViewRepoImpl extends PgUserViewRepo {
  override def select: SelectBuilder[PgUserViewFields, PgUserViewRow] = {
    SelectBuilderSql("pg_catalog.pg_user", PgUserViewFields, PgUserViewRow.jdbcDecoder)
  }
  override def selectAll: ZStream[ZConnection, Throwable, PgUserViewRow] = {
    sql"""select "usename", "usesysid", "usecreatedb", "usesuper", "userepl", "usebypassrls", "passwd", "valuntil"::text, "useconfig" from pg_catalog.pg_user""".query(PgUserViewRow.jdbcDecoder).selectStream
  }
}
