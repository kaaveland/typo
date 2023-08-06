/**
 * File has been automatically generated by `typo` for internal use.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 *
 * (If you're developing `typo` and want to change it: run `bleep generate-sources`)
 */
package typo
package generated

import anorm.Column
import anorm.ParameterMetaData
import anorm.ToStatement
import anorm.TypeDoesNotMatch
import java.sql.Types
import org.postgresql.jdbc.PgArray
import org.postgresql.util.PGobject
import play.api.libs.json.Reads
import play.api.libs.json.Writes

/** regnamespace (via PGObject) */
case class TypoRegnamespace(value: String)

object TypoRegnamespace {
  implicit lazy val arrayColumn: Column[Array[TypoRegnamespace]] = Column.nonNull[Array[TypoRegnamespace]]((v1: Any, _) =>
    v1 match {
        case v: PgArray =>
         v.getArray match {
           case v: Array[?] =>
             Right(v.map(v => TypoRegnamespace(v.asInstanceOf[String])))
           case other => Left(TypeDoesNotMatch(s"Expected one-dimensional array from JDBC to produce an array of TypoRegnamespace, got ${other.getClass.getName}"))
         }
      case other => Left(TypeDoesNotMatch(s"Expected instance of org.postgresql.jdbc.PgArray, got ${other.getClass.getName}"))
    }
  )
  implicit lazy val arrayParameterMetaData: ParameterMetaData[Array[TypoRegnamespace]] = new ParameterMetaData[Array[TypoRegnamespace]] {
    override def sqlType: String = "_regnamespace"
    override def jdbcType: Int = Types.ARRAY
  }
  implicit lazy val arrayToStatement: ToStatement[Array[TypoRegnamespace]] = ToStatement[Array[TypoRegnamespace]]((s, index, v) => s.setArray(index, s.getConnection.createArrayOf("regnamespace", v.map(v => {
                                                                                                                                     val obj = new PGobject
                                                                                                                                     obj.setType("regnamespace")
                                                                                                                                     obj.setValue(v.value)
                                                                                                                                     obj
                                                                                                                                   }))))
  implicit lazy val column: Column[TypoRegnamespace] = Column.nonNull[TypoRegnamespace]((v1: Any, _) =>
    v1 match {
      case v: PGobject => Right(TypoRegnamespace(v.getValue))
      case other => Left(TypeDoesNotMatch(s"Expected instance of org.postgresql.util.PGobject, got ${other.getClass.getName}"))
    }
  )
  implicit lazy val ordering: Ordering[TypoRegnamespace] = Ordering.by(_.value)
  implicit lazy val parameterMetadata: ParameterMetaData[TypoRegnamespace] = new ParameterMetaData[TypoRegnamespace] {
    override def sqlType: String = "regnamespace"
    override def jdbcType: Int = Types.OTHER
  }
  implicit lazy val reads: Reads[TypoRegnamespace] = Reads.StringReads.map(TypoRegnamespace.apply)
  implicit lazy val toStatement: ToStatement[TypoRegnamespace] = ToStatement[TypoRegnamespace]((s, index, v) => s.setObject(index, {
                                                                      val obj = new PGobject
                                                                      obj.setType("regnamespace")
                                                                      obj.setValue(v.value)
                                                                      obj
                                                                    }))
  implicit lazy val writes: Writes[TypoRegnamespace] = Writes.StringWrites.contramap(_.value)
}
