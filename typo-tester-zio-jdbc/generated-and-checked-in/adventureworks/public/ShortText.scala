/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package public

import adventureworks.Text
import java.sql.Types
import typo.dsl.Bijection
import typo.dsl.PGType
import zio.jdbc.JdbcDecoder
import zio.jdbc.JdbcEncoder
import zio.jdbc.SqlFragment.Setter
import zio.json.JsonDecoder
import zio.json.JsonEncoder

/** Domain `public.short_text`
  * Constraint: CHECK ((length(VALUE) <= 55))
  */
case class ShortText(value: String)
object ShortText {
  implicit lazy val arrayJdbcDecoder: JdbcDecoder[Array[ShortText]] = adventureworks.StringArrayDecoder.map(_.map(ShortText.apply))
  implicit lazy val arrayJdbcEncoder: JdbcEncoder[Array[ShortText]] = adventureworks.StringArrayEncoder.contramap(_.map(_.value))
  implicit lazy val arraySetter: Setter[Array[ShortText]] = adventureworks.StringArraySetter.contramap(_.map(_.value))
  implicit lazy val bijection: Bijection[ShortText, String] = Bijection[ShortText, String](_.value)(ShortText.apply)
  implicit lazy val jdbcDecoder: JdbcDecoder[ShortText] = JdbcDecoder.stringDecoder.map(ShortText.apply)
  implicit lazy val jdbcEncoder: JdbcEncoder[ShortText] = JdbcEncoder.stringEncoder.contramap(_.value)
  implicit lazy val jsonDecoder: JsonDecoder[ShortText] = JsonDecoder.string.map(ShortText.apply)
  implicit lazy val jsonEncoder: JsonEncoder[ShortText] = JsonEncoder.string.contramap(_.value)
  implicit lazy val ordering: Ordering[ShortText] = Ordering.by(_.value)
  implicit lazy val pgType: PGType[ShortText] = PGType.instance(""""public"."short_text"""", Types.OTHER)
  implicit lazy val setter: Setter[ShortText] = Setter.stringSetter.contramap(_.value)
  implicit lazy val text: Text[ShortText] = new Text[ShortText] {
    override def unsafeEncode(v: ShortText, sb: StringBuilder) = Text.stringInstance.unsafeEncode(v.value, sb)
    override def unsafeArrayEncode(v: ShortText, sb: StringBuilder) = Text.stringInstance.unsafeArrayEncode(v.value, sb)
  }
}