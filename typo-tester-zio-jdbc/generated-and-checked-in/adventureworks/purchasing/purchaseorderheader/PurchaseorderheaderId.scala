/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package purchasing
package purchaseorderheader

import typo.dsl.Bijection
import typo.dsl.ParameterMetaData
import zio.jdbc.JdbcDecoder
import zio.jdbc.JdbcEncoder
import zio.jdbc.SqlFragment.Setter
import zio.json.JsonDecoder
import zio.json.JsonEncoder

/** Type for the primary key of table `purchasing.purchaseorderheader` */
case class PurchaseorderheaderId(value: Int) extends AnyVal
object PurchaseorderheaderId {
  implicit lazy val arraySetter: Setter[Array[PurchaseorderheaderId]] = adventureworks.IntArraySetter.contramap(_.map(_.value))
  implicit lazy val bijection: Bijection[PurchaseorderheaderId, Int] = Bijection[PurchaseorderheaderId, Int](_.value)(PurchaseorderheaderId.apply)
  implicit lazy val jdbcDecoder: JdbcDecoder[PurchaseorderheaderId] = JdbcDecoder.intDecoder.map(PurchaseorderheaderId.apply)
  implicit lazy val jdbcEncoder: JdbcEncoder[PurchaseorderheaderId] = JdbcEncoder.intEncoder.contramap(_.value)
  implicit lazy val jsonDecoder: JsonDecoder[PurchaseorderheaderId] = JsonDecoder.int.map(PurchaseorderheaderId.apply)
  implicit lazy val jsonEncoder: JsonEncoder[PurchaseorderheaderId] = JsonEncoder.int.contramap(_.value)
  implicit lazy val ordering: Ordering[PurchaseorderheaderId] = Ordering.by(_.value)
  implicit lazy val parameterMetadata: ParameterMetaData[PurchaseorderheaderId] = ParameterMetaData.instance[PurchaseorderheaderId](ParameterMetaData.IntParameterMetaData.sqlType, ParameterMetaData.IntParameterMetaData.jdbcType)
  implicit lazy val setter: Setter[PurchaseorderheaderId] = Setter.intSetter.contramap(_.value)
}
