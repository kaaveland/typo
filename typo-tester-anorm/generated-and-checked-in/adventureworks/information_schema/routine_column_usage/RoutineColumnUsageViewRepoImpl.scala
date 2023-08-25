/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package routine_column_usage

import anorm.SqlStringInterpolation
import java.sql.Connection
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql

object RoutineColumnUsageViewRepoImpl extends RoutineColumnUsageViewRepo {
  override def select: SelectBuilder[RoutineColumnUsageViewFields, RoutineColumnUsageViewRow] = {
    SelectBuilderSql("information_schema.routine_column_usage", RoutineColumnUsageViewFields, RoutineColumnUsageViewRow.rowParser)
  }
  override def selectAll(implicit c: Connection): List[RoutineColumnUsageViewRow] = {
    SQL"""select specific_catalog, specific_schema, "specific_name", "routine_catalog", "routine_schema", "routine_name", table_catalog, table_schema, "table_name", "column_name"
          from information_schema.routine_column_usage
       """.as(RoutineColumnUsageViewRow.rowParser(1).*)
  }
}