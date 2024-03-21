/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pr
package pc

import doobie.free.connection.ConnectionIO
import doobie.syntax.string.toSqlInterpolator
import fs2.Stream
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql

class PcViewRepoImpl extends PcViewRepo {
  override def select: SelectBuilder[PcViewFields, PcViewRow] = {
    SelectBuilderSql("pr.pc", PcViewFields.structure, PcViewRow.read)
  }
  override def selectAll: Stream[ConnectionIO, PcViewRow] = {
    sql"""select "id", "productcategoryid", "name", "rowguid", "modifieddate"::text from pr.pc""".query(using PcViewRow.read).stream
  }
}
