/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package public
package pgtest

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
import typo.dsl.SqlExpr.Field
import typo.dsl.SqlExpr.FieldLikeNoHkt
import typo.dsl.Structure.Relation

trait PgtestFields {
  def bool: Field[Boolean, PgtestRow]
  def box: Field[TypoBox, PgtestRow]
  def bpchar: Field[/* bpchar, max 3 chars */ String, PgtestRow]
  def bytea: Field[TypoBytea, PgtestRow]
  def char: Field[/* bpchar, max 1 chars */ String, PgtestRow]
  def circle: Field[TypoCircle, PgtestRow]
  def date: Field[TypoLocalDate, PgtestRow]
  def float4: Field[Float, PgtestRow]
  def float8: Field[Double, PgtestRow]
  def hstore: Field[TypoHStore, PgtestRow]
  def inet: Field[TypoInet, PgtestRow]
  def int2: Field[TypoShort, PgtestRow]
  def int2vector: Field[TypoInt2Vector, PgtestRow]
  def int4: Field[Int, PgtestRow]
  def int8: Field[Long, PgtestRow]
  def interval: Field[TypoInterval, PgtestRow]
  def json: Field[TypoJson, PgtestRow]
  def jsonb: Field[TypoJsonb, PgtestRow]
  def line: Field[TypoLine, PgtestRow]
  def lseg: Field[TypoLineSegment, PgtestRow]
  def money: Field[TypoMoney, PgtestRow]
  def mydomain: Field[Mydomain, PgtestRow]
  def myenum: Field[Myenum, PgtestRow]
  def name: Field[String, PgtestRow]
  def numeric: Field[BigDecimal, PgtestRow]
  def path: Field[TypoPath, PgtestRow]
  def point: Field[TypoPoint, PgtestRow]
  def polygon: Field[TypoPolygon, PgtestRow]
  def text: Field[String, PgtestRow]
  def time: Field[TypoLocalTime, PgtestRow]
  def timestamp: Field[TypoLocalDateTime, PgtestRow]
  def timestampz: Field[TypoInstant, PgtestRow]
  def timez: Field[TypoOffsetTime, PgtestRow]
  def uuid: Field[TypoUUID, PgtestRow]
  def varchar: Field[String, PgtestRow]
  def vector: Field[TypoVector, PgtestRow]
  def xml: Field[TypoXml, PgtestRow]
  def boxes: Field[Array[TypoBox], PgtestRow]
  def bpchares: Field[Array[/* bpchar */ String], PgtestRow]
  def chares: Field[Array[/* bpchar */ String], PgtestRow]
  def circlees: Field[Array[TypoCircle], PgtestRow]
  def datees: Field[Array[TypoLocalDate], PgtestRow]
  def float4es: Field[Array[Float], PgtestRow]
  def float8es: Field[Array[Double], PgtestRow]
  def inetes: Field[Array[TypoInet], PgtestRow]
  def int2es: Field[Array[TypoShort], PgtestRow]
  def int2vectores: Field[Array[TypoInt2Vector], PgtestRow]
  def int4es: Field[Array[Int], PgtestRow]
  def int8es: Field[Array[Long], PgtestRow]
  def intervales: Field[Array[TypoInterval], PgtestRow]
  def jsones: Field[Array[TypoJson], PgtestRow]
  def jsonbes: Field[Array[TypoJsonb], PgtestRow]
  def linees: Field[Array[TypoLine], PgtestRow]
  def lseges: Field[Array[TypoLineSegment], PgtestRow]
  def moneyes: Field[Array[TypoMoney], PgtestRow]
  def mydomaines: Field[Array[Mydomain], PgtestRow]
  def myenumes: Field[Array[Myenum], PgtestRow]
  def namees: Field[Array[String], PgtestRow]
  def numerices: Field[Array[BigDecimal], PgtestRow]
  def pathes: Field[Array[TypoPath], PgtestRow]
  def pointes: Field[Array[TypoPoint], PgtestRow]
  def polygones: Field[Array[TypoPolygon], PgtestRow]
  def textes: Field[Array[String], PgtestRow]
  def timees: Field[Array[TypoLocalTime], PgtestRow]
  def timestampes: Field[Array[TypoLocalDateTime], PgtestRow]
  def timestampzes: Field[Array[TypoInstant], PgtestRow]
  def timezes: Field[Array[TypoOffsetTime], PgtestRow]
  def uuides: Field[Array[TypoUUID], PgtestRow]
  def varchares: Field[Array[String], PgtestRow]
  def xmles: Field[Array[TypoXml], PgtestRow]
}

