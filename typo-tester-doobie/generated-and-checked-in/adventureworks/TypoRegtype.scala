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
import org.postgresql.util.PGobject
import typo.dsl.Bijection

/** regtype (via PGObject) */
case class TypoRegtype(value: String)

object TypoRegtype {
  implicit lazy val arrayGet: Get[Array[TypoRegtype]] = Get.Advanced.array[AnyRef](NonEmptyList.one("_regtype"))
    .map(_.map(v => TypoRegtype(v.asInstanceOf[String])))
  implicit lazy val arrayPut: Put[Array[TypoRegtype]] = Put.Advanced.array[AnyRef](NonEmptyList.one("_regtype"), "regtype")
    .contramap(_.map(v => {
                            val obj = new PGobject
                            obj.setType("regtype")
                            obj.setValue(v.value)
                            obj
                          }))
  implicit lazy val bijection: Bijection[TypoRegtype, String] = Bijection[TypoRegtype, String](_.value)(TypoRegtype.apply)
  implicit lazy val decoder: Decoder[TypoRegtype] = Decoder.decodeString.map(TypoRegtype.apply)
  implicit lazy val encoder: Encoder[TypoRegtype] = Encoder.encodeString.contramap(_.value)
  implicit lazy val get: Get[TypoRegtype] = Get.Advanced.other[PGobject](NonEmptyList.one("regtype"))
    .map(v => TypoRegtype(v.getValue))
  implicit lazy val ordering: Ordering[TypoRegtype] = Ordering.by(_.value)
  implicit lazy val put: Put[TypoRegtype] = Put.Advanced.other[PGobject](NonEmptyList.one("regtype")).contramap(v => {
                                                                             val obj = new PGobject
                                                                             obj.setType("regtype")
                                                                             obj.setValue(v.value)
                                                                             obj
                                                                           })
}