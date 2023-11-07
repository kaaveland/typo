/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_cast

import typo.dsl.Bijection
import typo.dsl.ParameterMetaData
import zio.jdbc.JdbcDecoder
import zio.jdbc.JdbcEncoder
import zio.jdbc.SqlFragment.Setter
import zio.json.JsonDecoder
import zio.json.JsonEncoder

/** Type for the primary key of table `pg_catalog.pg_cast` */
case class PgCastId(value: /* oid */ Long) extends AnyVal
object PgCastId {
  implicit lazy val arraySetter: Setter[Array[PgCastId]] = adventureworks.LongArraySetter.contramap(_.map(_.value))
  implicit lazy val bijection: Bijection[PgCastId, /* oid */ Long] = Bijection[PgCastId, /* oid */ Long](_.value)(PgCastId.apply)
  implicit lazy val jdbcDecoder: JdbcDecoder[PgCastId] = JdbcDecoder.longDecoder.map(PgCastId.apply)
  implicit lazy val jdbcEncoder: JdbcEncoder[PgCastId] = JdbcEncoder.longEncoder.contramap(_.value)
  implicit lazy val jsonDecoder: JsonDecoder[PgCastId] = JsonDecoder.long.map(PgCastId.apply)
  implicit lazy val jsonEncoder: JsonEncoder[PgCastId] = JsonEncoder.long.contramap(_.value)
  implicit lazy val ordering: Ordering[PgCastId] = Ordering.by(_.value)
  implicit lazy val parameterMetadata: ParameterMetaData[PgCastId] = ParameterMetaData.instance[PgCastId](ParameterMetaData.LongParameterMetaData.sqlType, ParameterMetaData.LongParameterMetaData.jdbcType)
  implicit lazy val setter: Setter[PgCastId] = Setter.longSetter.contramap(_.value)
}
