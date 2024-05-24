/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package public
package pgtestnull

import adventureworks.customtypes.TypoBox
import adventureworks.customtypes.TypoBytea
import adventureworks.customtypes.TypoCircle
import adventureworks.customtypes.TypoHStore
import adventureworks.customtypes.TypoInet
import adventureworks.customtypes.TypoInstant
import adventureworks.customtypes.TypoInt2Vector
import adventureworks.customtypes.TypoInterval
import adventureworks.customtypes.TypoJson
import adventureworks.customtypes.TypoJsonb
import adventureworks.customtypes.TypoLine
import adventureworks.customtypes.TypoLineSegment
import adventureworks.customtypes.TypoLocalDate
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoLocalTime
import adventureworks.customtypes.TypoMoney
import adventureworks.customtypes.TypoOffsetTime
import adventureworks.customtypes.TypoPath
import adventureworks.customtypes.TypoPoint
import adventureworks.customtypes.TypoPolygon
import adventureworks.customtypes.TypoShort
import adventureworks.customtypes.TypoUUID
import adventureworks.customtypes.TypoVector
import adventureworks.customtypes.TypoXml
import adventureworks.public.Mydomain
import adventureworks.public.Myenum
import typo.dsl.Path
import typo.dsl.SqlExpr.FieldLikeNoHkt
import typo.dsl.SqlExpr.OptField
import typo.dsl.Structure.Relation

trait PgtestnullFields {
  def bool: OptField[Boolean, PgtestnullRow]
  def box: OptField[TypoBox, PgtestnullRow]
  def bpchar: OptField[/* bpchar, max 3 chars */ String, PgtestnullRow]
  def bytea: OptField[TypoBytea, PgtestnullRow]
  def char: OptField[/* bpchar, max 1 chars */ String, PgtestnullRow]
  def circle: OptField[TypoCircle, PgtestnullRow]
  def date: OptField[TypoLocalDate, PgtestnullRow]
  def float4: OptField[Float, PgtestnullRow]
  def float8: OptField[Double, PgtestnullRow]
  def hstore: OptField[TypoHStore, PgtestnullRow]
  def inet: OptField[TypoInet, PgtestnullRow]
  def int2: OptField[TypoShort, PgtestnullRow]
  def int2vector: OptField[TypoInt2Vector, PgtestnullRow]
  def int4: OptField[Int, PgtestnullRow]
  def int8: OptField[Long, PgtestnullRow]
  def interval: OptField[TypoInterval, PgtestnullRow]
  def json: OptField[TypoJson, PgtestnullRow]
  def jsonb: OptField[TypoJsonb, PgtestnullRow]
  def line: OptField[TypoLine, PgtestnullRow]
  def lseg: OptField[TypoLineSegment, PgtestnullRow]
  def money: OptField[TypoMoney, PgtestnullRow]
  def mydomain: OptField[Mydomain, PgtestnullRow]
  def myenum: OptField[Myenum, PgtestnullRow]
  def name: OptField[String, PgtestnullRow]
  def numeric: OptField[BigDecimal, PgtestnullRow]
  def path: OptField[TypoPath, PgtestnullRow]
  def point: OptField[TypoPoint, PgtestnullRow]
  def polygon: OptField[TypoPolygon, PgtestnullRow]
  def text: OptField[String, PgtestnullRow]
  def time: OptField[TypoLocalTime, PgtestnullRow]
  def timestamp: OptField[TypoLocalDateTime, PgtestnullRow]
  def timestampz: OptField[TypoInstant, PgtestnullRow]
  def timez: OptField[TypoOffsetTime, PgtestnullRow]
  def uuid: OptField[TypoUUID, PgtestnullRow]
  def varchar: OptField[String, PgtestnullRow]
  def vector: OptField[TypoVector, PgtestnullRow]
  def xml: OptField[TypoXml, PgtestnullRow]
  def boxes: OptField[Array[TypoBox], PgtestnullRow]
  def bpchares: OptField[Array[/* bpchar */ String], PgtestnullRow]
  def chares: OptField[Array[/* bpchar */ String], PgtestnullRow]
  def circlees: OptField[Array[TypoCircle], PgtestnullRow]
  def datees: OptField[Array[TypoLocalDate], PgtestnullRow]
  def float4es: OptField[Array[Float], PgtestnullRow]
  def float8es: OptField[Array[Double], PgtestnullRow]
  def inetes: OptField[Array[TypoInet], PgtestnullRow]
  def int2es: OptField[Array[TypoShort], PgtestnullRow]
  def int2vectores: OptField[Array[TypoInt2Vector], PgtestnullRow]
  def int4es: OptField[Array[Int], PgtestnullRow]
  def int8es: OptField[Array[Long], PgtestnullRow]
  def intervales: OptField[Array[TypoInterval], PgtestnullRow]
  def jsones: OptField[Array[TypoJson], PgtestnullRow]
  def jsonbes: OptField[Array[TypoJsonb], PgtestnullRow]
  def linees: OptField[Array[TypoLine], PgtestnullRow]
  def lseges: OptField[Array[TypoLineSegment], PgtestnullRow]
  def moneyes: OptField[Array[TypoMoney], PgtestnullRow]
  def myenumes: OptField[Array[Myenum], PgtestnullRow]
  def namees: OptField[Array[String], PgtestnullRow]
  def numerices: OptField[Array[BigDecimal], PgtestnullRow]
  def pathes: OptField[Array[TypoPath], PgtestnullRow]
  def pointes: OptField[Array[TypoPoint], PgtestnullRow]
  def polygones: OptField[Array[TypoPolygon], PgtestnullRow]
  def textes: OptField[Array[String], PgtestnullRow]
  def timees: OptField[Array[TypoLocalTime], PgtestnullRow]
  def timestampes: OptField[Array[TypoLocalDateTime], PgtestnullRow]
  def timestampzes: OptField[Array[TypoInstant], PgtestnullRow]
  def timezes: OptField[Array[TypoOffsetTime], PgtestnullRow]
  def uuides: OptField[Array[TypoUUID], PgtestnullRow]
  def varchares: OptField[Array[String], PgtestnullRow]
  def xmles: OptField[Array[TypoXml], PgtestnullRow]
}

