/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package salestaxrate

import adventureworks.Defaulted
import adventureworks.person.stateprovince.StateprovinceId
import adventureworks.public.Name
import anorm.NamedParameter
import anorm.ParameterValue
import anorm.RowParser
import anorm.SqlStringInterpolation
import anorm.Success
import anorm.ToSql
import anorm.ToStatement
import java.lang.Integer
import java.sql.Connection
import java.sql.PreparedStatement
import java.time.LocalDateTime
import java.util.UUID

object SalestaxrateRepoImpl extends SalestaxrateRepo {
  override def delete(salestaxrateid: SalestaxrateId)(implicit c: Connection): Boolean = {
    SQL"delete from sales.salestaxrate where salestaxrateid = $salestaxrateid".executeUpdate() > 0
  }
  override def insert(unsaved: SalestaxrateRowUnsaved)(implicit c: Connection): SalestaxrateRow = {
    val namedParameters = List(
      Some(NamedParameter("stateprovinceid", ParameterValue.from(unsaved.stateprovinceid))),
      Some(NamedParameter("taxtype", ParameterValue.from(unsaved.taxtype))),
      unsaved.taxrate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some(NamedParameter("taxrate", ParameterValue.from[BigDecimal](value)))
      },
      Some(NamedParameter("name", ParameterValue.from(unsaved.name))),
      unsaved.rowguid match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some(NamedParameter("rowguid", ParameterValue.from[UUID](value)))
      },
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some(NamedParameter("modifieddate", ParameterValue.from[LocalDateTime](value)))
      }
    ).flatten
    
    if (namedParameters.isEmpty) {
      SQL"""insert into sales.salestaxrate default values
            returning salestaxrateid, stateprovinceid, taxtype, taxrate, "name", rowguid, modifieddate
         """
        .executeInsert(rowParser.single)
    } else {
      val q = s"""insert into sales.salestaxrate(${namedParameters.map(_.name).mkString(", ")})
                  values (${namedParameters.map(np => s"{${np.name}}").mkString(", ")})
                  returning salestaxrateid, stateprovinceid, taxtype, taxrate, "name", rowguid, modifieddate
               """
      // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
      import anorm._
      SQL(q)
        .on(namedParameters :_*)
        .executeInsert(rowParser.single)
    }
  
  }
  override def selectAll(implicit c: Connection): List[SalestaxrateRow] = {
    SQL"""select salestaxrateid, stateprovinceid, taxtype, taxrate, "name", rowguid, modifieddate
          from sales.salestaxrate
       """.as(rowParser.*)
  }
  override def selectByFieldValues(fieldValues: List[SalestaxrateFieldOrIdValue[_]])(implicit c: Connection): List[SalestaxrateRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case SalestaxrateFieldValue.salestaxrateid(value) => NamedParameter("salestaxrateid", ParameterValue.from(value))
          case SalestaxrateFieldValue.stateprovinceid(value) => NamedParameter("stateprovinceid", ParameterValue.from(value))
          case SalestaxrateFieldValue.taxtype(value) => NamedParameter("taxtype", ParameterValue.from(value))
          case SalestaxrateFieldValue.taxrate(value) => NamedParameter("taxrate", ParameterValue.from(value))
          case SalestaxrateFieldValue.name(value) => NamedParameter("name", ParameterValue.from(value))
          case SalestaxrateFieldValue.rowguid(value) => NamedParameter("rowguid", ParameterValue.from(value))
          case SalestaxrateFieldValue.modifieddate(value) => NamedParameter("modifieddate", ParameterValue.from(value))
        }
        val q = s"""select salestaxrateid, stateprovinceid, taxtype, taxrate, "name", rowguid, modifieddate
                    from sales.salestaxrate
                    where ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(" AND ")}
                 """
        // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
        import anorm._
        SQL(q)
          .on(namedParams: _*)
          .as(rowParser.*)
    }
  
  }
  override def selectById(salestaxrateid: SalestaxrateId)(implicit c: Connection): Option[SalestaxrateRow] = {
    SQL"""select salestaxrateid, stateprovinceid, taxtype, taxrate, "name", rowguid, modifieddate
          from sales.salestaxrate
          where salestaxrateid = $salestaxrateid
       """.as(rowParser.singleOpt)
  }
  override def selectByIds(salestaxrateids: Array[SalestaxrateId])(implicit c: Connection): List[SalestaxrateRow] = {
    implicit val arrayToSql: ToSql[Array[SalestaxrateId]] = _ => ("?", 1) // fix wrong instance from anorm
    implicit val toStatement: ToStatement[Array[SalestaxrateId]] =
      (s: PreparedStatement, index: Int, v: Array[SalestaxrateId]) =>
        s.setArray(index, s.getConnection.createArrayOf("int4", v.map(x => x.value: Integer)))
    
    SQL"""select salestaxrateid, stateprovinceid, taxtype, taxrate, "name", rowguid, modifieddate
          from sales.salestaxrate
          where salestaxrateid = ANY($salestaxrateids)
       """.as(rowParser.*)
  
  }
  override def update(row: SalestaxrateRow)(implicit c: Connection): Boolean = {
    val salestaxrateid = row.salestaxrateid
    SQL"""update sales.salestaxrate
          set stateprovinceid = ${row.stateprovinceid},
              taxtype = ${row.taxtype},
              taxrate = ${row.taxrate},
              "name" = ${row.name},
              rowguid = ${row.rowguid},
              modifieddate = ${row.modifieddate}
          where salestaxrateid = $salestaxrateid
       """.executeUpdate() > 0
  }
  override def updateFieldValues(salestaxrateid: SalestaxrateId, fieldValues: List[SalestaxrateFieldValue[_]])(implicit c: Connection): Boolean = {
    fieldValues match {
      case Nil => false
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case SalestaxrateFieldValue.stateprovinceid(value) => NamedParameter("stateprovinceid", ParameterValue.from(value))
          case SalestaxrateFieldValue.taxtype(value) => NamedParameter("taxtype", ParameterValue.from(value))
          case SalestaxrateFieldValue.taxrate(value) => NamedParameter("taxrate", ParameterValue.from(value))
          case SalestaxrateFieldValue.name(value) => NamedParameter("name", ParameterValue.from(value))
          case SalestaxrateFieldValue.rowguid(value) => NamedParameter("rowguid", ParameterValue.from(value))
          case SalestaxrateFieldValue.modifieddate(value) => NamedParameter("modifieddate", ParameterValue.from(value))
        }
        val q = s"""update sales.salestaxrate
                    set ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(", ")}
                    where salestaxrateid = {salestaxrateid}
                 """
        // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
        import anorm._
        SQL(q)
          .on(namedParams: _*)
          .on(NamedParameter("salestaxrateid", ParameterValue.from(salestaxrateid)))
          .executeUpdate() > 0
    }
  
  }
  val rowParser: RowParser[SalestaxrateRow] =
    RowParser[SalestaxrateRow] { row =>
      Success(
        SalestaxrateRow(
          salestaxrateid = row[SalestaxrateId]("salestaxrateid"),
          stateprovinceid = row[StateprovinceId]("stateprovinceid"),
          taxtype = row[Int]("taxtype"),
          taxrate = row[BigDecimal]("taxrate"),
          name = row[Name]("name"),
          rowguid = row[UUID]("rowguid"),
          modifieddate = row[LocalDateTime]("modifieddate")
        )
      )
    }
}
