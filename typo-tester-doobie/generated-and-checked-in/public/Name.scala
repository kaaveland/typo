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

/** Domain `public.Name`
  * No constraint
  */
case class Name(value: String) extends AnyVal
object Name {
  implicit lazy val arrayGet: Get[Array[Name]] = adventureworks.StringArrayMeta.get.map(_.map(Name.apply))
  implicit lazy val arrayPut: Put[Array[Name]] = adventureworks.StringArrayMeta.put.contramap(_.map(_.value))
  implicit lazy val bijection: Bijection[Name, String] = Bijection[Name, String](_.value)(Name.apply)
  implicit lazy val decoder: Decoder[Name] = Decoder.decodeString.map(Name.apply)
  implicit lazy val encoder: Encoder[Name] = Encoder.encodeString.contramap(_.value)
  implicit lazy val get: Get[Name] = Meta.StringMeta.get.map(Name.apply)
  implicit lazy val ordering: Ordering[Name] = Ordering.by(_.value)
  implicit lazy val put: Put[Name] = Meta.StringMeta.put.contramap(_.value)
}
