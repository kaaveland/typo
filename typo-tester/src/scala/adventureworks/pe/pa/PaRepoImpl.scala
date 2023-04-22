/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pe
package pa

import adventureworks.person.businessentity.BusinessentityId
import anorm.NamedParameter
import anorm.ParameterValue
import anorm.RowParser
import anorm.SqlStringInterpolation
import anorm.Success
import java.sql.Connection
import java.time.LocalDateTime
import java.util.UUID

object PaRepoImpl extends PaRepo {
  override def selectAll(implicit c: Connection): List[PaRow] = {
    SQL"""select "id", businessentityid, passwordhash, passwordsalt, rowguid, modifieddate
          from pe.pa
       """.as(rowParser.*)
  }
  override def selectByFieldValues(fieldValues: List[PaFieldOrIdValue[_]])(implicit c: Connection): List[PaRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case PaFieldValue.id(value) => NamedParameter("id", ParameterValue.from(value))
          case PaFieldValue.businessentityid(value) => NamedParameter("businessentityid", ParameterValue.from(value))
          case PaFieldValue.passwordhash(value) => NamedParameter("passwordhash", ParameterValue.from(value))
          case PaFieldValue.passwordsalt(value) => NamedParameter("passwordsalt", ParameterValue.from(value))
          case PaFieldValue.rowguid(value) => NamedParameter("rowguid", ParameterValue.from(value))
          case PaFieldValue.modifieddate(value) => NamedParameter("modifieddate", ParameterValue.from(value))
        }
        val q = s"""select "id", businessentityid, passwordhash, passwordsalt, rowguid, modifieddate
                    from pe.pa
                    where ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(" AND ")}
                 """
        // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
        import anorm._
        SQL(q)
          .on(namedParams: _*)
          .as(rowParser.*)
    }
  
  }
  val rowParser: RowParser[PaRow] =
    RowParser[PaRow] { row =>
      Success(
        PaRow(
          id = row[Option[Int]]("id"),
          businessentityid = row[Option[BusinessentityId]]("businessentityid"),
          passwordhash = row[Option[String]]("passwordhash"),
          passwordsalt = row[Option[String]]("passwordsalt"),
          rowguid = row[Option[UUID]]("rowguid"),
          modifieddate = row[Option[LocalDateTime]]("modifieddate")
        )
      )
    }
}
