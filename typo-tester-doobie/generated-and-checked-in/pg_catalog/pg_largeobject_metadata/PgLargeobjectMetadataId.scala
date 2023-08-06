/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_largeobject_metadata

import doobie.util.Get
import doobie.util.Put
import doobie.util.meta.Meta
import io.circe.Decoder
import io.circe.Encoder
import typo.dsl.Bijection

/** Type for the primary key of table `pg_catalog.pg_largeobject_metadata` */
case class PgLargeobjectMetadataId(value: /* oid */ Long) extends AnyVal
object PgLargeobjectMetadataId {
  implicit lazy val arrayGet: Get[Array[PgLargeobjectMetadataId]] = adventureworks.LongArrayMeta.get.map(_.map(PgLargeobjectMetadataId.apply))
  implicit lazy val arrayPut: Put[Array[PgLargeobjectMetadataId]] = adventureworks.LongArrayMeta.put.contramap(_.map(_.value))
  implicit lazy val bijection: Bijection[PgLargeobjectMetadataId, /* oid */ Long] = Bijection[PgLargeobjectMetadataId, /* oid */ Long](_.value)(PgLargeobjectMetadataId.apply)
  implicit lazy val decoder: Decoder[PgLargeobjectMetadataId] = Decoder.decodeLong.map(PgLargeobjectMetadataId.apply)
  implicit lazy val encoder: Encoder[PgLargeobjectMetadataId] = Encoder.encodeLong.contramap(_.value)
  implicit lazy val get: Get[PgLargeobjectMetadataId] = Meta.LongMeta.get.map(PgLargeobjectMetadataId.apply)
  implicit lazy val ordering: Ordering[PgLargeobjectMetadataId] = Ordering.by(_.value)
  implicit lazy val put: Put[PgLargeobjectMetadataId] = Meta.LongMeta.put.contramap(_.value)
}
