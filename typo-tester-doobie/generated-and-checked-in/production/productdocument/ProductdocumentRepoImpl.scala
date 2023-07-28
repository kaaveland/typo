/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package productdocument

import adventureworks.Defaulted
import adventureworks.production.document.DocumentId
import doobie.free.connection.ConnectionIO
import doobie.syntax.string.toSqlInterpolator
import doobie.util.fragment.Fragment
import fs2.Stream
import java.time.LocalDateTime

object ProductdocumentRepoImpl extends ProductdocumentRepo {
  override def delete(compositeId: ProductdocumentId): ConnectionIO[Boolean] = {
    sql"delete from production.productdocument where productid = ${compositeId.productid} AND documentnode = ${compositeId.documentnode}".update.run.map(_ > 0)
  }
  override def insert(unsaved: ProductdocumentRow): ConnectionIO[ProductdocumentRow] = {
    sql"""insert into production.productdocument(productid, modifieddate, documentnode)
          values (${unsaved.productid}::int4, ${unsaved.modifieddate}::timestamp, ${unsaved.documentnode})
          returning productid, modifieddate, documentnode
       """.query[ProductdocumentRow].unique
  }
  override def insert(unsaved: ProductdocumentRowUnsaved): ConnectionIO[ProductdocumentRow] = {
    val fs = List(
      Some((Fragment.const(s"productid"), fr"${unsaved.productid}::int4")),
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s"modifieddate"), fr"${value: LocalDateTime}::timestamp"))
      },
      unsaved.documentnode match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s"documentnode"), fr"${value: DocumentId}"))
      }
    ).flatten
    
    val q = if (fs.isEmpty) {
      sql"""insert into production.productdocument default values
            returning productid, modifieddate, documentnode
         """
    } else {
      import cats.syntax.foldable.toFoldableOps
      sql"""insert into production.productdocument(${fs.map { case (n, _) => n }.intercalate(fr", ")})
            values (${fs.map { case (_, f) => f }.intercalate(fr", ")})
            returning productid, modifieddate, documentnode
         """
    }
    q.query[ProductdocumentRow].unique
  
  }
  override def selectAll: Stream[ConnectionIO, ProductdocumentRow] = {
    sql"select productid, modifieddate, documentnode from production.productdocument".query[ProductdocumentRow].stream
  }
  override def selectById(compositeId: ProductdocumentId): ConnectionIO[Option[ProductdocumentRow]] = {
    sql"select productid, modifieddate, documentnode from production.productdocument where productid = ${compositeId.productid} AND documentnode = ${compositeId.documentnode}".query[ProductdocumentRow].option
  }
  override def update(row: ProductdocumentRow): ConnectionIO[Boolean] = {
    val compositeId = row.compositeId
    sql"""update production.productdocument
          set modifieddate = ${row.modifieddate}::timestamp
          where productid = ${compositeId.productid} AND documentnode = ${compositeId.documentnode}
       """
      .update
      .run
      .map(_ > 0)
  }
  override def upsert(unsaved: ProductdocumentRow): ConnectionIO[ProductdocumentRow] = {
    sql"""insert into production.productdocument(productid, modifieddate, documentnode)
          values (
            ${unsaved.productid}::int4,
            ${unsaved.modifieddate}::timestamp,
            ${unsaved.documentnode}
          )
          on conflict (productid, documentnode)
          do update set
            modifieddate = EXCLUDED.modifieddate
          returning productid, modifieddate, documentnode
       """.query[ProductdocumentRow].unique
  }
}
