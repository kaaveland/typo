/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pr
package wr

import adventureworks.production.location.LocationId
import adventureworks.production.workorder.WorkorderId
import io.circe.Decoder
import io.circe.Encoder
import io.circe.HCursor
import io.circe.Json
import java.time.LocalDateTime

case class WrViewRow(
  id: Option[Int],
  /** Points to [[production.workorderrouting.WorkorderroutingRow.workorderid]] */
  workorderid: Option[WorkorderId],
  /** Points to [[production.workorderrouting.WorkorderroutingRow.productid]] */
  productid: Option[Int],
  /** Points to [[production.workorderrouting.WorkorderroutingRow.operationsequence]] */
  operationsequence: Option[Int],
  /** Points to [[production.workorderrouting.WorkorderroutingRow.locationid]] */
  locationid: Option[LocationId],
  /** Points to [[production.workorderrouting.WorkorderroutingRow.scheduledstartdate]] */
  scheduledstartdate: Option[LocalDateTime],
  /** Points to [[production.workorderrouting.WorkorderroutingRow.scheduledenddate]] */
  scheduledenddate: Option[LocalDateTime],
  /** Points to [[production.workorderrouting.WorkorderroutingRow.actualstartdate]] */
  actualstartdate: Option[LocalDateTime],
  /** Points to [[production.workorderrouting.WorkorderroutingRow.actualenddate]] */
  actualenddate: Option[LocalDateTime],
  /** Points to [[production.workorderrouting.WorkorderroutingRow.actualresourcehrs]] */
  actualresourcehrs: Option[BigDecimal],
  /** Points to [[production.workorderrouting.WorkorderroutingRow.plannedcost]] */
  plannedcost: Option[BigDecimal],
  /** Points to [[production.workorderrouting.WorkorderroutingRow.actualcost]] */
  actualcost: Option[BigDecimal],
  /** Points to [[production.workorderrouting.WorkorderroutingRow.modifieddate]] */
  modifieddate: Option[LocalDateTime]
)

object WrViewRow {
  implicit val decoder: Decoder[WrViewRow] =
    (c: HCursor) =>
      for {
        id <- c.downField("id").as[Option[Int]]
        workorderid <- c.downField("workorderid").as[Option[WorkorderId]]
        productid <- c.downField("productid").as[Option[Int]]
        operationsequence <- c.downField("operationsequence").as[Option[Int]]
        locationid <- c.downField("locationid").as[Option[LocationId]]
        scheduledstartdate <- c.downField("scheduledstartdate").as[Option[LocalDateTime]]
        scheduledenddate <- c.downField("scheduledenddate").as[Option[LocalDateTime]]
        actualstartdate <- c.downField("actualstartdate").as[Option[LocalDateTime]]
        actualenddate <- c.downField("actualenddate").as[Option[LocalDateTime]]
        actualresourcehrs <- c.downField("actualresourcehrs").as[Option[BigDecimal]]
        plannedcost <- c.downField("plannedcost").as[Option[BigDecimal]]
        actualcost <- c.downField("actualcost").as[Option[BigDecimal]]
        modifieddate <- c.downField("modifieddate").as[Option[LocalDateTime]]
      } yield WrViewRow(id, workorderid, productid, operationsequence, locationid, scheduledstartdate, scheduledenddate, actualstartdate, actualenddate, actualresourcehrs, plannedcost, actualcost, modifieddate)
  implicit val encoder: Encoder[WrViewRow] = {
    import io.circe.syntax._
    row =>
      Json.obj(
        "id" := row.id,
        "workorderid" := row.workorderid,
        "productid" := row.productid,
        "operationsequence" := row.operationsequence,
        "locationid" := row.locationid,
        "scheduledstartdate" := row.scheduledstartdate,
        "scheduledenddate" := row.scheduledenddate,
        "actualstartdate" := row.actualstartdate,
        "actualenddate" := row.actualenddate,
        "actualresourcehrs" := row.actualresourcehrs,
        "plannedcost" := row.plannedcost,
        "actualcost" := row.actualcost,
        "modifieddate" := row.modifieddate
      )}
}
