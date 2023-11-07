/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_database

import typo.dsl.Bijection
import typo.dsl.ParameterMetaData
import zio.jdbc.JdbcDecoder
import zio.jdbc.JdbcEncoder
import zio.jdbc.SqlFragment.Setter
import zio.json.JsonDecoder
import zio.json.JsonEncoder

/** Type for the primary key of table `pg_catalog.pg_database` */
case class PgDatabaseId(value: /* oid */ Long) extends AnyVal
object PgDatabaseId {
  implicit lazy val arraySetter: Setter[Array[PgDatabaseId]] = adventureworks.LongArraySetter.contramap(_.map(_.value))
  implicit lazy val bijection: Bijection[PgDatabaseId, /* oid */ Long] = Bijection[PgDatabaseId, /* oid */ Long](_.value)(PgDatabaseId.apply)
  implicit lazy val jdbcDecoder: JdbcDecoder[PgDatabaseId] = JdbcDecoder.longDecoder.map(PgDatabaseId.apply)
  implicit lazy val jdbcEncoder: JdbcEncoder[PgDatabaseId] = JdbcEncoder.longEncoder.contramap(_.value)
  implicit lazy val jsonDecoder: JsonDecoder[PgDatabaseId] = JsonDecoder.long.map(PgDatabaseId.apply)
  implicit lazy val jsonEncoder: JsonEncoder[PgDatabaseId] = JsonEncoder.long.contramap(_.value)
  implicit lazy val ordering: Ordering[PgDatabaseId] = Ordering.by(_.value)
  implicit lazy val parameterMetadata: ParameterMetaData[PgDatabaseId] = ParameterMetaData.instance[PgDatabaseId](ParameterMetaData.LongParameterMetaData.sqlType, ParameterMetaData.LongParameterMetaData.jdbcType)
  implicit lazy val setter: Setter[PgDatabaseId] = Setter.longSetter.contramap(_.value)
}
