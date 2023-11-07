/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package salesterritoryhistory

import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoUUID
import adventureworks.person.businessentity.BusinessentityId
import adventureworks.sales.salesterritory.SalesterritoryId
import java.sql.ResultSet
import zio.jdbc.JdbcDecoder
import zio.json.JsonDecoder
import zio.json.JsonEncoder
import zio.json.ast.Json
import zio.json.internal.Write

case class SalesterritoryhistoryRow(
  /** Primary key. The sales rep.  Foreign key to SalesPerson.BusinessEntityID.
      Points to [[salesperson.SalespersonRow.businessentityid]] */
  businessentityid: BusinessentityId,
  /** Primary key. Territory identification number. Foreign key to SalesTerritory.SalesTerritoryID.
      Points to [[salesterritory.SalesterritoryRow.territoryid]] */
  territoryid: SalesterritoryId,
  /** Primary key. Date the sales representive started work in the territory.
      Constraint CK_SalesTerritoryHistory_EndDate affecting columns "enddate", "startdate":  (((enddate >= startdate) OR (enddate IS NULL))) */
  startdate: TypoLocalDateTime,
  /** Date the sales representative left work in the territory.
      Constraint CK_SalesTerritoryHistory_EndDate affecting columns "enddate", "startdate":  (((enddate >= startdate) OR (enddate IS NULL))) */
  enddate: Option[TypoLocalDateTime],
  rowguid: TypoUUID,
  modifieddate: TypoLocalDateTime
){
   val compositeId: SalesterritoryhistoryId = SalesterritoryhistoryId(businessentityid, startdate, territoryid)
 }

object SalesterritoryhistoryRow {
  implicit lazy val jdbcDecoder: JdbcDecoder[SalesterritoryhistoryRow] = new JdbcDecoder[SalesterritoryhistoryRow] {
    override def unsafeDecode(columIndex: Int, rs: ResultSet): (Int, SalesterritoryhistoryRow) =
      columIndex + 5 ->
        SalesterritoryhistoryRow(
          businessentityid = BusinessentityId.jdbcDecoder.unsafeDecode(columIndex + 0, rs)._2,
          territoryid = SalesterritoryId.jdbcDecoder.unsafeDecode(columIndex + 1, rs)._2,
          startdate = TypoLocalDateTime.jdbcDecoder.unsafeDecode(columIndex + 2, rs)._2,
          enddate = JdbcDecoder.optionDecoder(TypoLocalDateTime.jdbcDecoder).unsafeDecode(columIndex + 3, rs)._2,
          rowguid = TypoUUID.jdbcDecoder.unsafeDecode(columIndex + 4, rs)._2,
          modifieddate = TypoLocalDateTime.jdbcDecoder.unsafeDecode(columIndex + 5, rs)._2
        )
  }
  implicit lazy val jsonDecoder: JsonDecoder[SalesterritoryhistoryRow] = JsonDecoder[Json.Obj].mapOrFail { jsonObj =>
    val businessentityid = jsonObj.get("businessentityid").toRight("Missing field 'businessentityid'").flatMap(_.as(BusinessentityId.jsonDecoder))
    val territoryid = jsonObj.get("territoryid").toRight("Missing field 'territoryid'").flatMap(_.as(SalesterritoryId.jsonDecoder))
    val startdate = jsonObj.get("startdate").toRight("Missing field 'startdate'").flatMap(_.as(TypoLocalDateTime.jsonDecoder))
    val enddate = jsonObj.get("enddate").fold[Either[String, Option[TypoLocalDateTime]]](Right(None))(_.as(JsonDecoder.option(TypoLocalDateTime.jsonDecoder)))
    val rowguid = jsonObj.get("rowguid").toRight("Missing field 'rowguid'").flatMap(_.as(TypoUUID.jsonDecoder))
    val modifieddate = jsonObj.get("modifieddate").toRight("Missing field 'modifieddate'").flatMap(_.as(TypoLocalDateTime.jsonDecoder))
    if (businessentityid.isRight && territoryid.isRight && startdate.isRight && enddate.isRight && rowguid.isRight && modifieddate.isRight)
      Right(SalesterritoryhistoryRow(businessentityid = businessentityid.toOption.get, territoryid = territoryid.toOption.get, startdate = startdate.toOption.get, enddate = enddate.toOption.get, rowguid = rowguid.toOption.get, modifieddate = modifieddate.toOption.get))
    else Left(List[Either[String, Any]](businessentityid, territoryid, startdate, enddate, rowguid, modifieddate).flatMap(_.left.toOption).mkString(", "))
  }
  implicit lazy val jsonEncoder: JsonEncoder[SalesterritoryhistoryRow] = new JsonEncoder[SalesterritoryhistoryRow] {
    override def unsafeEncode(a: SalesterritoryhistoryRow, indent: Option[Int], out: Write): Unit = {
      out.write("{")
      out.write(""""businessentityid":""")
      BusinessentityId.jsonEncoder.unsafeEncode(a.businessentityid, indent, out)
      out.write(",")
      out.write(""""territoryid":""")
      SalesterritoryId.jsonEncoder.unsafeEncode(a.territoryid, indent, out)
      out.write(",")
      out.write(""""startdate":""")
      TypoLocalDateTime.jsonEncoder.unsafeEncode(a.startdate, indent, out)
      out.write(",")
      out.write(""""enddate":""")
      JsonEncoder.option(TypoLocalDateTime.jsonEncoder).unsafeEncode(a.enddate, indent, out)
      out.write(",")
      out.write(""""rowguid":""")
      TypoUUID.jsonEncoder.unsafeEncode(a.rowguid, indent, out)
      out.write(",")
      out.write(""""modifieddate":""")
      TypoLocalDateTime.jsonEncoder.unsafeEncode(a.modifieddate, indent, out)
      out.write("}")
    }
  }
}
