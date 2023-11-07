/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_operator

import typo.dsl.Bijection
import typo.dsl.ParameterMetaData
import zio.jdbc.JdbcDecoder
import zio.jdbc.JdbcEncoder
import zio.jdbc.SqlFragment.Setter
import zio.json.JsonDecoder
import zio.json.JsonEncoder

/** Type for the primary key of table `pg_catalog.pg_operator` */
case class PgOperatorId(value: /* oid */ Long) extends AnyVal
object PgOperatorId {
  implicit lazy val arraySetter: Setter[Array[PgOperatorId]] = adventureworks.LongArraySetter.contramap(_.map(_.value))
  implicit lazy val bijection: Bijection[PgOperatorId, /* oid */ Long] = Bijection[PgOperatorId, /* oid */ Long](_.value)(PgOperatorId.apply)
  implicit lazy val jdbcDecoder: JdbcDecoder[PgOperatorId] = JdbcDecoder.longDecoder.map(PgOperatorId.apply)
  implicit lazy val jdbcEncoder: JdbcEncoder[PgOperatorId] = JdbcEncoder.longEncoder.contramap(_.value)
  implicit lazy val jsonDecoder: JsonDecoder[PgOperatorId] = JsonDecoder.long.map(PgOperatorId.apply)
  implicit lazy val jsonEncoder: JsonEncoder[PgOperatorId] = JsonEncoder.long.contramap(_.value)
  implicit lazy val ordering: Ordering[PgOperatorId] = Ordering.by(_.value)
  implicit lazy val parameterMetadata: ParameterMetaData[PgOperatorId] = ParameterMetaData.instance[PgOperatorId](ParameterMetaData.LongParameterMetaData.sqlType, ParameterMetaData.LongParameterMetaData.jdbcType)
  implicit lazy val setter: Setter[PgOperatorId] = Setter.longSetter.contramap(_.value)
}
