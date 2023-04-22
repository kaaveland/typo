/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package vpersondemographics

import adventureworks.person.businessentity.BusinessentityId
import anorm.NamedParameter
import anorm.ParameterValue
import anorm.RowParser
import anorm.SqlStringInterpolation
import anorm.Success
import java.sql.Connection
import java.time.LocalDate
import org.postgresql.util.PGmoney

object VpersondemographicsRepoImpl extends VpersondemographicsRepo {
  override def selectAll(implicit c: Connection): List[VpersondemographicsRow] = {
    SQL"""select businessentityid, totalpurchaseytd, datefirstpurchase, birthdate, maritalstatus, yearlyincome, gender, totalchildren, numberchildrenathome, education, occupation, homeownerflag, numbercarsowned
          from sales.vpersondemographics
       """.as(rowParser.*)
  }
  override def selectByFieldValues(fieldValues: List[VpersondemographicsFieldOrIdValue[_]])(implicit c: Connection): List[VpersondemographicsRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case VpersondemographicsFieldValue.businessentityid(value) => NamedParameter("businessentityid", ParameterValue.from(value))
          case VpersondemographicsFieldValue.totalpurchaseytd(value) => NamedParameter("totalpurchaseytd", ParameterValue.from(value))
          case VpersondemographicsFieldValue.datefirstpurchase(value) => NamedParameter("datefirstpurchase", ParameterValue.from(value))
          case VpersondemographicsFieldValue.birthdate(value) => NamedParameter("birthdate", ParameterValue.from(value))
          case VpersondemographicsFieldValue.maritalstatus(value) => NamedParameter("maritalstatus", ParameterValue.from(value))
          case VpersondemographicsFieldValue.yearlyincome(value) => NamedParameter("yearlyincome", ParameterValue.from(value))
          case VpersondemographicsFieldValue.gender(value) => NamedParameter("gender", ParameterValue.from(value))
          case VpersondemographicsFieldValue.totalchildren(value) => NamedParameter("totalchildren", ParameterValue.from(value))
          case VpersondemographicsFieldValue.numberchildrenathome(value) => NamedParameter("numberchildrenathome", ParameterValue.from(value))
          case VpersondemographicsFieldValue.education(value) => NamedParameter("education", ParameterValue.from(value))
          case VpersondemographicsFieldValue.occupation(value) => NamedParameter("occupation", ParameterValue.from(value))
          case VpersondemographicsFieldValue.homeownerflag(value) => NamedParameter("homeownerflag", ParameterValue.from(value))
          case VpersondemographicsFieldValue.numbercarsowned(value) => NamedParameter("numbercarsowned", ParameterValue.from(value))
        }
        val q = s"""select businessentityid, totalpurchaseytd, datefirstpurchase, birthdate, maritalstatus, yearlyincome, gender, totalchildren, numberchildrenathome, education, occupation, homeownerflag, numbercarsowned
                    from sales.vpersondemographics
                    where ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(" AND ")}
                 """
        // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
        import anorm._
        SQL(q)
          .on(namedParams: _*)
          .as(rowParser.*)
    }
  
  }
  val rowParser: RowParser[VpersondemographicsRow] =
    RowParser[VpersondemographicsRow] { row =>
      Success(
        VpersondemographicsRow(
          businessentityid = row[Option[BusinessentityId]]("businessentityid"),
          totalpurchaseytd = row[Option[PGmoney]]("totalpurchaseytd"),
          datefirstpurchase = row[Option[LocalDate]]("datefirstpurchase"),
          birthdate = row[Option[LocalDate]]("birthdate"),
          maritalstatus = row[Option[String]]("maritalstatus"),
          yearlyincome = row[Option[String]]("yearlyincome"),
          gender = row[Option[String]]("gender"),
          totalchildren = row[Option[Int]]("totalchildren"),
          numberchildrenathome = row[Option[Int]]("numberchildrenathome"),
          education = row[Option[String]]("education"),
          occupation = row[Option[String]]("occupation"),
          homeownerflag = row[Option[Boolean]]("homeownerflag"),
          numbercarsowned = row[Option[Int]]("numbercarsowned")
        )
      )
    }
}
