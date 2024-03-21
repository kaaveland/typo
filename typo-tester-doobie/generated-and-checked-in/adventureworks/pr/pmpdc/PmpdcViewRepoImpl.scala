/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pr
package pmpdc

import doobie.free.connection.ConnectionIO
import doobie.syntax.string.toSqlInterpolator
import fs2.Stream
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql

class PmpdcViewRepoImpl extends PmpdcViewRepo {
  override def select: SelectBuilder[PmpdcViewFields, PmpdcViewRow] = {
    SelectBuilderSql("pr.pmpdc", PmpdcViewFields.structure, PmpdcViewRow.read)
  }
  override def selectAll: Stream[ConnectionIO, PmpdcViewRow] = {
    sql"""select "productmodelid", "productdescriptionid", "cultureid", "modifieddate"::text from pr.pmpdc""".query(using PmpdcViewRow.read).stream
  }
}
