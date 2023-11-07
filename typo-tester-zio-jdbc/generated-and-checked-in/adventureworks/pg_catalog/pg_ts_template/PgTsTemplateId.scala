/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_ts_template

import typo.dsl.Bijection
import typo.dsl.ParameterMetaData
import zio.jdbc.JdbcDecoder
import zio.jdbc.JdbcEncoder
import zio.jdbc.SqlFragment.Setter
import zio.json.JsonDecoder
import zio.json.JsonEncoder

/** Type for the primary key of table `pg_catalog.pg_ts_template` */
case class PgTsTemplateId(value: /* oid */ Long) extends AnyVal
object PgTsTemplateId {
  implicit lazy val arraySetter: Setter[Array[PgTsTemplateId]] = adventureworks.LongArraySetter.contramap(_.map(_.value))
  implicit lazy val bijection: Bijection[PgTsTemplateId, /* oid */ Long] = Bijection[PgTsTemplateId, /* oid */ Long](_.value)(PgTsTemplateId.apply)
  implicit lazy val jdbcDecoder: JdbcDecoder[PgTsTemplateId] = JdbcDecoder.longDecoder.map(PgTsTemplateId.apply)
  implicit lazy val jdbcEncoder: JdbcEncoder[PgTsTemplateId] = JdbcEncoder.longEncoder.contramap(_.value)
  implicit lazy val jsonDecoder: JsonDecoder[PgTsTemplateId] = JsonDecoder.long.map(PgTsTemplateId.apply)
  implicit lazy val jsonEncoder: JsonEncoder[PgTsTemplateId] = JsonEncoder.long.contramap(_.value)
  implicit lazy val ordering: Ordering[PgTsTemplateId] = Ordering.by(_.value)
  implicit lazy val parameterMetadata: ParameterMetaData[PgTsTemplateId] = ParameterMetaData.instance[PgTsTemplateId](ParameterMetaData.LongParameterMetaData.sqlType, ParameterMetaData.LongParameterMetaData.jdbcType)
  implicit lazy val setter: Setter[PgTsTemplateId] = Setter.longSetter.contramap(_.value)
}
