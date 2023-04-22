/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package person
package countryregion

import adventureworks.Defaulted
import adventureworks.public.Name
import anorm.NamedParameter
import anorm.ParameterValue
import anorm.RowParser
import anorm.SqlStringInterpolation
import anorm.Success
import anorm.ToSql
import anorm.ToStatement
import java.sql.Connection
import java.sql.PreparedStatement
import java.time.LocalDateTime

object CountryregionRepoImpl extends CountryregionRepo {
  override def delete(countryregioncode: CountryregionId)(implicit c: Connection): Boolean = {
    SQL"delete from person.countryregion where countryregioncode = $countryregioncode".executeUpdate() > 0
  }
  override def insert(countryregioncode: CountryregionId, unsaved: CountryregionRowUnsaved)(implicit c: Connection): CountryregionRow = {
    val namedParameters = List(
      Some((NamedParameter("name", ParameterValue.from(unsaved.name)), """::"public"."Name"""")),
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("modifieddate", ParameterValue.from[LocalDateTime](value)), "::timestamp"))
      }
    ).flatten
    val q = s"""insert into person.countryregion(countryregioncode, ${namedParameters.map(_._1.name).mkString(", ")})
                values ({countryregioncode}, ${namedParameters.map{case (np, cast) => s"{${np.name}}$cast"}.mkString(", ")})
                returning countryregioncode, "name", modifieddate
             """
    // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
    import anorm._
    SQL(q)
      .on(namedParameters.map(_._1) :_*)
      .on(NamedParameter("countryregioncode", ParameterValue.from(countryregioncode)))
      .executeInsert(rowParser.single)
  
  }
  override def selectAll(implicit c: Connection): List[CountryregionRow] = {
    SQL"""select countryregioncode, "name", modifieddate
          from person.countryregion
       """.as(rowParser.*)
  }
  override def selectByFieldValues(fieldValues: List[CountryregionFieldOrIdValue[_]])(implicit c: Connection): List[CountryregionRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case CountryregionFieldValue.countryregioncode(value) => NamedParameter("countryregioncode", ParameterValue.from(value))
          case CountryregionFieldValue.name(value) => NamedParameter("name", ParameterValue.from(value))
          case CountryregionFieldValue.modifieddate(value) => NamedParameter("modifieddate", ParameterValue.from(value))
        }
        val q = s"""select countryregioncode, "name", modifieddate
                    from person.countryregion
                    where ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(" AND ")}
                 """
        // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
        import anorm._
        SQL(q)
          .on(namedParams: _*)
          .as(rowParser.*)
    }
  
  }
  override def selectById(countryregioncode: CountryregionId)(implicit c: Connection): Option[CountryregionRow] = {
    SQL"""select countryregioncode, "name", modifieddate
          from person.countryregion
          where countryregioncode = $countryregioncode
       """.as(rowParser.singleOpt)
  }
  override def selectByIds(countryregioncodes: Array[CountryregionId])(implicit c: Connection): List[CountryregionRow] = {
    implicit val arrayToSql: ToSql[Array[CountryregionId]] = _ => ("?", 1) // fix wrong instance from anorm
    implicit val toStatement: ToStatement[Array[CountryregionId]] =
      (s: PreparedStatement, index: Int, v: Array[CountryregionId]) =>
        s.setArray(index, s.getConnection.createArrayOf("varchar", v.map(x => x.value)))
    
    SQL"""select countryregioncode, "name", modifieddate
          from person.countryregion
          where countryregioncode = ANY($countryregioncodes)
       """.as(rowParser.*)
  
  }
  override def update(row: CountryregionRow)(implicit c: Connection): Boolean = {
    val countryregioncode = row.countryregioncode
    SQL"""update person.countryregion
          set "name" = ${row.name},
              modifieddate = ${row.modifieddate}
          where countryregioncode = $countryregioncode
       """.executeUpdate() > 0
  }
  override def updateFieldValues(countryregioncode: CountryregionId, fieldValues: List[CountryregionFieldValue[_]])(implicit c: Connection): Boolean = {
    fieldValues match {
      case Nil => false
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case CountryregionFieldValue.name(value) => NamedParameter("name", ParameterValue.from(value))
          case CountryregionFieldValue.modifieddate(value) => NamedParameter("modifieddate", ParameterValue.from(value))
        }
        val q = s"""update person.countryregion
                    set ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(", ")}
                    where countryregioncode = {countryregioncode}
                 """
        // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
        import anorm._
        SQL(q)
          .on(namedParams: _*)
          .on(NamedParameter("countryregioncode", ParameterValue.from(countryregioncode)))
          .executeUpdate() > 0
    }
  
  }
  val rowParser: RowParser[CountryregionRow] =
    RowParser[CountryregionRow] { row =>
      Success(
        CountryregionRow(
          countryregioncode = row[CountryregionId]("countryregioncode"),
          name = row[Name]("name"),
          modifieddate = row[LocalDateTime]("modifieddate")
        )
      )
    }
}
