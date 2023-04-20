/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pe
package pnt

import adventureworks.person.phonenumbertype.PhonenumbertypeId
import adventureworks.public.Name
import anorm.NamedParameter
import anorm.ParameterValue
import anorm.RowParser
import anorm.SqlStringInterpolation
import anorm.Success
import java.sql.Connection
import java.time.LocalDateTime

object PntRepoImpl extends PntRepo {
  override def selectAll(implicit c: Connection): List[PntRow] = {
    SQL"""select id, phonenumbertypeid, name, modifieddate
          from pe.pnt
       """.as(rowParser.*)
  }
  override def selectByFieldValues(fieldValues: List[PntFieldOrIdValue[_]])(implicit c: Connection): List[PntRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case PntFieldValue.id(value) => NamedParameter("id", ParameterValue.from(value))
          case PntFieldValue.phonenumbertypeid(value) => NamedParameter("phonenumbertypeid", ParameterValue.from(value))
          case PntFieldValue.name(value) => NamedParameter("name", ParameterValue.from(value))
          case PntFieldValue.modifieddate(value) => NamedParameter("modifieddate", ParameterValue.from(value))
        }
        val q = s"""select *
                    from pe.pnt
                    where ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(" AND ")}
                 """
        // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
        import anorm._
        SQL(q)
          .on(namedParams: _*)
          .as(rowParser.*)
    }
  
  }
  val rowParser: RowParser[PntRow] =
    RowParser[PntRow] { row =>
      Success(
        PntRow(
          id = row[Option[Int]]("id"),
          phonenumbertypeid = row[Option[PhonenumbertypeId]]("phonenumbertypeid"),
          name = row[Option[Name]]("name"),
          modifieddate = row[Option[LocalDateTime]]("modifieddate")
        )
      )
    }
}