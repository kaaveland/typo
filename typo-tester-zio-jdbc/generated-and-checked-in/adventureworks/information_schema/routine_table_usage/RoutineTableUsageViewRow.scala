/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package routine_table_usage

import java.sql.ResultSet
import zio.jdbc.JdbcDecoder
import zio.json.JsonDecoder
import zio.json.JsonEncoder
import zio.json.ast.Json
import zio.json.internal.Write

case class RoutineTableUsageViewRow(
  specificCatalog: /* nullability unknown */ Option[String],
  specificSchema: /* nullability unknown */ Option[String],
  specificName: /* nullability unknown */ Option[String],
  routineCatalog: /* nullability unknown */ Option[String],
  routineSchema: /* nullability unknown */ Option[String],
  routineName: /* nullability unknown */ Option[String],
  tableCatalog: /* nullability unknown */ Option[String],
  tableSchema: /* nullability unknown */ Option[String],
  tableName: /* nullability unknown */ Option[String]
)

object RoutineTableUsageViewRow {
  implicit lazy val jdbcDecoder: JdbcDecoder[RoutineTableUsageViewRow] = new JdbcDecoder[RoutineTableUsageViewRow] {
    override def unsafeDecode(columIndex: Int, rs: ResultSet): (Int, RoutineTableUsageViewRow) =
      columIndex + 8 ->
        RoutineTableUsageViewRow(
          specificCatalog = JdbcDecoder.optionDecoder(JdbcDecoder.stringDecoder).unsafeDecode(columIndex + 0, rs)._2,
          specificSchema = JdbcDecoder.optionDecoder(JdbcDecoder.stringDecoder).unsafeDecode(columIndex + 1, rs)._2,
          specificName = JdbcDecoder.optionDecoder(JdbcDecoder.stringDecoder).unsafeDecode(columIndex + 2, rs)._2,
          routineCatalog = JdbcDecoder.optionDecoder(JdbcDecoder.stringDecoder).unsafeDecode(columIndex + 3, rs)._2,
          routineSchema = JdbcDecoder.optionDecoder(JdbcDecoder.stringDecoder).unsafeDecode(columIndex + 4, rs)._2,
          routineName = JdbcDecoder.optionDecoder(JdbcDecoder.stringDecoder).unsafeDecode(columIndex + 5, rs)._2,
          tableCatalog = JdbcDecoder.optionDecoder(JdbcDecoder.stringDecoder).unsafeDecode(columIndex + 6, rs)._2,
          tableSchema = JdbcDecoder.optionDecoder(JdbcDecoder.stringDecoder).unsafeDecode(columIndex + 7, rs)._2,
          tableName = JdbcDecoder.optionDecoder(JdbcDecoder.stringDecoder).unsafeDecode(columIndex + 8, rs)._2
        )
  }
  implicit lazy val jsonDecoder: JsonDecoder[RoutineTableUsageViewRow] = JsonDecoder[Json.Obj].mapOrFail { jsonObj =>
    val specificCatalog = jsonObj.get("specific_catalog").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.string)))
    val specificSchema = jsonObj.get("specific_schema").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.string)))
    val specificName = jsonObj.get("specific_name").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.string)))
    val routineCatalog = jsonObj.get("routine_catalog").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.string)))
    val routineSchema = jsonObj.get("routine_schema").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.string)))
    val routineName = jsonObj.get("routine_name").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.string)))
    val tableCatalog = jsonObj.get("table_catalog").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.string)))
    val tableSchema = jsonObj.get("table_schema").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.string)))
    val tableName = jsonObj.get("table_name").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(JsonDecoder.string)))
    if (specificCatalog.isRight && specificSchema.isRight && specificName.isRight && routineCatalog.isRight && routineSchema.isRight && routineName.isRight && tableCatalog.isRight && tableSchema.isRight && tableName.isRight)
      Right(RoutineTableUsageViewRow(specificCatalog = specificCatalog.toOption.get, specificSchema = specificSchema.toOption.get, specificName = specificName.toOption.get, routineCatalog = routineCatalog.toOption.get, routineSchema = routineSchema.toOption.get, routineName = routineName.toOption.get, tableCatalog = tableCatalog.toOption.get, tableSchema = tableSchema.toOption.get, tableName = tableName.toOption.get))
    else Left(List[Either[String, Any]](specificCatalog, specificSchema, specificName, routineCatalog, routineSchema, routineName, tableCatalog, tableSchema, tableName).flatMap(_.left.toOption).mkString(", "))
  }
  implicit lazy val jsonEncoder: JsonEncoder[RoutineTableUsageViewRow] = new JsonEncoder[RoutineTableUsageViewRow] {
    override def unsafeEncode(a: RoutineTableUsageViewRow, indent: Option[Int], out: Write): Unit = {
      out.write("{")
      out.write(""""specific_catalog":""")
      JsonEncoder.option(JsonEncoder.string).unsafeEncode(a.specificCatalog, indent, out)
      out.write(",")
      out.write(""""specific_schema":""")
      JsonEncoder.option(JsonEncoder.string).unsafeEncode(a.specificSchema, indent, out)
      out.write(",")
      out.write(""""specific_name":""")
      JsonEncoder.option(JsonEncoder.string).unsafeEncode(a.specificName, indent, out)
      out.write(",")
      out.write(""""routine_catalog":""")
      JsonEncoder.option(JsonEncoder.string).unsafeEncode(a.routineCatalog, indent, out)
      out.write(",")
      out.write(""""routine_schema":""")
      JsonEncoder.option(JsonEncoder.string).unsafeEncode(a.routineSchema, indent, out)
      out.write(",")
      out.write(""""routine_name":""")
      JsonEncoder.option(JsonEncoder.string).unsafeEncode(a.routineName, indent, out)
      out.write(",")
      out.write(""""table_catalog":""")
      JsonEncoder.option(JsonEncoder.string).unsafeEncode(a.tableCatalog, indent, out)
      out.write(",")
      out.write(""""table_schema":""")
      JsonEncoder.option(JsonEncoder.string).unsafeEncode(a.tableSchema, indent, out)
      out.write(",")
      out.write(""""table_name":""")
      JsonEncoder.option(JsonEncoder.string).unsafeEncode(a.tableName, indent, out)
      out.write("}")
    }
  }
}
