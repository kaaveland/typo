/**
 * File has been automatically generated by `typo` for internal use.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 *
 * (If you're developing `typo` and want to change it: run `bleep generate-sources`)
 */
package typo
package generated
package pg_catalog
package pg_prepared_statements

import anorm.SqlStringInterpolation
import java.sql.Connection

class PgPreparedStatementsViewRepoImpl extends PgPreparedStatementsViewRepo {
  override def selectAll(implicit c: Connection): List[PgPreparedStatementsViewRow] = {
    SQL"""select "name", "statement", "prepare_time"::text, "parameter_types", "from_sql"
          from pg_catalog.pg_prepared_statements
       """.as(PgPreparedStatementsViewRow.rowParser(1).*)
  }
}
