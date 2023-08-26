/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package salesreason

import adventureworks.customtypes.Defaulted
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.public.Name
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

object SalesreasonRepoImpl extends SalesreasonRepo {
  override def delete(salesreasonid: SalesreasonId)(implicit c: Connection): Boolean = {
    SQL"delete from sales.salesreason where salesreasonid = ${ParameterValue(salesreasonid, null, SalesreasonId.toStatement)}".executeUpdate() > 0
  }
  override def delete: DeleteBuilder[SalesreasonFields, SalesreasonRow] = {
    DeleteBuilder("sales.salesreason", SalesreasonFields)
  }
  override def insert(unsaved: SalesreasonRow)(implicit c: Connection): SalesreasonRow = {
    SQL"""insert into sales.salesreason(salesreasonid, "name", reasontype, modifieddate)
          values (${ParameterValue(unsaved.salesreasonid, null, SalesreasonId.toStatement)}::int4, ${ParameterValue(unsaved.name, null, Name.toStatement)}::varchar, ${ParameterValue(unsaved.reasontype, null, Name.toStatement)}::varchar, ${ParameterValue(unsaved.modifieddate, null, TypoLocalDateTime.toStatement)}::timestamp)
          returning salesreasonid, "name", reasontype, modifieddate::text
       """
      .executeInsert(SalesreasonRow.rowParser(1).single)
    
  }
  override def insert(unsaved: SalesreasonRowUnsaved)(implicit c: Connection): SalesreasonRow = {
    val namedParameters = List(
      Some((NamedParameter("name", ParameterValue(unsaved.name, null, Name.toStatement)), "::varchar")),
      Some((NamedParameter("reasontype", ParameterValue(unsaved.reasontype, null, Name.toStatement)), "::varchar")),
      unsaved.salesreasonid match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("salesreasonid", ParameterValue(value, null, SalesreasonId.toStatement)), "::int4"))
      },
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("modifieddate", ParameterValue(value, null, TypoLocalDateTime.toStatement)), "::timestamp"))
      }
    ).flatten
    val quote = '"'.toString
    if (namedParameters.isEmpty) {
      SQL"""insert into sales.salesreason default values
            returning salesreasonid, "name", reasontype, modifieddate::text
         """
        .executeInsert(SalesreasonRow.rowParser(1).single)
    } else {
      val q = s"""insert into sales.salesreason(${namedParameters.map{case (x, _) => quote + x.name + quote}.mkString(", ")})
                  values (${namedParameters.map{ case (np, cast) => s"{${np.name}}$cast"}.mkString(", ")})
                  returning salesreasonid, "name", reasontype, modifieddate::text
               """
      SimpleSql(SQL(q), namedParameters.map { case (np, _) => np.tupled }.toMap, RowParser.successful)
        .executeInsert(SalesreasonRow.rowParser(1).single)
    }
    
  }
  override def select: SelectBuilder[SalesreasonFields, SalesreasonRow] = {
    SelectBuilderSql("sales.salesreason", SalesreasonFields, SalesreasonRow.rowParser)
  }
  override def selectAll(implicit c: Connection): List[SalesreasonRow] = {
    SQL"""select salesreasonid, "name", reasontype, modifieddate::text
          from sales.salesreason
       """.as(SalesreasonRow.rowParser(1).*)
  }
  override def selectById(salesreasonid: SalesreasonId)(implicit c: Connection): Option[SalesreasonRow] = {
    SQL"""select salesreasonid, "name", reasontype, modifieddate::text
          from sales.salesreason
          where salesreasonid = ${ParameterValue(salesreasonid, null, SalesreasonId.toStatement)}
       """.as(SalesreasonRow.rowParser(1).singleOpt)
  }
  override def selectByIds(salesreasonids: Array[SalesreasonId])(implicit c: Connection): List[SalesreasonRow] = {
    SQL"""select salesreasonid, "name", reasontype, modifieddate::text
          from sales.salesreason
          where salesreasonid = ANY(${salesreasonids})
       """.as(SalesreasonRow.rowParser(1).*)
    
  }
  override def update(row: SalesreasonRow)(implicit c: Connection): Boolean = {
    val salesreasonid = row.salesreasonid
    SQL"""update sales.salesreason
          set "name" = ${ParameterValue(row.name, null, Name.toStatement)}::varchar,
              reasontype = ${ParameterValue(row.reasontype, null, Name.toStatement)}::varchar,
              modifieddate = ${ParameterValue(row.modifieddate, null, TypoLocalDateTime.toStatement)}::timestamp
          where salesreasonid = ${ParameterValue(salesreasonid, null, SalesreasonId.toStatement)}
       """.executeUpdate() > 0
  }
  override def update: UpdateBuilder[SalesreasonFields, SalesreasonRow] = {
    UpdateBuilder("sales.salesreason", SalesreasonFields, SalesreasonRow.rowParser)
  }
  override def upsert(unsaved: SalesreasonRow)(implicit c: Connection): SalesreasonRow = {
    SQL"""insert into sales.salesreason(salesreasonid, "name", reasontype, modifieddate)
          values (
            ${ParameterValue(unsaved.salesreasonid, null, SalesreasonId.toStatement)}::int4,
            ${ParameterValue(unsaved.name, null, Name.toStatement)}::varchar,
            ${ParameterValue(unsaved.reasontype, null, Name.toStatement)}::varchar,
            ${ParameterValue(unsaved.modifieddate, null, TypoLocalDateTime.toStatement)}::timestamp
          )
          on conflict (salesreasonid)
          do update set
            "name" = EXCLUDED."name",
            reasontype = EXCLUDED.reasontype,
            modifieddate = EXCLUDED.modifieddate
          returning salesreasonid, "name", reasontype, modifieddate::text
       """
      .executeInsert(SalesreasonRow.rowParser(1).single)
    
  }
}
