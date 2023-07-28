/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package productproductphoto

import adventureworks.Defaulted
import adventureworks.public.Flag
import doobie.free.connection.ConnectionIO
import doobie.syntax.string.toSqlInterpolator
import doobie.util.fragment.Fragment
import fs2.Stream
import java.time.LocalDateTime

object ProductproductphotoRepoImpl extends ProductproductphotoRepo {
  override def delete(compositeId: ProductproductphotoId): ConnectionIO[Boolean] = {
    sql"delete from production.productproductphoto where productid = ${compositeId.productid} AND productphotoid = ${compositeId.productphotoid}".update.run.map(_ > 0)
  }
  override def insert(unsaved: ProductproductphotoRow): ConnectionIO[ProductproductphotoRow] = {
    sql"""insert into production.productproductphoto(productid, productphotoid, "primary", modifieddate)
          values (${unsaved.productid}::int4, ${unsaved.productphotoid}::int4, ${unsaved.primary}::"public"."Flag", ${unsaved.modifieddate}::timestamp)
          returning productid, productphotoid, "primary", modifieddate
       """.query[ProductproductphotoRow].unique
  }
  override def insert(unsaved: ProductproductphotoRowUnsaved): ConnectionIO[ProductproductphotoRow] = {
    val fs = List(
      Some((Fragment.const(s"productid"), fr"${unsaved.productid}::int4")),
      Some((Fragment.const(s"productphotoid"), fr"${unsaved.productphotoid}::int4")),
      unsaved.primary match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s""""primary""""), fr"""${value: Flag}::"public"."Flag""""))
      },
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s"modifieddate"), fr"${value: LocalDateTime}::timestamp"))
      }
    ).flatten
    
    val q = if (fs.isEmpty) {
      sql"""insert into production.productproductphoto default values
            returning productid, productphotoid, "primary", modifieddate
         """
    } else {
      import cats.syntax.foldable.toFoldableOps
      sql"""insert into production.productproductphoto(${fs.map { case (n, _) => n }.intercalate(fr", ")})
            values (${fs.map { case (_, f) => f }.intercalate(fr", ")})
            returning productid, productphotoid, "primary", modifieddate
         """
    }
    q.query[ProductproductphotoRow].unique
  
  }
  override def selectAll: Stream[ConnectionIO, ProductproductphotoRow] = {
    sql"""select productid, productphotoid, "primary", modifieddate from production.productproductphoto""".query[ProductproductphotoRow].stream
  }
  override def selectById(compositeId: ProductproductphotoId): ConnectionIO[Option[ProductproductphotoRow]] = {
    sql"""select productid, productphotoid, "primary", modifieddate from production.productproductphoto where productid = ${compositeId.productid} AND productphotoid = ${compositeId.productphotoid}""".query[ProductproductphotoRow].option
  }
  override def update(row: ProductproductphotoRow): ConnectionIO[Boolean] = {
    val compositeId = row.compositeId
    sql"""update production.productproductphoto
          set "primary" = ${row.primary}::"public"."Flag",
              modifieddate = ${row.modifieddate}::timestamp
          where productid = ${compositeId.productid} AND productphotoid = ${compositeId.productphotoid}
       """
      .update
      .run
      .map(_ > 0)
  }
  override def upsert(unsaved: ProductproductphotoRow): ConnectionIO[ProductproductphotoRow] = {
    sql"""insert into production.productproductphoto(productid, productphotoid, "primary", modifieddate)
          values (
            ${unsaved.productid}::int4,
            ${unsaved.productphotoid}::int4,
            ${unsaved.primary}::"public"."Flag",
            ${unsaved.modifieddate}::timestamp
          )
          on conflict (productid, productphotoid)
          do update set
            "primary" = EXCLUDED."primary",
            modifieddate = EXCLUDED.modifieddate
          returning productid, productphotoid, "primary", modifieddate
       """.query[ProductproductphotoRow].unique
  }
}
