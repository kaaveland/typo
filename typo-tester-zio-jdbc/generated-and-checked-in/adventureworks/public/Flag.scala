/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package public

import adventureworks.Text
import typo.dsl.Bijection
import typo.dsl.ParameterMetaData
import zio.jdbc.JdbcDecoder
import zio.jdbc.JdbcEncoder
import zio.jdbc.SqlFragment.Setter
import zio.json.JsonDecoder
import zio.json.JsonEncoder

/** Domain `public.Flag`
  * No constraint
  */
case class Flag(value: Boolean)
object Flag {
  implicit lazy val arraySetter: Setter[Array[Flag]] = adventureworks.BooleanArraySetter.contramap(_.map(_.value))
  implicit lazy val bijection: Bijection[Flag, Boolean] = Bijection[Flag, Boolean](_.value)(Flag.apply)
  implicit lazy val jdbcDecoder: JdbcDecoder[Flag] = JdbcDecoder.booleanDecoder.map(Flag.apply)
  implicit lazy val jdbcEncoder: JdbcEncoder[Flag] = JdbcEncoder.booleanEncoder.contramap(_.value)
  implicit lazy val jsonDecoder: JsonDecoder[Flag] = JsonDecoder.boolean.map(Flag.apply)
  implicit lazy val jsonEncoder: JsonEncoder[Flag] = JsonEncoder.boolean.contramap(_.value)
  implicit lazy val ordering: Ordering[Flag] = Ordering.by(_.value)
  implicit lazy val parameterMetadata: ParameterMetaData[Flag] = ParameterMetaData.instance[Flag](ParameterMetaData.BooleanParameterMetaData.sqlType, ParameterMetaData.BooleanParameterMetaData.jdbcType)
  implicit lazy val setter: Setter[Flag] = Setter.booleanSetter.contramap(_.value)
  implicit lazy val text: Text[Flag] = new Text[Flag] {
    override def unsafeEncode(v: Flag, sb: StringBuilder) = Text.booleanInstance.unsafeEncode(v.value, sb)
    override def unsafeArrayEncode(v: Flag, sb: StringBuilder) = Text.booleanInstance.unsafeArrayEncode(v.value, sb)
  }
}