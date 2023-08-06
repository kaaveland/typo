/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_rewrite

import doobie.util.Get
import doobie.util.Put
import doobie.util.meta.Meta
import io.circe.Decoder
import io.circe.Encoder
import typo.dsl.Bijection

/** Type for the primary key of table `pg_catalog.pg_rewrite` */
case class PgRewriteId(value: /* oid */ Long) extends AnyVal
object PgRewriteId {
  implicit lazy val arrayGet: Get[Array[PgRewriteId]] = adventureworks.LongArrayMeta.get.map(_.map(PgRewriteId.apply))
  implicit lazy val arrayPut: Put[Array[PgRewriteId]] = adventureworks.LongArrayMeta.put.contramap(_.map(_.value))
  implicit lazy val bijection: Bijection[PgRewriteId, /* oid */ Long] = Bijection[PgRewriteId, /* oid */ Long](_.value)(PgRewriteId.apply)
  implicit lazy val decoder: Decoder[PgRewriteId] = Decoder.decodeLong.map(PgRewriteId.apply)
  implicit lazy val encoder: Encoder[PgRewriteId] = Encoder.encodeLong.contramap(_.value)
  implicit lazy val get: Get[PgRewriteId] = Meta.LongMeta.get.map(PgRewriteId.apply)
  implicit lazy val ordering: Ordering[PgRewriteId] = Ordering.by(_.value)
  implicit lazy val put: Put[PgRewriteId] = Meta.LongMeta.put.contramap(_.value)
}
