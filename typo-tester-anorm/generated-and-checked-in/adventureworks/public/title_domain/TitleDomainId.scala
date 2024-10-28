/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package public
package title_domain

import anorm.Column
import anorm.ParameterMetaData
import anorm.ToStatement
import java.sql.Types
import play.api.libs.json.JsValue
import play.api.libs.json.Reads
import play.api.libs.json.Writes

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
              
  implicit lazy val arrayColumn: Column[Array[TitleDomainId]] = ShortText.arrayColumn.map(_.map(TitleDomainId.apply))
  implicit lazy val arrayToStatement: ToStatement[Array[TitleDomainId]] = ShortText.arrayToStatement.contramap(_.map(_.value))
  implicit lazy val column: Column[TitleDomainId] = ShortText.column.map(TitleDomainId.apply)
  implicit lazy val ordering: Ordering[TitleDomainId] = Ordering.by(_.value)
  implicit lazy val parameterMetadata: ParameterMetaData[TitleDomainId] = new ParameterMetaData[TitleDomainId] {
    override def sqlType: String = """"public"."short_text""""
    override def jdbcType: Int = Types.OTHER
  }
  implicit lazy val reads: Reads[TitleDomainId] = Reads[TitleDomainId]{(value: JsValue) => value.validate(ShortText.reads).map(TitleDomainId.apply)}
  implicit lazy val text: Text[TitleDomainId] = new Text[TitleDomainId] {
    override def unsafeEncode(v: TitleDomainId, sb: StringBuilder) = ShortText.text.unsafeEncode(v.value, sb)
    override def unsafeArrayEncode(v: TitleDomainId, sb: StringBuilder) = ShortText.text.unsafeArrayEncode(v.value, sb)
  }
  implicit lazy val toStatement: ToStatement[TitleDomainId] = ShortText.toStatement.contramap(_.value)
  implicit lazy val writes: Writes[TitleDomainId] = Writes[TitleDomainId](value => ShortText.writes.writes(value.value))
}