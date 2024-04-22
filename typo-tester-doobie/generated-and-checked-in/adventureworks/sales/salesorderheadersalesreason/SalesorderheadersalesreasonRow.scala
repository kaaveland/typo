/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package salesorderheadersalesreason

import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.sales.salesorderheader.SalesorderheaderId
import adventureworks.sales.salesreason.SalesreasonId
import doobie.enumerated.Nullability
import doobie.postgres.Text
import doobie.util.Read
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet

/** Table: sales.salesorderheadersalesreason
    Cross-reference table mapping sales orders to sales reason codes.
    Composite primary key: salesorderid, salesreasonid */
case class SalesorderheadersalesreasonRow(
  /** Primary key. Foreign key to SalesOrderHeader.SalesOrderID.
      Points to [[salesorderheader.SalesorderheaderRow.salesorderid]] */
  salesorderid: SalesorderheaderId,
  /** Primary key. Foreign key to SalesReason.SalesReasonID.
      Points to [[salesreason.SalesreasonRow.salesreasonid]] */
  salesreasonid: SalesreasonId,
  /** Default: now() */
  modifieddate: TypoLocalDateTime
){
   val compositeId: SalesorderheadersalesreasonId = SalesorderheadersalesreasonId(salesorderid, salesreasonid)
 }

object SalesorderheadersalesreasonRow {
  implicit lazy val decoder: Decoder[SalesorderheadersalesreasonRow] = Decoder.forProduct3[SalesorderheadersalesreasonRow, SalesorderheaderId, SalesreasonId, TypoLocalDateTime]("salesorderid", "salesreasonid", "modifieddate")(SalesorderheadersalesreasonRow.apply)(SalesorderheaderId.decoder, SalesreasonId.decoder, TypoLocalDateTime.decoder)
  implicit lazy val encoder: Encoder[SalesorderheadersalesreasonRow] = Encoder.forProduct3[SalesorderheadersalesreasonRow, SalesorderheaderId, SalesreasonId, TypoLocalDateTime]("salesorderid", "salesreasonid", "modifieddate")(x => (x.salesorderid, x.salesreasonid, x.modifieddate))(SalesorderheaderId.encoder, SalesreasonId.encoder, TypoLocalDateTime.encoder)
  implicit lazy val read: Read[SalesorderheadersalesreasonRow] = new Read[SalesorderheadersalesreasonRow](
    gets = List(
      (SalesorderheaderId.get, Nullability.NoNulls),
      (SalesreasonId.get, Nullability.NoNulls),
      (TypoLocalDateTime.get, Nullability.NoNulls)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => SalesorderheadersalesreasonRow(
      salesorderid = SalesorderheaderId.get.unsafeGetNonNullable(rs, i + 0),
      salesreasonid = SalesreasonId.get.unsafeGetNonNullable(rs, i + 1),
      modifieddate = TypoLocalDateTime.get.unsafeGetNonNullable(rs, i + 2)
    )
  )
  implicit lazy val text: Text[SalesorderheadersalesreasonRow] = Text.instance[SalesorderheadersalesreasonRow]{ (row, sb) =>
    SalesorderheaderId.text.unsafeEncode(row.salesorderid, sb)
    sb.append(Text.DELIMETER)
    SalesreasonId.text.unsafeEncode(row.salesreasonid, sb)
    sb.append(Text.DELIMETER)
    TypoLocalDateTime.text.unsafeEncode(row.modifieddate, sb)
  }
}
