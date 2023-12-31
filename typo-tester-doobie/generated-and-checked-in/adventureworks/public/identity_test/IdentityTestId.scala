/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package public
package identity_test

import doobie.postgres.Text
import doobie.util.Get
import doobie.util.Put
import doobie.util.meta.Meta
import io.circe.Decoder
import io.circe.Encoder
import typo.dsl.Bijection

/** Type for the primary key of table `public.identity-test` */
case class IdentityTestId(value: /* max 250 chars */ String) extends AnyVal
object IdentityTestId {
  implicit lazy val arrayGet: Get[Array[IdentityTestId]] = adventureworks.StringArrayMeta.get.map(_.map(IdentityTestId.apply))
  implicit lazy val arrayPut: Put[Array[IdentityTestId]] = adventureworks.StringArrayMeta.put.contramap(_.map(_.value))
  implicit lazy val bijection: Bijection[IdentityTestId, /* max 250 chars */ String] = Bijection[IdentityTestId, /* max 250 chars */ String](_.value)(IdentityTestId.apply)
  implicit lazy val decoder: Decoder[IdentityTestId] = Decoder.decodeString.map(IdentityTestId.apply)
  implicit lazy val encoder: Encoder[IdentityTestId] = Encoder.encodeString.contramap(_.value)
  implicit lazy val get: Get[IdentityTestId] = Meta.StringMeta.get.map(IdentityTestId.apply)
  implicit lazy val ordering: Ordering[IdentityTestId] = Ordering.by(_.value)
  implicit lazy val put: Put[IdentityTestId] = Meta.StringMeta.put.contramap(_.value)
  implicit lazy val text: Text[IdentityTestId] = new Text[IdentityTestId] {
    override def unsafeEncode(v: IdentityTestId, sb: StringBuilder) = Text.stringInstance.unsafeEncode(v.value, sb)
    override def unsafeArrayEncode(v: IdentityTestId, sb: StringBuilder) = Text.stringInstance.unsafeArrayEncode(v.value, sb)
  }
}
