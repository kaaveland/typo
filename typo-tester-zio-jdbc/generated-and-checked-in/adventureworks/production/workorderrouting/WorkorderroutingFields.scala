/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package workorderrouting

import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoShort
import adventureworks.production.location.LocationId
import adventureworks.production.workorder.WorkorderId
import typo.dsl.SqlExpr.Field
import typo.dsl.SqlExpr.FieldLikeNoHkt
import typo.dsl.SqlExpr.IdField
import typo.dsl.SqlExpr.OptField
import typo.dsl.Structure.Relation

trait WorkorderroutingFields[Row] {
  val workorderid: IdField[WorkorderId, Row]
  val productid: IdField[Int, Row]
  val operationsequence: IdField[TypoShort, Row]
  val locationid: Field[LocationId, Row]
  val scheduledstartdate: Field[TypoLocalDateTime, Row]
  val scheduledenddate: Field[TypoLocalDateTime, Row]
  val actualstartdate: OptField[TypoLocalDateTime, Row]
  val actualenddate: OptField[TypoLocalDateTime, Row]
  val actualresourcehrs: OptField[BigDecimal, Row]
  val plannedcost: Field[BigDecimal, Row]
  val actualcost: OptField[BigDecimal, Row]
  val modifieddate: Field[TypoLocalDateTime, Row]
}

object WorkorderroutingFields {
  val structure: Relation[WorkorderroutingFields, WorkorderroutingRow, WorkorderroutingRow] = 
    new Impl(None, identity, (_, x) => x)
    
  private final class Impl[Row](val prefix: Option[String], val extract: Row => WorkorderroutingRow, val merge: (Row, WorkorderroutingRow) => Row)
    extends Relation[WorkorderroutingFields, WorkorderroutingRow, Row] { 
  
    override val fields: WorkorderroutingFields[Row] = new WorkorderroutingFields[Row] {
      override val workorderid = new IdField[WorkorderId, Row](prefix, "workorderid", None, Some("int4"))(x => extract(x).workorderid, (row, value) => merge(row, extract(row).copy(workorderid = value)))
      override val productid = new IdField[Int, Row](prefix, "productid", None, Some("int4"))(x => extract(x).productid, (row, value) => merge(row, extract(row).copy(productid = value)))
      override val operationsequence = new IdField[TypoShort, Row](prefix, "operationsequence", None, Some("int2"))(x => extract(x).operationsequence, (row, value) => merge(row, extract(row).copy(operationsequence = value)))
      override val locationid = new Field[LocationId, Row](prefix, "locationid", None, Some("int2"))(x => extract(x).locationid, (row, value) => merge(row, extract(row).copy(locationid = value)))
      override val scheduledstartdate = new Field[TypoLocalDateTime, Row](prefix, "scheduledstartdate", Some("text"), Some("timestamp"))(x => extract(x).scheduledstartdate, (row, value) => merge(row, extract(row).copy(scheduledstartdate = value)))
      override val scheduledenddate = new Field[TypoLocalDateTime, Row](prefix, "scheduledenddate", Some("text"), Some("timestamp"))(x => extract(x).scheduledenddate, (row, value) => merge(row, extract(row).copy(scheduledenddate = value)))
      override val actualstartdate = new OptField[TypoLocalDateTime, Row](prefix, "actualstartdate", Some("text"), Some("timestamp"))(x => extract(x).actualstartdate, (row, value) => merge(row, extract(row).copy(actualstartdate = value)))
      override val actualenddate = new OptField[TypoLocalDateTime, Row](prefix, "actualenddate", Some("text"), Some("timestamp"))(x => extract(x).actualenddate, (row, value) => merge(row, extract(row).copy(actualenddate = value)))
      override val actualresourcehrs = new OptField[BigDecimal, Row](prefix, "actualresourcehrs", None, Some("numeric"))(x => extract(x).actualresourcehrs, (row, value) => merge(row, extract(row).copy(actualresourcehrs = value)))
      override val plannedcost = new Field[BigDecimal, Row](prefix, "plannedcost", None, Some("numeric"))(x => extract(x).plannedcost, (row, value) => merge(row, extract(row).copy(plannedcost = value)))
      override val actualcost = new OptField[BigDecimal, Row](prefix, "actualcost", None, Some("numeric"))(x => extract(x).actualcost, (row, value) => merge(row, extract(row).copy(actualcost = value)))
      override val modifieddate = new Field[TypoLocalDateTime, Row](prefix, "modifieddate", Some("text"), Some("timestamp"))(x => extract(x).modifieddate, (row, value) => merge(row, extract(row).copy(modifieddate = value)))
    }
  
    override val columns: List[FieldLikeNoHkt[?, Row]] =
      List[FieldLikeNoHkt[?, Row]](fields.workorderid, fields.productid, fields.operationsequence, fields.locationid, fields.scheduledstartdate, fields.scheduledenddate, fields.actualstartdate, fields.actualenddate, fields.actualresourcehrs, fields.plannedcost, fields.actualcost, fields.modifieddate)
  
    override def copy[NewRow](prefix: Option[String], extract: NewRow => WorkorderroutingRow, merge: (NewRow, WorkorderroutingRow) => NewRow): Impl[NewRow] =
      new Impl(prefix, extract, merge)
  }
  
}
