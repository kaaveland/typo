/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sa
package sohsr

import doobie.free.connection.ConnectionIO
import doobie.syntax.string.toSqlInterpolator
import fs2.Stream
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql

class SohsrViewRepoImpl extends SohsrViewRepo {
  override def select: SelectBuilder[SohsrViewFields, SohsrViewRow] = {
    SelectBuilderSql("sa.sohsr", SohsrViewFields.structure, SohsrViewRow.read)
  }
  override def selectAll: Stream[ConnectionIO, SohsrViewRow] = {
    sql"""select "salesorderid", "salesreasonid", "modifieddate"::text from sa.sohsr""".query(using SohsrViewRow.read).stream
  }
}
