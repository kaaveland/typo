/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package transactionhistory

import doobie.util.Get
import doobie.util.Put
import doobie.util.meta.Meta
import io.circe.Decoder
import io.circe.Encoder
import typo.dsl.Bijection

/** Type for the primary key of table `production.transactionhistory` */
case class TransactionhistoryId(value: Int) extends AnyVal
object TransactionhistoryId {
  implicit lazy val arrayGet: Get[Array[TransactionhistoryId]] = adventureworks.IntegerArrayMeta.get.map(_.map(TransactionhistoryId.apply))
  implicit lazy val arrayPut: Put[Array[TransactionhistoryId]] = adventureworks.IntegerArrayMeta.put.contramap(_.map(_.value))
  implicit lazy val bijection: Bijection[TransactionhistoryId, Int] = Bijection[TransactionhistoryId, Int](_.value)(TransactionhistoryId.apply)
  implicit lazy val decoder: Decoder[TransactionhistoryId] = Decoder.decodeInt.map(TransactionhistoryId.apply)
  implicit lazy val encoder: Encoder[TransactionhistoryId] = Encoder.encodeInt.contramap(_.value)
  implicit lazy val get: Get[TransactionhistoryId] = Meta.IntMeta.get.map(TransactionhistoryId.apply)
  implicit lazy val ordering: Ordering[TransactionhistoryId] = Ordering.by(_.value)
  implicit lazy val put: Put[TransactionhistoryId] = Meta.IntMeta.put.contramap(_.value)
}
