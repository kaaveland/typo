/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pr
package th

import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.production.product.ProductId
import adventureworks.production.transactionhistory.TransactionhistoryId
import doobie.enumerated.Nullability
import doobie.util.Read
import doobie.util.meta.Meta
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet

/** View: pr.th */
case class ThViewRow(
  /** Points to [[production.transactionhistory.TransactionhistoryRow.transactionid]] */
  id: TransactionhistoryId,
  /** Points to [[production.transactionhistory.TransactionhistoryRow.transactionid]] */
  transactionid: TransactionhistoryId,
  /** Points to [[production.transactionhistory.TransactionhistoryRow.productid]] */
  productid: ProductId,
  /** Points to [[production.transactionhistory.TransactionhistoryRow.referenceorderid]] */
  referenceorderid: Int,
  /** Points to [[production.transactionhistory.TransactionhistoryRow.referenceorderlineid]] */
  referenceorderlineid: Int,
  /** Points to [[production.transactionhistory.TransactionhistoryRow.transactiondate]] */
  transactiondate: TypoLocalDateTime,
  /** Points to [[production.transactionhistory.TransactionhistoryRow.transactiontype]] */
  transactiontype: /* bpchar, max 1 chars */ String,
  /** Points to [[production.transactionhistory.TransactionhistoryRow.quantity]] */
  quantity: Int,
  /** Points to [[production.transactionhistory.TransactionhistoryRow.actualcost]] */
  actualcost: BigDecimal,
  /** Points to [[production.transactionhistory.TransactionhistoryRow.modifieddate]] */
  modifieddate: TypoLocalDateTime
)

object ThViewRow {
  implicit lazy val decoder: Decoder[ThViewRow] = Decoder.forProduct10[ThViewRow, TransactionhistoryId, TransactionhistoryId, ProductId, Int, Int, TypoLocalDateTime, /* bpchar, max 1 chars */ String, Int, BigDecimal, TypoLocalDateTime]("id", "transactionid", "productid", "referenceorderid", "referenceorderlineid", "transactiondate", "transactiontype", "quantity", "actualcost", "modifieddate")(ThViewRow.apply)(TransactionhistoryId.decoder, TransactionhistoryId.decoder, ProductId.decoder, Decoder.decodeInt, Decoder.decodeInt, TypoLocalDateTime.decoder, Decoder.decodeString, Decoder.decodeInt, Decoder.decodeBigDecimal, TypoLocalDateTime.decoder)
  implicit lazy val encoder: Encoder[ThViewRow] = Encoder.forProduct10[ThViewRow, TransactionhistoryId, TransactionhistoryId, ProductId, Int, Int, TypoLocalDateTime, /* bpchar, max 1 chars */ String, Int, BigDecimal, TypoLocalDateTime]("id", "transactionid", "productid", "referenceorderid", "referenceorderlineid", "transactiondate", "transactiontype", "quantity", "actualcost", "modifieddate")(x => (x.id, x.transactionid, x.productid, x.referenceorderid, x.referenceorderlineid, x.transactiondate, x.transactiontype, x.quantity, x.actualcost, x.modifieddate))(TransactionhistoryId.encoder, TransactionhistoryId.encoder, ProductId.encoder, Encoder.encodeInt, Encoder.encodeInt, TypoLocalDateTime.encoder, Encoder.encodeString, Encoder.encodeInt, Encoder.encodeBigDecimal, TypoLocalDateTime.encoder)
  implicit lazy val read: Read[ThViewRow] = new Read[ThViewRow](
    gets = List(
      (TransactionhistoryId.get, Nullability.NoNulls),
      (TransactionhistoryId.get, Nullability.NoNulls),
      (ProductId.get, Nullability.NoNulls),
      (Meta.IntMeta.get, Nullability.NoNulls),
      (Meta.IntMeta.get, Nullability.NoNulls),
      (TypoLocalDateTime.get, Nullability.NoNulls),
      (Meta.StringMeta.get, Nullability.NoNulls),
      (Meta.IntMeta.get, Nullability.NoNulls),
      (Meta.ScalaBigDecimalMeta.get, Nullability.NoNulls),
      (TypoLocalDateTime.get, Nullability.NoNulls)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => ThViewRow(
      id = TransactionhistoryId.get.unsafeGetNonNullable(rs, i + 0),
      transactionid = TransactionhistoryId.get.unsafeGetNonNullable(rs, i + 1),
      productid = ProductId.get.unsafeGetNonNullable(rs, i + 2),
      referenceorderid = Meta.IntMeta.get.unsafeGetNonNullable(rs, i + 3),
      referenceorderlineid = Meta.IntMeta.get.unsafeGetNonNullable(rs, i + 4),
      transactiondate = TypoLocalDateTime.get.unsafeGetNonNullable(rs, i + 5),
      transactiontype = Meta.StringMeta.get.unsafeGetNonNullable(rs, i + 6),
      quantity = Meta.IntMeta.get.unsafeGetNonNullable(rs, i + 7),
      actualcost = Meta.ScalaBigDecimalMeta.get.unsafeGetNonNullable(rs, i + 8),
      modifieddate = TypoLocalDateTime.get.unsafeGetNonNullable(rs, i + 9)
    )
  )
}
