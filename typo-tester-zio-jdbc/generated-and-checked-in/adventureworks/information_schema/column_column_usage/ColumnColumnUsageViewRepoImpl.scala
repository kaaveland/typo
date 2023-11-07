/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package column_column_usage

import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql
import zio.jdbc.ZConnection
import zio.jdbc.sqlInterpolator
import zio.stream.ZStream

object ColumnColumnUsageViewRepoImpl extends ColumnColumnUsageViewRepo {
  override def select: SelectBuilder[ColumnColumnUsageViewFields, ColumnColumnUsageViewRow] = {
    SelectBuilderSql("information_schema.column_column_usage", ColumnColumnUsageViewFields, ColumnColumnUsageViewRow.jdbcDecoder)
  }
  override def selectAll: ZStream[ZConnection, Throwable, ColumnColumnUsageViewRow] = {
    sql"""select "table_catalog", "table_schema", "table_name", "column_name", "dependent_column" from information_schema.column_column_usage""".query(ColumnColumnUsageViewRow.jdbcDecoder).selectStream
  }
}
