/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package salesorderdetail

import adventureworks.Defaulted
import adventureworks.production.product.ProductId
import adventureworks.sales.salesorderheader.SalesorderheaderId
import adventureworks.sales.specialoffer.SpecialofferId
import doobie.Get
import doobie.Read
import doobie.enumerated.Nullability
import doobie.free.connection.ConnectionIO
import doobie.free.connection.pure
import doobie.syntax.string.toSqlInterpolator
import doobie.util.fragment.Fragment
import doobie.util.fragments
import fs2.Stream
import java.sql.ResultSet
import java.time.LocalDateTime
import java.util.UUID

object SalesorderdetailRepoImpl extends SalesorderdetailRepo {
  override def delete(compositeId: SalesorderdetailId): ConnectionIO[Boolean] = {
    sql"delete from sales.salesorderdetail where salesorderid = ${compositeId.salesorderid} AND salesorderdetailid = ${compositeId.salesorderdetailid}".update.run.map(_ > 0)
  }
  override def insert(unsaved: SalesorderdetailRow): ConnectionIO[SalesorderdetailRow] = {
    sql"""insert into sales.salesorderdetail(salesorderid, salesorderdetailid, carriertrackingnumber, orderqty, productid, specialofferid, unitprice, unitpricediscount, rowguid, modifieddate)
          values (${unsaved.salesorderid}::int4, ${unsaved.salesorderdetailid}::int4, ${unsaved.carriertrackingnumber}, ${unsaved.orderqty}::int2, ${unsaved.productid}::int4, ${unsaved.specialofferid}::int4, ${unsaved.unitprice}::numeric, ${unsaved.unitpricediscount}::numeric, ${unsaved.rowguid}::uuid, ${unsaved.modifieddate}::timestamp)
          returning salesorderid, salesorderdetailid, carriertrackingnumber, orderqty, productid, specialofferid, unitprice, unitpricediscount, rowguid, modifieddate
       """.query.unique
  }
  override def insert(unsaved: SalesorderdetailRowUnsaved): ConnectionIO[SalesorderdetailRow] = {
    val fs = List(
      Some((Fragment.const(s"salesorderid"), fr"${unsaved.salesorderid}::int4")),
      Some((Fragment.const(s"carriertrackingnumber"), fr"${unsaved.carriertrackingnumber}")),
      Some((Fragment.const(s"orderqty"), fr"${unsaved.orderqty}::int2")),
      Some((Fragment.const(s"productid"), fr"${unsaved.productid}::int4")),
      Some((Fragment.const(s"specialofferid"), fr"${unsaved.specialofferid}::int4")),
      Some((Fragment.const(s"unitprice"), fr"${unsaved.unitprice}::numeric")),
      unsaved.salesorderdetailid match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s"salesorderdetailid"), fr"${value: Int}::int4"))
      },
      unsaved.unitpricediscount match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s"unitpricediscount"), fr"${value: BigDecimal}::numeric"))
      },
      unsaved.rowguid match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s"rowguid"), fr"${value: UUID}::uuid"))
      },
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s"modifieddate"), fr"${value: LocalDateTime}::timestamp"))
      }
    ).flatten
    
    val q = if (fs.isEmpty) {
      sql"""insert into sales.salesorderdetail default values
            returning salesorderid, salesorderdetailid, carriertrackingnumber, orderqty, productid, specialofferid, unitprice, unitpricediscount, rowguid, modifieddate
         """
    } else {
      import cats.syntax.foldable.toFoldableOps
      sql"""insert into sales.salesorderdetail(${fs.map { case (n, _) => n }.intercalate(fr", ")})
            values (${fs.map { case (_, f) => f }.intercalate(fr", ")})
            returning salesorderid, salesorderdetailid, carriertrackingnumber, orderqty, productid, specialofferid, unitprice, unitpricediscount, rowguid, modifieddate
         """
    }
    q.query.unique
  
  }
  override def selectAll: Stream[ConnectionIO, SalesorderdetailRow] = {
    sql"select salesorderid, salesorderdetailid, carriertrackingnumber, orderqty, productid, specialofferid, unitprice, unitpricediscount, rowguid, modifieddate from sales.salesorderdetail".query[SalesorderdetailRow].stream
  }
  override def selectByFieldValues(fieldValues: List[SalesorderdetailFieldOrIdValue[_]]): Stream[ConnectionIO, SalesorderdetailRow] = {
    val where = fragments.whereAnd(
      fieldValues.map {
        case SalesorderdetailFieldValue.salesorderid(value) => fr"salesorderid = $value"
        case SalesorderdetailFieldValue.salesorderdetailid(value) => fr"salesorderdetailid = $value"
        case SalesorderdetailFieldValue.carriertrackingnumber(value) => fr"carriertrackingnumber = $value"
        case SalesorderdetailFieldValue.orderqty(value) => fr"orderqty = $value"
        case SalesorderdetailFieldValue.productid(value) => fr"productid = $value"
        case SalesorderdetailFieldValue.specialofferid(value) => fr"specialofferid = $value"
        case SalesorderdetailFieldValue.unitprice(value) => fr"unitprice = $value"
        case SalesorderdetailFieldValue.unitpricediscount(value) => fr"unitpricediscount = $value"
        case SalesorderdetailFieldValue.rowguid(value) => fr"rowguid = $value"
        case SalesorderdetailFieldValue.modifieddate(value) => fr"modifieddate = $value"
      } :_*
    )
    sql"select * from sales.salesorderdetail $where".query[SalesorderdetailRow].stream
  
  }
  override def selectById(compositeId: SalesorderdetailId): ConnectionIO[Option[SalesorderdetailRow]] = {
    sql"select salesorderid, salesorderdetailid, carriertrackingnumber, orderqty, productid, specialofferid, unitprice, unitpricediscount, rowguid, modifieddate from sales.salesorderdetail where salesorderid = ${compositeId.salesorderid} AND salesorderdetailid = ${compositeId.salesorderdetailid}".query[SalesorderdetailRow].option
  }
  override def update(row: SalesorderdetailRow): ConnectionIO[Boolean] = {
    val compositeId = row.compositeId
    sql"""update sales.salesorderdetail
          set carriertrackingnumber = ${row.carriertrackingnumber},
              orderqty = ${row.orderqty}::int2,
              productid = ${row.productid}::int4,
              specialofferid = ${row.specialofferid}::int4,
              unitprice = ${row.unitprice}::numeric,
              unitpricediscount = ${row.unitpricediscount}::numeric,
              rowguid = ${row.rowguid}::uuid,
              modifieddate = ${row.modifieddate}::timestamp
          where salesorderid = ${compositeId.salesorderid} AND salesorderdetailid = ${compositeId.salesorderdetailid}
       """
      .update
      .run
      .map(_ > 0)
  }
  override def updateFieldValues(compositeId: SalesorderdetailId, fieldValues: List[SalesorderdetailFieldValue[_]]): ConnectionIO[Boolean] = {
    fieldValues match {
      case Nil => pure(false)
      case nonEmpty =>
        val updates = fragments.set(
          nonEmpty.map {
            case SalesorderdetailFieldValue.carriertrackingnumber(value) => fr"carriertrackingnumber = $value"
            case SalesorderdetailFieldValue.orderqty(value) => fr"orderqty = $value"
            case SalesorderdetailFieldValue.productid(value) => fr"productid = $value"
            case SalesorderdetailFieldValue.specialofferid(value) => fr"specialofferid = $value"
            case SalesorderdetailFieldValue.unitprice(value) => fr"unitprice = $value"
            case SalesorderdetailFieldValue.unitpricediscount(value) => fr"unitpricediscount = $value"
            case SalesorderdetailFieldValue.rowguid(value) => fr"rowguid = $value"
            case SalesorderdetailFieldValue.modifieddate(value) => fr"modifieddate = $value"
          } :_*
        )
        sql"""update sales.salesorderdetail
              $updates
              where salesorderid = ${compositeId.salesorderid} AND salesorderdetailid = ${compositeId.salesorderdetailid}
           """.update.run.map(_ > 0)
    }
  }
  override def upsert(unsaved: SalesorderdetailRow): ConnectionIO[SalesorderdetailRow] = {
    sql"""insert into sales.salesorderdetail(salesorderid, salesorderdetailid, carriertrackingnumber, orderqty, productid, specialofferid, unitprice, unitpricediscount, rowguid, modifieddate)
          values (
            ${unsaved.salesorderid}::int4,
            ${unsaved.salesorderdetailid}::int4,
            ${unsaved.carriertrackingnumber},
            ${unsaved.orderqty}::int2,
            ${unsaved.productid}::int4,
            ${unsaved.specialofferid}::int4,
            ${unsaved.unitprice}::numeric,
            ${unsaved.unitpricediscount}::numeric,
            ${unsaved.rowguid}::uuid,
            ${unsaved.modifieddate}::timestamp
          )
          on conflict (salesorderid, salesorderdetailid)
          do update set
            carriertrackingnumber = EXCLUDED.carriertrackingnumber,
            orderqty = EXCLUDED.orderqty,
            productid = EXCLUDED.productid,
            specialofferid = EXCLUDED.specialofferid,
            unitprice = EXCLUDED.unitprice,
            unitpricediscount = EXCLUDED.unitpricediscount,
            rowguid = EXCLUDED.rowguid,
            modifieddate = EXCLUDED.modifieddate
          returning salesorderid, salesorderdetailid, carriertrackingnumber, orderqty, productid, specialofferid, unitprice, unitpricediscount, rowguid, modifieddate
       """.query.unique
  }
  implicit val read: Read[SalesorderdetailRow] =
    new Read[SalesorderdetailRow](
      gets = List(
        (Get[SalesorderheaderId], Nullability.NoNulls),
        (Get[Int], Nullability.NoNulls),
        (Get[String], Nullability.Nullable),
        (Get[Int], Nullability.NoNulls),
        (Get[ProductId], Nullability.NoNulls),
        (Get[SpecialofferId], Nullability.NoNulls),
        (Get[BigDecimal], Nullability.NoNulls),
        (Get[BigDecimal], Nullability.NoNulls),
        (Get[UUID], Nullability.NoNulls),
        (Get[LocalDateTime], Nullability.NoNulls)
      ),
      unsafeGet = (rs: ResultSet, i: Int) => SalesorderdetailRow(
        salesorderid = Get[SalesorderheaderId].unsafeGetNonNullable(rs, i + 0),
        salesorderdetailid = Get[Int].unsafeGetNonNullable(rs, i + 1),
        carriertrackingnumber = Get[String].unsafeGetNullable(rs, i + 2),
        orderqty = Get[Int].unsafeGetNonNullable(rs, i + 3),
        productid = Get[ProductId].unsafeGetNonNullable(rs, i + 4),
        specialofferid = Get[SpecialofferId].unsafeGetNonNullable(rs, i + 5),
        unitprice = Get[BigDecimal].unsafeGetNonNullable(rs, i + 6),
        unitpricediscount = Get[BigDecimal].unsafeGetNonNullable(rs, i + 7),
        rowguid = Get[UUID].unsafeGetNonNullable(rs, i + 8),
        modifieddate = Get[LocalDateTime].unsafeGetNonNullable(rs, i + 9)
      )
    )
  

}