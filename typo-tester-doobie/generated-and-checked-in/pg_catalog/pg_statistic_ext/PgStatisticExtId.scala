/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_statistic_ext

import doobie.util.Get
import doobie.util.Put
import doobie.util.meta.Meta
import io.circe.Decoder
import io.circe.Encoder
import typo.dsl.Bijection

/** Type for the primary key of table `pg_catalog.pg_statistic_ext` */
case class PgStatisticExtId(value: /* oid */ Long) extends AnyVal
object PgStatisticExtId {
  implicit lazy val arrayGet: Get[Array[PgStatisticExtId]] = adventureworks.LongArrayMeta.get.map(_.map(PgStatisticExtId.apply))
  implicit lazy val arrayPut: Put[Array[PgStatisticExtId]] = adventureworks.LongArrayMeta.put.contramap(_.map(_.value))
  implicit lazy val bijection: Bijection[PgStatisticExtId, /* oid */ Long] = Bijection[PgStatisticExtId, /* oid */ Long](_.value)(PgStatisticExtId.apply)
  implicit lazy val decoder: Decoder[PgStatisticExtId] = Decoder.decodeLong.map(PgStatisticExtId.apply)
  implicit lazy val encoder: Encoder[PgStatisticExtId] = Encoder.encodeLong.contramap(_.value)
  implicit lazy val get: Get[PgStatisticExtId] = Meta.LongMeta.get.map(PgStatisticExtId.apply)
  implicit lazy val ordering: Ordering[PgStatisticExtId] = Ordering.by(_.value)
  implicit lazy val put: Put[PgStatisticExtId] = Meta.LongMeta.put.contramap(_.value)
}
