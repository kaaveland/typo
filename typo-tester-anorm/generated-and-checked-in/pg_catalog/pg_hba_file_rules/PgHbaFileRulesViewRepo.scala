/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_hba_file_rules

import java.sql.Connection

trait PgHbaFileRulesViewRepo {
  def selectAll(implicit c: Connection): List[PgHbaFileRulesViewRow]
}