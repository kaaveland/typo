/**
 * File automatically generated by `typo` for its own test suite.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN
 */
package testdb
package hardcoded
package myschema
package person

import doobie.util.Get
import doobie.util.Put
import doobie.util.meta.Meta
import io.circe.Decoder
import io.circe.Encoder

/** Type for the primary key of table `myschema.person` */
case class PersonId(value: Long) extends AnyVal
object PersonId {
  implicit val arrayGet: Get[Array[PersonId]] = testdb.hardcoded.LongArrayMeta.get.map(_.map(PersonId.apply))
  implicit val arrayPut: Put[Array[PersonId]] = testdb.hardcoded.LongArrayMeta.put.contramap(_.map(_.value))
  implicit val decoder: Decoder[PersonId] = Decoder.decodeLong.map(PersonId.apply)
  implicit val encoder: Encoder[PersonId] = Encoder.encodeLong.contramap(_.value)
  implicit val get: Get[PersonId] = Meta.LongMeta.get.map(PersonId.apply)
  implicit val ordering: Ordering[PersonId] = Ordering.by(_.value)
  implicit val put: Put[PersonId] = Meta.LongMeta.put.contramap(_.value)
}