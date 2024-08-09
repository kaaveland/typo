/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package shoppingcartitem

import adventureworks.customtypes.Defaulted
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.production.product.ProductId
import anorm.BatchSql
import anorm.NamedParameter
import anorm.ParameterValue
import anorm.RowParser
import anorm.SQL
import anorm.SimpleSql
import anorm.SqlStringInterpolation
import anorm.ToStatement
import java.sql.Connection
import scala.annotation.nowarn
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql
import typo.dsl.UpdateBuilder

class ShoppingcartitemRepoImpl extends ShoppingcartitemRepo {
  override def delete: DeleteBuilder[ShoppingcartitemFields, ShoppingcartitemRow] = {
    DeleteBuilder(""""sales"."shoppingcartitem"""", ShoppingcartitemFields.structure)
  }
  override def deleteById(shoppingcartitemid: ShoppingcartitemId)(implicit c: Connection): Boolean = {
    SQL"""delete from "sales"."shoppingcartitem" where "shoppingcartitemid" = ${ParameterValue(shoppingcartitemid, null, ShoppingcartitemId.toStatement)}""".executeUpdate() > 0
  }
  override def deleteByIds(shoppingcartitemids: Array[ShoppingcartitemId])(implicit c: Connection): Int = {
    SQL"""delete
          from "sales"."shoppingcartitem"
          where "shoppingcartitemid" = ANY(${shoppingcartitemids})
       """.executeUpdate()
    
  }
  override def insert(unsaved: ShoppingcartitemRow)(implicit c: Connection): ShoppingcartitemRow = {
    SQL"""insert into "sales"."shoppingcartitem"("shoppingcartitemid", "shoppingcartid", "quantity", "productid", "datecreated", "modifieddate")
          values (${ParameterValue(unsaved.shoppingcartitemid, null, ShoppingcartitemId.toStatement)}::int4, ${ParameterValue(unsaved.shoppingcartid, null, ToStatement.stringToStatement)}, ${ParameterValue(unsaved.quantity, null, ToStatement.intToStatement)}::int4, ${ParameterValue(unsaved.productid, null, ProductId.toStatement)}::int4, ${ParameterValue(unsaved.datecreated, null, TypoLocalDateTime.toStatement)}::timestamp, ${ParameterValue(unsaved.modifieddate, null, TypoLocalDateTime.toStatement)}::timestamp)
          returning "shoppingcartitemid", "shoppingcartid", "quantity", "productid", "datecreated"::text, "modifieddate"::text
       """
      .executeInsert(ShoppingcartitemRow.rowParser(1).single)
    
  }
  override def insert(unsaved: ShoppingcartitemRowUnsaved)(implicit c: Connection): ShoppingcartitemRow = {
    val namedParameters = List(
      Some((NamedParameter("shoppingcartid", ParameterValue(unsaved.shoppingcartid, null, ToStatement.stringToStatement)), "")),
      Some((NamedParameter("productid", ParameterValue(unsaved.productid, null, ProductId.toStatement)), "::int4")),
      unsaved.shoppingcartitemid match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("shoppingcartitemid", ParameterValue(value, null, ShoppingcartitemId.toStatement)), "::int4"))
      },
      unsaved.quantity match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("quantity", ParameterValue(value, null, ToStatement.intToStatement)), "::int4"))
      },
      unsaved.datecreated match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("datecreated", ParameterValue(value, null, TypoLocalDateTime.toStatement)), "::timestamp"))
      },
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("modifieddate", ParameterValue(value, null, TypoLocalDateTime.toStatement)), "::timestamp"))
      }
    ).flatten
    val quote = '"'.toString
    if (namedParameters.isEmpty) {
      SQL"""insert into "sales"."shoppingcartitem" default values
            returning "shoppingcartitemid", "shoppingcartid", "quantity", "productid", "datecreated"::text, "modifieddate"::text
         """
        .executeInsert(ShoppingcartitemRow.rowParser(1).single)
    } else {
      val q = s"""insert into "sales"."shoppingcartitem"(${namedParameters.map{case (x, _) => quote + x.name + quote}.mkString(", ")})
                  values (${namedParameters.map{ case (np, cast) => s"{${np.name}}$cast"}.mkString(", ")})
                  returning "shoppingcartitemid", "shoppingcartid", "quantity", "productid", "datecreated"::text, "modifieddate"::text
               """
      SimpleSql(SQL(q), namedParameters.map { case (np, _) => np.tupled }.toMap, RowParser.successful)
        .executeInsert(ShoppingcartitemRow.rowParser(1).single)
    }
    
  }
  override def insertStreaming(unsaved: Iterator[ShoppingcartitemRow], batchSize: Int = 10000)(implicit c: Connection): Long = {
    streamingInsert(s"""COPY "sales"."shoppingcartitem"("shoppingcartitemid", "shoppingcartid", "quantity", "productid", "datecreated", "modifieddate") FROM STDIN""", batchSize, unsaved)(ShoppingcartitemRow.text, c)
  }
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  override def insertUnsavedStreaming(unsaved: Iterator[ShoppingcartitemRowUnsaved], batchSize: Int = 10000)(implicit c: Connection): Long = {
    streamingInsert(s"""COPY "sales"."shoppingcartitem"("shoppingcartid", "productid", "shoppingcartitemid", "quantity", "datecreated", "modifieddate") FROM STDIN (DEFAULT '__DEFAULT_VALUE__')""", batchSize, unsaved)(ShoppingcartitemRowUnsaved.text, c)
  }
  override def select: SelectBuilder[ShoppingcartitemFields, ShoppingcartitemRow] = {
    SelectBuilderSql(""""sales"."shoppingcartitem"""", ShoppingcartitemFields.structure, ShoppingcartitemRow.rowParser)
  }
  override def selectAll(implicit c: Connection): List[ShoppingcartitemRow] = {
    SQL"""select "shoppingcartitemid", "shoppingcartid", "quantity", "productid", "datecreated"::text, "modifieddate"::text
          from "sales"."shoppingcartitem"
       """.as(ShoppingcartitemRow.rowParser(1).*)
  }
  override def selectById(shoppingcartitemid: ShoppingcartitemId)(implicit c: Connection): Option[ShoppingcartitemRow] = {
    SQL"""select "shoppingcartitemid", "shoppingcartid", "quantity", "productid", "datecreated"::text, "modifieddate"::text
          from "sales"."shoppingcartitem"
          where "shoppingcartitemid" = ${ParameterValue(shoppingcartitemid, null, ShoppingcartitemId.toStatement)}
       """.as(ShoppingcartitemRow.rowParser(1).singleOpt)
  }
  override def selectByIds(shoppingcartitemids: Array[ShoppingcartitemId])(implicit c: Connection): List[ShoppingcartitemRow] = {
    SQL"""select "shoppingcartitemid", "shoppingcartid", "quantity", "productid", "datecreated"::text, "modifieddate"::text
          from "sales"."shoppingcartitem"
          where "shoppingcartitemid" = ANY(${shoppingcartitemids})
       """.as(ShoppingcartitemRow.rowParser(1).*)
    
  }
  override def selectByIdsTracked(shoppingcartitemids: Array[ShoppingcartitemId])(implicit c: Connection): Map[ShoppingcartitemId, ShoppingcartitemRow] = {
    val byId = selectByIds(shoppingcartitemids).view.map(x => (x.shoppingcartitemid, x)).toMap
    shoppingcartitemids.view.flatMap(id => byId.get(id).map(x => (id, x))).toMap
  }
  override def update: UpdateBuilder[ShoppingcartitemFields, ShoppingcartitemRow] = {
    UpdateBuilder(""""sales"."shoppingcartitem"""", ShoppingcartitemFields.structure, ShoppingcartitemRow.rowParser)
  }
  override def update(row: ShoppingcartitemRow)(implicit c: Connection): Boolean = {
    val shoppingcartitemid = row.shoppingcartitemid
    SQL"""update "sales"."shoppingcartitem"
          set "shoppingcartid" = ${ParameterValue(row.shoppingcartid, null, ToStatement.stringToStatement)},
              "quantity" = ${ParameterValue(row.quantity, null, ToStatement.intToStatement)}::int4,
              "productid" = ${ParameterValue(row.productid, null, ProductId.toStatement)}::int4,
              "datecreated" = ${ParameterValue(row.datecreated, null, TypoLocalDateTime.toStatement)}::timestamp,
              "modifieddate" = ${ParameterValue(row.modifieddate, null, TypoLocalDateTime.toStatement)}::timestamp
          where "shoppingcartitemid" = ${ParameterValue(shoppingcartitemid, null, ShoppingcartitemId.toStatement)}
       """.executeUpdate() > 0
  }
  override def upsert(unsaved: ShoppingcartitemRow)(implicit c: Connection): ShoppingcartitemRow = {
    SQL"""insert into "sales"."shoppingcartitem"("shoppingcartitemid", "shoppingcartid", "quantity", "productid", "datecreated", "modifieddate")
          values (
            ${ParameterValue(unsaved.shoppingcartitemid, null, ShoppingcartitemId.toStatement)}::int4,
            ${ParameterValue(unsaved.shoppingcartid, null, ToStatement.stringToStatement)},
            ${ParameterValue(unsaved.quantity, null, ToStatement.intToStatement)}::int4,
            ${ParameterValue(unsaved.productid, null, ProductId.toStatement)}::int4,
            ${ParameterValue(unsaved.datecreated, null, TypoLocalDateTime.toStatement)}::timestamp,
            ${ParameterValue(unsaved.modifieddate, null, TypoLocalDateTime.toStatement)}::timestamp
          )
          on conflict ("shoppingcartitemid")
          do update set
            "shoppingcartid" = EXCLUDED."shoppingcartid",
            "quantity" = EXCLUDED."quantity",
            "productid" = EXCLUDED."productid",
            "datecreated" = EXCLUDED."datecreated",
            "modifieddate" = EXCLUDED."modifieddate"
          returning "shoppingcartitemid", "shoppingcartid", "quantity", "productid", "datecreated"::text, "modifieddate"::text
       """
      .executeInsert(ShoppingcartitemRow.rowParser(1).single)
    
  }
  override def upsertBatch(unsaved: Iterable[ShoppingcartitemRow])(implicit c: Connection): List[ShoppingcartitemRow] = {
    def toNamedParameter(row: ShoppingcartitemRow): List[NamedParameter] = List(
      NamedParameter("shoppingcartitemid", ParameterValue(row.shoppingcartitemid, null, ShoppingcartitemId.toStatement)),
      NamedParameter("shoppingcartid", ParameterValue(row.shoppingcartid, null, ToStatement.stringToStatement)),
      NamedParameter("quantity", ParameterValue(row.quantity, null, ToStatement.intToStatement)),
      NamedParameter("productid", ParameterValue(row.productid, null, ProductId.toStatement)),
      NamedParameter("datecreated", ParameterValue(row.datecreated, null, TypoLocalDateTime.toStatement)),
      NamedParameter("modifieddate", ParameterValue(row.modifieddate, null, TypoLocalDateTime.toStatement))
    )
    unsaved.toList match {
      case Nil => Nil
      case head :: rest =>
        new anorm.adventureworks.ExecuteReturningSyntax.Ops(
          BatchSql(
            s"""insert into "sales"."shoppingcartitem"("shoppingcartitemid", "shoppingcartid", "quantity", "productid", "datecreated", "modifieddate")
                values ({shoppingcartitemid}::int4, {shoppingcartid}, {quantity}::int4, {productid}::int4, {datecreated}::timestamp, {modifieddate}::timestamp)
                on conflict ("shoppingcartitemid")
                do update set
                  "shoppingcartid" = EXCLUDED."shoppingcartid",
                  "quantity" = EXCLUDED."quantity",
                  "productid" = EXCLUDED."productid",
                  "datecreated" = EXCLUDED."datecreated",
                  "modifieddate" = EXCLUDED."modifieddate"
                returning "shoppingcartitemid", "shoppingcartid", "quantity", "productid", "datecreated"::text, "modifieddate"::text
             """,
            toNamedParameter(head),
            rest.map(toNamedParameter)*
          )
        ).executeReturning(ShoppingcartitemRow.rowParser(1).*)
    }
  }
  /* NOTE: this functionality is not safe if you use auto-commit mode! it runs 3 SQL statements */
  override def upsertStreaming(unsaved: Iterator[ShoppingcartitemRow], batchSize: Int = 10000)(implicit c: Connection): Int = {
    SQL"""create temporary table shoppingcartitem_TEMP (like "sales"."shoppingcartitem") on commit drop""".execute(): @nowarn
    streamingInsert(s"""copy shoppingcartitem_TEMP("shoppingcartitemid", "shoppingcartid", "quantity", "productid", "datecreated", "modifieddate") from stdin""", batchSize, unsaved)(ShoppingcartitemRow.text, c): @nowarn
    SQL"""insert into "sales"."shoppingcartitem"("shoppingcartitemid", "shoppingcartid", "quantity", "productid", "datecreated", "modifieddate")
          select * from shoppingcartitem_TEMP
          on conflict ("shoppingcartitemid")
          do update set
            "shoppingcartid" = EXCLUDED."shoppingcartid",
            "quantity" = EXCLUDED."quantity",
            "productid" = EXCLUDED."productid",
            "datecreated" = EXCLUDED."datecreated",
            "modifieddate" = EXCLUDED."modifieddate"
          ;
          drop table shoppingcartitem_TEMP;""".executeUpdate()
  }
}
