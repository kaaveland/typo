/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package public
package issue142

import anorm.Column
import anorm.ParameterMetaData
import anorm.ToStatement
import java.sql.Types
import play.api.libs.json.JsValue
import play.api.libs.json.Reads
import play.api.libs.json.Writes

/** Type for the primary key of table `public.issue142`. It has some known values: 
  *  - aa
  *  - bb
  */
sealed abstract class Issue142Id(val value: String)

object Issue142Id {
  def apply(underlying: String): Issue142Id =
    ByName.getOrElse(underlying, Unknown(underlying))
  case object aa extends Issue142Id("aa")
  case object bb extends Issue142Id("bb")
  case class Unknown(override val value: String) extends Issue142Id(value)
  val All: List[Issue142Id] = List(aa, bb)
  val ByName: Map[String, Issue142Id] = All.map(x => (x.value, x)).toMap
              
  implicit lazy val arrayColumn: Column[Array[Issue142Id]] = Column.columnToArray[String](Column.columnToString, implicitly).map(_.map(Issue142Id.apply))
  implicit lazy val arrayToStatement: ToStatement[Array[Issue142Id]] = ToStatement.arrayToParameter(ParameterMetaData.StringParameterMetaData).contramap(_.map(_.value))
  implicit lazy val column: Column[Issue142Id] = Column.columnToString.map(Issue142Id.apply)
  implicit lazy val ordering: Ordering[Issue142Id] = Ordering.by(_.value)
  implicit lazy val parameterMetadata: ParameterMetaData[Issue142Id] = new ParameterMetaData[Issue142Id] {
    override def sqlType: String = "text"
    override def jdbcType: Int = Types.OTHER
  }
  implicit lazy val reads: Reads[Issue142Id] = Reads[Issue142Id]{(value: JsValue) => value.validate(Reads.StringReads).map(Issue142Id.apply)}
  implicit lazy val text: Text[Issue142Id] = new Text[Issue142Id] {
    override def unsafeEncode(v: Issue142Id, sb: StringBuilder) = Text.stringInstance.unsafeEncode(v.value, sb)
    override def unsafeArrayEncode(v: Issue142Id, sb: StringBuilder) = Text.stringInstance.unsafeArrayEncode(v.value, sb)
  }
  implicit lazy val toStatement: ToStatement[Issue142Id] = ToStatement.stringToStatement.contramap(_.value)
  implicit lazy val writes: Writes[Issue142Id] = Writes[Issue142Id](value => Writes.StringWrites.writes(value.value))
}
