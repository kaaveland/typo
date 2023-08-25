/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks

import cats.data.NonEmptyList
import doobie.util.Get
import doobie.util.Put
import io.circe.Decoder
import io.circe.Encoder
import org.postgresql.geometric.PGcircle

/** This represents circle datatype in PostgreSQL, consisting of a point and a radius */
case class TypoCircle(center: TypoPoint, radius: Double)

object TypoCircle {
  implicit lazy val arrayGet: Get[Array[TypoCircle]] = Get.Advanced.array[AnyRef](NonEmptyList.one("_circle"))
    .map(_.map(v => TypoCircle(TypoPoint(v.asInstanceOf[PGcircle].center.x, v.asInstanceOf[PGcircle].center.y), v.asInstanceOf[PGcircle].radius)))
  implicit lazy val arrayPut: Put[Array[TypoCircle]] = Put.Advanced.array[AnyRef](NonEmptyList.one("_circle"), "circle")
    .contramap(_.map(v => new PGcircle(v.center.x, v.center.y, v.radius)))
  implicit lazy val decoder: Decoder[TypoCircle] = Decoder.forProduct2[TypoCircle, TypoPoint, Double]("center", "radius")(TypoCircle.apply)(TypoPoint.decoder, Decoder.decodeDouble)
  implicit lazy val encoder: Encoder[TypoCircle] = Encoder.forProduct2[TypoCircle, TypoPoint, Double]("center", "radius")(x => (x.center, x.radius))(TypoPoint.encoder, Encoder.encodeDouble)
  implicit lazy val get: Get[TypoCircle] = Get.Advanced.other[PGcircle](NonEmptyList.one("circle"))
    .map(v => TypoCircle(TypoPoint(v.center.x, v.center.y), v.radius))
  implicit def ordering(implicit O0: Ordering[TypoPoint]): Ordering[TypoCircle] = Ordering.by(x => (x.center, x.radius))
  implicit lazy val put: Put[TypoCircle] = Put.Advanced.other[PGcircle](NonEmptyList.one("circle")).contramap(v => new PGcircle(v.center.x, v.center.y, v.radius))
}