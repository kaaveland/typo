/**
 * File automatically generated by `typo` for its own test suite.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN
 */
package testdb
package hardcoded
package myschema
package person

import testdb.hardcoded.Text
import typo.dsl.Bijection
import typo.dsl.PGType
import zio.jdbc.JdbcDecoder
import zio.jdbc.JdbcEncoder
import zio.jdbc.SqlFragment.Setter
import zio.json.JsonDecoder
import zio.json.JsonEncoder

/** Type for the primary key of table `myschema.person` */
case class PersonId(value: Long) extends AnyVal
object PersonId {
  implicit lazy val arrayJdbcDecoder: JdbcDecoder[Array[PersonId]] = testdb.hardcoded.LongArrayDecoder.map(_.map(PersonId.apply))
  implicit lazy val arrayJdbcEncoder: JdbcEncoder[Array[PersonId]] = testdb.hardcoded.LongArrayEncoder.contramap(_.map(_.value))
  implicit lazy val arraySetter: Setter[Array[PersonId]] = testdb.hardcoded.LongArraySetter.contramap(_.map(_.value))
  implicit lazy val bijection: Bijection[PersonId, Long] = Bijection[PersonId, Long](_.value)(PersonId.apply)
  implicit lazy val jdbcDecoder: JdbcDecoder[PersonId] = JdbcDecoder.longDecoder.map(PersonId.apply)
  implicit lazy val jdbcEncoder: JdbcEncoder[PersonId] = JdbcEncoder.longEncoder.contramap(_.value)
  implicit lazy val jsonDecoder: JsonDecoder[PersonId] = JsonDecoder.long.map(PersonId.apply)
  implicit lazy val jsonEncoder: JsonEncoder[PersonId] = JsonEncoder.long.contramap(_.value)
  implicit lazy val ordering: Ordering[PersonId] = Ordering.by(_.value)
  implicit lazy val pgType: PGType[PersonId] = PGType.PGTypeLong.as
  implicit lazy val setter: Setter[PersonId] = Setter.longSetter.contramap(_.value)
  implicit lazy val text: Text[PersonId] = new Text[PersonId] {
    override def unsafeEncode(v: PersonId, sb: StringBuilder) = Text.longInstance.unsafeEncode(v.value, sb)
    override def unsafeArrayEncode(v: PersonId, sb: StringBuilder) = Text.longInstance.unsafeArrayEncode(v.value, sb)
  }
}
