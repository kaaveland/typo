/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package purchasing
package productvendor

import adventureworks.Defaulted
import adventureworks.person.businessentity.BusinessentityId
import adventureworks.production.product.ProductId
import adventureworks.production.unitmeasure.UnitmeasureId
import anorm.NamedParameter
import anorm.ParameterValue
import anorm.RowParser
import anorm.SqlStringInterpolation
import anorm.Success
import java.sql.Connection
import java.time.LocalDateTime

object ProductvendorRepoImpl extends ProductvendorRepo {
  override def delete(compositeId: ProductvendorId)(implicit c: Connection): Boolean = {
    SQL"delete from purchasing.productvendor where productid = ${compositeId.productid} AND businessentityid = ${compositeId.businessentityid}".executeUpdate() > 0
  }
  override def insert(unsaved: ProductvendorRow)(implicit c: Connection): ProductvendorRow = {
    SQL"""insert into purchasing.productvendor(productid, businessentityid, averageleadtime, standardprice, lastreceiptcost, lastreceiptdate, minorderqty, maxorderqty, onorderqty, unitmeasurecode, modifieddate)
          values (${unsaved.productid}::int4, ${unsaved.businessentityid}::int4, ${unsaved.averageleadtime}::int4, ${unsaved.standardprice}::numeric, ${unsaved.lastreceiptcost}::numeric, ${unsaved.lastreceiptdate}::timestamp, ${unsaved.minorderqty}::int4, ${unsaved.maxorderqty}::int4, ${unsaved.onorderqty}::int4, ${unsaved.unitmeasurecode}::bpchar, ${unsaved.modifieddate}::timestamp)
          returning productid, businessentityid, averageleadtime, standardprice, lastreceiptcost, lastreceiptdate, minorderqty, maxorderqty, onorderqty, unitmeasurecode, modifieddate
       """
      .executeInsert(rowParser.single)
  
  }
  override def insert(unsaved: ProductvendorRowUnsaved)(implicit c: Connection): ProductvendorRow = {
    val namedParameters = List(
      Some((NamedParameter("productid", ParameterValue.from(unsaved.productid)), "::int4")),
      Some((NamedParameter("businessentityid", ParameterValue.from(unsaved.businessentityid)), "::int4")),
      Some((NamedParameter("averageleadtime", ParameterValue.from(unsaved.averageleadtime)), "::int4")),
      Some((NamedParameter("standardprice", ParameterValue.from(unsaved.standardprice)), "::numeric")),
      Some((NamedParameter("lastreceiptcost", ParameterValue.from(unsaved.lastreceiptcost)), "::numeric")),
      Some((NamedParameter("lastreceiptdate", ParameterValue.from(unsaved.lastreceiptdate)), "::timestamp")),
      Some((NamedParameter("minorderqty", ParameterValue.from(unsaved.minorderqty)), "::int4")),
      Some((NamedParameter("maxorderqty", ParameterValue.from(unsaved.maxorderqty)), "::int4")),
      Some((NamedParameter("onorderqty", ParameterValue.from(unsaved.onorderqty)), "::int4")),
      Some((NamedParameter("unitmeasurecode", ParameterValue.from(unsaved.unitmeasurecode)), "::bpchar")),
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("modifieddate", ParameterValue.from[LocalDateTime](value)), "::timestamp"))
      }
    ).flatten
    val quote = '"'.toString
    if (namedParameters.isEmpty) {
      SQL"""insert into purchasing.productvendor default values
            returning productid, businessentityid, averageleadtime, standardprice, lastreceiptcost, lastreceiptdate, minorderqty, maxorderqty, onorderqty, unitmeasurecode, modifieddate
         """
        .executeInsert(rowParser.single)
    } else {
      val q = s"""insert into purchasing.productvendor(${namedParameters.map{case (x, _) => quote + x.name + quote}.mkString(", ")})
                  values (${namedParameters.map{ case (np, cast) => s"{${np.name}}$cast"}.mkString(", ")})
                  returning productid, businessentityid, averageleadtime, standardprice, lastreceiptcost, lastreceiptdate, minorderqty, maxorderqty, onorderqty, unitmeasurecode, modifieddate
               """
      // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
      import anorm._
      SQL(q)
        .on(namedParameters.map(_._1) :_*)
        .executeInsert(rowParser.single)
    }
  
  }
  override def selectAll(implicit c: Connection): List[ProductvendorRow] = {
    SQL"""select productid, businessentityid, averageleadtime, standardprice, lastreceiptcost, lastreceiptdate, minorderqty, maxorderqty, onorderqty, unitmeasurecode, modifieddate
          from purchasing.productvendor
       """.as(rowParser.*)
  }
  override def selectByFieldValues(fieldValues: List[ProductvendorFieldOrIdValue[_]])(implicit c: Connection): List[ProductvendorRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case ProductvendorFieldValue.productid(value) => NamedParameter("productid", ParameterValue.from(value))
          case ProductvendorFieldValue.businessentityid(value) => NamedParameter("businessentityid", ParameterValue.from(value))
          case ProductvendorFieldValue.averageleadtime(value) => NamedParameter("averageleadtime", ParameterValue.from(value))
          case ProductvendorFieldValue.standardprice(value) => NamedParameter("standardprice", ParameterValue.from(value))
          case ProductvendorFieldValue.lastreceiptcost(value) => NamedParameter("lastreceiptcost", ParameterValue.from(value))
          case ProductvendorFieldValue.lastreceiptdate(value) => NamedParameter("lastreceiptdate", ParameterValue.from(value))
          case ProductvendorFieldValue.minorderqty(value) => NamedParameter("minorderqty", ParameterValue.from(value))
          case ProductvendorFieldValue.maxorderqty(value) => NamedParameter("maxorderqty", ParameterValue.from(value))
          case ProductvendorFieldValue.onorderqty(value) => NamedParameter("onorderqty", ParameterValue.from(value))
          case ProductvendorFieldValue.unitmeasurecode(value) => NamedParameter("unitmeasurecode", ParameterValue.from(value))
          case ProductvendorFieldValue.modifieddate(value) => NamedParameter("modifieddate", ParameterValue.from(value))
        }
        val quote = '"'.toString
        val q = s"""select productid, businessentityid, averageleadtime, standardprice, lastreceiptcost, lastreceiptdate, minorderqty, maxorderqty, onorderqty, unitmeasurecode, modifieddate
                    from purchasing.productvendor
                    where ${namedParams.map(x => s"$quote${x.name}$quote = {${x.name}}").mkString(" AND ")}
                 """
        // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
        import anorm._
        SQL(q)
          .on(namedParams: _*)
          .as(rowParser.*)
    }
  
  }
  override def selectById(compositeId: ProductvendorId)(implicit c: Connection): Option[ProductvendorRow] = {
    SQL"""select productid, businessentityid, averageleadtime, standardprice, lastreceiptcost, lastreceiptdate, minorderqty, maxorderqty, onorderqty, unitmeasurecode, modifieddate
          from purchasing.productvendor
          where productid = ${compositeId.productid} AND businessentityid = ${compositeId.businessentityid}
       """.as(rowParser.singleOpt)
  }
  override def update(row: ProductvendorRow)(implicit c: Connection): Boolean = {
    val compositeId = row.compositeId
    SQL"""update purchasing.productvendor
          set averageleadtime = ${row.averageleadtime}::int4,
              standardprice = ${row.standardprice}::numeric,
              lastreceiptcost = ${row.lastreceiptcost}::numeric,
              lastreceiptdate = ${row.lastreceiptdate}::timestamp,
              minorderqty = ${row.minorderqty}::int4,
              maxorderqty = ${row.maxorderqty}::int4,
              onorderqty = ${row.onorderqty}::int4,
              unitmeasurecode = ${row.unitmeasurecode}::bpchar,
              modifieddate = ${row.modifieddate}::timestamp
          where productid = ${compositeId.productid} AND businessentityid = ${compositeId.businessentityid}
       """.executeUpdate() > 0
  }
  override def updateFieldValues(compositeId: ProductvendorId, fieldValues: List[ProductvendorFieldValue[_]])(implicit c: Connection): Boolean = {
    fieldValues match {
      case Nil => false
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case ProductvendorFieldValue.averageleadtime(value) => NamedParameter("averageleadtime", ParameterValue.from(value))
          case ProductvendorFieldValue.standardprice(value) => NamedParameter("standardprice", ParameterValue.from(value))
          case ProductvendorFieldValue.lastreceiptcost(value) => NamedParameter("lastreceiptcost", ParameterValue.from(value))
          case ProductvendorFieldValue.lastreceiptdate(value) => NamedParameter("lastreceiptdate", ParameterValue.from(value))
          case ProductvendorFieldValue.minorderqty(value) => NamedParameter("minorderqty", ParameterValue.from(value))
          case ProductvendorFieldValue.maxorderqty(value) => NamedParameter("maxorderqty", ParameterValue.from(value))
          case ProductvendorFieldValue.onorderqty(value) => NamedParameter("onorderqty", ParameterValue.from(value))
          case ProductvendorFieldValue.unitmeasurecode(value) => NamedParameter("unitmeasurecode", ParameterValue.from(value))
          case ProductvendorFieldValue.modifieddate(value) => NamedParameter("modifieddate", ParameterValue.from(value))
        }
        val quote = '"'.toString
        val q = s"""update purchasing.productvendor
                    set ${namedParams.map(x => s"$quote${x.name}$quote = {${x.name}}").mkString(", ")}
                    where productid = {productid} AND businessentityid = {businessentityid}
                 """
        // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
        import anorm._
        SQL(q)
          .on(namedParams: _*)
          .on(NamedParameter("productid", ParameterValue.from(compositeId.productid)), NamedParameter("businessentityid", ParameterValue.from(compositeId.businessentityid)))
          .executeUpdate() > 0
    }
  
  }
  override def upsert(unsaved: ProductvendorRow)(implicit c: Connection): ProductvendorRow = {
    SQL"""insert into purchasing.productvendor(productid, businessentityid, averageleadtime, standardprice, lastreceiptcost, lastreceiptdate, minorderqty, maxorderqty, onorderqty, unitmeasurecode, modifieddate)
          values (
            ${unsaved.productid}::int4,
            ${unsaved.businessentityid}::int4,
            ${unsaved.averageleadtime}::int4,
            ${unsaved.standardprice}::numeric,
            ${unsaved.lastreceiptcost}::numeric,
            ${unsaved.lastreceiptdate}::timestamp,
            ${unsaved.minorderqty}::int4,
            ${unsaved.maxorderqty}::int4,
            ${unsaved.onorderqty}::int4,
            ${unsaved.unitmeasurecode}::bpchar,
            ${unsaved.modifieddate}::timestamp
          )
          on conflict (productid, businessentityid)
          do update set
            averageleadtime = EXCLUDED.averageleadtime,
            standardprice = EXCLUDED.standardprice,
            lastreceiptcost = EXCLUDED.lastreceiptcost,
            lastreceiptdate = EXCLUDED.lastreceiptdate,
            minorderqty = EXCLUDED.minorderqty,
            maxorderqty = EXCLUDED.maxorderqty,
            onorderqty = EXCLUDED.onorderqty,
            unitmeasurecode = EXCLUDED.unitmeasurecode,
            modifieddate = EXCLUDED.modifieddate
          returning productid, businessentityid, averageleadtime, standardprice, lastreceiptcost, lastreceiptdate, minorderqty, maxorderqty, onorderqty, unitmeasurecode, modifieddate
       """
      .executeInsert(rowParser.single)
  
  }
  val rowParser: RowParser[ProductvendorRow] =
    RowParser[ProductvendorRow] { row =>
      Success(
        ProductvendorRow(
          productid = row[ProductId]("productid"),
          businessentityid = row[BusinessentityId]("businessentityid"),
          averageleadtime = row[Int]("averageleadtime"),
          standardprice = row[BigDecimal]("standardprice"),
          lastreceiptcost = row[Option[BigDecimal]]("lastreceiptcost"),
          lastreceiptdate = row[Option[LocalDateTime]]("lastreceiptdate"),
          minorderqty = row[Int]("minorderqty"),
          maxorderqty = row[Int]("maxorderqty"),
          onorderqty = row[Option[Int]]("onorderqty"),
          unitmeasurecode = row[UnitmeasureId]("unitmeasurecode"),
          modifieddate = row[LocalDateTime]("modifieddate")
        )
      )
    }
}