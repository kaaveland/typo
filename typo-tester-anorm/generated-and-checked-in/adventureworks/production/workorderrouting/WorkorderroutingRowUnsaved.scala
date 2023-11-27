/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package workorderrouting

import adventureworks.Text
import adventureworks.customtypes.Defaulted
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoShort
import adventureworks.production.location.LocationId
import adventureworks.production.workorder.WorkorderId
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.OWrites
import play.api.libs.json.Reads
import play.api.libs.json.Writes
import scala.collection.immutable.ListMap
import scala.util.Try

/** This class corresponds to a row in table `production.workorderrouting` which has not been persisted yet */
case class WorkorderroutingRowUnsaved(
  /** Primary key. Foreign key to WorkOrder.WorkOrderID.
      Points to [[workorder.WorkorderRow.workorderid]] */
  workorderid: WorkorderId,
  /** Primary key. Foreign key to Product.ProductID. */
  productid: Int,
  /** Primary key. Indicates the manufacturing process sequence. */
  operationsequence: TypoShort,
  /** Manufacturing location where the part is processed. Foreign key to Location.LocationID.
      Points to [[location.LocationRow.locationid]] */
  locationid: LocationId,
  /** Planned manufacturing start date.
      Constraint CK_WorkOrderRouting_ScheduledEndDate affecting columns s, c, h, e, d, u, l, e, d, e, n, d, d, a, t, e, ,,  , s, c, h, e, d, u, l, e, d, s, t, a, r, t, d, a, t, e:  ((scheduledenddate >= scheduledstartdate)) */
  scheduledstartdate: TypoLocalDateTime,
  /** Planned manufacturing end date.
      Constraint CK_WorkOrderRouting_ScheduledEndDate affecting columns s, c, h, e, d, u, l, e, d, e, n, d, d, a, t, e, ,,  , s, c, h, e, d, u, l, e, d, s, t, a, r, t, d, a, t, e:  ((scheduledenddate >= scheduledstartdate)) */
  scheduledenddate: TypoLocalDateTime,
  /** Actual start date.
      Constraint CK_WorkOrderRouting_ActualEndDate affecting columns a, c, t, u, a, l, e, n, d, d, a, t, e, ,,  , a, c, t, u, a, l, s, t, a, r, t, d, a, t, e:  (((actualenddate >= actualstartdate) OR (actualenddate IS NULL) OR (actualstartdate IS NULL))) */
  actualstartdate: Option[TypoLocalDateTime],
  /** Actual end date.
      Constraint CK_WorkOrderRouting_ActualEndDate affecting columns a, c, t, u, a, l, e, n, d, d, a, t, e, ,,  , a, c, t, u, a, l, s, t, a, r, t, d, a, t, e:  (((actualenddate >= actualstartdate) OR (actualenddate IS NULL) OR (actualstartdate IS NULL))) */
  actualenddate: Option[TypoLocalDateTime],
  /** Number of manufacturing hours used.
      Constraint CK_WorkOrderRouting_ActualResourceHrs affecting columns a, c, t, u, a, l, r, e, s, o, u, r, c, e, h, r, s:  ((actualresourcehrs >= 0.0000)) */
  actualresourcehrs: Option[BigDecimal],
  /** Estimated manufacturing cost.
      Constraint CK_WorkOrderRouting_PlannedCost affecting columns p, l, a, n, n, e, d, c, o, s, t:  ((plannedcost > 0.00)) */
  plannedcost: BigDecimal,
  /** Actual manufacturing cost.
      Constraint CK_WorkOrderRouting_ActualCost affecting columns a, c, t, u, a, l, c, o, s, t:  ((actualcost > 0.00)) */
  actualcost: Option[BigDecimal],
  /** Default: now() */
  modifieddate: Defaulted[TypoLocalDateTime] = Defaulted.UseDefault
) {
  def toRow(modifieddateDefault: => TypoLocalDateTime): WorkorderroutingRow =
    WorkorderroutingRow(
      workorderid = workorderid,
      productid = productid,
      operationsequence = operationsequence,
      locationid = locationid,
      scheduledstartdate = scheduledstartdate,
      scheduledenddate = scheduledenddate,
      actualstartdate = actualstartdate,
      actualenddate = actualenddate,
      actualresourcehrs = actualresourcehrs,
      plannedcost = plannedcost,
      actualcost = actualcost,
      modifieddate = modifieddate match {
                       case Defaulted.UseDefault => modifieddateDefault
                       case Defaulted.Provided(value) => value
                     }
    )
}
object WorkorderroutingRowUnsaved {
  implicit lazy val reads: Reads[WorkorderroutingRowUnsaved] = Reads[WorkorderroutingRowUnsaved](json => JsResult.fromTry(
      Try(
        WorkorderroutingRowUnsaved(
          workorderid = json.\("workorderid").as(WorkorderId.reads),
          productid = json.\("productid").as(Reads.IntReads),
          operationsequence = json.\("operationsequence").as(TypoShort.reads),
          locationid = json.\("locationid").as(LocationId.reads),
          scheduledstartdate = json.\("scheduledstartdate").as(TypoLocalDateTime.reads),
          scheduledenddate = json.\("scheduledenddate").as(TypoLocalDateTime.reads),
          actualstartdate = json.\("actualstartdate").toOption.map(_.as(TypoLocalDateTime.reads)),
          actualenddate = json.\("actualenddate").toOption.map(_.as(TypoLocalDateTime.reads)),
          actualresourcehrs = json.\("actualresourcehrs").toOption.map(_.as(Reads.bigDecReads)),
          plannedcost = json.\("plannedcost").as(Reads.bigDecReads),
          actualcost = json.\("actualcost").toOption.map(_.as(Reads.bigDecReads)),
          modifieddate = json.\("modifieddate").as(Defaulted.reads(TypoLocalDateTime.reads))
        )
      )
    ),
  )
  implicit lazy val text: Text[WorkorderroutingRowUnsaved] = Text.instance[WorkorderroutingRowUnsaved]{ (row, sb) =>
    WorkorderId.text.unsafeEncode(row.workorderid, sb)
    sb.append(Text.DELIMETER)
    Text.intInstance.unsafeEncode(row.productid, sb)
    sb.append(Text.DELIMETER)
    TypoShort.text.unsafeEncode(row.operationsequence, sb)
    sb.append(Text.DELIMETER)
    LocationId.text.unsafeEncode(row.locationid, sb)
    sb.append(Text.DELIMETER)
    TypoLocalDateTime.text.unsafeEncode(row.scheduledstartdate, sb)
    sb.append(Text.DELIMETER)
    TypoLocalDateTime.text.unsafeEncode(row.scheduledenddate, sb)
    sb.append(Text.DELIMETER)
    Text.option(TypoLocalDateTime.text).unsafeEncode(row.actualstartdate, sb)
    sb.append(Text.DELIMETER)
    Text.option(TypoLocalDateTime.text).unsafeEncode(row.actualenddate, sb)
    sb.append(Text.DELIMETER)
    Text.option(Text.bigDecimalInstance).unsafeEncode(row.actualresourcehrs, sb)
    sb.append(Text.DELIMETER)
    Text.bigDecimalInstance.unsafeEncode(row.plannedcost, sb)
    sb.append(Text.DELIMETER)
    Text.option(Text.bigDecimalInstance).unsafeEncode(row.actualcost, sb)
    sb.append(Text.DELIMETER)
    Defaulted.text(TypoLocalDateTime.text).unsafeEncode(row.modifieddate, sb)
  }
  implicit lazy val writes: OWrites[WorkorderroutingRowUnsaved] = OWrites[WorkorderroutingRowUnsaved](o =>
    new JsObject(ListMap[String, JsValue](
      "workorderid" -> WorkorderId.writes.writes(o.workorderid),
      "productid" -> Writes.IntWrites.writes(o.productid),
      "operationsequence" -> TypoShort.writes.writes(o.operationsequence),
      "locationid" -> LocationId.writes.writes(o.locationid),
      "scheduledstartdate" -> TypoLocalDateTime.writes.writes(o.scheduledstartdate),
      "scheduledenddate" -> TypoLocalDateTime.writes.writes(o.scheduledenddate),
      "actualstartdate" -> Writes.OptionWrites(TypoLocalDateTime.writes).writes(o.actualstartdate),
      "actualenddate" -> Writes.OptionWrites(TypoLocalDateTime.writes).writes(o.actualenddate),
      "actualresourcehrs" -> Writes.OptionWrites(Writes.BigDecimalWrites).writes(o.actualresourcehrs),
      "plannedcost" -> Writes.BigDecimalWrites.writes(o.plannedcost),
      "actualcost" -> Writes.OptionWrites(Writes.BigDecimalWrites).writes(o.actualcost),
      "modifieddate" -> Defaulted.writes(TypoLocalDateTime.writes).writes(o.modifieddate)
    ))
  )
}
