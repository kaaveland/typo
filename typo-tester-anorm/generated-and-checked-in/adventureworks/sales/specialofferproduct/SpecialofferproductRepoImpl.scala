/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package specialofferproduct

import adventureworks.customtypes.Defaulted
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoUUID
import adventureworks.production.product.ProductId
import adventureworks.sales.specialoffer.SpecialofferId
import anorm.BatchSql
import anorm.NamedParameter
import anorm.ParameterValue
import anorm.RowParser
import anorm.SQL
import anorm.SimpleSql
import anorm.SqlStringInterpolation
import java.sql.Connection
import scala.annotation.nowarn
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql
import typo.dsl.UpdateBuilder

class SpecialofferproductRepoImpl extends SpecialofferproductRepo {
  override def delete: DeleteBuilder[SpecialofferproductFields, SpecialofferproductRow] = {
    DeleteBuilder(""""sales"."specialofferproduct"""", SpecialofferproductFields.structure)
  }
  override def deleteById(compositeId: SpecialofferproductId)(implicit c: Connection): Boolean = {
    SQL"""delete from "sales"."specialofferproduct" where "specialofferid" = ${ParameterValue(compositeId.specialofferid, null, SpecialofferId.toStatement)} AND "productid" = ${ParameterValue(compositeId.productid, null, ProductId.toStatement)}""".executeUpdate() > 0
  }
  override def deleteByIds(compositeIds: Array[SpecialofferproductId])(implicit c: Connection): Int = {
    val specialofferid = compositeIds.map(_.specialofferid)
    val productid = compositeIds.map(_.productid)
    SQL"""delete
          from "sales"."specialofferproduct"
          where ("specialofferid", "productid")
          in (select unnest(${specialofferid}), unnest(${productid}))
       """.executeUpdate()
    
  }
  override def insert(unsaved: SpecialofferproductRow)(implicit c: Connection): SpecialofferproductRow = {
    SQL"""insert into "sales"."specialofferproduct"("specialofferid", "productid", "rowguid", "modifieddate")
          values (${ParameterValue(unsaved.specialofferid, null, SpecialofferId.toStatement)}::int4, ${ParameterValue(unsaved.productid, null, ProductId.toStatement)}::int4, ${ParameterValue(unsaved.rowguid, null, TypoUUID.toStatement)}::uuid, ${ParameterValue(unsaved.modifieddate, null, TypoLocalDateTime.toStatement)}::timestamp)
          returning "specialofferid", "productid", "rowguid", "modifieddate"::text
       """
      .executeInsert(SpecialofferproductRow.rowParser(1).single)
    
  }
  override def insert(unsaved: SpecialofferproductRowUnsaved)(implicit c: Connection): SpecialofferproductRow = {
    val namedParameters = List(
      Some((NamedParameter("specialofferid", ParameterValue(unsaved.specialofferid, null, SpecialofferId.toStatement)), "::int4")),
      Some((NamedParameter("productid", ParameterValue(unsaved.productid, null, ProductId.toStatement)), "::int4")),
      unsaved.rowguid match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("rowguid", ParameterValue(value, null, TypoUUID.toStatement)), "::uuid"))
      },
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("modifieddate", ParameterValue(value, null, TypoLocalDateTime.toStatement)), "::timestamp"))
      }
    ).flatten
    val quote = '"'.toString
    if (namedParameters.isEmpty) {
      SQL"""insert into "sales"."specialofferproduct" default values
            returning "specialofferid", "productid", "rowguid", "modifieddate"::text
         """
        .executeInsert(SpecialofferproductRow.rowParser(1).single)
    } else {
      val q = s"""insert into "sales"."specialofferproduct"(${namedParameters.map{case (x, _) => quote + x.name + quote}.mkString(", ")})
                  values (${namedParameters.map{ case (np, cast) => s"{${np.name}}$cast"}.mkString(", ")})
                  returning "specialofferid", "productid", "rowguid", "modifieddate"::text
               """
      SimpleSql(SQL(q), namedParameters.map { case (np, _) => np.tupled }.toMap, RowParser.successful)
        .executeInsert(SpecialofferproductRow.rowParser(1).single)
    }
    
  }
  override def insertStreaming(unsaved: Iterator[SpecialofferproductRow], batchSize: Int = 10000)(implicit c: Connection): Long = {
    streamingInsert(s"""COPY "sales"."specialofferproduct"("specialofferid", "productid", "rowguid", "modifieddate") FROM STDIN""", batchSize, unsaved)(SpecialofferproductRow.text, c)
  }
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  override def insertUnsavedStreaming(unsaved: Iterator[SpecialofferproductRowUnsaved], batchSize: Int = 10000)(implicit c: Connection): Long = {
    streamingInsert(s"""COPY "sales"."specialofferproduct"("specialofferid", "productid", "rowguid", "modifieddate") FROM STDIN (DEFAULT '__DEFAULT_VALUE__')""", batchSize, unsaved)(SpecialofferproductRowUnsaved.text, c)
  }
  override def select: SelectBuilder[SpecialofferproductFields, SpecialofferproductRow] = {
    SelectBuilderSql(""""sales"."specialofferproduct"""", SpecialofferproductFields.structure, SpecialofferproductRow.rowParser)
  }
  override def selectAll(implicit c: Connection): List[SpecialofferproductRow] = {
    SQL"""select "specialofferid", "productid", "rowguid", "modifieddate"::text
          from "sales"."specialofferproduct"
       """.as(SpecialofferproductRow.rowParser(1).*)
  }
  override def selectById(compositeId: SpecialofferproductId)(implicit c: Connection): Option[SpecialofferproductRow] = {
    SQL"""select "specialofferid", "productid", "rowguid", "modifieddate"::text
          from "sales"."specialofferproduct"
          where "specialofferid" = ${ParameterValue(compositeId.specialofferid, null, SpecialofferId.toStatement)} AND "productid" = ${ParameterValue(compositeId.productid, null, ProductId.toStatement)}
       """.as(SpecialofferproductRow.rowParser(1).singleOpt)
  }
  override def selectByIds(compositeIds: Array[SpecialofferproductId])(implicit c: Connection): List[SpecialofferproductRow] = {
    val specialofferid = compositeIds.map(_.specialofferid)
    val productid = compositeIds.map(_.productid)
    SQL"""select "specialofferid", "productid", "rowguid", "modifieddate"::text
          from "sales"."specialofferproduct"
          where ("specialofferid", "productid") 
          in (select unnest(${specialofferid}), unnest(${productid}))
       """.as(SpecialofferproductRow.rowParser(1).*)
    
  }
  override def selectByIdsTracked(compositeIds: Array[SpecialofferproductId])(implicit c: Connection): Map[SpecialofferproductId, SpecialofferproductRow] = {
    val byId = selectByIds(compositeIds).view.map(x => (x.compositeId, x)).toMap
    compositeIds.view.flatMap(id => byId.get(id).map(x => (id, x))).toMap
  }
  override def update: UpdateBuilder[SpecialofferproductFields, SpecialofferproductRow] = {
    UpdateBuilder(""""sales"."specialofferproduct"""", SpecialofferproductFields.structure, SpecialofferproductRow.rowParser)
  }
  override def update(row: SpecialofferproductRow)(implicit c: Connection): Boolean = {
    val compositeId = row.compositeId
    SQL"""update "sales"."specialofferproduct"
          set "rowguid" = ${ParameterValue(row.rowguid, null, TypoUUID.toStatement)}::uuid,
              "modifieddate" = ${ParameterValue(row.modifieddate, null, TypoLocalDateTime.toStatement)}::timestamp
          where "specialofferid" = ${ParameterValue(compositeId.specialofferid, null, SpecialofferId.toStatement)} AND "productid" = ${ParameterValue(compositeId.productid, null, ProductId.toStatement)}
       """.executeUpdate() > 0
  }
  override def upsert(unsaved: SpecialofferproductRow)(implicit c: Connection): SpecialofferproductRow = {
    SQL"""insert into "sales"."specialofferproduct"("specialofferid", "productid", "rowguid", "modifieddate")
          values (
            ${ParameterValue(unsaved.specialofferid, null, SpecialofferId.toStatement)}::int4,
            ${ParameterValue(unsaved.productid, null, ProductId.toStatement)}::int4,
            ${ParameterValue(unsaved.rowguid, null, TypoUUID.toStatement)}::uuid,
            ${ParameterValue(unsaved.modifieddate, null, TypoLocalDateTime.toStatement)}::timestamp
          )
          on conflict ("specialofferid", "productid")
          do update set
            "rowguid" = EXCLUDED."rowguid",
            "modifieddate" = EXCLUDED."modifieddate"
          returning "specialofferid", "productid", "rowguid", "modifieddate"::text
       """
      .executeInsert(SpecialofferproductRow.rowParser(1).single)
    
  }
  override def upsertBatch(unsaved: Iterable[SpecialofferproductRow])(implicit c: Connection): List[SpecialofferproductRow] = {
    def toNamedParameter(row: SpecialofferproductRow): List[NamedParameter] = List(
      NamedParameter("specialofferid", ParameterValue(row.specialofferid, null, SpecialofferId.toStatement)),
      NamedParameter("productid", ParameterValue(row.productid, null, ProductId.toStatement)),
      NamedParameter("rowguid", ParameterValue(row.rowguid, null, TypoUUID.toStatement)),
      NamedParameter("modifieddate", ParameterValue(row.modifieddate, null, TypoLocalDateTime.toStatement))
    )
    unsaved.toList match {
      case Nil => Nil
      case head :: rest =>
        new anorm.adventureworks.ExecuteReturningSyntax.Ops(
          BatchSql(
            s"""insert into "sales"."specialofferproduct"("specialofferid", "productid", "rowguid", "modifieddate")
                values ({specialofferid}::int4, {productid}::int4, {rowguid}::uuid, {modifieddate}::timestamp)
                on conflict ("specialofferid", "productid")
                do update set
                  "rowguid" = EXCLUDED."rowguid",
                  "modifieddate" = EXCLUDED."modifieddate"
                returning "specialofferid", "productid", "rowguid", "modifieddate"::text
             """,
            toNamedParameter(head),
            rest.map(toNamedParameter)*
          )
        ).executeReturning(SpecialofferproductRow.rowParser(1).*)
    }
  }
  /* NOTE: this functionality is not safe if you use auto-commit mode! it runs 3 SQL statements */
  override def upsertStreaming(unsaved: Iterator[SpecialofferproductRow], batchSize: Int = 10000)(implicit c: Connection): Int = {
    SQL"""create temporary table specialofferproduct_TEMP (like "sales"."specialofferproduct") on commit drop""".execute(): @nowarn
    streamingInsert(s"""copy specialofferproduct_TEMP("specialofferid", "productid", "rowguid", "modifieddate") from stdin""", batchSize, unsaved)(SpecialofferproductRow.text, c): @nowarn
    SQL"""insert into "sales"."specialofferproduct"("specialofferid", "productid", "rowguid", "modifieddate")
          select * from specialofferproduct_TEMP
          on conflict ("specialofferid", "productid")
          do update set
            "rowguid" = EXCLUDED."rowguid",
            "modifieddate" = EXCLUDED."modifieddate"
          ;
          drop table specialofferproduct_TEMP;""".executeUpdate()
  }
}
