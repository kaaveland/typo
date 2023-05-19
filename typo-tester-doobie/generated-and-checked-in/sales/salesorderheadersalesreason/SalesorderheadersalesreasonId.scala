/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package salesorderheadersalesreason

import adventureworks.sales.salesorderheader.SalesorderheaderId
import adventureworks.sales.salesreason.SalesreasonId
import io.circe.Decoder
import io.circe.Encoder
import io.circe.HCursor
import io.circe.Json

/** Type for the composite primary key of table `sales.salesorderheadersalesreason` */
case class SalesorderheadersalesreasonId(salesorderid: SalesorderheaderId, salesreasonid: SalesreasonId)
object SalesorderheadersalesreasonId {
  implicit def ordering: Ordering[SalesorderheadersalesreasonId] = Ordering.by(x => (x.salesorderid, x.salesreasonid))
  implicit val decoder: Decoder[SalesorderheadersalesreasonId] =
    (c: HCursor) =>
      for {
        salesorderid <- c.downField("salesorderid").as[SalesorderheaderId]
        salesreasonid <- c.downField("salesreasonid").as[SalesreasonId]
      } yield SalesorderheadersalesreasonId(salesorderid, salesreasonid)
  implicit val encoder: Encoder[SalesorderheadersalesreasonId] = {
    import io.circe.syntax._
    row =>
      Json.obj(
        "salesorderid" := row.salesorderid,
        "salesreasonid" := row.salesreasonid
      )}
}
