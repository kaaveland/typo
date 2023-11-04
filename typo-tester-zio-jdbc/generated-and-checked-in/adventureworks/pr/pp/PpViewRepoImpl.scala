/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pr
package pp

import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql
import zio.jdbc.ZConnection
import zio.jdbc.sqlInterpolator
import zio.stream.ZStream

object PpViewRepoImpl extends PpViewRepo {
  override def select: SelectBuilder[PpViewFields, PpViewRow] = {
    SelectBuilderSql("pr.pp", PpViewFields, PpViewRow.jdbcDecoder)
  }
  override def selectAll: ZStream[ZConnection, Throwable, PpViewRow] = {
    sql"""select "id", "productphotoid", "thumbnailphoto", "thumbnailphotofilename", "largephoto", "largephotofilename", "modifieddate"::text from pr.pp""".query(PpViewRow.jdbcDecoder).selectStream
  }
}