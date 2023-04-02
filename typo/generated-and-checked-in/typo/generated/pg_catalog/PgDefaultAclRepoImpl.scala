/**
 * File has been automatically generated by `typo` for internal use.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 *
 * (If you're developing `typo` and want to change it: run `bleep generate-sources`)
 */
package typo
package generated
package pg_catalog

import anorm.NamedParameter
import anorm.ParameterValue
import anorm.SqlStringInterpolation
import java.sql.Connection

object PgDefaultAclRepoImpl extends PgDefaultAclRepo {
  override def selectAll(implicit c: Connection): List[PgDefaultAclRow] = {
    SQL"""select oid, defaclrole, defaclnamespace, defaclobjtype, defaclacl from pg_catalog.pg_default_acl""".as(PgDefaultAclRow.rowParser("").*)
  }
  override def selectById(oid: PgDefaultAclId)(implicit c: Connection): Option[PgDefaultAclRow] = {
    SQL"""select oid, defaclrole, defaclnamespace, defaclobjtype, defaclacl from pg_catalog.pg_default_acl where oid = $oid""".as(PgDefaultAclRow.rowParser("").singleOpt)
  }
  override def selectByIds(oids: List[PgDefaultAclId])(implicit c: Connection): List[PgDefaultAclRow] = {
    SQL"""select oid, defaclrole, defaclnamespace, defaclobjtype, defaclacl from pg_catalog.pg_default_acl where oid in $oids""".as(PgDefaultAclRow.rowParser("").*)
  }
  override def selectByFieldValues(fieldValues: List[PgDefaultAclFieldValue[_]])(implicit c: Connection): List[PgDefaultAclRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case PgDefaultAclFieldValue.oid(value) => NamedParameter("oid", ParameterValue.from(value))
          case PgDefaultAclFieldValue.defaclrole(value) => NamedParameter("defaclrole", ParameterValue.from(value))
          case PgDefaultAclFieldValue.defaclnamespace(value) => NamedParameter("defaclnamespace", ParameterValue.from(value))
          case PgDefaultAclFieldValue.defaclobjtype(value) => NamedParameter("defaclobjtype", ParameterValue.from(value))
          case PgDefaultAclFieldValue.defaclacl(value) => NamedParameter("defaclacl", ParameterValue.from(value))
        }
        val q = s"""select * from pg_catalog.pg_default_acl where ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(" AND ")}"""
        // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
        import anorm._
        SQL(q)
          .on(namedParams: _*)
          .as(PgDefaultAclRow.rowParser("").*)
    }

  }
  override def updateFieldValues(oid: PgDefaultAclId, fieldValues: List[PgDefaultAclFieldValue[_]])(implicit c: Connection): Int = {
    fieldValues match {
      case Nil => 0
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case PgDefaultAclFieldValue.oid(value) => NamedParameter("oid", ParameterValue.from(value))
          case PgDefaultAclFieldValue.defaclrole(value) => NamedParameter("defaclrole", ParameterValue.from(value))
          case PgDefaultAclFieldValue.defaclnamespace(value) => NamedParameter("defaclnamespace", ParameterValue.from(value))
          case PgDefaultAclFieldValue.defaclobjtype(value) => NamedParameter("defaclobjtype", ParameterValue.from(value))
          case PgDefaultAclFieldValue.defaclacl(value) => NamedParameter("defaclacl", ParameterValue.from(value))
        }
        val q = s"""update pg_catalog.pg_default_acl
          set ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(", ")}
          where oid = $oid"""
        // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
        import anorm._
        SQL(q)
          .on(namedParams: _*)
          .executeUpdate()
    }

  }
  override def insert(oid: PgDefaultAclId, unsaved: PgDefaultAclRowUnsaved)(implicit c: Connection): Boolean = {
    val namedParameters = List(
      Some(NamedParameter("defaclrole", ParameterValue.from(unsaved.defaclrole))),
      Some(NamedParameter("defaclnamespace", ParameterValue.from(unsaved.defaclnamespace))),
      Some(NamedParameter("defaclobjtype", ParameterValue.from(unsaved.defaclobjtype))),
      Some(NamedParameter("defaclacl", ParameterValue.from(unsaved.defaclacl)))
    ).flatten

    SQL"""insert into pg_catalog.pg_default_acl(oid, ${namedParameters.map(_.name).mkString(", ")})
      values (${oid}, ${namedParameters.map(np => s"{${np.name}}").mkString(", ")})
      """
      .on(namedParameters :_*)
      .execute()

  }
  override def delete(oid: PgDefaultAclId)(implicit c: Connection): Boolean = {
    SQL"""delete from pg_catalog.pg_default_acl where oid = $oid""".executeUpdate() > 0
  }
  override def selectByUniqueDefaclroleDefaclnamespaceDefaclobjtype(defaclrole: /* oid */ Long, defaclnamespace: /* oid */ Long, defaclobjtype: String)(implicit c: Connection): Option[PgDefaultAclRow] = {
    selectByFieldValues(List(PgDefaultAclFieldValue.defaclrole(defaclrole), PgDefaultAclFieldValue.defaclnamespace(defaclnamespace), PgDefaultAclFieldValue.defaclobjtype(defaclobjtype))).headOption
  }
}
