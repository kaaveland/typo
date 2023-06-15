/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package vpersondemographics

import adventureworks.TypoMoney
import adventureworks.person.businessentity.BusinessentityId
import doobie.Get
import doobie.Read
import doobie.enumerated.Nullability
import doobie.free.connection.ConnectionIO
import doobie.syntax.string.toSqlInterpolator
import doobie.util.fragments
import fs2.Stream
import java.sql.ResultSet
import java.time.LocalDate

object VpersondemographicsViewRepoImpl extends VpersondemographicsViewRepo {
  override def selectAll: Stream[ConnectionIO, VpersondemographicsViewRow] = {
    sql"select businessentityid, totalpurchaseytd, datefirstpurchase, birthdate, maritalstatus, yearlyincome, gender, totalchildren, numberchildrenathome, education, occupation, homeownerflag, numbercarsowned from sales.vpersondemographics".query[VpersondemographicsViewRow].stream
  }
  override def selectByFieldValues(fieldValues: List[VpersondemographicsViewFieldOrIdValue[_]]): Stream[ConnectionIO, VpersondemographicsViewRow] = {
    val where = fragments.whereAnd(
      fieldValues.map {
        case VpersondemographicsViewFieldValue.businessentityid(value) => fr"businessentityid = $value"
        case VpersondemographicsViewFieldValue.totalpurchaseytd(value) => fr"totalpurchaseytd = $value"
        case VpersondemographicsViewFieldValue.datefirstpurchase(value) => fr"datefirstpurchase = $value"
        case VpersondemographicsViewFieldValue.birthdate(value) => fr"birthdate = $value"
        case VpersondemographicsViewFieldValue.maritalstatus(value) => fr"maritalstatus = $value"
        case VpersondemographicsViewFieldValue.yearlyincome(value) => fr"yearlyincome = $value"
        case VpersondemographicsViewFieldValue.gender(value) => fr"gender = $value"
        case VpersondemographicsViewFieldValue.totalchildren(value) => fr"totalchildren = $value"
        case VpersondemographicsViewFieldValue.numberchildrenathome(value) => fr"numberchildrenathome = $value"
        case VpersondemographicsViewFieldValue.education(value) => fr"education = $value"
        case VpersondemographicsViewFieldValue.occupation(value) => fr"occupation = $value"
        case VpersondemographicsViewFieldValue.homeownerflag(value) => fr"homeownerflag = $value"
        case VpersondemographicsViewFieldValue.numbercarsowned(value) => fr"numbercarsowned = $value"
      } :_*
    )
    sql"select * from sales.vpersondemographics $where".query[VpersondemographicsViewRow].stream
  
  }
  implicit val read: Read[VpersondemographicsViewRow] =
    new Read[VpersondemographicsViewRow](
      gets = List(
        (Get[BusinessentityId], Nullability.Nullable),
        (Get[TypoMoney], Nullability.Nullable),
        (Get[LocalDate], Nullability.Nullable),
        (Get[LocalDate], Nullability.Nullable),
        (Get[String], Nullability.Nullable),
        (Get[String], Nullability.Nullable),
        (Get[String], Nullability.Nullable),
        (Get[Int], Nullability.Nullable),
        (Get[Int], Nullability.Nullable),
        (Get[String], Nullability.Nullable),
        (Get[String], Nullability.Nullable),
        (Get[Boolean], Nullability.Nullable),
        (Get[Int], Nullability.Nullable)
      ),
      unsafeGet = (rs: ResultSet, i: Int) => VpersondemographicsViewRow(
        businessentityid = Get[BusinessentityId].unsafeGetNullable(rs, i + 0),
        totalpurchaseytd = Get[TypoMoney].unsafeGetNullable(rs, i + 1),
        datefirstpurchase = Get[LocalDate].unsafeGetNullable(rs, i + 2),
        birthdate = Get[LocalDate].unsafeGetNullable(rs, i + 3),
        maritalstatus = Get[String].unsafeGetNullable(rs, i + 4),
        yearlyincome = Get[String].unsafeGetNullable(rs, i + 5),
        gender = Get[String].unsafeGetNullable(rs, i + 6),
        totalchildren = Get[Int].unsafeGetNullable(rs, i + 7),
        numberchildrenathome = Get[Int].unsafeGetNullable(rs, i + 8),
        education = Get[String].unsafeGetNullable(rs, i + 9),
        occupation = Get[String].unsafeGetNullable(rs, i + 10),
        homeownerflag = Get[Boolean].unsafeGetNullable(rs, i + 11),
        numbercarsowned = Get[Int].unsafeGetNullable(rs, i + 12)
      )
    )
  

}