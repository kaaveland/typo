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

object PgInheritsRepoImpl extends PgInheritsRepo {
  override def selectAll(implicit c: Connection): List[PgInheritsRow] = {
    SQL"""select inhrelid, inhparent, inhseqno, inhdetachpending from pg_catalog.pg_inherits""".as(PgInheritsRow.rowParser("").*)
  }
  override def selectById(compositeId: PgInheritsId)(implicit c: Connection): Option[PgInheritsRow] = {
    SQL"""select inhrelid, inhparent, inhseqno, inhdetachpending from pg_catalog.pg_inherits where inhrelid = ${compositeId.inhrelid}, inhseqno = ${compositeId.inhseqno}""".as(PgInheritsRow.rowParser("").singleOpt)
  }
  override def selectByFieldValues(fieldValues: List[PgInheritsFieldValue[_]])(implicit c: Connection): List[PgInheritsRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case PgInheritsFieldValue.inhrelid(value) => NamedParameter("inhrelid", ParameterValue.from(value))
          case PgInheritsFieldValue.inhparent(value) => NamedParameter("inhparent", ParameterValue.from(value))
          case PgInheritsFieldValue.inhseqno(value) => NamedParameter("inhseqno", ParameterValue.from(value))
          case PgInheritsFieldValue.inhdetachpending(value) => NamedParameter("inhdetachpending", ParameterValue.from(value))
        }
        val q = s"""select * from pg_catalog.pg_inherits where ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(" AND ")}"""
        // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
        import anorm._
        SQL(q)
          .on(namedParams: _*)
          .as(PgInheritsRow.rowParser("").*)
    }

  }
  override def updateFieldValues(compositeId: PgInheritsId, fieldValues: List[PgInheritsFieldValue[_]])(implicit c: Connection): Int = {
    fieldValues match {
      case Nil => 0
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case PgInheritsFieldValue.inhrelid(value) => NamedParameter("inhrelid", ParameterValue.from(value))
          case PgInheritsFieldValue.inhparent(value) => NamedParameter("inhparent", ParameterValue.from(value))
          case PgInheritsFieldValue.inhseqno(value) => NamedParameter("inhseqno", ParameterValue.from(value))
          case PgInheritsFieldValue.inhdetachpending(value) => NamedParameter("inhdetachpending", ParameterValue.from(value))
        }
        val q = s"""update pg_catalog.pg_inherits
          set ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(", ")}
          where inhrelid = ${compositeId.inhrelid}, inhseqno = ${compositeId.inhseqno}"""
        // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
        import anorm._
        SQL(q)
          .on(namedParams: _*)
          .executeUpdate()
    }

  }
  override def insert(compositeId: PgInheritsId, unsaved: PgInheritsRowUnsaved)(implicit c: Connection): Boolean = {
    val namedParameters = List(
      Some(NamedParameter("inhparent", ParameterValue.from(unsaved.inhparent))),
      Some(NamedParameter("inhdetachpending", ParameterValue.from(unsaved.inhdetachpending)))
    ).flatten

    SQL"""insert into pg_catalog.pg_inherits(inhrelid, inhseqno, ${namedParameters.map(_.name).mkString(", ")})
      values (${compositeId.inhrelid}, ${compositeId.inhseqno}, ${namedParameters.map(np => s"{${np.name}}").mkString(", ")})
      """
      .on(namedParameters :_*)
      .execute()

  }
  override def delete(compositeId: PgInheritsId)(implicit c: Connection): Boolean = {
    SQL"""delete from pg_catalog.pg_inherits where inhrelid = ${compositeId.inhrelid}, inhseqno = ${compositeId.inhseqno}""".executeUpdate() > 0
  }
}
