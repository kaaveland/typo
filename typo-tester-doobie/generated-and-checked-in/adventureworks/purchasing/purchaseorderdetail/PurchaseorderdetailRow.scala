/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package purchasing
package purchaseorderdetail

import adventureworks.TypoLocalDateTime
import adventureworks.production.product.ProductId
import adventureworks.purchasing.purchaseorderheader.PurchaseorderheaderId
import doobie.enumerated.Nullability
import doobie.util.Read
import doobie.util.meta.Meta
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet

case class PurchaseorderdetailRow(
  /** Primary key. Foreign key to PurchaseOrderHeader.PurchaseOrderID.
      Points to [[purchaseorderheader.PurchaseorderheaderRow.purchaseorderid]] */
  purchaseorderid: PurchaseorderheaderId,
  /** Primary key. One line number per purchased product. */
  purchaseorderdetailid: Int,
  /** Date the product is expected to be received. */
  duedate: TypoLocalDateTime,
  /** Quantity ordered. */
  orderqty: Int,
  /** Product identification number. Foreign key to Product.ProductID.
      Points to [[production.product.ProductRow.productid]] */
  productid: ProductId,
  /** Vendor's selling price of a single product. */
  unitprice: BigDecimal,
  /** Quantity actually received from the vendor. */
  receivedqty: BigDecimal,
  /** Quantity rejected during inspection. */
  rejectedqty: BigDecimal,
  modifieddate: TypoLocalDateTime
){
   val compositeId: PurchaseorderdetailId = PurchaseorderdetailId(purchaseorderid, purchaseorderdetailid)
 }

object PurchaseorderdetailRow {
  implicit lazy val decoder: Decoder[PurchaseorderdetailRow] = Decoder.forProduct9[PurchaseorderdetailRow, PurchaseorderheaderId, Int, TypoLocalDateTime, Int, ProductId, BigDecimal, BigDecimal, BigDecimal, TypoLocalDateTime]("purchaseorderid", "purchaseorderdetailid", "duedate", "orderqty", "productid", "unitprice", "receivedqty", "rejectedqty", "modifieddate")(PurchaseorderdetailRow.apply)(PurchaseorderheaderId.decoder, Decoder.decodeInt, TypoLocalDateTime.decoder, Decoder.decodeInt, ProductId.decoder, Decoder.decodeBigDecimal, Decoder.decodeBigDecimal, Decoder.decodeBigDecimal, TypoLocalDateTime.decoder)
  implicit lazy val encoder: Encoder[PurchaseorderdetailRow] = Encoder.forProduct9[PurchaseorderdetailRow, PurchaseorderheaderId, Int, TypoLocalDateTime, Int, ProductId, BigDecimal, BigDecimal, BigDecimal, TypoLocalDateTime]("purchaseorderid", "purchaseorderdetailid", "duedate", "orderqty", "productid", "unitprice", "receivedqty", "rejectedqty", "modifieddate")(x => (x.purchaseorderid, x.purchaseorderdetailid, x.duedate, x.orderqty, x.productid, x.unitprice, x.receivedqty, x.rejectedqty, x.modifieddate))(PurchaseorderheaderId.encoder, Encoder.encodeInt, TypoLocalDateTime.encoder, Encoder.encodeInt, ProductId.encoder, Encoder.encodeBigDecimal, Encoder.encodeBigDecimal, Encoder.encodeBigDecimal, TypoLocalDateTime.encoder)
  implicit lazy val read: Read[PurchaseorderdetailRow] = new Read[PurchaseorderdetailRow](
    gets = List(
      (PurchaseorderheaderId.get, Nullability.NoNulls),
      (Meta.IntMeta.get, Nullability.NoNulls),
      (TypoLocalDateTime.get, Nullability.NoNulls),
      (Meta.IntMeta.get, Nullability.NoNulls),
      (ProductId.get, Nullability.NoNulls),
      (Meta.ScalaBigDecimalMeta.get, Nullability.NoNulls),
      (Meta.ScalaBigDecimalMeta.get, Nullability.NoNulls),
      (Meta.ScalaBigDecimalMeta.get, Nullability.NoNulls),
      (TypoLocalDateTime.get, Nullability.NoNulls)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => PurchaseorderdetailRow(
      purchaseorderid = PurchaseorderheaderId.get.unsafeGetNonNullable(rs, i + 0),
      purchaseorderdetailid = Meta.IntMeta.get.unsafeGetNonNullable(rs, i + 1),
      duedate = TypoLocalDateTime.get.unsafeGetNonNullable(rs, i + 2),
      orderqty = Meta.IntMeta.get.unsafeGetNonNullable(rs, i + 3),
      productid = ProductId.get.unsafeGetNonNullable(rs, i + 4),
      unitprice = Meta.ScalaBigDecimalMeta.get.unsafeGetNonNullable(rs, i + 5),
      receivedqty = Meta.ScalaBigDecimalMeta.get.unsafeGetNonNullable(rs, i + 6),
      rejectedqty = Meta.ScalaBigDecimalMeta.get.unsafeGetNonNullable(rs, i + 7),
      modifieddate = TypoLocalDateTime.get.unsafeGetNonNullable(rs, i + 8)
    )
  )
}