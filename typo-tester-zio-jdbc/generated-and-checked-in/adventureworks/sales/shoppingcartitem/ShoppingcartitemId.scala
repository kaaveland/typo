/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package shoppingcartitem

import typo.dsl.Bijection
import typo.dsl.ParameterMetaData
import zio.jdbc.JdbcDecoder
import zio.jdbc.JdbcEncoder
import zio.jdbc.SqlFragment.Setter
import zio.json.JsonDecoder
import zio.json.JsonEncoder

/** Type for the primary key of table `sales.shoppingcartitem` */
case class ShoppingcartitemId(value: Int) extends AnyVal
object ShoppingcartitemId {
  implicit lazy val arraySetter: Setter[Array[ShoppingcartitemId]] = adventureworks.IntArraySetter.contramap(_.map(_.value))
  implicit lazy val bijection: Bijection[ShoppingcartitemId, Int] = Bijection[ShoppingcartitemId, Int](_.value)(ShoppingcartitemId.apply)
  implicit lazy val jdbcDecoder: JdbcDecoder[ShoppingcartitemId] = JdbcDecoder.intDecoder.map(ShoppingcartitemId.apply)
  implicit lazy val jdbcEncoder: JdbcEncoder[ShoppingcartitemId] = JdbcEncoder.intEncoder.contramap(_.value)
  implicit lazy val jsonDecoder: JsonDecoder[ShoppingcartitemId] = JsonDecoder.int.map(ShoppingcartitemId.apply)
  implicit lazy val jsonEncoder: JsonEncoder[ShoppingcartitemId] = JsonEncoder.int.contramap(_.value)
  implicit lazy val ordering: Ordering[ShoppingcartitemId] = Ordering.by(_.value)
  implicit lazy val parameterMetadata: ParameterMetaData[ShoppingcartitemId] = ParameterMetaData.instance[ShoppingcartitemId](ParameterMetaData.IntParameterMetaData.sqlType, ParameterMetaData.IntParameterMetaData.jdbcType)
  implicit lazy val setter: Setter[ShoppingcartitemId] = Setter.intSetter.contramap(_.value)
}
