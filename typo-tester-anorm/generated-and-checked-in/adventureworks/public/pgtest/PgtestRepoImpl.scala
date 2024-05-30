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
import adventureworks.streamingInsert
import anorm.ParameterMetaData
import anorm.ParameterValue
import anorm.SqlStringInterpolation
import anorm.ToStatement
import java.sql.Connection
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql
import typo.dsl.UpdateBuilder

class PgtestRepoImpl extends PgtestRepo {
  override def delete: DeleteBuilder[PgtestFields, PgtestRow] = {
    DeleteBuilder("public.pgtest", PgtestFields.structure)
  }
  override def insert(unsaved: PgtestRow)(implicit c: Connection): PgtestRow = {
    SQL"""insert into public.pgtest("bool", "box", "bpchar", "bytea", "char", "circle", "date", "float4", "float8", "hstore", "inet", "int2", "int2vector", "int4", "int8", "interval", "json", "jsonb", "line", "lseg", "money", "mydomain", "myenum", "name", "numeric", "path", "point", "polygon", "text", "time", "timestamp", "timestampz", "timez", "uuid", "varchar", "vector", "xml", "boxes", "bpchares", "chares", "circlees", "datees", "float4es", "float8es", "inetes", "int2es", "int2vectores", "int4es", "int8es", "intervales", "jsones", "jsonbes", "linees", "lseges", "moneyes", "mydomaines", "myenumes", "namees", "numerices", "pathes", "pointes", "polygones", "textes", "timees", "timestampes", "timestampzes", "timezes", "uuides", "varchares", "xmles")
          values (${ParameterValue(unsaved.bool, null, ToStatement.booleanToStatement)}, ${ParameterValue(unsaved.box, null, TypoBox.toStatement)}::box, ${ParameterValue(unsaved.bpchar, null, ToStatement.stringToStatement)}::bpchar, ${ParameterValue(unsaved.bytea, null, TypoBytea.toStatement)}::bytea, ${ParameterValue(unsaved.char, null, ToStatement.stringToStatement)}::bpchar, ${ParameterValue(unsaved.circle, null, TypoCircle.toStatement)}::circle, ${ParameterValue(unsaved.date, null, TypoLocalDate.toStatement)}::date, ${ParameterValue(unsaved.float4, null, ToStatement.floatToStatement)}::float4, ${ParameterValue(unsaved.float8, null, ToStatement.doubleToStatement)}::float8, ${ParameterValue(unsaved.hstore, null, TypoHStore.toStatement)}::hstore, ${ParameterValue(unsaved.inet, null, TypoInet.toStatement)}::inet, ${ParameterValue(unsaved.int2, null, TypoShort.toStatement)}::int2, ${ParameterValue(unsaved.int2vector, null, TypoInt2Vector.toStatement)}::int2vector, ${ParameterValue(unsaved.int4, null, ToStatement.intToStatement)}::int4, ${ParameterValue(unsaved.int8, null, ToStatement.longToStatement)}::int8, ${ParameterValue(unsaved.interval, null, TypoInterval.toStatement)}::interval, ${ParameterValue(unsaved.json, null, TypoJson.toStatement)}::json, ${ParameterValue(unsaved.jsonb, null, TypoJsonb.toStatement)}::jsonb, ${ParameterValue(unsaved.line, null, TypoLine.toStatement)}::line, ${ParameterValue(unsaved.lseg, null, TypoLineSegment.toStatement)}::lseg, ${ParameterValue(unsaved.money, null, TypoMoney.toStatement)}::money, ${ParameterValue(unsaved.mydomain, null, Mydomain.toStatement)}::text, ${ParameterValue(unsaved.myenum, null, Myenum.toStatement)}::public.myenum, ${ParameterValue(unsaved.name, null, ToStatement.stringToStatement)}::name, ${ParameterValue(unsaved.numeric, null, ToStatement.scalaBigDecimalToStatement)}::numeric, ${ParameterValue(unsaved.path, null, TypoPath.toStatement)}::path, ${ParameterValue(unsaved.point, null, TypoPoint.toStatement)}::point, ${ParameterValue(unsaved.polygon, null, TypoPolygon.toStatement)}::polygon, ${ParameterValue(unsaved.text, null, ToStatement.stringToStatement)}, ${ParameterValue(unsaved.time, null, TypoLocalTime.toStatement)}::time, ${ParameterValue(unsaved.timestamp, null, TypoLocalDateTime.toStatement)}::timestamp, ${ParameterValue(unsaved.timestampz, null, TypoInstant.toStatement)}::timestamptz, ${ParameterValue(unsaved.timez, null, TypoOffsetTime.toStatement)}::timetz, ${ParameterValue(unsaved.uuid, null, TypoUUID.toStatement)}::uuid, ${ParameterValue(unsaved.varchar, null, ToStatement.stringToStatement)}, ${ParameterValue(unsaved.vector, null, TypoVector.toStatement)}::vector, ${ParameterValue(unsaved.xml, null, TypoXml.toStatement)}::xml, ${ParameterValue(unsaved.boxes, null, TypoBox.arrayToStatement)}::box[], ${ParameterValue(unsaved.bpchares, null, ToStatement.arrayToParameter(ParameterMetaData.StringParameterMetaData))}::bpchar[], ${ParameterValue(unsaved.chares, null, ToStatement.arrayToParameter(ParameterMetaData.StringParameterMetaData))}::bpchar[], ${ParameterValue(unsaved.circlees, null, TypoCircle.arrayToStatement)}::circle[], ${ParameterValue(unsaved.datees, null, TypoLocalDate.arrayToStatement)}::date[], ${ParameterValue(unsaved.float4es, null, adventureworks.FloatArrayToStatement)}::float4[], ${ParameterValue(unsaved.float8es, null, adventureworks.DoubleArrayToStatement)}::float8[], ${ParameterValue(unsaved.inetes, null, TypoInet.arrayToStatement)}::inet[], ${ParameterValue(unsaved.int2es, null, TypoShort.arrayToStatement)}::int2[], ${ParameterValue(unsaved.int2vectores, null, TypoInt2Vector.arrayToStatement)}::int2vector[], ${ParameterValue(unsaved.int4es, null, adventureworks.IntArrayToStatement)}::int4[], ${ParameterValue(unsaved.int8es, null, adventureworks.LongArrayToStatement)}::int8[], ${ParameterValue(unsaved.intervales, null, TypoInterval.arrayToStatement)}::interval[], ${ParameterValue(unsaved.jsones, null, TypoJson.arrayToStatement)}::json[], ${ParameterValue(unsaved.jsonbes, null, TypoJsonb.arrayToStatement)}::jsonb[], ${ParameterValue(unsaved.linees, null, TypoLine.arrayToStatement)}::line[], ${ParameterValue(unsaved.lseges, null, TypoLineSegment.arrayToStatement)}::lseg[], ${ParameterValue(unsaved.moneyes, null, TypoMoney.arrayToStatement)}::money[], ${ParameterValue(unsaved.mydomaines, null, Mydomain.arrayToStatement)}::mydomain[], ${ParameterValue(unsaved.myenumes, null, Myenum.arrayToStatement)}::myenum[], ${ParameterValue(unsaved.namees, null, ToStatement.arrayToParameter(ParameterMetaData.StringParameterMetaData))}::name[], ${ParameterValue(unsaved.numerices, null, adventureworks.BigDecimalArrayToStatement)}::numeric[], ${ParameterValue(unsaved.pathes, null, TypoPath.arrayToStatement)}::path[], ${ParameterValue(unsaved.pointes, null, TypoPoint.arrayToStatement)}::point[], ${ParameterValue(unsaved.polygones, null, TypoPolygon.arrayToStatement)}::polygon[], ${ParameterValue(unsaved.textes, null, ToStatement.arrayToParameter(ParameterMetaData.StringParameterMetaData))}::text[], ${ParameterValue(unsaved.timees, null, TypoLocalTime.arrayToStatement)}::time[], ${ParameterValue(unsaved.timestampes, null, TypoLocalDateTime.arrayToStatement)}::timestamp[], ${ParameterValue(unsaved.timestampzes, null, TypoInstant.arrayToStatement)}::timestamptz[], ${ParameterValue(unsaved.timezes, null, TypoOffsetTime.arrayToStatement)}::timetz[], ${ParameterValue(unsaved.uuides, null, TypoUUID.arrayToStatement)}::uuid[], ${ParameterValue(unsaved.varchares, null, ToStatement.arrayToParameter(ParameterMetaData.StringParameterMetaData))}::varchar[], ${ParameterValue(unsaved.xmles, null, TypoXml.arrayToStatement)}::xml[])
          returning "bool", "box", "bpchar", "bytea", "char", "circle", "date"::text, "float4", "float8", "hstore", "inet", "int2", "int2vector", "int4", "int8", "interval", "json", "jsonb", "line", "lseg", "money"::numeric, "mydomain", "myenum", "name", "numeric", "path", "point", "polygon", "text", "time"::text, "timestamp"::text, "timestampz"::text, "timez"::text, "uuid", "varchar", "vector"::float4[], "xml", "boxes", "bpchares", "chares", "circlees", "datees"::text[], "float4es", "float8es", "inetes", "int2es", "int2vectores", "int4es", "int8es", "intervales", "jsones", "jsonbes", "linees", "lseges", "moneyes"::numeric[], "mydomaines"::text[], "myenumes", "namees", "numerices", "pathes", "pointes", "polygones", "textes", "timees"::text[], "timestampes"::text[], "timestampzes"::text[], "timezes"::text[], "uuides", "varchares", "xmles"
       """
      .executeInsert(PgtestRow.rowParser(1).single)
    
  }
  override def insertStreaming(unsaved: Iterator[PgtestRow], batchSize: Int = 10000)(implicit c: Connection): Long = {
    streamingInsert(s"""COPY public.pgtest("bool", "box", "bpchar", "bytea", "char", "circle", "date", "float4", "float8", "hstore", "inet", "int2", "int2vector", "int4", "int8", "interval", "json", "jsonb", "line", "lseg", "money", "mydomain", "myenum", "name", "numeric", "path", "point", "polygon", "text", "time", "timestamp", "timestampz", "timez", "uuid", "varchar", "vector", "xml", "boxes", "bpchares", "chares", "circlees", "datees", "float4es", "float8es", "inetes", "int2es", "int2vectores", "int4es", "int8es", "intervales", "jsones", "jsonbes", "linees", "lseges", "moneyes", "mydomaines", "myenumes", "namees", "numerices", "pathes", "pointes", "polygones", "textes", "timees", "timestampes", "timestampzes", "timezes", "uuides", "varchares", "xmles") FROM STDIN""", batchSize, unsaved)(PgtestRow.text, c)
  }
  override def select: SelectBuilder[PgtestFields, PgtestRow] = {
    SelectBuilderSql("public.pgtest", PgtestFields.structure, PgtestRow.rowParser)
  }
  override def selectAll(implicit c: Connection): List[PgtestRow] = {
    SQL"""select "bool", "box", "bpchar", "bytea", "char", "circle", "date"::text, "float4", "float8", "hstore", "inet", "int2", "int2vector", "int4", "int8", "interval", "json", "jsonb", "line", "lseg", "money"::numeric, "mydomain", "myenum", "name", "numeric", "path", "point", "polygon", "text", "time"::text, "timestamp"::text, "timestampz"::text, "timez"::text, "uuid", "varchar", "vector"::float4[], "xml", "boxes", "bpchares", "chares", "circlees", "datees"::text[], "float4es", "float8es", "inetes", "int2es", "int2vectores", "int4es", "int8es", "intervales", "jsones", "jsonbes", "linees", "lseges", "moneyes"::numeric[], "mydomaines"::text[], "myenumes", "namees", "numerices", "pathes", "pointes", "polygones", "textes", "timees"::text[], "timestampes"::text[], "timestampzes"::text[], "timezes"::text[], "uuides", "varchares", "xmles"
          from public.pgtest
       """.as(PgtestRow.rowParser(1).*)
  }
  override def update: UpdateBuilder[PgtestFields, PgtestRow] = {
    UpdateBuilder("public.pgtest", PgtestFields.structure, PgtestRow.rowParser)
  }
}
