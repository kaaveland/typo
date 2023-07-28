/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_partitioned_table

import doobie.util.Get
import doobie.util.Put
import doobie.util.meta.Meta
import io.circe.Decoder
import io.circe.Encoder

/** Type for the primary key of table `pg_catalog.pg_partitioned_table` */
case class PgPartitionedTableId(value: /* oid */ Long) extends AnyVal
object PgPartitionedTableId {
  implicit val arrayGet: Get[Array[PgPartitionedTableId]] = adventureworks.LongArrayMeta.get.map(_.map(PgPartitionedTableId.apply))
  implicit val arrayPut: Put[Array[PgPartitionedTableId]] = adventureworks.LongArrayMeta.put.contramap(_.map(_.value))
  implicit val decoder: Decoder[PgPartitionedTableId] = Decoder.decodeLong.map(PgPartitionedTableId.apply)
  implicit val encoder: Encoder[PgPartitionedTableId] = Encoder.encodeLong.contramap(_.value)
  implicit val get: Get[PgPartitionedTableId] = Meta.LongMeta.get.map(PgPartitionedTableId.apply)
  implicit val ordering: Ordering[PgPartitionedTableId] = Ordering.by(_.value)
  implicit val put: Put[PgPartitionedTableId] = Meta.LongMeta.put.contramap(_.value)
}