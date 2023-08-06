/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pr
package th

import adventureworks.TypoLocalDateTime
import adventureworks.production.product.ProductId
import adventureworks.production.transactionhistory.TransactionhistoryId
import doobie.enumerated.Nullability
import doobie.util.Read
import doobie.util.meta.Meta
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet

case class ThViewRow(
  id: Option[Int],
  /** Points to [[production.transactionhistory.TransactionhistoryRow.transactionid]] */
  transactionid: Option[TransactionhistoryId],
  /** Points to [[production.transactionhistory.TransactionhistoryRow.productid]] */
  productid: Option[ProductId],
  /** Points to [[production.transactionhistory.TransactionhistoryRow.referenceorderid]] */
  referenceorderid: Option[Int],
  /** Points to [[production.transactionhistory.TransactionhistoryRow.referenceorderlineid]] */
  referenceorderlineid: Option[Int],
  /** Points to [[production.transactionhistory.TransactionhistoryRow.transactiondate]] */
  transactiondate: Option[TypoLocalDateTime],
  /** Points to [[production.transactionhistory.TransactionhistoryRow.transactiontype]] */
  transactiontype: Option[/* bpchar */ String],
  /** Points to [[production.transactionhistory.TransactionhistoryRow.quantity]] */
  quantity: Option[Int],
  /** Points to [[production.transactionhistory.TransactionhistoryRow.actualcost]] */
  actualcost: Option[BigDecimal],
  /** Points to [[production.transactionhistory.TransactionhistoryRow.modifieddate]] */
  modifieddate: Option[TypoLocalDateTime]
)

object ThViewRow {
  implicit lazy val decoder: Decoder[ThViewRow] = Decoder.forProduct10[ThViewRow, Option[Int], Option[TransactionhistoryId], Option[ProductId], Option[Int], Option[Int], Option[TypoLocalDateTime], Option[/* bpchar */ String], Option[Int], Option[BigDecimal], Option[TypoLocalDateTime]]("id", "transactionid", "productid", "referenceorderid", "referenceorderlineid", "transactiondate", "transactiontype", "quantity", "actualcost", "modifieddate")(ThViewRow.apply)(Decoder.decodeOption(Decoder.decodeInt), Decoder.decodeOption(TransactionhistoryId.decoder), Decoder.decodeOption(ProductId.decoder), Decoder.decodeOption(Decoder.decodeInt), Decoder.decodeOption(Decoder.decodeInt), Decoder.decodeOption(TypoLocalDateTime.decoder), Decoder.decodeOption(Decoder.decodeString), Decoder.decodeOption(Decoder.decodeInt), Decoder.decodeOption(Decoder.decodeBigDecimal), Decoder.decodeOption(TypoLocalDateTime.decoder))
  implicit lazy val encoder: Encoder[ThViewRow] = Encoder.forProduct10[ThViewRow, Option[Int], Option[TransactionhistoryId], Option[ProductId], Option[Int], Option[Int], Option[TypoLocalDateTime], Option[/* bpchar */ String], Option[Int], Option[BigDecimal], Option[TypoLocalDateTime]]("id", "transactionid", "productid", "referenceorderid", "referenceorderlineid", "transactiondate", "transactiontype", "quantity", "actualcost", "modifieddate")(x => (x.id, x.transactionid, x.productid, x.referenceorderid, x.referenceorderlineid, x.transactiondate, x.transactiontype, x.quantity, x.actualcost, x.modifieddate))(Encoder.encodeOption(Encoder.encodeInt), Encoder.encodeOption(TransactionhistoryId.encoder), Encoder.encodeOption(ProductId.encoder), Encoder.encodeOption(Encoder.encodeInt), Encoder.encodeOption(Encoder.encodeInt), Encoder.encodeOption(TypoLocalDateTime.encoder), Encoder.encodeOption(Encoder.encodeString), Encoder.encodeOption(Encoder.encodeInt), Encoder.encodeOption(Encoder.encodeBigDecimal), Encoder.encodeOption(TypoLocalDateTime.encoder))
  implicit lazy val read: Read[ThViewRow] = new Read[ThViewRow](
    gets = List(
      (Meta.IntMeta.get, Nullability.Nullable),
      (TransactionhistoryId.get, Nullability.Nullable),
      (ProductId.get, Nullability.Nullable),
      (Meta.IntMeta.get, Nullability.Nullable),
      (Meta.IntMeta.get, Nullability.Nullable),
      (TypoLocalDateTime.get, Nullability.Nullable),
      (Meta.StringMeta.get, Nullability.Nullable),
      (Meta.IntMeta.get, Nullability.Nullable),
      (Meta.ScalaBigDecimalMeta.get, Nullability.Nullable),
      (TypoLocalDateTime.get, Nullability.Nullable)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => ThViewRow(
      id = Meta.IntMeta.get.unsafeGetNullable(rs, i + 0),
      transactionid = TransactionhistoryId.get.unsafeGetNullable(rs, i + 1),
      productid = ProductId.get.unsafeGetNullable(rs, i + 2),
      referenceorderid = Meta.IntMeta.get.unsafeGetNullable(rs, i + 3),
      referenceorderlineid = Meta.IntMeta.get.unsafeGetNullable(rs, i + 4),
      transactiondate = TypoLocalDateTime.get.unsafeGetNullable(rs, i + 5),
      transactiontype = Meta.StringMeta.get.unsafeGetNullable(rs, i + 6),
      quantity = Meta.IntMeta.get.unsafeGetNullable(rs, i + 7),
      actualcost = Meta.ScalaBigDecimalMeta.get.unsafeGetNullable(rs, i + 8),
      modifieddate = TypoLocalDateTime.get.unsafeGetNullable(rs, i + 9)
    )
  )
}
