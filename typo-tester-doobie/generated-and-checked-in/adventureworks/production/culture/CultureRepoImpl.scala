/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package culture

import adventureworks.customtypes.Defaulted
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.public.Name
import doobie.free.connection.ConnectionIO
import doobie.postgres.syntax.FragmentOps
import doobie.syntax.SqlInterpolator.SingleFragment.fromWrite
import doobie.syntax.string.toSqlInterpolator
import doobie.util.Write
import doobie.util.fragment.Fragment
import fs2.Stream
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql
import typo.dsl.UpdateBuilder

class CultureRepoImpl extends CultureRepo {
  override def delete(cultureid: CultureId): ConnectionIO[Boolean] = {
    sql"""delete from production.culture where "cultureid" = ${fromWrite(cultureid)(Write.fromPut(CultureId.put))}""".update.run.map(_ > 0)
  }
  override def delete: DeleteBuilder[CultureFields, CultureRow] = {
    DeleteBuilder("production.culture", CultureFields.structure)
  }
  override def insert(unsaved: CultureRow): ConnectionIO[CultureRow] = {
    sql"""insert into production.culture("cultureid", "name", "modifieddate")
          values (${fromWrite(unsaved.cultureid)(Write.fromPut(CultureId.put))}::bpchar, ${fromWrite(unsaved.name)(Write.fromPut(Name.put))}::varchar, ${fromWrite(unsaved.modifieddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp)
          returning "cultureid", "name", "modifieddate"::text
       """.query(CultureRow.read).unique
  }
  override def insertStreaming(unsaved: Stream[ConnectionIO, CultureRow], batchSize: Int): ConnectionIO[Long] = {
    new FragmentOps(sql"""COPY production.culture("cultureid", "name", "modifieddate") FROM STDIN""").copyIn(unsaved, batchSize)(CultureRow.text)
  }
  override def insert(unsaved: CultureRowUnsaved): ConnectionIO[CultureRow] = {
    val fs = List(
      Some((Fragment.const(s""""cultureid""""), fr"${fromWrite(unsaved.cultureid)(Write.fromPut(CultureId.put))}::bpchar")),
      Some((Fragment.const(s""""name""""), fr"${fromWrite(unsaved.name)(Write.fromPut(Name.put))}::varchar")),
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s""""modifieddate""""), fr"${fromWrite(value: TypoLocalDateTime)(Write.fromPut(TypoLocalDateTime.put))}::timestamp"))
      }
    ).flatten
    
    val q = if (fs.isEmpty) {
      sql"""insert into production.culture default values
            returning "cultureid", "name", "modifieddate"::text
         """
    } else {
      val CommaSeparate = Fragment.FragmentMonoid.intercalate(fr", ")
      sql"""insert into production.culture(${CommaSeparate.combineAllOption(fs.map { case (n, _) => n }).get})
            values (${CommaSeparate.combineAllOption(fs.map { case (_, f) => f }).get})
            returning "cultureid", "name", "modifieddate"::text
         """
    }
    q.query(CultureRow.read).unique
    
  }
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  override def insertUnsavedStreaming(unsaved: Stream[ConnectionIO, CultureRowUnsaved], batchSize: Int): ConnectionIO[Long] = {
    new FragmentOps(sql"""COPY production.culture("cultureid", "name", "modifieddate") FROM STDIN (DEFAULT '__DEFAULT_VALUE__')""").copyIn(unsaved, batchSize)(CultureRowUnsaved.text)
  }
  override def select: SelectBuilder[CultureFields, CultureRow] = {
    SelectBuilderSql("production.culture", CultureFields.structure, CultureRow.read)
  }
  override def selectAll: Stream[ConnectionIO, CultureRow] = {
    sql"""select "cultureid", "name", "modifieddate"::text from production.culture""".query(CultureRow.read).stream
  }
  override def selectById(cultureid: CultureId): ConnectionIO[Option[CultureRow]] = {
    sql"""select "cultureid", "name", "modifieddate"::text from production.culture where "cultureid" = ${fromWrite(cultureid)(Write.fromPut(CultureId.put))}""".query(CultureRow.read).option
  }
  override def selectByIds(cultureids: Array[CultureId]): Stream[ConnectionIO, CultureRow] = {
    sql"""select "cultureid", "name", "modifieddate"::text from production.culture where "cultureid" = ANY(${cultureids})""".query(CultureRow.read).stream
  }
  override def update(row: CultureRow): ConnectionIO[Boolean] = {
    val cultureid = row.cultureid
    sql"""update production.culture
          set "name" = ${fromWrite(row.name)(Write.fromPut(Name.put))}::varchar,
              "modifieddate" = ${fromWrite(row.modifieddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp
          where "cultureid" = ${fromWrite(cultureid)(Write.fromPut(CultureId.put))}"""
      .update
      .run
      .map(_ > 0)
  }
  override def update: UpdateBuilder[CultureFields, CultureRow] = {
    UpdateBuilder("production.culture", CultureFields.structure, CultureRow.read)
  }
  override def upsert(unsaved: CultureRow): ConnectionIO[CultureRow] = {
    sql"""insert into production.culture("cultureid", "name", "modifieddate")
          values (
            ${fromWrite(unsaved.cultureid)(Write.fromPut(CultureId.put))}::bpchar,
            ${fromWrite(unsaved.name)(Write.fromPut(Name.put))}::varchar,
            ${fromWrite(unsaved.modifieddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp
          )
          on conflict ("cultureid")
          do update set
            "name" = EXCLUDED."name",
            "modifieddate" = EXCLUDED."modifieddate"
          returning "cultureid", "name", "modifieddate"::text
       """.query(CultureRow.read).unique
  }
}
