/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pr
package plph

import doobie.free.connection.ConnectionIO
import doobie.syntax.string.toSqlInterpolator
import fs2.Stream
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql

class PlphViewRepoImpl extends PlphViewRepo {
  override def select: SelectBuilder[PlphViewFields, PlphViewRow] = {
    SelectBuilderSql("pr.plph", PlphViewFields.structure, PlphViewRow.read)
  }
  override def selectAll: Stream[ConnectionIO, PlphViewRow] = {
    sql"""select "id", "productid", "startdate"::text, "enddate"::text, "listprice", "modifieddate"::text from pr.plph""".query(using PlphViewRow.read).stream
  }
}
