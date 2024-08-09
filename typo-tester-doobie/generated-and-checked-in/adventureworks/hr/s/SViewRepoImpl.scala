/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package hr
package s

import doobie.free.connection.ConnectionIO
import doobie.syntax.string.toSqlInterpolator
import fs2.Stream
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql

class SViewRepoImpl extends SViewRepo {
  override def select: SelectBuilder[SViewFields, SViewRow] = {
    SelectBuilderSql(""""hr"."s"""", SViewFields.structure, SViewRow.read)
  }
  override def selectAll: Stream[ConnectionIO, SViewRow] = {
    sql"""select "id", "shiftid", "name", "starttime"::text, "endtime"::text, "modifieddate"::text from "hr"."s"""".query(using SViewRow.read).stream
  }
}
