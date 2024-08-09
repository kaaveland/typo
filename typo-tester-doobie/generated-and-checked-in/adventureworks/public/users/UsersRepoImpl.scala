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
import cats.instances.list.catsStdInstancesForList
import doobie.free.connection.ConnectionIO
import doobie.postgres.syntax.FragmentOps
import doobie.syntax.SqlInterpolator.SingleFragment.fromWrite
import doobie.syntax.string.toSqlInterpolator
import doobie.util.Write
import doobie.util.fragment.Fragment
import doobie.util.meta.Meta
import doobie.util.update.Update
import fs2.Stream
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql
import typo.dsl.UpdateBuilder

class UsersRepoImpl extends UsersRepo {
  override def delete: DeleteBuilder[UsersFields, UsersRow] = {
    DeleteBuilder(""""public"."users"""", UsersFields.structure)
  }
  override def deleteById(userId: UsersId): ConnectionIO[Boolean] = {
    sql"""delete from "public"."users" where "user_id" = ${fromWrite(userId)(Write.fromPut(UsersId.put))}""".update.run.map(_ > 0)
  }
  override def deleteByIds(userIds: Array[UsersId]): ConnectionIO[Int] = {
    sql"""delete from "public"."users" where "user_id" = ANY(${userIds})""".update.run
  }
  override def insert(unsaved: UsersRow): ConnectionIO[UsersRow] = {
    sql"""insert into "public"."users"("user_id", "name", "last_name", "email", "password", "created_at", "verified_on")
          values (${fromWrite(unsaved.userId)(Write.fromPut(UsersId.put))}::uuid, ${fromWrite(unsaved.name)(Write.fromPut(Meta.StringMeta.put))}, ${fromWrite(unsaved.lastName)(Write.fromPutOption(Meta.StringMeta.put))}, ${fromWrite(unsaved.email)(Write.fromPut(TypoUnknownCitext.put))}::citext, ${fromWrite(unsaved.password)(Write.fromPut(Meta.StringMeta.put))}, ${fromWrite(unsaved.createdAt)(Write.fromPut(TypoInstant.put))}::timestamptz, ${fromWrite(unsaved.verifiedOn)(Write.fromPutOption(TypoInstant.put))}::timestamptz)
          returning "user_id", "name", "last_name", "email"::text, "password", "created_at"::text, "verified_on"::text
       """.query(using UsersRow.read).unique
  }
  override def insert(unsaved: UsersRowUnsaved): ConnectionIO[UsersRow] = {
    val fs = List(
      Some((Fragment.const0(s""""user_id""""), fr"${fromWrite(unsaved.userId)(Write.fromPut(UsersId.put))}::uuid")),
      Some((Fragment.const0(s""""name""""), fr"${fromWrite(unsaved.name)(Write.fromPut(Meta.StringMeta.put))}")),
      Some((Fragment.const0(s""""last_name""""), fr"${fromWrite(unsaved.lastName)(Write.fromPutOption(Meta.StringMeta.put))}")),
      Some((Fragment.const0(s""""email""""), fr"${fromWrite(unsaved.email)(Write.fromPut(TypoUnknownCitext.put))}::citext")),
      Some((Fragment.const0(s""""password""""), fr"${fromWrite(unsaved.password)(Write.fromPut(Meta.StringMeta.put))}")),
      Some((Fragment.const0(s""""verified_on""""), fr"${fromWrite(unsaved.verifiedOn)(Write.fromPutOption(TypoInstant.put))}::timestamptz")),
      unsaved.createdAt match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const0(s""""created_at""""), fr"${fromWrite(value: TypoInstant)(Write.fromPut(TypoInstant.put))}::timestamptz"))
      }
    ).flatten
    
    val q = if (fs.isEmpty) {
      sql"""insert into "public"."users" default values
            returning "user_id", "name", "last_name", "email"::text, "password", "created_at"::text, "verified_on"::text
         """
    } else {
      val CommaSeparate = Fragment.FragmentMonoid.intercalate(fr", ")
      sql"""insert into "public"."users"(${CommaSeparate.combineAllOption(fs.map { case (n, _) => n }).get})
            values (${CommaSeparate.combineAllOption(fs.map { case (_, f) => f }).get})
            returning "user_id", "name", "last_name", "email"::text, "password", "created_at"::text, "verified_on"::text
         """
    }
    q.query(using UsersRow.read).unique
    
  }
  override def insertStreaming(unsaved: Stream[ConnectionIO, UsersRow], batchSize: Int = 10000): ConnectionIO[Long] = {
    new FragmentOps(sql"""COPY "public"."users"("user_id", "name", "last_name", "email", "password", "created_at", "verified_on") FROM STDIN""").copyIn(unsaved, batchSize)(using UsersRow.text)
  }
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  override def insertUnsavedStreaming(unsaved: Stream[ConnectionIO, UsersRowUnsaved], batchSize: Int = 10000): ConnectionIO[Long] = {
    new FragmentOps(sql"""COPY "public"."users"("user_id", "name", "last_name", "email", "password", "verified_on", "created_at") FROM STDIN (DEFAULT '__DEFAULT_VALUE__')""").copyIn(unsaved, batchSize)(using UsersRowUnsaved.text)
  }
  override def select: SelectBuilder[UsersFields, UsersRow] = {
    SelectBuilderSql(""""public"."users"""", UsersFields.structure, UsersRow.read)
  }
  override def selectAll: Stream[ConnectionIO, UsersRow] = {
    sql"""select "user_id", "name", "last_name", "email"::text, "password", "created_at"::text, "verified_on"::text from "public"."users"""".query(using UsersRow.read).stream
  }
  override def selectById(userId: UsersId): ConnectionIO[Option[UsersRow]] = {
    sql"""select "user_id", "name", "last_name", "email"::text, "password", "created_at"::text, "verified_on"::text from "public"."users" where "user_id" = ${fromWrite(userId)(Write.fromPut(UsersId.put))}""".query(using UsersRow.read).option
  }
  override def selectByIds(userIds: Array[UsersId]): Stream[ConnectionIO, UsersRow] = {
    sql"""select "user_id", "name", "last_name", "email"::text, "password", "created_at"::text, "verified_on"::text from "public"."users" where "user_id" = ANY(${userIds})""".query(using UsersRow.read).stream
  }
  override def selectByIdsTracked(userIds: Array[UsersId]): ConnectionIO[Map[UsersId, UsersRow]] = {
    selectByIds(userIds).compile.toList.map { rows =>
      val byId = rows.view.map(x => (x.userId, x)).toMap
      userIds.view.flatMap(id => byId.get(id).map(x => (id, x))).toMap
    }
  }
  override def selectByUniqueEmail(email: TypoUnknownCitext): ConnectionIO[Option[UsersRow]] = {
    sql"""select "user_id", "name", "last_name", "email"::text, "password", "created_at"::text, "verified_on"::text
          from "public"."users"
          where "email" = ${fromWrite(email)(Write.fromPut(TypoUnknownCitext.put))}
       """.query(using UsersRow.read).option
  }
  override def update: UpdateBuilder[UsersFields, UsersRow] = {
    UpdateBuilder(""""public"."users"""", UsersFields.structure, UsersRow.read)
  }
  override def update(row: UsersRow): ConnectionIO[Boolean] = {
    val userId = row.userId
    sql"""update "public"."users"
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
  override def upsert(unsaved: UsersRow): ConnectionIO[UsersRow] = {
    sql"""insert into "public"."users"("user_id", "name", "last_name", "email", "password", "created_at", "verified_on")
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
  override def upsertBatch(unsaved: List[UsersRow]): Stream[ConnectionIO, UsersRow] = {
    Update[UsersRow](
      s"""insert into "public"."users"("user_id", "name", "last_name", "email", "password", "created_at", "verified_on")
          values (?::uuid,?,?,?::citext,?,?::timestamptz,?::timestamptz)
          on conflict ("user_id")
          do update set
            "name" = EXCLUDED."name",
            "last_name" = EXCLUDED."last_name",
            "email" = EXCLUDED."email",
            "password" = EXCLUDED."password",
            "created_at" = EXCLUDED."created_at",
            "verified_on" = EXCLUDED."verified_on"
          returning "user_id", "name", "last_name", "email"::text, "password", "created_at"::text, "verified_on"::text"""
    )(using UsersRow.write)
    .updateManyWithGeneratedKeys[UsersRow]("user_id", "name", "last_name", "email", "password", "created_at", "verified_on")(unsaved)(using catsStdInstancesForList, UsersRow.read)
  }
  /* NOTE: this functionality is not safe if you use auto-commit mode! it runs 3 SQL statements */
  override def upsertStreaming(unsaved: Stream[ConnectionIO, UsersRow], batchSize: Int = 10000): ConnectionIO[Int] = {
    for {
      _ <- sql"""create temporary table users_TEMP (like "public"."users") on commit drop""".update.run
      _ <- new FragmentOps(sql"""copy users_TEMP("user_id", "name", "last_name", "email", "password", "created_at", "verified_on") from stdin""").copyIn(unsaved, batchSize)(using UsersRow.text)
      res <- sql"""insert into "public"."users"("user_id", "name", "last_name", "email", "password", "created_at", "verified_on")
                   select * from users_TEMP
                   on conflict ("user_id")
                   do update set
                     "name" = EXCLUDED."name",
                     "last_name" = EXCLUDED."last_name",
                     "email" = EXCLUDED."email",
                     "password" = EXCLUDED."password",
                     "created_at" = EXCLUDED."created_at",
                     "verified_on" = EXCLUDED."verified_on"
                   ;
                   drop table users_TEMP;""".update.run
    } yield res
  }
}
