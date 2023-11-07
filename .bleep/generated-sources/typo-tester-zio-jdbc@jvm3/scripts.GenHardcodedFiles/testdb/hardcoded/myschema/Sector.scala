/**
 * File automatically generated by `typo` for its own test suite.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN
 */
package testdb
package hardcoded
package myschema

import java.sql.ResultSet
import typo.dsl.ParameterMetaData
import zio.jdbc.JdbcDecoder
import zio.jdbc.JdbcDecoderError
import zio.jdbc.JdbcEncoder
import zio.jdbc.SqlFragment.Setter
import zio.json.JsonDecoder
import zio.json.JsonEncoder

/** Enum `myschema.sector`
  *  - PUBLIC
  *  - PRIVATE
  *  - OTHER
  */
sealed abstract class Sector(val value: String)

object Sector {
  def apply(str: String): Either[String, Sector] =
    ByName.get(str).toRight(s"'$str' does not match any of the following legal values: $Names")
  def force(str: String): Sector =
    apply(str) match {
      case Left(msg) => sys.error(msg)
      case Right(value) => value
    }
  case object `_public` extends Sector("PUBLIC")
  case object `_private` extends Sector("PRIVATE")
  case object `_other` extends Sector("OTHER")
  val All: List[Sector] = List(`_public`, `_private`, `_other`)
  val Names: String = All.map(_.value).mkString(", ")
  val ByName: Map[String, Sector] = All.map(x => (x.value, x)).toMap
              
  implicit lazy val arrayJdbcDecoder: JdbcDecoder[Array[Sector]] = testdb.hardcoded.StringArrayDecoder.map(a => if (a == null) null else a.map(force))
  implicit lazy val arrayJdbcEncoder: JdbcEncoder[Array[Sector]] = JdbcEncoder.singleParamEncoder(arraySetter)
  implicit lazy val arraySetter: Setter[Array[Sector]] = testdb.hardcoded.StringArraySetter.contramap(_.map(_.value))
  implicit lazy val jdbcDecoder: JdbcDecoder[Sector] = JdbcDecoder.stringDecoder.flatMap { s =>
    new JdbcDecoder[Sector] {
      override def unsafeDecode(columIndex: Int, rs: ResultSet): (Int, Sector) = {
        def error(msg: String): JdbcDecoderError =
          JdbcDecoderError(
            message = s"Error decoding Sector from ResultSet",
            cause = new RuntimeException(msg),
            metadata = rs.getMetaData,
            row = rs.getRow
          )
  
        Sector.apply(s).fold(e => throw error(e), (columIndex, _))
      }
    }
  }
  implicit lazy val jdbcEncoder: JdbcEncoder[Sector] = JdbcEncoder.stringEncoder.contramap(_.value)
  implicit lazy val jsonDecoder: JsonDecoder[Sector] = JsonDecoder.string.mapOrFail(Sector.apply)
  implicit lazy val jsonEncoder: JsonEncoder[Sector] = JsonEncoder.string.contramap(_.value)
  implicit lazy val ordering: Ordering[Sector] = Ordering.by(_.value)
  implicit lazy val parameterMetadata: ParameterMetaData[Sector] = ParameterMetaData.instance[Sector](ParameterMetaData.StringParameterMetaData.sqlType, ParameterMetaData.StringParameterMetaData.jdbcType)
  implicit lazy val setter: Setter[Sector] = Setter.stringSetter.contramap(_.value)
}
