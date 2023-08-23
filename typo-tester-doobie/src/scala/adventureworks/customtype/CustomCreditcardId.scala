/** File has been automatically generated by `typo`.
  *
  * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
  */
package adventureworks.customtype

import doobie.util.{Get, Put}
import doobie.util.meta.Meta
import io.circe.{Decoder, Encoder}
import typo.dsl.Bijection

/** Type for the primary key of table `sales.creditcard` */
case class CustomCreditcardId(value: Int) extends AnyVal
object CustomCreditcardId {
  implicit lazy val arrayGet: Get[Array[CustomCreditcardId]] = adventureworks.IntegerArrayMeta.get.map(_.map(CustomCreditcardId.apply))
  implicit lazy val arrayPut: Put[Array[CustomCreditcardId]] = adventureworks.IntegerArrayMeta.put.contramap(_.map(_.value))
  implicit lazy val bijection: Bijection[CustomCreditcardId, Int] = Bijection[CustomCreditcardId, Int](_.value)(CustomCreditcardId.apply)
  implicit lazy val decoder: Decoder[CustomCreditcardId] = Decoder.decodeInt.map(CustomCreditcardId.apply)
  implicit lazy val encoder: Encoder[CustomCreditcardId] = Encoder.encodeInt.contramap(_.value)
  implicit lazy val get: Get[CustomCreditcardId] = Meta.IntMeta.get.map(CustomCreditcardId.apply)
  implicit lazy val ordering: Ordering[CustomCreditcardId] = Ordering.by(_.value)
  implicit lazy val put: Put[CustomCreditcardId] = Meta.IntMeta.put.contramap(_.value)
}
