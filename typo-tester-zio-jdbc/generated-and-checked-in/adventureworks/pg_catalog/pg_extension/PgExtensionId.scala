/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_extension

import typo.dsl.Bijection
import typo.dsl.ParameterMetaData
import zio.jdbc.JdbcDecoder
import zio.jdbc.JdbcEncoder
import zio.jdbc.SqlFragment.Setter
import zio.json.JsonDecoder
import zio.json.JsonEncoder

/** Type for the primary key of table `pg_catalog.pg_extension` */
case class PgExtensionId(value: /* oid */ Long) extends AnyVal
object PgExtensionId {
  implicit lazy val arraySetter: Setter[Array[PgExtensionId]] = adventureworks.LongArraySetter.contramap(_.map(_.value))
  implicit lazy val bijection: Bijection[PgExtensionId, /* oid */ Long] = Bijection[PgExtensionId, /* oid */ Long](_.value)(PgExtensionId.apply)
  implicit lazy val jdbcDecoder: JdbcDecoder[PgExtensionId] = JdbcDecoder.longDecoder.map(PgExtensionId.apply)
  implicit lazy val jdbcEncoder: JdbcEncoder[PgExtensionId] = JdbcEncoder.longEncoder.contramap(_.value)
  implicit lazy val jsonDecoder: JsonDecoder[PgExtensionId] = JsonDecoder.long.map(PgExtensionId.apply)
  implicit lazy val jsonEncoder: JsonEncoder[PgExtensionId] = JsonEncoder.long.contramap(_.value)
  implicit lazy val ordering: Ordering[PgExtensionId] = Ordering.by(_.value)
  implicit lazy val parameterMetadata: ParameterMetaData[PgExtensionId] = ParameterMetaData.instance[PgExtensionId](ParameterMetaData.LongParameterMetaData.sqlType, ParameterMetaData.LongParameterMetaData.jdbcType)
  implicit lazy val setter: Setter[PgExtensionId] = Setter.longSetter.contramap(_.value)
}
