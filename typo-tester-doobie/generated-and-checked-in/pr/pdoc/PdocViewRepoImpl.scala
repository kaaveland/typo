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

object PdocViewRepoImpl extends PdocViewRepo {
  override def selectAll: Stream[ConnectionIO, PdocViewRow] = {
    sql"""select "id", productid, modifieddate, documentnode from pr.pdoc""".query[PdocViewRow].stream
  }
}
