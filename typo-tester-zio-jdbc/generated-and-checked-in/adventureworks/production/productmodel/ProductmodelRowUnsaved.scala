/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package productmodel

import adventureworks.Text
import adventureworks.customtypes.Defaulted
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoUUID
import adventureworks.customtypes.TypoXml
import adventureworks.public.Name
import zio.json.JsonDecoder
import zio.json.JsonEncoder
import zio.json.ast.Json
import zio.json.internal.Write

/** This class corresponds to a row in table `production.productmodel` which has not been persisted yet */
case class ProductmodelRowUnsaved(
  /** Product model description. */
  name: Name,
  /** Detailed product catalog information in xml format. */
  catalogdescription: Option[TypoXml],
  /** Manufacturing instructions in xml format. */
  instructions: Option[TypoXml],
  /** Default: nextval('production.productmodel_productmodelid_seq'::regclass)
      Primary key for ProductModel records. */
  productmodelid: Defaulted[ProductmodelId] = Defaulted.UseDefault,
  /** Default: uuid_generate_v1() */
  rowguid: Defaulted[TypoUUID] = Defaulted.UseDefault,
  /** Default: now() */
  modifieddate: Defaulted[TypoLocalDateTime] = Defaulted.UseDefault
) {
  def toRow(productmodelidDefault: => ProductmodelId, rowguidDefault: => TypoUUID, modifieddateDefault: => TypoLocalDateTime): ProductmodelRow =
    ProductmodelRow(
      name = name,
      catalogdescription = catalogdescription,
      instructions = instructions,
      productmodelid = productmodelid match {
                         case Defaulted.UseDefault => productmodelidDefault
                         case Defaulted.Provided(value) => value
                       },
      rowguid = rowguid match {
                  case Defaulted.UseDefault => rowguidDefault
                  case Defaulted.Provided(value) => value
                },
      modifieddate = modifieddate match {
                       case Defaulted.UseDefault => modifieddateDefault
                       case Defaulted.Provided(value) => value
                     }
    )
}
object ProductmodelRowUnsaved {
  implicit lazy val jsonDecoder: JsonDecoder[ProductmodelRowUnsaved] = JsonDecoder[Json.Obj].mapOrFail { jsonObj =>
    val name = jsonObj.get("name").toRight("Missing field 'name'").flatMap(_.as(Name.jsonDecoder))
    val catalogdescription = jsonObj.get("catalogdescription").fold[Either[String, Option[TypoXml]]](Right(None))(_.as(JsonDecoder.option(using TypoXml.jsonDecoder)))
    val instructions = jsonObj.get("instructions").fold[Either[String, Option[TypoXml]]](Right(None))(_.as(JsonDecoder.option(using TypoXml.jsonDecoder)))
    val productmodelid = jsonObj.get("productmodelid").toRight("Missing field 'productmodelid'").flatMap(_.as(Defaulted.jsonDecoder(ProductmodelId.jsonDecoder)))
    val rowguid = jsonObj.get("rowguid").toRight("Missing field 'rowguid'").flatMap(_.as(Defaulted.jsonDecoder(TypoUUID.jsonDecoder)))
    val modifieddate = jsonObj.get("modifieddate").toRight("Missing field 'modifieddate'").flatMap(_.as(Defaulted.jsonDecoder(TypoLocalDateTime.jsonDecoder)))
    if (name.isRight && catalogdescription.isRight && instructions.isRight && productmodelid.isRight && rowguid.isRight && modifieddate.isRight)
      Right(ProductmodelRowUnsaved(name = name.toOption.get, catalogdescription = catalogdescription.toOption.get, instructions = instructions.toOption.get, productmodelid = productmodelid.toOption.get, rowguid = rowguid.toOption.get, modifieddate = modifieddate.toOption.get))
    else Left(List[Either[String, Any]](name, catalogdescription, instructions, productmodelid, rowguid, modifieddate).flatMap(_.left.toOption).mkString(", "))
  }
  implicit lazy val jsonEncoder: JsonEncoder[ProductmodelRowUnsaved] = new JsonEncoder[ProductmodelRowUnsaved] {
    override def unsafeEncode(a: ProductmodelRowUnsaved, indent: Option[Int], out: Write): Unit = {
      out.write("{")
      out.write(""""name":""")
      Name.jsonEncoder.unsafeEncode(a.name, indent, out)
      out.write(",")
      out.write(""""catalogdescription":""")
      JsonEncoder.option(using TypoXml.jsonEncoder).unsafeEncode(a.catalogdescription, indent, out)
      out.write(",")
      out.write(""""instructions":""")
      JsonEncoder.option(using TypoXml.jsonEncoder).unsafeEncode(a.instructions, indent, out)
      out.write(",")
      out.write(""""productmodelid":""")
      Defaulted.jsonEncoder(ProductmodelId.jsonEncoder).unsafeEncode(a.productmodelid, indent, out)
      out.write(",")
      out.write(""""rowguid":""")
      Defaulted.jsonEncoder(TypoUUID.jsonEncoder).unsafeEncode(a.rowguid, indent, out)
      out.write(",")
      out.write(""""modifieddate":""")
      Defaulted.jsonEncoder(TypoLocalDateTime.jsonEncoder).unsafeEncode(a.modifieddate, indent, out)
      out.write("}")
    }
  }
  implicit lazy val text: Text[ProductmodelRowUnsaved] = Text.instance[ProductmodelRowUnsaved]{ (row, sb) =>
    Name.text.unsafeEncode(row.name, sb)
    sb.append(Text.DELIMETER)
    Text.option(TypoXml.text).unsafeEncode(row.catalogdescription, sb)
    sb.append(Text.DELIMETER)
    Text.option(TypoXml.text).unsafeEncode(row.instructions, sb)
    sb.append(Text.DELIMETER)
    Defaulted.text(ProductmodelId.text).unsafeEncode(row.productmodelid, sb)
    sb.append(Text.DELIMETER)
    Defaulted.text(TypoUUID.text).unsafeEncode(row.rowguid, sb)
    sb.append(Text.DELIMETER)
    Defaulted.text(TypoLocalDateTime.text).unsafeEncode(row.modifieddate, sb)
  }
}
