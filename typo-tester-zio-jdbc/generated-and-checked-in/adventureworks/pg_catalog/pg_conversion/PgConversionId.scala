/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_conversion

import typo.dsl.Bijection
import typo.dsl.ParameterMetaData
import zio.jdbc.JdbcDecoder
import zio.jdbc.JdbcEncoder
import zio.jdbc.SqlFragment.Setter
import zio.json.JsonDecoder
import zio.json.JsonEncoder

/** Type for the primary key of table `pg_catalog.pg_conversion` */
case class PgConversionId(value: /* oid */ Long) extends AnyVal
object PgConversionId {
  implicit lazy val arraySetter: Setter[Array[PgConversionId]] = adventureworks.LongArraySetter.contramap(_.map(_.value))
  implicit lazy val bijection: Bijection[PgConversionId, /* oid */ Long] = Bijection[PgConversionId, /* oid */ Long](_.value)(PgConversionId.apply)
  implicit lazy val jdbcDecoder: JdbcDecoder[PgConversionId] = JdbcDecoder.longDecoder.map(PgConversionId.apply)
  implicit lazy val jdbcEncoder: JdbcEncoder[PgConversionId] = JdbcEncoder.longEncoder.contramap(_.value)
  implicit lazy val jsonDecoder: JsonDecoder[PgConversionId] = JsonDecoder.long.map(PgConversionId.apply)
  implicit lazy val jsonEncoder: JsonEncoder[PgConversionId] = JsonEncoder.long.contramap(_.value)
  implicit lazy val ordering: Ordering[PgConversionId] = Ordering.by(_.value)
  implicit lazy val parameterMetadata: ParameterMetaData[PgConversionId] = ParameterMetaData.instance[PgConversionId](ParameterMetaData.LongParameterMetaData.sqlType, ParameterMetaData.LongParameterMetaData.jdbcType)
  implicit lazy val setter: Setter[PgConversionId] = Setter.longSetter.contramap(_.value)
}
