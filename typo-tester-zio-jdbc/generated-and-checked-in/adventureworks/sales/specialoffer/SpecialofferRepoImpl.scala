/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package specialoffer

import adventureworks.customtypes.Defaulted
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoUUID
import adventureworks.streamingInsert
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql
import typo.dsl.UpdateBuilder
import zio.ZIO
import zio.jdbc.SqlFragment
import zio.jdbc.SqlFragment.Segment
import zio.jdbc.SqlFragment.Setter
import zio.jdbc.UpdateResult
import zio.jdbc.ZConnection
import zio.jdbc.sqlInterpolator
import zio.stream.ZStream

class SpecialofferRepoImpl extends SpecialofferRepo {
  override def delete(specialofferid: SpecialofferId): ZIO[ZConnection, Throwable, Boolean] = {
    sql"""delete from sales.specialoffer where "specialofferid" = ${Segment.paramSegment(specialofferid)(SpecialofferId.setter)}""".delete.map(_ > 0)
  }
  override def delete: DeleteBuilder[SpecialofferFields, SpecialofferRow] = {
    DeleteBuilder("sales.specialoffer", SpecialofferFields.structure)
  }
  override def insert(unsaved: SpecialofferRow): ZIO[ZConnection, Throwable, SpecialofferRow] = {
    sql"""insert into sales.specialoffer("specialofferid", "description", "discountpct", "type", "category", "startdate", "enddate", "minqty", "maxqty", "rowguid", "modifieddate")
          values (${Segment.paramSegment(unsaved.specialofferid)(SpecialofferId.setter)}::int4, ${Segment.paramSegment(unsaved.description)(Setter.stringSetter)}, ${Segment.paramSegment(unsaved.discountpct)(Setter.bigDecimalScalaSetter)}::numeric, ${Segment.paramSegment(unsaved.`type`)(Setter.stringSetter)}, ${Segment.paramSegment(unsaved.category)(Setter.stringSetter)}, ${Segment.paramSegment(unsaved.startdate)(TypoLocalDateTime.setter)}::timestamp, ${Segment.paramSegment(unsaved.enddate)(TypoLocalDateTime.setter)}::timestamp, ${Segment.paramSegment(unsaved.minqty)(Setter.intSetter)}::int4, ${Segment.paramSegment(unsaved.maxqty)(Setter.optionParamSetter(Setter.intSetter))}::int4, ${Segment.paramSegment(unsaved.rowguid)(TypoUUID.setter)}::uuid, ${Segment.paramSegment(unsaved.modifieddate)(TypoLocalDateTime.setter)}::timestamp)
          returning "specialofferid", "description", "discountpct", "type", "category", "startdate"::text, "enddate"::text, "minqty", "maxqty", "rowguid", "modifieddate"::text
       """.insertReturning(SpecialofferRow.jdbcDecoder).map(_.updatedKeys.head)
  }
  override def insertStreaming(unsaved: ZStream[ZConnection, Throwable, SpecialofferRow], batchSize: Int): ZIO[ZConnection, Throwable, Long] = {
    streamingInsert(s"""COPY sales.specialoffer("specialofferid", "description", "discountpct", "type", "category", "startdate", "enddate", "minqty", "maxqty", "rowguid", "modifieddate") FROM STDIN""", batchSize, unsaved)(SpecialofferRow.text)
  }
  override def insert(unsaved: SpecialofferRowUnsaved): ZIO[ZConnection, Throwable, SpecialofferRow] = {
    val fs = List(
      Some((sql""""description"""", sql"${Segment.paramSegment(unsaved.description)(Setter.stringSetter)}")),
      Some((sql""""type"""", sql"${Segment.paramSegment(unsaved.`type`)(Setter.stringSetter)}")),
      Some((sql""""category"""", sql"${Segment.paramSegment(unsaved.category)(Setter.stringSetter)}")),
      Some((sql""""startdate"""", sql"${Segment.paramSegment(unsaved.startdate)(TypoLocalDateTime.setter)}::timestamp")),
      Some((sql""""enddate"""", sql"${Segment.paramSegment(unsaved.enddate)(TypoLocalDateTime.setter)}::timestamp")),
      Some((sql""""maxqty"""", sql"${Segment.paramSegment(unsaved.maxqty)(Setter.optionParamSetter(Setter.intSetter))}::int4")),
      unsaved.specialofferid match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((sql""""specialofferid"""", sql"${Segment.paramSegment(value: SpecialofferId)(SpecialofferId.setter)}::int4"))
      },
      unsaved.discountpct match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((sql""""discountpct"""", sql"${Segment.paramSegment(value: BigDecimal)(Setter.bigDecimalScalaSetter)}::numeric"))
      },
      unsaved.minqty match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((sql""""minqty"""", sql"${Segment.paramSegment(value: Int)(Setter.intSetter)}::int4"))
      },
      unsaved.rowguid match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((sql""""rowguid"""", sql"${Segment.paramSegment(value: TypoUUID)(TypoUUID.setter)}::uuid"))
      },
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((sql""""modifieddate"""", sql"${Segment.paramSegment(value: TypoLocalDateTime)(TypoLocalDateTime.setter)}::timestamp"))
      }
    ).flatten
    
    val q = if (fs.isEmpty) {
      sql"""insert into sales.specialoffer default values
            returning "specialofferid", "description", "discountpct", "type", "category", "startdate"::text, "enddate"::text, "minqty", "maxqty", "rowguid", "modifieddate"::text
         """
    } else {
      val names  = fs.map { case (n, _) => n }.mkFragment(SqlFragment(", "))
      val values = fs.map { case (_, f) => f }.mkFragment(SqlFragment(", "))
      sql"""insert into sales.specialoffer($names) values ($values) returning "specialofferid", "description", "discountpct", "type", "category", "startdate"::text, "enddate"::text, "minqty", "maxqty", "rowguid", "modifieddate"::text"""
    }
    q.insertReturning(SpecialofferRow.jdbcDecoder).map(_.updatedKeys.head)
    
  }
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  override def insertUnsavedStreaming(unsaved: ZStream[ZConnection, Throwable, SpecialofferRowUnsaved], batchSize: Int): ZIO[ZConnection, Throwable, Long] = {
    streamingInsert(s"""COPY sales.specialoffer("description", "type", "category", "startdate", "enddate", "maxqty", "specialofferid", "discountpct", "minqty", "rowguid", "modifieddate") FROM STDIN (DEFAULT '__DEFAULT_VALUE__')""", batchSize, unsaved)(SpecialofferRowUnsaved.text)
  }
  override def select: SelectBuilder[SpecialofferFields, SpecialofferRow] = {
    SelectBuilderSql("sales.specialoffer", SpecialofferFields.structure, SpecialofferRow.jdbcDecoder)
  }
  override def selectAll: ZStream[ZConnection, Throwable, SpecialofferRow] = {
    sql"""select "specialofferid", "description", "discountpct", "type", "category", "startdate"::text, "enddate"::text, "minqty", "maxqty", "rowguid", "modifieddate"::text from sales.specialoffer""".query(SpecialofferRow.jdbcDecoder).selectStream
  }
  override def selectById(specialofferid: SpecialofferId): ZIO[ZConnection, Throwable, Option[SpecialofferRow]] = {
    sql"""select "specialofferid", "description", "discountpct", "type", "category", "startdate"::text, "enddate"::text, "minqty", "maxqty", "rowguid", "modifieddate"::text from sales.specialoffer where "specialofferid" = ${Segment.paramSegment(specialofferid)(SpecialofferId.setter)}""".query(SpecialofferRow.jdbcDecoder).selectOne
  }
  override def selectByIds(specialofferids: Array[SpecialofferId]): ZStream[ZConnection, Throwable, SpecialofferRow] = {
    sql"""select "specialofferid", "description", "discountpct", "type", "category", "startdate"::text, "enddate"::text, "minqty", "maxqty", "rowguid", "modifieddate"::text from sales.specialoffer where "specialofferid" = ANY(${Segment.paramSegment(specialofferids)(SpecialofferId.arraySetter)})""".query(SpecialofferRow.jdbcDecoder).selectStream
  }
  override def update(row: SpecialofferRow): ZIO[ZConnection, Throwable, Boolean] = {
    val specialofferid = row.specialofferid
    sql"""update sales.specialoffer
          set "description" = ${Segment.paramSegment(row.description)(Setter.stringSetter)},
              "discountpct" = ${Segment.paramSegment(row.discountpct)(Setter.bigDecimalScalaSetter)}::numeric,
              "type" = ${Segment.paramSegment(row.`type`)(Setter.stringSetter)},
              "category" = ${Segment.paramSegment(row.category)(Setter.stringSetter)},
              "startdate" = ${Segment.paramSegment(row.startdate)(TypoLocalDateTime.setter)}::timestamp,
              "enddate" = ${Segment.paramSegment(row.enddate)(TypoLocalDateTime.setter)}::timestamp,
              "minqty" = ${Segment.paramSegment(row.minqty)(Setter.intSetter)}::int4,
              "maxqty" = ${Segment.paramSegment(row.maxqty)(Setter.optionParamSetter(Setter.intSetter))}::int4,
              "rowguid" = ${Segment.paramSegment(row.rowguid)(TypoUUID.setter)}::uuid,
              "modifieddate" = ${Segment.paramSegment(row.modifieddate)(TypoLocalDateTime.setter)}::timestamp
          where "specialofferid" = ${Segment.paramSegment(specialofferid)(SpecialofferId.setter)}""".update.map(_ > 0)
  }
  override def update: UpdateBuilder[SpecialofferFields, SpecialofferRow] = {
    UpdateBuilder("sales.specialoffer", SpecialofferFields.structure, SpecialofferRow.jdbcDecoder)
  }
  override def upsert(unsaved: SpecialofferRow): ZIO[ZConnection, Throwable, UpdateResult[SpecialofferRow]] = {
    sql"""insert into sales.specialoffer("specialofferid", "description", "discountpct", "type", "category", "startdate", "enddate", "minqty", "maxqty", "rowguid", "modifieddate")
          values (
            ${Segment.paramSegment(unsaved.specialofferid)(SpecialofferId.setter)}::int4,
            ${Segment.paramSegment(unsaved.description)(Setter.stringSetter)},
            ${Segment.paramSegment(unsaved.discountpct)(Setter.bigDecimalScalaSetter)}::numeric,
            ${Segment.paramSegment(unsaved.`type`)(Setter.stringSetter)},
            ${Segment.paramSegment(unsaved.category)(Setter.stringSetter)},
            ${Segment.paramSegment(unsaved.startdate)(TypoLocalDateTime.setter)}::timestamp,
            ${Segment.paramSegment(unsaved.enddate)(TypoLocalDateTime.setter)}::timestamp,
            ${Segment.paramSegment(unsaved.minqty)(Setter.intSetter)}::int4,
            ${Segment.paramSegment(unsaved.maxqty)(Setter.optionParamSetter(Setter.intSetter))}::int4,
            ${Segment.paramSegment(unsaved.rowguid)(TypoUUID.setter)}::uuid,
            ${Segment.paramSegment(unsaved.modifieddate)(TypoLocalDateTime.setter)}::timestamp
          )
          on conflict ("specialofferid")
          do update set
            "description" = EXCLUDED."description",
            "discountpct" = EXCLUDED."discountpct",
            "type" = EXCLUDED."type",
            "category" = EXCLUDED."category",
            "startdate" = EXCLUDED."startdate",
            "enddate" = EXCLUDED."enddate",
            "minqty" = EXCLUDED."minqty",
            "maxqty" = EXCLUDED."maxqty",
            "rowguid" = EXCLUDED."rowguid",
            "modifieddate" = EXCLUDED."modifieddate"
          returning "specialofferid", "description", "discountpct", "type", "category", "startdate"::text, "enddate"::text, "minqty", "maxqty", "rowguid", "modifieddate"::text""".insertReturning(SpecialofferRow.jdbcDecoder)
  }
}
