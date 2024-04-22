/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package transactionhistoryarchive

import adventureworks.Text
import adventureworks.customtypes.TypoLocalDateTime
import java.sql.ResultSet
import zio.jdbc.JdbcDecoder
import zio.json.JsonDecoder
import zio.json.JsonEncoder
import zio.json.ast.Json
import zio.json.internal.Write

/** Table: production.transactionhistoryarchive
    Transactions for previous years.
    Primary key: transactionid */
case class TransactionhistoryarchiveRow(
  /** Primary key for TransactionHistoryArchive records. */
  transactionid: TransactionhistoryarchiveId,
  /** Product identification number. Foreign key to Product.ProductID. */
  productid: Int,
  /** Purchase order, sales order, or work order identification number. */
  referenceorderid: Int,
  /** Line number associated with the purchase order, sales order, or work order.
      Default: 0 */
  referenceorderlineid: Int,
  /** Date and time of the transaction.
      Default: now() */
  transactiondate: TypoLocalDateTime,
  /** W = Work Order, S = Sales Order, P = Purchase Order
      Constraint CK_TransactionHistoryArchive_TransactionType affecting columns transactiontype: ((upper((transactiontype)::text) = ANY (ARRAY['W'::text, 'S'::text, 'P'::text]))) */
  transactiontype: /* bpchar, max 1 chars */ String,
  /** Product quantity. */
  quantity: Int,
  /** Product cost. */
  actualcost: BigDecimal,
  /** Default: now() */
  modifieddate: TypoLocalDateTime
)

