/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sa
package so

import adventureworks.sales.specialoffer.SpecialofferId
import doobie.Get
import doobie.Read
import doobie.enumerated.Nullability
import doobie.free.connection.ConnectionIO
import doobie.syntax.string.toSqlInterpolator
import doobie.util.fragments
import fs2.Stream
import java.sql.ResultSet
import java.time.LocalDateTime
import java.util.UUID

object SoViewRepoImpl extends SoViewRepo {
  override def selectAll: Stream[ConnectionIO, SoViewRow] = {
    sql"""select "id", specialofferid, description, discountpct, "type", category, startdate, enddate, minqty, maxqty, rowguid, modifieddate from sa.so""".query[SoViewRow].stream
  }
  override def selectByFieldValues(fieldValues: List[SoViewFieldOrIdValue[_]]): Stream[ConnectionIO, SoViewRow] = {
    val where = fragments.whereAnd(
      fieldValues.map {
        case SoViewFieldValue.id(value) => fr""""id" = $value"""
        case SoViewFieldValue.specialofferid(value) => fr"specialofferid = $value"
        case SoViewFieldValue.description(value) => fr"description = $value"
        case SoViewFieldValue.discountpct(value) => fr"discountpct = $value"
        case SoViewFieldValue.`type`(value) => fr""""type" = $value"""
        case SoViewFieldValue.category(value) => fr"category = $value"
        case SoViewFieldValue.startdate(value) => fr"startdate = $value"
        case SoViewFieldValue.enddate(value) => fr"enddate = $value"
        case SoViewFieldValue.minqty(value) => fr"minqty = $value"
        case SoViewFieldValue.maxqty(value) => fr"maxqty = $value"
        case SoViewFieldValue.rowguid(value) => fr"rowguid = $value"
        case SoViewFieldValue.modifieddate(value) => fr"modifieddate = $value"
      } :_*
    )
    sql"select * from sa.so $where".query[SoViewRow].stream
  
  }
  implicit val read: Read[SoViewRow] =
    new Read[SoViewRow](
      gets = List(
        (Get[Int], Nullability.Nullable),
        (Get[SpecialofferId], Nullability.Nullable),
        (Get[String], Nullability.Nullable),
        (Get[BigDecimal], Nullability.Nullable),
        (Get[String], Nullability.Nullable),
        (Get[String], Nullability.Nullable),
        (Get[LocalDateTime], Nullability.Nullable),
        (Get[LocalDateTime], Nullability.Nullable),
        (Get[Int], Nullability.Nullable),
        (Get[Int], Nullability.Nullable),
        (Get[UUID], Nullability.Nullable),
        (Get[LocalDateTime], Nullability.Nullable)
      ),
      unsafeGet = (rs: ResultSet, i: Int) => SoViewRow(
        id = Get[Int].unsafeGetNullable(rs, i + 0),
        specialofferid = Get[SpecialofferId].unsafeGetNullable(rs, i + 1),
        description = Get[String].unsafeGetNullable(rs, i + 2),
        discountpct = Get[BigDecimal].unsafeGetNullable(rs, i + 3),
        `type` = Get[String].unsafeGetNullable(rs, i + 4),
        category = Get[String].unsafeGetNullable(rs, i + 5),
        startdate = Get[LocalDateTime].unsafeGetNullable(rs, i + 6),
        enddate = Get[LocalDateTime].unsafeGetNullable(rs, i + 7),
        minqty = Get[Int].unsafeGetNullable(rs, i + 8),
        maxqty = Get[Int].unsafeGetNullable(rs, i + 9),
        rowguid = Get[UUID].unsafeGetNullable(rs, i + 10),
        modifieddate = Get[LocalDateTime].unsafeGetNullable(rs, i + 11)
      )
    )
  

}