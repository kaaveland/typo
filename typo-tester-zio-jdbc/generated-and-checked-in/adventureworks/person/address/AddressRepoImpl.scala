/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package person
package address

import adventureworks.customtypes.Defaulted
import adventureworks.customtypes.TypoBytea
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoUUID
import adventureworks.person.stateprovince.StateprovinceId
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

object AddressRepoImpl extends AddressRepo {
  override def delete(addressid: AddressId): ZIO[ZConnection, Throwable, Boolean] = {
    sql"""delete from person.address where "addressid" = ${Segment.paramSegment(addressid)(AddressId.setter)}""".delete.map(_ > 0)
  }
  override def delete: DeleteBuilder[AddressFields, AddressRow] = {
    DeleteBuilder("person.address", AddressFields)
  }
  override def insert(unsaved: AddressRow): ZIO[ZConnection, Throwable, AddressRow] = {
    sql"""insert into person.address("addressid", "addressline1", "addressline2", "city", "stateprovinceid", "postalcode", "spatiallocation", "rowguid", "modifieddate")
          values (${Segment.paramSegment(unsaved.addressid)(AddressId.setter)}::int4, ${Segment.paramSegment(unsaved.addressline1)(Setter.stringSetter)}, ${Segment.paramSegment(unsaved.addressline2)(Setter.optionParamSetter(Setter.stringSetter))}, ${Segment.paramSegment(unsaved.city)(Setter.stringSetter)}, ${Segment.paramSegment(unsaved.stateprovinceid)(StateprovinceId.setter)}::int4, ${Segment.paramSegment(unsaved.postalcode)(Setter.stringSetter)}, ${Segment.paramSegment(unsaved.spatiallocation)(Setter.optionParamSetter(TypoBytea.setter))}::bytea, ${Segment.paramSegment(unsaved.rowguid)(TypoUUID.setter)}::uuid, ${Segment.paramSegment(unsaved.modifieddate)(TypoLocalDateTime.setter)}::timestamp)
          returning "addressid", "addressline1", "addressline2", "city", "stateprovinceid", "postalcode", "spatiallocation", "rowguid", "modifieddate"::text
       """.insertReturning(AddressRow.jdbcDecoder).map(_.updatedKeys.head)
  }
  override def insert(unsaved: AddressRowUnsaved): ZIO[ZConnection, Throwable, AddressRow] = {
    val fs = List(
      Some((sql""""addressline1"""", sql"${Segment.paramSegment(unsaved.addressline1)(Setter.stringSetter)}")),
      Some((sql""""addressline2"""", sql"${Segment.paramSegment(unsaved.addressline2)(Setter.optionParamSetter(Setter.stringSetter))}")),
      Some((sql""""city"""", sql"${Segment.paramSegment(unsaved.city)(Setter.stringSetter)}")),
      Some((sql""""stateprovinceid"""", sql"${Segment.paramSegment(unsaved.stateprovinceid)(StateprovinceId.setter)}::int4")),
      Some((sql""""postalcode"""", sql"${Segment.paramSegment(unsaved.postalcode)(Setter.stringSetter)}")),
      Some((sql""""spatiallocation"""", sql"${Segment.paramSegment(unsaved.spatiallocation)(Setter.optionParamSetter(TypoBytea.setter))}::bytea")),
      unsaved.addressid match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((sql""""addressid"""", sql"${Segment.paramSegment(value: AddressId)(AddressId.setter)}::int4"))
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
      sql"""insert into person.address default values
            returning "addressid", "addressline1", "addressline2", "city", "stateprovinceid", "postalcode", "spatiallocation", "rowguid", "modifieddate"::text
         """
    } else {
      val names  = fs.map { case (n, _) => n }.mkFragment(SqlFragment(", "))
      val values = fs.map { case (_, f) => f }.mkFragment(SqlFragment(", "))
      sql"""insert into person.address($names) values ($values) returning "addressid", "addressline1", "addressline2", "city", "stateprovinceid", "postalcode", "spatiallocation", "rowguid", "modifieddate"::text"""
    }
    q.insertReturning(AddressRow.jdbcDecoder).map(_.updatedKeys.head)
    
  }
  override def select: SelectBuilder[AddressFields, AddressRow] = {
    SelectBuilderSql("person.address", AddressFields, AddressRow.jdbcDecoder)
  }
  override def selectAll: ZStream[ZConnection, Throwable, AddressRow] = {
    sql"""select "addressid", "addressline1", "addressline2", "city", "stateprovinceid", "postalcode", "spatiallocation", "rowguid", "modifieddate"::text from person.address""".query(AddressRow.jdbcDecoder).selectStream
  }
  override def selectById(addressid: AddressId): ZIO[ZConnection, Throwable, Option[AddressRow]] = {
    sql"""select "addressid", "addressline1", "addressline2", "city", "stateprovinceid", "postalcode", "spatiallocation", "rowguid", "modifieddate"::text from person.address where "addressid" = ${Segment.paramSegment(addressid)(AddressId.setter)}""".query(AddressRow.jdbcDecoder).selectOne
  }
  override def selectByIds(addressids: Array[AddressId]): ZStream[ZConnection, Throwable, AddressRow] = {
    sql"""select "addressid", "addressline1", "addressline2", "city", "stateprovinceid", "postalcode", "spatiallocation", "rowguid", "modifieddate"::text from person.address where "addressid" = ANY(${Segment.paramSegment(addressids)(AddressId.arraySetter)})""".query(AddressRow.jdbcDecoder).selectStream
  }
  override def update(row: AddressRow): ZIO[ZConnection, Throwable, Boolean] = {
    val addressid = row.addressid
    sql"""update person.address
          set "addressline1" = ${Segment.paramSegment(row.addressline1)(Setter.stringSetter)},
              "addressline2" = ${Segment.paramSegment(row.addressline2)(Setter.optionParamSetter(Setter.stringSetter))},
              "city" = ${Segment.paramSegment(row.city)(Setter.stringSetter)},
              "stateprovinceid" = ${Segment.paramSegment(row.stateprovinceid)(StateprovinceId.setter)}::int4,
              "postalcode" = ${Segment.paramSegment(row.postalcode)(Setter.stringSetter)},
              "spatiallocation" = ${Segment.paramSegment(row.spatiallocation)(Setter.optionParamSetter(TypoBytea.setter))}::bytea,
              "rowguid" = ${Segment.paramSegment(row.rowguid)(TypoUUID.setter)}::uuid,
              "modifieddate" = ${Segment.paramSegment(row.modifieddate)(TypoLocalDateTime.setter)}::timestamp
          where "addressid" = ${Segment.paramSegment(addressid)(AddressId.setter)}""".update.map(_ > 0)
  }
  override def update: UpdateBuilder[AddressFields, AddressRow] = {
    UpdateBuilder("person.address", AddressFields, AddressRow.jdbcDecoder)
  }
  override def upsert(unsaved: AddressRow): ZIO[ZConnection, Throwable, UpdateResult[AddressRow]] = {
    sql"""insert into person.address("addressid", "addressline1", "addressline2", "city", "stateprovinceid", "postalcode", "spatiallocation", "rowguid", "modifieddate")
          values (
            ${Segment.paramSegment(unsaved.addressid)(AddressId.setter)}::int4,
            ${Segment.paramSegment(unsaved.addressline1)(Setter.stringSetter)},
            ${Segment.paramSegment(unsaved.addressline2)(Setter.optionParamSetter(Setter.stringSetter))},
            ${Segment.paramSegment(unsaved.city)(Setter.stringSetter)},
            ${Segment.paramSegment(unsaved.stateprovinceid)(StateprovinceId.setter)}::int4,
            ${Segment.paramSegment(unsaved.postalcode)(Setter.stringSetter)},
            ${Segment.paramSegment(unsaved.spatiallocation)(Setter.optionParamSetter(TypoBytea.setter))}::bytea,
            ${Segment.paramSegment(unsaved.rowguid)(TypoUUID.setter)}::uuid,
            ${Segment.paramSegment(unsaved.modifieddate)(TypoLocalDateTime.setter)}::timestamp
          )
          on conflict ("addressid")
          do update set
            "addressline1" = EXCLUDED."addressline1",
            "addressline2" = EXCLUDED."addressline2",
            "city" = EXCLUDED."city",
            "stateprovinceid" = EXCLUDED."stateprovinceid",
            "postalcode" = EXCLUDED."postalcode",
            "spatiallocation" = EXCLUDED."spatiallocation",
            "rowguid" = EXCLUDED."rowguid",
            "modifieddate" = EXCLUDED."modifieddate"
          returning "addressid", "addressline1", "addressline2", "city", "stateprovinceid", "postalcode", "spatiallocation", "rowguid", "modifieddate"::text""".insertReturning(AddressRow.jdbcDecoder)
  }
}
