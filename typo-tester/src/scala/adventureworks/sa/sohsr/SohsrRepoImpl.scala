/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sa
package sohsr

import adventureworks.sales.salesorderheader.SalesorderheaderId
import adventureworks.sales.salesreason.SalesreasonId
import anorm.NamedParameter
import anorm.ParameterValue
import anorm.RowParser
import anorm.SqlStringInterpolation
import anorm.Success
import java.sql.Connection
import java.time.LocalDateTime

object SohsrRepoImpl extends SohsrRepo {
  override def selectAll(implicit c: Connection): List[SohsrRow] = {
    SQL"""select salesorderid, salesreasonid, modifieddate
          from sa.sohsr
       """.as(rowParser.*)
  }
  override def selectByFieldValues(fieldValues: List[SohsrFieldOrIdValue[_]])(implicit c: Connection): List[SohsrRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case SohsrFieldValue.salesorderid(value) => NamedParameter("salesorderid", ParameterValue.from(value))
          case SohsrFieldValue.salesreasonid(value) => NamedParameter("salesreasonid", ParameterValue.from(value))
          case SohsrFieldValue.modifieddate(value) => NamedParameter("modifieddate", ParameterValue.from(value))
        }
        val q = s"""select salesorderid, salesreasonid, modifieddate
                    from sa.sohsr
                    where ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(" AND ")}
                 """
        // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
        import anorm._
        SQL(q)
          .on(namedParams: _*)
          .as(rowParser.*)
    }
  
  }
  val rowParser: RowParser[SohsrRow] =
    RowParser[SohsrRow] { row =>
      Success(
        SohsrRow(
          salesorderid = row[Option[SalesorderheaderId]]("salesorderid"),
          salesreasonid = row[Option[SalesreasonId]]("salesreasonid"),
          modifieddate = row[Option[LocalDateTime]]("modifieddate")
        )
      )
    }
}
