/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package customtypes

import java.sql.ResultSet
import java.sql.Types
import org.postgresql.util.PGobject
import typo.dsl.Bijection
import typo.dsl.ParameterMetaData
import zio.jdbc.JdbcDecoder
import zio.jdbc.JdbcEncoder
import zio.jdbc.SqlFragment.Setter
import zio.json.JsonDecoder
import zio.json.JsonEncoder

/** oidvector (via PGObject) */
case class TypoOidVector(value: String)

object TypoOidVector {
  implicit lazy val arrayJdbcDecoder: JdbcDecoder[Array[TypoOidVector]] = JdbcDecoder[Array[TypoOidVector]]((rs: ResultSet) => (i: Int) =>
    rs.getArray(i) match {
      case null => null
      case arr => arr.getArray.asInstanceOf[Array[AnyRef]].map(x => TypoOidVector(x.asInstanceOf[String]))
    },
    "scala.Array[org.postgresql.util.PGobject]"
  )
  implicit lazy val arrayJdbcEncoder: JdbcEncoder[Array[TypoOidVector]] = JdbcEncoder.singleParamEncoder(arraySetter)
  implicit lazy val arraySetter: Setter[Array[TypoOidVector]] = Setter.forSqlType((ps, i, v) =>
    ps.setArray(
      i,
      ps.getConnection.createArrayOf(
        "oidvector",
        v.map { vv =>
          {
            val obj = new PGobject
            obj.setType("oidvector")
            obj.setValue(vv.value)
            obj
          }
        }
      )
    ),
    Types.ARRAY
  )
  implicit lazy val bijection: Bijection[TypoOidVector, String] = Bijection[TypoOidVector, String](_.value)(TypoOidVector.apply)
  implicit lazy val jdbcDecoder: JdbcDecoder[TypoOidVector] = JdbcDecoder[TypoOidVector](
    (rs: ResultSet) => (i: Int) => {
      val v = rs.getObject(i)
      if (v eq null) null else TypoOidVector(v.asInstanceOf[PGobject].getValue)
    },
    "org.postgresql.util.PGobject"
  )
  implicit lazy val jdbcEncoder: JdbcEncoder[TypoOidVector] = JdbcEncoder.singleParamEncoder(setter)
  implicit lazy val jsonDecoder: JsonDecoder[TypoOidVector] = JsonDecoder.string.map(TypoOidVector.apply)
  implicit lazy val jsonEncoder: JsonEncoder[TypoOidVector] = JsonEncoder.string.contramap(_.value)
  implicit lazy val ordering: Ordering[TypoOidVector] = Ordering.by(_.value)
  implicit lazy val parameterMetadata: ParameterMetaData[TypoOidVector] = ParameterMetaData.instance[TypoOidVector]("oidvector", Types.OTHER)
  implicit lazy val setter: Setter[TypoOidVector] = Setter.other(
    (ps, i, v) => {
      ps.setObject(
        i,
        {
          val obj = new PGobject
          obj.setType("oidvector")
          obj.setValue(v.value)
          obj
        }
      )
    },
    "oidvector"
  )
}
