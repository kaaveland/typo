/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pr
package wr

import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.production.location.LocationId
import adventureworks.production.workorder.WorkorderId
import anorm.Column
import anorm.RowParser
import anorm.Success
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.OWrites
import play.api.libs.json.Reads
import play.api.libs.json.Writes
import scala.collection.immutable.ListMap
import scala.util.Try

case class WrViewRow(
  id: Int,
  /** Points to [[production.workorderrouting.WorkorderroutingRow.workorderid]] */
  workorderid: WorkorderId,
  /** Points to [[production.workorderrouting.WorkorderroutingRow.productid]] */
  productid: Int,
  /** Points to [[production.workorderrouting.WorkorderroutingRow.operationsequence]] */
  operationsequence: Int,
  /** Points to [[production.workorderrouting.WorkorderroutingRow.locationid]] */
  locationid: LocationId,
  /** Points to [[production.workorderrouting.WorkorderroutingRow.scheduledstartdate]] */
  scheduledstartdate: TypoLocalDateTime,
  /** Points to [[production.workorderrouting.WorkorderroutingRow.scheduledenddate]] */
  scheduledenddate: TypoLocalDateTime,
  /** Points to [[production.workorderrouting.WorkorderroutingRow.actualstartdate]] */
  actualstartdate: TypoLocalDateTime,
  /** Points to [[production.workorderrouting.WorkorderroutingRow.actualenddate]] */
  actualenddate: TypoLocalDateTime,
  /** Points to [[production.workorderrouting.WorkorderroutingRow.actualresourcehrs]] */
  actualresourcehrs: BigDecimal,
  /** Points to [[production.workorderrouting.WorkorderroutingRow.plannedcost]] */
  plannedcost: BigDecimal,
  /** Points to [[production.workorderrouting.WorkorderroutingRow.actualcost]] */
  actualcost: BigDecimal,
  /** Points to [[production.workorderrouting.WorkorderroutingRow.modifieddate]] */
  modifieddate: TypoLocalDateTime
)

object WrViewRow {
  implicit lazy val reads: Reads[WrViewRow] = Reads[WrViewRow](json => JsResult.fromTry(
      Try(
        WrViewRow(
          id = json.\("id").as(Reads.IntReads),
          workorderid = json.\("workorderid").as(WorkorderId.reads),
          productid = json.\("productid").as(Reads.IntReads),
          operationsequence = json.\("operationsequence").as(Reads.IntReads),
          locationid = json.\("locationid").as(LocationId.reads),
          scheduledstartdate = json.\("scheduledstartdate").as(TypoLocalDateTime.reads),
          scheduledenddate = json.\("scheduledenddate").as(TypoLocalDateTime.reads),
          actualstartdate = json.\("actualstartdate").as(TypoLocalDateTime.reads),
          actualenddate = json.\("actualenddate").as(TypoLocalDateTime.reads),
          actualresourcehrs = json.\("actualresourcehrs").as(Reads.bigDecReads),
          plannedcost = json.\("plannedcost").as(Reads.bigDecReads),
          actualcost = json.\("actualcost").as(Reads.bigDecReads),
          modifieddate = json.\("modifieddate").as(TypoLocalDateTime.reads)
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[WrViewRow] = RowParser[WrViewRow] { row =>
    Success(
      WrViewRow(
        id = row(idx + 0)(Column.columnToInt),
        workorderid = row(idx + 1)(WorkorderId.column),
        productid = row(idx + 2)(Column.columnToInt),
        operationsequence = row(idx + 3)(Column.columnToInt),
        locationid = row(idx + 4)(LocationId.column),
        scheduledstartdate = row(idx + 5)(TypoLocalDateTime.column),
        scheduledenddate = row(idx + 6)(TypoLocalDateTime.column),
        actualstartdate = row(idx + 7)(TypoLocalDateTime.column),
        actualenddate = row(idx + 8)(TypoLocalDateTime.column),
        actualresourcehrs = row(idx + 9)(Column.columnToScalaBigDecimal),
        plannedcost = row(idx + 10)(Column.columnToScalaBigDecimal),
        actualcost = row(idx + 11)(Column.columnToScalaBigDecimal),
        modifieddate = row(idx + 12)(TypoLocalDateTime.column)
      )
    )
  }
  implicit lazy val writes: OWrites[WrViewRow] = OWrites[WrViewRow](o =>
    new JsObject(ListMap[String, JsValue](
      "id" -> Writes.IntWrites.writes(o.id),
      "workorderid" -> WorkorderId.writes.writes(o.workorderid),
      "productid" -> Writes.IntWrites.writes(o.productid),
      "operationsequence" -> Writes.IntWrites.writes(o.operationsequence),
      "locationid" -> LocationId.writes.writes(o.locationid),
      "scheduledstartdate" -> TypoLocalDateTime.writes.writes(o.scheduledstartdate),
      "scheduledenddate" -> TypoLocalDateTime.writes.writes(o.scheduledenddate),
      "actualstartdate" -> TypoLocalDateTime.writes.writes(o.actualstartdate),
      "actualenddate" -> TypoLocalDateTime.writes.writes(o.actualenddate),
      "actualresourcehrs" -> Writes.BigDecimalWrites.writes(o.actualresourcehrs),
      "plannedcost" -> Writes.BigDecimalWrites.writes(o.plannedcost),
      "actualcost" -> Writes.BigDecimalWrites.writes(o.actualcost),
      "modifieddate" -> TypoLocalDateTime.writes.writes(o.modifieddate)
    ))
  )
}
