/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package table_privileges

import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql
import zio.jdbc.ZConnection
import zio.jdbc.sqlInterpolator
import zio.stream.ZStream

object TablePrivilegesViewRepoImpl extends TablePrivilegesViewRepo {
  override def select: SelectBuilder[TablePrivilegesViewFields, TablePrivilegesViewRow] = {
    SelectBuilderSql("information_schema.table_privileges", TablePrivilegesViewFields, TablePrivilegesViewRow.jdbcDecoder)
  }
  override def selectAll: ZStream[ZConnection, Throwable, TablePrivilegesViewRow] = {
    sql"""select "grantor", "grantee", "table_catalog", "table_schema", "table_name", "privilege_type", "is_grantable", "with_hierarchy" from information_schema.table_privileges""".query(TablePrivilegesViewRow.jdbcDecoder).selectStream
  }
}
