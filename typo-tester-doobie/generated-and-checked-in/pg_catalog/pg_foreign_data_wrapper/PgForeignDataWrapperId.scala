/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_foreign_data_wrapper

import doobie.util.Get
import doobie.util.Put
import doobie.util.meta.Meta
import io.circe.Decoder
import io.circe.Encoder
import typo.dsl.Bijection

/** Type for the primary key of table `pg_catalog.pg_foreign_data_wrapper` */
case class PgForeignDataWrapperId(value: /* oid */ Long) extends AnyVal
object PgForeignDataWrapperId {
  implicit lazy val arrayGet: Get[Array[PgForeignDataWrapperId]] = adventureworks.LongArrayMeta.get.map(_.map(PgForeignDataWrapperId.apply))
  implicit lazy val arrayPut: Put[Array[PgForeignDataWrapperId]] = adventureworks.LongArrayMeta.put.contramap(_.map(_.value))
  implicit lazy val bijection: Bijection[PgForeignDataWrapperId, /* oid */ Long] = Bijection[PgForeignDataWrapperId, /* oid */ Long](_.value)(PgForeignDataWrapperId.apply)
  implicit lazy val decoder: Decoder[PgForeignDataWrapperId] = Decoder.decodeLong.map(PgForeignDataWrapperId.apply)
  implicit lazy val encoder: Encoder[PgForeignDataWrapperId] = Encoder.encodeLong.contramap(_.value)
  implicit lazy val get: Get[PgForeignDataWrapperId] = Meta.LongMeta.get.map(PgForeignDataWrapperId.apply)
  implicit lazy val ordering: Ordering[PgForeignDataWrapperId] = Ordering.by(_.value)
  implicit lazy val put: Put[PgForeignDataWrapperId] = Meta.LongMeta.put.contramap(_.value)
}
