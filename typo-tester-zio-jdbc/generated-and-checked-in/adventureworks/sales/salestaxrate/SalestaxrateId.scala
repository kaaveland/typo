/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package salestaxrate

import typo.dsl.Bijection
import typo.dsl.ParameterMetaData
import zio.jdbc.JdbcDecoder
import zio.jdbc.JdbcEncoder
import zio.jdbc.SqlFragment.Setter
import zio.json.JsonDecoder
import zio.json.JsonEncoder

/** Type for the primary key of table `sales.salestaxrate` */
case class SalestaxrateId(value: Int) extends AnyVal
object SalestaxrateId {
  implicit lazy val arraySetter: Setter[Array[SalestaxrateId]] = adventureworks.IntArraySetter.contramap(_.map(_.value))
  implicit lazy val bijection: Bijection[SalestaxrateId, Int] = Bijection[SalestaxrateId, Int](_.value)(SalestaxrateId.apply)
  implicit lazy val jdbcDecoder: JdbcDecoder[SalestaxrateId] = JdbcDecoder.intDecoder.map(SalestaxrateId.apply)
  implicit lazy val jdbcEncoder: JdbcEncoder[SalestaxrateId] = JdbcEncoder.intEncoder.contramap(_.value)
  implicit lazy val jsonDecoder: JsonDecoder[SalestaxrateId] = JsonDecoder.int.map(SalestaxrateId.apply)
  implicit lazy val jsonEncoder: JsonEncoder[SalestaxrateId] = JsonEncoder.int.contramap(_.value)
  implicit lazy val ordering: Ordering[SalestaxrateId] = Ordering.by(_.value)
  implicit lazy val parameterMetadata: ParameterMetaData[SalestaxrateId] = ParameterMetaData.instance[SalestaxrateId](ParameterMetaData.IntParameterMetaData.sqlType, ParameterMetaData.IntParameterMetaData.jdbcType)
  implicit lazy val setter: Setter[SalestaxrateId] = Setter.intSetter.contramap(_.value)
}
