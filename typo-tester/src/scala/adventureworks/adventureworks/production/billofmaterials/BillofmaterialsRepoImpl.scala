/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package billofmaterials

import adventureworks.Defaulted.Provided
import adventureworks.Defaulted.UseDefault
import anorm.NamedParameter
import anorm.ParameterValue
import anorm.SqlParser
import anorm.SqlStringInterpolation
import java.sql.Connection
import java.time.LocalDateTime

object BillofmaterialsRepoImpl extends BillofmaterialsRepo {
  override def delete(billofmaterialsid: BillofmaterialsId)(implicit c: Connection): Boolean = {
    SQL"""delete from production.billofmaterials where billofmaterialsid = $billofmaterialsid""".executeUpdate() > 0
  }
  override def insert(unsaved: BillofmaterialsRowUnsaved)(implicit c: Connection): BillofmaterialsId = {
    val namedParameters = List(
      Some(NamedParameter("productassemblyid", ParameterValue.from(unsaved.productassemblyid))),
      Some(NamedParameter("componentid", ParameterValue.from(unsaved.componentid))),
      unsaved.startdate match {
        case UseDefault => None
        case Provided(value) => Some(NamedParameter("startdate", ParameterValue.from[LocalDateTime](value)))
      },
      Some(NamedParameter("enddate", ParameterValue.from(unsaved.enddate))),
      Some(NamedParameter("unitmeasurecode", ParameterValue.from(unsaved.unitmeasurecode))),
      Some(NamedParameter("bomlevel", ParameterValue.from(unsaved.bomlevel))),
      unsaved.perassemblyqty match {
        case UseDefault => None
        case Provided(value) => Some(NamedParameter("perassemblyqty", ParameterValue.from[BigDecimal](value)))
      },
      unsaved.modifieddate match {
        case UseDefault => None
        case Provided(value) => Some(NamedParameter("modifieddate", ParameterValue.from[LocalDateTime](value)))
      }
    ).flatten
    
    SQL"""insert into production.billofmaterials(${namedParameters.map(_.name).mkString(", ")})
          values (${namedParameters.map(np => s"{${np.name}}").mkString(", ")})
          returning billofmaterialsid
    """
      .on(namedParameters :_*)
      .executeInsert(SqlParser.get[BillofmaterialsId]("billofmaterialsid").single)
  
  }
  override def selectAll(implicit c: Connection): List[BillofmaterialsRow] = {
    SQL"""select billofmaterialsid, productassemblyid, componentid, startdate, enddate, unitmeasurecode, bomlevel, perassemblyqty, modifieddate from production.billofmaterials""".as(BillofmaterialsRow.rowParser("").*)
  }
  override def selectByFieldValues(fieldValues: List[BillofmaterialsFieldOrIdValue[_]])(implicit c: Connection): List[BillofmaterialsRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case BillofmaterialsFieldValue.billofmaterialsid(value) => NamedParameter("billofmaterialsid", ParameterValue.from(value))
          case BillofmaterialsFieldValue.productassemblyid(value) => NamedParameter("productassemblyid", ParameterValue.from(value))
          case BillofmaterialsFieldValue.componentid(value) => NamedParameter("componentid", ParameterValue.from(value))
          case BillofmaterialsFieldValue.startdate(value) => NamedParameter("startdate", ParameterValue.from(value))
          case BillofmaterialsFieldValue.enddate(value) => NamedParameter("enddate", ParameterValue.from(value))
          case BillofmaterialsFieldValue.unitmeasurecode(value) => NamedParameter("unitmeasurecode", ParameterValue.from(value))
          case BillofmaterialsFieldValue.bomlevel(value) => NamedParameter("bomlevel", ParameterValue.from(value))
          case BillofmaterialsFieldValue.perassemblyqty(value) => NamedParameter("perassemblyqty", ParameterValue.from(value))
          case BillofmaterialsFieldValue.modifieddate(value) => NamedParameter("modifieddate", ParameterValue.from(value))
        }
        val q = s"""select * from production.billofmaterials where ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(" AND ")}"""
        // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
        import anorm._
        SQL(q)
          .on(namedParams: _*)
          .as(BillofmaterialsRow.rowParser("").*)
    }
  
  }
  override def selectById(billofmaterialsid: BillofmaterialsId)(implicit c: Connection): Option[BillofmaterialsRow] = {
    SQL"""select billofmaterialsid, productassemblyid, componentid, startdate, enddate, unitmeasurecode, bomlevel, perassemblyqty, modifieddate from production.billofmaterials where billofmaterialsid = $billofmaterialsid""".as(BillofmaterialsRow.rowParser("").singleOpt)
  }
  override def selectByIds(billofmaterialsids: List[BillofmaterialsId])(implicit c: Connection): List[BillofmaterialsRow] = {
    SQL"""select billofmaterialsid, productassemblyid, componentid, startdate, enddate, unitmeasurecode, bomlevel, perassemblyqty, modifieddate from production.billofmaterials where billofmaterialsid in $billofmaterialsids""".as(BillofmaterialsRow.rowParser("").*)
  }
  override def update(billofmaterialsid: BillofmaterialsId, row: BillofmaterialsRow)(implicit c: Connection): Boolean = {
    SQL"""update production.billofmaterials
          set productassemblyid = ${row.productassemblyid},
              componentid = ${row.componentid},
              startdate = ${row.startdate},
              enddate = ${row.enddate},
              unitmeasurecode = ${row.unitmeasurecode},
              bomlevel = ${row.bomlevel},
              perassemblyqty = ${row.perassemblyqty},
              modifieddate = ${row.modifieddate}
          where billofmaterialsid = $billofmaterialsid""".executeUpdate() > 0
  }
  override def updateFieldValues(billofmaterialsid: BillofmaterialsId, fieldValues: List[BillofmaterialsFieldValue[_]])(implicit c: Connection): Boolean = {
    fieldValues match {
      case Nil => false
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case BillofmaterialsFieldValue.productassemblyid(value) => NamedParameter("productassemblyid", ParameterValue.from(value))
          case BillofmaterialsFieldValue.componentid(value) => NamedParameter("componentid", ParameterValue.from(value))
          case BillofmaterialsFieldValue.startdate(value) => NamedParameter("startdate", ParameterValue.from(value))
          case BillofmaterialsFieldValue.enddate(value) => NamedParameter("enddate", ParameterValue.from(value))
          case BillofmaterialsFieldValue.unitmeasurecode(value) => NamedParameter("unitmeasurecode", ParameterValue.from(value))
          case BillofmaterialsFieldValue.bomlevel(value) => NamedParameter("bomlevel", ParameterValue.from(value))
          case BillofmaterialsFieldValue.perassemblyqty(value) => NamedParameter("perassemblyqty", ParameterValue.from(value))
          case BillofmaterialsFieldValue.modifieddate(value) => NamedParameter("modifieddate", ParameterValue.from(value))
        }
        val q = s"""update production.billofmaterials
                    set ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(", ")}
                    where billofmaterialsid = $billofmaterialsid"""
        // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
        import anorm._
        SQL(q)
          .on(namedParams: _*)
          .executeUpdate() > 0
    }
  
  }
}
