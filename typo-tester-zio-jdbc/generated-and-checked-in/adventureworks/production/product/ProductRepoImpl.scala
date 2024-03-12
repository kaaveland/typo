/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package product

import adventureworks.customtypes.Defaulted
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoShort
import adventureworks.customtypes.TypoUUID
import adventureworks.production.productmodel.ProductmodelId
import adventureworks.production.productsubcategory.ProductsubcategoryId
import adventureworks.production.unitmeasure.UnitmeasureId
import adventureworks.public.Flag
import adventureworks.public.Name
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

class ProductRepoImpl extends ProductRepo {
  override def delete(productid: ProductId): ZIO[ZConnection, Throwable, Boolean] = {
    sql"""delete from production.product where "productid" = ${Segment.paramSegment(productid)(ProductId.setter)}""".delete.map(_ > 0)
  }
  override def delete: DeleteBuilder[ProductFields, ProductRow] = {
    DeleteBuilder("production.product", ProductFields.structure)
  }
  override def insert(unsaved: ProductRow): ZIO[ZConnection, Throwable, ProductRow] = {
    sql"""insert into production.product("productid", "name", "productnumber", "makeflag", "finishedgoodsflag", "color", "safetystocklevel", "reorderpoint", "standardcost", "listprice", "size", "sizeunitmeasurecode", "weightunitmeasurecode", "weight", "daystomanufacture", "productline", "class", "style", "productsubcategoryid", "productmodelid", "sellstartdate", "sellenddate", "discontinueddate", "rowguid", "modifieddate")
          values (${Segment.paramSegment(unsaved.productid)(ProductId.setter)}::int4, ${Segment.paramSegment(unsaved.name)(Name.setter)}::varchar, ${Segment.paramSegment(unsaved.productnumber)(Setter.stringSetter)}, ${Segment.paramSegment(unsaved.makeflag)(Flag.setter)}::bool, ${Segment.paramSegment(unsaved.finishedgoodsflag)(Flag.setter)}::bool, ${Segment.paramSegment(unsaved.color)(Setter.optionParamSetter(Setter.stringSetter))}, ${Segment.paramSegment(unsaved.safetystocklevel)(TypoShort.setter)}::int2, ${Segment.paramSegment(unsaved.reorderpoint)(TypoShort.setter)}::int2, ${Segment.paramSegment(unsaved.standardcost)(Setter.bigDecimalScalaSetter)}::numeric, ${Segment.paramSegment(unsaved.listprice)(Setter.bigDecimalScalaSetter)}::numeric, ${Segment.paramSegment(unsaved.size)(Setter.optionParamSetter(Setter.stringSetter))}, ${Segment.paramSegment(unsaved.sizeunitmeasurecode)(Setter.optionParamSetter(UnitmeasureId.setter))}::bpchar, ${Segment.paramSegment(unsaved.weightunitmeasurecode)(Setter.optionParamSetter(UnitmeasureId.setter))}::bpchar, ${Segment.paramSegment(unsaved.weight)(Setter.optionParamSetter(Setter.bigDecimalScalaSetter))}::numeric, ${Segment.paramSegment(unsaved.daystomanufacture)(Setter.intSetter)}::int4, ${Segment.paramSegment(unsaved.productline)(Setter.optionParamSetter(Setter.stringSetter))}::bpchar, ${Segment.paramSegment(unsaved.`class`)(Setter.optionParamSetter(Setter.stringSetter))}::bpchar, ${Segment.paramSegment(unsaved.style)(Setter.optionParamSetter(Setter.stringSetter))}::bpchar, ${Segment.paramSegment(unsaved.productsubcategoryid)(Setter.optionParamSetter(ProductsubcategoryId.setter))}::int4, ${Segment.paramSegment(unsaved.productmodelid)(Setter.optionParamSetter(ProductmodelId.setter))}::int4, ${Segment.paramSegment(unsaved.sellstartdate)(TypoLocalDateTime.setter)}::timestamp, ${Segment.paramSegment(unsaved.sellenddate)(Setter.optionParamSetter(TypoLocalDateTime.setter))}::timestamp, ${Segment.paramSegment(unsaved.discontinueddate)(Setter.optionParamSetter(TypoLocalDateTime.setter))}::timestamp, ${Segment.paramSegment(unsaved.rowguid)(TypoUUID.setter)}::uuid, ${Segment.paramSegment(unsaved.modifieddate)(TypoLocalDateTime.setter)}::timestamp)
          returning "productid", "name", "productnumber", "makeflag", "finishedgoodsflag", "color", "safetystocklevel", "reorderpoint", "standardcost", "listprice", "size", "sizeunitmeasurecode", "weightunitmeasurecode", "weight", "daystomanufacture", "productline", "class", "style", "productsubcategoryid", "productmodelid", "sellstartdate"::text, "sellenddate"::text, "discontinueddate"::text, "rowguid", "modifieddate"::text
       """.insertReturning(ProductRow.jdbcDecoder).map(_.updatedKeys.head)
  }
  override def insertStreaming(unsaved: ZStream[ZConnection, Throwable, ProductRow], batchSize: Int): ZIO[ZConnection, Throwable, Long] = {
    streamingInsert(s"""COPY production.product("productid", "name", "productnumber", "makeflag", "finishedgoodsflag", "color", "safetystocklevel", "reorderpoint", "standardcost", "listprice", "size", "sizeunitmeasurecode", "weightunitmeasurecode", "weight", "daystomanufacture", "productline", "class", "style", "productsubcategoryid", "productmodelid", "sellstartdate", "sellenddate", "discontinueddate", "rowguid", "modifieddate") FROM STDIN""", batchSize, unsaved)(ProductRow.text)
  }
  override def insert(unsaved: ProductRowUnsaved): ZIO[ZConnection, Throwable, ProductRow] = {
    val fs = List(
      Some((sql""""name"""", sql"${Segment.paramSegment(unsaved.name)(Name.setter)}::varchar")),
      Some((sql""""productnumber"""", sql"${Segment.paramSegment(unsaved.productnumber)(Setter.stringSetter)}")),
      Some((sql""""color"""", sql"${Segment.paramSegment(unsaved.color)(Setter.optionParamSetter(Setter.stringSetter))}")),
      Some((sql""""safetystocklevel"""", sql"${Segment.paramSegment(unsaved.safetystocklevel)(TypoShort.setter)}::int2")),
      Some((sql""""reorderpoint"""", sql"${Segment.paramSegment(unsaved.reorderpoint)(TypoShort.setter)}::int2")),
      Some((sql""""standardcost"""", sql"${Segment.paramSegment(unsaved.standardcost)(Setter.bigDecimalScalaSetter)}::numeric")),
      Some((sql""""listprice"""", sql"${Segment.paramSegment(unsaved.listprice)(Setter.bigDecimalScalaSetter)}::numeric")),
      Some((sql""""size"""", sql"${Segment.paramSegment(unsaved.size)(Setter.optionParamSetter(Setter.stringSetter))}")),
      Some((sql""""sizeunitmeasurecode"""", sql"${Segment.paramSegment(unsaved.sizeunitmeasurecode)(Setter.optionParamSetter(UnitmeasureId.setter))}::bpchar")),
      Some((sql""""weightunitmeasurecode"""", sql"${Segment.paramSegment(unsaved.weightunitmeasurecode)(Setter.optionParamSetter(UnitmeasureId.setter))}::bpchar")),
      Some((sql""""weight"""", sql"${Segment.paramSegment(unsaved.weight)(Setter.optionParamSetter(Setter.bigDecimalScalaSetter))}::numeric")),
      Some((sql""""daystomanufacture"""", sql"${Segment.paramSegment(unsaved.daystomanufacture)(Setter.intSetter)}::int4")),
      Some((sql""""productline"""", sql"${Segment.paramSegment(unsaved.productline)(Setter.optionParamSetter(Setter.stringSetter))}::bpchar")),
      Some((sql""""class"""", sql"${Segment.paramSegment(unsaved.`class`)(Setter.optionParamSetter(Setter.stringSetter))}::bpchar")),
      Some((sql""""style"""", sql"${Segment.paramSegment(unsaved.style)(Setter.optionParamSetter(Setter.stringSetter))}::bpchar")),
      Some((sql""""productsubcategoryid"""", sql"${Segment.paramSegment(unsaved.productsubcategoryid)(Setter.optionParamSetter(ProductsubcategoryId.setter))}::int4")),
      Some((sql""""productmodelid"""", sql"${Segment.paramSegment(unsaved.productmodelid)(Setter.optionParamSetter(ProductmodelId.setter))}::int4")),
      Some((sql""""sellstartdate"""", sql"${Segment.paramSegment(unsaved.sellstartdate)(TypoLocalDateTime.setter)}::timestamp")),
      Some((sql""""sellenddate"""", sql"${Segment.paramSegment(unsaved.sellenddate)(Setter.optionParamSetter(TypoLocalDateTime.setter))}::timestamp")),
      Some((sql""""discontinueddate"""", sql"${Segment.paramSegment(unsaved.discontinueddate)(Setter.optionParamSetter(TypoLocalDateTime.setter))}::timestamp")),
      unsaved.productid match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((sql""""productid"""", sql"${Segment.paramSegment(value: ProductId)(ProductId.setter)}::int4"))
      },
      unsaved.makeflag match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((sql""""makeflag"""", sql"${Segment.paramSegment(value: Flag)(Flag.setter)}::bool"))
      },
      unsaved.finishedgoodsflag match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((sql""""finishedgoodsflag"""", sql"${Segment.paramSegment(value: Flag)(Flag.setter)}::bool"))
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
      sql"""insert into production.product default values
            returning "productid", "name", "productnumber", "makeflag", "finishedgoodsflag", "color", "safetystocklevel", "reorderpoint", "standardcost", "listprice", "size", "sizeunitmeasurecode", "weightunitmeasurecode", "weight", "daystomanufacture", "productline", "class", "style", "productsubcategoryid", "productmodelid", "sellstartdate"::text, "sellenddate"::text, "discontinueddate"::text, "rowguid", "modifieddate"::text
         """
    } else {
      val names  = fs.map { case (n, _) => n }.mkFragment(SqlFragment(", "))
      val values = fs.map { case (_, f) => f }.mkFragment(SqlFragment(", "))
      sql"""insert into production.product($names) values ($values) returning "productid", "name", "productnumber", "makeflag", "finishedgoodsflag", "color", "safetystocklevel", "reorderpoint", "standardcost", "listprice", "size", "sizeunitmeasurecode", "weightunitmeasurecode", "weight", "daystomanufacture", "productline", "class", "style", "productsubcategoryid", "productmodelid", "sellstartdate"::text, "sellenddate"::text, "discontinueddate"::text, "rowguid", "modifieddate"::text"""
    }
    q.insertReturning(ProductRow.jdbcDecoder).map(_.updatedKeys.head)
    
  }
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  override def insertUnsavedStreaming(unsaved: ZStream[ZConnection, Throwable, ProductRowUnsaved], batchSize: Int): ZIO[ZConnection, Throwable, Long] = {
    streamingInsert(s"""COPY production.product("name", "productnumber", "color", "safetystocklevel", "reorderpoint", "standardcost", "listprice", "size", "sizeunitmeasurecode", "weightunitmeasurecode", "weight", "daystomanufacture", "productline", "class", "style", "productsubcategoryid", "productmodelid", "sellstartdate", "sellenddate", "discontinueddate", "productid", "makeflag", "finishedgoodsflag", "rowguid", "modifieddate") FROM STDIN (DEFAULT '__DEFAULT_VALUE__')""", batchSize, unsaved)(ProductRowUnsaved.text)
  }
  override def select: SelectBuilder[ProductFields, ProductRow] = {
    SelectBuilderSql("production.product", ProductFields.structure, ProductRow.jdbcDecoder)
  }
  override def selectAll: ZStream[ZConnection, Throwable, ProductRow] = {
    sql"""select "productid", "name", "productnumber", "makeflag", "finishedgoodsflag", "color", "safetystocklevel", "reorderpoint", "standardcost", "listprice", "size", "sizeunitmeasurecode", "weightunitmeasurecode", "weight", "daystomanufacture", "productline", "class", "style", "productsubcategoryid", "productmodelid", "sellstartdate"::text, "sellenddate"::text, "discontinueddate"::text, "rowguid", "modifieddate"::text from production.product""".query(ProductRow.jdbcDecoder).selectStream
  }
  override def selectById(productid: ProductId): ZIO[ZConnection, Throwable, Option[ProductRow]] = {
    sql"""select "productid", "name", "productnumber", "makeflag", "finishedgoodsflag", "color", "safetystocklevel", "reorderpoint", "standardcost", "listprice", "size", "sizeunitmeasurecode", "weightunitmeasurecode", "weight", "daystomanufacture", "productline", "class", "style", "productsubcategoryid", "productmodelid", "sellstartdate"::text, "sellenddate"::text, "discontinueddate"::text, "rowguid", "modifieddate"::text from production.product where "productid" = ${Segment.paramSegment(productid)(ProductId.setter)}""".query(ProductRow.jdbcDecoder).selectOne
  }
  override def selectByIds(productids: Array[ProductId]): ZStream[ZConnection, Throwable, ProductRow] = {
    sql"""select "productid", "name", "productnumber", "makeflag", "finishedgoodsflag", "color", "safetystocklevel", "reorderpoint", "standardcost", "listprice", "size", "sizeunitmeasurecode", "weightunitmeasurecode", "weight", "daystomanufacture", "productline", "class", "style", "productsubcategoryid", "productmodelid", "sellstartdate"::text, "sellenddate"::text, "discontinueddate"::text, "rowguid", "modifieddate"::text from production.product where "productid" = ANY(${Segment.paramSegment(productids)(ProductId.arraySetter)})""".query(ProductRow.jdbcDecoder).selectStream
  }
  override def update(row: ProductRow): ZIO[ZConnection, Throwable, Boolean] = {
    val productid = row.productid
    sql"""update production.product
          set "name" = ${Segment.paramSegment(row.name)(Name.setter)}::varchar,
              "productnumber" = ${Segment.paramSegment(row.productnumber)(Setter.stringSetter)},
              "makeflag" = ${Segment.paramSegment(row.makeflag)(Flag.setter)}::bool,
              "finishedgoodsflag" = ${Segment.paramSegment(row.finishedgoodsflag)(Flag.setter)}::bool,
              "color" = ${Segment.paramSegment(row.color)(Setter.optionParamSetter(Setter.stringSetter))},
              "safetystocklevel" = ${Segment.paramSegment(row.safetystocklevel)(TypoShort.setter)}::int2,
              "reorderpoint" = ${Segment.paramSegment(row.reorderpoint)(TypoShort.setter)}::int2,
              "standardcost" = ${Segment.paramSegment(row.standardcost)(Setter.bigDecimalScalaSetter)}::numeric,
              "listprice" = ${Segment.paramSegment(row.listprice)(Setter.bigDecimalScalaSetter)}::numeric,
              "size" = ${Segment.paramSegment(row.size)(Setter.optionParamSetter(Setter.stringSetter))},
              "sizeunitmeasurecode" = ${Segment.paramSegment(row.sizeunitmeasurecode)(Setter.optionParamSetter(UnitmeasureId.setter))}::bpchar,
              "weightunitmeasurecode" = ${Segment.paramSegment(row.weightunitmeasurecode)(Setter.optionParamSetter(UnitmeasureId.setter))}::bpchar,
              "weight" = ${Segment.paramSegment(row.weight)(Setter.optionParamSetter(Setter.bigDecimalScalaSetter))}::numeric,
              "daystomanufacture" = ${Segment.paramSegment(row.daystomanufacture)(Setter.intSetter)}::int4,
              "productline" = ${Segment.paramSegment(row.productline)(Setter.optionParamSetter(Setter.stringSetter))}::bpchar,
              "class" = ${Segment.paramSegment(row.`class`)(Setter.optionParamSetter(Setter.stringSetter))}::bpchar,
              "style" = ${Segment.paramSegment(row.style)(Setter.optionParamSetter(Setter.stringSetter))}::bpchar,
              "productsubcategoryid" = ${Segment.paramSegment(row.productsubcategoryid)(Setter.optionParamSetter(ProductsubcategoryId.setter))}::int4,
              "productmodelid" = ${Segment.paramSegment(row.productmodelid)(Setter.optionParamSetter(ProductmodelId.setter))}::int4,
              "sellstartdate" = ${Segment.paramSegment(row.sellstartdate)(TypoLocalDateTime.setter)}::timestamp,
              "sellenddate" = ${Segment.paramSegment(row.sellenddate)(Setter.optionParamSetter(TypoLocalDateTime.setter))}::timestamp,
              "discontinueddate" = ${Segment.paramSegment(row.discontinueddate)(Setter.optionParamSetter(TypoLocalDateTime.setter))}::timestamp,
              "rowguid" = ${Segment.paramSegment(row.rowguid)(TypoUUID.setter)}::uuid,
              "modifieddate" = ${Segment.paramSegment(row.modifieddate)(TypoLocalDateTime.setter)}::timestamp
          where "productid" = ${Segment.paramSegment(productid)(ProductId.setter)}""".update.map(_ > 0)
  }
  override def update: UpdateBuilder[ProductFields, ProductRow] = {
    UpdateBuilder("production.product", ProductFields.structure, ProductRow.jdbcDecoder)
  }
  override def upsert(unsaved: ProductRow): ZIO[ZConnection, Throwable, UpdateResult[ProductRow]] = {
    sql"""insert into production.product("productid", "name", "productnumber", "makeflag", "finishedgoodsflag", "color", "safetystocklevel", "reorderpoint", "standardcost", "listprice", "size", "sizeunitmeasurecode", "weightunitmeasurecode", "weight", "daystomanufacture", "productline", "class", "style", "productsubcategoryid", "productmodelid", "sellstartdate", "sellenddate", "discontinueddate", "rowguid", "modifieddate")
          values (
            ${Segment.paramSegment(unsaved.productid)(ProductId.setter)}::int4,
            ${Segment.paramSegment(unsaved.name)(Name.setter)}::varchar,
            ${Segment.paramSegment(unsaved.productnumber)(Setter.stringSetter)},
            ${Segment.paramSegment(unsaved.makeflag)(Flag.setter)}::bool,
            ${Segment.paramSegment(unsaved.finishedgoodsflag)(Flag.setter)}::bool,
            ${Segment.paramSegment(unsaved.color)(Setter.optionParamSetter(Setter.stringSetter))},
            ${Segment.paramSegment(unsaved.safetystocklevel)(TypoShort.setter)}::int2,
            ${Segment.paramSegment(unsaved.reorderpoint)(TypoShort.setter)}::int2,
            ${Segment.paramSegment(unsaved.standardcost)(Setter.bigDecimalScalaSetter)}::numeric,
            ${Segment.paramSegment(unsaved.listprice)(Setter.bigDecimalScalaSetter)}::numeric,
            ${Segment.paramSegment(unsaved.size)(Setter.optionParamSetter(Setter.stringSetter))},
            ${Segment.paramSegment(unsaved.sizeunitmeasurecode)(Setter.optionParamSetter(UnitmeasureId.setter))}::bpchar,
            ${Segment.paramSegment(unsaved.weightunitmeasurecode)(Setter.optionParamSetter(UnitmeasureId.setter))}::bpchar,
            ${Segment.paramSegment(unsaved.weight)(Setter.optionParamSetter(Setter.bigDecimalScalaSetter))}::numeric,
            ${Segment.paramSegment(unsaved.daystomanufacture)(Setter.intSetter)}::int4,
            ${Segment.paramSegment(unsaved.productline)(Setter.optionParamSetter(Setter.stringSetter))}::bpchar,
            ${Segment.paramSegment(unsaved.`class`)(Setter.optionParamSetter(Setter.stringSetter))}::bpchar,
            ${Segment.paramSegment(unsaved.style)(Setter.optionParamSetter(Setter.stringSetter))}::bpchar,
            ${Segment.paramSegment(unsaved.productsubcategoryid)(Setter.optionParamSetter(ProductsubcategoryId.setter))}::int4,
            ${Segment.paramSegment(unsaved.productmodelid)(Setter.optionParamSetter(ProductmodelId.setter))}::int4,
            ${Segment.paramSegment(unsaved.sellstartdate)(TypoLocalDateTime.setter)}::timestamp,
            ${Segment.paramSegment(unsaved.sellenddate)(Setter.optionParamSetter(TypoLocalDateTime.setter))}::timestamp,
            ${Segment.paramSegment(unsaved.discontinueddate)(Setter.optionParamSetter(TypoLocalDateTime.setter))}::timestamp,
            ${Segment.paramSegment(unsaved.rowguid)(TypoUUID.setter)}::uuid,
            ${Segment.paramSegment(unsaved.modifieddate)(TypoLocalDateTime.setter)}::timestamp
          )
          on conflict ("productid")
          do update set
            "name" = EXCLUDED."name",
            "productnumber" = EXCLUDED."productnumber",
            "makeflag" = EXCLUDED."makeflag",
            "finishedgoodsflag" = EXCLUDED."finishedgoodsflag",
            "color" = EXCLUDED."color",
            "safetystocklevel" = EXCLUDED."safetystocklevel",
            "reorderpoint" = EXCLUDED."reorderpoint",
            "standardcost" = EXCLUDED."standardcost",
            "listprice" = EXCLUDED."listprice",
            "size" = EXCLUDED."size",
            "sizeunitmeasurecode" = EXCLUDED."sizeunitmeasurecode",
            "weightunitmeasurecode" = EXCLUDED."weightunitmeasurecode",
            "weight" = EXCLUDED."weight",
            "daystomanufacture" = EXCLUDED."daystomanufacture",
            "productline" = EXCLUDED."productline",
            "class" = EXCLUDED."class",
            "style" = EXCLUDED."style",
            "productsubcategoryid" = EXCLUDED."productsubcategoryid",
            "productmodelid" = EXCLUDED."productmodelid",
            "sellstartdate" = EXCLUDED."sellstartdate",
            "sellenddate" = EXCLUDED."sellenddate",
            "discontinueddate" = EXCLUDED."discontinueddate",
            "rowguid" = EXCLUDED."rowguid",
            "modifieddate" = EXCLUDED."modifieddate"
          returning "productid", "name", "productnumber", "makeflag", "finishedgoodsflag", "color", "safetystocklevel", "reorderpoint", "standardcost", "listprice", "size", "sizeunitmeasurecode", "weightunitmeasurecode", "weight", "daystomanufacture", "productline", "class", "style", "productsubcategoryid", "productmodelid", "sellstartdate"::text, "sellenddate"::text, "discontinueddate"::text, "rowguid", "modifieddate"::text""".insertReturning(ProductRow.jdbcDecoder)
  }
}
