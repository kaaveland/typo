/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pr
package c

import anorm.SqlStringInterpolation
import java.sql.Connection
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql

class CViewRepoImpl extends CViewRepo {
  override def select: SelectBuilder[CViewFields, CViewRow] = {
    SelectBuilderSql("pr.c", CViewFields.structure, CViewRow.rowParser)
  }
  override def selectAll(implicit c: Connection): List[CViewRow] = {
    SQL"""select "id", "cultureid", "name", "modifieddate"::text
          from pr.c
       """.as(CViewRow.rowParser(1).*)
  }
}
