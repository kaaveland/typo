/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_statio_sys_indexes

import java.sql.Connection

trait PgStatioSysIndexesViewRepo {
  def selectAll(implicit c: Connection): List[PgStatioSysIndexesViewRow]
}