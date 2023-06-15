/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pr
package pdoc

import adventureworks.production.document.DocumentId
import adventureworks.production.product.ProductId
import doobie.Get
import doobie.Read
import doobie.enumerated.Nullability
import doobie.free.connection.ConnectionIO
import doobie.syntax.string.toSqlInterpolator
import doobie.util.fragments
import fs2.Stream
import java.sql.ResultSet
import java.time.LocalDateTime

object PdocViewRepoImpl extends PdocViewRepo {
  override def selectAll: Stream[ConnectionIO, PdocViewRow] = {
    sql"""select "id", productid, modifieddate, documentnode from pr.pdoc""".query[PdocViewRow].stream
  }
  override def selectByFieldValues(fieldValues: List[PdocViewFieldOrIdValue[_]]): Stream[ConnectionIO, PdocViewRow] = {
    val where = fragments.whereAnd(
      fieldValues.map {
        case PdocViewFieldValue.id(value) => fr""""id" = $value"""
        case PdocViewFieldValue.productid(value) => fr"productid = $value"
        case PdocViewFieldValue.modifieddate(value) => fr"modifieddate = $value"
        case PdocViewFieldValue.documentnode(value) => fr"documentnode = $value"
      } :_*
    )
    sql"select * from pr.pdoc $where".query[PdocViewRow].stream
  
  }
  implicit val read: Read[PdocViewRow] =
    new Read[PdocViewRow](
      gets = List(
        (Get[Int], Nullability.Nullable),
        (Get[ProductId], Nullability.Nullable),
        (Get[LocalDateTime], Nullability.Nullable),
        (Get[DocumentId], Nullability.Nullable)
      ),
      unsafeGet = (rs: ResultSet, i: Int) => PdocViewRow(
        id = Get[Int].unsafeGetNullable(rs, i + 0),
        productid = Get[ProductId].unsafeGetNullable(rs, i + 1),
        modifieddate = Get[LocalDateTime].unsafeGetNullable(rs, i + 2),
        documentnode = Get[DocumentId].unsafeGetNullable(rs, i + 3)
      )
    )
  

}