object TransactionhistoryarchiveRow {
  implicit lazy val jdbcDecoder: JdbcDecoder[TransactionhistoryarchiveRow] = new JdbcDecoder[TransactionhistoryarchiveRow] {
    override def unsafeDecode(columIndex: Int, rs: ResultSet): (Int, TransactionhistoryarchiveRow) =
      columIndex + 8 ->
        TransactionhistoryarchiveRow(
          transactionid = TransactionhistoryarchiveId.jdbcDecoder.unsafeDecode(columIndex + 0, rs)._2,
          productid = JdbcDecoder.intDecoder.unsafeDecode(columIndex + 1, rs)._2,
          referenceorderid = JdbcDecoder.intDecoder.unsafeDecode(columIndex + 2, rs)._2,
          referenceorderlineid = JdbcDecoder.intDecoder.unsafeDecode(columIndex + 3, rs)._2,
          transactiondate = TypoLocalDateTime.jdbcDecoder.unsafeDecode(columIndex + 4, rs)._2,
          transactiontype = JdbcDecoder.stringDecoder.unsafeDecode(columIndex + 5, rs)._2,
          quantity = JdbcDecoder.intDecoder.unsafeDecode(columIndex + 6, rs)._2,
          actualcost = JdbcDecoder.bigDecimalDecoderScala.unsafeDecode(columIndex + 7, rs)._2,
          modifieddate = TypoLocalDateTime.jdbcDecoder.unsafeDecode(columIndex + 8, rs)._2
        )
  }
  implicit lazy val jsonDecoder: JsonDecoder[TransactionhistoryarchiveRow] = JsonDecoder[Json.Obj].mapOrFail { jsonObj =>
    val transactionid = jsonObj.get("transactionid").toRight("Missing field 'transactionid'").flatMap(_.as(TransactionhistoryarchiveId.jsonDecoder))
    val productid = jsonObj.get("productid").toRight("Missing field 'productid'").flatMap(_.as(JsonDecoder.int))
    val referenceorderid = jsonObj.get("referenceorderid").toRight("Missing field 'referenceorderid'").flatMap(_.as(JsonDecoder.int))
    val referenceorderlineid = jsonObj.get("referenceorderlineid").toRight("Missing field 'referenceorderlineid'").flatMap(_.as(JsonDecoder.int))
    val transactiondate = jsonObj.get("transactiondate").toRight("Missing field 'transactiondate'").flatMap(_.as(TypoLocalDateTime.jsonDecoder))
    val transactiontype = jsonObj.get("transactiontype").toRight("Missing field 'transactiontype'").flatMap(_.as(JsonDecoder.string))
    val quantity = jsonObj.get("quantity").toRight("Missing field 'quantity'").flatMap(_.as(JsonDecoder.int))
    val actualcost = jsonObj.get("actualcost").toRight("Missing field 'actualcost'").flatMap(_.as(JsonDecoder.scalaBigDecimal))
    val modifieddate = jsonObj.get("modifieddate").toRight("Missing field 'modifieddate'").flatMap(_.as(TypoLocalDateTime.jsonDecoder))
    if (transactionid.isRight && productid.isRight && referenceorderid.isRight && referenceorderlineid.isRight && transactiondate.isRight && transactiontype.isRight && quantity.isRight && actualcost.isRight && modifieddate.isRight)
      Right(TransactionhistoryarchiveRow(transactionid = transactionid.toOption.get, productid = productid.toOption.get, referenceorderid = referenceorderid.toOption.get, referenceorderlineid = referenceorderlineid.toOption.get, transactiondate = transactiondate.toOption.get, transactiontype = transactiontype.toOption.get, quantity = quantity.toOption.get, actualcost = actualcost.toOption.get, modifieddate = modifieddate.toOption.get))
    else Left(List[Either[String, Any]](transactionid, productid, referenceorderid, referenceorderlineid, transactiondate, transactiontype, quantity, actualcost, modifieddate).flatMap(_.left.toOption).mkString(", "))
  }
  implicit lazy val jsonEncoder: JsonEncoder[TransactionhistoryarchiveRow] = new JsonEncoder[TransactionhistoryarchiveRow] {
    override def unsafeEncode(a: TransactionhistoryarchiveRow, indent: Option[Int], out: Write): Unit = {
      out.write("{")
      out.write(""""transactionid":""")
      TransactionhistoryarchiveId.jsonEncoder.unsafeEncode(a.transactionid, indent, out)
      out.write(",")
      out.write(""""productid":""")
      JsonEncoder.int.unsafeEncode(a.productid, indent, out)
      out.write(",")
      out.write(""""referenceorderid":""")
      JsonEncoder.int.unsafeEncode(a.referenceorderid, indent, out)
      out.write(",")
      out.write(""""referenceorderlineid":""")
      JsonEncoder.int.unsafeEncode(a.referenceorderlineid, indent, out)
      out.write(",")
      out.write(""""transactiondate":""")
      TypoLocalDateTime.jsonEncoder.unsafeEncode(a.transactiondate, indent, out)
      out.write(",")
      out.write(""""transactiontype":""")
      JsonEncoder.string.unsafeEncode(a.transactiontype, indent, out)
      out.write(",")
      out.write(""""quantity":""")
      JsonEncoder.int.unsafeEncode(a.quantity, indent, out)
      out.write(",")
      out.write(""""actualcost":""")
      JsonEncoder.scalaBigDecimal.unsafeEncode(a.actualcost, indent, out)
      out.write(",")
      out.write(""""modifieddate":""")
      TypoLocalDateTime.jsonEncoder.unsafeEncode(a.modifieddate, indent, out)
      out.write("}")
    }
  }
  implicit lazy val text: Text[TransactionhistoryarchiveRow] = Text.instance[TransactionhistoryarchiveRow]{ (row, sb) =>
    TransactionhistoryarchiveId.text.unsafeEncode(row.transactionid, sb)
    sb.append(Text.DELIMETER)
    Text.intInstance.unsafeEncode(row.productid, sb)
    sb.append(Text.DELIMETER)
    Text.intInstance.unsafeEncode(row.referenceorderid, sb)
    sb.append(Text.DELIMETER)
    Text.intInstance.unsafeEncode(row.referenceorderlineid, sb)
    sb.append(Text.DELIMETER)
    TypoLocalDateTime.text.unsafeEncode(row.transactiondate, sb)
    sb.append(Text.DELIMETER)
    Text.stringInstance.unsafeEncode(row.transactiontype, sb)
    sb.append(Text.DELIMETER)
    Text.intInstance.unsafeEncode(row.quantity, sb)
    sb.append(Text.DELIMETER)
    Text.bigDecimalInstance.unsafeEncode(row.actualcost, sb)
    sb.append(Text.DELIMETER)
    TypoLocalDateTime.text.unsafeEncode(row.modifieddate, sb)
  }
}
