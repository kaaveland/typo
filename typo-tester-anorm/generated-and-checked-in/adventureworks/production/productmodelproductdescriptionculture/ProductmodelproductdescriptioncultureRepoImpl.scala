/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package productmodelproductdescriptionculture

import adventureworks.customtypes.Defaulted
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.production.culture.CultureId
import adventureworks.production.productdescription.ProductdescriptionId
import adventureworks.production.productmodel.ProductmodelId
import adventureworks.streamingInsert
import anorm.NamedParameter
import anorm.ParameterValue
import anorm.RowParser
import anorm.SQL
import anorm.SimpleSql
import anorm.SqlStringInterpolation
import java.sql.Connection
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql
import typo.dsl.UpdateBuilder

class ProductmodelproductdescriptioncultureRepoImpl extends ProductmodelproductdescriptioncultureRepo {
  override def delete: DeleteBuilder[ProductmodelproductdescriptioncultureFields, ProductmodelproductdescriptioncultureRow] = {
    DeleteBuilder("production.productmodelproductdescriptionculture", ProductmodelproductdescriptioncultureFields.structure)
  }
  override def deleteById(compositeId: ProductmodelproductdescriptioncultureId)(implicit c: Connection): Boolean = {
    SQL"""delete from production.productmodelproductdescriptionculture where "productmodelid" = ${ParameterValue(compositeId.productmodelid, null, ProductmodelId.toStatement)} AND "productdescriptionid" = ${ParameterValue(compositeId.productdescriptionid, null, ProductdescriptionId.toStatement)} AND "cultureid" = ${ParameterValue(compositeId.cultureid, null, CultureId.toStatement)}""".executeUpdate() > 0
  }
  override def deleteByIds(compositeIds: Array[ProductmodelproductdescriptioncultureId])(implicit c: Connection): Int = {
    val productmodelid = compositeIds.map(_.productmodelid)
    val productdescriptionid = compositeIds.map(_.productdescriptionid)
    val cultureid = compositeIds.map(_.cultureid)
    SQL"""delete
          from production.productmodelproductdescriptionculture
          where ("productmodelid", "productdescriptionid", "cultureid")
          in (select unnest(${productmodelid}), unnest(${productdescriptionid}), unnest(${cultureid}))
       """.executeUpdate()
    
  }
  override def insert(unsaved: ProductmodelproductdescriptioncultureRow)(implicit c: Connection): ProductmodelproductdescriptioncultureRow = {
    SQL"""insert into production.productmodelproductdescriptionculture("productmodelid", "productdescriptionid", "cultureid", "modifieddate")
          values (${ParameterValue(unsaved.productmodelid, null, ProductmodelId.toStatement)}::int4, ${ParameterValue(unsaved.productdescriptionid, null, ProductdescriptionId.toStatement)}::int4, ${ParameterValue(unsaved.cultureid, null, CultureId.toStatement)}::bpchar, ${ParameterValue(unsaved.modifieddate, null, TypoLocalDateTime.toStatement)}::timestamp)
          returning "productmodelid", "productdescriptionid", "cultureid", "modifieddate"::text
       """
      .executeInsert(ProductmodelproductdescriptioncultureRow.rowParser(1).single)
    
  }
  override def insert(unsaved: ProductmodelproductdescriptioncultureRowUnsaved)(implicit c: Connection): ProductmodelproductdescriptioncultureRow = {
    val namedParameters = List(
      Some((NamedParameter("productmodelid", ParameterValue(unsaved.productmodelid, null, ProductmodelId.toStatement)), "::int4")),
      Some((NamedParameter("productdescriptionid", ParameterValue(unsaved.productdescriptionid, null, ProductdescriptionId.toStatement)), "::int4")),
      Some((NamedParameter("cultureid", ParameterValue(unsaved.cultureid, null, CultureId.toStatement)), "::bpchar")),
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("modifieddate", ParameterValue(value, null, TypoLocalDateTime.toStatement)), "::timestamp"))
      }
    ).flatten
    val quote = '"'.toString
    if (namedParameters.isEmpty) {
      SQL"""insert into production.productmodelproductdescriptionculture default values
            returning "productmodelid", "productdescriptionid", "cultureid", "modifieddate"::text
         """
        .executeInsert(ProductmodelproductdescriptioncultureRow.rowParser(1).single)
    } else {
      val q = s"""insert into production.productmodelproductdescriptionculture(${namedParameters.map{case (x, _) => quote + x.name + quote}.mkString(", ")})
                  values (${namedParameters.map{ case (np, cast) => s"{${np.name}}$cast"}.mkString(", ")})
                  returning "productmodelid", "productdescriptionid", "cultureid", "modifieddate"::text
               """
      SimpleSql(SQL(q), namedParameters.map { case (np, _) => np.tupled }.toMap, RowParser.successful)
        .executeInsert(ProductmodelproductdescriptioncultureRow.rowParser(1).single)
    }
    
  }
  override def insertStreaming(unsaved: Iterator[ProductmodelproductdescriptioncultureRow], batchSize: Int = 10000)(implicit c: Connection): Long = {
    streamingInsert(s"""COPY production.productmodelproductdescriptionculture("productmodelid", "productdescriptionid", "cultureid", "modifieddate") FROM STDIN""", batchSize, unsaved)(ProductmodelproductdescriptioncultureRow.text, c)
  }
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  override def insertUnsavedStreaming(unsaved: Iterator[ProductmodelproductdescriptioncultureRowUnsaved], batchSize: Int = 10000)(implicit c: Connection): Long = {
    streamingInsert(s"""COPY production.productmodelproductdescriptionculture("productmodelid", "productdescriptionid", "cultureid", "modifieddate") FROM STDIN (DEFAULT '__DEFAULT_VALUE__')""", batchSize, unsaved)(ProductmodelproductdescriptioncultureRowUnsaved.text, c)
  }
  override def select: SelectBuilder[ProductmodelproductdescriptioncultureFields, ProductmodelproductdescriptioncultureRow] = {
    SelectBuilderSql("production.productmodelproductdescriptionculture", ProductmodelproductdescriptioncultureFields.structure, ProductmodelproductdescriptioncultureRow.rowParser)
  }
  override def selectAll(implicit c: Connection): List[ProductmodelproductdescriptioncultureRow] = {
    SQL"""select "productmodelid", "productdescriptionid", "cultureid", "modifieddate"::text
          from production.productmodelproductdescriptionculture
       """.as(ProductmodelproductdescriptioncultureRow.rowParser(1).*)
  }
  override def selectById(compositeId: ProductmodelproductdescriptioncultureId)(implicit c: Connection): Option[ProductmodelproductdescriptioncultureRow] = {
    SQL"""select "productmodelid", "productdescriptionid", "cultureid", "modifieddate"::text
          from production.productmodelproductdescriptionculture
          where "productmodelid" = ${ParameterValue(compositeId.productmodelid, null, ProductmodelId.toStatement)} AND "productdescriptionid" = ${ParameterValue(compositeId.productdescriptionid, null, ProductdescriptionId.toStatement)} AND "cultureid" = ${ParameterValue(compositeId.cultureid, null, CultureId.toStatement)}
       """.as(ProductmodelproductdescriptioncultureRow.rowParser(1).singleOpt)
  }
  override def selectByIds(compositeIds: Array[ProductmodelproductdescriptioncultureId])(implicit c: Connection): List[ProductmodelproductdescriptioncultureRow] = {
    val productmodelid = compositeIds.map(_.productmodelid)
    val productdescriptionid = compositeIds.map(_.productdescriptionid)
    val cultureid = compositeIds.map(_.cultureid)
    SQL"""select "productmodelid", "productdescriptionid", "cultureid", "modifieddate"::text
          from production.productmodelproductdescriptionculture
          where ("productmodelid", "productdescriptionid", "cultureid") 
          in (select unnest(${productmodelid}), unnest(${productdescriptionid}), unnest(${cultureid}))
       """.as(ProductmodelproductdescriptioncultureRow.rowParser(1).*)
    
  }
  override def selectByIdsTracked(compositeIds: Array[ProductmodelproductdescriptioncultureId])(implicit c: Connection): Map[ProductmodelproductdescriptioncultureId, ProductmodelproductdescriptioncultureRow] = {
    val byId = selectByIds(compositeIds).view.map(x => (x.compositeId, x)).toMap
    compositeIds.view.flatMap(id => byId.get(id).map(x => (id, x))).toMap
  }
  override def update: UpdateBuilder[ProductmodelproductdescriptioncultureFields, ProductmodelproductdescriptioncultureRow] = {
    UpdateBuilder("production.productmodelproductdescriptionculture", ProductmodelproductdescriptioncultureFields.structure, ProductmodelproductdescriptioncultureRow.rowParser)
  }
  override def update(row: ProductmodelproductdescriptioncultureRow)(implicit c: Connection): Boolean = {
    val compositeId = row.compositeId
    SQL"""update production.productmodelproductdescriptionculture
          set "modifieddate" = ${ParameterValue(row.modifieddate, null, TypoLocalDateTime.toStatement)}::timestamp
          where "productmodelid" = ${ParameterValue(compositeId.productmodelid, null, ProductmodelId.toStatement)} AND "productdescriptionid" = ${ParameterValue(compositeId.productdescriptionid, null, ProductdescriptionId.toStatement)} AND "cultureid" = ${ParameterValue(compositeId.cultureid, null, CultureId.toStatement)}
       """.executeUpdate() > 0
  }
  override def upsert(unsaved: ProductmodelproductdescriptioncultureRow)(implicit c: Connection): ProductmodelproductdescriptioncultureRow = {
    SQL"""insert into production.productmodelproductdescriptionculture("productmodelid", "productdescriptionid", "cultureid", "modifieddate")
          values (
            ${ParameterValue(unsaved.productmodelid, null, ProductmodelId.toStatement)}::int4,
            ${ParameterValue(unsaved.productdescriptionid, null, ProductdescriptionId.toStatement)}::int4,
            ${ParameterValue(unsaved.cultureid, null, CultureId.toStatement)}::bpchar,
            ${ParameterValue(unsaved.modifieddate, null, TypoLocalDateTime.toStatement)}::timestamp
          )
          on conflict ("productmodelid", "productdescriptionid", "cultureid")
          do update set
            "modifieddate" = EXCLUDED."modifieddate"
          returning "productmodelid", "productdescriptionid", "cultureid", "modifieddate"::text
       """
      .executeInsert(ProductmodelproductdescriptioncultureRow.rowParser(1).single)
    
  }
}
