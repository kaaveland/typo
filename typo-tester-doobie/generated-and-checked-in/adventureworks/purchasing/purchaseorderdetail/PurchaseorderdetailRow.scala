/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package purchasing
package purchaseorderdetail

import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoShort
import adventureworks.production.product.ProductId
import adventureworks.purchasing.purchaseorderheader.PurchaseorderheaderId
import doobie.enumerated.Nullability
import doobie.postgres.Text
import doobie.util.Read
import doobie.util.meta.Meta
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet

/** Table: purchasing.purchaseorderdetail
    Individual products associated with a specific purchase order. See PurchaseOrderHeader.
    Composite primary key: purchaseorderid, purchaseorderdetailid */
case class PurchaseorderdetailRow(
  /** Primary key. Foreign key to PurchaseOrderHeader.PurchaseOrderID.
      Points to [[purchaseorderheader.PurchaseorderheaderRow.purchaseorderid]] */
  purchaseorderid: PurchaseorderheaderId,
  /** Primary key. One line number per purchased product.
      Default: nextval('purchasing.purchaseorderdetail_purchaseorderdetailid_seq'::regclass) */
  purchaseorderdetailid: Int,
  /** Date the product is expected to be received. */
  duedate: TypoLocalDateTime,
  /** Quantity ordered.
      Constraint CK_PurchaseOrderDetail_OrderQty affecting columns orderqty: ((orderqty > 0)) */
  orderqty: TypoShort,
  /** Product identification number. Foreign key to Product.ProductID.
      Points to [[production.product.ProductRow.productid]] */
  productid: ProductId,
  /** Vendor's selling price of a single product.
      Constraint CK_PurchaseOrderDetail_UnitPrice affecting columns unitprice: ((unitprice >= 0.00)) */
  unitprice: BigDecimal,
  /** Quantity actually received from the vendor.
      Constraint CK_PurchaseOrderDetail_ReceivedQty affecting columns receivedqty: ((receivedqty >= 0.00)) */
  receivedqty: BigDecimal,
  /** Quantity rejected during inspection.
      Constraint CK_PurchaseOrderDetail_RejectedQty affecting columns rejectedqty: ((rejectedqty >= 0.00)) */
  rejectedqty: BigDecimal,
  /** Default: now() */
  modifieddate: TypoLocalDateTime
){
   val compositeId: PurchaseorderdetailId = PurchaseorderdetailId(purchaseorderid, purchaseorderdetailid)
 }

object PurchaseorderdetailRow {
  def apply(compositeId: PurchaseorderdetailId, duedate: TypoLocalDateTime, orderqty: TypoShort, productid: ProductId, unitprice: BigDecimal, receivedqty: BigDecimal, rejectedqty: BigDecimal, modifieddate: TypoLocalDateTime) =
    new PurchaseorderdetailRow(compositeId.purchaseorderid, compositeId.purchaseorderdetailid, duedate, orderqty, productid, unitprice, receivedqty, rejectedqty, modifieddate)
  implicit lazy val decoder: Decoder[PurchaseorderdetailRow] = Decoder.forProduct9[PurchaseorderdetailRow, PurchaseorderheaderId, Int, TypoLocalDateTime, TypoShort, ProductId, BigDecimal, BigDecimal, BigDecimal, TypoLocalDateTime]("purchaseorderid", "purchaseorderdetailid", "duedate", "orderqty", "productid", "unitprice", "receivedqty", "rejectedqty", "modifieddate")(PurchaseorderdetailRow.apply)(PurchaseorderheaderId.decoder, Decoder.decodeInt, TypoLocalDateTime.decoder, TypoShort.decoder, ProductId.decoder, Decoder.decodeBigDecimal, Decoder.decodeBigDecimal, Decoder.decodeBigDecimal, TypoLocalDateTime.decoder)
  implicit lazy val encoder: Encoder[PurchaseorderdetailRow] = Encoder.forProduct9[PurchaseorderdetailRow, PurchaseorderheaderId, Int, TypoLocalDateTime, TypoShort, ProductId, BigDecimal, BigDecimal, BigDecimal, TypoLocalDateTime]("purchaseorderid", "purchaseorderdetailid", "duedate", "orderqty", "productid", "unitprice", "receivedqty", "rejectedqty", "modifieddate")(x => (x.purchaseorderid, x.purchaseorderdetailid, x.duedate, x.orderqty, x.productid, x.unitprice, x.receivedqty, x.rejectedqty, x.modifieddate))(PurchaseorderheaderId.encoder, Encoder.encodeInt, TypoLocalDateTime.encoder, TypoShort.encoder, ProductId.encoder, Encoder.encodeBigDecimal, Encoder.encodeBigDecimal, Encoder.encodeBigDecimal, TypoLocalDateTime.encoder)
  implicit lazy val read: Read[PurchaseorderdetailRow] = new Read[PurchaseorderdetailRow](
    gets = List(
      (PurchaseorderheaderId.get, Nullability.NoNulls),
      (Meta.IntMeta.get, Nullability.NoNulls),
      (TypoLocalDateTime.get, Nullability.NoNulls),
      (TypoShort.get, Nullability.NoNulls),
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
      orderqty = TypoShort.get.unsafeGetNonNullable(rs, i + 3),
      productid = ProductId.get.unsafeGetNonNullable(rs, i + 4),
      unitprice = Meta.ScalaBigDecimalMeta.get.unsafeGetNonNullable(rs, i + 5),
      receivedqty = Meta.ScalaBigDecimalMeta.get.unsafeGetNonNullable(rs, i + 6),
      rejectedqty = Meta.ScalaBigDecimalMeta.get.unsafeGetNonNullable(rs, i + 7),
      modifieddate = TypoLocalDateTime.get.unsafeGetNonNullable(rs, i + 8)
    )
  )
  implicit lazy val text: Text[PurchaseorderdetailRow] = Text.instance[PurchaseorderdetailRow]{ (row, sb) =>
    PurchaseorderheaderId.text.unsafeEncode(row.purchaseorderid, sb)
    sb.append(Text.DELIMETER)
    Text.intInstance.unsafeEncode(row.purchaseorderdetailid, sb)
    sb.append(Text.DELIMETER)
    TypoLocalDateTime.text.unsafeEncode(row.duedate, sb)
    sb.append(Text.DELIMETER)
    TypoShort.text.unsafeEncode(row.orderqty, sb)
    sb.append(Text.DELIMETER)
    ProductId.text.unsafeEncode(row.productid, sb)
    sb.append(Text.DELIMETER)
    Text.bigDecimalInstance.unsafeEncode(row.unitprice, sb)
    sb.append(Text.DELIMETER)
    Text.bigDecimalInstance.unsafeEncode(row.receivedqty, sb)
    sb.append(Text.DELIMETER)
    Text.bigDecimalInstance.unsafeEncode(row.rejectedqty, sb)
    sb.append(Text.DELIMETER)
    TypoLocalDateTime.text.unsafeEncode(row.modifieddate, sb)
  }
}
