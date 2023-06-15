/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pr
package wr

import adventureworks.production.location.LocationId
import adventureworks.production.workorder.WorkorderId
import doobie.Get
import doobie.Read
import doobie.enumerated.Nullability
import doobie.free.connection.ConnectionIO
import doobie.syntax.string.toSqlInterpolator
import doobie.util.fragments
import fs2.Stream
import java.sql.ResultSet
import java.time.LocalDateTime

object WrViewRepoImpl extends WrViewRepo {
  override def selectAll: Stream[ConnectionIO, WrViewRow] = {
    sql"""select "id", workorderid, productid, operationsequence, locationid, scheduledstartdate, scheduledenddate, actualstartdate, actualenddate, actualresourcehrs, plannedcost, actualcost, modifieddate from pr.wr""".query[WrViewRow].stream
  }
  override def selectByFieldValues(fieldValues: List[WrViewFieldOrIdValue[_]]): Stream[ConnectionIO, WrViewRow] = {
    val where = fragments.whereAnd(
      fieldValues.map {
        case WrViewFieldValue.id(value) => fr""""id" = $value"""
        case WrViewFieldValue.workorderid(value) => fr"workorderid = $value"
        case WrViewFieldValue.productid(value) => fr"productid = $value"
        case WrViewFieldValue.operationsequence(value) => fr"operationsequence = $value"
        case WrViewFieldValue.locationid(value) => fr"locationid = $value"
        case WrViewFieldValue.scheduledstartdate(value) => fr"scheduledstartdate = $value"
        case WrViewFieldValue.scheduledenddate(value) => fr"scheduledenddate = $value"
        case WrViewFieldValue.actualstartdate(value) => fr"actualstartdate = $value"
        case WrViewFieldValue.actualenddate(value) => fr"actualenddate = $value"
        case WrViewFieldValue.actualresourcehrs(value) => fr"actualresourcehrs = $value"
        case WrViewFieldValue.plannedcost(value) => fr"plannedcost = $value"
        case WrViewFieldValue.actualcost(value) => fr"actualcost = $value"
        case WrViewFieldValue.modifieddate(value) => fr"modifieddate = $value"
      } :_*
    )
    sql"select * from pr.wr $where".query[WrViewRow].stream
  
  }
  implicit val read: Read[WrViewRow] =
    new Read[WrViewRow](
      gets = List(
        (Get[Int], Nullability.Nullable),
        (Get[WorkorderId], Nullability.Nullable),
        (Get[Int], Nullability.Nullable),
        (Get[Int], Nullability.Nullable),
        (Get[LocationId], Nullability.Nullable),
        (Get[LocalDateTime], Nullability.Nullable),
        (Get[LocalDateTime], Nullability.Nullable),
        (Get[LocalDateTime], Nullability.Nullable),
        (Get[LocalDateTime], Nullability.Nullable),
        (Get[BigDecimal], Nullability.Nullable),
        (Get[BigDecimal], Nullability.Nullable),
        (Get[BigDecimal], Nullability.Nullable),
        (Get[LocalDateTime], Nullability.Nullable)
      ),
      unsafeGet = (rs: ResultSet, i: Int) => WrViewRow(
        id = Get[Int].unsafeGetNullable(rs, i + 0),
        workorderid = Get[WorkorderId].unsafeGetNullable(rs, i + 1),
        productid = Get[Int].unsafeGetNullable(rs, i + 2),
        operationsequence = Get[Int].unsafeGetNullable(rs, i + 3),
        locationid = Get[LocationId].unsafeGetNullable(rs, i + 4),
        scheduledstartdate = Get[LocalDateTime].unsafeGetNullable(rs, i + 5),
        scheduledenddate = Get[LocalDateTime].unsafeGetNullable(rs, i + 6),
        actualstartdate = Get[LocalDateTime].unsafeGetNullable(rs, i + 7),
        actualenddate = Get[LocalDateTime].unsafeGetNullable(rs, i + 8),
        actualresourcehrs = Get[BigDecimal].unsafeGetNullable(rs, i + 9),
        plannedcost = Get[BigDecimal].unsafeGetNullable(rs, i + 10),
        actualcost = Get[BigDecimal].unsafeGetNullable(rs, i + 11),
        modifieddate = Get[LocalDateTime].unsafeGetNullable(rs, i + 12)
      )
    )
  

}