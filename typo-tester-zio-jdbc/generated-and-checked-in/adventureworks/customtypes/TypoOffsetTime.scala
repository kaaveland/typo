/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package customtypes

import adventureworks.Text
import java.sql.ResultSet
import java.sql.Types
import java.time.OffsetTime
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeFormatterBuilder
import java.time.temporal.ChronoField
import java.time.temporal.ChronoUnit
import typo.dsl.Bijection
import typo.dsl.ParameterMetaData
import zio.jdbc.JdbcDecoder
import zio.jdbc.JdbcEncoder
import zio.jdbc.SqlFragment.Setter
import zio.json.JsonDecoder
import zio.json.JsonEncoder

/** This is `java.time.OffsetTime`, but with microsecond precision and transferred to and from postgres as strings. The reason is that postgres driver and db libs are broken */
case class TypoOffsetTime(value: OffsetTime)

object TypoOffsetTime {
  val parser: DateTimeFormatter = new DateTimeFormatterBuilder().appendPattern("HH:mm:ss").appendFraction(ChronoField.MICRO_OF_SECOND, 0, 6, true).appendPattern("X").toFormatter
  def apply(value: OffsetTime): TypoOffsetTime = new TypoOffsetTime(value.truncatedTo(ChronoUnit.MICROS))
  def apply(str: String): TypoOffsetTime = apply(OffsetTime.parse(str, parser))
  def now = TypoOffsetTime(OffsetTime.now)
  implicit lazy val arrayJdbcDecoder: JdbcDecoder[Array[TypoOffsetTime]] = JdbcDecoder[Array[TypoOffsetTime]]((rs: ResultSet) => (i: Int) =>
    rs.getArray(i) match {
      case null => null
      case arr => arr.getArray.asInstanceOf[Array[AnyRef]].map(x => TypoOffsetTime(OffsetTime.parse(x.asInstanceOf[String], parser)))
    },
    "Array[java.lang.String]"
  )
  implicit lazy val arrayJdbcEncoder: JdbcEncoder[Array[TypoOffsetTime]] = JdbcEncoder.singleParamEncoder(using arraySetter)
  implicit lazy val arraySetter: Setter[Array[TypoOffsetTime]] = Setter.forSqlType((ps, i, v) =>
    ps.setArray(
      i,
      ps.getConnection.createArrayOf(
        "timetz",
        v.map { vv =>
          vv.value.toString
        }
      )
    ),
    Types.ARRAY
  )
  implicit lazy val bijection: Bijection[TypoOffsetTime, OffsetTime] = Bijection[TypoOffsetTime, OffsetTime](_.value)(TypoOffsetTime.apply)
  implicit lazy val jdbcDecoder: JdbcDecoder[TypoOffsetTime] = JdbcDecoder[TypoOffsetTime](
    (rs: ResultSet) => (i: Int) => {
      val v = rs.getObject(i)
      if (v eq null) null else TypoOffsetTime(OffsetTime.parse(v.asInstanceOf[String], parser))
    },
    "java.lang.String"
  )
  implicit lazy val jdbcEncoder: JdbcEncoder[TypoOffsetTime] = JdbcEncoder.singleParamEncoder(using setter)
  implicit lazy val jsonDecoder: JsonDecoder[TypoOffsetTime] = JsonDecoder.offsetTime.map(TypoOffsetTime.apply)
  implicit lazy val jsonEncoder: JsonEncoder[TypoOffsetTime] = JsonEncoder.offsetTime.contramap(_.value)
  implicit def ordering(implicit O0: Ordering[OffsetTime]): Ordering[TypoOffsetTime] = Ordering.by(_.value)
  implicit lazy val parameterMetadata: ParameterMetaData[TypoOffsetTime] = ParameterMetaData.instance[TypoOffsetTime]("timetz", Types.OTHER)
  implicit lazy val setter: Setter[TypoOffsetTime] = Setter.other(
    (ps, i, v) => {
      ps.setObject(
        i,
        v.value.toString
      )
    },
    "timetz"
  )
  implicit lazy val text: Text[TypoOffsetTime] = new Text[TypoOffsetTime] {
    override def unsafeEncode(v: TypoOffsetTime, sb: StringBuilder) = Text.stringInstance.unsafeEncode(v.value.toString, sb)
    override def unsafeArrayEncode(v: TypoOffsetTime, sb: StringBuilder) = Text.stringInstance.unsafeArrayEncode(v.value.toString, sb)
  }
}
