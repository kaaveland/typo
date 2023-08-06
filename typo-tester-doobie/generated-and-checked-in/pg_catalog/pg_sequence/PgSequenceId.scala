/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_sequence

import doobie.util.Get
import doobie.util.Put
import doobie.util.meta.Meta
import io.circe.Decoder
import io.circe.Encoder
import typo.dsl.Bijection

/** Type for the primary key of table `pg_catalog.pg_sequence` */
case class PgSequenceId(value: /* oid */ Long) extends AnyVal
object PgSequenceId {
  implicit lazy val arrayGet: Get[Array[PgSequenceId]] = adventureworks.LongArrayMeta.get.map(_.map(PgSequenceId.apply))
  implicit lazy val arrayPut: Put[Array[PgSequenceId]] = adventureworks.LongArrayMeta.put.contramap(_.map(_.value))
  implicit lazy val bijection: Bijection[PgSequenceId, /* oid */ Long] = Bijection[PgSequenceId, /* oid */ Long](_.value)(PgSequenceId.apply)
  implicit lazy val decoder: Decoder[PgSequenceId] = Decoder.decodeLong.map(PgSequenceId.apply)
  implicit lazy val encoder: Encoder[PgSequenceId] = Encoder.encodeLong.contramap(_.value)
  implicit lazy val get: Get[PgSequenceId] = Meta.LongMeta.get.map(PgSequenceId.apply)
  implicit lazy val ordering: Ordering[PgSequenceId] = Ordering.by(_.value)
  implicit lazy val put: Put[PgSequenceId] = Meta.LongMeta.put.contramap(_.value)
}
