/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package humanresources
package employee

import adventureworks.customtypes.Defaulted
import adventureworks.customtypes.TypoLocalDate
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoShort
import adventureworks.customtypes.TypoUUID
import adventureworks.person.businessentity.BusinessentityId
import adventureworks.public.Flag
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

class EmployeeRepoImpl extends EmployeeRepo {
  override def delete: DeleteBuilder[EmployeeFields, EmployeeRow] = {
    DeleteBuilder("humanresources.employee", EmployeeFields.structure)
  }
  override def deleteById(businessentityid: BusinessentityId): ZIO[ZConnection, Throwable, Boolean] = {
    sql"""delete from humanresources.employee where "businessentityid" = ${Segment.paramSegment(businessentityid)(BusinessentityId.setter)}""".delete.map(_ > 0)
  }
  override def deleteByIds(businessentityids: Array[BusinessentityId]): ZIO[ZConnection, Throwable, Long] = {
    sql"""delete from humanresources.employee where "businessentityid" = ANY(${businessentityids})""".delete
  }
  override def insert(unsaved: EmployeeRow): ZIO[ZConnection, Throwable, EmployeeRow] = {
    sql"""insert into humanresources.employee("businessentityid", "nationalidnumber", "loginid", "jobtitle", "birthdate", "maritalstatus", "gender", "hiredate", "salariedflag", "vacationhours", "sickleavehours", "currentflag", "rowguid", "modifieddate", "organizationnode")
          values (${Segment.paramSegment(unsaved.businessentityid)(BusinessentityId.setter)}::int4, ${Segment.paramSegment(unsaved.nationalidnumber)(Setter.stringSetter)}, ${Segment.paramSegment(unsaved.loginid)(Setter.stringSetter)}, ${Segment.paramSegment(unsaved.jobtitle)(Setter.stringSetter)}, ${Segment.paramSegment(unsaved.birthdate)(TypoLocalDate.setter)}::date, ${Segment.paramSegment(unsaved.maritalstatus)(Setter.stringSetter)}::bpchar, ${Segment.paramSegment(unsaved.gender)(Setter.stringSetter)}::bpchar, ${Segment.paramSegment(unsaved.hiredate)(TypoLocalDate.setter)}::date, ${Segment.paramSegment(unsaved.salariedflag)(Flag.setter)}::bool, ${Segment.paramSegment(unsaved.vacationhours)(TypoShort.setter)}::int2, ${Segment.paramSegment(unsaved.sickleavehours)(TypoShort.setter)}::int2, ${Segment.paramSegment(unsaved.currentflag)(Flag.setter)}::bool, ${Segment.paramSegment(unsaved.rowguid)(TypoUUID.setter)}::uuid, ${Segment.paramSegment(unsaved.modifieddate)(TypoLocalDateTime.setter)}::timestamp, ${Segment.paramSegment(unsaved.organizationnode)(Setter.optionParamSetter(Setter.stringSetter))})
          returning "businessentityid", "nationalidnumber", "loginid", "jobtitle", "birthdate"::text, "maritalstatus", "gender", "hiredate"::text, "salariedflag", "vacationhours", "sickleavehours", "currentflag", "rowguid", "modifieddate"::text, "organizationnode"
       """.insertReturning(using EmployeeRow.jdbcDecoder).map(_.updatedKeys.head)
  }
  override def insert(unsaved: EmployeeRowUnsaved): ZIO[ZConnection, Throwable, EmployeeRow] = {
    val fs = List(
      Some((sql""""businessentityid"""", sql"${Segment.paramSegment(unsaved.businessentityid)(BusinessentityId.setter)}::int4")),
      Some((sql""""nationalidnumber"""", sql"${Segment.paramSegment(unsaved.nationalidnumber)(Setter.stringSetter)}")),
      Some((sql""""loginid"""", sql"${Segment.paramSegment(unsaved.loginid)(Setter.stringSetter)}")),
      Some((sql""""jobtitle"""", sql"${Segment.paramSegment(unsaved.jobtitle)(Setter.stringSetter)}")),
      Some((sql""""birthdate"""", sql"${Segment.paramSegment(unsaved.birthdate)(TypoLocalDate.setter)}::date")),
      Some((sql""""maritalstatus"""", sql"${Segment.paramSegment(unsaved.maritalstatus)(Setter.stringSetter)}::bpchar")),
      Some((sql""""gender"""", sql"${Segment.paramSegment(unsaved.gender)(Setter.stringSetter)}::bpchar")),
      Some((sql""""hiredate"""", sql"${Segment.paramSegment(unsaved.hiredate)(TypoLocalDate.setter)}::date")),
      unsaved.salariedflag match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((sql""""salariedflag"""", sql"${Segment.paramSegment(value: Flag)(Flag.setter)}::bool"))
      },
      unsaved.vacationhours match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((sql""""vacationhours"""", sql"${Segment.paramSegment(value: TypoShort)(TypoShort.setter)}::int2"))
      },
      unsaved.sickleavehours match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((sql""""sickleavehours"""", sql"${Segment.paramSegment(value: TypoShort)(TypoShort.setter)}::int2"))
      },
      unsaved.currentflag match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((sql""""currentflag"""", sql"${Segment.paramSegment(value: Flag)(Flag.setter)}::bool"))
      },
      unsaved.rowguid match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((sql""""rowguid"""", sql"${Segment.paramSegment(value: TypoUUID)(TypoUUID.setter)}::uuid"))
      },
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((sql""""modifieddate"""", sql"${Segment.paramSegment(value: TypoLocalDateTime)(TypoLocalDateTime.setter)}::timestamp"))
      },
      unsaved.organizationnode match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((sql""""organizationnode"""", sql"${Segment.paramSegment(value: Option[String])(Setter.optionParamSetter(Setter.stringSetter))}"))
      }
    ).flatten
    
    val q = if (fs.isEmpty) {
      sql"""insert into humanresources.employee default values
            returning "businessentityid", "nationalidnumber", "loginid", "jobtitle", "birthdate"::text, "maritalstatus", "gender", "hiredate"::text, "salariedflag", "vacationhours", "sickleavehours", "currentflag", "rowguid", "modifieddate"::text, "organizationnode"
         """
    } else {
      val names  = fs.map { case (n, _) => n }.mkFragment(SqlFragment(", "))
      val values = fs.map { case (_, f) => f }.mkFragment(SqlFragment(", "))
      sql"""insert into humanresources.employee($names) values ($values) returning "businessentityid", "nationalidnumber", "loginid", "jobtitle", "birthdate"::text, "maritalstatus", "gender", "hiredate"::text, "salariedflag", "vacationhours", "sickleavehours", "currentflag", "rowguid", "modifieddate"::text, "organizationnode""""
    }
    q.insertReturning(using EmployeeRow.jdbcDecoder).map(_.updatedKeys.head)
    
  }
  override def insertStreaming(unsaved: ZStream[ZConnection, Throwable, EmployeeRow], batchSize: Int): ZIO[ZConnection, Throwable, Long] = {
    streamingInsert(s"""COPY humanresources.employee("businessentityid", "nationalidnumber", "loginid", "jobtitle", "birthdate", "maritalstatus", "gender", "hiredate", "salariedflag", "vacationhours", "sickleavehours", "currentflag", "rowguid", "modifieddate", "organizationnode") FROM STDIN""", batchSize, unsaved)(EmployeeRow.text)
  }
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  override def insertUnsavedStreaming(unsaved: ZStream[ZConnection, Throwable, EmployeeRowUnsaved], batchSize: Int): ZIO[ZConnection, Throwable, Long] = {
    streamingInsert(s"""COPY humanresources.employee("businessentityid", "nationalidnumber", "loginid", "jobtitle", "birthdate", "maritalstatus", "gender", "hiredate", "salariedflag", "vacationhours", "sickleavehours", "currentflag", "rowguid", "modifieddate", "organizationnode") FROM STDIN (DEFAULT '__DEFAULT_VALUE__')""", batchSize, unsaved)(EmployeeRowUnsaved.text)
  }
  override def select: SelectBuilder[EmployeeFields, EmployeeRow] = {
    SelectBuilderSql("humanresources.employee", EmployeeFields.structure, EmployeeRow.jdbcDecoder)
  }
  override def selectAll: ZStream[ZConnection, Throwable, EmployeeRow] = {
    sql"""select "businessentityid", "nationalidnumber", "loginid", "jobtitle", "birthdate"::text, "maritalstatus", "gender", "hiredate"::text, "salariedflag", "vacationhours", "sickleavehours", "currentflag", "rowguid", "modifieddate"::text, "organizationnode" from humanresources.employee""".query(using EmployeeRow.jdbcDecoder).selectStream()
  }
  override def selectById(businessentityid: BusinessentityId): ZIO[ZConnection, Throwable, Option[EmployeeRow]] = {
    sql"""select "businessentityid", "nationalidnumber", "loginid", "jobtitle", "birthdate"::text, "maritalstatus", "gender", "hiredate"::text, "salariedflag", "vacationhours", "sickleavehours", "currentflag", "rowguid", "modifieddate"::text, "organizationnode" from humanresources.employee where "businessentityid" = ${Segment.paramSegment(businessentityid)(BusinessentityId.setter)}""".query(using EmployeeRow.jdbcDecoder).selectOne
  }
  override def selectByIds(businessentityids: Array[BusinessentityId]): ZStream[ZConnection, Throwable, EmployeeRow] = {
    sql"""select "businessentityid", "nationalidnumber", "loginid", "jobtitle", "birthdate"::text, "maritalstatus", "gender", "hiredate"::text, "salariedflag", "vacationhours", "sickleavehours", "currentflag", "rowguid", "modifieddate"::text, "organizationnode" from humanresources.employee where "businessentityid" = ANY(${Segment.paramSegment(businessentityids)(BusinessentityId.arraySetter)})""".query(using EmployeeRow.jdbcDecoder).selectStream()
  }
  override def selectByIdsTracked(businessentityids: Array[BusinessentityId]): ZIO[ZConnection, Throwable, Map[BusinessentityId, Option[EmployeeRow]]] = {
    selectByIds(businessentityids).runCollect.map { rows =>
      val byId = rows.view.map(x => (x.businessentityid, x)).toMap
      businessentityids.view.map(id => (id, byId.get(id))).toMap
    }
  }
  override def update: UpdateBuilder[EmployeeFields, EmployeeRow] = {
    UpdateBuilder("humanresources.employee", EmployeeFields.structure, EmployeeRow.jdbcDecoder)
  }
  override def update(row: EmployeeRow): ZIO[ZConnection, Throwable, Boolean] = {
    val businessentityid = row.businessentityid
    sql"""update humanresources.employee
          set "nationalidnumber" = ${Segment.paramSegment(row.nationalidnumber)(Setter.stringSetter)},
              "loginid" = ${Segment.paramSegment(row.loginid)(Setter.stringSetter)},
              "jobtitle" = ${Segment.paramSegment(row.jobtitle)(Setter.stringSetter)},
              "birthdate" = ${Segment.paramSegment(row.birthdate)(TypoLocalDate.setter)}::date,
              "maritalstatus" = ${Segment.paramSegment(row.maritalstatus)(Setter.stringSetter)}::bpchar,
              "gender" = ${Segment.paramSegment(row.gender)(Setter.stringSetter)}::bpchar,
              "hiredate" = ${Segment.paramSegment(row.hiredate)(TypoLocalDate.setter)}::date,
              "salariedflag" = ${Segment.paramSegment(row.salariedflag)(Flag.setter)}::bool,
              "vacationhours" = ${Segment.paramSegment(row.vacationhours)(TypoShort.setter)}::int2,
              "sickleavehours" = ${Segment.paramSegment(row.sickleavehours)(TypoShort.setter)}::int2,
              "currentflag" = ${Segment.paramSegment(row.currentflag)(Flag.setter)}::bool,
              "rowguid" = ${Segment.paramSegment(row.rowguid)(TypoUUID.setter)}::uuid,
              "modifieddate" = ${Segment.paramSegment(row.modifieddate)(TypoLocalDateTime.setter)}::timestamp,
              "organizationnode" = ${Segment.paramSegment(row.organizationnode)(Setter.optionParamSetter(Setter.stringSetter))}
          where "businessentityid" = ${Segment.paramSegment(businessentityid)(BusinessentityId.setter)}""".update.map(_ > 0)
  }
  override def upsert(unsaved: EmployeeRow): ZIO[ZConnection, Throwable, UpdateResult[EmployeeRow]] = {
    sql"""insert into humanresources.employee("businessentityid", "nationalidnumber", "loginid", "jobtitle", "birthdate", "maritalstatus", "gender", "hiredate", "salariedflag", "vacationhours", "sickleavehours", "currentflag", "rowguid", "modifieddate", "organizationnode")
          values (
            ${Segment.paramSegment(unsaved.businessentityid)(BusinessentityId.setter)}::int4,
            ${Segment.paramSegment(unsaved.nationalidnumber)(Setter.stringSetter)},
            ${Segment.paramSegment(unsaved.loginid)(Setter.stringSetter)},
            ${Segment.paramSegment(unsaved.jobtitle)(Setter.stringSetter)},
            ${Segment.paramSegment(unsaved.birthdate)(TypoLocalDate.setter)}::date,
            ${Segment.paramSegment(unsaved.maritalstatus)(Setter.stringSetter)}::bpchar,
            ${Segment.paramSegment(unsaved.gender)(Setter.stringSetter)}::bpchar,
            ${Segment.paramSegment(unsaved.hiredate)(TypoLocalDate.setter)}::date,
            ${Segment.paramSegment(unsaved.salariedflag)(Flag.setter)}::bool,
            ${Segment.paramSegment(unsaved.vacationhours)(TypoShort.setter)}::int2,
            ${Segment.paramSegment(unsaved.sickleavehours)(TypoShort.setter)}::int2,
            ${Segment.paramSegment(unsaved.currentflag)(Flag.setter)}::bool,
            ${Segment.paramSegment(unsaved.rowguid)(TypoUUID.setter)}::uuid,
            ${Segment.paramSegment(unsaved.modifieddate)(TypoLocalDateTime.setter)}::timestamp,
            ${Segment.paramSegment(unsaved.organizationnode)(Setter.optionParamSetter(Setter.stringSetter))}
          )
          on conflict ("businessentityid")
          do update set
            "nationalidnumber" = EXCLUDED."nationalidnumber",
            "loginid" = EXCLUDED."loginid",
            "jobtitle" = EXCLUDED."jobtitle",
            "birthdate" = EXCLUDED."birthdate",
            "maritalstatus" = EXCLUDED."maritalstatus",
            "gender" = EXCLUDED."gender",
            "hiredate" = EXCLUDED."hiredate",
            "salariedflag" = EXCLUDED."salariedflag",
            "vacationhours" = EXCLUDED."vacationhours",
            "sickleavehours" = EXCLUDED."sickleavehours",
            "currentflag" = EXCLUDED."currentflag",
            "rowguid" = EXCLUDED."rowguid",
            "modifieddate" = EXCLUDED."modifieddate",
            "organizationnode" = EXCLUDED."organizationnode"
          returning "businessentityid", "nationalidnumber", "loginid", "jobtitle", "birthdate"::text, "maritalstatus", "gender", "hiredate"::text, "salariedflag", "vacationhours", "sickleavehours", "currentflag", "rowguid", "modifieddate"::text, "organizationnode"""".insertReturning(using EmployeeRow.jdbcDecoder)
  }
}
