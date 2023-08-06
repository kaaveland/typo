/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_proc

import doobie.util.Get
import doobie.util.Put
import doobie.util.meta.Meta
import io.circe.Decoder
import io.circe.Encoder
import typo.dsl.Bijection

/** Type for the primary key of table `pg_catalog.pg_proc` */
case class PgProcId(value: /* oid */ Long) extends AnyVal
object PgProcId {
  implicit lazy val arrayGet: Get[Array[PgProcId]] = adventureworks.LongArrayMeta.get.map(_.map(PgProcId.apply))
  implicit lazy val arrayPut: Put[Array[PgProcId]] = adventureworks.LongArrayMeta.put.contramap(_.map(_.value))
  implicit lazy val bijection: Bijection[PgProcId, /* oid */ Long] = Bijection[PgProcId, /* oid */ Long](_.value)(PgProcId.apply)
  implicit lazy val decoder: Decoder[PgProcId] = Decoder.decodeLong.map(PgProcId.apply)
  implicit lazy val encoder: Encoder[PgProcId] = Encoder.encodeLong.contramap(_.value)
  implicit lazy val get: Get[PgProcId] = Meta.LongMeta.get.map(PgProcId.apply)
  implicit lazy val ordering: Ordering[PgProcId] = Ordering.by(_.value)
  implicit lazy val put: Put[PgProcId] = Meta.LongMeta.put.contramap(_.value)
}
