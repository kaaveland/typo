/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package customer

import typo.dsl.Bijection
import typo.dsl.ParameterMetaData
import zio.jdbc.JdbcDecoder
import zio.jdbc.JdbcEncoder
import zio.jdbc.SqlFragment.Setter
import zio.json.JsonDecoder
import zio.json.JsonEncoder

/** Type for the primary key of table `sales.customer` */
case class CustomerId(value: Int) extends AnyVal
object CustomerId {
  implicit lazy val arraySetter: Setter[Array[CustomerId]] = adventureworks.IntArraySetter.contramap(_.map(_.value))
  implicit lazy val bijection: Bijection[CustomerId, Int] = Bijection[CustomerId, Int](_.value)(CustomerId.apply)
  implicit lazy val jdbcDecoder: JdbcDecoder[CustomerId] = JdbcDecoder.intDecoder.map(CustomerId.apply)
  implicit lazy val jdbcEncoder: JdbcEncoder[CustomerId] = JdbcEncoder.intEncoder.contramap(_.value)
  implicit lazy val jsonDecoder: JsonDecoder[CustomerId] = JsonDecoder.int.map(CustomerId.apply)
  implicit lazy val jsonEncoder: JsonEncoder[CustomerId] = JsonEncoder.int.contramap(_.value)
  implicit lazy val ordering: Ordering[CustomerId] = Ordering.by(_.value)
  implicit lazy val parameterMetadata: ParameterMetaData[CustomerId] = ParameterMetaData.instance[CustomerId](ParameterMetaData.IntParameterMetaData.sqlType, ParameterMetaData.IntParameterMetaData.jdbcType)
  implicit lazy val setter: Setter[CustomerId] = Setter.intSetter.contramap(_.value)
}
