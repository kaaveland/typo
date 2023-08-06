/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package salestaxrate

import doobie.util.Get
import doobie.util.Put
import doobie.util.meta.Meta
import io.circe.Decoder
import io.circe.Encoder
import typo.dsl.Bijection

/** Type for the primary key of table `sales.salestaxrate` */
case class SalestaxrateId(value: Int) extends AnyVal
object SalestaxrateId {
  implicit lazy val arrayGet: Get[Array[SalestaxrateId]] = adventureworks.IntegerArrayMeta.get.map(_.map(SalestaxrateId.apply))
  implicit lazy val arrayPut: Put[Array[SalestaxrateId]] = adventureworks.IntegerArrayMeta.put.contramap(_.map(_.value))
  implicit lazy val bijection: Bijection[SalestaxrateId, Int] = Bijection[SalestaxrateId, Int](_.value)(SalestaxrateId.apply)
  implicit lazy val decoder: Decoder[SalestaxrateId] = Decoder.decodeInt.map(SalestaxrateId.apply)
  implicit lazy val encoder: Encoder[SalestaxrateId] = Encoder.encodeInt.contramap(_.value)
  implicit lazy val get: Get[SalestaxrateId] = Meta.IntMeta.get.map(SalestaxrateId.apply)
  implicit lazy val ordering: Ordering[SalestaxrateId] = Ordering.by(_.value)
  implicit lazy val put: Put[SalestaxrateId] = Meta.IntMeta.put.contramap(_.value)
}
