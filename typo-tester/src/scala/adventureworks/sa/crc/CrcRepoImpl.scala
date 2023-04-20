/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sa
package crc

import adventureworks.person.countryregion.CountryregionId
import adventureworks.sales.currency.CurrencyId
import anorm.NamedParameter
import anorm.ParameterValue
import anorm.RowParser
import anorm.SqlStringInterpolation
import anorm.Success
import java.sql.Connection
import java.time.LocalDateTime

object CrcRepoImpl extends CrcRepo {
  override def selectAll(implicit c: Connection): List[CrcRow] = {
    SQL"""select countryregioncode, currencycode, modifieddate
          from sa.crc
       """.as(rowParser.*)
  }
  override def selectByFieldValues(fieldValues: List[CrcFieldOrIdValue[_]])(implicit c: Connection): List[CrcRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case CrcFieldValue.countryregioncode(value) => NamedParameter("countryregioncode", ParameterValue.from(value))
          case CrcFieldValue.currencycode(value) => NamedParameter("currencycode", ParameterValue.from(value))
          case CrcFieldValue.modifieddate(value) => NamedParameter("modifieddate", ParameterValue.from(value))
        }
        val q = s"""select *
                    from sa.crc
                    where ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(" AND ")}
                 """
        // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
        import anorm._
        SQL(q)
          .on(namedParams: _*)
          .as(rowParser.*)
    }
  
  }
  val rowParser: RowParser[CrcRow] =
    RowParser[CrcRow] { row =>
      Success(
        CrcRow(
          countryregioncode = row[Option[CountryregionId]]("countryregioncode"),
          currencycode = row[Option[CurrencyId]]("currencycode"),
          modifieddate = row[Option[LocalDateTime]]("modifieddate")
        )
      )
    }
}