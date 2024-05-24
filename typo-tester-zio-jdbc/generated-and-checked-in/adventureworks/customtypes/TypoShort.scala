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
import typo.dsl.Bijection
import typo.dsl.ParameterMetaData
import zio.jdbc.JdbcDecoder
import zio.jdbc.JdbcEncoder
import zio.jdbc.SqlFragment.Setter
import zio.json.JsonDecoder
import zio.json.JsonEncoder

/** Short primitive */
case class TypoShort(value: Short)

object TypoShort {
  implicit object numeric extends Numeric[TypoShort] {
      override def compare(x: TypoShort, y: TypoShort): Int = java.lang.Short.compare(x.value, y.value)
      override def plus(x: TypoShort, y: TypoShort): TypoShort = TypoShort((x.value + y.value).toShort)
      override def minus(x: TypoShort, y: TypoShort): TypoShort = TypoShort((x.value - y.value).toShort)
      override def times(x: TypoShort, y: TypoShort): TypoShort = TypoShort((x.value * y.value).toShort)
      override def negate(x: TypoShort): TypoShort = TypoShort((-x.value).toShort)
      override def fromInt(x: Int): TypoShort = TypoShort(x.toShort)
      override def toInt(x: TypoShort): Int = x.value.toInt
      override def toLong(x: TypoShort): Long = x.value.toLong
      override def toFloat(x: TypoShort): Float = x.value.toFloat
      override def toDouble(x: TypoShort): Double = x.value.toDouble
      def parseString(str: String): Option[TypoShort] = str.toShortOption.map(TypoShort.apply)
    }
  implicit lazy val arrayJdbcDecoder: JdbcDecoder[Array[TypoShort]] = JdbcDecoder[Array[TypoShort]]((rs: ResultSet) => (i: Int) =>
    rs.getArray(i) match {
      case null => null
      case arr => arr.getArray.asInstanceOf[Array[AnyRef]].map(x => TypoShort(x.asInstanceOf[java.lang.Short]))
    },
    "Array[java.lang.Integer]"
  )
  implicit lazy val arrayJdbcEncoder: JdbcEncoder[Array[TypoShort]] = JdbcEncoder.singleParamEncoder(using arraySetter)
  implicit lazy val arraySetter: Setter[Array[TypoShort]] = Setter.forSqlType((ps, i, v) =>
    ps.setArray(
      i,
      ps.getConnection.createArrayOf(
        "int2",
        v.map { vv =>
          vv.value: java.lang.Short
        }
      )
    ),
    Types.ARRAY
  )
  implicit lazy val bijection: Bijection[TypoShort, Short] = Bijection[TypoShort, Short](_.value)(TypoShort.apply)
  implicit lazy val jdbcDecoder: JdbcDecoder[TypoShort] = JdbcDecoder[TypoShort](
    (rs: ResultSet) => (i: Int) => {
      val v = rs.getObject(i)
      if (v eq null) null else TypoShort(v.asInstanceOf[Integer].toShort)
    },
    "java.lang.Integer"
  )
  implicit lazy val jdbcEncoder: JdbcEncoder[TypoShort] = JdbcEncoder.singleParamEncoder(using setter)
  implicit lazy val jsonDecoder: JsonDecoder[TypoShort] = JsonDecoder[Short].map(TypoShort.apply)
  implicit lazy val jsonEncoder: JsonEncoder[TypoShort] = JsonEncoder[Short].contramap(_.value)
  implicit lazy val ordering: Ordering[TypoShort] = Ordering.by(_.value)
  implicit lazy val parameterMetadata: ParameterMetaData[TypoShort] = ParameterMetaData.instance[TypoShort]("int2", Types.OTHER)
  implicit lazy val setter: Setter[TypoShort] = Setter.other(
    (ps, i, v) => {
      ps.setObject(
        i,
        v.value.toInt
      )
    },
    "int2"
  )
  implicit lazy val text: Text[TypoShort] = new Text[TypoShort] {
    override def unsafeEncode(v: TypoShort, sb: StringBuilder) = Text[Short].unsafeEncode(v.value, sb)
    override def unsafeArrayEncode(v: TypoShort, sb: StringBuilder) = Text[Short].unsafeArrayEncode(v.value, sb)
  }
}