object PgtestFields {
  lazy val structure: Relation[PgtestFields, PgtestRow] =
    new Impl(Nil)
    
  private final class Impl(val _path: List[Path])
    extends Relation[PgtestFields, PgtestRow] {
  
    override lazy val fields: PgtestFields = new PgtestFields {
      override def bool = Field[Boolean, PgtestRow](_path, "bool", None, None, x => x.bool, (row, value) => row.copy(bool = value))
      override def box = Field[TypoBox, PgtestRow](_path, "box", None, Some("box"), x => x.box, (row, value) => row.copy(box = value))
      override def bpchar = Field[/* bpchar, max 3 chars */ String, PgtestRow](_path, "bpchar", None, Some("bpchar"), x => x.bpchar, (row, value) => row.copy(bpchar = value))
      override def bytea = Field[TypoBytea, PgtestRow](_path, "bytea", None, Some("bytea"), x => x.bytea, (row, value) => row.copy(bytea = value))
      override def char = Field[/* bpchar, max 1 chars */ String, PgtestRow](_path, "char", None, Some("bpchar"), x => x.char, (row, value) => row.copy(char = value))
      override def circle = Field[TypoCircle, PgtestRow](_path, "circle", None, Some("circle"), x => x.circle, (row, value) => row.copy(circle = value))
      override def date = Field[TypoLocalDate, PgtestRow](_path, "date", Some("text"), Some("date"), x => x.date, (row, value) => row.copy(date = value))
      override def float4 = Field[Float, PgtestRow](_path, "float4", None, Some("float4"), x => x.float4, (row, value) => row.copy(float4 = value))
      override def float8 = Field[Double, PgtestRow](_path, "float8", None, Some("float8"), x => x.float8, (row, value) => row.copy(float8 = value))
      override def hstore = Field[TypoHStore, PgtestRow](_path, "hstore", None, Some("hstore"), x => x.hstore, (row, value) => row.copy(hstore = value))
      override def inet = Field[TypoInet, PgtestRow](_path, "inet", None, Some("inet"), x => x.inet, (row, value) => row.copy(inet = value))
      override def int2 = Field[TypoShort, PgtestRow](_path, "int2", None, Some("int2"), x => x.int2, (row, value) => row.copy(int2 = value))
      override def int2vector = Field[TypoInt2Vector, PgtestRow](_path, "int2vector", None, Some("int2vector"), x => x.int2vector, (row, value) => row.copy(int2vector = value))
      override def int4 = Field[Int, PgtestRow](_path, "int4", None, Some("int4"), x => x.int4, (row, value) => row.copy(int4 = value))
      override def int8 = Field[Long, PgtestRow](_path, "int8", None, Some("int8"), x => x.int8, (row, value) => row.copy(int8 = value))
      override def interval = Field[TypoInterval, PgtestRow](_path, "interval", None, Some("interval"), x => x.interval, (row, value) => row.copy(interval = value))
      override def json = Field[TypoJson, PgtestRow](_path, "json", None, Some("json"), x => x.json, (row, value) => row.copy(json = value))
      override def jsonb = Field[TypoJsonb, PgtestRow](_path, "jsonb", None, Some("jsonb"), x => x.jsonb, (row, value) => row.copy(jsonb = value))
      override def line = Field[TypoLine, PgtestRow](_path, "line", None, Some("line"), x => x.line, (row, value) => row.copy(line = value))
      override def lseg = Field[TypoLineSegment, PgtestRow](_path, "lseg", None, Some("lseg"), x => x.lseg, (row, value) => row.copy(lseg = value))
      override def money = Field[TypoMoney, PgtestRow](_path, "money", Some("numeric"), Some("money"), x => x.money, (row, value) => row.copy(money = value))
      override def mydomain = Field[Mydomain, PgtestRow](_path, "mydomain", None, Some("text"), x => x.mydomain, (row, value) => row.copy(mydomain = value))
      override def myenum = Field[Myenum, PgtestRow](_path, "myenum", None, Some("public.myenum"), x => x.myenum, (row, value) => row.copy(myenum = value))
      override def name = Field[String, PgtestRow](_path, "name", None, Some("name"), x => x.name, (row, value) => row.copy(name = value))
      override def numeric = Field[BigDecimal, PgtestRow](_path, "numeric", None, Some("numeric"), x => x.numeric, (row, value) => row.copy(numeric = value))
      override def path = Field[TypoPath, PgtestRow](_path, "path", None, Some("path"), x => x.path, (row, value) => row.copy(path = value))
      override def point = Field[TypoPoint, PgtestRow](_path, "point", None, Some("point"), x => x.point, (row, value) => row.copy(point = value))
      override def polygon = Field[TypoPolygon, PgtestRow](_path, "polygon", None, Some("polygon"), x => x.polygon, (row, value) => row.copy(polygon = value))
      override def text = Field[String, PgtestRow](_path, "text", None, None, x => x.text, (row, value) => row.copy(text = value))
      override def time = Field[TypoLocalTime, PgtestRow](_path, "time", Some("text"), Some("time"), x => x.time, (row, value) => row.copy(time = value))
      override def timestamp = Field[TypoLocalDateTime, PgtestRow](_path, "timestamp", Some("text"), Some("timestamp"), x => x.timestamp, (row, value) => row.copy(timestamp = value))
      override def timestampz = Field[TypoInstant, PgtestRow](_path, "timestampz", Some("text"), Some("timestamptz"), x => x.timestampz, (row, value) => row.copy(timestampz = value))
      override def timez = Field[TypoOffsetTime, PgtestRow](_path, "timez", Some("text"), Some("timetz"), x => x.timez, (row, value) => row.copy(timez = value))
      override def uuid = Field[TypoUUID, PgtestRow](_path, "uuid", None, Some("uuid"), x => x.uuid, (row, value) => row.copy(uuid = value))
      override def varchar = Field[String, PgtestRow](_path, "varchar", None, None, x => x.varchar, (row, value) => row.copy(varchar = value))
      override def vector = Field[TypoVector, PgtestRow](_path, "vector", Some("float4[]"), Some("vector"), x => x.vector, (row, value) => row.copy(vector = value))
      override def xml = Field[TypoXml, PgtestRow](_path, "xml", None, Some("xml"), x => x.xml, (row, value) => row.copy(xml = value))
      override def boxes = Field[Array[TypoBox], PgtestRow](_path, "boxes", None, Some("box[]"), x => x.boxes, (row, value) => row.copy(boxes = value))
      override def bpchares = Field[Array[/* bpchar */ String], PgtestRow](_path, "bpchares", None, Some("bpchar[]"), x => x.bpchares, (row, value) => row.copy(bpchares = value))
      override def chares = Field[Array[/* bpchar */ String], PgtestRow](_path, "chares", None, Some("bpchar[]"), x => x.chares, (row, value) => row.copy(chares = value))
      override def circlees = Field[Array[TypoCircle], PgtestRow](_path, "circlees", None, Some("circle[]"), x => x.circlees, (row, value) => row.copy(circlees = value))
      override def datees = Field[Array[TypoLocalDate], PgtestRow](_path, "datees", Some("text[]"), Some("date[]"), x => x.datees, (row, value) => row.copy(datees = value))
      override def float4es = Field[Array[Float], PgtestRow](_path, "float4es", None, Some("float4[]"), x => x.float4es, (row, value) => row.copy(float4es = value))
      override def float8es = Field[Array[Double], PgtestRow](_path, "float8es", None, Some("float8[]"), x => x.float8es, (row, value) => row.copy(float8es = value))
      override def inetes = Field[Array[TypoInet], PgtestRow](_path, "inetes", None, Some("inet[]"), x => x.inetes, (row, value) => row.copy(inetes = value))
      override def int2es = Field[Array[TypoShort], PgtestRow](_path, "int2es", None, Some("int2[]"), x => x.int2es, (row, value) => row.copy(int2es = value))
      override def int2vectores = Field[Array[TypoInt2Vector], PgtestRow](_path, "int2vectores", None, Some("int2vector[]"), x => x.int2vectores, (row, value) => row.copy(int2vectores = value))
      override def int4es = Field[Array[Int], PgtestRow](_path, "int4es", None, Some("int4[]"), x => x.int4es, (row, value) => row.copy(int4es = value))
      override def int8es = Field[Array[Long], PgtestRow](_path, "int8es", None, Some("int8[]"), x => x.int8es, (row, value) => row.copy(int8es = value))
      override def intervales = Field[Array[TypoInterval], PgtestRow](_path, "intervales", None, Some("interval[]"), x => x.intervales, (row, value) => row.copy(intervales = value))
      override def jsones = Field[Array[TypoJson], PgtestRow](_path, "jsones", None, Some("json[]"), x => x.jsones, (row, value) => row.copy(jsones = value))
      override def jsonbes = Field[Array[TypoJsonb], PgtestRow](_path, "jsonbes", None, Some("jsonb[]"), x => x.jsonbes, (row, value) => row.copy(jsonbes = value))
      override def linees = Field[Array[TypoLine], PgtestRow](_path, "linees", None, Some("line[]"), x => x.linees, (row, value) => row.copy(linees = value))
      override def lseges = Field[Array[TypoLineSegment], PgtestRow](_path, "lseges", None, Some("lseg[]"), x => x.lseges, (row, value) => row.copy(lseges = value))
      override def moneyes = Field[Array[TypoMoney], PgtestRow](_path, "moneyes", Some("numeric[]"), Some("money[]"), x => x.moneyes, (row, value) => row.copy(moneyes = value))
      override def mydomaines = Field[Array[Mydomain], PgtestRow](_path, "mydomaines", Some("text[]"), Some("mydomain[]"), x => x.mydomaines, (row, value) => row.copy(mydomaines = value))
      override def myenumes = Field[Array[Myenum], PgtestRow](_path, "myenumes", None, Some("myenum[]"), x => x.myenumes, (row, value) => row.copy(myenumes = value))
      override def namees = Field[Array[String], PgtestRow](_path, "namees", None, Some("name[]"), x => x.namees, (row, value) => row.copy(namees = value))
      override def numerices = Field[Array[BigDecimal], PgtestRow](_path, "numerices", None, Some("numeric[]"), x => x.numerices, (row, value) => row.copy(numerices = value))
      override def pathes = Field[Array[TypoPath], PgtestRow](_path, "pathes", None, Some("path[]"), x => x.pathes, (row, value) => row.copy(pathes = value))
      override def pointes = Field[Array[TypoPoint], PgtestRow](_path, "pointes", None, Some("point[]"), x => x.pointes, (row, value) => row.copy(pointes = value))
      override def polygones = Field[Array[TypoPolygon], PgtestRow](_path, "polygones", None, Some("polygon[]"), x => x.polygones, (row, value) => row.copy(polygones = value))
      override def textes = Field[Array[String], PgtestRow](_path, "textes", None, Some("text[]"), x => x.textes, (row, value) => row.copy(textes = value))
      override def timees = Field[Array[TypoLocalTime], PgtestRow](_path, "timees", Some("text[]"), Some("time[]"), x => x.timees, (row, value) => row.copy(timees = value))
      override def timestampes = Field[Array[TypoLocalDateTime], PgtestRow](_path, "timestampes", Some("text[]"), Some("timestamp[]"), x => x.timestampes, (row, value) => row.copy(timestampes = value))
      override def timestampzes = Field[Array[TypoInstant], PgtestRow](_path, "timestampzes", Some("text[]"), Some("timestamptz[]"), x => x.timestampzes, (row, value) => row.copy(timestampzes = value))
      override def timezes = Field[Array[TypoOffsetTime], PgtestRow](_path, "timezes", Some("text[]"), Some("timetz[]"), x => x.timezes, (row, value) => row.copy(timezes = value))
      override def uuides = Field[Array[TypoUUID], PgtestRow](_path, "uuides", None, Some("uuid[]"), x => x.uuides, (row, value) => row.copy(uuides = value))
      override def varchares = Field[Array[String], PgtestRow](_path, "varchares", None, Some("varchar[]"), x => x.varchares, (row, value) => row.copy(varchares = value))
      override def xmles = Field[Array[TypoXml], PgtestRow](_path, "xmles", None, Some("xml[]"), x => x.xmles, (row, value) => row.copy(xmles = value))
    }
  
    override lazy val columns: List[FieldLikeNoHkt[?, PgtestRow]] =
      List[FieldLikeNoHkt[?, PgtestRow]](fields.bool, fields.box, fields.bpchar, fields.bytea, fields.char, fields.circle, fields.date, fields.float4, fields.float8, fields.hstore, fields.inet, fields.int2, fields.int2vector, fields.int4, fields.int8, fields.interval, fields.json, fields.jsonb, fields.line, fields.lseg, fields.money, fields.mydomain, fields.myenum, fields.name, fields.numeric, fields.path, fields.point, fields.polygon, fields.text, fields.time, fields.timestamp, fields.timestampz, fields.timez, fields.uuid, fields.varchar, fields.vector, fields.xml, fields.boxes, fields.bpchares, fields.chares, fields.circlees, fields.datees, fields.float4es, fields.float8es, fields.inetes, fields.int2es, fields.int2vectores, fields.int4es, fields.int8es, fields.intervales, fields.jsones, fields.jsonbes, fields.linees, fields.lseges, fields.moneyes, fields.mydomaines, fields.myenumes, fields.namees, fields.numerices, fields.pathes, fields.pointes, fields.polygones, fields.textes, fields.timees, fields.timestampes, fields.timestampzes, fields.timezes, fields.uuides, fields.varchares, fields.xmles)
  
    override def copy(path: List[Path]): Impl =
      new Impl(path)
  }
  
}
