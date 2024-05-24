/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package customtypes

import adventureworks.Text
import anorm.Column
import anorm.ParameterMetaData
import anorm.ToStatement
import anorm.TypeDoesNotMatch
import java.sql.Types
import org.postgresql.jdbc.PgArray
import play.api.libs.json.Reads
import play.api.libs.json.Writes
import typo.dsl.Bijection

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
  implicit lazy val arrayColumn: Column[Array[TypoShort]] = Column.nonNull[Array[TypoShort]]((v1: Any, _) =>
    v1 match {
        case v: PgArray =>
         v.getArray match {
           case v: Array[?] =>
             Right(v.map(v => TypoShort(v.asInstanceOf[java.lang.Short])))
           case other => Left(TypeDoesNotMatch(s"Expected one-dimensional array from JDBC to produce an array of TypoShort, got ${other.getClass.getName}"))
         }
      case other => Left(TypeDoesNotMatch(s"Expected instance of org.postgresql.jdbc.PgArray, got ${other.getClass.getName}"))
    }
  )
  implicit lazy val arrayToStatement: ToStatement[Array[TypoShort]] = ToStatement[Array[TypoShort]]((s, index, v) => s.setArray(index, s.getConnection.createArrayOf("int2", v.map(v => v.value: java.lang.Short))))
  implicit lazy val bijection: Bijection[TypoShort, Short] = Bijection[TypoShort, Short](_.value)(TypoShort.apply)
  implicit lazy val column: Column[TypoShort] = Column.nonNull[TypoShort]((v1: Any, _) =>
    v1 match {
      case v: Integer => Right(TypoShort(v.toShort))
      case other => Left(TypeDoesNotMatch(s"Expected instance of java.lang.Integer, got ${other.getClass.getName}"))
    }
  )
  implicit lazy val ordering: Ordering[TypoShort] = Ordering.by(_.value)
  implicit lazy val parameterMetadata: ParameterMetaData[TypoShort] = new ParameterMetaData[TypoShort] {
    override def sqlType: String = "int2"
    override def jdbcType: Int = Types.OTHER
  }
  implicit lazy val reads: Reads[TypoShort] = implicitly[Reads[Short]].map(TypoShort.apply)
  implicit lazy val text: Text[TypoShort] = new Text[TypoShort] {
    override def unsafeEncode(v: TypoShort, sb: StringBuilder) = Text[Short].unsafeEncode(v.value, sb)
    override def unsafeArrayEncode(v: TypoShort, sb: StringBuilder) = Text[Short].unsafeArrayEncode(v.value, sb)
  }
  implicit lazy val toStatement: ToStatement[TypoShort] = ToStatement[TypoShort]((s, index, v) => s.setObject(index, v.value.toInt))
  implicit lazy val writes: Writes[TypoShort] = implicitly[Writes[Short]].contramap(_.value)
}
