/**
 * File automatically generated by `typo` for its own test suite.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN
 */
package testdb
package hardcoded
package myschema
package football_club

import doobie.util.Get
import doobie.util.Put
import doobie.util.meta.Meta
import io.circe.Decoder
import io.circe.Encoder

/** Type for the primary key of table `myschema.football_club` */
case class FootballClubId(value: Long) extends AnyVal
object FootballClubId {
  implicit val arrayGet: Get[Array[FootballClubId]] = testdb.hardcoded.LongArrayMeta.get.map(_.map(FootballClubId.apply))
  implicit val arrayPut: Put[Array[FootballClubId]] = testdb.hardcoded.LongArrayMeta.put.contramap(_.map(_.value))
  implicit val decoder: Decoder[FootballClubId] = Decoder.decodeLong.map(FootballClubId.apply)
  implicit val encoder: Encoder[FootballClubId] = Encoder.encodeLong.contramap(_.value)
  implicit val get: Get[FootballClubId] = Meta.LongMeta.get.map(FootballClubId.apply)
  implicit val ordering: Ordering[FootballClubId] = Ordering.by(_.value)
  implicit val put: Put[FootballClubId] = Meta.LongMeta.put.contramap(_.value)
}