/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_statistic_ext_data

import typo.dsl.Bijection
import typo.dsl.ParameterMetaData
import zio.jdbc.JdbcDecoder
import zio.jdbc.JdbcEncoder
import zio.jdbc.SqlFragment.Setter
import zio.json.JsonDecoder
import zio.json.JsonEncoder

/** Type for the primary key of table `pg_catalog.pg_statistic_ext_data` */
case class PgStatisticExtDataId(value: /* oid */ Long) extends AnyVal
object PgStatisticExtDataId {
  implicit lazy val arraySetter: Setter[Array[PgStatisticExtDataId]] = adventureworks.LongArraySetter.contramap(_.map(_.value))
  implicit lazy val bijection: Bijection[PgStatisticExtDataId, /* oid */ Long] = Bijection[PgStatisticExtDataId, /* oid */ Long](_.value)(PgStatisticExtDataId.apply)
  implicit lazy val jdbcDecoder: JdbcDecoder[PgStatisticExtDataId] = JdbcDecoder.longDecoder.map(PgStatisticExtDataId.apply)
  implicit lazy val jdbcEncoder: JdbcEncoder[PgStatisticExtDataId] = JdbcEncoder.longEncoder.contramap(_.value)
  implicit lazy val jsonDecoder: JsonDecoder[PgStatisticExtDataId] = JsonDecoder.long.map(PgStatisticExtDataId.apply)
  implicit lazy val jsonEncoder: JsonEncoder[PgStatisticExtDataId] = JsonEncoder.long.contramap(_.value)
  implicit lazy val ordering: Ordering[PgStatisticExtDataId] = Ordering.by(_.value)
  implicit lazy val parameterMetadata: ParameterMetaData[PgStatisticExtDataId] = ParameterMetaData.instance[PgStatisticExtDataId](ParameterMetaData.LongParameterMetaData.sqlType, ParameterMetaData.LongParameterMetaData.jdbcType)
  implicit lazy val setter: Setter[PgStatisticExtDataId] = Setter.longSetter.contramap(_.value)
}
