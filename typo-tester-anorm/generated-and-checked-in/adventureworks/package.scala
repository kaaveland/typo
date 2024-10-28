/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */


package object adventureworks {
  implicit lazy val BigDecimalArrayToStatement: anorm.ToStatement[Array[scala.math.BigDecimal]] = anorm.ToStatement[Array[scala.math.BigDecimal]]((ps, index, v) => ps.setArray(index, ps.getConnection.createArrayOf("numeric", v.map(v => v.bigDecimal))))
  implicit lazy val BooleanArrayToStatement: anorm.ToStatement[Array[scala.Boolean]] = anorm.ToStatement[Array[scala.Boolean]]((ps, index, v) => ps.setArray(index, ps.getConnection.createArrayOf("bool", v.map(v => v: java.lang.Boolean))))
  implicit lazy val DoubleArrayToStatement: anorm.ToStatement[Array[scala.Double]] = anorm.ToStatement[Array[scala.Double]]((ps, index, v) => ps.setArray(index, ps.getConnection.createArrayOf("float8", v.map(v => v: java.lang.Double))))
  implicit lazy val FloatArrayToStatement: anorm.ToStatement[Array[scala.Float]] = anorm.ToStatement[Array[scala.Float]]((ps, index, v) => ps.setArray(index, ps.getConnection.createArrayOf("float4", v.map(v => v: java.lang.Float))))
  implicit lazy val IntArrayToStatement: anorm.ToStatement[Array[scala.Int]] = anorm.ToStatement[Array[scala.Int]]((ps, index, v) => ps.setArray(index, ps.getConnection.createArrayOf("int4", v.map(v => v: java.lang.Integer))))
  implicit lazy val LongArrayToStatement: anorm.ToStatement[Array[scala.Long]] = anorm.ToStatement[Array[scala.Long]]((ps, index, v) => ps.setArray(index, ps.getConnection.createArrayOf("int8", v.map(v => v: java.lang.Long))))
  implicit lazy val OffsetTimeReads: play.api.libs.json.Reads[java.time.OffsetTime] = play.api.libs.json.Reads.StringReads.flatMapResult { str =>
      try play.api.libs.json.JsSuccess(java.time.OffsetTime.parse(str)) catch {
        case x: java.time.format.DateTimeParseException => play.api.libs.json.JsError(s"must follow ${java.time.format.DateTimeFormatter.ISO_OFFSET_TIME}: ${x.getMessage}")
      }
    }
  implicit lazy val OffsetTimeWrites: play.api.libs.json.Writes[java.time.OffsetTime] = play.api.libs.json.Writes.StringWrites.contramap(_.toString)
  implicit lazy val ShortArrayToStatement: anorm.ToStatement[Array[scala.Short]] = anorm.ToStatement[Array[scala.Short]]((ps, index, v) => ps.setArray(index, ps.getConnection.createArrayOf("int2", v.map(v => v: java.lang.Short))))
  implicit def arrayParameterMetaData[T](implicit T: anorm.ParameterMetaData[T]): anorm.ParameterMetaData[Array[T]] = new anorm.ParameterMetaData[Array[T]] {
    override def sqlType: java.lang.String =
      T.sqlType match {
        case "INTEGER" => "int4[]"
        case "FLOAT" => "float4[]"
        case "DOUBLE PRECISION" => "float8[]"
        case "DECIMAL" => "float8[]"
        case "VARCHAR" => "text[]"
        case other => s"${other}[]"
      }
  
    override def jdbcType: scala.Int = java.sql.Types.ARRAY
  }
}
