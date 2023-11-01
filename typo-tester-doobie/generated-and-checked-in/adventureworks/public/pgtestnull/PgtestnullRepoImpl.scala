/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package public
package pgtestnull

import adventureworks.customtypes.TypoBox
import adventureworks.customtypes.TypoCircle
import adventureworks.customtypes.TypoHStore
import adventureworks.customtypes.TypoInet
import adventureworks.customtypes.TypoInstant
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
import adventureworks.customtypes.TypoUUID
import adventureworks.customtypes.TypoVector
import adventureworks.customtypes.TypoXml
import doobie.free.connection.ConnectionIO
import doobie.syntax.SqlInterpolator.SingleFragment.fromWrite
import doobie.syntax.string.toSqlInterpolator
import doobie.util.Write
import doobie.util.meta.Meta
import fs2.Stream
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql
import typo.dsl.UpdateBuilder

object PgtestnullRepoImpl extends PgtestnullRepo {
  override def delete: DeleteBuilder[PgtestnullFields, PgtestnullRow] = {
    DeleteBuilder("public.pgtestnull", PgtestnullFields)
  }
  override def insert(unsaved: PgtestnullRow): ConnectionIO[PgtestnullRow] = {
    sql"""insert into public.pgtestnull("box", "circle", "line", "lseg", "path", "point", "polygon", "interval", "money", "xml", "json", "jsonb", "hstore", "inet", "timestamp", "timestampz", "time", "timez", "date", "uuid", "numeric", "vector", "boxes", "circlees", "linees", "lseges", "pathes", "pointes", "polygones", "intervales", "moneyes", "xmles", "jsones", "jsonbes", "inets", "timestamps", "timestampzs", "times", "timezs", "dates", "uuids", "numerics")
          values (${fromWrite(unsaved.box)(Write.fromPutOption(TypoBox.put))}::box, ${fromWrite(unsaved.circle)(Write.fromPutOption(TypoCircle.put))}::circle, ${fromWrite(unsaved.line)(Write.fromPutOption(TypoLine.put))}::line, ${fromWrite(unsaved.lseg)(Write.fromPutOption(TypoLineSegment.put))}::lseg, ${fromWrite(unsaved.path)(Write.fromPutOption(TypoPath.put))}::path, ${fromWrite(unsaved.point)(Write.fromPutOption(TypoPoint.put))}::point, ${fromWrite(unsaved.polygon)(Write.fromPutOption(TypoPolygon.put))}::polygon, ${fromWrite(unsaved.interval)(Write.fromPutOption(TypoInterval.put))}::interval, ${fromWrite(unsaved.money)(Write.fromPutOption(TypoMoney.put))}::money, ${fromWrite(unsaved.xml)(Write.fromPutOption(TypoXml.put))}::xml, ${fromWrite(unsaved.json)(Write.fromPutOption(TypoJson.put))}::json, ${fromWrite(unsaved.jsonb)(Write.fromPutOption(TypoJsonb.put))}::jsonb, ${fromWrite(unsaved.hstore)(Write.fromPutOption(TypoHStore.put))}::hstore, ${fromWrite(unsaved.inet)(Write.fromPutOption(TypoInet.put))}::inet, ${fromWrite(unsaved.timestamp)(Write.fromPutOption(TypoLocalDateTime.put))}::timestamp, ${fromWrite(unsaved.timestampz)(Write.fromPutOption(TypoInstant.put))}::timestamptz, ${fromWrite(unsaved.time)(Write.fromPutOption(TypoLocalTime.put))}::time, ${fromWrite(unsaved.timez)(Write.fromPutOption(TypoOffsetTime.put))}::timetz, ${fromWrite(unsaved.date)(Write.fromPutOption(TypoLocalDate.put))}::date, ${fromWrite(unsaved.uuid)(Write.fromPutOption(TypoUUID.put))}::uuid, ${fromWrite(unsaved.numeric)(Write.fromPutOption(Meta.ScalaBigDecimalMeta.put))}::numeric, ${fromWrite(unsaved.vector)(Write.fromPutOption(TypoVector.put))}::vector, ${fromWrite(unsaved.boxes)(Write.fromPutOption(TypoBox.arrayPut))}::_box, ${fromWrite(unsaved.circlees)(Write.fromPutOption(TypoCircle.arrayPut))}::_circle, ${fromWrite(unsaved.linees)(Write.fromPutOption(TypoLine.arrayPut))}::_line, ${fromWrite(unsaved.lseges)(Write.fromPutOption(TypoLineSegment.arrayPut))}::_lseg, ${fromWrite(unsaved.pathes)(Write.fromPutOption(TypoPath.arrayPut))}::_path, ${fromWrite(unsaved.pointes)(Write.fromPutOption(TypoPoint.arrayPut))}::_point, ${fromWrite(unsaved.polygones)(Write.fromPutOption(TypoPolygon.arrayPut))}::_polygon, ${fromWrite(unsaved.intervales)(Write.fromPutOption(TypoInterval.arrayPut))}::_interval, ${fromWrite(unsaved.moneyes)(Write.fromPutOption(TypoMoney.arrayPut))}::_money, ${fromWrite(unsaved.xmles)(Write.fromPutOption(TypoXml.arrayPut))}::_xml, ${fromWrite(unsaved.jsones)(Write.fromPutOption(TypoJson.arrayPut))}::_json, ${fromWrite(unsaved.jsonbes)(Write.fromPutOption(TypoJsonb.arrayPut))}::_jsonb, ${fromWrite(unsaved.inets)(Write.fromPutOption(TypoInet.arrayPut))}::_inet, ${fromWrite(unsaved.timestamps)(Write.fromPutOption(TypoLocalDateTime.arrayPut))}::_timestamp, ${fromWrite(unsaved.timestampzs)(Write.fromPutOption(TypoInstant.arrayPut))}::_timestamptz, ${fromWrite(unsaved.times)(Write.fromPutOption(TypoLocalTime.arrayPut))}::_time, ${fromWrite(unsaved.timezs)(Write.fromPutOption(TypoOffsetTime.arrayPut))}::_timetz, ${fromWrite(unsaved.dates)(Write.fromPutOption(TypoLocalDate.arrayPut))}::_date, ${fromWrite(unsaved.uuids)(Write.fromPutOption(TypoUUID.arrayPut))}::_uuid, ${fromWrite(unsaved.numerics)(Write.fromPutOption(adventureworks.BigDecimalMeta.put))}::_numeric)
          returning "box", "circle", "line", "lseg", "path", "point", "polygon", "interval", "money"::numeric, "xml", "json", "jsonb", "hstore", "inet", "timestamp"::text, "timestampz"::text, "time"::text, "timez"::text, "date"::text, "uuid", "numeric", "vector"::float4[], "boxes", "circlees", "linees", "lseges", "pathes", "pointes", "polygones", "intervales", "moneyes"::numeric[], "xmles", "jsones", "jsonbes", "inets", "timestamps"::text[], "timestampzs"::text[], "times"::text[], "timezs"::text[], "dates"::text[], "uuids", "numerics"
       """.query(PgtestnullRow.read).unique
  }
  override def select: SelectBuilder[PgtestnullFields, PgtestnullRow] = {
    SelectBuilderSql("public.pgtestnull", PgtestnullFields, PgtestnullRow.read)
  }
  override def selectAll: Stream[ConnectionIO, PgtestnullRow] = {
    sql"""select "box", "circle", "line", "lseg", "path", "point", "polygon", "interval", "money"::numeric, "xml", "json", "jsonb", "hstore", "inet", "timestamp"::text, "timestampz"::text, "time"::text, "timez"::text, "date"::text, "uuid", "numeric", "vector"::float4[], "boxes", "circlees", "linees", "lseges", "pathes", "pointes", "polygones", "intervales", "moneyes"::numeric[], "xmles", "jsones", "jsonbes", "inets", "timestamps"::text[], "timestampzs"::text[], "times"::text[], "timezs"::text[], "dates"::text[], "uuids", "numerics" from public.pgtestnull""".query(PgtestnullRow.read).stream
  }
  override def update: UpdateBuilder[PgtestnullFields, PgtestnullRow] = {
    UpdateBuilder("public.pgtestnull", PgtestnullFields, PgtestnullRow.read)
  }
}
