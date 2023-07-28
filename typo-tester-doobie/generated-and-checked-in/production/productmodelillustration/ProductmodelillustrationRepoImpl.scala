/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package productmodelillustration

import adventureworks.Defaulted
import doobie.free.connection.ConnectionIO
import doobie.syntax.string.toSqlInterpolator
import doobie.util.fragment.Fragment
import fs2.Stream
import java.time.LocalDateTime

object ProductmodelillustrationRepoImpl extends ProductmodelillustrationRepo {
  override def delete(compositeId: ProductmodelillustrationId): ConnectionIO[Boolean] = {
    sql"delete from production.productmodelillustration where productmodelid = ${compositeId.productmodelid} AND illustrationid = ${compositeId.illustrationid}".update.run.map(_ > 0)
  }
  override def insert(unsaved: ProductmodelillustrationRow): ConnectionIO[ProductmodelillustrationRow] = {
    sql"""insert into production.productmodelillustration(productmodelid, illustrationid, modifieddate)
          values (${unsaved.productmodelid}::int4, ${unsaved.illustrationid}::int4, ${unsaved.modifieddate}::timestamp)
          returning productmodelid, illustrationid, modifieddate
       """.query[ProductmodelillustrationRow].unique
  }
  override def insert(unsaved: ProductmodelillustrationRowUnsaved): ConnectionIO[ProductmodelillustrationRow] = {
    val fs = List(
      Some((Fragment.const(s"productmodelid"), fr"${unsaved.productmodelid}::int4")),
      Some((Fragment.const(s"illustrationid"), fr"${unsaved.illustrationid}::int4")),
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s"modifieddate"), fr"${value: LocalDateTime}::timestamp"))
      }
    ).flatten
    
    val q = if (fs.isEmpty) {
      sql"""insert into production.productmodelillustration default values
            returning productmodelid, illustrationid, modifieddate
         """
    } else {
      import cats.syntax.foldable.toFoldableOps
      sql"""insert into production.productmodelillustration(${fs.map { case (n, _) => n }.intercalate(fr", ")})
            values (${fs.map { case (_, f) => f }.intercalate(fr", ")})
            returning productmodelid, illustrationid, modifieddate
         """
    }
    q.query[ProductmodelillustrationRow].unique
  
  }
  override def selectAll: Stream[ConnectionIO, ProductmodelillustrationRow] = {
    sql"select productmodelid, illustrationid, modifieddate from production.productmodelillustration".query[ProductmodelillustrationRow].stream
  }
  override def selectById(compositeId: ProductmodelillustrationId): ConnectionIO[Option[ProductmodelillustrationRow]] = {
    sql"select productmodelid, illustrationid, modifieddate from production.productmodelillustration where productmodelid = ${compositeId.productmodelid} AND illustrationid = ${compositeId.illustrationid}".query[ProductmodelillustrationRow].option
  }
  override def update(row: ProductmodelillustrationRow): ConnectionIO[Boolean] = {
    val compositeId = row.compositeId
    sql"""update production.productmodelillustration
          set modifieddate = ${row.modifieddate}::timestamp
          where productmodelid = ${compositeId.productmodelid} AND illustrationid = ${compositeId.illustrationid}
       """
      .update
      .run
      .map(_ > 0)
  }
  override def upsert(unsaved: ProductmodelillustrationRow): ConnectionIO[ProductmodelillustrationRow] = {
    sql"""insert into production.productmodelillustration(productmodelid, illustrationid, modifieddate)
          values (
            ${unsaved.productmodelid}::int4,
            ${unsaved.illustrationid}::int4,
            ${unsaved.modifieddate}::timestamp
          )
          on conflict (productmodelid, illustrationid)
          do update set
            modifieddate = EXCLUDED.modifieddate
          returning productmodelid, illustrationid, modifieddate
       """.query[ProductmodelillustrationRow].unique
  }
}
