/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package culture

import adventureworks.Defaulted
import adventureworks.public.Name
import anorm.NamedParameter
import anorm.ParameterValue
import anorm.RowParser
import anorm.SqlStringInterpolation
import anorm.Success
import anorm.ToSql
import anorm.ToStatement
import java.sql.Connection
import java.sql.PreparedStatement
import java.time.LocalDateTime

object CultureRepoImpl extends CultureRepo {
  override def delete(cultureid: CultureId)(implicit c: Connection): Boolean = {
    SQL"delete from production.culture where cultureid = $cultureid".executeUpdate() > 0
  }
  override def insert(cultureid: CultureId, unsaved: CultureRowUnsaved)(implicit c: Connection): CultureRow = {
    val namedParameters = List(
      Some((NamedParameter("name", ParameterValue.from(unsaved.name)), """::"public"."Name"""")),
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("modifieddate", ParameterValue.from[LocalDateTime](value)), "::timestamp"))
      }
    ).flatten
    val q = s"""insert into production.culture(cultureid, ${namedParameters.map(_._1.name).mkString(", ")})
                values ({cultureid}::bpchar, ${namedParameters.map{case (np, cast) => s"{${np.name}}$cast"}.mkString(", ")})
                returning cultureid, "name", modifieddate
             """
    // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
    import anorm._
    SQL(q)
      .on(namedParameters.map(_._1) :_*)
      .on(NamedParameter("cultureid", ParameterValue.from(cultureid)))
      .executeInsert(rowParser.single)
  
  }
  override def selectAll(implicit c: Connection): List[CultureRow] = {
    SQL"""select cultureid, "name", modifieddate
          from production.culture
       """.as(rowParser.*)
  }
  override def selectByFieldValues(fieldValues: List[CultureFieldOrIdValue[_]])(implicit c: Connection): List[CultureRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case CultureFieldValue.cultureid(value) => NamedParameter("cultureid", ParameterValue.from(value))
          case CultureFieldValue.name(value) => NamedParameter("name", ParameterValue.from(value))
          case CultureFieldValue.modifieddate(value) => NamedParameter("modifieddate", ParameterValue.from(value))
        }
        val q = s"""select cultureid, "name", modifieddate
                    from production.culture
                    where ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(" AND ")}
                 """
        // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
        import anorm._
        SQL(q)
          .on(namedParams: _*)
          .as(rowParser.*)
    }
  
  }
  override def selectById(cultureid: CultureId)(implicit c: Connection): Option[CultureRow] = {
    SQL"""select cultureid, "name", modifieddate
          from production.culture
          where cultureid = $cultureid
       """.as(rowParser.singleOpt)
  }
  override def selectByIds(cultureids: Array[CultureId])(implicit c: Connection): List[CultureRow] = {
    implicit val arrayToSql: ToSql[Array[CultureId]] = _ => ("?", 1) // fix wrong instance from anorm
    implicit val toStatement: ToStatement[Array[CultureId]] =
      (s: PreparedStatement, index: Int, v: Array[CultureId]) =>
        s.setArray(index, s.getConnection.createArrayOf("bpchar", v.map(x => x.value)))
    
    SQL"""select cultureid, "name", modifieddate
          from production.culture
          where cultureid = ANY($cultureids)
       """.as(rowParser.*)
  
  }
  override def update(row: CultureRow)(implicit c: Connection): Boolean = {
    val cultureid = row.cultureid
    SQL"""update production.culture
          set "name" = ${row.name},
              modifieddate = ${row.modifieddate}
          where cultureid = $cultureid
       """.executeUpdate() > 0
  }
  override def updateFieldValues(cultureid: CultureId, fieldValues: List[CultureFieldValue[_]])(implicit c: Connection): Boolean = {
    fieldValues match {
      case Nil => false
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case CultureFieldValue.name(value) => NamedParameter("name", ParameterValue.from(value))
          case CultureFieldValue.modifieddate(value) => NamedParameter("modifieddate", ParameterValue.from(value))
        }
        val q = s"""update production.culture
                    set ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(", ")}
                    where cultureid = {cultureid}
                 """
        // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
        import anorm._
        SQL(q)
          .on(namedParams: _*)
          .on(NamedParameter("cultureid", ParameterValue.from(cultureid)))
          .executeUpdate() > 0
    }
  
  }
  val rowParser: RowParser[CultureRow] =
    RowParser[CultureRow] { row =>
      Success(
        CultureRow(
          cultureid = row[CultureId]("cultureid"),
          name = row[Name]("name"),
          modifieddate = row[LocalDateTime]("modifieddate")
        )
      )
    }
}
