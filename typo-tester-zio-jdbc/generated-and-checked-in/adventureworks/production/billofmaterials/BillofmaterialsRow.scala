/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package billofmaterials

import adventureworks.Text
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoShort
import adventureworks.production.product.ProductId
import adventureworks.production.unitmeasure.UnitmeasureId
import java.sql.ResultSet
import zio.jdbc.JdbcDecoder
import zio.json.JsonDecoder
import zio.json.JsonEncoder
import zio.json.ast.Json
import zio.json.internal.Write

/** Table: production.billofmaterials
    Items required to make bicycles and bicycle subassemblies. It identifies the heirarchical relationship between a parent product and its components.
    Primary key: billofmaterialsid */
case class BillofmaterialsRow(
  /** Primary key for BillOfMaterials records.
      Default: nextval('production.billofmaterials_billofmaterialsid_seq'::regclass) */
  billofmaterialsid: Int,
  /** Parent product identification number. Foreign key to Product.ProductID.
      Points to [[product.ProductRow.productid]]
      Constraint CK_BillOfMaterials_BOMLevel affecting columns bomlevel, perassemblyqty, productassemblyid: ((((productassemblyid IS NULL) AND (bomlevel = 0) AND (perassemblyqty = 1.00)) OR ((productassemblyid IS NOT NULL) AND (bomlevel >= 1))))
      Constraint CK_BillOfMaterials_ProductAssemblyID affecting columns componentid, productassemblyid: ((productassemblyid <> componentid)) */
  productassemblyid: Option[ProductId],
  /** Component identification number. Foreign key to Product.ProductID.
      Points to [[product.ProductRow.productid]]
      Constraint CK_BillOfMaterials_ProductAssemblyID affecting columns componentid, productassemblyid: ((productassemblyid <> componentid)) */
  componentid: ProductId,
  /** Date the component started being used in the assembly item.
      Default: now()
      Constraint CK_BillOfMaterials_EndDate affecting columns enddate, startdate: (((enddate > startdate) OR (enddate IS NULL))) */
  startdate: TypoLocalDateTime,
  /** Date the component stopped being used in the assembly item.
      Constraint CK_BillOfMaterials_EndDate affecting columns enddate, startdate: (((enddate > startdate) OR (enddate IS NULL))) */
  enddate: Option[TypoLocalDateTime],
  /** Standard code identifying the unit of measure for the quantity.
      Points to [[unitmeasure.UnitmeasureRow.unitmeasurecode]] */
  unitmeasurecode: UnitmeasureId,
  /** Indicates the depth the component is from its parent (AssemblyID).
      Constraint CK_BillOfMaterials_BOMLevel affecting columns bomlevel, perassemblyqty, productassemblyid: ((((productassemblyid IS NULL) AND (bomlevel = 0) AND (perassemblyqty = 1.00)) OR ((productassemblyid IS NOT NULL) AND (bomlevel >= 1)))) */
  bomlevel: TypoShort,
  /** Quantity of the component needed to create the assembly.
      Default: 1.00
      Constraint CK_BillOfMaterials_BOMLevel affecting columns bomlevel, perassemblyqty, productassemblyid: ((((productassemblyid IS NULL) AND (bomlevel = 0) AND (perassemblyqty = 1.00)) OR ((productassemblyid IS NOT NULL) AND (bomlevel >= 1))))
      Constraint CK_BillOfMaterials_PerAssemblyQty affecting columns perassemblyqty: ((perassemblyqty >= 1.00)) */
  perassemblyqty: BigDecimal,
  /** Default: now() */
  modifieddate: TypoLocalDateTime
)

