/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package salesterritory

import doobie.Meta
import io.circe.Decoder
import io.circe.Encoder

/** Type for the primary key of table `sales.salesterritory` */
case class SalesterritoryId(value: Int) extends AnyVal
object SalesterritoryId {
  implicit val ordering: Ordering[SalesterritoryId] = Ordering.by(_.value)
  implicit val encoder: Encoder[SalesterritoryId] =
    Encoder[Int].contramap(_.value)
  implicit val decoder: Decoder[SalesterritoryId] =
    Decoder[Int].map(SalesterritoryId(_))
  implicit val metaArray: Meta[Array[SalesterritoryId]] = Meta[Array[Int]].imap(_.map(SalesterritoryId.apply))(_.map(_.value))
  implicit val meta: Meta[SalesterritoryId] = Meta[Int].imap(SalesterritoryId.apply)(_.value)
}
