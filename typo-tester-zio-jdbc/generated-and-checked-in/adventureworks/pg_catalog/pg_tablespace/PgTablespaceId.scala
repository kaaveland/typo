/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_tablespace

import typo.dsl.Bijection
import typo.dsl.ParameterMetaData
import zio.jdbc.JdbcDecoder
import zio.jdbc.JdbcEncoder
import zio.jdbc.SqlFragment.Setter
import zio.json.JsonDecoder
import zio.json.JsonEncoder

/** Type for the primary key of table `pg_catalog.pg_tablespace` */
case class PgTablespaceId(value: /* oid */ Long) extends AnyVal
object PgTablespaceId {
  implicit lazy val arraySetter: Setter[Array[PgTablespaceId]] = adventureworks.LongArraySetter.contramap(_.map(_.value))
  implicit lazy val bijection: Bijection[PgTablespaceId, /* oid */ Long] = Bijection[PgTablespaceId, /* oid */ Long](_.value)(PgTablespaceId.apply)
  implicit lazy val jdbcDecoder: JdbcDecoder[PgTablespaceId] = JdbcDecoder.longDecoder.map(PgTablespaceId.apply)
  implicit lazy val jdbcEncoder: JdbcEncoder[PgTablespaceId] = JdbcEncoder.longEncoder.contramap(_.value)
  implicit lazy val jsonDecoder: JsonDecoder[PgTablespaceId] = JsonDecoder.long.map(PgTablespaceId.apply)
  implicit lazy val jsonEncoder: JsonEncoder[PgTablespaceId] = JsonEncoder.long.contramap(_.value)
  implicit lazy val ordering: Ordering[PgTablespaceId] = Ordering.by(_.value)
  implicit lazy val parameterMetadata: ParameterMetaData[PgTablespaceId] = ParameterMetaData.instance[PgTablespaceId](ParameterMetaData.LongParameterMetaData.sqlType, ParameterMetaData.LongParameterMetaData.jdbcType)
  implicit lazy val setter: Setter[PgTablespaceId] = Setter.longSetter.contramap(_.value)
}
