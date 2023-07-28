/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_ts_config

import doobie.util.Get
import doobie.util.Put
import doobie.util.meta.Meta
import io.circe.Decoder
import io.circe.Encoder

/** Type for the primary key of table `pg_catalog.pg_ts_config` */
case class PgTsConfigId(value: /* oid */ Long) extends AnyVal
object PgTsConfigId {
  implicit val arrayGet: Get[Array[PgTsConfigId]] = adventureworks.LongArrayMeta.get.map(_.map(PgTsConfigId.apply))
  implicit val arrayPut: Put[Array[PgTsConfigId]] = adventureworks.LongArrayMeta.put.contramap(_.map(_.value))
  implicit val decoder: Decoder[PgTsConfigId] = Decoder.decodeLong.map(PgTsConfigId.apply)
  implicit val encoder: Encoder[PgTsConfigId] = Encoder.encodeLong.contramap(_.value)
  implicit val get: Get[PgTsConfigId] = Meta.LongMeta.get.map(PgTsConfigId.apply)
  implicit val ordering: Ordering[PgTsConfigId] = Ordering.by(_.value)
  implicit val put: Put[PgTsConfigId] = Meta.LongMeta.put.contramap(_.value)
}