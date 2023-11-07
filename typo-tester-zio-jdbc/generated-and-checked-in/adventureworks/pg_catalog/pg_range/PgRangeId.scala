/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_range

import typo.dsl.Bijection
import typo.dsl.ParameterMetaData
import zio.jdbc.JdbcDecoder
import zio.jdbc.JdbcEncoder
import zio.jdbc.SqlFragment.Setter
import zio.json.JsonDecoder
import zio.json.JsonEncoder

/** Type for the primary key of table `pg_catalog.pg_range` */
case class PgRangeId(value: /* oid */ Long) extends AnyVal
object PgRangeId {
  implicit lazy val arraySetter: Setter[Array[PgRangeId]] = adventureworks.LongArraySetter.contramap(_.map(_.value))
  implicit lazy val bijection: Bijection[PgRangeId, /* oid */ Long] = Bijection[PgRangeId, /* oid */ Long](_.value)(PgRangeId.apply)
  implicit lazy val jdbcDecoder: JdbcDecoder[PgRangeId] = JdbcDecoder.longDecoder.map(PgRangeId.apply)
  implicit lazy val jdbcEncoder: JdbcEncoder[PgRangeId] = JdbcEncoder.longEncoder.contramap(_.value)
  implicit lazy val jsonDecoder: JsonDecoder[PgRangeId] = JsonDecoder.long.map(PgRangeId.apply)
  implicit lazy val jsonEncoder: JsonEncoder[PgRangeId] = JsonEncoder.long.contramap(_.value)
  implicit lazy val ordering: Ordering[PgRangeId] = Ordering.by(_.value)
  implicit lazy val parameterMetadata: ParameterMetaData[PgRangeId] = ParameterMetaData.instance[PgRangeId](ParameterMetaData.LongParameterMetaData.sqlType, ParameterMetaData.LongParameterMetaData.jdbcType)
  implicit lazy val setter: Setter[PgRangeId] = Setter.longSetter.contramap(_.value)
}
