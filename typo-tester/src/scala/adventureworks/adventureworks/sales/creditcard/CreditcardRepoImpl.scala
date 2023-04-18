/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package creditcard

import adventureworks.Defaulted
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

object CreditcardRepoImpl extends CreditcardRepo {
  override def delete(creditcardid: CreditcardId)(implicit c: Connection): Boolean = {
    SQL"""delete from sales.creditcard where creditcardid = $creditcardid""".executeUpdate() > 0
  }
  override def insert(unsaved: CreditcardRowUnsaved)(implicit c: Connection): CreditcardId = {
    val namedParameters = List(
      Some(NamedParameter("cardtype", ParameterValue.from(unsaved.cardtype))),
      Some(NamedParameter("cardnumber", ParameterValue.from(unsaved.cardnumber))),
      Some(NamedParameter("expmonth", ParameterValue.from(unsaved.expmonth))),
      Some(NamedParameter("expyear", ParameterValue.from(unsaved.expyear))),
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some(NamedParameter("modifieddate", ParameterValue.from[LocalDateTime](value)))
      }
    ).flatten
    
    SQL"""insert into sales.creditcard(${namedParameters.map(_.name).mkString(", ")})
          values (${namedParameters.map(np => s"{${np.name}}").mkString(", ")})
          returning creditcardid
    """
      .on(namedParameters :_*)
      .executeInsert(idRowParser.single)
  
  }
  override def selectAll(implicit c: Connection): List[CreditcardRow] = {
    SQL"""select creditcardid, cardtype, cardnumber, expmonth, expyear, modifieddate from sales.creditcard""".as(rowParser.*)
  }
  override def selectByFieldValues(fieldValues: List[CreditcardFieldOrIdValue[_]])(implicit c: Connection): List[CreditcardRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case CreditcardFieldValue.creditcardid(value) => NamedParameter("creditcardid", ParameterValue.from(value))
          case CreditcardFieldValue.cardtype(value) => NamedParameter("cardtype", ParameterValue.from(value))
          case CreditcardFieldValue.cardnumber(value) => NamedParameter("cardnumber", ParameterValue.from(value))
          case CreditcardFieldValue.expmonth(value) => NamedParameter("expmonth", ParameterValue.from(value))
          case CreditcardFieldValue.expyear(value) => NamedParameter("expyear", ParameterValue.from(value))
          case CreditcardFieldValue.modifieddate(value) => NamedParameter("modifieddate", ParameterValue.from(value))
        }
        val q = s"""select * from sales.creditcard where ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(" AND ")}"""
        // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
        import anorm._
        SQL(q)
          .on(namedParams: _*)
          .as(rowParser.*)
    }
  
  }
  override def selectById(creditcardid: CreditcardId)(implicit c: Connection): Option[CreditcardRow] = {
    SQL"""select creditcardid, cardtype, cardnumber, expmonth, expyear, modifieddate from sales.creditcard where creditcardid = $creditcardid""".as(rowParser.singleOpt)
  }
  override def selectByIds(creditcardids: Array[CreditcardId])(implicit c: Connection): List[CreditcardRow] = {
    implicit val arrayToSql: ToSql[Array[CreditcardId]] = _ => ("?", 1) // fix wrong instance from anorm
    implicit val toStatement: ToStatement[Array[CreditcardId]] =
      (s: PreparedStatement, index: Int, v: Array[CreditcardId]) =>
        s.setArray(index, s.getConnection.createArrayOf("int4", v.map(x => x.value: Integer)))
    
    SQL"""select creditcardid, cardtype, cardnumber, expmonth, expyear, modifieddate from sales.creditcard where creditcardid = ANY($creditcardids)""".as(rowParser.*)
  
  }
  override def update(row: CreditcardRow)(implicit c: Connection): Boolean = {
    val creditcardid = row.creditcardid
    SQL"""update sales.creditcard
          set cardtype = ${row.cardtype},
              cardnumber = ${row.cardnumber},
              expmonth = ${row.expmonth},
              expyear = ${row.expyear},
              modifieddate = ${row.modifieddate}
          where creditcardid = $creditcardid""".executeUpdate() > 0
  }
  override def updateFieldValues(creditcardid: CreditcardId, fieldValues: List[CreditcardFieldValue[_]])(implicit c: Connection): Boolean = {
    fieldValues match {
      case Nil => false
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case CreditcardFieldValue.cardtype(value) => NamedParameter("cardtype", ParameterValue.from(value))
          case CreditcardFieldValue.cardnumber(value) => NamedParameter("cardnumber", ParameterValue.from(value))
          case CreditcardFieldValue.expmonth(value) => NamedParameter("expmonth", ParameterValue.from(value))
          case CreditcardFieldValue.expyear(value) => NamedParameter("expyear", ParameterValue.from(value))
          case CreditcardFieldValue.modifieddate(value) => NamedParameter("modifieddate", ParameterValue.from(value))
        }
        val q = s"""update sales.creditcard
                    set ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(", ")}
                    where creditcardid = $creditcardid"""
        // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
        import anorm._
        SQL(q)
          .on(namedParams: _*)
          .executeUpdate() > 0
    }
  
  }
  val rowParser: RowParser[CreditcardRow] =
    RowParser[CreditcardRow] { row =>
      Success(
        CreditcardRow(
          creditcardid = row[CreditcardId]("creditcardid"),
          cardtype = row[String]("cardtype"),
          cardnumber = row[String]("cardnumber"),
          expmonth = row[Int]("expmonth"),
          expyear = row[Int]("expyear"),
          modifieddate = row[LocalDateTime]("modifieddate")
        )
      )
    }
  val idRowParser: RowParser[CreditcardId] =
    SqlParser.get[CreditcardId]("creditcardid")
}
