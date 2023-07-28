/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package culture

import adventureworks.Defaulted
import doobie.free.connection.ConnectionIO
import doobie.syntax.string.toSqlInterpolator
import doobie.util.fragment.Fragment
import fs2.Stream
import java.time.LocalDateTime

object CultureRepoImpl extends CultureRepo {
  override def delete(cultureid: CultureId): ConnectionIO[Boolean] = {
    sql"delete from production.culture where cultureid = $cultureid".update.run.map(_ > 0)
  }
  override def insert(unsaved: CultureRow): ConnectionIO[CultureRow] = {
    sql"""insert into production.culture(cultureid, "name", modifieddate)
          values (${unsaved.cultureid}::bpchar, ${unsaved.name}::"public"."Name", ${unsaved.modifieddate}::timestamp)
          returning cultureid, "name", modifieddate
       """.query[CultureRow].unique
  }
  override def insert(unsaved: CultureRowUnsaved): ConnectionIO[CultureRow] = {
    val fs = List(
      Some((Fragment.const(s"cultureid"), fr"${unsaved.cultureid}::bpchar")),
      Some((Fragment.const(s""""name""""), fr"""${unsaved.name}::"public"."Name"""")),
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s"modifieddate"), fr"${value: LocalDateTime}::timestamp"))
      }
    ).flatten
    
    val q = if (fs.isEmpty) {
      sql"""insert into production.culture default values
            returning cultureid, "name", modifieddate
         """
    } else {
      import cats.syntax.foldable.toFoldableOps
      sql"""insert into production.culture(${fs.map { case (n, _) => n }.intercalate(fr", ")})
            values (${fs.map { case (_, f) => f }.intercalate(fr", ")})
            returning cultureid, "name", modifieddate
         """
    }
    q.query[CultureRow].unique
  
  }
  override def selectAll: Stream[ConnectionIO, CultureRow] = {
    sql"""select cultureid, "name", modifieddate from production.culture""".query[CultureRow].stream
  }
  override def selectById(cultureid: CultureId): ConnectionIO[Option[CultureRow]] = {
    sql"""select cultureid, "name", modifieddate from production.culture where cultureid = $cultureid""".query[CultureRow].option
  }
  override def selectByIds(cultureids: Array[CultureId]): Stream[ConnectionIO, CultureRow] = {
    sql"""select cultureid, "name", modifieddate from production.culture where cultureid = ANY($cultureids)""".query[CultureRow].stream
  }
  override def update(row: CultureRow): ConnectionIO[Boolean] = {
    val cultureid = row.cultureid
    sql"""update production.culture
          set "name" = ${row.name}::"public"."Name",
              modifieddate = ${row.modifieddate}::timestamp
          where cultureid = $cultureid
       """
      .update
      .run
      .map(_ > 0)
  }
  override def upsert(unsaved: CultureRow): ConnectionIO[CultureRow] = {
    sql"""insert into production.culture(cultureid, "name", modifieddate)
          values (
            ${unsaved.cultureid}::bpchar,
            ${unsaved.name}::"public"."Name",
            ${unsaved.modifieddate}::timestamp
          )
          on conflict (cultureid)
          do update set
            "name" = EXCLUDED."name",
            modifieddate = EXCLUDED.modifieddate
          returning cultureid, "name", modifieddate
       """.query[CultureRow].unique
  }
}
