/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package location

import adventureworks.Defaulted.Provided
import adventureworks.Defaulted.UseDefault
import anorm.NamedParameter
import anorm.ParameterValue
import anorm.SqlParser
import anorm.SqlStringInterpolation
import java.sql.Connection
import java.time.LocalDateTime

object LocationRepoImpl extends LocationRepo {
  override def delete(locationid: LocationId)(implicit c: Connection): Boolean = {
    SQL"""delete from production.location where locationid = $locationid""".executeUpdate() > 0
  }
  override def insert(unsaved: LocationRowUnsaved)(implicit c: Connection): LocationId = {
    val namedParameters = List(
      Some(NamedParameter("name", ParameterValue.from(unsaved.name))),
      unsaved.costrate match {
        case UseDefault => None
        case Provided(value) => Some(NamedParameter("costrate", ParameterValue.from[BigDecimal](value)))
      },
      unsaved.availability match {
        case UseDefault => None
        case Provided(value) => Some(NamedParameter("availability", ParameterValue.from[BigDecimal](value)))
      },
      unsaved.modifieddate match {
        case UseDefault => None
        case Provided(value) => Some(NamedParameter("modifieddate", ParameterValue.from[LocalDateTime](value)))
      }
    ).flatten
    
    SQL"""insert into production.location(${namedParameters.map(_.name).mkString(", ")})
          values (${namedParameters.map(np => s"{${np.name}}").mkString(", ")})
          returning locationid
    """
      .on(namedParameters :_*)
      .executeInsert(SqlParser.get[LocationId]("locationid").single)
  
  }
  override def selectAll(implicit c: Connection): List[LocationRow] = {
    SQL"""select locationid, name, costrate, availability, modifieddate from production.location""".as(LocationRow.rowParser("").*)
  }
  override def selectByFieldValues(fieldValues: List[LocationFieldOrIdValue[_]])(implicit c: Connection): List[LocationRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case LocationFieldValue.locationid(value) => NamedParameter("locationid", ParameterValue.from(value))
          case LocationFieldValue.name(value) => NamedParameter("name", ParameterValue.from(value))
          case LocationFieldValue.costrate(value) => NamedParameter("costrate", ParameterValue.from(value))
          case LocationFieldValue.availability(value) => NamedParameter("availability", ParameterValue.from(value))
          case LocationFieldValue.modifieddate(value) => NamedParameter("modifieddate", ParameterValue.from(value))
        }
        val q = s"""select * from production.location where ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(" AND ")}"""
        // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
        import anorm._
        SQL(q)
          .on(namedParams: _*)
          .as(LocationRow.rowParser("").*)
    }
  
  }
  override def selectById(locationid: LocationId)(implicit c: Connection): Option[LocationRow] = {
    SQL"""select locationid, name, costrate, availability, modifieddate from production.location where locationid = $locationid""".as(LocationRow.rowParser("").singleOpt)
  }
  override def selectByIds(locationids: List[LocationId])(implicit c: Connection): List[LocationRow] = {
    SQL"""select locationid, name, costrate, availability, modifieddate from production.location where locationid in $locationids""".as(LocationRow.rowParser("").*)
  }
  override def update(locationid: LocationId, row: LocationRow)(implicit c: Connection): Boolean = {
    SQL"""update production.location
          set name = ${row.name},
              costrate = ${row.costrate},
              availability = ${row.availability},
              modifieddate = ${row.modifieddate}
          where locationid = $locationid""".executeUpdate() > 0
  }
  override def updateFieldValues(locationid: LocationId, fieldValues: List[LocationFieldValue[_]])(implicit c: Connection): Boolean = {
    fieldValues match {
      case Nil => false
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case LocationFieldValue.name(value) => NamedParameter("name", ParameterValue.from(value))
          case LocationFieldValue.costrate(value) => NamedParameter("costrate", ParameterValue.from(value))
          case LocationFieldValue.availability(value) => NamedParameter("availability", ParameterValue.from(value))
          case LocationFieldValue.modifieddate(value) => NamedParameter("modifieddate", ParameterValue.from(value))
        }
        val q = s"""update production.location
                    set ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(", ")}
                    where locationid = $locationid"""
        // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
        import anorm._
        SQL(q)
          .on(namedParams: _*)
          .executeUpdate() > 0
    }
  
  }
}
