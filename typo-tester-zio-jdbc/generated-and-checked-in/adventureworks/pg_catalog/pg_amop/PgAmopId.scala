/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_amop

import typo.dsl.Bijection
import typo.dsl.ParameterMetaData
import zio.jdbc.JdbcDecoder
import zio.jdbc.JdbcEncoder
import zio.jdbc.SqlFragment.Setter
import zio.json.JsonDecoder
import zio.json.JsonEncoder

/** Type for the primary key of table `pg_catalog.pg_amop` */
case class PgAmopId(value: /* oid */ Long) extends AnyVal
object PgAmopId {
  implicit lazy val arraySetter: Setter[Array[PgAmopId]] = adventureworks.LongArraySetter.contramap(_.map(_.value))
  implicit lazy val bijection: Bijection[PgAmopId, /* oid */ Long] = Bijection[PgAmopId, /* oid */ Long](_.value)(PgAmopId.apply)
  implicit lazy val jdbcDecoder: JdbcDecoder[PgAmopId] = JdbcDecoder.longDecoder.map(PgAmopId.apply)
  implicit lazy val jdbcEncoder: JdbcEncoder[PgAmopId] = JdbcEncoder.longEncoder.contramap(_.value)
  implicit lazy val jsonDecoder: JsonDecoder[PgAmopId] = JsonDecoder.long.map(PgAmopId.apply)
  implicit lazy val jsonEncoder: JsonEncoder[PgAmopId] = JsonEncoder.long.contramap(_.value)
  implicit lazy val ordering: Ordering[PgAmopId] = Ordering.by(_.value)
  implicit lazy val parameterMetadata: ParameterMetaData[PgAmopId] = ParameterMetaData.instance[PgAmopId](ParameterMetaData.LongParameterMetaData.sqlType, ParameterMetaData.LongParameterMetaData.jdbcType)
  implicit lazy val setter: Setter[PgAmopId] = Setter.longSetter.contramap(_.value)
}
