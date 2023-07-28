/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks

import anorm.Column
import anorm.ParameterMetaData
import anorm.ToStatement
import anorm.TypeDoesNotMatch
import java.sql.Types
import org.postgresql.jdbc.PgArray
import org.postgresql.util.PGobject
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.OWrites
import play.api.libs.json.Reads
import play.api.libs.json.Writes
import scala.collection.immutable.ListMap
import scala.util.Try

/** regtype (via PGObject) */
case class TypoRegtype(value: String)

object TypoRegtype {
  implicit val arrayColumn: Column[Array[TypoRegtype]] = Column.nonNull[Array[TypoRegtype]]((v1: Any, _) =>
    v1 match {
        case v: PgArray =>
         v.getArray match {
           case v: Array[?] =>
             Right(v.map(v => TypoRegtype(v.asInstanceOf[String])))
           case other => Left(TypeDoesNotMatch(s"Expected one-dimensional array from JDBC to produce an array of TypoRegtype, got ${other.getClass.getName}"))
         }
      case other => Left(TypeDoesNotMatch(s"Expected instance of org.postgresql.jdbc.PgArray, got ${other.getClass.getName}"))
    }
  )
  implicit val arrayParameterMetaData: ParameterMetaData[Array[TypoRegtype]] = new ParameterMetaData[Array[TypoRegtype]] {
    override def sqlType: String = "_regtype"
    override def jdbcType: Int = Types.ARRAY
  }
  implicit val arrayToStatement: ToStatement[Array[TypoRegtype]] = ToStatement[Array[TypoRegtype]]((s, index, v) => s.setArray(index, s.getConnection.createArrayOf("regtype", v.map(v => {
                                                                                                                           val obj = new PGobject
                                                                                                                           obj.setType("regtype")
                                                                                                                           obj.setValue(v.value)
                                                                                                                           obj
                                                                                                                         }))))
  implicit val column: Column[TypoRegtype] = Column.nonNull[TypoRegtype]((v1: Any, _) =>
    v1 match {
      case v: PGobject => Right(TypoRegtype(v.getValue))
      case other => Left(TypeDoesNotMatch(s"Expected instance of org.postgresql.util.PGobject, got ${other.getClass.getName}"))
    }
  )
  implicit val parameterMetadata: ParameterMetaData[TypoRegtype] = new ParameterMetaData[TypoRegtype] {
    override def sqlType: String = "regtype"
    override def jdbcType: Int = Types.OTHER
  }
  implicit val reads: Reads[TypoRegtype] = Reads[TypoRegtype](json => JsResult.fromTry(
      Try(
        TypoRegtype(
          value = json.\("value").as(Reads.StringReads)
        )
      )
    ),
  )
  implicit val toStatement: ToStatement[TypoRegtype] = ToStatement[TypoRegtype]((s, index, v) => s.setObject(index, {
                                                                 val obj = new PGobject
                                                                 obj.setType("regtype")
                                                                 obj.setValue(v.value)
                                                                 obj
                                                               }))
  implicit val writes: OWrites[TypoRegtype] = OWrites[TypoRegtype](o =>
    new JsObject(ListMap[String, JsValue](
      "value" -> Writes.StringWrites.writes(o.value)
    ))
  )
}