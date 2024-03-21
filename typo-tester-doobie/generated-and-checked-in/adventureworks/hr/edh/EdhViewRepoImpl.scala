/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package hr
package edh

import doobie.free.connection.ConnectionIO
import doobie.syntax.string.toSqlInterpolator
import fs2.Stream
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql

class EdhViewRepoImpl extends EdhViewRepo {
  override def select: SelectBuilder[EdhViewFields, EdhViewRow] = {
    SelectBuilderSql("hr.edh", EdhViewFields.structure, EdhViewRow.read)
  }
  override def selectAll: Stream[ConnectionIO, EdhViewRow] = {
    sql"""select "id", "businessentityid", "departmentid", "shiftid", "startdate"::text, "enddate"::text, "modifieddate"::text from hr.edh""".query(using EdhViewRow.read).stream
  }
}
