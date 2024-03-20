/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package public

import adventureworks.Text
import anorm.Column
import anorm.ParameterMetaData
import anorm.ToStatement
import play.api.libs.json.Reads
import play.api.libs.json.Writes
import typo.dsl.Bijection

/** Domain `public.Flag`
  * No constraint
  */
case class Flag(value: Boolean)
object Flag {
  implicit lazy val arrayColumn: Column[Array[Flag]] = Column.columnToArray(column, implicitly)
  implicit lazy val arrayToStatement: ToStatement[Array[Flag]] = adventureworks.BooleanArrayToStatement.contramap(_.map(_.value))
  implicit lazy val bijection: Bijection[Flag, Boolean] = Bijection[Flag, Boolean](_.value)(Flag.apply)
  implicit lazy val column: Column[Flag] = Column.columnToBoolean.map(Flag.apply)
  implicit lazy val ordering: Ordering[Flag] = Ordering.by(_.value)
  implicit lazy val parameterMetadata: ParameterMetaData[Flag] = new ParameterMetaData[Flag] {
    override def sqlType: String = ParameterMetaData.BooleanParameterMetaData.sqlType
    override def jdbcType: Int = ParameterMetaData.BooleanParameterMetaData.jdbcType
  }
  implicit lazy val reads: Reads[Flag] = Reads.BooleanReads.map(Flag.apply)
  implicit lazy val text: Text[Flag] = new Text[Flag] {
    override def unsafeEncode(v: Flag, sb: StringBuilder) = Text.booleanInstance.unsafeEncode(v.value, sb)
    override def unsafeArrayEncode(v: Flag, sb: StringBuilder) = Text.booleanInstance.unsafeArrayEncode(v.value, sb)
  }
  implicit lazy val toStatement: ToStatement[Flag] = ToStatement.booleanToStatement.contramap(_.value)
  implicit lazy val writes: Writes[Flag] = Writes.BooleanWrites.contramap(_.value)
}