/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_user_mapping

import doobie.util.Get
import doobie.util.Put
import doobie.util.meta.Meta
import io.circe.Decoder
import io.circe.Encoder
import typo.dsl.Bijection

/** Type for the primary key of table `pg_catalog.pg_user_mapping` */
case class PgUserMappingId(value: /* oid */ Long) extends AnyVal
object PgUserMappingId {
  implicit lazy val arrayGet: Get[Array[PgUserMappingId]] = adventureworks.LongArrayMeta.get.map(_.map(PgUserMappingId.apply))
  implicit lazy val arrayPut: Put[Array[PgUserMappingId]] = adventureworks.LongArrayMeta.put.contramap(_.map(_.value))
  implicit lazy val bijection: Bijection[PgUserMappingId, /* oid */ Long] = Bijection[PgUserMappingId, /* oid */ Long](_.value)(PgUserMappingId.apply)
  implicit lazy val decoder: Decoder[PgUserMappingId] = Decoder.decodeLong.map(PgUserMappingId.apply)
  implicit lazy val encoder: Encoder[PgUserMappingId] = Encoder.encodeLong.contramap(_.value)
  implicit lazy val get: Get[PgUserMappingId] = Meta.LongMeta.get.map(PgUserMappingId.apply)
  implicit lazy val ordering: Ordering[PgUserMappingId] = Ordering.by(_.value)
  implicit lazy val put: Put[PgUserMappingId] = Meta.LongMeta.put.contramap(_.value)
}
