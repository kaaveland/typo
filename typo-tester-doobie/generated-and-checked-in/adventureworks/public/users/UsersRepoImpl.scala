/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package public
package users

import adventureworks.customtypes.Defaulted
import adventureworks.customtypes.TypoInstant
import adventureworks.customtypes.TypoUnknownCitext
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

class UsersRepoImpl extends UsersRepo {
  override def delete(userId: UsersId): ConnectionIO[Boolean] = {
    sql"""delete from public.users where "user_id" = ${fromWrite(userId)(Write.fromPut(UsersId.put))}""".update.run.map(_ > 0)
  }
  override def delete: DeleteBuilder[UsersFields, UsersRow] = {
    DeleteBuilder("public.users", UsersFields.structure)
  }
  override def insert(unsaved: UsersRow): ConnectionIO[UsersRow] = {
    sql"""insert into public.users("user_id", "name", "last_name", "email", "password", "created_at", "verified_on")
          values (${fromWrite(unsaved.userId)(Write.fromPut(UsersId.put))}::uuid, ${fromWrite(unsaved.name)(Write.fromPut(Meta.StringMeta.put))}, ${fromWrite(unsaved.lastName)(Write.fromPutOption(Meta.StringMeta.put))}, ${fromWrite(unsaved.email)(Write.fromPut(TypoUnknownCitext.put))}::citext, ${fromWrite(unsaved.password)(Write.fromPut(Meta.StringMeta.put))}, ${fromWrite(unsaved.createdAt)(Write.fromPut(TypoInstant.put))}::timestamptz, ${fromWrite(unsaved.verifiedOn)(Write.fromPutOption(TypoInstant.put))}::timestamptz)
          returning "user_id", "name", "last_name", "email"::text, "password", "created_at"::text, "verified_on"::text
       """.query(using UsersRow.read).unique
  }
  override def insertStreaming(unsaved: Stream[ConnectionIO, UsersRow], batchSize: Int): ConnectionIO[Long] = {
    new FragmentOps(sql"""COPY public.users("user_id", "name", "last_name", "email", "password", "created_at", "verified_on") FROM STDIN""").copyIn(unsaved, batchSize)(using UsersRow.text)
  }
  override def insert(unsaved: UsersRowUnsaved): ConnectionIO[UsersRow] = {
    val fs = List(
      Some((Fragment.const(s""""user_id""""), fr"${fromWrite(unsaved.userId)(Write.fromPut(UsersId.put))}::uuid")),
      Some((Fragment.const(s""""name""""), fr"${fromWrite(unsaved.name)(Write.fromPut(Meta.StringMeta.put))}")),
      Some((Fragment.const(s""""last_name""""), fr"${fromWrite(unsaved.lastName)(Write.fromPutOption(Meta.StringMeta.put))}")),
      Some((Fragment.const(s""""email""""), fr"${fromWrite(unsaved.email)(Write.fromPut(TypoUnknownCitext.put))}::citext")),
      Some((Fragment.const(s""""password""""), fr"${fromWrite(unsaved.password)(Write.fromPut(Meta.StringMeta.put))}")),
      Some((Fragment.const(s""""verified_on""""), fr"${fromWrite(unsaved.verifiedOn)(Write.fromPutOption(TypoInstant.put))}::timestamptz")),
      unsaved.createdAt match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s""""created_at""""), fr"${fromWrite(value: TypoInstant)(Write.fromPut(TypoInstant.put))}::timestamptz"))
      }
    ).flatten
    
    val q = if (fs.isEmpty) {
      sql"""insert into public.users default values
            returning "user_id", "name", "last_name", "email"::text, "password", "created_at"::text, "verified_on"::text
         """
    } else {
      val CommaSeparate = Fragment.FragmentMonoid.intercalate(fr", ")
      sql"""insert into public.users(${CommaSeparate.combineAllOption(fs.map { case (n, _) => n }).get})
            values (${CommaSeparate.combineAllOption(fs.map { case (_, f) => f }).get})
            returning "user_id", "name", "last_name", "email"::text, "password", "created_at"::text, "verified_on"::text
         """
    }
    q.query(using UsersRow.read).unique
    
  }
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  override def insertUnsavedStreaming(unsaved: Stream[ConnectionIO, UsersRowUnsaved], batchSize: Int): ConnectionIO[Long] = {
    new FragmentOps(sql"""COPY public.users("user_id", "name", "last_name", "email", "password", "verified_on", "created_at") FROM STDIN (DEFAULT '__DEFAULT_VALUE__')""").copyIn(unsaved, batchSize)(using UsersRowUnsaved.text)
  }
  override def select: SelectBuilder[UsersFields, UsersRow] = {
    SelectBuilderSql("public.users", UsersFields.structure, UsersRow.read)
  }
  override def selectAll: Stream[ConnectionIO, UsersRow] = {
    sql"""select "user_id", "name", "last_name", "email"::text, "password", "created_at"::text, "verified_on"::text from public.users""".query(using UsersRow.read).stream
  }
  override def selectById(userId: UsersId): ConnectionIO[Option[UsersRow]] = {
    sql"""select "user_id", "name", "last_name", "email"::text, "password", "created_at"::text, "verified_on"::text from public.users where "user_id" = ${fromWrite(userId)(Write.fromPut(UsersId.put))}""".query(using UsersRow.read).option
  }
  override def selectByIds(userIds: Array[UsersId]): Stream[ConnectionIO, UsersRow] = {
    sql"""select "user_id", "name", "last_name", "email"::text, "password", "created_at"::text, "verified_on"::text from public.users where "user_id" = ANY(${userIds})""".query(using UsersRow.read).stream
  }
  override def selectByUnique(email: TypoUnknownCitext): ConnectionIO[Option[UsersRow]] = {
    sql"""select "user_id", "name", "last_name", "email"::text, "password", "created_at"::text, "verified_on"::text
          from public.users
          where "email" = ${fromWrite(email)(Write.fromPut(TypoUnknownCitext.put))}
       """.query(using UsersRow.read).option
  }
  override def update(row: UsersRow): ConnectionIO[Boolean] = {
    val userId = row.userId
    sql"""update public.users
          set "name" = ${fromWrite(row.name)(Write.fromPut(Meta.StringMeta.put))},
              "last_name" = ${fromWrite(row.lastName)(Write.fromPutOption(Meta.StringMeta.put))},
              "email" = ${fromWrite(row.email)(Write.fromPut(TypoUnknownCitext.put))}::citext,
              "password" = ${fromWrite(row.password)(Write.fromPut(Meta.StringMeta.put))},
              "created_at" = ${fromWrite(row.createdAt)(Write.fromPut(TypoInstant.put))}::timestamptz,
              "verified_on" = ${fromWrite(row.verifiedOn)(Write.fromPutOption(TypoInstant.put))}::timestamptz
          where "user_id" = ${fromWrite(userId)(Write.fromPut(UsersId.put))}"""
      .update
      .run
      .map(_ > 0)
  }
  override def update: UpdateBuilder[UsersFields, UsersRow] = {
    UpdateBuilder("public.users", UsersFields.structure, UsersRow.read)
  }
  override def upsert(unsaved: UsersRow): ConnectionIO[UsersRow] = {
    sql"""insert into public.users("user_id", "name", "last_name", "email", "password", "created_at", "verified_on")
          values (
            ${fromWrite(unsaved.userId)(Write.fromPut(UsersId.put))}::uuid,
            ${fromWrite(unsaved.name)(Write.fromPut(Meta.StringMeta.put))},
            ${fromWrite(unsaved.lastName)(Write.fromPutOption(Meta.StringMeta.put))},
            ${fromWrite(unsaved.email)(Write.fromPut(TypoUnknownCitext.put))}::citext,
            ${fromWrite(unsaved.password)(Write.fromPut(Meta.StringMeta.put))},
            ${fromWrite(unsaved.createdAt)(Write.fromPut(TypoInstant.put))}::timestamptz,
            ${fromWrite(unsaved.verifiedOn)(Write.fromPutOption(TypoInstant.put))}::timestamptz
          )
          on conflict ("user_id")
          do update set
            "name" = EXCLUDED."name",
            "last_name" = EXCLUDED."last_name",
            "email" = EXCLUDED."email",
            "password" = EXCLUDED."password",
            "created_at" = EXCLUDED."created_at",
            "verified_on" = EXCLUDED."verified_on"
          returning "user_id", "name", "last_name", "email"::text, "password", "created_at"::text, "verified_on"::text
       """.query(using UsersRow.read).unique
  }
}
