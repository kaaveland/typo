/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_type

import adventureworks.customtypes.TypoAclItem
import adventureworks.customtypes.TypoPgNodeTree
import adventureworks.customtypes.TypoRegproc
import adventureworks.customtypes.TypoShort
import java.sql.ResultSet
import zio.jdbc.JdbcDecoder
import zio.json.JsonDecoder
import zio.json.JsonEncoder
import zio.json.ast.Json
import zio.json.internal.Write

case class PgTypeRow(
  oid: PgTypeId,
  typname: String,
  typnamespace: /* oid */ Long,
  typowner: /* oid */ Long,
  typlen: TypoShort,
  typbyval: Boolean,
  typtype: String,
  typcategory: String,
  typispreferred: Boolean,
  typisdefined: Boolean,
  typdelim: String,
  typrelid: /* oid */ Long,
  typsubscript: TypoRegproc,
  typelem: /* oid */ Long,
  typarray: /* oid */ Long,
  typinput: TypoRegproc,
  typoutput: TypoRegproc,
  typreceive: TypoRegproc,
  typsend: TypoRegproc,
  typmodin: TypoRegproc,
  typmodout: TypoRegproc,
  typanalyze: TypoRegproc,
  typalign: String,
  typstorage: String,
  typnotnull: Boolean,
  typbasetype: /* oid */ Long,
  typtypmod: Int,
  typndims: Int,
  typcollation: /* oid */ Long,
  typdefaultbin: Option[TypoPgNodeTree],
  typdefault: Option[String],
  typacl: Option[Array[TypoAclItem]]
)