object BillofmaterialsRow {
  implicit lazy val jdbcDecoder: JdbcDecoder[BillofmaterialsRow] = new JdbcDecoder[BillofmaterialsRow] {
    override def unsafeDecode(columIndex: Int, rs: ResultSet): (Int, BillofmaterialsRow) =
      columIndex + 8 ->
        BillofmaterialsRow(
          billofmaterialsid = JdbcDecoder.intDecoder.unsafeDecode(columIndex + 0, rs)._2,
          productassemblyid = JdbcDecoder.optionDecoder(ProductId.jdbcDecoder).unsafeDecode(columIndex + 1, rs)._2,
          componentid = ProductId.jdbcDecoder.unsafeDecode(columIndex + 2, rs)._2,
          startdate = TypoLocalDateTime.jdbcDecoder.unsafeDecode(columIndex + 3, rs)._2,
          enddate = JdbcDecoder.optionDecoder(TypoLocalDateTime.jdbcDecoder).unsafeDecode(columIndex + 4, rs)._2,
          unitmeasurecode = UnitmeasureId.jdbcDecoder.unsafeDecode(columIndex + 5, rs)._2,
          bomlevel = TypoShort.jdbcDecoder.unsafeDecode(columIndex + 6, rs)._2,
          perassemblyqty = JdbcDecoder.bigDecimalDecoderScala.unsafeDecode(columIndex + 7, rs)._2,
          modifieddate = TypoLocalDateTime.jdbcDecoder.unsafeDecode(columIndex + 8, rs)._2
        )
  }
  implicit lazy val jsonDecoder: JsonDecoder[BillofmaterialsRow] = JsonDecoder[Json.Obj].mapOrFail { jsonObj =>
    val billofmaterialsid = jsonObj.get("billofmaterialsid").toRight("Missing field 'billofmaterialsid'").flatMap(_.as(JsonDecoder.int))
    val productassemblyid = jsonObj.get("productassemblyid").fold[Either[String, Option[ProductId]]](Right(None))(_.as(JsonDecoder.option(using ProductId.jsonDecoder)))
    val componentid = jsonObj.get("componentid").toRight("Missing field 'componentid'").flatMap(_.as(ProductId.jsonDecoder))
    val startdate = jsonObj.get("startdate").toRight("Missing field 'startdate'").flatMap(_.as(TypoLocalDateTime.jsonDecoder))
    val enddate = jsonObj.get("enddate").fold[Either[String, Option[TypoLocalDateTime]]](Right(None))(_.as(JsonDecoder.option(using TypoLocalDateTime.jsonDecoder)))
    val unitmeasurecode = jsonObj.get("unitmeasurecode").toRight("Missing field 'unitmeasurecode'").flatMap(_.as(UnitmeasureId.jsonDecoder))
    val bomlevel = jsonObj.get("bomlevel").toRight("Missing field 'bomlevel'").flatMap(_.as(TypoShort.jsonDecoder))
    val perassemblyqty = jsonObj.get("perassemblyqty").toRight("Missing field 'perassemblyqty'").flatMap(_.as(JsonDecoder.scalaBigDecimal))
    val modifieddate = jsonObj.get("modifieddate").toRight("Missing field 'modifieddate'").flatMap(_.as(TypoLocalDateTime.jsonDecoder))
    if (billofmaterialsid.isRight && productassemblyid.isRight && componentid.isRight && startdate.isRight && enddate.isRight && unitmeasurecode.isRight && bomlevel.isRight && perassemblyqty.isRight && modifieddate.isRight)
      Right(BillofmaterialsRow(billofmaterialsid = billofmaterialsid.toOption.get, productassemblyid = productassemblyid.toOption.get, componentid = componentid.toOption.get, startdate = startdate.toOption.get, enddate = enddate.toOption.get, unitmeasurecode = unitmeasurecode.toOption.get, bomlevel = bomlevel.toOption.get, perassemblyqty = perassemblyqty.toOption.get, modifieddate = modifieddate.toOption.get))
    else Left(List[Either[String, Any]](billofmaterialsid, productassemblyid, componentid, startdate, enddate, unitmeasurecode, bomlevel, perassemblyqty, modifieddate).flatMap(_.left.toOption).mkString(", "))
  }
  implicit lazy val jsonEncoder: JsonEncoder[BillofmaterialsRow] = new JsonEncoder[BillofmaterialsRow] {
    override def unsafeEncode(a: BillofmaterialsRow, indent: Option[Int], out: Write): Unit = {
      out.write("{")
      out.write(""""billofmaterialsid":""")
      JsonEncoder.int.unsafeEncode(a.billofmaterialsid, indent, out)
      out.write(",")
      out.write(""""productassemblyid":""")
      JsonEncoder.option(using ProductId.jsonEncoder).unsafeEncode(a.productassemblyid, indent, out)
      out.write(",")
      out.write(""""componentid":""")
      ProductId.jsonEncoder.unsafeEncode(a.componentid, indent, out)
      out.write(",")
      out.write(""""startdate":""")
      TypoLocalDateTime.jsonEncoder.unsafeEncode(a.startdate, indent, out)
      out.write(",")
      out.write(""""enddate":""")
      JsonEncoder.option(using TypoLocalDateTime.jsonEncoder).unsafeEncode(a.enddate, indent, out)
      out.write(",")
      out.write(""""unitmeasurecode":""")
      UnitmeasureId.jsonEncoder.unsafeEncode(a.unitmeasurecode, indent, out)
      out.write(",")
      out.write(""""bomlevel":""")
      TypoShort.jsonEncoder.unsafeEncode(a.bomlevel, indent, out)
      out.write(",")
      out.write(""""perassemblyqty":""")
      JsonEncoder.scalaBigDecimal.unsafeEncode(a.perassemblyqty, indent, out)
      out.write(",")
      out.write(""""modifieddate":""")
      TypoLocalDateTime.jsonEncoder.unsafeEncode(a.modifieddate, indent, out)
      out.write("}")
    }
  }
  implicit lazy val text: Text[BillofmaterialsRow] = Text.instance[BillofmaterialsRow]{ (row, sb) =>
    Text.intInstance.unsafeEncode(row.billofmaterialsid, sb)
    sb.append(Text.DELIMETER)
    Text.option(ProductId.text).unsafeEncode(row.productassemblyid, sb)
    sb.append(Text.DELIMETER)
    ProductId.text.unsafeEncode(row.componentid, sb)
    sb.append(Text.DELIMETER)
    TypoLocalDateTime.text.unsafeEncode(row.startdate, sb)
    sb.append(Text.DELIMETER)
    Text.option(TypoLocalDateTime.text).unsafeEncode(row.enddate, sb)
    sb.append(Text.DELIMETER)
    UnitmeasureId.text.unsafeEncode(row.unitmeasurecode, sb)
    sb.append(Text.DELIMETER)
    TypoShort.text.unsafeEncode(row.bomlevel, sb)
    sb.append(Text.DELIMETER)
    Text.bigDecimalInstance.unsafeEncode(row.perassemblyqty, sb)
    sb.append(Text.DELIMETER)
    TypoLocalDateTime.text.unsafeEncode(row.modifieddate, sb)
  }
}
