/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package customtypes

import cats.data.NonEmptyList
import doobie.postgres.Text
import doobie.util.Get
import doobie.util.Put
import io.circe.Decoder
import io.circe.Encoder
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
  implicit lazy val arrayGet: Get[Array[TypoShort]] = Get.Advanced.array[AnyRef](NonEmptyList.one("_int2"))
    .map(_.map(v => TypoShort(v.asInstanceOf[java.lang.Short])))
  implicit lazy val arrayPut: Put[Array[TypoShort]] = Put.Advanced.array[AnyRef](NonEmptyList.one("_int2"), "int2")
    .contramap(_.map(v => v.value: java.lang.Short))
  implicit lazy val bijection: Bijection[TypoShort, Short] = Bijection[TypoShort, Short](_.value)(TypoShort.apply)
  implicit lazy val decoder: Decoder[TypoShort] = Decoder[Short].map(TypoShort.apply)
  implicit lazy val encoder: Encoder[TypoShort] = Encoder[Short].contramap(_.value)
  implicit lazy val get: Get[TypoShort] = Get.Advanced.other[Integer](NonEmptyList.one("int2"))
    .map(v => TypoShort(v.toShort))
  implicit lazy val ordering: Ordering[TypoShort] = Ordering.by(_.value)
  implicit lazy val put: Put[TypoShort] = Put.Advanced.other[Integer](NonEmptyList.one("int2")).contramap(v => v.value.toInt)
  implicit lazy val text: Text[TypoShort] = new Text[TypoShort] {
    override def unsafeEncode(v: TypoShort, sb: StringBuilder) = Text[Short].unsafeEncode(v.value, sb)
    override def unsafeArrayEncode(v: TypoShort, sb: StringBuilder) = Text[Short].unsafeArrayEncode(v.value, sb)
  }
}
