/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package applicable_roles

import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql
import zio.jdbc.ZConnection
import zio.jdbc.sqlInterpolator
import zio.stream.ZStream

object ApplicableRolesViewRepoImpl extends ApplicableRolesViewRepo {
  override def select: SelectBuilder[ApplicableRolesViewFields, ApplicableRolesViewRow] = {
    SelectBuilderSql("information_schema.applicable_roles", ApplicableRolesViewFields, ApplicableRolesViewRow.jdbcDecoder)
  }
  override def selectAll: ZStream[ZConnection, Throwable, ApplicableRolesViewRow] = {
    sql"""select "grantee", "role_name", "is_grantable" from information_schema.applicable_roles""".query(ApplicableRolesViewRow.jdbcDecoder).selectStream
  }
}
