/**
 * File automatically generated by `typo` for its own test suite.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN
 */
package testdb
package postgres
package pg_catalog

import anorm.NamedParameter
import anorm.ParameterValue
import anorm.SQL
import anorm.SqlStringInterpolation
import java.sql.Connection

object PgStatisticRepoImpl extends PgStatisticRepo {
  override def selectAll(implicit c: Connection): List[PgStatisticRow] = {
    SQL"""select starelid, staattnum, stainherit, stanullfrac, stawidth, stadistinct, stakind1, stakind2, stakind3, stakind4, stakind5, staop1, staop2, staop3, staop4, staop5, stacoll1, stacoll2, stacoll3, stacoll4, stacoll5, stanumbers1, stanumbers2, stanumbers3, stanumbers4, stanumbers5, stavalues1, stavalues2, stavalues3, stavalues4, stavalues5 from pg_catalog.pg_statistic""".as(PgStatisticRow.rowParser.*)
  }
  override def selectById(compositeId: PgStatisticId)(implicit c: Connection): Option[PgStatisticRow] = {
    SQL"""select starelid, staattnum, stainherit, stanullfrac, stawidth, stadistinct, stakind1, stakind2, stakind3, stakind4, stakind5, staop1, staop2, staop3, staop4, staop5, stacoll1, stacoll2, stacoll3, stacoll4, stacoll5, stanumbers1, stanumbers2, stanumbers3, stanumbers4, stanumbers5, stavalues1, stavalues2, stavalues3, stavalues4, stavalues5 from pg_catalog.pg_statistic where starelid = ${compositeId.starelid}, staattnum = ${compositeId.staattnum}, stainherit = ${compositeId.stainherit}""".as(PgStatisticRow.rowParser.singleOpt)
  }
  override def selectByFieldValues(fieldValues: List[PgStatisticFieldValue[_]])(implicit c: Connection): List[PgStatisticRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case PgStatisticFieldValue.starelid(value) => NamedParameter("starelid", ParameterValue.from(value))
          case PgStatisticFieldValue.staattnum(value) => NamedParameter("staattnum", ParameterValue.from(value))
          case PgStatisticFieldValue.stainherit(value) => NamedParameter("stainherit", ParameterValue.from(value))
          case PgStatisticFieldValue.stanullfrac(value) => NamedParameter("stanullfrac", ParameterValue.from(value))
          case PgStatisticFieldValue.stawidth(value) => NamedParameter("stawidth", ParameterValue.from(value))
          case PgStatisticFieldValue.stadistinct(value) => NamedParameter("stadistinct", ParameterValue.from(value))
          case PgStatisticFieldValue.stakind1(value) => NamedParameter("stakind1", ParameterValue.from(value))
          case PgStatisticFieldValue.stakind2(value) => NamedParameter("stakind2", ParameterValue.from(value))
          case PgStatisticFieldValue.stakind3(value) => NamedParameter("stakind3", ParameterValue.from(value))
          case PgStatisticFieldValue.stakind4(value) => NamedParameter("stakind4", ParameterValue.from(value))
          case PgStatisticFieldValue.stakind5(value) => NamedParameter("stakind5", ParameterValue.from(value))
          case PgStatisticFieldValue.staop1(value) => NamedParameter("staop1", ParameterValue.from(value))
          case PgStatisticFieldValue.staop2(value) => NamedParameter("staop2", ParameterValue.from(value))
          case PgStatisticFieldValue.staop3(value) => NamedParameter("staop3", ParameterValue.from(value))
          case PgStatisticFieldValue.staop4(value) => NamedParameter("staop4", ParameterValue.from(value))
          case PgStatisticFieldValue.staop5(value) => NamedParameter("staop5", ParameterValue.from(value))
          case PgStatisticFieldValue.stacoll1(value) => NamedParameter("stacoll1", ParameterValue.from(value))
          case PgStatisticFieldValue.stacoll2(value) => NamedParameter("stacoll2", ParameterValue.from(value))
          case PgStatisticFieldValue.stacoll3(value) => NamedParameter("stacoll3", ParameterValue.from(value))
          case PgStatisticFieldValue.stacoll4(value) => NamedParameter("stacoll4", ParameterValue.from(value))
          case PgStatisticFieldValue.stacoll5(value) => NamedParameter("stacoll5", ParameterValue.from(value))
          case PgStatisticFieldValue.stanumbers1(value) => NamedParameter("stanumbers1", ParameterValue.from(value))
          case PgStatisticFieldValue.stanumbers2(value) => NamedParameter("stanumbers2", ParameterValue.from(value))
          case PgStatisticFieldValue.stanumbers3(value) => NamedParameter("stanumbers3", ParameterValue.from(value))
          case PgStatisticFieldValue.stanumbers4(value) => NamedParameter("stanumbers4", ParameterValue.from(value))
          case PgStatisticFieldValue.stanumbers5(value) => NamedParameter("stanumbers5", ParameterValue.from(value))
          case PgStatisticFieldValue.stavalues1(value) => NamedParameter("stavalues1", ParameterValue.from(value))
          case PgStatisticFieldValue.stavalues2(value) => NamedParameter("stavalues2", ParameterValue.from(value))
          case PgStatisticFieldValue.stavalues3(value) => NamedParameter("stavalues3", ParameterValue.from(value))
          case PgStatisticFieldValue.stavalues4(value) => NamedParameter("stavalues4", ParameterValue.from(value))
          case PgStatisticFieldValue.stavalues5(value) => NamedParameter("stavalues5", ParameterValue.from(value))
        }
        val q = s"""select * from pg_catalog.pg_statistic where ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(" AND ")}"""
        SQL(q)
          .on(namedParams: _*)
          .as(PgStatisticRow.rowParser.*)
    }

  }
  override def updateFieldValues(compositeId: PgStatisticId, fieldValues: List[PgStatisticFieldValue[_]])(implicit c: Connection): Int = {
    fieldValues match {
      case Nil => 0
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case PgStatisticFieldValue.starelid(value) => NamedParameter("starelid", ParameterValue.from(value))
          case PgStatisticFieldValue.staattnum(value) => NamedParameter("staattnum", ParameterValue.from(value))
          case PgStatisticFieldValue.stainherit(value) => NamedParameter("stainherit", ParameterValue.from(value))
          case PgStatisticFieldValue.stanullfrac(value) => NamedParameter("stanullfrac", ParameterValue.from(value))
          case PgStatisticFieldValue.stawidth(value) => NamedParameter("stawidth", ParameterValue.from(value))
          case PgStatisticFieldValue.stadistinct(value) => NamedParameter("stadistinct", ParameterValue.from(value))
          case PgStatisticFieldValue.stakind1(value) => NamedParameter("stakind1", ParameterValue.from(value))
          case PgStatisticFieldValue.stakind2(value) => NamedParameter("stakind2", ParameterValue.from(value))
          case PgStatisticFieldValue.stakind3(value) => NamedParameter("stakind3", ParameterValue.from(value))
          case PgStatisticFieldValue.stakind4(value) => NamedParameter("stakind4", ParameterValue.from(value))
          case PgStatisticFieldValue.stakind5(value) => NamedParameter("stakind5", ParameterValue.from(value))
          case PgStatisticFieldValue.staop1(value) => NamedParameter("staop1", ParameterValue.from(value))
          case PgStatisticFieldValue.staop2(value) => NamedParameter("staop2", ParameterValue.from(value))
          case PgStatisticFieldValue.staop3(value) => NamedParameter("staop3", ParameterValue.from(value))
          case PgStatisticFieldValue.staop4(value) => NamedParameter("staop4", ParameterValue.from(value))
          case PgStatisticFieldValue.staop5(value) => NamedParameter("staop5", ParameterValue.from(value))
          case PgStatisticFieldValue.stacoll1(value) => NamedParameter("stacoll1", ParameterValue.from(value))
          case PgStatisticFieldValue.stacoll2(value) => NamedParameter("stacoll2", ParameterValue.from(value))
          case PgStatisticFieldValue.stacoll3(value) => NamedParameter("stacoll3", ParameterValue.from(value))
          case PgStatisticFieldValue.stacoll4(value) => NamedParameter("stacoll4", ParameterValue.from(value))
          case PgStatisticFieldValue.stacoll5(value) => NamedParameter("stacoll5", ParameterValue.from(value))
          case PgStatisticFieldValue.stanumbers1(value) => NamedParameter("stanumbers1", ParameterValue.from(value))
          case PgStatisticFieldValue.stanumbers2(value) => NamedParameter("stanumbers2", ParameterValue.from(value))
          case PgStatisticFieldValue.stanumbers3(value) => NamedParameter("stanumbers3", ParameterValue.from(value))
          case PgStatisticFieldValue.stanumbers4(value) => NamedParameter("stanumbers4", ParameterValue.from(value))
          case PgStatisticFieldValue.stanumbers5(value) => NamedParameter("stanumbers5", ParameterValue.from(value))
          case PgStatisticFieldValue.stavalues1(value) => NamedParameter("stavalues1", ParameterValue.from(value))
          case PgStatisticFieldValue.stavalues2(value) => NamedParameter("stavalues2", ParameterValue.from(value))
          case PgStatisticFieldValue.stavalues3(value) => NamedParameter("stavalues3", ParameterValue.from(value))
          case PgStatisticFieldValue.stavalues4(value) => NamedParameter("stavalues4", ParameterValue.from(value))
          case PgStatisticFieldValue.stavalues5(value) => NamedParameter("stavalues5", ParameterValue.from(value))
        }
        val q = s"""update pg_catalog.pg_statistic
          set ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(", ")}
          where starelid = ${compositeId.starelid}, staattnum = ${compositeId.staattnum}, stainherit = ${compositeId.stainherit}"""
        SQL(q)
          .on(namedParams: _*)
          .executeUpdate()
    }

  }
  override def insert(compositeId: PgStatisticId, unsaved: PgStatisticRowUnsaved)(implicit c: Connection): Unit = {
    val namedParameters = List(
      Some(NamedParameter("stanullfrac", ParameterValue.from(unsaved.stanullfrac))),
      Some(NamedParameter("stawidth", ParameterValue.from(unsaved.stawidth))),
      Some(NamedParameter("stadistinct", ParameterValue.from(unsaved.stadistinct))),
      Some(NamedParameter("stakind1", ParameterValue.from(unsaved.stakind1))),
      Some(NamedParameter("stakind2", ParameterValue.from(unsaved.stakind2))),
      Some(NamedParameter("stakind3", ParameterValue.from(unsaved.stakind3))),
      Some(NamedParameter("stakind4", ParameterValue.from(unsaved.stakind4))),
      Some(NamedParameter("stakind5", ParameterValue.from(unsaved.stakind5))),
      Some(NamedParameter("staop1", ParameterValue.from(unsaved.staop1))),
      Some(NamedParameter("staop2", ParameterValue.from(unsaved.staop2))),
      Some(NamedParameter("staop3", ParameterValue.from(unsaved.staop3))),
      Some(NamedParameter("staop4", ParameterValue.from(unsaved.staop4))),
      Some(NamedParameter("staop5", ParameterValue.from(unsaved.staop5))),
      Some(NamedParameter("stacoll1", ParameterValue.from(unsaved.stacoll1))),
      Some(NamedParameter("stacoll2", ParameterValue.from(unsaved.stacoll2))),
      Some(NamedParameter("stacoll3", ParameterValue.from(unsaved.stacoll3))),
      Some(NamedParameter("stacoll4", ParameterValue.from(unsaved.stacoll4))),
      Some(NamedParameter("stacoll5", ParameterValue.from(unsaved.stacoll5))),
      Some(NamedParameter("stanumbers1", ParameterValue.from(unsaved.stanumbers1))),
      Some(NamedParameter("stanumbers2", ParameterValue.from(unsaved.stanumbers2))),
      Some(NamedParameter("stanumbers3", ParameterValue.from(unsaved.stanumbers3))),
      Some(NamedParameter("stanumbers4", ParameterValue.from(unsaved.stanumbers4))),
      Some(NamedParameter("stanumbers5", ParameterValue.from(unsaved.stanumbers5))),
      Some(NamedParameter("stavalues1", ParameterValue.from(unsaved.stavalues1))),
      Some(NamedParameter("stavalues2", ParameterValue.from(unsaved.stavalues2))),
      Some(NamedParameter("stavalues3", ParameterValue.from(unsaved.stavalues3))),
      Some(NamedParameter("stavalues4", ParameterValue.from(unsaved.stavalues4))),
      Some(NamedParameter("stavalues5", ParameterValue.from(unsaved.stavalues5)))
    ).flatten

    SQL"""insert into pg_catalog.pg_statistic(starelid, staattnum, stainherit, ${namedParameters.map(_.name).mkString(", ")})
      values (${compositeId.starelid}, ${compositeId.staattnum}, ${compositeId.stainherit}, ${namedParameters.map(np => s"{${np.name}}").mkString(", ")})
      """
      .on(namedParameters :_*)
      .execute()

  }
  override def delete(compositeId: PgStatisticId)(implicit c: Connection): Boolean = {
    SQL"""delete from pg_catalog.pg_statistic where starelid = ${compositeId.starelid}, staattnum = ${compositeId.staattnum}, stainherit = ${compositeId.stainherit}""".executeUpdate() > 0
  }
}
