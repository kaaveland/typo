/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package customer

import doobie.Meta
import io.circe.Decoder
import io.circe.Encoder

/** Type for the primary key of table `sales.customer` */
case class CustomerId(value: Int) extends AnyVal
object CustomerId {
  implicit val ordering: Ordering[CustomerId] = Ordering.by(_.value)
  implicit val encoder: Encoder[CustomerId] =
    Encoder[Int].contramap(_.value)
  implicit val decoder: Decoder[CustomerId] =
    Decoder[Int].map(CustomerId(_))
  implicit val metaArray: Meta[Array[CustomerId]] = Meta[Array[Int]].imap(_.map(CustomerId.apply))(_.map(_.value))
  implicit val meta: Meta[CustomerId] = Meta[Int].imap(CustomerId.apply)(_.value)
}
