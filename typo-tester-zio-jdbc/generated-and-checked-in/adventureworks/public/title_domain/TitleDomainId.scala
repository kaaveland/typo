/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package public
package title_domain

import java.sql.Types
import typo.dsl.PGType
import zio.jdbc.JdbcDecoder
import zio.jdbc.JdbcEncoder
import zio.jdbc.SqlFragment.Setter
import zio.json.JsonDecoder
import zio.json.JsonEncoder

/** Type for the primary key of table `public.title_domain`. It has some known values: 
  *  - dr
  *  - mr
  *  - ms
  *  - phd
  */
sealed abstract class TitleDomainId(val value: ShortText)

object TitleDomainId {
  def apply(underlying: ShortText): TitleDomainId =
    ByName.getOrElse(underlying, Unknown(underlying))
  def shortText(value: String): TitleDomainId = TitleDomainId(ShortText(value))
  case object dr extends TitleDomainId(ShortText("dr"))
  case object mr extends TitleDomainId(ShortText("mr"))
  case object ms extends TitleDomainId(ShortText("ms"))
  case object phd extends TitleDomainId(ShortText("phd"))
  case class Unknown(override val value: ShortText) extends TitleDomainId(value)
  val All: List[TitleDomainId] = List(dr, mr, ms, phd)
  val ByName: Map[ShortText, TitleDomainId] = All.map(x => (x.value, x)).toMap
              
  implicit lazy val arrayJdbcDecoder: JdbcDecoder[Array[TitleDomainId]] = JdbcDecoder[Array[ShortText]].map(a => if (a == null) null else a.map(apply))
  implicit lazy val arrayJdbcEncoder: JdbcEncoder[Array[TitleDomainId]] = JdbcEncoder.singleParamEncoder(using arraySetter)
  implicit lazy val arraySetter: Setter[Array[TitleDomainId]] = ShortText.arraySetter.contramap(_.map(_.value))
  implicit lazy val jdbcDecoder: JdbcDecoder[TitleDomainId] = ShortText.jdbcDecoder.map(TitleDomainId.apply)
  implicit lazy val jdbcEncoder: JdbcEncoder[TitleDomainId] = ShortText.jdbcEncoder.contramap(_.value)
  implicit lazy val jsonDecoder: JsonDecoder[TitleDomainId] = ShortText.jsonDecoder.map(TitleDomainId.apply)
  implicit lazy val jsonEncoder: JsonEncoder[TitleDomainId] = ShortText.jsonEncoder.contramap(_.value)
  implicit lazy val ordering: Ordering[TitleDomainId] = Ordering.by(_.value)
  implicit lazy val pgType: PGType[TitleDomainId] = PGType.instance[TitleDomainId](""""public"."short_text"""", Types.OTHER)
  implicit lazy val setter: Setter[TitleDomainId] = ShortText.setter.contramap(_.value)
  implicit lazy val text: Text[TitleDomainId] = new Text[TitleDomainId] {
    override def unsafeEncode(v: TitleDomainId, sb: StringBuilder) = ShortText.text.unsafeEncode(v.value, sb)
    override def unsafeArrayEncode(v: TitleDomainId, sb: StringBuilder) = ShortText.text.unsafeArrayEncode(v.value, sb)
  }
}
