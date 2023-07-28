/**
 * File automatically generated by `typo` for its own test suite.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN
 */
package testdb
package hardcoded
package myschema

import doobie.util.Get
import doobie.util.Put
import doobie.util.Read
import doobie.util.Write
import doobie.util.meta.Meta
import io.circe.Decoder
import io.circe.Encoder

/** Enum `myschema.sector`
  *  - PUBLIC
  *  - PRIVATE
  *  - OTHER
  */
sealed abstract class Sector(val value: String)

object Sector {
  case object `_public` extends Sector("PUBLIC")
  case object `_private` extends Sector("PRIVATE")
  case object `_other` extends Sector("OTHER")
  val All: List[Sector] = List(`_public`, `_private`, `_other`)
  val Names: String = All.map(_.value).mkString(", ")
  val ByName: Map[String, Sector] = All.map(x => (x.value, x)).toMap
              
  implicit val arrayPut: Put[Array[Sector]] = testdb.hardcoded.StringArrayMeta.put.contramap(_.map(_.value))
  implicit val decoder: Decoder[Sector] = Decoder[String].emap(str => ByName.get(str).toRight(s"'$str' does not match any of the following legal values: $Names"))
  implicit val encoder: Encoder[Sector] = Encoder[String].contramap(_.value)
  implicit val get: Get[Sector] = Get[String].temap { str => ByName.get(str).toRight(s"$str was not among ${ByName.keys}") }
  implicit val put: Put[Sector] = Meta.StringMeta.put.contramap(_.value)
  implicit val read: Read[Sector] = Read.fromGet(get)
  implicit val write: Write[Sector] = Write.fromPut(put)
}