object PgTypeRow {
  implicit lazy val jdbcDecoder: JdbcDecoder[PgTypeRow] = new JdbcDecoder[PgTypeRow] {
    override def unsafeDecode(columIndex: Int, rs: ResultSet): (Int, PgTypeRow) =
      columIndex + 31 ->
        PgTypeRow(
          oid = PgTypeId.jdbcDecoder.unsafeDecode(columIndex + 0, rs)._2,
          typname = JdbcDecoder.stringDecoder.unsafeDecode(columIndex + 1, rs)._2,
          typnamespace = JdbcDecoder.longDecoder.unsafeDecode(columIndex + 2, rs)._2,
          typowner = JdbcDecoder.longDecoder.unsafeDecode(columIndex + 3, rs)._2,
          typlen = TypoShort.jdbcDecoder.unsafeDecode(columIndex + 4, rs)._2,
          typbyval = JdbcDecoder.booleanDecoder.unsafeDecode(columIndex + 5, rs)._2,
          typtype = JdbcDecoder.stringDecoder.unsafeDecode(columIndex + 6, rs)._2,
          typcategory = JdbcDecoder.stringDecoder.unsafeDecode(columIndex + 7, rs)._2,
          typispreferred = JdbcDecoder.booleanDecoder.unsafeDecode(columIndex + 8, rs)._2,
          typisdefined = JdbcDecoder.booleanDecoder.unsafeDecode(columIndex + 9, rs)._2,
          typdelim = JdbcDecoder.stringDecoder.unsafeDecode(columIndex + 10, rs)._2,
          typrelid = JdbcDecoder.longDecoder.unsafeDecode(columIndex + 11, rs)._2,
          typsubscript = TypoRegproc.jdbcDecoder.unsafeDecode(columIndex + 12, rs)._2,
          typelem = JdbcDecoder.longDecoder.unsafeDecode(columIndex + 13, rs)._2,
          typarray = JdbcDecoder.longDecoder.unsafeDecode(columIndex + 14, rs)._2,
          typinput = TypoRegproc.jdbcDecoder.unsafeDecode(columIndex + 15, rs)._2,
          typoutput = TypoRegproc.jdbcDecoder.unsafeDecode(columIndex + 16, rs)._2,
          typreceive = TypoRegproc.jdbcDecoder.unsafeDecode(columIndex + 17, rs)._2,
          typsend = TypoRegproc.jdbcDecoder.unsafeDecode(columIndex + 18, rs)._2,
          typmodin = TypoRegproc.jdbcDecoder.unsafeDecode(columIndex + 19, rs)._2,
          typmodout = TypoRegproc.jdbcDecoder.unsafeDecode(columIndex + 20, rs)._2,
          typanalyze = TypoRegproc.jdbcDecoder.unsafeDecode(columIndex + 21, rs)._2,
          typalign = JdbcDecoder.stringDecoder.unsafeDecode(columIndex + 22, rs)._2,
          typstorage = JdbcDecoder.stringDecoder.unsafeDecode(columIndex + 23, rs)._2,
          typnotnull = JdbcDecoder.booleanDecoder.unsafeDecode(columIndex + 24, rs)._2,
          typbasetype = JdbcDecoder.longDecoder.unsafeDecode(columIndex + 25, rs)._2,
          typtypmod = JdbcDecoder.intDecoder.unsafeDecode(columIndex + 26, rs)._2,
          typndims = JdbcDecoder.intDecoder.unsafeDecode(columIndex + 27, rs)._2,
          typcollation = JdbcDecoder.longDecoder.unsafeDecode(columIndex + 28, rs)._2,
          typdefaultbin = JdbcDecoder.optionDecoder(TypoPgNodeTree.jdbcDecoder).unsafeDecode(columIndex + 29, rs)._2,
          typdefault = JdbcDecoder.optionDecoder(JdbcDecoder.stringDecoder).unsafeDecode(columIndex + 30, rs)._2,
          typacl = JdbcDecoder.optionDecoder(JdbcDecoder[Array[TypoAclItem]]).unsafeDecode(columIndex + 31, rs)._2
        )
  }
  implicit lazy val jsonDecoder: JsonDecoder[PgTypeRow] = JsonDecoder[Json.Obj].mapOrFail { jsonObj =>
    val oid = jsonObj.get("oid").toRight("Missing field 'oid'").flatMap(_.as(PgTypeId.jsonDecoder))
    val typname = jsonObj.get("typname").toRight("Missing field 'typname'").flatMap(_.as(JsonDecoder.string))
    val typnamespace = jsonObj.get("typnamespace").toRight("Missing field 'typnamespace'").flatMap(_.as(JsonDecoder.long))
    val typowner = jsonObj.get("typowner").toRight("Missing field 'typowner'").flatMap(_.as(JsonDecoder.long))
    val typlen = jsonObj.get("typlen").toRight("Missing field 'typlen'").flatMap(_.as(TypoShort.jsonDecoder))
    val typbyval = jsonObj.get("typbyval").toRight("Missing field 'typbyval'").flatMap(_.as(JsonDecoder.boolean))
    val typtype = jsonObj.get("typtype").toRight("Missing field 'typtype'").flatMap(_.as(JsonDecoder.string))
    val typcategory = jsonObj.get("typcategory").toRight("Missing field 'typcategory'").flatMap(_.as(JsonDecoder.string))
    val typispreferred = jsonObj.get("typispreferred").toRight("Missing field 'typispreferred'").flatMap(_.as(JsonDecoder.boolean))
    val typisdefined = jsonObj.get("typisdefined").toRight("Missing field 'typisdefined'").flatMap(_.as(JsonDecoder.boolean))
    val typdelim = jsonObj.get("typdelim").toRight("Missing field 'typdelim'").flatMap(_.as(JsonDecoder.string))
    val typrelid = jsonObj.get("typrelid").toRight("Missing field 'typrelid'").flatMap(_.as(JsonDecoder.long))
    val typsubscript = jsonObj.get("typsubscript").toRight("Missing field 'typsubscript'").flatMap(_.as(TypoRegproc.jsonDecoder))
    val typelem = jsonObj.get("typelem").toRight("Missing field 'typelem'").flatMap(_.as(JsonDecoder.long))
    val typarray = jsonObj.get("typarray").toRight("Missing field 'typarray'").flatMap(_.as(JsonDecoder.long))
    val typinput = jsonObj.get("typinput").toRight("Missing field 'typinput'").flatMap(_.as(TypoRegproc.jsonDecoder))
    val typoutput = jsonObj.get("typoutput").toRight("Missing field 'typoutput'").flatMap(_.as(TypoRegproc.jsonDecoder))
    val typreceive = jsonObj.get("typreceive").toRight("Missing field 'typreceive'").flatMap(_.as(TypoRegproc.jsonDecoder))
    val typsend = jsonObj.get("typsend").toRight("Missing field 'typsend'").flatMap(_.as(TypoRegproc.jsonDecoder))
    val typmodin = jsonObj.get("typmodin").toRight("Missing field 'typmodin'").flatMap(_.as(TypoRegproc.jsonDecoder))
    val typmodout = jsonObj.get("typmodout").toRight("Missing field 'typmodout'").flatMap(_.as(TypoRegproc.jsonDecoder))
    val typanalyze = jsonObj.get("typanalyze").toRight("Missing field 'typanalyze'").flatMap(_.as(TypoRegproc.jsonDecoder))
    val typalign = jsonObj.get("typalign").toRight("Missing field 'typalign'").flatMap(_.as(JsonDecoder.string))
    val typstorage = jsonObj.get("typstorage").toRight("Missing field 'typstorage'").flatMap(_.as(JsonDecoder.string))
    val typnotnull = jsonObj.get("typnotnull").toRight("Missing field 'typnotnull'").flatMap(_.as(JsonDecoder.boolean))
    val typbasetype = jsonObj.get("typbasetype").toRight("Missing field 'typbasetype'").flatMap(_.as(JsonDecoder.long))
    val typtypmod = jsonObj.get("typtypmod").toRight("Missing field 'typtypmod'").flatMap(_.as(JsonDecoder.int))
    val typndims = jsonObj.get("typndims").toRight("Missing field 'typndims'").flatMap(_.as(JsonDecoder.int))
    val typcollation = jsonObj.get("typcollation").toRight("Missing field 'typcollation'").flatMap(_.as(JsonDecoder.long))
    val typdefaultbin = jsonObj.get("typdefaultbin").fold[Either[String, Option[TypoPgNodeTree]]](Right(None))(_.as(JsonDecoder.option(TypoPgNodeTree.jsonDecoder)))
    val typdefault = jsonObj.get("typdefault").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.string)))
    val typacl = jsonObj.get("typacl").fold[Either[String, Option[Array[TypoAclItem]]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.array[TypoAclItem](TypoAclItem.jsonDecoder, implicitly))))
    if (oid.isRight && typname.isRight && typnamespace.isRight && typowner.isRight && typlen.isRight && typbyval.isRight && typtype.isRight && typcategory.isRight && typispreferred.isRight && typisdefined.isRight && typdelim.isRight && typrelid.isRight && typsubscript.isRight && typelem.isRight && typarray.isRight && typinput.isRight && typoutput.isRight && typreceive.isRight && typsend.isRight && typmodin.isRight && typmodout.isRight && typanalyze.isRight && typalign.isRight && typstorage.isRight && typnotnull.isRight && typbasetype.isRight && typtypmod.isRight && typndims.isRight && typcollation.isRight && typdefaultbin.isRight && typdefault.isRight && typacl.isRight)
      Right(PgTypeRow(oid = oid.toOption.get, typname = typname.toOption.get, typnamespace = typnamespace.toOption.get, typowner = typowner.toOption.get, typlen = typlen.toOption.get, typbyval = typbyval.toOption.get, typtype = typtype.toOption.get, typcategory = typcategory.toOption.get, typispreferred = typispreferred.toOption.get, typisdefined = typisdefined.toOption.get, typdelim = typdelim.toOption.get, typrelid = typrelid.toOption.get, typsubscript = typsubscript.toOption.get, typelem = typelem.toOption.get, typarray = typarray.toOption.get, typinput = typinput.toOption.get, typoutput = typoutput.toOption.get, typreceive = typreceive.toOption.get, typsend = typsend.toOption.get, typmodin = typmodin.toOption.get, typmodout = typmodout.toOption.get, typanalyze = typanalyze.toOption.get, typalign = typalign.toOption.get, typstorage = typstorage.toOption.get, typnotnull = typnotnull.toOption.get, typbasetype = typbasetype.toOption.get, typtypmod = typtypmod.toOption.get, typndims = typndims.toOption.get, typcollation = typcollation.toOption.get, typdefaultbin = typdefaultbin.toOption.get, typdefault = typdefault.toOption.get, typacl = typacl.toOption.get))
    else Left(List[Either[String, Any]](oid, typname, typnamespace, typowner, typlen, typbyval, typtype, typcategory, typispreferred, typisdefined, typdelim, typrelid, typsubscript, typelem, typarray, typinput, typoutput, typreceive, typsend, typmodin, typmodout, typanalyze, typalign, typstorage, typnotnull, typbasetype, typtypmod, typndims, typcollation, typdefaultbin, typdefault, typacl).flatMap(_.left.toOption).mkString(", "))
  }
  implicit lazy val jsonEncoder: JsonEncoder[PgTypeRow] = new JsonEncoder[PgTypeRow] {
    override def unsafeEncode(a: PgTypeRow, indent: Option[Int], out: Write): Unit = {
      out.write("{")
      out.write(""""oid":""")
      PgTypeId.jsonEncoder.unsafeEncode(a.oid, indent, out)
      out.write(",")
      out.write(""""typname":""")
      JsonEncoder.string.unsafeEncode(a.typname, indent, out)
      out.write(",")
      out.write(""""typnamespace":""")
      JsonEncoder.long.unsafeEncode(a.typnamespace, indent, out)
      out.write(",")
      out.write(""""typowner":""")
      JsonEncoder.long.unsafeEncode(a.typowner, indent, out)
      out.write(",")
      out.write(""""typlen":""")
      TypoShort.jsonEncoder.unsafeEncode(a.typlen, indent, out)
      out.write(",")
      out.write(""""typbyval":""")
      JsonEncoder.boolean.unsafeEncode(a.typbyval, indent, out)
      out.write(",")
      out.write(""""typtype":""")
      JsonEncoder.string.unsafeEncode(a.typtype, indent, out)
      out.write(",")
      out.write(""""typcategory":""")
      JsonEncoder.string.unsafeEncode(a.typcategory, indent, out)
      out.write(",")
      out.write(""""typispreferred":""")
      JsonEncoder.boolean.unsafeEncode(a.typispreferred, indent, out)
      out.write(",")
      out.write(""""typisdefined":""")
      JsonEncoder.boolean.unsafeEncode(a.typisdefined, indent, out)
      out.write(",")
      out.write(""""typdelim":""")
      JsonEncoder.string.unsafeEncode(a.typdelim, indent, out)
      out.write(",")
      out.write(""""typrelid":""")
      JsonEncoder.long.unsafeEncode(a.typrelid, indent, out)
      out.write(",")
      out.write(""""typsubscript":""")
      TypoRegproc.jsonEncoder.unsafeEncode(a.typsubscript, indent, out)
      out.write(",")
      out.write(""""typelem":""")
      JsonEncoder.long.unsafeEncode(a.typelem, indent, out)
      out.write(",")
      out.write(""""typarray":""")
      JsonEncoder.long.unsafeEncode(a.typarray, indent, out)
      out.write(",")
      out.write(""""typinput":""")
      TypoRegproc.jsonEncoder.unsafeEncode(a.typinput, indent, out)
      out.write(",")
      out.write(""""typoutput":""")
      TypoRegproc.jsonEncoder.unsafeEncode(a.typoutput, indent, out)
      out.write(",")
      out.write(""""typreceive":""")
      TypoRegproc.jsonEncoder.unsafeEncode(a.typreceive, indent, out)
      out.write(",")
      out.write(""""typsend":""")
      TypoRegproc.jsonEncoder.unsafeEncode(a.typsend, indent, out)
      out.write(",")
      out.write(""""typmodin":""")
      TypoRegproc.jsonEncoder.unsafeEncode(a.typmodin, indent, out)
      out.write(",")
      out.write(""""typmodout":""")
      TypoRegproc.jsonEncoder.unsafeEncode(a.typmodout, indent, out)
      out.write(",")
      out.write(""""typanalyze":""")
      TypoRegproc.jsonEncoder.unsafeEncode(a.typanalyze, indent, out)
      out.write(",")
      out.write(""""typalign":""")
      JsonEncoder.string.unsafeEncode(a.typalign, indent, out)
      out.write(",")
      out.write(""""typstorage":""")
      JsonEncoder.string.unsafeEncode(a.typstorage, indent, out)
      out.write(",")
      out.write(""""typnotnull":""")
      JsonEncoder.boolean.unsafeEncode(a.typnotnull, indent, out)
      out.write(",")
      out.write(""""typbasetype":""")
      JsonEncoder.long.unsafeEncode(a.typbasetype, indent, out)
      out.write(",")
      out.write(""""typtypmod":""")
      JsonEncoder.int.unsafeEncode(a.typtypmod, indent, out)
      out.write(",")
      out.write(""""typndims":""")
      JsonEncoder.int.unsafeEncode(a.typndims, indent, out)
      out.write(",")
      out.write(""""typcollation":""")
      JsonEncoder.long.unsafeEncode(a.typcollation, indent, out)
      out.write(",")
      out.write(""""typdefaultbin":""")
      JsonEncoder.option(TypoPgNodeTree.jsonEncoder).unsafeEncode(a.typdefaultbin, indent, out)
      out.write(",")
      out.write(""""typdefault":""")
      JsonEncoder.option(JsonEncoder.string).unsafeEncode(a.typdefault, indent, out)
      out.write(",")
      out.write(""""typacl":""")
      JsonEncoder.option(JsonEncoder.array[TypoAclItem](TypoAclItem.jsonEncoder, implicitly)).unsafeEncode(a.typacl, indent, out)
      out.write("}")
    }
  }
}
