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
import doobie.free.connection.ConnectionIO
import doobie.postgres.syntax.FragmentOps
import doobie.syntax.SqlInterpolator.SingleFragment.fromWrite
import doobie.syntax.string.toSqlInterpolator
import doobie.util.Write
import doobie.util.meta.Meta
import fs2.Stream
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql
import typo.dsl.UpdateBuilder

class PgtestRepoImpl extends PgtestRepo {
  override def delete: DeleteBuilder[PgtestFields, PgtestRow] = {
    DeleteBuilder("public.pgtest", PgtestFields.structure)
  }
  override def insert(unsaved: PgtestRow): ConnectionIO[PgtestRow] = {
    sql"""insert into public.pgtest("bool", "box", "bpchar", "bytea", "char", "circle", "date", "float4", "float8", "hstore", "inet", "int2", "int2vector", "int4", "int8", "interval", "json", "jsonb", "line", "lseg", "money", "mydomain", "myenum", "name", "numeric", "path", "point", "polygon", "text", "time", "timestamp", "timestampz", "timez", "uuid", "varchar", "vector", "xml", "boxes", "bpchares", "chares", "circlees", "datees", "float4es", "float8es", "inetes", "int2es", "int2vectores", "int4es", "int8es", "intervales", "jsones", "jsonbes", "linees", "lseges", "moneyes", "mydomaines", "myenumes", "namees", "numerices", "pathes", "pointes", "polygones", "textes", "timees", "timestampes", "timestampzes", "timezes", "uuides", "varchares", "xmles")
          values (${fromWrite(unsaved.bool)(Write.fromPut(Meta.BooleanMeta.put))}, ${fromWrite(unsaved.box)(Write.fromPut(TypoBox.put))}::box, ${fromWrite(unsaved.bpchar)(Write.fromPut(Meta.StringMeta.put))}::bpchar, ${fromWrite(unsaved.bytea)(Write.fromPut(TypoBytea.put))}::bytea, ${fromWrite(unsaved.char)(Write.fromPut(Meta.StringMeta.put))}::bpchar, ${fromWrite(unsaved.circle)(Write.fromPut(TypoCircle.put))}::circle, ${fromWrite(unsaved.date)(Write.fromPut(TypoLocalDate.put))}::date, ${fromWrite(unsaved.float4)(Write.fromPut(Meta.FloatMeta.put))}::float4, ${fromWrite(unsaved.float8)(Write.fromPut(Meta.DoubleMeta.put))}::float8, ${fromWrite(unsaved.hstore)(Write.fromPut(TypoHStore.put))}::hstore, ${fromWrite(unsaved.inet)(Write.fromPut(TypoInet.put))}::inet, ${fromWrite(unsaved.int2)(Write.fromPut(TypoShort.put))}::int2, ${fromWrite(unsaved.int2vector)(Write.fromPut(TypoInt2Vector.put))}::int2vector, ${fromWrite(unsaved.int4)(Write.fromPut(Meta.IntMeta.put))}::int4, ${fromWrite(unsaved.int8)(Write.fromPut(Meta.LongMeta.put))}::int8, ${fromWrite(unsaved.interval)(Write.fromPut(TypoInterval.put))}::interval, ${fromWrite(unsaved.json)(Write.fromPut(TypoJson.put))}::json, ${fromWrite(unsaved.jsonb)(Write.fromPut(TypoJsonb.put))}::jsonb, ${fromWrite(unsaved.line)(Write.fromPut(TypoLine.put))}::line, ${fromWrite(unsaved.lseg)(Write.fromPut(TypoLineSegment.put))}::lseg, ${fromWrite(unsaved.money)(Write.fromPut(TypoMoney.put))}::money, ${fromWrite(unsaved.mydomain)(Write.fromPut(Mydomain.put))}::text, ${fromWrite(unsaved.myenum)(Write.fromPut(Myenum.put))}::public.myenum, ${fromWrite(unsaved.name)(Write.fromPut(Meta.StringMeta.put))}::name, ${fromWrite(unsaved.numeric)(Write.fromPut(Meta.ScalaBigDecimalMeta.put))}::numeric, ${fromWrite(unsaved.path)(Write.fromPut(TypoPath.put))}::path, ${fromWrite(unsaved.point)(Write.fromPut(TypoPoint.put))}::point, ${fromWrite(unsaved.polygon)(Write.fromPut(TypoPolygon.put))}::polygon, ${fromWrite(unsaved.text)(Write.fromPut(Meta.StringMeta.put))}, ${fromWrite(unsaved.time)(Write.fromPut(TypoLocalTime.put))}::time, ${fromWrite(unsaved.timestamp)(Write.fromPut(TypoLocalDateTime.put))}::timestamp, ${fromWrite(unsaved.timestampz)(Write.fromPut(TypoInstant.put))}::timestamptz, ${fromWrite(unsaved.timez)(Write.fromPut(TypoOffsetTime.put))}::timetz, ${fromWrite(unsaved.uuid)(Write.fromPut(TypoUUID.put))}::uuid, ${fromWrite(unsaved.varchar)(Write.fromPut(Meta.StringMeta.put))}, ${fromWrite(unsaved.vector)(Write.fromPut(TypoVector.put))}::vector, ${fromWrite(unsaved.xml)(Write.fromPut(TypoXml.put))}::xml, ${fromWrite(unsaved.boxes)(Write.fromPut(TypoBox.arrayPut))}::box[], ${fromWrite(unsaved.bpchares)(Write.fromPut(adventureworks.StringArrayMeta.put))}::bpchar[], ${fromWrite(unsaved.chares)(Write.fromPut(adventureworks.StringArrayMeta.put))}::bpchar[], ${fromWrite(unsaved.circlees)(Write.fromPut(TypoCircle.arrayPut))}::circle[], ${fromWrite(unsaved.datees)(Write.fromPut(TypoLocalDate.arrayPut))}::date[], ${fromWrite(unsaved.float4es)(Write.fromPut(adventureworks.FloatArrayMeta.put))}::float4[], ${fromWrite(unsaved.float8es)(Write.fromPut(adventureworks.DoubleArrayMeta.put))}::float8[], ${fromWrite(unsaved.inetes)(Write.fromPut(TypoInet.arrayPut))}::inet[], ${fromWrite(unsaved.int2es)(Write.fromPut(TypoShort.arrayPut))}::int2[], ${fromWrite(unsaved.int2vectores)(Write.fromPut(TypoInt2Vector.arrayPut))}::int2vector[], ${fromWrite(unsaved.int4es)(Write.fromPut(adventureworks.IntegerArrayMeta.put))}::int4[], ${fromWrite(unsaved.int8es)(Write.fromPut(adventureworks.LongArrayMeta.put))}::int8[], ${fromWrite(unsaved.intervales)(Write.fromPut(TypoInterval.arrayPut))}::interval[], ${fromWrite(unsaved.jsones)(Write.fromPut(TypoJson.arrayPut))}::json[], ${fromWrite(unsaved.jsonbes)(Write.fromPut(TypoJsonb.arrayPut))}::jsonb[], ${fromWrite(unsaved.linees)(Write.fromPut(TypoLine.arrayPut))}::line[], ${fromWrite(unsaved.lseges)(Write.fromPut(TypoLineSegment.arrayPut))}::lseg[], ${fromWrite(unsaved.moneyes)(Write.fromPut(TypoMoney.arrayPut))}::money[], ${fromWrite(unsaved.mydomaines)(Write.fromPut(Mydomain.arrayPut))}::mydomain[], ${fromWrite(unsaved.myenumes)(Write.fromPut(Myenum.arrayPut))}::myenum[], ${fromWrite(unsaved.namees)(Write.fromPut(adventureworks.StringArrayMeta.put))}::name[], ${fromWrite(unsaved.numerices)(Write.fromPut(adventureworks.BigDecimalMeta.put))}::numeric[], ${fromWrite(unsaved.pathes)(Write.fromPut(TypoPath.arrayPut))}::path[], ${fromWrite(unsaved.pointes)(Write.fromPut(TypoPoint.arrayPut))}::point[], ${fromWrite(unsaved.polygones)(Write.fromPut(TypoPolygon.arrayPut))}::polygon[], ${fromWrite(unsaved.textes)(Write.fromPut(adventureworks.StringArrayMeta.put))}::text[], ${fromWrite(unsaved.timees)(Write.fromPut(TypoLocalTime.arrayPut))}::time[], ${fromWrite(unsaved.timestampes)(Write.fromPut(TypoLocalDateTime.arrayPut))}::timestamp[], ${fromWrite(unsaved.timestampzes)(Write.fromPut(TypoInstant.arrayPut))}::timestamptz[], ${fromWrite(unsaved.timezes)(Write.fromPut(TypoOffsetTime.arrayPut))}::timetz[], ${fromWrite(unsaved.uuides)(Write.fromPut(TypoUUID.arrayPut))}::uuid[], ${fromWrite(unsaved.varchares)(Write.fromPut(adventureworks.StringArrayMeta.put))}::varchar[], ${fromWrite(unsaved.xmles)(Write.fromPut(TypoXml.arrayPut))}::xml[])
          returning "bool", "box", "bpchar", "bytea", "char", "circle", "date"::text, "float4", "float8", "hstore", "inet", "int2", "int2vector", "int4", "int8", "interval", "json", "jsonb", "line", "lseg", "money"::numeric, "mydomain", "myenum", "name", "numeric", "path", "point", "polygon", "text", "time"::text, "timestamp"::text, "timestampz"::text, "timez"::text, "uuid", "varchar", "vector"::float4[], "xml", "boxes", "bpchares", "chares", "circlees", "datees"::text[], "float4es", "float8es", "inetes", "int2es", "int2vectores", "int4es", "int8es", "intervales", "jsones", "jsonbes", "linees", "lseges", "moneyes"::numeric[], "mydomaines"::text[], "myenumes", "namees", "numerices", "pathes", "pointes", "polygones", "textes", "timees"::text[], "timestampes"::text[], "timestampzes"::text[], "timezes"::text[], "uuides", "varchares", "xmles"
       """.query(using PgtestRow.read).unique
  }
  override def insertStreaming(unsaved: Stream[ConnectionIO, PgtestRow], batchSize: Int = 10000): ConnectionIO[Long] = {
    new FragmentOps(sql"""COPY public.pgtest("bool", "box", "bpchar", "bytea", "char", "circle", "date", "float4", "float8", "hstore", "inet", "int2", "int2vector", "int4", "int8", "interval", "json", "jsonb", "line", "lseg", "money", "mydomain", "myenum", "name", "numeric", "path", "point", "polygon", "text", "time", "timestamp", "timestampz", "timez", "uuid", "varchar", "vector", "xml", "boxes", "bpchares", "chares", "circlees", "datees", "float4es", "float8es", "inetes", "int2es", "int2vectores", "int4es", "int8es", "intervales", "jsones", "jsonbes", "linees", "lseges", "moneyes", "mydomaines", "myenumes", "namees", "numerices", "pathes", "pointes", "polygones", "textes", "timees", "timestampes", "timestampzes", "timezes", "uuides", "varchares", "xmles") FROM STDIN""").copyIn(unsaved, batchSize)(using PgtestRow.text)
  }
  override def select: SelectBuilder[PgtestFields, PgtestRow] = {
    SelectBuilderSql("public.pgtest", PgtestFields.structure, PgtestRow.read)
  }
  override def selectAll: Stream[ConnectionIO, PgtestRow] = {
    sql"""select "bool", "box", "bpchar", "bytea", "char", "circle", "date"::text, "float4", "float8", "hstore", "inet", "int2", "int2vector", "int4", "int8", "interval", "json", "jsonb", "line", "lseg", "money"::numeric, "mydomain", "myenum", "name", "numeric", "path", "point", "polygon", "text", "time"::text, "timestamp"::text, "timestampz"::text, "timez"::text, "uuid", "varchar", "vector"::float4[], "xml", "boxes", "bpchares", "chares", "circlees", "datees"::text[], "float4es", "float8es", "inetes", "int2es", "int2vectores", "int4es", "int8es", "intervales", "jsones", "jsonbes", "linees", "lseges", "moneyes"::numeric[], "mydomaines"::text[], "myenumes", "namees", "numerices", "pathes", "pointes", "polygones", "textes", "timees"::text[], "timestampes"::text[], "timestampzes"::text[], "timezes"::text[], "uuides", "varchares", "xmles" from public.pgtest""".query(using PgtestRow.read).stream
  }
  override def update: UpdateBuilder[PgtestFields, PgtestRow] = {
    UpdateBuilder("public.pgtest", PgtestFields.structure, PgtestRow.read)
  }
}
