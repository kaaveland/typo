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
import org.postgresql.geometric.PGpath
import org.postgresql.geometric.PGpoint

/** This implements a path (a multiple segmented line, which may be closed) */
case class TypoPath(open: Boolean, points: List[TypoPoint])

object TypoPath {
  implicit lazy val arrayGet: Get[Array[TypoPath]] = Get.Advanced.array[AnyRef](NonEmptyList.one("_path"))
    .map(_.map(v => TypoPath(v.asInstanceOf[PGpath].isOpen, v.asInstanceOf[PGpath].points.map(p => TypoPoint(p.x, p.y)).toList)))
  implicit lazy val arrayPut: Put[Array[TypoPath]] = Put.Advanced.array[AnyRef](NonEmptyList.one("_path"), "path")
    .contramap(_.map(v => new PGpath(v.points.map(p => new PGpoint(p.x, p.y)).toArray, v.open)))
  implicit lazy val decoder: Decoder[TypoPath] = Decoder.forProduct2[TypoPath, Boolean, List[TypoPoint]]("open", "points")(TypoPath.apply)(Decoder.decodeBoolean, Decoder[List[TypoPoint]])
  implicit lazy val encoder: Encoder[TypoPath] = Encoder.forProduct2[TypoPath, Boolean, List[TypoPoint]]("open", "points")(x => (x.open, x.points))(Encoder.encodeBoolean, Encoder[List[TypoPoint]])
  implicit lazy val get: Get[TypoPath] = Get.Advanced.other[PGpath](NonEmptyList.one("path"))
    .map(v => TypoPath(v.isOpen, v.points.map(p => TypoPoint(p.x, p.y)).toList))
  implicit def ordering(implicit O0: Ordering[List[TypoPoint]]): Ordering[TypoPath] = Ordering.by(x => (x.open, x.points))
  implicit lazy val put: Put[TypoPath] = Put.Advanced.other[PGpath](NonEmptyList.one("path")).contramap(v => new PGpath(v.points.map(p => new PGpoint(p.x, p.y)).toArray, v.open))
}