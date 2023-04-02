/**
 * File automatically generated by `typo` for its own test suite.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN
 */
package testdb

package object hardcoded {
  implicit val StringArray: anorm.ToStatement[scala.Array[java.lang.String]] with anorm.ParameterMetaData[scala.Array[java.lang.String]] = new anorm.ToStatement[scala.Array[java.lang.String]] with anorm.ParameterMetaData[scala.Array[java.lang.String]] {
    override def sqlType: java.lang.String = "_varchar"
    override def jdbcType: scala.Int = java.sql.Types.ARRAY
    override def set(ps: java.sql.PreparedStatement, index: scala.Int, v: scala.Array[java.lang.String]): scala.Unit = ps.setArray(index, ps.getConnection.createArrayOf("_varchar", v.map(v => v: scala.AnyRef)))
  }

  implicit val FloatArray: anorm.ToStatement[scala.Array[scala.Float]] with anorm.ParameterMetaData[scala.Array[scala.Float]] = new anorm.ToStatement[scala.Array[scala.Float]] with anorm.ParameterMetaData[scala.Array[scala.Float]] {
    override def sqlType: java.lang.String = "_float4"
    override def jdbcType: scala.Int = java.sql.Types.ARRAY
    override def set(ps: java.sql.PreparedStatement, index: scala.Int, v: scala.Array[scala.Float]): scala.Unit = ps.setArray(index, ps.getConnection.createArrayOf("_float4", v.map(v => v: java.lang.Float)))
  }

  implicit val ShortArray: anorm.ToStatement[scala.Array[scala.Short]] with anorm.ParameterMetaData[scala.Array[scala.Short]] = new anorm.ToStatement[scala.Array[scala.Short]] with anorm.ParameterMetaData[scala.Array[scala.Short]] {
    override def sqlType: java.lang.String = "_int2"
    override def jdbcType: scala.Int = java.sql.Types.ARRAY
    override def set(ps: java.sql.PreparedStatement, index: scala.Int, v: scala.Array[scala.Short]): scala.Unit = ps.setArray(index, ps.getConnection.createArrayOf("_int2", v.map(v => v: java.lang.Short)))
  }

  implicit val IntArray: anorm.ToStatement[scala.Array[scala.Int]] with anorm.ParameterMetaData[scala.Array[scala.Int]] = new anorm.ToStatement[scala.Array[scala.Int]] with anorm.ParameterMetaData[scala.Array[scala.Int]] {
    override def sqlType: java.lang.String = "_int4"
    override def jdbcType: scala.Int = java.sql.Types.ARRAY
    override def set(ps: java.sql.PreparedStatement, index: scala.Int, v: scala.Array[scala.Int]): scala.Unit = ps.setArray(index, ps.getConnection.createArrayOf("_int4", v.map(v => v: java.lang.Integer)))
  }

  implicit val LongArray: anorm.ToStatement[scala.Array[scala.Long]] with anorm.ParameterMetaData[scala.Array[scala.Long]] = new anorm.ToStatement[scala.Array[scala.Long]] with anorm.ParameterMetaData[scala.Array[scala.Long]] {
    override def sqlType: java.lang.String = "_int8"
    override def jdbcType: scala.Int = java.sql.Types.ARRAY
    override def set(ps: java.sql.PreparedStatement, index: scala.Int, v: scala.Array[scala.Long]): scala.Unit = ps.setArray(index, ps.getConnection.createArrayOf("_int8", v.map(v => v: java.lang.Long)))
  }

  implicit val BooleanArray: anorm.ToStatement[scala.Array[scala.Boolean]] with anorm.ParameterMetaData[scala.Array[scala.Boolean]] = new anorm.ToStatement[scala.Array[scala.Boolean]] with anorm.ParameterMetaData[scala.Array[scala.Boolean]] {
    override def sqlType: java.lang.String = "_bool"
    override def jdbcType: scala.Int = java.sql.Types.ARRAY
    override def set(ps: java.sql.PreparedStatement, index: scala.Int, v: scala.Array[scala.Boolean]): scala.Unit = ps.setArray(index, ps.getConnection.createArrayOf("_bool", v.map(v => v: java.lang.Boolean)))
  }

  implicit val DoubleArray: anorm.ToStatement[scala.Array[scala.Double]] with anorm.ParameterMetaData[scala.Array[scala.Double]] = new anorm.ToStatement[scala.Array[scala.Double]] with anorm.ParameterMetaData[scala.Array[scala.Double]] {
    override def sqlType: java.lang.String = "_float8"
    override def jdbcType: scala.Int = java.sql.Types.ARRAY
    override def set(ps: java.sql.PreparedStatement, index: scala.Int, v: scala.Array[scala.Double]): scala.Unit = ps.setArray(index, ps.getConnection.createArrayOf("_float8", v.map(v => v: java.lang.Double)))
  }

  implicit val UUIDArray: anorm.ToStatement[scala.Array[java.util.UUID]] with anorm.ParameterMetaData[scala.Array[java.util.UUID]] = new anorm.ToStatement[scala.Array[java.util.UUID]] with anorm.ParameterMetaData[scala.Array[java.util.UUID]] {
    override def sqlType: java.lang.String = "_uuid"
    override def jdbcType: scala.Int = java.sql.Types.ARRAY
    override def set(ps: java.sql.PreparedStatement, index: scala.Int, v: scala.Array[java.util.UUID]): scala.Unit = ps.setArray(index, ps.getConnection.createArrayOf("_uuid", v.map(v => v: scala.AnyRef)))
  }

  implicit val BigDecimalArray: anorm.ToStatement[scala.Array[scala.math.BigDecimal]] with anorm.ParameterMetaData[scala.Array[scala.math.BigDecimal]] = new anorm.ToStatement[scala.Array[scala.math.BigDecimal]] with anorm.ParameterMetaData[scala.Array[scala.math.BigDecimal]] {
    override def sqlType: java.lang.String = "_decimal"
    override def jdbcType: scala.Int = java.sql.Types.ARRAY
    override def set(ps: java.sql.PreparedStatement, index: scala.Int, v: scala.Array[scala.math.BigDecimal]): scala.Unit = ps.setArray(index, ps.getConnection.createArrayOf("_decimal", v.map(v => v: scala.AnyRef)))
  }

  implicit val PGobjectArray: anorm.ToStatement[scala.Array[org.postgresql.util.PGobject]] with anorm.ParameterMetaData[scala.Array[org.postgresql.util.PGobject]] = new anorm.ToStatement[scala.Array[org.postgresql.util.PGobject]] with anorm.ParameterMetaData[scala.Array[org.postgresql.util.PGobject]] {
    override def sqlType: java.lang.String = "_aclitem"
    override def jdbcType: scala.Int = java.sql.Types.ARRAY
    override def set(ps: java.sql.PreparedStatement, index: scala.Int, v: scala.Array[org.postgresql.util.PGobject]): scala.Unit = ps.setArray(index, ps.getConnection.createArrayOf("_aclitem", v.map(v => v: scala.AnyRef)))
  }

  implicit val PGboxDb: anorm.ToStatement[org.postgresql.geometric.PGbox] with anorm.ParameterMetaData[org.postgresql.geometric.PGbox] with anorm.Column[org.postgresql.geometric.PGbox] = new anorm.ToStatement[org.postgresql.geometric.PGbox] with anorm.ParameterMetaData[org.postgresql.geometric.PGbox] with anorm.Column[org.postgresql.geometric.PGbox] {
    override def sqlType: java.lang.String = "box"
    override def jdbcType: scala.Int = java.sql.Types.OTHER
    override def set(s: java.sql.PreparedStatement, index: scala.Int, v: org.postgresql.geometric.PGbox): scala.Unit = s.setObject(index, v)
    override def apply(v1: scala.Any, v2: anorm.MetaDataItem): scala.Either[anorm.SqlRequestError, org.postgresql.geometric.PGbox] = scala.Right(v1.asInstanceOf[org.postgresql.geometric.PGbox])
  }

  implicit val PGcircleDb: anorm.ToStatement[org.postgresql.geometric.PGcircle] with anorm.ParameterMetaData[org.postgresql.geometric.PGcircle] with anorm.Column[org.postgresql.geometric.PGcircle] = new anorm.ToStatement[org.postgresql.geometric.PGcircle] with anorm.ParameterMetaData[org.postgresql.geometric.PGcircle] with anorm.Column[org.postgresql.geometric.PGcircle] {
    override def sqlType: java.lang.String = "circle"
    override def jdbcType: scala.Int = java.sql.Types.OTHER
    override def set(s: java.sql.PreparedStatement, index: scala.Int, v: org.postgresql.geometric.PGcircle): scala.Unit = s.setObject(index, v)
    override def apply(v1: scala.Any, v2: anorm.MetaDataItem): scala.Either[anorm.SqlRequestError, org.postgresql.geometric.PGcircle] = scala.Right(v1.asInstanceOf[org.postgresql.geometric.PGcircle])
  }

  implicit val PGlineDb: anorm.ToStatement[org.postgresql.geometric.PGline] with anorm.ParameterMetaData[org.postgresql.geometric.PGline] with anorm.Column[org.postgresql.geometric.PGline] = new anorm.ToStatement[org.postgresql.geometric.PGline] with anorm.ParameterMetaData[org.postgresql.geometric.PGline] with anorm.Column[org.postgresql.geometric.PGline] {
    override def sqlType: java.lang.String = "line"
    override def jdbcType: scala.Int = java.sql.Types.OTHER
    override def set(s: java.sql.PreparedStatement, index: scala.Int, v: org.postgresql.geometric.PGline): scala.Unit = s.setObject(index, v)
    override def apply(v1: scala.Any, v2: anorm.MetaDataItem): scala.Either[anorm.SqlRequestError, org.postgresql.geometric.PGline] = scala.Right(v1.asInstanceOf[org.postgresql.geometric.PGline])
  }

  implicit val PGlsegDb: anorm.ToStatement[org.postgresql.geometric.PGlseg] with anorm.ParameterMetaData[org.postgresql.geometric.PGlseg] with anorm.Column[org.postgresql.geometric.PGlseg] = new anorm.ToStatement[org.postgresql.geometric.PGlseg] with anorm.ParameterMetaData[org.postgresql.geometric.PGlseg] with anorm.Column[org.postgresql.geometric.PGlseg] {
    override def sqlType: java.lang.String = "lseg"
    override def jdbcType: scala.Int = java.sql.Types.OTHER
    override def set(s: java.sql.PreparedStatement, index: scala.Int, v: org.postgresql.geometric.PGlseg): scala.Unit = s.setObject(index, v)
    override def apply(v1: scala.Any, v2: anorm.MetaDataItem): scala.Either[anorm.SqlRequestError, org.postgresql.geometric.PGlseg] = scala.Right(v1.asInstanceOf[org.postgresql.geometric.PGlseg])
  }

  implicit val PGpathDb: anorm.ToStatement[org.postgresql.geometric.PGpath] with anorm.ParameterMetaData[org.postgresql.geometric.PGpath] with anorm.Column[org.postgresql.geometric.PGpath] = new anorm.ToStatement[org.postgresql.geometric.PGpath] with anorm.ParameterMetaData[org.postgresql.geometric.PGpath] with anorm.Column[org.postgresql.geometric.PGpath] {
    override def sqlType: java.lang.String = "path"
    override def jdbcType: scala.Int = java.sql.Types.OTHER
    override def set(s: java.sql.PreparedStatement, index: scala.Int, v: org.postgresql.geometric.PGpath): scala.Unit = s.setObject(index, v)
    override def apply(v1: scala.Any, v2: anorm.MetaDataItem): scala.Either[anorm.SqlRequestError, org.postgresql.geometric.PGpath] = scala.Right(v1.asInstanceOf[org.postgresql.geometric.PGpath])
  }

  implicit val PGpointDb: anorm.ToStatement[org.postgresql.geometric.PGpoint] with anorm.ParameterMetaData[org.postgresql.geometric.PGpoint] with anorm.Column[org.postgresql.geometric.PGpoint] = new anorm.ToStatement[org.postgresql.geometric.PGpoint] with anorm.ParameterMetaData[org.postgresql.geometric.PGpoint] with anorm.Column[org.postgresql.geometric.PGpoint] {
    override def sqlType: java.lang.String = "point"
    override def jdbcType: scala.Int = java.sql.Types.OTHER
    override def set(s: java.sql.PreparedStatement, index: scala.Int, v: org.postgresql.geometric.PGpoint): scala.Unit = s.setObject(index, v)
    override def apply(v1: scala.Any, v2: anorm.MetaDataItem): scala.Either[anorm.SqlRequestError, org.postgresql.geometric.PGpoint] = scala.Right(v1.asInstanceOf[org.postgresql.geometric.PGpoint])
  }

  implicit val PGpolygonDb: anorm.ToStatement[org.postgresql.geometric.PGpolygon] with anorm.ParameterMetaData[org.postgresql.geometric.PGpolygon] with anorm.Column[org.postgresql.geometric.PGpolygon] = new anorm.ToStatement[org.postgresql.geometric.PGpolygon] with anorm.ParameterMetaData[org.postgresql.geometric.PGpolygon] with anorm.Column[org.postgresql.geometric.PGpolygon] {
    override def sqlType: java.lang.String = "polygon"
    override def jdbcType: scala.Int = java.sql.Types.OTHER
    override def set(s: java.sql.PreparedStatement, index: scala.Int, v: org.postgresql.geometric.PGpolygon): scala.Unit = s.setObject(index, v)
    override def apply(v1: scala.Any, v2: anorm.MetaDataItem): scala.Either[anorm.SqlRequestError, org.postgresql.geometric.PGpolygon] = scala.Right(v1.asInstanceOf[org.postgresql.geometric.PGpolygon])
  }

  implicit val PGIntervalDb: anorm.ToStatement[org.postgresql.util.PGInterval] with anorm.ParameterMetaData[org.postgresql.util.PGInterval] with anorm.Column[org.postgresql.util.PGInterval] = new anorm.ToStatement[org.postgresql.util.PGInterval] with anorm.ParameterMetaData[org.postgresql.util.PGInterval] with anorm.Column[org.postgresql.util.PGInterval] {
    override def sqlType: java.lang.String = "interval"
    override def jdbcType: scala.Int = java.sql.Types.OTHER
    override def set(s: java.sql.PreparedStatement, index: scala.Int, v: org.postgresql.util.PGInterval): scala.Unit = s.setObject(index, v)
    override def apply(v1: scala.Any, v2: anorm.MetaDataItem): scala.Either[anorm.SqlRequestError, org.postgresql.util.PGInterval] = scala.Right(v1.asInstanceOf[org.postgresql.util.PGInterval])
  }

  implicit val PGmoneyDb: anorm.ToStatement[org.postgresql.util.PGmoney] with anorm.ParameterMetaData[org.postgresql.util.PGmoney] with anorm.Column[org.postgresql.util.PGmoney] = new anorm.ToStatement[org.postgresql.util.PGmoney] with anorm.ParameterMetaData[org.postgresql.util.PGmoney] with anorm.Column[org.postgresql.util.PGmoney] {
    override def sqlType: java.lang.String = "money"
    override def jdbcType: scala.Int = java.sql.Types.OTHER
    override def set(s: java.sql.PreparedStatement, index: scala.Int, v: org.postgresql.util.PGmoney): scala.Unit = s.setObject(index, v)
    override def apply(v1: scala.Any, v2: anorm.MetaDataItem): scala.Either[anorm.SqlRequestError, org.postgresql.util.PGmoney] = scala.Right(v1.asInstanceOf[org.postgresql.util.PGmoney])
  }

  implicit val hstoreDb: anorm.ToStatement[java.util.Map[java.lang.String, java.lang.String]] with anorm.ParameterMetaData[java.util.Map[java.lang.String, java.lang.String]] with anorm.Column[java.util.Map[java.lang.String, java.lang.String]] = new anorm.ToStatement[java.util.Map[java.lang.String, java.lang.String]] with anorm.ParameterMetaData[java.util.Map[java.lang.String, java.lang.String]] with anorm.Column[java.util.Map[java.lang.String, java.lang.String]] {
    override def sqlType: java.lang.String = "hstore"
    override def jdbcType: scala.Int = java.sql.Types.OTHER
    override def set(s: java.sql.PreparedStatement, index: scala.Int, v: java.util.Map[java.lang.String, java.lang.String]): scala.Unit = s.setObject(index, v)
    override def apply(v1: scala.Any, v2: anorm.MetaDataItem): scala.Either[anorm.SqlRequestError, java.util.Map[java.lang.String, java.lang.String]] = scala.Right(v1.asInstanceOf[java.util.Map[java.lang.String, java.lang.String]])
  }

  implicit val pgObjectDb: anorm.ToStatement[org.postgresql.util.PGobject] with anorm.ParameterMetaData[org.postgresql.util.PGobject] with anorm.Column[org.postgresql.util.PGobject] = new anorm.ToStatement[org.postgresql.util.PGobject] with anorm.ParameterMetaData[org.postgresql.util.PGobject] with anorm.Column[org.postgresql.util.PGobject] {
    override def sqlType: java.lang.String = "hstore"
    override def jdbcType: scala.Int = java.sql.Types.OTHER
    override def set(s: java.sql.PreparedStatement, index: scala.Int, v: org.postgresql.util.PGobject): scala.Unit = s.setObject(index, v)
    override def apply(v1: scala.Any, v2: anorm.MetaDataItem): scala.Either[anorm.SqlRequestError, org.postgresql.util.PGobject] = scala.Right(v1.asInstanceOf[org.postgresql.util.PGobject])
  }

  implicit val PGboxFormat: play.api.libs.json.Format[org.postgresql.geometric.PGbox] = implicitly[play.api.libs.json.Format[java.lang.String]].bimap[org.postgresql.geometric.PGbox](new org.postgresql.geometric.PGbox(_), _.getValue)
  implicit val PGcircleFormat: play.api.libs.json.Format[org.postgresql.geometric.PGcircle] = implicitly[play.api.libs.json.Format[java.lang.String]].bimap[org.postgresql.geometric.PGcircle](new org.postgresql.geometric.PGcircle(_), _.getValue)
  implicit val PGlineFormat: play.api.libs.json.Format[org.postgresql.geometric.PGline] = implicitly[play.api.libs.json.Format[java.lang.String]].bimap[org.postgresql.geometric.PGline](new org.postgresql.geometric.PGline(_), _.getValue)
  implicit val PGlsegFormat: play.api.libs.json.Format[org.postgresql.geometric.PGlseg] = implicitly[play.api.libs.json.Format[java.lang.String]].bimap[org.postgresql.geometric.PGlseg](new org.postgresql.geometric.PGlseg(_), _.getValue)
  implicit val PGpathFormat: play.api.libs.json.Format[org.postgresql.geometric.PGpath] = implicitly[play.api.libs.json.Format[java.lang.String]].bimap[org.postgresql.geometric.PGpath](new org.postgresql.geometric.PGpath(_), _.getValue)
  implicit val PGpointFormat: play.api.libs.json.Format[org.postgresql.geometric.PGpoint] = implicitly[play.api.libs.json.Format[java.lang.String]].bimap[org.postgresql.geometric.PGpoint](new org.postgresql.geometric.PGpoint(_), _.getValue)
  implicit val PGpolygonFormat: play.api.libs.json.Format[org.postgresql.geometric.PGpolygon] = implicitly[play.api.libs.json.Format[java.lang.String]].bimap[org.postgresql.geometric.PGpolygon](new org.postgresql.geometric.PGpolygon(_), _.getValue)
  implicit val PGIntervalFormat: play.api.libs.json.Format[org.postgresql.util.PGInterval] = implicitly[play.api.libs.json.Format[java.lang.String]].bimap[org.postgresql.util.PGInterval](new org.postgresql.util.PGInterval(_), _.getValue)
  implicit val PGmoneyFormat: play.api.libs.json.Format[org.postgresql.util.PGmoney] = implicitly[play.api.libs.json.Format[java.lang.String]].bimap[org.postgresql.util.PGmoney](new org.postgresql.util.PGmoney(_), _.getValue)
  implicit val hstoreFormat: play.api.libs.json.Format[java.util.Map[java.lang.String, java.lang.String]] = {
    // on 2.12 and getting an error here? add dependency: org.scala-lang.modules::scala-collection-compat
    import scala.jdk.CollectionConverters._
    implicitly[play.api.libs.json.Format[scala.collection.immutable.Map[java.lang.String, java.lang.String]]].bimap(_.asJava, _.asScala.toMap)
}
  implicit val pgObjectFormat: play.api.libs.json.OFormat[org.postgresql.util.PGobject] =
    new play.api.libs.json.OFormat[org.postgresql.util.PGobject] {
      override def writes(o: org.postgresql.util.PGobject): play.api.libs.json.JsObject =
        play.api.libs.json.JsObject(scala.collection.immutable.Map("type" -> play.api.libs.json.JsString(o.getType), "value" -> play.api.libs.json.JsString(o.getValue)))

      override def reads(json: play.api.libs.json.JsValue): play.api.libs.json.JsResult[org.postgresql.util.PGobject] = json match {
        case play.api.libs.json.JsObject(fields) =>
          val t = fields.get("type").map(_.as[String])
          val v = fields.get("value").map(_.as[String])
          (t, v) match {
            case (scala.Some(t), scala.Some(v)) =>
              val o = new org.postgresql.util.PGobject()
              o.setType(t)
              o.setValue(v)
              play.api.libs.json.JsSuccess(o)
            case _ => play.api.libs.json.JsError("Invalid PGobject")
          }
        case _ => play.api.libs.json.JsError("Invalid PGobject")
      }
    }

  implicit val pgObjectOrdering: scala.math.Ordering[org.postgresql.util.PGobject] =
    scala.math.Ordering.by(x => (x.getType, x.getValue))
}
