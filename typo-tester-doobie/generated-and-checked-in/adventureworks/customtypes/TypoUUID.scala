/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package customtypes

import cats.data.NonEmptyList
import doobie.util.Get
import doobie.util.Put
import io.circe.Decoder
import io.circe.Encoder
import java.util.UUID
import typo.dsl.Bijection

/** UUID */
case class TypoUUID(value: UUID)

object TypoUUID {
  def apply(str: String): TypoUUID = TypoUUID(UUID.fromString(str))
  def randomUUID: TypoUUID = TypoUUID(UUID.randomUUID())
  implicit lazy val arrayGet: Get[Array[TypoUUID]] = Get.Advanced.array[AnyRef](NonEmptyList.one("_uuid"))
    .map(_.map(v => TypoUUID(v.asInstanceOf[UUID])))
  implicit lazy val arrayPut: Put[Array[TypoUUID]] = Put.Advanced.array[AnyRef](NonEmptyList.one("_uuid"), "uuid")
    .contramap(_.map(v => v.value))
  implicit lazy val bijection: Bijection[TypoUUID, UUID] = Bijection[TypoUUID, UUID](_.value)(TypoUUID.apply)
  implicit lazy val decoder: Decoder[TypoUUID] = Decoder.decodeUUID.map(TypoUUID.apply)
  implicit lazy val encoder: Encoder[TypoUUID] = Encoder.encodeUUID.contramap(_.value)
  implicit lazy val get: Get[TypoUUID] = Get.Advanced.other[UUID](NonEmptyList.one("uuid"))
    .map(v => TypoUUID(v))
  implicit def ordering(implicit O0: Ordering[UUID]): Ordering[TypoUUID] = Ordering.by(_.value)
  implicit lazy val put: Put[TypoUUID] = Put.Advanced.other[UUID](NonEmptyList.one("uuid")).contramap(v => v.value)
}