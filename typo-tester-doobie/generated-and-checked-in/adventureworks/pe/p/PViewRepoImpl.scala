/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pe
package p

import doobie.free.connection.ConnectionIO
import doobie.syntax.string.toSqlInterpolator
import fs2.Stream
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql

class PViewRepoImpl extends PViewRepo {
  override def select: SelectBuilder[PViewFields, PViewRow] = {
    SelectBuilderSql("pe.p", PViewFields.structure, PViewRow.read)
  }
  override def selectAll: Stream[ConnectionIO, PViewRow] = {
    sql"""select "id", "businessentityid", "persontype", "namestyle", "title", "firstname", "middlename", "lastname", "suffix", "emailpromotion", "additionalcontactinfo", "demographics", "rowguid", "modifieddate"::text from pe.p""".query(PViewRow.read).stream
  }
}
