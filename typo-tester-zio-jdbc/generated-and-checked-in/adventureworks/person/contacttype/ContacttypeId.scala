/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package person
package contacttype

import typo.dsl.Bijection
import typo.dsl.ParameterMetaData
import zio.jdbc.JdbcDecoder
import zio.jdbc.JdbcEncoder
import zio.jdbc.SqlFragment.Setter
import zio.json.JsonDecoder
import zio.json.JsonEncoder

/** Type for the primary key of table `person.contacttype` */
case class ContacttypeId(value: Int) extends AnyVal
object ContacttypeId {
  implicit lazy val arraySetter: Setter[Array[ContacttypeId]] = adventureworks.IntArraySetter.contramap(_.map(_.value))
  implicit lazy val bijection: Bijection[ContacttypeId, Int] = Bijection[ContacttypeId, Int](_.value)(ContacttypeId.apply)
  implicit lazy val jdbcDecoder: JdbcDecoder[ContacttypeId] = JdbcDecoder.intDecoder.map(ContacttypeId.apply)
  implicit lazy val jdbcEncoder: JdbcEncoder[ContacttypeId] = JdbcEncoder.intEncoder.contramap(_.value)
  implicit lazy val jsonDecoder: JsonDecoder[ContacttypeId] = JsonDecoder.int.map(ContacttypeId.apply)
  implicit lazy val jsonEncoder: JsonEncoder[ContacttypeId] = JsonEncoder.int.contramap(_.value)
  implicit lazy val ordering: Ordering[ContacttypeId] = Ordering.by(_.value)
  implicit lazy val parameterMetadata: ParameterMetaData[ContacttypeId] = ParameterMetaData.instance[ContacttypeId](ParameterMetaData.IntParameterMetaData.sqlType, ParameterMetaData.IntParameterMetaData.jdbcType)
  implicit lazy val setter: Setter[ContacttypeId] = Setter.intSetter.contramap(_.value)
}
