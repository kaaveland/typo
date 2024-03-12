/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pr
package pdoc

import doobie.free.connection.ConnectionIO
import doobie.syntax.string.toSqlInterpolator
import fs2.Stream
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql

class PdocViewRepoImpl extends PdocViewRepo {
  override def select: SelectBuilder[PdocViewFields, PdocViewRow] = {
    SelectBuilderSql("pr.pdoc", PdocViewFields.structure, PdocViewRow.read)
  }
  override def selectAll: Stream[ConnectionIO, PdocViewRow] = {
    sql"""select "id", "productid", "modifieddate"::text, "documentnode" from pr.pdoc""".query(PdocViewRow.read).stream
  }
}
