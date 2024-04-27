/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package salesperson

import adventureworks.customtypes.Defaulted
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoUUID
import adventureworks.person.businessentity.BusinessentityId
import adventureworks.sales.salesterritory.SalesterritoryId
import doobie.free.connection.ConnectionIO
import doobie.postgres.syntax.FragmentOps
import doobie.syntax.SqlInterpolator.SingleFragment.fromWrite
import doobie.syntax.string.toSqlInterpolator
import doobie.util.Write
import doobie.util.fragment.Fragment
import doobie.util.meta.Meta
import fs2.Stream
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql
import typo.dsl.UpdateBuilder

class SalespersonRepoImpl extends SalespersonRepo {
  override def delete: DeleteBuilder[SalespersonFields, SalespersonRow] = {
    DeleteBuilder("sales.salesperson", SalespersonFields.structure)
  }
  override def deleteById(businessentityid: BusinessentityId): ConnectionIO[Boolean] = {
    sql"""delete from sales.salesperson where "businessentityid" = ${fromWrite(businessentityid)(Write.fromPut(BusinessentityId.put))}""".update.run.map(_ > 0)
  }
  override def deleteByIds(businessentityids: Array[BusinessentityId]): ConnectionIO[Int] = {
    sql"""delete from sales.salesperson where "businessentityid" = ANY(${businessentityids})""".update.run
  }
  override def insert(unsaved: SalespersonRow): ConnectionIO[SalespersonRow] = {
    sql"""insert into sales.salesperson("businessentityid", "territoryid", "salesquota", "bonus", "commissionpct", "salesytd", "saleslastyear", "rowguid", "modifieddate")
          values (${fromWrite(unsaved.businessentityid)(Write.fromPut(BusinessentityId.put))}::int4, ${fromWrite(unsaved.territoryid)(Write.fromPutOption(SalesterritoryId.put))}::int4, ${fromWrite(unsaved.salesquota)(Write.fromPutOption(Meta.ScalaBigDecimalMeta.put))}::numeric, ${fromWrite(unsaved.bonus)(Write.fromPut(Meta.ScalaBigDecimalMeta.put))}::numeric, ${fromWrite(unsaved.commissionpct)(Write.fromPut(Meta.ScalaBigDecimalMeta.put))}::numeric, ${fromWrite(unsaved.salesytd)(Write.fromPut(Meta.ScalaBigDecimalMeta.put))}::numeric, ${fromWrite(unsaved.saleslastyear)(Write.fromPut(Meta.ScalaBigDecimalMeta.put))}::numeric, ${fromWrite(unsaved.rowguid)(Write.fromPut(TypoUUID.put))}::uuid, ${fromWrite(unsaved.modifieddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp)
          returning "businessentityid", "territoryid", "salesquota", "bonus", "commissionpct", "salesytd", "saleslastyear", "rowguid", "modifieddate"::text
       """.query(using SalespersonRow.read).unique
  }
  override def insert(unsaved: SalespersonRowUnsaved): ConnectionIO[SalespersonRow] = {
    val fs = List(
      Some((Fragment.const(s""""businessentityid""""), fr"${fromWrite(unsaved.businessentityid)(Write.fromPut(BusinessentityId.put))}::int4")),
      Some((Fragment.const(s""""territoryid""""), fr"${fromWrite(unsaved.territoryid)(Write.fromPutOption(SalesterritoryId.put))}::int4")),
      Some((Fragment.const(s""""salesquota""""), fr"${fromWrite(unsaved.salesquota)(Write.fromPutOption(Meta.ScalaBigDecimalMeta.put))}::numeric")),
      unsaved.bonus match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s""""bonus""""), fr"${fromWrite(value: BigDecimal)(Write.fromPut(Meta.ScalaBigDecimalMeta.put))}::numeric"))
      },
      unsaved.commissionpct match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s""""commissionpct""""), fr"${fromWrite(value: BigDecimal)(Write.fromPut(Meta.ScalaBigDecimalMeta.put))}::numeric"))
      },
      unsaved.salesytd match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s""""salesytd""""), fr"${fromWrite(value: BigDecimal)(Write.fromPut(Meta.ScalaBigDecimalMeta.put))}::numeric"))
      },
      unsaved.saleslastyear match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s""""saleslastyear""""), fr"${fromWrite(value: BigDecimal)(Write.fromPut(Meta.ScalaBigDecimalMeta.put))}::numeric"))
      },
      unsaved.rowguid match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s""""rowguid""""), fr"${fromWrite(value: TypoUUID)(Write.fromPut(TypoUUID.put))}::uuid"))
      },
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s""""modifieddate""""), fr"${fromWrite(value: TypoLocalDateTime)(Write.fromPut(TypoLocalDateTime.put))}::timestamp"))
      }
    ).flatten
    
    val q = if (fs.isEmpty) {
      sql"""insert into sales.salesperson default values
            returning "businessentityid", "territoryid", "salesquota", "bonus", "commissionpct", "salesytd", "saleslastyear", "rowguid", "modifieddate"::text
         """
    } else {
      val CommaSeparate = Fragment.FragmentMonoid.intercalate(fr", ")
      sql"""insert into sales.salesperson(${CommaSeparate.combineAllOption(fs.map { case (n, _) => n }).get})
            values (${CommaSeparate.combineAllOption(fs.map { case (_, f) => f }).get})
            returning "businessentityid", "territoryid", "salesquota", "bonus", "commissionpct", "salesytd", "saleslastyear", "rowguid", "modifieddate"::text
         """
    }
    q.query(using SalespersonRow.read).unique
    
  }
  override def insertStreaming(unsaved: Stream[ConnectionIO, SalespersonRow], batchSize: Int): ConnectionIO[Long] = {
    new FragmentOps(sql"""COPY sales.salesperson("businessentityid", "territoryid", "salesquota", "bonus", "commissionpct", "salesytd", "saleslastyear", "rowguid", "modifieddate") FROM STDIN""").copyIn(unsaved, batchSize)(using SalespersonRow.text)
  }
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  override def insertUnsavedStreaming(unsaved: Stream[ConnectionIO, SalespersonRowUnsaved], batchSize: Int): ConnectionIO[Long] = {
    new FragmentOps(sql"""COPY sales.salesperson("businessentityid", "territoryid", "salesquota", "bonus", "commissionpct", "salesytd", "saleslastyear", "rowguid", "modifieddate") FROM STDIN (DEFAULT '__DEFAULT_VALUE__')""").copyIn(unsaved, batchSize)(using SalespersonRowUnsaved.text)
  }
  override def select: SelectBuilder[SalespersonFields, SalespersonRow] = {
    SelectBuilderSql("sales.salesperson", SalespersonFields.structure, SalespersonRow.read)
  }
  override def selectAll: Stream[ConnectionIO, SalespersonRow] = {
    sql"""select "businessentityid", "territoryid", "salesquota", "bonus", "commissionpct", "salesytd", "saleslastyear", "rowguid", "modifieddate"::text from sales.salesperson""".query(using SalespersonRow.read).stream
  }
  override def selectById(businessentityid: BusinessentityId): ConnectionIO[Option[SalespersonRow]] = {
    sql"""select "businessentityid", "territoryid", "salesquota", "bonus", "commissionpct", "salesytd", "saleslastyear", "rowguid", "modifieddate"::text from sales.salesperson where "businessentityid" = ${fromWrite(businessentityid)(Write.fromPut(BusinessentityId.put))}""".query(using SalespersonRow.read).option
  }
  override def selectByIds(businessentityids: Array[BusinessentityId]): Stream[ConnectionIO, SalespersonRow] = {
    sql"""select "businessentityid", "territoryid", "salesquota", "bonus", "commissionpct", "salesytd", "saleslastyear", "rowguid", "modifieddate"::text from sales.salesperson where "businessentityid" = ANY(${businessentityids})""".query(using SalespersonRow.read).stream
  }
  override def selectByIdsTracked(businessentityids: Array[BusinessentityId]): ConnectionIO[Map[BusinessentityId, Option[SalespersonRow]]] = {
    selectByIds(businessentityids).compile.toList.map { rows =>
      val byId = rows.view.map(x => (x.businessentityid, x)).toMap
      businessentityids.view.map(id => (id, byId.get(id))).toMap
    }
  }
  override def update: UpdateBuilder[SalespersonFields, SalespersonRow] = {
    UpdateBuilder("sales.salesperson", SalespersonFields.structure, SalespersonRow.read)
  }
  override def update(row: SalespersonRow): ConnectionIO[Boolean] = {
    val businessentityid = row.businessentityid
    sql"""update sales.salesperson
          set "territoryid" = ${fromWrite(row.territoryid)(Write.fromPutOption(SalesterritoryId.put))}::int4,
              "salesquota" = ${fromWrite(row.salesquota)(Write.fromPutOption(Meta.ScalaBigDecimalMeta.put))}::numeric,
              "bonus" = ${fromWrite(row.bonus)(Write.fromPut(Meta.ScalaBigDecimalMeta.put))}::numeric,
              "commissionpct" = ${fromWrite(row.commissionpct)(Write.fromPut(Meta.ScalaBigDecimalMeta.put))}::numeric,
              "salesytd" = ${fromWrite(row.salesytd)(Write.fromPut(Meta.ScalaBigDecimalMeta.put))}::numeric,
              "saleslastyear" = ${fromWrite(row.saleslastyear)(Write.fromPut(Meta.ScalaBigDecimalMeta.put))}::numeric,
              "rowguid" = ${fromWrite(row.rowguid)(Write.fromPut(TypoUUID.put))}::uuid,
              "modifieddate" = ${fromWrite(row.modifieddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp
          where "businessentityid" = ${fromWrite(businessentityid)(Write.fromPut(BusinessentityId.put))}"""
      .update
      .run
      .map(_ > 0)
  }
  override def upsert(unsaved: SalespersonRow): ConnectionIO[SalespersonRow] = {
    sql"""insert into sales.salesperson("businessentityid", "territoryid", "salesquota", "bonus", "commissionpct", "salesytd", "saleslastyear", "rowguid", "modifieddate")
          values (
            ${fromWrite(unsaved.businessentityid)(Write.fromPut(BusinessentityId.put))}::int4,
            ${fromWrite(unsaved.territoryid)(Write.fromPutOption(SalesterritoryId.put))}::int4,
            ${fromWrite(unsaved.salesquota)(Write.fromPutOption(Meta.ScalaBigDecimalMeta.put))}::numeric,
            ${fromWrite(unsaved.bonus)(Write.fromPut(Meta.ScalaBigDecimalMeta.put))}::numeric,
            ${fromWrite(unsaved.commissionpct)(Write.fromPut(Meta.ScalaBigDecimalMeta.put))}::numeric,
            ${fromWrite(unsaved.salesytd)(Write.fromPut(Meta.ScalaBigDecimalMeta.put))}::numeric,
            ${fromWrite(unsaved.saleslastyear)(Write.fromPut(Meta.ScalaBigDecimalMeta.put))}::numeric,
            ${fromWrite(unsaved.rowguid)(Write.fromPut(TypoUUID.put))}::uuid,
            ${fromWrite(unsaved.modifieddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp
          )
          on conflict ("businessentityid")
          do update set
            "territoryid" = EXCLUDED."territoryid",
            "salesquota" = EXCLUDED."salesquota",
            "bonus" = EXCLUDED."bonus",
            "commissionpct" = EXCLUDED."commissionpct",
            "salesytd" = EXCLUDED."salesytd",
            "saleslastyear" = EXCLUDED."saleslastyear",
            "rowguid" = EXCLUDED."rowguid",
            "modifieddate" = EXCLUDED."modifieddate"
          returning "businessentityid", "territoryid", "salesquota", "bonus", "commissionpct", "salesytd", "saleslastyear", "rowguid", "modifieddate"::text
       """.query(using SalespersonRow.read).unique
  }
}
