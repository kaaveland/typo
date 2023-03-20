/**
 * File has been automatically generated by `typo` for internal use.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 *
 * (If you're developing `typo` and want to change it: run `bleep generate-sources)
 */
package typo
package generated
package pg_catalog

import anorm.NamedParameter
import anorm.ParameterValue
import anorm.SQL
import anorm.SqlStringInterpolation
import java.sql.Connection

object PgAuthMembersRepoImpl extends PgAuthMembersRepo {
  override def selectAll(implicit c: Connection): List[PgAuthMembersRow] = {
    SQL"""select roleid, member, grantor, admin_option from pg_catalog.pg_auth_members""".as(PgAuthMembersRow.rowParser.*)
  }
  override def selectById(compositeId: PgAuthMembersId)(implicit c: Connection): Option[PgAuthMembersRow] = {
    SQL"""select roleid, member, grantor, admin_option from pg_catalog.pg_auth_members where roleid = ${compositeId.roleid}, member = ${compositeId.member}""".as(PgAuthMembersRow.rowParser.singleOpt)
  }
  override def selectByFieldValues(fieldValues: List[PgAuthMembersFieldValue[_]])(implicit c: Connection): List[PgAuthMembersRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case PgAuthMembersFieldValue.roleid(value) => NamedParameter("roleid", ParameterValue.from(value))
          case PgAuthMembersFieldValue.member(value) => NamedParameter("member", ParameterValue.from(value))
          case PgAuthMembersFieldValue.grantor(value) => NamedParameter("grantor", ParameterValue.from(value))
          case PgAuthMembersFieldValue.adminOption(value) => NamedParameter("admin_option", ParameterValue.from(value))
        }
        val q = s"""select * from pg_catalog.pg_auth_members where ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(" AND ")}"""
        SQL(q)
          .on(namedParams: _*)
          .as(PgAuthMembersRow.rowParser.*)
    }

  }
  override def updateFieldValues(compositeId: PgAuthMembersId, fieldValues: List[PgAuthMembersFieldValue[_]])(implicit c: Connection): Int = {
    fieldValues match {
      case Nil => 0
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case PgAuthMembersFieldValue.roleid(value) => NamedParameter("roleid", ParameterValue.from(value))
          case PgAuthMembersFieldValue.member(value) => NamedParameter("member", ParameterValue.from(value))
          case PgAuthMembersFieldValue.grantor(value) => NamedParameter("grantor", ParameterValue.from(value))
          case PgAuthMembersFieldValue.adminOption(value) => NamedParameter("admin_option", ParameterValue.from(value))
        }
        val q = s"""update pg_catalog.pg_auth_members
          set ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(", ")}
          where roleid = ${compositeId.roleid}, member = ${compositeId.member}"""
        SQL(q)
          .on(namedParams: _*)
          .executeUpdate()
    }

  }
  override def insert(compositeId: PgAuthMembersId, unsaved: PgAuthMembersRowUnsaved)(implicit c: Connection): Unit = {
    val namedParameters = List(
      Some(NamedParameter("grantor", ParameterValue.from(unsaved.grantor))),
      Some(NamedParameter("admin_option", ParameterValue.from(unsaved.adminOption)))
    ).flatten

    SQL"""insert into pg_catalog.pg_auth_members(roleid, member, ${namedParameters.map(_.name).mkString(", ")})
      values (${compositeId.roleid}, ${compositeId.member}, ${namedParameters.map(np => s"{${np.name}}").mkString(", ")})
      """
      .on(namedParameters :_*)
      .execute()

  }
  override def delete(compositeId: PgAuthMembersId)(implicit c: Connection): Boolean = {
    SQL"""delete from pg_catalog.pg_auth_members where roleid = ${compositeId.roleid}, member = ${compositeId.member}""".executeUpdate() > 0
  }
  override def selectByUnique(member: Long, roleid: Long)(implicit c: Connection): Option[PgAuthMembersRow] = {
    ???
  }
}