object PgtestnullFields {
  lazy val structure: Relation[PgtestnullFields, PgtestnullRow] =
    new Impl(Nil)
    
  private final class Impl(val _path: List[Path])
    extends Relation[PgtestnullFields, PgtestnullRow] {
  
    override lazy val fields: PgtestnullFields = new PgtestnullFields {
      override def bool = OptField[Boolean, PgtestnullRow](_path, "bool", None, None, x => x.bool, (row, value) => row.copy(bool = value))
      override def box = OptField[TypoBox, PgtestnullRow](_path, "box", None, Some("box"), x => x.box, (row, value) => row.copy(box = value))
      override def bpchar = OptField[/* bpchar, max 3 chars */ String, PgtestnullRow](_path, "bpchar", None, Some("bpchar"), x => x.bpchar, (row, value) => row.copy(bpchar = value))
      override def bytea = OptField[TypoBytea, PgtestnullRow](_path, "bytea", None, Some("bytea"), x => x.bytea, (row, value) => row.copy(bytea = value))
      override def char = OptField[/* bpchar, max 1 chars */ String, PgtestnullRow](_path, "char", None, Some("bpchar"), x => x.char, (row, value) => row.copy(char = value))
      override def circle = OptField[TypoCircle, PgtestnullRow](_path, "circle", None, Some("circle"), x => x.circle, (row, value) => row.copy(circle = value))
      override def date = OptField[TypoLocalDate, PgtestnullRow](_path, "date", Some("text"), Some("date"), x => x.date, (row, value) => row.copy(date = value))
      override def float4 = OptField[Float, PgtestnullRow](_path, "float4", None, Some("float4"), x => x.float4, (row, value) => row.copy(float4 = value))
      override def float8 = OptField[Double, PgtestnullRow](_path, "float8", None, Some("float8"), x => x.float8, (row, value) => row.copy(float8 = value))
      override def hstore = OptField[TypoHStore, PgtestnullRow](_path, "hstore", None, Some("hstore"), x => x.hstore, (row, value) => row.copy(hstore = value))
      override def inet = OptField[TypoInet, PgtestnullRow](_path, "inet", None, Some("inet"), x => x.inet, (row, value) => row.copy(inet = value))
      override def int2 = OptField[TypoShort, PgtestnullRow](_path, "int2", None, Some("int2"), x => x.int2, (row, value) => row.copy(int2 = value))
      override def int2vector = OptField[TypoInt2Vector, PgtestnullRow](_path, "int2vector", None, Some("int2vector"), x => x.int2vector, (row, value) => row.copy(int2vector = value))
      override def int4 = OptField[Int, PgtestnullRow](_path, "int4", None, Some("int4"), x => x.int4, (row, value) => row.copy(int4 = value))
      override def int8 = OptField[Long, PgtestnullRow](_path, "int8", None, Some("int8"), x => x.int8, (row, value) => row.copy(int8 = value))
      override def interval = OptField[TypoInterval, PgtestnullRow](_path, "interval", None, Some("interval"), x => x.interval, (row, value) => row.copy(interval = value))
      override def json = OptField[TypoJson, PgtestnullRow](_path, "json", None, Some("json"), x => x.json, (row, value) => row.copy(json = value))
      override def jsonb = OptField[TypoJsonb, PgtestnullRow](_path, "jsonb", None, Some("jsonb"), x => x.jsonb, (row, value) => row.copy(jsonb = value))
      override def line = OptField[TypoLine, PgtestnullRow](_path, "line", None, Some("line"), x => x.line, (row, value) => row.copy(line = value))
      override def lseg = OptField[TypoLineSegment, PgtestnullRow](_path, "lseg", None, Some("lseg"), x => x.lseg, (row, value) => row.copy(lseg = value))
      override def money = OptField[TypoMoney, PgtestnullRow](_path, "money", Some("numeric"), Some("money"), x => x.money, (row, value) => row.copy(money = value))
      override def mydomain = OptField[Mydomain, PgtestnullRow](_path, "mydomain", None, Some("text"), x => x.mydomain, (row, value) => row.copy(mydomain = value))
      override def myenum = OptField[Myenum, PgtestnullRow](_path, "myenum", None, Some("public.myenum"), x => x.myenum, (row, value) => row.copy(myenum = value))
      override def name = OptField[String, PgtestnullRow](_path, "name", None, Some("name"), x => x.name, (row, value) => row.copy(name = value))
      override def numeric = OptField[BigDecimal, PgtestnullRow](_path, "numeric", None, Some("numeric"), x => x.numeric, (row, value) => row.copy(numeric = value))
      override def path = OptField[TypoPath, PgtestnullRow](_path, "path", None, Some("path"), x => x.path, (row, value) => row.copy(path = value))
      override def point = OptField[TypoPoint, PgtestnullRow](_path, "point", None, Some("point"), x => x.point, (row, value) => row.copy(point = value))
      override def polygon = OptField[TypoPolygon, PgtestnullRow](_path, "polygon", None, Some("polygon"), x => x.polygon, (row, value) => row.copy(polygon = value))
      override def text = OptField[String, PgtestnullRow](_path, "text", None, None, x => x.text, (row, value) => row.copy(text = value))
      override def time = OptField[TypoLocalTime, PgtestnullRow](_path, "time", Some("text"), Some("time"), x => x.time, (row, value) => row.copy(time = value))
      override def timestamp = OptField[TypoLocalDateTime, PgtestnullRow](_path, "timestamp", Some("text"), Some("timestamp"), x => x.timestamp, (row, value) => row.copy(timestamp = value))
      override def timestampz = OptField[TypoInstant, PgtestnullRow](_path, "timestampz", Some("text"), Some("timestamptz"), x => x.timestampz, (row, value) => row.copy(timestampz = value))
      override def timez = OptField[TypoOffsetTime, PgtestnullRow](_path, "timez", Some("text"), Some("timetz"), x => x.timez, (row, value) => row.copy(timez = value))
      override def uuid = OptField[TypoUUID, PgtestnullRow](_path, "uuid", None, Some("uuid"), x => x.uuid, (row, value) => row.copy(uuid = value))
      override def varchar = OptField[String, PgtestnullRow](_path, "varchar", None, None, x => x.varchar, (row, value) => row.copy(varchar = value))
      override def vector = OptField[TypoVector, PgtestnullRow](_path, "vector", Some("float4[]"), Some("vector"), x => x.vector, (row, value) => row.copy(vector = value))
      override def xml = OptField[TypoXml, PgtestnullRow](_path, "xml", None, Some("xml"), x => x.xml, (row, value) => row.copy(xml = value))
      override def boxes = OptField[Array[TypoBox], PgtestnullRow](_path, "boxes", None, Some("_box"), x => x.boxes, (row, value) => row.copy(boxes = value))
      override def bpchares = OptField[Array[/* bpchar */ String], PgtestnullRow](_path, "bpchares", None, Some("_bpchar"), x => x.bpchares, (row, value) => row.copy(bpchares = value))
      override def chares = OptField[Array[/* bpchar */ String], PgtestnullRow](_path, "chares", None, Some("_bpchar"), x => x.chares, (row, value) => row.copy(chares = value))
      override def circlees = OptField[Array[TypoCircle], PgtestnullRow](_path, "circlees", None, Some("_circle"), x => x.circlees, (row, value) => row.copy(circlees = value))
      override def datees = OptField[Array[TypoLocalDate], PgtestnullRow](_path, "datees", Some("text[]"), Some("_date"), x => x.datees, (row, value) => row.copy(datees = value))
      override def float4es = OptField[Array[Float], PgtestnullRow](_path, "float4es", None, Some("_float4"), x => x.float4es, (row, value) => row.copy(float4es = value))
      override def float8es = OptField[Array[Double], PgtestnullRow](_path, "float8es", None, Some("_float8"), x => x.float8es, (row, value) => row.copy(float8es = value))
      override def inetes = OptField[Array[TypoInet], PgtestnullRow](_path, "inetes", None, Some("_inet"), x => x.inetes, (row, value) => row.copy(inetes = value))
      override def int2es = OptField[Array[TypoShort], PgtestnullRow](_path, "int2es", None, Some("_int2"), x => x.int2es, (row, value) => row.copy(int2es = value))
      override def int2vectores = OptField[Array[TypoInt2Vector], PgtestnullRow](_path, "int2vectores", None, Some("_int2vector"), x => x.int2vectores, (row, value) => row.copy(int2vectores = value))
      override def int4es = OptField[Array[Int], PgtestnullRow](_path, "int4es", None, Some("_int4"), x => x.int4es, (row, value) => row.copy(int4es = value))
      override def int8es = OptField[Array[Long], PgtestnullRow](_path, "int8es", None, Some("_int8"), x => x.int8es, (row, value) => row.copy(int8es = value))
      override def intervales = OptField[Array[TypoInterval], PgtestnullRow](_path, "intervales", None, Some("_interval"), x => x.intervales, (row, value) => row.copy(intervales = value))
      override def jsones = OptField[Array[TypoJson], PgtestnullRow](_path, "jsones", None, Some("_json"), x => x.jsones, (row, value) => row.copy(jsones = value))
      override def jsonbes = OptField[Array[TypoJsonb], PgtestnullRow](_path, "jsonbes", None, Some("_jsonb"), x => x.jsonbes, (row, value) => row.copy(jsonbes = value))
      override def linees = OptField[Array[TypoLine], PgtestnullRow](_path, "linees", None, Some("_line"), x => x.linees, (row, value) => row.copy(linees = value))
      override def lseges = OptField[Array[TypoLineSegment], PgtestnullRow](_path, "lseges", None, Some("_lseg"), x => x.lseges, (row, value) => row.copy(lseges = value))
      override def moneyes = OptField[Array[TypoMoney], PgtestnullRow](_path, "moneyes", Some("numeric[]"), Some("_money"), x => x.moneyes, (row, value) => row.copy(moneyes = value))
      override def myenumes = OptField[Array[Myenum], PgtestnullRow](_path, "myenumes", None, Some("_myenum"), x => x.myenumes, (row, value) => row.copy(myenumes = value))
      override def namees = OptField[Array[String], PgtestnullRow](_path, "namees", None, Some("_name"), x => x.namees, (row, value) => row.copy(namees = value))
      override def numerices = OptField[Array[BigDecimal], PgtestnullRow](_path, "numerices", None, Some("_numeric"), x => x.numerices, (row, value) => row.copy(numerices = value))
      override def pathes = OptField[Array[TypoPath], PgtestnullRow](_path, "pathes", None, Some("_path"), x => x.pathes, (row, value) => row.copy(pathes = value))
      override def pointes = OptField[Array[TypoPoint], PgtestnullRow](_path, "pointes", None, Some("_point"), x => x.pointes, (row, value) => row.copy(pointes = value))
      override def polygones = OptField[Array[TypoPolygon], PgtestnullRow](_path, "polygones", None, Some("_polygon"), x => x.polygones, (row, value) => row.copy(polygones = value))
      override def textes = OptField[Array[String], PgtestnullRow](_path, "textes", None, Some("_text"), x => x.textes, (row, value) => row.copy(textes = value))
      override def timees = OptField[Array[TypoLocalTime], PgtestnullRow](_path, "timees", Some("text[]"), Some("_time"), x => x.timees, (row, value) => row.copy(timees = value))
      override def timestampes = OptField[Array[TypoLocalDateTime], PgtestnullRow](_path, "timestampes", Some("text[]"), Some("_timestamp"), x => x.timestampes, (row, value) => row.copy(timestampes = value))
      override def timestampzes = OptField[Array[TypoInstant], PgtestnullRow](_path, "timestampzes", Some("text[]"), Some("_timestamptz"), x => x.timestampzes, (row, value) => row.copy(timestampzes = value))
      override def timezes = OptField[Array[TypoOffsetTime], PgtestnullRow](_path, "timezes", Some("text[]"), Some("_timetz"), x => x.timezes, (row, value) => row.copy(timezes = value))
      override def uuides = OptField[Array[TypoUUID], PgtestnullRow](_path, "uuides", None, Some("_uuid"), x => x.uuides, (row, value) => row.copy(uuides = value))
      override def varchares = OptField[Array[String], PgtestnullRow](_path, "varchares", None, Some("_varchar"), x => x.varchares, (row, value) => row.copy(varchares = value))
      override def xmles = OptField[Array[TypoXml], PgtestnullRow](_path, "xmles", None, Some("_xml"), x => x.xmles, (row, value) => row.copy(xmles = value))
    }
  
    override lazy val columns: List[FieldLikeNoHkt[?, PgtestnullRow]] =
      List[FieldLikeNoHkt[?, PgtestnullRow]](fields.bool, fields.box, fields.bpchar, fields.bytea, fields.char, fields.circle, fields.date, fields.float4, fields.float8, fields.hstore, fields.inet, fields.int2, fields.int2vector, fields.int4, fields.int8, fields.interval, fields.json, fields.jsonb, fields.line, fields.lseg, fields.money, fields.mydomain, fields.myenum, fields.name, fields.numeric, fields.path, fields.point, fields.polygon, fields.text, fields.time, fields.timestamp, fields.timestampz, fields.timez, fields.uuid, fields.varchar, fields.vector, fields.xml, fields.boxes, fields.bpchares, fields.chares, fields.circlees, fields.datees, fields.float4es, fields.float8es, fields.inetes, fields.int2es, fields.int2vectores, fields.int4es, fields.int8es, fields.intervales, fields.jsones, fields.jsonbes, fields.linees, fields.lseges, fields.moneyes, fields.myenumes, fields.namees, fields.numerices, fields.pathes, fields.pointes, fields.polygones, fields.textes, fields.timees, fields.timestampes, fields.timestampzes, fields.timezes, fields.uuides, fields.varchares, fields.xmles)
  
    override def copy(path: List[Path]): Impl =
      new Impl(path)
  }
  
}
