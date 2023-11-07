/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_publication

import typo.dsl.Bijection
import typo.dsl.ParameterMetaData
import zio.jdbc.JdbcDecoder
import zio.jdbc.JdbcEncoder
import zio.jdbc.SqlFragment.Setter
import zio.json.JsonDecoder
import zio.json.JsonEncoder

/** Type for the primary key of table `pg_catalog.pg_publication` */
case class PgPublicationId(value: /* oid */ Long) extends AnyVal
object PgPublicationId {
  implicit lazy val arraySetter: Setter[Array[PgPublicationId]] = adventureworks.LongArraySetter.contramap(_.map(_.value))
  implicit lazy val bijection: Bijection[PgPublicationId, /* oid */ Long] = Bijection[PgPublicationId, /* oid */ Long](_.value)(PgPublicationId.apply)
  implicit lazy val jdbcDecoder: JdbcDecoder[PgPublicationId] = JdbcDecoder.longDecoder.map(PgPublicationId.apply)
  implicit lazy val jdbcEncoder: JdbcEncoder[PgPublicationId] = JdbcEncoder.longEncoder.contramap(_.value)
  implicit lazy val jsonDecoder: JsonDecoder[PgPublicationId] = JsonDecoder.long.map(PgPublicationId.apply)
  implicit lazy val jsonEncoder: JsonEncoder[PgPublicationId] = JsonEncoder.long.contramap(_.value)
  implicit lazy val ordering: Ordering[PgPublicationId] = Ordering.by(_.value)
  implicit lazy val parameterMetadata: ParameterMetaData[PgPublicationId] = ParameterMetaData.instance[PgPublicationId](ParameterMetaData.LongParameterMetaData.sqlType, ParameterMetaData.LongParameterMetaData.jdbcType)
  implicit lazy val setter: Setter[PgPublicationId] = Setter.longSetter.contramap(_.value)
}
