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

class PgtestnullRepoImpl extends PgtestnullRepo {
  override def delete: DeleteBuilder[PgtestnullFields, PgtestnullRow] = {
    DeleteBuilder("public.pgtestnull", PgtestnullFields.structure)
  }
  override def insert(unsaved: PgtestnullRow)(implicit c: Connection): PgtestnullRow = {
    SQL"""insert into public.pgtestnull("bool", "box", "bpchar", "bytea", "char", "circle", "date", "float4", "float8", "hstore", "inet", "int2", "int2vector", "int4", "int8", "interval", "json", "jsonb", "line", "lseg", "money", "mydomain", "myenum", "name", "numeric", "path", "point", "polygon", "text", "time", "timestamp", "timestampz", "timez", "uuid", "varchar", "vector", "xml", "boxes", "bpchares", "chares", "circlees", "datees", "float4es", "float8es", "inetes", "int2es", "int2vectores", "int4es", "int8es", "intervales", "jsones", "jsonbes", "linees", "lseges", "moneyes", "myenumes", "namees", "numerices", "pathes", "pointes", "polygones", "textes", "timees", "timestampes", "timestampzes", "timezes", "uuides", "varchares", "xmles")
          values (${ParameterValue(unsaved.bool, null, ToStatement.optionToStatement(ToStatement.booleanToStatement, ParameterMetaData.BooleanParameterMetaData))}, ${ParameterValue(unsaved.box, null, ToStatement.optionToStatement(TypoBox.toStatement, TypoBox.parameterMetadata))}::box, ${ParameterValue(unsaved.bpchar, null, ToStatement.optionToStatement(ToStatement.stringToStatement, ParameterMetaData.StringParameterMetaData))}::bpchar, ${ParameterValue(unsaved.bytea, null, ToStatement.optionToStatement(TypoBytea.toStatement, TypoBytea.parameterMetadata))}::bytea, ${ParameterValue(unsaved.char, null, ToStatement.optionToStatement(ToStatement.stringToStatement, ParameterMetaData.StringParameterMetaData))}::bpchar, ${ParameterValue(unsaved.circle, null, ToStatement.optionToStatement(TypoCircle.toStatement, TypoCircle.parameterMetadata))}::circle, ${ParameterValue(unsaved.date, null, ToStatement.optionToStatement(TypoLocalDate.toStatement, TypoLocalDate.parameterMetadata))}::date, ${ParameterValue(unsaved.float4, null, ToStatement.optionToStatement(ToStatement.floatToStatement, ParameterMetaData.FloatParameterMetaData))}::float4, ${ParameterValue(unsaved.float8, null, ToStatement.optionToStatement(ToStatement.doubleToStatement, ParameterMetaData.DoubleParameterMetaData))}::float8, ${ParameterValue(unsaved.hstore, null, ToStatement.optionToStatement(TypoHStore.toStatement, TypoHStore.parameterMetadata))}::hstore, ${ParameterValue(unsaved.inet, null, ToStatement.optionToStatement(TypoInet.toStatement, TypoInet.parameterMetadata))}::inet, ${ParameterValue(unsaved.int2, null, ToStatement.optionToStatement(TypoShort.toStatement, TypoShort.parameterMetadata))}::int2, ${ParameterValue(unsaved.int2vector, null, ToStatement.optionToStatement(TypoInt2Vector.toStatement, TypoInt2Vector.parameterMetadata))}::int2vector, ${ParameterValue(unsaved.int4, null, ToStatement.optionToStatement(ToStatement.intToStatement, ParameterMetaData.IntParameterMetaData))}::int4, ${ParameterValue(unsaved.int8, null, ToStatement.optionToStatement(ToStatement.longToStatement, ParameterMetaData.LongParameterMetaData))}::int8, ${ParameterValue(unsaved.interval, null, ToStatement.optionToStatement(TypoInterval.toStatement, TypoInterval.parameterMetadata))}::interval, ${ParameterValue(unsaved.json, null, ToStatement.optionToStatement(TypoJson.toStatement, TypoJson.parameterMetadata))}::json, ${ParameterValue(unsaved.jsonb, null, ToStatement.optionToStatement(TypoJsonb.toStatement, TypoJsonb.parameterMetadata))}::jsonb, ${ParameterValue(unsaved.line, null, ToStatement.optionToStatement(TypoLine.toStatement, TypoLine.parameterMetadata))}::line, ${ParameterValue(unsaved.lseg, null, ToStatement.optionToStatement(TypoLineSegment.toStatement, TypoLineSegment.parameterMetadata))}::lseg, ${ParameterValue(unsaved.money, null, ToStatement.optionToStatement(TypoMoney.toStatement, TypoMoney.parameterMetadata))}::money, ${ParameterValue(unsaved.mydomain, null, ToStatement.optionToStatement(Mydomain.toStatement, Mydomain.parameterMetadata))}::text, ${ParameterValue(unsaved.myenum, null, ToStatement.optionToStatement(Myenum.toStatement, Myenum.parameterMetadata))}::public.myenum, ${ParameterValue(unsaved.name, null, ToStatement.optionToStatement(ToStatement.stringToStatement, ParameterMetaData.StringParameterMetaData))}::name, ${ParameterValue(unsaved.numeric, null, ToStatement.optionToStatement(ToStatement.scalaBigDecimalToStatement, ParameterMetaData.BigDecimalParameterMetaData))}::numeric, ${ParameterValue(unsaved.path, null, ToStatement.optionToStatement(TypoPath.toStatement, TypoPath.parameterMetadata))}::path, ${ParameterValue(unsaved.point, null, ToStatement.optionToStatement(TypoPoint.toStatement, TypoPoint.parameterMetadata))}::point, ${ParameterValue(unsaved.polygon, null, ToStatement.optionToStatement(TypoPolygon.toStatement, TypoPolygon.parameterMetadata))}::polygon, ${ParameterValue(unsaved.text, null, ToStatement.optionToStatement(ToStatement.stringToStatement, ParameterMetaData.StringParameterMetaData))}, ${ParameterValue(unsaved.time, null, ToStatement.optionToStatement(TypoLocalTime.toStatement, TypoLocalTime.parameterMetadata))}::time, ${ParameterValue(unsaved.timestamp, null, ToStatement.optionToStatement(TypoLocalDateTime.toStatement, TypoLocalDateTime.parameterMetadata))}::timestamp, ${ParameterValue(unsaved.timestampz, null, ToStatement.optionToStatement(TypoInstant.toStatement, TypoInstant.parameterMetadata))}::timestamptz, ${ParameterValue(unsaved.timez, null, ToStatement.optionToStatement(TypoOffsetTime.toStatement, TypoOffsetTime.parameterMetadata))}::timetz, ${ParameterValue(unsaved.uuid, null, ToStatement.optionToStatement(TypoUUID.toStatement, TypoUUID.parameterMetadata))}::uuid, ${ParameterValue(unsaved.varchar, null, ToStatement.optionToStatement(ToStatement.stringToStatement, ParameterMetaData.StringParameterMetaData))}, ${ParameterValue(unsaved.vector, null, ToStatement.optionToStatement(TypoVector.toStatement, TypoVector.parameterMetadata))}::vector, ${ParameterValue(unsaved.xml, null, ToStatement.optionToStatement(TypoXml.toStatement, TypoXml.parameterMetadata))}::xml, ${ParameterValue(unsaved.boxes, null, ToStatement.optionToStatement(TypoBox.arrayToStatement, adventureworks.arrayParameterMetaData(TypoBox.parameterMetadata)))}::_box, ${ParameterValue(unsaved.bpchares, null, ToStatement.optionToStatement(ToStatement.arrayToParameter(ParameterMetaData.StringParameterMetaData), adventureworks.arrayParameterMetaData(ParameterMetaData.StringParameterMetaData)))}::_bpchar, ${ParameterValue(unsaved.chares, null, ToStatement.optionToStatement(ToStatement.arrayToParameter(ParameterMetaData.StringParameterMetaData), adventureworks.arrayParameterMetaData(ParameterMetaData.StringParameterMetaData)))}::_bpchar, ${ParameterValue(unsaved.circlees, null, ToStatement.optionToStatement(TypoCircle.arrayToStatement, adventureworks.arrayParameterMetaData(TypoCircle.parameterMetadata)))}::_circle, ${ParameterValue(unsaved.datees, null, ToStatement.optionToStatement(TypoLocalDate.arrayToStatement, adventureworks.arrayParameterMetaData(TypoLocalDate.parameterMetadata)))}::_date, ${ParameterValue(unsaved.float4es, null, ToStatement.optionToStatement(adventureworks.FloatArrayToStatement, adventureworks.arrayParameterMetaData(ParameterMetaData.FloatParameterMetaData)))}::_float4, ${ParameterValue(unsaved.float8es, null, ToStatement.optionToStatement(adventureworks.DoubleArrayToStatement, adventureworks.arrayParameterMetaData(ParameterMetaData.DoubleParameterMetaData)))}::_float8, ${ParameterValue(unsaved.inetes, null, ToStatement.optionToStatement(TypoInet.arrayToStatement, adventureworks.arrayParameterMetaData(TypoInet.parameterMetadata)))}::_inet, ${ParameterValue(unsaved.int2es, null, ToStatement.optionToStatement(TypoShort.arrayToStatement, adventureworks.arrayParameterMetaData(TypoShort.parameterMetadata)))}::_int2, ${ParameterValue(unsaved.int2vectores, null, ToStatement.optionToStatement(TypoInt2Vector.arrayToStatement, adventureworks.arrayParameterMetaData(TypoInt2Vector.parameterMetadata)))}::_int2vector, ${ParameterValue(unsaved.int4es, null, ToStatement.optionToStatement(adventureworks.IntArrayToStatement, adventureworks.arrayParameterMetaData(ParameterMetaData.IntParameterMetaData)))}::_int4, ${ParameterValue(unsaved.int8es, null, ToStatement.optionToStatement(adventureworks.LongArrayToStatement, adventureworks.arrayParameterMetaData(ParameterMetaData.LongParameterMetaData)))}::_int8, ${ParameterValue(unsaved.intervales, null, ToStatement.optionToStatement(TypoInterval.arrayToStatement, adventureworks.arrayParameterMetaData(TypoInterval.parameterMetadata)))}::_interval, ${ParameterValue(unsaved.jsones, null, ToStatement.optionToStatement(TypoJson.arrayToStatement, adventureworks.arrayParameterMetaData(TypoJson.parameterMetadata)))}::_json, ${ParameterValue(unsaved.jsonbes, null, ToStatement.optionToStatement(TypoJsonb.arrayToStatement, adventureworks.arrayParameterMetaData(TypoJsonb.parameterMetadata)))}::_jsonb, ${ParameterValue(unsaved.linees, null, ToStatement.optionToStatement(TypoLine.arrayToStatement, adventureworks.arrayParameterMetaData(TypoLine.parameterMetadata)))}::_line, ${ParameterValue(unsaved.lseges, null, ToStatement.optionToStatement(TypoLineSegment.arrayToStatement, adventureworks.arrayParameterMetaData(TypoLineSegment.parameterMetadata)))}::_lseg, ${ParameterValue(unsaved.moneyes, null, ToStatement.optionToStatement(TypoMoney.arrayToStatement, adventureworks.arrayParameterMetaData(TypoMoney.parameterMetadata)))}::_money, ${ParameterValue(unsaved.myenumes, null, ToStatement.optionToStatement(Myenum.arrayToStatement, adventureworks.arrayParameterMetaData(Myenum.parameterMetadata)))}::_myenum, ${ParameterValue(unsaved.namees, null, ToStatement.optionToStatement(ToStatement.arrayToParameter(ParameterMetaData.StringParameterMetaData), adventureworks.arrayParameterMetaData(ParameterMetaData.StringParameterMetaData)))}::_name, ${ParameterValue(unsaved.numerices, null, ToStatement.optionToStatement(adventureworks.BigDecimalArrayToStatement, adventureworks.arrayParameterMetaData(ParameterMetaData.BigDecimalParameterMetaData)))}::_numeric, ${ParameterValue(unsaved.pathes, null, ToStatement.optionToStatement(TypoPath.arrayToStatement, adventureworks.arrayParameterMetaData(TypoPath.parameterMetadata)))}::_path, ${ParameterValue(unsaved.pointes, null, ToStatement.optionToStatement(TypoPoint.arrayToStatement, adventureworks.arrayParameterMetaData(TypoPoint.parameterMetadata)))}::_point, ${ParameterValue(unsaved.polygones, null, ToStatement.optionToStatement(TypoPolygon.arrayToStatement, adventureworks.arrayParameterMetaData(TypoPolygon.parameterMetadata)))}::_polygon, ${ParameterValue(unsaved.textes, null, ToStatement.optionToStatement(ToStatement.arrayToParameter(ParameterMetaData.StringParameterMetaData), adventureworks.arrayParameterMetaData(ParameterMetaData.StringParameterMetaData)))}::_text, ${ParameterValue(unsaved.timees, null, ToStatement.optionToStatement(TypoLocalTime.arrayToStatement, adventureworks.arrayParameterMetaData(TypoLocalTime.parameterMetadata)))}::_time, ${ParameterValue(unsaved.timestampes, null, ToStatement.optionToStatement(TypoLocalDateTime.arrayToStatement, adventureworks.arrayParameterMetaData(TypoLocalDateTime.parameterMetadata)))}::_timestamp, ${ParameterValue(unsaved.timestampzes, null, ToStatement.optionToStatement(TypoInstant.arrayToStatement, adventureworks.arrayParameterMetaData(TypoInstant.parameterMetadata)))}::_timestamptz, ${ParameterValue(unsaved.timezes, null, ToStatement.optionToStatement(TypoOffsetTime.arrayToStatement, adventureworks.arrayParameterMetaData(TypoOffsetTime.parameterMetadata)))}::_timetz, ${ParameterValue(unsaved.uuides, null, ToStatement.optionToStatement(TypoUUID.arrayToStatement, adventureworks.arrayParameterMetaData(TypoUUID.parameterMetadata)))}::_uuid, ${ParameterValue(unsaved.varchares, null, ToStatement.optionToStatement(ToStatement.arrayToParameter(ParameterMetaData.StringParameterMetaData), adventureworks.arrayParameterMetaData(ParameterMetaData.StringParameterMetaData)))}::_varchar, ${ParameterValue(unsaved.xmles, null, ToStatement.optionToStatement(TypoXml.arrayToStatement, adventureworks.arrayParameterMetaData(TypoXml.parameterMetadata)))}::_xml)
          returning "bool", "box", "bpchar", "bytea", "char", "circle", "date"::text, "float4", "float8", "hstore", "inet", "int2", "int2vector", "int4", "int8", "interval", "json", "jsonb", "line", "lseg", "money"::numeric, "mydomain", "myenum", "name", "numeric", "path", "point", "polygon", "text", "time"::text, "timestamp"::text, "timestampz"::text, "timez"::text, "uuid", "varchar", "vector"::float4[], "xml", "boxes", "bpchares", "chares", "circlees", "datees"::text[], "float4es", "float8es", "inetes", "int2es", "int2vectores", "int4es", "int8es", "intervales", "jsones", "jsonbes", "linees", "lseges", "moneyes"::numeric[], "myenumes", "namees", "numerices", "pathes", "pointes", "polygones", "textes", "timees"::text[], "timestampes"::text[], "timestampzes"::text[], "timezes"::text[], "uuides", "varchares", "xmles"
       """
      .executeInsert(PgtestnullRow.rowParser(1).single)
    
  }
  override def insertStreaming(unsaved: Iterator[PgtestnullRow], batchSize: Int)(implicit c: Connection): Long = {
    streamingInsert(s"""COPY public.pgtestnull("bool", "box", "bpchar", "bytea", "char", "circle", "date", "float4", "float8", "hstore", "inet", "int2", "int2vector", "int4", "int8", "interval", "json", "jsonb", "line", "lseg", "money", "mydomain", "myenum", "name", "numeric", "path", "point", "polygon", "text", "time", "timestamp", "timestampz", "timez", "uuid", "varchar", "vector", "xml", "boxes", "bpchares", "chares", "circlees", "datees", "float4es", "float8es", "inetes", "int2es", "int2vectores", "int4es", "int8es", "intervales", "jsones", "jsonbes", "linees", "lseges", "moneyes", "myenumes", "namees", "numerices", "pathes", "pointes", "polygones", "textes", "timees", "timestampes", "timestampzes", "timezes", "uuides", "varchares", "xmles") FROM STDIN""", batchSize, unsaved)(PgtestnullRow.text, c)
  }
  override def select: SelectBuilder[PgtestnullFields, PgtestnullRow] = {
    SelectBuilderSql("public.pgtestnull", PgtestnullFields.structure, PgtestnullRow.rowParser)
  }
  override def selectAll(implicit c: Connection): List[PgtestnullRow] = {
    SQL"""select "bool", "box", "bpchar", "bytea", "char", "circle", "date"::text, "float4", "float8", "hstore", "inet", "int2", "int2vector", "int4", "int8", "interval", "json", "jsonb", "line", "lseg", "money"::numeric, "mydomain", "myenum", "name", "numeric", "path", "point", "polygon", "text", "time"::text, "timestamp"::text, "timestampz"::text, "timez"::text, "uuid", "varchar", "vector"::float4[], "xml", "boxes", "bpchares", "chares", "circlees", "datees"::text[], "float4es", "float8es", "inetes", "int2es", "int2vectores", "int4es", "int8es", "intervales", "jsones", "jsonbes", "linees", "lseges", "moneyes"::numeric[], "myenumes", "namees", "numerices", "pathes", "pointes", "polygones", "textes", "timees"::text[], "timestampes"::text[], "timestampzes"::text[], "timezes"::text[], "uuides", "varchares", "xmles"
          from public.pgtestnull
       """.as(PgtestnullRow.rowParser(1).*)
  }
  override def update: UpdateBuilder[PgtestnullFields, PgtestnullRow] = {
    UpdateBuilder("public.pgtestnull", PgtestnullFields.structure, PgtestnullRow.rowParser)
  }
}
