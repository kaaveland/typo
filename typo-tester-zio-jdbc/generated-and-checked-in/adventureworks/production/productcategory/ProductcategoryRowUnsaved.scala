/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package productcategory

import adventureworks.customtypes.Defaulted
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoUUID
import adventureworks.public.Name
import zio.json.JsonDecoder
import zio.json.JsonEncoder
import zio.json.ast.Json
import zio.json.internal.Write

/** This class corresponds to a row in table `production.productcategory` which has not been persisted yet */
case class ProductcategoryRowUnsaved(
  /** Category description. */
  name: Name,
  /** Default: nextval('production.productcategory_productcategoryid_seq'::regclass)
      Primary key for ProductCategory records. */
  productcategoryid: Defaulted[ProductcategoryId] = Defaulted.UseDefault,
  /** Default: uuid_generate_v1() */
  rowguid: Defaulted[TypoUUID] = Defaulted.UseDefault,
  /** Default: now() */
  modifieddate: Defaulted[TypoLocalDateTime] = Defaulted.UseDefault
) {
  def toRow(productcategoryidDefault: => ProductcategoryId, rowguidDefault: => TypoUUID, modifieddateDefault: => TypoLocalDateTime): ProductcategoryRow =
    ProductcategoryRow(
      name = name,
      productcategoryid = productcategoryid match {
                            case Defaulted.UseDefault => productcategoryidDefault
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
object ProductcategoryRowUnsaved {
  implicit lazy val jsonDecoder: JsonDecoder[ProductcategoryRowUnsaved] = JsonDecoder[Json.Obj].mapOrFail { jsonObj =>
    val name = jsonObj.get("name").toRight("Missing field 'name'").flatMap(_.as(Name.jsonDecoder))
    val productcategoryid = jsonObj.get("productcategoryid").toRight("Missing field 'productcategoryid'").flatMap(_.as(Defaulted.jsonDecoder(ProductcategoryId.jsonDecoder)))
    val rowguid = jsonObj.get("rowguid").toRight("Missing field 'rowguid'").flatMap(_.as(Defaulted.jsonDecoder(TypoUUID.jsonDecoder)))
    val modifieddate = jsonObj.get("modifieddate").toRight("Missing field 'modifieddate'").flatMap(_.as(Defaulted.jsonDecoder(TypoLocalDateTime.jsonDecoder)))
    if (name.isRight && productcategoryid.isRight && rowguid.isRight && modifieddate.isRight)
      Right(ProductcategoryRowUnsaved(name = name.toOption.get, productcategoryid = productcategoryid.toOption.get, rowguid = rowguid.toOption.get, modifieddate = modifieddate.toOption.get))
    else Left(List[Either[String, Any]](name, productcategoryid, rowguid, modifieddate).flatMap(_.left.toOption).mkString(", "))
  }
  implicit lazy val jsonEncoder: JsonEncoder[ProductcategoryRowUnsaved] = new JsonEncoder[ProductcategoryRowUnsaved] {
    override def unsafeEncode(a: ProductcategoryRowUnsaved, indent: Option[Int], out: Write): Unit = {
      out.write("{")
      out.write(""""name":""")
      Name.jsonEncoder.unsafeEncode(a.name, indent, out)
      out.write(",")
      out.write(""""productcategoryid":""")
      Defaulted.jsonEncoder(ProductcategoryId.jsonEncoder).unsafeEncode(a.productcategoryid, indent, out)
      out.write(",")
      out.write(""""rowguid":""")
      Defaulted.jsonEncoder(TypoUUID.jsonEncoder).unsafeEncode(a.rowguid, indent, out)
      out.write(",")
      out.write(""""modifieddate":""")
      Defaulted.jsonEncoder(TypoLocalDateTime.jsonEncoder).unsafeEncode(a.modifieddate, indent, out)
      out.write("}")
    }
  }
}
