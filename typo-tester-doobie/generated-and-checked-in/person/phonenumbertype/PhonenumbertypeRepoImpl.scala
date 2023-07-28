/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package person
package phonenumbertype

import adventureworks.Defaulted
import doobie.free.connection.ConnectionIO
import doobie.syntax.string.toSqlInterpolator
import doobie.util.fragment.Fragment
import fs2.Stream
import java.time.LocalDateTime

object PhonenumbertypeRepoImpl extends PhonenumbertypeRepo {
  override def delete(phonenumbertypeid: PhonenumbertypeId): ConnectionIO[Boolean] = {
    sql"delete from person.phonenumbertype where phonenumbertypeid = $phonenumbertypeid".update.run.map(_ > 0)
  }
  override def insert(unsaved: PhonenumbertypeRow): ConnectionIO[PhonenumbertypeRow] = {
    sql"""insert into person.phonenumbertype(phonenumbertypeid, "name", modifieddate)
          values (${unsaved.phonenumbertypeid}::int4, ${unsaved.name}::"public"."Name", ${unsaved.modifieddate}::timestamp)
          returning phonenumbertypeid, "name", modifieddate
       """.query[PhonenumbertypeRow].unique
  }
  override def insert(unsaved: PhonenumbertypeRowUnsaved): ConnectionIO[PhonenumbertypeRow] = {
    val fs = List(
      Some((Fragment.const(s""""name""""), fr"""${unsaved.name}::"public"."Name"""")),
      unsaved.phonenumbertypeid match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s"phonenumbertypeid"), fr"${value: PhonenumbertypeId}::int4"))
      },
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s"modifieddate"), fr"${value: LocalDateTime}::timestamp"))
      }
    ).flatten
    
    val q = if (fs.isEmpty) {
      sql"""insert into person.phonenumbertype default values
            returning phonenumbertypeid, "name", modifieddate
         """
    } else {
      import cats.syntax.foldable.toFoldableOps
      sql"""insert into person.phonenumbertype(${fs.map { case (n, _) => n }.intercalate(fr", ")})
            values (${fs.map { case (_, f) => f }.intercalate(fr", ")})
            returning phonenumbertypeid, "name", modifieddate
         """
    }
    q.query[PhonenumbertypeRow].unique
  
  }
  override def selectAll: Stream[ConnectionIO, PhonenumbertypeRow] = {
    sql"""select phonenumbertypeid, "name", modifieddate from person.phonenumbertype""".query[PhonenumbertypeRow].stream
  }
  override def selectById(phonenumbertypeid: PhonenumbertypeId): ConnectionIO[Option[PhonenumbertypeRow]] = {
    sql"""select phonenumbertypeid, "name", modifieddate from person.phonenumbertype where phonenumbertypeid = $phonenumbertypeid""".query[PhonenumbertypeRow].option
  }
  override def selectByIds(phonenumbertypeids: Array[PhonenumbertypeId]): Stream[ConnectionIO, PhonenumbertypeRow] = {
    sql"""select phonenumbertypeid, "name", modifieddate from person.phonenumbertype where phonenumbertypeid = ANY($phonenumbertypeids)""".query[PhonenumbertypeRow].stream
  }
  override def update(row: PhonenumbertypeRow): ConnectionIO[Boolean] = {
    val phonenumbertypeid = row.phonenumbertypeid
    sql"""update person.phonenumbertype
          set "name" = ${row.name}::"public"."Name",
              modifieddate = ${row.modifieddate}::timestamp
          where phonenumbertypeid = $phonenumbertypeid
       """
      .update
      .run
      .map(_ > 0)
  }
  override def upsert(unsaved: PhonenumbertypeRow): ConnectionIO[PhonenumbertypeRow] = {
    sql"""insert into person.phonenumbertype(phonenumbertypeid, "name", modifieddate)
          values (
            ${unsaved.phonenumbertypeid}::int4,
            ${unsaved.name}::"public"."Name",
            ${unsaved.modifieddate}::timestamp
          )
          on conflict (phonenumbertypeid)
          do update set
            "name" = EXCLUDED."name",
            modifieddate = EXCLUDED.modifieddate
          returning phonenumbertypeid, "name", modifieddate
       """.query[PhonenumbertypeRow].unique
  }
}
