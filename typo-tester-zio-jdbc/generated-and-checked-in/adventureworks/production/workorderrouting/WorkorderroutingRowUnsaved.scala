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
import zio.json.JsonDecoder
import zio.json.JsonEncoder
import zio.json.ast.Json
import zio.json.internal.Write

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
  implicit lazy val jsonDecoder: JsonDecoder[WorkorderroutingRowUnsaved] = JsonDecoder[Json.Obj].mapOrFail { jsonObj =>
    val workorderid = jsonObj.get("workorderid").toRight("Missing field 'workorderid'").flatMap(_.as(WorkorderId.jsonDecoder))
    val productid = jsonObj.get("productid").toRight("Missing field 'productid'").flatMap(_.as(JsonDecoder.int))
    val operationsequence = jsonObj.get("operationsequence").toRight("Missing field 'operationsequence'").flatMap(_.as(TypoShort.jsonDecoder))
    val locationid = jsonObj.get("locationid").toRight("Missing field 'locationid'").flatMap(_.as(LocationId.jsonDecoder))
    val scheduledstartdate = jsonObj.get("scheduledstartdate").toRight("Missing field 'scheduledstartdate'").flatMap(_.as(TypoLocalDateTime.jsonDecoder))
    val scheduledenddate = jsonObj.get("scheduledenddate").toRight("Missing field 'scheduledenddate'").flatMap(_.as(TypoLocalDateTime.jsonDecoder))
    val actualstartdate = jsonObj.get("actualstartdate").fold[Either[String, Option[TypoLocalDateTime]]](Right(None))(_.as(JsonDecoder.option(TypoLocalDateTime.jsonDecoder)))
    val actualenddate = jsonObj.get("actualenddate").fold[Either[String, Option[TypoLocalDateTime]]](Right(None))(_.as(JsonDecoder.option(TypoLocalDateTime.jsonDecoder)))
    val actualresourcehrs = jsonObj.get("actualresourcehrs").fold[Either[String, Option[BigDecimal]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.scalaBigDecimal)))
    val plannedcost = jsonObj.get("plannedcost").toRight("Missing field 'plannedcost'").flatMap(_.as(JsonDecoder.scalaBigDecimal))
    val actualcost = jsonObj.get("actualcost").fold[Either[String, Option[BigDecimal]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.scalaBigDecimal)))
    val modifieddate = jsonObj.get("modifieddate").toRight("Missing field 'modifieddate'").flatMap(_.as(Defaulted.jsonDecoder(TypoLocalDateTime.jsonDecoder)))
    if (workorderid.isRight && productid.isRight && operationsequence.isRight && locationid.isRight && scheduledstartdate.isRight && scheduledenddate.isRight && actualstartdate.isRight && actualenddate.isRight && actualresourcehrs.isRight && plannedcost.isRight && actualcost.isRight && modifieddate.isRight)
      Right(WorkorderroutingRowUnsaved(workorderid = workorderid.toOption.get, productid = productid.toOption.get, operationsequence = operationsequence.toOption.get, locationid = locationid.toOption.get, scheduledstartdate = scheduledstartdate.toOption.get, scheduledenddate = scheduledenddate.toOption.get, actualstartdate = actualstartdate.toOption.get, actualenddate = actualenddate.toOption.get, actualresourcehrs = actualresourcehrs.toOption.get, plannedcost = plannedcost.toOption.get, actualcost = actualcost.toOption.get, modifieddate = modifieddate.toOption.get))
    else Left(List[Either[String, Any]](workorderid, productid, operationsequence, locationid, scheduledstartdate, scheduledenddate, actualstartdate, actualenddate, actualresourcehrs, plannedcost, actualcost, modifieddate).flatMap(_.left.toOption).mkString(", "))
  }
  implicit lazy val jsonEncoder: JsonEncoder[WorkorderroutingRowUnsaved] = new JsonEncoder[WorkorderroutingRowUnsaved] {
    override def unsafeEncode(a: WorkorderroutingRowUnsaved, indent: Option[Int], out: Write): Unit = {
      out.write("{")
      out.write(""""workorderid":""")
      WorkorderId.jsonEncoder.unsafeEncode(a.workorderid, indent, out)
      out.write(",")
      out.write(""""productid":""")
      JsonEncoder.int.unsafeEncode(a.productid, indent, out)
      out.write(",")
      out.write(""""operationsequence":""")
      TypoShort.jsonEncoder.unsafeEncode(a.operationsequence, indent, out)
      out.write(",")
      out.write(""""locationid":""")
      LocationId.jsonEncoder.unsafeEncode(a.locationid, indent, out)
      out.write(",")
      out.write(""""scheduledstartdate":""")
      TypoLocalDateTime.jsonEncoder.unsafeEncode(a.scheduledstartdate, indent, out)
      out.write(",")
      out.write(""""scheduledenddate":""")
      TypoLocalDateTime.jsonEncoder.unsafeEncode(a.scheduledenddate, indent, out)
      out.write(",")
      out.write(""""actualstartdate":""")
      JsonEncoder.option(TypoLocalDateTime.jsonEncoder).unsafeEncode(a.actualstartdate, indent, out)
      out.write(",")
      out.write(""""actualenddate":""")
      JsonEncoder.option(TypoLocalDateTime.jsonEncoder).unsafeEncode(a.actualenddate, indent, out)
      out.write(",")
      out.write(""""actualresourcehrs":""")
      JsonEncoder.option(JsonEncoder.scalaBigDecimal).unsafeEncode(a.actualresourcehrs, indent, out)
      out.write(",")
      out.write(""""plannedcost":""")
      JsonEncoder.scalaBigDecimal.unsafeEncode(a.plannedcost, indent, out)
      out.write(",")
      out.write(""""actualcost":""")
      JsonEncoder.option(JsonEncoder.scalaBigDecimal).unsafeEncode(a.actualcost, indent, out)
      out.write(",")
      out.write(""""modifieddate":""")
      Defaulted.jsonEncoder(TypoLocalDateTime.jsonEncoder).unsafeEncode(a.modifieddate, indent, out)
      out.write("}")
    }
  }
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
}
