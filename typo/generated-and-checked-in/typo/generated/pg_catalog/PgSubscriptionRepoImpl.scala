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

object PgSubscriptionRepoImpl extends PgSubscriptionRepo {
  override def selectAll(implicit c: Connection): List[PgSubscriptionRow] = {
    SQL"""select oid, subdbid, subname, subowner, subenabled, subbinary, substream, subconninfo, subslotname, subsynccommit, subpublications from pg_catalog.pg_subscription""".as(PgSubscriptionRow.rowParser("").*)
  }
  override def selectById(oid: PgSubscriptionId)(implicit c: Connection): Option[PgSubscriptionRow] = {
    SQL"""select oid, subdbid, subname, subowner, subenabled, subbinary, substream, subconninfo, subslotname, subsynccommit, subpublications from pg_catalog.pg_subscription where oid = $oid""".as(PgSubscriptionRow.rowParser("").singleOpt)
  }
  override def selectByIds(oids: List[PgSubscriptionId])(implicit c: Connection): List[PgSubscriptionRow] = {
    SQL"""select oid, subdbid, subname, subowner, subenabled, subbinary, substream, subconninfo, subslotname, subsynccommit, subpublications from pg_catalog.pg_subscription where oid in $oids""".as(PgSubscriptionRow.rowParser("").*)
  }
  override def selectByFieldValues(fieldValues: List[PgSubscriptionFieldValue[_]])(implicit c: Connection): List[PgSubscriptionRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case PgSubscriptionFieldValue.oid(value) => NamedParameter("oid", ParameterValue.from(value))
          case PgSubscriptionFieldValue.subdbid(value) => NamedParameter("subdbid", ParameterValue.from(value))
          case PgSubscriptionFieldValue.subname(value) => NamedParameter("subname", ParameterValue.from(value))
          case PgSubscriptionFieldValue.subowner(value) => NamedParameter("subowner", ParameterValue.from(value))
          case PgSubscriptionFieldValue.subenabled(value) => NamedParameter("subenabled", ParameterValue.from(value))
          case PgSubscriptionFieldValue.subbinary(value) => NamedParameter("subbinary", ParameterValue.from(value))
          case PgSubscriptionFieldValue.substream(value) => NamedParameter("substream", ParameterValue.from(value))
          case PgSubscriptionFieldValue.subconninfo(value) => NamedParameter("subconninfo", ParameterValue.from(value))
          case PgSubscriptionFieldValue.subslotname(value) => NamedParameter("subslotname", ParameterValue.from(value))
          case PgSubscriptionFieldValue.subsynccommit(value) => NamedParameter("subsynccommit", ParameterValue.from(value))
          case PgSubscriptionFieldValue.subpublications(value) => NamedParameter("subpublications", ParameterValue.from(value))
        }
        val q = s"""select * from pg_catalog.pg_subscription where ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(" AND ")}"""
        // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
        import anorm._
        SQL(q)
          .on(namedParams: _*)
          .as(PgSubscriptionRow.rowParser("").*)
    }

  }
  override def updateFieldValues(oid: PgSubscriptionId, fieldValues: List[PgSubscriptionFieldValue[_]])(implicit c: Connection): Int = {
    fieldValues match {
      case Nil => 0
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case PgSubscriptionFieldValue.oid(value) => NamedParameter("oid", ParameterValue.from(value))
          case PgSubscriptionFieldValue.subdbid(value) => NamedParameter("subdbid", ParameterValue.from(value))
          case PgSubscriptionFieldValue.subname(value) => NamedParameter("subname", ParameterValue.from(value))
          case PgSubscriptionFieldValue.subowner(value) => NamedParameter("subowner", ParameterValue.from(value))
          case PgSubscriptionFieldValue.subenabled(value) => NamedParameter("subenabled", ParameterValue.from(value))
          case PgSubscriptionFieldValue.subbinary(value) => NamedParameter("subbinary", ParameterValue.from(value))
          case PgSubscriptionFieldValue.substream(value) => NamedParameter("substream", ParameterValue.from(value))
          case PgSubscriptionFieldValue.subconninfo(value) => NamedParameter("subconninfo", ParameterValue.from(value))
          case PgSubscriptionFieldValue.subslotname(value) => NamedParameter("subslotname", ParameterValue.from(value))
          case PgSubscriptionFieldValue.subsynccommit(value) => NamedParameter("subsynccommit", ParameterValue.from(value))
          case PgSubscriptionFieldValue.subpublications(value) => NamedParameter("subpublications", ParameterValue.from(value))
        }
        val q = s"""update pg_catalog.pg_subscription
          set ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(", ")}
          where oid = $oid"""
        // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
        import anorm._
        SQL(q)
          .on(namedParams: _*)
          .executeUpdate()
    }

  }
  override def insert(oid: PgSubscriptionId, unsaved: PgSubscriptionRowUnsaved)(implicit c: Connection): Boolean = {
    val namedParameters = List(
      Some(NamedParameter("subdbid", ParameterValue.from(unsaved.subdbid))),
      Some(NamedParameter("subname", ParameterValue.from(unsaved.subname))),
      Some(NamedParameter("subowner", ParameterValue.from(unsaved.subowner))),
      Some(NamedParameter("subenabled", ParameterValue.from(unsaved.subenabled))),
      Some(NamedParameter("subbinary", ParameterValue.from(unsaved.subbinary))),
      Some(NamedParameter("substream", ParameterValue.from(unsaved.substream))),
      Some(NamedParameter("subconninfo", ParameterValue.from(unsaved.subconninfo))),
      Some(NamedParameter("subslotname", ParameterValue.from(unsaved.subslotname))),
      Some(NamedParameter("subsynccommit", ParameterValue.from(unsaved.subsynccommit))),
      Some(NamedParameter("subpublications", ParameterValue.from(unsaved.subpublications)))
    ).flatten

    SQL"""insert into pg_catalog.pg_subscription(oid, ${namedParameters.map(_.name).mkString(", ")})
      values (${oid}, ${namedParameters.map(np => s"{${np.name}}").mkString(", ")})
      """
      .on(namedParameters :_*)
      .execute()

  }
  override def delete(oid: PgSubscriptionId)(implicit c: Connection): Boolean = {
    SQL"""delete from pg_catalog.pg_subscription where oid = $oid""".executeUpdate() > 0
  }
  override def selectByUniqueSubdbidSubname(subdbid: /* oid */ Long, subname: String)(implicit c: Connection): Option[PgSubscriptionRow] = {
    selectByFieldValues(List(PgSubscriptionFieldValue.subdbid(subdbid), PgSubscriptionFieldValue.subname(subname))).headOption
  }
}
