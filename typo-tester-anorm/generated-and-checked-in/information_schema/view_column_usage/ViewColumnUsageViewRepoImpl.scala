/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package view_column_usage

import anorm.SqlStringInterpolation
import java.sql.Connection

object ViewColumnUsageViewRepoImpl extends ViewColumnUsageViewRepo {
  override def selectAll(implicit c: Connection): List[ViewColumnUsageViewRow] = {
    SQL"""select view_catalog, view_schema, view_name, table_catalog, table_schema, "table_name", "column_name"
          from information_schema.view_column_usage
       """.as(ViewColumnUsageViewRow.rowParser(1).*)
  }
}