/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package person
package phonenumbertype

import adventureworks.Defaulted
import adventureworks.public.Name
import anorm.NamedParameter
import anorm.ParameterValue
import anorm.RowParser
import anorm.SqlParser
import anorm.SqlStringInterpolation
import anorm.Success
import anorm.ToSql
import anorm.ToStatement
import java.lang.Integer
import java.sql.Connection
import java.sql.PreparedStatement
import java.time.LocalDateTime

object PhonenumbertypeRepoImpl extends PhonenumbertypeRepo {
  override def delete(phonenumbertypeid: PhonenumbertypeId)(implicit c: Connection): Boolean = {
    SQL"""delete from person.phonenumbertype where phonenumbertypeid = $phonenumbertypeid""".executeUpdate() > 0
  }
  override def insert(unsaved: PhonenumbertypeRowUnsaved)(implicit c: Connection): PhonenumbertypeId = {
    val namedParameters = List(
      Some(NamedParameter("name", ParameterValue.from(unsaved.name))),
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some(NamedParameter("modifieddate", ParameterValue.from[LocalDateTime](value)))
      }
    ).flatten
    
    SQL"""insert into person.phonenumbertype(${namedParameters.map(_.name).mkString(", ")})
          values (${namedParameters.map(np => s"{${np.name}}").mkString(", ")})
          returning phonenumbertypeid
    """
      .on(namedParameters :_*)
      .executeInsert(idRowParser.single)
  
  }
  override def selectAll(implicit c: Connection): List[PhonenumbertypeRow] = {
    SQL"""select phonenumbertypeid, name, modifieddate from person.phonenumbertype""".as(rowParser.*)
  }
  override def selectByFieldValues(fieldValues: List[PhonenumbertypeFieldOrIdValue[_]])(implicit c: Connection): List[PhonenumbertypeRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case PhonenumbertypeFieldValue.phonenumbertypeid(value) => NamedParameter("phonenumbertypeid", ParameterValue.from(value))
          case PhonenumbertypeFieldValue.name(value) => NamedParameter("name", ParameterValue.from(value))
          case PhonenumbertypeFieldValue.modifieddate(value) => NamedParameter("modifieddate", ParameterValue.from(value))
        }
        val q = s"""select * from person.phonenumbertype where ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(" AND ")}"""
        // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
        import anorm._
        SQL(q)
          .on(namedParams: _*)
          .as(rowParser.*)
    }
  
  }
  override def selectById(phonenumbertypeid: PhonenumbertypeId)(implicit c: Connection): Option[PhonenumbertypeRow] = {
    SQL"""select phonenumbertypeid, name, modifieddate from person.phonenumbertype where phonenumbertypeid = $phonenumbertypeid""".as(rowParser.singleOpt)
  }
  override def selectByIds(phonenumbertypeids: Array[PhonenumbertypeId])(implicit c: Connection): List[PhonenumbertypeRow] = {
    implicit val arrayToSql: ToSql[Array[PhonenumbertypeId]] = _ => ("?", 1) // fix wrong instance from anorm
    implicit val toStatement: ToStatement[Array[PhonenumbertypeId]] =
      (s: PreparedStatement, index: Int, v: Array[PhonenumbertypeId]) =>
        s.setArray(index, s.getConnection.createArrayOf("int4", v.map(x => x.value: Integer)))
    
    SQL"""select phonenumbertypeid, name, modifieddate from person.phonenumbertype where phonenumbertypeid = ANY($phonenumbertypeids)""".as(rowParser.*)
  
  }
  override def update(row: PhonenumbertypeRow)(implicit c: Connection): Boolean = {
    val phonenumbertypeid = row.phonenumbertypeid
    SQL"""update person.phonenumbertype
          set name = ${row.name},
              modifieddate = ${row.modifieddate}
          where phonenumbertypeid = $phonenumbertypeid""".executeUpdate() > 0
  }
  override def updateFieldValues(phonenumbertypeid: PhonenumbertypeId, fieldValues: List[PhonenumbertypeFieldValue[_]])(implicit c: Connection): Boolean = {
    fieldValues match {
      case Nil => false
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case PhonenumbertypeFieldValue.name(value) => NamedParameter("name", ParameterValue.from(value))
          case PhonenumbertypeFieldValue.modifieddate(value) => NamedParameter("modifieddate", ParameterValue.from(value))
        }
        val q = s"""update person.phonenumbertype
                    set ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(", ")}
                    where phonenumbertypeid = $phonenumbertypeid"""
        // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
        import anorm._
        SQL(q)
          .on(namedParams: _*)
          .executeUpdate() > 0
    }
  
  }
  val rowParser: RowParser[PhonenumbertypeRow] =
    RowParser[PhonenumbertypeRow] { row =>
      Success(
        PhonenumbertypeRow(
          phonenumbertypeid = row[PhonenumbertypeId]("phonenumbertypeid"),
          name = row[Name]("name"),
          modifieddate = row[LocalDateTime]("modifieddate")
        )
      )
    }
  val idRowParser: RowParser[PhonenumbertypeId] =
    SqlParser.get[PhonenumbertypeId]("phonenumbertypeid")
}
