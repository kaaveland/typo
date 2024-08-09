/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package salesorderheader

import adventureworks.customtypes.Defaulted
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoShort
import adventureworks.customtypes.TypoUUID
import adventureworks.person.address.AddressId
import adventureworks.person.businessentity.BusinessentityId
import adventureworks.public.AccountNumber
import adventureworks.public.Flag
import adventureworks.public.OrderNumber
import adventureworks.purchasing.shipmethod.ShipmethodId
import adventureworks.sales.currencyrate.CurrencyrateId
import adventureworks.sales.customer.CustomerId
import adventureworks.sales.salesterritory.SalesterritoryId
import adventureworks.userdefined.CustomCreditcardId
import cats.instances.list.catsStdInstancesForList
import doobie.free.connection.ConnectionIO
import doobie.postgres.syntax.FragmentOps
import doobie.syntax.SqlInterpolator.SingleFragment.fromWrite
import doobie.syntax.string.toSqlInterpolator
import doobie.util.Write
import doobie.util.fragment.Fragment
import doobie.util.meta.Meta
import doobie.util.update.Update
import fs2.Stream
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql
import typo.dsl.UpdateBuilder

class SalesorderheaderRepoImpl extends SalesorderheaderRepo {
  override def delete: DeleteBuilder[SalesorderheaderFields, SalesorderheaderRow] = {
    DeleteBuilder(""""sales"."salesorderheader"""", SalesorderheaderFields.structure)
  }
  override def deleteById(salesorderid: SalesorderheaderId): ConnectionIO[Boolean] = {
    sql"""delete from "sales"."salesorderheader" where "salesorderid" = ${fromWrite(salesorderid)(Write.fromPut(SalesorderheaderId.put))}""".update.run.map(_ > 0)
  }
  override def deleteByIds(salesorderids: Array[SalesorderheaderId]): ConnectionIO[Int] = {
    sql"""delete from "sales"."salesorderheader" where "salesorderid" = ANY(${salesorderids})""".update.run
  }
  override def insert(unsaved: SalesorderheaderRow): ConnectionIO[SalesorderheaderRow] = {
    sql"""insert into "sales"."salesorderheader"("salesorderid", "revisionnumber", "orderdate", "duedate", "shipdate", "status", "onlineorderflag", "purchaseordernumber", "accountnumber", "customerid", "salespersonid", "territoryid", "billtoaddressid", "shiptoaddressid", "shipmethodid", "creditcardid", "creditcardapprovalcode", "currencyrateid", "subtotal", "taxamt", "freight", "totaldue", "comment", "rowguid", "modifieddate")
          values (${fromWrite(unsaved.salesorderid)(Write.fromPut(SalesorderheaderId.put))}::int4, ${fromWrite(unsaved.revisionnumber)(Write.fromPut(TypoShort.put))}::int2, ${fromWrite(unsaved.orderdate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp, ${fromWrite(unsaved.duedate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp, ${fromWrite(unsaved.shipdate)(Write.fromPutOption(TypoLocalDateTime.put))}::timestamp, ${fromWrite(unsaved.status)(Write.fromPut(TypoShort.put))}::int2, ${fromWrite(unsaved.onlineorderflag)(Write.fromPut(Flag.put))}::bool, ${fromWrite(unsaved.purchaseordernumber)(Write.fromPutOption(OrderNumber.put))}::varchar, ${fromWrite(unsaved.accountnumber)(Write.fromPutOption(AccountNumber.put))}::varchar, ${fromWrite(unsaved.customerid)(Write.fromPut(CustomerId.put))}::int4, ${fromWrite(unsaved.salespersonid)(Write.fromPutOption(BusinessentityId.put))}::int4, ${fromWrite(unsaved.territoryid)(Write.fromPutOption(SalesterritoryId.put))}::int4, ${fromWrite(unsaved.billtoaddressid)(Write.fromPut(AddressId.put))}::int4, ${fromWrite(unsaved.shiptoaddressid)(Write.fromPut(AddressId.put))}::int4, ${fromWrite(unsaved.shipmethodid)(Write.fromPut(ShipmethodId.put))}::int4, ${fromWrite(unsaved.creditcardid)(Write.fromPutOption(/* user-picked */ CustomCreditcardId.put))}::int4, ${fromWrite(unsaved.creditcardapprovalcode)(Write.fromPutOption(Meta.StringMeta.put))}, ${fromWrite(unsaved.currencyrateid)(Write.fromPutOption(CurrencyrateId.put))}::int4, ${fromWrite(unsaved.subtotal)(Write.fromPut(Meta.ScalaBigDecimalMeta.put))}::numeric, ${fromWrite(unsaved.taxamt)(Write.fromPut(Meta.ScalaBigDecimalMeta.put))}::numeric, ${fromWrite(unsaved.freight)(Write.fromPut(Meta.ScalaBigDecimalMeta.put))}::numeric, ${fromWrite(unsaved.totaldue)(Write.fromPutOption(Meta.ScalaBigDecimalMeta.put))}::numeric, ${fromWrite(unsaved.comment)(Write.fromPutOption(Meta.StringMeta.put))}, ${fromWrite(unsaved.rowguid)(Write.fromPut(TypoUUID.put))}::uuid, ${fromWrite(unsaved.modifieddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp)
          returning "salesorderid", "revisionnumber", "orderdate"::text, "duedate"::text, "shipdate"::text, "status", "onlineorderflag", "purchaseordernumber", "accountnumber", "customerid", "salespersonid", "territoryid", "billtoaddressid", "shiptoaddressid", "shipmethodid", "creditcardid", "creditcardapprovalcode", "currencyrateid", "subtotal", "taxamt", "freight", "totaldue", "comment", "rowguid", "modifieddate"::text
       """.query(using SalesorderheaderRow.read).unique
  }
  override def insert(unsaved: SalesorderheaderRowUnsaved): ConnectionIO[SalesorderheaderRow] = {
    val fs = List(
      Some((Fragment.const0(s""""duedate""""), fr"${fromWrite(unsaved.duedate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp")),
      Some((Fragment.const0(s""""shipdate""""), fr"${fromWrite(unsaved.shipdate)(Write.fromPutOption(TypoLocalDateTime.put))}::timestamp")),
      Some((Fragment.const0(s""""purchaseordernumber""""), fr"${fromWrite(unsaved.purchaseordernumber)(Write.fromPutOption(OrderNumber.put))}::varchar")),
      Some((Fragment.const0(s""""accountnumber""""), fr"${fromWrite(unsaved.accountnumber)(Write.fromPutOption(AccountNumber.put))}::varchar")),
      Some((Fragment.const0(s""""customerid""""), fr"${fromWrite(unsaved.customerid)(Write.fromPut(CustomerId.put))}::int4")),
      Some((Fragment.const0(s""""salespersonid""""), fr"${fromWrite(unsaved.salespersonid)(Write.fromPutOption(BusinessentityId.put))}::int4")),
      Some((Fragment.const0(s""""territoryid""""), fr"${fromWrite(unsaved.territoryid)(Write.fromPutOption(SalesterritoryId.put))}::int4")),
      Some((Fragment.const0(s""""billtoaddressid""""), fr"${fromWrite(unsaved.billtoaddressid)(Write.fromPut(AddressId.put))}::int4")),
      Some((Fragment.const0(s""""shiptoaddressid""""), fr"${fromWrite(unsaved.shiptoaddressid)(Write.fromPut(AddressId.put))}::int4")),
      Some((Fragment.const0(s""""shipmethodid""""), fr"${fromWrite(unsaved.shipmethodid)(Write.fromPut(ShipmethodId.put))}::int4")),
      Some((Fragment.const0(s""""creditcardid""""), fr"${fromWrite(unsaved.creditcardid)(Write.fromPutOption(/* user-picked */ CustomCreditcardId.put))}::int4")),
      Some((Fragment.const0(s""""creditcardapprovalcode""""), fr"${fromWrite(unsaved.creditcardapprovalcode)(Write.fromPutOption(Meta.StringMeta.put))}")),
      Some((Fragment.const0(s""""currencyrateid""""), fr"${fromWrite(unsaved.currencyrateid)(Write.fromPutOption(CurrencyrateId.put))}::int4")),
      Some((Fragment.const0(s""""totaldue""""), fr"${fromWrite(unsaved.totaldue)(Write.fromPutOption(Meta.ScalaBigDecimalMeta.put))}::numeric")),
      Some((Fragment.const0(s""""comment""""), fr"${fromWrite(unsaved.comment)(Write.fromPutOption(Meta.StringMeta.put))}")),
      unsaved.salesorderid match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const0(s""""salesorderid""""), fr"${fromWrite(value: SalesorderheaderId)(Write.fromPut(SalesorderheaderId.put))}::int4"))
      },
      unsaved.revisionnumber match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const0(s""""revisionnumber""""), fr"${fromWrite(value: TypoShort)(Write.fromPut(TypoShort.put))}::int2"))
      },
      unsaved.orderdate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const0(s""""orderdate""""), fr"${fromWrite(value: TypoLocalDateTime)(Write.fromPut(TypoLocalDateTime.put))}::timestamp"))
      },
      unsaved.status match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const0(s""""status""""), fr"${fromWrite(value: TypoShort)(Write.fromPut(TypoShort.put))}::int2"))
      },
      unsaved.onlineorderflag match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const0(s""""onlineorderflag""""), fr"${fromWrite(value: Flag)(Write.fromPut(Flag.put))}::bool"))
      },
      unsaved.subtotal match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const0(s""""subtotal""""), fr"${fromWrite(value: BigDecimal)(Write.fromPut(Meta.ScalaBigDecimalMeta.put))}::numeric"))
      },
      unsaved.taxamt match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const0(s""""taxamt""""), fr"${fromWrite(value: BigDecimal)(Write.fromPut(Meta.ScalaBigDecimalMeta.put))}::numeric"))
      },
      unsaved.freight match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const0(s""""freight""""), fr"${fromWrite(value: BigDecimal)(Write.fromPut(Meta.ScalaBigDecimalMeta.put))}::numeric"))
      },
      unsaved.rowguid match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const0(s""""rowguid""""), fr"${fromWrite(value: TypoUUID)(Write.fromPut(TypoUUID.put))}::uuid"))
      },
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const0(s""""modifieddate""""), fr"${fromWrite(value: TypoLocalDateTime)(Write.fromPut(TypoLocalDateTime.put))}::timestamp"))
      }
    ).flatten
    
    val q = if (fs.isEmpty) {
      sql"""insert into "sales"."salesorderheader" default values
            returning "salesorderid", "revisionnumber", "orderdate"::text, "duedate"::text, "shipdate"::text, "status", "onlineorderflag", "purchaseordernumber", "accountnumber", "customerid", "salespersonid", "territoryid", "billtoaddressid", "shiptoaddressid", "shipmethodid", "creditcardid", "creditcardapprovalcode", "currencyrateid", "subtotal", "taxamt", "freight", "totaldue", "comment", "rowguid", "modifieddate"::text
         """
    } else {
      val CommaSeparate = Fragment.FragmentMonoid.intercalate(fr", ")
      sql"""insert into "sales"."salesorderheader"(${CommaSeparate.combineAllOption(fs.map { case (n, _) => n }).get})
            values (${CommaSeparate.combineAllOption(fs.map { case (_, f) => f }).get})
            returning "salesorderid", "revisionnumber", "orderdate"::text, "duedate"::text, "shipdate"::text, "status", "onlineorderflag", "purchaseordernumber", "accountnumber", "customerid", "salespersonid", "territoryid", "billtoaddressid", "shiptoaddressid", "shipmethodid", "creditcardid", "creditcardapprovalcode", "currencyrateid", "subtotal", "taxamt", "freight", "totaldue", "comment", "rowguid", "modifieddate"::text
         """
    }
    q.query(using SalesorderheaderRow.read).unique
    
  }
  override def insertStreaming(unsaved: Stream[ConnectionIO, SalesorderheaderRow], batchSize: Int = 10000): ConnectionIO[Long] = {
    new FragmentOps(sql"""COPY "sales"."salesorderheader"("salesorderid", "revisionnumber", "orderdate", "duedate", "shipdate", "status", "onlineorderflag", "purchaseordernumber", "accountnumber", "customerid", "salespersonid", "territoryid", "billtoaddressid", "shiptoaddressid", "shipmethodid", "creditcardid", "creditcardapprovalcode", "currencyrateid", "subtotal", "taxamt", "freight", "totaldue", "comment", "rowguid", "modifieddate") FROM STDIN""").copyIn(unsaved, batchSize)(using SalesorderheaderRow.text)
  }
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  override def insertUnsavedStreaming(unsaved: Stream[ConnectionIO, SalesorderheaderRowUnsaved], batchSize: Int = 10000): ConnectionIO[Long] = {
    new FragmentOps(sql"""COPY "sales"."salesorderheader"("duedate", "shipdate", "purchaseordernumber", "accountnumber", "customerid", "salespersonid", "territoryid", "billtoaddressid", "shiptoaddressid", "shipmethodid", "creditcardid", "creditcardapprovalcode", "currencyrateid", "totaldue", "comment", "salesorderid", "revisionnumber", "orderdate", "status", "onlineorderflag", "subtotal", "taxamt", "freight", "rowguid", "modifieddate") FROM STDIN (DEFAULT '__DEFAULT_VALUE__')""").copyIn(unsaved, batchSize)(using SalesorderheaderRowUnsaved.text)
  }
  override def select: SelectBuilder[SalesorderheaderFields, SalesorderheaderRow] = {
    SelectBuilderSql(""""sales"."salesorderheader"""", SalesorderheaderFields.structure, SalesorderheaderRow.read)
  }
  override def selectAll: Stream[ConnectionIO, SalesorderheaderRow] = {
    sql"""select "salesorderid", "revisionnumber", "orderdate"::text, "duedate"::text, "shipdate"::text, "status", "onlineorderflag", "purchaseordernumber", "accountnumber", "customerid", "salespersonid", "territoryid", "billtoaddressid", "shiptoaddressid", "shipmethodid", "creditcardid", "creditcardapprovalcode", "currencyrateid", "subtotal", "taxamt", "freight", "totaldue", "comment", "rowguid", "modifieddate"::text from "sales"."salesorderheader"""".query(using SalesorderheaderRow.read).stream
  }
  override def selectById(salesorderid: SalesorderheaderId): ConnectionIO[Option[SalesorderheaderRow]] = {
    sql"""select "salesorderid", "revisionnumber", "orderdate"::text, "duedate"::text, "shipdate"::text, "status", "onlineorderflag", "purchaseordernumber", "accountnumber", "customerid", "salespersonid", "territoryid", "billtoaddressid", "shiptoaddressid", "shipmethodid", "creditcardid", "creditcardapprovalcode", "currencyrateid", "subtotal", "taxamt", "freight", "totaldue", "comment", "rowguid", "modifieddate"::text from "sales"."salesorderheader" where "salesorderid" = ${fromWrite(salesorderid)(Write.fromPut(SalesorderheaderId.put))}""".query(using SalesorderheaderRow.read).option
  }
  override def selectByIds(salesorderids: Array[SalesorderheaderId]): Stream[ConnectionIO, SalesorderheaderRow] = {
    sql"""select "salesorderid", "revisionnumber", "orderdate"::text, "duedate"::text, "shipdate"::text, "status", "onlineorderflag", "purchaseordernumber", "accountnumber", "customerid", "salespersonid", "territoryid", "billtoaddressid", "shiptoaddressid", "shipmethodid", "creditcardid", "creditcardapprovalcode", "currencyrateid", "subtotal", "taxamt", "freight", "totaldue", "comment", "rowguid", "modifieddate"::text from "sales"."salesorderheader" where "salesorderid" = ANY(${salesorderids})""".query(using SalesorderheaderRow.read).stream
  }
  override def selectByIdsTracked(salesorderids: Array[SalesorderheaderId]): ConnectionIO[Map[SalesorderheaderId, SalesorderheaderRow]] = {
    selectByIds(salesorderids).compile.toList.map { rows =>
      val byId = rows.view.map(x => (x.salesorderid, x)).toMap
      salesorderids.view.flatMap(id => byId.get(id).map(x => (id, x))).toMap
    }
  }
  override def update: UpdateBuilder[SalesorderheaderFields, SalesorderheaderRow] = {
    UpdateBuilder(""""sales"."salesorderheader"""", SalesorderheaderFields.structure, SalesorderheaderRow.read)
  }
  override def update(row: SalesorderheaderRow): ConnectionIO[Boolean] = {
    val salesorderid = row.salesorderid
    sql"""update "sales"."salesorderheader"
          set "revisionnumber" = ${fromWrite(row.revisionnumber)(Write.fromPut(TypoShort.put))}::int2,
              "orderdate" = ${fromWrite(row.orderdate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp,
              "duedate" = ${fromWrite(row.duedate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp,
              "shipdate" = ${fromWrite(row.shipdate)(Write.fromPutOption(TypoLocalDateTime.put))}::timestamp,
              "status" = ${fromWrite(row.status)(Write.fromPut(TypoShort.put))}::int2,
              "onlineorderflag" = ${fromWrite(row.onlineorderflag)(Write.fromPut(Flag.put))}::bool,
              "purchaseordernumber" = ${fromWrite(row.purchaseordernumber)(Write.fromPutOption(OrderNumber.put))}::varchar,
              "accountnumber" = ${fromWrite(row.accountnumber)(Write.fromPutOption(AccountNumber.put))}::varchar,
              "customerid" = ${fromWrite(row.customerid)(Write.fromPut(CustomerId.put))}::int4,
              "salespersonid" = ${fromWrite(row.salespersonid)(Write.fromPutOption(BusinessentityId.put))}::int4,
              "territoryid" = ${fromWrite(row.territoryid)(Write.fromPutOption(SalesterritoryId.put))}::int4,
              "billtoaddressid" = ${fromWrite(row.billtoaddressid)(Write.fromPut(AddressId.put))}::int4,
              "shiptoaddressid" = ${fromWrite(row.shiptoaddressid)(Write.fromPut(AddressId.put))}::int4,
              "shipmethodid" = ${fromWrite(row.shipmethodid)(Write.fromPut(ShipmethodId.put))}::int4,
              "creditcardid" = ${fromWrite(row.creditcardid)(Write.fromPutOption(/* user-picked */ CustomCreditcardId.put))}::int4,
              "creditcardapprovalcode" = ${fromWrite(row.creditcardapprovalcode)(Write.fromPutOption(Meta.StringMeta.put))},
              "currencyrateid" = ${fromWrite(row.currencyrateid)(Write.fromPutOption(CurrencyrateId.put))}::int4,
              "subtotal" = ${fromWrite(row.subtotal)(Write.fromPut(Meta.ScalaBigDecimalMeta.put))}::numeric,
              "taxamt" = ${fromWrite(row.taxamt)(Write.fromPut(Meta.ScalaBigDecimalMeta.put))}::numeric,
              "freight" = ${fromWrite(row.freight)(Write.fromPut(Meta.ScalaBigDecimalMeta.put))}::numeric,
              "totaldue" = ${fromWrite(row.totaldue)(Write.fromPutOption(Meta.ScalaBigDecimalMeta.put))}::numeric,
              "comment" = ${fromWrite(row.comment)(Write.fromPutOption(Meta.StringMeta.put))},
              "rowguid" = ${fromWrite(row.rowguid)(Write.fromPut(TypoUUID.put))}::uuid,
              "modifieddate" = ${fromWrite(row.modifieddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp
          where "salesorderid" = ${fromWrite(salesorderid)(Write.fromPut(SalesorderheaderId.put))}"""
      .update
      .run
      .map(_ > 0)
  }
  override def upsert(unsaved: SalesorderheaderRow): ConnectionIO[SalesorderheaderRow] = {
    sql"""insert into "sales"."salesorderheader"("salesorderid", "revisionnumber", "orderdate", "duedate", "shipdate", "status", "onlineorderflag", "purchaseordernumber", "accountnumber", "customerid", "salespersonid", "territoryid", "billtoaddressid", "shiptoaddressid", "shipmethodid", "creditcardid", "creditcardapprovalcode", "currencyrateid", "subtotal", "taxamt", "freight", "totaldue", "comment", "rowguid", "modifieddate")
          values (
            ${fromWrite(unsaved.salesorderid)(Write.fromPut(SalesorderheaderId.put))}::int4,
            ${fromWrite(unsaved.revisionnumber)(Write.fromPut(TypoShort.put))}::int2,
            ${fromWrite(unsaved.orderdate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp,
            ${fromWrite(unsaved.duedate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp,
            ${fromWrite(unsaved.shipdate)(Write.fromPutOption(TypoLocalDateTime.put))}::timestamp,
            ${fromWrite(unsaved.status)(Write.fromPut(TypoShort.put))}::int2,
            ${fromWrite(unsaved.onlineorderflag)(Write.fromPut(Flag.put))}::bool,
            ${fromWrite(unsaved.purchaseordernumber)(Write.fromPutOption(OrderNumber.put))}::varchar,
            ${fromWrite(unsaved.accountnumber)(Write.fromPutOption(AccountNumber.put))}::varchar,
            ${fromWrite(unsaved.customerid)(Write.fromPut(CustomerId.put))}::int4,
            ${fromWrite(unsaved.salespersonid)(Write.fromPutOption(BusinessentityId.put))}::int4,
            ${fromWrite(unsaved.territoryid)(Write.fromPutOption(SalesterritoryId.put))}::int4,
            ${fromWrite(unsaved.billtoaddressid)(Write.fromPut(AddressId.put))}::int4,
            ${fromWrite(unsaved.shiptoaddressid)(Write.fromPut(AddressId.put))}::int4,
            ${fromWrite(unsaved.shipmethodid)(Write.fromPut(ShipmethodId.put))}::int4,
            ${fromWrite(unsaved.creditcardid)(Write.fromPutOption(/* user-picked */ CustomCreditcardId.put))}::int4,
            ${fromWrite(unsaved.creditcardapprovalcode)(Write.fromPutOption(Meta.StringMeta.put))},
            ${fromWrite(unsaved.currencyrateid)(Write.fromPutOption(CurrencyrateId.put))}::int4,
            ${fromWrite(unsaved.subtotal)(Write.fromPut(Meta.ScalaBigDecimalMeta.put))}::numeric,
            ${fromWrite(unsaved.taxamt)(Write.fromPut(Meta.ScalaBigDecimalMeta.put))}::numeric,
            ${fromWrite(unsaved.freight)(Write.fromPut(Meta.ScalaBigDecimalMeta.put))}::numeric,
            ${fromWrite(unsaved.totaldue)(Write.fromPutOption(Meta.ScalaBigDecimalMeta.put))}::numeric,
            ${fromWrite(unsaved.comment)(Write.fromPutOption(Meta.StringMeta.put))},
            ${fromWrite(unsaved.rowguid)(Write.fromPut(TypoUUID.put))}::uuid,
            ${fromWrite(unsaved.modifieddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp
          )
          on conflict ("salesorderid")
          do update set
            "revisionnumber" = EXCLUDED."revisionnumber",
            "orderdate" = EXCLUDED."orderdate",
            "duedate" = EXCLUDED."duedate",
            "shipdate" = EXCLUDED."shipdate",
            "status" = EXCLUDED."status",
            "onlineorderflag" = EXCLUDED."onlineorderflag",
            "purchaseordernumber" = EXCLUDED."purchaseordernumber",
            "accountnumber" = EXCLUDED."accountnumber",
            "customerid" = EXCLUDED."customerid",
            "salespersonid" = EXCLUDED."salespersonid",
            "territoryid" = EXCLUDED."territoryid",
            "billtoaddressid" = EXCLUDED."billtoaddressid",
            "shiptoaddressid" = EXCLUDED."shiptoaddressid",
            "shipmethodid" = EXCLUDED."shipmethodid",
            "creditcardid" = EXCLUDED."creditcardid",
            "creditcardapprovalcode" = EXCLUDED."creditcardapprovalcode",
            "currencyrateid" = EXCLUDED."currencyrateid",
            "subtotal" = EXCLUDED."subtotal",
            "taxamt" = EXCLUDED."taxamt",
            "freight" = EXCLUDED."freight",
            "totaldue" = EXCLUDED."totaldue",
            "comment" = EXCLUDED."comment",
            "rowguid" = EXCLUDED."rowguid",
            "modifieddate" = EXCLUDED."modifieddate"
          returning "salesorderid", "revisionnumber", "orderdate"::text, "duedate"::text, "shipdate"::text, "status", "onlineorderflag", "purchaseordernumber", "accountnumber", "customerid", "salespersonid", "territoryid", "billtoaddressid", "shiptoaddressid", "shipmethodid", "creditcardid", "creditcardapprovalcode", "currencyrateid", "subtotal", "taxamt", "freight", "totaldue", "comment", "rowguid", "modifieddate"::text
       """.query(using SalesorderheaderRow.read).unique
  }
  override def upsertBatch(unsaved: List[SalesorderheaderRow]): Stream[ConnectionIO, SalesorderheaderRow] = {
    Update[SalesorderheaderRow](
      s"""insert into "sales"."salesorderheader"("salesorderid", "revisionnumber", "orderdate", "duedate", "shipdate", "status", "onlineorderflag", "purchaseordernumber", "accountnumber", "customerid", "salespersonid", "territoryid", "billtoaddressid", "shiptoaddressid", "shipmethodid", "creditcardid", "creditcardapprovalcode", "currencyrateid", "subtotal", "taxamt", "freight", "totaldue", "comment", "rowguid", "modifieddate")
          values (?::int4,?::int2,?::timestamp,?::timestamp,?::timestamp,?::int2,?::bool,?::varchar,?::varchar,?::int4,?::int4,?::int4,?::int4,?::int4,?::int4,?::int4,?,?::int4,?::numeric,?::numeric,?::numeric,?::numeric,?,?::uuid,?::timestamp)
          on conflict ("salesorderid")
          do update set
            "revisionnumber" = EXCLUDED."revisionnumber",
            "orderdate" = EXCLUDED."orderdate",
            "duedate" = EXCLUDED."duedate",
            "shipdate" = EXCLUDED."shipdate",
            "status" = EXCLUDED."status",
            "onlineorderflag" = EXCLUDED."onlineorderflag",
            "purchaseordernumber" = EXCLUDED."purchaseordernumber",
            "accountnumber" = EXCLUDED."accountnumber",
            "customerid" = EXCLUDED."customerid",
            "salespersonid" = EXCLUDED."salespersonid",
            "territoryid" = EXCLUDED."territoryid",
            "billtoaddressid" = EXCLUDED."billtoaddressid",
            "shiptoaddressid" = EXCLUDED."shiptoaddressid",
            "shipmethodid" = EXCLUDED."shipmethodid",
            "creditcardid" = EXCLUDED."creditcardid",
            "creditcardapprovalcode" = EXCLUDED."creditcardapprovalcode",
            "currencyrateid" = EXCLUDED."currencyrateid",
            "subtotal" = EXCLUDED."subtotal",
            "taxamt" = EXCLUDED."taxamt",
            "freight" = EXCLUDED."freight",
            "totaldue" = EXCLUDED."totaldue",
            "comment" = EXCLUDED."comment",
            "rowguid" = EXCLUDED."rowguid",
            "modifieddate" = EXCLUDED."modifieddate"
          returning "salesorderid", "revisionnumber", "orderdate"::text, "duedate"::text, "shipdate"::text, "status", "onlineorderflag", "purchaseordernumber", "accountnumber", "customerid", "salespersonid", "territoryid", "billtoaddressid", "shiptoaddressid", "shipmethodid", "creditcardid", "creditcardapprovalcode", "currencyrateid", "subtotal", "taxamt", "freight", "totaldue", "comment", "rowguid", "modifieddate"::text"""
    )(using SalesorderheaderRow.write)
    .updateManyWithGeneratedKeys[SalesorderheaderRow]("salesorderid", "revisionnumber", "orderdate", "duedate", "shipdate", "status", "onlineorderflag", "purchaseordernumber", "accountnumber", "customerid", "salespersonid", "territoryid", "billtoaddressid", "shiptoaddressid", "shipmethodid", "creditcardid", "creditcardapprovalcode", "currencyrateid", "subtotal", "taxamt", "freight", "totaldue", "comment", "rowguid", "modifieddate")(unsaved)(using catsStdInstancesForList, SalesorderheaderRow.read)
  }
  /* NOTE: this functionality is not safe if you use auto-commit mode! it runs 3 SQL statements */
  override def upsertStreaming(unsaved: Stream[ConnectionIO, SalesorderheaderRow], batchSize: Int = 10000): ConnectionIO[Int] = {
    for {
      _ <- sql"""create temporary table salesorderheader_TEMP (like "sales"."salesorderheader") on commit drop""".update.run
      _ <- new FragmentOps(sql"""copy salesorderheader_TEMP("salesorderid", "revisionnumber", "orderdate", "duedate", "shipdate", "status", "onlineorderflag", "purchaseordernumber", "accountnumber", "customerid", "salespersonid", "territoryid", "billtoaddressid", "shiptoaddressid", "shipmethodid", "creditcardid", "creditcardapprovalcode", "currencyrateid", "subtotal", "taxamt", "freight", "totaldue", "comment", "rowguid", "modifieddate") from stdin""").copyIn(unsaved, batchSize)(using SalesorderheaderRow.text)
      res <- sql"""insert into "sales"."salesorderheader"("salesorderid", "revisionnumber", "orderdate", "duedate", "shipdate", "status", "onlineorderflag", "purchaseordernumber", "accountnumber", "customerid", "salespersonid", "territoryid", "billtoaddressid", "shiptoaddressid", "shipmethodid", "creditcardid", "creditcardapprovalcode", "currencyrateid", "subtotal", "taxamt", "freight", "totaldue", "comment", "rowguid", "modifieddate")
                   select * from salesorderheader_TEMP
                   on conflict ("salesorderid")
                   do update set
                     "revisionnumber" = EXCLUDED."revisionnumber",
                     "orderdate" = EXCLUDED."orderdate",
                     "duedate" = EXCLUDED."duedate",
                     "shipdate" = EXCLUDED."shipdate",
                     "status" = EXCLUDED."status",
                     "onlineorderflag" = EXCLUDED."onlineorderflag",
                     "purchaseordernumber" = EXCLUDED."purchaseordernumber",
                     "accountnumber" = EXCLUDED."accountnumber",
                     "customerid" = EXCLUDED."customerid",
                     "salespersonid" = EXCLUDED."salespersonid",
                     "territoryid" = EXCLUDED."territoryid",
                     "billtoaddressid" = EXCLUDED."billtoaddressid",
                     "shiptoaddressid" = EXCLUDED."shiptoaddressid",
                     "shipmethodid" = EXCLUDED."shipmethodid",
                     "creditcardid" = EXCLUDED."creditcardid",
                     "creditcardapprovalcode" = EXCLUDED."creditcardapprovalcode",
                     "currencyrateid" = EXCLUDED."currencyrateid",
                     "subtotal" = EXCLUDED."subtotal",
                     "taxamt" = EXCLUDED."taxamt",
                     "freight" = EXCLUDED."freight",
                     "totaldue" = EXCLUDED."totaldue",
                     "comment" = EXCLUDED."comment",
                     "rowguid" = EXCLUDED."rowguid",
                     "modifieddate" = EXCLUDED."modifieddate"
                   ;
                   drop table salesorderheader_TEMP;""".update.run
    } yield res
  }
}
