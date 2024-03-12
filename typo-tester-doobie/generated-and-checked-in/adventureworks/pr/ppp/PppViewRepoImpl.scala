/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pr
package ppp

import doobie.free.connection.ConnectionIO
import doobie.syntax.string.toSqlInterpolator
import fs2.Stream
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql

class PppViewRepoImpl extends PppViewRepo {
  override def select: SelectBuilder[PppViewFields, PppViewRow] = {
    SelectBuilderSql("pr.ppp", PppViewFields.structure, PppViewRow.read)
  }
  override def selectAll: Stream[ConnectionIO, PppViewRow] = {
    sql"""select "productid", "productphotoid", "primary", "modifieddate"::text from pr.ppp""".query(PppViewRow.read).stream
  }
}
