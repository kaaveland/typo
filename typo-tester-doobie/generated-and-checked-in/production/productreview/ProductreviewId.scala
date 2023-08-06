/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package productreview

import doobie.util.Get
import doobie.util.Put
import doobie.util.meta.Meta
import io.circe.Decoder
import io.circe.Encoder
import typo.dsl.Bijection

/** Type for the primary key of table `production.productreview` */
case class ProductreviewId(value: Int) extends AnyVal
object ProductreviewId {
  implicit lazy val arrayGet: Get[Array[ProductreviewId]] = adventureworks.IntegerArrayMeta.get.map(_.map(ProductreviewId.apply))
  implicit lazy val arrayPut: Put[Array[ProductreviewId]] = adventureworks.IntegerArrayMeta.put.contramap(_.map(_.value))
  implicit lazy val bijection: Bijection[ProductreviewId, Int] = Bijection[ProductreviewId, Int](_.value)(ProductreviewId.apply)
  implicit lazy val decoder: Decoder[ProductreviewId] = Decoder.decodeInt.map(ProductreviewId.apply)
  implicit lazy val encoder: Encoder[ProductreviewId] = Encoder.encodeInt.contramap(_.value)
  implicit lazy val get: Get[ProductreviewId] = Meta.IntMeta.get.map(ProductreviewId.apply)
  implicit lazy val ordering: Ordering[ProductreviewId] = Ordering.by(_.value)
  implicit lazy val put: Put[ProductreviewId] = Meta.IntMeta.put.contramap(_.value)
}
