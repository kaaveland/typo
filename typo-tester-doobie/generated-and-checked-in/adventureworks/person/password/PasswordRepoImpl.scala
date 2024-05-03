/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package person
package password

import adventureworks.customtypes.Defaulted
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoUUID
import adventureworks.person.businessentity.BusinessentityId
import doobie.free.connection.ConnectionIO
import doobie.postgres.syntax.FragmentOps
import doobie.syntax.SqlInterpolator.SingleFragment.fromWrite
import doobie.syntax.string.toSqlInterpolator
import doobie.util.Write
import doobie.util.fragment.Fragment
import doobie.util.meta.Meta
import fs2.Stream
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql
import typo.dsl.UpdateBuilder

class PasswordRepoImpl extends PasswordRepo {
  override def delete: DeleteBuilder[PasswordFields, PasswordRow] = {
    DeleteBuilder("person.password", PasswordFields.structure)
  }
  override def deleteById(businessentityid: BusinessentityId): ConnectionIO[Boolean] = {
    sql"""delete from person.password where "businessentityid" = ${fromWrite(businessentityid)(Write.fromPut(BusinessentityId.put))}""".update.run.map(_ > 0)
  }
  override def deleteByIds(businessentityids: Array[BusinessentityId]): ConnectionIO[Int] = {
    sql"""delete from person.password where "businessentityid" = ANY(${businessentityids})""".update.run
  }
  override def insert(unsaved: PasswordRow): ConnectionIO[PasswordRow] = {
    sql"""insert into person.password("businessentityid", "passwordhash", "passwordsalt", "rowguid", "modifieddate")
          values (${fromWrite(unsaved.businessentityid)(Write.fromPut(BusinessentityId.put))}::int4, ${fromWrite(unsaved.passwordhash)(Write.fromPut(Meta.StringMeta.put))}, ${fromWrite(unsaved.passwordsalt)(Write.fromPut(Meta.StringMeta.put))}, ${fromWrite(unsaved.rowguid)(Write.fromPut(TypoUUID.put))}::uuid, ${fromWrite(unsaved.modifieddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp)
          returning "businessentityid", "passwordhash", "passwordsalt", "rowguid", "modifieddate"::text
       """.query(using PasswordRow.read).unique
  }
  override def insert(unsaved: PasswordRowUnsaved): ConnectionIO[PasswordRow] = {
    val fs = List(
      Some((Fragment.const(s""""businessentityid""""), fr"${fromWrite(unsaved.businessentityid)(Write.fromPut(BusinessentityId.put))}::int4")),
      Some((Fragment.const(s""""passwordhash""""), fr"${fromWrite(unsaved.passwordhash)(Write.fromPut(Meta.StringMeta.put))}")),
      Some((Fragment.const(s""""passwordsalt""""), fr"${fromWrite(unsaved.passwordsalt)(Write.fromPut(Meta.StringMeta.put))}")),
      unsaved.rowguid match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s""""rowguid""""), fr"${fromWrite(value: TypoUUID)(Write.fromPut(TypoUUID.put))}::uuid"))
      },
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s""""modifieddate""""), fr"${fromWrite(value: TypoLocalDateTime)(Write.fromPut(TypoLocalDateTime.put))}::timestamp"))
      }
    ).flatten
    
    val q = if (fs.isEmpty) {
      sql"""insert into person.password default values
            returning "businessentityid", "passwordhash", "passwordsalt", "rowguid", "modifieddate"::text
         """
    } else {
      val CommaSeparate = Fragment.FragmentMonoid.intercalate(fr", ")
      sql"""insert into person.password(${CommaSeparate.combineAllOption(fs.map { case (n, _) => n }).get})
            values (${CommaSeparate.combineAllOption(fs.map { case (_, f) => f }).get})
            returning "businessentityid", "passwordhash", "passwordsalt", "rowguid", "modifieddate"::text
         """
    }
    q.query(using PasswordRow.read).unique
    
  }
  override def insertStreaming(unsaved: Stream[ConnectionIO, PasswordRow], batchSize: Int = 10000): ConnectionIO[Long] = {
    new FragmentOps(sql"""COPY person.password("businessentityid", "passwordhash", "passwordsalt", "rowguid", "modifieddate") FROM STDIN""").copyIn(unsaved, batchSize)(using PasswordRow.text)
  }
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  override def insertUnsavedStreaming(unsaved: Stream[ConnectionIO, PasswordRowUnsaved], batchSize: Int = 10000): ConnectionIO[Long] = {
    new FragmentOps(sql"""COPY person.password("businessentityid", "passwordhash", "passwordsalt", "rowguid", "modifieddate") FROM STDIN (DEFAULT '__DEFAULT_VALUE__')""").copyIn(unsaved, batchSize)(using PasswordRowUnsaved.text)
  }
  override def select: SelectBuilder[PasswordFields, PasswordRow] = {
    SelectBuilderSql("person.password", PasswordFields.structure, PasswordRow.read)
  }
  override def selectAll: Stream[ConnectionIO, PasswordRow] = {
    sql"""select "businessentityid", "passwordhash", "passwordsalt", "rowguid", "modifieddate"::text from person.password""".query(using PasswordRow.read).stream
  }
  override def selectById(businessentityid: BusinessentityId): ConnectionIO[Option[PasswordRow]] = {
    sql"""select "businessentityid", "passwordhash", "passwordsalt", "rowguid", "modifieddate"::text from person.password where "businessentityid" = ${fromWrite(businessentityid)(Write.fromPut(BusinessentityId.put))}""".query(using PasswordRow.read).option
  }
  override def selectByIds(businessentityids: Array[BusinessentityId]): Stream[ConnectionIO, PasswordRow] = {
    sql"""select "businessentityid", "passwordhash", "passwordsalt", "rowguid", "modifieddate"::text from person.password where "businessentityid" = ANY(${businessentityids})""".query(using PasswordRow.read).stream
  }
  override def selectByIdsTracked(businessentityids: Array[BusinessentityId]): ConnectionIO[Map[BusinessentityId, PasswordRow]] = {
    selectByIds(businessentityids).compile.toList.map { rows =>
      val byId = rows.view.map(x => (x.businessentityid, x)).toMap
      businessentityids.view.flatMap(id => byId.get(id).map(x => (id, x))).toMap
    }
  }
  override def update: UpdateBuilder[PasswordFields, PasswordRow] = {
    UpdateBuilder("person.password", PasswordFields.structure, PasswordRow.read)
  }
  override def update(row: PasswordRow): ConnectionIO[Boolean] = {
    val businessentityid = row.businessentityid
    sql"""update person.password
          set "passwordhash" = ${fromWrite(row.passwordhash)(Write.fromPut(Meta.StringMeta.put))},
              "passwordsalt" = ${fromWrite(row.passwordsalt)(Write.fromPut(Meta.StringMeta.put))},
              "rowguid" = ${fromWrite(row.rowguid)(Write.fromPut(TypoUUID.put))}::uuid,
              "modifieddate" = ${fromWrite(row.modifieddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp
          where "businessentityid" = ${fromWrite(businessentityid)(Write.fromPut(BusinessentityId.put))}"""
      .update
      .run
      .map(_ > 0)
  }
  override def upsert(unsaved: PasswordRow): ConnectionIO[PasswordRow] = {
    sql"""insert into person.password("businessentityid", "passwordhash", "passwordsalt", "rowguid", "modifieddate")
          values (
            ${fromWrite(unsaved.businessentityid)(Write.fromPut(BusinessentityId.put))}::int4,
            ${fromWrite(unsaved.passwordhash)(Write.fromPut(Meta.StringMeta.put))},
            ${fromWrite(unsaved.passwordsalt)(Write.fromPut(Meta.StringMeta.put))},
            ${fromWrite(unsaved.rowguid)(Write.fromPut(TypoUUID.put))}::uuid,
            ${fromWrite(unsaved.modifieddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp
          )
          on conflict ("businessentityid")
          do update set
            "passwordhash" = EXCLUDED."passwordhash",
            "passwordsalt" = EXCLUDED."passwordsalt",
            "rowguid" = EXCLUDED."rowguid",
            "modifieddate" = EXCLUDED."modifieddate"
          returning "businessentityid", "passwordhash", "passwordsalt", "rowguid", "modifieddate"::text
       """.query(using PasswordRow.read).unique
  }
}
