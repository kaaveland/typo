/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sa
package sth

import doobie.free.connection.ConnectionIO
import doobie.syntax.string.toSqlInterpolator
import fs2.Stream
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql

class SthViewRepoImpl extends SthViewRepo {
  override def select: SelectBuilder[SthViewFields, SthViewRow] = {
    SelectBuilderSql("sa.sth", SthViewFields.structure, SthViewRow.read)
  }
  override def selectAll: Stream[ConnectionIO, SthViewRow] = {
    sql"""select "id", "businessentityid", "territoryid", "startdate"::text, "enddate"::text, "rowguid", "modifieddate"::text from sa.sth""".query(using SthViewRow.read).stream
  }
}
