/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_range

import doobie.util.Get
import doobie.util.Put
import doobie.util.meta.Meta
import io.circe.Decoder
import io.circe.Encoder
import typo.dsl.Bijection

/** Type for the primary key of table `pg_catalog.pg_range` */
case class PgRangeId(value: /* oid */ Long) extends AnyVal
object PgRangeId {
  implicit lazy val arrayGet: Get[Array[PgRangeId]] = adventureworks.LongArrayMeta.get.map(_.map(PgRangeId.apply))
  implicit lazy val arrayPut: Put[Array[PgRangeId]] = adventureworks.LongArrayMeta.put.contramap(_.map(_.value))
  implicit lazy val bijection: Bijection[PgRangeId, /* oid */ Long] = Bijection[PgRangeId, /* oid */ Long](_.value)(PgRangeId.apply)
  implicit lazy val decoder: Decoder[PgRangeId] = Decoder.decodeLong.map(PgRangeId.apply)
  implicit lazy val encoder: Encoder[PgRangeId] = Encoder.encodeLong.contramap(_.value)
  implicit lazy val get: Get[PgRangeId] = Meta.LongMeta.get.map(PgRangeId.apply)
  implicit lazy val ordering: Ordering[PgRangeId] = Ordering.by(_.value)
  implicit lazy val put: Put[PgRangeId] = Meta.LongMeta.put.contramap(_.value)
}
