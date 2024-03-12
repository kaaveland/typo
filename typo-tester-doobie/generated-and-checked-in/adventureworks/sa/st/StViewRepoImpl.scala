/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sa
package st

import doobie.free.connection.ConnectionIO
import doobie.syntax.string.toSqlInterpolator
import fs2.Stream
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql

class StViewRepoImpl extends StViewRepo {
  override def select: SelectBuilder[StViewFields, StViewRow] = {
    SelectBuilderSql("sa.st", StViewFields.structure, StViewRow.read)
  }
  override def selectAll: Stream[ConnectionIO, StViewRow] = {
    sql"""select "id", "territoryid", "name", "countryregioncode", "group", "salesytd", "saleslastyear", "costytd", "costlastyear", "rowguid", "modifieddate"::text from sa.st""".query(StViewRow.read).stream
  }
}
