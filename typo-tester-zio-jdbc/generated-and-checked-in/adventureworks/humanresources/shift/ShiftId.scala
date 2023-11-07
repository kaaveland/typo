/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package humanresources
package shift

import typo.dsl.Bijection
import typo.dsl.ParameterMetaData
import zio.jdbc.JdbcDecoder
import zio.jdbc.JdbcEncoder
import zio.jdbc.SqlFragment.Setter
import zio.json.JsonDecoder
import zio.json.JsonEncoder

/** Type for the primary key of table `humanresources.shift` */
case class ShiftId(value: Int) extends AnyVal
object ShiftId {
  implicit lazy val arraySetter: Setter[Array[ShiftId]] = adventureworks.IntArraySetter.contramap(_.map(_.value))
  implicit lazy val bijection: Bijection[ShiftId, Int] = Bijection[ShiftId, Int](_.value)(ShiftId.apply)
  implicit lazy val jdbcDecoder: JdbcDecoder[ShiftId] = JdbcDecoder.intDecoder.map(ShiftId.apply)
  implicit lazy val jdbcEncoder: JdbcEncoder[ShiftId] = JdbcEncoder.intEncoder.contramap(_.value)
  implicit lazy val jsonDecoder: JsonDecoder[ShiftId] = JsonDecoder.int.map(ShiftId.apply)
  implicit lazy val jsonEncoder: JsonEncoder[ShiftId] = JsonEncoder.int.contramap(_.value)
  implicit lazy val ordering: Ordering[ShiftId] = Ordering.by(_.value)
  implicit lazy val parameterMetadata: ParameterMetaData[ShiftId] = ParameterMetaData.instance[ShiftId](ParameterMetaData.IntParameterMetaData.sqlType, ParameterMetaData.IntParameterMetaData.jdbcType)
  implicit lazy val setter: Setter[ShiftId] = Setter.intSetter.contramap(_.value)
}
