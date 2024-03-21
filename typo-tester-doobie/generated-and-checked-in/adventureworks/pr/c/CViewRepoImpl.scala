/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pr
package c

import doobie.free.connection.ConnectionIO
import doobie.syntax.string.toSqlInterpolator
import fs2.Stream
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql

class CViewRepoImpl extends CViewRepo {
  override def select: SelectBuilder[CViewFields, CViewRow] = {
    SelectBuilderSql("pr.c", CViewFields.structure, CViewRow.read)
  }
  override def selectAll: Stream[ConnectionIO, CViewRow] = {
    sql"""select "id", "cultureid", "name", "modifieddate"::text from pr.c""".query(using CViewRow.read).stream
  }
}
