/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package public

import doobie.util.Get
import doobie.util.Put
import doobie.util.meta.Meta
import io.circe.Decoder
import io.circe.Encoder
import typo.dsl.Bijection

/** Domain `public.OrderNumber`
  * No constraint
  */
case class OrderNumber(value: String) extends AnyVal
object OrderNumber {
  implicit lazy val arrayGet: Get[Array[OrderNumber]] = adventureworks.StringArrayMeta.get.map(_.map(OrderNumber.apply))
  implicit lazy val arrayPut: Put[Array[OrderNumber]] = adventureworks.StringArrayMeta.put.contramap(_.map(_.value))
  implicit lazy val bijection: Bijection[OrderNumber, String] = Bijection[OrderNumber, String](_.value)(OrderNumber.apply)
  implicit lazy val decoder: Decoder[OrderNumber] = Decoder.decodeString.map(OrderNumber.apply)
  implicit lazy val encoder: Encoder[OrderNumber] = Encoder.encodeString.contramap(_.value)
  implicit lazy val get: Get[OrderNumber] = Meta.StringMeta.get.map(OrderNumber.apply)
  implicit lazy val ordering: Ordering[OrderNumber] = Ordering.by(_.value)
  implicit lazy val put: Put[OrderNumber] = Meta.StringMeta.put.contramap(_.value)
}
