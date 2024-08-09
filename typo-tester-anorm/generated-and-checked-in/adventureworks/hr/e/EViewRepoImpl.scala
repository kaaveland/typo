/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package hr
package e

import anorm.SqlStringInterpolation
import java.sql.Connection
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql

class EViewRepoImpl extends EViewRepo {
  override def select: SelectBuilder[EViewFields, EViewRow] = {
    SelectBuilderSql(""""hr"."e"""", EViewFields.structure, EViewRow.rowParser)
  }
  override def selectAll(implicit c: Connection): List[EViewRow] = {
    SQL"""select "id", "businessentityid", "nationalidnumber", "loginid", "jobtitle", "birthdate"::text, "maritalstatus", "gender", "hiredate"::text, "salariedflag", "vacationhours", "sickleavehours", "currentflag", "rowguid", "modifieddate"::text, "organizationnode"
          from "hr"."e"
       """.as(EViewRow.rowParser(1).*)
  }
}
